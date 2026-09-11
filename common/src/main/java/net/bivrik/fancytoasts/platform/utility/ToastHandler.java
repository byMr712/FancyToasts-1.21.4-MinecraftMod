package net.bivrik.fancytoasts.platform.utility;

import net.bivrik.fancytoasts.client.config.data.ToastConfigData;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.bivrik.fancytoasts.client.config.data.ToastsFilteringData;
import net.bivrik.fancytoasts.client.toast.IAdvancementAccessor;
import net.bivrik.fancytoasts.core.Debug;
import net.bivrik.fancytoasts.core.manager.FancyToastManager;
import net.bivrik.fancytoasts.platform.Services;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.client.gui.components.toasts.AdvancementToast;
import net.minecraft.client.gui.components.toasts.Toast;

public record ToastHandler(ToastsFilteringData filteringData, ToastConfigData toastData, FancyToastManager fancyToastManager) {
    public void handleAdvancementToast(AdvancementToast advancementToast, CallbackInfo info) {
        if (!filteringData.isFancyAdvancementToastsEnabled()) {
            Debug.info("Fancy advancement toasts are disabled, letting vanilla toast display");
            return;
        }

        AdvancementHolder advancementHolder = ((IAdvancementAccessor) advancementToast).getAdvancementHolder();
        if (advancementHolder == null) {
            Debug.warn("AdvancementToast has null AdvancementHolder");
            return;
        }
        DisplayInfo vanillaDisplay = advancementHolder.value().display().orElse(null);
        if (vanillaDisplay == null) {
            Debug.info("Advancement {} has no display info, skipping fancy toast", advancementHolder.id());
            return;
        }

        FancyAdvancementType type;
        switch (vanillaDisplay.getType()) {
            case GOAL -> type = FancyAdvancementType.GOAL;
            case CHALLENGE -> type = FancyAdvancementType.CHALLENGE;
            default -> type = FancyAdvancementType.TASK;
        }

        if (filteringData.isTypeIgnored(type)) {
            Debug.info("Advancement type {} is ignored in filtering, letting vanilla toast display", type);
            return;
        }
        if (filteringData.isToastIgnored(advancementHolder.id())) {
            Debug.info("Advancement {} is ignored in filtering, letting vanilla toast display", advancementHolder.id());
            return;
        }

        info.cancel();
        Debug.info("Intercepted AdvancementToast: '{}' ({})", vanillaDisplay.getTitle().getString(), advancementHolder.id());

        ResourceLocation soundId = toastData.getSoundIdByType(type);
        if (Services.AETHER_HELPER.isLoaded()) {
            ResourceLocation aetherSoundOverrideId = Services.AETHER_HELPER.getOverrideId(advancementHolder);
            if (aetherSoundOverrideId != null) {
                soundId = aetherSoundOverrideId;
            }
        }

        AdvancementDisplay display = new AdvancementDisplay(
                vanillaDisplay.getIcon(),
                vanillaDisplay.getTitle(), vanillaDisplay.getDescription(), vanillaDisplay.getType().getDisplayName(),
                type.getTitleColor(), type.getDescriptionColor(),
                type.getConventionalType());

        fancyToastManager.add(display, soundId);
    }

    public void handleFTBQuestsToast(Toast questToast, CallbackInfo info) {
        if (!filteringData.isFancyQuestToastsEnabled()) {
            return;
        }
        info.cancel();

        QuestDisplay display = (QuestDisplay) Services.FTB_QUESTS.getDisplayInfo(questToast);
        if (display == null) {
            return;
        }

        QuestType type = display.getQuestType();
        if (filteringData.isQuestTypeIgnored(type)) {
            return;
        }

        fancyToastManager.add(display, toastData.getSoundIdByQuestType(type));
    }

    public void handleQuestlogToast(Toast questlogToast, CallbackInfo info) {
        if (!filteringData.isFancyQuestlogToastsEnabled()) {
            return;
        }
        info.cancel();

        AdvancementDisplay display = Services.QUESTLOG_HELPER.getDisplay(questlogToast);
        if (display == null) {
            return;
        }

        FancyAdvancementType type;
        switch (display.getType()) {
            case GOAL -> type = FancyAdvancementType.GOAL;
            case CHALLENGE -> type = FancyAdvancementType.CHALLENGE;
            default -> type = FancyAdvancementType.TASK;
        }

        fancyToastManager.add(display, toastData.getSoundIdByType(type));
    }
}

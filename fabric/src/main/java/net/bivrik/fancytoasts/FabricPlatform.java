package net.bivrik.fancytoasts;

import net.fabricmc.api.ClientModInitializer;

public class FabricPlatform implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        FancyToasts.getInstance().onModInit();
    }
}

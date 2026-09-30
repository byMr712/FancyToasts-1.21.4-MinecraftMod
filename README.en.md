> **Language:** [Русский](README.md) · English

# Fancy Toasts (Minecraft 1.21.4 Fabric Port)

![Java 21](https://img.shields.io/badge/Java-21-blue.svg)
![Minecraft](https://img.shields.io/badge/Minecraft-1.21.4-blue.svg)
![Fabric](https://img.shields.io/badge/Loader-Fabric-blue.svg)
![ModMenu](https://img.shields.io/badge/ModMenu-Supported-blue.svg)
![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)

Port and update of the **Fancy Toasts** mod for **Minecraft 1.21.4 (Fabric)** by **byMr712**.

Original Developer: [Bivrik/FancyToasts](https://github.com/Bivrik/FancyToasts).

---

## About

**Fancy Toasts** replaces standard, repetitive advancement toast notifications with fresh, beautiful, and customizable animations and visual themes, enhancing your game's atmosphere.

---

## Animation Gallery

| Standard Animation | Quirky Animation |
|:---:|:---:|
| ![Standard Animation](https://raw.githubusercontent.com/Bivrik/FancyToasts/refs/heads/master/.github/assets/standard_animtion.webp) | ![Quirky Animation](https://raw.githubusercontent.com/Bivrik/FancyToasts/refs/heads/master/.github/assets/quirky_animation.webp) |

---

## Features

### Visual Styles & Themes

Offers a rich collection of 8 textures and 4 animations (providing 32 unique visual combinations):

- **Textures**:
  - `Vanilla-Like` (Minecraft style)
  - `Nature`
  - `OG` (Classic)
  - `Modern`
  - `Terracraft` (inspired by Terraria)
  - `Steamy` (inspired by Steam)
  - `Landspaper`
  - `Neon`
- **Animations**:
  - `Standard`
  - `Playful`
  - `Quirky`
  - `Old-Like`

### Custom Textures

Supports loading user-created custom textures via data-driven datapacks and resource packs.

### Flexible Configuration

- Mod compatibility settings.
- Sound effect volume and pitch adjustments.
- Screen behavior when menus (inventory, chests) are open.
- Screen anchor and relative X/Y offsets.
- Custom title and description visibility.
- Loop and animation speed controls.
- Advancement toast filtering by ResourceLocation.

---

## Changes in 1.21.4 Port (byMr712)

- Full adaptation and finalized build for **Minecraft 1.21.4** (Fabric Loader, Parchment mappings, Java 21 LTS).
- Updated GUI rendering, texture sprites, and ModMenu/Jade integration.
- Configured fast build scripts and auto-copy to the launcher instance folder.

---

## Installation

1. Download the latest release from [GitHub Releases](https://github.com/byMr712/FancyToasts-1.21.4-MinecraftMod/releases).
2. Requires:
   - [Fabric Loader](https://fabricmc.net/) (Minecraft 1.21.4)
   - [Fabric API](https://modrinth.com/mod/fabric-api)
   - [Mod Menu](https://modrinth.com/mod/modmenu) (recommended)
3. Place the `.jar` file into your `mods` folder.
4. Launch the game.

---

## Building

1. Requires Java 21 and Fabric Loader for Minecraft 1.21.4.
2. To build the project, run:
   ```bash
   ./gradlew :fabric:build
   ```
3. The built jar file will be located at `build/libs/FancyToasts-1.21.4-byMr712.jar`.

---

## Credits & License

- Original Author: [Bivrik](https://github.com/Bivrik) ([FancyToasts](https://github.com/Bivrik/FancyToasts)).
- Ported and adapted for 1.21.4 by: [Mr712](https://github.com/byMr712).
- Distributed under the [Apache License 2.0](LICENSE).

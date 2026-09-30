> **Language:** Русский · [English](README.en.md)

# Fancy Toasts (Minecraft 1.21.4 Fabric Port)

![Java 21](https://img.shields.io/badge/Java-21-blue.svg)
![Minecraft](https://img.shields.io/badge/Minecraft-1.21.4-blue.svg)
![Fabric](https://img.shields.io/badge/Loader-Fabric-blue.svg)
![ModMenu](https://img.shields.io/badge/ModMenu-Supported-blue.svg)
![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)

Порт и обновление мода **Fancy Toasts** для **Minecraft 1.21.4 (Fabric)** от **byMr712**.

Оригинальный разработчик: [Bivrik/FancyToasts](https://github.com/Bivrik/FancyToasts).

---

## О моде

**Fancy Toasts** заменяет стандартные и однообразные всплывающие уведомления о достижениях (toasts) новыми, красивыми и полностью настраиваемыми анимациями и стилями, создавая неповторимую атмосферу.

---

## Галерея анимаций

| Стандартная анимация | Неординарная анимация |
|:---:|:---:|
| ![Стандартная анимация](/images/standard_animtion.webp) | ![Неординарная анимация](/images/quirky_animation.webp) |

---

## Возможности

### Визуальные стили и темы

Мод предлагает широкий выбор текстур и анимаций (8 текстур и 4 анимации, дающих 32 уникальные комбинации оформления):

- **Текстуры**:
  - `Vanilla-Like` (Ванильный стиль Minecraft)
  - `Nature` (Природа)
  - `OG` (Классика)
  - `Modern` (Модерн)
  - `Terracraft` (в стиле Terraria)
  - `Steamy` (в стиле Steam)
  - `Landspaper` (Бумажный стиль)
  - `Neon` (Неон)
- **Анимации**:
  - `Standard` (Стандартная)
  - `Playful` (Игривая)
  - `Quirky` (Неординарная)
  - `Old-Like` (Винтажная)

### Пользовательские текстуры

Поддержка добавления собственных текстур через data-driven систему датапаков и ресурспаков.

### Гибкие настройки конфигурации

- Настройки совместимости со сторонними модами.
- Регулировка громкости и высоты звуковых эффектов.
- Поведение уведомлений при открытых экранах меню (инвентарь, сундуки).
- Позиционирование на экране: выбор точки привязки (якоря) и смещения по координатам X и Y.
- Настройка отображаемой информации (заголовок, описание).
- Настройка скорости синусоидальных волн и скорости анимации.
- Фильтрация достижений по ResourceLocation.

---

## Что изменено в порте для 1.21.4 (byMr712)

- Полная адаптация и завершение сборки под **Minecraft 1.21.4** (Fabric Loader, Parchment mappings, Java 21 LTS).
- Обновление рендеринга GUI, текстурных спрайтов и интеграции с ModMenu/Jade.
- Настроена быстрая сборка и автокопирование скомпилированного мода в лаунчер.

---

## Установка

1. Скачайте последнюю версию со страницы [GitHub Releases](https://github.com/byMr712/FancyToasts-1.21.4-MinecraftMod/releases).
2. Требуются:
   - [Fabric Loader](https://fabricmc.net/) (Minecraft 1.21.4)
   - [Fabric API](https://modrinth.com/mod/fabric-api)
   - [Mod Menu](https://modrinth.com/mod/modmenu) (рекомендуется)
3. Поместите `.jar` файл в папку `mods`.
4. Запустите игру.

---

## Сборка

1. Требуется Java 21 и Fabric Loader для Minecraft 1.21.4.
2. Для сборки выполните:
   ```bash
   ./gradlew :fabric:build
   ```
3. Собранный файл находится в `build/libs/FancyToasts-1.21.4-byMr712.jar`.

---

## Авторы и лицензия

- Оригинальный автор: [Bivrik](https://github.com/Bivrik) ([FancyToasts](https://github.com/Bivrik/FancyToasts)).
- Порт и адаптация для 1.21.4: [Mr712](https://github.com/byMr712).
- Распространяется под лицензией [Apache License 2.0](LICENSE).

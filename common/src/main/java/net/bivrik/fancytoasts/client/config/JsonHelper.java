package net.bivrik.fancytoasts.client.config;

import com.google.gson.*;
import net.bivrik.fancytoasts.core.Debug;
import net.bivrik.fancytoasts.platform.utility.ResourceLocations;
import net.minecraft.resources.ResourceLocation;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.Optional;

public class JsonHelper {
    public static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(ResourceLocation.class, new ResourceLocationAdapter())
            .create();

    private static class ResourceLocationAdapter implements JsonSerializer<ResourceLocation>, JsonDeserializer<ResourceLocation> {
        @Override
        public ResourceLocation deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return ResourceLocations.parse(json.getAsString());
        }

        @Override
        public JsonElement serialize(ResourceLocation src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.toString());
        }
    }

    public static <T> Optional<T> tryToRead(File jsonFile, Class<T> classReference) {
        try (var reader = java.nio.file.Files.newBufferedReader(jsonFile.toPath(), java.nio.charset.StandardCharsets.UTF_8)) {
            T data = GSON.fromJson(reader, classReference);
            return Optional.ofNullable(data);
        } catch (Exception e) {
            Debug.error("Could not read json file {}: {}", jsonFile.getName(), e.getMessage());
            return Optional.empty();
        }
    }

    public static boolean tryToWrite(File jsonFile, Object data) {
        return tryToWrite(GSON, jsonFile, data);
    }

    public static boolean tryToWrite(Gson gson, File jsonFile, Object data) {
        try (var writer = java.nio.file.Files.newBufferedWriter(jsonFile.toPath(), java.nio.charset.StandardCharsets.UTF_8)) {
            gson.toJson(data, writer);
            return true;
        } catch (Exception e) {
            Debug.error("Could not write json file {}: {}", jsonFile.getName(), e.getMessage());
            return false;
        }
    }
}
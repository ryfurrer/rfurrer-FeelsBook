/*

Adapted from https://github.com/nklapste/lonelyTwitter/blob/9f8f86354105bc7719a90ffa2ab0325e9d369c84/app/src/main/java/ca/ualberta/cs/lonelytwitter/TweetSerializer.java
(Nathan klapstein - lonelyTwitter)
 */

package com.assign1.rfurrer.feelsbook.feeling;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

//Add-in to allow GSON/JSON Serializing of the abstract class Mood and its subclasses.
public class FeelingSerializer implements JsonSerializer<Mood>, JsonDeserializer<Mood> {

    /**
     * @param json    The Json data being deserialized
     * @param typeOfT not used
     * @param context
     * @return a deserialized object which is a subclass of {@code Mood}
     * @throws JsonParseException if json is not in the expected format of {@code typeofT}
     * @see {@code Mood}
     * @see com.google.gson.JsonDeserializer
     */
    @Override
    public Mood deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        JsonElement element = jsonObject.get("properties");

        try {
            return context.deserialize(element, Class.forName("com.assign1.rfurrer.feelsbook.feeling." + type));
        } catch (ClassNotFoundException cnfe) {
            throw new JsonParseException("Unknown element type: " + type, cnfe);
        }
    }

    /**
     *
     * @param src       the object that needs to be converted to Json.
     * @param typeOfSrc the actual type (fully genericized version) of the source object.
     * @param context
     * @return a JsonElement corresponding to the specified object.
     */
    @Override
    public JsonElement serialize(Mood src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.add("type", new JsonPrimitive(src.getClass().getSimpleName()));
        result.add("properties", context.serialize(src, src.getClass()));
        return result;
    }
}

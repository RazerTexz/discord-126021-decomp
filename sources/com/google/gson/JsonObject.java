package com.google.gson;

import b.i.d.JsonNull;
import b.i.d.JsonPrimitive;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonObject extends JsonElement {
    public final LinkedTreeMap<String, JsonElement> a = new LinkedTreeMap<>();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonObject) && ((JsonObject) obj).a.equals(this.a));
    }

    public void h(String str, JsonElement jsonElement) {
        LinkedTreeMap<String, JsonElement> linkedTreeMap = this.a;
        if (jsonElement == null) {
            jsonElement = JsonNull.a;
        }
        linkedTreeMap.put(str, jsonElement);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public void i(String str, Number number) {
        this.a.put(str, number == null ? JsonNull.a : new JsonPrimitive(number));
    }

    public Set<Map.Entry<String, JsonElement>> j() {
        return this.a.entrySet();
    }
}

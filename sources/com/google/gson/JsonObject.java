package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;
import p007b.p225i.p408d.C4906j;
import p007b.p225i.p408d.C4907k;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonObject extends JsonElement {

    /* JADX INFO: renamed from: a */
    public final LinkedTreeMap<String, JsonElement> f21481a = new LinkedTreeMap<>();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonObject) && ((JsonObject) obj).f21481a.equals(this.f21481a));
    }

    /* JADX INFO: renamed from: h */
    public void m9214h(String str, JsonElement jsonElement) {
        LinkedTreeMap<String, JsonElement> linkedTreeMap = this.f21481a;
        if (jsonElement == null) {
            jsonElement = C4906j.f13106a;
        }
        linkedTreeMap.put(str, jsonElement);
    }

    public int hashCode() {
        return this.f21481a.hashCode();
    }

    /* JADX INFO: renamed from: i */
    public void m9215i(String str, Number number) {
        this.f21481a.put(str, number == null ? C4906j.f13106a : new C4907k(number));
    }

    /* JADX INFO: renamed from: j */
    public Set<Map.Entry<String, JsonElement>> m9216j() {
        return this.f21481a.entrySet();
    }
}

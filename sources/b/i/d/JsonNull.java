package b.i.d;

import com.google.gson.JsonElement;

/* JADX INFO: renamed from: b.i.d.j, reason: use source file name */
/* JADX INFO: compiled from: JsonNull.java */
/* JADX INFO: loaded from: classes3.dex */
public final class JsonNull extends JsonElement {
    public static final JsonNull a = new JsonNull();

    @Deprecated
    public JsonNull() {
    }

    public boolean equals(Object obj) {
        return this == obj || (obj instanceof JsonNull);
    }

    public int hashCode() {
        return JsonNull.class.hashCode();
    }
}

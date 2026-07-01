package b.i.d;

import com.google.gson.JsonElement;

/* JADX INFO: compiled from: JsonNull.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends JsonElement {
    public static final j a = new j();

    @Deprecated
    public j() {
    }

    public boolean equals(Object obj) {
        return this == obj || (obj instanceof j);
    }

    public int hashCode() {
        return j.class.hashCode();
    }
}

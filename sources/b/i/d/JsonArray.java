package b.i.d;

import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: b.i.d.g, reason: use source file name */
/* JADX INFO: compiled from: JsonArray.java */
/* JADX INFO: loaded from: classes3.dex */
public final class JsonArray extends JsonElement implements Iterable<JsonElement> {
    public final List<JsonElement> j = new ArrayList();

    @Override // com.google.gson.JsonElement
    public int c() {
        if (this.j.size() == 1) {
            return this.j.get(0).c();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonArray) && ((JsonArray) obj).j.equals(this.j));
    }

    @Override // com.google.gson.JsonElement
    public String g() {
        if (this.j.size() == 1) {
            return this.j.get(0).g();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<JsonElement> iterator() {
        return this.j.iterator();
    }
}

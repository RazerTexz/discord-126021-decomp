package p007b.p225i.p408d;

import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: b.i.d.g */
/* JADX INFO: compiled from: JsonArray.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4903g extends JsonElement implements Iterable<JsonElement> {

    /* JADX INFO: renamed from: j */
    public final List<JsonElement> f13105j = new ArrayList();

    @Override // com.google.gson.JsonElement
    /* JADX INFO: renamed from: c */
    public int mo6854c() {
        if (this.f13105j.size() == 1) {
            return this.f13105j.get(0).mo6854c();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof C4903g) && ((C4903g) obj).f13105j.equals(this.f13105j));
    }

    @Override // com.google.gson.JsonElement
    /* JADX INFO: renamed from: g */
    public String mo6855g() {
        if (this.f13105j.size() == 1) {
            return this.f13105j.get(0).mo6855g();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.f13105j.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<JsonElement> iterator() {
        return this.f13105j.iterator();
    }
}

package b.i.a.f.h.l;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class f5<K> implements Map.Entry<K, Object> {
    public Map.Entry<K, d5> j;

    public f5(Map.Entry entry, g5 g5Var) {
        this.j = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.j.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.j.getValue() == null) {
            return null;
        }
        int i = d5.c;
        throw new NoSuchMethodError();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof c6)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        d5 value = this.j.getValue();
        c6 c6Var = value.a;
        value.f1448b = null;
        value.a = (c6) obj;
        return c6Var;
    }
}

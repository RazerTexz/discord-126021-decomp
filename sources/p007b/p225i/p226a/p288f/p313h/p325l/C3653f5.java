package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.Map;

/* JADX INFO: renamed from: b.i.a.f.h.l.f5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3653f5<K> implements Map.Entry<K, Object> {

    /* JADX INFO: renamed from: j */
    public Map.Entry<K, C3625d5> f9942j;

    public C3653f5(Map.Entry entry, C3667g5 c3667g5) {
        this.f9942j = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f9942j.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f9942j.getValue() == null) {
            return null;
        }
        int i = C3625d5.f9892c;
        throw new NoSuchMethodError();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof InterfaceC3612c6)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        C3625d5 value = this.f9942j.getValue();
        InterfaceC3612c6 interfaceC3612c6 = value.f9990a;
        value.f9991b = null;
        value.f9990a = (InterfaceC3612c6) obj;
        return interfaceC3612c6;
    }
}

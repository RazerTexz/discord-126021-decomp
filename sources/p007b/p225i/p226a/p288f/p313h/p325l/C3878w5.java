package p007b.p225i.p226a.p288f.p313h.p325l;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: renamed from: b.i.a.f.h.l.w5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3878w5<K, V> extends LinkedHashMap<K, V> {

    /* JADX INFO: renamed from: j */
    public static final C3878w5 f10381j;
    private boolean zza;

    static {
        C3878w5 c3878w5 = new C3878w5();
        f10381j = c3878w5;
        c3878w5.zza = false;
    }

    public C3878w5() {
        this.zza = true;
    }

    /* JADX INFO: renamed from: b */
    public static int m5347b(Object obj) {
        if (!(obj instanceof byte[])) {
            if (obj instanceof InterfaceC3903y4) {
                throw new UnsupportedOperationException();
            }
            return obj.hashCode();
        }
        byte[] bArr = (byte[]) obj;
        Charset charset = C3877w4.f10379a;
        int length = bArr.length;
        int i = length;
        for (int i2 = 0; i2 < 0 + length; i2++) {
            i = (i * 31) + bArr[i2];
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        m5350h();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        boolean z2;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this == map) {
                z2 = true;
            } else {
                if (size() == map.size()) {
                    Iterator<Map.Entry<K, V>> it = entrySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Map.Entry<K, V> next = it.next();
                            if (map.containsKey(next.getKey())) {
                                V value = next.getValue();
                                Object obj2 = map.get(next.getKey());
                                if (!(((value instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) value, (byte[]) obj2) : value.equals(obj2))) {
                                }
                            }
                        } else {
                            z2 = true;
                        }
                    }
                }
                z2 = false;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: f */
    public final void m5348f() {
        this.zza = false;
    }

    /* JADX INFO: renamed from: g */
    public final boolean m5349g() {
        return this.zza;
    }

    /* JADX INFO: renamed from: h */
    public final void m5350h() {
        if (!this.zza) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int iM5347b = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            iM5347b += m5347b(entry.getValue()) ^ m5347b(entry.getKey());
        }
        return iM5347b;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        m5350h();
        Charset charset = C3877w4.f10379a;
        Objects.requireNonNull(k);
        Objects.requireNonNull(v);
        return (V) super.put(k, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        m5350h();
        for (K k : map.keySet()) {
            Charset charset = C3877w4.f10379a;
            Objects.requireNonNull(k);
            Objects.requireNonNull(map.get(k));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        m5350h();
        return (V) super.remove(obj);
    }

    public C3878w5(Map<K, V> map) {
        super(map);
        this.zza = true;
    }
}

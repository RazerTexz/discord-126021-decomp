package p507d0.p580t;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.t.x */
/* JADX INFO: compiled from: Maps.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12166x implements Map, Serializable, InterfaceC12228a {

    /* JADX INFO: renamed from: j */
    public static final C12166x f25222j = new C12166x();
    private static final long serialVersionUID = 8246714829545688274L;

    private final Object readResolve() {
        return f25222j;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof Void) {
            return containsValue((Void) obj);
        }
        return false;
    }

    public boolean containsValue(Void r2) {
        C12238m.checkNotNullParameter(r2, "value");
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Object get(Object obj) {
        return get(obj);
    }

    @Override // java.util.Map
    public Void get(Object obj) {
        return null;
    }

    public Set<Map.Entry> getEntries() {
        return C12167y.f25223j;
    }

    public Set<Object> getKeys() {
        return C12167y.f25223j;
    }

    public int getSize() {
        return 0;
    }

    public Collection getValues() {
        return C12165w.f25221j;
    }

    @Override // java.util.Map
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Object> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return getValues();
    }
}

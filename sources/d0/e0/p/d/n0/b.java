package d0.e0.p.d.n0;

/* JADX INFO: compiled from: HashPMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b<K, V> {
    public static final b<Object, Object> a = new b<>(d.empty(), 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d<a<e<K, V>>> f3565b;
    public final int c;

    public b(d<a<e<K, V>>> dVar, int i) {
        this.f3565b = dVar;
        this.c = i;
    }

    public static <K, V> b<K, V> empty() {
        b<K, V> bVar = (b<K, V>) a;
        if (bVar == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/pcollections/HashPMap", "empty"));
        }
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V get(Object obj) {
        a aVarEmpty = this.f3565b.get(obj.hashCode());
        if (aVarEmpty == null) {
            aVarEmpty = a.empty();
        }
        while (aVarEmpty != null && aVarEmpty.size() > 0) {
            e eVar = (e) aVarEmpty.k;
            if (eVar.key.equals(obj)) {
                return eVar.value;
            }
            aVarEmpty = aVarEmpty.l;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b<K, V> plus(K k, V v) {
        a<e<K, V>> aVarMinus = this.f3565b.get(k.hashCode());
        if (aVarMinus == null) {
            aVarMinus = a.empty();
        }
        int size = aVarMinus.size();
        int i = 0;
        a aVar = aVarMinus;
        while (true) {
            if (aVar == null || aVar.size() <= 0) {
                i = -1;
                break;
            }
            if (((e) aVar.k).key.equals(k)) {
                break;
            }
            aVar = aVar.l;
            i++;
        }
        if (i != -1) {
            aVarMinus = aVarMinus.minus(i);
        }
        a<e<K, V>> aVarPlus = aVarMinus.plus(new e<>(k, v));
        return new b<>(this.f3565b.plus(k.hashCode(), aVarPlus), aVarPlus.size() + (this.c - size));
    }
}

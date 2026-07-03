package p507d0.p513e0.p514p.p515d.p577n0;

/* JADX INFO: renamed from: d0.e0.p.d.n0.b */
/* JADX INFO: compiled from: HashPMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12045b<K, V> {

    /* JADX INFO: renamed from: a */
    public static final C12045b<Object, Object> f25023a = new C12045b<>(C12047d.empty(), 0);

    /* JADX INFO: renamed from: b */
    public final C12047d<C12044a<C12048e<K, V>>> f25024b;

    /* JADX INFO: renamed from: c */
    public final int f25025c;

    public C12045b(C12047d<C12044a<C12048e<K, V>>> c12047d, int i) {
        this.f25024b = c12047d;
        this.f25025c = i;
    }

    public static <K, V> C12045b<K, V> empty() {
        C12045b<K, V> c12045b = (C12045b<K, V>) f25023a;
        if (c12045b == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/pcollections/HashPMap", "empty"));
        }
        return c12045b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V get(Object obj) {
        C12044a c12044aEmpty = this.f25024b.get(obj.hashCode());
        if (c12044aEmpty == null) {
            c12044aEmpty = C12044a.empty();
        }
        while (c12044aEmpty != null && c12044aEmpty.size() > 0) {
            C12048e c12048e = (C12048e) c12044aEmpty.f25019k;
            if (c12048e.key.equals(obj)) {
                return c12048e.value;
            }
            c12044aEmpty = c12044aEmpty.f25020l;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C12045b<K, V> plus(K k, V v) {
        C12044a<C12048e<K, V>> c12044aMinus = this.f25024b.get(k.hashCode());
        if (c12044aMinus == null) {
            c12044aMinus = C12044a.empty();
        }
        int size = c12044aMinus.size();
        int i = 0;
        C12044a c12044a = c12044aMinus;
        while (true) {
            if (c12044a == null || c12044a.size() <= 0) {
                i = -1;
                break;
            }
            if (((C12048e) c12044a.f25019k).key.equals(k)) {
                break;
            }
            c12044a = c12044a.f25020l;
            i++;
        }
        if (i != -1) {
            c12044aMinus = c12044aMinus.minus(i);
        }
        C12044a<C12048e<K, V>> c12044aPlus = c12044aMinus.plus(new C12048e<>(k, v));
        return new C12045b<>(this.f25024b.plus(k.hashCode(), c12044aPlus), c12044aPlus.size() + (this.f25025c - size));
    }
}

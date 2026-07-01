package d0.e0.p.d.n0;

/* JADX INFO: renamed from: d0.e0.p.d.n0.b, reason: use source file name */
/* JADX INFO: compiled from: HashPMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class HashPMap<K, V> {
    public static final HashPMap<Object, Object> a = new HashPMap<>(IntTreePMap.empty(), 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IntTreePMap<ConsPStack<MapEntry<K, V>>> f3565b;
    public final int c;

    public HashPMap(IntTreePMap<ConsPStack<MapEntry<K, V>>> intTreePMap, int i) {
        this.f3565b = intTreePMap;
        this.c = i;
    }

    public static <K, V> HashPMap<K, V> empty() {
        HashPMap<K, V> hashPMap = (HashPMap<K, V>) a;
        if (hashPMap == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/pcollections/HashPMap", "empty"));
        }
        return hashPMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V get(Object obj) {
        ConsPStack consPStackEmpty = this.f3565b.get(obj.hashCode());
        if (consPStackEmpty == null) {
            consPStackEmpty = ConsPStack.empty();
        }
        while (consPStackEmpty != null && consPStackEmpty.size() > 0) {
            MapEntry mapEntry = (MapEntry) consPStackEmpty.k;
            if (mapEntry.key.equals(obj)) {
                return mapEntry.value;
            }
            consPStackEmpty = consPStackEmpty.l;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HashPMap<K, V> plus(K k, V v) {
        ConsPStack<MapEntry<K, V>> consPStackMinus = this.f3565b.get(k.hashCode());
        if (consPStackMinus == null) {
            consPStackMinus = ConsPStack.empty();
        }
        int size = consPStackMinus.size();
        int i = 0;
        ConsPStack consPStack = consPStackMinus;
        while (true) {
            if (consPStack == null || consPStack.size() <= 0) {
                i = -1;
                break;
            }
            if (((MapEntry) consPStack.k).key.equals(k)) {
                break;
            }
            consPStack = consPStack.l;
            i++;
        }
        if (i != -1) {
            consPStackMinus = consPStackMinus.minus(i);
        }
        ConsPStack<MapEntry<K, V>> consPStackPlus = consPStackMinus.plus(new MapEntry<>(k, v));
        return new HashPMap<>(this.f3565b.plus(k.hashCode(), consPStackPlus), consPStackPlus.size() + (this.c - size));
    }
}

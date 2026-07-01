package d0.t.q0;

import d0.z.d.m;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$e<K, V> extends c$d<K, V> implements Iterator<K>, d0.z.d.g0.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c$e(c<K, V> cVar) {
        super(cVar);
        m.checkNotNullParameter(cVar, "map");
    }

    @Override // java.util.Iterator
    public K next() {
        if (getIndex$kotlin_stdlib() >= c.access$getLength$p(getMap$kotlin_stdlib())) {
            throw new NoSuchElementException();
        }
        int index$kotlin_stdlib = getIndex$kotlin_stdlib();
        setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
        setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
        K k = (K) c.access$getKeysArray$p(getMap$kotlin_stdlib())[getLastIndex$kotlin_stdlib()];
        initNext$kotlin_stdlib();
        return k;
    }
}

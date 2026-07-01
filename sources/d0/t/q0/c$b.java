package d0.t.q0;

import d0.z.d.m;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$b<K, V> extends c$d<K, V> implements Iterator<Map$Entry<K, V>>, d0.z.d.g0.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c$b(c<K, V> cVar) {
        super(cVar);
        m.checkNotNullParameter(cVar, "map");
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    public final void nextAppendString(StringBuilder sb) {
        m.checkNotNullParameter(sb, "sb");
        if (getIndex$kotlin_stdlib() >= c.access$getLength$p(getMap$kotlin_stdlib())) {
            throw new NoSuchElementException();
        }
        int index$kotlin_stdlib = getIndex$kotlin_stdlib();
        setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
        setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
        Object obj = c.access$getKeysArray$p(getMap$kotlin_stdlib())[getLastIndex$kotlin_stdlib()];
        if (m.areEqual(obj, getMap$kotlin_stdlib())) {
            sb.append("(this Map)");
        } else {
            sb.append(obj);
        }
        sb.append('=');
        Object[] objArrAccess$getValuesArray$p = c.access$getValuesArray$p(getMap$kotlin_stdlib());
        m.checkNotNull(objArrAccess$getValuesArray$p);
        Object obj2 = objArrAccess$getValuesArray$p[getLastIndex$kotlin_stdlib()];
        if (m.areEqual(obj2, getMap$kotlin_stdlib())) {
            sb.append("(this Map)");
        } else {
            sb.append(obj2);
        }
        initNext$kotlin_stdlib();
    }

    public final int nextHashCode$kotlin_stdlib() {
        if (getIndex$kotlin_stdlib() >= c.access$getLength$p(getMap$kotlin_stdlib())) {
            throw new NoSuchElementException();
        }
        int index$kotlin_stdlib = getIndex$kotlin_stdlib();
        setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
        setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
        Object obj = c.access$getKeysArray$p(getMap$kotlin_stdlib())[getLastIndex$kotlin_stdlib()];
        int iHashCode = obj != null ? obj.hashCode() : 0;
        Object[] objArrAccess$getValuesArray$p = c.access$getValuesArray$p(getMap$kotlin_stdlib());
        m.checkNotNull(objArrAccess$getValuesArray$p);
        Object obj2 = objArrAccess$getValuesArray$p[getLastIndex$kotlin_stdlib()];
        int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
        initNext$kotlin_stdlib();
        return iHashCode2;
    }

    @Override // java.util.Iterator
    public c$c<K, V> next() {
        if (getIndex$kotlin_stdlib() >= c.access$getLength$p(getMap$kotlin_stdlib())) {
            throw new NoSuchElementException();
        }
        int index$kotlin_stdlib = getIndex$kotlin_stdlib();
        setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
        setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
        c$c<K, V> c_c = new c$c<>(getMap$kotlin_stdlib(), getLastIndex$kotlin_stdlib());
        initNext$kotlin_stdlib();
        return c_c;
    }
}

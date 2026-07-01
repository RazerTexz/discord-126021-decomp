package b.i.b.b;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v$o<K, V> extends v$b<K, V> {
    private static final long serialVersionUID = 3;

    public v$o(v$p v_p, v$p v_p2, b.i.b.a.d<Object> dVar, b.i.b.a.d<Object> dVar2, int i, ConcurrentMap<K, V> concurrentMap) {
        super(v_p, v_p2, dVar, dVar2, i, concurrentMap);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        u uVar = new u();
        int i2 = uVar.f1649b;
        b.i.a.f.e.o.f.F(i2 == -1, "initial capacity was already set to %s", i2);
        b.i.a.f.e.o.f.v(i >= 0);
        uVar.f1649b = i;
        uVar.d(this.keyStrength);
        v$p v_p = this.valueStrength;
        v$p v_p2 = uVar.e;
        b.i.a.f.e.o.f.G(v_p2 == null, "Value strength was already set to %s", v_p2);
        Objects.requireNonNull(v_p);
        uVar.e = v_p;
        if (v_p != v$p.j) {
            uVar.a = true;
        }
        b.i.b.a.d<Object> dVar = this.keyEquivalence;
        b.i.b.a.d<Object> dVar2 = uVar.f;
        b.i.a.f.e.o.f.G(dVar2 == null, "key equivalence was already set to %s", dVar2);
        Objects.requireNonNull(dVar);
        uVar.f = dVar;
        uVar.a = true;
        int i3 = this.concurrencyLevel;
        int i4 = uVar.c;
        b.i.a.f.e.o.f.F(i4 == -1, "concurrency level was already set to %s", i4);
        b.i.a.f.e.o.f.v(i3 > 0);
        uVar.c = i3;
        this.j = uVar.c();
        while (true) {
            Object object = objectInputStream.readObject();
            if (object == null) {
                return;
            } else {
                this.j.put((K) object, (V) objectInputStream.readObject());
            }
        }
    }

    private Object readResolve() {
        return this.j;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.j.size());
        for (Map$Entry<K, V> map$Entry : this.j.entrySet()) {
            objectOutputStream.writeObject(map$Entry.getKey());
            objectOutputStream.writeObject(map$Entry.getValue());
        }
        objectOutputStream.writeObject(null);
    }
}

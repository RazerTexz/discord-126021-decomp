package b.i.b.b;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: Multimaps.java */
/* JADX INFO: loaded from: classes3.dex */
public class d0<K, V> extends c<K, V> {
    private static final long serialVersionUID = 0;
    public transient b.i.b.a.l<? extends List<V>> o;

    public d0(Map<K, Collection<V>> map, b.i.b.a.l<? extends List<V>> lVar) {
        super(map);
        Objects.requireNonNull(lVar);
        this.o = lVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.o = (b.i.b.a.l) objectInputStream.readObject();
        Map<K, Collection<V>> map = (Map) objectInputStream.readObject();
        this.m = map;
        this.n = 0;
        for (Collection<V> collection : map.values()) {
            b.i.a.f.e.o.f.v(!collection.isEmpty());
            this.n = collection.size() + this.n;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.o);
        objectOutputStream.writeObject(this.m);
    }

    @Override // b.i.b.b.e
    public Collection e() {
        return this.o.get();
    }
}

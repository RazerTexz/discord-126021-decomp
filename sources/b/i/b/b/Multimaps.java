package b.i.b.b;

import b.i.b.a.Supplier2;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.b.b.d0, reason: use source file name */
/* JADX INFO: compiled from: Multimaps.java */
/* JADX INFO: loaded from: classes3.dex */
public class Multimaps<K, V> extends AbstractListMultimap<K, V> {
    private static final long serialVersionUID = 0;
    public transient Supplier2<? extends List<V>> o;

    public Multimaps(Map<K, Collection<V>> map, Supplier2<? extends List<V>> supplier2) {
        super(map);
        Objects.requireNonNull(supplier2);
        this.o = supplier2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.o = (Supplier2) objectInputStream.readObject();
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

    @Override // b.i.b.b.AbstractMapBasedMultimap2
    public Collection e() {
        return this.o.get();
    }
}

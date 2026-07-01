package b.g.a.c.i0;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: LRUMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class h<K, V> implements j<K, V>, Serializable {
    private static final long serialVersionUID = 1;
    public final transient int j;
    public final transient ConcurrentHashMap<K, V> k;
    public transient int l;

    public h(int i, int i2) {
        this.k = new ConcurrentHashMap<>(i, 0.8f, 4);
        this.j = i2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        this.l = objectInputStream.readInt();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.l);
    }

    @Override // b.g.a.c.i0.j
    public V get(Object obj) {
        return this.k.get(obj);
    }

    @Override // b.g.a.c.i0.j
    public V putIfAbsent(K k, V v) {
        if (this.k.size() >= this.j) {
            synchronized (this) {
                if (this.k.size() >= this.j) {
                    this.k.clear();
                }
            }
        }
        return this.k.putIfAbsent(k, v);
    }

    public Object readResolve() {
        int i = this.l;
        return new h(i, i);
    }
}

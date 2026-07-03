package p007b.p195g.p196a.p205c.p219i0;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: b.g.a.c.i0.h */
/* JADX INFO: compiled from: LRUMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2346h<K, V> implements InterfaceC2348j<K, V>, Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: j */
    public final transient int f4954j;

    /* JADX INFO: renamed from: k */
    public final transient ConcurrentHashMap<K, V> f4955k;

    /* JADX INFO: renamed from: l */
    public transient int f4956l;

    public C2346h(int i, int i2) {
        this.f4955k = new ConcurrentHashMap<>(i, 0.8f, 4);
        this.f4954j = i2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        this.f4956l = objectInputStream.readInt();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f4956l);
    }

    @Override // p007b.p195g.p196a.p205c.p219i0.InterfaceC2348j
    public V get(Object obj) {
        return this.f4955k.get(obj);
    }

    @Override // p007b.p195g.p196a.p205c.p219i0.InterfaceC2348j
    public V putIfAbsent(K k, V v) {
        if (this.f4955k.size() >= this.f4954j) {
            synchronized (this) {
                if (this.f4955k.size() >= this.f4954j) {
                    this.f4955k.clear();
                }
            }
        }
        return this.f4955k.putIfAbsent(k, v);
    }

    public Object readResolve() {
        int i = this.f4956l;
        return new C2346h(i, i);
    }
}

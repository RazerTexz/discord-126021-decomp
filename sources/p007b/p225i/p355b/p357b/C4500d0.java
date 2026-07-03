package p007b.p225i.p355b.p357b;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p356a.InterfaceC4492l;

/* JADX INFO: renamed from: b.i.b.b.d0 */
/* JADX INFO: compiled from: Multimaps.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4500d0<K, V> extends AbstractC4497c<K, V> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: o */
    public transient InterfaceC4492l<? extends List<V>> f11972o;

    public C4500d0(Map<K, Collection<V>> map, InterfaceC4492l<? extends List<V>> interfaceC4492l) {
        super(map);
        Objects.requireNonNull(interfaceC4492l);
        this.f11972o = interfaceC4492l;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f11972o = (InterfaceC4492l) objectInputStream.readObject();
        Map<K, Collection<V>> map = (Map) objectInputStream.readObject();
        this.f11973m = map;
        this.f11974n = 0;
        for (Collection<V> collection : map.values()) {
            C3404f.m4351v(!collection.isEmpty());
            this.f11974n = collection.size() + this.f11974n;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f11972o);
        objectOutputStream.writeObject(this.f11973m);
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4501e
    /* JADX INFO: renamed from: e */
    public Collection mo6217e() {
        return this.f11972o.get();
    }
}

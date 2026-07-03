package p007b.p109f.p161j.p168c;

import com.facebook.common.references.CloseableReference;
import p007b.p109f.p115d.p119d.InterfaceC1687j;
import p007b.p109f.p115d.p122g.InterfaceC1695b;

/* JADX INFO: renamed from: b.f.j.c.w */
/* JADX INFO: compiled from: MemoryCache.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC1876w<K, V> extends InterfaceC1695b {

    /* JADX INFO: renamed from: b.f.j.c.w$a */
    /* JADX INFO: compiled from: MemoryCache.java */
    public interface a {
    }

    /* JADX INFO: renamed from: a */
    CloseableReference<V> mo1235a(K k, CloseableReference<V> closeableReference);

    boolean contains(K k);

    /* JADX INFO: renamed from: d */
    int mo1236d(InterfaceC1687j<K> interfaceC1687j);

    CloseableReference<V> get(K k);
}

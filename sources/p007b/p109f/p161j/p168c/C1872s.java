package p007b.p109f.p161j.p168c;

import com.facebook.common.references.CloseableReference;
import p007b.p109f.p115d.p119d.InterfaceC1687j;

/* JADX INFO: renamed from: b.f.j.c.s */
/* JADX INFO: compiled from: InstrumentedMemoryCache.java */
/* JADX INFO: loaded from: classes.dex */
public class C1872s<K, V> implements InterfaceC1876w<K, V> {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1876w<K, V> f3687a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1877x f3688b;

    public C1872s(InterfaceC1876w<K, V> interfaceC1876w, InterfaceC1877x interfaceC1877x) {
        this.f3687a = interfaceC1876w;
        this.f3688b = interfaceC1877x;
    }

    @Override // p007b.p109f.p161j.p168c.InterfaceC1876w
    /* JADX INFO: renamed from: a */
    public CloseableReference<V> mo1235a(K k, CloseableReference<V> closeableReference) {
        this.f3688b.mo1234c(k);
        return this.f3687a.mo1235a(k, closeableReference);
    }

    @Override // p007b.p109f.p161j.p168c.InterfaceC1876w
    /* JADX INFO: renamed from: d */
    public int mo1236d(InterfaceC1687j<K> interfaceC1687j) {
        return this.f3687a.mo1236d(interfaceC1687j);
    }

    @Override // p007b.p109f.p161j.p168c.InterfaceC1876w
    public CloseableReference<V> get(K k) {
        CloseableReference<V> closeableReference = this.f3687a.get(k);
        if (closeableReference == null) {
            this.f3688b.mo1233b(k);
        } else {
            this.f3688b.mo1232a(k);
        }
        return closeableReference;
    }
}

package p007b.p109f.p161j.p168c;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: renamed from: b.f.j.c.u */
/* JADX INFO: compiled from: LruCountingMemoryCache.java */
/* JADX INFO: loaded from: classes.dex */
public class C1874u<K, V> implements InterfaceC1855b0<InterfaceC1866m.a<K, V>> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ InterfaceC1855b0 f3690a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C1875v f3691b;

    public C1874u(C1875v c1875v, InterfaceC1855b0 interfaceC1855b0) {
        this.f3691b = c1875v;
        this.f3690a = interfaceC1855b0;
    }

    @Override // p007b.p109f.p161j.p168c.InterfaceC1855b0
    /* JADX INFO: renamed from: a */
    public int mo1212a(Object obj) {
        InterfaceC1866m.a aVar = (InterfaceC1866m.a) obj;
        return this.f3691b.f3699h ? aVar.f3683f : this.f3690a.mo1212a(aVar.f3679b.m8642u());
    }
}

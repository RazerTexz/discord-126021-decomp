package s.a.a;

/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k$a extends d<k> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f3828b;
    public final k c;

    public k$a(k kVar) {
        this.c = kVar;
    }

    @Override // s.a.a.d
    public void b(k kVar, Object obj) {
        k kVar2 = kVar;
        boolean z2 = obj == null;
        k kVar3 = z2 ? this.c : this.f3828b;
        if (kVar3 != null && k.j.compareAndSet(kVar2, this, kVar3) && z2) {
            k kVar4 = this.c;
            k kVar5 = this.f3828b;
            d0.z.d.m.checkNotNull(kVar5);
            kVar4.g(kVar5);
        }
    }
}

package p637j0.p642l.p643a;

import p637j0.p642l.p643a.C12628h1;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.i1 */
/* JADX INFO: compiled from: OperatorPublish.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12632i1 implements Action0 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C12628h1.b f26850j;

    public C12632i1(C12628h1.b bVar) {
        this.f26850j = bVar;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // p658rx.functions.Action0
    public void call() {
        this.f26850j.f26837o.getAndSet(C12628h1.b.f26833k);
        C12628h1.b bVar = this.f26850j;
        bVar.f26835m.compareAndSet((C12628h1.b<T>) bVar, null);
    }
}

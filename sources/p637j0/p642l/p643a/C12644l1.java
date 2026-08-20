package p637j0.p642l.p643a;

import java.util.concurrent.atomic.AtomicReference;
import p637j0.p655r.C12785a;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.functions.Func0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.l1 */
/* JADX INFO: compiled from: OperatorReplay.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12644l1<T> implements Observable.InterfaceC13005a<T> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AtomicReference f26905j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Func0 f26906k;

    public C12644l1(AtomicReference atomicReference, Func0 func0) {
        this.f26905j = atomicReference;
        this.f26906k = func0;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        C12636j1.f fVar;
        Subscriber subscriber = (Subscriber) obj;
        while (true) {
            fVar = (C12636j1.f) this.f26905j.get();
            if (fVar != null) {
                break;
            }
            C12636j1.f fVar2 = new C12636j1.f((C12636j1.e) this.f26906k.call());
            fVar2.add(new C12785a(new C12648m1(fVar2)));
            if (this.f26905j.compareAndSet(fVar, fVar2)) {
                fVar = fVar2;
                break;
            }
        }
        C12636j1.c<T> cVar = new C12636j1.c<>(fVar, subscriber);
        if (!fVar.f26864m) {
            synchronized (fVar.f26865n) {
                if (!fVar.f26864m) {
                    fVar.f26865n.m10815a(cVar);
                    fVar.f26867p++;
                }
            }
        }
        subscriber.add(cVar);
        fVar.f26862k.mo10764h(cVar);
        subscriber.setProducer(cVar);
    }
}

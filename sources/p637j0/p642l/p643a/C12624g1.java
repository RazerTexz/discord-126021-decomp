package p637j0.p642l.p643a;

import java.util.concurrent.atomic.AtomicReference;
import p637j0.p642l.p643a.C12628h1;
import p637j0.p655r.C12785a;
import p658rx.Observable;
import p658rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.g1 */
/* JADX INFO: compiled from: OperatorPublish.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12624g1<T> implements Observable.InterfaceC13005a<T> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AtomicReference f26810j;

    public C12624g1(AtomicReference atomicReference) {
        this.f26810j = atomicReference;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        boolean z2;
        Subscriber subscriber = (Subscriber) obj;
        while (true) {
            C12628h1.b bVar = (C12628h1.b) this.f26810j.get();
            if (bVar == null || bVar.isUnsubscribed()) {
                C12628h1.b bVar2 = new C12628h1.b(this.f26810j);
                bVar2.add(new C12785a(new C12632i1(bVar2)));
                if (this.f26810j.compareAndSet(bVar, bVar2)) {
                    bVar = bVar2;
                } else {
                    continue;
                }
            }
            C12628h1.a aVar = new C12628h1.a(bVar, subscriber);
            while (true) {
                C12628h1.a[] aVarArr = bVar.f26837o.get();
                z2 = false;
                if (aVarArr == C12628h1.b.f26833k) {
                    break;
                }
                int length = aVarArr.length;
                C12628h1.a[] aVarArr2 = new C12628h1.a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
                if (bVar.f26837o.compareAndSet(aVarArr, aVarArr2)) {
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                subscriber.add(aVar);
                subscriber.setProducer(aVar);
                return;
            }
        }
    }
}

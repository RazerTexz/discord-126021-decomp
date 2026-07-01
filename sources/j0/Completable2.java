package j0;

import j0.Completable3;
import rx.Observable;

/* JADX INFO: renamed from: j0.c, reason: use source file name */
/* JADX INFO: compiled from: Completable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Completable2 implements Completable3.a {
    public final /* synthetic */ Observable j;

    public Completable2(Observable observable) {
        this.j = observable;
    }

    @Override // rx.functions.Action1
    public void call(CompletableSubscriber completableSubscriber) {
        CompletableSubscriber completableSubscriber2 = completableSubscriber;
        Completable completable = new Completable(this, completableSubscriber2);
        completableSubscriber2.a(completable);
        this.j.i0(completable);
    }
}

package j0.l.e;

import java.util.concurrent.TimeUnit;
import rx.Subscription;
import rx.functions.Action0;

/* JADX INFO: compiled from: ScalarSynchronousObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public class k$a implements j0.k.b<Action0, Subscription> {
    public final /* synthetic */ j0.l.c.b j;

    public k$a(k kVar, j0.l.c.b bVar) {
        this.j = bVar;
    }

    @Override // j0.k.b
    public Subscription call(Action0 action0) {
        return this.j.e.get().a().f(action0, -1L, TimeUnit.NANOSECONDS);
    }
}

package j0.l.a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Scheduler$Worker;
import rx.Subscriber;
import rx.functions.Action0;

/* JADX INFO: compiled from: OnSubscribeRedo.java */
/* JADX INFO: loaded from: classes3.dex */
public class w implements Action0 {
    public final /* synthetic */ Observable j;
    public final /* synthetic */ Subscriber k;
    public final /* synthetic */ AtomicLong l;
    public final /* synthetic */ Scheduler$Worker m;
    public final /* synthetic */ Action0 n;
    public final /* synthetic */ AtomicBoolean o;

    public w(y yVar, Observable observable, Subscriber subscriber, AtomicLong atomicLong, Scheduler$Worker scheduler$Worker, Action0 action0, AtomicBoolean atomicBoolean) {
        this.j = observable;
        this.k = subscriber;
        this.l = atomicLong;
        this.m = scheduler$Worker;
        this.n = action0;
        this.o = atomicBoolean;
    }

    @Override // rx.functions.Action0
    public void call() {
        this.j.i0(new w$a(this, this.k));
    }
}

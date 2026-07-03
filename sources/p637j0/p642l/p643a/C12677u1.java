package p637j0.p642l.p643a;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Subscriber;
import p658rx.functions.Func2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.u1 */
/* JADX INFO: compiled from: OperatorSkipWhile.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12677u1<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public boolean f27060j;

    /* JADX INFO: renamed from: k */
    public int f27061k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Subscriber f27062l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ C12683w1 f27063m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12677u1(C12683w1 c12683w1, Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.f27063m = c12683w1;
        this.f27062l = subscriber2;
        this.f27060j = true;
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        this.f27062l.onCompleted();
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        this.f27062l.onError(th);
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        if (!this.f27060j) {
            this.f27062l.onNext(t);
            return;
        }
        try {
            Func2<? super T, Integer, Boolean> func2 = this.f27063m.f27075j;
            int i = this.f27061k;
            this.f27061k = i + 1;
            if (func2.call(t, Integer.valueOf(i)).booleanValue()) {
                request(1L);
            } else {
                this.f27060j = false;
                this.f27062l.onNext(t);
            }
        } catch (Throwable th) {
            C3404f.m4329p1(th, this.f27062l, t);
        }
    }
}

package p637j0.p642l.p643a;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Subscriber;
import p658rx.functions.Func2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.j2 */
/* JADX INFO: compiled from: OperatorTakeWhile.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12637j2<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public int f26877j;

    /* JADX INFO: renamed from: k */
    public boolean f26878k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Subscriber f26879l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ C12633i2 f26880m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12637j2(C12633i2 c12633i2, Subscriber subscriber, boolean z2, Subscriber subscriber2) {
        super(subscriber, z2);
        this.f26880m = c12633i2;
        this.f26879l = subscriber2;
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        if (this.f26878k) {
            return;
        }
        this.f26879l.onCompleted();
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        if (this.f26878k) {
            return;
        }
        this.f26879l.onError(th);
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        try {
            Func2<? super T, ? super Integer, Boolean> func2 = this.f26880m.f26851j;
            int i = this.f26877j;
            this.f26877j = i + 1;
            if (func2.call(t, Integer.valueOf(i)).booleanValue()) {
                this.f26879l.onNext(t);
                return;
            }
            this.f26878k = true;
            this.f26879l.onCompleted();
            unsubscribe();
        } catch (Throwable th) {
            this.f26878k = true;
            C3404f.m4329p1(th, this.f26879l, t);
            unsubscribe();
        }
    }
}

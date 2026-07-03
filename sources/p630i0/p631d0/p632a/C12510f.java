package p630i0.p631d0.p632a;

import java.lang.reflect.Type;
import p630i0.InterfaceC12504d;
import p630i0.InterfaceC12512e;
import p637j0.C12577c;
import p637j0.C12578d;
import p637j0.C12582h;
import p637j0.p642l.p643a.C12615e0;
import p637j0.p652o.C12774l;
import p658rx.Observable;
import p658rx.Scheduler;

/* JADX INFO: renamed from: i0.d0.a.f */
/* JADX INFO: compiled from: RxJavaCallAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12510f<R> implements InterfaceC12512e<R, Object> {

    /* JADX INFO: renamed from: a */
    public final Type f26505a;

    /* JADX INFO: renamed from: b */
    public final boolean f26506b;

    /* JADX INFO: renamed from: c */
    public final boolean f26507c;

    /* JADX INFO: renamed from: d */
    public final boolean f26508d;

    /* JADX INFO: renamed from: e */
    public final boolean f26509e;

    public C12510f(Type type, Scheduler scheduler, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f26505a = type;
        this.f26506b = z3;
        this.f26507c = z4;
        this.f26508d = z5;
        this.f26509e = z6;
    }

    @Override // p630i0.InterfaceC12512e
    /* JADX INFO: renamed from: a */
    public Type mo10705a() {
        return this.f26505a;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0027  */
    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    /* JADX WARN: Code duplicated, block: B:15:0x0036  */
    /* JADX WARN: Code duplicated, block: B:23:0x0052 A[RETURN] */
    @Override // p630i0.InterfaceC12512e
    /* JADX INFO: renamed from: b */
    public Object mo10706b(InterfaceC12504d<R> interfaceC12504d) {
        Observable.InterfaceC13005a c12505a;
        Observable observable;
        Observable.InterfaceC13005a c12507c = new C12507c(interfaceC12504d);
        if (!this.f26506b) {
            if (this.f26507c) {
                c12505a = new C12505a(c12507c);
            }
            observable = new Observable(C12774l.m10862a(c12507c));
            if (this.f26508d) {
                return new C12582h(new C12615e0(observable));
            }
            if (!this.f26509e) {
                return observable;
            }
            try {
                return new C12578d(new C12577c(observable));
            } catch (NullPointerException e) {
                throw e;
            } catch (Throwable th) {
                C12774l.m10863b(th);
                NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
                nullPointerException.initCause(th);
                throw nullPointerException;
            }
        }
        c12505a = new C12509e(c12507c);
        c12507c = c12505a;
        observable = new Observable(C12774l.m10862a(c12507c));
        if (this.f26508d) {
            return new C12582h(new C12615e0(observable));
        }
        if (!this.f26509e) {
            return new C12578d(new C12577c(observable));
        }
        return observable;
    }
}

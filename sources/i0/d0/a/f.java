package i0.d0.a;

import j0.h;
import j0.l.a.e0;
import j0.o.l;
import java.lang.reflect.Type;
import rx.Observable;
import rx.Observable$a;
import rx.Scheduler;

/* JADX INFO: compiled from: RxJavaCallAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f<R> implements i0.e<R, Object> {
    public final Type a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3736b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    public f(Type type, Scheduler scheduler, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.a = type;
        this.f3736b = z3;
        this.c = z4;
        this.d = z5;
        this.e = z6;
    }

    @Override // i0.e
    public Type a() {
        return this.a;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0027  */
    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    /* JADX WARN: Code duplicated, block: B:15:0x0036  */
    /* JADX WARN: Code duplicated, block: B:23:0x0052 A[RETURN] */
    @Override // i0.e
    public Object b(i0.d<R> dVar) {
        Observable$a aVar;
        Observable observable;
        Observable$a cVar = new c(dVar);
        if (!this.f3736b) {
            if (this.c) {
                aVar = new a(cVar);
            }
            observable = new Observable(l.a(cVar));
            if (this.d) {
                return new h(new e0(observable));
            }
            if (!this.e) {
                return observable;
            }
            try {
                return new j0.d(new j0.c(observable));
            } catch (NullPointerException e) {
                throw e;
            } catch (Throwable th) {
                l.b(th);
                NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
                nullPointerException.initCause(th);
                throw nullPointerException;
            }
        }
        aVar = new e(cVar);
        cVar = aVar;
        observable = new Observable(l.a(cVar));
        if (this.d) {
            return new h(new e0(observable));
        }
        if (!this.e) {
            return new j0.d(new j0.c(observable));
        }
        return observable;
    }
}

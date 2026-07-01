package rx.subjects;

import b.i.a.f.e.o.f;
import j0.l.a.e;
import j0.l.a.e$c;
import j0.q.c;
import j0.q.c$b;
import java.util.ArrayList;
import rx.Observable$a;

/* JADX INFO: loaded from: classes3.dex */
public final class BehaviorSubject<T> extends Subject<T, T> {
    public static final Object[] k = new Object[0];
    public final c<T> l;

    public BehaviorSubject(Observable$a<T> observable$a, c<T> cVar) {
        super(observable$a);
        this.l = cVar;
    }

    public static <T> BehaviorSubject<T> k0() {
        return m0(null, false);
    }

    public static <T> BehaviorSubject<T> l0(T t) {
        return m0(t, true);
    }

    public static <T> BehaviorSubject<T> m0(T t, boolean z2) {
        c cVar = new c();
        if (z2) {
            if (t == null) {
                t = (T) e.f3771b;
            }
            cVar.latest = t;
        }
        BehaviorSubject$a behaviorSubject$a = new BehaviorSubject$a(cVar);
        cVar.onAdded = behaviorSubject$a;
        cVar.onTerminated = behaviorSubject$a;
        return new BehaviorSubject<>(cVar, cVar);
    }

    public T n0() {
        Object obj = this.l.latest;
        if ((obj == null || (obj instanceof e$c) || e.c(obj)) ? false : true) {
            return (T) e.b(obj);
        }
        return null;
    }

    @Override // j0.g
    public void onCompleted() {
        if (this.l.latest == null || this.l.active) {
            Object obj = e.a;
            for (c$b<T> c_b : this.l.b(obj)) {
                c_b.a(obj);
            }
        }
    }

    @Override // j0.g
    public void onError(Throwable th) {
        if (this.l.latest == null || this.l.active) {
            e$c e_c = new e$c(th);
            ArrayList arrayList = null;
            for (c$b<T> c_b : this.l.b(e_c)) {
                try {
                    c_b.a(e_c);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            f.n1(arrayList);
        }
    }

    @Override // j0.g
    public void onNext(T t) {
        if (this.l.latest == null || this.l.active) {
            if (t == null) {
                t = (T) e.f3771b;
            }
            c<T> cVar = this.l;
            cVar.latest = t;
            for (c$b c_b : cVar.get().e) {
                c_b.a(t);
            }
        }
    }
}

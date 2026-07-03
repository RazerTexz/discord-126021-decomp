package p658rx.subjects;

import java.util.ArrayList;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p643a.C12614e;
import p637j0.p654q.C12784c;
import p658rx.Observable;
import p658rx.functions.Action1;

/* JADX INFO: loaded from: classes3.dex */
public final class BehaviorSubject<T> extends Subject<T, T> {

    /* JADX INFO: renamed from: k */
    public static final Object[] f27647k = new Object[0];

    /* JADX INFO: renamed from: l */
    public final C12784c<T> f27648l;

    /* JADX INFO: renamed from: rx.subjects.BehaviorSubject$a */
    public static class C13014a implements Action1<C12784c.b<T>> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ C12784c f27649j;

        public C13014a(C12784c c12784c) {
            this.f27649j = c12784c;
        }

        /* JADX WARN: Code duplicated, block: B:46:0x005b  */
        /* JADX WARN: Code duplicated, block: B:59:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // p658rx.functions.Action1
        public void call(Object obj) throws Throwable {
            C12784c.b bVar = (C12784c.b) obj;
            Object obj2 = this.f27649j.latest;
            synchronized (bVar) {
                if (bVar.f27415k && !bVar.f27416l) {
                    bVar.f27415k = false;
                    boolean z2 = true;
                    bVar.f27416l = obj2 != null;
                    if (obj2 != null) {
                        List<Object> list = null;
                        boolean z3 = true;
                        while (true) {
                            if (list != null) {
                                try {
                                    for (Object obj3 : list) {
                                        if (obj3 != null) {
                                            C12614e.m10744a(bVar.f27414j, obj3);
                                        }
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    z2 = false;
                                    if (!z2) {
                                        synchronized (bVar) {
                                            bVar.f27416l = false;
                                        }
                                    }
                                    throw th;
                                }
                            }
                            if (z3) {
                                C12614e.m10744a(bVar.f27414j, obj2);
                                z3 = false;
                            }
                            try {
                                synchronized (bVar) {
                                    try {
                                        list = bVar.f27417m;
                                        bVar.f27417m = null;
                                        if (list == null) {
                                            bVar.f27416l = false;
                                            return;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z2 = false;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            try {
                                throw th;
                            } catch (Throwable th4) {
                                th = th4;
                                if (!z2) {
                                    synchronized (bVar) {
                                        bVar.f27416l = false;
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                }
            }
        }
    }

    public BehaviorSubject(Observable.InterfaceC13005a<T> interfaceC13005a, C12784c<T> c12784c) {
        super(interfaceC13005a);
        this.f27648l = c12784c;
    }

    /* JADX INFO: renamed from: k0 */
    public static <T> BehaviorSubject<T> m11129k0() {
        return m11131m0(null, false);
    }

    /* JADX INFO: renamed from: l0 */
    public static <T> BehaviorSubject<T> m11130l0(T t) {
        return m11131m0(t, true);
    }

    /* JADX INFO: renamed from: m0 */
    public static <T> BehaviorSubject<T> m11131m0(T t, boolean z2) {
        C12784c c12784c = new C12784c();
        if (z2) {
            if (t == null) {
                t = (T) C12614e.f26769b;
            }
            c12784c.latest = t;
        }
        C13014a c13014a = new C13014a(c12784c);
        c12784c.onAdded = c13014a;
        c12784c.onTerminated = c13014a;
        return new BehaviorSubject<>(c12784c, c12784c);
    }

    /* JADX INFO: renamed from: n0 */
    public T m11132n0() {
        Object obj = this.f27648l.latest;
        if ((obj == null || (obj instanceof C12614e.c) || C12614e.m10746c(obj)) ? false : true) {
            return (T) C12614e.m10745b(obj);
        }
        return null;
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        if (this.f27648l.latest == null || this.f27648l.active) {
            Object obj = C12614e.f26768a;
            for (C12784c.b<T> bVar : this.f27648l.m10879b(obj)) {
                bVar.m10880a(obj);
            }
        }
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        if (this.f27648l.latest == null || this.f27648l.active) {
            C12614e.c cVar = new C12614e.c(th);
            ArrayList arrayList = null;
            for (C12784c.b<T> bVar : this.f27648l.m10879b(cVar)) {
                try {
                    bVar.m10880a(cVar);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            C3404f.m4321n1(arrayList);
        }
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        if (this.f27648l.latest == null || this.f27648l.active) {
            if (t == null) {
                t = (T) C12614e.f26769b;
            }
            C12784c<T> c12784c = this.f27648l;
            c12784c.latest = t;
            for (C12784c.b bVar : c12784c.get().f27413e) {
                bVar.m10880a(t);
            }
        }
    }
}

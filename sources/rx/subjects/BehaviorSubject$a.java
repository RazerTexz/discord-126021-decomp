package rx.subjects;

import j0.l.a.e;
import j0.q.c;
import j0.q.c$b;
import java.util.List;
import rx.functions.Action1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes3.dex */
public class BehaviorSubject$a<T> implements Action1<c$b<T>> {
    public final /* synthetic */ c j;

    public BehaviorSubject$a(c cVar) {
        this.j = cVar;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x005b  */
    /* JADX WARN: Code duplicated, block: B:59:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // rx.functions.Action1
    public void call(Object obj) throws Throwable {
        c$b c_b = (c$b) obj;
        Object obj2 = this.j.latest;
        synchronized (c_b) {
            if (c_b.k && !c_b.l) {
                c_b.k = false;
                boolean z2 = true;
                c_b.l = obj2 != null;
                if (obj2 != null) {
                    List<Object> list = null;
                    boolean z3 = true;
                    while (true) {
                        if (list != null) {
                            try {
                                for (Object obj3 : list) {
                                    if (obj3 != null) {
                                        e.a(c_b.j, obj3);
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                z2 = false;
                                if (!z2) {
                                    synchronized (c_b) {
                                        c_b.l = false;
                                    }
                                }
                                throw th;
                            }
                        }
                        if (z3) {
                            e.a(c_b.j, obj2);
                            z3 = false;
                        }
                        try {
                            synchronized (c_b) {
                                try {
                                    list = c_b.m;
                                    c_b.m = null;
                                    if (list == null) {
                                        c_b.l = false;
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
                                synchronized (c_b) {
                                    c_b.l = false;
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

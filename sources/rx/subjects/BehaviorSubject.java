package rx.subjects;

import b.i.a.f.e.o.f;
import j0.l.a.NotificationLite;
import j0.q.SubjectSubscriptionManager2;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes3.dex */
public final class BehaviorSubject<T> extends Subject<T, T> {
    public static final Object[] k = new Object[0];
    public final SubjectSubscriptionManager2<T> l;

    public static class a implements Action1<SubjectSubscriptionManager2.b<T>> {
        public final /* synthetic */ SubjectSubscriptionManager2 j;

        public a(SubjectSubscriptionManager2 subjectSubscriptionManager2) {
            this.j = subjectSubscriptionManager2;
        }

        /* JADX WARN: Code duplicated, block: B:46:0x005b  */
        /* JADX WARN: Code duplicated, block: B:59:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // rx.functions.Action1
        public void call(Object obj) throws Throwable {
            SubjectSubscriptionManager2.b bVar = (SubjectSubscriptionManager2.b) obj;
            Object obj2 = this.j.latest;
            synchronized (bVar) {
                if (bVar.k && !bVar.l) {
                    bVar.k = false;
                    boolean z2 = true;
                    bVar.l = obj2 != null;
                    if (obj2 != null) {
                        List<Object> list = null;
                        boolean z3 = true;
                        while (true) {
                            if (list != null) {
                                try {
                                    for (Object obj3 : list) {
                                        if (obj3 != null) {
                                            NotificationLite.a(bVar.j, obj3);
                                        }
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    z2 = false;
                                    if (!z2) {
                                        synchronized (bVar) {
                                            bVar.l = false;
                                        }
                                    }
                                    throw th;
                                }
                            }
                            if (z3) {
                                NotificationLite.a(bVar.j, obj2);
                                z3 = false;
                            }
                            try {
                                synchronized (bVar) {
                                    try {
                                        list = bVar.m;
                                        bVar.m = null;
                                        if (list == null) {
                                            bVar.l = false;
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
                                        bVar.l = false;
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

    public BehaviorSubject(Observable.a<T> aVar, SubjectSubscriptionManager2<T> subjectSubscriptionManager2) {
        super(aVar);
        this.l = subjectSubscriptionManager2;
    }

    public static <T> BehaviorSubject<T> k0() {
        return m0(null, false);
    }

    public static <T> BehaviorSubject<T> l0(T t) {
        return m0(t, true);
    }

    public static <T> BehaviorSubject<T> m0(T t, boolean z2) {
        SubjectSubscriptionManager2 subjectSubscriptionManager2 = new SubjectSubscriptionManager2();
        if (z2) {
            if (t == null) {
                t = (T) NotificationLite.f3771b;
            }
            subjectSubscriptionManager2.latest = t;
        }
        a aVar = new a(subjectSubscriptionManager2);
        subjectSubscriptionManager2.onAdded = aVar;
        subjectSubscriptionManager2.onTerminated = aVar;
        return new BehaviorSubject<>(subjectSubscriptionManager2, subjectSubscriptionManager2);
    }

    public T n0() {
        Object obj = this.l.latest;
        if ((obj == null || (obj instanceof NotificationLite.c) || NotificationLite.c(obj)) ? false : true) {
            return (T) NotificationLite.b(obj);
        }
        return null;
    }

    @Override // j0.Observer2
    public void onCompleted() {
        if (this.l.latest == null || this.l.active) {
            Object obj = NotificationLite.a;
            for (SubjectSubscriptionManager2.b<T> bVar : this.l.b(obj)) {
                bVar.a(obj);
            }
        }
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        if (this.l.latest == null || this.l.active) {
            NotificationLite.c cVar = new NotificationLite.c(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager2.b<T> bVar : this.l.b(cVar)) {
                try {
                    bVar.a(cVar);
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

    @Override // j0.Observer2
    public void onNext(T t) {
        if (this.l.latest == null || this.l.active) {
            if (t == null) {
                t = (T) NotificationLite.f3771b;
            }
            SubjectSubscriptionManager2<T> subjectSubscriptionManager2 = this.l;
            subjectSubscriptionManager2.latest = t;
            for (SubjectSubscriptionManager2.b bVar : subjectSubscriptionManager2.get().e) {
                bVar.a(t);
            }
        }
    }
}

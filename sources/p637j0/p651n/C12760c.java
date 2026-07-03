package p637j0.p651n;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.InterfaceC12581g;
import p637j0.p642l.p643a.C12614e;
import p658rx.exceptions.OnErrorThrowable;

/* JADX INFO: renamed from: j0.n.c */
/* JADX INFO: compiled from: SerializedObserver.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12760c<T> implements InterfaceC12581g<T> {

    /* JADX INFO: renamed from: j */
    public final InterfaceC12581g<? super T> f27366j;

    /* JADX INFO: renamed from: k */
    public boolean f27367k;

    /* JADX INFO: renamed from: l */
    public volatile boolean f27368l;

    /* JADX INFO: renamed from: m */
    public a f27369m;

    /* JADX INFO: renamed from: j0.n.c$a */
    /* JADX INFO: compiled from: SerializedObserver.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public Object[] f27370a;

        /* JADX INFO: renamed from: b */
        public int f27371b;

        /* JADX INFO: renamed from: a */
        public void m10861a(Object obj) {
            int i = this.f27371b;
            Object[] objArr = this.f27370a;
            if (objArr == null) {
                objArr = new Object[16];
                this.f27370a = objArr;
            } else if (i == objArr.length) {
                Object[] objArr2 = new Object[(i >> 2) + i];
                System.arraycopy(objArr, 0, objArr2, 0, i);
                this.f27370a = objArr2;
                objArr = objArr2;
            }
            objArr[i] = obj;
            this.f27371b = i + 1;
        }
    }

    public C12760c(InterfaceC12581g<? super T> interfaceC12581g) {
        this.f27366j = interfaceC12581g;
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        if (this.f27368l) {
            return;
        }
        synchronized (this) {
            if (this.f27368l) {
                return;
            }
            this.f27368l = true;
            if (!this.f27367k) {
                this.f27367k = true;
                this.f27366j.onCompleted();
                return;
            }
            a aVar = this.f27369m;
            if (aVar == null) {
                aVar = new a();
                this.f27369m = aVar;
            }
            aVar.m10861a(C12614e.f26768a);
        }
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        C3404f.m4325o1(th);
        if (this.f27368l) {
            return;
        }
        synchronized (this) {
            if (this.f27368l) {
                return;
            }
            this.f27368l = true;
            if (!this.f27367k) {
                this.f27367k = true;
                this.f27366j.onError(th);
                return;
            }
            a aVar = this.f27369m;
            if (aVar == null) {
                aVar = new a();
                this.f27369m = aVar;
            }
            aVar.m10861a(new C12614e.c(th));
        }
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        if (this.f27368l) {
            return;
        }
        synchronized (this) {
            if (this.f27368l) {
                return;
            }
            if (this.f27367k) {
                a aVar = this.f27369m;
                if (aVar == null) {
                    aVar = new a();
                    this.f27369m = aVar;
                }
                if (t == null) {
                    t = (T) C12614e.f26769b;
                }
                aVar.m10861a(t);
                return;
            }
            this.f27367k = true;
            try {
                this.f27366j.onNext(t);
                while (true) {
                    synchronized (this) {
                        a aVar2 = this.f27369m;
                        if (aVar2 == null) {
                            this.f27367k = false;
                            return;
                        }
                        this.f27369m = null;
                        for (Object obj : aVar2.f27370a) {
                            if (obj == null) {
                                break;
                            }
                            try {
                                if (C12614e.m10744a(this.f27366j, obj)) {
                                    this.f27368l = true;
                                    return;
                                }
                            } catch (Throwable th) {
                                this.f27368l = true;
                                C3404f.m4325o1(th);
                                this.f27366j.onError(OnErrorThrowable.m11126a(th, t));
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                this.f27368l = true;
                C3404f.m4329p1(th2, this.f27366j, t);
            }
        }
    }
}

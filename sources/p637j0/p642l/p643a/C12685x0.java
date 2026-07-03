package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p647e.C12719i;
import p637j0.p642l.p647e.C12721k;
import p637j0.p642l.p647e.p648n.C12726c;
import p637j0.p642l.p647e.p648n.C12727d;
import p637j0.p642l.p647e.p648n.C12730g;
import p637j0.p642l.p647e.p649o.C12744n;
import p637j0.p642l.p647e.p649o.C12755y;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.exceptions.CompositeException;
import p658rx.exceptions.MissingBackpressureException;
import p658rx.exceptions.OnErrorThrowable;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: renamed from: j0.l.a.x0 */
/* JADX INFO: compiled from: OperatorMerge.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12685x0<T> implements Observable.InterfaceC13006b<T, Observable<? extends T>> {

    /* JADX INFO: renamed from: j */
    public final boolean f27081j;

    /* JADX INFO: renamed from: j0.l.a.x0$a */
    /* JADX INFO: compiled from: OperatorMerge.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final C12685x0<Object> f27082a = new C12685x0<>(true, Integer.MAX_VALUE);
    }

    /* JADX INFO: renamed from: j0.l.a.x0$b */
    /* JADX INFO: compiled from: OperatorMerge.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public static final C12685x0<Object> f27083a = new C12685x0<>(false, Integer.MAX_VALUE);
    }

    /* JADX INFO: renamed from: j0.l.a.x0$c */
    /* JADX INFO: compiled from: OperatorMerge.java */
    public static final class c<T> extends Subscriber<T> {

        /* JADX INFO: renamed from: j */
        public static final int f27084j = C12719i.f27283j / 4;

        /* JADX INFO: renamed from: k */
        public final e<T> f27085k;

        /* JADX INFO: renamed from: l */
        public final long f27086l;

        /* JADX INFO: renamed from: m */
        public volatile boolean f27087m;

        /* JADX INFO: renamed from: n */
        public volatile C12719i f27088n;

        /* JADX INFO: renamed from: o */
        public int f27089o;

        public c(e<T> eVar, long j) {
            this.f27085k = eVar;
            this.f27086l = j;
        }

        /* JADX INFO: renamed from: a */
        public void m10780a(long j) {
            int i = this.f27089o - ((int) j);
            if (i > f27084j) {
                this.f27089o = i;
                return;
            }
            int i2 = C12719i.f27283j;
            this.f27089o = i2;
            int i3 = i2 - i;
            if (i3 > 0) {
                request(i3);
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() throws Throwable {
            this.f27087m = true;
            this.f27085k.m10783b();
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) throws Throwable {
            this.f27085k.m10785d().offer(th);
            this.f27087m = true;
            this.f27085k.m10783b();
        }

        /* JADX WARN: Code duplicated, block: B:60:0x0090  */
        /* JADX WARN: Code duplicated, block: B:70:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) throws Throwable {
            boolean z2;
            e<T> eVar = this.f27085k;
            long j = eVar.f27095n.get();
            boolean z3 = true;
            if (j != 0) {
                synchronized (eVar) {
                    j = eVar.f27095n.get();
                    if (eVar.f27100s || j == 0) {
                        z2 = false;
                    } else {
                        eVar.f27100s = true;
                        z2 = true;
                    }
                }
            } else {
                z2 = false;
            }
            if (!z2) {
                eVar.m10787f(this, t);
                eVar.m10783b();
                return;
            }
            C12719i c12719i = this.f27088n;
            if (c12719i != null) {
                Queue<Object> queue = c12719i.f27284k;
                if (!(queue == null || queue.isEmpty())) {
                    eVar.m10787f(this, t);
                    eVar.m10784c();
                    return;
                }
            }
            try {
                try {
                    try {
                        eVar.f27092k.onNext(t);
                    } catch (Throwable th) {
                        th = th;
                        z3 = false;
                        if (!z3) {
                            synchronized (eVar) {
                                eVar.f27100s = false;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (!z3) {
                        synchronized (eVar) {
                            eVar.f27100s = false;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                if (!eVar.f27093l) {
                    C3404f.m4325o1(th3);
                    unsubscribe();
                    onError(th3);
                    return;
                }
                eVar.m10785d().offer(th3);
            }
            if (j != RecyclerView.FOREVER_NS) {
                eVar.f27095n.m10781a(1);
            }
            m10780a(1L);
            synchronized (eVar) {
                if (eVar.f27101t) {
                    eVar.f27101t = false;
                    eVar.m10784c();
                } else {
                    eVar.f27100s = false;
                }
            }
        }

        @Override // p658rx.Subscriber
        public void onStart() {
            int i = C12719i.f27283j;
            this.f27089o = i;
            request(i);
        }
    }

    /* JADX INFO: renamed from: j0.l.a.x0$d */
    /* JADX INFO: compiled from: OperatorMerge.java */
    public static final class d<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -1214379189873595503L;
        public final e<T> subscriber;

        public d(e<T> eVar) {
            this.subscriber = eVar;
        }

        /* JADX INFO: renamed from: a */
        public long m10781a(int i) {
            return addAndGet(-i);
        }

        @Override // p658rx.Producer
        /* JADX INFO: renamed from: j */
        public void mo10704j(long j) throws Throwable {
            if (j <= 0) {
                if (j < 0) {
                    throw new IllegalArgumentException("n >= 0 required");
                }
            } else {
                if (get() == RecyclerView.FOREVER_NS) {
                    return;
                }
                C3404f.m4276c0(this, j);
                this.subscriber.m10783b();
            }
        }
    }

    /* JADX INFO: renamed from: j0.l.a.x0$e */
    /* JADX INFO: compiled from: OperatorMerge.java */
    public static final class e<T> extends Subscriber<Observable<? extends T>> {

        /* JADX INFO: renamed from: j */
        public static final c<?>[] f27090j = new c[0];

        /* JADX INFO: renamed from: A */
        public int f27091A;

        /* JADX INFO: renamed from: k */
        public final Subscriber<? super T> f27092k;

        /* JADX INFO: renamed from: l */
        public final boolean f27093l;

        /* JADX INFO: renamed from: m */
        public final int f27094m;

        /* JADX INFO: renamed from: n */
        public d<T> f27095n;

        /* JADX INFO: renamed from: o */
        public volatile Queue<Object> f27096o;

        /* JADX INFO: renamed from: p */
        public volatile CompositeSubscription f27097p;

        /* JADX INFO: renamed from: q */
        public volatile ConcurrentLinkedQueue<Throwable> f27098q;

        /* JADX INFO: renamed from: r */
        public volatile boolean f27099r;

        /* JADX INFO: renamed from: s */
        public boolean f27100s;

        /* JADX INFO: renamed from: t */
        public boolean f27101t;

        /* JADX INFO: renamed from: u */
        public final Object f27102u = new Object();

        /* JADX INFO: renamed from: v */
        public volatile c<?>[] f27103v = f27090j;

        /* JADX INFO: renamed from: w */
        public long f27104w;

        /* JADX INFO: renamed from: x */
        public long f27105x;

        /* JADX INFO: renamed from: y */
        public int f27106y;

        /* JADX INFO: renamed from: z */
        public final int f27107z;

        public e(Subscriber<? super T> subscriber, boolean z2, int i) {
            this.f27092k = subscriber;
            this.f27093l = z2;
            this.f27094m = i;
            if (i == Integer.MAX_VALUE) {
                this.f27107z = Integer.MAX_VALUE;
                request(RecyclerView.FOREVER_NS);
            } else {
                this.f27107z = Math.max(1, i >> 1);
                request(i);
            }
        }

        /* JADX INFO: renamed from: a */
        public boolean m10782a() {
            if (this.f27092k.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.f27098q;
            if (this.f27093l || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                return false;
            }
            try {
                m10789h();
                return true;
            } finally {
                unsubscribe();
            }
        }

        /* JADX INFO: renamed from: b */
        public void m10783b() throws Throwable {
            synchronized (this) {
                if (this.f27100s) {
                    this.f27101t = true;
                } else {
                    this.f27100s = true;
                    m10784c();
                }
            }
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x01b6 */
        /* JADX WARN: Code duplicated, block: B:132:0x0169 A[Catch: all -> 0x01b8, TryCatch #7 {all -> 0x01b8, blocks: (B:3:0x0002, B:4:0x0004, B:7:0x000b, B:17:0x002f, B:22:0x003f, B:36:0x0066, B:27:0x004a, B:29:0x004e, B:35:0x005f, B:40:0x0076, B:47:0x008a, B:50:0x0095, B:53:0x009d, B:55:0x00a1, B:58:0x00a8, B:59:0x00ac, B:62:0x00b2, B:64:0x00b8, B:80:0x00e3, B:83:0x00ea, B:87:0x00f2, B:90:0x00f9, B:93:0x00fe, B:96:0x0105, B:112:0x012e, B:114:0x013e, B:121:0x0151, B:124:0x0159, B:126:0x015d, B:132:0x0169, B:135:0x0173, B:143:0x0186, B:146:0x0194, B:149:0x019e, B:138:0x0179, B:141:0x017e, B:70:0x00c6, B:73:0x00cf, B:76:0x00d4, B:77:0x00d7, B:23:0x0043), top: B:196:0x0002, inners: #5 }] */
        /* JADX WARN: Code duplicated, block: B:135:0x0173 A[Catch: all -> 0x01b8, TryCatch #7 {all -> 0x01b8, blocks: (B:3:0x0002, B:4:0x0004, B:7:0x000b, B:17:0x002f, B:22:0x003f, B:36:0x0066, B:27:0x004a, B:29:0x004e, B:35:0x005f, B:40:0x0076, B:47:0x008a, B:50:0x0095, B:53:0x009d, B:55:0x00a1, B:58:0x00a8, B:59:0x00ac, B:62:0x00b2, B:64:0x00b8, B:80:0x00e3, B:83:0x00ea, B:87:0x00f2, B:90:0x00f9, B:93:0x00fe, B:96:0x0105, B:112:0x012e, B:114:0x013e, B:121:0x0151, B:124:0x0159, B:126:0x015d, B:132:0x0169, B:135:0x0173, B:143:0x0186, B:146:0x0194, B:149:0x019e, B:138:0x0179, B:141:0x017e, B:70:0x00c6, B:73:0x00cf, B:76:0x00d4, B:77:0x00d7, B:23:0x0043), top: B:196:0x0002, inners: #5 }] */
        /* JADX WARN: Code duplicated, block: B:205:0x0172 A[SYNTHETIC] */
        /* JADX INFO: renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void m10784c() throws Throwable {
            boolean z2;
            long jM10781a;
            int i;
            boolean z3;
            try {
                Subscriber<? super T> subscriber = this.f27092k;
                while (!m10782a()) {
                    Queue<Object> queue = this.f27096o;
                    long j = this.f27095n.get();
                    boolean z4 = j == RecyclerView.FOREVER_NS;
                    if (queue != null) {
                        int i2 = 0;
                        while (true) {
                            jM10781a = j;
                            int i3 = 0;
                            i = i2;
                            Object obj = null;
                            while (jM10781a > 0) {
                                Object objPoll = queue.poll();
                                if (m10782a()) {
                                    return;
                                }
                                if (objPoll == null) {
                                    obj = objPoll;
                                    break;
                                }
                                try {
                                    subscriber.onNext((Object) C12614e.m10745b(objPoll));
                                } catch (Throwable th) {
                                    if (!this.f27093l) {
                                        C3404f.m4325o1(th);
                                        unsubscribe();
                                        subscriber.onError(th);
                                        return;
                                    }
                                    m10785d().offer(th);
                                }
                                i++;
                                i3++;
                                jM10781a--;
                                obj = objPoll;
                            }
                            if (i3 > 0) {
                                jM10781a = z4 ? Long.MAX_VALUE : this.f27095n.m10781a(i3);
                            }
                            if (jM10781a == 0 || obj == null) {
                                break;
                                break;
                            } else {
                                i2 = i;
                                j = jM10781a;
                            }
                        }
                    } else {
                        jM10781a = j;
                        i = 0;
                    }
                    boolean z5 = this.f27099r;
                    Queue<Object> queue2 = this.f27096o;
                    c<?>[] cVarArr = this.f27103v;
                    int length = cVarArr.length;
                    if (z5 && ((queue2 == null || queue2.isEmpty()) && length == 0)) {
                        ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.f27098q;
                        if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                            m10789h();
                            return;
                        }
                        subscriber.onCompleted();
                        return;
                    }
                    if (length > 0) {
                        long j2 = this.f27105x;
                        int i4 = this.f27106y;
                        if (length <= i4 || cVarArr[i4].f27086l != j2) {
                            if (length <= i4) {
                                i4 = 0;
                            }
                            for (int i5 = 0; i5 < length && cVarArr[i4].f27086l != j2; i5++) {
                                i4++;
                                if (i4 == length) {
                                    i4 = 0;
                                }
                            }
                            this.f27106y = i4;
                            this.f27105x = cVarArr[i4].f27086l;
                        }
                        int i6 = 0;
                        z3 = false;
                        while (true) {
                            if (i6 >= length) {
                                subscriber = subscriber;
                                break;
                            }
                            if (m10782a()) {
                                return;
                            }
                            c<?> cVar = cVarArr[i4];
                            Object objM10819c = null;
                            while (true) {
                                int i7 = 0;
                                while (jM10781a > 0) {
                                    if (m10782a()) {
                                        return;
                                    }
                                    C12719i c12719i = cVar.f27088n;
                                    if (c12719i != null && (objM10819c = c12719i.m10819c()) != null) {
                                        try {
                                            try {
                                                subscriber.onNext((Object) C12614e.m10745b(objM10819c));
                                                jM10781a--;
                                                i7++;
                                            } catch (Throwable th2) {
                                                C3404f.m4325o1(th2);
                                                try {
                                                    subscriber.onError(th2);
                                                    return;
                                                } finally {
                                                    unsubscribe();
                                                }
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            z2 = true;
                                        }
                                    }
                                    if (!z2) {
                                        synchronized (this) {
                                            this.f27100s = false;
                                        }
                                    }
                                    throw th;
                                }
                                if (i7 > 0) {
                                    long jM10781a2 = !z4 ? this.f27095n.m10781a(i7) : RecyclerView.FOREVER_NS;
                                    cVar.m10780a(i7);
                                    jM10781a = jM10781a2;
                                } else {
                                    subscriber = subscriber;
                                }
                                if (jM10781a == 0 || objM10819c == null) {
                                    break;
                                    break;
                                }
                                subscriber = subscriber;
                            }
                            boolean z6 = cVar.f27087m;
                            C12719i c12719i2 = cVar.f27088n;
                            if (z6) {
                                if (c12719i2 == null) {
                                    m10788g(cVar);
                                    if (m10782a()) {
                                        return;
                                    }
                                    i++;
                                    z3 = true;
                                } else {
                                    Queue<Object> queue3 = c12719i2.f27284k;
                                    if (queue3 == null || queue3.isEmpty()) {
                                        m10788g(cVar);
                                        if (m10782a()) {
                                            return;
                                        }
                                        i++;
                                        z3 = true;
                                    }
                                }
                            }
                            if (jM10781a == 0) {
                                break;
                            }
                            i4++;
                            if (i4 == length) {
                                i4 = 0;
                            }
                            i6++;
                            subscriber = subscriber;
                        }
                        this.f27106y = i4;
                        this.f27105x = cVarArr[i4].f27086l;
                    } else {
                        subscriber = subscriber;
                        z3 = false;
                    }
                    if (i > 0) {
                        request(i);
                    }
                    if (!z3) {
                        try {
                            synchronized (this) {
                                try {
                                    if (this.f27101t) {
                                        this.f27101t = false;
                                    } else {
                                        try {
                                            this.f27100s = false;
                                            return;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            z2 = true;
                                        }
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    z2 = false;
                                }
                                while (true) {
                                }
                                throw th;
                            }
                            throw th;
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    }
                    subscriber = subscriber;
                }
            } catch (Throwable th7) {
                th = th7;
                z2 = false;
            }
        }

        /* JADX INFO: renamed from: d */
        public Queue<Throwable> m10785d() {
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.f27098q;
            if (concurrentLinkedQueue == null) {
                synchronized (this) {
                    concurrentLinkedQueue = this.f27098q;
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        this.f27098q = concurrentLinkedQueue;
                    }
                }
            }
            return concurrentLinkedQueue;
        }

        /* JADX INFO: renamed from: e */
        public void m10786e(T t) throws Throwable {
            Queue<Object> c12727d;
            Queue<Object> c12730g = this.f27096o;
            if (c12730g == null) {
                int i = this.f27094m;
                if (i == Integer.MAX_VALUE) {
                    c12730g = new C12730g<>(C12719i.f27283j);
                } else {
                    if (((i + (-1)) & i) == 0) {
                        c12727d = C12755y.m10858b() ? new C12744n<>(i) : new C12726c<>(i);
                    } else {
                        c12727d = new C12727d<>(i);
                    }
                    c12730g = c12727d;
                }
                this.f27096o = c12730g;
            }
            if (c12730g.offer(t == null ? C12614e.f26769b : t)) {
                return;
            }
            unsubscribe();
            m10785d().offer(OnErrorThrowable.m11126a(new MissingBackpressureException(), t));
            this.f27099r = true;
            m10783b();
        }

        /* JADX INFO: renamed from: f */
        public void m10787f(c<T> cVar, T t) throws Throwable {
            C12719i c12719i = cVar.f27088n;
            if (c12719i == null) {
                c12719i = C12755y.m10858b() ? new C12719i(false, C12719i.f27283j) : new C12719i();
                cVar.add(c12719i);
                cVar.f27088n = c12719i;
            }
            if (t == null) {
                try {
                    t = (T) C12614e.f26769b;
                } catch (IllegalStateException e) {
                    if (cVar.isUnsubscribed()) {
                        return;
                    }
                    cVar.unsubscribe();
                    cVar.onError(e);
                    return;
                } catch (MissingBackpressureException e2) {
                    cVar.unsubscribe();
                    cVar.onError(e2);
                    return;
                }
            }
            c12719i.m10817a(t);
        }

        /* JADX INFO: renamed from: g */
        public void m10788g(c<T> cVar) {
            C12719i c12719i = cVar.f27088n;
            if (c12719i != null) {
                synchronized (c12719i) {
                }
            }
            this.f27097p.m11138c(cVar);
            synchronized (this.f27102u) {
                c<?>[] cVarArr = this.f27103v;
                int length = cVarArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (cVar.equals(cVarArr[i])) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    this.f27103v = f27090j;
                    return;
                }
                c<?>[] cVarArr2 = new c[length - 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, i);
                System.arraycopy(cVarArr, i + 1, cVarArr2, i, (length - i) - 1);
                this.f27103v = cVarArr2;
            }
        }

        /* JADX INFO: renamed from: h */
        public final void m10789h() {
            ArrayList arrayList = new ArrayList(this.f27098q);
            if (arrayList.size() == 1) {
                this.f27092k.onError((Throwable) arrayList.get(0));
            } else {
                this.f27092k.onError(new CompositeException(arrayList));
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() throws Throwable {
            this.f27099r = true;
            m10783b();
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) throws Throwable {
            m10785d().offer(th);
            this.f27099r = true;
            m10783b();
        }

        /* JADX WARN: Code duplicated, block: B:104:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:68:0x00bf  */
        @Override // p637j0.InterfaceC12581g
        public void onNext(Object obj) throws Throwable {
            boolean z2;
            Observable<Object> observable = (Observable) obj;
            if (observable == null) {
                return;
            }
            boolean z3 = true;
            if (observable == EnumC12606c.f26751k) {
                int i = this.f27091A + 1;
                if (i != this.f27107z) {
                    this.f27091A = i;
                    return;
                } else {
                    this.f27091A = 0;
                    request(i);
                    return;
                }
            }
            if (!(observable instanceof C12721k)) {
                long j = this.f27104w;
                this.f27104w = 1 + j;
                c<?> cVar = new c<>(this, j);
                CompositeSubscription compositeSubscription = this.f27097p;
                if (compositeSubscription == null) {
                    synchronized (this) {
                        compositeSubscription = this.f27097p;
                        if (compositeSubscription == null) {
                            compositeSubscription = new CompositeSubscription();
                            this.f27097p = compositeSubscription;
                        } else {
                            z3 = false;
                        }
                    }
                    if (z3) {
                        add(compositeSubscription);
                    }
                }
                compositeSubscription.m11136a(cVar);
                synchronized (this.f27102u) {
                    c<?>[] cVarArr = this.f27103v;
                    int length = cVarArr.length;
                    c<?>[] cVarArr2 = new c[length + 1];
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                    cVarArr2[length] = cVar;
                    this.f27103v = cVarArr2;
                }
                observable.m11107i0(cVar);
                m10783b();
                return;
            }
            T t = ((C12721k) observable).f27288l;
            long j2 = this.f27095n.get();
            if (j2 != 0) {
                synchronized (this) {
                    j2 = this.f27095n.get();
                    if (this.f27100s || j2 == 0) {
                        z2 = false;
                    } else {
                        this.f27100s = true;
                        z2 = true;
                    }
                }
            } else {
                z2 = false;
            }
            if (!z2) {
                m10786e(t);
                m10783b();
                return;
            }
            Queue<Object> queue = this.f27096o;
            if (queue != null && !queue.isEmpty()) {
                m10786e(t);
                m10784c();
                return;
            }
            try {
                try {
                    this.f27092k.onNext(t);
                } catch (Throwable th) {
                    try {
                        if (!this.f27093l) {
                            C3404f.m4325o1(th);
                            unsubscribe();
                            m10785d().offer(th);
                            this.f27099r = true;
                            m10783b();
                            return;
                        }
                        m10785d().offer(th);
                    } catch (Throwable th2) {
                        th = th2;
                        z3 = false;
                        if (!z3) {
                            synchronized (this) {
                                this.f27100s = false;
                            }
                        }
                        throw th;
                    }
                }
                if (j2 != RecyclerView.FOREVER_NS) {
                    this.f27095n.m10781a(1);
                }
                int i2 = this.f27091A + 1;
                if (i2 == this.f27107z) {
                    this.f27091A = 0;
                    request(i2);
                } else {
                    this.f27091A = i2;
                }
                synchronized (this) {
                    if (this.f27101t) {
                        this.f27101t = false;
                        m10784c();
                    } else {
                        this.f27100s = false;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (!z3) {
                    synchronized (this) {
                        this.f27100s = false;
                    }
                }
                throw th;
            }
        }
    }

    public C12685x0(boolean z2, int i) {
        this.f27081j = z2;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        e eVar = new e(subscriber, this.f27081j, Integer.MAX_VALUE);
        d<T> dVar = new d<>(eVar);
        eVar.f27095n = dVar;
        subscriber.add(eVar);
        subscriber.setProducer(dVar);
        return eVar;
    }
}

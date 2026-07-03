package p659s.p660a;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CompletionHandlerException;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.TimeoutCancellationException;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C11211b;
import p507d0.p578f0.AbstractC12072k;
import p507d0.p578f0.C12073l;
import p507d0.p584w.p586i.p587a.AbstractC12193j;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.p661a.AbstractC13033p;
import p659s.p660a.p661a.C13027j;
import p659s.p660a.p661a.C13028k;
import p659s.p660a.p661a.C13037t;

/* JADX INFO: renamed from: s.a.h1 */
/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C13116h1 implements Job, InterfaceC13144r, InterfaceC13143q1 {

    /* JADX INFO: renamed from: j */
    public static final AtomicReferenceFieldUpdater f27846j = AtomicReferenceFieldUpdater.newUpdater(C13116h1.class, Object.class, "_state");
    public volatile Object _parentHandle;
    public volatile Object _state;

    /* JADX INFO: renamed from: s.a.h1$a */
    /* JADX INFO: compiled from: JobSupport.kt */
    public static final class a extends AbstractC13113g1<Job> {

        /* JADX INFO: renamed from: n */
        public final C13116h1 f27847n;

        /* JADX INFO: renamed from: o */
        public final b f27848o;

        /* JADX INFO: renamed from: p */
        public final C13141q f27849p;

        /* JADX INFO: renamed from: q */
        public final Object f27850q;

        public a(C13116h1 c13116h1, b bVar, C13141q c13141q, Object obj) {
            super(c13141q.f27882n);
            this.f27847n = c13116h1;
            this.f27848o = bVar;
            this.f27849p = c13141q;
            this.f27850q = obj;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            mo11198q(th);
            return Unit.f27425a;
        }

        @Override // p659s.p660a.AbstractC13165y
        /* JADX INFO: renamed from: q */
        public void mo11198q(Throwable th) {
            C13116h1 c13116h1 = this.f27847n;
            b bVar = this.f27848o;
            C13141q c13141q = this.f27849p;
            Object obj = this.f27850q;
            C13141q c13141qM11297U = c13116h1.m11297U(c13141q);
            if (c13141qM11297U == null || !c13116h1.m11303d0(bVar, c13141qM11297U, obj)) {
                c13116h1.mo11173v(c13116h1.m11289H(bVar, obj));
            }
        }

        @Override // p659s.p660a.p661a.C13028k
        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ChildCompletion[");
            sbM833U.append(this.f27849p);
            sbM833U.append(", ");
            sbM833U.append(this.f27850q);
            sbM833U.append(']');
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: s.a.h1$b */
    /* JADX INFO: compiled from: JobSupport.kt */
    public static final class b implements InterfaceC13169z0 {
        public volatile Object _exceptionsHolder = null;
        public volatile int _isCompleting;
        public volatile Object _rootCause;

        /* JADX INFO: renamed from: j */
        public final C13131m1 f27851j;

        public b(C13131m1 c13131m1, boolean z2, Throwable th) {
            this.f27851j = c13131m1;
            this._isCompleting = z2 ? 1 : 0;
            this._rootCause = th;
        }

        @Override // p659s.p660a.InterfaceC13169z0
        /* JADX INFO: renamed from: a */
        public boolean mo11281a() {
            return ((Throwable) this._rootCause) == null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: b */
        public final void m11309b(Throwable th) {
            Throwable th2 = (Throwable) this._rootCause;
            if (th2 == null) {
                this._rootCause = th;
                return;
            }
            if (th == th2) {
                return;
            }
            Object obj = this._exceptionsHolder;
            if (obj == null) {
                this._exceptionsHolder = th;
                return;
            }
            if (!(obj instanceof Throwable)) {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException(C1643a.m881v("State is ", obj).toString());
                }
                ((ArrayList) obj).add(th);
            } else {
                if (th == obj) {
                    return;
                }
                ArrayList<Throwable> arrayListM11310c = m11310c();
                arrayListM11310c.add(obj);
                arrayListM11310c.add(th);
                this._exceptionsHolder = arrayListM11310c;
            }
        }

        /* JADX INFO: renamed from: c */
        public final ArrayList<Throwable> m11310c() {
            return new ArrayList<>(4);
        }

        /* JADX INFO: renamed from: d */
        public final boolean m11311d() {
            return ((Throwable) this._rootCause) != null;
        }

        /* JADX INFO: renamed from: e */
        public final boolean m11312e() {
            return this._exceptionsHolder == C13119i1.f27861e;
        }

        /* JADX INFO: renamed from: f */
        public final List<Throwable> m11313f(Throwable th) {
            ArrayList arrayListM11310c;
            Object obj = this._exceptionsHolder;
            if (obj == null) {
                arrayListM11310c = m11310c();
            } else if (obj instanceof Throwable) {
                ArrayList arrayListM11310c2 = m11310c();
                arrayListM11310c2.add(obj);
                arrayListM11310c = arrayListM11310c2;
            } else {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException(C1643a.m881v("State is ", obj).toString());
                }
                arrayListM11310c = (ArrayList) obj;
            }
            Throwable th2 = (Throwable) this._rootCause;
            if (th2 != null) {
                arrayListM11310c.add(0, th2);
            }
            if (th != null && (!C12238m.areEqual(th, th2))) {
                arrayListM11310c.add(th);
            }
            this._exceptionsHolder = C13119i1.f27861e;
            return arrayListM11310c;
        }

        @Override // p659s.p660a.InterfaceC13169z0
        public C13131m1 getList() {
            return this.f27851j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Finishing[cancelling=");
            sbM833U.append(m11311d());
            sbM833U.append(", completing=");
            sbM833U.append((boolean) this._isCompleting);
            sbM833U.append(", rootCause=");
            sbM833U.append((Throwable) this._rootCause);
            sbM833U.append(", exceptions=");
            sbM833U.append(this._exceptionsHolder);
            sbM833U.append(", list=");
            sbM833U.append(this.f27851j);
            sbM833U.append(']');
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: s.a.h1$c */
    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    public static final class c extends C13028k.a {

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ C13116h1 f27852d;

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ Object f27853e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(C13028k c13028k, C13028k c13028k2, C13116h1 c13116h1, Object obj) {
            super(c13028k2);
            this.f27852d = c13116h1;
            this.f27853e = obj;
        }

        @Override // p659s.p660a.p661a.AbstractC13021d
        /* JADX INFO: renamed from: c */
        public Object mo11144c(C13028k c13028k) {
            if (this.f27852d.m11292M() == this.f27853e) {
                return null;
            }
            return C13027j.f27683a;
        }
    }

    /* JADX INFO: renamed from: s.a.h1$d */
    /* JADX INFO: compiled from: JobSupport.kt */
    @InterfaceC12188e(m10084c = "kotlinx.coroutines.JobSupport$children$1", m10085f = "JobSupport.kt", m10086l = {949, 951}, m10087m = "invokeSuspend")
    public static final class d extends AbstractC12193j implements Function2<AbstractC12072k<? super InterfaceC13144r>, Continuation<? super Unit>, Object> {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public Object L$5;
        public int label;

        /* JADX INFO: renamed from: p$ */
        private AbstractC12072k f27854p$;

        public d(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d dVar = C13116h1.this.new d(continuation);
            dVar.f27854p$ = (AbstractC12072k) obj;
            return dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AbstractC12072k<? super InterfaceC13144r> abstractC12072k, Continuation<? super Unit> continuation) {
            d dVar = C13116h1.this.new d(continuation);
            dVar.f27854p$ = abstractC12072k;
            return dVar.invokeSuspend(Unit.f27425a);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x007f  */
        /* JADX WARN: Code duplicated, block: B:24:0x0083  */
        /* JADX WARN: Code duplicated, block: B:26:0x009c A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0081 -> B:27:0x009d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x009a -> B:27:0x009d). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = p507d0.p584w.p585h.C12183c.getCOROUTINE_SUSPENDED()
                int r1 = r10.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L3a
                if (r1 == r3) goto L32
                if (r1 != r2) goto L2a
                java.lang.Object r1 = r10.L$5
                s.a.q r1 = (p659s.p660a.C13141q) r1
                java.lang.Object r1 = r10.L$4
                s.a.a.k r1 = (p659s.p660a.p661a.C13028k) r1
                java.lang.Object r4 = r10.L$3
                s.a.a.i r4 = (p659s.p660a.p661a.C13026i) r4
                java.lang.Object r5 = r10.L$2
                s.a.m1 r5 = (p659s.p660a.C13131m1) r5
                java.lang.Object r6 = r10.L$1
                java.lang.Object r7 = r10.L$0
                d0.f0.k r7 = (p507d0.p578f0.AbstractC12072k) r7
                p507d0.C12113l.throwOnFailure(r11)
                r11 = r10
                goto L9d
            L2a:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L32:
                java.lang.Object r0 = r10.L$0
                d0.f0.k r0 = (p507d0.p578f0.AbstractC12072k) r0
                p507d0.C12113l.throwOnFailure(r11)
                goto La2
            L3a:
                p507d0.C12113l.throwOnFailure(r11)
                d0.f0.k r11 = r10.f27854p$
                s.a.h1 r1 = p659s.p660a.C13116h1.this
                java.lang.Object r1 = r1.m11292M()
                boolean r4 = r1 instanceof p659s.p660a.C13141q
                if (r4 == 0) goto L5b
                r2 = r1
                s.a.q r2 = (p659s.p660a.C13141q) r2
                s.a.r r2 = r2.f27882n
                r10.L$0 = r11
                r10.L$1 = r1
                r10.label = r3
                java.lang.Object r11 = r11.yield(r2, r10)
                if (r11 != r0) goto La2
                return r0
            L5b:
                boolean r4 = r1 instanceof p659s.p660a.InterfaceC13169z0
                if (r4 == 0) goto La2
                r4 = r1
                s.a.z0 r4 = (p659s.p660a.InterfaceC13169z0) r4
                s.a.m1 r4 = r4.getList()
                if (r4 == 0) goto La2
                java.lang.Object r5 = r4.m11155i()
            */
            //  java.lang.String r6 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
            /*
                java.util.Objects.requireNonNull(r5, r6)
                s.a.a.k r5 = (p659s.p660a.p661a.C13028k) r5
                r7 = r11
                r6 = r1
                r1 = r5
                r11 = r10
                r5 = r4
            L78:
                boolean r8 = p507d0.p592z.p594d.C12238m.areEqual(r1, r4)
                r8 = r8 ^ r3
                if (r8 == 0) goto La2
                boolean r8 = r1 instanceof p659s.p660a.C13141q
                if (r8 == 0) goto L9d
                r8 = r1
                s.a.q r8 = (p659s.p660a.C13141q) r8
                s.a.r r9 = r8.f27882n
                r11.L$0 = r7
                r11.L$1 = r6
                r11.L$2 = r5
                r11.L$3 = r4
                r11.L$4 = r1
                r11.L$5 = r8
                r11.label = r2
                java.lang.Object r8 = r7.yield(r9, r11)
                if (r8 != r0) goto L9d
                return r0
            L9d:
                s.a.a.k r1 = r1.m11156j()
                goto L78
            La2:
                kotlin.Unit r11 = kotlin.Unit.f27425a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: p659s.p660a.C13116h1.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public C13116h1(boolean z2) {
        this._state = z2 ? C13119i1.f27863g : C13119i1.f27862f;
        this._parentHandle = null;
    }

    /* JADX INFO: renamed from: b0 */
    public static /* synthetic */ CancellationException m11284b0(C13116h1 c13116h1, Throwable th, String str, int i, Object obj) {
        int i2 = i & 1;
        return c13116h1.m11301a0(th, null);
    }

    @Override // p659s.p660a.InterfaceC13143q1
    /* JADX INFO: renamed from: A */
    public CancellationException mo11285A() {
        Throwable th;
        Object objM11292M = m11292M();
        if (objM11292M instanceof b) {
            th = (Throwable) ((b) objM11292M)._rootCause;
        } else if (objM11292M instanceof C13159w) {
            th = ((C13159w) objM11292M).f27913b;
        } else {
            if (objM11292M instanceof InterfaceC13169z0) {
                throw new IllegalStateException(C1643a.m881v("Cannot be cancelling child in this state: ", objM11292M).toString());
            }
            th = null;
        }
        CancellationException cancellationException = (CancellationException) (th instanceof CancellationException ? th : null);
        if (cancellationException != null) {
            return cancellationException;
        }
        StringBuilder sbM833U = C1643a.m833U("Parent job is ");
        sbM833U.append(m11300Z(objM11292M));
        return new JobCancellationException(sbM833U.toString(), th, this);
    }

    /* JADX INFO: renamed from: B */
    public String mo11182B() {
        return "Job was cancelled";
    }

    @Override // kotlinx.coroutines.Job
    /* JADX INFO: renamed from: D */
    public final InterfaceC13138p mo10909D(InterfaceC13144r interfaceC13144r) {
        InterfaceC13130m0 interfaceC13130m0M4356w0 = C3404f.m4356w0(this, true, false, new C13141q(this, interfaceC13144r), 2, null);
        Objects.requireNonNull(interfaceC13130m0M4356w0, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (InterfaceC13138p) interfaceC13130m0M4356w0;
    }

    /* JADX INFO: renamed from: E */
    public boolean mo11286E(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return m11306w(th) && mo11279J();
    }

    /* JADX INFO: renamed from: F */
    public final void m11287F(InterfaceC13169z0 interfaceC13169z0, Object obj) throws Throwable {
        InterfaceC13138p interfaceC13138p = (InterfaceC13138p) this._parentHandle;
        if (interfaceC13138p != null) {
            interfaceC13138p.dispose();
            this._parentHandle = C13137o1.f27880j;
        }
        CompletionHandlerException completionHandlerException = null;
        if (!(obj instanceof C13159w)) {
            obj = null;
        }
        C13159w c13159w = (C13159w) obj;
        Throwable th = c13159w != null ? c13159w.f27913b : null;
        if (interfaceC13169z0 instanceof AbstractC13113g1) {
            try {
                ((AbstractC13113g1) interfaceC13169z0).mo11198q(th);
                return;
            } catch (Throwable th2) {
                mo11183O(new CompletionHandlerException("Exception in completion handler " + interfaceC13169z0 + " for " + this, th2));
                return;
            }
        }
        C13131m1 list = interfaceC13169z0.getList();
        if (list != null) {
            Object objM11155i = list.m11155i();
            Objects.requireNonNull(objM11155i, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            for (C13028k c13028kM11156j = (C13028k) objM11155i; !C12238m.areEqual(c13028kM11156j, list); c13028kM11156j = c13028kM11156j.m11156j()) {
                if (c13028kM11156j instanceof AbstractC13113g1) {
                    AbstractC13113g1 abstractC13113g1 = (AbstractC13113g1) c13028kM11156j;
                    try {
                        abstractC13113g1.mo11198q(th);
                    } catch (Throwable th3) {
                        if (completionHandlerException != null) {
                            C11211b.addSuppressed(completionHandlerException, th3);
                        } else {
                            completionHandlerException = new CompletionHandlerException("Exception in completion handler " + abstractC13113g1 + " for " + this, th3);
                        }
                    }
                }
            }
            if (completionHandlerException != null) {
                mo11183O(completionHandlerException);
            }
        }
    }

    /* JADX INFO: renamed from: G */
    public final Throwable m11288G(Object obj) {
        if (obj != null ? obj instanceof Throwable : true) {
            return obj != null ? (Throwable) obj : new JobCancellationException(mo11182B(), null, this);
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((InterfaceC13143q1) obj).mo11285A();
    }

    /* JADX INFO: renamed from: H */
    public final Object m11289H(b bVar, Object obj) throws Throwable {
        Throwable thM11290I;
        C13159w c13159w = (C13159w) (!(obj instanceof C13159w) ? null : obj);
        Throwable th = c13159w != null ? c13159w.f27913b : null;
        synchronized (bVar) {
            bVar.m11311d();
            List<Throwable> listM11313f = bVar.m11313f(th);
            thM11290I = m11290I(bVar, listM11313f);
            if (thM11290I != null && listM11313f.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(listM11313f.size()));
                for (Throwable th2 : listM11313f) {
                    if (th2 != thM11290I && th2 != thM11290I && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        C11211b.addSuppressed(thM11290I, th2);
                    }
                }
            }
        }
        if (thM11290I != null && thM11290I != th) {
            obj = new C13159w(thM11290I, false, 2);
        }
        if (thM11290I != null) {
            if (m11308z(thM11290I) || mo11293N(thM11290I)) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                C13159w.f27912a.compareAndSet((C13159w) obj, 0, 1);
            }
        }
        mo11185W(obj);
        f27846j.compareAndSet(this, bVar, obj instanceof InterfaceC13169z0 ? new C13043a1((InterfaceC13169z0) obj) : obj);
        m11287F(bVar, obj);
        return obj;
    }

    /* JADX INFO: renamed from: I */
    public final Throwable m11290I(b bVar, List<? extends Throwable> list) {
        Object next;
        Object obj = null;
        if (list.isEmpty()) {
            if (bVar.m11311d()) {
                return new JobCancellationException(mo11182B(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(!(((Throwable) next) instanceof CancellationException)));
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            for (Object obj2 : list) {
                Throwable th3 = (Throwable) obj2;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj = obj2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    /* JADX INFO: renamed from: J */
    public boolean mo11279J() {
        return true;
    }

    /* JADX INFO: renamed from: K */
    public boolean mo11280K() {
        return false;
    }

    /* JADX INFO: renamed from: L */
    public final C13131m1 m11291L(InterfaceC13169z0 interfaceC13169z0) {
        C13131m1 list = interfaceC13169z0.getList();
        if (list != null) {
            return list;
        }
        if (interfaceC13169z0 instanceof C13139p0) {
            return new C13131m1();
        }
        if (interfaceC13169z0 instanceof AbstractC13113g1) {
            m11299Y((AbstractC13113g1) interfaceC13169z0);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + interfaceC13169z0).toString());
    }

    /* JADX INFO: renamed from: M */
    public final Object m11292M() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof AbstractC13033p)) {
                return obj;
            }
            ((AbstractC13033p) obj).mo11142a(this);
        }
    }

    /* JADX INFO: renamed from: N */
    public boolean mo11293N(Throwable th) {
        return false;
    }

    /* JADX INFO: renamed from: O */
    public void mo11183O(Throwable th) throws Throwable {
        throw th;
    }

    /* JADX INFO: renamed from: P */
    public final void m11294P(Job job) {
        if (job == null) {
            this._parentHandle = C13137o1.f27880j;
            return;
        }
        job.start();
        InterfaceC13138p interfaceC13138pMo10909D = job.mo10909D(this);
        this._parentHandle = interfaceC13138pMo10909D;
        if (!(m11292M() instanceof InterfaceC13169z0)) {
            interfaceC13138pMo10909D.dispose();
            this._parentHandle = C13137o1.f27880j;
        }
    }

    /* JADX INFO: renamed from: Q */
    public boolean mo11171Q() {
        return this instanceof C13108f;
    }

    /* JADX INFO: renamed from: R */
    public final Object m11295R(Object obj) throws Throwable {
        Object objM11302c0;
        do {
            objM11302c0 = m11302c0(m11292M(), obj);
            if (objM11302c0 == C13119i1.f27857a) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                if (!(obj instanceof C13159w)) {
                    obj = null;
                }
                C13159w c13159w = (C13159w) obj;
                throw new IllegalStateException(str, c13159w != null ? c13159w.f27913b : null);
            }
        } while (objM11302c0 == C13119i1.f27859c);
        return objM11302c0;
    }

    /* JADX INFO: renamed from: S */
    public final AbstractC13113g1<?> m11296S(Function1<? super Throwable, Unit> function1, boolean z2) {
        if (z2) {
            AbstractC13094e1 abstractC13094e1 = (AbstractC13094e1) (function1 instanceof AbstractC13094e1 ? function1 : null);
            return abstractC13094e1 != null ? abstractC13094e1 : new C13053c1(this, function1);
        }
        AbstractC13113g1<?> abstractC13113g1 = (AbstractC13113g1) (function1 instanceof AbstractC13113g1 ? function1 : null);
        return abstractC13113g1 != null ? abstractC13113g1 : new C13078d1(this, function1);
    }

    /* JADX INFO: renamed from: T */
    public String mo11184T() {
        return getClass().getSimpleName();
    }

    /* JADX INFO: renamed from: U */
    public final C13141q m11297U(C13028k c13028k) {
        while (c13028k.mo11150m()) {
            c13028k = c13028k.m11157k();
        }
        while (true) {
            c13028k = c13028k.m11156j();
            if (!c13028k.mo11150m()) {
                if (c13028k instanceof C13141q) {
                    return (C13141q) c13028k;
                }
                if (c13028k instanceof C13131m1) {
                    return null;
                }
            }
        }
    }

    /* JADX INFO: renamed from: V */
    public final void m11298V(C13131m1 c13131m1, Throwable th) throws Throwable {
        CompletionHandlerException completionHandlerException = null;
        Object objM11155i = c13131m1.m11155i();
        Objects.requireNonNull(objM11155i, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        for (C13028k c13028kM11156j = (C13028k) objM11155i; !C12238m.areEqual(c13028kM11156j, c13131m1); c13028kM11156j = c13028kM11156j.m11156j()) {
            if (c13028kM11156j instanceof AbstractC13094e1) {
                AbstractC13113g1 abstractC13113g1 = (AbstractC13113g1) c13028kM11156j;
                try {
                    abstractC13113g1.mo11198q(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        C11211b.addSuppressed(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + abstractC13113g1 + " for " + this, th2);
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            mo11183O(completionHandlerException);
        }
        m11308z(th);
    }

    /* JADX INFO: renamed from: W */
    public void mo11185W(Object obj) {
    }

    /* JADX INFO: renamed from: X */
    public void mo11186X() {
    }

    /* JADX INFO: renamed from: Y */
    public final void m11299Y(AbstractC13113g1<?> abstractC13113g1) {
        C13131m1 c13131m1 = new C13131m1();
        C13028k.f27685k.lazySet(c13131m1, abstractC13113g1);
        C13028k.f27684j.lazySet(c13131m1, abstractC13113g1);
        while (abstractC13113g1.m11155i() == abstractC13113g1) {
            if (C13028k.f27684j.compareAndSet(abstractC13113g1, abstractC13113g1, c13131m1)) {
                c13131m1.m11154g(abstractC13113g1);
                break;
            }
        }
        f27846j.compareAndSet(this, abstractC13113g1, abstractC13113g1.m11156j());
    }

    /* JADX INFO: renamed from: Z */
    public final String m11300Z(Object obj) {
        if (!(obj instanceof b)) {
            if (obj instanceof InterfaceC13169z0) {
                return ((InterfaceC13169z0) obj).mo11281a() ? "Active" : "New";
            }
            return obj instanceof C13159w ? "Cancelled" : "Completed";
        }
        b bVar = (b) obj;
        if (bVar.m11311d()) {
            return "Cancelling";
        }
        return bVar._isCompleting != 0 ? "Completing" : "Active";
    }

    @Override // kotlinx.coroutines.Job
    /* JADX INFO: renamed from: a */
    public boolean mo10910a() {
        Object objM11292M = m11292M();
        return (objM11292M instanceof InterfaceC13169z0) && ((InterfaceC13169z0) objM11292M).mo11281a();
    }

    /* JADX INFO: renamed from: a0 */
    public final CancellationException m11301a0(Throwable th, String str) {
        CancellationException jobCancellationException = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        if (jobCancellationException == null) {
            if (str == null) {
                str = mo11182B();
            }
            jobCancellationException = new JobCancellationException(str, th, this);
        }
        return jobCancellationException;
    }

    @Override // kotlinx.coroutines.Job
    /* JADX INFO: renamed from: b */
    public void mo10911b(CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(mo11182B(), null, this);
        }
        m11307x(cancellationException);
    }

    /* JADX INFO: renamed from: c0 */
    public final Object m11302c0(Object obj, Object obj2) throws Throwable {
        if (!(obj instanceof InterfaceC13169z0)) {
            return C13119i1.f27857a;
        }
        boolean z2 = true;
        if (((obj instanceof C13139p0) || (obj instanceof AbstractC13113g1)) && !(obj instanceof C13141q) && !(obj2 instanceof C13159w)) {
            InterfaceC13169z0 interfaceC13169z0 = (InterfaceC13169z0) obj;
            if (f27846j.compareAndSet(this, interfaceC13169z0, obj2 instanceof InterfaceC13169z0 ? new C13043a1((InterfaceC13169z0) obj2) : obj2)) {
                mo11185W(obj2);
                m11287F(interfaceC13169z0, obj2);
            } else {
                z2 = false;
            }
            return z2 ? obj2 : C13119i1.f27859c;
        }
        InterfaceC13169z0 interfaceC13169z1 = (InterfaceC13169z0) obj;
        C13131m1 c13131m1M11291L = m11291L(interfaceC13169z1);
        if (c13131m1M11291L == null) {
            return C13119i1.f27859c;
        }
        C13141q c13141qM11297U = null;
        b bVar = (b) (!(interfaceC13169z1 instanceof b) ? null : interfaceC13169z1);
        if (bVar == null) {
            bVar = new b(c13131m1M11291L, false, null);
        }
        synchronized (bVar) {
            if (bVar._isCompleting != 0) {
                return C13119i1.f27857a;
            }
            bVar._isCompleting = 1;
            if (bVar != interfaceC13169z1 && !f27846j.compareAndSet(this, interfaceC13169z1, bVar)) {
                return C13119i1.f27859c;
            }
            boolean zM11311d = bVar.m11311d();
            C13159w c13159w = (C13159w) (!(obj2 instanceof C13159w) ? null : obj2);
            if (c13159w != null) {
                bVar.m11309b(c13159w.f27913b);
            }
            Throwable th = (Throwable) bVar._rootCause;
            if (!(true ^ zM11311d)) {
                th = null;
            }
            if (th != null) {
                m11298V(c13131m1M11291L, th);
            }
            C13141q c13141q = (C13141q) (!(interfaceC13169z1 instanceof C13141q) ? null : interfaceC13169z1);
            if (c13141q != null) {
                c13141qM11297U = c13141q;
            } else {
                C13131m1 list = interfaceC13169z1.getList();
                if (list != null) {
                    c13141qM11297U = m11297U(list);
                }
            }
            return (c13141qM11297U == null || !m11303d0(bVar, c13141qM11297U, obj2)) ? m11289H(bVar, obj2) : C13119i1.f27858b;
        }
    }

    /* JADX INFO: renamed from: d0 */
    public final boolean m11303d0(b bVar, C13141q c13141q, Object obj) {
        while (C3404f.m4356w0(c13141q.f27882n, false, false, new a(this, bVar, c13141q, obj), 1, null) == C13137o1.f27880j) {
            c13141q = m11297U(c13141q);
            if (c13141q == null) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.coroutines.Job
    /* JADX INFO: renamed from: e */
    public final Sequence<Job> mo10912e() {
        return C12073l.sequence(new d(null));
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) CoroutineContext.Element.C12790a.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) CoroutineContext.Element.C12790a.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return Job.INSTANCE;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return CoroutineContext.Element.C12790a.minusKey(this, key);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x008a  */
    /* JADX WARN: Code duplicated, block: B:55:0x008e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x0091  */
    /* JADX WARN: Code duplicated, block: B:83:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x009b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x0002 A[SYNTHETIC] */
    @Override // kotlinx.coroutines.Job
    /* JADX INFO: renamed from: n */
    public final InterfaceC13130m0 mo10913n(boolean z2, boolean z3, Function1<? super Throwable, Unit> function1) {
        Throwable th;
        AbstractC13113g1<?> abstractC13113g1M11296S = null;
        while (true) {
            Object objM11292M = m11292M();
            if (objM11292M instanceof C13139p0) {
                C13139p0 c13139p0 = (C13139p0) objM11292M;
                if (c13139p0.f27881j) {
                    if (abstractC13113g1M11296S == null) {
                        abstractC13113g1M11296S = m11296S(function1, z2);
                    }
                    if (f27846j.compareAndSet(this, objM11292M, abstractC13113g1M11296S)) {
                        return abstractC13113g1M11296S;
                    }
                } else {
                    C13131m1 c13131m1 = new C13131m1();
                    Object c13166y0 = c13131m1;
                    if (!c13139p0.f27881j) {
                        c13166y0 = new C13166y0(c13131m1);
                    }
                    f27846j.compareAndSet(this, c13139p0, c13166y0);
                }
            } else {
                if (!(objM11292M instanceof InterfaceC13169z0)) {
                    if (z3) {
                        if (!(objM11292M instanceof C13159w)) {
                            objM11292M = null;
                        }
                        C13159w c13159w = (C13159w) objM11292M;
                        function1.invoke(c13159w != null ? c13159w.f27913b : null);
                    }
                    return C13137o1.f27880j;
                }
                C13131m1 list = ((InterfaceC13169z0) objM11292M).getList();
                if (list == null) {
                    Objects.requireNonNull(objM11292M, "null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
                    m11299Y((AbstractC13113g1) objM11292M);
                } else {
                    InterfaceC13130m0 interfaceC13130m0 = C13137o1.f27880j;
                    if (z2 && (objM11292M instanceof b)) {
                        synchronized (objM11292M) {
                            th = (Throwable) ((b) objM11292M)._rootCause;
                            if (th == null || ((function1 instanceof C13141q) && ((b) objM11292M)._isCompleting == 0)) {
                                if (abstractC13113g1M11296S == null) {
                                    abstractC13113g1M11296S = m11296S(function1, z2);
                                }
                                if (m11305t(objM11292M, list, abstractC13113g1M11296S)) {
                                    if (th == null) {
                                        return abstractC13113g1M11296S;
                                    }
                                    interfaceC13130m0 = abstractC13113g1M11296S;
                                }
                            }
                        }
                        if (th != null) {
                            if (z3) {
                                function1.invoke(th);
                            }
                            return interfaceC13130m0;
                        }
                        if (abstractC13113g1M11296S == null) {
                            abstractC13113g1M11296S = m11296S(function1, z2);
                        }
                        if (m11305t(objM11292M, list, abstractC13113g1M11296S)) {
                            return abstractC13113g1M11296S;
                        }
                    } else {
                        th = null;
                        if (th != null) {
                            if (z3) {
                                function1.invoke(th);
                            }
                            return interfaceC13130m0;
                        }
                        if (abstractC13113g1M11296S == null) {
                            abstractC13113g1M11296S = m11296S(function1, z2);
                        }
                        if (m11305t(objM11292M, list, abstractC13113g1M11296S)) {
                            return abstractC13113g1M11296S;
                        }
                    }
                }
            }
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.C12790a.plus(this, coroutineContext);
    }

    @Override // kotlinx.coroutines.Job
    /* JADX INFO: renamed from: q */
    public final CancellationException mo10914q() {
        Object objM11292M = m11292M();
        if (objM11292M instanceof b) {
            Throwable th = (Throwable) ((b) objM11292M)._rootCause;
            if (th != null) {
                return m11301a0(th, getClass().getSimpleName() + " is cancelling");
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (objM11292M instanceof InterfaceC13169z0) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (objM11292M instanceof C13159w) {
            return m11284b0(this, ((C13159w) objM11292M).f27913b, null, 1, null);
        }
        return new JobCancellationException(getClass().getSimpleName() + " has completed normally", null, this);
    }

    @Override // p659s.p660a.InterfaceC13144r
    /* JADX INFO: renamed from: s */
    public final void mo11304s(InterfaceC13143q1 interfaceC13143q1) throws Throwable {
        m11306w(interfaceC13143q1);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0039  */
    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        byte b2;
        do {
            Object objM11292M = m11292M();
            b2 = -1;
            if (objM11292M instanceof C13139p0) {
                if (((C13139p0) objM11292M).f27881j) {
                    b2 = 0;
                } else if (f27846j.compareAndSet(this, objM11292M, C13119i1.f27863g)) {
                    mo11186X();
                    b2 = 1;
                }
            } else if (!(objM11292M instanceof C13166y0)) {
                b2 = 0;
            } else if (f27846j.compareAndSet(this, objM11292M, ((C13166y0) objM11292M).f27921j)) {
                mo11186X();
                b2 = 1;
            }
            if (b2 == 0) {
                return false;
            }
        } while (b2 != 1);
        return true;
    }

    /* JADX INFO: renamed from: t */
    public final boolean m11305t(Object obj, C13131m1 c13131m1, AbstractC13113g1<?> abstractC13113g1) {
        int iM11160p;
        c cVar = new c(abstractC13113g1, abstractC13113g1, this, obj);
        do {
            iM11160p = c13131m1.m11157k().m11160p(abstractC13113g1, c13131m1, cVar);
            if (iM11160p == 1) {
                return true;
            }
        } while (iM11160p != 2);
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo11184T() + '{' + m11300Z(m11292M()) + '}');
        sb.append(MentionUtilsKt.MENTIONS_CHAR);
        sb.append(C3404f.m4312l0(this));
        return sb.toString();
    }

    @Override // kotlinx.coroutines.Job
    /* JADX INFO: renamed from: u */
    public final InterfaceC13130m0 mo10915u(Function1<? super Throwable, Unit> function1) {
        return mo10913n(false, true, function1);
    }

    /* JADX INFO: renamed from: v */
    public void mo11173v(Object obj) {
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00b6  */
    /* JADX INFO: renamed from: w */
    public final boolean m11306w(Object obj) throws Throwable {
        C13037t c13037t;
        boolean z2;
        Object objM11302c0 = C13119i1.f27857a;
        if (mo11280K()) {
            do {
                Object objM11292M = m11292M();
                if (!(objM11292M instanceof InterfaceC13169z0) || ((objM11292M instanceof b) && ((b) objM11292M)._isCompleting != 0)) {
                    objM11302c0 = C13119i1.f27857a;
                    break;
                }
                objM11302c0 = m11302c0(objM11292M, new C13159w(m11288G(obj), false, 2));
            } while (objM11302c0 == C13119i1.f27859c);
            if (objM11302c0 == C13119i1.f27858b) {
                return true;
            }
        }
        if (objM11302c0 == C13119i1.f27857a) {
            Throwable thM11288G = null;
            while (true) {
                Object objM11292M2 = m11292M();
                if (objM11292M2 instanceof b) {
                    synchronized (objM11292M2) {
                        if (((b) objM11292M2).m11312e()) {
                            c13037t = C13119i1.f27860d;
                        } else {
                            boolean zM11311d = ((b) objM11292M2).m11311d();
                            if (obj != null || !zM11311d) {
                                if (thM11288G == null) {
                                    thM11288G = m11288G(obj);
                                }
                                ((b) objM11292M2).m11309b(thM11288G);
                            }
                            Throwable th = zM11311d ^ true ? (Throwable) ((b) objM11292M2)._rootCause : null;
                            if (th != null) {
                                m11298V(((b) objM11292M2).f27851j, th);
                            }
                            c13037t = C13119i1.f27857a;
                        }
                    }
                } else if (objM11292M2 instanceof InterfaceC13169z0) {
                    if (thM11288G == null) {
                        thM11288G = m11288G(obj);
                    }
                    InterfaceC13169z0 interfaceC13169z0 = (InterfaceC13169z0) objM11292M2;
                    if (interfaceC13169z0.mo11281a()) {
                        C13131m1 c13131m1M11291L = m11291L(interfaceC13169z0);
                        if (c13131m1M11291L != null) {
                            if (f27846j.compareAndSet(this, interfaceC13169z0, new b(c13131m1M11291L, false, thM11288G))) {
                                m11298V(c13131m1M11291L, thM11288G);
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            c13037t = C13119i1.f27857a;
                        }
                    } else {
                        Object objM11302c1 = m11302c0(objM11292M2, new C13159w(thM11288G, false, 2));
                        if (objM11302c1 == C13119i1.f27857a) {
                            throw new IllegalStateException(C1643a.m881v("Cannot happen in ", objM11292M2).toString());
                        }
                        if (objM11302c1 != C13119i1.f27859c) {
                            objM11302c0 = objM11302c1;
                            break;
                        }
                    }
                } else {
                    c13037t = C13119i1.f27860d;
                }
                objM11302c0 = c13037t;
                break;
            }
        }
        if (objM11302c0 != C13119i1.f27857a && objM11302c0 != C13119i1.f27858b) {
            if (objM11302c0 == C13119i1.f27860d) {
                return false;
            }
            mo11173v(objM11302c0);
        }
        return true;
    }

    /* JADX INFO: renamed from: x */
    public void m11307x(Throwable th) throws Throwable {
        m11306w(th);
    }

    /* JADX INFO: renamed from: z */
    public final boolean m11308z(Throwable th) {
        if (mo11171Q()) {
            return true;
        }
        boolean z2 = th instanceof CancellationException;
        InterfaceC13138p interfaceC13138p = (InterfaceC13138p) this._parentHandle;
        if (interfaceC13138p == null || interfaceC13138p == C13137o1.f27880j) {
            return z2;
        }
        return interfaceC13138p.mo11333h(th) || z2;
    }
}

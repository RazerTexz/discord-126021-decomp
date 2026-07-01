package s.a.a;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import s.a.ThreadContextElement;

/* JADX INFO: renamed from: s.a.a.a, reason: use source file name */
/* JADX INFO: compiled from: ThreadContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ThreadContext {
    public static final Symbol3 a = new Symbol3("ZERO");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Function2<Object, CoroutineContext.Element, Object> f3825b = b.j;
    public static final Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> c = c.j;
    public static final Function2<ThreadContext2, CoroutineContext.Element, ThreadContext2> d = a.k;
    public static final Function2<ThreadContext2, CoroutineContext.Element, ThreadContext2> e = a.j;

    /* JADX INFO: renamed from: s.a.a.a$a */
    /* JADX INFO: compiled from: kotlin-style lambda group */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class a extends Lambda implements Function2<ThreadContext2, CoroutineContext.Element, ThreadContext2> {
        public static final a j = new a(0);
        public static final a k = new a(1);
        public final /* synthetic */ int l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(2);
            this.l = i;
        }

        @Override // kotlin.jvm.functions.Function2
        public final ThreadContext2 invoke(ThreadContext2 threadContext2, CoroutineContext.Element element) {
            int i = this.l;
            if (i == 0) {
                ThreadContext2 threadContext3 = threadContext2;
                CoroutineContext.Element element2 = element;
                if (element2 instanceof ThreadContextElement) {
                    CoroutineContext coroutineContext = threadContext3.c;
                    Object[] objArr = threadContext3.a;
                    int i2 = threadContext3.f3832b;
                    threadContext3.f3832b = i2 + 1;
                    ((ThreadContextElement) element2).y(coroutineContext, objArr[i2]);
                }
                return threadContext3;
            }
            if (i != 1) {
                throw null;
            }
            ThreadContext2 threadContext4 = threadContext2;
            CoroutineContext.Element element3 = element;
            if (element3 instanceof ThreadContextElement) {
                Object objC = ((ThreadContextElement) element3).C(threadContext4.c);
                Object[] objArr2 = threadContext4.a;
                int i3 = threadContext4.f3832b;
                threadContext4.f3832b = i3 + 1;
                objArr2[i3] = objC;
            }
            return threadContext4;
        }
    }

    /* JADX INFO: renamed from: s.a.a.a$b */
    /* JADX INFO: compiled from: ThreadContext.kt */
    public static final class b extends Lambda implements Function2<Object, CoroutineContext.Element, Object> {
        public static final b j = new b();

        public b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(Object obj, CoroutineContext.Element element) {
            CoroutineContext.Element element2 = element;
            if (!(element2 instanceof ThreadContextElement)) {
                return obj;
            }
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? element2 : Integer.valueOf(iIntValue + 1);
        }
    }

    /* JADX INFO: renamed from: s.a.a.a$c */
    /* JADX INFO: compiled from: ThreadContext.kt */
    public static final class c extends Lambda implements Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> {
        public static final c j = new c();

        public c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public ThreadContextElement<?> invoke(ThreadContextElement<?> threadContextElement, CoroutineContext.Element element) {
            ThreadContextElement<?> threadContextElement2 = threadContextElement;
            CoroutineContext.Element element2 = element;
            if (threadContextElement2 != null) {
                return threadContextElement2;
            }
            if (!(element2 instanceof ThreadContextElement)) {
                element2 = null;
            }
            return (ThreadContextElement) element2;
        }
    }

    public static final void a(CoroutineContext coroutineContext, Object obj) {
        if (obj == a) {
            return;
        }
        if (obj instanceof ThreadContext2) {
            ((ThreadContext2) obj).f3832b = 0;
            coroutineContext.fold(obj, e);
        } else {
            Object objFold = coroutineContext.fold(null, c);
            Objects.requireNonNull(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((ThreadContextElement) objFold).y(coroutineContext, obj);
        }
    }

    public static final Object b(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = coroutineContext.fold(0, f3825b);
            Intrinsics3.checkNotNull(obj);
        }
        if (obj == 0) {
            return a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new ThreadContext2(coroutineContext, ((Number) obj).intValue()), d);
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((ThreadContextElement) obj).C(coroutineContext);
    }
}

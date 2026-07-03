package p659s.p660a.p661a;

import java.util.Objects;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.InterfaceC13158v1;

/* JADX INFO: renamed from: s.a.a.a */
/* JADX INFO: compiled from: ThreadContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13018a {

    /* JADX INFO: renamed from: a */
    public static final C13037t f27658a = new C13037t("ZERO");

    /* JADX INFO: renamed from: b */
    public static final Function2<Object, CoroutineContext.Element, Object> f27659b = b.f27666j;

    /* JADX INFO: renamed from: c */
    public static final Function2<InterfaceC13158v1<?>, CoroutineContext.Element, InterfaceC13158v1<?>> f27660c = c.f27667j;

    /* JADX INFO: renamed from: d */
    public static final Function2<C13041x, CoroutineContext.Element, C13041x> f27661d = a.f27664k;

    /* JADX INFO: renamed from: e */
    public static final Function2<C13041x, CoroutineContext.Element, C13041x> f27662e = a.f27663j;

    /* JADX INFO: renamed from: s.a.a.a$a */
    /* JADX INFO: compiled from: kotlin-style lambda group */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class a extends AbstractC12240o implements Function2<C13041x, CoroutineContext.Element, C13041x> {

        /* JADX INFO: renamed from: j */
        public static final a f27663j = new a(0);

        /* JADX INFO: renamed from: k */
        public static final a f27664k = new a(1);

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ int f27665l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(2);
            this.f27665l = i;
        }

        @Override // kotlin.jvm.functions.Function2
        public final C13041x invoke(C13041x c13041x, CoroutineContext.Element element) {
            int i = this.f27665l;
            if (i == 0) {
                C13041x c13041x2 = c13041x;
                CoroutineContext.Element element2 = element;
                if (element2 instanceof InterfaceC13158v1) {
                    CoroutineContext coroutineContext = c13041x2.f27710c;
                    Object[] objArr = c13041x2.f27708a;
                    int i2 = c13041x2.f27709b;
                    c13041x2.f27709b = i2 + 1;
                    ((InterfaceC13158v1) element2).m11352y(coroutineContext, objArr[i2]);
                }
                return c13041x2;
            }
            if (i != 1) {
                throw null;
            }
            C13041x c13041x3 = c13041x;
            CoroutineContext.Element element3 = element;
            if (element3 instanceof InterfaceC13158v1) {
                Object objM11351C = ((InterfaceC13158v1) element3).m11351C(c13041x3.f27710c);
                Object[] objArr2 = c13041x3.f27708a;
                int i3 = c13041x3.f27709b;
                c13041x3.f27709b = i3 + 1;
                objArr2[i3] = objM11351C;
            }
            return c13041x3;
        }
    }

    /* JADX INFO: renamed from: s.a.a.a$b */
    /* JADX INFO: compiled from: ThreadContext.kt */
    public static final class b extends AbstractC12240o implements Function2<Object, CoroutineContext.Element, Object> {

        /* JADX INFO: renamed from: j */
        public static final b f27666j = new b();

        public b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(Object obj, CoroutineContext.Element element) {
            CoroutineContext.Element element2 = element;
            if (!(element2 instanceof InterfaceC13158v1)) {
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
    public static final class c extends AbstractC12240o implements Function2<InterfaceC13158v1<?>, CoroutineContext.Element, InterfaceC13158v1<?>> {

        /* JADX INFO: renamed from: j */
        public static final c f27667j = new c();

        public c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public InterfaceC13158v1<?> invoke(InterfaceC13158v1<?> interfaceC13158v1, CoroutineContext.Element element) {
            InterfaceC13158v1<?> interfaceC13158v2 = interfaceC13158v1;
            CoroutineContext.Element element2 = element;
            if (interfaceC13158v2 != null) {
                return interfaceC13158v2;
            }
            if (!(element2 instanceof InterfaceC13158v1)) {
                element2 = null;
            }
            return (InterfaceC13158v1) element2;
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m11140a(CoroutineContext coroutineContext, Object obj) {
        if (obj == f27658a) {
            return;
        }
        if (obj instanceof C13041x) {
            ((C13041x) obj).f27709b = 0;
            coroutineContext.fold(obj, f27662e);
        } else {
            Object objFold = coroutineContext.fold(null, f27660c);
            Objects.requireNonNull(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((InterfaceC13158v1) objFold).m11352y(coroutineContext, obj);
        }
    }

    /* JADX INFO: renamed from: b */
    public static final Object m11141b(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = coroutineContext.fold(0, f27659b);
            C12238m.checkNotNull(obj);
        }
        if (obj == 0) {
            return f27658a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new C13041x(coroutineContext, ((Number) obj).intValue()), f27661d);
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((InterfaceC13158v1) obj).m11351C(coroutineContext);
    }
}

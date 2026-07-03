package p507d0.p584w;

import java.io.Serializable;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.w.c */
/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12176c implements CoroutineContext, Serializable {
    private final CoroutineContext.Element element;
    private final CoroutineContext left;

    /* JADX INFO: renamed from: d0.w.c$a */
    /* JADX INFO: compiled from: CoroutineContextImpl.kt */
    public static final class a implements Serializable {
        private static final long serialVersionUID = 0;
        private final CoroutineContext[] elements;

        /* JADX INFO: renamed from: d0.w.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CoroutineContextImpl.kt */
        public static final class C13343a {
            public C13343a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        static {
            new C13343a(null);
        }

        public a(CoroutineContext[] coroutineContextArr) {
            C12238m.checkNotNullParameter(coroutineContextArr, "elements");
            this.elements = coroutineContextArr;
        }

        private final Object readResolve() {
            CoroutineContext[] coroutineContextArr = this.elements;
            CoroutineContext coroutineContextPlus = C12179f.f25237j;
            for (CoroutineContext coroutineContext : coroutineContextArr) {
                coroutineContextPlus = coroutineContextPlus.plus(coroutineContext);
            }
            return coroutineContextPlus;
        }
    }

    /* JADX INFO: renamed from: d0.w.c$b */
    /* JADX INFO: compiled from: CoroutineContextImpl.kt */
    public static final class b extends AbstractC12240o implements Function2<String, CoroutineContext.Element, String> {

        /* JADX INFO: renamed from: j */
        public static final b f25234j = new b();

        public b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final String invoke(String str, CoroutineContext.Element element) {
            C12238m.checkNotNullParameter(str, "acc");
            C12238m.checkNotNullParameter(element, "element");
            if (str.length() == 0) {
                return element.toString();
            }
            return str + ", " + element;
        }
    }

    /* JADX INFO: renamed from: d0.w.c$c */
    /* JADX INFO: compiled from: CoroutineContextImpl.kt */
    public static final class c extends AbstractC12240o implements Function2<Unit, CoroutineContext.Element, Unit> {
        public final /* synthetic */ CoroutineContext[] $elements;
        public final /* synthetic */ Ref$IntRef $index;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CoroutineContext[] coroutineContextArr, Ref$IntRef ref$IntRef) {
            super(2);
            this.$elements = coroutineContextArr;
            this.$index = ref$IntRef;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit, CoroutineContext.Element element) {
            invoke2(unit, element);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit, CoroutineContext.Element element) {
            C12238m.checkNotNullParameter(unit, "<anonymous parameter 0>");
            C12238m.checkNotNullParameter(element, "element");
            CoroutineContext[] coroutineContextArr = this.$elements;
            Ref$IntRef ref$IntRef = this.$index;
            int i = ref$IntRef.element;
            ref$IntRef.element = i + 1;
            coroutineContextArr[i] = element;
        }
    }

    public C12176c(CoroutineContext coroutineContext, CoroutineContext.Element element) {
        C12238m.checkNotNullParameter(coroutineContext, "left");
        C12238m.checkNotNullParameter(element, "element");
        this.left = coroutineContext;
        this.element = element;
    }

    private final Object writeReplace() {
        int iM10083c = m10083c();
        CoroutineContext[] coroutineContextArr = new CoroutineContext[iM10083c];
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = 0;
        fold(Unit.f27425a, new c(coroutineContextArr, ref$IntRef));
        if (ref$IntRef.element == iM10083c) {
            return new a(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX INFO: renamed from: c */
    public final int m10083c() {
        int i = 2;
        C12176c c12176c = this;
        while (true) {
            CoroutineContext coroutineContext = c12176c.left;
            if (!(coroutineContext instanceof C12176c)) {
                coroutineContext = null;
            }
            c12176c = (C12176c) coroutineContext;
            if (c12176c == null) {
                return i;
            }
            i++;
        }
    }

    public boolean equals(Object obj) {
        boolean zAreEqual;
        if (this != obj) {
            if (!(obj instanceof C12176c)) {
                return false;
            }
            C12176c c12176c = (C12176c) obj;
            if (c12176c.m10083c() != m10083c()) {
                return false;
            }
            Objects.requireNonNull(c12176c);
            C12176c c12176c2 = this;
            while (true) {
                CoroutineContext.Element element = c12176c2.element;
                if (!C12238m.areEqual(c12176c.get(element.getKey()), element)) {
                    zAreEqual = false;
                    break;
                }
                CoroutineContext coroutineContext = c12176c2.left;
                if (!(coroutineContext instanceof C12176c)) {
                    Objects.requireNonNull(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                    CoroutineContext.Element element2 = (CoroutineContext.Element) coroutineContext;
                    zAreEqual = C12238m.areEqual(c12176c.get(element2.getKey()), element2);
                    break;
                }
                c12176c2 = (C12176c) coroutineContext;
            }
            if (!zAreEqual) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        C12238m.checkNotNullParameter(function2, "operation");
        return function2.invoke((Object) this.left.fold(r, function2), this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        C12238m.checkNotNullParameter(key, "key");
        C12176c c12176c = this;
        while (true) {
            E e = (E) c12176c.element.get(key);
            if (e != null) {
                return e;
            }
            CoroutineContext coroutineContext = c12176c.left;
            if (!(coroutineContext instanceof C12176c)) {
                return (E) coroutineContext.get(key);
            }
            c12176c = (C12176c) coroutineContext;
        }
    }

    public int hashCode() {
        return this.element.hashCode() + this.left.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        C12238m.checkNotNullParameter(key, "key");
        if (this.element.get(key) != null) {
            return this.left;
        }
        CoroutineContext coroutineContextMinusKey = this.left.minusKey(key);
        if (coroutineContextMinusKey == this.left) {
            return this;
        }
        return coroutineContextMinusKey == C12179f.f25237j ? this.element : new C12176c(coroutineContextMinusKey, this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        C12238m.checkNotNullParameter(coroutineContext, "context");
        return CoroutineContext.C12791a.plus(this, coroutineContext);
    }

    public String toString() {
        return C1643a.m822J(C1643a.m833U("["), (String) fold("", b.f25234j), "]");
    }
}

package d0.w;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: renamed from: d0.w.c, reason: use source file name */
/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CoroutineContextImpl3 implements CoroutineContext, Serializable {
    private final CoroutineContext.Element element;
    private final CoroutineContext left;

    /* JADX INFO: renamed from: d0.w.c$a */
    /* JADX INFO: compiled from: CoroutineContextImpl.kt */
    public static final class a implements Serializable {
        private static final long serialVersionUID = 0;
        private final CoroutineContext[] elements;

        /* JADX INFO: renamed from: d0.w.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CoroutineContextImpl.kt */
        public static final class C0421a {
            public C0421a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        static {
            new C0421a(null);
        }

        public a(CoroutineContext[] coroutineContextArr) {
            Intrinsics3.checkNotNullParameter(coroutineContextArr, "elements");
            this.elements = coroutineContextArr;
        }

        private final Object readResolve() {
            CoroutineContext[] coroutineContextArr = this.elements;
            CoroutineContext coroutineContextPlus = CoroutineContextImpl4.j;
            for (CoroutineContext coroutineContext : coroutineContextArr) {
                coroutineContextPlus = coroutineContextPlus.plus(coroutineContext);
            }
            return coroutineContextPlus;
        }
    }

    /* JADX INFO: renamed from: d0.w.c$b */
    /* JADX INFO: compiled from: CoroutineContextImpl.kt */
    public static final class b extends Lambda implements Function2<String, CoroutineContext.Element, String> {
        public static final b j = new b();

        public b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final String invoke(String str, CoroutineContext.Element element) {
            Intrinsics3.checkNotNullParameter(str, "acc");
            Intrinsics3.checkNotNullParameter(element, "element");
            if (str.length() == 0) {
                return element.toString();
            }
            return str + ", " + element;
        }
    }

    /* JADX INFO: renamed from: d0.w.c$c */
    /* JADX INFO: compiled from: CoroutineContextImpl.kt */
    public static final class c extends Lambda implements Function2<Unit, CoroutineContext.Element, Unit> {
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
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit, CoroutineContext.Element element) {
            Intrinsics3.checkNotNullParameter(unit, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(element, "element");
            CoroutineContext[] coroutineContextArr = this.$elements;
            Ref$IntRef ref$IntRef = this.$index;
            int i = ref$IntRef.element;
            ref$IntRef.element = i + 1;
            coroutineContextArr[i] = element;
        }
    }

    public CoroutineContextImpl3(CoroutineContext coroutineContext, CoroutineContext.Element element) {
        Intrinsics3.checkNotNullParameter(coroutineContext, "left");
        Intrinsics3.checkNotNullParameter(element, "element");
        this.left = coroutineContext;
        this.element = element;
    }

    private final Object writeReplace() {
        int iC = c();
        CoroutineContext[] coroutineContextArr = new CoroutineContext[iC];
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = 0;
        fold(Unit.a, new c(coroutineContextArr, ref$IntRef));
        if (ref$IntRef.element == iC) {
            return new a(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final int c() {
        int i = 2;
        CoroutineContextImpl3 coroutineContextImpl3 = this;
        while (true) {
            CoroutineContext coroutineContext = coroutineContextImpl3.left;
            if (!(coroutineContext instanceof CoroutineContextImpl3)) {
                coroutineContext = null;
            }
            coroutineContextImpl3 = (CoroutineContextImpl3) coroutineContext;
            if (coroutineContextImpl3 == null) {
                return i;
            }
            i++;
        }
    }

    public boolean equals(Object obj) {
        boolean zAreEqual;
        if (this != obj) {
            if (!(obj instanceof CoroutineContextImpl3)) {
                return false;
            }
            CoroutineContextImpl3 coroutineContextImpl3 = (CoroutineContextImpl3) obj;
            if (coroutineContextImpl3.c() != c()) {
                return false;
            }
            Objects.requireNonNull(coroutineContextImpl3);
            CoroutineContextImpl3 coroutineContextImpl4 = this;
            while (true) {
                CoroutineContext.Element element = coroutineContextImpl4.element;
                if (!Intrinsics3.areEqual(coroutineContextImpl3.get(element.getKey()), element)) {
                    zAreEqual = false;
                    break;
                }
                CoroutineContext coroutineContext = coroutineContextImpl4.left;
                if (!(coroutineContext instanceof CoroutineContextImpl3)) {
                    Objects.requireNonNull(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                    CoroutineContext.Element element2 = (CoroutineContext.Element) coroutineContext;
                    zAreEqual = Intrinsics3.areEqual(coroutineContextImpl3.get(element2.getKey()), element2);
                    break;
                }
                coroutineContextImpl4 = (CoroutineContextImpl3) coroutineContext;
            }
            if (!zAreEqual) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics3.checkNotNullParameter(function2, "operation");
        return function2.invoke((Object) this.left.fold(r, function2), this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics3.checkNotNullParameter(key, "key");
        CoroutineContextImpl3 coroutineContextImpl3 = this;
        while (true) {
            E e = (E) coroutineContextImpl3.element.get(key);
            if (e != null) {
                return e;
            }
            CoroutineContext coroutineContext = coroutineContextImpl3.left;
            if (!(coroutineContext instanceof CoroutineContextImpl3)) {
                return (E) coroutineContext.get(key);
            }
            coroutineContextImpl3 = (CoroutineContextImpl3) coroutineContext;
        }
    }

    public int hashCode() {
        return this.element.hashCode() + this.left.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics3.checkNotNullParameter(key, "key");
        if (this.element.get(key) != null) {
            return this.left;
        }
        CoroutineContext coroutineContextMinusKey = this.left.minusKey(key);
        if (coroutineContextMinusKey == this.left) {
            return this;
        }
        return coroutineContextMinusKey == CoroutineContextImpl4.j ? this.element : new CoroutineContextImpl3(coroutineContextMinusKey, this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        Intrinsics3.checkNotNullParameter(coroutineContext, "context");
        return CoroutineContext.a.plus(this, coroutineContext);
    }

    public String toString() {
        return outline.J(outline.U("["), (String) fold("", b.j), "]");
    }
}

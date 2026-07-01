package d0.w;

import d0.z.d.m;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext$a;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements CoroutineContext, Serializable {
    private final CoroutineContext$Element element;
    private final CoroutineContext left;

    public c(CoroutineContext coroutineContext, CoroutineContext$Element coroutineContext$Element) {
        m.checkNotNullParameter(coroutineContext, "left");
        m.checkNotNullParameter(coroutineContext$Element, "element");
        this.left = coroutineContext;
        this.element = coroutineContext$Element;
    }

    private final Object writeReplace() {
        int iC = c();
        CoroutineContext[] coroutineContextArr = new CoroutineContext[iC];
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = 0;
        fold(Unit.a, new c$c(coroutineContextArr, ref$IntRef));
        if (ref$IntRef.element == iC) {
            return new c$a(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final int c() {
        int i = 2;
        c cVar = this;
        while (true) {
            CoroutineContext coroutineContext = cVar.left;
            if (!(coroutineContext instanceof c)) {
                coroutineContext = null;
            }
            cVar = (c) coroutineContext;
            if (cVar == null) {
                return i;
            }
            i++;
        }
    }

    public boolean equals(Object obj) {
        boolean zAreEqual;
        if (this != obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (cVar.c() != c()) {
                return false;
            }
            Objects.requireNonNull(cVar);
            c cVar2 = this;
            while (true) {
                CoroutineContext$Element coroutineContext$Element = cVar2.element;
                if (!m.areEqual(cVar.get(coroutineContext$Element.getKey()), coroutineContext$Element)) {
                    zAreEqual = false;
                    break;
                }
                CoroutineContext coroutineContext = cVar2.left;
                if (!(coroutineContext instanceof c)) {
                    Objects.requireNonNull(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                    CoroutineContext$Element coroutineContext$Element2 = (CoroutineContext$Element) coroutineContext;
                    zAreEqual = m.areEqual(cVar.get(coroutineContext$Element2.getKey()), coroutineContext$Element2);
                    break;
                }
                cVar2 = (c) coroutineContext;
            }
            if (!zAreEqual) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext$Element, ? extends R> function2) {
        m.checkNotNullParameter(function2, "operation");
        return function2.invoke((Object) this.left.fold(r, function2), this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext$Element> E get(CoroutineContext$Key<E> coroutineContext$Key) {
        m.checkNotNullParameter(coroutineContext$Key, "key");
        c cVar = this;
        while (true) {
            E e = (E) cVar.element.get(coroutineContext$Key);
            if (e != null) {
                return e;
            }
            CoroutineContext coroutineContext = cVar.left;
            if (!(coroutineContext instanceof c)) {
                return (E) coroutineContext.get(coroutineContext$Key);
            }
            cVar = (c) coroutineContext;
        }
    }

    public int hashCode() {
        return this.element.hashCode() + this.left.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext$Key<?> coroutineContext$Key) {
        m.checkNotNullParameter(coroutineContext$Key, "key");
        if (this.element.get(coroutineContext$Key) != null) {
            return this.left;
        }
        CoroutineContext coroutineContextMinusKey = this.left.minusKey(coroutineContext$Key);
        if (coroutineContextMinusKey == this.left) {
            return this;
        }
        return coroutineContextMinusKey == f.j ? this.element : new c(coroutineContextMinusKey, this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        m.checkNotNullParameter(coroutineContext, "context");
        return CoroutineContext$a.plus(this, coroutineContext);
    }

    public String toString() {
        return b.d.b.a.a.J(b.d.b.a.a.U("["), (String) fold("", c$b.j), "]");
    }
}

package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.functions.Function2;
import p507d0.p584w.C12176c;
import p507d0.p584w.C12179f;
import p507d0.p584w.InterfaceC12177d;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface CoroutineContext {

    /* JADX INFO: compiled from: CoroutineContext.kt */
    public interface Element extends CoroutineContext {

        /* JADX INFO: renamed from: kotlin.coroutines.CoroutineContext$Element$a */
        /* JADX INFO: compiled from: CoroutineContext.kt */
        public static final class C12790a {
            public static <R> R fold(Element element, R r, Function2<? super R, ? super Element, ? extends R> function2) {
                C12238m.checkNotNullParameter(function2, "operation");
                return function2.invoke(r, element);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends Element> E get(Element element, Key<E> key) {
                C12238m.checkNotNullParameter(key, "key");
                if (C12238m.areEqual(element.getKey(), key)) {
                    return element;
                }
                return null;
            }

            public static CoroutineContext minusKey(Element element, Key<?> key) {
                C12238m.checkNotNullParameter(key, "key");
                return C12238m.areEqual(element.getKey(), key) ? C12179f.f25237j : element;
            }

            public static CoroutineContext plus(Element element, CoroutineContext coroutineContext) {
                C12238m.checkNotNullParameter(coroutineContext, "context");
                return C12791a.plus(element, coroutineContext);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        <E extends Element> E get(Key<E> key);

        Key<?> getKey();
    }

    /* JADX INFO: compiled from: CoroutineContext.kt */
    public interface Key<E extends Element> {
    }

    /* JADX INFO: renamed from: kotlin.coroutines.CoroutineContext$a */
    /* JADX INFO: compiled from: CoroutineContext.kt */
    public static final class C12791a {

        /* JADX INFO: renamed from: kotlin.coroutines.CoroutineContext$a$a */
        /* JADX INFO: compiled from: CoroutineContext.kt */
        public static final class a extends AbstractC12240o implements Function2<CoroutineContext, Element, CoroutineContext> {

            /* JADX INFO: renamed from: j */
            public static final a f27431j = new a();

            public a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final CoroutineContext invoke(CoroutineContext coroutineContext, Element element) {
                C12176c c12176c;
                C12238m.checkNotNullParameter(coroutineContext, "acc");
                C12238m.checkNotNullParameter(element, "element");
                CoroutineContext coroutineContextMinusKey = coroutineContext.minusKey(element.getKey());
                C12179f c12179f = C12179f.f25237j;
                if (coroutineContextMinusKey == c12179f) {
                    return element;
                }
                int i = InterfaceC12177d.f25235e;
                InterfaceC12177d.b bVar = InterfaceC12177d.b.f25236a;
                InterfaceC12177d interfaceC12177d = (InterfaceC12177d) coroutineContextMinusKey.get(bVar);
                if (interfaceC12177d == null) {
                    c12176c = new C12176c(coroutineContextMinusKey, element);
                } else {
                    CoroutineContext coroutineContextMinusKey2 = coroutineContextMinusKey.minusKey(bVar);
                    if (coroutineContextMinusKey2 == c12179f) {
                        return new C12176c(element, interfaceC12177d);
                    }
                    c12176c = new C12176c(new C12176c(coroutineContextMinusKey2, element), interfaceC12177d);
                }
                return c12176c;
            }
        }

        public static CoroutineContext plus(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
            C12238m.checkNotNullParameter(coroutineContext2, "context");
            return coroutineContext2 == C12179f.f25237j ? coroutineContext : (CoroutineContext) coroutineContext2.fold(coroutineContext, a.f27431j);
        }
    }

    <R> R fold(R initial, Function2<? super R, ? super Element, ? extends R> operation);

    <E extends Element> E get(Key<E> key);

    CoroutineContext minusKey(Key<?> key);

    CoroutineContext plus(CoroutineContext context);
}

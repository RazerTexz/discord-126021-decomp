package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import d0.w.ContinuationInterceptor;
import d0.w.CoroutineContextImpl3;
import d0.w.CoroutineContextImpl4;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface CoroutineContext {

    /* JADX INFO: compiled from: CoroutineContext.kt */
    public interface Element extends CoroutineContext {

        /* JADX INFO: compiled from: CoroutineContext.kt */
        public static final class a {
            public static <R> R fold(Element element, R r, Function2<? super R, ? super Element, ? extends R> function2) {
                Intrinsics3.checkNotNullParameter(function2, "operation");
                return function2.invoke(r, element);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends Element> E get(Element element, Key<E> key) {
                Intrinsics3.checkNotNullParameter(key, "key");
                if (Intrinsics3.areEqual(element.getKey(), key)) {
                    return element;
                }
                return null;
            }

            public static CoroutineContext minusKey(Element element, Key<?> key) {
                Intrinsics3.checkNotNullParameter(key, "key");
                return Intrinsics3.areEqual(element.getKey(), key) ? CoroutineContextImpl4.j : element;
            }

            public static CoroutineContext plus(Element element, CoroutineContext coroutineContext) {
                Intrinsics3.checkNotNullParameter(coroutineContext, "context");
                return a.plus(element, coroutineContext);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        <E extends Element> E get(Key<E> key);

        Key<?> getKey();
    }

    /* JADX INFO: compiled from: CoroutineContext.kt */
    public interface Key<E extends Element> {
    }

    /* JADX INFO: compiled from: CoroutineContext.kt */
    public static final class a {

        /* JADX INFO: renamed from: kotlin.coroutines.CoroutineContext$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CoroutineContext.kt */
        public static final class C0433a extends Lambda implements Function2<CoroutineContext, Element, CoroutineContext> {
            public static final C0433a j = new C0433a();

            public C0433a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final CoroutineContext invoke(CoroutineContext coroutineContext, Element element) {
                CoroutineContextImpl3 coroutineContextImpl3;
                Intrinsics3.checkNotNullParameter(coroutineContext, "acc");
                Intrinsics3.checkNotNullParameter(element, "element");
                CoroutineContext coroutineContextMinusKey = coroutineContext.minusKey(element.getKey());
                CoroutineContextImpl4 coroutineContextImpl4 = CoroutineContextImpl4.j;
                if (coroutineContextMinusKey == coroutineContextImpl4) {
                    return element;
                }
                int i = ContinuationInterceptor.e;
                ContinuationInterceptor.b bVar = ContinuationInterceptor.b.a;
                ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContextMinusKey.get(bVar);
                if (continuationInterceptor == null) {
                    coroutineContextImpl3 = new CoroutineContextImpl3(coroutineContextMinusKey, element);
                } else {
                    CoroutineContext coroutineContextMinusKey2 = coroutineContextMinusKey.minusKey(bVar);
                    if (coroutineContextMinusKey2 == coroutineContextImpl4) {
                        return new CoroutineContextImpl3(element, continuationInterceptor);
                    }
                    coroutineContextImpl3 = new CoroutineContextImpl3(new CoroutineContextImpl3(coroutineContextMinusKey2, element), continuationInterceptor);
                }
                return coroutineContextImpl3;
            }
        }

        public static CoroutineContext plus(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
            Intrinsics3.checkNotNullParameter(coroutineContext2, "context");
            return coroutineContext2 == CoroutineContextImpl4.j ? coroutineContext : (CoroutineContext) coroutineContext2.fold(coroutineContext, C0433a.j);
        }
    }

    <R> R fold(R initial, Function2<? super R, ? super Element, ? extends R> operation);

    <E extends Element> E get(Key<E> key);

    CoroutineContext minusKey(Key<?> key);

    CoroutineContext plus(CoroutineContext context);
}

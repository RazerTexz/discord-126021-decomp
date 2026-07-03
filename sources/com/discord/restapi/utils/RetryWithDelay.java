package com.discord.restapi.utils;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import okhttp3.Request;
import okhttp3.Response;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import retrofit2.HttpException;

/* JADX INFO: compiled from: RetryWithDelay.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RetryWithDelay {
    public static final RetryWithDelay INSTANCE = new RetryWithDelay();

    /* JADX INFO: renamed from: com.discord.restapi.utils.RetryWithDelay$restRetry$1 */
    /* JADX INFO: compiled from: RetryWithDelay.kt */
    public static final class C55931 extends AbstractC12240o implements Function1<Throwable, Boolean> {
        public static final C55931 INSTANCE = new C55931();

        public C55931() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
            return Boolean.valueOf(invoke2(th));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Throwable th) {
            Response response;
            Request request;
            String str;
            C12238m.checkNotNullParameter(th, "throwable");
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                int iM11055a = httpException.m11055a();
                retrofit2.Response<?> response2 = httpException.f27630j;
                if ((response2 != null && (response = response2.f27631a) != null && (request = response.request) != null && (str = request.method) != null && (!C12238m.areEqual(str, ShareTarget.METHOD_GET))) || iM11055a == 401 || iM11055a == 429 || iM11055a == 503 || iM11055a == 403 || iM11055a == 404) {
                    return false;
                }
            } else if (th instanceof TimeoutException) {
                return false;
            }
            return th instanceof IOException;
        }
    }

    private RetryWithDelay() {
    }

    public static /* synthetic */ Observable restRetry$default(RetryWithDelay retryWithDelay, Observable observable, long j, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 1000;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            num = 3;
        }
        Integer num3 = num;
        if ((i & 4) != 0) {
            num2 = 3;
        }
        return retryWithDelay.restRetry(observable, j2, num3, num2);
    }

    private final Observable<Object> retryWithDelay(Observable<? extends Throwable> observable, long j, Integer num, Integer num2, final Function1<? super Throwable, Boolean> function1) {
        final int iIntValue = num2 != null ? num2.intValue() : Integer.MAX_VALUE;
        final int iIntValue2 = num != null ? num.intValue() : Integer.MAX_VALUE;
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = 0;
        final Ref$IntRef ref$IntRef2 = new Ref$IntRef();
        ref$IntRef2.element = 0;
        final Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.element = j;
        Observable<R> observableM11082A = observable.m11082A(new InterfaceC12589b<Throwable, Observable<? extends Object>>() { // from class: com.discord.restapi.utils.RetryWithDelay.retryWithDelay.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Object> call(Throwable th) {
                Ref$IntRef ref$IntRef3 = ref$IntRef;
                int i = ref$IntRef3.element;
                ref$IntRef3.element = i + 1;
                if (i < iIntValue) {
                    Function1 function2 = function1;
                    C12238m.checkNotNullExpressionValue(th, "it");
                    if (((Boolean) function2.invoke(th)).booleanValue()) {
                        Ref$IntRef ref$IntRef4 = ref$IntRef2;
                        int i2 = ref$IntRef4.element;
                        int i3 = i2 + 1;
                        ref$IntRef4.element = i3;
                        if (i2 < iIntValue2 && i3 > 1) {
                            ref$LongRef.element *= (long) 2;
                        }
                        return Observable.m11068d0(ref$LongRef.element, TimeUnit.MILLISECONDS);
                    }
                }
                return Observable.m11081x(th);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11082A, "flatMap {\n      if (curr…able.error<Any>(it)\n    }");
        return observableM11082A;
    }

    public final <T> Observable<T> restRetry(Observable<T> observable, final long j, final Integer num, final Integer num2) {
        C12238m.checkNotNullParameter(observable, "$this$restRetry");
        C55931 c55931 = C55931.INSTANCE;
        Observable<T> observableM11089O = observable.m11089O(new InterfaceC12589b<Observable<? extends Throwable>, Observable<?>>() { // from class: com.discord.restapi.utils.RetryWithDelay.restRetry.2

            /* JADX INFO: renamed from: com.discord.restapi.utils.RetryWithDelay$restRetry$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: RetryWithDelay.kt */
            public static final /* synthetic */ class AnonymousClass1 extends C12236k implements Function1<Throwable, Boolean> {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(1, null, "isNetworkError", "invoke(Ljava/lang/Throwable;)Z", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
                    return Boolean.valueOf(invoke2(th));
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(Throwable th) {
                    C12238m.checkNotNullParameter(th, "p1");
                    return C55931.INSTANCE.invoke2(th);
                }
            }

            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<?> call(Observable<? extends Throwable> observable2) {
                RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
                C12238m.checkNotNullExpressionValue(observable2, "it");
                return retryWithDelay.retryWithDelay(observable2, j, num, num2, AnonymousClass1.INSTANCE);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11089O, "retryWhen { it.retryWith…ries, ::isNetworkError) }");
        return observableM11089O;
    }

    public static /* synthetic */ Observable restRetry$default(RetryWithDelay retryWithDelay, Observable observable, long j, Integer num, Integer num2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 1000;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            num = 3;
        }
        Integer num3 = num;
        if ((i & 4) != 0) {
            num2 = 3;
        }
        return retryWithDelay.restRetry(observable, j2, num3, num2, function1);
    }

    public final <T> Observable<T> restRetry(Observable<T> observable, final long j, final Integer num, final Integer num2, final Function1<? super Throwable, Boolean> function1) {
        C12238m.checkNotNullParameter(observable, "$this$restRetry");
        C12238m.checkNotNullParameter(function1, "predicate");
        Observable<T> observableM11089O = observable.m11089O(new InterfaceC12589b<Observable<? extends Throwable>, Observable<?>>() { // from class: com.discord.restapi.utils.RetryWithDelay.restRetry.3
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<?> call(Observable<? extends Throwable> observable2) {
                RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
                C12238m.checkNotNullExpressionValue(observable2, "it");
                return retryWithDelay.retryWithDelay(observable2, j, num, num2, function1);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11089O, "retryWhen { it.retryWith… maxRetries, predicate) }");
        return observableM11089O;
    }
}

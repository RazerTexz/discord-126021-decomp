package com.discord.restapi.utils;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.HttpException;
import rx.Observable;

/* JADX INFO: compiled from: RetryWithDelay.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RetryWithDelay {
    public static final RetryWithDelay INSTANCE = new RetryWithDelay();

    /* JADX INFO: renamed from: com.discord.restapi.utils.RetryWithDelay$restRetry$1, reason: invalid class name */
    /* JADX INFO: compiled from: RetryWithDelay.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Throwable, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
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
            Intrinsics3.checkNotNullParameter(th, "throwable");
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                int iA = httpException.a();
                retrofit2.Response<?> response2 = httpException.j;
                if ((response2 != null && (response = response2.a) != null && (request = response.request) != null && (str = request.method) != null && (!Intrinsics3.areEqual(str, ShareTarget.METHOD_GET))) || iA == 401 || iA == 429 || iA == 503 || iA == 403 || iA == 404) {
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
        Observable<R> observableA = observable.A(new Func1<Throwable, Observable<? extends Object>>() { // from class: com.discord.restapi.utils.RetryWithDelay.retryWithDelay.1
            @Override // j0.k.Func1
            public final Observable<? extends Object> call(Throwable th) {
                Ref$IntRef ref$IntRef3 = ref$IntRef;
                int i = ref$IntRef3.element;
                ref$IntRef3.element = i + 1;
                if (i < iIntValue) {
                    Function1 function2 = function1;
                    Intrinsics3.checkNotNullExpressionValue(th, "it");
                    if (((Boolean) function2.invoke(th)).booleanValue()) {
                        Ref$IntRef ref$IntRef4 = ref$IntRef2;
                        int i2 = ref$IntRef4.element;
                        int i3 = i2 + 1;
                        ref$IntRef4.element = i3;
                        if (i2 < iIntValue2 && i3 > 1) {
                            ref$LongRef.element *= (long) 2;
                        }
                        return Observable.d0(ref$LongRef.element, TimeUnit.MILLISECONDS);
                    }
                }
                return Observable.x(th);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableA, "flatMap {\n      if (curr…able.error<Any>(it)\n    }");
        return observableA;
    }

    public final <T> Observable<T> restRetry(Observable<T> observable, final long j, final Integer num, final Integer num2) {
        Intrinsics3.checkNotNullParameter(observable, "$this$restRetry");
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        Observable<T> observableO = observable.O(new Func1<Observable<? extends Throwable>, Observable<?>>() { // from class: com.discord.restapi.utils.RetryWithDelay.restRetry.2

            /* JADX INFO: renamed from: com.discord.restapi.utils.RetryWithDelay$restRetry$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: RetryWithDelay.kt */
            public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Throwable, Boolean> {
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
                    Intrinsics3.checkNotNullParameter(th, "p1");
                    return AnonymousClass1.INSTANCE.invoke2(th);
                }
            }

            @Override // j0.k.Func1
            public final Observable<?> call(Observable<? extends Throwable> observable2) {
                RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(observable2, "it");
                return retryWithDelay.retryWithDelay(observable2, j, num, num2, AnonymousClass1.INSTANCE);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableO, "retryWhen { it.retryWith…ries, ::isNetworkError) }");
        return observableO;
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
        Intrinsics3.checkNotNullParameter(observable, "$this$restRetry");
        Intrinsics3.checkNotNullParameter(function1, "predicate");
        Observable<T> observableO = observable.O(new Func1<Observable<? extends Throwable>, Observable<?>>() { // from class: com.discord.restapi.utils.RetryWithDelay.restRetry.3
            @Override // j0.k.Func1
            public final Observable<?> call(Observable<? extends Throwable> observable2) {
                RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(observable2, "it");
                return retryWithDelay.retryWithDelay(observable2, j, num, num2, function1);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableO, "retryWhen { it.retryWith… maxRetries, predicate) }");
        return observableO;
    }
}

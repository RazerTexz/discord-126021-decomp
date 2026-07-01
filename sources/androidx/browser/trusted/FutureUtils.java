package androidx.browser.trusted;

import androidx.annotation.NonNull;
import androidx.concurrent.futures.ResolvableFuture;
import b.i.b.d.a.a;

/* JADX INFO: loaded from: classes.dex */
public class FutureUtils {
    private FutureUtils() {
    }

    @NonNull
    public static <T> a<T> immediateFailedFuture(@NonNull Throwable th) {
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        resolvableFutureCreate.setException(th);
        return resolvableFutureCreate;
    }
}

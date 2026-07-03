package androidx.browser.trusted;

import androidx.annotation.NonNull;
import androidx.concurrent.futures.ResolvableFuture;
import p007b.p225i.p355b.p359d.p360a.InterfaceFutureC4539a;

/* JADX INFO: loaded from: classes.dex */
public class FutureUtils {
    private FutureUtils() {
    }

    @NonNull
    public static <T> InterfaceFutureC4539a<T> immediateFailedFuture(@NonNull Throwable th) {
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        resolvableFutureCreate.setException(th);
        return resolvableFutureCreate;
    }
}

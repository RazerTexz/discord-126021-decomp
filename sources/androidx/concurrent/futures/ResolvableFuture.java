package androidx.concurrent.futures;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import p007b.p225i.p355b.p359d.p360a.InterfaceFutureC4539a;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ResolvableFuture<V> extends AbstractResolvableFuture<V> {
    private ResolvableFuture() {
    }

    public static <V> ResolvableFuture<V> create() {
        return new ResolvableFuture<>();
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean set(@Nullable V v) {
        return super.set(v);
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean setException(Throwable th) {
        return super.setException(th);
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean setFuture(InterfaceFutureC4539a<? extends V> interfaceFutureC4539a) {
        return super.setFuture(interfaceFutureC4539a);
    }
}

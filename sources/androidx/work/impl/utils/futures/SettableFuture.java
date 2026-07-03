package androidx.work.impl.utils.futures;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import p007b.p225i.p355b.p359d.p360a.InterfaceFutureC4539a;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SettableFuture<V> extends AbstractFuture<V> {
    private SettableFuture() {
    }

    public static <V> SettableFuture<V> create() {
        return new SettableFuture<>();
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public boolean set(@Nullable V v) {
        return super.set(v);
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public boolean setException(Throwable th) {
        return super.setException(th);
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public boolean setFuture(InterfaceFutureC4539a<? extends V> interfaceFutureC4539a) {
        return super.setFuture(interfaceFutureC4539a);
    }
}

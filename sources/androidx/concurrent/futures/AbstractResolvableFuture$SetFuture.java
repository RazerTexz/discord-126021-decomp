package androidx.concurrent.futures;

import b.i.b.d.a.a;

/* JADX INFO: loaded from: classes.dex */
public final class AbstractResolvableFuture$SetFuture<V> implements Runnable {
    public final a<? extends V> future;
    public final AbstractResolvableFuture<V> owner;

    public AbstractResolvableFuture$SetFuture(AbstractResolvableFuture<V> abstractResolvableFuture, a<? extends V> aVar) {
        this.owner = abstractResolvableFuture;
        this.future = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.owner.value != this) {
            return;
        }
        if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(this.owner, this, AbstractResolvableFuture.getFutureValue(this.future))) {
            AbstractResolvableFuture.complete(this.owner);
        }
    }
}

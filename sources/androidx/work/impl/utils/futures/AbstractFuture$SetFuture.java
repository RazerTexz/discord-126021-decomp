package androidx.work.impl.utils.futures;

import b.i.b.d.a.a;

/* JADX INFO: loaded from: classes.dex */
public final class AbstractFuture$SetFuture<V> implements Runnable {
    public final a<? extends V> future;
    public final AbstractFuture<V> owner;

    public AbstractFuture$SetFuture(AbstractFuture<V> abstractFuture, a<? extends V> aVar) {
        this.owner = abstractFuture;
        this.future = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.owner.value != this) {
            return;
        }
        if (AbstractFuture.ATOMIC_HELPER.casValue(this.owner, this, AbstractFuture.getFutureValue(this.future))) {
            AbstractFuture.complete(this.owner);
        }
    }
}

package p007b.p225i.p226a.p288f.p292c.p293a.p296f.p297b;

import android.content.Context;
import android.util.Log;
import androidx.loader.content.AsyncTaskLoader;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;

/* JADX INFO: renamed from: b.i.a.f.c.a.f.b.d */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3201d extends AsyncTaskLoader<Void> {

    /* JADX INFO: renamed from: a */
    public Semaphore f9229a;

    /* JADX INFO: renamed from: b */
    public Set<AbstractC3268c> f9230b;

    public C3201d(Context context, Set<AbstractC3268c> set) {
        super(context);
        this.f9229a = new Semaphore(0);
        this.f9230b = set;
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public final Void loadInBackground() {
        Iterator<AbstractC3268c> it = this.f9230b.iterator();
        if (it.hasNext()) {
            Objects.requireNonNull(it.next());
            throw new UnsupportedOperationException();
        }
        try {
            this.f9229a.tryAcquire(0, 5L, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override // androidx.loader.content.Loader
    public final void onStartLoading() {
        this.f9229a.drainPermits();
        forceLoad();
    }
}

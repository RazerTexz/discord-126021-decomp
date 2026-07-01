package b.i.a.f.c.a.f.b;

import android.content.Context;
import android.util.Log;
import androidx.loader.content.AsyncTaskLoader;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends AsyncTaskLoader<Void> {
    public Semaphore a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Set<b.i.a.f.e.h.c> f1336b;

    public d(Context context, Set<b.i.a.f.e.h.c> set) {
        super(context);
        this.a = new Semaphore(0);
        this.f1336b = set;
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public final Void loadInBackground() {
        Iterator<b.i.a.f.e.h.c> it = this.f1336b.iterator();
        if (it.hasNext()) {
            Objects.requireNonNull(it.next());
            throw new UnsupportedOperationException();
        }
        try {
            this.a.tryAcquire(0, 5L, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override // androidx.loader.content.Loader
    public final void onStartLoading() {
        this.a.drainPermits();
        forceLoad();
    }
}

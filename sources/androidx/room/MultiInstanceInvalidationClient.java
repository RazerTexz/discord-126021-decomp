package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class MultiInstanceInvalidationClient {
    public final Context mAppContext;
    public int mClientId;
    public final Executor mExecutor;
    public final InvalidationTracker mInvalidationTracker;
    public final String mName;
    public final InvalidationTracker$Observer mObserver;
    public final Runnable mRemoveObserverRunnable;

    @Nullable
    public IMultiInstanceInvalidationService mService;
    public final ServiceConnection mServiceConnection;
    public final Runnable mSetUpRunnable;
    private final Runnable mTearDownRunnable;
    public final IMultiInstanceInvalidationCallback mCallback = new MultiInstanceInvalidationClient$1(this);
    public final AtomicBoolean mStopped = new AtomicBoolean(false);

    public MultiInstanceInvalidationClient(Context context, String str, InvalidationTracker invalidationTracker, Executor executor) {
        MultiInstanceInvalidationClient$2 multiInstanceInvalidationClient$2 = new MultiInstanceInvalidationClient$2(this);
        this.mServiceConnection = multiInstanceInvalidationClient$2;
        this.mSetUpRunnable = new MultiInstanceInvalidationClient$3(this);
        this.mRemoveObserverRunnable = new MultiInstanceInvalidationClient$4(this);
        this.mTearDownRunnable = new MultiInstanceInvalidationClient$5(this);
        Context applicationContext = context.getApplicationContext();
        this.mAppContext = applicationContext;
        this.mName = str;
        this.mInvalidationTracker = invalidationTracker;
        this.mExecutor = executor;
        this.mObserver = new MultiInstanceInvalidationClient$6(this, (String[]) invalidationTracker.mTableIdLookup.keySet().toArray(new String[0]));
        applicationContext.bindService(new Intent(applicationContext, (Class<?>) MultiInstanceInvalidationService.class), multiInstanceInvalidationClient$2, 1);
    }

    public void stop() {
        if (this.mStopped.compareAndSet(false, true)) {
            this.mExecutor.execute(this.mTearDownRunnable);
        }
    }
}

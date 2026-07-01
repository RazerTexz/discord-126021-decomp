package androidx.view;

import androidx.annotation.MainThread;

/* JADX INFO: loaded from: classes.dex */
public class ComputableLiveData$3 implements Runnable {
    public final /* synthetic */ ComputableLiveData this$0;

    public ComputableLiveData$3(ComputableLiveData computableLiveData) {
        this.this$0 = computableLiveData;
    }

    @Override // java.lang.Runnable
    @MainThread
    public void run() {
        boolean zHasActiveObservers = this.this$0.mLiveData.hasActiveObservers();
        if (this.this$0.mInvalid.compareAndSet(false, true) && zHasActiveObservers) {
            ComputableLiveData computableLiveData = this.this$0;
            computableLiveData.mExecutor.execute(computableLiveData.mRefreshRunnable);
        }
    }
}

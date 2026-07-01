package androidx.room;

import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class MultiInstanceInvalidationClient$5 implements Runnable {
    public final /* synthetic */ MultiInstanceInvalidationClient this$0;

    public MultiInstanceInvalidationClient$5(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    @Override // java.lang.Runnable
    public void run() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.this$0;
        multiInstanceInvalidationClient.mInvalidationTracker.removeObserver(multiInstanceInvalidationClient.mObserver);
        try {
            MultiInstanceInvalidationClient multiInstanceInvalidationClient2 = this.this$0;
            IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient2.mService;
            if (iMultiInstanceInvalidationService != null) {
                iMultiInstanceInvalidationService.unregisterCallback(multiInstanceInvalidationClient2.mCallback, multiInstanceInvalidationClient2.mClientId);
            }
        } catch (RemoteException e) {
            Log.w(Room.LOG_TAG, "Cannot unregister multi-instance invalidation callback", e);
        }
        MultiInstanceInvalidationClient multiInstanceInvalidationClient3 = this.this$0;
        multiInstanceInvalidationClient3.mAppContext.unbindService(multiInstanceInvalidationClient3.mServiceConnection);
    }
}

package androidx.room;

import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MultiInstanceInvalidationClient$6 extends InvalidationTracker$Observer {
    public final /* synthetic */ MultiInstanceInvalidationClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiInstanceInvalidationClient$6(MultiInstanceInvalidationClient multiInstanceInvalidationClient, String[] strArr) {
        super(strArr);
        this.this$0 = multiInstanceInvalidationClient;
    }

    @Override // androidx.room.InvalidationTracker$Observer
    public boolean isRemote() {
        return true;
    }

    @Override // androidx.room.InvalidationTracker$Observer
    public void onInvalidated(@NonNull Set<String> set) {
        if (this.this$0.mStopped.get()) {
            return;
        }
        try {
            MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.this$0;
            IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.mService;
            if (iMultiInstanceInvalidationService != null) {
                iMultiInstanceInvalidationService.broadcastInvalidation(multiInstanceInvalidationClient.mClientId, (String[]) set.toArray(new String[0]));
            }
        } catch (RemoteException e) {
            Log.w(Room.LOG_TAG, "Cannot broadcast invalidation", e);
        }
    }
}

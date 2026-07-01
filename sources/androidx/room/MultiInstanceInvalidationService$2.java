package androidx.room;

import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class MultiInstanceInvalidationService$2 extends IMultiInstanceInvalidationService$Stub {
    public final /* synthetic */ MultiInstanceInvalidationService this$0;

    public MultiInstanceInvalidationService$2(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.this$0 = multiInstanceInvalidationService;
    }

    @Override // androidx.room.IMultiInstanceInvalidationService
    public void broadcastInvalidation(int i, String[] strArr) {
        synchronized (this.this$0.mCallbackList) {
            try {
                String str = this.this$0.mClientNames.get(Integer.valueOf(i));
                if (str == null) {
                    Log.w(Room.LOG_TAG, "Remote invalidation client ID not registered");
                    return;
                }
                int iBeginBroadcast = this.this$0.mCallbackList.beginBroadcast();
                for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
                    try {
                        int iIntValue = ((Integer) this.this$0.mCallbackList.getBroadcastCookie(i2)).intValue();
                        String str2 = this.this$0.mClientNames.get(Integer.valueOf(iIntValue));
                        if (i != iIntValue && str.equals(str2)) {
                            try {
                                ((IMultiInstanceInvalidationCallback) this.this$0.mCallbackList.getBroadcastItem(i2)).onInvalidation(strArr);
                            } catch (RemoteException e) {
                                Log.w(Room.LOG_TAG, "Error invoking a remote callback", e);
                            }
                        }
                    } catch (Throwable th) {
                        this.this$0.mCallbackList.finishBroadcast();
                        throw th;
                    }
                }
                this.this$0.mCallbackList.finishBroadcast();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.room.IMultiInstanceInvalidationService
    public int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) {
        if (str == null) {
            return 0;
        }
        synchronized (this.this$0.mCallbackList) {
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
            int i = multiInstanceInvalidationService.mMaxClientId + 1;
            multiInstanceInvalidationService.mMaxClientId = i;
            if (multiInstanceInvalidationService.mCallbackList.register(iMultiInstanceInvalidationCallback, Integer.valueOf(i))) {
                this.this$0.mClientNames.put(Integer.valueOf(i), str);
                return i;
            }
            this.this$0.mMaxClientId--;
            return 0;
        }
    }

    @Override // androidx.room.IMultiInstanceInvalidationService
    public void unregisterCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i) {
        synchronized (this.this$0.mCallbackList) {
            this.this$0.mCallbackList.unregister(iMultiInstanceInvalidationCallback);
            this.this$0.mClientNames.remove(Integer.valueOf(i));
        }
    }
}

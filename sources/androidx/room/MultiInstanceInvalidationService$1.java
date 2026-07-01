package androidx.room;

import android.os.IInterface;
import android.os.RemoteCallbackList;

/* JADX INFO: loaded from: classes.dex */
public class MultiInstanceInvalidationService$1 extends RemoteCallbackList<IMultiInstanceInvalidationCallback> {
    public final /* synthetic */ MultiInstanceInvalidationService this$0;

    public MultiInstanceInvalidationService$1(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.this$0 = multiInstanceInvalidationService;
    }

    @Override // android.os.RemoteCallbackList
    public /* bridge */ /* synthetic */ void onCallbackDied(IInterface iInterface, Object obj) {
        onCallbackDied((IMultiInstanceInvalidationCallback) iInterface, obj);
    }

    public void onCallbackDied(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, Object obj) {
        this.this$0.mClientNames.remove(Integer.valueOf(((Integer) obj).intValue()));
    }
}

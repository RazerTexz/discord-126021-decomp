package androidx.room;

import androidx.annotation.NonNull;
import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class RoomTrackingLiveData$3 extends InvalidationTracker$Observer {
    public final /* synthetic */ RoomTrackingLiveData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomTrackingLiveData$3(RoomTrackingLiveData roomTrackingLiveData, String[] strArr) {
        super(strArr);
        this.this$0 = roomTrackingLiveData;
    }

    @Override // androidx.room.InvalidationTracker$Observer
    public void onInvalidated(@NonNull Set<String> set) {
        ArchTaskExecutor.getInstance().executeOnMainThread(this.this$0.mInvalidationRunnable);
    }
}

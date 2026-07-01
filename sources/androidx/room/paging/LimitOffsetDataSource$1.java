package androidx.room.paging;

import androidx.annotation.NonNull;
import androidx.room.InvalidationTracker$Observer;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class LimitOffsetDataSource$1 extends InvalidationTracker$Observer {
    public final /* synthetic */ LimitOffsetDataSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LimitOffsetDataSource$1(LimitOffsetDataSource limitOffsetDataSource, String[] strArr) {
        super(strArr);
        this.this$0 = limitOffsetDataSource;
    }

    @Override // androidx.room.InvalidationTracker$Observer
    public void onInvalidated(@NonNull Set<String> set) {
        this.this$0.invalidate();
    }
}

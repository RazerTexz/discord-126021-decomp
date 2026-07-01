package androidx.recyclerview.widget;

import androidx.annotation.Nullable;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SimplePool;

/* JADX INFO: loaded from: classes.dex */
public class ViewInfoStore$InfoRecord {
    public static final int FLAG_APPEAR = 2;
    public static final int FLAG_APPEAR_AND_DISAPPEAR = 3;
    public static final int FLAG_APPEAR_PRE_AND_POST = 14;
    public static final int FLAG_DISAPPEARED = 1;
    public static final int FLAG_POST = 8;
    public static final int FLAG_PRE = 4;
    public static final int FLAG_PRE_AND_POST = 12;
    public static Pools$Pool<ViewInfoStore$InfoRecord> sPool = new Pools$SimplePool(20);
    public int flags;

    @Nullable
    public RecyclerView$ItemAnimator$ItemHolderInfo postInfo;

    @Nullable
    public RecyclerView$ItemAnimator$ItemHolderInfo preInfo;

    private ViewInfoStore$InfoRecord() {
    }

    public static void drainCache() {
        while (sPool.acquire() != null) {
        }
    }

    public static ViewInfoStore$InfoRecord obtain() {
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecordAcquire = sPool.acquire();
        return viewInfoStore$InfoRecordAcquire == null ? new ViewInfoStore$InfoRecord() : viewInfoStore$InfoRecordAcquire;
    }

    public static void recycle(ViewInfoStore$InfoRecord viewInfoStore$InfoRecord) {
        viewInfoStore$InfoRecord.flags = 0;
        viewInfoStore$InfoRecord.preInfo = null;
        viewInfoStore$InfoRecord.postInfo = null;
        sPool.release(viewInfoStore$InfoRecord);
    }
}

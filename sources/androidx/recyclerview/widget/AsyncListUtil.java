package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class AsyncListUtil<T> {
    public static final boolean DEBUG = false;
    public static final String TAG = "AsyncListUtil";
    public boolean mAllowScrollHints;
    private final ThreadUtil$BackgroundCallback<T> mBackgroundCallback;
    public final ThreadUtil$BackgroundCallback<T> mBackgroundProxy;
    public final AsyncListUtil$DataCallback<T> mDataCallback;
    private final ThreadUtil$MainThreadCallback<T> mMainThreadCallback;
    public final ThreadUtil$MainThreadCallback<T> mMainThreadProxy;
    public final Class<T> mTClass;
    public final TileList<T> mTileList;
    public final int mTileSize;
    public final AsyncListUtil$ViewCallback mViewCallback;
    public final int[] mTmpRange = new int[2];
    public final int[] mPrevRange = new int[2];
    public final int[] mTmpRangeExtended = new int[2];
    private int mScrollHint = 0;
    public int mItemCount = 0;
    public int mDisplayedGeneration = 0;
    public int mRequestedGeneration = 0;
    public final SparseIntArray mMissingPositions = new SparseIntArray();

    public AsyncListUtil(@NonNull Class<T> cls, int i, @NonNull AsyncListUtil$DataCallback<T> asyncListUtil$DataCallback, @NonNull AsyncListUtil$ViewCallback asyncListUtil$ViewCallback) {
        AsyncListUtil$1 asyncListUtil$1 = new AsyncListUtil$1(this);
        this.mMainThreadCallback = asyncListUtil$1;
        AsyncListUtil$2 asyncListUtil$2 = new AsyncListUtil$2(this);
        this.mBackgroundCallback = asyncListUtil$2;
        this.mTClass = cls;
        this.mTileSize = i;
        this.mDataCallback = asyncListUtil$DataCallback;
        this.mViewCallback = asyncListUtil$ViewCallback;
        this.mTileList = new TileList<>(i);
        MessageThreadUtil messageThreadUtil = new MessageThreadUtil();
        this.mMainThreadProxy = messageThreadUtil.getMainThreadProxy(asyncListUtil$1);
        this.mBackgroundProxy = messageThreadUtil.getBackgroundProxy(asyncListUtil$2);
        refresh();
    }

    private boolean isRefreshPending() {
        return this.mRequestedGeneration != this.mDisplayedGeneration;
    }

    @Nullable
    public T getItem(int i) {
        if (i < 0 || i >= this.mItemCount) {
            throw new IndexOutOfBoundsException(i + " is not within 0 and " + this.mItemCount);
        }
        T itemAt = this.mTileList.getItemAt(i);
        if (itemAt == null && !isRefreshPending()) {
            this.mMissingPositions.put(i, 0);
        }
        return itemAt;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public void log(String str, Object... objArr) {
        StringBuilder sbU = a.U("[MAIN] ");
        sbU.append(String.format(str, objArr));
        Log.d(TAG, sbU.toString());
    }

    public void onRangeChanged() {
        if (isRefreshPending()) {
            return;
        }
        updateRange();
        this.mAllowScrollHints = true;
    }

    public void refresh() {
        this.mMissingPositions.clear();
        ThreadUtil$BackgroundCallback<T> threadUtil$BackgroundCallback = this.mBackgroundProxy;
        int i = this.mRequestedGeneration + 1;
        this.mRequestedGeneration = i;
        threadUtil$BackgroundCallback.refresh(i);
    }

    public void updateRange() {
        this.mViewCallback.getItemRangeInto(this.mTmpRange);
        int[] iArr = this.mTmpRange;
        if (iArr[0] > iArr[1] || iArr[0] < 0 || iArr[1] >= this.mItemCount) {
            return;
        }
        if (this.mAllowScrollHints) {
            int i = iArr[0];
            int[] iArr2 = this.mPrevRange;
            if (i > iArr2[1] || iArr2[0] > iArr[1]) {
                this.mScrollHint = 0;
            } else if (iArr[0] < iArr2[0]) {
                this.mScrollHint = 1;
            } else if (iArr[0] > iArr2[0]) {
                this.mScrollHint = 2;
            }
        } else {
            this.mScrollHint = 0;
        }
        int[] iArr3 = this.mPrevRange;
        iArr3[0] = iArr[0];
        iArr3[1] = iArr[1];
        this.mViewCallback.extendRangeInto(iArr, this.mTmpRangeExtended, this.mScrollHint);
        int[] iArr4 = this.mTmpRangeExtended;
        iArr4[0] = Math.min(this.mTmpRange[0], Math.max(iArr4[0], 0));
        int[] iArr5 = this.mTmpRangeExtended;
        iArr5[1] = Math.max(this.mTmpRange[1], Math.min(iArr5[1], this.mItemCount - 1));
        ThreadUtil$BackgroundCallback<T> threadUtil$BackgroundCallback = this.mBackgroundProxy;
        int[] iArr6 = this.mTmpRange;
        int i2 = iArr6[0];
        int i3 = iArr6[1];
        int[] iArr7 = this.mTmpRangeExtended;
        threadUtil$BackgroundCallback.updateRange(i2, i3, iArr7[0], iArr7[1], this.mScrollHint);
    }
}

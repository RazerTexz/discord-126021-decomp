package androidx.recyclerview.widget;

import android.util.Log;
import b.d.b.a.a;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes.dex */
public class AsyncListUtil$1<T> implements ThreadUtil$MainThreadCallback<T> {
    public final /* synthetic */ AsyncListUtil this$0;

    public AsyncListUtil$1(AsyncListUtil asyncListUtil) {
        this.this$0 = asyncListUtil;
    }

    private boolean isRequestedGeneration(int i) {
        return i == this.this$0.mRequestedGeneration;
    }

    private void recycleAllTiles() {
        for (int i = 0; i < this.this$0.mTileList.size(); i++) {
            AsyncListUtil asyncListUtil = this.this$0;
            asyncListUtil.mBackgroundProxy.recycleTile(asyncListUtil.mTileList.getAtIndex(i));
        }
        this.this$0.mTileList.clear();
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
    public void addTile(int i, TileList$Tile<T> tileList$Tile) {
        if (!isRequestedGeneration(i)) {
            this.this$0.mBackgroundProxy.recycleTile(tileList$Tile);
            return;
        }
        TileList$Tile<T> tileList$TileAddOrReplace = this.this$0.mTileList.addOrReplace(tileList$Tile);
        if (tileList$TileAddOrReplace != null) {
            StringBuilder sbU = a.U("duplicate tile @");
            sbU.append(tileList$TileAddOrReplace.mStartPosition);
            Log.e(AsyncListUtil.TAG, sbU.toString());
            this.this$0.mBackgroundProxy.recycleTile(tileList$TileAddOrReplace);
        }
        int i2 = tileList$Tile.mStartPosition + tileList$Tile.mItemCount;
        int i3 = 0;
        while (i3 < this.this$0.mMissingPositions.size()) {
            int iKeyAt = this.this$0.mMissingPositions.keyAt(i3);
            if (tileList$Tile.mStartPosition > iKeyAt || iKeyAt >= i2) {
                i3++;
            } else {
                this.this$0.mMissingPositions.removeAt(i3);
                this.this$0.mViewCallback.onItemLoaded(iKeyAt);
            }
        }
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
    public void removeTile(int i, int i2) {
        if (isRequestedGeneration(i)) {
            TileList$Tile<T> tileList$TileRemoveAtPos = this.this$0.mTileList.removeAtPos(i2);
            if (tileList$TileRemoveAtPos != null) {
                this.this$0.mBackgroundProxy.recycleTile(tileList$TileRemoveAtPos);
                return;
            }
            Log.e(AsyncListUtil.TAG, "tile not found @" + i2);
        }
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
    public void updateItemCount(int i, int i2) {
        if (isRequestedGeneration(i)) {
            AsyncListUtil asyncListUtil = this.this$0;
            asyncListUtil.mItemCount = i2;
            asyncListUtil.mViewCallback.onDataRefresh();
            AsyncListUtil asyncListUtil2 = this.this$0;
            asyncListUtil2.mDisplayedGeneration = asyncListUtil2.mRequestedGeneration;
            recycleAllTiles();
            AsyncListUtil asyncListUtil3 = this.this$0;
            asyncListUtil3.mAllowScrollHints = false;
            asyncListUtil3.updateRange();
        }
    }
}

package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import b.d.b.a.a;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes.dex */
public class AsyncListUtil$2<T> implements ThreadUtil$BackgroundCallback<T> {
    private int mFirstRequiredTileStart;
    private int mGeneration;
    private int mItemCount;
    private int mLastRequiredTileStart;
    public final SparseBooleanArray mLoadedTiles = new SparseBooleanArray();
    private TileList$Tile<T> mRecycledRoot;
    public final /* synthetic */ AsyncListUtil this$0;

    public AsyncListUtil$2(AsyncListUtil asyncListUtil) {
        this.this$0 = asyncListUtil;
    }

    private TileList$Tile<T> acquireTile() {
        TileList$Tile<T> tileList$Tile = this.mRecycledRoot;
        if (tileList$Tile != null) {
            this.mRecycledRoot = tileList$Tile.mNext;
            return tileList$Tile;
        }
        AsyncListUtil asyncListUtil = this.this$0;
        return new TileList$Tile<>(asyncListUtil.mTClass, asyncListUtil.mTileSize);
    }

    private void addTile(TileList$Tile<T> tileList$Tile) {
        this.mLoadedTiles.put(tileList$Tile.mStartPosition, true);
        this.this$0.mMainThreadProxy.addTile(this.mGeneration, tileList$Tile);
    }

    private void flushTileCache(int i) {
        int maxCachedTiles = this.this$0.mDataCallback.getMaxCachedTiles();
        while (this.mLoadedTiles.size() >= maxCachedTiles) {
            int iKeyAt = this.mLoadedTiles.keyAt(0);
            SparseBooleanArray sparseBooleanArray = this.mLoadedTiles;
            int iKeyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
            int i2 = this.mFirstRequiredTileStart - iKeyAt;
            int i3 = iKeyAt2 - this.mLastRequiredTileStart;
            if (i2 > 0 && (i2 >= i3 || i == 2)) {
                removeTile(iKeyAt);
            } else {
                if (i3 <= 0) {
                    return;
                }
                if (i2 >= i3 && i != 1) {
                    return;
                } else {
                    removeTile(iKeyAt2);
                }
            }
        }
    }

    private int getTileStart(int i) {
        return i - (i % this.this$0.mTileSize);
    }

    private boolean isTileLoaded(int i) {
        return this.mLoadedTiles.get(i);
    }

    private void log(String str, Object... objArr) {
        StringBuilder sbU = a.U("[BKGR] ");
        sbU.append(String.format(str, objArr));
        Log.d(AsyncListUtil.TAG, sbU.toString());
    }

    private void removeTile(int i) {
        this.mLoadedTiles.delete(i);
        this.this$0.mMainThreadProxy.removeTile(this.mGeneration, i);
    }

    private void requestTiles(int i, int i2, int i3, boolean z2) {
        int i4 = i;
        while (i4 <= i2) {
            this.this$0.mBackgroundProxy.loadTile(z2 ? (i2 + i) - i4 : i4, i3);
            i4 += this.this$0.mTileSize;
        }
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
    public void loadTile(int i, int i2) {
        if (isTileLoaded(i)) {
            return;
        }
        TileList$Tile<T> tileList$TileAcquireTile = acquireTile();
        tileList$TileAcquireTile.mStartPosition = i;
        int iMin = Math.min(this.this$0.mTileSize, this.mItemCount - i);
        tileList$TileAcquireTile.mItemCount = iMin;
        this.this$0.mDataCallback.fillData(tileList$TileAcquireTile.mItems, tileList$TileAcquireTile.mStartPosition, iMin);
        flushTileCache(i2);
        addTile(tileList$TileAcquireTile);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
    public void recycleTile(TileList$Tile<T> tileList$Tile) {
        this.this$0.mDataCallback.recycleData(tileList$Tile.mItems, tileList$Tile.mItemCount);
        tileList$Tile.mNext = this.mRecycledRoot;
        this.mRecycledRoot = tileList$Tile;
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
    public void refresh(int i) {
        this.mGeneration = i;
        this.mLoadedTiles.clear();
        int iRefreshData = this.this$0.mDataCallback.refreshData();
        this.mItemCount = iRefreshData;
        this.this$0.mMainThreadProxy.updateItemCount(this.mGeneration, iRefreshData);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
    public void updateRange(int i, int i2, int i3, int i4, int i5) {
        if (i > i2) {
            return;
        }
        int tileStart = getTileStart(i);
        int tileStart2 = getTileStart(i2);
        this.mFirstRequiredTileStart = getTileStart(i3);
        int tileStart3 = getTileStart(i4);
        this.mLastRequiredTileStart = tileStart3;
        if (i5 == 1) {
            requestTiles(this.mFirstRequiredTileStart, tileStart2, i5, true);
            requestTiles(tileStart2 + this.this$0.mTileSize, this.mLastRequiredTileStart, i5, false);
        } else {
            requestTiles(tileStart, tileStart3, i5, false);
            requestTiles(this.mFirstRequiredTileStart, tileStart - this.this$0.mTileSize, i5, true);
        }
    }
}

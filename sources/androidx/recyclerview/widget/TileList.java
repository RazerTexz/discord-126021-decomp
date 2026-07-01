package androidx.recyclerview.widget;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public class TileList<T> {
    public TileList$Tile<T> mLastAccessedTile;
    public final int mTileSize;
    private final SparseArray<TileList$Tile<T>> mTiles = new SparseArray<>(10);

    public TileList(int i) {
        this.mTileSize = i;
    }

    public TileList$Tile<T> addOrReplace(TileList$Tile<T> tileList$Tile) {
        int iIndexOfKey = this.mTiles.indexOfKey(tileList$Tile.mStartPosition);
        if (iIndexOfKey < 0) {
            this.mTiles.put(tileList$Tile.mStartPosition, tileList$Tile);
            return null;
        }
        TileList$Tile<T> tileList$TileValueAt = this.mTiles.valueAt(iIndexOfKey);
        this.mTiles.setValueAt(iIndexOfKey, tileList$Tile);
        if (this.mLastAccessedTile == tileList$TileValueAt) {
            this.mLastAccessedTile = tileList$Tile;
        }
        return tileList$TileValueAt;
    }

    public void clear() {
        this.mTiles.clear();
    }

    public TileList$Tile<T> getAtIndex(int i) {
        if (i < 0 || i >= this.mTiles.size()) {
            return null;
        }
        return this.mTiles.valueAt(i);
    }

    public T getItemAt(int i) {
        TileList$Tile<T> tileList$Tile = this.mLastAccessedTile;
        if (tileList$Tile == null || !tileList$Tile.containsPosition(i)) {
            int iIndexOfKey = this.mTiles.indexOfKey(i - (i % this.mTileSize));
            if (iIndexOfKey < 0) {
                return null;
            }
            this.mLastAccessedTile = this.mTiles.valueAt(iIndexOfKey);
        }
        return this.mLastAccessedTile.getByPosition(i);
    }

    public TileList$Tile<T> removeAtPos(int i) {
        TileList$Tile<T> tileList$Tile = this.mTiles.get(i);
        if (this.mLastAccessedTile == tileList$Tile) {
            this.mLastAccessedTile = null;
        }
        this.mTiles.delete(i);
        return tileList$Tile;
    }

    public int size() {
        return this.mTiles.size();
    }
}

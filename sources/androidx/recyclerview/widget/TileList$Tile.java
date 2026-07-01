package androidx.recyclerview.widget;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public class TileList$Tile<T> {
    public int mItemCount;
    public final T[] mItems;
    public TileList$Tile<T> mNext;
    public int mStartPosition;

    public TileList$Tile(Class<T> cls, int i) {
        this.mItems = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
    }

    public boolean containsPosition(int i) {
        int i2 = this.mStartPosition;
        return i2 <= i && i < i2 + this.mItemCount;
    }

    public T getByPosition(int i) {
        return this.mItems[i - this.mStartPosition];
    }
}

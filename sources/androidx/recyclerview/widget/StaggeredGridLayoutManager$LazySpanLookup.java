package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager$LazySpanLookup {
    private static final int MIN_SIZE = 10;
    public int[] mData;
    public List<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> mFullSpanItems;

    private int invalidateFullSpansAfter(int i) {
        if (this.mFullSpanItems == null) {
            return -1;
        }
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem fullSpanItem = getFullSpanItem(i);
        if (fullSpanItem != null) {
            this.mFullSpanItems.remove(fullSpanItem);
        }
        int size = this.mFullSpanItems.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            }
            if (this.mFullSpanItems.get(i2).mPosition >= i) {
                break;
            }
            i2++;
        }
        if (i2 == -1) {
            return -1;
        }
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = this.mFullSpanItems.get(i2);
        this.mFullSpanItems.remove(i2);
        return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition;
    }

    private void offsetFullSpansForAddition(int i, int i2) {
        List<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> list = this.mFullSpanItems;
        if (list == null) {
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = this.mFullSpanItems.get(size);
            int i3 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition;
            if (i3 >= i) {
                staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition = i3 + i2;
            }
        }
    }

    private void offsetFullSpansForRemoval(int i, int i2) {
        List<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> list = this.mFullSpanItems;
        if (list == null) {
            return;
        }
        int i3 = i + i2;
        for (int size = list.size() - 1; size >= 0; size--) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = this.mFullSpanItems.get(size);
            int i4 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition;
            if (i4 >= i) {
                if (i4 < i3) {
                    this.mFullSpanItems.remove(size);
                } else {
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition = i4 - i2;
                }
            }
        }
    }

    public void addFullSpanItem(StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem) {
        if (this.mFullSpanItems == null) {
            this.mFullSpanItems = new ArrayList();
        }
        int size = this.mFullSpanItems.size();
        for (int i = 0; i < size; i++) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2 = this.mFullSpanItems.get(i);
            if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.mPosition == staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition) {
                this.mFullSpanItems.remove(i);
            }
            if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.mPosition >= staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition) {
                this.mFullSpanItems.add(i, staggeredGridLayoutManager$LazySpanLookup$FullSpanItem);
                return;
            }
        }
        this.mFullSpanItems.add(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem);
    }

    public void clear() {
        int[] iArr = this.mData;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        this.mFullSpanItems = null;
    }

    public void ensureSize(int i) {
        int[] iArr = this.mData;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i, 10) + 1];
            this.mData = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i >= iArr.length) {
            int[] iArr3 = new int[sizeForPosition(i)];
            this.mData = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = this.mData;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    public int forceInvalidateAfter(int i) {
        List<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> list = this.mFullSpanItems;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (this.mFullSpanItems.get(size).mPosition >= i) {
                    this.mFullSpanItems.remove(size);
                }
            }
        }
        return invalidateAfter(i);
    }

    public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem getFirstFullSpanItemInRange(int i, int i2, int i3, boolean z2) {
        List<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> list = this.mFullSpanItems;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = this.mFullSpanItems.get(i4);
            int i5 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition;
            if (i5 >= i2) {
                return null;
            }
            if (i5 >= i && (i3 == 0 || staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mGapDir == i3 || (z2 && staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mHasUnwantedGapAfter))) {
                return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
            }
        }
        return null;
    }

    public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem getFullSpanItem(int i) {
        List<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> list = this.mFullSpanItems;
        if (list == null) {
            return null;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = this.mFullSpanItems.get(size);
            if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition == i) {
                return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
            }
        }
        return null;
    }

    public int getSpan(int i) {
        int[] iArr = this.mData;
        if (iArr == null || i >= iArr.length) {
            return -1;
        }
        return iArr[i];
    }

    public int invalidateAfter(int i) {
        int[] iArr = this.mData;
        if (iArr == null || i >= iArr.length) {
            return -1;
        }
        int iInvalidateFullSpansAfter = invalidateFullSpansAfter(i);
        if (iInvalidateFullSpansAfter == -1) {
            int[] iArr2 = this.mData;
            Arrays.fill(iArr2, i, iArr2.length, -1);
            return this.mData.length;
        }
        int iMin = Math.min(iInvalidateFullSpansAfter + 1, this.mData.length);
        Arrays.fill(this.mData, i, iMin, -1);
        return iMin;
    }

    public void offsetForAddition(int i, int i2) {
        int[] iArr = this.mData;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        int i3 = i + i2;
        ensureSize(i3);
        int[] iArr2 = this.mData;
        System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
        Arrays.fill(this.mData, i, i3, -1);
        offsetFullSpansForAddition(i, i2);
    }

    public void offsetForRemoval(int i, int i2) {
        int[] iArr = this.mData;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        int i3 = i + i2;
        ensureSize(i3);
        int[] iArr2 = this.mData;
        System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
        int[] iArr3 = this.mData;
        Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
        offsetFullSpansForRemoval(i, i2);
    }

    public void setSpan(int i, StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span) {
        ensureSize(i);
        this.mData[i] = staggeredGridLayoutManager$Span.mIndex;
    }

    public int sizeForPosition(int i) {
        int length = this.mData.length;
        while (length <= i) {
            length *= 2;
        }
        return length;
    }
}

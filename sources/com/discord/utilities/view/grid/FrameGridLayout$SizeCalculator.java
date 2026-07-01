package com.discord.utilities.view.grid;


/* JADX INFO: compiled from: FrameGridLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FrameGridLayout$SizeCalculator {
    private final int maxLinearViews;

    public FrameGridLayout$SizeCalculator(int i) {
        this.maxLinearViews = i;
    }

    private final int getItemRow(int itemIndex, int itemCount, boolean isVertical) {
        if (isVertical) {
            return itemCount <= this.maxLinearViews ? itemIndex : itemIndex / 2;
        }
        if (itemCount <= this.maxLinearViews) {
            return 0;
        }
        return itemIndex % 2;
    }

    private final int getRowCount(int itemCount, boolean isVertical) {
        if (!isVertical) {
            return itemCount <= this.maxLinearViews ? 1 : 2;
        }
        if (itemCount <= this.maxLinearViews) {
            return itemCount;
        }
        return itemCount % 2 == 1 ? (itemCount / 2) + 1 : itemCount / 2;
    }

    public final FrameGridLayout$PositionSpec getItemSize(int layoutWidth, int layoutHeight, int itemCount, int itemIndex) {
        boolean z2 = false;
        boolean z3 = layoutHeight >= layoutWidth;
        int itemRow = getItemRow(itemIndex, itemCount, z3);
        int itemRow2 = getItemRow(itemIndex, itemCount, !z3);
        int rowCount = getRowCount(itemCount, z3);
        int rowCount2 = getRowCount(itemCount, !z3);
        if (itemIndex == itemCount - 1 && itemCount > this.maxLinearViews && itemCount % 2 == 1) {
            z2 = true;
        }
        int i = layoutWidth / rowCount2;
        int i2 = layoutHeight / rowCount;
        int i3 = itemRow * i2;
        int i4 = itemRow2 * i;
        return new FrameGridLayout$PositionSpec(i4, i3, ((z2 && z3) ? i * 2 : i) + i4, ((!z2 || z3) ? i2 : i2 * 2) + i3);
    }

    public final int getMaxLinearViews() {
        return this.maxLinearViews;
    }
}

package com.discord.utilities.view.grid;

import b.d.b.a.a;

/* JADX INFO: compiled from: FrameGridLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FrameGridLayout$PositionSpec {
    private final int bottom;
    private final int height;
    private final int left;
    private final int right;
    private final int top;
    private final int width;

    public FrameGridLayout$PositionSpec(int i, int i2, int i3, int i4) {
        this.left = i;
        this.top = i2;
        this.right = i3;
        this.bottom = i4;
        this.width = i3 - i;
        this.height = i4 - i2;
    }

    public static /* synthetic */ FrameGridLayout$PositionSpec copy$default(FrameGridLayout$PositionSpec frameGridLayout$PositionSpec, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = frameGridLayout$PositionSpec.left;
        }
        if ((i5 & 2) != 0) {
            i2 = frameGridLayout$PositionSpec.top;
        }
        if ((i5 & 4) != 0) {
            i3 = frameGridLayout$PositionSpec.right;
        }
        if ((i5 & 8) != 0) {
            i4 = frameGridLayout$PositionSpec.bottom;
        }
        return frameGridLayout$PositionSpec.copy(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getLeft() {
        return this.left;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRight() {
        return this.right;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getBottom() {
        return this.bottom;
    }

    public final FrameGridLayout$PositionSpec copy(int left, int top, int right, int bottom) {
        return new FrameGridLayout$PositionSpec(left, top, right, bottom);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FrameGridLayout$PositionSpec)) {
            return false;
        }
        FrameGridLayout$PositionSpec frameGridLayout$PositionSpec = (FrameGridLayout$PositionSpec) other;
        return this.left == frameGridLayout$PositionSpec.left && this.top == frameGridLayout$PositionSpec.top && this.right == frameGridLayout$PositionSpec.right && this.bottom == frameGridLayout$PositionSpec.bottom;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getTop() {
        return this.top;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    public String toString() {
        StringBuilder sbU = a.U("PositionSpec(left=");
        sbU.append(this.left);
        sbU.append(", top=");
        sbU.append(this.top);
        sbU.append(", right=");
        sbU.append(this.right);
        sbU.append(", bottom=");
        return a.B(sbU, this.bottom, ")");
    }
}

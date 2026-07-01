package com.discord.widgets.voice.fullscreen.grid;

import b.d.b.a.a;

/* JADX INFO: compiled from: VideoCallGridAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class VideoCallGridAdapter$CallUiInsets {
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    public VideoCallGridAdapter$CallUiInsets(int i, int i2, int i3, int i4) {
        this.top = i;
        this.bottom = i2;
        this.left = i3;
        this.right = i4;
    }

    public static /* synthetic */ VideoCallGridAdapter$CallUiInsets copy$default(VideoCallGridAdapter$CallUiInsets videoCallGridAdapter$CallUiInsets, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = videoCallGridAdapter$CallUiInsets.top;
        }
        if ((i5 & 2) != 0) {
            i2 = videoCallGridAdapter$CallUiInsets.bottom;
        }
        if ((i5 & 4) != 0) {
            i3 = videoCallGridAdapter$CallUiInsets.left;
        }
        if ((i5 & 8) != 0) {
            i4 = videoCallGridAdapter$CallUiInsets.right;
        }
        return videoCallGridAdapter$CallUiInsets.copy(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getBottom() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getLeft() {
        return this.left;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getRight() {
        return this.right;
    }

    public final VideoCallGridAdapter$CallUiInsets copy(int top, int bottom, int left, int right) {
        return new VideoCallGridAdapter$CallUiInsets(top, bottom, left, right);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoCallGridAdapter$CallUiInsets)) {
            return false;
        }
        VideoCallGridAdapter$CallUiInsets videoCallGridAdapter$CallUiInsets = (VideoCallGridAdapter$CallUiInsets) other;
        return this.top == videoCallGridAdapter$CallUiInsets.top && this.bottom == videoCallGridAdapter$CallUiInsets.bottom && this.left == videoCallGridAdapter$CallUiInsets.left && this.right == videoCallGridAdapter$CallUiInsets.right;
    }

    public final int getBottom() {
        return this.bottom;
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

    public int hashCode() {
        return (((((this.top * 31) + this.bottom) * 31) + this.left) * 31) + this.right;
    }

    public String toString() {
        StringBuilder sbU = a.U("CallUiInsets(top=");
        sbU.append(this.top);
        sbU.append(", bottom=");
        sbU.append(this.bottom);
        sbU.append(", left=");
        sbU.append(this.left);
        sbU.append(", right=");
        return a.B(sbU, this.right, ")");
    }
}

package androidx.customview.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Px;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewDragHelper$Callback {
    public int clampViewPositionHorizontal(@NonNull View view, int i, int i2) {
        return 0;
    }

    public int clampViewPositionVertical(@NonNull View view, int i, int i2) {
        return 0;
    }

    public int getOrderedChildIndex(int i) {
        return i;
    }

    public int getViewHorizontalDragRange(@NonNull View view) {
        return 0;
    }

    public int getViewVerticalDragRange(@NonNull View view) {
        return 0;
    }

    public void onEdgeDragStarted(int i, int i2) {
    }

    public boolean onEdgeLock(int i) {
        return false;
    }

    public void onEdgeTouched(int i, int i2) {
    }

    public void onViewCaptured(@NonNull View view, int i) {
    }

    public void onViewDragStateChanged(int i) {
    }

    public void onViewPositionChanged(@NonNull View view, int i, int i2, @Px int i3, @Px int i4) {
    }

    public void onViewReleased(@NonNull View view, float f, float f2) {
    }

    public abstract boolean tryCaptureView(@NonNull View view, int i);
}

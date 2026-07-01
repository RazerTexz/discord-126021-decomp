package org.webrtc;

import android.graphics.Point;
import android.view.View;
import android.view.View$MeasureSpec;

/* JADX INFO: loaded from: classes3.dex */
public class RendererCommon$VideoLayoutMeasure {
    private float visibleFractionMatchOrientation;
    private float visibleFractionMismatchOrientation;

    public RendererCommon$VideoLayoutMeasure() {
        RendererCommon$ScalingType rendererCommon$ScalingType = RendererCommon$ScalingType.SCALE_ASPECT_BALANCED;
        this.visibleFractionMatchOrientation = RendererCommon.access$000(rendererCommon$ScalingType);
        this.visibleFractionMismatchOrientation = RendererCommon.access$000(rendererCommon$ScalingType);
    }

    public Point measure(int i, int i2, int i3, int i4) {
        int defaultSize = View.getDefaultSize(Integer.MAX_VALUE, i);
        int defaultSize2 = View.getDefaultSize(Integer.MAX_VALUE, i2);
        if (i3 == 0 || i4 == 0 || defaultSize == 0 || defaultSize2 == 0) {
            return new Point(defaultSize, defaultSize2);
        }
        float f = i3 / i4;
        Point displaySize = RendererCommon.getDisplaySize(((f > 1.0f ? 1 : (f == 1.0f ? 0 : -1)) > 0) == (((float) defaultSize) / ((float) defaultSize2) > 1.0f) ? this.visibleFractionMatchOrientation : this.visibleFractionMismatchOrientation, f, defaultSize, defaultSize2);
        if (View$MeasureSpec.getMode(i) == 1073741824) {
            displaySize.x = defaultSize;
        }
        if (View$MeasureSpec.getMode(i2) == 1073741824) {
            displaySize.y = defaultSize2;
        }
        return displaySize;
    }

    public void setScalingType(RendererCommon$ScalingType rendererCommon$ScalingType) {
        setScalingType(rendererCommon$ScalingType, rendererCommon$ScalingType);
    }

    public void setVisibleFraction(float f, float f2) {
        this.visibleFractionMatchOrientation = f;
        this.visibleFractionMismatchOrientation = f2;
    }

    public void setScalingType(RendererCommon$ScalingType rendererCommon$ScalingType, RendererCommon$ScalingType rendererCommon$ScalingType2) {
        this.visibleFractionMatchOrientation = RendererCommon.access$000(rendererCommon$ScalingType);
        this.visibleFractionMismatchOrientation = RendererCommon.access$000(rendererCommon$ScalingType2);
    }
}

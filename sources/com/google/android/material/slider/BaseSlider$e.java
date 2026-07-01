package com.google.android.material.slider;

import android.graphics.Rect;
import android.os.Bundle;
import android.widget.SeekBar;
import androidx.core.math.MathUtils;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$RangeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R$string;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BaseSlider$e extends ExploreByTouchHelper {
    public final BaseSlider<?, ?, ?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Rect f3062b;

    public BaseSlider$e(BaseSlider<?, ?, ?> baseSlider) {
        super(baseSlider);
        this.f3062b = new Rect();
        this.a = baseSlider;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public int getVirtualViewAt(float f, float f2) {
        for (int i = 0; i < this.a.getValues().size(); i++) {
            this.a.updateBoundsForVirturalViewId(i, this.f3062b);
            if (this.f3062b.contains((int) f, (int) f2)) {
                return i;
            }
        }
        return -1;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public void getVisibleVirtualViews(List<Integer> list) {
        for (int i = 0; i < this.a.getValues().size(); i++) {
            list.add(Integer.valueOf(i));
        }
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
        if (!this.a.isEnabled()) {
            return false;
        }
        if (i2 != 4096 && i2 != 8192) {
            if (i2 == 16908349 && bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                if (BaseSlider.access$600(this.a, i, bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE))) {
                    BaseSlider.access$700(this.a);
                    this.a.postInvalidate();
                    invalidateVirtualView(i);
                    return true;
                }
            }
            return false;
        }
        float fAccess$800 = BaseSlider.access$800(this.a, 20);
        if (i2 == 8192) {
            fAccess$800 = -fAccess$800;
        }
        if (this.a.isRtl()) {
            fAccess$800 = -fAccess$800;
        }
        if (!BaseSlider.access$600(this.a, i, MathUtils.clamp(this.a.getValues().get(i).floatValue() + fAccess$800, this.a.getValueFrom(), this.a.getValueTo()))) {
            return false;
        }
        BaseSlider.access$700(this.a);
        this.a.postInvalidate();
        invalidateVirtualView(i);
        return true;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        String string;
        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_SET_PROGRESS);
        List<Float> values = this.a.getValues();
        float fFloatValue = values.get(i).floatValue();
        float valueFrom = this.a.getValueFrom();
        float valueTo = this.a.getValueTo();
        if (this.a.isEnabled()) {
            if (fFloatValue > valueFrom) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
            if (fFloatValue < valueTo) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
        }
        accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat$RangeInfoCompat.obtain(1, valueFrom, valueTo, fFloatValue));
        accessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
        StringBuilder sb = new StringBuilder();
        if (this.a.getContentDescription() != null) {
            sb.append(this.a.getContentDescription());
            sb.append(",");
        }
        if (values.size() > 1) {
            if (i == this.a.getValues().size() - 1) {
                string = this.a.getContext().getString(R$string.material_slider_range_end);
            } else {
                string = i == 0 ? this.a.getContext().getString(R$string.material_slider_range_start) : "";
            }
            sb.append(string);
            sb.append(BaseSlider.access$500(this.a, fFloatValue));
        }
        accessibilityNodeInfoCompat.setContentDescription(sb.toString());
        this.a.updateBoundsForVirturalViewId(i, this.f3062b);
        accessibilityNodeInfoCompat.setBoundsInParent(this.f3062b);
    }
}

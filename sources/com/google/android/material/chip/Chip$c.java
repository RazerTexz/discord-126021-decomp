package com.google.android.material.chip;

import android.content.Context;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R$string;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Chip$c extends ExploreByTouchHelper {
    public final /* synthetic */ Chip a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Chip$c(Chip chip, Chip chip2) {
        super(chip2);
        this.a = chip;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public int getVirtualViewAt(float f, float f2) {
        return (Chip.access$100(this.a) && Chip.access$200(this.a).contains(f, f2)) ? 1 : 0;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public void getVisibleVirtualViews(@NonNull List<Integer> list) {
        list.add(0);
        if (Chip.access$100(this.a) && this.a.isCloseIconVisible() && Chip.access$300(this.a) != null) {
            list.add(1);
        }
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
        if (i2 != 16) {
            return false;
        }
        if (i == 0) {
            return this.a.performClick();
        }
        if (i == 1) {
            return this.a.performCloseIconClick();
        }
        return false;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        accessibilityNodeInfoCompat.setCheckable(this.a.isCheckable());
        accessibilityNodeInfoCompat.setClickable(this.a.isClickable());
        if (this.a.isCheckable() || this.a.isClickable()) {
            accessibilityNodeInfoCompat.setClassName(this.a.isCheckable() ? "android.widget.CompoundButton" : "android.widget.Button");
        } else {
            accessibilityNodeInfoCompat.setClassName("android.view.View");
        }
        CharSequence text = this.a.getText();
        if (Build$VERSION.SDK_INT >= 23) {
            accessibilityNodeInfoCompat.setText(text);
        } else {
            accessibilityNodeInfoCompat.setContentDescription(text);
        }
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public void onPopulateNodeForVirtualView(int i, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (i != 1) {
            accessibilityNodeInfoCompat.setContentDescription("");
            accessibilityNodeInfoCompat.setBoundsInParent(Chip.access$600());
            return;
        }
        CharSequence closeIconContentDescription = this.a.getCloseIconContentDescription();
        if (closeIconContentDescription != null) {
            accessibilityNodeInfoCompat.setContentDescription(closeIconContentDescription);
        } else {
            CharSequence text = this.a.getText();
            Context context = this.a.getContext();
            int i2 = R$string.mtrl_chip_close_icon_content_description;
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(text) ? "" : text;
            accessibilityNodeInfoCompat.setContentDescription(context.getString(i2, objArr).trim());
        }
        accessibilityNodeInfoCompat.setBoundsInParent(Chip.access$500(this.a));
        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_CLICK);
        accessibilityNodeInfoCompat.setEnabled(this.a.isEnabled());
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public void onVirtualViewKeyboardFocusChanged(int i, boolean z2) {
        if (i == 1) {
            Chip.access$402(this.a, z2);
            this.a.refreshDrawableState();
        }
    }
}

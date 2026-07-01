package com.discord.views;

import android.R$attr;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.discord.R$a;
import d0.z.d.m;

/* JADX INFO: compiled from: CheckableImageView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CheckableImageView extends AppCompatImageView implements Checkable {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final int[] checkedStateSet;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public boolean checked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        this.checkedStateSet = new int[]{R$attr.state_checked};
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$a.CheckableImageView, 0, 0);
            m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…CheckableImageView, 0, 0)");
            try {
                this.checked = typedArrayObtainStyledAttributes.getBoolean(0, this.checked);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int extraSpace) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(extraSpace + 1);
        m.checkNotNullExpressionValue(iArrOnCreateDrawableState, "super.onCreateDrawableState(extraSpace + 1)");
        if (this.checked) {
            ImageView.mergeDrawableStates(iArrOnCreateDrawableState, this.checkedStateSet);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        this.checked = checked;
        refreshDrawableState();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.checked);
    }
}

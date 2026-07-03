package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.C0051R;
import androidx.core.widget.PopupWindowCompat;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatPopupWindow extends PopupWindow {
    private static final boolean COMPAT_OVERLAP_ANCHOR = false;
    private boolean mOverlapAnchor;

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i, int i2) {
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0051R.styleable.PopupWindow, i, i2);
        int i3 = C0051R.styleable.PopupWindow_overlapAnchor;
        if (tintTypedArrayObtainStyledAttributes.hasValue(i3)) {
            setSupportOverlapAnchor(tintTypedArrayObtainStyledAttributes.getBoolean(i3, false));
        }
        setBackgroundDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(C0051R.styleable.PopupWindow_android_popupBackground));
        tintTypedArrayObtainStyledAttributes.recycle();
    }

    private void setSupportOverlapAnchor(boolean z2) {
        if (COMPAT_OVERLAP_ANCHOR) {
            this.mOverlapAnchor = z2;
        } else {
            PopupWindowCompat.setOverlapAnchor(this, z2);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i3, int i4) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }
}

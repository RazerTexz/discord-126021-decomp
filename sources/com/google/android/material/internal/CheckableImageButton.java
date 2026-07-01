package com.google.android.material.internal;

import android.R$attr;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    private static final int[] DRAWABLE_STATE_CHECKED = {R$attr.state_checked};
    private boolean checkable;
    private boolean checked;
    private boolean pressable;

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    public boolean isPressable() {
        return this.pressable;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        if (!this.checked) {
            return super.onCreateDrawableState(i);
        }
        int[] iArr = DRAWABLE_STATE_CHECKED;
        return ImageButton.mergeDrawableStates(super.onCreateDrawableState(i + iArr.length), iArr);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof CheckableImageButton$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        CheckableImageButton$SavedState checkableImageButton$SavedState = (CheckableImageButton$SavedState) parcelable;
        super.onRestoreInstanceState(checkableImageButton$SavedState.getSuperState());
        setChecked(checkableImageButton$SavedState.j);
    }

    @Override // android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        CheckableImageButton$SavedState checkableImageButton$SavedState = new CheckableImageButton$SavedState(super.onSaveInstanceState());
        checkableImageButton$SavedState.j = this.checked;
        return checkableImageButton$SavedState;
    }

    public void setCheckable(boolean z2) {
        if (this.checkable != z2) {
            this.checkable = z2;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (!this.checkable || this.checked == z2) {
            return;
        }
        this.checked = z2;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z2) {
        this.pressable = z2;
    }

    @Override // android.view.View
    public void setPressed(boolean z2) {
        if (this.pressable) {
            super.setPressed(z2);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.checked);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R$attr.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.checkable = true;
        this.pressable = true;
        ViewCompat.setAccessibilityDelegate(this, new CheckableImageButton$a(this));
    }
}

package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0051R;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    private static final int[] DRAWABLE_STATE_CHECKED = {R.attr.state_checked};
    private boolean checkable;
    private boolean checked;
    private boolean pressable;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C10923a();

        /* JADX INFO: renamed from: j */
        public boolean f21025j;

        /* JADX INFO: renamed from: com.google.android.material.internal.CheckableImageButton$SavedState$a */
        public static class C10923a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public Object createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f21025j ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f21025j = parcel.readInt() == 1;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.CheckableImageButton$a */
    public class C10924a extends AccessibilityDelegateCompat {
        public C10924a() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCheckable(CheckableImageButton.this.isCheckable());
            accessibilityNodeInfoCompat.setChecked(CheckableImageButton.this.isChecked());
        }
    }

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
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.f21025j);
    }

    @Override // android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f21025j = this.checked;
        return savedState;
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
        this(context, attributeSet, C0051R.attr.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.checkable = true;
        this.pressable = true;
        ViewCompat.setAccessibilityDelegate(this, new C10924a());
    }
}

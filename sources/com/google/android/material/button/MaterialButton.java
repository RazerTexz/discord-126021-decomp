package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.C10817R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import p007b.p225i.p226a.p341g.p343b.C4388a;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {
    private static final int[] CHECKABLE_STATE_SET = {R.attr.state_checkable};
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int DEF_STYLE_RES = C10817R.style.Widget_MaterialComponents_Button;
    public static final int ICON_GRAVITY_END = 3;
    public static final int ICON_GRAVITY_START = 1;
    public static final int ICON_GRAVITY_TEXT_END = 4;
    public static final int ICON_GRAVITY_TEXT_START = 2;
    public static final int ICON_GRAVITY_TEXT_TOP = 32;
    public static final int ICON_GRAVITY_TOP = 16;
    private static final String LOG_TAG = "MaterialButton";
    private boolean broadcasting;
    private boolean checked;

    @Nullable
    private Drawable icon;
    private int iconGravity;

    @Px
    private int iconLeft;

    @Px
    private int iconPadding;

    @Px
    private int iconSize;

    @Nullable
    private ColorStateList iconTint;

    @Nullable
    private PorterDuff.Mode iconTintMode;

    @Px
    private int iconTop;

    @NonNull
    private final C4388a materialButtonHelper;

    @NonNull
    private final LinkedHashSet<OnCheckedChangeListener> onCheckedChangeListeners;

    @Nullable
    private InterfaceC10866a onPressedChangeListenerInternal;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IconGravity {
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialButton materialButton, boolean z2);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C10865a();

        /* JADX INFO: renamed from: j */
        public boolean f20940j;

        /* JADX INFO: renamed from: com.google.android.material.button.MaterialButton$SavedState$a */
        public static class C10865a implements Parcelable.ClassLoaderCreator<SavedState> {
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
            parcel.writeInt(this.f20940j ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                SavedState.class.getClassLoader();
            }
            this.f20940j = parcel.readInt() == 1;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.button.MaterialButton$a */
    public interface InterfaceC10866a {
    }

    public MaterialButton(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    private String getA11yClassName() {
        return (isCheckable() ? CompoundButton.class : Button.class).getName();
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        return Math.min((int) paint.measureText(string), getLayout().getEllipsizedWidth());
    }

    private boolean isIconEnd() {
        int i = this.iconGravity;
        return i == 3 || i == 4;
    }

    private boolean isIconStart() {
        int i = this.iconGravity;
        return i == 1 || i == 2;
    }

    private boolean isIconTop() {
        int i = this.iconGravity;
        return i == 16 || i == 32;
    }

    private boolean isLayoutRTL() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    private boolean isUsingOriginalBackground() {
        C4388a c4388a = this.materialButtonHelper;
        return (c4388a == null || c4388a.f11552o) ? false : true;
    }

    private void resetIconDrawable() {
        if (isIconStart()) {
            TextViewCompat.setCompoundDrawablesRelative(this, this.icon, null, null, null);
        } else if (isIconEnd()) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, null, this.icon, null);
        } else if (isIconTop()) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, this.icon, null, null);
        }
    }

    private void updateIcon(boolean z2) {
        Drawable drawable = this.icon;
        if (drawable != null) {
            Drawable drawableMutate = DrawableCompat.wrap(drawable).mutate();
            this.icon = drawableMutate;
            DrawableCompat.setTintList(drawableMutate, this.iconTint);
            PorterDuff.Mode mode = this.iconTintMode;
            if (mode != null) {
                DrawableCompat.setTintMode(this.icon, mode);
            }
            int intrinsicWidth = this.iconSize;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.icon.getIntrinsicWidth();
            }
            int intrinsicHeight = this.iconSize;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.icon.getIntrinsicHeight();
            }
            Drawable drawable2 = this.icon;
            int i = this.iconLeft;
            int i2 = this.iconTop;
            drawable2.setBounds(i, i2, intrinsicWidth + i, intrinsicHeight + i2);
        }
        if (z2) {
            resetIconDrawable();
            return;
        }
        Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this);
        boolean z3 = false;
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        if ((isIconStart() && drawable3 != this.icon) || ((isIconEnd() && drawable5 != this.icon) || (isIconTop() && drawable4 != this.icon))) {
            z3 = true;
        }
        if (z3) {
            resetIconDrawable();
        }
    }

    private void updateIconPosition(int i, int i2) {
        if (this.icon == null || getLayout() == null) {
            return;
        }
        if (!isIconStart() && !isIconEnd()) {
            if (isIconTop()) {
                this.iconLeft = 0;
                if (this.iconGravity == 16) {
                    this.iconTop = 0;
                    updateIcon(false);
                    return;
                }
                int intrinsicHeight = this.iconSize;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.icon.getIntrinsicHeight();
                }
                int textHeight = (((((i2 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.iconPadding) - getPaddingBottom()) / 2;
                if (this.iconTop != textHeight) {
                    this.iconTop = textHeight;
                    updateIcon(false);
                    return;
                }
                return;
            }
            return;
        }
        this.iconTop = 0;
        int i3 = this.iconGravity;
        if (i3 == 1 || i3 == 3) {
            this.iconLeft = 0;
            updateIcon(false);
            return;
        }
        int intrinsicWidth = this.iconSize;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.icon.getIntrinsicWidth();
        }
        int textWidth = (((((i - getTextWidth()) - ViewCompat.getPaddingEnd(this)) - intrinsicWidth) - this.iconPadding) - ViewCompat.getPaddingStart(this)) / 2;
        if (isLayoutRTL() != (this.iconGravity == 4)) {
            textWidth = -textWidth;
        }
        if (this.iconLeft != textWidth) {
            this.iconLeft = textWidth;
            updateIcon(false);
        }
    }

    public void addOnCheckedChangeListener(@NonNull OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListeners.add(onCheckedChangeListener);
    }

    public void clearOnCheckedChangeListeners() {
        this.onCheckedChangeListeners.clear();
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Px
    public int getCornerRadius() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.f11544g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getIconGravity() {
        return this.iconGravity;
    }

    @Px
    public int getIconPadding() {
        return this.iconPadding;
    }

    @Px
    public int getIconSize() {
        return this.iconSize;
    }

    public ColorStateList getIconTint() {
        return this.iconTint;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.iconTintMode;
    }

    @Dimension
    public int getInsetBottom() {
        return this.materialButtonHelper.f11543f;
    }

    @Dimension
    public int getInsetTop() {
        return this.materialButtonHelper.f11542e;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.f11549l;
        }
        return null;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.f11539b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.f11548k;
        }
        return null;
    }

    @Px
    public int getStrokeWidth() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.f11545h;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        return isUsingOriginalBackground() ? this.materialButtonHelper.f11547j : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return isUsingOriginalBackground() ? this.materialButtonHelper.f11546i : super.getSupportBackgroundTintMode();
    }

    public boolean isCheckable() {
        C4388a c4388a = this.materialButtonHelper;
        return c4388a != null && c4388a.f11554q;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isUsingOriginalBackground()) {
            MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialButtonHelper.m6037b());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isCheckable()) {
            Button.mergeDrawableStates(iArrOnCreateDrawableState, CHECKABLE_STATE_SET);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        C4388a c4388a;
        super.onLayout(z2, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT != 21 || (c4388a = this.materialButtonHelper) == null) {
            return;
        }
        int i5 = i4 - i2;
        int i6 = i3 - i;
        Drawable drawable = c4388a.f11550m;
        if (drawable != null) {
            drawable.setBounds(c4388a.f11540c, c4388a.f11542e, i6 - c4388a.f11541d, i5 - c4388a.f11543f);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.f20940j);
    }

    @Override // android.widget.TextView, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f20940j = this.checked;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        updateIconPosition(i, i2);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void removeOnCheckedChangeListener(@NonNull OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListeners.remove(onCheckedChangeListener);
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i) {
        if (!isUsingOriginalBackground()) {
            super.setBackgroundColor(i);
            return;
        }
        C4388a c4388a = this.materialButtonHelper;
        if (c4388a.m6037b() != null) {
            c4388a.m6037b().setTint(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (!isUsingOriginalBackground()) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
            return;
        }
        Log.w(LOG_TAG, "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        C4388a c4388a = this.materialButtonHelper;
        c4388a.f11552o = true;
        c4388a.f11538a.setSupportBackgroundTintList(c4388a.f11547j);
        c4388a.f11538a.setSupportBackgroundTintMode(c4388a.f11546i);
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        setBackgroundDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z2) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.f11554q = z2;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (isCheckable() && isEnabled() && this.checked != z2) {
            this.checked = z2;
            refreshDrawableState();
            if (this.broadcasting) {
                return;
            }
            this.broadcasting = true;
            Iterator<OnCheckedChangeListener> it = this.onCheckedChangeListeners.iterator();
            while (it.hasNext()) {
                it.next().onCheckedChanged(this, this.checked);
            }
            this.broadcasting = false;
        }
    }

    public void setCornerRadius(@Px int i) {
        if (isUsingOriginalBackground()) {
            C4388a c4388a = this.materialButtonHelper;
            if (c4388a.f11553p && c4388a.f11544g == i) {
                return;
            }
            c4388a.f11544g = i;
            c4388a.f11553p = true;
            c4388a.m6040e(c4388a.f11539b.withCornerSize(i));
        }
    }

    public void setCornerRadiusResource(@DimenRes int i) {
        if (isUsingOriginalBackground()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f) {
        super.setElevation(f);
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.m6037b().setElevation(f);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.icon != drawable) {
            this.icon = drawable;
            updateIcon(true);
            updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i) {
        if (this.iconGravity != i) {
            this.iconGravity = i;
            updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(@Px int i) {
        if (this.iconPadding != i) {
            this.iconPadding = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(@DrawableRes int i) {
        setIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setIconSize(@Px int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.iconSize != i) {
            this.iconSize = i;
            updateIcon(true);
        }
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.iconTint != colorStateList) {
            this.iconTint = colorStateList;
            updateIcon(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.iconTintMode != mode) {
            this.iconTintMode = mode;
            updateIcon(false);
        }
    }

    public void setIconTintResource(@ColorRes int i) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), i));
    }

    public void setInsetBottom(@Dimension int i) {
        C4388a c4388a = this.materialButtonHelper;
        c4388a.m6041f(c4388a.f11542e, i);
    }

    public void setInsetTop(@Dimension int i) {
        C4388a c4388a = this.materialButtonHelper;
        c4388a.m6041f(i, c4388a.f11543f);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(@Nullable InterfaceC10866a interfaceC10866a) {
        this.onPressedChangeListenerInternal = interfaceC10866a;
    }

    @Override // android.view.View
    public void setPressed(boolean z2) {
        InterfaceC10866a interfaceC10866a = this.onPressedChangeListenerInternal;
        if (interfaceC10866a != null) {
            MaterialButtonToggleGroup.this.invalidate();
        }
        super.setPressed(z2);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            C4388a c4388a = this.materialButtonHelper;
            if (c4388a.f11549l != colorStateList) {
                c4388a.f11549l = colorStateList;
                if (c4388a.f11538a.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) c4388a.f11538a.getBackground()).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(@ColorRes int i) {
        if (isUsingOriginalBackground()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (!isUsingOriginalBackground()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.materialButtonHelper.m6040e(shapeAppearanceModel);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z2) {
        if (isUsingOriginalBackground()) {
            C4388a c4388a = this.materialButtonHelper;
            c4388a.f11551n = z2;
            c4388a.m6043h();
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            C4388a c4388a = this.materialButtonHelper;
            if (c4388a.f11548k != colorStateList) {
                c4388a.f11548k = colorStateList;
                c4388a.m6043h();
            }
        }
    }

    public void setStrokeColorResource(@ColorRes int i) {
        if (isUsingOriginalBackground()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    public void setStrokeWidth(@Px int i) {
        if (isUsingOriginalBackground()) {
            C4388a c4388a = this.materialButtonHelper;
            if (c4388a.f11545h != i) {
                c4388a.f11545h = i;
                c4388a.m6043h();
            }
        }
    }

    public void setStrokeWidthResource(@DimenRes int i) {
        if (isUsingOriginalBackground()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (!isUsingOriginalBackground()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        C4388a c4388a = this.materialButtonHelper;
        if (c4388a.f11547j != colorStateList) {
            c4388a.f11547j = colorStateList;
            if (c4388a.m6037b() != null) {
                DrawableCompat.setTintList(c4388a.m6037b(), c4388a.f11547j);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (!isUsingOriginalBackground()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        C4388a c4388a = this.materialButtonHelper;
        if (c4388a.f11546i != mode) {
            c4388a.f11546i = mode;
            if (c4388a.m6037b() == null || c4388a.f11546i == null) {
                return;
            }
            DrawableCompat.setTintMode(c4388a.m6037b(), c4388a.f11546i);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.checked);
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C10817R.attr.materialButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        int i2 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i2), attributeSet, i);
        this.onCheckedChangeListeners = new LinkedHashSet<>();
        this.checked = false;
        this.broadcasting = false;
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, C10817R.styleable.MaterialButton, i, i2, new int[0]);
        this.iconPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10817R.styleable.MaterialButton_iconPadding, 0);
        this.iconTintMode = ViewUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(C10817R.styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.iconTint = MaterialResources.getColorStateList(getContext(), typedArrayObtainStyledAttributes, C10817R.styleable.MaterialButton_iconTint);
        this.icon = MaterialResources.getDrawable(getContext(), typedArrayObtainStyledAttributes, C10817R.styleable.MaterialButton_icon);
        this.iconGravity = typedArrayObtainStyledAttributes.getInteger(C10817R.styleable.MaterialButton_iconGravity, 1);
        this.iconSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10817R.styleable.MaterialButton_iconSize, 0);
        C4388a c4388a = new C4388a(this, ShapeAppearanceModel.builder(context2, attributeSet, i, i2).build());
        this.materialButtonHelper = c4388a;
        Objects.requireNonNull(c4388a);
        c4388a.f11540c = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C10817R.styleable.MaterialButton_android_insetLeft, 0);
        c4388a.f11541d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C10817R.styleable.MaterialButton_android_insetRight, 0);
        c4388a.f11542e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C10817R.styleable.MaterialButton_android_insetTop, 0);
        c4388a.f11543f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C10817R.styleable.MaterialButton_android_insetBottom, 0);
        int i3 = C10817R.styleable.MaterialButton_cornerRadius;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(i3, -1);
            c4388a.f11544g = dimensionPixelSize;
            c4388a.m6040e(c4388a.f11539b.withCornerSize(dimensionPixelSize));
            c4388a.f11553p = true;
        }
        c4388a.f11545h = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10817R.styleable.MaterialButton_strokeWidth, 0);
        c4388a.f11546i = ViewUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(C10817R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        c4388a.f11547j = MaterialResources.getColorStateList(getContext(), typedArrayObtainStyledAttributes, C10817R.styleable.MaterialButton_backgroundTint);
        c4388a.f11548k = MaterialResources.getColorStateList(getContext(), typedArrayObtainStyledAttributes, C10817R.styleable.MaterialButton_strokeColor);
        c4388a.f11549l = MaterialResources.getColorStateList(getContext(), typedArrayObtainStyledAttributes, C10817R.styleable.MaterialButton_rippleColor);
        c4388a.f11554q = typedArrayObtainStyledAttributes.getBoolean(C10817R.styleable.MaterialButton_android_checkable, false);
        c4388a.f11556s = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10817R.styleable.MaterialButton_elevation, 0);
        int paddingStart = ViewCompat.getPaddingStart(this);
        int paddingTop = getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this);
        int paddingBottom = getPaddingBottom();
        if (typedArrayObtainStyledAttributes.hasValue(C10817R.styleable.MaterialButton_android_background)) {
            c4388a.f11552o = true;
            setSupportBackgroundTintList(c4388a.f11547j);
            setSupportBackgroundTintMode(c4388a.f11546i);
        } else {
            c4388a.m6042g();
        }
        ViewCompat.setPaddingRelative(this, paddingStart + c4388a.f11540c, paddingTop + c4388a.f11542e, paddingEnd + c4388a.f11541d, paddingBottom + c4388a.f11543f);
        typedArrayObtainStyledAttributes.recycle();
        setCompoundDrawablePadding(this.iconPadding);
        updateIcon(this.icon != null);
    }
}

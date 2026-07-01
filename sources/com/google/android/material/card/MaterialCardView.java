package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import b.i.a.g.c.MaterialCardViewHelper;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialCardView extends CardView implements Checkable, Shapeable {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.cardview.widget.CardView";
    private static final String LOG_TAG = "MaterialCardView";

    @NonNull
    private final MaterialCardViewHelper cardViewHelper;
    private boolean checked;
    private boolean dragged;
    private boolean isParentCardViewDoneInitializing;
    private OnCheckedChangeListener onCheckedChangeListener;
    private static final int[] CHECKABLE_STATE_SET = {R.attr.state_checkable};
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int[] DRAGGED_STATE_SET = {com.google.android.material.R.attr.state_dragged};
    private static final int DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_CardView;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialCardView materialCardView, boolean z2);
    }

    public MaterialCardView(Context context) {
        this(context, null);
    }

    private void forceRippleRedrawIfNeeded() {
        MaterialCardViewHelper materialCardViewHelper;
        Drawable drawable;
        if (Build.VERSION.SDK_INT <= 26 || (drawable = (materialCardViewHelper = this.cardViewHelper).p) == null) {
            return;
        }
        Rect bounds = drawable.getBounds();
        int i = bounds.bottom;
        materialCardViewHelper.p.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
        materialCardViewHelper.p.setBounds(bounds.left, bounds.top, bounds.right, i);
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.cardViewHelper.e.getBounds());
        return rectF;
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.cardViewHelper.e.getFillColor();
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.cardViewHelper.f.getFillColor();
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.cardViewHelper.k;
    }

    @Dimension
    public int getCheckedIconMargin() {
        return this.cardViewHelper.g;
    }

    @Dimension
    public int getCheckedIconSize() {
        return this.cardViewHelper.h;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.cardViewHelper.m;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.cardViewHelper.d.bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.cardViewHelper.d.left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.cardViewHelper.d.right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.cardViewHelper.d.top;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.cardViewHelper.e.getInterpolation();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.cardViewHelper.e.getTopLeftCornerResolvedSize();
    }

    public ColorStateList getRippleColor() {
        return this.cardViewHelper.l;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.cardViewHelper.n;
    }

    @ColorInt
    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.cardViewHelper.o;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.cardViewHelper.o;
    }

    @Dimension
    public int getStrokeWidth() {
        return this.cardViewHelper.i;
    }

    public boolean isCheckable() {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        return materialCardViewHelper != null && materialCardViewHelper.u;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    public boolean isDragged() {
        return this.dragged;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.cardViewHelper.e);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 3);
        if (isCheckable()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, CHECKABLE_STATE_SET);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        if (isDragged()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, DRAGGED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        super.onMeasure(i, i2);
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (materialCardViewHelper.q != null) {
            int i5 = materialCardViewHelper.g;
            int i6 = materialCardViewHelper.h;
            int iCeil = (measuredWidth - i5) - i6;
            int iCeil2 = (measuredHeight - i5) - i6;
            if (materialCardViewHelper.c.getUseCompatPadding()) {
                iCeil2 -= (int) Math.ceil(materialCardViewHelper.d() * 2.0f);
                iCeil -= (int) Math.ceil(materialCardViewHelper.c() * 2.0f);
            }
            int i7 = iCeil2;
            int i8 = materialCardViewHelper.g;
            if (ViewCompat.getLayoutDirection(materialCardViewHelper.c) == 1) {
                i4 = iCeil;
                i3 = i8;
            } else {
                i3 = iCeil;
                i4 = i8;
            }
            materialCardViewHelper.q.setLayerInset(2, i3, materialCardViewHelper.g, i4, i7);
        }
    }

    public void setAncestorContentPadding(int i, int i2, int i3, int i4) {
        super.setContentPadding(i, i2, i3, i4);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.isParentCardViewDoneInitializing) {
            if (!this.cardViewHelper.t) {
                Log.i(LOG_TAG, "Setting a custom background is not supported.");
                this.cardViewHelper.t = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@ColorInt int i) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.e.setFillColor(ColorStateList.valueOf(i));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f) {
        super.setCardElevation(f);
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.e.setElevation(materialCardViewHelper.c.getCardElevation());
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.cardViewHelper.f;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        materialShapeDrawable.setFillColor(colorStateList);
    }

    public void setCheckable(boolean z2) {
        this.cardViewHelper.u = z2;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (this.checked != z2) {
            toggle();
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        this.cardViewHelper.g(drawable);
    }

    public void setCheckedIconMargin(@Dimension int i) {
        this.cardViewHelper.g = i;
    }

    public void setCheckedIconMarginResource(@DimenRes int i) {
        if (i != -1) {
            this.cardViewHelper.g = getResources().getDimensionPixelSize(i);
        }
    }

    public void setCheckedIconResource(@DrawableRes int i) {
        this.cardViewHelper.g(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setCheckedIconSize(@Dimension int i) {
        this.cardViewHelper.h = i;
    }

    public void setCheckedIconSizeResource(@DimenRes int i) {
        if (i != 0) {
            this.cardViewHelper.h = getResources().getDimensionPixelSize(i);
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.m = colorStateList;
        Drawable drawable = materialCardViewHelper.k;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z2) {
        super.setClickable(z2);
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        if (materialCardViewHelper != null) {
            Drawable drawable = materialCardViewHelper.j;
            Drawable drawableE = materialCardViewHelper.c.isClickable() ? materialCardViewHelper.e() : materialCardViewHelper.f;
            materialCardViewHelper.j = drawableE;
            if (drawable != drawableE) {
                if (Build.VERSION.SDK_INT < 23 || !(materialCardViewHelper.c.getForeground() instanceof InsetDrawable)) {
                    materialCardViewHelper.c.setForeground(materialCardViewHelper.f(drawableE));
                } else {
                    ((InsetDrawable) materialCardViewHelper.c.getForeground()).setDrawable(drawableE);
                }
            }
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i, int i2, int i3, int i4) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.d.set(i, i2, i3, i4);
        materialCardViewHelper.k();
    }

    public void setDragged(boolean z2) {
        if (this.dragged != z2) {
            this.dragged = z2;
            refreshDrawableState();
            forceRippleRedrawIfNeeded();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f) {
        super.setMaxCardElevation(f);
        this.cardViewHelper.l();
    }

    public void setOnCheckedChangeListener(@Nullable OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z2) {
        super.setPreventCornerOverlap(z2);
        this.cardViewHelper.l();
        this.cardViewHelper.k();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.e.setInterpolation(f);
        MaterialShapeDrawable materialShapeDrawable = materialCardViewHelper.f;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setInterpolation(f);
        }
        MaterialShapeDrawable materialShapeDrawable2 = materialCardViewHelper.f1607s;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setInterpolation(f);
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f) {
        super.setRadius(f);
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.h(materialCardViewHelper.n.withCornerSize(f));
        materialCardViewHelper.j.invalidateSelf();
        if (materialCardViewHelper.j() || materialCardViewHelper.i()) {
            materialCardViewHelper.k();
        }
        if (materialCardViewHelper.j()) {
            materialCardViewHelper.l();
        }
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.l = colorStateList;
        materialCardViewHelper.m();
    }

    public void setRippleColorResource(@ColorRes int i) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.l = AppCompatResources.getColorStateList(getContext(), i);
        materialCardViewHelper.m();
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        setClipToOutline(shapeAppearanceModel.isRoundRect(getBoundsAsRectF()));
        this.cardViewHelper.h(shapeAppearanceModel);
    }

    public void setStrokeColor(@ColorInt int i) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        if (materialCardViewHelper.o == colorStateListValueOf) {
            return;
        }
        materialCardViewHelper.o = colorStateListValueOf;
        materialCardViewHelper.n();
    }

    public void setStrokeWidth(@Dimension int i) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        if (i == materialCardViewHelper.i) {
            return;
        }
        materialCardViewHelper.i = i;
        materialCardViewHelper.n();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z2) {
        super.setUseCompatPadding(z2);
        this.cardViewHelper.l();
        this.cardViewHelper.k();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (isCheckable() && isEnabled()) {
            this.checked = !this.checked;
            refreshDrawableState();
            forceRippleRedrawIfNeeded();
            OnCheckedChangeListener onCheckedChangeListener = this.onCheckedChangeListener;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(this, this.checked);
            }
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.materialCardViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialCardView(Context context, AttributeSet attributeSet, int i) {
        int i2 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i2), attributeSet, i);
        this.checked = false;
        this.dragged = false;
        this.isParentCardViewDoneInitializing = true;
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(getContext(), attributeSet, com.google.android.material.R.styleable.MaterialCardView, i, i2, new int[0]);
        MaterialCardViewHelper materialCardViewHelper = new MaterialCardViewHelper(this, attributeSet, i, i2);
        this.cardViewHelper = materialCardViewHelper;
        materialCardViewHelper.e.setFillColor(super.getCardBackgroundColor());
        materialCardViewHelper.d.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        materialCardViewHelper.k();
        ColorStateList colorStateList = MaterialResources.getColorStateList(materialCardViewHelper.c.getContext(), typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.MaterialCardView_strokeColor);
        materialCardViewHelper.o = colorStateList;
        if (colorStateList == null) {
            materialCardViewHelper.o = ColorStateList.valueOf(-1);
        }
        materialCardViewHelper.i = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_strokeWidth, 0);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.MaterialCardView_android_checkable, false);
        materialCardViewHelper.u = z2;
        materialCardViewHelper.c.setLongClickable(z2);
        materialCardViewHelper.m = MaterialResources.getColorStateList(materialCardViewHelper.c.getContext(), typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.MaterialCardView_checkedIconTint);
        materialCardViewHelper.g(MaterialResources.getDrawable(materialCardViewHelper.c.getContext(), typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.MaterialCardView_checkedIcon));
        materialCardViewHelper.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_checkedIconSize, 0);
        materialCardViewHelper.g = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_checkedIconMargin, 0);
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(materialCardViewHelper.c.getContext(), typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.MaterialCardView_rippleColor);
        materialCardViewHelper.l = colorStateList2;
        if (colorStateList2 == null) {
            materialCardViewHelper.l = ColorStateList.valueOf(MaterialColors.getColor(materialCardViewHelper.c, com.google.android.material.R.attr.colorControlHighlight));
        }
        ColorStateList colorStateList3 = MaterialResources.getColorStateList(materialCardViewHelper.c.getContext(), typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.MaterialCardView_cardForegroundColor);
        materialCardViewHelper.f.setFillColor(colorStateList3 == null ? ColorStateList.valueOf(0) : colorStateList3);
        materialCardViewHelper.m();
        materialCardViewHelper.e.setElevation(materialCardViewHelper.c.getCardElevation());
        materialCardViewHelper.n();
        materialCardViewHelper.c.setBackgroundInternal(materialCardViewHelper.f(materialCardViewHelper.e));
        Drawable drawableE = materialCardViewHelper.c.isClickable() ? materialCardViewHelper.e() : materialCardViewHelper.f;
        materialCardViewHelper.j = drawableE;
        materialCardViewHelper.c.setForeground(materialCardViewHelper.f(drawableE));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        this.cardViewHelper.e.setFillColor(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        if (materialCardViewHelper.o == colorStateList) {
            return;
        }
        materialCardViewHelper.o = colorStateList;
        materialCardViewHelper.n();
    }
}

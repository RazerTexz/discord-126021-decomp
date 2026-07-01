package com.google.android.material.card;

import android.R$attr;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build$VERSION;
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
import b.i.a.g.c.a;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
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
    private final a cardViewHelper;
    private boolean checked;
    private boolean dragged;
    private boolean isParentCardViewDoneInitializing;
    private MaterialCardView$OnCheckedChangeListener onCheckedChangeListener;
    private static final int[] CHECKABLE_STATE_SET = {R$attr.state_checkable};
    private static final int[] CHECKED_STATE_SET = {R$attr.state_checked};
    private static final int[] DRAGGED_STATE_SET = {com.google.android.material.R$attr.state_dragged};
    private static final int DEF_STYLE_RES = R$style.Widget_MaterialComponents_CardView;

    public MaterialCardView(Context context) {
        this(context, null);
    }

    public static /* synthetic */ float access$001(MaterialCardView materialCardView) {
        return super.getRadius();
    }

    private void forceRippleRedrawIfNeeded() {
        a aVar;
        Drawable drawable;
        if (Build$VERSION.SDK_INT <= 26 || (drawable = (aVar = this.cardViewHelper).p) == null) {
            return;
        }
        Rect bounds = drawable.getBounds();
        int i = bounds.bottom;
        aVar.p.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
        aVar.p.setBounds(bounds.left, bounds.top, bounds.right, i);
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
        return access$001(this);
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
        a aVar = this.cardViewHelper;
        return aVar != null && aVar.u;
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
        a aVar = this.cardViewHelper;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (aVar.q != null) {
            int i5 = aVar.g;
            int i6 = aVar.h;
            int iCeil = (measuredWidth - i5) - i6;
            int iCeil2 = (measuredHeight - i5) - i6;
            if (aVar.c.getUseCompatPadding()) {
                iCeil2 -= (int) Math.ceil(aVar.d() * 2.0f);
                iCeil -= (int) Math.ceil(aVar.c() * 2.0f);
            }
            int i7 = iCeil2;
            int i8 = aVar.g;
            if (ViewCompat.getLayoutDirection(aVar.c) == 1) {
                i4 = iCeil;
                i3 = i8;
            } else {
                i3 = iCeil;
                i4 = i8;
            }
            aVar.q.setLayerInset(2, i3, aVar.g, i4, i7);
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
        a aVar = this.cardViewHelper;
        aVar.e.setFillColor(ColorStateList.valueOf(i));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f) {
        super.setCardElevation(f);
        a aVar = this.cardViewHelper;
        aVar.e.setElevation(aVar.c.getCardElevation());
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
        a aVar = this.cardViewHelper;
        aVar.m = colorStateList;
        Drawable drawable = aVar.k;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z2) {
        super.setClickable(z2);
        a aVar = this.cardViewHelper;
        if (aVar != null) {
            Drawable drawable = aVar.j;
            Drawable drawableE = aVar.c.isClickable() ? aVar.e() : aVar.f;
            aVar.j = drawableE;
            if (drawable != drawableE) {
                if (Build$VERSION.SDK_INT < 23 || !(aVar.c.getForeground() instanceof InsetDrawable)) {
                    aVar.c.setForeground(aVar.f(drawableE));
                } else {
                    ((InsetDrawable) aVar.c.getForeground()).setDrawable(drawableE);
                }
            }
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i, int i2, int i3, int i4) {
        a aVar = this.cardViewHelper;
        aVar.d.set(i, i2, i3, i4);
        aVar.k();
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

    public void setOnCheckedChangeListener(@Nullable MaterialCardView$OnCheckedChangeListener materialCardView$OnCheckedChangeListener) {
        this.onCheckedChangeListener = materialCardView$OnCheckedChangeListener;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z2) {
        super.setPreventCornerOverlap(z2);
        this.cardViewHelper.l();
        this.cardViewHelper.k();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        a aVar = this.cardViewHelper;
        aVar.e.setInterpolation(f);
        MaterialShapeDrawable materialShapeDrawable = aVar.f;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setInterpolation(f);
        }
        MaterialShapeDrawable materialShapeDrawable2 = aVar.f1607s;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setInterpolation(f);
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f) {
        super.setRadius(f);
        a aVar = this.cardViewHelper;
        aVar.h(aVar.n.withCornerSize(f));
        aVar.j.invalidateSelf();
        if (aVar.j() || aVar.i()) {
            aVar.k();
        }
        if (aVar.j()) {
            aVar.l();
        }
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        a aVar = this.cardViewHelper;
        aVar.l = colorStateList;
        aVar.m();
    }

    public void setRippleColorResource(@ColorRes int i) {
        a aVar = this.cardViewHelper;
        aVar.l = AppCompatResources.getColorStateList(getContext(), i);
        aVar.m();
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        setClipToOutline(shapeAppearanceModel.isRoundRect(getBoundsAsRectF()));
        this.cardViewHelper.h(shapeAppearanceModel);
    }

    public void setStrokeColor(@ColorInt int i) {
        a aVar = this.cardViewHelper;
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        if (aVar.o == colorStateListValueOf) {
            return;
        }
        aVar.o = colorStateListValueOf;
        aVar.n();
    }

    public void setStrokeWidth(@Dimension int i) {
        a aVar = this.cardViewHelper;
        if (i == aVar.i) {
            return;
        }
        aVar.i = i;
        aVar.n();
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
            MaterialCardView$OnCheckedChangeListener materialCardView$OnCheckedChangeListener = this.onCheckedChangeListener;
            if (materialCardView$OnCheckedChangeListener != null) {
                materialCardView$OnCheckedChangeListener.onCheckedChanged(this, this.checked);
            }
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R$attr.materialCardViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialCardView(Context context, AttributeSet attributeSet, int i) {
        int i2 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i2), attributeSet, i);
        this.checked = false;
        this.dragged = false;
        this.isParentCardViewDoneInitializing = true;
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(getContext(), attributeSet, R$styleable.MaterialCardView, i, i2, new int[0]);
        a aVar = new a(this, attributeSet, i, i2);
        this.cardViewHelper = aVar;
        aVar.e.setFillColor(super.getCardBackgroundColor());
        aVar.d.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        aVar.k();
        ColorStateList colorStateList = MaterialResources.getColorStateList(aVar.c.getContext(), typedArrayObtainStyledAttributes, R$styleable.MaterialCardView_strokeColor);
        aVar.o = colorStateList;
        if (colorStateList == null) {
            aVar.o = ColorStateList.valueOf(-1);
        }
        aVar.i = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialCardView_strokeWidth, 0);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MaterialCardView_android_checkable, false);
        aVar.u = z2;
        aVar.c.setLongClickable(z2);
        aVar.m = MaterialResources.getColorStateList(aVar.c.getContext(), typedArrayObtainStyledAttributes, R$styleable.MaterialCardView_checkedIconTint);
        aVar.g(MaterialResources.getDrawable(aVar.c.getContext(), typedArrayObtainStyledAttributes, R$styleable.MaterialCardView_checkedIcon));
        aVar.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconSize, 0);
        aVar.g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconMargin, 0);
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(aVar.c.getContext(), typedArrayObtainStyledAttributes, R$styleable.MaterialCardView_rippleColor);
        aVar.l = colorStateList2;
        if (colorStateList2 == null) {
            aVar.l = ColorStateList.valueOf(MaterialColors.getColor(aVar.c, com.google.android.material.R$attr.colorControlHighlight));
        }
        ColorStateList colorStateList3 = MaterialResources.getColorStateList(aVar.c.getContext(), typedArrayObtainStyledAttributes, R$styleable.MaterialCardView_cardForegroundColor);
        aVar.f.setFillColor(colorStateList3 == null ? ColorStateList.valueOf(0) : colorStateList3);
        aVar.m();
        aVar.e.setElevation(aVar.c.getCardElevation());
        aVar.n();
        aVar.c.setBackgroundInternal(aVar.f(aVar.e));
        Drawable drawableE = aVar.c.isClickable() ? aVar.e() : aVar.f;
        aVar.j = drawableE;
        aVar.c.setForeground(aVar.f(drawableE));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        this.cardViewHelper.e.setFillColor(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        a aVar = this.cardViewHelper;
        if (aVar.o == colorStateList) {
            return;
        }
        aVar.o = colorStateList;
        aVar.n();
    }
}

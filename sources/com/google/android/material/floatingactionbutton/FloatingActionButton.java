package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator$AnimatorListener;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver$OnPreDrawListener;
import android.widget.ImageView$ScaleType;
import androidx.annotation.AnimatorRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout$AttachedBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import b.i.a.g.e.c;
import b.i.a.g.e.d;
import b.i.a.g.e.e;
import b.i.a.g.e.f;
import b.i.a.g.e.f$e;
import b.i.a.g.e.f$f;
import b.i.a.g.e.h;
import b.i.a.g.e.i;
import com.google.android.material.R$animator;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.expandable.ExpandableTransformationWidget;
import com.google.android.material.expandable.ExpandableWidgetHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.stateful.ExtendableSavedState;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements TintableBackgroundView, TintableImageSourceView, ExpandableTransformationWidget, Shapeable, CoordinatorLayout$AttachedBehavior {
    private static final int AUTO_MINI_LARGEST_SCREEN_WIDTH = 470;
    private static final int DEF_STYLE_RES = R$style.Widget_Design_FloatingActionButton;
    private static final String EXPANDABLE_WIDGET_HELPER_KEY = "expandableWidgetHelper";
    private static final String LOG_TAG = "FloatingActionButton";
    public static final int NO_CUSTOM_SIZE = 0;
    public static final int SIZE_AUTO = -1;
    public static final int SIZE_MINI = 1;
    public static final int SIZE_NORMAL = 0;

    @Nullable
    private ColorStateList backgroundTint;

    @Nullable
    private PorterDuff$Mode backgroundTintMode;
    private int borderWidth;
    public boolean compatPadding;
    private int customSize;

    @NonNull
    private final ExpandableWidgetHelper expandableWidgetHelper;

    @NonNull
    private final AppCompatImageHelper imageHelper;

    @Nullable
    private PorterDuff$Mode imageMode;
    private int imagePadding;

    @Nullable
    private ColorStateList imageTint;
    private f impl;
    private int maxImageSize;

    @Nullable
    private ColorStateList rippleColor;
    public final Rect shadowPadding;
    private int size;
    private final Rect touchArea;

    public FloatingActionButton(@NonNull Context context) {
        this(context, null);
    }

    public static /* synthetic */ int access$000(FloatingActionButton floatingActionButton) {
        return floatingActionButton.imagePadding;
    }

    public static /* synthetic */ void access$101(FloatingActionButton floatingActionButton, Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @NonNull
    private f createImpl() {
        return new i(this, new FloatingActionButton$b(this));
    }

    private f getImpl() {
        if (this.impl == null) {
            this.impl = createImpl();
        }
        return this.impl;
    }

    private void offsetRectWithShadow(@NonNull Rect rect) {
        int i = rect.left;
        Rect rect2 = this.shadowPadding;
        rect.left = i + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void onApplySupportImageTint() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.imageTint;
        if (colorStateList == null) {
            DrawableCompat.clearColorFilter(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff$Mode porterDuff$Mode = this.imageMode;
        if (porterDuff$Mode == null) {
            porterDuff$Mode = PorterDuff$Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(colorForState, porterDuff$Mode));
    }

    private static int resolveAdjustedSize(int i, int i2) {
        int mode = View$MeasureSpec.getMode(i2);
        int size = View$MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i, size);
        }
        if (mode == 0) {
            return i;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    @Nullable
    private f$f wrapOnVisibilityChangedListener(@Nullable FloatingActionButton$OnVisibilityChangedListener floatingActionButton$OnVisibilityChangedListener) {
        if (floatingActionButton$OnVisibilityChangedListener == null) {
            return null;
        }
        return new FloatingActionButton$a(this, floatingActionButton$OnVisibilityChangedListener);
    }

    public void addOnHideAnimationListener(@NonNull Animator$AnimatorListener animator$AnimatorListener) {
        f impl = getImpl();
        if (impl.D == null) {
            impl.D = new ArrayList<>();
        }
        impl.D.add(animator$AnimatorListener);
    }

    public void addOnShowAnimationListener(@NonNull Animator$AnimatorListener animator$AnimatorListener) {
        f impl = getImpl();
        if (impl.C == null) {
            impl.C = new ArrayList<>();
        }
        impl.C.add(animator$AnimatorListener);
    }

    public void addTransformationCallback(@NonNull TransformationCallback<? extends FloatingActionButton> transformationCallback) {
        f impl = getImpl();
        FloatingActionButton$c floatingActionButton$c = new FloatingActionButton$c(this, transformationCallback);
        if (impl.E == null) {
            impl.E = new ArrayList<>();
        }
        impl.E.add(floatingActionButton$c);
    }

    public void clearCustomSize() {
        setCustomSize(0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().k(getDrawableState());
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return this.backgroundTint;
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff$Mode getBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$AttachedBehavior
    @NonNull
    public CoordinatorLayout$Behavior<FloatingActionButton> getBehavior() {
        return new FloatingActionButton$Behavior();
    }

    public float getCompatElevation() {
        return getImpl().d();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().p;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().q;
    }

    @Nullable
    public Drawable getContentBackground() {
        return getImpl().l;
    }

    @Deprecated
    public boolean getContentRect(@NonNull Rect rect) {
        if (!ViewCompat.isLaidOut(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        offsetRectWithShadow(rect);
        return true;
    }

    @Px
    public int getCustomSize() {
        return this.customSize;
    }

    @Override // com.google.android.material.expandable.ExpandableTransformationWidget
    public int getExpandedComponentIdHint() {
        return this.expandableWidgetHelper.getExpandedComponentIdHint();
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        return getImpl().f1617x;
    }

    public void getMeasuredContentRect(@NonNull Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        offsetRectWithShadow(rect);
    }

    @ColorInt
    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.rippleColor;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    @Nullable
    public ColorStateList getRippleColorStateList() {
        return this.rippleColor;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return (ShapeAppearanceModel) Preconditions.checkNotNull(getImpl().h);
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        return getImpl().w;
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeDimension() {
        return getSizeDimension(this.size);
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public PorterDuff$Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    public ColorStateList getSupportImageTintList() {
        return this.imageTint;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    public PorterDuff$Mode getSupportImageTintMode() {
        return this.imageMode;
    }

    public boolean getUseCompatPadding() {
        return this.compatPadding;
    }

    public void hide() {
        hide(null);
    }

    @Override // com.google.android.material.expandable.ExpandableWidget
    public boolean isExpanded() {
        return this.expandableWidgetHelper.isExpanded();
    }

    public boolean isOrWillBeHidden() {
        return getImpl().g();
    }

    public boolean isOrWillBeShown() {
        return getImpl().h();
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().i();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f impl = getImpl();
        MaterialShapeDrawable materialShapeDrawable = impl.i;
        if (materialShapeDrawable != null) {
            MaterialShapeUtils.setParentAbsoluteElevation(impl.F, materialShapeDrawable);
        }
        if (!(impl instanceof i)) {
            ViewTreeObserver viewTreeObserver = impl.F.getViewTreeObserver();
            if (impl.L == null) {
                impl.L = new h(impl);
            }
            viewTreeObserver.addOnPreDrawListener(impl.L);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.F.getViewTreeObserver();
        ViewTreeObserver$OnPreDrawListener viewTreeObserver$OnPreDrawListener = impl.L;
        if (viewTreeObserver$OnPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(viewTreeObserver$OnPreDrawListener);
            impl.L = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.imagePadding = (sizeDimension - this.maxImageSize) / 2;
        getImpl().v();
        int iMin = Math.min(resolveAdjustedSize(sizeDimension, i), resolveAdjustedSize(sizeDimension, i2));
        Rect rect = this.shadowPadding;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.getSuperState());
        this.expandableWidgetHelper.onRestoreInstanceState((Bundle) Preconditions.checkNotNull(extendableSavedState.extendableStates.get(EXPANDABLE_WIDGET_HELPER_KEY)));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(parcelableOnSaveInstanceState);
        extendableSavedState.extendableStates.put(EXPANDABLE_WIDGET_HELPER_KEY, this.expandableWidgetHelper.onSaveInstanceState());
        return extendableSavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && getContentRect(this.touchArea) && !this.touchArea.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void removeOnHideAnimationListener(@NonNull Animator$AnimatorListener animator$AnimatorListener) {
        ArrayList<Animator$AnimatorListener> arrayList = getImpl().D;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animator$AnimatorListener);
    }

    public void removeOnShowAnimationListener(@NonNull Animator$AnimatorListener animator$AnimatorListener) {
        ArrayList<Animator$AnimatorListener> arrayList = getImpl().C;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animator$AnimatorListener);
    }

    public void removeTransformationCallback(@NonNull TransformationCallback<? extends FloatingActionButton> transformationCallback) {
        f impl = getImpl();
        FloatingActionButton$c floatingActionButton$c = new FloatingActionButton$c(this, transformationCallback);
        ArrayList<f$e> arrayList = impl.E;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(floatingActionButton$c);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.i(LOG_TAG, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i(LOG_TAG, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Log.i(LOG_TAG, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.backgroundTint != colorStateList) {
            this.backgroundTint = colorStateList;
            f impl = getImpl();
            MaterialShapeDrawable materialShapeDrawable = impl.i;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setTintList(colorStateList);
            }
            c cVar = impl.k;
            if (cVar != null) {
                cVar.b(colorStateList);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff$Mode porterDuff$Mode) {
        if (this.backgroundTintMode != porterDuff$Mode) {
            this.backgroundTintMode = porterDuff$Mode;
            MaterialShapeDrawable materialShapeDrawable = getImpl().i;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setTintMode(porterDuff$Mode);
            }
        }
    }

    public void setCompatElevation(float f) {
        f impl = getImpl();
        if (impl.o != f) {
            impl.o = f;
            impl.l(f, impl.p, impl.q);
        }
    }

    public void setCompatElevationResource(@DimenRes int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        f impl = getImpl();
        if (impl.p != f) {
            impl.p = f;
            impl.l(impl.o, f, impl.q);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(@DimenRes int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public void setCompatPressedTranslationZ(float f) {
        f impl = getImpl();
        if (impl.q != f) {
            impl.q = f;
            impl.l(impl.o, impl.p, f);
        }
    }

    public void setCompatPressedTranslationZResource(@DimenRes int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public void setCustomSize(@Px int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i != this.customSize) {
            this.customSize = i;
            requestLayout();
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f) {
        super.setElevation(f);
        MaterialShapeDrawable materialShapeDrawable = getImpl().i;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setElevation(f);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        if (z2 != getImpl().m) {
            getImpl().m = z2;
            requestLayout();
        }
    }

    @Override // com.google.android.material.expandable.ExpandableWidget
    public boolean setExpanded(boolean z2) {
        return this.expandableWidgetHelper.setExpanded(z2);
    }

    @Override // com.google.android.material.expandable.ExpandableTransformationWidget
    public void setExpandedComponentIdHint(@IdRes int i) {
        this.expandableWidgetHelper.setExpandedComponentIdHint(i);
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        getImpl().f1617x = motionSpec;
    }

    public void setHideMotionSpecResource(@AnimatorRes int i) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            f impl = getImpl();
            impl.o(impl.f1619z);
            if (this.imageTint != null) {
                onApplySupportImageTint();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i) {
        this.imageHelper.setImageResource(i);
        onApplySupportImageTint();
    }

    public void setRippleColor(@ColorInt int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        super.setScaleX(f);
        getImpl().m();
    }

    @Override // android.view.View
    public void setScaleY(float f) {
        super.setScaleY(f);
        getImpl().m();
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setShadowPaddingEnabled(boolean z2) {
        f impl = getImpl();
        impl.n = z2;
        impl.v();
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        getImpl().q(shapeAppearanceModel);
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        getImpl().w = motionSpec;
    }

    public void setShowMotionSpecResource(@AnimatorRes int i) {
        setShowMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    public void setSize(int i) {
        this.customSize = 0;
        if (i != this.size) {
            this.size = i;
            requestLayout();
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(@Nullable PorterDuff$Mode porterDuff$Mode) {
        setBackgroundTintMode(porterDuff$Mode);
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        if (this.imageTint != colorStateList) {
            this.imageTint = colorStateList;
            onApplySupportImageTint();
        }
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintMode(@Nullable PorterDuff$Mode porterDuff$Mode) {
        if (this.imageMode != porterDuff$Mode) {
            this.imageMode = porterDuff$Mode;
            onApplySupportImageTint();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        super.setTranslationX(f);
        getImpl().n();
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        getImpl().n();
    }

    @Override // android.view.View
    public void setTranslationZ(float f) {
        super.setTranslationZ(f);
        getImpl().n();
    }

    public void setUseCompatPadding(boolean z2) {
        if (this.compatPadding != z2) {
            this.compatPadding = z2;
            getImpl().j();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return getImpl().m;
    }

    public void show() {
        show(null);
    }

    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.floatingActionButtonStyle);
    }

    private int getSizeDimension(int i) {
        int i2 = this.customSize;
        if (i2 != 0) {
            return i2;
        }
        Resources resources = getResources();
        if (i != -1) {
            return i != 1 ? resources.getDimensionPixelSize(R$dimen.design_fab_size_normal) : resources.getDimensionPixelSize(R$dimen.design_fab_size_mini);
        }
        return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < AUTO_MINI_LARGEST_SCREEN_WIDTH ? getSizeDimension(1) : getSizeDimension(0);
    }

    public void hide(@Nullable FloatingActionButton$OnVisibilityChangedListener floatingActionButton$OnVisibilityChangedListener) {
        hide(floatingActionButton$OnVisibilityChangedListener, true);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            getImpl().p(this.rippleColor);
        }
    }

    public void show(@Nullable FloatingActionButton$OnVisibilityChangedListener floatingActionButton$OnVisibilityChangedListener) {
        show(floatingActionButton$OnVisibilityChangedListener, true);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        int i2 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i2), attributeSet, i);
        this.shadowPadding = new Rect();
        this.touchArea = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R$styleable.FloatingActionButton, i, i2, new int[0]);
        this.backgroundTint = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, R$styleable.FloatingActionButton_backgroundTint);
        this.backgroundTintMode = ViewUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(R$styleable.FloatingActionButton_backgroundTintMode, -1), null);
        this.rippleColor = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, R$styleable.FloatingActionButton_rippleColor);
        this.size = typedArrayObtainStyledAttributes.getInt(R$styleable.FloatingActionButton_fabSize, -1);
        this.customSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatingActionButton_fabCustomSize, 0);
        this.borderWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatingActionButton_borderWidth, 0);
        float dimension = typedArrayObtainStyledAttributes.getDimension(R$styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(R$styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(R$styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.compatPadding = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_useCompatPadding, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.mtrl_fab_min_touch_target);
        this.maxImageSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatingActionButton_maxImageSize, 0);
        MotionSpec motionSpecCreateFromAttribute = MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, R$styleable.FloatingActionButton_showMotionSpec);
        MotionSpec motionSpecCreateFromAttribute2 = MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, R$styleable.FloatingActionButton_hideMotionSpec);
        ShapeAppearanceModel shapeAppearanceModelBuild = ShapeAppearanceModel.builder(context2, attributeSet, i, i2, ShapeAppearanceModel.PILL).build();
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_android_enabled, true));
        typedArrayObtainStyledAttributes.recycle();
        AppCompatImageHelper appCompatImageHelper = new AppCompatImageHelper(this);
        this.imageHelper = appCompatImageHelper;
        appCompatImageHelper.loadFromAttributes(attributeSet, i);
        this.expandableWidgetHelper = new ExpandableWidgetHelper(this);
        getImpl().q(shapeAppearanceModelBuild);
        getImpl().f(this.backgroundTint, this.backgroundTintMode, this.rippleColor, this.borderWidth);
        getImpl().r = dimensionPixelSize;
        f impl = getImpl();
        if (impl.o != dimension) {
            impl.o = dimension;
            impl.l(dimension, impl.p, impl.q);
        }
        f impl2 = getImpl();
        if (impl2.p != dimension2) {
            impl2.p = dimension2;
            impl2.l(impl2.o, dimension2, impl2.q);
        }
        f impl3 = getImpl();
        if (impl3.q != dimension3) {
            impl3.q = dimension3;
            impl3.l(impl3.o, impl3.p, dimension3);
        }
        f impl4 = getImpl();
        int i3 = this.maxImageSize;
        if (impl4.A != i3) {
            impl4.A = i3;
            impl4.o(impl4.f1619z);
        }
        getImpl().w = motionSpecCreateFromAttribute;
        getImpl().f1617x = motionSpecCreateFromAttribute2;
        getImpl().m = z2;
        setScaleType(ImageView$ScaleType.MATRIX);
    }

    public void hide(@Nullable FloatingActionButton$OnVisibilityChangedListener floatingActionButton$OnVisibilityChangedListener, boolean z2) {
        f impl = getImpl();
        f$f f_fWrapOnVisibilityChangedListener = wrapOnVisibilityChangedListener(floatingActionButton$OnVisibilityChangedListener);
        if (impl.g()) {
            return;
        }
        Animator animator = impl.v;
        if (animator != null) {
            animator.cancel();
        }
        if (impl.s()) {
            MotionSpec motionSpec = impl.f1617x;
            if (motionSpec == null) {
                if (impl.u == null) {
                    impl.u = MotionSpec.createFromResource(impl.F.getContext(), R$animator.design_fab_hide_motion_spec);
                }
                motionSpec = (MotionSpec) Preconditions.checkNotNull(impl.u);
            }
            AnimatorSet animatorSetB = impl.b(motionSpec, 0.0f, 0.0f, 0.0f);
            animatorSetB.addListener(new d(impl, z2, f_fWrapOnVisibilityChangedListener));
            ArrayList<Animator$AnimatorListener> arrayList = impl.D;
            if (arrayList != null) {
                Iterator<Animator$AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    animatorSetB.addListener(it.next());
                }
            }
            animatorSetB.start();
            return;
        }
        impl.F.internalSetVisibility(z2 ? 8 : 4, z2);
        if (f_fWrapOnVisibilityChangedListener != null) {
            FloatingActionButton$a floatingActionButton$a = (FloatingActionButton$a) f_fWrapOnVisibilityChangedListener;
            floatingActionButton$a.a.onHidden(floatingActionButton$a.f3040b);
        }
    }

    public void show(@Nullable FloatingActionButton$OnVisibilityChangedListener floatingActionButton$OnVisibilityChangedListener, boolean z2) {
        f impl = getImpl();
        f$f f_fWrapOnVisibilityChangedListener = wrapOnVisibilityChangedListener(floatingActionButton$OnVisibilityChangedListener);
        if (impl.h()) {
            return;
        }
        Animator animator = impl.v;
        if (animator != null) {
            animator.cancel();
        }
        if (impl.s()) {
            if (impl.F.getVisibility() != 0) {
                impl.F.setAlpha(0.0f);
                impl.F.setScaleY(0.0f);
                impl.F.setScaleX(0.0f);
                impl.o(0.0f);
            }
            MotionSpec motionSpec = impl.w;
            if (motionSpec == null) {
                if (impl.t == null) {
                    impl.t = MotionSpec.createFromResource(impl.F.getContext(), R$animator.design_fab_show_motion_spec);
                }
                motionSpec = (MotionSpec) Preconditions.checkNotNull(impl.t);
            }
            AnimatorSet animatorSetB = impl.b(motionSpec, 1.0f, 1.0f, 1.0f);
            animatorSetB.addListener(new e(impl, z2, f_fWrapOnVisibilityChangedListener));
            ArrayList<Animator$AnimatorListener> arrayList = impl.C;
            if (arrayList != null) {
                Iterator<Animator$AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    animatorSetB.addListener(it.next());
                }
            }
            animatorSetB.start();
            return;
        }
        impl.F.internalSetVisibility(0, z2);
        impl.F.setAlpha(1.0f);
        impl.F.setScaleY(1.0f);
        impl.F.setScaleX(1.0f);
        impl.o(1.0f);
        if (f_fWrapOnVisibilityChangedListener != null) {
            FloatingActionButton$a floatingActionButton$a = (FloatingActionButton$a) f_fWrapOnVisibilityChangedListener;
            floatingActionButton$a.a.onShown(floatingActionButton$a.f3040b);
        }
    }
}

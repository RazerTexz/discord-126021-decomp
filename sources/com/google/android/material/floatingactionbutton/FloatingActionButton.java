package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
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
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import com.google.android.material.C10817R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.expandable.ExpandableTransformationWidget;
import com.google.android.material.expandable.ExpandableWidgetHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.stateful.ExtendableSavedState;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p007b.p225i.p226a.p341g.p346e.C4405c;
import p007b.p225i.p226a.p341g.p346e.C4406d;
import p007b.p225i.p226a.p341g.p346e.C4407e;
import p007b.p225i.p226a.p341g.p346e.C4408f;
import p007b.p225i.p226a.p341g.p346e.C4411i;
import p007b.p225i.p226a.p341g.p346e.ViewTreeObserverOnPreDrawListenerC4410h;

/* JADX INFO: loaded from: classes3.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements TintableBackgroundView, TintableImageSourceView, ExpandableTransformationWidget, Shapeable, CoordinatorLayout.AttachedBehavior {
    private static final int AUTO_MINI_LARGEST_SCREEN_WIDTH = 470;
    private static final int DEF_STYLE_RES = C10817R.style.Widget_Design_FloatingActionButton;
    private static final String EXPANDABLE_WIDGET_HELPER_KEY = "expandableWidgetHelper";
    private static final String LOG_TAG = "FloatingActionButton";
    public static final int NO_CUSTOM_SIZE = 0;
    public static final int SIZE_AUTO = -1;
    public static final int SIZE_MINI = 1;
    public static final int SIZE_NORMAL = 0;

    @Nullable
    private ColorStateList backgroundTint;

    @Nullable
    private PorterDuff.Mode backgroundTintMode;
    private int borderWidth;
    public boolean compatPadding;
    private int customSize;

    @NonNull
    private final ExpandableWidgetHelper expandableWidgetHelper;

    @NonNull
    private final AppCompatImageHelper imageHelper;

    @Nullable
    private PorterDuff.Mode imageMode;
    private int imagePadding;

    @Nullable
    private ColorStateList imageTint;
    private C4408f impl;
    private int maxImageSize;

    @Nullable
    private ColorStateList rippleColor;
    public final Rect shadowPadding;
    private int size;
    private final Rect touchArea;

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private static final boolean AUTO_HIDE_DEFAULT = true;
        private boolean autoHideEnabled;
        private OnVisibilityChangedListener internalAutoHideListener;
        private Rect tmpRect;

        public BaseBehavior() {
            this.autoHideEnabled = true;
        }

        private static boolean isBottomSheet(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void offsetIfNeeded(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton) {
            int i;
            Rect rect = floatingActionButton.shadowPadding;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
            int i2 = 0;
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) {
                i = rect.right;
            } else {
                i = floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) {
                i2 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) {
                i2 = -rect.top;
            }
            if (i2 != 0) {
                ViewCompat.offsetTopAndBottom(floatingActionButton, i2);
            }
            if (i != 0) {
                ViewCompat.offsetLeftAndRight(floatingActionButton, i);
            }
        }

        private boolean shouldUpdateVisibility(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            return this.autoHideEnabled && ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).getAnchorId() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull FloatingActionButton floatingActionButton) {
            if (!shouldUpdateVisibility(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.tmpRect == null) {
                this.tmpRect = new Rect();
            }
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.hide(this.internalAutoHideListener, false);
                return true;
            }
            floatingActionButton.show(this.internalAutoHideListener, false);
            return true;
        }

        private boolean updateFabVisibilityForBottomSheet(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            if (!shouldUpdateVisibility(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.hide(this.internalAutoHideListener, false);
                return true;
            }
            floatingActionButton.show(this.internalAutoHideListener, false);
            return true;
        }

        public boolean isAutoHideEnabled() {
            return this.autoHideEnabled;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        public void setAutoHideEnabled(boolean z2) {
            this.autoHideEnabled = z2;
        }

        @VisibleForTesting
        public void setInternalAutoHideListener(OnVisibilityChangedListener onVisibilityChangedListener) {
            this.internalAutoHideListener = onVisibilityChangedListener;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            Rect rect2 = floatingActionButton.shadowPadding;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!isBottomSheet(view)) {
                return false;
            }
            updateFabVisibilityForBottomSheet(view, floatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i) {
            List<View> dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = dependencies.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (isBottomSheet(view) && updateFabVisibilityForBottomSheet(view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(floatingActionButton, i);
            offsetIfNeeded(coordinatorLayout, floatingActionButton);
            return true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10817R.styleable.FloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = typedArrayObtainStyledAttributes.getBoolean(C10817R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean isAutoHideEnabled() {
            return super.isAutoHideEnabled();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            super.onAttachedToLayoutParams(layoutParams);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view) {
            return super.onDependentViewChanged(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i) {
            return super.onLayoutChild(coordinatorLayout, floatingActionButton, i);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ void setAutoHideEnabled(boolean z2) {
            super.setAutoHideEnabled(z2);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        @VisibleForTesting
        public /* bridge */ /* synthetic */ void setInternalAutoHideListener(OnVisibilityChangedListener onVisibilityChangedListener) {
            super.setInternalAutoHideListener(onVisibilityChangedListener);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static abstract class OnVisibilityChangedListener {
        public void onHidden(FloatingActionButton floatingActionButton) {
        }

        public void onShown(FloatingActionButton floatingActionButton) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Size {
    }

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.FloatingActionButton$a */
    public class C10919a implements C4408f.f {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ OnVisibilityChangedListener f21018a;

        public C10919a(OnVisibilityChangedListener onVisibilityChangedListener) {
            this.f21018a = onVisibilityChangedListener;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.FloatingActionButton$b */
    public class C10920b implements ShadowViewDelegate {
        public C10920b() {
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public float getRadius() {
            return FloatingActionButton.this.getSizeDimension() / 2.0f;
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public boolean isCompatPaddingEnabled() {
            return FloatingActionButton.this.compatPadding;
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public void setShadowPadding(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.shadowPadding.set(i, i2, i3, i4);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(floatingActionButton.imagePadding + i, FloatingActionButton.this.imagePadding + i2, FloatingActionButton.this.imagePadding + i3, FloatingActionButton.this.imagePadding + i4);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.FloatingActionButton$c */
    public class C10921c<T extends FloatingActionButton> implements C4408f.e {

        /* JADX INFO: renamed from: a */
        @NonNull
        public final TransformationCallback<T> f21021a;

        public C10921c(TransformationCallback<T> transformationCallback) {
            this.f21021a = transformationCallback;
        }

        @Override // p007b.p225i.p226a.p341g.p346e.C4408f.e
        /* JADX INFO: renamed from: a */
        public void mo6109a() {
            this.f21021a.onTranslationChanged(FloatingActionButton.this);
        }

        @Override // p007b.p225i.p226a.p341g.p346e.C4408f.e
        /* JADX INFO: renamed from: b */
        public void mo6110b() {
            this.f21021a.onScaleChanged(FloatingActionButton.this);
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof C10921c) && ((C10921c) obj).f21021a.equals(this.f21021a);
        }

        public int hashCode() {
            return this.f21021a.hashCode();
        }
    }

    public FloatingActionButton(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    private C4408f createImpl() {
        return new C4411i(this, new C10920b());
    }

    private C4408f getImpl() {
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
        PorterDuff.Mode mode = this.imageMode;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(colorForState, mode));
    }

    private static int resolveAdjustedSize(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
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
    private C4408f.f wrapOnVisibilityChangedListener(@Nullable OnVisibilityChangedListener onVisibilityChangedListener) {
        if (onVisibilityChangedListener == null) {
            return null;
        }
        return new C10919a(onVisibilityChangedListener);
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        C4408f impl = getImpl();
        if (impl.f11662D == null) {
            impl.f11662D = new ArrayList<>();
        }
        impl.f11662D.add(animatorListener);
    }

    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        C4408f impl = getImpl();
        if (impl.f11661C == null) {
            impl.f11661C = new ArrayList<>();
        }
        impl.f11661C.add(animatorListener);
    }

    public void addTransformationCallback(@NonNull TransformationCallback<? extends FloatingActionButton> transformationCallback) {
        C4408f impl = getImpl();
        C10921c c10921c = new C10921c(transformationCallback);
        if (impl.f11663E == null) {
            impl.f11663E = new ArrayList<>();
        }
        impl.f11663E.add(c10921c);
    }

    public void clearCustomSize() {
        setCustomSize(0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().mo6095k(getDrawableState());
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return this.backgroundTint;
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().mo6088d();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().f11679p;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().f11680q;
    }

    @Nullable
    public Drawable getContentBackground() {
        return getImpl().f11675l;
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
        return getImpl().f11687x;
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
        return (ShapeAppearanceModel) Preconditions.checkNotNull(getImpl().f11671h);
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        return getImpl().f11686w;
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
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    public ColorStateList getSupportImageTintList() {
        return this.imageTint;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    public PorterDuff.Mode getSupportImageTintMode() {
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
        return getImpl().m6091g();
    }

    public boolean isOrWillBeShown() {
        return getImpl().m6092h();
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().mo6093i();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C4408f impl = getImpl();
        MaterialShapeDrawable materialShapeDrawable = impl.f11672i;
        if (materialShapeDrawable != null) {
            MaterialShapeUtils.setParentAbsoluteElevation(impl.f11664F, materialShapeDrawable);
        }
        if (!(impl instanceof C4411i)) {
            ViewTreeObserver viewTreeObserver = impl.f11664F.getViewTreeObserver();
            if (impl.f11670L == null) {
                impl.f11670L = new ViewTreeObserverOnPreDrawListenerC4410h(impl);
            }
            viewTreeObserver.addOnPreDrawListener(impl.f11670L);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C4408f impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.f11664F.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = impl.f11670L;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            impl.f11670L = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.imagePadding = (sizeDimension - this.maxImageSize) / 2;
        getImpl().m6106v();
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

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = getImpl().f11662D;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = getImpl().f11661C;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void removeTransformationCallback(@NonNull TransformationCallback<? extends FloatingActionButton> transformationCallback) {
        C4408f impl = getImpl();
        C10921c c10921c = new C10921c(transformationCallback);
        ArrayList<C4408f.e> arrayList = impl.f11663E;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(c10921c);
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
            C4408f impl = getImpl();
            MaterialShapeDrawable materialShapeDrawable = impl.f11672i;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setTintList(colorStateList);
            }
            C4405c c4405c = impl.f11674k;
            if (c4405c != null) {
                c4405c.m6084b(colorStateList);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.backgroundTintMode != mode) {
            this.backgroundTintMode = mode;
            MaterialShapeDrawable materialShapeDrawable = getImpl().f11672i;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setTintMode(mode);
            }
        }
    }

    public void setCompatElevation(float f) {
        C4408f impl = getImpl();
        if (impl.f11678o != f) {
            impl.f11678o = f;
            impl.mo6096l(f, impl.f11679p, impl.f11680q);
        }
    }

    public void setCompatElevationResource(@DimenRes int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        C4408f impl = getImpl();
        if (impl.f11679p != f) {
            impl.f11679p = f;
            impl.mo6096l(impl.f11678o, f, impl.f11680q);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(@DimenRes int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public void setCompatPressedTranslationZ(float f) {
        C4408f impl = getImpl();
        if (impl.f11680q != f) {
            impl.f11680q = f;
            impl.mo6096l(impl.f11678o, impl.f11679p, f);
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
        MaterialShapeDrawable materialShapeDrawable = getImpl().f11672i;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setElevation(f);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        if (z2 != getImpl().f11676m) {
            getImpl().f11676m = z2;
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
        getImpl().f11687x = motionSpec;
    }

    public void setHideMotionSpecResource(@AnimatorRes int i) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            C4408f impl = getImpl();
            impl.m6099o(impl.f11689z);
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
        getImpl().m6097m();
    }

    @Override // android.view.View
    public void setScaleY(float f) {
        super.setScaleY(f);
        getImpl().m6097m();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setShadowPaddingEnabled(boolean z2) {
        C4408f impl = getImpl();
        impl.f11677n = z2;
        impl.m6106v();
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        getImpl().m6101q(shapeAppearanceModel);
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        getImpl().f11686w = motionSpec;
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
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        if (this.imageTint != colorStateList) {
            this.imageTint = colorStateList;
            onApplySupportImageTint();
        }
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.imageMode != mode) {
            this.imageMode = mode;
            onApplySupportImageTint();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        super.setTranslationX(f);
        getImpl().m6098n();
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        getImpl().m6098n();
    }

    @Override // android.view.View
    public void setTranslationZ(float f) {
        super.setTranslationZ(f);
        getImpl().m6098n();
    }

    public void setUseCompatPadding(boolean z2) {
        if (this.compatPadding != z2) {
            this.compatPadding = z2;
            getImpl().mo6094j();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return getImpl().f11676m;
    }

    public void show() {
        show(null);
    }

    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C10817R.attr.floatingActionButtonStyle);
    }

    private int getSizeDimension(int i) {
        int i2 = this.customSize;
        if (i2 != 0) {
            return i2;
        }
        Resources resources = getResources();
        if (i != -1) {
            return i != 1 ? resources.getDimensionPixelSize(C10817R.dimen.design_fab_size_normal) : resources.getDimensionPixelSize(C10817R.dimen.design_fab_size_mini);
        }
        return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < AUTO_MINI_LARGEST_SCREEN_WIDTH ? getSizeDimension(1) : getSizeDimension(0);
    }

    public void hide(@Nullable OnVisibilityChangedListener onVisibilityChangedListener) {
        hide(onVisibilityChangedListener, true);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            getImpl().mo6100p(this.rippleColor);
        }
    }

    public void show(@Nullable OnVisibilityChangedListener onVisibilityChangedListener) {
        show(onVisibilityChangedListener, true);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        int i2 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i2), attributeSet, i);
        this.shadowPadding = new Rect();
        this.touchArea = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, C10817R.styleable.FloatingActionButton, i, i2, new int[0]);
        this.backgroundTint = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, C10817R.styleable.FloatingActionButton_backgroundTint);
        this.backgroundTintMode = ViewUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(C10817R.styleable.FloatingActionButton_backgroundTintMode, -1), null);
        this.rippleColor = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, C10817R.styleable.FloatingActionButton_rippleColor);
        this.size = typedArrayObtainStyledAttributes.getInt(C10817R.styleable.FloatingActionButton_fabSize, -1);
        this.customSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10817R.styleable.FloatingActionButton_fabCustomSize, 0);
        this.borderWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10817R.styleable.FloatingActionButton_borderWidth, 0);
        float dimension = typedArrayObtainStyledAttributes.getDimension(C10817R.styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(C10817R.styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(C10817R.styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.compatPadding = typedArrayObtainStyledAttributes.getBoolean(C10817R.styleable.FloatingActionButton_useCompatPadding, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(C10817R.dimen.mtrl_fab_min_touch_target);
        this.maxImageSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10817R.styleable.FloatingActionButton_maxImageSize, 0);
        MotionSpec motionSpecCreateFromAttribute = MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, C10817R.styleable.FloatingActionButton_showMotionSpec);
        MotionSpec motionSpecCreateFromAttribute2 = MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, C10817R.styleable.FloatingActionButton_hideMotionSpec);
        ShapeAppearanceModel shapeAppearanceModelBuild = ShapeAppearanceModel.builder(context2, attributeSet, i, i2, ShapeAppearanceModel.PILL).build();
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(C10817R.styleable.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(C10817R.styleable.FloatingActionButton_android_enabled, true));
        typedArrayObtainStyledAttributes.recycle();
        AppCompatImageHelper appCompatImageHelper = new AppCompatImageHelper(this);
        this.imageHelper = appCompatImageHelper;
        appCompatImageHelper.loadFromAttributes(attributeSet, i);
        this.expandableWidgetHelper = new ExpandableWidgetHelper(this);
        getImpl().m6101q(shapeAppearanceModelBuild);
        getImpl().mo6090f(this.backgroundTint, this.backgroundTintMode, this.rippleColor, this.borderWidth);
        getImpl().f11681r = dimensionPixelSize;
        C4408f impl = getImpl();
        if (impl.f11678o != dimension) {
            impl.f11678o = dimension;
            impl.mo6096l(dimension, impl.f11679p, impl.f11680q);
        }
        C4408f impl2 = getImpl();
        if (impl2.f11679p != dimension2) {
            impl2.f11679p = dimension2;
            impl2.mo6096l(impl2.f11678o, dimension2, impl2.f11680q);
        }
        C4408f impl3 = getImpl();
        if (impl3.f11680q != dimension3) {
            impl3.f11680q = dimension3;
            impl3.mo6096l(impl3.f11678o, impl3.f11679p, dimension3);
        }
        C4408f impl4 = getImpl();
        int i3 = this.maxImageSize;
        if (impl4.f11659A != i3) {
            impl4.f11659A = i3;
            impl4.m6099o(impl4.f11689z);
        }
        getImpl().f11686w = motionSpecCreateFromAttribute;
        getImpl().f11687x = motionSpecCreateFromAttribute2;
        getImpl().f11676m = z2;
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void hide(@Nullable OnVisibilityChangedListener onVisibilityChangedListener, boolean z2) {
        C4408f impl = getImpl();
        C4408f.f fVarWrapOnVisibilityChangedListener = wrapOnVisibilityChangedListener(onVisibilityChangedListener);
        if (impl.m6091g()) {
            return;
        }
        Animator animator = impl.f11685v;
        if (animator != null) {
            animator.cancel();
        }
        if (impl.m6103s()) {
            MotionSpec motionSpec = impl.f11687x;
            if (motionSpec == null) {
                if (impl.f11684u == null) {
                    impl.f11684u = MotionSpec.createFromResource(impl.f11664F.getContext(), C10817R.animator.design_fab_hide_motion_spec);
                }
                motionSpec = (MotionSpec) Preconditions.checkNotNull(impl.f11684u);
            }
            AnimatorSet animatorSetM6086b = impl.m6086b(motionSpec, 0.0f, 0.0f, 0.0f);
            animatorSetM6086b.addListener(new C4406d(impl, z2, fVarWrapOnVisibilityChangedListener));
            ArrayList<Animator.AnimatorListener> arrayList = impl.f11662D;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    animatorSetM6086b.addListener(it.next());
                }
            }
            animatorSetM6086b.start();
            return;
        }
        impl.f11664F.internalSetVisibility(z2 ? 8 : 4, z2);
        if (fVarWrapOnVisibilityChangedListener != null) {
            C10919a c10919a = (C10919a) fVarWrapOnVisibilityChangedListener;
            c10919a.f21018a.onHidden(FloatingActionButton.this);
        }
    }

    public void show(@Nullable OnVisibilityChangedListener onVisibilityChangedListener, boolean z2) {
        C4408f impl = getImpl();
        C4408f.f fVarWrapOnVisibilityChangedListener = wrapOnVisibilityChangedListener(onVisibilityChangedListener);
        if (impl.m6092h()) {
            return;
        }
        Animator animator = impl.f11685v;
        if (animator != null) {
            animator.cancel();
        }
        if (impl.m6103s()) {
            if (impl.f11664F.getVisibility() != 0) {
                impl.f11664F.setAlpha(0.0f);
                impl.f11664F.setScaleY(0.0f);
                impl.f11664F.setScaleX(0.0f);
                impl.m6099o(0.0f);
            }
            MotionSpec motionSpec = impl.f11686w;
            if (motionSpec == null) {
                if (impl.f11683t == null) {
                    impl.f11683t = MotionSpec.createFromResource(impl.f11664F.getContext(), C10817R.animator.design_fab_show_motion_spec);
                }
                motionSpec = (MotionSpec) Preconditions.checkNotNull(impl.f11683t);
            }
            AnimatorSet animatorSetM6086b = impl.m6086b(motionSpec, 1.0f, 1.0f, 1.0f);
            animatorSetM6086b.addListener(new C4407e(impl, z2, fVarWrapOnVisibilityChangedListener));
            ArrayList<Animator.AnimatorListener> arrayList = impl.f11661C;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    animatorSetM6086b.addListener(it.next());
                }
            }
            animatorSetM6086b.start();
            return;
        }
        impl.f11664F.internalSetVisibility(0, z2);
        impl.f11664F.setAlpha(1.0f);
        impl.f11664F.setScaleY(1.0f);
        impl.f11664F.setScaleX(1.0f);
        impl.m6099o(1.0f);
        if (fVarWrapOnVisibilityChangedListener != null) {
            C10919a c10919a = (C10919a) fVarWrapOnVisibilityChangedListener;
            c10919a.f21018a.onShown(FloatingActionButton.this);
        }
    }
}

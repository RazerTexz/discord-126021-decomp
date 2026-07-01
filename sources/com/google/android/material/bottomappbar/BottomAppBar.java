package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint$Style;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Dimension;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar$LayoutParams;
import androidx.constraintlayout.motion.widget.Key;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$AttachedBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout$AttachedBehavior {
    private static final long ANIMATION_DURATION = 300;
    private static final int DEF_STYLE_RES = R$style.Widget_MaterialComponents_BottomAppBar;
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    public static final int FAB_ANIMATION_MODE_SCALE = 0;
    public static final int FAB_ANIMATION_MODE_SLIDE = 1;
    private static final int NO_MENU_RES_ID = 0;
    private int animatingModeChangeCounter;
    private ArrayList<BottomAppBar$j> animationListeners;
    private BottomAppBar$Behavior behavior;
    private int bottomInset;
    private int fabAlignmentMode;

    @NonNull
    public AnimatorListenerAdapter fabAnimationListener;
    private int fabAnimationMode;
    private boolean fabAttached;
    private final int fabOffsetEndMode;

    @NonNull
    public TransformationCallback<FloatingActionButton> fabTransformationCallback;
    private boolean hideOnScroll;
    private int leftInset;
    private final MaterialShapeDrawable materialShapeDrawable;
    private boolean menuAnimatingWithFabAlignmentMode;

    @Nullable
    private Animator menuAnimator;

    @Nullable
    private Animator modeAnimator;
    private final boolean paddingBottomSystemWindowInsets;
    private final boolean paddingLeftSystemWindowInsets;
    private final boolean paddingRightSystemWindowInsets;

    @MenuRes
    private int pendingMenuResId;
    private int rightInset;

    public BottomAppBar(@NonNull Context context) {
        this(context, null, 0);
    }

    public static /* synthetic */ boolean access$000(BottomAppBar bottomAppBar) {
        return bottomAppBar.menuAnimatingWithFabAlignmentMode;
    }

    public static /* synthetic */ boolean access$002(BottomAppBar bottomAppBar, boolean z2) {
        bottomAppBar.menuAnimatingWithFabAlignmentMode = z2;
        return z2;
    }

    public static /* synthetic */ int access$100(BottomAppBar bottomAppBar) {
        return bottomAppBar.fabAlignmentMode;
    }

    public static /* synthetic */ boolean access$1000(BottomAppBar bottomAppBar) {
        return bottomAppBar.paddingRightSystemWindowInsets;
    }

    public static /* synthetic */ int access$1100(BottomAppBar bottomAppBar) {
        return bottomAppBar.rightInset;
    }

    public static /* synthetic */ int access$1102(BottomAppBar bottomAppBar, int i) {
        bottomAppBar.rightInset = i;
        return i;
    }

    public static /* synthetic */ void access$1200(BottomAppBar bottomAppBar) {
        bottomAppBar.cancelAnimations();
    }

    public static /* synthetic */ void access$1300(BottomAppBar bottomAppBar) {
        bottomAppBar.setCutoutState();
    }

    public static /* synthetic */ void access$1400(BottomAppBar bottomAppBar) {
        bottomAppBar.setActionMenuViewPosition();
    }

    public static /* synthetic */ void access$1500(BottomAppBar bottomAppBar) {
        bottomAppBar.dispatchAnimationStart();
    }

    public static /* synthetic */ void access$1600(BottomAppBar bottomAppBar) {
        bottomAppBar.dispatchAnimationEnd();
    }

    public static /* synthetic */ Animator access$1702(BottomAppBar bottomAppBar, Animator animator) {
        bottomAppBar.modeAnimator = animator;
        return animator;
    }

    public static /* synthetic */ float access$1800(BottomAppBar bottomAppBar, int i) {
        return bottomAppBar.getFabTranslationX(i);
    }

    public static /* synthetic */ Animator access$1902(BottomAppBar bottomAppBar, Animator animator) {
        bottomAppBar.menuAnimator = animator;
        return animator;
    }

    public static /* synthetic */ boolean access$200(BottomAppBar bottomAppBar) {
        return bottomAppBar.fabAttached;
    }

    public static /* synthetic */ int access$2000(BottomAppBar bottomAppBar) {
        return bottomAppBar.pendingMenuResId;
    }

    public static /* synthetic */ void access$2100(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i, boolean z2, boolean z3) {
        bottomAppBar.translateActionMenuView(actionMenuView, i, z2, z3);
    }

    public static /* synthetic */ FloatingActionButton access$2200(BottomAppBar bottomAppBar) {
        return bottomAppBar.findDependentFab();
    }

    public static /* synthetic */ float access$2300(BottomAppBar bottomAppBar) {
        return bottomAppBar.getFabTranslationX();
    }

    public static /* synthetic */ int access$2700(BottomAppBar bottomAppBar) {
        return bottomAppBar.getBottomInset();
    }

    public static /* synthetic */ int access$2800(BottomAppBar bottomAppBar) {
        return bottomAppBar.getLeftInset();
    }

    public static /* synthetic */ int access$2900(BottomAppBar bottomAppBar) {
        return bottomAppBar.getRightInset();
    }

    public static /* synthetic */ void access$300(BottomAppBar bottomAppBar, int i, boolean z2) {
        bottomAppBar.maybeAnimateMenuView(i, z2);
    }

    public static /* synthetic */ int access$3000(BottomAppBar bottomAppBar) {
        return bottomAppBar.fabOffsetEndMode;
    }

    public static /* synthetic */ View access$3100(BottomAppBar bottomAppBar) {
        return bottomAppBar.findDependentView();
    }

    public static /* synthetic */ void access$3200(BottomAppBar bottomAppBar, FloatingActionButton floatingActionButton) {
        bottomAppBar.addFabAnimationListeners(floatingActionButton);
    }

    public static /* synthetic */ MaterialShapeDrawable access$400(BottomAppBar bottomAppBar) {
        return bottomAppBar.materialShapeDrawable;
    }

    public static /* synthetic */ BottomAppBarTopEdgeTreatment access$500(BottomAppBar bottomAppBar) {
        return bottomAppBar.getTopEdgeTreatment();
    }

    public static /* synthetic */ boolean access$600(BottomAppBar bottomAppBar) {
        return bottomAppBar.paddingBottomSystemWindowInsets;
    }

    public static /* synthetic */ int access$702(BottomAppBar bottomAppBar, int i) {
        bottomAppBar.bottomInset = i;
        return i;
    }

    public static /* synthetic */ boolean access$800(BottomAppBar bottomAppBar) {
        return bottomAppBar.paddingLeftSystemWindowInsets;
    }

    public static /* synthetic */ int access$900(BottomAppBar bottomAppBar) {
        return bottomAppBar.leftInset;
    }

    public static /* synthetic */ int access$902(BottomAppBar bottomAppBar, int i) {
        bottomAppBar.leftInset = i;
        return i;
    }

    private void addFabAnimationListeners(@NonNull FloatingActionButton floatingActionButton) {
        floatingActionButton.addOnHideAnimationListener(this.fabAnimationListener);
        floatingActionButton.addOnShowAnimationListener(new BottomAppBar$i(this));
        floatingActionButton.addTransformationCallback(this.fabTransformationCallback);
    }

    private void cancelAnimations() {
        Animator animator = this.menuAnimator;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.modeAnimator;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void createFabTranslationXAnimation(int i, @NonNull List<Animator> list) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(findDependentFab(), Key.TRANSLATION_X, getFabTranslationX(i));
        objectAnimatorOfFloat.setDuration(300L);
        list.add(objectAnimatorOfFloat);
    }

    private void createMenuViewTranslationAnimation(int i, boolean z2, @NonNull List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator animatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, Key.ALPHA, 1.0f);
        if (Math.abs(actionMenuView.getTranslationX() - getActionMenuViewTranslationX(actionMenuView, i, z2)) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(animatorOfFloat);
            }
        } else {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, Key.ALPHA, 0.0f);
            objectAnimatorOfFloat.addListener(new BottomAppBar$g(this, actionMenuView, i, z2));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(objectAnimatorOfFloat, animatorOfFloat);
            list.add(animatorSet);
        }
    }

    private void dispatchAnimationEnd() {
        ArrayList<BottomAppBar$j> arrayList;
        int i = this.animatingModeChangeCounter - 1;
        this.animatingModeChangeCounter = i;
        if (i != 0 || (arrayList = this.animationListeners) == null) {
            return;
        }
        Iterator<BottomAppBar$j> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    private void dispatchAnimationStart() {
        ArrayList<BottomAppBar$j> arrayList;
        int i = this.animatingModeChangeCounter;
        this.animatingModeChangeCounter = i + 1;
        if (i != 0 || (arrayList = this.animationListeners) == null) {
            return;
        }
        Iterator<BottomAppBar$j> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    @Nullable
    private FloatingActionButton findDependentFab() {
        View viewFindDependentView = findDependentView();
        if (viewFindDependentView instanceof FloatingActionButton) {
            return (FloatingActionButton) viewFindDependentView;
        }
        return null;
    }

    @Nullable
    private View findDependentView() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).getDependents(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    private int getBottomInset() {
        return this.bottomInset;
    }

    private float getFabTranslationX(int i) {
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        if (i == 1) {
            return ((getMeasuredWidth() / 2) - (this.fabOffsetEndMode + (zIsLayoutRtl ? this.leftInset : this.rightInset))) * (zIsLayoutRtl ? -1 : 1);
        }
        return 0.0f;
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().getCradleVerticalOffset();
    }

    private int getLeftInset() {
        return this.leftInset;
    }

    private int getRightInset() {
        return this.rightInset;
    }

    @NonNull
    private BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        return (BottomAppBarTopEdgeTreatment) this.materialShapeDrawable.getShapeAppearanceModel().getTopEdge();
    }

    private boolean isFabVisibleOrWillBeShown() {
        FloatingActionButton floatingActionButtonFindDependentFab = findDependentFab();
        return floatingActionButtonFindDependentFab != null && floatingActionButtonFindDependentFab.isOrWillBeShown();
    }

    private void maybeAnimateMenuView(int i, boolean z2) {
        if (!ViewCompat.isLaidOut(this)) {
            this.menuAnimatingWithFabAlignmentMode = false;
            replaceMenu(this.pendingMenuResId);
            return;
        }
        Animator animator = this.menuAnimator;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!isFabVisibleOrWillBeShown()) {
            i = 0;
            z2 = false;
        }
        createMenuViewTranslationAnimation(i, z2, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.menuAnimator = animatorSet;
        animatorSet.addListener(new BottomAppBar$f(this));
        this.menuAnimator.start();
    }

    private void maybeAnimateModeChange(int i) {
        if (this.fabAlignmentMode == i || !ViewCompat.isLaidOut(this)) {
            return;
        }
        Animator animator = this.modeAnimator;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (this.fabAnimationMode == 1) {
            createFabTranslationXAnimation(i, arrayList);
        } else {
            createFabDefaultXAnimation(i, arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.modeAnimator = animatorSet;
        animatorSet.addListener(new BottomAppBar$d(this));
        this.modeAnimator.start();
    }

    private void setActionMenuViewPosition() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.menuAnimator != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (isFabVisibleOrWillBeShown()) {
            translateActionMenuView(actionMenuView, this.fabAlignmentMode, this.fabAttached);
        } else {
            translateActionMenuView(actionMenuView, 0, false);
        }
    }

    private void setCutoutState() {
        getTopEdgeTreatment().setHorizontalOffset(getFabTranslationX());
        View viewFindDependentView = findDependentView();
        this.materialShapeDrawable.setInterpolation((this.fabAttached && isFabVisibleOrWillBeShown()) ? 1.0f : 0.0f);
        if (viewFindDependentView != null) {
            viewFindDependentView.setTranslationY(getFabTranslationY());
            viewFindDependentView.setTranslationX(getFabTranslationX());
        }
    }

    private void translateActionMenuView(@NonNull ActionMenuView actionMenuView, int i, boolean z2) {
        translateActionMenuView(actionMenuView, i, z2, false);
    }

    public void addAnimationListener(@NonNull BottomAppBar$j bottomAppBar$j) {
        if (this.animationListeners == null) {
            this.animationListeners = new ArrayList<>();
        }
        this.animationListeners.add(bottomAppBar$j);
    }

    public void createFabDefaultXAnimation(int i, List<Animator> list) {
        FloatingActionButton floatingActionButtonFindDependentFab = findDependentFab();
        if (floatingActionButtonFindDependentFab == null || floatingActionButtonFindDependentFab.isOrWillBeHidden()) {
            return;
        }
        dispatchAnimationStart();
        floatingActionButtonFindDependentFab.hide(new BottomAppBar$e(this, i));
    }

    public int getActionMenuViewTranslationX(@NonNull ActionMenuView actionMenuView, int i, boolean z2) {
        if (i != 1 || !z2) {
            return 0;
        }
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        int measuredWidth = zIsLayoutRtl ? getMeasuredWidth() : 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt.getLayoutParams() instanceof Toolbar$LayoutParams) && (((Toolbar$LayoutParams) childAt.getLayoutParams()).gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 8388611) {
                measuredWidth = zIsLayoutRtl ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        return measuredWidth - ((zIsLayoutRtl ? actionMenuView.getRight() : actionMenuView.getLeft()) + (zIsLayoutRtl ? this.rightInset : -this.leftInset));
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        return this.materialShapeDrawable.getTintList();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$AttachedBehavior
    @NonNull
    public /* bridge */ /* synthetic */ CoordinatorLayout$Behavior getBehavior() {
        return getBehavior();
    }

    @Dimension
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().getCradleVerticalOffset();
    }

    public int getFabAlignmentMode() {
        return this.fabAlignmentMode;
    }

    public int getFabAnimationMode() {
        return this.fabAnimationMode;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().getFabCradleMargin();
    }

    @Dimension
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().getFabCradleRoundedCornerRadius();
    }

    public boolean getHideOnScroll() {
        return this.hideOnScroll;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialShapeDrawable);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        if (z2) {
            cancelAnimations();
            setCutoutState();
        }
        setActionMenuViewPosition();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof BottomAppBar$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        BottomAppBar$SavedState bottomAppBar$SavedState = (BottomAppBar$SavedState) parcelable;
        super.onRestoreInstanceState(bottomAppBar$SavedState.getSuperState());
        this.fabAlignmentMode = bottomAppBar$SavedState.j;
        this.fabAttached = bottomAppBar$SavedState.k;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        BottomAppBar$SavedState bottomAppBar$SavedState = new BottomAppBar$SavedState(super.onSaveInstanceState());
        bottomAppBar$SavedState.j = this.fabAlignmentMode;
        bottomAppBar$SavedState.k = this.fabAttached;
        return bottomAppBar$SavedState;
    }

    public void performHide() {
        getBehavior().slideDown(this);
    }

    public void performShow() {
        getBehavior().slideUp(this);
    }

    public void removeAnimationListener(@NonNull BottomAppBar$j bottomAppBar$j) {
        ArrayList<BottomAppBar$j> arrayList = this.animationListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(bottomAppBar$j);
    }

    public void replaceMenu(@MenuRes int i) {
        if (i != 0) {
            this.pendingMenuResId = 0;
            getMenu().clear();
            inflateMenu(i);
        }
    }

    public void setBackgroundTint(@Nullable ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.materialShapeDrawable, colorStateList);
    }

    public void setCradleVerticalOffset(@Dimension float f) {
        if (f != getCradleVerticalOffset()) {
            getTopEdgeTreatment().setCradleVerticalOffset(f);
            this.materialShapeDrawable.invalidateSelf();
            setCutoutState();
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        this.materialShapeDrawable.setElevation(f);
        getBehavior().setAdditionalHiddenOffsetY(this, this.materialShapeDrawable.getShadowRadius() - this.materialShapeDrawable.getShadowOffsetY());
    }

    public void setFabAlignmentMode(int i) {
        setFabAlignmentModeAndReplaceMenu(i, 0);
    }

    public void setFabAlignmentModeAndReplaceMenu(int i, @MenuRes int i2) {
        this.pendingMenuResId = i2;
        this.menuAnimatingWithFabAlignmentMode = true;
        maybeAnimateMenuView(i, this.fabAttached);
        maybeAnimateModeChange(i);
        this.fabAlignmentMode = i;
    }

    public void setFabAnimationMode(int i) {
        this.fabAnimationMode = i;
    }

    public void setFabCradleMargin(@Dimension float f) {
        if (f != getFabCradleMargin()) {
            getTopEdgeTreatment().setFabCradleMargin(f);
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float f) {
        if (f != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().setFabCradleRoundedCornerRadius(f);
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public boolean setFabDiameter(@Px int i) {
        float f = i;
        if (f == getTopEdgeTreatment().getFabDiameter()) {
            return false;
        }
        getTopEdgeTreatment().setFabDiameter(f);
        this.materialShapeDrawable.invalidateSelf();
        return true;
    }

    public void setHideOnScroll(boolean z2) {
        this.hideOnScroll = z2;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.bottomAppBarStyle);
    }

    private void translateActionMenuView(@NonNull ActionMenuView actionMenuView, int i, boolean z2, boolean z3) {
        BottomAppBar$h bottomAppBar$h = new BottomAppBar$h(this, actionMenuView, i, z2);
        if (z3) {
            actionMenuView.post(bottomAppBar$h);
        } else {
            bottomAppBar$h.run();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$AttachedBehavior
    @NonNull
    public BottomAppBar$Behavior getBehavior() {
        if (this.behavior == null) {
            this.behavior = new BottomAppBar$Behavior();
        }
        return this.behavior;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        int i2 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i2), attributeSet, i);
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.materialShapeDrawable = materialShapeDrawable;
        this.animatingModeChangeCounter = 0;
        this.pendingMenuResId = 0;
        this.menuAnimatingWithFabAlignmentMode = false;
        this.fabAttached = true;
        this.fabAnimationListener = new BottomAppBar$a(this);
        this.fabTransformationCallback = new BottomAppBar$b(this);
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R$styleable.BottomAppBar, i, i2, new int[0]);
        ColorStateList colorStateList = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, R$styleable.BottomAppBar_backgroundTint);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.BottomAppBar_elevation, 0);
        float dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleMargin, 0);
        float dimensionPixelOffset2 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float dimensionPixelOffset3 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.fabAlignmentMode = typedArrayObtainStyledAttributes.getInt(R$styleable.BottomAppBar_fabAlignmentMode, 0);
        this.fabAnimationMode = typedArrayObtainStyledAttributes.getInt(R$styleable.BottomAppBar_fabAnimationMode, 0);
        this.hideOnScroll = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomAppBar_hideOnScroll, false);
        this.paddingBottomSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        this.fabOffsetEndMode = getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fabOffsetEndMode);
        materialShapeDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setTopEdge(new BottomAppBarTopEdgeTreatment(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3)).build());
        materialShapeDrawable.setShadowCompatibilityMode(2);
        materialShapeDrawable.setPaintStyle(Paint$Style.FILL);
        materialShapeDrawable.initializeElevationOverlay(context2);
        setElevation(dimensionPixelSize);
        DrawableCompat.setTintList(materialShapeDrawable, colorStateList);
        ViewCompat.setBackground(this, materialShapeDrawable);
        ViewUtils.doOnApplyWindowInsets(this, attributeSet, i, i2, new BottomAppBar$c(this));
    }

    private float getFabTranslationX() {
        return getFabTranslationX(this.fabAlignmentMode);
    }
}

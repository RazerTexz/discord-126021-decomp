package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
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
import androidx.constraintlayout.motion.widget.Key;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.C10817R;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    private static final long ANIMATION_DURATION = 300;
    private static final int DEF_STYLE_RES = C10817R.style.Widget_MaterialComponents_BottomAppBar;
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    public static final int FAB_ANIMATION_MODE_SCALE = 0;
    public static final int FAB_ANIMATION_MODE_SLIDE = 1;
    private static final int NO_MENU_RES_ID = 0;
    private int animatingModeChangeCounter;
    private ArrayList<InterfaceC10845j> animationListeners;
    private Behavior behavior;
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

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        @NonNull
        private final Rect fabContentRect;
        private final View.OnLayoutChangeListener fabLayoutListener;
        private int originalBottomMargin;
        private WeakReference<BottomAppBar> viewRef;

        /* JADX INFO: renamed from: com.google.android.material.bottomappbar.BottomAppBar$Behavior$a */
        public class ViewOnLayoutChangeListenerC10834a implements View.OnLayoutChangeListener {
            public ViewOnLayoutChangeListenerC10834a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.viewRef.get();
                if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                floatingActionButton.getMeasuredContentRect(Behavior.this.fabContentRect);
                int iHeight = Behavior.this.fabContentRect.height();
                bottomAppBar.setFabDiameter(iHeight);
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                if (Behavior.this.originalBottomMargin == 0) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(C10817R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - iHeight) / 2));
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bottomAppBar.getRightInset();
                    if (ViewUtils.isLayoutRtl(floatingActionButton)) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bottomAppBar.fabOffsetEndMode + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bottomAppBar.fabOffsetEndMode + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    }
                }
            }
        }

        public Behavior() {
            this.fabLayoutListener = new ViewOnLayoutChangeListenerC10834a();
            this.fabContentRect = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, int i) {
            this.viewRef = new WeakReference<>(bottomAppBar);
            View viewFindDependentView = bottomAppBar.findDependentView();
            if (viewFindDependentView != null && !ViewCompat.isLaidOut(viewFindDependentView)) {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) viewFindDependentView.getLayoutParams();
                layoutParams.anchorGravity = 49;
                this.originalBottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                if (viewFindDependentView instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) viewFindDependentView;
                    floatingActionButton.addOnLayoutChangeListener(this.fabLayoutListener);
                    bottomAppBar.addFabAnimationListeners(floatingActionButton);
                }
                bottomAppBar.setCutoutState();
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i);
            return super.onLayoutChild(coordinatorLayout, bottomAppBar, i);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, @NonNull View view, @NonNull View view2, int i, int i2) {
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, bottomAppBar, view, view2, i, i2);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.fabLayoutListener = new ViewOnLayoutChangeListenerC10834a();
            this.fabContentRect = new Rect();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAlignmentMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAnimationMode {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C10835a();

        /* JADX INFO: renamed from: j */
        public int f20897j;

        /* JADX INFO: renamed from: k */
        public boolean f20898k;

        /* JADX INFO: renamed from: com.google.android.material.bottomappbar.BottomAppBar$SavedState$a */
        public static class C10835a implements Parcelable.ClassLoaderCreator<SavedState> {
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
            @Nullable
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
            parcel.writeInt(this.f20897j);
            parcel.writeInt(this.f20898k ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f20897j = parcel.readInt();
            this.f20898k = parcel.readInt() != 0;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.bottomappbar.BottomAppBar$a */
    public class C10836a extends AnimatorListenerAdapter {
        public C10836a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (BottomAppBar.this.menuAnimatingWithFabAlignmentMode) {
                return;
            }
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.maybeAnimateMenuView(bottomAppBar.fabAlignmentMode, BottomAppBar.this.fabAttached);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.bottomappbar.BottomAppBar$b */
    public class C10837b implements TransformationCallback<FloatingActionButton> {
        public C10837b() {
        }

        @Override // com.google.android.material.animation.TransformationCallback
        public void onScaleChanged(@NonNull View view) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            BottomAppBar.this.materialShapeDrawable.setInterpolation(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }

        @Override // com.google.android.material.animation.TransformationCallback
        public void onTranslationChanged(@NonNull View view) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            float translationX = floatingActionButton.getTranslationX();
            if (BottomAppBar.this.getTopEdgeTreatment().getHorizontalOffset() != translationX) {
                BottomAppBar.this.getTopEdgeTreatment().setHorizontalOffset(translationX);
                BottomAppBar.this.materialShapeDrawable.invalidateSelf();
            }
            float fMax = Math.max(0.0f, -floatingActionButton.getTranslationY());
            if (BottomAppBar.this.getTopEdgeTreatment().getCradleVerticalOffset() != fMax) {
                BottomAppBar.this.getTopEdgeTreatment().setCradleVerticalOffset(fMax);
                BottomAppBar.this.materialShapeDrawable.invalidateSelf();
            }
            BottomAppBar.this.materialShapeDrawable.setInterpolation(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.bottomappbar.BottomAppBar$c */
    public class C10838c implements ViewUtils.OnApplyWindowInsetsListener {
        public C10838c() {
        }

        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils.RelativePadding relativePadding) {
            boolean z2;
            if (BottomAppBar.this.paddingBottomSystemWindowInsets) {
                BottomAppBar.this.bottomInset = windowInsetsCompat.getSystemWindowInsetBottom();
            }
            boolean z3 = false;
            if (BottomAppBar.this.paddingLeftSystemWindowInsets) {
                z2 = BottomAppBar.this.leftInset != windowInsetsCompat.getSystemWindowInsetLeft();
                BottomAppBar.this.leftInset = windowInsetsCompat.getSystemWindowInsetLeft();
            } else {
                z2 = false;
            }
            if (BottomAppBar.this.paddingRightSystemWindowInsets) {
                boolean z4 = BottomAppBar.this.rightInset != windowInsetsCompat.getSystemWindowInsetRight();
                BottomAppBar.this.rightInset = windowInsetsCompat.getSystemWindowInsetRight();
                z3 = z4;
            }
            if (z2 || z3) {
                BottomAppBar.this.cancelAnimations();
                BottomAppBar.this.setCutoutState();
                BottomAppBar.this.setActionMenuViewPosition();
            }
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.bottomappbar.BottomAppBar$d */
    public class C10839d extends AnimatorListenerAdapter {
        public C10839d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.dispatchAnimationEnd();
            BottomAppBar.this.modeAnimator = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.dispatchAnimationStart();
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.bottomappbar.BottomAppBar$e */
    public class C10840e extends FloatingActionButton.OnVisibilityChangedListener {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ int f20903a;

        /* JADX INFO: renamed from: com.google.android.material.bottomappbar.BottomAppBar$e$a */
        public class a extends FloatingActionButton.OnVisibilityChangedListener {
            public a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
            public void onShown(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.dispatchAnimationEnd();
            }
        }

        public C10840e(int i) {
            this.f20903a = i;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
        public void onHidden(@NonNull FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.getFabTranslationX(this.f20903a));
            floatingActionButton.show(new a());
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.bottomappbar.BottomAppBar$f */
    public class C10841f extends AnimatorListenerAdapter {
        public C10841f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.dispatchAnimationEnd();
            BottomAppBar.this.menuAnimatingWithFabAlignmentMode = false;
            BottomAppBar.this.menuAnimator = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.dispatchAnimationStart();
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.bottomappbar.BottomAppBar$g */
    public class C10842g extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a */
        public boolean f20907a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ ActionMenuView f20908b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ int f20909c;

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ boolean f20910d;

        public C10842g(ActionMenuView actionMenuView, int i, boolean z2) {
            this.f20908b = actionMenuView;
            this.f20909c = i;
            this.f20910d = z2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f20907a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f20907a) {
                return;
            }
            boolean z2 = BottomAppBar.this.pendingMenuResId != 0;
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.replaceMenu(bottomAppBar.pendingMenuResId);
            BottomAppBar.this.translateActionMenuView(this.f20908b, this.f20909c, this.f20910d, z2);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.bottomappbar.BottomAppBar$h */
    public class RunnableC10843h implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ ActionMenuView f20912j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ int f20913k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ boolean f20914l;

        public RunnableC10843h(ActionMenuView actionMenuView, int i, boolean z2) {
            this.f20912j = actionMenuView;
            this.f20913k = i;
            this.f20914l = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionMenuView actionMenuView = this.f20912j;
            actionMenuView.setTranslationX(BottomAppBar.this.getActionMenuViewTranslationX(actionMenuView, this.f20913k, this.f20914l));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.bottomappbar.BottomAppBar$i */
    public class C10844i extends AnimatorListenerAdapter {
        public C10844i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.fabAnimationListener.onAnimationStart(animator);
            FloatingActionButton floatingActionButtonFindDependentFab = BottomAppBar.this.findDependentFab();
            if (floatingActionButtonFindDependentFab != null) {
                floatingActionButtonFindDependentFab.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.bottomappbar.BottomAppBar$j */
    public interface InterfaceC10845j {
        /* JADX INFO: renamed from: a */
        void m9127a(BottomAppBar bottomAppBar);

        /* JADX INFO: renamed from: b */
        void m9128b(BottomAppBar bottomAppBar);
    }

    public BottomAppBar(@NonNull Context context) {
        this(context, null, 0);
    }

    private void addFabAnimationListeners(@NonNull FloatingActionButton floatingActionButton) {
        floatingActionButton.addOnHideAnimationListener(this.fabAnimationListener);
        floatingActionButton.addOnShowAnimationListener(new C10844i());
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
            objectAnimatorOfFloat.addListener(new C10842g(actionMenuView, i, z2));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(objectAnimatorOfFloat, animatorOfFloat);
            list.add(animatorSet);
        }
    }

    private void dispatchAnimationEnd() {
        ArrayList<InterfaceC10845j> arrayList;
        int i = this.animatingModeChangeCounter - 1;
        this.animatingModeChangeCounter = i;
        if (i != 0 || (arrayList = this.animationListeners) == null) {
            return;
        }
        Iterator<InterfaceC10845j> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().m9128b(this);
        }
    }

    private void dispatchAnimationStart() {
        ArrayList<InterfaceC10845j> arrayList;
        int i = this.animatingModeChangeCounter;
        this.animatingModeChangeCounter = i + 1;
        if (i != 0 || (arrayList = this.animationListeners) == null) {
            return;
        }
        Iterator<InterfaceC10845j> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().m9127a(this);
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
        animatorSet.addListener(new C10841f());
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
        animatorSet.addListener(new C10839d());
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

    public void addAnimationListener(@NonNull InterfaceC10845j interfaceC10845j) {
        if (this.animationListeners == null) {
            this.animationListeners = new ArrayList<>();
        }
        this.animationListeners.add(interfaceC10845j);
    }

    public void createFabDefaultXAnimation(int i, List<Animator> list) {
        FloatingActionButton floatingActionButtonFindDependentFab = findDependentFab();
        if (floatingActionButtonFindDependentFab == null || floatingActionButtonFindDependentFab.isOrWillBeHidden()) {
            return;
        }
        dispatchAnimationStart();
        floatingActionButtonFindDependentFab.hide(new C10840e(i));
    }

    public int getActionMenuViewTranslationX(@NonNull ActionMenuView actionMenuView, int i, boolean z2) {
        if (i != 1 || !z2) {
            return 0;
        }
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        int measuredWidth = zIsLayoutRtl ? getMeasuredWidth() : 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 8388611) {
                measuredWidth = zIsLayoutRtl ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        return measuredWidth - ((zIsLayoutRtl ? actionMenuView.getRight() : actionMenuView.getLeft()) + (zIsLayoutRtl ? this.rightInset : -this.leftInset));
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        return this.materialShapeDrawable.getTintList();
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
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.fabAlignmentMode = savedState.f20897j;
        this.fabAttached = savedState.f20898k;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f20897j = this.fabAlignmentMode;
        savedState.f20898k = this.fabAttached;
        return savedState;
    }

    public void performHide() {
        getBehavior().slideDown(this);
    }

    public void performShow() {
        getBehavior().slideUp(this);
    }

    public void removeAnimationListener(@NonNull InterfaceC10845j interfaceC10845j) {
        ArrayList<InterfaceC10845j> arrayList = this.animationListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(interfaceC10845j);
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
        this(context, attributeSet, C10817R.attr.bottomAppBarStyle);
    }

    private void translateActionMenuView(@NonNull ActionMenuView actionMenuView, int i, boolean z2, boolean z3) {
        RunnableC10843h runnableC10843h = new RunnableC10843h(actionMenuView, i, z2);
        if (z3) {
            actionMenuView.post(runnableC10843h);
        } else {
            runnableC10843h.run();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public Behavior getBehavior() {
        if (this.behavior == null) {
            this.behavior = new Behavior();
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
        this.fabAnimationListener = new C10836a();
        this.fabTransformationCallback = new C10837b();
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, C10817R.styleable.BottomAppBar, i, i2, new int[0]);
        ColorStateList colorStateList = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, C10817R.styleable.BottomAppBar_backgroundTint);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10817R.styleable.BottomAppBar_elevation, 0);
        float dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C10817R.styleable.BottomAppBar_fabCradleMargin, 0);
        float dimensionPixelOffset2 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C10817R.styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float dimensionPixelOffset3 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C10817R.styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.fabAlignmentMode = typedArrayObtainStyledAttributes.getInt(C10817R.styleable.BottomAppBar_fabAlignmentMode, 0);
        this.fabAnimationMode = typedArrayObtainStyledAttributes.getInt(C10817R.styleable.BottomAppBar_fabAnimationMode, 0);
        this.hideOnScroll = typedArrayObtainStyledAttributes.getBoolean(C10817R.styleable.BottomAppBar_hideOnScroll, false);
        this.paddingBottomSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(C10817R.styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(C10817R.styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(C10817R.styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        this.fabOffsetEndMode = getResources().getDimensionPixelOffset(C10817R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
        materialShapeDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setTopEdge(new BottomAppBarTopEdgeTreatment(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3)).build());
        materialShapeDrawable.setShadowCompatibilityMode(2);
        materialShapeDrawable.setPaintStyle(Paint.Style.FILL);
        materialShapeDrawable.initializeElevationOverlay(context2);
        setElevation(dimensionPixelSize);
        DrawableCompat.setTintList(materialShapeDrawable, colorStateList);
        ViewCompat.setBackground(this, materialShapeDrawable);
        ViewUtils.doOnApplyWindowInsets(this, attributeSet, i, i2, new C10838c());
    }

    private float getFabTranslationX() {
        return getFabTranslationX(this.fabAlignmentMode);
    }
}

package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.core.view.ViewCompat;
import b.i.a.g.h.a;
import b.i.a.g.h.a$b;
import b.i.a.g.h.a$c;
import com.google.android.material.R$attr;
import com.google.android.material.R$layout;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    public static final int ANIMATION_DURATION = 250;
    public static final int ANIMATION_FADE_DURATION = 180;
    private static final int ANIMATION_FADE_IN_DURATION = 150;
    private static final int ANIMATION_FADE_OUT_DURATION = 75;
    public static final int ANIMATION_MODE_FADE = 1;
    public static final int ANIMATION_MODE_SLIDE = 0;
    private static final float ANIMATION_SCALE_FROM_VALUE = 0.8f;
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;
    public static final int MSG_DISMISS = 1;
    public static final int MSG_SHOW = 0;

    @Nullable
    private final AccessibilityManager accessibilityManager;

    @Nullable
    private View anchorView;
    private final ViewTreeObserver$OnGlobalLayoutListener anchorViewLayoutListener;
    private boolean anchorViewLayoutListenerEnabled;
    private BaseTransientBottomBar$Behavior behavior;

    @RequiresApi(29)
    private final Runnable bottomMarginGestureInsetRunnable;
    private List<BaseTransientBottomBar$BaseCallback<B>> callbacks;

    @NonNull
    private final ContentViewCallback contentViewCallback;
    private final Context context;
    private int duration;
    private int extraBottomMarginAnchorView;
    private int extraBottomMarginGestureInset;
    private int extraBottomMarginWindowInset;
    private int extraLeftMarginWindowInset;
    private int extraRightMarginWindowInset;
    private boolean gestureInsetBottomIgnored;

    @NonNull
    public a$b managerCallback;

    @Nullable
    private Rect originalMargins;

    @NonNull
    private final ViewGroup targetParent;

    @NonNull
    public final BaseTransientBottomBar$SnackbarBaseLayout view;
    private static final boolean USE_OFFSET_API = false;
    private static final int[] SNACKBAR_STYLE_ATTR = {R$attr.snackbarStyle};
    private static final String TAG = BaseTransientBottomBar.class.getSimpleName();

    @NonNull
    public static final Handler handler = new Handler(Looper.getMainLooper(), new BaseTransientBottomBar$j());

    public BaseTransientBottomBar(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull ContentViewCallback contentViewCallback) {
        this(viewGroup.getContext(), viewGroup, view, contentViewCallback);
    }

    public static /* synthetic */ boolean access$000(BaseTransientBottomBar baseTransientBottomBar) {
        return baseTransientBottomBar.anchorViewLayoutListenerEnabled;
    }

    public static /* synthetic */ int access$1002(BaseTransientBottomBar baseTransientBottomBar, int i) {
        baseTransientBottomBar.extraLeftMarginWindowInset = i;
        return i;
    }

    public static /* synthetic */ int access$102(BaseTransientBottomBar baseTransientBottomBar, int i) {
        baseTransientBottomBar.extraBottomMarginAnchorView = i;
        return i;
    }

    public static /* synthetic */ int access$1102(BaseTransientBottomBar baseTransientBottomBar, int i) {
        baseTransientBottomBar.extraRightMarginWindowInset = i;
        return i;
    }

    public static /* synthetic */ void access$1200(BaseTransientBottomBar baseTransientBottomBar) {
        baseTransientBottomBar.showViewImpl();
    }

    public static /* synthetic */ void access$1400(BaseTransientBottomBar baseTransientBottomBar) {
        baseTransientBottomBar.startFadeInAnimation();
    }

    public static /* synthetic */ void access$1500(BaseTransientBottomBar baseTransientBottomBar) {
        baseTransientBottomBar.startSlideInAnimation();
    }

    public static /* synthetic */ ContentViewCallback access$1600(BaseTransientBottomBar baseTransientBottomBar) {
        return baseTransientBottomBar.contentViewCallback;
    }

    public static /* synthetic */ boolean access$1700() {
        return USE_OFFSET_API;
    }

    public static /* synthetic */ int access$200(BaseTransientBottomBar baseTransientBottomBar) {
        return baseTransientBottomBar.calculateBottomMarginForAnchorView();
    }

    public static /* synthetic */ void access$300(BaseTransientBottomBar baseTransientBottomBar) {
        baseTransientBottomBar.updateMargins();
    }

    public static /* synthetic */ Context access$400(BaseTransientBottomBar baseTransientBottomBar) {
        return baseTransientBottomBar.context;
    }

    public static /* synthetic */ int access$500(BaseTransientBottomBar baseTransientBottomBar) {
        return baseTransientBottomBar.getScreenHeight();
    }

    public static /* synthetic */ int access$600(BaseTransientBottomBar baseTransientBottomBar) {
        return baseTransientBottomBar.getViewAbsoluteBottom();
    }

    public static /* synthetic */ int access$700(BaseTransientBottomBar baseTransientBottomBar) {
        return baseTransientBottomBar.extraBottomMarginGestureInset;
    }

    public static /* synthetic */ int access$702(BaseTransientBottomBar baseTransientBottomBar, int i) {
        baseTransientBottomBar.extraBottomMarginGestureInset = i;
        return i;
    }

    public static /* synthetic */ String access$800() {
        return TAG;
    }

    public static /* synthetic */ int access$902(BaseTransientBottomBar baseTransientBottomBar, int i) {
        baseTransientBottomBar.extraBottomMarginWindowInset = i;
        return i;
    }

    private void animateViewOut(int i) {
        if (this.view.getAnimationMode() == 1) {
            startFadeOutAnimation(i);
        } else {
            startSlideOutAnimation(i);
        }
    }

    private int calculateBottomMarginForAnchorView() {
        View view = this.anchorView;
        if (view == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[1];
        int[] iArr2 = new int[2];
        this.targetParent.getLocationOnScreen(iArr2);
        return (this.targetParent.getHeight() + iArr2[1]) - i;
    }

    private ValueAnimator getAlphaAnimator(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        valueAnimatorOfFloat.addUpdateListener(new BaseTransientBottomBar$d(this));
        return valueAnimatorOfFloat;
    }

    private ValueAnimator getScaleAnimator(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimatorOfFloat.addUpdateListener(new BaseTransientBottomBar$e(this));
        return valueAnimatorOfFloat;
    }

    @RequiresApi(17)
    private int getScreenHeight() {
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private int getTranslationYBottom() {
        int height = this.view.getHeight();
        ViewGroup$LayoutParams layoutParams = this.view.getLayoutParams();
        return layoutParams instanceof ViewGroup$MarginLayoutParams ? height + ((ViewGroup$MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    private int getViewAbsoluteBottom() {
        int[] iArr = new int[2];
        this.view.getLocationOnScreen(iArr);
        return this.view.getHeight() + iArr[1];
    }

    private boolean isSwipeDismissable() {
        ViewGroup$LayoutParams layoutParams = this.view.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout$LayoutParams) && (((CoordinatorLayout$LayoutParams) layoutParams).getBehavior() instanceof SwipeDismissBehavior);
    }

    private void setUpBehavior(CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams) {
        SwipeDismissBehavior<? extends View> newBehavior = this.behavior;
        if (newBehavior == null) {
            newBehavior = getNewBehavior();
        }
        if (newBehavior instanceof BaseTransientBottomBar$Behavior) {
            BaseTransientBottomBar$Behavior.access$1300((BaseTransientBottomBar$Behavior) newBehavior, this);
        }
        newBehavior.setListener(new BaseTransientBottomBar$r(this));
        coordinatorLayout$LayoutParams.setBehavior(newBehavior);
        if (this.anchorView == null) {
            coordinatorLayout$LayoutParams.insetEdge = 80;
        }
    }

    private boolean shouldUpdateGestureInset() {
        return this.extraBottomMarginGestureInset > 0 && !this.gestureInsetBottomIgnored && isSwipeDismissable();
    }

    private void showViewImpl() {
        if (shouldAnimate()) {
            animateViewIn();
            return;
        }
        if (this.view.getParent() != null) {
            this.view.setVisibility(0);
        }
        onViewShown();
    }

    private void startFadeInAnimation() {
        ValueAnimator alphaAnimator = getAlphaAnimator(0.0f, 1.0f);
        ValueAnimator scaleAnimator = getScaleAnimator(ANIMATION_SCALE_FROM_VALUE, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(alphaAnimator, scaleAnimator);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new BaseTransientBottomBar$b(this));
        animatorSet.start();
    }

    private void startFadeOutAnimation(int i) {
        ValueAnimator alphaAnimator = getAlphaAnimator(1.0f, 0.0f);
        alphaAnimator.setDuration(75L);
        alphaAnimator.addListener(new BaseTransientBottomBar$c(this, i));
        alphaAnimator.start();
    }

    private void startSlideInAnimation() {
        int translationYBottom = getTranslationYBottom();
        if (USE_OFFSET_API) {
            ViewCompat.offsetTopAndBottom(this.view, translationYBottom);
        } else {
            this.view.setTranslationY(translationYBottom);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(translationYBottom, 0);
        valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new BaseTransientBottomBar$f(this));
        valueAnimator.addUpdateListener(new BaseTransientBottomBar$g(this, translationYBottom));
        valueAnimator.start();
    }

    private void startSlideOutAnimation(int i) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, getTranslationYBottom());
        valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new BaseTransientBottomBar$h(this, i));
        valueAnimator.addUpdateListener(new BaseTransientBottomBar$i(this));
        valueAnimator.start();
    }

    private void updateMargins() {
        Rect rect;
        ViewGroup$LayoutParams layoutParams = this.view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup$MarginLayoutParams) || (rect = this.originalMargins) == null) {
            Log.w(TAG, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams) layoutParams;
        viewGroup$MarginLayoutParams.bottomMargin = rect.bottom + (this.anchorView != null ? this.extraBottomMarginAnchorView : this.extraBottomMarginWindowInset);
        viewGroup$MarginLayoutParams.leftMargin = rect.left + this.extraLeftMarginWindowInset;
        viewGroup$MarginLayoutParams.rightMargin = rect.right + this.extraRightMarginWindowInset;
        this.view.requestLayout();
        if (Build$VERSION.SDK_INT < 29 || !shouldUpdateGestureInset()) {
            return;
        }
        this.view.removeCallbacks(this.bottomMarginGestureInsetRunnable);
        this.view.post(this.bottomMarginGestureInsetRunnable);
    }

    @NonNull
    public B addCallback(@Nullable BaseTransientBottomBar$BaseCallback<B> baseTransientBottomBar$BaseCallback) {
        if (baseTransientBottomBar$BaseCallback == null) {
            return this;
        }
        if (this.callbacks == null) {
            this.callbacks = new ArrayList();
        }
        this.callbacks.add(baseTransientBottomBar$BaseCallback);
        return this;
    }

    public void animateViewIn() {
        this.view.post(new BaseTransientBottomBar$a(this));
    }

    public void dismiss() {
        dispatchDismiss(3);
    }

    public void dispatchDismiss(int i) {
        a aVarB = a.b();
        a$b a_b = this.managerCallback;
        synchronized (aVarB.f1624b) {
            if (aVarB.c(a_b)) {
                aVarB.a(aVarB.d, i);
            } else if (aVarB.d(a_b)) {
                aVarB.a(aVarB.e, i);
            }
        }
    }

    @Nullable
    public View getAnchorView() {
        return this.anchorView;
    }

    public int getAnimationMode() {
        return this.view.getAnimationMode();
    }

    public BaseTransientBottomBar$Behavior getBehavior() {
        return this.behavior;
    }

    @NonNull
    public Context getContext() {
        return this.context;
    }

    public int getDuration() {
        return this.duration;
    }

    @NonNull
    public SwipeDismissBehavior<? extends View> getNewBehavior() {
        return new BaseTransientBottomBar$Behavior();
    }

    @LayoutRes
    public int getSnackbarBaseLayoutResId() {
        return hasSnackbarStyleAttr() ? R$layout.mtrl_layout_snackbar : R$layout.design_layout_snackbar;
    }

    @NonNull
    public View getView() {
        return this.view;
    }

    public boolean hasSnackbarStyleAttr() {
        TypedArray typedArrayObtainStyledAttributes = this.context.obtainStyledAttributes(SNACKBAR_STYLE_ATTR);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    public final void hideView(int i) {
        if (shouldAnimate() && this.view.getVisibility() == 0) {
            animateViewOut(i);
        } else {
            onViewHidden(i);
        }
    }

    public boolean isAnchorViewLayoutListenerEnabled() {
        return this.anchorViewLayoutListenerEnabled;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isShown() {
        boolean zC;
        a aVarB = a.b();
        a$b a_b = this.managerCallback;
        synchronized (aVarB.f1624b) {
            zC = aVarB.c(a_b);
        }
        return zC;
    }

    public boolean isShownOrQueued() {
        boolean z2;
        a aVarB = a.b();
        a$b a_b = this.managerCallback;
        synchronized (aVarB.f1624b) {
            z2 = aVarB.c(a_b) || aVarB.d(a_b);
        }
        return z2;
    }

    public void onViewHidden(int i) {
        a aVarB = a.b();
        a$b a_b = this.managerCallback;
        synchronized (aVarB.f1624b) {
            if (aVarB.c(a_b)) {
                aVarB.d = null;
                if (aVarB.e != null) {
                    aVarB.h();
                }
            }
        }
        List<BaseTransientBottomBar$BaseCallback<B>> list = this.callbacks;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.callbacks.get(size).onDismissed(this, i);
            }
        }
        ViewParent parent = this.view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.view);
        }
    }

    public void onViewShown() {
        a aVarB = a.b();
        a$b a_b = this.managerCallback;
        synchronized (aVarB.f1624b) {
            if (aVarB.c(a_b)) {
                aVarB.g(aVarB.d);
            }
        }
        List<BaseTransientBottomBar$BaseCallback<B>> list = this.callbacks;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.callbacks.get(size).onShown(this);
            }
        }
    }

    @NonNull
    public B removeCallback(@Nullable BaseTransientBottomBar$BaseCallback<B> baseTransientBottomBar$BaseCallback) {
        List<BaseTransientBottomBar$BaseCallback<B>> list;
        if (baseTransientBottomBar$BaseCallback == null || (list = this.callbacks) == null) {
            return this;
        }
        list.remove(baseTransientBottomBar$BaseCallback);
        return this;
    }

    @NonNull
    public B setAnchorView(@Nullable View view) {
        ViewUtils.removeOnGlobalLayoutListener(this.anchorView, this.anchorViewLayoutListener);
        this.anchorView = view;
        ViewUtils.addOnGlobalLayoutListener(view, this.anchorViewLayoutListener);
        return this;
    }

    public void setAnchorViewLayoutListenerEnabled(boolean z2) {
        this.anchorViewLayoutListenerEnabled = z2;
    }

    @NonNull
    public B setAnimationMode(int i) {
        this.view.setAnimationMode(i);
        return this;
    }

    @NonNull
    public B setBehavior(BaseTransientBottomBar$Behavior baseTransientBottomBar$Behavior) {
        this.behavior = baseTransientBottomBar$Behavior;
        return this;
    }

    @NonNull
    public B setDuration(int i) {
        this.duration = i;
        return this;
    }

    @NonNull
    public B setGestureInsetBottomIgnored(boolean z2) {
        this.gestureInsetBottomIgnored = z2;
        return this;
    }

    public boolean shouldAnimate() {
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public void show() {
        a aVarB = a.b();
        int duration = getDuration();
        a$b a_b = this.managerCallback;
        synchronized (aVarB.f1624b) {
            if (aVarB.c(a_b)) {
                a$c a_c = aVarB.d;
                a_c.f1625b = duration;
                aVarB.c.removeCallbacksAndMessages(a_c);
                aVarB.g(aVarB.d);
                return;
            }
            if (aVarB.d(a_b)) {
                aVarB.e.f1625b = duration;
            } else {
                aVarB.e = new a$c(duration, a_b);
            }
            a$c a_c2 = aVarB.d;
            if (a_c2 == null || !aVarB.a(a_c2, 4)) {
                aVarB.d = null;
                aVarB.h();
            }
        }
    }

    public final void showView() {
        this.view.setOnAttachStateChangeListener(new BaseTransientBottomBar$p(this));
        if (this.view.getParent() == null) {
            ViewGroup$LayoutParams layoutParams = this.view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout$LayoutParams) {
                setUpBehavior((CoordinatorLayout$LayoutParams) layoutParams);
            }
            this.extraBottomMarginAnchorView = calculateBottomMarginForAnchorView();
            updateMargins();
            this.view.setVisibility(4);
            this.targetParent.addView(this.view);
        }
        if (ViewCompat.isLaidOut(this.view)) {
            showViewImpl();
        } else {
            this.view.setOnLayoutChangeListener(new BaseTransientBottomBar$q(this));
        }
    }

    public BaseTransientBottomBar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull ContentViewCallback contentViewCallback) {
        this.anchorViewLayoutListenerEnabled = false;
        this.anchorViewLayoutListener = new BaseTransientBottomBar$k(this);
        this.bottomMarginGestureInsetRunnable = new BaseTransientBottomBar$l(this);
        this.managerCallback = new BaseTransientBottomBar$o(this);
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (contentViewCallback == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.targetParent = viewGroup;
        this.contentViewCallback = contentViewCallback;
        this.context = context;
        ThemeEnforcement.checkAppCompatTheme(context);
        BaseTransientBottomBar$SnackbarBaseLayout baseTransientBottomBar$SnackbarBaseLayout = (BaseTransientBottomBar$SnackbarBaseLayout) LayoutInflater.from(context).inflate(getSnackbarBaseLayoutResId(), viewGroup, false);
        this.view = baseTransientBottomBar$SnackbarBaseLayout;
        if (view instanceof SnackbarContentLayout) {
            ((SnackbarContentLayout) view).updateActionTextColorAlphaIfNeeded(baseTransientBottomBar$SnackbarBaseLayout.getActionTextColorAlpha());
        }
        baseTransientBottomBar$SnackbarBaseLayout.addView(view);
        ViewGroup$LayoutParams layoutParams = baseTransientBottomBar$SnackbarBaseLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup$MarginLayoutParams) {
            ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams) layoutParams;
            this.originalMargins = new Rect(viewGroup$MarginLayoutParams.leftMargin, viewGroup$MarginLayoutParams.topMargin, viewGroup$MarginLayoutParams.rightMargin, viewGroup$MarginLayoutParams.bottomMargin);
        }
        ViewCompat.setAccessibilityLiveRegion(baseTransientBottomBar$SnackbarBaseLayout, 1);
        ViewCompat.setImportantForAccessibility(baseTransientBottomBar$SnackbarBaseLayout, 1);
        ViewCompat.setFitsSystemWindows(baseTransientBottomBar$SnackbarBaseLayout, true);
        ViewCompat.setOnApplyWindowInsetsListener(baseTransientBottomBar$SnackbarBaseLayout, new BaseTransientBottomBar$m(this));
        ViewCompat.setAccessibilityDelegate(baseTransientBottomBar$SnackbarBaseLayout, new BaseTransientBottomBar$n(this));
        this.accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
    }

    @NonNull
    public B setAnchorView(@IdRes int i) {
        View viewFindViewById = this.targetParent.findViewById(i);
        if (viewFindViewById != null) {
            return (B) setAnchorView(viewFindViewById);
        }
        throw new IllegalArgumentException(b.d.b.a.a.q("Unable to find anchor view with id: ", i));
    }
}

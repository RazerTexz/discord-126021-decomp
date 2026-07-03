package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.C10817R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p341g.p349h.C4427a;

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
    private final ViewTreeObserver.OnGlobalLayoutListener anchorViewLayoutListener;
    private boolean anchorViewLayoutListenerEnabled;
    private Behavior behavior;

    @RequiresApi(29)
    private final Runnable bottomMarginGestureInsetRunnable;
    private List<BaseCallback<B>> callbacks;

    @NonNull
    private final com.google.android.material.snackbar.ContentViewCallback contentViewCallback;
    private final Context context;
    private int duration;
    private int extraBottomMarginAnchorView;
    private int extraBottomMarginGestureInset;
    private int extraBottomMarginWindowInset;
    private int extraLeftMarginWindowInset;
    private int extraRightMarginWindowInset;
    private boolean gestureInsetBottomIgnored;

    @NonNull
    public C4427a.b managerCallback;

    @Nullable
    private Rect originalMargins;

    @NonNull
    private final ViewGroup targetParent;

    @NonNull
    public final SnackbarBaseLayout view;
    private static final boolean USE_OFFSET_API = false;
    private static final int[] SNACKBAR_STYLE_ATTR = {C10817R.attr.snackbarStyle};
    private static final String TAG = BaseTransientBottomBar.class.getSimpleName();

    @NonNull
    public static final Handler handler = new Handler(Looper.getMainLooper(), new C10994j());

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface AnimationMode {
    }

    public static abstract class BaseCallback<B> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface DismissEvent {
        }

        public void onDismissed(B b2, int i) {
        }

        public void onShown(B b2) {
        }
    }

    public static class Behavior extends SwipeDismissBehavior<View> {

        @NonNull
        private final BehaviorDelegate delegate = new BehaviorDelegate(this);

        private void setBaseTransientBottomBar(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.delegate.setBaseTransientBottomBar(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean canSwipeDismissView(View view) {
            return this.delegate.canSwipeDismissView(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            this.delegate.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class BehaviorDelegate {
        private C4427a.b managerCallback;

        public BehaviorDelegate(@NonNull SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.setStartAlphaSwipeDistance(0.1f);
            swipeDismissBehavior.setEndAlphaSwipeDistance(0.6f);
            swipeDismissBehavior.setSwipeDirection(0);
        }

        public boolean canSwipeDismissView(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        public void onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    C4427a.m6134b().m6138e(this.managerCallback);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                C4427a.m6134b().m6139f(this.managerCallback);
            }
        }

        public void setBaseTransientBottomBar(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.managerCallback = baseTransientBottomBar.managerCallback;
        }
    }

    @Deprecated
    public interface ContentViewCallback extends com.google.android.material.snackbar.ContentViewCallback {
    }

    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Duration {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface OnAttachStateChangeListener {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface OnLayoutChangeListener {
        void onLayoutChange(View view, int i, int i2, int i3, int i4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class SnackbarBaseLayout extends FrameLayout {
        private static final View.OnTouchListener consumeAllTouchListener = new ViewOnTouchListenerC10984a();
        private final float actionTextColorAlpha;
        private int animationMode;
        private final float backgroundOverlayColorAlpha;
        private ColorStateList backgroundTint;
        private PorterDuff.Mode backgroundTintMode;
        private OnAttachStateChangeListener onAttachStateChangeListener;
        private OnLayoutChangeListener onLayoutChangeListener;

        /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout$a */
        public static class ViewOnTouchListenerC10984a implements View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public SnackbarBaseLayout(@NonNull Context context) {
            this(context, null);
        }

        @NonNull
        private Drawable createThemedBackground() {
            float dimension = getResources().getDimension(C10817R.dimen.mtrl_snackbar_background_corner_radius);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(MaterialColors.layer(this, C10817R.attr.colorSurface, C10817R.attr.colorOnSurface, getBackgroundOverlayColorAlpha()));
            if (this.backgroundTint == null) {
                return DrawableCompat.wrap(gradientDrawable);
            }
            Drawable drawableWrap = DrawableCompat.wrap(gradientDrawable);
            DrawableCompat.setTintList(drawableWrap, this.backgroundTint);
            return drawableWrap;
        }

        public float getActionTextColorAlpha() {
            return this.actionTextColorAlpha;
        }

        public int getAnimationMode() {
            return this.animationMode;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.backgroundOverlayColorAlpha;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            OnAttachStateChangeListener onAttachStateChangeListener = this.onAttachStateChangeListener;
            if (onAttachStateChangeListener != null) {
                onAttachStateChangeListener.onViewAttachedToWindow(this);
            }
            ViewCompat.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            OnAttachStateChangeListener onAttachStateChangeListener = this.onAttachStateChangeListener;
            if (onAttachStateChangeListener != null) {
                onAttachStateChangeListener.onViewDetachedFromWindow(this);
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
            super.onLayout(z2, i, i2, i3, i4);
            OnLayoutChangeListener onLayoutChangeListener = this.onLayoutChangeListener;
            if (onLayoutChangeListener != null) {
                onLayoutChangeListener.onLayoutChange(this, i, i2, i3, i4);
            }
        }

        public void setAnimationMode(int i) {
            this.animationMode = i;
        }

        @Override // android.view.View
        public void setBackground(@Nullable Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (drawable != null && this.backgroundTint != null) {
                drawable = DrawableCompat.wrap(drawable.mutate());
                DrawableCompat.setTintList(drawable, this.backgroundTint);
                DrawableCompat.setTintMode(drawable, this.backgroundTintMode);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            this.backgroundTint = colorStateList;
            if (getBackground() != null) {
                Drawable drawableWrap = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintList(drawableWrap, colorStateList);
                DrawableCompat.setTintMode(drawableWrap, this.backgroundTintMode);
                if (drawableWrap != getBackground()) {
                    super.setBackgroundDrawable(drawableWrap);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            this.backgroundTintMode = mode;
            if (getBackground() != null) {
                Drawable drawableWrap = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintMode(drawableWrap, mode);
                if (drawableWrap != getBackground()) {
                    super.setBackgroundDrawable(drawableWrap);
                }
            }
        }

        public void setOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
            this.onAttachStateChangeListener = onAttachStateChangeListener;
        }

        @Override // android.view.View
        public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : consumeAllTouchListener);
            super.setOnClickListener(onClickListener);
        }

        public void setOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener) {
            this.onLayoutChangeListener = onLayoutChangeListener;
        }

        public SnackbarBaseLayout(@NonNull Context context, AttributeSet attributeSet) {
            super(MaterialThemeOverlay.wrap(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, C10817R.styleable.SnackbarLayout);
            int i = C10817R.styleable.SnackbarLayout_elevation;
            if (typedArrayObtainStyledAttributes.hasValue(i)) {
                ViewCompat.setElevation(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(i, 0));
            }
            this.animationMode = typedArrayObtainStyledAttributes.getInt(C10817R.styleable.SnackbarLayout_animationMode, 0);
            this.backgroundOverlayColorAlpha = typedArrayObtainStyledAttributes.getFloat(C10817R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, C10817R.styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(ViewUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(C10817R.styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.actionTextColorAlpha = typedArrayObtainStyledAttributes.getFloat(C10817R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(consumeAllTouchListener);
            setFocusable(true);
            if (getBackground() == null) {
                ViewCompat.setBackground(this, createThemedBackground());
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$a */
    public class RunnableC10985a implements Runnable {
        public RunnableC10985a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SnackbarBaseLayout snackbarBaseLayout = BaseTransientBottomBar.this.view;
            if (snackbarBaseLayout == null) {
                return;
            }
            if (snackbarBaseLayout.getParent() != null) {
                BaseTransientBottomBar.this.view.setVisibility(0);
            }
            if (BaseTransientBottomBar.this.view.getAnimationMode() == 1) {
                BaseTransientBottomBar.this.startFadeInAnimation();
            } else {
                BaseTransientBottomBar.this.startSlideInAnimation();
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$b */
    public class C10986b extends AnimatorListenerAdapter {
        public C10986b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.onViewShown();
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$c */
    public class C10987c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ int f21125a;

        public C10987c(int i) {
            this.f21125a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.onViewHidden(this.f21125a);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$d */
    public class C10988d implements ValueAnimator.AnimatorUpdateListener {
        public C10988d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$e */
    public class C10989e implements ValueAnimator.AnimatorUpdateListener {
        public C10989e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.view.setScaleX(fFloatValue);
            BaseTransientBottomBar.this.view.setScaleY(fFloatValue);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$f */
    public class C10990f extends AnimatorListenerAdapter {
        public C10990f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.onViewShown();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.contentViewCallback.animateContentIn(70, 180);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$g */
    public class C10991g implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a */
        public int f21130a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ int f21131b;

        public C10991g(int i) {
            this.f21131b = i;
            this.f21130a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.USE_OFFSET_API) {
                ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.view, iIntValue - this.f21130a);
            } else {
                BaseTransientBottomBar.this.view.setTranslationY(iIntValue);
            }
            this.f21130a = iIntValue;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$h */
    public class C10992h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ int f21133a;

        public C10992h(int i) {
            this.f21133a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.onViewHidden(this.f21133a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.contentViewCallback.animateContentOut(0, 180);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$i */
    public class C10993i implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a */
        public int f21135a = 0;

        public C10993i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.USE_OFFSET_API) {
                ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.view, iIntValue - this.f21135a);
            } else {
                BaseTransientBottomBar.this.view.setTranslationY(iIntValue);
            }
            this.f21135a = iIntValue;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$j */
    public static class C10994j implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            int i = message.what;
            if (i == 0) {
                ((BaseTransientBottomBar) message.obj).showView();
                return true;
            }
            if (i != 1) {
                return false;
            }
            ((BaseTransientBottomBar) message.obj).hideView(message.arg1);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$k */
    public class ViewTreeObserverOnGlobalLayoutListenerC10995k implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserverOnGlobalLayoutListenerC10995k() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (BaseTransientBottomBar.this.anchorViewLayoutListenerEnabled) {
                BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
                baseTransientBottomBar.extraBottomMarginAnchorView = baseTransientBottomBar.calculateBottomMarginForAnchorView();
                BaseTransientBottomBar.this.updateMargins();
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$l */
    public class RunnableC10996l implements Runnable {
        public RunnableC10996l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int screenHeight;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.view == null || baseTransientBottomBar.context == null || (screenHeight = (BaseTransientBottomBar.this.getScreenHeight() - BaseTransientBottomBar.this.getViewAbsoluteBottom()) + ((int) BaseTransientBottomBar.this.view.getTranslationY())) >= BaseTransientBottomBar.this.extraBottomMarginGestureInset) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.view.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                Log.w(BaseTransientBottomBar.TAG, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                return;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = (BaseTransientBottomBar.this.extraBottomMarginGestureInset - screenHeight) + marginLayoutParams.bottomMargin;
            BaseTransientBottomBar.this.view.requestLayout();
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$m */
    public class C10997m implements OnApplyWindowInsetsListener {
        public C10997m() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            BaseTransientBottomBar.this.extraBottomMarginWindowInset = windowInsetsCompat.getSystemWindowInsetBottom();
            BaseTransientBottomBar.this.extraLeftMarginWindowInset = windowInsetsCompat.getSystemWindowInsetLeft();
            BaseTransientBottomBar.this.extraRightMarginWindowInset = windowInsetsCompat.getSystemWindowInsetRight();
            BaseTransientBottomBar.this.updateMargins();
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$n */
    public class C10998n extends AccessibilityDelegateCompat {
        public C10998n() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.addAction(1048576);
            accessibilityNodeInfoCompat.setDismissable(true);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (i != 1048576) {
                return super.performAccessibilityAction(view, i, bundle);
            }
            BaseTransientBottomBar.this.dismiss();
            return true;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$o */
    public class C10999o implements C4427a.b {
        public C10999o() {
        }

        @Override // p007b.p225i.p226a.p341g.p349h.C4427a.b
        /* JADX INFO: renamed from: a */
        public void mo6142a(int i) {
            Handler handler = BaseTransientBottomBar.handler;
            handler.sendMessage(handler.obtainMessage(1, i, 0, BaseTransientBottomBar.this));
        }

        @Override // p007b.p225i.p226a.p341g.p349h.C4427a.b
        public void show() {
            Handler handler = BaseTransientBottomBar.handler;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$p */
    public class C11000p implements OnAttachStateChangeListener {

        /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$p$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseTransientBottomBar.this.onViewHidden(3);
            }
        }

        public C11000p() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            WindowInsets rootWindowInsets;
            if (Build.VERSION.SDK_INT < 29 || (rootWindowInsets = BaseTransientBottomBar.this.view.getRootWindowInsets()) == null) {
                return;
            }
            BaseTransientBottomBar.this.extraBottomMarginGestureInset = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
            BaseTransientBottomBar.this.updateMargins();
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (BaseTransientBottomBar.this.isShownOrQueued()) {
                BaseTransientBottomBar.handler.post(new a());
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$q */
    public class C11001q implements OnLayoutChangeListener {
        public C11001q() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4) {
            BaseTransientBottomBar.this.view.setOnLayoutChangeListener(null);
            BaseTransientBottomBar.this.showViewImpl();
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$r */
    public class C11002r implements SwipeDismissBehavior.OnDismissListener {
        public C11002r() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
        public void onDismiss(@NonNull View view) {
            if (view.getParent() != null) {
                view.setVisibility(8);
            }
            BaseTransientBottomBar.this.dispatchDismiss(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
        public void onDragStateChanged(int i) {
            if (i == 0) {
                C4427a.m6134b().m6139f(BaseTransientBottomBar.this.managerCallback);
            } else if (i == 1 || i == 2) {
                C4427a.m6134b().m6138e(BaseTransientBottomBar.this.managerCallback);
            }
        }
    }

    public BaseTransientBottomBar(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull com.google.android.material.snackbar.ContentViewCallback contentViewCallback) {
        this(viewGroup.getContext(), viewGroup, view, contentViewCallback);
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
        valueAnimatorOfFloat.addUpdateListener(new C10988d());
        return valueAnimatorOfFloat;
    }

    private ValueAnimator getScaleAnimator(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimatorOfFloat.addUpdateListener(new C10989e());
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
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    private int getViewAbsoluteBottom() {
        int[] iArr = new int[2];
        this.view.getLocationOnScreen(iArr);
        return this.view.getHeight() + iArr[1];
    }

    private boolean isSwipeDismissable() {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof SwipeDismissBehavior);
    }

    private void setUpBehavior(CoordinatorLayout.LayoutParams layoutParams) {
        SwipeDismissBehavior<? extends View> newBehavior = this.behavior;
        if (newBehavior == null) {
            newBehavior = getNewBehavior();
        }
        if (newBehavior instanceof Behavior) {
            ((Behavior) newBehavior).setBaseTransientBottomBar(this);
        }
        newBehavior.setListener(new C11002r());
        layoutParams.setBehavior(newBehavior);
        if (this.anchorView == null) {
            layoutParams.insetEdge = 80;
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
        animatorSet.addListener(new C10986b());
        animatorSet.start();
    }

    private void startFadeOutAnimation(int i) {
        ValueAnimator alphaAnimator = getAlphaAnimator(1.0f, 0.0f);
        alphaAnimator.setDuration(75L);
        alphaAnimator.addListener(new C10987c(i));
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
        valueAnimator.addListener(new C10990f());
        valueAnimator.addUpdateListener(new C10991g(translationYBottom));
        valueAnimator.start();
    }

    private void startSlideOutAnimation(int i) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, getTranslationYBottom());
        valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new C10992h(i));
        valueAnimator.addUpdateListener(new C10993i());
        valueAnimator.start();
    }

    private void updateMargins() {
        Rect rect;
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || (rect = this.originalMargins) == null) {
            Log.w(TAG, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = rect.bottom + (this.anchorView != null ? this.extraBottomMarginAnchorView : this.extraBottomMarginWindowInset);
        marginLayoutParams.leftMargin = rect.left + this.extraLeftMarginWindowInset;
        marginLayoutParams.rightMargin = rect.right + this.extraRightMarginWindowInset;
        this.view.requestLayout();
        if (Build.VERSION.SDK_INT < 29 || !shouldUpdateGestureInset()) {
            return;
        }
        this.view.removeCallbacks(this.bottomMarginGestureInsetRunnable);
        this.view.post(this.bottomMarginGestureInsetRunnable);
    }

    @NonNull
    public B addCallback(@Nullable BaseCallback<B> baseCallback) {
        if (baseCallback == null) {
            return this;
        }
        if (this.callbacks == null) {
            this.callbacks = new ArrayList();
        }
        this.callbacks.add(baseCallback);
        return this;
    }

    public void animateViewIn() {
        this.view.post(new RunnableC10985a());
    }

    public void dismiss() {
        dispatchDismiss(3);
    }

    public void dispatchDismiss(int i) {
        C4427a c4427aM6134b = C4427a.m6134b();
        C4427a.b bVar = this.managerCallback;
        synchronized (c4427aM6134b.f11763b) {
            if (c4427aM6134b.m6136c(bVar)) {
                c4427aM6134b.m6135a(c4427aM6134b.f11765d, i);
            } else if (c4427aM6134b.m6137d(bVar)) {
                c4427aM6134b.m6135a(c4427aM6134b.f11766e, i);
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

    public Behavior getBehavior() {
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
        return new Behavior();
    }

    @LayoutRes
    public int getSnackbarBaseLayoutResId() {
        return hasSnackbarStyleAttr() ? C10817R.layout.mtrl_layout_snackbar : C10817R.layout.design_layout_snackbar;
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
        boolean zM6136c;
        C4427a c4427aM6134b = C4427a.m6134b();
        C4427a.b bVar = this.managerCallback;
        synchronized (c4427aM6134b.f11763b) {
            zM6136c = c4427aM6134b.m6136c(bVar);
        }
        return zM6136c;
    }

    public boolean isShownOrQueued() {
        boolean z2;
        C4427a c4427aM6134b = C4427a.m6134b();
        C4427a.b bVar = this.managerCallback;
        synchronized (c4427aM6134b.f11763b) {
            z2 = c4427aM6134b.m6136c(bVar) || c4427aM6134b.m6137d(bVar);
        }
        return z2;
    }

    public void onViewHidden(int i) {
        C4427a c4427aM6134b = C4427a.m6134b();
        C4427a.b bVar = this.managerCallback;
        synchronized (c4427aM6134b.f11763b) {
            if (c4427aM6134b.m6136c(bVar)) {
                c4427aM6134b.f11765d = null;
                if (c4427aM6134b.f11766e != null) {
                    c4427aM6134b.m6141h();
                }
            }
        }
        List<BaseCallback<B>> list = this.callbacks;
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
        C4427a c4427aM6134b = C4427a.m6134b();
        C4427a.b bVar = this.managerCallback;
        synchronized (c4427aM6134b.f11763b) {
            if (c4427aM6134b.m6136c(bVar)) {
                c4427aM6134b.m6140g(c4427aM6134b.f11765d);
            }
        }
        List<BaseCallback<B>> list = this.callbacks;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.callbacks.get(size).onShown(this);
            }
        }
    }

    @NonNull
    public B removeCallback(@Nullable BaseCallback<B> baseCallback) {
        List<BaseCallback<B>> list;
        if (baseCallback == null || (list = this.callbacks) == null) {
            return this;
        }
        list.remove(baseCallback);
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
    public B setBehavior(Behavior behavior) {
        this.behavior = behavior;
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
        C4427a c4427aM6134b = C4427a.m6134b();
        int duration = getDuration();
        C4427a.b bVar = this.managerCallback;
        synchronized (c4427aM6134b.f11763b) {
            if (c4427aM6134b.m6136c(bVar)) {
                C4427a.c cVar = c4427aM6134b.f11765d;
                cVar.f11769b = duration;
                c4427aM6134b.f11764c.removeCallbacksAndMessages(cVar);
                c4427aM6134b.m6140g(c4427aM6134b.f11765d);
                return;
            }
            if (c4427aM6134b.m6137d(bVar)) {
                c4427aM6134b.f11766e.f11769b = duration;
            } else {
                c4427aM6134b.f11766e = new C4427a.c(duration, bVar);
            }
            C4427a.c cVar2 = c4427aM6134b.f11765d;
            if (cVar2 == null || !c4427aM6134b.m6135a(cVar2, 4)) {
                c4427aM6134b.f11765d = null;
                c4427aM6134b.m6141h();
            }
        }
    }

    public final void showView() {
        this.view.setOnAttachStateChangeListener(new C11000p());
        if (this.view.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                setUpBehavior((CoordinatorLayout.LayoutParams) layoutParams);
            }
            this.extraBottomMarginAnchorView = calculateBottomMarginForAnchorView();
            updateMargins();
            this.view.setVisibility(4);
            this.targetParent.addView(this.view);
        }
        if (ViewCompat.isLaidOut(this.view)) {
            showViewImpl();
        } else {
            this.view.setOnLayoutChangeListener(new C11001q());
        }
    }

    public BaseTransientBottomBar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull com.google.android.material.snackbar.ContentViewCallback contentViewCallback) {
        this.anchorViewLayoutListenerEnabled = false;
        this.anchorViewLayoutListener = new ViewTreeObserverOnGlobalLayoutListenerC10995k();
        this.bottomMarginGestureInsetRunnable = new RunnableC10996l();
        this.managerCallback = new C10999o();
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
        SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) LayoutInflater.from(context).inflate(getSnackbarBaseLayoutResId(), viewGroup, false);
        this.view = snackbarBaseLayout;
        if (view instanceof SnackbarContentLayout) {
            ((SnackbarContentLayout) view).updateActionTextColorAlphaIfNeeded(snackbarBaseLayout.getActionTextColorAlpha());
        }
        snackbarBaseLayout.addView(view);
        ViewGroup.LayoutParams layoutParams = snackbarBaseLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            this.originalMargins = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        ViewCompat.setAccessibilityLiveRegion(snackbarBaseLayout, 1);
        ViewCompat.setImportantForAccessibility(snackbarBaseLayout, 1);
        ViewCompat.setFitsSystemWindows(snackbarBaseLayout, true);
        ViewCompat.setOnApplyWindowInsetsListener(snackbarBaseLayout, new C10997m());
        ViewCompat.setAccessibilityDelegate(snackbarBaseLayout, new C10998n());
        this.accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
    }

    @NonNull
    public B setAnchorView(@IdRes int i) {
        View viewFindViewById = this.targetParent.findViewById(i);
        if (viewFindViewById != null) {
            return (B) setAnchorView(viewFindViewById);
        }
        throw new IllegalArgumentException(C1643a.m871q("Unable to find anchor view with id: ", i));
    }
}

package com.discord.overlay.views;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager$LayoutParams;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import b.d.b.a.a;
import com.discord.overlay.R$b;
import com.discord.overlay.R$c;
import com.discord.utilities.display.DisplayUtils;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.s;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: OverlayBubbleWrap.kt */
/* JADX INFO: loaded from: classes.dex */
public class OverlayBubbleWrap extends FrameLayout {
    public static final /* synthetic */ KProperty[] j = {a0.mutableProperty1(new s(OverlayBubbleWrap.class, "isMoving", "isMoving()Z", 0))};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final WindowManager windowManager;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public WindowManager$LayoutParams windowLayoutParams;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Rect insetMargins;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final int moveThresholdPx;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public final ReadWriteProperty isMoving;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public Function1<? super Boolean, Unit> onMovingStateChanged;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public final int[] screenOffset;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public int deltaX;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    public int deltaY;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public final SpringAnimation springAnimationX;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public final SpringAnimation springAnimationY;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public Point actualPosition;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    public Point anchorPosition;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayBubbleWrap(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        Object systemService = getContext().getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.windowManager = (WindowManager) systemService;
        WindowManager$LayoutParams windowManager$LayoutParams = new WindowManager$LayoutParams(-2, -2, Build$VERSION.SDK_INT <= 25 ? 2007 : 2038, 16777768, -3);
        windowManager$LayoutParams.gravity = 51;
        this.windowLayoutParams = windowManager$LayoutParams;
        this.insetMargins = new Rect();
        this.moveThresholdPx = getResources().getDimensionPixelOffset(R$b.movement_threshold_dp);
        setStateListAnimator(AnimatorInflater.loadStateListAnimator(getContext(), R$c.bubble_state_selector));
        Boolean bool = Boolean.FALSE;
        this.isMoving = new OverlayBubbleWrap$a(bool, bool, this);
        this.screenOffset = new int[2];
        SpringAnimation springAnimation = new SpringAnimation(this, DynamicAnimation.X, 0.0f);
        springAnimation.setStartVelocity(50.0f);
        SpringForce spring = springAnimation.getSpring();
        m.checkNotNullExpressionValue(spring, "spring");
        spring.setStiffness(200.0f);
        SpringForce spring2 = springAnimation.getSpring();
        m.checkNotNullExpressionValue(spring2, "spring");
        spring2.setDampingRatio(0.75f);
        this.springAnimationX = springAnimation;
        SpringAnimation springAnimation2 = new SpringAnimation(this, DynamicAnimation.Y, 0.0f);
        springAnimation2.setStartVelocity(50.0f);
        SpringForce spring3 = springAnimation2.getSpring();
        m.checkNotNullExpressionValue(spring3, "spring");
        spring3.setDampingRatio(0.75f);
        SpringForce spring4 = springAnimation2.getSpring();
        m.checkNotNullExpressionValue(spring4, "spring");
        spring4.setStiffness(200.0f);
        this.springAnimationY = springAnimation2;
        WindowManager$LayoutParams windowManager$LayoutParams2 = this.windowLayoutParams;
        this.actualPosition = new Point(windowManager$LayoutParams2.x, windowManager$LayoutParams2.y);
    }

    public static void c(OverlayBubbleWrap overlayBubbleWrap, int i, int i2, Rect rect, int i3, Object obj) {
        Rect rectE;
        if ((i3 & 4) != 0) {
            Context context = overlayBubbleWrap.getContext();
            m.checkNotNullExpressionValue(context, "context");
            rectE = overlayBubbleWrap.e(context);
        } else {
            rectE = null;
        }
        m.checkNotNullParameter(rectE, "screenBounds");
        int iMin = Math.min(Math.max(rectE.left, i), rectE.right - overlayBubbleWrap.getWidth());
        SpringAnimation springAnimation = overlayBubbleWrap.springAnimationX;
        float f = overlayBubbleWrap.windowLayoutParams.x;
        m.checkNotNullParameter(springAnimation, "$this$animateTo");
        springAnimation.cancel();
        springAnimation.setStartValue(f);
        springAnimation.animateToFinalPosition(iMin);
        int iMin2 = Math.min(Math.max(rectE.top - overlayBubbleWrap.screenOffset[1], i2), rectE.bottom - overlayBubbleWrap.getHeight());
        SpringAnimation springAnimation2 = overlayBubbleWrap.springAnimationY;
        float f2 = overlayBubbleWrap.windowLayoutParams.y;
        m.checkNotNullParameter(springAnimation2, "$this$animateTo");
        springAnimation2.cancel();
        springAnimation2.setStartValue(f2);
        springAnimation2.animateToFinalPosition(iMin2);
    }

    public static /* synthetic */ void getSpringAnimationX$annotations() {
    }

    public static /* synthetic */ void getSpringAnimationY$annotations() {
    }

    public void a(boolean animate) {
        String simpleName = getClass().getSimpleName();
        StringBuilder sbU = a.U("Unanchoring[");
        sbU.append(this.anchorPosition);
        sbU.append("] -> ");
        sbU.append(this.actualPosition);
        Log.d(simpleName, sbU.toString());
        this.anchorPosition = null;
        this.springAnimationX.cancel();
        this.springAnimationY.cancel();
        if (animate) {
            Point point = this.actualPosition;
            c(this, point.x, point.y, null, 4, null);
            return;
        }
        WindowManager$LayoutParams windowManager$LayoutParams = this.windowLayoutParams;
        Point point2 = this.actualPosition;
        windowManager$LayoutParams.x = point2.x;
        windowManager$LayoutParams.y = point2.y;
        this.windowManager.updateViewLayout(this, windowManager$LayoutParams);
    }

    public void b(View targetView) {
        m.checkNotNullParameter(targetView, "targetView");
        m.checkNotNullParameter(targetView, "view");
        int[] iArr = {(targetView.getWidth() / 2) + i, (targetView.getHeight() / 2) + i};
        m.checkNotNullParameter(iArr, "outLocation");
        targetView.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[0];
        int[] iArr2 = this.screenOffset;
        Point point = new Point((i3 - iArr2[0]) - (getWidth() / 2), (iArr[1] - iArr2[1]) - (getHeight() / 2));
        setAnchorAt(point);
        c(this, point.x, point.y, null, 4, null);
        String simpleName = getClass().getSimpleName();
        StringBuilder sbU = a.U("Anchored[");
        sbU.append(this.actualPosition);
        sbU.append("] -> ");
        sbU.append(targetView);
        Log.d(simpleName, sbU.toString());
    }

    public final void d() {
        getLocationOnScreen(this.screenOffset);
        int[] iArr = this.screenOffset;
        int i = iArr[0];
        WindowManager$LayoutParams windowManager$LayoutParams = this.windowLayoutParams;
        iArr[0] = i - windowManager$LayoutParams.x;
        iArr[1] = iArr[1] - windowManager$LayoutParams.y;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        m.checkNotNullParameter(motionEvent, "motionEvent");
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (f()) {
                        this.actualPosition.x = ((int) motionEvent.getRawX()) - this.deltaX;
                        this.actualPosition.y = ((int) motionEvent.getRawY()) - this.deltaY;
                        if (ViewCompat.isAttachedToWindow(this) && this.anchorPosition == null) {
                            WindowManager$LayoutParams windowManager$LayoutParams = this.windowLayoutParams;
                            Point point = this.actualPosition;
                            windowManager$LayoutParams.x = point.x;
                            windowManager$LayoutParams.y = point.y;
                            this.windowManager.updateViewLayout(this, windowManager$LayoutParams);
                        }
                    } else {
                        if (Math.abs((this.deltaX + this.windowLayoutParams.x) - ((int) motionEvent.getRawX())) > this.moveThresholdPx) {
                            setMoving(true);
                        }
                    }
                }
            } else if (f()) {
                setMoving(false);
            }
        } else {
            this.deltaX = ((int) motionEvent.getRawX()) - this.windowLayoutParams.x;
            this.deltaY = ((int) motionEvent.getRawY()) - this.windowLayoutParams.y;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final Rect e(Context context) {
        m.checkNotNullParameter(context, "context");
        Rect screenSize = DisplayUtils.getScreenSize(context);
        int i = screenSize.left;
        Rect rect = this.insetMargins;
        screenSize.left = i + rect.left;
        screenSize.right -= rect.right;
        screenSize.top += rect.top;
        screenSize.bottom -= rect.bottom;
        return screenSize;
    }

    public boolean f() {
        return ((Boolean) this.isMoving.getValue(this, j[0])).booleanValue();
    }

    public final int getCenterX() {
        return (getWidth() / 2) + this.windowLayoutParams.x;
    }

    public final int getCenterY() {
        return (getHeight() / 2) + this.windowLayoutParams.y;
    }

    public final Rect getInsetMargins() {
        return this.insetMargins;
    }

    public final int getMoveThresholdPx() {
        return this.moveThresholdPx;
    }

    public final Function1<Boolean, Unit> getOnMovingStateChanged() {
        return this.onMovingStateChanged;
    }

    public final int[] getScreenOffset() {
        return this.screenOffset;
    }

    public final SpringAnimation getSpringAnimationX() {
        return this.springAnimationX;
    }

    public final SpringAnimation getSpringAnimationY() {
        return this.springAnimationY;
    }

    public final WindowManager$LayoutParams getWindowLayoutParams() {
        return this.windowLayoutParams;
    }

    public final WindowManager getWindowManager() {
        return this.windowManager;
    }

    @Override // android.view.View
    public float getX() {
        return this.windowLayoutParams.x;
    }

    @Override // android.view.View
    public float getY() {
        return this.windowLayoutParams.y;
    }

    @Override // android.view.View
    @CallSuper
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.windowManager.updateViewLayout(this, this.windowLayoutParams);
        if (!ViewCompat.isLaidOut(this) || isLayoutRequested()) {
            addOnLayoutChangeListener(new OverlayBubbleWrap$b(this));
        } else {
            d();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m.checkNotNullParameter(motionEvent, "motionEvent");
        return motionEvent.getAction() != 2 ? super.onInterceptTouchEvent(motionEvent) : f();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            d();
        }
    }

    public final void setAnchorAt(Point newAnchorPoint) {
        m.checkNotNullParameter(newAnchorPoint, "newAnchorPoint");
        this.actualPosition.x = (int) getX();
        this.actualPosition.y = (int) getY();
        this.anchorPosition = newAnchorPoint;
        String simpleName = getClass().getSimpleName();
        StringBuilder sbU = a.U("Anchoring[");
        sbU.append(this.actualPosition);
        sbU.append("] -> ");
        sbU.append(this.anchorPosition);
        Log.d(simpleName, sbU.toString());
    }

    public final void setBubbleTouchable(boolean isTouchable) {
        WindowManager$LayoutParams windowManager$LayoutParams = this.windowLayoutParams;
        m.checkNotNullParameter(windowManager$LayoutParams, "$this$setFlagTouchable");
        if (isTouchable) {
            m.checkNotNullParameter(windowManager$LayoutParams, "$this$removeFlag");
            windowManager$LayoutParams.flags &= -17;
        } else {
            m.checkNotNullParameter(windowManager$LayoutParams, "$this$addFlag");
            windowManager$LayoutParams.flags = 16 | windowManager$LayoutParams.flags;
        }
        this.windowManager.updateViewLayout(this, this.windowLayoutParams);
    }

    public void setMoving(boolean z2) {
        this.isMoving.setValue(this, j[0], Boolean.valueOf(z2));
    }

    public final void setOnMovingStateChanged(Function1<? super Boolean, Unit> function1) {
        this.onMovingStateChanged = function1;
    }

    public final void setWindowLayoutParams(WindowManager$LayoutParams windowManager$LayoutParams) {
        m.checkNotNullParameter(windowManager$LayoutParams, "<set-?>");
        this.windowLayoutParams = windowManager$LayoutParams;
    }

    @Override // android.view.View
    public void setX(float x2) {
        this.windowLayoutParams.x = (int) x2;
        if (ViewCompat.isAttachedToWindow(this)) {
            this.windowManager.updateViewLayout(this, this.windowLayoutParams);
        }
    }

    @Override // android.view.View
    public void setY(float y2) {
        this.windowLayoutParams.y = (int) y2;
        if (ViewCompat.isAttachedToWindow(this)) {
            this.windowManager.updateViewLayout(this, this.windowLayoutParams);
        }
    }
}

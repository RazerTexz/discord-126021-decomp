package com.discord.panels;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import b.a.o.a;
import d0.t.n;
import d0.z.d.h;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: OverlappingPanelsLayout.kt */
/* JADX INFO: loaded from: classes.dex */
public class OverlappingPanelsLayout extends FrameLayout {
    public static final OverlappingPanelsLayout$Companion Companion = new OverlappingPanelsLayout$Companion(null);
    private static final long SIDE_PANEL_CLOSE_DURATION_MS = 200;
    private static final long SIDE_PANEL_OPEN_DURATION_MS = 250;
    private HashMap _$_findViewCache;
    private View centerPanel;
    private float centerPanelAnimationEndX;
    private float centerPanelDiffX;
    private ValueAnimator centerPanelXAnimator;
    private List<Rect> childGestureRegions;
    private View endPanel;
    private OverlappingPanelsLayout$LockState endPanelLockState;
    private float endPanelOpenedCenterPanelX;
    private PanelState endPanelState;
    private final ArrayList<OverlappingPanelsLayout$PanelStateListener> endPanelStateListeners;
    private float homeGestureFromBottomThreshold;
    private boolean isHomeSystemGesture;
    private boolean isLeftToRight;
    private boolean isScrollingHorizontally;
    private final boolean isSystemGestureNavigationPossible;
    private float minFlingPxPerSecond;
    private int nonFullScreenSidePanelWidth;
    private Function0<Unit> pendingUpdate;
    private float scrollingSlopPx;
    private OverlappingPanelsLayout$Panel selectedPanel;
    private View startPanel;
    private OverlappingPanelsLayout$LockState startPanelLockState;
    private float startPanelOpenedCenterPanelX;
    private PanelState startPanelState;
    private final ArrayList<OverlappingPanelsLayout$PanelStateListener> startPanelStateListeners;
    private OverlappingPanelsLayout$SwipeDirection swipeDirection;
    private boolean useFullWidthForStartPanel;
    private VelocityTracker velocityTracker;
    private boolean wasActionDownOnClosedCenterPanel;
    private float xFromInterceptActionDown;
    private float yFromInterceptActionDown;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlappingPanelsLayout(Context context) {
        super(context);
        m.checkParameterIsNotNull(context, "context");
        this.isLeftToRight = true;
        h hVar = h.a;
        this.startPanelOpenedCenterPanelX = hVar.getMIN_VALUE();
        this.endPanelOpenedCenterPanelX = hVar.getMAX_VALUE();
        this.startPanelStateListeners = new ArrayList<>();
        this.endPanelStateListeners = new ArrayList<>();
        this.selectedPanel = OverlappingPanelsLayout$Panel.CENTER;
        OverlappingPanelsLayout$LockState overlappingPanelsLayout$LockState = OverlappingPanelsLayout$LockState.UNLOCKED;
        this.startPanelLockState = overlappingPanelsLayout$LockState;
        this.endPanelLockState = overlappingPanelsLayout$LockState;
        PanelState$a panelState$a = PanelState$a.a;
        this.startPanelState = panelState$a;
        this.endPanelState = panelState$a;
        this.childGestureRegions = n.emptyList();
        this.isSystemGestureNavigationPossible = Build$VERSION.SDK_INT >= 29;
    }

    public static final /* synthetic */ void access$closePanels(OverlappingPanelsLayout overlappingPanelsLayout, boolean z2) {
        overlappingPanelsLayout.closePanels(z2);
    }

    public static final /* synthetic */ View access$getCenterPanel$p(OverlappingPanelsLayout overlappingPanelsLayout) {
        View view = overlappingPanelsLayout.centerPanel;
        if (view == null) {
            m.throwUninitializedPropertyAccessException("centerPanel");
        }
        return view;
    }

    public static final /* synthetic */ View access$getStartPanel$p(OverlappingPanelsLayout overlappingPanelsLayout) {
        View view = overlappingPanelsLayout.startPanel;
        if (view == null) {
            m.throwUninitializedPropertyAccessException("startPanel");
        }
        return view;
    }

    public static final /* synthetic */ void access$handleEndPanelWidthUpdate(OverlappingPanelsLayout overlappingPanelsLayout) {
        overlappingPanelsLayout.handleEndPanelWidthUpdate();
    }

    public static final /* synthetic */ void access$handleStartPanelWidthUpdate(OverlappingPanelsLayout overlappingPanelsLayout) {
        overlappingPanelsLayout.handleStartPanelWidthUpdate();
    }

    public static final /* synthetic */ boolean access$isLeftToRight$p(OverlappingPanelsLayout overlappingPanelsLayout) {
        return overlappingPanelsLayout.isLeftToRight;
    }

    public static final /* synthetic */ void access$openEndPanel(OverlappingPanelsLayout overlappingPanelsLayout, boolean z2) {
        overlappingPanelsLayout.openEndPanel(z2);
    }

    public static final /* synthetic */ void access$openStartPanel(OverlappingPanelsLayout overlappingPanelsLayout, boolean z2) {
        overlappingPanelsLayout.openStartPanel(z2);
    }

    public static final /* synthetic */ void access$setCenterPanel$p(OverlappingPanelsLayout overlappingPanelsLayout, View view) {
        overlappingPanelsLayout.centerPanel = view;
    }

    public static final /* synthetic */ void access$setLeftToRight$p(OverlappingPanelsLayout overlappingPanelsLayout, boolean z2) {
        overlappingPanelsLayout.isLeftToRight = z2;
    }

    public static final /* synthetic */ void access$setStartPanel$p(OverlappingPanelsLayout overlappingPanelsLayout, View view) {
        overlappingPanelsLayout.startPanel = view;
    }

    public static final /* synthetic */ void access$updateCenterPanelX(OverlappingPanelsLayout overlappingPanelsLayout, float f) {
        overlappingPanelsLayout.updateCenterPanelX(f);
    }

    private final float calculateDistanceX(float startX, MotionEvent event) {
        return event.getX() - startX;
    }

    private final float calculateDistanceY(float startY, MotionEvent event) {
        return event.getY() - startY;
    }

    public static /* synthetic */ void closePanels$default(OverlappingPanelsLayout overlappingPanelsLayout, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: closePanels");
        }
        if ((i & 1) != 0) {
            z2 = false;
        }
        overlappingPanelsLayout.closePanels(z2);
    }

    private final PanelState getEndPanelState(float previousX, float x2) {
        boolean z2 = this.isLeftToRight;
        if (z2 && x2 >= 0.0f) {
            return PanelState$a.a;
        }
        if (!z2 && x2 <= 0.0f) {
            return PanelState$a.a;
        }
        if (x2 == this.endPanelOpenedCenterPanelX) {
            return PanelState$c.a;
        }
        if (!z2 || x2 >= previousX) {
            return (z2 || x2 <= previousX) ? PanelState$b.a : PanelState$d.a;
        }
        return PanelState$d.a;
    }

    private final OverlappingPanelsLayout$Panel getLeftPanel() {
        return this.isLeftToRight ? OverlappingPanelsLayout$Panel.START : OverlappingPanelsLayout$Panel.END;
    }

    private final OverlappingPanelsLayout$LockState getLeftPanelLockState() {
        return this.isLeftToRight ? this.startPanelLockState : this.endPanelLockState;
    }

    private final float getNormalizedX(float targetedX) {
        OverlappingPanelsLayout$LockState overlappingPanelsLayout$LockState = this.startPanelLockState;
        OverlappingPanelsLayout$LockState overlappingPanelsLayout$LockState2 = OverlappingPanelsLayout$LockState.OPEN;
        if (overlappingPanelsLayout$LockState == overlappingPanelsLayout$LockState2) {
            return this.startPanelOpenedCenterPanelX;
        }
        if (this.endPanelLockState == overlappingPanelsLayout$LockState2) {
            return this.endPanelOpenedCenterPanelX;
        }
        OverlappingPanelsLayout$LockState leftPanelLockState = getLeftPanelLockState();
        OverlappingPanelsLayout$LockState overlappingPanelsLayout$LockState3 = OverlappingPanelsLayout$LockState.CLOSE;
        float fMin = 0.0f;
        float fMax = (leftPanelLockState == overlappingPanelsLayout$LockState3 || (this.selectedPanel == OverlappingPanelsLayout$Panel.CENTER && this.swipeDirection == OverlappingPanelsLayout$SwipeDirection.LEFT)) ? 0.0f : Math.max(this.startPanelOpenedCenterPanelX, this.endPanelOpenedCenterPanelX);
        if (getRightPanelLockState() != overlappingPanelsLayout$LockState3 && (this.selectedPanel != OverlappingPanelsLayout$Panel.CENTER || this.swipeDirection != OverlappingPanelsLayout$SwipeDirection.RIGHT)) {
            fMin = Math.min(this.startPanelOpenedCenterPanelX, this.endPanelOpenedCenterPanelX);
        }
        if (targetedX > fMax) {
            return fMax;
        }
        return targetedX < fMin ? fMin : targetedX;
    }

    private final OverlappingPanelsLayout$Panel getRightPanel() {
        return this.isLeftToRight ? OverlappingPanelsLayout$Panel.END : OverlappingPanelsLayout$Panel.START;
    }

    private final OverlappingPanelsLayout$LockState getRightPanelLockState() {
        return this.isLeftToRight ? this.endPanelLockState : this.startPanelLockState;
    }

    private final PanelState getStartPanelState(float previousX, float x2) {
        boolean z2 = this.isLeftToRight;
        if (z2 && x2 <= 0.0f) {
            return PanelState$a.a;
        }
        if (!z2 && x2 >= 0.0f) {
            return PanelState$a.a;
        }
        if (x2 == this.startPanelOpenedCenterPanelX) {
            return PanelState$c.a;
        }
        if (!z2 || x2 <= previousX) {
            return (z2 || x2 >= previousX) ? PanelState$b.a : PanelState$d.a;
        }
        return PanelState$d.a;
    }

    private final float getTargetedX(MotionEvent event) {
        return event.getRawX() + this.centerPanelDiffX;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0022  */
    /* JADX WARN: Code duplicated, block: B:14:0x0026  */
    /* JADX WARN: Code duplicated, block: B:16:0x002a  */
    /* JADX WARN: Code duplicated, block: B:19:0x0036  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:33:0x005d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0061  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d  */
    private final void handleCenterPanelX(float previousX, float x2) {
        View view;
        int i;
        View view2;
        int i2;
        View view3 = this.startPanel;
        if (view3 == null) {
            m.throwUninitializedPropertyAccessException("startPanel");
        }
        if (this.isLeftToRight) {
            View view4 = this.centerPanel;
            if (view4 == null) {
                m.throwUninitializedPropertyAccessException("centerPanel");
            }
            if (view4.getX() <= 0) {
                if (!this.isLeftToRight) {
                    view = this.centerPanel;
                    if (view == null) {
                        m.throwUninitializedPropertyAccessException("centerPanel");
                    }
                    if (view.getX() < ((float) 0)) {
                    }
                }
            }
        } else {
            if (!this.isLeftToRight) {
                view = this.centerPanel;
                if (view == null) {
                    m.throwUninitializedPropertyAccessException("centerPanel");
                }
                i = view.getX() < ((float) 0) ? 0 : 4;
            }
        }
        view3.setVisibility(i);
        View view5 = this.endPanel;
        if (view5 == null) {
            m.throwUninitializedPropertyAccessException("endPanel");
        }
        if (this.isLeftToRight) {
            View view6 = this.centerPanel;
            if (view6 == null) {
                m.throwUninitializedPropertyAccessException("centerPanel");
            }
            if (view6.getX() >= 0) {
                if (!this.isLeftToRight) {
                    view2 = this.centerPanel;
                    if (view2 == null) {
                        m.throwUninitializedPropertyAccessException("centerPanel");
                    }
                    if (view2.getX() > ((float) 0)) {
                    }
                }
            }
        } else {
            if (!this.isLeftToRight) {
                view2 = this.centerPanel;
                if (view2 == null) {
                    m.throwUninitializedPropertyAccessException("centerPanel");
                }
                i2 = view2.getX() > ((float) 0) ? 0 : 4;
            }
        }
        view5.setVisibility(i2);
        if (x2 == 0.0f) {
            this.selectedPanel = OverlappingPanelsLayout$Panel.CENTER;
        } else if (x2 == this.startPanelOpenedCenterPanelX) {
            this.selectedPanel = OverlappingPanelsLayout$Panel.START;
        } else if (x2 == this.endPanelOpenedCenterPanelX) {
            this.selectedPanel = OverlappingPanelsLayout$Panel.END;
        }
        boolean z2 = x2 == this.endPanelOpenedCenterPanelX || x2 == this.startPanelOpenedCenterPanelX;
        View view7 = this.centerPanel;
        if (view7 == null) {
            m.throwUninitializedPropertyAccessException("centerPanel");
        }
        boolean z3 = !z2;
        m.checkParameterIsNotNull(view7, "$this$setEnabledAlpha");
        view7.setAlpha(z3 ? 1.0f : 0.5f);
        View view8 = this.centerPanel;
        if (view8 == null) {
            m.throwUninitializedPropertyAccessException("centerPanel");
        }
        view8.setImportantForAccessibility(z2 ? 4 : 0);
        boolean z4 = x2 == 0.0f || z2;
        View view9 = this.centerPanel;
        if (view9 == null) {
            m.throwUninitializedPropertyAccessException("centerPanel");
        }
        view9.setElevation(z4 ? 0.0f : getResources().getDimension(R$a.overlapping_panels_center_panel_non_resting_elevation));
        this.startPanelState = getStartPanelState(previousX, x2);
        Iterator<OverlappingPanelsLayout$PanelStateListener> it = this.startPanelStateListeners.iterator();
        while (it.hasNext()) {
            it.next().onPanelStateChange(this.startPanelState);
        }
        this.endPanelState = getEndPanelState(previousX, x2);
        Iterator<OverlappingPanelsLayout$PanelStateListener> it2 = this.endPanelStateListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onPanelStateChange(this.endPanelState);
        }
    }

    private final void handleEndPanelWidthUpdate() {
        float f = this.endPanelOpenedCenterPanelX;
        float dimension = getResources().getDimension(R$a.overlapping_panels_margin_between_panels);
        View view = this.endPanel;
        if (view == null) {
            m.throwUninitializedPropertyAccessException("endPanel");
        }
        float f2 = -(view.getWidth() + dimension);
        this.endPanelOpenedCenterPanelX = f2;
        if (!this.isLeftToRight) {
            f2 = -f2;
        }
        this.endPanelOpenedCenterPanelX = f2;
        View view2 = this.centerPanel;
        if (view2 == null) {
            m.throwUninitializedPropertyAccessException("centerPanel");
        }
        if (view2.getX() == f || this.centerPanelAnimationEndX == f) {
            openEndPanel();
        }
    }

    private final void handleStartPanelWidthUpdate() {
        float f = this.startPanelOpenedCenterPanelX;
        float dimension = getResources().getDimension(R$a.overlapping_panels_margin_between_panels);
        View view = this.startPanel;
        if (view == null) {
            m.throwUninitializedPropertyAccessException("startPanel");
        }
        float width = view.getWidth() + dimension;
        this.startPanelOpenedCenterPanelX = width;
        if (!this.isLeftToRight) {
            width = -width;
        }
        this.startPanelOpenedCenterPanelX = width;
        View view2 = this.centerPanel;
        if (view2 == null) {
            m.throwUninitializedPropertyAccessException("centerPanel");
        }
        if (view2.getX() == f || this.centerPanelAnimationEndX == f) {
            openStartPanel();
        }
    }

    private final void initPanels() {
        View childAt = getChildAt(0);
        m.checkExpressionValueIsNotNull(childAt, "getChildAt(0)");
        this.startPanel = childAt;
        View childAt2 = getChildAt(1);
        m.checkExpressionValueIsNotNull(childAt2, "getChildAt(1)");
        this.centerPanel = childAt2;
        View childAt3 = getChildAt(2);
        m.checkExpressionValueIsNotNull(childAt3, "getChildAt(2)");
        this.endPanel = childAt3;
        View view = this.startPanel;
        if (view == null) {
            m.throwUninitializedPropertyAccessException("startPanel");
        }
        view.setVisibility(4);
        View view2 = this.startPanel;
        if (view2 == null) {
            m.throwUninitializedPropertyAccessException("startPanel");
        }
        view2.setElevation(0.0f);
        View view3 = this.centerPanel;
        if (view3 == null) {
            m.throwUninitializedPropertyAccessException("centerPanel");
        }
        view3.setVisibility(0);
        View view4 = this.centerPanel;
        if (view4 == null) {
            m.throwUninitializedPropertyAccessException("centerPanel");
        }
        view4.setElevation(0.0f);
        View view5 = this.endPanel;
        if (view5 == null) {
            m.throwUninitializedPropertyAccessException("endPanel");
        }
        view5.setVisibility(4);
        View view6 = this.endPanel;
        if (view6 == null) {
            m.throwUninitializedPropertyAccessException("endPanel");
        }
        view6.setElevation(0.0f);
        resetStartPanelWidth();
        resetEndPanelWidth();
        handleStartPanelWidthUpdate();
        handleEndPanelWidthUpdate();
        Function0<Unit> function0 = this.pendingUpdate;
        if (function0 != null) {
            function0.invoke();
        }
        this.pendingUpdate = null;
        View view7 = this.startPanel;
        if (view7 == null) {
            m.throwUninitializedPropertyAccessException("startPanel");
        }
        view7.addOnLayoutChangeListener(new OverlappingPanelsLayout$b(0, this));
        View view8 = this.endPanel;
        if (view8 == null) {
            m.throwUninitializedPropertyAccessException("endPanel");
        }
        view8.addOnLayoutChangeListener(new OverlappingPanelsLayout$b(1, this));
    }

    private final void initialize(AttributeSet attrs) {
        int i;
        a aVar = a.f251b;
        Context context = getContext();
        m.checkExpressionValueIsNotNull(context, "context");
        m.checkParameterIsNotNull(context, "context");
        this.isLeftToRight = TextUtils.getLayoutDirectionFromLocale(a.a.invoke(context)) == 0;
        this.scrollingSlopPx = getResources().getDimension(R$a.overlapping_panels_scroll_slop);
        this.homeGestureFromBottomThreshold = getResources().getDimension(R$a.overlapping_panels_home_gesture_from_bottom_threshold);
        this.minFlingPxPerSecond = getResources().getDimension(R$a.overlapping_panels_min_fling_dp_per_second);
        Resources resources = getResources();
        m.checkExpressionValueIsNotNull(resources, "resources");
        if (resources.getConfiguration().orientation == 1) {
            Resources resources2 = getResources();
            m.checkExpressionValueIsNotNull(resources2, "resources");
            i = resources2.getDisplayMetrics().widthPixels;
        } else {
            Resources resources3 = getResources();
            m.checkExpressionValueIsNotNull(resources3, "resources");
            i = resources3.getDisplayMetrics().heightPixels;
        }
        this.nonFullScreenSidePanelWidth = (int) ((i - getResources().getDimension(R$a.overlapping_panels_margin_between_panels)) - getResources().getDimension(R$a.overlapping_panels_closed_center_panel_visible_width));
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R$b.OverlappingPanelsLayout, 0, 0);
        try {
            this.nonFullScreenSidePanelWidth = Math.min(this.nonFullScreenSidePanelWidth, (int) typedArrayObtainStyledAttributes.getDimension(R$b.OverlappingPanelsLayout_maxSidePanelNonFullScreenWidth, Integer.MAX_VALUE));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private final boolean isTouchingCenterPanelWhileSidePanelOpen(MotionEvent event) {
        float x2 = event.getX();
        View view = this.centerPanel;
        if (view == null) {
            m.throwUninitializedPropertyAccessException("centerPanel");
        }
        float x3 = view.getX();
        float fMax = Math.max(this.startPanelOpenedCenterPanelX, this.endPanelOpenedCenterPanelX);
        float fMin = Math.min(this.startPanelOpenedCenterPanelX, this.endPanelOpenedCenterPanelX);
        View view2 = this.centerPanel;
        if (view2 == null) {
            m.throwUninitializedPropertyAccessException("centerPanel");
        }
        float width = view2.getWidth() + fMin;
        boolean z2 = x2 > fMax;
        boolean z3 = x2 < width;
        boolean z4 = x3 == fMax;
        boolean z5 = x3 == fMin;
        if (z4 && z2) {
            return true;
        }
        return z5 && z3;
    }

    private final boolean isTouchingChildGestureRegion(MotionEvent event) {
        boolean z2;
        float rawX = event.getRawX();
        float rawY = event.getRawY();
        Iterator<T> it = this.childGestureRegions.iterator();
        do {
            z2 = false;
            if (!it.hasNext()) {
                return false;
            }
            Rect rect = (Rect) it.next();
            boolean z3 = rawX >= ((float) rect.left) && rawX <= ((float) rect.right);
            boolean z4 = rawY <= ((float) rect.bottom) && rawY >= ((float) rect.top);
            if (z3 && z4) {
                z2 = true;
            }
        } while (!z2);
        return true;
    }

    public static /* synthetic */ void openEndPanel$default(OverlappingPanelsLayout overlappingPanelsLayout, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openEndPanel");
        }
        if ((i & 1) != 0) {
            z2 = false;
        }
        overlappingPanelsLayout.openEndPanel(z2);
    }

    private final void openPanel(OverlappingPanelsLayout$Panel panel) {
        int iOrdinal = panel.ordinal();
        if (iOrdinal == 0) {
            openStartPanel(false);
        } else if (iOrdinal == 1) {
            closePanels(false);
        } else {
            if (iOrdinal != 2) {
                return;
            }
            openEndPanel(false);
        }
    }

    public static /* synthetic */ void openStartPanel$default(OverlappingPanelsLayout overlappingPanelsLayout, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openStartPanel");
        }
        if ((i & 1) != 0) {
            z2 = false;
        }
        overlappingPanelsLayout.openStartPanel(z2);
    }

    private final void resetEndPanelWidth() {
        View view = this.endPanel;
        if (view == null) {
            m.throwUninitializedPropertyAccessException("endPanel");
        }
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = this.nonFullScreenSidePanelWidth;
        View view2 = this.endPanel;
        if (view2 == null) {
            m.throwUninitializedPropertyAccessException("endPanel");
        }
        view2.setLayoutParams(layoutParams);
    }

    private final void resetStartPanelWidth() {
        View view = this.startPanel;
        if (view != null) {
            if (view == null) {
                m.throwUninitializedPropertyAccessException("startPanel");
            }
            ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = this.useFullWidthForStartPanel ? -1 : this.nonFullScreenSidePanelWidth;
            View view2 = this.startPanel;
            if (view2 == null) {
                m.throwUninitializedPropertyAccessException("startPanel");
            }
            view2.setLayoutParams(layoutParams);
        }
    }

    private final boolean shouldHandleActionMoveEvent(MotionEvent event) {
        float normalizedX = getNormalizedX(getTargetedX(event));
        View view = this.centerPanel;
        if (view == null) {
            m.throwUninitializedPropertyAccessException("centerPanel");
        }
        float fAbs = Math.abs(normalizedX - view.getX());
        Resources resources = getResources();
        m.checkExpressionValueIsNotNull(resources, "resources");
        return normalizedX == 0.0f || normalizedX == this.startPanelOpenedCenterPanelX || normalizedX == this.endPanelOpenedCenterPanelX || ((fAbs > resources.getDisplayMetrics().density ? 1 : (fAbs == resources.getDisplayMetrics().density ? 0 : -1)) > 0);
    }

    private final void snapOpenOrClose(MotionEvent event) {
        float targetedX = getTargetedX(event);
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.computeCurrentVelocity(1000);
        }
        VelocityTracker velocityTracker2 = this.velocityTracker;
        float xVelocity = velocityTracker2 != null ? velocityTracker2.getXVelocity() : h.a.getMIN_VALUE();
        boolean z2 = false;
        boolean z3 = Math.abs(xVelocity) > this.minFlingPxPerSecond;
        if (!this.isLeftToRight ? xVelocity < 0 : xVelocity > 0) {
            z2 = true;
        }
        if (z3) {
            if (z2) {
                OverlappingPanelsLayout$Panel overlappingPanelsLayout$Panel = this.selectedPanel;
                if (overlappingPanelsLayout$Panel == OverlappingPanelsLayout$Panel.END) {
                    closePanels(true);
                    return;
                } else if (overlappingPanelsLayout$Panel == OverlappingPanelsLayout$Panel.CENTER) {
                    openStartPanel(true);
                    return;
                }
            } else {
                OverlappingPanelsLayout$Panel overlappingPanelsLayout$Panel2 = this.selectedPanel;
                if (overlappingPanelsLayout$Panel2 == OverlappingPanelsLayout$Panel.START) {
                    closePanels(true);
                    return;
                } else if (overlappingPanelsLayout$Panel2 == OverlappingPanelsLayout$Panel.CENTER) {
                    openEndPanel(true);
                    return;
                }
            }
        }
        float fMax = Math.max(this.startPanelOpenedCenterPanelX, this.endPanelOpenedCenterPanelX);
        float fMin = Math.min(this.startPanelOpenedCenterPanelX, this.endPanelOpenedCenterPanelX);
        float f = 2;
        if (targetedX > fMax / f) {
            openPanel(getLeftPanel());
        } else if (targetedX < fMin / f) {
            openPanel(getRightPanel());
        } else {
            closePanels();
        }
    }

    private final void translateCenterPanel(MotionEvent event) {
        updateCenterPanelX(getNormalizedX(getTargetedX(event)));
    }

    private final void updateCenterPanelX(float x2) {
        View view = this.centerPanel;
        if (view == null) {
            m.throwUninitializedPropertyAccessException("centerPanel");
        }
        float x3 = view.getX();
        View view2 = this.centerPanel;
        if (view2 == null) {
            m.throwUninitializedPropertyAccessException("centerPanel");
        }
        view2.setX(x2);
        handleCenterPanelX(x3, x2);
    }

    private final void updateCenterPanelXWithAnimation(float x2, boolean isFling, long animationDurationMs) {
        View view = this.centerPanel;
        if (view == null) {
            m.throwUninitializedPropertyAccessException("centerPanel");
        }
        float x3 = view.getX();
        ValueAnimator valueAnimator = this.centerPanelXAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        float normalizedX = getNormalizedX(x2);
        this.centerPanelAnimationEndX = normalizedX;
        if (isFling) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(x3, normalizedX);
            valueAnimatorOfFloat.setInterpolator(new LinearOutSlowInInterpolator());
            valueAnimatorOfFloat.setDuration(animationDurationMs);
            this.centerPanelXAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new OverlappingPanelsLayout$a(0, this));
        } else {
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(x3, normalizedX);
            valueAnimatorOfFloat2.setInterpolator(new FastOutSlowInInterpolator());
            valueAnimatorOfFloat2.setDuration(animationDurationMs);
            this.centerPanelXAnimator = valueAnimatorOfFloat2;
            valueAnimatorOfFloat2.addUpdateListener(new OverlappingPanelsLayout$a(1, this));
        }
        ValueAnimator valueAnimator2 = this.centerPanelXAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.start();
        }
    }

    public static /* synthetic */ void updateCenterPanelXWithAnimation$default(OverlappingPanelsLayout overlappingPanelsLayout, float f, boolean z2, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCenterPanelXWithAnimation");
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            j = SIDE_PANEL_OPEN_DURATION_MS;
        }
        overlappingPanelsLayout.updateCenterPanelXWithAnimation(f, z2, j);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this._$_findViewCache;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void closePanels() {
        closePanels(false);
    }

    public final OverlappingPanelsLayout$Panel getSelectedPanel() {
        return this.selectedPanel;
    }

    public final void handleEndPanelState(PanelState endPanelState) {
        m.checkParameterIsNotNull(endPanelState, "endPanelState");
        PanelState panelState = this.endPanelState;
        PanelState$c panelState$c = PanelState$c.a;
        if (m.areEqual(endPanelState, panelState$c) && (!m.areEqual(panelState, panelState$c))) {
            openEndPanel();
        } else if ((endPanelState instanceof PanelState$a) && m.areEqual(panelState, panelState$c)) {
            closePanels();
        }
        this.endPanelState = endPanelState;
    }

    public final void handleStartPanelState(PanelState startPanelState) {
        m.checkParameterIsNotNull(startPanelState, "startPanelState");
        PanelState panelState = this.startPanelState;
        PanelState$c panelState$c = PanelState$c.a;
        if (m.areEqual(startPanelState, panelState$c) && (!m.areEqual(panelState, panelState$c))) {
            openStartPanel();
        } else if (m.areEqual(startPanelState, PanelState$a.a) && m.areEqual(panelState, panelState$c)) {
            closePanels();
        }
        this.startPanelState = startPanelState;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004f  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        VelocityTracker velocityTracker;
        m.checkParameterIsNotNull(event, "event");
        int actionMasked = event.getActionMasked();
        boolean z2 = false;
        if (actionMasked == 0) {
            this.isScrollingHorizontally = false;
            this.wasActionDownOnClosedCenterPanel = isTouchingCenterPanelWhileSidePanelOpen(event);
            View view = this.centerPanel;
            if (view == null) {
                m.throwUninitializedPropertyAccessException("centerPanel");
            }
            this.centerPanelDiffX = view.getX() - event.getRawX();
            this.xFromInterceptActionDown = event.getX();
            float y2 = event.getY();
            this.yFromInterceptActionDown = y2;
            Resources resources = getResources();
            m.checkExpressionValueIsNotNull(resources, "resources");
            if (Math.abs(y2 - resources.getDisplayMetrics().heightPixels) < this.homeGestureFromBottomThreshold && this.isSystemGestureNavigationPossible) {
                z2 = true;
            }
            this.isHomeSystemGesture = z2;
            VelocityTracker velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 == null) {
                VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
                this.velocityTracker = velocityTrackerObtain;
                if (velocityTrackerObtain != null) {
                    velocityTrackerObtain.addMovement(event);
                }
            } else if (velocityTracker2 != null) {
                velocityTracker2.clear();
            }
            return this.wasActionDownOnClosedCenterPanel;
        }
        if (actionMasked == 1) {
            velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            this.velocityTracker = null;
            if (this.isScrollingHorizontally && !this.wasActionDownOnClosedCenterPanel) {
                return false;
            }
        } else if (actionMasked != 2) {
            if (actionMasked != 3) {
                return this.wasActionDownOnClosedCenterPanel;
            }
            velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            this.velocityTracker = null;
            if (this.isScrollingHorizontally) {
            }
        } else if (!this.isScrollingHorizontally) {
            float fCalculateDistanceX = calculateDistanceX(this.xFromInterceptActionDown, event);
            float fCalculateDistanceY = calculateDistanceY(this.yFromInterceptActionDown, event);
            boolean zIsTouchingChildGestureRegion = isTouchingChildGestureRegion(event);
            if (Math.abs(fCalculateDistanceX) <= this.scrollingSlopPx || Math.abs(fCalculateDistanceX) <= Math.abs(fCalculateDistanceY) || zIsTouchingChildGestureRegion) {
                return false;
            }
            this.isScrollingHorizontally = true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (getChildCount() == 3 && this.centerPanel == null) {
            initPanels();
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0072  */
    /* JADX WARN: Code duplicated, block: B:41:0x0076  */
    /* JADX WARN: Code duplicated, block: B:43:0x007a  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        boolean z2;
        VelocityTracker velocityTracker;
        m.checkParameterIsNotNull(event, "event");
        if (this.isHomeSystemGesture) {
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                if (this.wasActionDownOnClosedCenterPanel || Math.abs(event.getX() - this.xFromInterceptActionDown) >= this.scrollingSlopPx || this.isScrollingHorizontally) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    closePanels();
                } else {
                    velocityTracker = this.velocityTracker;
                    if (velocityTracker != null) {
                        velocityTracker.addMovement(event);
                    }
                    snapOpenOrClose(event);
                }
                this.wasActionDownOnClosedCenterPanel = false;
                this.isScrollingHorizontally = false;
                this.swipeDirection = null;
            } else if (actionMasked != 2) {
                if (actionMasked != 3) {
                    return false;
                }
                if (this.wasActionDownOnClosedCenterPanel) {
                    z2 = false;
                } else {
                    z2 = false;
                }
                if (z2) {
                    closePanels();
                } else {
                    velocityTracker = this.velocityTracker;
                    if (velocityTracker != null) {
                        velocityTracker.addMovement(event);
                    }
                    snapOpenOrClose(event);
                }
                this.wasActionDownOnClosedCenterPanel = false;
                this.isScrollingHorizontally = false;
                this.swipeDirection = null;
            } else {
                if (isTouchingChildGestureRegion(event)) {
                    return false;
                }
                float fCalculateDistanceX = calculateDistanceX(this.xFromInterceptActionDown, event);
                if (Math.abs(fCalculateDistanceX) > this.scrollingSlopPx && this.swipeDirection == null) {
                    this.swipeDirection = fCalculateDistanceX > ((float) 0) ? OverlappingPanelsLayout$SwipeDirection.RIGHT : OverlappingPanelsLayout$SwipeDirection.LEFT;
                }
                VelocityTracker velocityTracker2 = this.velocityTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(event);
                }
                if (shouldHandleActionMoveEvent(event)) {
                    translateCenterPanel(event);
                }
            }
        }
        return true;
    }

    public final void openEndPanel() {
        openEndPanel(false);
    }

    public final void openStartPanel() {
        openStartPanel(false);
    }

    public final void registerEndPanelStateListeners(OverlappingPanelsLayout$PanelStateListener... panelStateListenerArgs) {
        m.checkParameterIsNotNull(panelStateListenerArgs, "panelStateListenerArgs");
        for (OverlappingPanelsLayout$PanelStateListener overlappingPanelsLayout$PanelStateListener : panelStateListenerArgs) {
            this.endPanelStateListeners.add(overlappingPanelsLayout$PanelStateListener);
        }
    }

    public final void registerStartPanelStateListeners(OverlappingPanelsLayout$PanelStateListener... panelStateListenerArgs) {
        m.checkParameterIsNotNull(panelStateListenerArgs, "panelStateListenerArgs");
        for (OverlappingPanelsLayout$PanelStateListener overlappingPanelsLayout$PanelStateListener : panelStateListenerArgs) {
            this.startPanelStateListeners.add(overlappingPanelsLayout$PanelStateListener);
        }
    }

    public final void setChildGestureRegions(List<Rect> childGestureRegions) {
        m.checkParameterIsNotNull(childGestureRegions, "childGestureRegions");
        this.childGestureRegions = childGestureRegions;
    }

    public final void setEndPanelLockState(OverlappingPanelsLayout$LockState lockState) {
        m.checkParameterIsNotNull(lockState, "lockState");
        this.endPanelLockState = lockState;
        if (lockState == OverlappingPanelsLayout$LockState.OPEN) {
            openEndPanel();
        }
    }

    public final void setStartPanelLockState(OverlappingPanelsLayout$LockState lockState) {
        m.checkParameterIsNotNull(lockState, "lockState");
        this.startPanelLockState = lockState;
        if (lockState == OverlappingPanelsLayout$LockState.OPEN) {
            openStartPanel();
        }
    }

    public final void setStartPanelUseFullPortraitWidth(boolean useFullPortraitWidth) {
        this.useFullWidthForStartPanel = useFullPortraitWidth;
        resetStartPanelWidth();
    }

    private final void closePanels(boolean isFling) {
        if (this.centerPanel == null) {
            this.pendingUpdate = new OverlappingPanelsLayout$c(this, isFling);
        } else {
            updateCenterPanelXWithAnimation(0.0f, isFling, SIDE_PANEL_CLOSE_DURATION_MS);
        }
    }

    private final void openEndPanel(boolean isFling) {
        if (this.centerPanel == null) {
            this.pendingUpdate = new OverlappingPanelsLayout$d(this, isFling);
        } else {
            updateCenterPanelXWithAnimation(this.endPanelOpenedCenterPanelX, isFling, SIDE_PANEL_OPEN_DURATION_MS);
        }
    }

    private final void openStartPanel(boolean isFling) {
        if (this.centerPanel == null) {
            this.pendingUpdate = new OverlappingPanelsLayout$e(this, isFling);
        } else if (this.startPanelLockState == OverlappingPanelsLayout$LockState.OPEN) {
            updateCenterPanelX(this.startPanelOpenedCenterPanelX);
        } else {
            updateCenterPanelXWithAnimation(this.startPanelOpenedCenterPanelX, isFling, SIDE_PANEL_OPEN_DURATION_MS);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlappingPanelsLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkParameterIsNotNull(context, "context");
        this.isLeftToRight = true;
        h hVar = h.a;
        this.startPanelOpenedCenterPanelX = hVar.getMIN_VALUE();
        this.endPanelOpenedCenterPanelX = hVar.getMAX_VALUE();
        this.startPanelStateListeners = new ArrayList<>();
        this.endPanelStateListeners = new ArrayList<>();
        this.selectedPanel = OverlappingPanelsLayout$Panel.CENTER;
        OverlappingPanelsLayout$LockState overlappingPanelsLayout$LockState = OverlappingPanelsLayout$LockState.UNLOCKED;
        this.startPanelLockState = overlappingPanelsLayout$LockState;
        this.endPanelLockState = overlappingPanelsLayout$LockState;
        PanelState$a panelState$a = PanelState$a.a;
        this.startPanelState = panelState$a;
        this.endPanelState = panelState$a;
        this.childGestureRegions = n.emptyList();
        this.isSystemGestureNavigationPossible = Build$VERSION.SDK_INT >= 29;
        initialize(attributeSet);
    }

    public /* synthetic */ OverlappingPanelsLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlappingPanelsLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkParameterIsNotNull(context, "context");
        this.isLeftToRight = true;
        h hVar = h.a;
        this.startPanelOpenedCenterPanelX = hVar.getMIN_VALUE();
        this.endPanelOpenedCenterPanelX = hVar.getMAX_VALUE();
        this.startPanelStateListeners = new ArrayList<>();
        this.endPanelStateListeners = new ArrayList<>();
        this.selectedPanel = OverlappingPanelsLayout$Panel.CENTER;
        OverlappingPanelsLayout$LockState overlappingPanelsLayout$LockState = OverlappingPanelsLayout$LockState.UNLOCKED;
        this.startPanelLockState = overlappingPanelsLayout$LockState;
        this.endPanelLockState = overlappingPanelsLayout$LockState;
        PanelState$a panelState$a = PanelState$a.a;
        this.startPanelState = panelState$a;
        this.endPanelState = panelState$a;
        this.childGestureRegions = n.emptyList();
        this.isSystemGestureNavigationPossible = Build$VERSION.SDK_INT >= 29;
        initialize(attributeSet);
    }

    public /* synthetic */ OverlappingPanelsLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}

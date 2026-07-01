package com.discord.panels;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import b.a.o.LocaleProvider;
import com.discord.panels.PanelState;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PrimitiveCompanionObjects2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: OverlappingPanelsLayout.kt */
/* JADX INFO: loaded from: classes.dex */
public class OverlappingPanelsLayout extends FrameLayout {
    private static final long SIDE_PANEL_CLOSE_DURATION_MS = 200;
    private static final long SIDE_PANEL_OPEN_DURATION_MS = 250;
    private HashMap _$_findViewCache;
    private View centerPanel;
    private float centerPanelAnimationEndX;
    private float centerPanelDiffX;
    private ValueAnimator centerPanelXAnimator;
    private List<Rect> childGestureRegions;
    private View endPanel;
    private LockState endPanelLockState;
    private float endPanelOpenedCenterPanelX;
    private PanelState endPanelState;
    private final ArrayList<PanelStateListener> endPanelStateListeners;
    private float homeGestureFromBottomThreshold;
    private boolean isHomeSystemGesture;
    private boolean isLeftToRight;
    private boolean isScrollingHorizontally;
    private final boolean isSystemGestureNavigationPossible;
    private float minFlingPxPerSecond;
    private int nonFullScreenSidePanelWidth;
    private Function0<Unit> pendingUpdate;
    private float scrollingSlopPx;
    private Panel selectedPanel;
    private View startPanel;
    private LockState startPanelLockState;
    private float startPanelOpenedCenterPanelX;
    private PanelState startPanelState;
    private final ArrayList<PanelStateListener> startPanelStateListeners;
    private SwipeDirection swipeDirection;
    private boolean useFullWidthForStartPanel;
    private VelocityTracker velocityTracker;
    private boolean wasActionDownOnClosedCenterPanel;
    private float xFromInterceptActionDown;
    private float yFromInterceptActionDown;

    /* JADX INFO: compiled from: OverlappingPanelsLayout.kt */
    public enum LockState {
        OPEN,
        CLOSE,
        UNLOCKED
    }

    /* JADX INFO: compiled from: OverlappingPanelsLayout.kt */
    public enum Panel {
        START,
        CENTER,
        END
    }

    /* JADX INFO: compiled from: OverlappingPanelsLayout.kt */
    public interface PanelStateListener {
        void onPanelStateChange(PanelState panelState);
    }

    /* JADX INFO: compiled from: OverlappingPanelsLayout.kt */
    public enum SwipeDirection {
        LEFT,
        RIGHT
    }

    /* JADX INFO: compiled from: java-style lambda group */
    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f2757b;

        public a(int i, Object obj) {
            this.a = i;
            this.f2757b = obj;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int i = this.a;
            if (i == 0) {
                OverlappingPanelsLayout overlappingPanelsLayout = (OverlappingPanelsLayout) this.f2757b;
                Intrinsics3.checkExpressionValueIsNotNull(valueAnimator, "animator");
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
                }
                overlappingPanelsLayout.updateCenterPanelX(((Float) animatedValue).floatValue());
                return;
            }
            if (i != 1) {
                throw null;
            }
            OverlappingPanelsLayout overlappingPanelsLayout2 = (OverlappingPanelsLayout) this.f2757b;
            Intrinsics3.checkExpressionValueIsNotNull(valueAnimator, "animator");
            Object animatedValue2 = valueAnimator.getAnimatedValue();
            if (animatedValue2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
            }
            overlappingPanelsLayout2.updateCenterPanelX(((Float) animatedValue2).floatValue());
        }
    }

    /* JADX INFO: compiled from: java-style lambda group */
    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public b(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9 = this.j;
            if (i9 == 0) {
                if (((OverlappingPanelsLayout) this.k).isLeftToRight && i3 != i7) {
                    ((OverlappingPanelsLayout) this.k).handleStartPanelWidthUpdate();
                    return;
                } else {
                    if (((OverlappingPanelsLayout) this.k).isLeftToRight || i == i5) {
                        return;
                    }
                    ((OverlappingPanelsLayout) this.k).handleStartPanelWidthUpdate();
                    return;
                }
            }
            if (i9 != 1) {
                throw null;
            }
            if (((OverlappingPanelsLayout) this.k).isLeftToRight && i != i5) {
                ((OverlappingPanelsLayout) this.k).handleEndPanelWidthUpdate();
            } else {
                if (((OverlappingPanelsLayout) this.k).isLeftToRight || i3 == i7) {
                    return;
                }
                ((OverlappingPanelsLayout) this.k).handleEndPanelWidthUpdate();
            }
        }
    }

    /* JADX INFO: compiled from: OverlappingPanelsLayout.kt */
    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $isFling;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(boolean z2) {
            super(0);
            this.$isFling = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            OverlappingPanelsLayout.this.closePanels(this.$isFling);
            return Unit.a;
        }
    }

    /* JADX INFO: compiled from: OverlappingPanelsLayout.kt */
    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $isFling;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(boolean z2) {
            super(0);
            this.$isFling = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            OverlappingPanelsLayout.this.openEndPanel(this.$isFling);
            return Unit.a;
        }
    }

    /* JADX INFO: compiled from: OverlappingPanelsLayout.kt */
    public static final class e extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $isFling;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(boolean z2) {
            super(0);
            this.$isFling = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            OverlappingPanelsLayout.this.openStartPanel(this.$isFling);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlappingPanelsLayout(Context context) {
        super(context);
        Intrinsics3.checkParameterIsNotNull(context, "context");
        this.isLeftToRight = true;
        PrimitiveCompanionObjects2 primitiveCompanionObjects2 = PrimitiveCompanionObjects2.a;
        this.startPanelOpenedCenterPanelX = primitiveCompanionObjects2.getMIN_VALUE();
        this.endPanelOpenedCenterPanelX = primitiveCompanionObjects2.getMAX_VALUE();
        this.startPanelStateListeners = new ArrayList<>();
        this.endPanelStateListeners = new ArrayList<>();
        this.selectedPanel = Panel.CENTER;
        LockState lockState = LockState.UNLOCKED;
        this.startPanelLockState = lockState;
        this.endPanelLockState = lockState;
        PanelState.a aVar = PanelState.a.a;
        this.startPanelState = aVar;
        this.endPanelState = aVar;
        this.childGestureRegions = Collections2.emptyList();
        this.isSystemGestureNavigationPossible = Build.VERSION.SDK_INT >= 29;
    }

    public static final /* synthetic */ View access$getCenterPanel$p(OverlappingPanelsLayout overlappingPanelsLayout) {
        View view = overlappingPanelsLayout.centerPanel;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        return view;
    }

    public static final /* synthetic */ View access$getStartPanel$p(OverlappingPanelsLayout overlappingPanelsLayout) {
        View view = overlappingPanelsLayout.startPanel;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("startPanel");
        }
        return view;
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
            return PanelState.a.a;
        }
        if (!z2 && x2 <= 0.0f) {
            return PanelState.a.a;
        }
        if (x2 == this.endPanelOpenedCenterPanelX) {
            return PanelState.c.a;
        }
        if (!z2 || x2 >= previousX) {
            return (z2 || x2 <= previousX) ? PanelState.b.a : PanelState.d.a;
        }
        return PanelState.d.a;
    }

    private final Panel getLeftPanel() {
        return this.isLeftToRight ? Panel.START : Panel.END;
    }

    private final LockState getLeftPanelLockState() {
        return this.isLeftToRight ? this.startPanelLockState : this.endPanelLockState;
    }

    private final float getNormalizedX(float targetedX) {
        LockState lockState = this.startPanelLockState;
        LockState lockState2 = LockState.OPEN;
        if (lockState == lockState2) {
            return this.startPanelOpenedCenterPanelX;
        }
        if (this.endPanelLockState == lockState2) {
            return this.endPanelOpenedCenterPanelX;
        }
        LockState leftPanelLockState = getLeftPanelLockState();
        LockState lockState3 = LockState.CLOSE;
        float fMin = 0.0f;
        float fMax = (leftPanelLockState == lockState3 || (this.selectedPanel == Panel.CENTER && this.swipeDirection == SwipeDirection.LEFT)) ? 0.0f : Math.max(this.startPanelOpenedCenterPanelX, this.endPanelOpenedCenterPanelX);
        if (getRightPanelLockState() != lockState3 && (this.selectedPanel != Panel.CENTER || this.swipeDirection != SwipeDirection.RIGHT)) {
            fMin = Math.min(this.startPanelOpenedCenterPanelX, this.endPanelOpenedCenterPanelX);
        }
        if (targetedX > fMax) {
            return fMax;
        }
        return targetedX < fMin ? fMin : targetedX;
    }

    private final Panel getRightPanel() {
        return this.isLeftToRight ? Panel.END : Panel.START;
    }

    private final LockState getRightPanelLockState() {
        return this.isLeftToRight ? this.endPanelLockState : this.startPanelLockState;
    }

    private final PanelState getStartPanelState(float previousX, float x2) {
        boolean z2 = this.isLeftToRight;
        if (z2 && x2 <= 0.0f) {
            return PanelState.a.a;
        }
        if (!z2 && x2 >= 0.0f) {
            return PanelState.a.a;
        }
        if (x2 == this.startPanelOpenedCenterPanelX) {
            return PanelState.c.a;
        }
        if (!z2 || x2 <= previousX) {
            return (z2 || x2 >= previousX) ? PanelState.b.a : PanelState.d.a;
        }
        return PanelState.d.a;
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
            Intrinsics3.throwUninitializedPropertyAccessException("startPanel");
        }
        if (this.isLeftToRight) {
            View view4 = this.centerPanel;
            if (view4 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
            }
            if (view4.getX() <= 0) {
                if (!this.isLeftToRight) {
                    view = this.centerPanel;
                    if (view == null) {
                        Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
                    }
                    if (view.getX() < ((float) 0)) {
                    }
                }
            }
        } else {
            if (!this.isLeftToRight) {
                view = this.centerPanel;
                if (view == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
                }
                i = view.getX() < ((float) 0) ? 0 : 4;
            }
        }
        view3.setVisibility(i);
        View view5 = this.endPanel;
        if (view5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("endPanel");
        }
        if (this.isLeftToRight) {
            View view6 = this.centerPanel;
            if (view6 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
            }
            if (view6.getX() >= 0) {
                if (!this.isLeftToRight) {
                    view2 = this.centerPanel;
                    if (view2 == null) {
                        Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
                    }
                    if (view2.getX() > ((float) 0)) {
                    }
                }
            }
        } else {
            if (!this.isLeftToRight) {
                view2 = this.centerPanel;
                if (view2 == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
                }
                i2 = view2.getX() > ((float) 0) ? 0 : 4;
            }
        }
        view5.setVisibility(i2);
        if (x2 == 0.0f) {
            this.selectedPanel = Panel.CENTER;
        } else if (x2 == this.startPanelOpenedCenterPanelX) {
            this.selectedPanel = Panel.START;
        } else if (x2 == this.endPanelOpenedCenterPanelX) {
            this.selectedPanel = Panel.END;
        }
        boolean z2 = x2 == this.endPanelOpenedCenterPanelX || x2 == this.startPanelOpenedCenterPanelX;
        View view7 = this.centerPanel;
        if (view7 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        boolean z3 = !z2;
        Intrinsics3.checkParameterIsNotNull(view7, "$this$setEnabledAlpha");
        view7.setAlpha(z3 ? 1.0f : 0.5f);
        View view8 = this.centerPanel;
        if (view8 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        view8.setImportantForAccessibility(z2 ? 4 : 0);
        boolean z4 = x2 == 0.0f || z2;
        View view9 = this.centerPanel;
        if (view9 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        view9.setElevation(z4 ? 0.0f : getResources().getDimension(R.a.overlapping_panels_center_panel_non_resting_elevation));
        this.startPanelState = getStartPanelState(previousX, x2);
        Iterator<PanelStateListener> it = this.startPanelStateListeners.iterator();
        while (it.hasNext()) {
            it.next().onPanelStateChange(this.startPanelState);
        }
        this.endPanelState = getEndPanelState(previousX, x2);
        Iterator<PanelStateListener> it2 = this.endPanelStateListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onPanelStateChange(this.endPanelState);
        }
    }

    private final void handleEndPanelWidthUpdate() {
        float f = this.endPanelOpenedCenterPanelX;
        float dimension = getResources().getDimension(R.a.overlapping_panels_margin_between_panels);
        View view = this.endPanel;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("endPanel");
        }
        float f2 = -(view.getWidth() + dimension);
        this.endPanelOpenedCenterPanelX = f2;
        if (!this.isLeftToRight) {
            f2 = -f2;
        }
        this.endPanelOpenedCenterPanelX = f2;
        View view2 = this.centerPanel;
        if (view2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        if (view2.getX() == f || this.centerPanelAnimationEndX == f) {
            openEndPanel();
        }
    }

    private final void handleStartPanelWidthUpdate() {
        float f = this.startPanelOpenedCenterPanelX;
        float dimension = getResources().getDimension(R.a.overlapping_panels_margin_between_panels);
        View view = this.startPanel;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("startPanel");
        }
        float width = view.getWidth() + dimension;
        this.startPanelOpenedCenterPanelX = width;
        if (!this.isLeftToRight) {
            width = -width;
        }
        this.startPanelOpenedCenterPanelX = width;
        View view2 = this.centerPanel;
        if (view2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        if (view2.getX() == f || this.centerPanelAnimationEndX == f) {
            openStartPanel();
        }
    }

    private final void initPanels() {
        View childAt = getChildAt(0);
        Intrinsics3.checkExpressionValueIsNotNull(childAt, "getChildAt(0)");
        this.startPanel = childAt;
        View childAt2 = getChildAt(1);
        Intrinsics3.checkExpressionValueIsNotNull(childAt2, "getChildAt(1)");
        this.centerPanel = childAt2;
        View childAt3 = getChildAt(2);
        Intrinsics3.checkExpressionValueIsNotNull(childAt3, "getChildAt(2)");
        this.endPanel = childAt3;
        View view = this.startPanel;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("startPanel");
        }
        view.setVisibility(4);
        View view2 = this.startPanel;
        if (view2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("startPanel");
        }
        view2.setElevation(0.0f);
        View view3 = this.centerPanel;
        if (view3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        view3.setVisibility(0);
        View view4 = this.centerPanel;
        if (view4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        view4.setElevation(0.0f);
        View view5 = this.endPanel;
        if (view5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("endPanel");
        }
        view5.setVisibility(4);
        View view6 = this.endPanel;
        if (view6 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("endPanel");
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
            Intrinsics3.throwUninitializedPropertyAccessException("startPanel");
        }
        view7.addOnLayoutChangeListener(new b(0, this));
        View view8 = this.endPanel;
        if (view8 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("endPanel");
        }
        view8.addOnLayoutChangeListener(new b(1, this));
    }

    private final void initialize(AttributeSet attrs) {
        int i;
        LocaleProvider localeProvider = LocaleProvider.f251b;
        Context context = getContext();
        Intrinsics3.checkExpressionValueIsNotNull(context, "context");
        Intrinsics3.checkParameterIsNotNull(context, "context");
        this.isLeftToRight = TextUtils.getLayoutDirectionFromLocale(LocaleProvider.a.invoke(context)) == 0;
        this.scrollingSlopPx = getResources().getDimension(R.a.overlapping_panels_scroll_slop);
        this.homeGestureFromBottomThreshold = getResources().getDimension(R.a.overlapping_panels_home_gesture_from_bottom_threshold);
        this.minFlingPxPerSecond = getResources().getDimension(R.a.overlapping_panels_min_fling_dp_per_second);
        Resources resources = getResources();
        Intrinsics3.checkExpressionValueIsNotNull(resources, "resources");
        if (resources.getConfiguration().orientation == 1) {
            Resources resources2 = getResources();
            Intrinsics3.checkExpressionValueIsNotNull(resources2, "resources");
            i = resources2.getDisplayMetrics().widthPixels;
        } else {
            Resources resources3 = getResources();
            Intrinsics3.checkExpressionValueIsNotNull(resources3, "resources");
            i = resources3.getDisplayMetrics().heightPixels;
        }
        this.nonFullScreenSidePanelWidth = (int) ((i - getResources().getDimension(R.a.overlapping_panels_margin_between_panels)) - getResources().getDimension(R.a.overlapping_panels_closed_center_panel_visible_width));
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.b.OverlappingPanelsLayout, 0, 0);
        try {
            this.nonFullScreenSidePanelWidth = Math.min(this.nonFullScreenSidePanelWidth, (int) typedArrayObtainStyledAttributes.getDimension(R.b.OverlappingPanelsLayout_maxSidePanelNonFullScreenWidth, Integer.MAX_VALUE));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private final boolean isTouchingCenterPanelWhileSidePanelOpen(MotionEvent event) {
        float x2 = event.getX();
        View view = this.centerPanel;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        float x3 = view.getX();
        float fMax = Math.max(this.startPanelOpenedCenterPanelX, this.endPanelOpenedCenterPanelX);
        float fMin = Math.min(this.startPanelOpenedCenterPanelX, this.endPanelOpenedCenterPanelX);
        View view2 = this.centerPanel;
        if (view2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
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

    private final void openPanel(Panel panel) {
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
            Intrinsics3.throwUninitializedPropertyAccessException("endPanel");
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = this.nonFullScreenSidePanelWidth;
        View view2 = this.endPanel;
        if (view2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("endPanel");
        }
        view2.setLayoutParams(layoutParams);
    }

    private final void resetStartPanelWidth() {
        View view = this.startPanel;
        if (view != null) {
            if (view == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("startPanel");
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = this.useFullWidthForStartPanel ? -1 : this.nonFullScreenSidePanelWidth;
            View view2 = this.startPanel;
            if (view2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("startPanel");
            }
            view2.setLayoutParams(layoutParams);
        }
    }

    private final boolean shouldHandleActionMoveEvent(MotionEvent event) {
        float normalizedX = getNormalizedX(getTargetedX(event));
        View view = this.centerPanel;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        float fAbs = Math.abs(normalizedX - view.getX());
        Resources resources = getResources();
        Intrinsics3.checkExpressionValueIsNotNull(resources, "resources");
        return normalizedX == 0.0f || normalizedX == this.startPanelOpenedCenterPanelX || normalizedX == this.endPanelOpenedCenterPanelX || ((fAbs > resources.getDisplayMetrics().density ? 1 : (fAbs == resources.getDisplayMetrics().density ? 0 : -1)) > 0);
    }

    private final void snapOpenOrClose(MotionEvent event) {
        float targetedX = getTargetedX(event);
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.computeCurrentVelocity(1000);
        }
        VelocityTracker velocityTracker2 = this.velocityTracker;
        float xVelocity = velocityTracker2 != null ? velocityTracker2.getXVelocity() : PrimitiveCompanionObjects2.a.getMIN_VALUE();
        boolean z2 = false;
        boolean z3 = Math.abs(xVelocity) > this.minFlingPxPerSecond;
        if (!this.isLeftToRight ? xVelocity < 0 : xVelocity > 0) {
            z2 = true;
        }
        if (z3) {
            if (z2) {
                Panel panel = this.selectedPanel;
                if (panel == Panel.END) {
                    closePanels(true);
                    return;
                } else if (panel == Panel.CENTER) {
                    openStartPanel(true);
                    return;
                }
            } else {
                Panel panel2 = this.selectedPanel;
                if (panel2 == Panel.START) {
                    closePanels(true);
                    return;
                } else if (panel2 == Panel.CENTER) {
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
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        float x3 = view.getX();
        View view2 = this.centerPanel;
        if (view2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
        }
        view2.setX(x2);
        handleCenterPanelX(x3, x2);
    }

    private final void updateCenterPanelXWithAnimation(float x2, boolean isFling, long animationDurationMs) {
        View view = this.centerPanel;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
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
            valueAnimatorOfFloat.addUpdateListener(new a(0, this));
        } else {
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(x3, normalizedX);
            valueAnimatorOfFloat2.setInterpolator(new FastOutSlowInInterpolator());
            valueAnimatorOfFloat2.setDuration(animationDurationMs);
            this.centerPanelXAnimator = valueAnimatorOfFloat2;
            valueAnimatorOfFloat2.addUpdateListener(new a(1, this));
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

    public final Panel getSelectedPanel() {
        return this.selectedPanel;
    }

    public final void handleEndPanelState(PanelState endPanelState) {
        Intrinsics3.checkParameterIsNotNull(endPanelState, "endPanelState");
        PanelState panelState = this.endPanelState;
        PanelState.c cVar = PanelState.c.a;
        if (Intrinsics3.areEqual(endPanelState, cVar) && (!Intrinsics3.areEqual(panelState, cVar))) {
            openEndPanel();
        } else if ((endPanelState instanceof PanelState.a) && Intrinsics3.areEqual(panelState, cVar)) {
            closePanels();
        }
        this.endPanelState = endPanelState;
    }

    public final void handleStartPanelState(PanelState startPanelState) {
        Intrinsics3.checkParameterIsNotNull(startPanelState, "startPanelState");
        PanelState panelState = this.startPanelState;
        PanelState.c cVar = PanelState.c.a;
        if (Intrinsics3.areEqual(startPanelState, cVar) && (!Intrinsics3.areEqual(panelState, cVar))) {
            openStartPanel();
        } else if (Intrinsics3.areEqual(startPanelState, PanelState.a.a) && Intrinsics3.areEqual(panelState, cVar)) {
            closePanels();
        }
        this.startPanelState = startPanelState;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004f  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        VelocityTracker velocityTracker;
        Intrinsics3.checkParameterIsNotNull(event, "event");
        int actionMasked = event.getActionMasked();
        boolean z2 = false;
        if (actionMasked == 0) {
            this.isScrollingHorizontally = false;
            this.wasActionDownOnClosedCenterPanel = isTouchingCenterPanelWhileSidePanelOpen(event);
            View view = this.centerPanel;
            if (view == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("centerPanel");
            }
            this.centerPanelDiffX = view.getX() - event.getRawX();
            this.xFromInterceptActionDown = event.getX();
            float y2 = event.getY();
            this.yFromInterceptActionDown = y2;
            Resources resources = getResources();
            Intrinsics3.checkExpressionValueIsNotNull(resources, "resources");
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
        Intrinsics3.checkParameterIsNotNull(event, "event");
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
                    this.swipeDirection = fCalculateDistanceX > ((float) 0) ? SwipeDirection.RIGHT : SwipeDirection.LEFT;
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

    public final void registerEndPanelStateListeners(PanelStateListener... panelStateListenerArgs) {
        Intrinsics3.checkParameterIsNotNull(panelStateListenerArgs, "panelStateListenerArgs");
        for (PanelStateListener panelStateListener : panelStateListenerArgs) {
            this.endPanelStateListeners.add(panelStateListener);
        }
    }

    public final void registerStartPanelStateListeners(PanelStateListener... panelStateListenerArgs) {
        Intrinsics3.checkParameterIsNotNull(panelStateListenerArgs, "panelStateListenerArgs");
        for (PanelStateListener panelStateListener : panelStateListenerArgs) {
            this.startPanelStateListeners.add(panelStateListener);
        }
    }

    public final void setChildGestureRegions(List<Rect> childGestureRegions) {
        Intrinsics3.checkParameterIsNotNull(childGestureRegions, "childGestureRegions");
        this.childGestureRegions = childGestureRegions;
    }

    public final void setEndPanelLockState(LockState lockState) {
        Intrinsics3.checkParameterIsNotNull(lockState, "lockState");
        this.endPanelLockState = lockState;
        if (lockState == LockState.OPEN) {
            openEndPanel();
        }
    }

    public final void setStartPanelLockState(LockState lockState) {
        Intrinsics3.checkParameterIsNotNull(lockState, "lockState");
        this.startPanelLockState = lockState;
        if (lockState == LockState.OPEN) {
            openStartPanel();
        }
    }

    public final void setStartPanelUseFullPortraitWidth(boolean useFullPortraitWidth) {
        this.useFullWidthForStartPanel = useFullPortraitWidth;
        resetStartPanelWidth();
    }

    private final void closePanels(boolean isFling) {
        if (this.centerPanel == null) {
            this.pendingUpdate = new c(isFling);
        } else {
            updateCenterPanelXWithAnimation(0.0f, isFling, SIDE_PANEL_CLOSE_DURATION_MS);
        }
    }

    private final void openEndPanel(boolean isFling) {
        if (this.centerPanel == null) {
            this.pendingUpdate = new d(isFling);
        } else {
            updateCenterPanelXWithAnimation(this.endPanelOpenedCenterPanelX, isFling, SIDE_PANEL_OPEN_DURATION_MS);
        }
    }

    private final void openStartPanel(boolean isFling) {
        if (this.centerPanel == null) {
            this.pendingUpdate = new e(isFling);
        } else if (this.startPanelLockState == LockState.OPEN) {
            updateCenterPanelX(this.startPanelOpenedCenterPanelX);
        } else {
            updateCenterPanelXWithAnimation(this.startPanelOpenedCenterPanelX, isFling, SIDE_PANEL_OPEN_DURATION_MS);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlappingPanelsLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkParameterIsNotNull(context, "context");
        this.isLeftToRight = true;
        PrimitiveCompanionObjects2 primitiveCompanionObjects2 = PrimitiveCompanionObjects2.a;
        this.startPanelOpenedCenterPanelX = primitiveCompanionObjects2.getMIN_VALUE();
        this.endPanelOpenedCenterPanelX = primitiveCompanionObjects2.getMAX_VALUE();
        this.startPanelStateListeners = new ArrayList<>();
        this.endPanelStateListeners = new ArrayList<>();
        this.selectedPanel = Panel.CENTER;
        LockState lockState = LockState.UNLOCKED;
        this.startPanelLockState = lockState;
        this.endPanelLockState = lockState;
        PanelState.a aVar = PanelState.a.a;
        this.startPanelState = aVar;
        this.endPanelState = aVar;
        this.childGestureRegions = Collections2.emptyList();
        this.isSystemGestureNavigationPossible = Build.VERSION.SDK_INT >= 29;
        initialize(attributeSet);
    }

    public /* synthetic */ OverlappingPanelsLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlappingPanelsLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkParameterIsNotNull(context, "context");
        this.isLeftToRight = true;
        PrimitiveCompanionObjects2 primitiveCompanionObjects2 = PrimitiveCompanionObjects2.a;
        this.startPanelOpenedCenterPanelX = primitiveCompanionObjects2.getMIN_VALUE();
        this.endPanelOpenedCenterPanelX = primitiveCompanionObjects2.getMAX_VALUE();
        this.startPanelStateListeners = new ArrayList<>();
        this.endPanelStateListeners = new ArrayList<>();
        this.selectedPanel = Panel.CENTER;
        LockState lockState = LockState.UNLOCKED;
        this.startPanelLockState = lockState;
        this.endPanelLockState = lockState;
        PanelState.a aVar = PanelState.a.a;
        this.startPanelState = aVar;
        this.endPanelState = aVar;
        this.childGestureRegions = Collections2.emptyList();
        this.isSystemGestureNavigationPossible = Build.VERSION.SDK_INT >= 29;
        initialize(attributeSet);
    }

    public /* synthetic */ OverlappingPanelsLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}

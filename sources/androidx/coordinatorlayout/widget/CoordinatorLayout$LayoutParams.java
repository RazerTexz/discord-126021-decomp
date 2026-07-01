package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.R$styleable;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout$LayoutParams extends ViewGroup$MarginLayoutParams {
    public int anchorGravity;
    public int dodgeInsetEdges;
    public int gravity;
    public int insetEdge;
    public int keyline;
    public View mAnchorDirectChild;
    public int mAnchorId;
    public View mAnchorView;
    public CoordinatorLayout$Behavior mBehavior;
    public boolean mBehaviorResolved;
    public Object mBehaviorTag;
    private boolean mDidAcceptNestedScrollNonTouch;
    private boolean mDidAcceptNestedScrollTouch;
    private boolean mDidBlockInteraction;
    private boolean mDidChangeAfterNestedScroll;
    public int mInsetOffsetX;
    public int mInsetOffsetY;
    public final Rect mLastChildRect;

    public CoordinatorLayout$LayoutParams(int i, int i2) {
        super(i, i2);
        this.mBehaviorResolved = false;
        this.gravity = 0;
        this.anchorGravity = 0;
        this.keyline = -1;
        this.mAnchorId = -1;
        this.insetEdge = 0;
        this.dodgeInsetEdges = 0;
        this.mLastChildRect = new Rect();
    }

    private void resolveAnchorView(View view, CoordinatorLayout coordinatorLayout) {
        View viewFindViewById = coordinatorLayout.findViewById(this.mAnchorId);
        this.mAnchorView = viewFindViewById;
        if (viewFindViewById == null) {
            if (coordinatorLayout.isInEditMode()) {
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
                return;
            } else {
                StringBuilder sbU = a.U("Could not find CoordinatorLayout descendant view with id ");
                sbU.append(coordinatorLayout.getResources().getResourceName(this.mAnchorId));
                sbU.append(" to anchor view ");
                sbU.append(view);
                throw new IllegalStateException(sbU.toString());
            }
        }
        if (viewFindViewById == coordinatorLayout) {
            if (!coordinatorLayout.isInEditMode()) {
                throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
            }
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return;
        }
        for (ViewParent parent = viewFindViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
            if (parent == view) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                }
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
                return;
            }
            if (parent instanceof View) {
                viewFindViewById = parent;
            }
        }
        this.mAnchorDirectChild = viewFindViewById;
    }

    private boolean shouldDodge(View view, int i) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(((CoordinatorLayout$LayoutParams) view.getLayoutParams()).insetEdge, i);
        return absoluteGravity != 0 && (GravityCompat.getAbsoluteGravity(this.dodgeInsetEdges, i) & absoluteGravity) == absoluteGravity;
    }

    private boolean verifyAnchorView(View view, CoordinatorLayout coordinatorLayout) {
        if (this.mAnchorView.getId() != this.mAnchorId) {
            return false;
        }
        View view2 = this.mAnchorView;
        for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
            if (parent == null || parent == view) {
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
                return false;
            }
            if (parent instanceof View) {
                view2 = parent;
            }
        }
        this.mAnchorDirectChild = view2;
        return true;
    }

    public boolean checkAnchorChanged() {
        return this.mAnchorView == null && this.mAnchorId != -1;
    }

    public boolean dependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        CoordinatorLayout$Behavior coordinatorLayout$Behavior;
        return view2 == this.mAnchorDirectChild || shouldDodge(view2, ViewCompat.getLayoutDirection(coordinatorLayout)) || ((coordinatorLayout$Behavior = this.mBehavior) != null && coordinatorLayout$Behavior.layoutDependsOn(coordinatorLayout, view, view2));
    }

    public boolean didBlockInteraction() {
        if (this.mBehavior == null) {
            this.mDidBlockInteraction = false;
        }
        return this.mDidBlockInteraction;
    }

    public View findAnchorView(CoordinatorLayout coordinatorLayout, View view) {
        if (this.mAnchorId == -1) {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return null;
        }
        if (this.mAnchorView == null || !verifyAnchorView(view, coordinatorLayout)) {
            resolveAnchorView(view, coordinatorLayout);
        }
        return this.mAnchorView;
    }

    @IdRes
    public int getAnchorId() {
        return this.mAnchorId;
    }

    @Nullable
    public CoordinatorLayout$Behavior getBehavior() {
        return this.mBehavior;
    }

    public boolean getChangedAfterNestedScroll() {
        return this.mDidChangeAfterNestedScroll;
    }

    public Rect getLastChildRect() {
        return this.mLastChildRect;
    }

    public void invalidateAnchor() {
        this.mAnchorDirectChild = null;
        this.mAnchorView = null;
    }

    public boolean isBlockingInteractionBelow(CoordinatorLayout coordinatorLayout, View view) {
        boolean z2 = this.mDidBlockInteraction;
        if (z2) {
            return true;
        }
        CoordinatorLayout$Behavior coordinatorLayout$Behavior = this.mBehavior;
        boolean zBlocksInteractionBelow = (coordinatorLayout$Behavior != null ? coordinatorLayout$Behavior.blocksInteractionBelow(coordinatorLayout, view) : false) | z2;
        this.mDidBlockInteraction = zBlocksInteractionBelow;
        return zBlocksInteractionBelow;
    }

    public boolean isNestedScrollAccepted(int i) {
        if (i == 0) {
            return this.mDidAcceptNestedScrollTouch;
        }
        if (i != 1) {
            return false;
        }
        return this.mDidAcceptNestedScrollNonTouch;
    }

    public void resetChangedAfterNestedScroll() {
        this.mDidChangeAfterNestedScroll = false;
    }

    public void resetNestedScroll(int i) {
        setNestedScrollAccepted(i, false);
    }

    public void resetTouchBehaviorTracking() {
        this.mDidBlockInteraction = false;
    }

    public void setAnchorId(@IdRes int i) {
        invalidateAnchor();
        this.mAnchorId = i;
    }

    public void setBehavior(@Nullable CoordinatorLayout$Behavior coordinatorLayout$Behavior) {
        CoordinatorLayout$Behavior coordinatorLayout$Behavior2 = this.mBehavior;
        if (coordinatorLayout$Behavior2 != coordinatorLayout$Behavior) {
            if (coordinatorLayout$Behavior2 != null) {
                coordinatorLayout$Behavior2.onDetachedFromLayoutParams();
            }
            this.mBehavior = coordinatorLayout$Behavior;
            this.mBehaviorTag = null;
            this.mBehaviorResolved = true;
            if (coordinatorLayout$Behavior != null) {
                coordinatorLayout$Behavior.onAttachedToLayoutParams(this);
            }
        }
    }

    public void setChangedAfterNestedScroll(boolean z2) {
        this.mDidChangeAfterNestedScroll = z2;
    }

    public void setLastChildRect(Rect rect) {
        this.mLastChildRect.set(rect);
    }

    public void setNestedScrollAccepted(int i, boolean z2) {
        if (i == 0) {
            this.mDidAcceptNestedScrollTouch = z2;
        } else {
            if (i != 1) {
                return;
            }
            this.mDidAcceptNestedScrollNonTouch = z2;
        }
    }

    public CoordinatorLayout$LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBehaviorResolved = false;
        this.gravity = 0;
        this.anchorGravity = 0;
        this.keyline = -1;
        this.mAnchorId = -1;
        this.insetEdge = 0;
        this.dodgeInsetEdges = 0;
        this.mLastChildRect = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout_Layout);
        this.gravity = typedArrayObtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
        this.mAnchorId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.CoordinatorLayout_Layout_layout_anchor, -1);
        this.anchorGravity = typedArrayObtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
        this.keyline = typedArrayObtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_keyline, -1);
        this.insetEdge = typedArrayObtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
        this.dodgeInsetEdges = typedArrayObtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
        int i = R$styleable.CoordinatorLayout_Layout_layout_behavior;
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i);
        this.mBehaviorResolved = zHasValue;
        if (zHasValue) {
            this.mBehavior = CoordinatorLayout.parseBehavior(context, attributeSet, typedArrayObtainStyledAttributes.getString(i));
        }
        typedArrayObtainStyledAttributes.recycle();
        CoordinatorLayout$Behavior coordinatorLayout$Behavior = this.mBehavior;
        if (coordinatorLayout$Behavior != null) {
            coordinatorLayout$Behavior.onAttachedToLayoutParams(this);
        }
    }

    public CoordinatorLayout$LayoutParams(CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams) {
        super((ViewGroup$MarginLayoutParams) coordinatorLayout$LayoutParams);
        this.mBehaviorResolved = false;
        this.gravity = 0;
        this.anchorGravity = 0;
        this.keyline = -1;
        this.mAnchorId = -1;
        this.insetEdge = 0;
        this.dodgeInsetEdges = 0;
        this.mLastChildRect = new Rect();
    }

    public CoordinatorLayout$LayoutParams(ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        super(viewGroup$MarginLayoutParams);
        this.mBehaviorResolved = false;
        this.gravity = 0;
        this.anchorGravity = 0;
        this.keyline = -1;
        this.mAnchorId = -1;
        this.insetEdge = 0;
        this.dodgeInsetEdges = 0;
        this.mLastChildRect = new Rect();
    }

    public CoordinatorLayout$LayoutParams(ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
        this.mBehaviorResolved = false;
        this.gravity = 0;
        this.anchorGravity = 0;
        this.keyline = -1;
        this.mAnchorId = -1;
        this.insetEdge = 0;
        this.dodgeInsetEdges = 0;
        this.mLastChildRect = new Rect();
    }
}

package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View$MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SlidingPaneLayout extends ViewGroup {
    private static final int DEFAULT_FADE_COLOR = -858993460;
    private static final int DEFAULT_OVERHANG_SIZE = 32;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final String TAG = "SlidingPaneLayout";
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    private boolean mDisplayListReflectionLoaded;
    public final ViewDragHelper mDragHelper;
    private boolean mFirstLayout;
    private Method mGetDisplayList;
    private float mInitialMotionX;
    private float mInitialMotionY;
    public boolean mIsUnableToDrag;
    private final int mOverhangSize;
    private SlidingPaneLayout$PanelSlideListener mPanelSlideListener;
    private int mParallaxBy;
    private float mParallaxOffset;
    public final ArrayList<SlidingPaneLayout$DisableLayerRunnable> mPostedRunnables;
    public boolean mPreservedOpenState;
    private Field mRecreateDisplayList;
    private Drawable mShadowDrawableLeft;
    private Drawable mShadowDrawableRight;
    public float mSlideOffset;
    public int mSlideRange;
    public View mSlideableView;
    private int mSliderFadeColor;
    private final Rect mTmpRect;

    public SlidingPaneLayout(@NonNull Context context) {
        this(context, null);
    }

    private boolean closePane(View view, int i) {
        if (!this.mFirstLayout && !smoothSlideTo(0.0f, i)) {
            return false;
        }
        this.mPreservedOpenState = false;
        return true;
    }

    private void dimChildView(View view, float f, int i) {
        SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) ((((-16777216) & i) >>> 24) * f)) << 24) | (i & ViewCompat.MEASURED_SIZE_MASK);
            if (slidingPaneLayout$LayoutParams.dimPaint == null) {
                slidingPaneLayout$LayoutParams.dimPaint = new Paint();
            }
            slidingPaneLayout$LayoutParams.dimPaint.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff$Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, slidingPaneLayout$LayoutParams.dimPaint);
            }
            invalidateChildRegion(view);
            return;
        }
        if (view.getLayerType() != 0) {
            Paint paint = slidingPaneLayout$LayoutParams.dimPaint;
            if (paint != null) {
                paint.setColorFilter(null);
            }
            SlidingPaneLayout$DisableLayerRunnable slidingPaneLayout$DisableLayerRunnable = new SlidingPaneLayout$DisableLayerRunnable(this, view);
            this.mPostedRunnables.add(slidingPaneLayout$DisableLayerRunnable);
            ViewCompat.postOnAnimation(this, slidingPaneLayout$DisableLayerRunnable);
        }
    }

    private boolean openPane(View view, int i) {
        if (!this.mFirstLayout && !smoothSlideTo(1.0f, i)) {
            return false;
        }
        this.mPreservedOpenState = true;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    private void parallaxOtherViews(float f) {
        boolean z2;
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams) this.mSlideableView.getLayoutParams();
        if (!slidingPaneLayout$LayoutParams.dimWhenOffset) {
            z2 = false;
        } else if ((zIsLayoutRtlSupport ? ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).rightMargin : ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).leftMargin) <= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != this.mSlideableView) {
                float f2 = 1.0f - this.mParallaxOffset;
                int i2 = this.mParallaxBy;
                this.mParallaxOffset = f;
                int i3 = ((int) (f2 * i2)) - ((int) ((1.0f - f) * i2));
                if (zIsLayoutRtlSupport) {
                    i3 = -i3;
                }
                childAt.offsetLeftAndRight(i3);
                if (z2) {
                    float f3 = this.mParallaxOffset;
                    dimChildView(childAt, zIsLayoutRtlSupport ? f3 - 1.0f : 1.0f - f3, this.mCoveredFadeColor);
                }
            }
        }
    }

    private static boolean viewIsOpaque(View view) {
        return view.isOpaque();
    }

    public boolean canScroll(View view, boolean z2, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && canScroll(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z2) {
            if (view.canScrollHorizontally(isLayoutRtlSupport() ? i : -i)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public boolean canSlide() {
        return this.mCanSlide;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return (viewGroup$LayoutParams instanceof SlidingPaneLayout$LayoutParams) && super.checkLayoutParams(viewGroup$LayoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mDragHelper.continueSettling(true)) {
            if (this.mCanSlide) {
                ViewCompat.postInvalidateOnAnimation(this);
            } else {
                this.mDragHelper.abort();
            }
        }
    }

    public void dispatchOnPanelClosed(View view) {
        SlidingPaneLayout$PanelSlideListener slidingPaneLayout$PanelSlideListener = this.mPanelSlideListener;
        if (slidingPaneLayout$PanelSlideListener != null) {
            slidingPaneLayout$PanelSlideListener.onPanelClosed(view);
        }
        sendAccessibilityEvent(32);
    }

    public void dispatchOnPanelOpened(View view) {
        SlidingPaneLayout$PanelSlideListener slidingPaneLayout$PanelSlideListener = this.mPanelSlideListener;
        if (slidingPaneLayout$PanelSlideListener != null) {
            slidingPaneLayout$PanelSlideListener.onPanelOpened(view);
        }
        sendAccessibilityEvent(32);
    }

    public void dispatchOnPanelSlide(View view) {
        SlidingPaneLayout$PanelSlideListener slidingPaneLayout$PanelSlideListener = this.mPanelSlideListener;
        if (slidingPaneLayout$PanelSlideListener != null) {
            slidingPaneLayout$PanelSlideListener.onPanelSlide(view, this.mSlideOffset);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i;
        int right;
        super.draw(canvas);
        Drawable drawable = isLayoutRtlSupport() ? this.mShadowDrawableRight : this.mShadowDrawableLeft;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt == null || drawable == null) {
            return;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (isLayoutRtlSupport()) {
            right = childAt.getRight();
            i = intrinsicWidth + right;
        } else {
            int left = childAt.getLeft();
            int i2 = left - intrinsicWidth;
            i = left;
            right = i2;
        }
        drawable.setBounds(right, top, i, bottom);
        drawable.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams) view.getLayoutParams();
        int iSave = canvas.save();
        if (this.mCanSlide && !slidingPaneLayout$LayoutParams.slideable && this.mSlideableView != null) {
            canvas.getClipBounds(this.mTmpRect);
            if (isLayoutRtlSupport()) {
                Rect rect = this.mTmpRect;
                rect.left = Math.max(rect.left, this.mSlideableView.getRight());
            } else {
                Rect rect2 = this.mTmpRect;
                rect2.right = Math.min(rect2.right, this.mSlideableView.getLeft());
            }
            canvas.clipRect(this.mTmpRect);
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(iSave);
        return zDrawChild;
    }

    @Override // android.view.ViewGroup
    public ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return new SlidingPaneLayout$LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams ? new SlidingPaneLayout$LayoutParams((ViewGroup$MarginLayoutParams) viewGroup$LayoutParams) : new SlidingPaneLayout$LayoutParams(viewGroup$LayoutParams);
    }

    @ColorInt
    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    @Px
    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    @ColorInt
    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    public void invalidateChildRegion(View view) {
        ViewCompat.setLayerPaint(view, ((SlidingPaneLayout$LayoutParams) view.getLayoutParams()).dimPaint);
    }

    public boolean isDimmed(View view) {
        if (view == null) {
            return false;
        }
        return this.mCanSlide && ((SlidingPaneLayout$LayoutParams) view.getLayoutParams()).dimWhenOffset && this.mSlideOffset > 0.0f;
    }

    public boolean isLayoutRtlSupport() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    public boolean isOpen() {
        return !this.mCanSlide || this.mSlideOffset == 1.0f;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        int size = this.mPostedRunnables.size();
        for (int i = 0; i < size; i++) {
            this.mPostedRunnables.get(i).run();
        }
        this.mPostedRunnables.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.mCanSlide && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.mPreservedOpenState = !this.mDragHelper.isViewUnder(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.mCanSlide || (this.mIsUnableToDrag && actionMasked != 0)) {
            this.mDragHelper.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked == 3 || actionMasked == 1) {
            this.mDragHelper.cancel();
            return false;
        }
        if (actionMasked == 0) {
            this.mIsUnableToDrag = false;
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            this.mInitialMotionX = x2;
            this.mInitialMotionY = y2;
            if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) x2, (int) y2) && isDimmed(this.mSlideableView)) {
                z2 = true;
            }
            return this.mDragHelper.shouldInterceptTouchEvent(motionEvent) || z2;
        }
        if (actionMasked == 2) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            float fAbs = Math.abs(x3 - this.mInitialMotionX);
            float fAbs2 = Math.abs(y3 - this.mInitialMotionY);
            if (fAbs > this.mDragHelper.getTouchSlop() && fAbs2 > fAbs) {
                this.mDragHelper.cancel();
                this.mIsUnableToDrag = true;
                return false;
            }
        }
        z2 = false;
        if (this.mDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        if (zIsLayoutRtlSupport) {
            this.mDragHelper.setEdgeTrackingEnabled(2);
        } else {
            this.mDragHelper.setEdgeTrackingEnabled(1);
        }
        int i10 = i3 - i;
        int paddingRight = zIsLayoutRtlSupport ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = zIsLayoutRtlSupport ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.mFirstLayout) {
            this.mSlideOffset = (this.mCanSlide && this.mPreservedOpenState) ? 1.0f : 0.0f;
        }
        int i11 = paddingRight;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (slidingPaneLayout$LayoutParams.slideable) {
                    int i13 = i10 - paddingLeft;
                    int iMin = (Math.min(paddingRight, i13 - this.mOverhangSize) - i11) - (((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).leftMargin + ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).rightMargin);
                    this.mSlideRange = iMin;
                    int i14 = zIsLayoutRtlSupport ? ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).rightMargin : ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).leftMargin;
                    slidingPaneLayout$LayoutParams.dimWhenOffset = (measuredWidth / 2) + ((i11 + i14) + iMin) > i13;
                    int i15 = (int) (iMin * this.mSlideOffset);
                    i5 = i14 + i15 + i11;
                    this.mSlideOffset = i15 / iMin;
                    i6 = 0;
                } else if (!this.mCanSlide || (i7 = this.mParallaxBy) == 0) {
                    i5 = paddingRight;
                    i6 = 0;
                } else {
                    i6 = (int) ((1.0f - this.mSlideOffset) * i7);
                    i5 = paddingRight;
                }
                if (zIsLayoutRtlSupport) {
                    i9 = (i10 - i5) + i6;
                    i8 = i9 - measuredWidth;
                } else {
                    i8 = i5 - i6;
                    i9 = i8 + measuredWidth;
                }
                childAt.layout(i8, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                i11 = i5;
                paddingRight = childAt.getWidth() + paddingRight;
            }
        }
        if (this.mFirstLayout) {
            if (this.mCanSlide) {
                if (this.mParallaxBy != 0) {
                    parallaxOtherViews(this.mSlideOffset);
                }
                if (((SlidingPaneLayout$LayoutParams) this.mSlideableView.getLayoutParams()).dimWhenOffset) {
                    dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
                }
            } else {
                for (int i16 = 0; i16 < childCount; i16++) {
                    dimChildView(getChildAt(i16), 0.0f, this.mSliderFadeColor);
                }
            }
            updateObscuredViewsVisibility(this.mSlideableView);
        }
        this.mFirstLayout = false;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00b2 A[PHI: r13
      0x00b2: PHI (r13v2 float) = (r13v1 float), (r13v7 float) binds: [B:35:0x00a9, B:37:0x00ae] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:41:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:42:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:45:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:60:0x0113  */
    /* JADX WARN: Code duplicated, block: B:61:0x0115  */
    /* JADX WARN: Code duplicated, block: B:64:0x011b  */
    /* JADX WARN: Code duplicated, block: B:74:0x0140  */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int paddingTop;
        int iMin;
        int i3;
        int iMakeMeasureSpec;
        int i4;
        int i5;
        int iMakeMeasureSpec2;
        int i6;
        int i7;
        float f;
        int i8;
        int iMakeMeasureSpec3;
        int i9;
        int iMakeMeasureSpec4;
        int iMakeMeasureSpec5;
        int measuredHeight;
        boolean z2;
        int mode = View$MeasureSpec.getMode(i);
        int size = View$MeasureSpec.getSize(i);
        int mode2 = View$MeasureSpec.getMode(i2);
        int size2 = View$MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
        } else if (mode2 == 0) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            }
            if (mode2 == 0) {
                mode2 = Integer.MIN_VALUE;
                size2 = 300;
            }
        }
        boolean z3 = false;
        if (mode2 == Integer.MIN_VALUE) {
            paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            iMin = 0;
        } else if (mode2 != 1073741824) {
            iMin = 0;
            paddingTop = 0;
        } else {
            iMin = (size2 - getPaddingTop()) - getPaddingBottom();
            paddingTop = iMin;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e(TAG, "onMeasure: More than two child views are not supported.");
        }
        this.mSlideableView = null;
        int i10 = paddingLeft;
        int i11 = 0;
        boolean z4 = false;
        float f2 = 0.0f;
        while (true) {
            i3 = 8;
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                slidingPaneLayout$LayoutParams.dimWhenOffset = z3;
            } else {
                float f3 = slidingPaneLayout$LayoutParams.weight;
                if (f3 > 0.0f) {
                    f2 += f3;
                    if (((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).width != 0) {
                        i6 = ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).leftMargin + ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).rightMargin;
                        i7 = ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).width;
                        if (i7 == -2) {
                            iMakeMeasureSpec3 = View$MeasureSpec.makeMeasureSpec(paddingLeft - i6, Integer.MIN_VALUE);
                            f = f2;
                            i8 = Integer.MIN_VALUE;
                        } else {
                            f = f2;
                            i8 = Integer.MIN_VALUE;
                            if (i7 == -1) {
                                iMakeMeasureSpec3 = View$MeasureSpec.makeMeasureSpec(paddingLeft - i6, BasicMeasure.EXACTLY);
                            } else {
                                iMakeMeasureSpec3 = View$MeasureSpec.makeMeasureSpec(i7, BasicMeasure.EXACTLY);
                            }
                        }
                        i9 = ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).height;
                        if (i9 == -2) {
                            iMakeMeasureSpec5 = View$MeasureSpec.makeMeasureSpec(paddingTop, i8);
                        } else {
                            if (i9 == -1) {
                                iMakeMeasureSpec4 = View$MeasureSpec.makeMeasureSpec(paddingTop, BasicMeasure.EXACTLY);
                            } else {
                                iMakeMeasureSpec4 = View$MeasureSpec.makeMeasureSpec(i9, BasicMeasure.EXACTLY);
                            }
                            iMakeMeasureSpec5 = iMakeMeasureSpec4;
                        }
                        childAt.measure(iMakeMeasureSpec3, iMakeMeasureSpec5);
                        int measuredWidth = childAt.getMeasuredWidth();
                        measuredHeight = childAt.getMeasuredHeight();
                        if (mode2 == i8 && measuredHeight > iMin) {
                            iMin = Math.min(measuredHeight, paddingTop);
                        }
                        i10 -= measuredWidth;
                        if (i10 < 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        slidingPaneLayout$LayoutParams.slideable = z2;
                        z4 |= z2;
                        if (z2) {
                            this.mSlideableView = childAt;
                        }
                        f2 = f;
                    }
                } else {
                    i6 = ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).leftMargin + ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).rightMargin;
                    i7 = ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).width;
                    if (i7 == -2) {
                        iMakeMeasureSpec3 = View$MeasureSpec.makeMeasureSpec(paddingLeft - i6, Integer.MIN_VALUE);
                        f = f2;
                        i8 = Integer.MIN_VALUE;
                    } else {
                        f = f2;
                        i8 = Integer.MIN_VALUE;
                        if (i7 == -1) {
                            iMakeMeasureSpec3 = View$MeasureSpec.makeMeasureSpec(paddingLeft - i6, BasicMeasure.EXACTLY);
                        } else {
                            iMakeMeasureSpec3 = View$MeasureSpec.makeMeasureSpec(i7, BasicMeasure.EXACTLY);
                        }
                    }
                    i9 = ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).height;
                    if (i9 == -2) {
                        iMakeMeasureSpec5 = View$MeasureSpec.makeMeasureSpec(paddingTop, i8);
                    } else {
                        if (i9 == -1) {
                            iMakeMeasureSpec4 = View$MeasureSpec.makeMeasureSpec(paddingTop, BasicMeasure.EXACTLY);
                        } else {
                            iMakeMeasureSpec4 = View$MeasureSpec.makeMeasureSpec(i9, BasicMeasure.EXACTLY);
                        }
                        iMakeMeasureSpec5 = iMakeMeasureSpec4;
                    }
                    childAt.measure(iMakeMeasureSpec3, iMakeMeasureSpec5);
                    int measuredWidth2 = childAt.getMeasuredWidth();
                    measuredHeight = childAt.getMeasuredHeight();
                    if (mode2 == i8) {
                        iMin = Math.min(measuredHeight, paddingTop);
                    }
                    i10 -= measuredWidth2;
                    if (i10 < 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    slidingPaneLayout$LayoutParams.slideable = z2;
                    z4 |= z2;
                    if (z2) {
                        this.mSlideableView = childAt;
                    }
                    f2 = f;
                }
            }
            i11++;
            z3 = false;
        }
        if (z4 || f2 > 0.0f) {
            int i12 = paddingLeft - this.mOverhangSize;
            int i13 = 0;
            while (i13 < childCount) {
                View childAt2 = getChildAt(i13);
                if (childAt2.getVisibility() == i3) {
                    i4 = i12;
                } else {
                    SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams2 = (SlidingPaneLayout$LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i3) {
                        boolean z5 = ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams2).width == 0 && slidingPaneLayout$LayoutParams2.weight > 0.0f;
                        int measuredWidth3 = z5 ? 0 : childAt2.getMeasuredWidth();
                        if (!z4 || childAt2 == this.mSlideableView) {
                            if (slidingPaneLayout$LayoutParams2.weight > 0.0f) {
                                if (((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams2).width == 0) {
                                    int i14 = ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams2).height;
                                    if (i14 == -2) {
                                        iMakeMeasureSpec = View$MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                    } else {
                                        iMakeMeasureSpec = i14 == -1 ? View$MeasureSpec.makeMeasureSpec(paddingTop, BasicMeasure.EXACTLY) : View$MeasureSpec.makeMeasureSpec(i14, BasicMeasure.EXACTLY);
                                    }
                                } else {
                                    iMakeMeasureSpec = View$MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), BasicMeasure.EXACTLY);
                                }
                                if (z4) {
                                    int i15 = paddingLeft - (((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams2).leftMargin + ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams2).rightMargin);
                                    i4 = i12;
                                    int iMakeMeasureSpec6 = View$MeasureSpec.makeMeasureSpec(i15, BasicMeasure.EXACTLY);
                                    if (measuredWidth3 != i15) {
                                        childAt2.measure(iMakeMeasureSpec6, iMakeMeasureSpec);
                                    }
                                } else {
                                    i4 = i12;
                                    childAt2.measure(View$MeasureSpec.makeMeasureSpec(measuredWidth3 + ((int) ((slidingPaneLayout$LayoutParams2.weight * Math.max(0, i10)) / f2)), BasicMeasure.EXACTLY), iMakeMeasureSpec);
                                }
                            }
                        } else if (((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams2).width < 0 && (measuredWidth3 > i12 || slidingPaneLayout$LayoutParams2.weight > 0.0f)) {
                            if (z5) {
                                int i16 = ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams2).height;
                                if (i16 == -2) {
                                    iMakeMeasureSpec2 = View$MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                    i5 = BasicMeasure.EXACTLY;
                                } else if (i16 == -1) {
                                    i5 = BasicMeasure.EXACTLY;
                                    iMakeMeasureSpec2 = View$MeasureSpec.makeMeasureSpec(paddingTop, BasicMeasure.EXACTLY);
                                } else {
                                    i5 = BasicMeasure.EXACTLY;
                                    iMakeMeasureSpec2 = View$MeasureSpec.makeMeasureSpec(i16, BasicMeasure.EXACTLY);
                                }
                            } else {
                                i5 = BasicMeasure.EXACTLY;
                                iMakeMeasureSpec2 = View$MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), BasicMeasure.EXACTLY);
                            }
                            childAt2.measure(View$MeasureSpec.makeMeasureSpec(i12, i5), iMakeMeasureSpec2);
                        }
                        i4 = i12;
                    } else {
                        i4 = i12;
                    }
                }
                i13++;
                i12 = i4;
                i3 = 8;
            }
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + iMin);
        this.mCanSlide = z4;
        if (this.mDragHelper.getViewDragState() == 0 || z4) {
            return;
        }
        this.mDragHelper.abort();
    }

    public void onPanelDragged(int i) {
        if (this.mSlideableView == null) {
            this.mSlideOffset = 0.0f;
            return;
        }
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams) this.mSlideableView.getLayoutParams();
        int width = this.mSlideableView.getWidth();
        if (zIsLayoutRtlSupport) {
            i = (getWidth() - i) - width;
        }
        float paddingRight = (i - ((zIsLayoutRtlSupport ? getPaddingRight() : getPaddingLeft()) + (zIsLayoutRtlSupport ? ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).rightMargin : ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).leftMargin))) / this.mSlideRange;
        this.mSlideOffset = paddingRight;
        if (this.mParallaxBy != 0) {
            parallaxOtherViews(paddingRight);
        }
        if (slidingPaneLayout$LayoutParams.dimWhenOffset) {
            dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
        }
        dispatchOnPanelSlide(this.mSlideableView);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SlidingPaneLayout$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SlidingPaneLayout$SavedState slidingPaneLayout$SavedState = (SlidingPaneLayout$SavedState) parcelable;
        super.onRestoreInstanceState(slidingPaneLayout$SavedState.getSuperState());
        if (slidingPaneLayout$SavedState.isOpen) {
            openPane();
        } else {
            closePane();
        }
        this.mPreservedOpenState = slidingPaneLayout$SavedState.isOpen;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SlidingPaneLayout$SavedState slidingPaneLayout$SavedState = new SlidingPaneLayout$SavedState(super.onSaveInstanceState());
        slidingPaneLayout$SavedState.isOpen = isSlideable() ? isOpen() : this.mPreservedOpenState;
        return slidingPaneLayout$SavedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.mFirstLayout = true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanSlide) {
            return super.onTouchEvent(motionEvent);
        }
        this.mDragHelper.processTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            this.mInitialMotionX = x2;
            this.mInitialMotionY = y2;
        } else if (actionMasked == 1 && isDimmed(this.mSlideableView)) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            float f = x3 - this.mInitialMotionX;
            float f2 = y3 - this.mInitialMotionY;
            int touchSlop = this.mDragHelper.getTouchSlop();
            if ((f2 * f2) + (f * f) < touchSlop * touchSlop && this.mDragHelper.isViewUnder(this.mSlideableView, (int) x3, (int) y3)) {
                closePane(this.mSlideableView, 0);
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.mCanSlide) {
            return;
        }
        this.mPreservedOpenState = view == this.mSlideableView;
    }

    public void setAllChildrenVisible() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public void setCoveredFadeColor(@ColorInt int i) {
        this.mCoveredFadeColor = i;
    }

    public void setPanelSlideListener(@Nullable SlidingPaneLayout$PanelSlideListener slidingPaneLayout$PanelSlideListener) {
        this.mPanelSlideListener = slidingPaneLayout$PanelSlideListener;
    }

    public void setParallaxDistance(@Px int i) {
        this.mParallaxBy = i;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(@Nullable Drawable drawable) {
        this.mShadowDrawableLeft = drawable;
    }

    public void setShadowDrawableRight(@Nullable Drawable drawable) {
        this.mShadowDrawableRight = drawable;
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(ContextCompat.getDrawable(getContext(), i));
    }

    public void setSliderFadeColor(@ColorInt int i) {
        this.mSliderFadeColor = i;
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    public boolean smoothSlideTo(float f, int i) {
        int paddingLeft;
        if (!this.mCanSlide) {
            return false;
        }
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams) this.mSlideableView.getLayoutParams();
        if (zIsLayoutRtlSupport) {
            int paddingRight = getPaddingRight() + ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).rightMargin;
            paddingLeft = (int) (getWidth() - (((f * this.mSlideRange) + paddingRight) + this.mSlideableView.getWidth()));
        } else {
            paddingLeft = (int) ((f * this.mSlideRange) + getPaddingLeft() + ((ViewGroup$MarginLayoutParams) slidingPaneLayout$LayoutParams).leftMargin);
        }
        ViewDragHelper viewDragHelper = this.mDragHelper;
        View view = this.mSlideableView;
        if (!viewDragHelper.smoothSlideViewTo(view, paddingLeft, view.getTop())) {
            return false;
        }
        setAllChildrenVisible();
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    }

    public void updateObscuredViewsVisibility(View view) {
        int left;
        int right;
        int top;
        int bottom;
        View childAt;
        View view2 = view;
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        int width = zIsLayoutRtlSupport ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = zIsLayoutRtlSupport ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !viewIsOpaque(view)) {
            left = 0;
            right = 0;
            top = 0;
            bottom = 0;
        } else {
            left = view.getLeft();
            right = view.getRight();
            top = view.getTop();
            bottom = view.getBottom();
        }
        int childCount = getChildCount();
        int i = 0;
        while (i < childCount && (childAt = getChildAt(i)) != view2) {
            if (childAt.getVisibility() != 8) {
                childAt.setVisibility((Math.max(zIsLayoutRtlSupport ? paddingLeft : width, childAt.getLeft()) < left || Math.max(paddingTop, childAt.getTop()) < top || Math.min(zIsLayoutRtlSupport ? width : paddingLeft, childAt.getRight()) > right || Math.min(height, childAt.getBottom()) > bottom) ? 0 : 4);
            }
            i++;
            view2 = view;
            zIsLayoutRtlSupport = zIsLayoutRtlSupport;
        }
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new SlidingPaneLayout$LayoutParams(getContext(), attributeSet);
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSliderFadeColor = DEFAULT_FADE_COLOR;
        this.mFirstLayout = true;
        this.mTmpRect = new Rect();
        this.mPostedRunnables = new ArrayList<>();
        float f = context.getResources().getDisplayMetrics().density;
        this.mOverhangSize = (int) ((32.0f * f) + 0.5f);
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new SlidingPaneLayout$AccessibilityDelegate(this));
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewDragHelper viewDragHelperCreate = ViewDragHelper.create(this, 0.5f, new SlidingPaneLayout$DragHelperCallback(this));
        this.mDragHelper = viewDragHelperCreate;
        viewDragHelperCreate.setMinVelocity(f * 400.0f);
    }

    public boolean closePane() {
        return closePane(this.mSlideableView, 0);
    }

    public boolean openPane() {
        return openPane(this.mSlideableView, 0);
    }
}

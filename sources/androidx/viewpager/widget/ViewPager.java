package androidx.viewpager.widget;

import android.R$attr;
import android.content.Context;
import android.content.res.Resources$NotFoundException;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View$MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.annotation.CallSuper;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import b.d.b.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private int mActivePointerId;
    public PagerAdapter mAdapter;
    private List<ViewPager$OnAdapterChangeListener> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    public int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private ViewPager$OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<ViewPager$ItemInfo> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private ViewPager$PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private ViewPager$OnPageChangeListener mOnPageChangeListener;
    private List<ViewPager$OnPageChangeListener> mOnPageChangeListeners;
    private int mPageMargin;
    private ViewPager$PageTransformer mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffect mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final ViewPager$ItemInfo mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    public static final int[] LAYOUT_ATTRS = {R$attr.layout_gravity};
    private static final Comparator<ViewPager$ItemInfo> COMPARATOR = new ViewPager$1();
    private static final Interpolator sInterpolator = new ViewPager$2();
    private static final ViewPager$ViewPositionComparator sPositionComparator = new ViewPager$ViewPositionComparator();

    public ViewPager(@NonNull Context context) {
        super(context);
        this.mItems = new ArrayList<>();
        this.mTempItem = new ViewPager$ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new ViewPager$3(this);
        this.mScrollState = 0;
        initViewPager();
    }

    private void calculatePageOffsets(ViewPager$ItemInfo viewPager$ItemInfo, int i, ViewPager$ItemInfo viewPager$ItemInfo2) {
        int i2;
        int i3;
        ViewPager$ItemInfo viewPager$ItemInfo3;
        ViewPager$ItemInfo viewPager$ItemInfo4;
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? this.mPageMargin / clientWidth : 0.0f;
        if (viewPager$ItemInfo2 != null) {
            int i4 = viewPager$ItemInfo2.position;
            int i5 = viewPager$ItemInfo.position;
            if (i4 < i5) {
                float pageWidth = viewPager$ItemInfo2.offset + viewPager$ItemInfo2.widthFactor + f;
                int i6 = i4 + 1;
                int i7 = 0;
                while (i6 <= viewPager$ItemInfo.position && i7 < this.mItems.size()) {
                    ViewPager$ItemInfo viewPager$ItemInfo5 = this.mItems.get(i7);
                    while (true) {
                        viewPager$ItemInfo4 = viewPager$ItemInfo5;
                        if (i6 <= viewPager$ItemInfo4.position || i7 >= this.mItems.size() - 1) {
                            break;
                        }
                        i7++;
                        viewPager$ItemInfo5 = this.mItems.get(i7);
                    }
                    while (i6 < viewPager$ItemInfo4.position) {
                        pageWidth += this.mAdapter.getPageWidth(i6) + f;
                        i6++;
                    }
                    viewPager$ItemInfo4.offset = pageWidth;
                    pageWidth += viewPager$ItemInfo4.widthFactor + f;
                    i6++;
                }
            } else if (i4 > i5) {
                int size = this.mItems.size() - 1;
                float pageWidth2 = viewPager$ItemInfo2.offset;
                while (true) {
                    i4--;
                    if (i4 < viewPager$ItemInfo.position || size < 0) {
                        break;
                    }
                    ViewPager$ItemInfo viewPager$ItemInfo6 = this.mItems.get(size);
                    while (true) {
                        viewPager$ItemInfo3 = viewPager$ItemInfo6;
                        if (i4 >= viewPager$ItemInfo3.position || size <= 0) {
                            break;
                        }
                        size--;
                        viewPager$ItemInfo6 = this.mItems.get(size);
                    }
                    while (i4 > viewPager$ItemInfo3.position) {
                        pageWidth2 -= this.mAdapter.getPageWidth(i4) + f;
                        i4--;
                    }
                    pageWidth2 -= viewPager$ItemInfo3.widthFactor + f;
                    viewPager$ItemInfo3.offset = pageWidth2;
                }
            }
        }
        int size2 = this.mItems.size();
        float pageWidth3 = viewPager$ItemInfo.offset;
        int i8 = viewPager$ItemInfo.position;
        int i9 = i8 - 1;
        this.mFirstOffset = i8 == 0 ? pageWidth3 : -3.4028235E38f;
        int i10 = count - 1;
        this.mLastOffset = i8 == i10 ? (viewPager$ItemInfo.widthFactor + pageWidth3) - 1.0f : Float.MAX_VALUE;
        int i11 = i - 1;
        while (i11 >= 0) {
            ViewPager$ItemInfo viewPager$ItemInfo7 = this.mItems.get(i11);
            while (true) {
                i3 = viewPager$ItemInfo7.position;
                if (i9 <= i3) {
                    break;
                }
                pageWidth3 -= this.mAdapter.getPageWidth(i9) + f;
                i9--;
            }
            pageWidth3 -= viewPager$ItemInfo7.widthFactor + f;
            viewPager$ItemInfo7.offset = pageWidth3;
            if (i3 == 0) {
                this.mFirstOffset = pageWidth3;
            }
            i11--;
            i9--;
        }
        float pageWidth4 = viewPager$ItemInfo.offset + viewPager$ItemInfo.widthFactor + f;
        int i12 = viewPager$ItemInfo.position + 1;
        int i13 = i + 1;
        while (i13 < size2) {
            ViewPager$ItemInfo viewPager$ItemInfo8 = this.mItems.get(i13);
            while (true) {
                i2 = viewPager$ItemInfo8.position;
                if (i12 >= i2) {
                    break;
                }
                pageWidth4 += this.mAdapter.getPageWidth(i12) + f;
                i12++;
            }
            if (i2 == i10) {
                this.mLastOffset = (viewPager$ItemInfo8.widthFactor + pageWidth4) - 1.0f;
            }
            viewPager$ItemInfo8.offset = pageWidth4;
            pageWidth4 += viewPager$ItemInfo8.widthFactor + f;
            i13++;
            i12++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    private void completeScroll(boolean z2) {
        boolean z3 = this.mScrollState == 2;
        if (z3) {
            setScrollingCacheEnabled(false);
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        pageScrolled(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        for (int i = 0; i < this.mItems.size(); i++) {
            ViewPager$ItemInfo viewPager$ItemInfo = this.mItems.get(i);
            if (viewPager$ItemInfo.scrolling) {
                viewPager$ItemInfo.scrolling = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z2) {
                ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
            } else {
                this.mEndScrollRunnable.run();
            }
        }
    }

    private int determineTargetPage(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.mFlingDistance || Math.abs(i2) <= this.mMinimumVelocity) {
            i += (int) (f + (i >= this.mCurItem ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.mItems.size() <= 0) {
            return i;
        }
        ViewPager$ItemInfo viewPager$ItemInfo = this.mItems.get(0);
        ArrayList<ViewPager$ItemInfo> arrayList = this.mItems;
        return Math.max(viewPager$ItemInfo.position, Math.min(i, arrayList.get(arrayList.size() - 1).position));
    }

    private void dispatchOnPageScrolled(int i, float f, int i2) {
        ViewPager$OnPageChangeListener viewPager$OnPageChangeListener = this.mOnPageChangeListener;
        if (viewPager$OnPageChangeListener != null) {
            viewPager$OnPageChangeListener.onPageScrolled(i, f, i2);
        }
        List<ViewPager$OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewPager$OnPageChangeListener viewPager$OnPageChangeListener2 = this.mOnPageChangeListeners.get(i3);
                if (viewPager$OnPageChangeListener2 != null) {
                    viewPager$OnPageChangeListener2.onPageScrolled(i, f, i2);
                }
            }
        }
        ViewPager$OnPageChangeListener viewPager$OnPageChangeListener3 = this.mInternalPageChangeListener;
        if (viewPager$OnPageChangeListener3 != null) {
            viewPager$OnPageChangeListener3.onPageScrolled(i, f, i2);
        }
    }

    private void dispatchOnPageSelected(int i) {
        ViewPager$OnPageChangeListener viewPager$OnPageChangeListener = this.mOnPageChangeListener;
        if (viewPager$OnPageChangeListener != null) {
            viewPager$OnPageChangeListener.onPageSelected(i);
        }
        List<ViewPager$OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ViewPager$OnPageChangeListener viewPager$OnPageChangeListener2 = this.mOnPageChangeListeners.get(i2);
                if (viewPager$OnPageChangeListener2 != null) {
                    viewPager$OnPageChangeListener2.onPageSelected(i);
                }
            }
        }
        ViewPager$OnPageChangeListener viewPager$OnPageChangeListener3 = this.mInternalPageChangeListener;
        if (viewPager$OnPageChangeListener3 != null) {
            viewPager$OnPageChangeListener3.onPageSelected(i);
        }
    }

    private void dispatchOnScrollStateChanged(int i) {
        ViewPager$OnPageChangeListener viewPager$OnPageChangeListener = this.mOnPageChangeListener;
        if (viewPager$OnPageChangeListener != null) {
            viewPager$OnPageChangeListener.onPageScrollStateChanged(i);
        }
        List<ViewPager$OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ViewPager$OnPageChangeListener viewPager$OnPageChangeListener2 = this.mOnPageChangeListeners.get(i2);
                if (viewPager$OnPageChangeListener2 != null) {
                    viewPager$OnPageChangeListener2.onPageScrollStateChanged(i);
                }
            }
        }
        ViewPager$OnPageChangeListener viewPager$OnPageChangeListener3 = this.mInternalPageChangeListener;
        if (viewPager$OnPageChangeListener3 != null) {
            viewPager$OnPageChangeListener3.onPageScrollStateChanged(i);
        }
    }

    private void enableLayers(boolean z2) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z2 ? this.mPageTransformerLayerType : 0, null);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private ViewPager$ItemInfo infoForCurrentScrollPosition() {
        int i;
        int clientWidth = getClientWidth();
        float f = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.mPageMargin / clientWidth : 0.0f;
        ViewPager$ItemInfo viewPager$ItemInfo = null;
        float f3 = 0.0f;
        int i2 = -1;
        int i3 = 0;
        boolean z2 = true;
        while (i3 < this.mItems.size()) {
            ViewPager$ItemInfo viewPager$ItemInfo2 = this.mItems.get(i3);
            if (!z2 && viewPager$ItemInfo2.position != (i = i2 + 1)) {
                viewPager$ItemInfo2 = this.mTempItem;
                viewPager$ItemInfo2.offset = f + f3 + f2;
                viewPager$ItemInfo2.position = i;
                viewPager$ItemInfo2.widthFactor = this.mAdapter.getPageWidth(i);
                i3--;
            }
            f = viewPager$ItemInfo2.offset;
            float f4 = viewPager$ItemInfo2.widthFactor + f + f2;
            if (!z2 && scrollX < f) {
                return viewPager$ItemInfo;
            }
            if (scrollX < f4 || i3 == this.mItems.size() - 1) {
                return viewPager$ItemInfo2;
            }
            i2 = viewPager$ItemInfo2.position;
            f3 = viewPager$ItemInfo2.widthFactor;
            i3++;
            viewPager$ItemInfo = viewPager$ItemInfo2;
            z2 = false;
        }
        return viewPager$ItemInfo;
    }

    private static boolean isDecorView(@NonNull View view) {
        return view.getClass().getAnnotation(ViewPager$DecorView.class) != null;
    }

    private boolean isGutterDrag(float f, float f2) {
        return (f < ((float) this.mGutterSize) && f2 > 0.0f) || (f > ((float) (getWidth() - this.mGutterSize)) && f2 < 0.0f);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = motionEvent.getX(i);
            this.mActivePointerId = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean pageScrolled(int i) {
        if (this.mItems.size() == 0) {
            if (this.mFirstLayout) {
                return false;
            }
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ViewPager$ItemInfo viewPager$ItemInfoInfoForCurrentScrollPosition = infoForCurrentScrollPosition();
        int clientWidth = getClientWidth();
        int i2 = this.mPageMargin;
        int i3 = clientWidth + i2;
        float f = clientWidth;
        int i4 = viewPager$ItemInfoInfoForCurrentScrollPosition.position;
        float f2 = ((i / f) - viewPager$ItemInfoInfoForCurrentScrollPosition.offset) / (viewPager$ItemInfoInfoForCurrentScrollPosition.widthFactor + (i2 / f));
        this.mCalledSuper = false;
        onPageScrolled(i4, f2, (int) (i3 * f2));
        if (this.mCalledSuper) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean performDrag(float f) {
        boolean z2;
        boolean z3;
        float f2 = this.mLastMotionX - f;
        this.mLastMotionX = f;
        float scrollX = getScrollX() + f2;
        float clientWidth = getClientWidth();
        float f3 = this.mFirstOffset * clientWidth;
        float f4 = this.mLastOffset * clientWidth;
        boolean z4 = false;
        ViewPager$ItemInfo viewPager$ItemInfo = this.mItems.get(0);
        ArrayList<ViewPager$ItemInfo> arrayList = this.mItems;
        ViewPager$ItemInfo viewPager$ItemInfo2 = arrayList.get(arrayList.size() - 1);
        if (viewPager$ItemInfo.position != 0) {
            f3 = viewPager$ItemInfo.offset * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (viewPager$ItemInfo2.position != this.mAdapter.getCount() - 1) {
            f4 = viewPager$ItemInfo2.offset * clientWidth;
            z3 = false;
        } else {
            z3 = true;
        }
        if (scrollX < f3) {
            if (z2) {
                this.mLeftEdge.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z4 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z3) {
                this.mRightEdge.onPull(Math.abs(scrollX - f4) / clientWidth);
                z4 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.mLastMotionX = (scrollX - i) + this.mLastMotionX;
        scrollTo(i, getScrollY());
        pageScrolled(i);
        return z4;
    }

    private void recomputeScrollPosition(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.mItems.isEmpty()) {
            if (!this.mScroller.isFinished()) {
                this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
                return;
            }
        }
        ViewPager$ItemInfo viewPager$ItemInfoInfoForPosition = infoForPosition(this.mCurItem);
        int iMin = (int) ((viewPager$ItemInfoInfoForPosition != null ? Math.min(viewPager$ItemInfoInfoForPosition.offset, this.mLastOffset) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            completeScroll(false);
            scrollTo(iMin, getScrollY());
        }
    }

    private void removeNonDecorViews() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((ViewPager$LayoutParams) getChildAt(i).getLayoutParams()).isDecor) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z2) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z2);
        }
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        endDrag();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        return this.mLeftEdge.isFinished() || this.mRightEdge.isFinished();
    }

    private void scrollToItem(int i, boolean z2, int i2, boolean z3) {
        int iMax;
        ViewPager$ItemInfo viewPager$ItemInfoInfoForPosition = infoForPosition(i);
        if (viewPager$ItemInfoInfoForPosition != null) {
            iMax = (int) (Math.max(this.mFirstOffset, Math.min(viewPager$ItemInfoInfoForPosition.offset, this.mLastOffset)) * getClientWidth());
        } else {
            iMax = 0;
        }
        if (z2) {
            smoothScrollTo(iMax, 0, i2);
            if (z3) {
                dispatchOnPageSelected(i);
                return;
            }
            return;
        }
        if (z3) {
            dispatchOnPageSelected(i);
        }
        completeScroll(false);
        scrollTo(iMax, 0);
        pageScrolled(iMax);
    }

    private void setScrollingCacheEnabled(boolean z2) {
        if (this.mScrollingCacheEnabled != z2) {
            this.mScrollingCacheEnabled = z2;
        }
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            ArrayList<View> arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.mDrawingOrderedChildren.add(getChildAt(i));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        ViewPager$ItemInfo viewPager$ItemInfoInfoForChild;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (viewPager$ItemInfoInfoForChild = infoForChild(childAt)) != null && viewPager$ItemInfoInfoForChild.position == this.mCurItem) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    public ViewPager$ItemInfo addNewItem(int i, int i2) {
        ViewPager$ItemInfo viewPager$ItemInfo = new ViewPager$ItemInfo();
        viewPager$ItemInfo.position = i;
        viewPager$ItemInfo.object = this.mAdapter.instantiateItem((ViewGroup) this, i);
        viewPager$ItemInfo.widthFactor = this.mAdapter.getPageWidth(i);
        if (i2 < 0 || i2 >= this.mItems.size()) {
            this.mItems.add(viewPager$ItemInfo);
        } else {
            this.mItems.add(i2, viewPager$ItemInfo);
        }
        return viewPager$ItemInfo;
    }

    public void addOnAdapterChangeListener(@NonNull ViewPager$OnAdapterChangeListener viewPager$OnAdapterChangeListener) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(viewPager$OnAdapterChangeListener);
    }

    public void addOnPageChangeListener(@NonNull ViewPager$OnPageChangeListener viewPager$OnPageChangeListener) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(viewPager$OnPageChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        ViewPager$ItemInfo viewPager$ItemInfoInfoForChild;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (viewPager$ItemInfoInfoForChild = infoForChild(childAt)) != null && viewPager$ItemInfoInfoForChild.position == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (!checkLayoutParams(viewGroup$LayoutParams)) {
            viewGroup$LayoutParams = generateLayoutParams(viewGroup$LayoutParams);
        }
        ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams) viewGroup$LayoutParams;
        boolean zIsDecorView = viewPager$LayoutParams.isDecor | isDecorView(view);
        viewPager$LayoutParams.isDecor = zIsDecorView;
        if (!this.mInLayout) {
            super.addView(view, i, viewGroup$LayoutParams);
        } else {
            if (zIsDecorView) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            viewPager$LayoutParams.needsMeasure = true;
            addViewInLayout(view, i, viewGroup$LayoutParams);
        }
    }

    public boolean arrowScroll(int i) {
        boolean zRequestFocus;
        boolean z2;
        View viewFindFocus = findFocus();
        boolean zPageLeft = false;
        if (viewFindFocus == this) {
            viewFindFocus = null;
        } else if (viewFindFocus != null) {
            ViewParent parent = viewFindFocus.getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    z2 = false;
                    break;
                }
                if (parent == this) {
                    z2 = true;
                    break;
                }
                parent = parent.getParent();
            }
            if (!z2) {
                StringBuilder sb = new StringBuilder();
                sb.append(viewFindFocus.getClass().getSimpleName());
                for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(" => ");
                    sb.append(parent2.getClass().getSimpleName());
                }
                StringBuilder sbU = a.U("arrowScroll tried to find focus based on non-child current focused view ");
                sbU.append(sb.toString());
                Log.e(TAG, sbU.toString());
                viewFindFocus = null;
            }
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i);
        if (viewFindNextFocus != null && viewFindNextFocus != viewFindFocus) {
            if (i == 17) {
                zRequestFocus = (viewFindFocus == null || getChildRectInPagerCoordinates(this.mTempRect, viewFindNextFocus).left < getChildRectInPagerCoordinates(this.mTempRect, viewFindFocus).left) ? viewFindNextFocus.requestFocus() : pageLeft();
            } else if (i == 66) {
                zRequestFocus = (viewFindFocus == null || getChildRectInPagerCoordinates(this.mTempRect, viewFindNextFocus).left > getChildRectInPagerCoordinates(this.mTempRect, viewFindFocus).left) ? viewFindNextFocus.requestFocus() : pageRight();
            }
            zPageLeft = zRequestFocus;
        } else if (i == 17 || i == 1) {
            zPageLeft = pageLeft();
        } else if (i == 66 || i == 2) {
            zPageLeft = pageRight();
        }
        if (zPageLeft) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return zPageLeft;
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(motionEventObtain);
        motionEventObtain.recycle();
        this.mFakeDragBeginTime = jUptimeMillis;
        return true;
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
        return z2 && view.canScrollHorizontally(-i);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.mAdapter == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            return scrollX > ((int) (((float) clientWidth) * this.mFirstOffset));
        }
        return i > 0 && scrollX < ((int) (((float) clientWidth) * this.mLastOffset));
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return (viewGroup$LayoutParams instanceof ViewPager$LayoutParams) && super.checkLayoutParams(viewGroup$LayoutParams);
    }

    public void clearOnPageChangeListeners() {
        List<ViewPager$OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void dataSetChanged() {
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        boolean z2 = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count;
        int iMax = this.mCurItem;
        int i = 0;
        boolean z3 = false;
        while (i < this.mItems.size()) {
            ViewPager$ItemInfo viewPager$ItemInfo = this.mItems.get(i);
            int itemPosition = this.mAdapter.getItemPosition(viewPager$ItemInfo.object);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i);
                    i--;
                    if (!z3) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z3 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, viewPager$ItemInfo.position, viewPager$ItemInfo.object);
                    int i2 = this.mCurItem;
                    if (i2 == viewPager$ItemInfo.position) {
                        iMax = Math.max(0, Math.min(i2, count - 1));
                    }
                } else {
                    int i3 = viewPager$ItemInfo.position;
                    if (i3 != itemPosition) {
                        if (i3 == this.mCurItem) {
                            iMax = itemPosition;
                        }
                        viewPager$ItemInfo.position = itemPosition;
                    }
                }
                z2 = true;
            }
            i++;
        }
        if (z3) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z2) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams) getChildAt(i4).getLayoutParams();
                if (!viewPager$LayoutParams.isDecor) {
                    viewPager$LayoutParams.widthFactor = 0.0f;
                }
            }
            setCurrentItemInternal(iMax, false, true);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ViewPager$ItemInfo viewPager$ItemInfoInfoForChild;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (viewPager$ItemInfoInfoForChild = infoForChild(childAt)) != null && viewPager$ItemInfoInfoForChild.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    public float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (pagerAdapter = this.mAdapter) != null && pagerAdapter.getCount() > 1)) {
            if (!this.mLeftEdge.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate(getPaddingTop() + (-height), this.mFirstOffset * width);
                this.mLeftEdge.setSize(height, width);
                zDraw = false | this.mLeftEdge.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.mRightEdge.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.mLastOffset + 1.0f)) * width2);
                this.mRightEdge.setSize(height2, width2);
                zDraw |= this.mRightEdge.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        }
        if (zDraw) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public void endFakeDrag() {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.mAdapter != null) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
            this.mPopulatePending = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            ViewPager$ItemInfo viewPager$ItemInfoInfoForCurrentScrollPosition = infoForCurrentScrollPosition();
            setCurrentItemInternal(determineTargetPage(viewPager$ItemInfoInfoForCurrentScrollPosition.position, ((scrollX / clientWidth) - viewPager$ItemInfoInfoForCurrentScrollPosition.offset) / viewPager$ItemInfoInfoForCurrentScrollPosition.widthFactor, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
        }
        endDrag();
        this.mFakeDragging = false;
    }

    public boolean executeKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return keyEvent.hasModifiers(2) ? pageLeft() : arrowScroll(17);
            }
            if (keyCode == 22) {
                return keyEvent.hasModifiers(2) ? pageRight() : arrowScroll(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return arrowScroll(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return arrowScroll(1);
                }
            }
        }
        return false;
    }

    public void fakeDragBy(float f) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.mAdapter == null) {
            return;
        }
        this.mLastMotionX += f;
        float scrollX = getScrollX() - f;
        float clientWidth = getClientWidth();
        float f2 = this.mFirstOffset * clientWidth;
        float f3 = this.mLastOffset * clientWidth;
        ViewPager$ItemInfo viewPager$ItemInfo = this.mItems.get(0);
        ArrayList<ViewPager$ItemInfo> arrayList = this.mItems;
        ViewPager$ItemInfo viewPager$ItemInfo2 = arrayList.get(arrayList.size() - 1);
        if (viewPager$ItemInfo.position != 0) {
            f2 = viewPager$ItemInfo.offset * clientWidth;
        }
        if (viewPager$ItemInfo2.position != this.mAdapter.getCount() - 1) {
            f3 = viewPager$ItemInfo2.offset * clientWidth;
        }
        if (scrollX < f2) {
            scrollX = f2;
        } else if (scrollX > f3) {
            scrollX = f3;
        }
        int i = (int) scrollX;
        this.mLastMotionX = (scrollX - i) + this.mLastMotionX;
        scrollTo(i, getScrollY());
        pageScrolled(i);
        MotionEvent motionEventObtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
        this.mVelocityTracker.addMovement(motionEventObtain);
        motionEventObtain.recycle();
    }

    @Override // android.view.ViewGroup
    public ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return new ViewPager$LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return generateDefaultLayoutParams();
    }

    @Nullable
    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        if (this.mDrawingOrder == 2) {
            i2 = (i - 1) - i2;
        }
        return ((ViewPager$LayoutParams) this.mDrawingOrderedChildren.get(i2).getLayoutParams()).childIndex;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public ViewPager$ItemInfo infoForAnyChild(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return infoForChild(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    public ViewPager$ItemInfo infoForChild(View view) {
        for (int i = 0; i < this.mItems.size(); i++) {
            ViewPager$ItemInfo viewPager$ItemInfo = this.mItems.get(i);
            if (this.mAdapter.isViewFromObject(view, viewPager$ItemInfo.object)) {
                return viewPager$ItemInfo;
            }
        }
        return null;
    }

    public ViewPager$ItemInfo infoForPosition(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            ViewPager$ItemInfo viewPager$ItemInfo = this.mItems.get(i2);
            if (viewPager$ItemInfo.position == i) {
                return viewPager$ItemInfo;
            }
        }
        return null;
    }

    public void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context);
        this.mRightEdge = new EdgeEffect(context);
        this.mFlingDistance = (int) (25.0f * f);
        this.mCloseEnough = (int) (2.0f * f);
        this.mDefaultGutterSize = (int) (f * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new ViewPager$MyAccessibilityDelegate(this));
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, new ViewPager$4(this));
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        float f;
        super.onDraw(canvas);
        if (this.mPageMargin <= 0 || this.mMarginDrawable == null || this.mItems.size() <= 0 || this.mAdapter == null) {
            return;
        }
        int scrollX = getScrollX();
        int width = getWidth();
        float f2 = width;
        float f3 = this.mPageMargin / f2;
        int i2 = 0;
        ViewPager$ItemInfo viewPager$ItemInfo = this.mItems.get(0);
        float f4 = viewPager$ItemInfo.offset;
        int size = this.mItems.size();
        int i3 = viewPager$ItemInfo.position;
        int i4 = this.mItems.get(size - 1).position;
        while (i3 < i4) {
            while (true) {
                i = viewPager$ItemInfo.position;
                if (i3 <= i || i2 >= size) {
                    break;
                }
                i2++;
                viewPager$ItemInfo = this.mItems.get(i2);
            }
            if (i3 == i) {
                float f5 = viewPager$ItemInfo.offset;
                float f6 = viewPager$ItemInfo.widthFactor;
                f = (f5 + f6) * f2;
                f4 = f5 + f6 + f3;
            } else {
                float pageWidth = this.mAdapter.getPageWidth(i3);
                f = (f4 + pageWidth) * f2;
                f4 = pageWidth + f3 + f4;
            }
            if (this.mPageMargin + f > scrollX) {
                this.mMarginDrawable.setBounds(Math.round(f), this.mTopPageBounds, Math.round(this.mPageMargin + f), this.mBottomPageBounds);
                this.mMarginDrawable.draw(canvas);
            }
            if (f > scrollX + width) {
                return;
            }
            i3++;
            f3 = f3;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            resetTouch();
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        if (action == 0) {
            float x2 = motionEvent.getX();
            this.mInitialMotionX = x2;
            this.mLastMotionX = x2;
            float y2 = motionEvent.getY();
            this.mInitialMotionY = y2;
            this.mLastMotionY = y2;
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mIsUnableToDrag = false;
            this.mIsScrollStarted = true;
            this.mScroller.computeScrollOffset();
            if (this.mScrollState != 2 || Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) <= this.mCloseEnough) {
                completeScroll(false);
                this.mIsBeingDragged = false;
            } else {
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                this.mIsBeingDragged = true;
                requestParentDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i = this.mActivePointerId;
            if (i != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i);
                float x3 = motionEvent.getX(iFindPointerIndex);
                float f = x3 - this.mLastMotionX;
                float fAbs = Math.abs(f);
                float y3 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y3 - this.mInitialMotionY);
                if (f != 0.0f && !isGutterDrag(this.mLastMotionX, f) && canScroll(this, false, (int) f, (int) x3, (int) y3)) {
                    this.mLastMotionX = x3;
                    this.mLastMotionY = y3;
                    this.mIsUnableToDrag = true;
                    return false;
                }
                int i2 = this.mTouchSlop;
                if (fAbs > i2 && fAbs * 0.5f > fAbs2) {
                    this.mIsBeingDragged = true;
                    requestParentDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    float f2 = this.mInitialMotionX;
                    float f3 = this.mTouchSlop;
                    this.mLastMotionX = f > 0.0f ? f2 + f3 : f2 - f3;
                    this.mLastMotionY = y3;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i2) {
                    this.mIsUnableToDrag = true;
                }
                if (this.mIsBeingDragged && performDrag(x3)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
            }
        } else if (action == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        return this.mIsBeingDragged;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0071  */
    /* JADX WARN: Code duplicated, block: B:24:0x0075  */
    /* JADX WARN: Code duplicated, block: B:26:0x0079  */
    /* JADX WARN: Code duplicated, block: B:27:0x007b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0088  */
    /* JADX WARN: Code duplicated, block: B:29:0x008e  */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        boolean z3;
        ViewPager$ItemInfo viewPager$ItemInfoInfoForChild;
        int iMax;
        int measuredWidth;
        int iMax2;
        int measuredHeight;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams) childAt.getLayoutParams();
                if (viewPager$LayoutParams.isDecor) {
                    int i9 = viewPager$LayoutParams.gravity;
                    int i10 = i9 & 7;
                    int i11 = i9 & 112;
                    if (i10 != 1) {
                        if (i10 == 3) {
                            measuredWidth = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i10 != 5) {
                            measuredWidth = paddingLeft;
                        } else {
                            iMax = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i11 != 16) {
                            if (i11 != 48) {
                                measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i11 != 80) {
                                measuredHeight = paddingTop;
                            } else {
                                iMax2 = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i12 = paddingLeft + scrollX;
                            childAt.layout(i12, paddingTop, childAt.getMeasuredWidth() + i12, childAt.getMeasuredHeight() + paddingTop);
                            i7++;
                            paddingTop = measuredHeight;
                            paddingLeft = measuredWidth;
                        } else {
                            iMax2 = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i13 = iMax2;
                        measuredHeight = paddingTop;
                        paddingTop = i13;
                        int i14 = paddingLeft + scrollX;
                        childAt.layout(i14, paddingTop, childAt.getMeasuredWidth() + i14, childAt.getMeasuredHeight() + paddingTop);
                        i7++;
                        paddingTop = measuredHeight;
                        paddingLeft = measuredWidth;
                    } else {
                        iMax = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i15 = iMax;
                    measuredWidth = paddingLeft;
                    paddingLeft = i15;
                    if (i11 != 16) {
                        if (i11 != 48) {
                            measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                        } else if (i11 != 80) {
                            measuredHeight = paddingTop;
                        } else {
                            iMax2 = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                        }
                        int i16 = paddingLeft + scrollX;
                        childAt.layout(i16, paddingTop, childAt.getMeasuredWidth() + i16, childAt.getMeasuredHeight() + paddingTop);
                        i7++;
                        paddingTop = measuredHeight;
                        paddingLeft = measuredWidth;
                    } else {
                        iMax2 = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                    }
                    int i17 = iMax2;
                    measuredHeight = paddingTop;
                    paddingTop = i17;
                    int i18 = paddingLeft + scrollX;
                    childAt.layout(i18, paddingTop, childAt.getMeasuredWidth() + i18, childAt.getMeasuredHeight() + paddingTop);
                    i7++;
                    paddingTop = measuredHeight;
                    paddingLeft = measuredWidth;
                }
            }
        }
        int i19 = (i5 - paddingLeft) - paddingRight;
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt2 = getChildAt(i20);
            if (childAt2.getVisibility() != 8) {
                ViewPager$LayoutParams viewPager$LayoutParams2 = (ViewPager$LayoutParams) childAt2.getLayoutParams();
                if (!viewPager$LayoutParams2.isDecor && (viewPager$ItemInfoInfoForChild = infoForChild(childAt2)) != null) {
                    float f = i19;
                    int i21 = ((int) (viewPager$ItemInfoInfoForChild.offset * f)) + paddingLeft;
                    if (viewPager$LayoutParams2.needsMeasure) {
                        viewPager$LayoutParams2.needsMeasure = false;
                        childAt2.measure(View$MeasureSpec.makeMeasureSpec((int) (f * viewPager$LayoutParams2.widthFactor), BasicMeasure.EXACTLY), View$MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, BasicMeasure.EXACTLY));
                    }
                    childAt2.layout(i21, paddingTop, childAt2.getMeasuredWidth() + i21, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.mTopPageBounds = paddingTop;
        this.mBottomPageBounds = i6 - paddingBottom;
        this.mDecorChildCount = i7;
        if (this.mFirstLayout) {
            z3 = false;
            scrollToItem(this.mCurItem, false, 0, false);
        } else {
            z3 = false;
        }
        this.mFirstLayout = z3;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0082 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x0085  */
    /* JADX WARN: Code duplicated, block: B:36:0x0089  */
    /* JADX WARN: Code duplicated, block: B:39:0x008e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x0091  */
    /* JADX WARN: Code duplicated, block: B:42:0x0093  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:66:0x00af A[SYNTHETIC] */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        ViewPager$LayoutParams viewPager$LayoutParams;
        ViewPager$LayoutParams viewPager$LayoutParams2;
        int i3;
        int i4;
        int i5;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, i), ViewGroup.getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            boolean z2 = true;
            int i7 = BasicMeasure.EXACTLY;
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && (viewPager$LayoutParams2 = (ViewPager$LayoutParams) childAt.getLayoutParams()) != null && viewPager$LayoutParams2.isDecor) {
                int i8 = viewPager$LayoutParams2.gravity;
                int i9 = i8 & 7;
                int i10 = i8 & 112;
                boolean z3 = i10 == 48 || i10 == 80;
                if (i9 != 3 && i9 != 5) {
                    z2 = false;
                }
                int i11 = Integer.MIN_VALUE;
                if (z3) {
                    i11 = BasicMeasure.EXACTLY;
                } else {
                    i3 = z2 ? BasicMeasure.EXACTLY : Integer.MIN_VALUE;
                    i4 = ((ViewGroup$LayoutParams) viewPager$LayoutParams2).width;
                    if (i4 != -2) {
                        if (i4 == -1) {
                            i4 = paddingLeft;
                        }
                        i11 = BasicMeasure.EXACTLY;
                    } else {
                        i4 = paddingLeft;
                    }
                    i5 = ((ViewGroup$LayoutParams) viewPager$LayoutParams2).height;
                    if (i5 != -2) {
                        i5 = measuredHeight;
                        i7 = i3;
                    } else if (i5 == -1) {
                        i5 = measuredHeight;
                    }
                    childAt.measure(View$MeasureSpec.makeMeasureSpec(i4, i11), View$MeasureSpec.makeMeasureSpec(i5, i7));
                    if (z3) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (z2) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
                i4 = ((ViewGroup$LayoutParams) viewPager$LayoutParams2).width;
                if (i4 != -2) {
                    if (i4 == -1) {
                        i4 = paddingLeft;
                    }
                    i11 = BasicMeasure.EXACTLY;
                } else {
                    i4 = paddingLeft;
                }
                i5 = ((ViewGroup$LayoutParams) viewPager$LayoutParams2).height;
                if (i5 != -2) {
                    i5 = measuredHeight;
                    i7 = i3;
                } else if (i5 == -1) {
                    i5 = measuredHeight;
                }
                childAt.measure(View$MeasureSpec.makeMeasureSpec(i4, i11), View$MeasureSpec.makeMeasureSpec(i5, i7));
                if (z3) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z2) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i6++;
        }
        this.mChildWidthMeasureSpec = View$MeasureSpec.makeMeasureSpec(paddingLeft, BasicMeasure.EXACTLY);
        this.mChildHeightMeasureSpec = View$MeasureSpec.makeMeasureSpec(measuredHeight, BasicMeasure.EXACTLY);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount2 = getChildCount();
        for (int i12 = 0; i12 < childCount2; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8 && ((viewPager$LayoutParams = (ViewPager$LayoutParams) childAt2.getLayoutParams()) == null || !viewPager$LayoutParams.isDecor)) {
                childAt2.measure(View$MeasureSpec.makeMeasureSpec((int) (paddingLeft * viewPager$LayoutParams.widthFactor), BasicMeasure.EXACTLY), this.mChildHeightMeasureSpec);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0064  */
    @CallSuper
    public void onPageScrolled(int i, float f, int i2) {
        int iMax;
        int width;
        int left;
        if (this.mDecorChildCount > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width2 = getWidth();
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams) childAt.getLayoutParams();
                if (viewPager$LayoutParams.isDecor) {
                    int i4 = viewPager$LayoutParams.gravity & 7;
                    if (i4 != 1) {
                        if (i4 == 3) {
                            width = childAt.getWidth() + paddingLeft;
                        } else if (i4 != 5) {
                            width = paddingLeft;
                        } else {
                            iMax = (width2 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = width;
                    } else {
                        iMax = Math.max((width2 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i5 = iMax;
                    width = paddingLeft;
                    paddingLeft = i5;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                    paddingLeft = width;
                }
            }
        }
        dispatchOnPageScrolled(i, f, i2);
        if (this.mPageTransformer != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i6 = 0; i6 < childCount2; i6++) {
                View childAt2 = getChildAt(i6);
                if (!((ViewPager$LayoutParams) childAt2.getLayoutParams()).isDecor) {
                    this.mPageTransformer.transformPage(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.mCalledSuper = true;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        ViewPager$ItemInfo viewPager$ItemInfoInfoForChild;
        int childCount = getChildCount();
        int i4 = -1;
        if ((i & 2) != 0) {
            i4 = childCount;
            i2 = 0;
            i3 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
        }
        while (i2 != i4) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (viewPager$ItemInfoInfoForChild = infoForChild(childAt)) != null && viewPager$ItemInfoInfoForChild.position == this.mCurItem && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ViewPager$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ViewPager$SavedState viewPager$SavedState = (ViewPager$SavedState) parcelable;
        super.onRestoreInstanceState(viewPager$SavedState.getSuperState());
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(viewPager$SavedState.adapterState, viewPager$SavedState.loader);
            setCurrentItemInternal(viewPager$SavedState.position, false, true);
        } else {
            this.mRestoredCurItem = viewPager$SavedState.position;
            this.mRestoredAdapterState = viewPager$SavedState.adapterState;
            this.mRestoredClassLoader = viewPager$SavedState.loader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        ViewPager$SavedState viewPager$SavedState = new ViewPager$SavedState(super.onSaveInstanceState());
        viewPager$SavedState.position = this.mCurItem;
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            viewPager$SavedState.adapterState = pagerAdapter.saveState();
        }
        return viewPager$SavedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.mPageMargin;
            recomputeScrollPosition(i, i3, i5, i5);
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00dc  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        if (this.mFakeDragging) {
            return true;
        }
        boolean zResetTouch = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.mAdapter) == null || pagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.mScroller.abortAnimation();
            this.mPopulatePending = false;
            populate();
            float x2 = motionEvent.getX();
            this.mInitialMotionX = x2;
            this.mLastMotionX = x2;
            float y2 = motionEvent.getY();
            this.mInitialMotionY = y2;
            this.mLastMotionY = y2;
            this.mActivePointerId = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.mLastMotionX = motionEvent.getX(actionIndex);
                        this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        onSecondaryPointerUp(motionEvent);
                        this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                    }
                } else if (this.mIsBeingDragged) {
                    scrollToItem(this.mCurItem, true, 0, false);
                    zResetTouch = resetTouch();
                }
            } else if (!this.mIsBeingDragged) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (iFindPointerIndex == -1) {
                    zResetTouch = resetTouch();
                } else {
                    float x3 = motionEvent.getX(iFindPointerIndex);
                    float fAbs = Math.abs(x3 - this.mLastMotionX);
                    float y3 = motionEvent.getY(iFindPointerIndex);
                    float fAbs2 = Math.abs(y3 - this.mLastMotionY);
                    if (fAbs > this.mTouchSlop && fAbs > fAbs2) {
                        this.mIsBeingDragged = true;
                        requestParentDisallowInterceptTouchEvent(true);
                        float f = this.mInitialMotionX;
                        this.mLastMotionX = x3 - f > 0.0f ? f + this.mTouchSlop : f - this.mTouchSlop;
                        this.mLastMotionY = y3;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (this.mIsBeingDragged) {
                        zResetTouch = false | performDrag(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)));
                    }
                }
            } else if (this.mIsBeingDragged) {
                zResetTouch = false | performDrag(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)));
            }
        } else if (this.mIsBeingDragged) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
            this.mPopulatePending = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            ViewPager$ItemInfo viewPager$ItemInfoInfoForCurrentScrollPosition = infoForCurrentScrollPosition();
            float f2 = clientWidth;
            setCurrentItemInternal(determineTargetPage(viewPager$ItemInfoInfoForCurrentScrollPosition.position, ((scrollX / f2) - viewPager$ItemInfoInfoForCurrentScrollPosition.offset) / (viewPager$ItemInfoInfoForCurrentScrollPosition.widthFactor + (this.mPageMargin / f2)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, xVelocity);
            zResetTouch = resetTouch();
        }
        if (zResetTouch) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    public boolean pageLeft() {
        int i = this.mCurItem;
        if (i <= 0) {
            return false;
        }
        setCurrentItem(i - 1, true);
        return true;
    }

    public boolean pageRight() {
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter == null || this.mCurItem >= pagerAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    public void populate() {
        populate(this.mCurItem);
    }

    public void removeOnAdapterChangeListener(@NonNull ViewPager$OnAdapterChangeListener viewPager$OnAdapterChangeListener) {
        List<ViewPager$OnAdapterChangeListener> list = this.mAdapterChangeListeners;
        if (list != null) {
            list.remove(viewPager$OnAdapterChangeListener);
        }
    }

    public void removeOnPageChangeListener(@NonNull ViewPager$OnPageChangeListener viewPager$OnPageChangeListener) {
        List<ViewPager$OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.remove(viewPager$OnPageChangeListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(@Nullable PagerAdapter pagerAdapter) {
        PagerAdapter pagerAdapter2 = this.mAdapter;
        if (pagerAdapter2 != null) {
            pagerAdapter2.setViewPagerObserver(null);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.mItems.size(); i++) {
                ViewPager$ItemInfo viewPager$ItemInfo = this.mItems.get(i);
                this.mAdapter.destroyItem((ViewGroup) this, viewPager$ItemInfo.position, viewPager$ItemInfo.object);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.mAdapter;
        this.mAdapter = pagerAdapter;
        this.mExpectedAdapterCount = 0;
        if (pagerAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new ViewPager$PagerObserver(this);
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z2 = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (z2) {
                requestLayout();
            } else {
                populate();
            }
        }
        List<ViewPager$OnAdapterChangeListener> list = this.mAdapterChangeListeners;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.mAdapterChangeListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mAdapterChangeListeners.get(i2).onAdapterChanged(this, pagerAdapter3, pagerAdapter);
        }
    }

    public void setCurrentItem(int i) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, !this.mFirstLayout, false);
    }

    public void setCurrentItemInternal(int i, boolean z2, boolean z3) {
        setCurrentItemInternal(i, z2, z3, 0);
    }

    public ViewPager$OnPageChangeListener setInternalPageChangeListener(ViewPager$OnPageChangeListener viewPager$OnPageChangeListener) {
        ViewPager$OnPageChangeListener viewPager$OnPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = viewPager$OnPageChangeListener;
        return viewPager$OnPageChangeListener2;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w(TAG, "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i;
            populate();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(ViewPager$OnPageChangeListener viewPager$OnPageChangeListener) {
        this.mOnPageChangeListener = viewPager$OnPageChangeListener;
    }

    public void setPageMargin(int i) {
        int i2 = this.mPageMargin;
        this.mPageMargin = i;
        int width = getWidth();
        recomputeScrollPosition(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(@Nullable Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z2, @Nullable ViewPager$PageTransformer viewPager$PageTransformer) {
        setPageTransformer(z2, viewPager$PageTransformer, 2);
    }

    public void setScrollState(int i) {
        if (this.mScrollState == i) {
            return;
        }
        this.mScrollState = i;
        if (this.mPageTransformer != null) {
            enableLayers(i != 0);
        }
        dispatchOnScrollStateChanged(i);
    }

    public void smoothScrollTo(int i, int i2) {
        smoothScrollTo(i, i2, 0);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mMarginDrawable;
    }

    @Override // android.view.ViewGroup
    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewPager$LayoutParams(getContext(), attributeSet);
    }

    /* JADX WARN: Code duplicated, block: B:64:0x00f3 A[PHI: r3 r6 r12
      0x00f3: PHI (r3v12 int) = (r3v11 int), (r3v10 int), (r3v14 int) binds: [B:62:0x00e8, B:59:0x00d2, B:53:0x00bc] A[DONT_GENERATE, DONT_INLINE]
      0x00f3: PHI (r6v9 int) = (r6v1 int), (r6v8 int), (r6v11 int) binds: [B:62:0x00e8, B:59:0x00d2, B:53:0x00bc] A[DONT_GENERATE, DONT_INLINE]
      0x00f3: PHI (r12v5 float) = (r12v3 float), (r12v4 float), (r12v2 float) binds: [B:62:0x00e8, B:59:0x00d2, B:53:0x00bc] A[DONT_GENERATE, DONT_INLINE]] */
    public void populate(int i) {
        ViewPager$ItemInfo viewPager$ItemInfoInfoForPosition;
        String hexString;
        ViewPager$ItemInfo viewPager$ItemInfoAddNewItem;
        ViewPager$ItemInfo viewPager$ItemInfoInfoForChild;
        int i2 = this.mCurItem;
        if (i2 != i) {
            viewPager$ItemInfoInfoForPosition = infoForPosition(i2);
            this.mCurItem = i;
        } else {
            viewPager$ItemInfoInfoForPosition = null;
        }
        if (this.mAdapter == null) {
            sortChildDrawingOrder();
            return;
        }
        if (this.mPopulatePending) {
            sortChildDrawingOrder();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        this.mAdapter.startUpdate((ViewGroup) this);
        int i3 = this.mOffscreenPageLimit;
        int iMax = Math.max(0, this.mCurItem - i3);
        int count = this.mAdapter.getCount();
        int iMin = Math.min(count - 1, this.mCurItem + i3);
        if (count != this.mExpectedAdapterCount) {
            try {
                hexString = getResources().getResourceName(getId());
            } catch (Resources$NotFoundException unused) {
                hexString = Integer.toHexString(getId());
            }
            StringBuilder sbU = a.U("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
            sbU.append(this.mExpectedAdapterCount);
            sbU.append(", found: ");
            sbU.append(count);
            sbU.append(" Pager id: ");
            sbU.append(hexString);
            sbU.append(" Pager class: ");
            sbU.append(getClass());
            sbU.append(" Problematic adapter: ");
            sbU.append(this.mAdapter.getClass());
            throw new IllegalStateException(sbU.toString());
        }
        int i4 = 0;
        while (true) {
            if (i4 < this.mItems.size()) {
                viewPager$ItemInfoAddNewItem = this.mItems.get(i4);
                int i5 = viewPager$ItemInfoAddNewItem.position;
                int i6 = this.mCurItem;
                if (i5 >= i6) {
                    if (i5 != i6) {
                        break;
                    } else {
                        break;
                    }
                }
                i4++;
            }
            viewPager$ItemInfoAddNewItem = null;
            break;
        }
        if (viewPager$ItemInfoAddNewItem == null && count > 0) {
            viewPager$ItemInfoAddNewItem = addNewItem(this.mCurItem, i4);
        }
        if (viewPager$ItemInfoAddNewItem != null) {
            int i7 = i4 - 1;
            ViewPager$ItemInfo viewPager$ItemInfo = i7 >= 0 ? this.mItems.get(i7) : null;
            int clientWidth = getClientWidth();
            float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - viewPager$ItemInfoAddNewItem.widthFactor) + (getPaddingLeft() / clientWidth);
            float f = 0.0f;
            for (int i8 = this.mCurItem - 1; i8 >= 0; i8--) {
                if (f >= paddingLeft && i8 < iMax) {
                    if (viewPager$ItemInfo == null) {
                        break;
                    }
                    if (i8 == viewPager$ItemInfo.position && !viewPager$ItemInfo.scrolling) {
                        this.mItems.remove(i7);
                        this.mAdapter.destroyItem((ViewGroup) this, i8, viewPager$ItemInfo.object);
                        i7--;
                        i4--;
                        if (i7 >= 0) {
                            viewPager$ItemInfo = this.mItems.get(i7);
                        } else {
                            viewPager$ItemInfo = null;
                        }
                    }
                } else if (viewPager$ItemInfo == null || i8 != viewPager$ItemInfo.position) {
                    f += addNewItem(i8, i7 + 1).widthFactor;
                    i4++;
                    if (i7 >= 0) {
                        viewPager$ItemInfo = this.mItems.get(i7);
                    } else {
                        viewPager$ItemInfo = null;
                    }
                } else {
                    f += viewPager$ItemInfo.widthFactor;
                    i7--;
                    if (i7 >= 0) {
                        viewPager$ItemInfo = this.mItems.get(i7);
                    } else {
                        viewPager$ItemInfo = null;
                    }
                }
            }
            float f2 = viewPager$ItemInfoAddNewItem.widthFactor;
            int i9 = i4 + 1;
            if (f2 < 2.0f) {
                ViewPager$ItemInfo viewPager$ItemInfo2 = i9 < this.mItems.size() ? this.mItems.get(i9) : null;
                float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                int i10 = this.mCurItem;
                while (true) {
                    i10++;
                    if (i10 >= count) {
                        break;
                    }
                    if (f2 >= paddingRight && i10 > iMin) {
                        if (viewPager$ItemInfo2 == null) {
                            break;
                        }
                        if (i10 == viewPager$ItemInfo2.position && !viewPager$ItemInfo2.scrolling) {
                            this.mItems.remove(i9);
                            this.mAdapter.destroyItem((ViewGroup) this, i10, viewPager$ItemInfo2.object);
                            if (i9 < this.mItems.size()) {
                                viewPager$ItemInfo2 = this.mItems.get(i9);
                            }
                        }
                    } else if (viewPager$ItemInfo2 == null || i10 != viewPager$ItemInfo2.position) {
                        ViewPager$ItemInfo viewPager$ItemInfoAddNewItem2 = addNewItem(i10, i9);
                        i9++;
                        f2 += viewPager$ItemInfoAddNewItem2.widthFactor;
                        viewPager$ItemInfo2 = i9 < this.mItems.size() ? this.mItems.get(i9) : null;
                    } else {
                        f2 += viewPager$ItemInfo2.widthFactor;
                        i9++;
                        if (i9 < this.mItems.size()) {
                            viewPager$ItemInfo2 = this.mItems.get(i9);
                        }
                    }
                }
            }
            calculatePageOffsets(viewPager$ItemInfoAddNewItem, i4, viewPager$ItemInfoInfoForPosition);
            this.mAdapter.setPrimaryItem((ViewGroup) this, this.mCurItem, viewPager$ItemInfoAddNewItem.object);
        }
        this.mAdapter.finishUpdate((ViewGroup) this);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams) childAt.getLayoutParams();
            viewPager$LayoutParams.childIndex = i11;
            if (!viewPager$LayoutParams.isDecor && viewPager$LayoutParams.widthFactor == 0.0f && (viewPager$ItemInfoInfoForChild = infoForChild(childAt)) != null) {
                viewPager$LayoutParams.widthFactor = viewPager$ItemInfoInfoForChild.widthFactor;
                viewPager$LayoutParams.position = viewPager$ItemInfoInfoForChild.position;
            }
        }
        sortChildDrawingOrder();
        if (hasFocus()) {
            View viewFindFocus = findFocus();
            ViewPager$ItemInfo viewPager$ItemInfoInfoForAnyChild = viewFindFocus != null ? infoForAnyChild(viewFindFocus) : null;
            if (viewPager$ItemInfoInfoForAnyChild == null || viewPager$ItemInfoInfoForAnyChild.position != this.mCurItem) {
                for (int i12 = 0; i12 < getChildCount(); i12++) {
                    View childAt2 = getChildAt(i12);
                    ViewPager$ItemInfo viewPager$ItemInfoInfoForChild2 = infoForChild(childAt2);
                    if (viewPager$ItemInfoInfoForChild2 != null && viewPager$ItemInfoInfoForChild2.position == this.mCurItem && childAt2.requestFocus(2)) {
                        return;
                    }
                }
            }
        }
    }

    public void setCurrentItemInternal(int i, boolean z2, boolean z3, int i2) {
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter == null || pagerAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z3 && this.mCurItem == i && this.mItems.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.mAdapter.getCount()) {
            i = this.mAdapter.getCount() - 1;
        }
        int i3 = this.mOffscreenPageLimit;
        int i4 = this.mCurItem;
        if (i > i4 + i3 || i < i4 - i3) {
            for (int i5 = 0; i5 < this.mItems.size(); i5++) {
                this.mItems.get(i5).scrolling = true;
            }
        }
        boolean z4 = this.mCurItem != i;
        if (!this.mFirstLayout) {
            populate(i);
            scrollToItem(i, z2, i2, z4);
        } else {
            this.mCurItem = i;
            if (z4) {
                dispatchOnPageSelected(i);
            }
            requestLayout();
        }
    }

    public void setPageTransformer(boolean z2, @Nullable ViewPager$PageTransformer viewPager$PageTransformer, int i) {
        boolean z3 = viewPager$PageTransformer != null;
        boolean z4 = z3 != (this.mPageTransformer != null);
        this.mPageTransformer = viewPager$PageTransformer;
        setChildrenDrawingOrderEnabled(z3);
        if (z3) {
            this.mDrawingOrder = z2 ? 2 : 1;
            this.mPageTransformerLayerType = i;
        } else {
            this.mDrawingOrder = 0;
        }
        if (z4) {
            populate();
        }
    }

    public void smoothScrollTo(int i, int i2, int i3) {
        int scrollX;
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.mScroller;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i4 = scrollX;
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i7 = clientWidth / 2;
        float f = clientWidth;
        float f2 = i7;
        float fDistanceInfluenceForSnapDuration = (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(i5) * 1.0f) / f)) * f2) + f2;
        int iAbs2 = Math.abs(i3);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fDistanceInfluenceForSnapDuration / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i5) / ((this.mAdapter.getPageWidth(this.mCurItem) * f) + this.mPageMargin)) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, MAX_SETTLE_DURATION);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(i4, scrollY, i5, i6, iMin);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void setCurrentItem(int i, boolean z2) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, z2, false);
    }

    public void setPageMarginDrawable(@DrawableRes int i) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), i));
    }

    public ViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItems = new ArrayList<>();
        this.mTempItem = new ViewPager$ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new ViewPager$3(this);
        this.mScrollState = 0;
        initViewPager();
    }
}

package com.google.android.material.tabs;

import android.animation.Animator$AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View$MeasureSpec;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout$LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout$LayoutParams;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SimplePool;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager$DecorView;
import b.i.a.g.i.a;
import b.i.a.g.i.b;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@ViewPager$DecorView
public class TabLayout extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;

    @Dimension(unit = 0)
    public static final int DEFAULT_GAP_TEXT_ICON = 8;

    @Dimension(unit = 0)
    private static final int DEFAULT_HEIGHT = 48;

    @Dimension(unit = 0)
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;

    @Dimension(unit = 0)
    public static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int GRAVITY_START = 2;
    public static final int INDICATOR_ANIMATION_MODE_ELASTIC = 1;
    public static final int INDICATOR_ANIMATION_MODE_LINEAR = 0;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    private static final int INVALID_WIDTH = -1;
    private static final String LOG_TAG = "TabLayout";
    public static final int MODE_AUTO = 2;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    public static final int TAB_LABEL_VISIBILITY_LABELED = 1;
    public static final int TAB_LABEL_VISIBILITY_UNLABELED = 0;

    @Dimension(unit = 0)
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private TabLayout$b adapterChangeListener;
    private int contentInsetStart;

    @Nullable
    private TabLayout$BaseOnTabSelectedListener currentVpSelectedListener;
    public boolean inlineLabel;
    public int mode;
    private TabLayout$TabLayoutOnPageChangeListener pageChangeListener;

    @Nullable
    private PagerAdapter pagerAdapter;
    private DataSetObserver pagerAdapterObserver;
    private final int requestedTabMaxWidth;
    private final int requestedTabMinWidth;
    private ValueAnimator scrollAnimator;
    private final int scrollableTabMinWidth;

    @Nullable
    private TabLayout$BaseOnTabSelectedListener selectedListener;
    private final ArrayList<TabLayout$BaseOnTabSelectedListener> selectedListeners;

    @Nullable
    private TabLayout$Tab selectedTab;
    private boolean setupViewPagerImplicitly;

    @NonNull
    public final TabLayout$d slidingTabIndicator;
    public final int tabBackgroundResId;
    public int tabGravity;
    public ColorStateList tabIconTint;
    public PorterDuff$Mode tabIconTintMode;
    public int tabIndicatorAnimationDuration;
    public int tabIndicatorAnimationMode;
    public boolean tabIndicatorFullWidth;
    public int tabIndicatorGravity;
    private b tabIndicatorInterpolator;
    public int tabMaxWidth;
    public int tabPaddingBottom;
    public int tabPaddingEnd;
    public int tabPaddingStart;
    public int tabPaddingTop;
    public ColorStateList tabRippleColorStateList;

    @NonNull
    public Drawable tabSelectedIndicator;
    private int tabSelectedIndicatorColor;
    public int tabTextAppearance;
    public ColorStateList tabTextColors;
    public float tabTextMultiLineSize;
    public float tabTextSize;
    private final Pools$Pool<TabLayout$TabView> tabViewPool;
    private final ArrayList<TabLayout$Tab> tabs;
    public boolean unboundedRipple;

    @Nullable
    public ViewPager viewPager;
    private static final int DEF_STYLE_RES = R$style.Widget_Design_TabLayout;
    private static final Pools$Pool<TabLayout$Tab> tabPool = new Pools$SynchronizedPool(16);

    public TabLayout(@NonNull Context context) {
        this(context, null);
    }

    public static /* synthetic */ b access$1200(TabLayout tabLayout) {
        return tabLayout.tabIndicatorInterpolator;
    }

    public static /* synthetic */ int access$1400(TabLayout tabLayout) {
        return tabLayout.tabSelectedIndicatorColor;
    }

    private void addTabFromItemView(@NonNull TabItem tabItem) {
        TabLayout$Tab tabLayout$TabNewTab = newTab();
        CharSequence charSequence = tabItem.text;
        if (charSequence != null) {
            tabLayout$TabNewTab.setText(charSequence);
        }
        Drawable drawable = tabItem.icon;
        if (drawable != null) {
            tabLayout$TabNewTab.setIcon(drawable);
        }
        int i = tabItem.customLayout;
        if (i != 0) {
            tabLayout$TabNewTab.setCustomView(i);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            tabLayout$TabNewTab.setContentDescription(tabItem.getContentDescription());
        }
        addTab(tabLayout$TabNewTab);
    }

    private void addTabView(@NonNull TabLayout$Tab tabLayout$Tab) {
        TabLayout$TabView tabLayout$TabView = tabLayout$Tab.view;
        tabLayout$TabView.setSelected(false);
        tabLayout$TabView.setActivated(false);
        this.slidingTabIndicator.addView(tabLayout$TabView, tabLayout$Tab.getPosition(), createLayoutParamsForTabs());
    }

    private void addViewInternal(View view) {
        if (!(view instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        addTabFromItemView((TabItem) view);
    }

    private void animateToTab(int i) {
        boolean z2;
        if (i == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this)) {
            TabLayout$d tabLayout$d = this.slidingTabIndicator;
            int childCount = tabLayout$d.getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    z2 = false;
                    break;
                } else {
                    if (tabLayout$d.getChildAt(i2).getWidth() <= 0) {
                        z2 = true;
                        break;
                    }
                    i2++;
                }
            }
            if (!z2) {
                int scrollX = getScrollX();
                int iCalculateScrollXForTab = calculateScrollXForTab(i, 0.0f);
                if (scrollX != iCalculateScrollXForTab) {
                    ensureScrollAnimator();
                    this.scrollAnimator.setIntValues(scrollX, iCalculateScrollXForTab);
                    this.scrollAnimator.start();
                }
                TabLayout$d tabLayout$d2 = this.slidingTabIndicator;
                int i3 = this.tabIndicatorAnimationDuration;
                ValueAnimator valueAnimator = tabLayout$d2.j;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    tabLayout$d2.j.cancel();
                }
                tabLayout$d2.d(true, i, i3);
                return;
            }
        }
        setScrollPosition(i, 0.0f, true);
    }

    private void applyGravityForModeScrollable(int i) {
        if (i == 0) {
            Log.w(LOG_TAG, "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        } else if (i == 1) {
            this.slidingTabIndicator.setGravity(1);
            return;
        } else if (i != 2) {
            return;
        }
        this.slidingTabIndicator.setGravity(GravityCompat.START);
    }

    private void applyModeAndGravity() {
        int i = this.mode;
        ViewCompat.setPaddingRelative(this.slidingTabIndicator, (i == 0 || i == 2) ? Math.max(0, this.contentInsetStart - this.tabPaddingStart) : 0, 0, 0, 0);
        int i2 = this.mode;
        if (i2 == 0) {
            applyGravityForModeScrollable(this.tabGravity);
        } else if (i2 == 1 || i2 == 2) {
            if (this.tabGravity == 2) {
                Log.w(LOG_TAG, "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.slidingTabIndicator.setGravity(1);
        }
        updateTabViews(true);
    }

    private int calculateScrollXForTab(int i, float f) {
        int i2 = this.mode;
        if (i2 != 0 && i2 != 2) {
            return 0;
        }
        View childAt = this.slidingTabIndicator.getChildAt(i);
        int i3 = i + 1;
        View childAt2 = i3 < this.slidingTabIndicator.getChildCount() ? this.slidingTabIndicator.getChildAt(i3) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i4 = (int) ((width + width2) * 0.5f * f);
        return ViewCompat.getLayoutDirection(this) == 0 ? left + i4 : left - i4;
    }

    private void configureTab(@NonNull TabLayout$Tab tabLayout$Tab, int i) {
        tabLayout$Tab.setPosition(i);
        this.tabs.add(i, tabLayout$Tab);
        int size = this.tabs.size();
        while (true) {
            i++;
            if (i >= size) {
                return;
            } else {
                this.tabs.get(i).setPosition(i);
            }
        }
    }

    @NonNull
    private static ColorStateList createColorStateList(int i, int i2) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i2, i});
    }

    @NonNull
    private LinearLayout$LayoutParams createLayoutParamsForTabs() {
        LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-2, -1);
        updateTabViewLayoutParams(linearLayout$LayoutParams);
        return linearLayout$LayoutParams;
    }

    @NonNull
    private TabLayout$TabView createTabView(@NonNull TabLayout$Tab tabLayout$Tab) {
        Pools$Pool<TabLayout$TabView> pools$Pool = this.tabViewPool;
        TabLayout$TabView tabLayout$TabViewAcquire = pools$Pool != null ? pools$Pool.acquire() : null;
        if (tabLayout$TabViewAcquire == null) {
            tabLayout$TabViewAcquire = new TabLayout$TabView(this, getContext());
        }
        tabLayout$TabViewAcquire.setTab(tabLayout$Tab);
        tabLayout$TabViewAcquire.setFocusable(true);
        tabLayout$TabViewAcquire.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(TabLayout$Tab.access$200(tabLayout$Tab))) {
            tabLayout$TabViewAcquire.setContentDescription(TabLayout$Tab.access$300(tabLayout$Tab));
        } else {
            tabLayout$TabViewAcquire.setContentDescription(TabLayout$Tab.access$200(tabLayout$Tab));
        }
        return tabLayout$TabViewAcquire;
    }

    private void dispatchTabReselected(@NonNull TabLayout$Tab tabLayout$Tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabReselected(tabLayout$Tab);
        }
    }

    private void dispatchTabSelected(@NonNull TabLayout$Tab tabLayout$Tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabSelected(tabLayout$Tab);
        }
    }

    private void dispatchTabUnselected(@NonNull TabLayout$Tab tabLayout$Tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabUnselected(tabLayout$Tab);
        }
    }

    private void ensureScrollAnimator() {
        if (this.scrollAnimator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.scrollAnimator = valueAnimator;
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.scrollAnimator.setDuration(this.tabIndicatorAnimationDuration);
            this.scrollAnimator.addUpdateListener(new TabLayout$a(this));
        }
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        int size = this.tabs.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            TabLayout$Tab tabLayout$Tab = this.tabs.get(i);
            if (tabLayout$Tab != null && tabLayout$Tab.getIcon() != null && !TextUtils.isEmpty(tabLayout$Tab.getText())) {
                z2 = true;
                break;
            }
        }
        return (!z2 || this.inlineLabel) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i = this.requestedTabMinWidth;
        if (i != -1) {
            return i;
        }
        int i2 = this.mode;
        if (i2 == 0 || i2 == 2) {
            return this.scrollableTabMinWidth;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void removeTabViewAt(int i) {
        TabLayout$TabView tabLayout$TabView = (TabLayout$TabView) this.slidingTabIndicator.getChildAt(i);
        this.slidingTabIndicator.removeViewAt(i);
        if (tabLayout$TabView != null) {
            tabLayout$TabView.reset();
            this.tabViewPool.release(tabLayout$TabView);
        }
        requestLayout();
    }

    private void setSelectedTabView(int i) {
        int childCount = this.slidingTabIndicator.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = this.slidingTabIndicator.getChildAt(i2);
                boolean z2 = true;
                childAt.setSelected(i2 == i);
                if (i2 != i) {
                    z2 = false;
                }
                childAt.setActivated(z2);
                i2++;
            }
        }
    }

    private void updateAllTabs() {
        int size = this.tabs.size();
        for (int i = 0; i < size; i++) {
            this.tabs.get(i).updateView();
        }
    }

    private void updateTabViewLayoutParams(@NonNull LinearLayout$LayoutParams linearLayout$LayoutParams) {
        if (this.mode == 1 && this.tabGravity == 0) {
            linearLayout$LayoutParams.width = 0;
            linearLayout$LayoutParams.weight = 1.0f;
        } else {
            linearLayout$LayoutParams.width = -2;
            linearLayout$LayoutParams.weight = 0.0f;
        }
    }

    public void addOnTabSelectedListener(@NonNull TabLayout$OnTabSelectedListener tabLayout$OnTabSelectedListener) {
        addOnTabSelectedListener((TabLayout$BaseOnTabSelectedListener) tabLayout$OnTabSelectedListener);
    }

    public void addTab(@NonNull TabLayout$Tab tabLayout$Tab) {
        addTab(tabLayout$Tab, this.tabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        addViewInternal(view);
    }

    public void clearOnTabSelectedListeners() {
        this.selectedListeners.clear();
    }

    public TabLayout$Tab createTabFromPool() {
        TabLayout$Tab tabLayout$TabAcquire = tabPool.acquire();
        return tabLayout$TabAcquire == null ? new TabLayout$Tab() : tabLayout$TabAcquire;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup$LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateLayoutParams(attributeSet);
    }

    public int getSelectedTabPosition() {
        TabLayout$Tab tabLayout$Tab = this.selectedTab;
        if (tabLayout$Tab != null) {
            return tabLayout$Tab.getPosition();
        }
        return -1;
    }

    @Nullable
    public TabLayout$Tab getTabAt(int i) {
        if (i < 0 || i >= getTabCount()) {
            return null;
        }
        return this.tabs.get(i);
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public int getTabIndicatorAnimationMode() {
        return this.tabIndicatorAnimationMode;
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    public int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    public int getTabMode() {
        return this.mode;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    @NonNull
    public Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.tabTextColors;
    }

    public boolean hasUnboundedRipple() {
        return this.unboundedRipple;
    }

    public boolean isInlineLabel() {
        return this.inlineLabel;
    }

    public boolean isTabIndicatorFullWidth() {
        return this.tabIndicatorFullWidth;
    }

    @NonNull
    public TabLayout$Tab newTab() {
        TabLayout$Tab tabLayout$TabCreateTabFromPool = createTabFromPool();
        tabLayout$TabCreateTabFromPool.parent = this;
        tabLayout$TabCreateTabFromPool.view = createTabView(tabLayout$TabCreateTabFromPool);
        if (TabLayout$Tab.access$000(tabLayout$TabCreateTabFromPool) != -1) {
            tabLayout$TabCreateTabFromPool.view.setId(TabLayout$Tab.access$000(tabLayout$TabCreateTabFromPool));
        }
        return tabLayout$TabCreateTabFromPool;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
        if (this.viewPager == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                setupWithViewPager((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.setupViewPagerImplicitly) {
            setupWithViewPager(null);
            this.setupViewPagerImplicitly = false;
        }
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
            View childAt = this.slidingTabIndicator.getChildAt(i);
            if (childAt instanceof TabLayout$TabView) {
                TabLayout$TabView.access$400((TabLayout$TabView) childAt, canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat$CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0080  */
    /* JADX WARN: Code duplicated, block: B:30:0x0082  */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int iRound = Math.round(ViewUtils.dpToPx(getContext(), getDefaultHeight()));
        int mode = View$MeasureSpec.getMode(i2);
        boolean z2 = false;
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i2 = View$MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + iRound, BasicMeasure.EXACTLY);
            }
        } else if (getChildCount() == 1 && View$MeasureSpec.getSize(i2) >= iRound) {
            getChildAt(0).setMinimumHeight(iRound);
        }
        int size = View$MeasureSpec.getSize(i);
        if (View$MeasureSpec.getMode(i) != 0) {
            int iDpToPx = this.requestedTabMaxWidth;
            if (iDpToPx <= 0) {
                iDpToPx = (int) (size - ViewUtils.dpToPx(getContext(), 56));
            }
            this.tabMaxWidth = iDpToPx;
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i3 = this.mode;
            if (i3 == 0) {
                if (childAt.getMeasuredWidth() < getMeasuredWidth()) {
                    z2 = true;
                }
            } else if (i3 != 1) {
                if (i3 == 2) {
                    if (childAt.getMeasuredWidth() < getMeasuredWidth()) {
                        z2 = true;
                    }
                }
            } else if (childAt.getMeasuredWidth() != getMeasuredWidth()) {
                z2 = true;
            }
            if (z2) {
                childAt.measure(View$MeasureSpec.makeMeasureSpec(getMeasuredWidth(), BasicMeasure.EXACTLY), HorizontalScrollView.getChildMeasureSpec(i2, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
            }
        }
    }

    public void populateFromPagerAdapter() {
        int currentItem;
        removeAllTabs();
        PagerAdapter pagerAdapter = this.pagerAdapter;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i = 0; i < count; i++) {
                addTab(newTab().setText(this.pagerAdapter.getPageTitle(i)), false);
            }
            ViewPager viewPager = this.viewPager;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            selectTab(getTabAt(currentItem));
        }
    }

    public boolean releaseFromTabPool(TabLayout$Tab tabLayout$Tab) {
        return tabPool.release(tabLayout$Tab);
    }

    public void removeAllTabs() {
        for (int childCount = this.slidingTabIndicator.getChildCount() - 1; childCount >= 0; childCount--) {
            removeTabViewAt(childCount);
        }
        Iterator<TabLayout$Tab> it = this.tabs.iterator();
        while (it.hasNext()) {
            TabLayout$Tab next = it.next();
            it.remove();
            next.reset();
            releaseFromTabPool(next);
        }
        this.selectedTab = null;
    }

    public void removeOnTabSelectedListener(@NonNull TabLayout$OnTabSelectedListener tabLayout$OnTabSelectedListener) {
        removeOnTabSelectedListener((TabLayout$BaseOnTabSelectedListener) tabLayout$OnTabSelectedListener);
    }

    public void removeTab(@NonNull TabLayout$Tab tabLayout$Tab) {
        if (tabLayout$Tab.parent != this) {
            throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
        }
        removeTabAt(tabLayout$Tab.getPosition());
    }

    public void removeTabAt(int i) {
        TabLayout$Tab tabLayout$Tab = this.selectedTab;
        int position = tabLayout$Tab != null ? tabLayout$Tab.getPosition() : 0;
        removeTabViewAt(i);
        TabLayout$Tab tabLayout$TabRemove = this.tabs.remove(i);
        if (tabLayout$TabRemove != null) {
            tabLayout$TabRemove.reset();
            releaseFromTabPool(tabLayout$TabRemove);
        }
        int size = this.tabs.size();
        for (int i2 = i; i2 < size; i2++) {
            this.tabs.get(i2).setPosition(i2);
        }
        if (position == i) {
            selectTab(this.tabs.isEmpty() ? null : this.tabs.get(Math.max(0, i - 1)));
        }
    }

    public void selectTab(@Nullable TabLayout$Tab tabLayout$Tab) {
        selectTab(tabLayout$Tab, true);
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f) {
        super.setElevation(f);
        MaterialShapeUtils.setElevation(this, f);
    }

    public void setInlineLabel(boolean z2) {
        if (this.inlineLabel != z2) {
            this.inlineLabel = z2;
            for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
                View childAt = this.slidingTabIndicator.getChildAt(i);
                if (childAt instanceof TabLayout$TabView) {
                    ((TabLayout$TabView) childAt).updateOrientation();
                }
            }
            applyModeAndGravity();
        }
    }

    public void setInlineLabelResource(@BoolRes int i) {
        setInlineLabel(getResources().getBoolean(i));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable TabLayout$OnTabSelectedListener tabLayout$OnTabSelectedListener) {
        setOnTabSelectedListener((TabLayout$BaseOnTabSelectedListener) tabLayout$OnTabSelectedListener);
    }

    public void setPagerAdapter(@Nullable PagerAdapter pagerAdapter, boolean z2) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.pagerAdapter;
        if (pagerAdapter2 != null && (dataSetObserver = this.pagerAdapterObserver) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.pagerAdapter = pagerAdapter;
        if (z2 && pagerAdapter != null) {
            if (this.pagerAdapterObserver == null) {
                this.pagerAdapterObserver = new TabLayout$c(this);
            }
            pagerAdapter.registerDataSetObserver(this.pagerAdapterObserver);
        }
        populateFromPagerAdapter();
    }

    public void setScrollAnimatorListener(Animator$AnimatorListener animator$AnimatorListener) {
        ensureScrollAnimator();
        this.scrollAnimator.addListener(animator$AnimatorListener);
    }

    public void setScrollPosition(int i, float f, boolean z2) {
        setScrollPosition(i, f, z2, true);
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (this.tabSelectedIndicator != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.tabSelectedIndicator = drawable;
        }
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i) {
        this.tabSelectedIndicatorColor = i;
    }

    public void setSelectedTabIndicatorGravity(int i) {
        if (this.tabIndicatorGravity != i) {
            this.tabIndicatorGravity = i;
            ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i) {
        this.slidingTabIndicator.b(i);
    }

    public void setTabGravity(int i) {
        if (this.tabGravity != i) {
            this.tabGravity = i;
            applyModeAndGravity();
        }
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        if (this.tabIconTint != colorStateList) {
            this.tabIconTint = colorStateList;
            updateAllTabs();
        }
    }

    public void setTabIconTintResource(@ColorRes int i) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), i));
    }

    public void setTabIndicatorAnimationMode(int i) {
        this.tabIndicatorAnimationMode = i;
        if (i == 0) {
            this.tabIndicatorInterpolator = new b();
        } else {
            if (i == 1) {
                this.tabIndicatorInterpolator = new a();
                return;
            }
            throw new IllegalArgumentException(i + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z2) {
        this.tabIndicatorFullWidth = z2;
        ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
    }

    public void setTabMode(int i) {
        if (i != this.mode) {
            this.mode = i;
            applyModeAndGravity();
        }
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.tabRippleColorStateList != colorStateList) {
            this.tabRippleColorStateList = colorStateList;
            for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
                View childAt = this.slidingTabIndicator.getChildAt(i);
                if (childAt instanceof TabLayout$TabView) {
                    TabLayout$TabView.access$100((TabLayout$TabView) childAt, getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(@ColorRes int i) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), i));
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.tabTextColors != colorStateList) {
            this.tabTextColors = colorStateList;
            updateAllTabs();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        setPagerAdapter(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean z2) {
        if (this.unboundedRipple != z2) {
            this.unboundedRipple = z2;
            for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
                View childAt = this.slidingTabIndicator.getChildAt(i);
                if (childAt instanceof TabLayout$TabView) {
                    TabLayout$TabView.access$100((TabLayout$TabView) childAt, getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(@BoolRes int i) {
        setUnboundedRipple(getResources().getBoolean(i));
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public void updateTabViews(boolean z2) {
        for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
            View childAt = this.slidingTabIndicator.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            updateTabViewLayoutParams((LinearLayout$LayoutParams) childAt.getLayoutParams());
            if (z2) {
                childAt.requestLayout();
            }
        }
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.tabStyle);
    }

    @Deprecated
    public void addOnTabSelectedListener(@Nullable TabLayout$BaseOnTabSelectedListener tabLayout$BaseOnTabSelectedListener) {
        if (this.selectedListeners.contains(tabLayout$BaseOnTabSelectedListener)) {
            return;
        }
        this.selectedListeners.add(tabLayout$BaseOnTabSelectedListener);
    }

    public void addTab(@NonNull TabLayout$Tab tabLayout$Tab, int i) {
        addTab(tabLayout$Tab, i, this.tabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i) {
        addViewInternal(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout$LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void removeOnTabSelectedListener(@Nullable TabLayout$BaseOnTabSelectedListener tabLayout$BaseOnTabSelectedListener) {
        this.selectedListeners.remove(tabLayout$BaseOnTabSelectedListener);
    }

    public void selectTab(@Nullable TabLayout$Tab tabLayout$Tab, boolean z2) {
        TabLayout$Tab tabLayout$Tab2 = this.selectedTab;
        if (tabLayout$Tab2 == tabLayout$Tab) {
            if (tabLayout$Tab2 != null) {
                dispatchTabReselected(tabLayout$Tab);
                animateToTab(tabLayout$Tab.getPosition());
                return;
            }
            return;
        }
        int position = tabLayout$Tab != null ? tabLayout$Tab.getPosition() : -1;
        if (z2) {
            if ((tabLayout$Tab2 == null || tabLayout$Tab2.getPosition() == -1) && position != -1) {
                setScrollPosition(position, 0.0f, true);
            } else {
                animateToTab(position);
            }
            if (position != -1) {
                setSelectedTabView(position);
            }
        }
        this.selectedTab = tabLayout$Tab;
        if (tabLayout$Tab2 != null) {
            dispatchTabUnselected(tabLayout$Tab2);
        }
        if (tabLayout$Tab != null) {
            dispatchTabSelected(tabLayout$Tab);
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable TabLayout$BaseOnTabSelectedListener tabLayout$BaseOnTabSelectedListener) {
        TabLayout$BaseOnTabSelectedListener tabLayout$BaseOnTabSelectedListener2 = this.selectedListener;
        if (tabLayout$BaseOnTabSelectedListener2 != null) {
            removeOnTabSelectedListener(tabLayout$BaseOnTabSelectedListener2);
        }
        this.selectedListener = tabLayout$BaseOnTabSelectedListener;
        if (tabLayout$BaseOnTabSelectedListener != null) {
            addOnTabSelectedListener(tabLayout$BaseOnTabSelectedListener);
        }
    }

    public void setScrollPosition(int i, float f, boolean z2, boolean z3) {
        int iRound = Math.round(i + f);
        if (iRound < 0 || iRound >= this.slidingTabIndicator.getChildCount()) {
            return;
        }
        if (z3) {
            TabLayout$d tabLayout$d = this.slidingTabIndicator;
            ValueAnimator valueAnimator = tabLayout$d.j;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                tabLayout$d.j.cancel();
            }
            tabLayout$d.k = i;
            tabLayout$d.l = f;
            tabLayout$d.c(tabLayout$d.getChildAt(i), tabLayout$d.getChildAt(tabLayout$d.k + 1), tabLayout$d.l);
        }
        ValueAnimator valueAnimator2 = this.scrollAnimator;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.scrollAnimator.cancel();
        }
        scrollTo(calculateScrollXForTab(i, f), 0);
        if (z2) {
            setSelectedTabView(iRound);
        }
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager, boolean z2) {
        setupWithViewPager(viewPager, z2, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        int i2 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i2), attributeSet, i);
        this.tabs = new ArrayList<>();
        this.tabSelectedIndicator = new GradientDrawable();
        this.tabSelectedIndicatorColor = 0;
        this.tabMaxWidth = Integer.MAX_VALUE;
        this.selectedListeners = new ArrayList<>();
        this.tabViewPool = new Pools$SimplePool(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        TabLayout$d tabLayout$d = new TabLayout$d(this, context2);
        this.slidingTabIndicator = tabLayout$d;
        super.addView(tabLayout$d, 0, new FrameLayout$LayoutParams(-2, -1));
        int[] iArr = R$styleable.TabLayout;
        int i3 = R$styleable.TabLayout_tabTextAppearance;
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, iArr, i, i2, i3);
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(colorDrawable.getColor()));
            materialShapeDrawable.initializeElevationOverlay(context2);
            materialShapeDrawable.setElevation(ViewCompat.getElevation(this));
            ViewCompat.setBackground(this, materialShapeDrawable);
        }
        setSelectedTabIndicator(MaterialResources.getDrawable(context2, typedArrayObtainStyledAttributes, R$styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(typedArrayObtainStyledAttributes.getColor(R$styleable.TabLayout_tabIndicatorColor, 0));
        tabLayout$d.b(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.TabLayout_tabIndicatorHeight, -1));
        setSelectedTabIndicatorGravity(typedArrayObtainStyledAttributes.getInt(R$styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(typedArrayObtainStyledAttributes.getBoolean(R$styleable.TabLayout_tabIndicatorFullWidth, true));
        setTabIndicatorAnimationMode(typedArrayObtainStyledAttributes.getInt(R$styleable.TabLayout_tabIndicatorAnimationMode, 0));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.TabLayout_tabPadding, 0);
        this.tabPaddingBottom = dimensionPixelSize;
        this.tabPaddingEnd = dimensionPixelSize;
        this.tabPaddingTop = dimensionPixelSize;
        this.tabPaddingStart = dimensionPixelSize;
        this.tabPaddingStart = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.tabPaddingTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingTop, this.tabPaddingTop);
        this.tabPaddingEnd = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingEnd, this.tabPaddingEnd);
        this.tabPaddingBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingBottom, this.tabPaddingBottom);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(i3, R$style.TextAppearance_Design_Tab);
        this.tabTextAppearance = resourceId;
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(resourceId, androidx.appcompat.R$styleable.TextAppearance);
        try {
            this.tabTextSize = typedArrayObtainStyledAttributes2.getDimensionPixelSize(androidx.appcompat.R$styleable.TextAppearance_android_textSize, 0);
            this.tabTextColors = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes2, androidx.appcompat.R$styleable.TextAppearance_android_textColor);
            typedArrayObtainStyledAttributes2.recycle();
            int i4 = R$styleable.TabLayout_tabTextColor;
            if (typedArrayObtainStyledAttributes.hasValue(i4)) {
                this.tabTextColors = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, i4);
            }
            int i5 = R$styleable.TabLayout_tabSelectedTextColor;
            if (typedArrayObtainStyledAttributes.hasValue(i5)) {
                this.tabTextColors = createColorStateList(this.tabTextColors.getDefaultColor(), typedArrayObtainStyledAttributes.getColor(i5, 0));
            }
            this.tabIconTint = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, R$styleable.TabLayout_tabIconTint);
            this.tabIconTintMode = ViewUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(R$styleable.TabLayout_tabIconTintMode, -1), null);
            this.tabRippleColorStateList = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, R$styleable.TabLayout_tabRippleColor);
            this.tabIndicatorAnimationDuration = typedArrayObtainStyledAttributes.getInt(R$styleable.TabLayout_tabIndicatorAnimationDuration, ANIMATION_DURATION);
            this.requestedTabMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.TabLayout_tabMinWidth, -1);
            this.requestedTabMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.TabLayout_tabMaxWidth, -1);
            this.tabBackgroundResId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.TabLayout_tabBackground, 0);
            this.contentInsetStart = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.TabLayout_tabContentStart, 0);
            this.mode = typedArrayObtainStyledAttributes.getInt(R$styleable.TabLayout_tabMode, 1);
            this.tabGravity = typedArrayObtainStyledAttributes.getInt(R$styleable.TabLayout_tabGravity, 0);
            this.inlineLabel = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TabLayout_tabInlineLabel, false);
            this.unboundedRipple = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TabLayout_tabUnboundedRipple, false);
            typedArrayObtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.tabTextMultiLineSize = resources.getDimensionPixelSize(R$dimen.design_tab_text_size_2line);
            this.scrollableTabMinWidth = resources.getDimensionPixelSize(R$dimen.design_tab_scrollable_min_width);
            applyModeAndGravity();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th;
        }
    }

    private void setupWithViewPager(@Nullable ViewPager viewPager, boolean z2, boolean z3) {
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            TabLayout$TabLayoutOnPageChangeListener tabLayout$TabLayoutOnPageChangeListener = this.pageChangeListener;
            if (tabLayout$TabLayoutOnPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(tabLayout$TabLayoutOnPageChangeListener);
            }
            TabLayout$b tabLayout$b = this.adapterChangeListener;
            if (tabLayout$b != null) {
                this.viewPager.removeOnAdapterChangeListener(tabLayout$b);
            }
        }
        TabLayout$BaseOnTabSelectedListener tabLayout$BaseOnTabSelectedListener = this.currentVpSelectedListener;
        if (tabLayout$BaseOnTabSelectedListener != null) {
            removeOnTabSelectedListener(tabLayout$BaseOnTabSelectedListener);
            this.currentVpSelectedListener = null;
        }
        if (viewPager != null) {
            this.viewPager = viewPager;
            if (this.pageChangeListener == null) {
                this.pageChangeListener = new TabLayout$TabLayoutOnPageChangeListener(this);
            }
            this.pageChangeListener.reset();
            viewPager.addOnPageChangeListener(this.pageChangeListener);
            TabLayout$ViewPagerOnTabSelectedListener tabLayout$ViewPagerOnTabSelectedListener = new TabLayout$ViewPagerOnTabSelectedListener(viewPager);
            this.currentVpSelectedListener = tabLayout$ViewPagerOnTabSelectedListener;
            addOnTabSelectedListener((TabLayout$BaseOnTabSelectedListener) tabLayout$ViewPagerOnTabSelectedListener);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, z2);
            }
            if (this.adapterChangeListener == null) {
                this.adapterChangeListener = new TabLayout$b(this);
            }
            TabLayout$b tabLayout$b2 = this.adapterChangeListener;
            tabLayout$b2.a = z2;
            viewPager.addOnAdapterChangeListener(tabLayout$b2);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.viewPager = null;
            setPagerAdapter(null, false);
        }
        this.setupViewPagerImplicitly = z3;
    }

    public void addTab(@NonNull TabLayout$Tab tabLayout$Tab, boolean z2) {
        addTab(tabLayout$Tab, this.tabs.size(), z2);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup$LayoutParams viewGroup$LayoutParams) {
        addViewInternal(view);
    }

    public void setSelectedTabIndicator(@DrawableRes int i) {
        if (i != 0) {
            setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), i));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    public void addTab(@NonNull TabLayout$Tab tabLayout$Tab, int i, boolean z2) {
        if (tabLayout$Tab.parent == this) {
            configureTab(tabLayout$Tab, i);
            addTabView(tabLayout$Tab);
            if (z2) {
                tabLayout$Tab.select();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup$LayoutParams viewGroup$LayoutParams) {
        addViewInternal(view);
    }

    public void setTabTextColors(int i, int i2) {
        setTabTextColors(createColorStateList(i, i2));
    }
}

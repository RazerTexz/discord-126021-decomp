package com.discord.utilities.simple_pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View$MeasureSpec;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SimplePager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SimplePager extends ViewPager {
    private boolean isScrollingEnabled;
    private boolean keepAllPagesLoaded;
    private boolean preserveSelectedPage;
    private boolean wrapHeight;

    public SimplePager(Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ SimplePager(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static /* synthetic */ void getKeepAllPagesLoaded$annotations() {
    }

    public static /* synthetic */ void getPreserveSelectedPage$annotations() {
    }

    public final boolean getKeepAllPagesLoaded() {
        return this.keepAllPagesLoaded;
    }

    public final boolean getPreserveSelectedPage() {
        return this.preserveSelectedPage;
    }

    public final boolean getWrapHeight() {
        return this.wrapHeight;
    }

    /* JADX INFO: renamed from: isScrollingEnabled, reason: from getter */
    public final boolean getIsScrollingEnabled() {
        return this.isScrollingEnabled;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        m.checkNotNullParameter(event, "event");
        return this.isScrollingEnabled && super.onInterceptTouchEvent(event);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!this.wrapHeight) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            childAt.measure(widthMeasureSpec, View$MeasureSpec.makeMeasureSpec(0, 0));
            m.checkNotNullExpressionValue(childAt, "child");
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredHeight > i) {
                i = measuredHeight;
            }
        }
        if (i != 0) {
            heightMeasureSpec = View$MeasureSpec.makeMeasureSpec(i, BasicMeasure.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        m.checkNotNullParameter(event, "event");
        return this.isScrollingEnabled && super.onTouchEvent(event);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter adapter) {
        int currentItem = getCurrentItem();
        super.setAdapter(adapter);
        if (this.preserveSelectedPage) {
            if (getChildCount() > currentItem) {
                setCurrentItem(currentItem, true);
            } else {
                setCurrentItem(0);
            }
        }
        if (this.keepAllPagesLoaded) {
            setOffscreenPageLimit(adapter != null ? adapter.getCount() : 0);
        }
    }

    public final void setKeepAllPagesLoaded(boolean z2) {
        this.keepAllPagesLoaded = z2;
    }

    public final void setPreserveSelectedPage(boolean z2) {
        this.preserveSelectedPage = z2;
    }

    public final void setScrollingEnabled(boolean z2) {
        this.isScrollingEnabled = z2;
    }

    public final void setTabLayout(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.setupWithViewPager(this);
        }
    }

    public final void setWrapHeight(boolean z2) {
        this.wrapHeight = z2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimplePager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        this.preserveSelectedPage = true;
        this.keepAllPagesLoaded = true;
        this.isScrollingEnabled = true;
    }
}

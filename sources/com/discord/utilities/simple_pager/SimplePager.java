package com.discord.utilities.simple_pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.material.tabs.TabLayout;
import d0.t._ArraysJvm;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SimplePager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SimplePager extends ViewPager {
    private boolean isScrollingEnabled;
    private boolean keepAllPagesLoaded;
    private boolean preserveSelectedPage;
    private boolean wrapHeight;

    /* JADX INFO: compiled from: SimplePager.kt */
    public static final class Adapter extends FragmentPagerAdapter {
        private final List<Item> items;

        /* JADX INFO: compiled from: SimplePager.kt */
        public static final class Item {
            private final Function0<Fragment> creator;
            private final String title;

            /* JADX WARN: Multi-variable type inference failed */
            public Item(String str, Function0<? extends Fragment> function0) {
                Intrinsics3.checkNotNullParameter(str, "title");
                Intrinsics3.checkNotNullParameter(function0, "creator");
                this.title = str;
                this.creator = function0;
            }

            public final Function0<Fragment> getCreator$utils_release() {
                return this.creator;
            }

            /* JADX INFO: renamed from: getTitle$utils_release, reason: from getter */
            public final String getTitle() {
                return this.title;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(FragmentManager fragmentManager, Item... itemArr) {
            super(fragmentManager, 1);
            Intrinsics3.checkNotNullParameter(fragmentManager, "fm");
            Intrinsics3.checkNotNullParameter(itemArr, "items");
            this.items = _ArraysJvm.asList(itemArr);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.items.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int position) {
            Function0<Fragment> creator$utils_release;
            Fragment fragmentInvoke;
            Item item = (Item) _Collections.getOrNull(this.items, position);
            if (item != null && (creator$utils_release = item.getCreator$utils_release()) != null && (fragmentInvoke = creator$utils_release.invoke()) != null) {
                return fragmentInvoke;
            }
            throw new IllegalArgumentException("Invalid position: " + position + '.');
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int position) {
            String title;
            Item item = (Item) _Collections.getOrNull(this.items, position);
            return (item == null || (title = item.getTitle()) == null) ? super.getPageTitle(position) : title;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimplePager(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
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
        Intrinsics3.checkNotNullParameter(event, "event");
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
            childAt.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
            Intrinsics3.checkNotNullExpressionValue(childAt, "child");
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredHeight > i) {
                i = measuredHeight;
            }
        }
        if (i != 0) {
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, BasicMeasure.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics3.checkNotNullParameter(event, "event");
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
        Intrinsics3.checkNotNullParameter(context, "context");
        this.preserveSelectedPage = true;
        this.keepAllPagesLoaded = true;
        this.isScrollingEnabled = true;
    }
}

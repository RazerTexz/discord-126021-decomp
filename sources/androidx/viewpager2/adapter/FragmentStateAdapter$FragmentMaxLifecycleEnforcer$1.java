package androidx.viewpager2.adapter;

import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;

/* JADX INFO: loaded from: classes.dex */
public class FragmentStateAdapter$FragmentMaxLifecycleEnforcer$1 extends ViewPager2$OnPageChangeCallback {
    public final /* synthetic */ FragmentStateAdapter$FragmentMaxLifecycleEnforcer this$1;

    public FragmentStateAdapter$FragmentMaxLifecycleEnforcer$1(FragmentStateAdapter$FragmentMaxLifecycleEnforcer fragmentStateAdapter$FragmentMaxLifecycleEnforcer) {
        this.this$1 = fragmentStateAdapter$FragmentMaxLifecycleEnforcer;
    }

    @Override // androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback
    public void onPageScrollStateChanged(int i) {
        this.this$1.updateFragmentMaxLifecycle(false);
    }

    @Override // androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback
    public void onPageSelected(int i) {
        this.this$1.updateFragmentMaxLifecycle(false);
    }
}

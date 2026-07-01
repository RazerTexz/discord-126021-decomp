package b.b.a.a;

import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: renamed from: b.b.a.a.c, reason: use source file name */
/* JADX INFO: compiled from: AddContentDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AddContentDialogFragment3 implements ViewPager.OnPageChangeListener {
    public final /* synthetic */ AddContentDialogFragment a;

    public AddContentDialogFragment3(AddContentDialogFragment addContentDialogFragment) {
        this.a = addContentDialogFragment;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        TabLayout.Tab tabAt;
        TabLayout tabLayout = this.a.contentTabs;
        if (tabLayout == null || (tabAt = tabLayout.getTabAt(i)) == null) {
            return;
        }
        tabAt.select();
    }
}

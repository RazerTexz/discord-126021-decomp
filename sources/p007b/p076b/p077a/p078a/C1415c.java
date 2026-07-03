package p007b.p076b.p077a.p078a;

import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: renamed from: b.b.a.a.c */
/* JADX INFO: compiled from: AddContentDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C1415c implements ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C1413a f2130a;

    public C1415c(C1413a c1413a) {
        this.f2130a = c1413a;
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
        TabLayout tabLayout = this.f2130a.contentTabs;
        if (tabLayout == null || (tabAt = tabLayout.getTabAt(i)) == null) {
            return;
        }
        tabAt.select();
    }
}

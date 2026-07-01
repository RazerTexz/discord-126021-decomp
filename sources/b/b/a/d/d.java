package b.b.a.d;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/* JADX INFO: compiled from: AddContentPagerAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends FragmentStatePagerAdapter {
    public final d$a[] a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(FragmentManager fragmentManager, d$a... d_aArr) {
        super(fragmentManager, 1);
        d0.z.d.m.checkNotNullParameter(fragmentManager, "childFragmentManager");
        d0.z.d.m.checkNotNullParameter(d_aArr, "pageSuppliers");
        this.a = d_aArr;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.a.length;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        return this.a[i].createFragment();
    }
}

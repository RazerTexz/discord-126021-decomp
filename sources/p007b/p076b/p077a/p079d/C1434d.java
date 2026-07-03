package p007b.p076b.p077a.p079d;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.b.a.d.d */
/* JADX INFO: compiled from: AddContentPagerAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C1434d extends FragmentStatePagerAdapter {

    /* JADX INFO: renamed from: a */
    public final a[] f2141a;

    /* JADX INFO: renamed from: b.b.a.d.d$a */
    /* JADX INFO: compiled from: AddContentPagerAdapter.kt */
    public static abstract class a {
        private final int contentDesc;
        private final int icon;

        public a(@DrawableRes int i, @StringRes int i2) {
            this.icon = i;
            this.contentDesc = i2;
        }

        public abstract Fragment createFragment();

        public final int getContentDesc() {
            return this.contentDesc;
        }

        public final int getIcon() {
            return this.icon;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1434d(FragmentManager fragmentManager, a... aVarArr) {
        super(fragmentManager, 1);
        C12238m.checkNotNullParameter(fragmentManager, "childFragmentManager");
        C12238m.checkNotNullParameter(aVarArr, "pageSuppliers");
        this.f2141a = aVarArr;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f2141a.length;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        return this.f2141a[i].createFragment();
    }
}

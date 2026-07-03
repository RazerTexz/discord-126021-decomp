package p007b.p076b.p077a.p078a;

import androidx.viewpager.widget.ViewPager;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;

/* JADX INFO: renamed from: b.b.a.a.f */
/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C1418f implements ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ FlexInputFragment f2133a;

    public C1418f(FlexInputFragment flexInputFragment) {
        this.f2133a = flexInputFragment;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        FlexInputViewModel flexInputViewModel = this.f2133a.viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.onContentDialogPageChanged(i);
        }
    }
}

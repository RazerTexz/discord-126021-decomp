package b.b.a.a;

import androidx.viewpager.widget.ViewPager$OnPageChangeListener;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;

/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements ViewPager$OnPageChangeListener {
    public final /* synthetic */ FlexInputFragment a;

    public f(FlexInputFragment flexInputFragment) {
        this.a = flexInputFragment;
    }

    @Override // androidx.viewpager.widget.ViewPager$OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager$OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager$OnPageChangeListener
    public void onPageSelected(int i) {
        FlexInputViewModel flexInputViewModel = this.a.viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.onContentDialogPageChanged(i);
        }
    }
}

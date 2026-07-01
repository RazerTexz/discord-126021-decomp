package b.b.a.a;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.b.a.a.b, reason: use source file name */
/* JADX INFO: compiled from: AddContentDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AddContentDialogFragment2 implements TabLayout.OnTabSelectedListener {
    public final /* synthetic */ AddContentDialogFragment a;

    public AddContentDialogFragment2(AddContentDialogFragment addContentDialogFragment) {
        this.a = addContentDialogFragment;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        Intrinsics3.checkNotNullParameter(tab, "tab");
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        FlexInputViewModel flexInputViewModel;
        Intrinsics3.checkNotNullParameter(tab, "tab");
        int position = tab.getPosition();
        if (position != 3) {
            ViewPager viewPager = this.a.contentPager;
            if (viewPager != null) {
                viewPager.setCurrentItem(position);
                return;
            }
            return;
        }
        this.a.h(false);
        Fragment parentFragment = this.a.getParentFragment();
        if (!(parentFragment instanceof FlexInputFragment) || (flexInputViewModel = ((FlexInputFragment) parentFragment).viewModel) == null) {
            return;
        }
        flexInputViewModel.onCreateThreadSelected();
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        Intrinsics3.checkNotNullParameter(tab, "tab");
    }
}

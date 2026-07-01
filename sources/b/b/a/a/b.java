package b.b.a.a;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout$OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout$Tab;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;

/* JADX INFO: compiled from: AddContentDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements TabLayout$OnTabSelectedListener {
    public final /* synthetic */ a a;

    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.material.tabs.TabLayout$BaseOnTabSelectedListener
    public void onTabReselected(TabLayout$Tab tabLayout$Tab) {
        d0.z.d.m.checkNotNullParameter(tabLayout$Tab, "tab");
    }

    @Override // com.google.android.material.tabs.TabLayout$BaseOnTabSelectedListener
    public void onTabSelected(TabLayout$Tab tabLayout$Tab) {
        FlexInputViewModel flexInputViewModel;
        d0.z.d.m.checkNotNullParameter(tabLayout$Tab, "tab");
        int position = tabLayout$Tab.getPosition();
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

    @Override // com.google.android.material.tabs.TabLayout$BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout$Tab tabLayout$Tab) {
        d0.z.d.m.checkNotNullParameter(tabLayout$Tab, "tab");
    }
}

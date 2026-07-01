package com.discord.widgets.nux;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetNavigationHelp.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNavigationHelp$NuxPagerAdapter extends FragmentStateAdapter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNavigationHelp$NuxPagerAdapter(Fragment fragment) {
        super(fragment);
        m.checkNotNullParameter(fragment, "fragment");
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new WidgetNavigationHelp$NuxGuildsPageFragment();
        }
        if (position == 1) {
            return new WidgetNavigationHelp$NuxChannelsPageFragment();
        }
        if (position == 2) {
            return new WidgetNavigationHelp$NuxDmsPageFragment();
        }
        throw new IllegalStateException(a.q("unknown nux page: ", position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return 3;
    }
}

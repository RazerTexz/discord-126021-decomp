package com.discord.widgets.directories;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.app.AppFragment;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.hubs.DirectoryEntryCategory;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetDirectoryChannelViewPagerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryChannelViewPagerAdapter extends FragmentStateAdapter {
    private List<? extends DirectoryEntryCategory> tabs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoryChannelViewPagerAdapter(AppFragment appFragment) {
        super(appFragment);
        m.checkNotNullParameter(appFragment, "fragment");
        this.tabs = n.emptyList();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public /* bridge */ /* synthetic */ Fragment createFragment(int i) {
        return createFragment(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.tabs.size();
    }

    public final List<DirectoryEntryCategory> getTabs() {
        return this.tabs;
    }

    public final void setTabs(List<? extends DirectoryEntryCategory> list) {
        m.checkNotNullParameter(list, "value");
        this.tabs = list;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public WidgetDirectoryCategory createFragment(int position) {
        WidgetDirectoryCategory widgetDirectoryCategory = new WidgetDirectoryCategory();
        DirectoryEntryCategory directoryEntryCategory = (DirectoryEntryCategory) u.getOrNull(this.tabs, position);
        if (directoryEntryCategory != null) {
            widgetDirectoryCategory.setArguments(d.e2(new DirectoryCategoryArgs(directoryEntryCategory)));
            return widgetDirectoryCategory;
        }
        StringBuilder sbV = a.V("Couldn't find tab with position ", position, " in ");
        sbV.append(this.tabs);
        throw new IllegalStateException(sbV.toString());
    }
}

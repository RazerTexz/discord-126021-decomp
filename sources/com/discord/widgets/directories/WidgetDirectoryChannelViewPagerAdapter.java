package com.discord.widgets.directories;

import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.discord.app.AppFragment;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.hubs.DirectoryEntryCategory;
import java.util.List;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetDirectoryChannelViewPagerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryChannelViewPagerAdapter extends FragmentStateAdapter {
    private List<? extends DirectoryEntryCategory> tabs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoryChannelViewPagerAdapter(AppFragment appFragment) {
        super(appFragment);
        C12238m.checkNotNullParameter(appFragment, "fragment");
        this.tabs = C12147n.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.tabs.size();
    }

    public final List<DirectoryEntryCategory> getTabs() {
        return this.tabs;
    }

    public final void setTabs(List<? extends DirectoryEntryCategory> list) {
        C12238m.checkNotNullParameter(list, "value");
        this.tabs = list;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public WidgetDirectoryCategory createFragment(int position) {
        WidgetDirectoryCategory widgetDirectoryCategory = new WidgetDirectoryCategory();
        DirectoryEntryCategory directoryEntryCategory = (DirectoryEntryCategory) C12163u.getOrNull(this.tabs, position);
        if (directoryEntryCategory != null) {
            widgetDirectoryCategory.setArguments(C1460d.m514e2(new DirectoryCategoryArgs(directoryEntryCategory)));
            return widgetDirectoryCategory;
        }
        StringBuilder sbM834V = C1643a.m834V("Couldn't find tab with position ", position, " in ");
        sbM834V.append(this.tabs);
        throw new IllegalStateException(sbM834V.toString());
    }
}

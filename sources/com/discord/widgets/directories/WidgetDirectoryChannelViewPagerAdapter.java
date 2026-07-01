package com.discord.widgets.directories;

import androidx.viewpager2.adapter.FragmentStateAdapter;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.app.AppFragment;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.hubs.DirectoryEntryCategory;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: WidgetDirectoryChannelViewPagerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryChannelViewPagerAdapter extends FragmentStateAdapter {
    private List<? extends DirectoryEntryCategory> tabs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoryChannelViewPagerAdapter(AppFragment appFragment) {
        super(appFragment);
        Intrinsics3.checkNotNullParameter(appFragment, "fragment");
        this.tabs = Collections2.emptyList();
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
        Intrinsics3.checkNotNullParameter(list, "value");
        this.tabs = list;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public WidgetDirectoryCategory createFragment(int position) {
        WidgetDirectoryCategory widgetDirectoryCategory = new WidgetDirectoryCategory();
        DirectoryEntryCategory directoryEntryCategory = (DirectoryEntryCategory) _Collections.getOrNull(this.tabs, position);
        if (directoryEntryCategory != null) {
            widgetDirectoryCategory.setArguments(AnimatableValueParser.e2(new WidgetDirectoryCategory2(directoryEntryCategory)));
            return widgetDirectoryCategory;
        }
        StringBuilder sbV = outline.V("Couldn't find tab with position ", position, " in ");
        sbV.append(this.tabs);
        throw new IllegalStateException(sbV.toString());
    }
}

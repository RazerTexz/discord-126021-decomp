package com.discord.widgets.quickmentions;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.user.WidgetUserMentions;
import com.discord.widgets.user.search.WidgetGlobalSearch;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetQuickMentionsDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetQuickMentionsDialog$TabsAdapter extends FragmentStateAdapter {
    private final String searchText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetQuickMentionsDialog$TabsAdapter(WidgetQuickMentionsDialog widgetQuickMentionsDialog, String str) {
        super(widgetQuickMentionsDialog);
        m.checkNotNullParameter(widgetQuickMentionsDialog, "fragment");
        this.searchText = str;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int position) {
        if (position == 0) {
            return WidgetGlobalSearch.Companion.create(this.searchText);
        }
        if (position == 1) {
            return WidgetUserMentions.Companion.create(true);
        }
        throw new UnsupportedOperationException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return 2;
    }

    public final int getItemTitleResId(int position) {
        if (position == 0) {
            return 2131895292;
        }
        if (position == 1) {
            return 2131892952;
        }
        throw new UnsupportedOperationException();
    }
}

package com.discord.widgets.channels.memberlist.adapter;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetChannelMembersListItemHeaderBinding;
import com.discord.databinding.WidgetChannelMembersListItemPlaceholderHeaderBinding;
import com.discord.utilities.views.StickyHeaderItemDecoration$LayoutManager;
import com.discord.widgets.roles.RoleIconView;
import d0.z.d.m;

/* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListAdapter$StickyHeadersManager {
    private View currentStickyHeaderView;
    private final WidgetChannelMembersListItemHeaderBinding headerViewBinding;
    private final ChannelMembersListViewHolderHeader onlineOfflineStickyHeader;
    private final WidgetChannelMembersListItemPlaceholderHeaderBinding placeholderHeaderViewBinding;
    private final ChannelMembersListViewHolderRoleHeader roleStickyHeader;

    public ChannelMembersListAdapter$StickyHeadersManager(WidgetChannelMembersListItemHeaderBinding widgetChannelMembersListItemHeaderBinding, WidgetChannelMembersListItemPlaceholderHeaderBinding widgetChannelMembersListItemPlaceholderHeaderBinding) {
        m.checkNotNullParameter(widgetChannelMembersListItemHeaderBinding, "headerViewBinding");
        m.checkNotNullParameter(widgetChannelMembersListItemPlaceholderHeaderBinding, "placeholderHeaderViewBinding");
        this.headerViewBinding = widgetChannelMembersListItemHeaderBinding;
        this.placeholderHeaderViewBinding = widgetChannelMembersListItemPlaceholderHeaderBinding;
        this.roleStickyHeader = new ChannelMembersListViewHolderRoleHeader(widgetChannelMembersListItemHeaderBinding);
        this.onlineOfflineStickyHeader = new ChannelMembersListViewHolderHeader(widgetChannelMembersListItemHeaderBinding);
        this.currentStickyHeaderView = widgetChannelMembersListItemHeaderBinding.a;
    }

    public final void bindStickyHeaderView(ChannelMembersListAdapter$Item row) {
        m.checkNotNullParameter(row, "row");
        if (row instanceof ChannelMembersListAdapter$Item$RoleHeader) {
            this.roleStickyHeader.bind((ChannelMembersListAdapter$Item$RoleHeader) row);
            this.currentStickyHeaderView = this.headerViewBinding.a;
            return;
        }
        if (row instanceof ChannelMembersListAdapter$Item$Header) {
            this.onlineOfflineStickyHeader.bind((ChannelMembersListAdapter$Item$Header) row);
            WidgetChannelMembersListItemHeaderBinding widgetChannelMembersListItemHeaderBinding = this.headerViewBinding;
            this.currentStickyHeaderView = widgetChannelMembersListItemHeaderBinding.a;
            RoleIconView roleIconView = widgetChannelMembersListItemHeaderBinding.f2259b;
            m.checkNotNullExpressionValue(roleIconView, "headerViewBinding.channe…ersListItemHeaderRoleIcon");
            roleIconView.setVisibility(8);
            return;
        }
        if (row instanceof ChannelMembersListAdapter$Item$PlaceholderHeader) {
            this.currentStickyHeaderView = this.placeholderHeaderViewBinding.a;
            RoleIconView roleIconView2 = this.headerViewBinding.f2259b;
            m.checkNotNullExpressionValue(roleIconView2, "headerViewBinding.channe…ersListItemHeaderRoleIcon");
            roleIconView2.setVisibility(8);
            return;
        }
        if (row instanceof ChannelMembersListAdapter$Item$AddMember) {
            this.currentStickyHeaderView = null;
            RoleIconView roleIconView3 = this.headerViewBinding.f2259b;
            m.checkNotNullExpressionValue(roleIconView3, "headerViewBinding.channe…ersListItemHeaderRoleIcon");
            roleIconView3.setVisibility(8);
        }
    }

    public final View getCurrentStickyHeaderView() {
        return this.currentStickyHeaderView;
    }

    public final void layoutViews(RecyclerView recyclerView) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        LinearLayout linearLayout = this.headerViewBinding.a;
        m.checkNotNullExpressionValue(linearLayout, "headerViewBinding.root");
        StickyHeaderItemDecoration$LayoutManager.layoutHeaderView(recyclerView, linearLayout);
        FrameLayout frameLayout = this.placeholderHeaderViewBinding.a;
        m.checkNotNullExpressionValue(frameLayout, "placeholderHeaderViewBinding.root");
        StickyHeaderItemDecoration$LayoutManager.layoutHeaderView(recyclerView, frameLayout);
    }
}

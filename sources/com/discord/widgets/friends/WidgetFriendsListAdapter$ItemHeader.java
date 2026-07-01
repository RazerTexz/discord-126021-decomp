package com.discord.widgets.friends;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetFriendsListAdapterItemHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemHeader extends WidgetFriendsListAdapter$Item {
    private final WidgetFriendsListAdapterItemHeaderBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsListAdapter$ItemHeader(WidgetFriendsListAdapter widgetFriendsListAdapter) {
        super(R$layout.widget_friends_list_adapter_item_header, widgetFriendsListAdapter);
        m.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(R$id.friends_list_item_header_text);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.friends_list_item_header_text)));
        }
        WidgetFriendsListAdapterItemHeaderBinding widgetFriendsListAdapterItemHeaderBinding = new WidgetFriendsListAdapterItemHeaderBinding((FrameLayout) view, textView);
        m.checkNotNullExpressionValue(widgetFriendsListAdapterItemHeaderBinding, "WidgetFriendsListAdapter…derBinding.bind(itemView)");
        this.binding = widgetFriendsListAdapterItemHeaderBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, FriendsListViewModel$Item friendsListViewModel$Item) {
        onConfigure2(i, friendsListViewModel$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, FriendsListViewModel$Item data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        FriendsListViewModel$Item$Header friendsListViewModel$Item$Header = (FriendsListViewModel$Item$Header) data;
        TextView textView = this.binding.f2393b;
        m.checkNotNullExpressionValue(textView, "binding.friendsListItemHeaderText");
        b.n(textView, friendsListViewModel$Item$Header.getTitleStringResId(), new Object[]{Integer.valueOf(friendsListViewModel$Item$Header.getCount())}, null, 4);
    }
}

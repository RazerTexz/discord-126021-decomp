package com.discord.widgets.friends;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import b.a.k.b;
import com.discord.R$layout;
import com.discord.databinding.WidgetFriendsListExpandableHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.drawable.DrawableCompat;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemPendingHeader extends WidgetFriendsListAdapter$Item {
    private final WidgetFriendsListExpandableHeaderBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsListAdapter$ItemPendingHeader(WidgetFriendsListAdapter widgetFriendsListAdapter) {
        super(R$layout.widget_friends_list_expandable_header, widgetFriendsListAdapter);
        m.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
        WidgetFriendsListExpandableHeaderBinding widgetFriendsListExpandableHeaderBindingA = WidgetFriendsListExpandableHeaderBinding.a(this.itemView);
        m.checkNotNullExpressionValue(widgetFriendsListExpandableHeaderBindingA, "WidgetFriendsListExpanda…derBinding.bind(itemView)");
        this.binding = widgetFriendsListExpandableHeaderBindingA;
    }

    public static final /* synthetic */ WidgetFriendsListAdapter access$getAdapter$p(WidgetFriendsListAdapter$ItemPendingHeader widgetFriendsListAdapter$ItemPendingHeader) {
        return (WidgetFriendsListAdapter) widgetFriendsListAdapter$ItemPendingHeader.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, FriendsListViewModel$Item friendsListViewModel$Item) {
        onConfigure2(i, friendsListViewModel$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, FriendsListViewModel$Item data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        FriendsListViewModel$Item$PendingHeader friendsListViewModel$Item$PendingHeader = (FriendsListViewModel$Item$PendingHeader) data;
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.friendsListPendingItemHeaderText");
        b.n(textView, friendsListViewModel$Item$PendingHeader.getTitleStringResId(), new Object[]{Integer.valueOf(friendsListViewModel$Item$PendingHeader.getCount())}, null, 4);
        if (!friendsListViewModel$Item$PendingHeader.getShowExpandButton()) {
            TextView textView2 = this.binding.f2398b;
            m.checkNotNullExpressionValue(textView2, "binding.friendsListExpandableHeaderButton");
            textView2.setVisibility(8);
            return;
        }
        TextView textView3 = this.binding.f2398b;
        m.checkNotNullExpressionValue(textView3, "binding.friendsListExpandableHeaderButton");
        textView3.setVisibility(0);
        int i = friendsListViewModel$Item$PendingHeader.isPendingSectionExpanded() ? 2131889488 : 2131889487;
        TextView textView4 = this.binding.f2398b;
        m.checkNotNullExpressionValue(textView4, "binding.friendsListExpandableHeaderButton");
        b.n(textView4, i, new Object[0], null, 4);
        int i2 = friendsListViewModel$Item$PendingHeader.isPendingSectionExpanded() ? 2131231532 : 2131231530;
        TextView textView5 = this.binding.f2398b;
        m.checkNotNullExpressionValue(textView5, "binding.friendsListExpandableHeaderButton");
        Drawable drawable = ContextCompat.getDrawable(textView5.getContext(), i2);
        TextView textView6 = this.binding.f2398b;
        m.checkNotNullExpressionValue(textView6, "binding.friendsListExpandableHeaderButton");
        DrawableCompat.setCompoundDrawablesCompat$default(textView6, (Drawable) null, (Drawable) null, drawable, (Drawable) null, 11, (Object) null);
        this.binding.f2398b.setOnClickListener(new WidgetFriendsListAdapter$ItemPendingHeader$onConfigure$1(this));
    }
}

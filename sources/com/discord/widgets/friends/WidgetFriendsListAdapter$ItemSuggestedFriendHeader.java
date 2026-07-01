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
public final class WidgetFriendsListAdapter$ItemSuggestedFriendHeader extends WidgetFriendsListAdapter$Item {
    private final WidgetFriendsListExpandableHeaderBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsListAdapter$ItemSuggestedFriendHeader(WidgetFriendsListAdapter widgetFriendsListAdapter) {
        super(R$layout.widget_friends_list_expandable_header, widgetFriendsListAdapter);
        m.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
        WidgetFriendsListExpandableHeaderBinding widgetFriendsListExpandableHeaderBindingA = WidgetFriendsListExpandableHeaderBinding.a(this.itemView);
        m.checkNotNullExpressionValue(widgetFriendsListExpandableHeaderBindingA, "WidgetFriendsListExpanda…derBinding.bind(itemView)");
        this.binding = widgetFriendsListExpandableHeaderBindingA;
    }

    public static final /* synthetic */ WidgetFriendsListAdapter access$getAdapter$p(WidgetFriendsListAdapter$ItemSuggestedFriendHeader widgetFriendsListAdapter$ItemSuggestedFriendHeader) {
        return (WidgetFriendsListAdapter) widgetFriendsListAdapter$ItemSuggestedFriendHeader.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, FriendsListViewModel$Item friendsListViewModel$Item) {
        onConfigure2(i, friendsListViewModel$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, FriendsListViewModel$Item data) {
        CharSequence charSequenceJ;
        m.checkNotNullParameter(data, "data");
        FriendsListViewModel$Item$SuggestedFriendsHeader friendsListViewModel$Item$SuggestedFriendsHeader = (FriendsListViewModel$Item$SuggestedFriendsHeader) data;
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.friendsListPendingItemHeaderText");
        b.m(textView, 2131889483, new Object[0], new WidgetFriendsListAdapter$ItemSuggestedFriendHeader$onConfigure$1(data));
        if (!friendsListViewModel$Item$SuggestedFriendsHeader.getShowExpandButton()) {
            TextView textView2 = this.binding.f2398b;
            m.checkNotNullExpressionValue(textView2, "binding.friendsListExpandableHeaderButton");
            textView2.setVisibility(8);
            return;
        }
        TextView textView3 = this.binding.f2398b;
        m.checkNotNullExpressionValue(textView3, "binding.friendsListExpandableHeaderButton");
        textView3.setVisibility(0);
        TextView textView4 = this.binding.f2398b;
        m.checkNotNullExpressionValue(textView4, "binding.friendsListExpandableHeaderButton");
        if (friendsListViewModel$Item$SuggestedFriendsHeader.isExpanded()) {
            TextView textView5 = this.binding.f2398b;
            m.checkNotNullExpressionValue(textView5, "binding.friendsListExpandableHeaderButton");
            charSequenceJ = b.j(textView5, 2131889488, new Object[0], null, 4);
        } else {
            TextView textView6 = this.binding.f2398b;
            m.checkNotNullExpressionValue(textView6, "binding.friendsListExpandableHeaderButton");
            charSequenceJ = b.j(textView6, 2131889487, new Object[0], null, 4);
        }
        textView4.setText(charSequenceJ);
        int i = friendsListViewModel$Item$SuggestedFriendsHeader.isExpanded() ? 2131231532 : 2131231530;
        TextView textView7 = this.binding.f2398b;
        m.checkNotNullExpressionValue(textView7, "binding.friendsListExpandableHeaderButton");
        Drawable drawable = ContextCompat.getDrawable(textView7.getContext(), i);
        TextView textView8 = this.binding.f2398b;
        m.checkNotNullExpressionValue(textView8, "binding.friendsListExpandableHeaderButton");
        DrawableCompat.setCompoundDrawablesCompat$default(textView8, (Drawable) null, (Drawable) null, drawable, (Drawable) null, 11, (Object) null);
        this.binding.f2398b.setOnClickListener(new WidgetFriendsListAdapter$ItemSuggestedFriendHeader$onConfigure$2(this));
    }
}

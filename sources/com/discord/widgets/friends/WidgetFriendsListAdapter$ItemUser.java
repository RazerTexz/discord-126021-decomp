package com.discord.widgets.friends;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetFriendsListAdapterItemFriendBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemUser extends WidgetFriendsListAdapter$Item {
    private final WidgetFriendsListAdapterItemFriendBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsListAdapter$ItemUser(WidgetFriendsListAdapter widgetFriendsListAdapter) {
        super(R$layout.widget_friends_list_adapter_item_friend, widgetFriendsListAdapter);
        m.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.friends_list_item_activity;
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R$id.friends_list_item_activity);
        if (simpleDraweeSpanTextView != null) {
            i = R$id.friends_list_item_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.friends_list_item_avatar);
            if (simpleDraweeView != null) {
                i = R$id.friends_list_item_buttons_wrap;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.friends_list_item_buttons_wrap);
                if (linearLayout != null) {
                    i = R$id.friends_list_item_call_button;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R$id.friends_list_item_call_button);
                    if (appCompatImageView != null) {
                        i = R$id.friends_list_item_chat_button;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(R$id.friends_list_item_chat_button);
                        if (appCompatImageView2 != null) {
                            i = R$id.friends_list_item_name;
                            TextView textView = (TextView) view.findViewById(R$id.friends_list_item_name);
                            if (textView != null) {
                                i = R$id.friends_list_item_status;
                                StatusView statusView = (StatusView) view.findViewById(R$id.friends_list_item_status);
                                if (statusView != null) {
                                    i = R$id.friends_list_item_text;
                                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R$id.friends_list_item_text);
                                    if (linearLayout2 != null) {
                                        WidgetFriendsListAdapterItemFriendBinding widgetFriendsListAdapterItemFriendBinding = new WidgetFriendsListAdapterItemFriendBinding((RelativeLayout) view, simpleDraweeSpanTextView, simpleDraweeView, linearLayout, appCompatImageView, appCompatImageView2, textView, statusView, linearLayout2);
                                        m.checkNotNullExpressionValue(widgetFriendsListAdapterItemFriendBinding, "WidgetFriendsListAdapter…endBinding.bind(itemView)");
                                        this.binding = widgetFriendsListAdapterItemFriendBinding;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetFriendsListAdapter access$getAdapter$p(WidgetFriendsListAdapter$ItemUser widgetFriendsListAdapter$ItemUser) {
        return (WidgetFriendsListAdapter) widgetFriendsListAdapter$ItemUser.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, FriendsListViewModel$Item friendsListViewModel$Item) {
        onConfigure2(i, friendsListViewModel$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, FriendsListViewModel$Item data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        FriendsListViewModel$Item$Friend friendsListViewModel$Item$Friend = (FriendsListViewModel$Item$Friend) data;
        this.binding.a.setOnClickListener(new WidgetFriendsListAdapter$ItemUser$onConfigure$1(this, data));
        TextView textView = this.binding.f;
        m.checkNotNullExpressionValue(textView, "binding.friendsListItemName");
        textView.setText(friendsListViewModel$Item$Friend.getUser().getUsername());
        this.binding.g.setPresence(friendsListViewModel$Item$Friend.getPresence());
        Presence presence = friendsListViewModel$Item$Friend.getPresence();
        boolean zIsApplicationStreaming = friendsListViewModel$Item$Friend.isApplicationStreaming();
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.f2392b;
        m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.friendsListItemActivity");
        PresenceUtils.setPresenceText$default(presence, zIsApplicationStreaming, simpleDraweeSpanTextView, true, false, 16, null);
        SimpleDraweeView simpleDraweeView = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.friendsListItemAvatar");
        IconUtils.setIcon$default(simpleDraweeView, friendsListViewModel$Item$Friend.getUser(), 2131165300, null, null, null, 56, null);
        this.binding.d.setOnClickListener(new WidgetFriendsListAdapter$ItemUser$onConfigure$2(this, friendsListViewModel$Item$Friend));
        this.binding.e.setOnClickListener(new WidgetFriendsListAdapter$ItemUser$onConfigure$3(this, friendsListViewModel$Item$Friend));
    }
}

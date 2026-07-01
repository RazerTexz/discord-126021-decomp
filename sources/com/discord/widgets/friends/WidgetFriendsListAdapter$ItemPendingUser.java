package com.discord.widgets.friends;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetFriendsListAdapterItemPendingBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemPendingUser extends WidgetFriendsListAdapter$Item {
    private final WidgetFriendsListAdapterItemPendingBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsListAdapter$ItemPendingUser(WidgetFriendsListAdapter widgetFriendsListAdapter) {
        super(R$layout.widget_friends_list_adapter_item_pending, widgetFriendsListAdapter);
        m.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.friends_list_item_accept_button;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R$id.friends_list_item_accept_button);
        if (appCompatImageView != null) {
            i = R$id.friends_list_item_activity;
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R$id.friends_list_item_activity);
            if (simpleDraweeSpanTextView != null) {
                i = R$id.friends_list_item_avatar;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.friends_list_item_avatar);
                if (simpleDraweeView != null) {
                    i = R$id.friends_list_item_buttons_wrap;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.friends_list_item_buttons_wrap);
                    if (linearLayout != null) {
                        i = R$id.friends_list_item_decline_button;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(R$id.friends_list_item_decline_button);
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
                                        WidgetFriendsListAdapterItemPendingBinding widgetFriendsListAdapterItemPendingBinding = new WidgetFriendsListAdapterItemPendingBinding((RelativeLayout) view, appCompatImageView, simpleDraweeSpanTextView, simpleDraweeView, linearLayout, appCompatImageView2, textView, statusView, linearLayout2);
                                        m.checkNotNullExpressionValue(widgetFriendsListAdapterItemPendingBinding, "WidgetFriendsListAdapter…ingBinding.bind(itemView)");
                                        this.binding = widgetFriendsListAdapterItemPendingBinding;
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

    public static final /* synthetic */ WidgetFriendsListAdapter access$getAdapter$p(WidgetFriendsListAdapter$ItemPendingUser widgetFriendsListAdapter$ItemPendingUser) {
        return (WidgetFriendsListAdapter) widgetFriendsListAdapter$ItemPendingUser.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, FriendsListViewModel$Item friendsListViewModel$Item) {
        onConfigure2(i, friendsListViewModel$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, FriendsListViewModel$Item data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        FriendsListViewModel$Item$PendingFriendRequest friendsListViewModel$Item$PendingFriendRequest = (FriendsListViewModel$Item$PendingFriendRequest) data;
        this.binding.a.setOnClickListener(new WidgetFriendsListAdapter$ItemPendingUser$onConfigure$1(this, data));
        TextView textView = this.binding.f;
        m.checkNotNullExpressionValue(textView, "binding.friendsListItemName");
        textView.setText(friendsListViewModel$Item$PendingFriendRequest.getUser().getUsername());
        this.binding.g.setPresence(friendsListViewModel$Item$PendingFriendRequest.getPresence());
        int relationshipType = friendsListViewModel$Item$PendingFriendRequest.getRelationshipType();
        if (relationshipType == 3) {
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.c;
            m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.friendsListItemActivity");
            SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = this.binding.c;
            m.checkNotNullExpressionValue(simpleDraweeSpanTextView2, "binding.friendsListItemActivity");
            ViewExtensions.setTextAndVisibilityBy(simpleDraweeSpanTextView, b.j(simpleDraweeSpanTextView2, 2131892031, new Object[0], null, 4));
            AppCompatImageView appCompatImageView = this.binding.f2394b;
            m.checkNotNullExpressionValue(appCompatImageView, "binding.friendsListItemAcceptButton");
            appCompatImageView.setVisibility(0);
        } else if (relationshipType == 4) {
            SimpleDraweeSpanTextView simpleDraweeSpanTextView3 = this.binding.c;
            m.checkNotNullExpressionValue(simpleDraweeSpanTextView3, "binding.friendsListItemActivity");
            SimpleDraweeSpanTextView simpleDraweeSpanTextView4 = this.binding.c;
            m.checkNotNullExpressionValue(simpleDraweeSpanTextView4, "binding.friendsListItemActivity");
            ViewExtensions.setTextAndVisibilityBy(simpleDraweeSpanTextView3, b.j(simpleDraweeSpanTextView4, 2131893553, new Object[0], null, 4));
            AppCompatImageView appCompatImageView2 = this.binding.f2394b;
            m.checkNotNullExpressionValue(appCompatImageView2, "binding.friendsListItemAcceptButton");
            appCompatImageView2.setVisibility(8);
        }
        SimpleDraweeView simpleDraweeView = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.friendsListItemAvatar");
        IconUtils.setIcon$default(simpleDraweeView, friendsListViewModel$Item$PendingFriendRequest.getUser(), 2131165300, null, null, null, 56, null);
        this.binding.f2394b.setOnClickListener(new WidgetFriendsListAdapter$ItemPendingUser$onConfigure$2(this, friendsListViewModel$Item$PendingFriendRequest));
        this.binding.e.setOnClickListener(new WidgetFriendsListAdapter$ItemPendingUser$onConfigure$3(this, friendsListViewModel$Item$PendingFriendRequest));
    }
}

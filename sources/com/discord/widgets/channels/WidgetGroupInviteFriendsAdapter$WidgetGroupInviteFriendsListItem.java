package com.discord.widgets.channels;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetGroupInviteFriendsItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGroupInviteFriendsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriendsAdapter$WidgetGroupInviteFriendsListItem extends MGRecyclerViewHolder<WidgetGroupInviteFriendsAdapter, WidgetGroupInviteFriends$Model$FriendItem> {
    private final WidgetGroupInviteFriendsItemBinding binding;
    public final /* synthetic */ WidgetGroupInviteFriendsAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGroupInviteFriendsAdapter$WidgetGroupInviteFriendsListItem(WidgetGroupInviteFriendsAdapter widgetGroupInviteFriendsAdapter, WidgetGroupInviteFriendsAdapter widgetGroupInviteFriendsAdapter2) {
        super(R$layout.widget_group_invite_friends_item, widgetGroupInviteFriendsAdapter2);
        m.checkNotNullParameter(widgetGroupInviteFriendsAdapter2, "adapter");
        this.this$0 = widgetGroupInviteFriendsAdapter;
        View view = this.itemView;
        int i = R$id.friend_container;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R$id.friend_container);
        if (relativeLayout != null) {
            i = R$id.friends_list_item_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.friends_list_item_avatar);
            if (simpleDraweeView != null) {
                i = R$id.friends_list_item_avatar_wrap;
                RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R$id.friends_list_item_avatar_wrap);
                if (relativeLayout2 != null) {
                    i = R$id.friends_list_item_game;
                    SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R$id.friends_list_item_game);
                    if (simpleDraweeSpanTextView != null) {
                        i = R$id.friends_list_item_name;
                        TextView textView = (TextView) view.findViewById(R$id.friends_list_item_name);
                        if (textView != null) {
                            i = R$id.friends_list_item_status;
                            StatusView statusView = (StatusView) view.findViewById(R$id.friends_list_item_status);
                            if (statusView != null) {
                                i = R$id.user_selected_checkbox;
                                CheckBox checkBox = (CheckBox) view.findViewById(R$id.user_selected_checkbox);
                                if (checkBox != null) {
                                    WidgetGroupInviteFriendsItemBinding widgetGroupInviteFriendsItemBinding = new WidgetGroupInviteFriendsItemBinding((LinearLayout) view, relativeLayout, simpleDraweeView, relativeLayout2, simpleDraweeSpanTextView, textView, statusView, checkBox);
                                    m.checkNotNullExpressionValue(widgetGroupInviteFriendsItemBinding, "WidgetGroupInviteFriendsItemBinding.bind(itemView)");
                                    this.binding = widgetGroupInviteFriendsItemBinding;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetGroupInviteFriendsAdapter access$getAdapter$p(WidgetGroupInviteFriendsAdapter$WidgetGroupInviteFriendsListItem widgetGroupInviteFriendsAdapter$WidgetGroupInviteFriendsListItem) {
        return (WidgetGroupInviteFriendsAdapter) widgetGroupInviteFriendsAdapter$WidgetGroupInviteFriendsListItem.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGroupInviteFriends$Model$FriendItem widgetGroupInviteFriends$Model$FriendItem) {
        onConfigure2(i, widgetGroupInviteFriends$Model$FriendItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetGroupInviteFriends$Model$FriendItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.friendsListItemName");
        User user = data.getUser();
        textView.setText(user != null ? user.getUsername() : null);
        this.binding.f.setPresence(data.getPresence());
        CheckBox checkBox = this.binding.g;
        m.checkNotNullExpressionValue(checkBox, "binding.userSelectedCheckbox");
        checkBox.setChecked(data.isSelected());
        this.binding.f2407b.setOnClickListener(new WidgetGroupInviteFriendsAdapter$WidgetGroupInviteFriendsListItem$onConfigure$1(this, data));
        Presence presence = data.getPresence();
        boolean zIsApplicationStreaming = data.isApplicationStreaming();
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.friendsListItemGame");
        PresenceUtils.setPresenceText$default(presence, zIsApplicationStreaming, simpleDraweeSpanTextView, true, false, 16, null);
        SimpleDraweeView simpleDraweeView = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.friendsListItemAvatar");
        IconUtils.setIcon$default(simpleDraweeView, data.getUser(), 2131165300, null, null, null, 56, null);
    }
}

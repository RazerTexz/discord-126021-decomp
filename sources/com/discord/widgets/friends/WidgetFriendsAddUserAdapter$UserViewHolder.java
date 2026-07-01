package com.discord.widgets.friends;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetAddFriendUserListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.user.UserUtils;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.u;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetFriendsAddUserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsAddUserAdapter$UserViewHolder extends MGRecyclerViewHolder<WidgetFriendsAddUserAdapter, WidgetFriendsAddUserAdapter$ItemUser> {
    private final WidgetAddFriendUserListItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsAddUserAdapter$UserViewHolder(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
        super(R$layout.widget_add_friend_user_list_item, widgetFriendsAddUserAdapter);
        m.checkNotNullParameter(widgetFriendsAddUserAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.add_friend_user_accept_button;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R$id.add_friend_user_accept_button);
        if (appCompatImageView != null) {
            i = R$id.add_friend_user_check_image;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(R$id.add_friend_user_check_image);
            if (appCompatImageView2 != null) {
                i = R$id.add_friend_user_decline_button;
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) view.findViewById(R$id.add_friend_user_decline_button);
                if (appCompatImageView3 != null) {
                    i = R$id.add_friend_user_item_avatar;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.add_friend_user_item_avatar);
                    if (simpleDraweeView != null) {
                        i = R$id.add_friend_user_item_buttons;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.add_friend_user_item_buttons);
                        if (linearLayout != null) {
                            i = R$id.add_friend_user_item_name;
                            TextView textView = (TextView) view.findViewById(R$id.add_friend_user_item_name);
                            if (textView != null) {
                                i = R$id.add_friend_user_item_name_secondary;
                                TextView textView2 = (TextView) view.findViewById(R$id.add_friend_user_item_name_secondary);
                                if (textView2 != null) {
                                    i = R$id.add_friend_user_item_status;
                                    StatusView statusView = (StatusView) view.findViewById(R$id.add_friend_user_item_status);
                                    if (statusView != null) {
                                        i = R$id.add_friend_user_item_text;
                                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R$id.add_friend_user_item_text);
                                        if (linearLayout2 != null) {
                                            i = R$id.add_friend_user_send_button;
                                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) view.findViewById(R$id.add_friend_user_send_button);
                                            if (appCompatImageView4 != null) {
                                                WidgetAddFriendUserListItemBinding widgetAddFriendUserListItemBinding = new WidgetAddFriendUserListItemBinding((ConstraintLayout) view, appCompatImageView, appCompatImageView2, appCompatImageView3, simpleDraweeView, linearLayout, textView, textView2, statusView, linearLayout2, appCompatImageView4);
                                                m.checkNotNullExpressionValue(widgetAddFriendUserListItemBinding, "WidgetAddFriendUserListItemBinding.bind(itemView)");
                                                this.binding = widgetAddFriendUserListItemBinding;
                                                return;
                                            }
                                        }
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

    public static final /* synthetic */ WidgetFriendsAddUserAdapter access$getAdapter$p(WidgetFriendsAddUserAdapter$UserViewHolder widgetFriendsAddUserAdapter$UserViewHolder) {
        return (WidgetFriendsAddUserAdapter) widgetFriendsAddUserAdapter$UserViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetFriendsAddUserAdapter$ItemUser widgetFriendsAddUserAdapter$ItemUser) {
        onConfigure2(i, widgetFriendsAddUserAdapter$ItemUser);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetFriendsAddUserAdapter$ItemUser data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        User user = data.getUser();
        SimpleDraweeView simpleDraweeView = this.binding.e;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.addFriendUserItemAvatar");
        IconUtils.setIcon$default(simpleDraweeView, user, 0, null, null, null, 60, null);
        TextView textView = this.binding.f;
        m.checkNotNullExpressionValue(textView, "binding.addFriendUserItemName");
        CharSequence username = (CharSequence) u.lastOrNull((List) data.getAliases());
        if (username == null) {
            username = user.getUsername();
        }
        textView.setText(username);
        TextView textView2 = this.binding.g;
        m.checkNotNullExpressionValue(textView2, "binding.addFriendUserItemNameSecondary");
        textView2.setText(UserUtils.INSTANCE.getDiscriminatorWithPadding(user));
        this.binding.h.setPresence(data.getPresence());
        StatusView statusView = this.binding.h;
        m.checkNotNullExpressionValue(statusView, "binding.addFriendUserItemStatus");
        boolean z2 = true;
        statusView.setVisibility(data.getPresence() != null ? 0 : 8);
        long id2 = data.getUser().getId();
        boolean zContains = WidgetFriendsAddUserAdapter.access$getOutgoingRequestUserIds$p((WidgetFriendsAddUserAdapter) this.adapter).contains(Long.valueOf(id2));
        boolean zContains2 = WidgetFriendsAddUserAdapter.access$getIncomingRequestUserIds$p((WidgetFriendsAddUserAdapter) this.adapter).contains(Long.valueOf(id2));
        this.binding.f2223b.setOnClickListener(new WidgetFriendsAddUserAdapter$UserViewHolder$onConfigure$1(this, id2));
        this.binding.d.setOnClickListener(new WidgetFriendsAddUserAdapter$UserViewHolder$onConfigure$2(this, id2, zContains2));
        this.binding.i.setOnClickListener(new WidgetFriendsAddUserAdapter$UserViewHolder$onConfigure$3(this, user));
        this.binding.a.setOnClickListener(new WidgetFriendsAddUserAdapter$UserViewHolder$onConfigure$4(this, id2));
        AppCompatImageView appCompatImageView = this.binding.c;
        m.checkNotNullExpressionValue(appCompatImageView, "binding.addFriendUserCheckImage");
        appCompatImageView.setVisibility(data.isFriend() ? 0 : 8);
        AppCompatImageView appCompatImageView2 = this.binding.i;
        m.checkNotNullExpressionValue(appCompatImageView2, "binding.addFriendUserSendButton");
        appCompatImageView2.setVisibility(!data.isFriend() && !zContains && !zContains2 ? 0 : 8);
        AppCompatImageView appCompatImageView3 = this.binding.f2223b;
        m.checkNotNullExpressionValue(appCompatImageView3, "binding.addFriendUserAcceptButton");
        appCompatImageView3.setVisibility(!data.isFriend() && zContains2 ? 0 : 8);
        AppCompatImageView appCompatImageView4 = this.binding.d;
        m.checkNotNullExpressionValue(appCompatImageView4, "binding.addFriendUserDeclineButton");
        if (data.isFriend() || (!zContains && !zContains2)) {
            z2 = false;
        }
        appCompatImageView4.setVisibility(z2 ? 0 : 8);
    }
}

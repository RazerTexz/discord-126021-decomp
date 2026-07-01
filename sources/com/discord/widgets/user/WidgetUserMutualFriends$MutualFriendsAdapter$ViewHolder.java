package com.discord.widgets.user;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.i.f6;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetUserProfileAdapterItemFriendBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.presence.Presence;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.u;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualFriends$MutualFriendsAdapter$ViewHolder extends MGRecyclerViewHolder<WidgetUserMutualFriends$MutualFriendsAdapter, WidgetUserMutualFriends$Model$Item> {
    private final WidgetUserProfileAdapterItemFriendBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMutualFriends$MutualFriendsAdapter$ViewHolder(WidgetUserMutualFriends$MutualFriendsAdapter widgetUserMutualFriends$MutualFriendsAdapter) {
        super(R$layout.widget_user_profile_adapter_item_friend, widgetUserMutualFriends$MutualFriendsAdapter);
        m.checkNotNullParameter(widgetUserMutualFriends$MutualFriendsAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.mutual_server_1;
        View viewFindViewById = view.findViewById(R$id.mutual_server_1);
        if (viewFindViewById != null) {
            f6 f6VarA = f6.a(viewFindViewById);
            i = R$id.mutual_server_2;
            View viewFindViewById2 = view.findViewById(R$id.mutual_server_2);
            if (viewFindViewById2 != null) {
                f6 f6VarA2 = f6.a(viewFindViewById2);
                i = R$id.mutual_server_3;
                View viewFindViewById3 = view.findViewById(R$id.mutual_server_3);
                if (viewFindViewById3 != null) {
                    f6 f6VarA3 = f6.a(viewFindViewById3);
                    i = R$id.mutual_server_4;
                    View viewFindViewById4 = view.findViewById(R$id.mutual_server_4);
                    if (viewFindViewById4 != null) {
                        f6 f6VarA4 = f6.a(viewFindViewById4);
                        i = R$id.user_profile_adapter_item_friend_avatar;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.user_profile_adapter_item_friend_avatar);
                        if (simpleDraweeView != null) {
                            i = R$id.user_profile_adapter_item_friend_mutual;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.user_profile_adapter_item_friend_mutual);
                            if (linearLayout != null) {
                                i = R$id.user_profile_adapter_item_friend_status;
                                StatusView statusView = (StatusView) view.findViewById(R$id.user_profile_adapter_item_friend_status);
                                if (statusView != null) {
                                    i = R$id.user_profile_adapter_item_friend_user_game;
                                    SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R$id.user_profile_adapter_item_friend_user_game);
                                    if (simpleDraweeSpanTextView != null) {
                                        i = R$id.user_profile_adapter_item_friend_user_name;
                                        TextView textView = (TextView) view.findViewById(R$id.user_profile_adapter_item_friend_user_name);
                                        if (textView != null) {
                                            WidgetUserProfileAdapterItemFriendBinding widgetUserProfileAdapterItemFriendBinding = new WidgetUserProfileAdapterItemFriendBinding((RelativeLayout) view, f6VarA, f6VarA2, f6VarA3, f6VarA4, simpleDraweeView, linearLayout, statusView, simpleDraweeSpanTextView, textView);
                                            m.checkNotNullExpressionValue(widgetUserProfileAdapterItemFriendBinding, "WidgetUserProfileAdapter…endBinding.bind(itemView)");
                                            this.binding = widgetUserProfileAdapterItemFriendBinding;
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetUserMutualFriends$MutualFriendsAdapter access$getAdapter$p(WidgetUserMutualFriends$MutualFriendsAdapter$ViewHolder widgetUserMutualFriends$MutualFriendsAdapter$ViewHolder) {
        return (WidgetUserMutualFriends$MutualFriendsAdapter) widgetUserMutualFriends$MutualFriendsAdapter$ViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetUserMutualFriends$Model$Item widgetUserMutualFriends$Model$Item) {
        onConfigure2(i, widgetUserMutualFriends$Model$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetUserMutualFriends$Model$Item data) {
        f6 f6Var;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        WidgetUserMutualFriends$Model$Item$MutualFriend widgetUserMutualFriends$Model$Item$MutualFriend = (WidgetUserMutualFriends$Model$Item$MutualFriend) data;
        this.itemView.setOnClickListener(new WidgetUserMutualFriends$MutualFriendsAdapter$ViewHolder$onConfigure$1(this, widgetUserMutualFriends$Model$Item$MutualFriend));
        TextView textView = this.binding.i;
        m.checkNotNullExpressionValue(textView, "binding.userProfileAdapterItemFriendUserName");
        textView.setText(widgetUserMutualFriends$Model$Item$MutualFriend.getUser().getUsername());
        this.binding.g.setPresence(widgetUserMutualFriends$Model$Item$MutualFriend.getPresence());
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.h;
        Presence presence = widgetUserMutualFriends$Model$Item$MutualFriend.getPresence();
        Boolean boolIsApplicationStreaming = widgetUserMutualFriends$Model$Item$MutualFriend.isApplicationStreaming();
        m.checkNotNull(boolIsApplicationStreaming);
        boolean zBooleanValue = boolIsApplicationStreaming.booleanValue();
        m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "it");
        PresenceUtils.setPresenceText$default(presence, zBooleanValue, simpleDraweeSpanTextView, true, false, 16, null);
        SimpleDraweeView simpleDraweeView = this.binding.f;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.userProfileAdapterItemFriendAvatar");
        IconUtils.setIcon$default(simpleDraweeView, widgetUserMutualFriends$Model$Item$MutualFriend.getUser(), 2131165300, null, null, null, 56, null);
        int i = 0;
        while (i <= 3) {
            if (i == 1) {
                f6Var = this.binding.f2690b;
            } else if (i == 2) {
                f6Var = this.binding.c;
            } else if (i != 3) {
                f6Var = i != 4 ? this.binding.e : this.binding.e;
            } else {
                f6Var = this.binding.d;
            }
            m.checkNotNullExpressionValue(f6Var, "when (i) {\n            1…mutualServer4\n          }");
            RelativeLayout relativeLayout = f6Var.a;
            m.checkNotNullExpressionValue(relativeLayout, "item.root");
            relativeLayout.setVisibility(8);
            TextView textView2 = f6Var.c;
            m.checkNotNullExpressionValue(textView2, "item.userProfileAdapterItemFriendMutualText");
            textView2.setVisibility(8);
            SimpleDraweeView simpleDraweeView2 = f6Var.f115b;
            m.checkNotNullExpressionValue(simpleDraweeView2, "item.userProfileAdapterItemFriendMutualImage");
            simpleDraweeView2.setVisibility(8);
            Guild guild = (Guild) u.getOrNull(widgetUserMutualFriends$Model$Item$MutualFriend.getMutualGuilds(), i);
            if (guild != null) {
                RelativeLayout relativeLayout2 = f6Var.a;
                m.checkNotNullExpressionValue(relativeLayout2, "item.root");
                relativeLayout2.setVisibility(0);
                if (guild.getIcon() != null) {
                    SimpleDraweeView simpleDraweeView3 = f6Var.f115b;
                    m.checkNotNullExpressionValue(simpleDraweeView3, "item.userProfileAdapterItemFriendMutualImage");
                    simpleDraweeView3.setVisibility(0);
                    SimpleDraweeView simpleDraweeView4 = f6Var.f115b;
                    m.checkNotNullExpressionValue(simpleDraweeView4, "imageView");
                    IconUtils.setIcon$default((ImageView) simpleDraweeView4, guild, 0, (MGImages$ChangeDetector) null, false, 28, (Object) null);
                } else {
                    TextView textView3 = f6Var.c;
                    m.checkNotNullExpressionValue(textView3, "item.userProfileAdapterItemFriendMutualText");
                    textView3.setVisibility(0);
                    TextView textView4 = f6Var.c;
                    m.checkNotNullExpressionValue(textView4, "item.userProfileAdapterItemFriendMutualText");
                    textView4.setText(guild.getShortName());
                }
            }
            i++;
        }
    }
}

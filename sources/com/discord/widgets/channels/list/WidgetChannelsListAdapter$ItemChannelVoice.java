package com.discord.widgets.channels.list;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$plurals;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guild.GuildMaxVideoChannelUsers$Limited;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.databinding.WidgetChannelsListItemChannelVoiceBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.VoiceUserLimitView;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceChannel;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelVoice extends WidgetChannelsListAdapter$Item {
    public static final WidgetChannelsListAdapter$ItemChannelVoice$Companion Companion = new WidgetChannelsListAdapter$ItemChannelVoice$Companion(null);
    private final WidgetChannelsListItemChannelVoiceBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemChannelVoice(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
        super(i, widgetChannelsListAdapter);
        m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
        View view = this.itemView;
        int i2 = R$id.channels_item_channel_mentions;
        TextView textView = (TextView) view.findViewById(R$id.channels_item_channel_mentions);
        if (textView != null) {
            i2 = R$id.channels_item_channel_unread;
            ImageView imageView = (ImageView) view.findViewById(R$id.channels_item_channel_unread);
            if (imageView != null) {
                i2 = R$id.channels_item_voice_channel_event_topic;
                TextView textView2 = (TextView) view.findViewById(R$id.channels_item_voice_channel_event_topic);
                if (textView2 != null) {
                    i2 = R$id.channels_item_voice_channel_guild_role_subscription_icon;
                    ImageView imageView2 = (ImageView) view.findViewById(R$id.channels_item_voice_channel_guild_role_subscription_icon);
                    if (imageView2 != null) {
                        i2 = R$id.channels_item_voice_channel_name;
                        TextView textView3 = (TextView) view.findViewById(R$id.channels_item_voice_channel_name);
                        if (textView3 != null) {
                            i2 = R$id.channels_item_voice_channel_speaker;
                            ImageView imageView3 = (ImageView) view.findViewById(R$id.channels_item_voice_channel_speaker);
                            if (imageView3 != null) {
                                i2 = R$id.channels_item_voice_channel_user_limit;
                                VoiceUserLimitView voiceUserLimitView = (VoiceUserLimitView) view.findViewById(R$id.channels_item_voice_channel_user_limit);
                                if (voiceUserLimitView != null) {
                                    i2 = R$id.channels_item_voice_channel_wrapper;
                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.channels_item_voice_channel_wrapper);
                                    if (linearLayout != null) {
                                        WidgetChannelsListItemChannelVoiceBinding widgetChannelsListItemChannelVoiceBinding = new WidgetChannelsListItemChannelVoiceBinding((ConstraintLayout) view, textView, imageView, textView2, imageView2, textView3, imageView3, voiceUserLimitView, linearLayout);
                                        m.checkNotNullExpressionValue(widgetChannelsListItemChannelVoiceBinding, "WidgetChannelsListItemCh…iceBinding.bind(itemView)");
                                        this.binding = widgetChannelsListItemChannelVoiceBinding;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(WidgetChannelsListAdapter$ItemChannelVoice widgetChannelsListAdapter$ItemChannelVoice) {
        return (WidgetChannelsListAdapter) widgetChannelsListAdapter$ItemChannelVoice.adapter;
    }

    private final CharSequence getContentDescription(ChannelListItemVoiceChannel channelListItemVoiceChannel, ChannelListItemVoiceChannel channelListItemVoiceChannel2, int i) {
        if (i > 0 && channelListItemVoiceChannel.getMentionCount() > 0) {
            ConstraintLayout constraintLayout = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            ConstraintLayout constraintLayout2 = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout2, "binding.root");
            Context context = constraintLayout2.getContext();
            m.checkNotNullExpressionValue(context, "binding.root.context");
            return b.j(constraintLayout, 2131891486, new Object[]{StringResourceUtilsKt.getI18nPluralString(context, R$plurals.guild_sidebar_default_channel_a11y_label_with_mentions_mentionCount, channelListItemVoiceChannel.getMentionCount(), Integer.valueOf(channelListItemVoiceChannel.getMentionCount())), ChannelUtils.c(channelListItemVoiceChannel2.getChannel()), Integer.valueOf(channelListItemVoiceChannel2.getNumUsersConnected()), Integer.valueOf(i)}, null, 4);
        }
        if (i > 0) {
            ConstraintLayout constraintLayout3 = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout3, "binding.root");
            return b.j(constraintLayout3, 2131891485, new Object[]{ChannelUtils.c(channelListItemVoiceChannel2.getChannel()), Integer.valueOf(channelListItemVoiceChannel2.getNumUsersConnected()), Integer.valueOf(i)}, null, 4);
        }
        if (channelListItemVoiceChannel2.getNumUsersConnected() > 0 && channelListItemVoiceChannel.getMentionCount() > 0) {
            ConstraintLayout constraintLayout4 = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout4, "binding.root");
            ConstraintLayout constraintLayout5 = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout5, "binding.root");
            Context context2 = constraintLayout5.getContext();
            m.checkNotNullExpressionValue(context2, "binding.root.context");
            int mentionCount = channelListItemVoiceChannel.getMentionCount();
            Object[] objArr = {Integer.valueOf(channelListItemVoiceChannel.getMentionCount())};
            ConstraintLayout constraintLayout6 = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout6, "binding.root");
            Context context3 = constraintLayout6.getContext();
            m.checkNotNullExpressionValue(context3, "binding.root.context");
            return b.j(constraintLayout4, 2131891489, new Object[]{StringResourceUtilsKt.getI18nPluralString(context2, R$plurals.guild_sidebar_default_channel_a11y_label_with_mentions_mentionCount, mentionCount, objArr), ChannelUtils.c(channelListItemVoiceChannel2.getChannel()), StringResourceUtilsKt.getI18nPluralString(context3, R$plurals.guild_sidebar_voice_channel_a11y_label_with_users_userCount, channelListItemVoiceChannel2.getNumUsersConnected(), Integer.valueOf(channelListItemVoiceChannel2.getNumUsersConnected()))}, null, 4);
        }
        if (channelListItemVoiceChannel2.getNumUsersConnected() > 0) {
            ConstraintLayout constraintLayout7 = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout7, "binding.root");
            ConstraintLayout constraintLayout8 = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout8, "binding.root");
            Context context4 = constraintLayout8.getContext();
            m.checkNotNullExpressionValue(context4, "binding.root.context");
            return b.j(constraintLayout7, 2131891488, new Object[]{ChannelUtils.c(channelListItemVoiceChannel2.getChannel()), StringResourceUtilsKt.getI18nPluralString(context4, R$plurals.guild_sidebar_voice_channel_a11y_label_with_users_userCount, channelListItemVoiceChannel2.getNumUsersConnected(), Integer.valueOf(channelListItemVoiceChannel2.getNumUsersConnected()))}, null, 4);
        }
        if (channelListItemVoiceChannel.getMentionCount() <= 0) {
            ConstraintLayout constraintLayout9 = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout9, "binding.root");
            return b.j(constraintLayout9, 2131891483, new Object[]{ChannelUtils.c(channelListItemVoiceChannel2.getChannel())}, null, 4);
        }
        ConstraintLayout constraintLayout10 = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout10, "binding.root");
        ConstraintLayout constraintLayout11 = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout11, "binding.root");
        Context context5 = constraintLayout11.getContext();
        m.checkNotNullExpressionValue(context5, "binding.root.context");
        return b.j(constraintLayout10, 2131891487, new Object[]{StringResourceUtilsKt.getI18nPluralString(context5, R$plurals.guild_sidebar_default_channel_a11y_label_with_mentions_mentionCount, channelListItemVoiceChannel.getMentionCount(), Integer.valueOf(channelListItemVoiceChannel.getMentionCount())), ChannelUtils.c(channelListItemVoiceChannel2.getChannel())}, null, 4);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
        onConfigure2(i, channelListItem);
    }

    @SuppressLint({"SetTextI18n"})
    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, ChannelListItem data) {
        int i;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ChannelListItemVoiceChannel channelListItemVoiceChannel = (ChannelListItemVoiceChannel) data;
        Channel channelComponent1 = channelListItemVoiceChannel.component1();
        boolean zComponent2 = channelListItemVoiceChannel.getTextSelected();
        boolean zComponent3 = channelListItemVoiceChannel.getVoiceSelected();
        Long lComponent4 = channelListItemVoiceChannel.getPermission();
        int iComponent5 = channelListItemVoiceChannel.component5();
        boolean zComponent6 = channelListItemVoiceChannel.component6();
        int iComponent7 = channelListItemVoiceChannel.component7();
        boolean zComponent8 = channelListItemVoiceChannel.getIsLocked();
        boolean zComponent9 = channelListItemVoiceChannel.getIsNsfw();
        boolean zComponent10 = channelListItemVoiceChannel.getIsAnyoneUsingVideo();
        GuildMaxVideoChannelUsers guildMaxVideoChannelUsersComponent11 = channelListItemVoiceChannel.getGuildMaxVideoChannelUsers();
        boolean zComponent12 = channelListItemVoiceChannel.getIsGuildRoleSubscriptionLockedChannel();
        boolean zComponent13 = channelListItemVoiceChannel.getIsGuildRoleSubscriptionChannel();
        GuildScheduledEvent guildScheduledEventComponent14 = channelListItemVoiceChannel.getGuildScheduledEvent();
        boolean zCan = PermissionUtils.can(Permission.CONNECT, lComponent4);
        WidgetChannelsListAdapter$ItemChannelVoice$Companion widgetChannelsListAdapter$ItemChannelVoice$Companion = Companion;
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "itemView.context");
        int iAccess$getVoiceChannelColor = WidgetChannelsListAdapter$ItemChannelVoice$Companion.access$getVoiceChannelColor(widgetChannelsListAdapter$ItemChannelVoice$Companion, zComponent3, context);
        this.binding.a.setOnClickListener(new WidgetChannelsListAdapter$ItemChannelVoice$onConfigure$1(this, zComponent12, data));
        ConstraintLayout constraintLayout = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        constraintLayout.setSelected(zComponent3);
        ConstraintLayout constraintLayout2 = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout2, "binding.root");
        setBackground(constraintLayout2, zComponent3, channelComponent1);
        TextView textView = this.binding.f;
        m.checkNotNullExpressionValue(textView, "binding.channelsItemVoiceChannelName");
        textView.setText(ChannelUtils.c(channelComponent1));
        this.binding.f.setTextColor(iAccess$getVoiceChannelColor);
        TextView textView2 = this.binding.d;
        m.checkNotNullExpressionValue(textView2, "binding.channelsItemVoiceChannelEventTopic");
        ViewExtensions.setTextAndVisibilityBy(textView2, guildScheduledEventComponent14 != null ? guildScheduledEventComponent14.getName() : null);
        TextView textView3 = this.binding.f2290b;
        m.checkNotNullExpressionValue(textView3, "binding.channelsItemChannelMentions");
        textView3.setVisibility(iComponent5 > 0 ? 0 : 8);
        TextView textView4 = this.binding.f2290b;
        m.checkNotNullExpressionValue(textView4, "binding.channelsItemChannelMentions");
        textView4.setText(String.valueOf(Math.min(99, iComponent5)));
        ImageView imageView = this.binding.c;
        m.checkNotNullExpressionValue(imageView, "binding.channelsItemChannelUnread");
        imageView.setVisibility(zComponent6 && !zComponent2 ? 0 : 8);
        ImageView imageView2 = this.binding.e;
        m.checkNotNullExpressionValue(imageView2, "binding.channelsItemVoic…GuildRoleSubscriptionIcon");
        imageView2.setVisibility(zComponent13 ? 0 : 8);
        if (zComponent12) {
            this.binding.e.setImageResource(2131232038);
        } else if (zComponent13) {
            this.binding.e.setImageResource(2131232039);
        }
        if (!zCan) {
            i = 2131231622;
        } else if (zComponent9) {
            i = 2131232254;
        } else {
            i = zComponent8 ? 2131231643 : 2131231639;
        }
        if (guildScheduledEventComponent14 != null) {
            View view2 = this.itemView;
            m.checkNotNullExpressionValue(view2, "itemView");
            iAccess$getVoiceChannelColor = ColorCompat.getColor(view2.getContext(), 2131100304);
        }
        this.binding.g.setImageResource(i);
        ImageView imageView3 = this.binding.g;
        m.checkNotNullExpressionValue(imageView3, "binding.channelsItemVoiceChannelSpeaker");
        imageView3.setImageTintList(ColorStateList.valueOf(iAccess$getVoiceChannelColor));
        GuildMaxVideoChannelUsers$Limited guildMaxVideoChannelUsers$Limited = (GuildMaxVideoChannelUsers$Limited) (!(guildMaxVideoChannelUsersComponent11 instanceof GuildMaxVideoChannelUsers$Limited) ? null : guildMaxVideoChannelUsersComponent11);
        int limit = guildMaxVideoChannelUsers$Limited != null ? guildMaxVideoChannelUsers$Limited.getLimit() : 0;
        int iMin = Math.min(channelComponent1.getUserLimit(), limit);
        if (iMin > 0) {
            boolean z2 = zComponent10 && iMin == limit;
            if (!z2) {
                limit = channelComponent1.getUserLimit();
            }
            VoiceUserLimitView voiceUserLimitView = this.binding.h;
            m.checkNotNullExpressionValue(voiceUserLimitView, "binding.channelsItemVoiceChannelUserLimit");
            voiceUserLimitView.setVisibility(limit > 0 && zCan ? 0 : 8);
            this.binding.h.a(iComponent7, limit, z2);
            ConstraintLayout constraintLayout3 = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout3, "binding.root");
            constraintLayout3.setContentDescription(getContentDescription(channelListItemVoiceChannel, channelListItemVoiceChannel, limit));
        } else {
            VoiceUserLimitView voiceUserLimitView2 = this.binding.h;
            m.checkNotNullExpressionValue(voiceUserLimitView2, "binding.channelsItemVoiceChannelUserLimit");
            voiceUserLimitView2.setVisibility(8);
            ConstraintLayout constraintLayout4 = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout4, "binding.root");
            constraintLayout4.setContentDescription(getContentDescription(channelListItemVoiceChannel, channelListItemVoiceChannel, iMin));
        }
        if (PermissionUtils.can(16L, lComponent4)) {
            ConstraintLayout constraintLayout5 = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout5, "binding.root");
            ViewExtensions.setOnLongClickListenerConsumeClick(constraintLayout5, new WidgetChannelsListAdapter$ItemChannelVoice$onConfigure$2(this, channelComponent1));
        } else {
            ConstraintLayout constraintLayout6 = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout6, "binding.root");
            ViewExtensions.setOnLongClickListenerConsumeClick(constraintLayout6, WidgetChannelsListAdapter$ItemChannelVoice$onConfigure$3.INSTANCE);
        }
    }
}

package com.discord.widgets.channels.list;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$plurals;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.stageinstance.StageInstance;
import com.discord.databinding.WidgetChannelsListItemChannelStageVoiceBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemStageVoiceChannel;
import com.discord.widgets.channels.list.items.ChannelListVocalItem;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelStageVoice extends WidgetChannelsListAdapter$Item {
    public static final WidgetChannelsListAdapter$ItemChannelStageVoice$Companion Companion = new WidgetChannelsListAdapter$ItemChannelStageVoice$Companion(null);
    private final WidgetChannelsListItemChannelStageVoiceBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemChannelStageVoice(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
        super(i, widgetChannelsListAdapter);
        m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
        View view = this.itemView;
        int i2 = R$id.channels_item_stage_voice_channel_guild_role_subscription_icon;
        ImageView imageView = (ImageView) view.findViewById(R$id.channels_item_stage_voice_channel_guild_role_subscription_icon);
        if (imageView != null) {
            i2 = R$id.stage_channel_item_stage_channel_icon;
            ImageView imageView2 = (ImageView) view.findViewById(R$id.stage_channel_item_stage_channel_icon);
            if (imageView2 != null) {
                i2 = R$id.stage_channel_item_voice_channel_name;
                TextView textView = (TextView) view.findViewById(R$id.stage_channel_item_voice_channel_name);
                if (textView != null) {
                    i2 = R$id.stage_channel_item_voice_channel_topic;
                    TextView textView2 = (TextView) view.findViewById(R$id.stage_channel_item_voice_channel_topic);
                    if (textView2 != null) {
                        WidgetChannelsListItemChannelStageVoiceBinding widgetChannelsListItemChannelStageVoiceBinding = new WidgetChannelsListItemChannelStageVoiceBinding((RelativeLayout) view, imageView, imageView2, textView, textView2);
                        m.checkNotNullExpressionValue(widgetChannelsListItemChannelStageVoiceBinding, "WidgetChannelsListItemCh…iceBinding.bind(itemView)");
                        this.binding = widgetChannelsListItemChannelStageVoiceBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(WidgetChannelsListAdapter$ItemChannelStageVoice widgetChannelsListAdapter$ItemChannelStageVoice) {
        return (WidgetChannelsListAdapter) widgetChannelsListAdapter$ItemChannelStageVoice.adapter;
    }

    private final CharSequence getContentDescription(ChannelListVocalItem data, int userLimit) {
        if (userLimit > 0) {
            RelativeLayout relativeLayout = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout, "binding.root");
            return b.j(relativeLayout, 2131891485, new Object[]{ChannelUtils.c(data.getChannel()), Integer.valueOf(data.getNumUsersConnected()), Integer.valueOf(userLimit)}, null, 4);
        }
        if (data.getNumUsersConnected() <= 0) {
            RelativeLayout relativeLayout2 = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout2, "binding.root");
            return b.j(relativeLayout2, 2131891483, new Object[]{ChannelUtils.c(data.getChannel())}, null, 4);
        }
        RelativeLayout relativeLayout3 = this.binding.a;
        m.checkNotNullExpressionValue(relativeLayout3, "binding.root");
        RelativeLayout relativeLayout4 = this.binding.a;
        m.checkNotNullExpressionValue(relativeLayout4, "binding.root");
        Context context = relativeLayout4.getContext();
        m.checkNotNullExpressionValue(context, "binding.root.context");
        return b.j(relativeLayout3, 2131891488, new Object[]{ChannelUtils.c(data.getChannel()), StringResourceUtilsKt.getI18nPluralString(context, R$plurals.guild_sidebar_voice_channel_a11y_label_with_users_userCount, data.getNumUsersConnected(), Integer.valueOf(data.getNumUsersConnected()))}, null, 4);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
        onConfigure2(i, channelListItem);
    }

    @SuppressLint({"SetTextI18n"})
    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, ChannelListItem data) {
        int i;
        ColorStateList colorStateListValueOf;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ChannelListItemStageVoiceChannel channelListItemStageVoiceChannel = (ChannelListItemStageVoiceChannel) data;
        Channel channelComponent1 = channelListItemStageVoiceChannel.component1();
        boolean selected = channelListItemStageVoiceChannel.getSelected();
        Long permission = channelListItemStageVoiceChannel.getPermission();
        boolean isLocked = channelListItemStageVoiceChannel.getIsLocked();
        StageInstance stageInstance = channelListItemStageVoiceChannel.getStageInstance();
        boolean isGuildRoleSubscriptionLockedChannel = channelListItemStageVoiceChannel.getIsGuildRoleSubscriptionLockedChannel();
        boolean isGuildRoleSubscriptionChannel = channelListItemStageVoiceChannel.getIsGuildRoleSubscriptionChannel();
        boolean z2 = stageInstance != null;
        boolean zCan = PermissionUtils.can(Permission.CONNECT, permission);
        WidgetChannelsListAdapter$ItemChannelStageVoice$Companion widgetChannelsListAdapter$ItemChannelStageVoice$Companion = Companion;
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "itemView.context");
        int iAccess$getVoiceChannelColor = WidgetChannelsListAdapter$ItemChannelStageVoice$Companion.access$getVoiceChannelColor(widgetChannelsListAdapter$ItemChannelStageVoice$Companion, selected, context);
        this.binding.a.setOnClickListener(new WidgetChannelsListAdapter$ItemChannelStageVoice$onConfigure$1(this, isGuildRoleSubscriptionLockedChannel, data));
        RelativeLayout relativeLayout = this.binding.a;
        m.checkNotNullExpressionValue(relativeLayout, "binding.root");
        relativeLayout.setSelected(selected);
        RelativeLayout relativeLayout2 = this.binding.a;
        m.checkNotNullExpressionValue(relativeLayout2, "binding.root");
        setBackground(relativeLayout2, selected, channelComponent1);
        TextView textView = this.binding.d;
        textView.setText(ChannelUtils.c(channelComponent1));
        textView.setTextColor(iAccess$getVoiceChannelColor);
        TextView textView2 = this.binding.e;
        m.checkNotNullExpressionValue(textView2, "binding.stageChannelItemVoiceChannelTopic");
        ViewExtensions.setTextAndVisibilityBy(textView2, stageInstance != null ? stageInstance.getTopic() : null);
        ImageView imageView = this.binding.f2289b;
        m.checkNotNullExpressionValue(imageView, "binding.channelsItemStag…GuildRoleSubscriptionIcon");
        imageView.setVisibility(isGuildRoleSubscriptionChannel ? 0 : 8);
        if (isGuildRoleSubscriptionLockedChannel) {
            this.binding.f2289b.setImageResource(2131232038);
        } else if (isGuildRoleSubscriptionChannel) {
            this.binding.f2289b.setImageResource(2131232039);
        }
        if (zCan) {
            i = isLocked ? 2131231629 : 2131231625;
        } else {
            i = 2131231622;
        }
        ImageView imageView2 = this.binding.c;
        imageView2.setImageResource(i);
        if (z2 && zCan) {
            RelativeLayout relativeLayout3 = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout3, "binding.root");
            colorStateListValueOf = ColorStateList.valueOf(ColorCompat.getColor(relativeLayout3.getContext(), 2131100304));
        } else {
            colorStateListValueOf = ColorStateList.valueOf(iAccess$getVoiceChannelColor);
        }
        imageView2.setImageTintList(colorStateListValueOf);
        RelativeLayout relativeLayout4 = this.binding.a;
        m.checkNotNullExpressionValue(relativeLayout4, "binding.root");
        relativeLayout4.setContentDescription(getContentDescription((ChannelListVocalItem) data, channelComponent1.getUserLimit()));
        RelativeLayout relativeLayout5 = this.binding.a;
        m.checkNotNullExpressionValue(relativeLayout5, "binding.root");
        ViewExtensions.setOnLongClickListenerConsumeClick(relativeLayout5, new WidgetChannelsListAdapter$ItemChannelStageVoice$onConfigure$4(this, channelComponent1));
    }
}

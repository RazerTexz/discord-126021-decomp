package com.discord.widgets.channels.list;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$drawable;
import com.discord.R$id;
import com.discord.R$plurals;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.WidgetChannelsListItemChannelBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemTextChannel;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelText extends WidgetChannelsListAdapter$Item {
    private final WidgetChannelsListItemChannelBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemChannelText(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
        super(i, widgetChannelsListAdapter);
        m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
        View view = this.itemView;
        int i2 = R$id.channels_item_channel_guild_role_subscription_icon;
        ImageView imageView = (ImageView) view.findViewById(R$id.channels_item_channel_guild_role_subscription_icon);
        if (imageView != null) {
            i2 = R$id.channels_item_channel_hash;
            ImageView imageView2 = (ImageView) view.findViewById(R$id.channels_item_channel_hash);
            if (imageView2 != null) {
                i2 = R$id.channels_item_channel_mentions;
                TextView textView = (TextView) view.findViewById(R$id.channels_item_channel_mentions);
                if (textView != null) {
                    i2 = R$id.channels_item_channel_name;
                    TextView textView2 = (TextView) view.findViewById(R$id.channels_item_channel_name);
                    if (textView2 != null) {
                        i2 = R$id.channels_item_channel_unread;
                        ImageView imageView3 = (ImageView) view.findViewById(R$id.channels_item_channel_unread);
                        if (imageView3 != null) {
                            WidgetChannelsListItemChannelBinding widgetChannelsListItemChannelBinding = new WidgetChannelsListItemChannelBinding((RelativeLayout) view, imageView, imageView2, textView, textView2, imageView3);
                            m.checkNotNullExpressionValue(widgetChannelsListItemChannelBinding, "WidgetChannelsListItemCh…nelBinding.bind(itemView)");
                            this.binding = widgetChannelsListItemChannelBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(WidgetChannelsListAdapter$ItemChannelText widgetChannelsListAdapter$ItemChannelText) {
        return (WidgetChannelsListAdapter) widgetChannelsListAdapter$ItemChannelText.adapter;
    }

    @DrawableRes
    private final int getAnnouncementsIcon(ChannelListItemTextChannel channelListItemTextChannel) {
        if (channelListItemTextChannel.getChannel().getNsfw()) {
            return channelListItemTextChannel.getHasActiveThreads() ? 2131231617 : 2131231614;
        }
        if (channelListItemTextChannel.isLocked()) {
            return channelListItemTextChannel.getHasActiveThreads() ? 2131231616 : 2131231613;
        }
        return channelListItemTextChannel.getHasActiveThreads() ? 2131231615 : 2131231611;
    }

    private final CharSequence getContentDescription(ChannelListItemTextChannel channelListItemTextChannel, boolean z2) {
        if (z2 && channelListItemTextChannel.getMentionCount() > 0) {
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            return b.j(view, 2131891463, new Object[]{StringResourceUtilsKt.getI18nPluralString(a.x(this.itemView, "itemView", "itemView.context"), R$plurals.guild_sidebar_announcement_channel_a11y_label_with_mentions_mentionCount, channelListItemTextChannel.getMentionCount(), Integer.valueOf(channelListItemTextChannel.getMentionCount())), ChannelUtils.c(channelListItemTextChannel.getChannel())}, null, 4);
        }
        if (z2 && channelListItemTextChannel.getIsUnread()) {
            View view2 = this.itemView;
            m.checkNotNullExpressionValue(view2, "itemView");
            return b.j(view2, 2131891464, new Object[]{ChannelUtils.c(channelListItemTextChannel.getChannel())}, null, 4);
        }
        if (z2) {
            View view3 = this.itemView;
            m.checkNotNullExpressionValue(view3, "itemView");
            return b.j(view3, 2131891462, new Object[]{ChannelUtils.c(channelListItemTextChannel.getChannel())}, null, 4);
        }
        if (channelListItemTextChannel.getMentionCount() > 0) {
            View view4 = this.itemView;
            m.checkNotNullExpressionValue(view4, "itemView");
            return b.j(view4, 2131891472, new Object[]{StringResourceUtilsKt.getI18nPluralString(a.x(this.itemView, "itemView", "itemView.context"), R$plurals.guild_sidebar_default_channel_a11y_label_with_mentions_mentionCount, channelListItemTextChannel.getMentionCount(), Integer.valueOf(channelListItemTextChannel.getMentionCount())), ChannelUtils.c(channelListItemTextChannel.getChannel())}, null, 4);
        }
        if (channelListItemTextChannel.getIsUnread()) {
            View view5 = this.itemView;
            m.checkNotNullExpressionValue(view5, "itemView");
            return b.j(view5, 2131891473, new Object[]{ChannelUtils.c(channelListItemTextChannel.getChannel())}, null, 4);
        }
        View view6 = this.itemView;
        m.checkNotNullExpressionValue(view6, "itemView");
        return b.j(view6, 2131891471, new Object[]{ChannelUtils.c(channelListItemTextChannel.getChannel())}, null, 4);
    }

    @DrawableRes
    private final int getForumIcon(ChannelListItemTextChannel channelListItemTextChannel) {
        if (channelListItemTextChannel.getChannel().getNsfw()) {
            return R$drawable.ic_channel_forum_nsfw;
        }
        return channelListItemTextChannel.isLocked() ? R$drawable.ic_channel_forum_locked : R$drawable.ic_channel_forum;
    }

    @ColorInt
    private final int getHashColor(ChannelListItemTextChannel channelListItemTextChannel) {
        if (channelListItemTextChannel.getMuted()) {
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            return ColorCompat.getThemedColor(view, 2130969007);
        }
        if (channelListItemTextChannel.getIsUnread()) {
            View view2 = this.itemView;
            m.checkNotNullExpressionValue(view2, "itemView");
            return ColorCompat.getThemedColor(view2, 2130969005);
        }
        View view3 = this.itemView;
        m.checkNotNullExpressionValue(view3, "itemView");
        return ColorCompat.getThemedColor(view3, 2130968965);
    }

    @DrawableRes
    private final int getHashIcon(ChannelListItemTextChannel channelListItemTextChannel) {
        if (channelListItemTextChannel.getChannel().getNsfw()) {
            return channelListItemTextChannel.getHasActiveThreads() ? 2131232197 : 2131231635;
        }
        if (channelListItemTextChannel.isLocked()) {
            return channelListItemTextChannel.getHasActiveThreads() ? 2131232196 : 2131231634;
        }
        return channelListItemTextChannel.getHasActiveThreads() ? 2131232193 : 2131231630;
    }

    @ColorInt
    private final int getTextColor(ChannelListItemTextChannel channelListItemTextChannel, boolean z2) {
        if (z2) {
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            return ColorCompat.getThemedColor(view, 2130969005);
        }
        if (channelListItemTextChannel.getMuted()) {
            View view2 = this.itemView;
            m.checkNotNullExpressionValue(view2, "itemView");
            return ColorCompat.getThemedColor(view2, 2130969007);
        }
        if (channelListItemTextChannel.getIsUnread()) {
            View view3 = this.itemView;
            m.checkNotNullExpressionValue(view3, "itemView");
            return ColorCompat.getThemedColor(view3, 2130969005);
        }
        View view4 = this.itemView;
        m.checkNotNullExpressionValue(view4, "itemView");
        return ColorCompat.getThemedColor(view4, 2130968965);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
        onConfigure2(i, channelListItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, ChannelListItem data) {
        int announcementsIcon;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ChannelListItemTextChannel channelListItemTextChannel = (ChannelListItemTextChannel) data;
        boolean z2 = channelListItemTextChannel.getChannel().getType() == 5;
        RelativeLayout relativeLayout = this.binding.a;
        m.checkNotNullExpressionValue(relativeLayout, "binding.root");
        ViewExtensions.setOnLongClickListenerConsumeClick(relativeLayout, new WidgetChannelsListAdapter$ItemChannelText$onConfigure$1(this, data));
        this.binding.a.setOnClickListener(new WidgetChannelsListAdapter$ItemChannelText$onConfigure$2(this, channelListItemTextChannel, data));
        RelativeLayout relativeLayout2 = this.binding.a;
        m.checkNotNullExpressionValue(relativeLayout2, "binding.root");
        setBackground(relativeLayout2, channelListItemTextChannel.getSelected(), channelListItemTextChannel.getChannel());
        RelativeLayout relativeLayout3 = this.binding.a;
        m.checkNotNullExpressionValue(relativeLayout3, "binding.root");
        relativeLayout3.setContentDescription(getContentDescription(channelListItemTextChannel, z2));
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.channelsItemChannelName");
        textView.setText(ChannelUtils.c(channelListItemTextChannel.getChannel()));
        this.binding.e.setTextColor(getTextColor(channelListItemTextChannel, channelListItemTextChannel.getSelected()));
        ImageView imageView = this.binding.c;
        int type = channelListItemTextChannel.getChannel().getType();
        if (type != 5) {
            announcementsIcon = type != 15 ? getHashIcon(channelListItemTextChannel) : getForumIcon(channelListItemTextChannel);
        } else {
            announcementsIcon = getAnnouncementsIcon(channelListItemTextChannel);
        }
        imageView.setImageResource(announcementsIcon);
        ImageView imageView2 = this.binding.c;
        m.checkNotNullExpressionValue(imageView2, "binding.channelsItemChannelHash");
        imageView2.setImageTintList(ColorStateList.valueOf(getHashColor(channelListItemTextChannel)));
        TextView textView2 = this.binding.d;
        m.checkNotNullExpressionValue(textView2, "binding.channelsItemChannelMentions");
        textView2.setVisibility(channelListItemTextChannel.getMentionCount() > 0 ? 0 : 8);
        TextView textView3 = this.binding.d;
        m.checkNotNullExpressionValue(textView3, "binding.channelsItemChannelMentions");
        textView3.setText(String.valueOf(Math.min(99, channelListItemTextChannel.getMentionCount())));
        ImageView imageView3 = this.binding.f;
        m.checkNotNullExpressionValue(imageView3, "binding.channelsItemChannelUnread");
        imageView3.setVisibility((!channelListItemTextChannel.getIsUnread() || channelListItemTextChannel.getSelected() || channelListItemTextChannel.getMuted()) ? false : true ? 0 : 8);
        TextView textView4 = this.binding.e;
        m.checkNotNullExpressionValue(textView4, "binding.channelsItemChannelName");
        FontUtils fontUtils = FontUtils.INSTANCE;
        RelativeLayout relativeLayout4 = this.binding.a;
        m.checkNotNullExpressionValue(relativeLayout4, "binding.root");
        Context context = relativeLayout4.getContext();
        m.checkNotNullExpressionValue(context, "binding.root.context");
        textView4.setTypeface(fontUtils.getThemedFont(context, (channelListItemTextChannel.getIsUnread() || channelListItemTextChannel.getSelected()) ? 2130969396 : 2130969395));
        ImageView imageView4 = this.binding.f2287b;
        m.checkNotNullExpressionValue(imageView4, "binding.channelsItemChan…GuildRoleSubscriptionIcon");
        imageView4.setVisibility(channelListItemTextChannel.isGuildRoleSubscriptionChannel() ? 0 : 8);
        if (channelListItemTextChannel.isGuildRoleSubscriptionLockedChannel()) {
            this.binding.f2287b.setImageResource(2131232038);
        } else if (channelListItemTextChannel.isGuildRoleSubscriptionChannel()) {
            this.binding.f2287b.setImageResource(2131232039);
        }
    }
}

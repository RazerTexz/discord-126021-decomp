package com.discord.widgets.channels.list;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import b.a.k.b;
import com.discord.R$id;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.User;
import com.discord.databinding.WidgetChannelsListItemChannelPrivateBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemPrivate;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelPrivate extends WidgetChannelsListAdapter$Item {
    private final WidgetChannelsListItemChannelPrivateBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemChannelPrivate(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
        super(i, widgetChannelsListAdapter);
        m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
        View view = this.itemView;
        int i2 = R$id.channel_list_item_private_status;
        StatusView statusView = (StatusView) view.findViewById(R$id.channel_list_item_private_status);
        if (statusView != null) {
            i2 = R$id.channels_list_item_private_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.channels_list_item_private_avatar);
            if (simpleDraweeView != null) {
                i2 = R$id.channels_list_item_private_desc;
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R$id.channels_list_item_private_desc);
                if (simpleDraweeSpanTextView != null) {
                    i2 = R$id.channels_list_item_private_mentions;
                    TextView textView = (TextView) view.findViewById(R$id.channels_list_item_private_mentions);
                    if (textView != null) {
                        i2 = R$id.channels_list_item_private_name;
                        TextView textView2 = (TextView) view.findViewById(R$id.channels_list_item_private_name);
                        if (textView2 != null) {
                            i2 = R$id.channels_list_item_private_tag;
                            TextView textView3 = (TextView) view.findViewById(R$id.channels_list_item_private_tag);
                            if (textView3 != null) {
                                WidgetChannelsListItemChannelPrivateBinding widgetChannelsListItemChannelPrivateBinding = new WidgetChannelsListItemChannelPrivateBinding((RelativeLayout) view, statusView, simpleDraweeView, simpleDraweeSpanTextView, textView, textView2, textView3);
                                m.checkNotNullExpressionValue(widgetChannelsListItemChannelPrivateBinding, "WidgetChannelsListItemCh…ateBinding.bind(itemView)");
                                this.binding = widgetChannelsListItemChannelPrivateBinding;
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(WidgetChannelsListAdapter$ItemChannelPrivate widgetChannelsListAdapter$ItemChannelPrivate) {
        return (WidgetChannelsListAdapter) widgetChannelsListAdapter$ItemChannelPrivate.adapter;
    }

    private final CharSequence getContentDescription(ChannelListItemPrivate channelListItemPrivate, CharSequence channelName) {
        if (ChannelUtils.p(channelListItemPrivate.getChannel()) && channelListItemPrivate.getMentionCount() > 0) {
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            return b.j(view, 2131889824, new Object[]{channelName}, null, 4);
        }
        if (ChannelUtils.p(channelListItemPrivate.getChannel())) {
            View view2 = this.itemView;
            m.checkNotNullExpressionValue(view2, "itemView");
            return b.j(view2, 2131889823, new Object[]{channelName}, null, 4);
        }
        if (channelListItemPrivate.getMentionCount() > 0) {
            View view3 = this.itemView;
            m.checkNotNullExpressionValue(view3, "itemView");
            return b.j(view3, 2131888441, new Object[]{channelName}, null, 4);
        }
        View view4 = this.itemView;
        m.checkNotNullExpressionValue(view4, "itemView");
        return b.j(view4, 2131888440, new Object[]{channelName}, null, 4);
    }

    @SuppressLint({"SetTextI18n"})
    private final String getMemberCount(Channel channel, Context context) {
        List<User> listZ = channel.z();
        int size = listZ != null ? listZ.size() : 0;
        CharSequence charSequenceH = b.h(context, 2131892934, new Object[0], null, 4);
        StringBuilder sb = new StringBuilder();
        sb.append(size + 1);
        sb.append(' ');
        sb.append(charSequenceH);
        return sb.toString();
    }

    private final int getPresenceBg(boolean selected) {
        if (selected) {
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            return ColorCompat.getThemedColor(view, 2130969061);
        }
        View view2 = this.itemView;
        m.checkNotNullExpressionValue(view2, "itemView");
        return ColorCompat.getThemedColor(view2, 2130968912);
    }

    @ColorInt
    private final int getTextColor(ChannelListItemPrivate channelListItemPrivate) {
        if (channelListItemPrivate.getSelected()) {
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            return ColorCompat.getThemedColor(view, 2130969005);
        }
        if (channelListItemPrivate.getMuted()) {
            View view2 = this.itemView;
            m.checkNotNullExpressionValue(view2, "itemView");
            return ColorCompat.getThemedColor(view2, 2130969007);
        }
        View view3 = this.itemView;
        m.checkNotNullExpressionValue(view3, "itemView");
        return ColorCompat.getThemedColor(view3, 2130968965);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
        onConfigure2(i, channelListItem);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x015f  */
    /* JADX WARN: Code duplicated, block: B:25:0x0161  */
    /* JADX WARN: Code duplicated, block: B:27:0x0164  */
    /* JADX WARN: Code duplicated, block: B:28:0x0166  */
    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, ChannelListItem data) {
        String strE;
        boolean z2;
        int i;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ChannelListItemPrivate channelListItemPrivate = (ChannelListItemPrivate) data;
        Channel channel = channelListItemPrivate.getChannel();
        Presence presence = channelListItemPrivate.getPresence();
        boolean selected = channelListItemPrivate.getSelected();
        int iComponent4 = channelListItemPrivate.component4();
        boolean isApplicationStreaming = channelListItemPrivate.getIsApplicationStreaming();
        if (ChannelUtils.m(channel)) {
            strE = ChannelUtils.c(channel);
        } else {
            TextView textView = this.binding.f;
            m.checkNotNullExpressionValue(textView, "binding.channelsListItemPrivateName");
            Context context = textView.getContext();
            m.checkNotNullExpressionValue(context, "binding.channelsListItemPrivateName.context");
            strE = ChannelUtils.e(channel, context, false, 2);
        }
        RelativeLayout relativeLayout = this.binding.a;
        m.checkNotNullExpressionValue(relativeLayout, "binding.root");
        ViewExtensions.setOnLongClickListenerConsumeClick(relativeLayout, new WidgetChannelsListAdapter$ItemChannelPrivate$onConfigure$1(this, data));
        this.binding.a.setOnClickListener(new WidgetChannelsListAdapter$ItemChannelPrivate$onConfigure$2(this, data));
        RelativeLayout relativeLayout2 = this.binding.a;
        m.checkNotNullExpressionValue(relativeLayout2, "binding.root");
        relativeLayout2.setContentDescription(getContentDescription(channelListItemPrivate, strE));
        TextView textView2 = this.binding.f;
        m.checkNotNullExpressionValue(textView2, "binding.channelsListItemPrivateName");
        textView2.setText(strE);
        this.binding.f.setTextColor(getTextColor(channelListItemPrivate));
        TextView textView3 = this.binding.g;
        m.checkNotNullExpressionValue(textView3, "binding.channelsListItemPrivateTag");
        textView3.setVisibility(ChannelUtils.E(channel) ? 0 : 8);
        SimpleDraweeView simpleDraweeView = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView, "it");
        IconUtils.setIcon$default(simpleDraweeView, channel, 2131165300, (MGImages$ChangeDetector) null, 8, (Object) null);
        StatusView statusView = this.binding.f2288b;
        m.checkNotNullExpressionValue(statusView, "binding.channelListItemPrivateStatus");
        statusView.setVisibility(ChannelUtils.n(channel, presence) ? 0 : 8);
        this.binding.f2288b.setPresence(presence);
        this.binding.f2288b.setBackgroundColor(getPresenceBg(selected));
        if (!ChannelUtils.E(channel)) {
            if (ChannelUtils.z(channel)) {
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.d;
                m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.channelsListItemPrivateDesc");
                SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = this.binding.d;
                m.checkNotNullExpressionValue(simpleDraweeSpanTextView2, "binding.channelsListItemPrivateDesc");
                Context context2 = simpleDraweeSpanTextView2.getContext();
                m.checkNotNullExpressionValue(context2, "binding.channelsListItemPrivateDesc.context");
                ViewExtensions.setTextAndVisibilityBy(simpleDraweeSpanTextView, getMemberCount(channel, context2));
            } else {
                SimpleDraweeSpanTextView simpleDraweeSpanTextView3 = this.binding.d;
                m.checkNotNullExpressionValue(simpleDraweeSpanTextView3, "binding.channelsListItemPrivateDesc");
                PresenceUtils.setPresenceText$default(presence, isApplicationStreaming, simpleDraweeSpanTextView3, false, false, 24, null);
            }
            TextView textView4 = this.binding.e;
            m.checkNotNullExpressionValue(textView4, "binding.channelsListItemPrivateMentions");
            textView4.setText(String.valueOf(Math.min(99, iComponent4)));
            TextView textView5 = this.binding.e;
            m.checkNotNullExpressionValue(textView5, "binding.channelsListItemPrivateMentions");
            if (iComponent4 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                i = 0;
            } else {
                i = 8;
            }
            textView5.setVisibility(i);
            RelativeLayout relativeLayout3 = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout3, r12);
            relativeLayout3.setSelected(selected);
            RelativeLayout relativeLayout4 = this.binding.a;
            m.checkNotNullExpressionValue(relativeLayout4, "binding.root");
            setBackground(relativeLayout4, selected, channel);
        }
        SimpleDraweeSpanTextView simpleDraweeSpanTextView4 = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeSpanTextView4, "binding.channelsListItemPrivateDesc");
        SimpleDraweeSpanTextView simpleDraweeSpanTextView5 = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeSpanTextView5, "binding.channelsListItemPrivateDesc");
        ViewExtensions.setTextAndVisibilityBy(simpleDraweeSpanTextView4, b.j(simpleDraweeSpanTextView5, 2131896161, new Object[0], null, 4));
        TextView textView6 = this.binding.e;
        m.checkNotNullExpressionValue(textView6, "binding.channelsListItemPrivateMentions");
        textView6.setText(String.valueOf(Math.min(99, iComponent4)));
        TextView textView7 = this.binding.e;
        m.checkNotNullExpressionValue(textView7, "binding.channelsListItemPrivateMentions");
        if (iComponent4 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i = 0;
        } else {
            i = 8;
        }
        textView7.setVisibility(i);
        RelativeLayout relativeLayout5 = this.binding.a;
        m.checkNotNullExpressionValue(relativeLayout5, r12);
        relativeLayout5.setSelected(selected);
        RelativeLayout relativeLayout6 = this.binding.a;
        m.checkNotNullExpressionValue(relativeLayout6, "binding.root");
        setBackground(relativeLayout6, selected, channel);
    }
}

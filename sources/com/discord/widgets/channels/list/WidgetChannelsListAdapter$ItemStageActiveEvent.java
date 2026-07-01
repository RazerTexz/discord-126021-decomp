package com.discord.widgets.channels.list;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$plurals;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.WidgetChannelsListItemActiveEventBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.views.user.UserSummaryView;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemActiveEvent;
import com.discord.widgets.channels.list.items.ChannelListItemActiveEventData;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventLocationInfo;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventLocationInfo$ChannelLocation;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventLocationInfo$ExternalLocation;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemStageActiveEvent extends WidgetChannelsListAdapter$Item {
    private final WidgetChannelsListItemActiveEventBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemStageActiveEvent(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
        super(i, widgetChannelsListAdapter);
        m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
        View view = this.itemView;
        int i2 = R$id.channel_separator;
        ImageView imageView = (ImageView) view.findViewById(R$id.channel_separator);
        if (imageView != null) {
            i2 = R$id.event_channel;
            TextView textView = (TextView) view.findViewById(R$id.event_channel);
            if (textView != null) {
                i2 = R$id.event_connect_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.event_connect_button);
                if (materialButton != null) {
                    i2 = R$id.event_topic;
                    TextView textView2 = (TextView) view.findViewById(R$id.event_topic);
                    if (textView2 != null) {
                        i2 = R$id.live_now_dot;
                        ImageView imageView2 = (ImageView) view.findViewById(R$id.live_now_dot);
                        if (imageView2 != null) {
                            i2 = R$id.live_now_label;
                            TextView textView3 = (TextView) view.findViewById(R$id.live_now_label);
                            if (textView3 != null) {
                                i2 = R$id.stage_event_listeners;
                                TextView textView4 = (TextView) view.findViewById(R$id.stage_event_listeners);
                                if (textView4 != null) {
                                    i2 = R$id.user_summary;
                                    UserSummaryView userSummaryView = (UserSummaryView) view.findViewById(R$id.user_summary);
                                    if (userSummaryView != null) {
                                        i2 = R$id.user_summary_label;
                                        MaterialTextView materialTextView = (MaterialTextView) view.findViewById(R$id.user_summary_label);
                                        if (materialTextView != null) {
                                            WidgetChannelsListItemActiveEventBinding widgetChannelsListItemActiveEventBinding = new WidgetChannelsListItemActiveEventBinding((ConstraintLayout) view, imageView, textView, materialButton, textView2, imageView2, textView3, textView4, userSummaryView, materialTextView);
                                            m.checkNotNullExpressionValue(widgetChannelsListItemActiveEventBinding, "WidgetChannelsListItemAc…entBinding.bind(itemView)");
                                            this.binding = widgetChannelsListItemActiveEventBinding;
                                            materialButton.setOnClickListener(new WidgetChannelsListAdapter$ItemStageActiveEvent$1(this, widgetChannelsListAdapter));
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
        onConfigure2(i, channelListItem);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a4  */
    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, ChannelListItem data) {
        int i;
        String locationName;
        int i2;
        CharSequence username;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ChannelListItemActiveEventData data2 = ((ChannelListItemActiveEvent) data).getData();
        GuildScheduledEventLocationInfo locationInfo = data2.getLocationInfo();
        if (!(locationInfo instanceof GuildScheduledEventLocationInfo$ChannelLocation)) {
            locationInfo = null;
        }
        GuildScheduledEventLocationInfo$ChannelLocation guildScheduledEventLocationInfo$ChannelLocation = (GuildScheduledEventLocationInfo$ChannelLocation) locationInfo;
        Channel channel = guildScheduledEventLocationInfo$ChannelLocation != null ? guildScheduledEventLocationInfo$ChannelLocation.getChannel() : null;
        int audienceSize = data2.getAudienceSize();
        boolean z2 = channel != null && channel.getType() == 13;
        if (z2) {
            i = 2131231624;
        } else {
            i = (channel == null || channel.getType() != 2) ? 2131231900 : 2131231640;
        }
        ConstraintLayout constraintLayout = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        Drawable drawable = ContextCompat.getDrawable(constraintLayout.getContext(), i);
        this.binding.f.setText(data2.getLocationInfo() instanceof GuildScheduledEventLocationInfo$ExternalLocation ? 2131892561 : 2131895796);
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.eventTopic");
        textView.setText(data2.getTopic());
        TextView textView2 = this.binding.c;
        m.checkNotNullExpressionValue(textView2, "binding.eventChannel");
        if (channel != null) {
            ConstraintLayout constraintLayout2 = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout2, "binding.root");
            Context context = constraintLayout2.getContext();
            m.checkNotNullExpressionValue(context, "binding.root.context");
            locationName = ChannelUtils.e(channel, context, false, 2);
            if (locationName == null) {
                locationName = data2.getLocationInfo().getLocationName();
            }
        } else {
            locationName = data2.getLocationInfo().getLocationName();
        }
        textView2.setText(locationName);
        this.binding.c.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        TextView textView3 = this.binding.g;
        m.checkNotNullExpressionValue(textView3, "binding.stageEventListeners");
        textView3.setVisibility(z2 ? 0 : 8);
        TextView textView4 = this.binding.g;
        m.checkNotNullExpressionValue(textView4, "binding.stageEventListeners");
        b.n(textView4, 2131892558, new Object[]{Integer.valueOf(audienceSize)}, null, 4);
        ImageView imageView = this.binding.f2284b;
        m.checkNotNullExpressionValue(imageView, "binding.channelSeparator");
        imageView.setVisibility(z2 ? 0 : 8);
        UserSummaryView userSummaryView = this.binding.h;
        userSummaryView.setVisibility(data2.getSpeakers().isEmpty() ^ true ? 0 : 8);
        if (!data2.getSpeakers().isEmpty()) {
            UserSummaryView.b(userSummaryView, data2.getSpeakers(), false, 2);
        }
        MaterialTextView materialTextView = this.binding.i;
        materialTextView.setVisibility(data2.getSpeakers().isEmpty() ^ true ? 0 : 8);
        if (!data2.getSpeakers().isEmpty()) {
            if (data2.getSpeakers().size() != 1) {
                Context context2 = materialTextView.getContext();
                m.checkNotNullExpressionValue(context2, "context");
                username = b.j(materialTextView, 2131897008, new Object[]{data2.getSpeakers().get(0).getUser().getUsername(), StringResourceUtilsKt.getI18nPluralString(context2, R$plurals.user_summary_with_others_count, data2.getSpeakers().size() - 1, Integer.valueOf(data2.getSpeakers().size() - 1))}, null, 4);
            } else {
                username = data2.getSpeakers().get(0).getUser().getUsername();
            }
            materialTextView.setText(username);
        }
        MaterialButton materialButton = this.binding.d;
        if (data2.getLocationInfo() instanceof GuildScheduledEventLocationInfo$ExternalLocation) {
            i2 = 2131895388;
        } else {
            i2 = !z2 ? 2131892378 : 2131895792;
        }
        materialButton.setText(i2);
    }
}

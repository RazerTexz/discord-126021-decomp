package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.databinding.WidgetChannelsListItemGuildJoinRequestBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.utilities.color.ColorCompat;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemGuildJoinRequest;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemGuildJoinRequest extends WidgetChannelsListAdapter$Item {
    private final WidgetChannelsListItemGuildJoinRequestBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListAdapter$ItemGuildJoinRequest(int i, WidgetChannelsListAdapter widgetChannelsListAdapter) {
        super(i, widgetChannelsListAdapter);
        m.checkNotNullParameter(widgetChannelsListAdapter, "adapter");
        View view = this.itemView;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i2 = R$id.channels_list_item_guild_join_request_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.channels_list_item_guild_join_request_button);
        if (materialButton != null) {
            i2 = R$id.channels_list_item_guild_join_request_label;
            TextView textView = (TextView) view.findViewById(R$id.channels_list_item_guild_join_request_label);
            if (textView != null) {
                WidgetChannelsListItemGuildJoinRequestBinding widgetChannelsListItemGuildJoinRequestBinding = new WidgetChannelsListItemGuildJoinRequestBinding((ConstraintLayout) view, constraintLayout, materialButton, textView);
                m.checkNotNullExpressionValue(widgetChannelsListItemGuildJoinRequestBinding, "WidgetChannelsListItemGu…estBinding.bind(itemView)");
                this.binding = widgetChannelsListItemGuildJoinRequestBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static final /* synthetic */ WidgetChannelsListAdapter access$getAdapter$p(WidgetChannelsListAdapter$ItemGuildJoinRequest widgetChannelsListAdapter$ItemGuildJoinRequest) {
        return (WidgetChannelsListAdapter) widgetChannelsListAdapter$ItemGuildJoinRequest.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelListItem channelListItem) {
        onConfigure2(i, channelListItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, ChannelListItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data instanceof ChannelListItemGuildJoinRequest) {
            ConstraintLayout constraintLayout = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            Context context = constraintLayout.getContext();
            ChannelListItemGuildJoinRequest channelListItemGuildJoinRequest = (ChannelListItemGuildJoinRequest) data;
            ApplicationStatus applicationStatus = channelListItemGuildJoinRequest.getGuildJoinRequest().getApplicationStatus();
            GuildMember member = channelListItemGuildJoinRequest.getMember();
            this.binding.c.setOnClickListener(new WidgetChannelsListAdapter$ItemGuildJoinRequest$onConfigure$1(this, context));
            if (!member.getPending()) {
                ConstraintLayout constraintLayout2 = this.binding.f2292b;
                m.checkNotNullExpressionValue(constraintLayout2, "binding.channelsListItemGuildJoinRequest");
                constraintLayout2.setVisibility(8);
            }
            int iOrdinal = applicationStatus.ordinal();
            if (iOrdinal == 0) {
                this.binding.d.setText(2131892877);
                this.binding.c.setText(2131892876);
                this.binding.c.setBackgroundColor(ColorCompat.getThemedColor(context, 2130969062));
                ConstraintLayout constraintLayout3 = this.binding.f2292b;
                m.checkNotNullExpressionValue(constraintLayout3, "binding.channelsListItemGuildJoinRequest");
                constraintLayout3.setVisibility(0);
                return;
            }
            if (iOrdinal == 1) {
                this.binding.d.setText(2131892896);
                this.binding.c.setText(2131892888);
                this.binding.c.setBackgroundColor(ColorCompat.getThemedColor(context, 2130968896));
                ConstraintLayout constraintLayout4 = this.binding.f2292b;
                m.checkNotNullExpressionValue(constraintLayout4, "binding.channelsListItemGuildJoinRequest");
                constraintLayout4.setVisibility(0);
                return;
            }
            if (iOrdinal != 2) {
                ConstraintLayout constraintLayout5 = this.binding.f2292b;
                m.checkNotNullExpressionValue(constraintLayout5, "binding.channelsListItemGuildJoinRequest");
                constraintLayout5.setVisibility(8);
            } else {
                this.binding.d.setText(2131892802);
                this.binding.c.setText(2131892863);
                this.binding.c.setBackgroundColor(ColorCompat.getThemedColor(context, 2130968896));
                ConstraintLayout constraintLayout6 = this.binding.f2292b;
                m.checkNotNullExpressionValue(constraintLayout6, "binding.channelsListItemGuildJoinRequest");
                constraintLayout6.setVisibility(0);
            }
        }
    }
}

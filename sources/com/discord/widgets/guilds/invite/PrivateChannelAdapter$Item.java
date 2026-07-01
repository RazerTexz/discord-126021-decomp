package com.discord.widgets.guilds.invite;

import android.widget.TextView;
import com.discord.R$layout;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.WidgetGuildInviteShareItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;

/* JADX INFO: compiled from: PrivateChannelAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PrivateChannelAdapter$Item extends MGRecyclerViewHolder<PrivateChannelAdapter, InviteSuggestionItem> {
    private final WidgetGuildInviteShareItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateChannelAdapter$Item(PrivateChannelAdapter privateChannelAdapter) {
        super(R$layout.widget_guild_invite_share_item, privateChannelAdapter);
        m.checkNotNullParameter(privateChannelAdapter, "adapter");
        WidgetGuildInviteShareItemBinding widgetGuildInviteShareItemBindingA = WidgetGuildInviteShareItemBinding.a(this.itemView);
        m.checkNotNullExpressionValue(widgetGuildInviteShareItemBindingA, "WidgetGuildInviteShareItemBinding.bind(itemView)");
        this.binding = widgetGuildInviteShareItemBindingA;
    }

    public static final /* synthetic */ PrivateChannelAdapter access$getAdapter$p(PrivateChannelAdapter$Item privateChannelAdapter$Item) {
        return (PrivateChannelAdapter) privateChannelAdapter$Item.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, InviteSuggestionItem inviteSuggestionItem) {
        onConfigure2(i, inviteSuggestionItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, InviteSuggestionItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        boolean z2 = data instanceof InviteSuggestionItem$ChannelItem;
        if (z2) {
            InviteSuggestionItem$ChannelItem inviteSuggestionItem$ChannelItem = (InviteSuggestionItem$ChannelItem) data;
            if (inviteSuggestionItem$ChannelItem.getChannel().getType() != 1) {
                SimpleDraweeView simpleDraweeView = this.binding.f2421b;
                m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIconIv");
                IconUtils.setIcon$default(simpleDraweeView, inviteSuggestionItem$ChannelItem.getChannel(), 0, (MGImages$ChangeDetector) null, 12, (Object) null);
            } else {
                SimpleDraweeView simpleDraweeView2 = this.binding.f2421b;
                m.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemIconIv");
                IconUtils.setIcon$default(simpleDraweeView2, ChannelUtils.a(inviteSuggestionItem$ChannelItem.getChannel()), 0, null, null, null, 60, null);
            }
            TextView textView = this.binding.d;
            m.checkNotNullExpressionValue(textView, "binding.itemNameTv");
            textView.setText(ChannelUtils.c(inviteSuggestionItem$ChannelItem.getChannel()));
        } else if (data instanceof InviteSuggestionItem$UserItem) {
            SimpleDraweeView simpleDraweeView3 = this.binding.f2421b;
            m.checkNotNullExpressionValue(simpleDraweeView3, "binding.itemIconIv");
            InviteSuggestionItem$UserItem inviteSuggestionItem$UserItem = (InviteSuggestionItem$UserItem) data;
            IconUtils.setIcon$default(simpleDraweeView3, inviteSuggestionItem$UserItem.getUser(), 0, null, null, null, 60, null);
            TextView textView2 = this.binding.d;
            m.checkNotNullExpressionValue(textView2, "binding.itemNameTv");
            textView2.setText(inviteSuggestionItem$UserItem.getUser().getUsername());
        }
        if (z2 || (data instanceof InviteSuggestionItem$UserItem)) {
            MaterialButton materialButton = this.binding.e;
            m.checkNotNullExpressionValue(materialButton, "binding.itemSent");
            materialButton.setVisibility(data.hasSentInvite() ? 0 : 8);
            MaterialButton materialButton2 = this.binding.c;
            m.checkNotNullExpressionValue(materialButton2, "binding.itemInviteBtn");
            materialButton2.setVisibility(data.hasSentInvite() ^ true ? 0 : 8);
            this.binding.c.setOnClickListener(new PrivateChannelAdapter$Item$onConfigure$1(this, data));
        }
    }
}

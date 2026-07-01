package com.discord.widgets.guilds.invite;

import android.widget.TextView;
import com.discord.R$integer;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.WidgetGuildInviteShareItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.user.UserNameFormatterKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;

/* JADX INFO: compiled from: InviteSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InviteSuggestionsAdapter$InviteSuggestionViewHolder extends MGRecyclerViewHolder<InviteSuggestionsAdapter, InviteSuggestionItemV2> {
    private final WidgetGuildInviteShareItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InviteSuggestionsAdapter$InviteSuggestionViewHolder(InviteSuggestionsAdapter inviteSuggestionsAdapter) {
        super(R$layout.widget_guild_invite_share_item, inviteSuggestionsAdapter);
        m.checkNotNullParameter(inviteSuggestionsAdapter, "adapter");
        WidgetGuildInviteShareItemBinding widgetGuildInviteShareItemBindingA = WidgetGuildInviteShareItemBinding.a(this.itemView);
        m.checkNotNullExpressionValue(widgetGuildInviteShareItemBindingA, "WidgetGuildInviteShareItemBinding.bind(itemView)");
        this.binding = widgetGuildInviteShareItemBindingA;
    }

    public static final /* synthetic */ InviteSuggestionsAdapter access$getAdapter$p(InviteSuggestionsAdapter$InviteSuggestionViewHolder inviteSuggestionsAdapter$InviteSuggestionViewHolder) {
        return (InviteSuggestionsAdapter) inviteSuggestionsAdapter$InviteSuggestionViewHolder.adapter;
    }

    private final void configureItemForChannel(Channel channel) {
        SimpleDraweeView simpleDraweeView = this.binding.f2421b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIconIv");
        IconUtils.setIcon$default(simpleDraweeView, channel, 0, (MGImages$ChangeDetector) null, 12, (Object) null);
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.itemNameTv");
        textView.setText(ChannelUtils.c(channel));
    }

    private final void configureItemForUser(User user) {
        SimpleDraweeView simpleDraweeView = this.binding.f2421b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIconIv");
        IconUtils.setIcon$default(simpleDraweeView, user, 0, null, null, null, 60, null);
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.itemNameTv");
        textView.setText(UserNameFormatterKt.getSpannableForUserNameWithDiscrim(user, null, ((InviteSuggestionsAdapter) this.adapter).getContext(), 2130968989, 2130969396, R$integer.uikit_textsize_large_sp, 2130969056, 2130969395, R$integer.uikit_textsize_large_sp));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, InviteSuggestionItemV2 inviteSuggestionItemV2) {
        onConfigure2(i, inviteSuggestionItemV2);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, InviteSuggestionItemV2 data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        boolean z2 = data instanceof InviteSuggestionItemV2$ChannelItem;
        if (z2) {
            InviteSuggestionItemV2$ChannelItem inviteSuggestionItemV2$ChannelItem = (InviteSuggestionItemV2$ChannelItem) data;
            User userA = ChannelUtils.a(inviteSuggestionItemV2$ChannelItem.getChannel());
            if (userA != null) {
                configureItemForUser(userA);
            } else {
                configureItemForChannel(inviteSuggestionItemV2$ChannelItem.getChannel());
            }
        } else if (data instanceof InviteSuggestionItemV2$UserItem) {
            configureItemForUser(((InviteSuggestionItemV2$UserItem) data).getUser());
        }
        if (z2 || (data instanceof InviteSuggestionItemV2$UserItem)) {
            MaterialButton materialButton = this.binding.e;
            m.checkNotNullExpressionValue(materialButton, "binding.itemSent");
            materialButton.setVisibility(data.hasSentInvite() ? 0 : 8);
            MaterialButton materialButton2 = this.binding.c;
            m.checkNotNullExpressionValue(materialButton2, "binding.itemInviteBtn");
            materialButton2.setVisibility(data.hasSentInvite() ^ true ? 0 : 8);
            this.binding.c.setOnClickListener(new InviteSuggestionsAdapter$InviteSuggestionViewHolder$onConfigure$1(this, data));
        }
    }
}

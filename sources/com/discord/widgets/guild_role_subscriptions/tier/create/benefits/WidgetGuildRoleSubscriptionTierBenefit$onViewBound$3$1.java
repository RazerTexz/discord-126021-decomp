package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.app.AppFragment;
import com.discord.models.domain.emoji.Emoji;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3$1 implements EmojiPickerListener {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3 this$0;

    public WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3$1(WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3 widgetGuildRoleSubscriptionTierBenefit$onViewBound$3) {
        this.this$0 = widgetGuildRoleSubscriptionTierBenefit$onViewBound$3;
    }

    @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
    public void onEmojiPicked(Emoji emoji) {
        m.checkNotNullParameter(emoji, "emoji");
        WidgetGuildRoleSubscriptionTierBenefit.access$getViewModel$p(this.this$0.this$0).updateEmoji(emoji);
        AppFragment.hideKeyboard$default(this.this$0.this$0, null, 1, null);
    }
}

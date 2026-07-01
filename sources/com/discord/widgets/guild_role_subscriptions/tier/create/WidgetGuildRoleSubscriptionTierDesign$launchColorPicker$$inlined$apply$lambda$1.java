package com.discord.widgets.guild_role_subscriptions.tier.create;

import b.k.a.a.f;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDesign$launchColorPicker$$inlined$apply$lambda$1 implements f {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierDesign this$0;

    public WidgetGuildRoleSubscriptionTierDesign$launchColorPicker$$inlined$apply$lambda$1(WidgetGuildRoleSubscriptionTierDesign widgetGuildRoleSubscriptionTierDesign) {
        this.this$0 = widgetGuildRoleSubscriptionTierDesign;
    }

    @Override // b.k.a.a.f
    public void onColorReset(int dialogId) {
        WidgetGuildRoleSubscriptionTierDesign.access$getViewModel$p(this.this$0).updateMemberColor(null);
    }

    @Override // b.k.a.a.f
    public void onColorSelected(int dialogId, int selectedColor) {
        WidgetGuildRoleSubscriptionTierDesign.access$getViewModel$p(this.this$0).updateMemberColor(Integer.valueOf(selectedColor));
    }

    @Override // b.k.a.a.f
    public void onDialogDismissed(int dialogId) {
    }
}

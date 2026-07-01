package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.channels.WidgetChannelPickerBottomSheet;
import com.discord.widgets.channels.WidgetChannelPickerBottomSheet$Companion;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ GuildRoleSubscriptionTierBenefitViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefit this$0;

    public WidgetGuildRoleSubscriptionTierBenefit$configureUI$1(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit, GuildRoleSubscriptionTierBenefitViewModel$ViewState guildRoleSubscriptionTierBenefitViewModel$ViewState) {
        this.this$0 = widgetGuildRoleSubscriptionTierBenefit;
        this.$viewState = guildRoleSubscriptionTierBenefitViewModel$ViewState;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelPickerBottomSheet$Companion widgetChannelPickerBottomSheet$Companion = WidgetChannelPickerBottomSheet.Companion;
        WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit = this.this$0;
        widgetChannelPickerBottomSheet$Companion.launch(widgetGuildRoleSubscriptionTierBenefit, "REQUEST_KEY_CHANNEL_PICKER", WidgetGuildRoleSubscriptionTierBenefit.access$getGuildId$p(widgetGuildRoleSubscriptionTierBenefit), this.$viewState.getChannelId(), new WidgetGuildRoleSubscriptionTierBenefit$configureUI$1$1(this), true);
    }
}

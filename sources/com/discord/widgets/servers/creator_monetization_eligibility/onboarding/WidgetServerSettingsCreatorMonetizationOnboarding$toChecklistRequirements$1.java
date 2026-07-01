package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import com.discord.R$plurals;
import com.discord.api.creatormonetization.CreatorMonetizationEligibilityRequirements;
import com.discord.i18n.RenderContext;
import com.discord.utilities.resources.StringResourceUtilsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboarding$toChecklistRequirements$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ CreatorMonetizationEligibilityRequirements $this_toChecklistRequirements;
    public final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboarding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCreatorMonetizationOnboarding$toChecklistRequirements$1(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding, CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements) {
        super(1);
        this.this$0 = widgetServerSettingsCreatorMonetizationOnboarding;
        this.$this_toChecklistRequirements = creatorMonetizationEligibilityRequirements;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.args.put("minimumSize", StringResourceUtilsKt.getI18nPluralString(this.this$0.requireContext(), R$plurals.guild_role_subscription_settings_eligibility_requirement_members_description_minimumSize, this.$this_toChecklistRequirements.getMinimumSize(), Integer.valueOf(this.$this_toChecklistRequirements.getMinimumSize())).toString());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }
}

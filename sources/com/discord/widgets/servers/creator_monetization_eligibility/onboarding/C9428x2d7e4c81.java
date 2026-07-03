package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import com.discord.i18n.RenderContext;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$2$1 */
/* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9428x2d7e4c81 extends AbstractC12240o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ CharSequence $rejectionCooldown;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9428x2d7e4c81(CharSequence charSequence) {
        super(1);
        this.$rejectionCooldown = charSequence;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        C12238m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.args.put("requestCooldownDuration", this.$rejectionCooldown.toString());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.f27425a;
    }
}

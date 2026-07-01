package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import com.discord.i18n.RenderContext;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboarding$toChecklistRequirements$3 extends o implements Function1<RenderContext, Unit> {
    public static final WidgetServerSettingsCreatorMonetizationOnboarding$toChecklistRequirements$3 INSTANCE = new WidgetServerSettingsCreatorMonetizationOnboarding$toChecklistRequirements$3();

    public WidgetServerSettingsCreatorMonetizationOnboarding$toChecklistRequirements$3() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.args.put("communityGuidelinesUrl", "https://support.discord.com/hc/en-us/articles/360035969312");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }
}

package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import com.discord.i18n.Hook;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.textprocessing.FontColorSpan;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$4$1 extends o implements Function1<Hook, Unit> {
    public final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$4 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$4$1(WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$4 widgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$4) {
        super(1);
        this.this$0 = widgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$4;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Hook hook) {
        m.checkNotNullParameter(hook, "$receiver");
        hook.styles.add(new FontColorSpan(ColorCompatKt.getColor(this.this$0.this$0, 2131100382)));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
        invoke2(hook);
        return Unit.a;
    }
}

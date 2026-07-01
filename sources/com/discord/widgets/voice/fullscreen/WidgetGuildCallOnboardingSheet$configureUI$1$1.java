package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildCallOnboardingSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildCallOnboardingSheet$configureUI$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetGuildCallOnboardingSheet$configureUI$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCallOnboardingSheet$configureUI$1$1(WidgetGuildCallOnboardingSheet$configureUI$1 widgetGuildCallOnboardingSheet$configureUI$1) {
        super(0);
        this.this$0 = widgetGuildCallOnboardingSheet$configureUI$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetGuildCallOnboardingSheet$Companion widgetGuildCallOnboardingSheet$Companion = WidgetGuildCallOnboardingSheet.Companion;
        Context contextRequireContext = this.this$0.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        widgetGuildCallOnboardingSheet$Companion.markSeenUserVoiceChannelOnboarding(contextRequireContext);
        WidgetGuildCallOnboardingSheet.access$getViewModel$p(this.this$0.this$0).onConnectPressed();
    }
}

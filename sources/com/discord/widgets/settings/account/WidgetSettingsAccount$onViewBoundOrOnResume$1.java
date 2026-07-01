package com.discord.widgets.settings.account;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccount$onViewBoundOrOnResume$1 extends o implements Function1<WidgetSettingsAccount$Model, Unit> {
    public final /* synthetic */ WidgetSettingsAccount this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccount$onViewBoundOrOnResume$1(WidgetSettingsAccount widgetSettingsAccount) {
        super(1);
        this.this$0 = widgetSettingsAccount;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetSettingsAccount$Model widgetSettingsAccount$Model) {
        invoke2(widgetSettingsAccount$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetSettingsAccount$Model widgetSettingsAccount$Model) {
        WidgetSettingsAccount widgetSettingsAccount = this.this$0;
        m.checkNotNullExpressionValue(widgetSettingsAccount$Model, "it");
        WidgetSettingsAccount.access$configureUI(widgetSettingsAccount, widgetSettingsAccount$Model);
    }
}

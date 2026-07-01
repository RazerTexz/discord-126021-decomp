package com.discord.widgets.settings;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAuthorizedApps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAuthorizedApps$deauthorizeApp$1$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ WidgetSettingsAuthorizedApps$deauthorizeApp$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAuthorizedApps$deauthorizeApp$1$1(WidgetSettingsAuthorizedApps$deauthorizeApp$1 widgetSettingsAuthorizedApps$deauthorizeApp$1) {
        super(1);
        this.this$0 = widgetSettingsAuthorizedApps$deauthorizeApp$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r1) {
        WidgetSettingsAuthorizedApps.access$loadAuthorizedApps(this.this$0.this$0);
    }
}

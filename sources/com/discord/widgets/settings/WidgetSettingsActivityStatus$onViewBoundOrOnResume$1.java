package com.discord.widgets.settings;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsActivityStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsActivityStatus$onViewBoundOrOnResume$1 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ WidgetSettingsActivityStatus this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsActivityStatus$onViewBoundOrOnResume$1(WidgetSettingsActivityStatus widgetSettingsActivityStatus) {
        super(1);
        this.this$0 = widgetSettingsActivityStatus;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        WidgetSettingsActivityStatus.access$configureUI(this.this$0, z2);
    }
}

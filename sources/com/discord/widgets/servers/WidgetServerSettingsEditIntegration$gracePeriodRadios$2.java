package com.discord.widgets.servers;

import com.discord.views.CheckedSetting;
import d0.t.n;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditIntegration$gracePeriodRadios$2 extends o implements Function0<List<? extends CheckedSetting>> {
    public final /* synthetic */ WidgetServerSettingsEditIntegration this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEditIntegration$gracePeriodRadios$2(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
        super(0);
        this.this$0 = widgetServerSettingsEditIntegration;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends CheckedSetting> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends CheckedSetting> invoke2() {
        return n.listOf((Object[]) new CheckedSetting[]{WidgetServerSettingsEditIntegration.access$getBinding$p(this.this$0).h, WidgetServerSettingsEditIntegration.access$getBinding$p(this.this$0).j, WidgetServerSettingsEditIntegration.access$getBinding$p(this.this$0).k, WidgetServerSettingsEditIntegration.access$getBinding$p(this.this$0).g, WidgetServerSettingsEditIntegration.access$getBinding$p(this.this$0).i});
    }
}

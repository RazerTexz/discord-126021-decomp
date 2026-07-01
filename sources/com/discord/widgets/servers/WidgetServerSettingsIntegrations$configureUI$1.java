package com.discord.widgets.servers;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsIntegrations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsIntegrations$configureUI$1 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetServerSettingsIntegrations$Model $model;
    public final /* synthetic */ WidgetServerSettingsIntegrations this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsIntegrations$configureUI$1(WidgetServerSettingsIntegrations widgetServerSettingsIntegrations, WidgetServerSettingsIntegrations$Model widgetServerSettingsIntegrations$Model) {
        super(1);
        this.this$0 = widgetServerSettingsIntegrations;
        this.$model = widgetServerSettingsIntegrations$Model;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        WidgetServerSettingsEditIntegration.Companion.launch(this.$model.getGuildId(), j, this.this$0.requireContext());
    }
}

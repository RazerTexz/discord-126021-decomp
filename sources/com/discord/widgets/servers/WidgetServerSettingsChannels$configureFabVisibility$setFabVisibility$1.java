package com.discord.widgets.servers;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannels$configureFabVisibility$setFabVisibility$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetServerSettingsChannels$Model $model;
    public final /* synthetic */ WidgetServerSettingsChannels this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsChannels$configureFabVisibility$setFabVisibility$1(WidgetServerSettingsChannels widgetServerSettingsChannels, WidgetServerSettingsChannels$Model widgetServerSettingsChannels$Model) {
        super(0);
        this.this$0 = widgetServerSettingsChannels;
        this.$model = widgetServerSettingsChannels$Model;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$model.isSorting()) {
            WidgetServerSettingsChannels.access$getBinding$p(this.this$0).c.hide();
        } else {
            WidgetServerSettingsChannels.access$getBinding$p(this.this$0).c.show();
        }
    }
}

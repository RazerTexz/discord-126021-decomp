package com.discord.widgets.servers;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannels$reorderChannels$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetServerSettingsChannels$Model $data;
    public final /* synthetic */ WidgetServerSettingsChannels this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsChannels$reorderChannels$2(WidgetServerSettingsChannels widgetServerSettingsChannels, WidgetServerSettingsChannels$Model widgetServerSettingsChannels$Model) {
        super(1);
        this.this$0 = widgetServerSettingsChannels;
        this.$data = widgetServerSettingsChannels$Model;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) throws Exception {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) throws Exception {
        m.checkNotNullParameter(error, "it");
        WidgetServerSettingsChannels.access$configureUI(this.this$0, this.$data);
    }
}

package com.discord.widgets.channels.list;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadArchiveActions$bindSubscriptions$1 extends k implements Function1<WidgetThreadArchiveActions$Model, Unit> {
    public WidgetThreadArchiveActions$bindSubscriptions$1(WidgetThreadArchiveActions widgetThreadArchiveActions) {
        super(1, widgetThreadArchiveActions, WidgetThreadArchiveActions.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/list/WidgetThreadArchiveActions$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadArchiveActions$Model widgetThreadArchiveActions$Model) {
        invoke2(widgetThreadArchiveActions$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetThreadArchiveActions$Model widgetThreadArchiveActions$Model) {
        WidgetThreadArchiveActions.access$configureUI((WidgetThreadArchiveActions) this.receiver, widgetThreadArchiveActions$Model);
    }
}

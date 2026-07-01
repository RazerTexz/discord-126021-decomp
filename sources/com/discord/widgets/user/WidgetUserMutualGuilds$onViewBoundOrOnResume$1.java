package com.discord.widgets.user;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserMutualGuilds.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualGuilds$onViewBoundOrOnResume$1 extends o implements Function1<WidgetUserMutualGuilds$Model, Unit> {
    public final /* synthetic */ WidgetUserMutualGuilds this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMutualGuilds$onViewBoundOrOnResume$1(WidgetUserMutualGuilds widgetUserMutualGuilds) {
        super(1);
        this.this$0 = widgetUserMutualGuilds;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetUserMutualGuilds$Model widgetUserMutualGuilds$Model) {
        invoke2(widgetUserMutualGuilds$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetUserMutualGuilds$Model widgetUserMutualGuilds$Model) {
        m.checkNotNullParameter(widgetUserMutualGuilds$Model, "data");
        WidgetUserMutualGuilds.access$configureUI(this.this$0, widgetUserMutualGuilds$Model);
    }
}

package com.discord.widgets.user;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$onViewBoundOrOnResume$1 extends o implements Function1<WidgetUserMentions$Model, Unit> {
    public final /* synthetic */ WidgetUserMentions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMentions$onViewBoundOrOnResume$1(WidgetUserMentions widgetUserMentions) {
        super(1);
        this.this$0 = widgetUserMentions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetUserMentions$Model widgetUserMentions$Model) {
        invoke2(widgetUserMentions$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetUserMentions$Model widgetUserMentions$Model) {
        m.checkNotNullParameter(widgetUserMentions$Model, "it");
        WidgetUserMentions.access$configureUI(this.this$0, widgetUserMentions$Model);
    }
}

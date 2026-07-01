package com.discord.widgets.user.email;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserEmailVerify$onViewBoundOrOnResume$1 extends k implements Function1<WidgetUserEmailVerify$Model, Unit> {
    public WidgetUserEmailVerify$onViewBoundOrOnResume$1(WidgetUserEmailVerify widgetUserEmailVerify) {
        super(1, widgetUserEmailVerify, WidgetUserEmailVerify.class, "configureUI", "configureUI(Lcom/discord/widgets/user/email/WidgetUserEmailVerify$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetUserEmailVerify$Model widgetUserEmailVerify$Model) {
        invoke2(widgetUserEmailVerify$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetUserEmailVerify$Model widgetUserEmailVerify$Model) {
        m.checkNotNullParameter(widgetUserEmailVerify$Model, "p1");
        WidgetUserEmailVerify.access$configureUI((WidgetUserEmailVerify) this.receiver, widgetUserEmailVerify$Model);
    }
}

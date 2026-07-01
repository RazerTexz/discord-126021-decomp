package com.discord.widgets.home;

import com.discord.api.interaction.InteractionModalCreate;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$onViewBoundOrOnResume$12 extends o implements Function1<InteractionModalCreate, Unit> {
    public final /* synthetic */ WidgetHome this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHome$onViewBoundOrOnResume$12(WidgetHome widgetHome) {
        super(1);
        this.this$0 = widgetHome;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(InteractionModalCreate interactionModalCreate) {
        invoke2(interactionModalCreate);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(InteractionModalCreate interactionModalCreate) {
        m.checkNotNullParameter(interactionModalCreate, "it");
        WidgetHome.access$showInteractionModal(this.this$0, interactionModalCreate);
    }
}

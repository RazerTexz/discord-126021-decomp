package com.discord.widgets.guilds.create;

import com.discord.i18n.RenderContext;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCreationIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreationIntent$onViewBound$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ WidgetCreationIntent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCreationIntent$onViewBound$1(WidgetCreationIntent widgetCreationIntent) {
        super(1);
        this.this$0 = widgetCreationIntent;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.b("onSkip", new WidgetCreationIntent$onViewBound$1$1(this));
    }
}

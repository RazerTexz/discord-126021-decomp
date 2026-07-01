package com.discord.widgets.servers.guildboost;

import com.discord.i18n.RenderContext;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoost$onViewBound$3 extends o implements Function1<RenderContext, Unit> {
    public static final WidgetGuildBoost$onViewBound$3 INSTANCE = new WidgetGuildBoost$onViewBound$3();

    public WidgetGuildBoost$onViewBound$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.b("learnMore", WidgetGuildBoost$onViewBound$3$1.INSTANCE);
    }
}

package com.discord.widgets.servers.guildboost;

import com.discord.i18n.RenderContext;
import com.discord.utilities.color.ColorCompat;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoost$onViewBound$4 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ WidgetGuildBoost this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildBoost$onViewBound$4(WidgetGuildBoost widgetGuildBoost) {
        super(1);
        this.this$0 = widgetGuildBoost;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.boldColor = Integer.valueOf(ColorCompat.getColor(this.this$0.requireContext(), 2131100304));
        renderContext.b("onLearnMore", WidgetGuildBoost$onViewBound$4$1.INSTANCE);
        renderContext.a("protipHook", WidgetGuildBoost$onViewBound$4$2.INSTANCE);
    }
}

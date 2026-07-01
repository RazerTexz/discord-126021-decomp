package com.discord.widgets.settings.premium;

import b.a.k.b;
import com.discord.i18n.RenderContext;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPremium$onViewBound$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ WidgetSettingsPremium this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPremium$onViewBound$1(WidgetSettingsPremium widgetSettingsPremium) {
        super(1);
        this.this$0 = widgetSettingsPremium;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.args.put("maxUploadStandard", b.k(this.this$0, 2131889029, new Object[0], null, 4).toString());
        renderContext.args.put("maxUploadPremium", b.k(this.this$0, 2131889028, new Object[0], null, 4).toString());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }
}

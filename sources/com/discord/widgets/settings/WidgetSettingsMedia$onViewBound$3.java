package com.discord.widgets.settings;

import com.discord.i18n.RenderContext;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsMedia$onViewBound$3 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ WidgetSettingsMedia this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsMedia$onViewBound$3(WidgetSettingsMedia widgetSettingsMedia) {
        super(1);
        this.this$0 = widgetSettingsMedia;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.b("getNitro", new WidgetSettingsMedia$onViewBound$3$1(this));
    }
}

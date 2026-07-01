package com.discord.widgets.settings;

import com.discord.i18n.RenderContext;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$onViewBound$2 extends o implements Function1<RenderContext, Unit> {
    public static final WidgetSettingsPrivacy$onViewBound$2 INSTANCE = new WidgetSettingsPrivacy$onViewBound$2();

    public WidgetSettingsPrivacy$onViewBound$2() {
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
        renderContext.b("onClick", WidgetSettingsPrivacy$onViewBound$2$1.INSTANCE);
    }
}

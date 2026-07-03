package com.discord.widgets.media;

import com.discord.databinding.WidgetMediaBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetMedia$binding$3 extends C12236k implements Function1<WidgetMediaBinding, Unit> {
    public WidgetMedia$binding$3(WidgetMedia widgetMedia) {
        super(1, widgetMedia, WidgetMedia.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetMediaBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetMediaBinding widgetMediaBinding) {
        invoke2(widgetMediaBinding);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetMediaBinding widgetMediaBinding) {
        C12238m.checkNotNullParameter(widgetMediaBinding, "p1");
        ((WidgetMedia) this.receiver).onViewBindingDestroy(widgetMediaBinding);
    }
}

package com.discord.widgets.changelog;

import com.discord.databinding.WidgetChangeLogSpecialBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChangeLogSpecial.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChangeLogSpecial$binding$3 extends k implements Function1<WidgetChangeLogSpecialBinding, Unit> {
    public WidgetChangeLogSpecial$binding$3(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        super(1, widgetChangeLogSpecial, WidgetChangeLogSpecial.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetChangeLogSpecialBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChangeLogSpecialBinding widgetChangeLogSpecialBinding) {
        invoke2(widgetChangeLogSpecialBinding);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChangeLogSpecialBinding widgetChangeLogSpecialBinding) {
        m.checkNotNullParameter(widgetChangeLogSpecialBinding, "p1");
        WidgetChangeLogSpecial.access$onViewBindingDestroy((WidgetChangeLogSpecial) this.receiver, widgetChangeLogSpecialBinding);
    }
}

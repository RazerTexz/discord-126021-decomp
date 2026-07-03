package com.discord.widgets.changelog;

import com.discord.databinding.WidgetChangeLogSpecialBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChangeLogSpecial.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChangeLogSpecial$binding$3 extends C12236k implements Function1<WidgetChangeLogSpecialBinding, Unit> {
    public WidgetChangeLogSpecial$binding$3(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        super(1, widgetChangeLogSpecial, WidgetChangeLogSpecial.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetChangeLogSpecialBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChangeLogSpecialBinding widgetChangeLogSpecialBinding) {
        invoke2(widgetChangeLogSpecialBinding);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChangeLogSpecialBinding widgetChangeLogSpecialBinding) {
        C12238m.checkNotNullParameter(widgetChangeLogSpecialBinding, "p1");
        ((WidgetChangeLogSpecial) this.receiver).onViewBindingDestroy(widgetChangeLogSpecialBinding);
    }
}

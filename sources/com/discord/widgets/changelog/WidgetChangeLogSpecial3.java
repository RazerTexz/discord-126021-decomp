package com.discord.widgets.changelog;

import com.discord.databinding.WidgetChangeLogSpecialBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$binding$3, reason: use source file name */
/* JADX INFO: compiled from: WidgetChangeLogSpecial.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChangeLogSpecial3 extends FunctionReferenceImpl implements Function1<WidgetChangeLogSpecialBinding, Unit> {
    public WidgetChangeLogSpecial3(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        super(1, widgetChangeLogSpecial, WidgetChangeLogSpecial.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetChangeLogSpecialBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChangeLogSpecialBinding widgetChangeLogSpecialBinding) {
        invoke2(widgetChangeLogSpecialBinding);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChangeLogSpecialBinding widgetChangeLogSpecialBinding) {
        Intrinsics3.checkNotNullParameter(widgetChangeLogSpecialBinding, "p1");
        ((WidgetChangeLogSpecial) this.receiver).onViewBindingDestroy(widgetChangeLogSpecialBinding);
    }
}

package com.discord.widgets.media;

import com.discord.databinding.WidgetMediaBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.media.WidgetMedia$binding$3, reason: use source file name */
/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetMedia3 extends FunctionReferenceImpl implements Function1<WidgetMediaBinding, Unit> {
    public WidgetMedia3(WidgetMedia widgetMedia) {
        super(1, widgetMedia, WidgetMedia.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetMediaBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetMediaBinding widgetMediaBinding) {
        invoke2(widgetMediaBinding);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetMediaBinding widgetMediaBinding) {
        Intrinsics3.checkNotNullParameter(widgetMediaBinding, "p1");
        ((WidgetMedia) this.receiver).onViewBindingDestroy(widgetMediaBinding);
    }
}

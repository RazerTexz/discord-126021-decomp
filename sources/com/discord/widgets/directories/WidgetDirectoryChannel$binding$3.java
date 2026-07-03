package com.discord.widgets.directories;

import com.discord.databinding.WidgetDirectoryChannelBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetDirectoryChannel$binding$3 extends C12236k implements Function1<WidgetDirectoryChannelBinding, Unit> {
    public WidgetDirectoryChannel$binding$3(WidgetDirectoryChannel widgetDirectoryChannel) {
        super(1, widgetDirectoryChannel, WidgetDirectoryChannel.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetDirectoryChannelBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoryChannelBinding widgetDirectoryChannelBinding) {
        invoke2(widgetDirectoryChannelBinding);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetDirectoryChannelBinding widgetDirectoryChannelBinding) {
        C12238m.checkNotNullParameter(widgetDirectoryChannelBinding, "p1");
        ((WidgetDirectoryChannel) this.receiver).onViewBindingDestroy(widgetDirectoryChannelBinding);
    }
}

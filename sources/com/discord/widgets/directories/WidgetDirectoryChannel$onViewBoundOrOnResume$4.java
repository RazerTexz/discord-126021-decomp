package com.discord.widgets.directories;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryChannel$onViewBoundOrOnResume$4 extends o implements Function1<WidgetDirectoriesViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetDirectoryChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoryChannel$onViewBoundOrOnResume$4(WidgetDirectoryChannel widgetDirectoryChannel) {
        super(1);
        this.this$0 = widgetDirectoryChannel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoriesViewModel$ViewState widgetDirectoriesViewModel$ViewState) {
        invoke2(widgetDirectoriesViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetDirectoriesViewModel$ViewState widgetDirectoriesViewModel$ViewState) {
        WidgetDirectoryChannel widgetDirectoryChannel = this.this$0;
        m.checkNotNullExpressionValue(widgetDirectoriesViewModel$ViewState, "it");
        WidgetDirectoryChannel.access$configureUi(widgetDirectoryChannel, widgetDirectoriesViewModel$ViewState);
    }
}

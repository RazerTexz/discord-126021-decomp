package com.discord.widgets.channels;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCreateChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannel$type$2 extends o implements Function0<Integer> {
    public final /* synthetic */ WidgetCreateChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCreateChannel$type$2(WidgetCreateChannel widgetCreateChannel) {
        super(0);
        this.this$0 = widgetCreateChannel;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        return this.this$0.getMostRecentIntent().getIntExtra("INTENT_TYPE", 0);
    }
}

package com.discord.widgets.directories;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryChannel$adapter$2 extends o implements Function0<WidgetDirectoryChannelViewPagerAdapter> {
    public final /* synthetic */ WidgetDirectoryChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoryChannel$adapter$2(WidgetDirectoryChannel widgetDirectoryChannel) {
        super(0);
        this.this$0 = widgetDirectoryChannel;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetDirectoryChannelViewPagerAdapter invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetDirectoryChannelViewPagerAdapter invoke() {
        return new WidgetDirectoryChannelViewPagerAdapter(this.this$0);
    }
}

package com.discord.widgets.status;

import com.discord.api.channel.Channel;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadStatusViewModel$onUnarchiveTapped$1$2 extends o implements Function1<Channel, Unit> {
    public static final WidgetThreadStatusViewModel$onUnarchiveTapped$1$2 INSTANCE = new WidgetThreadStatusViewModel$onUnarchiveTapped$1$2();

    public WidgetThreadStatusViewModel$onUnarchiveTapped$1$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "it");
    }
}

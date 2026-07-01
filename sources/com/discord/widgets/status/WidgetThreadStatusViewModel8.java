package com.discord.widgets.status;

import com.discord.api.channel.Channel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.status.WidgetThreadStatusViewModel$onUnarchiveTapped$1$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadStatusViewModel8 extends Lambda implements Function1<Channel, Unit> {
    public static final WidgetThreadStatusViewModel8 INSTANCE = new WidgetThreadStatusViewModel8();

    public WidgetThreadStatusViewModel8() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "it");
    }
}

package com.discord.widgets.channels;

import android.content.Context;
import android.view.View;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSidebarActions$configureUI$7 extends o implements Function1<View, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSidebarActions$configureUI$7(Context context, long j) {
        super(1);
        this.$context = context;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetChannelPinnedMessages.Companion.show(this.$context, this.$channelId);
    }
}

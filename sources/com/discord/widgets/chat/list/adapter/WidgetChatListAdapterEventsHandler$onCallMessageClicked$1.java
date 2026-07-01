package com.discord.widgets.chat.list.adapter;

import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$Companion;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler$onCallMessageClicked$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $voiceChannelId;
    public final /* synthetic */ WidgetChatListAdapterEventsHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterEventsHandler$onCallMessageClicked$1(WidgetChatListAdapterEventsHandler widgetChatListAdapterEventsHandler, long j) {
        super(0);
        this.this$0 = widgetChatListAdapterEventsHandler;
        this.$voiceChannelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetCallFullscreen$Companion.launch$default(WidgetCallFullscreen.Companion, WidgetChatListAdapterEventsHandler.access$getContext$p(this.this$0), this.$voiceChannelId, true, null, null, 24, null);
    }
}

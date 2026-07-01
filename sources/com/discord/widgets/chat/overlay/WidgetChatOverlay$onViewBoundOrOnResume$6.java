package com.discord.widgets.chat.overlay;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatOverlay$onViewBoundOrOnResume$6 extends k implements Function1<WidgetChatOverlay$StickerAutocompleteState, Unit> {
    public WidgetChatOverlay$onViewBoundOrOnResume$6(WidgetChatOverlay widgetChatOverlay) {
        super(1, widgetChatOverlay, WidgetChatOverlay.class, "configureStickerSuggestions", "configureStickerSuggestions(Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$StickerAutocompleteState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChatOverlay$StickerAutocompleteState widgetChatOverlay$StickerAutocompleteState) {
        invoke2(widgetChatOverlay$StickerAutocompleteState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChatOverlay$StickerAutocompleteState widgetChatOverlay$StickerAutocompleteState) {
        m.checkNotNullParameter(widgetChatOverlay$StickerAutocompleteState, "p1");
        WidgetChatOverlay.access$configureStickerSuggestions((WidgetChatOverlay) this.receiver, widgetChatOverlay$StickerAutocompleteState);
    }
}

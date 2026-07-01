package com.discord.widgets.chat.list.adapter;

import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler$onStickerClicked$3 extends o implements Function1<Sticker, Unit> {
    public final /* synthetic */ WidgetChatListAdapterEventsHandler$onStickerClicked$1 $handleFullStickerClicked$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterEventsHandler$onStickerClicked$3(WidgetChatListAdapterEventsHandler$onStickerClicked$1 widgetChatListAdapterEventsHandler$onStickerClicked$1) {
        super(1);
        this.$handleFullStickerClicked$1 = widgetChatListAdapterEventsHandler$onStickerClicked$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Sticker sticker) {
        invoke2(sticker);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Sticker sticker) {
        this.$handleFullStickerClicked$1.invoke2((BaseSticker) sticker);
    }
}

package com.discord.widgets.chat.list.adapter;

import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerPartial;
import com.discord.models.message.Message;
import com.discord.widgets.stickers.WidgetGuildStickerSheet;
import com.discord.widgets.stickers.WidgetStickerSheet;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler$onStickerClicked$1 extends o implements Function1<BaseSticker, Unit> {
    public final /* synthetic */ Message $message;
    public final /* synthetic */ BaseSticker $sticker;
    public final /* synthetic */ WidgetChatListAdapterEventsHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterEventsHandler$onStickerClicked$1(WidgetChatListAdapterEventsHandler widgetChatListAdapterEventsHandler, BaseSticker baseSticker, Message message) {
        super(1);
        this.this$0 = widgetChatListAdapterEventsHandler;
        this.$sticker = baseSticker;
        this.$message = message;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BaseSticker baseSticker) {
        invoke2(baseSticker);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BaseSticker baseSticker) {
        if (baseSticker == null) {
            baseSticker = this.$sticker;
        }
        if (baseSticker instanceof StickerPartial) {
            return;
        }
        Objects.requireNonNull(baseSticker, "null cannot be cast to non-null type com.discord.api.sticker.Sticker");
        Sticker sticker = (Sticker) baseSticker;
        int iOrdinal = sticker.getType().ordinal();
        if (iOrdinal == 1) {
            WidgetStickerSheet.Companion.show(WidgetChatListAdapterEventsHandler.access$getFragmentManager$p(this.this$0), sticker, this.$message.getChannelId());
        } else {
            if (iOrdinal != 2) {
                return;
            }
            WidgetGuildStickerSheet.Companion.show(WidgetChatListAdapterEventsHandler.access$getFragmentManager$p(this.this$0), sticker);
        }
    }
}

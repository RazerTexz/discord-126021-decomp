package com.discord.widgets.chat.list.adapter;

import androidx.fragment.app.FragmentManager;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.StickerPartial;
import com.discord.utilities.error.Error;
import com.discord.widgets.stickers.WidgetUnknownStickerSheet;
import com.discord.widgets.stickers.WidgetUnknownStickerSheet$Companion;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler$onStickerClicked$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ BaseSticker $sticker;
    public final /* synthetic */ WidgetChatListAdapterEventsHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterEventsHandler$onStickerClicked$2(WidgetChatListAdapterEventsHandler widgetChatListAdapterEventsHandler, BaseSticker baseSticker) {
        super(1);
        this.this$0 = widgetChatListAdapterEventsHandler;
        this.$sticker = baseSticker;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        WidgetUnknownStickerSheet$Companion widgetUnknownStickerSheet$Companion = WidgetUnknownStickerSheet.Companion;
        FragmentManager fragmentManagerAccess$getFragmentManager$p = WidgetChatListAdapterEventsHandler.access$getFragmentManager$p(this.this$0);
        BaseSticker baseSticker = this.$sticker;
        Objects.requireNonNull(baseSticker, "null cannot be cast to non-null type com.discord.api.sticker.StickerPartial");
        widgetUnknownStickerSheet$Companion.show(fragmentManagerAccess$getFragmentManager$p, (StickerPartial) baseSticker);
    }
}

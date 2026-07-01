package com.discord.widgets.chat.list.adapter;

import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StickerEntry;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSticker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSticker$onConfigure$1 extends o implements Function1<Sticker, Unit> {
    public final /* synthetic */ ChatListEntry $data;
    public final /* synthetic */ StickerEntry $stickerEntry;
    public final /* synthetic */ WidgetChatListAdapterItemSticker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSticker$onConfigure$1(WidgetChatListAdapterItemSticker widgetChatListAdapterItemSticker, StickerEntry stickerEntry, ChatListEntry chatListEntry) {
        super(1);
        this.this$0 = widgetChatListAdapterItemSticker;
        this.$stickerEntry = stickerEntry;
        this.$data = chatListEntry;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Sticker sticker) {
        invoke2(sticker);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Sticker sticker) {
        BaseSticker sticker2 = sticker;
        if (sticker == null) {
            sticker2 = this.$stickerEntry.getSticker();
        }
        StickerView.e(WidgetChatListAdapterItemSticker.access$getBinding$p(this.this$0).f2334b, sticker2, null, 2);
        WidgetChatListAdapterItemSticker.access$getBinding$p(this.this$0).f2334b.setOnClickListener(new WidgetChatListAdapterItemSticker$onConfigure$1$1(this, sticker2));
    }
}

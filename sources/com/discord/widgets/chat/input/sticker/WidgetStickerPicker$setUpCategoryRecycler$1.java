package com.discord.widgets.chat.input.sticker;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStickerPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStickerPicker$setUpCategoryRecycler$1 extends k implements Function1<StickerCategoryItem$GuildItem, Unit> {
    public WidgetStickerPicker$setUpCategoryRecycler$1(WidgetStickerPicker widgetStickerPicker) {
        super(1, widgetStickerPicker, WidgetStickerPicker.class, "onGuildClicked", "onGuildClicked(Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem$GuildItem;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StickerCategoryItem$GuildItem stickerCategoryItem$GuildItem) {
        invoke2(stickerCategoryItem$GuildItem);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StickerCategoryItem$GuildItem stickerCategoryItem$GuildItem) {
        m.checkNotNullParameter(stickerCategoryItem$GuildItem, "p1");
        WidgetStickerPicker.access$onGuildClicked((WidgetStickerPicker) this.receiver, stickerCategoryItem$GuildItem);
    }
}

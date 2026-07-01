package com.discord.widgets.chat.input.sticker;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStickerPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStickerPicker$setUpCategoryRecycler$2 extends k implements Function1<StickerCategoryItem$PackItem, Unit> {
    public WidgetStickerPicker$setUpCategoryRecycler$2(WidgetStickerPicker widgetStickerPicker) {
        super(1, widgetStickerPicker, WidgetStickerPicker.class, "onPackClicked", "onPackClicked(Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem$PackItem;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StickerCategoryItem$PackItem stickerCategoryItem$PackItem) {
        invoke2(stickerCategoryItem$PackItem);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StickerCategoryItem$PackItem stickerCategoryItem$PackItem) {
        m.checkNotNullParameter(stickerCategoryItem$PackItem, "p1");
        WidgetStickerPicker.access$onPackClicked((WidgetStickerPicker) this.receiver, stickerCategoryItem$PackItem);
    }
}

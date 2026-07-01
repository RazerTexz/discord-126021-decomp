package com.discord.widgets.stickers;

import com.discord.stores.StoreStickers$StickerPackState;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStickerPackDetailsDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetStickerPackDetailsDialog$onViewBoundOrOnResume$1 extends o implements Function1<StoreStickers$StickerPackState, Unit> {
    public final /* synthetic */ WidgetStickerPackDetailsDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStickerPackDetailsDialog$onViewBoundOrOnResume$1(WidgetStickerPackDetailsDialog widgetStickerPackDetailsDialog) {
        super(1);
        this.this$0 = widgetStickerPackDetailsDialog;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreStickers$StickerPackState storeStickers$StickerPackState) {
        invoke2(storeStickers$StickerPackState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreStickers$StickerPackState storeStickers$StickerPackState) {
        m.checkNotNullParameter(storeStickers$StickerPackState, "it");
        WidgetStickerPackDetailsDialog.access$configureUI(this.this$0, storeStickers$StickerPackState);
    }
}

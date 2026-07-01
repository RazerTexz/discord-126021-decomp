package com.discord.widgets.emoji;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EmojiSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiSheetViewModel$1 extends o implements Function1<EmojiSheetViewModel$StoreState, Unit> {
    public final /* synthetic */ EmojiSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiSheetViewModel$1(EmojiSheetViewModel emojiSheetViewModel) {
        super(1);
        this.this$0 = emojiSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(EmojiSheetViewModel$StoreState emojiSheetViewModel$StoreState) {
        invoke2(emojiSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(EmojiSheetViewModel$StoreState emojiSheetViewModel$StoreState) {
        EmojiSheetViewModel emojiSheetViewModel = this.this$0;
        m.checkNotNullExpressionValue(emojiSheetViewModel$StoreState, "it");
        EmojiSheetViewModel.access$handleStoreState(emojiSheetViewModel, emojiSheetViewModel$StoreState);
    }
}

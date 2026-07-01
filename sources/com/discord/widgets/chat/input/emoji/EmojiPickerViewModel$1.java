package com.discord.widgets.chat.input.emoji;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiPickerViewModel$1 extends o implements Function1<EmojiPickerViewModel$StoreState, Unit> {
    public final /* synthetic */ EmojiPickerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiPickerViewModel$1(EmojiPickerViewModel emojiPickerViewModel) {
        super(1);
        this.this$0 = emojiPickerViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(EmojiPickerViewModel$StoreState emojiPickerViewModel$StoreState) {
        invoke2(emojiPickerViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(EmojiPickerViewModel$StoreState emojiPickerViewModel$StoreState) {
        m.checkNotNullParameter(emojiPickerViewModel$StoreState, "storeState");
        EmojiPickerViewModel.access$handleStoreState(this.this$0, emojiPickerViewModel$StoreState);
    }
}

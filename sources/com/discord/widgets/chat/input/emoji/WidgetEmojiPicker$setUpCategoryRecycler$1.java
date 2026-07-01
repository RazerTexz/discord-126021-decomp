package com.discord.widgets.chat.input.emoji;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEmojiPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEmojiPicker$setUpCategoryRecycler$1 extends k implements Function1<EmojiCategoryItem, Unit> {
    public WidgetEmojiPicker$setUpCategoryRecycler$1(WidgetEmojiPicker widgetEmojiPicker) {
        super(1, widgetEmojiPicker, WidgetEmojiPicker.class, "onCategoryClicked", "onCategoryClicked(Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(EmojiCategoryItem emojiCategoryItem) {
        invoke2(emojiCategoryItem);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(EmojiCategoryItem emojiCategoryItem) {
        m.checkNotNullParameter(emojiCategoryItem, "p1");
        WidgetEmojiPicker.access$onCategoryClicked((WidgetEmojiPicker) this.receiver, emojiCategoryItem);
    }
}

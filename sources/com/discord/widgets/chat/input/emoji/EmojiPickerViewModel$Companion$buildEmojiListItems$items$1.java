package com.discord.widgets.chat.input.emoji;

import com.discord.models.domain.emoji.Emoji;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiPickerViewModel$Companion$buildEmojiListItems$items$1 extends o implements Function1<Emoji, Boolean> {
    public final /* synthetic */ boolean $includeUnavailable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiPickerViewModel$Companion$buildEmojiListItems$items$1(boolean z2) {
        super(1);
        this.$includeUnavailable = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Emoji emoji) {
        return Boolean.valueOf(invoke2(emoji));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Emoji emoji) {
        m.checkNotNullParameter(emoji, "emoji");
        if (this.$includeUnavailable) {
            return true;
        }
        return emoji.isAvailable();
    }
}

package com.discord.stores;

import com.discord.models.domain.emoji.ModelEmojiUnicode;
import d0.g0.t;
import d0.g0.w;
import d0.z.d.m;
import d0.z.d.o;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreEmoji.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmoji$handleLoadedUnicodeEmojis$1 extends o implements Function1<ModelEmojiUnicode, Unit> {
    public final /* synthetic */ HashMap $unicodeEmojiSurrogateMap;
    public final /* synthetic */ HashMap $unicodeEmojisNamesMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreEmoji$handleLoadedUnicodeEmojis$1(HashMap map, HashMap map2) {
        super(1);
        this.$unicodeEmojiSurrogateMap = map;
        this.$unicodeEmojisNamesMap = map2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelEmojiUnicode modelEmojiUnicode) {
        invoke2(modelEmojiUnicode);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelEmojiUnicode modelEmojiUnicode) {
        m.checkNotNullParameter(modelEmojiUnicode, "emoji");
        HashMap map = this.$unicodeEmojiSurrogateMap;
        String surrogates = modelEmojiUnicode.getSurrogates();
        m.checkNotNullExpressionValue(surrogates, "emoji.surrogates");
        map.put(surrogates, modelEmojiUnicode);
        List<String> names = modelEmojiUnicode.getNames();
        m.checkNotNullExpressionValue(names, "emoji\n          .names");
        for (String str : names) {
            HashMap map2 = this.$unicodeEmojisNamesMap;
            m.checkNotNullExpressionValue(str, "emojiName");
            map2.put(str, modelEmojiUnicode);
        }
        String surrogates2 = modelEmojiUnicode.getSurrogates();
        m.checkNotNullExpressionValue(surrogates2, "emoji.surrogates");
        if (w.indexOf$default((CharSequence) surrogates2, (char) 8205, 0, false, 6, (Object) null) < 0) {
            String surrogates3 = modelEmojiUnicode.getSurrogates();
            m.checkNotNullExpressionValue(surrogates3, "emoji.surrogates");
            String strReplace$default = t.replace$default(surrogates3, "️", "", false, 4, (Object) null);
            if (!m.areEqual(strReplace$default, modelEmojiUnicode.getSurrogates())) {
                this.$unicodeEmojiSurrogateMap.put(strReplace$default, modelEmojiUnicode);
            }
        }
    }
}

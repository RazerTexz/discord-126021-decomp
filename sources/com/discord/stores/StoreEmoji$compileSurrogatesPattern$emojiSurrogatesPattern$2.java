package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreEmoji.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmoji$compileSurrogatesPattern$emojiSurrogatesPattern$2 extends o implements Function1<String, CharSequence> {
    public static final StoreEmoji$compileSurrogatesPattern$emojiSurrogatesPattern$2 INSTANCE = new StoreEmoji$compileSurrogatesPattern$emojiSurrogatesPattern$2();

    public StoreEmoji$compileSurrogatesPattern$emojiSurrogatesPattern$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(String str) {
        return invoke2(str);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(String str) {
        m.checkNotNullParameter(str, "it");
        String strQuote = Pattern.quote(str);
        m.checkNotNullExpressionValue(strQuote, "Pattern.quote(it)");
        return strQuote;
    }
}

package com.discord.stores;

import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreEmoji.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmoji$compileSurrogatesPattern$emojiSurrogatesPattern$2 extends AbstractC12240o implements Function1<String, CharSequence> {
    public static final StoreEmoji$compileSurrogatesPattern$emojiSurrogatesPattern$2 INSTANCE = new StoreEmoji$compileSurrogatesPattern$emojiSurrogatesPattern$2();

    public StoreEmoji$compileSurrogatesPattern$emojiSurrogatesPattern$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(String str) {
        C12238m.checkNotNullParameter(str, "it");
        String strQuote = Pattern.quote(str);
        C12238m.checkNotNullExpressionValue(strQuote, "Pattern.quote(it)");
        return strQuote;
    }
}

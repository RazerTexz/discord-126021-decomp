package com.discord.stores;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.stores.StoreEmoji$compileSurrogatesPattern$emojiSurrogatesPattern$2, reason: use source file name */
/* JADX INFO: compiled from: StoreEmoji.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmoji2 extends Lambda implements Function1<String, CharSequence> {
    public static final StoreEmoji2 INSTANCE = new StoreEmoji2();

    public StoreEmoji2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(String str) {
        Intrinsics3.checkNotNullParameter(str, "it");
        String strQuote = Pattern.quote(str);
        Intrinsics3.checkNotNullExpressionValue(strQuote, "Pattern.quote(it)");
        return strQuote;
    }
}

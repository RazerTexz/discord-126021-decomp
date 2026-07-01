package com.discord.utilities.textprocessing;

import android.content.Context;
import android.text.style.CharacterStyle;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChangelogSpans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChangelogSpans$createHeaderStyleSpanProvider$1 extends o implements Function1<Integer, CharacterStyle> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangelogSpans$createHeaderStyleSpanProvider$1(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharacterStyle invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final CharacterStyle invoke(int i) {
        if (i != 1) {
            return i != 4 ? new StyleSpan(3) : new TextAppearanceSpan(this.$context, 2131952040);
        }
        return new TextAppearanceSpan(this.$context, 2131952035);
    }
}

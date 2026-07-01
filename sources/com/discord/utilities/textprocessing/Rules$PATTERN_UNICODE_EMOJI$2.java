package com.discord.utilities.textprocessing;

import b.d.b.a.outline;
import d0.z.d.Lambda;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Rules$PATTERN_UNICODE_EMOJI$2 extends Lambda implements Function0<Pattern> {
    public static final Rules$PATTERN_UNICODE_EMOJI$2 INSTANCE = new Rules$PATTERN_UNICODE_EMOJI$2();

    public Rules$PATTERN_UNICODE_EMOJI$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Pattern invoke() {
        StringBuilder sbU = outline.U("^(");
        sbU.append(Rules.access$getEmojiDataProvider$p(Rules.INSTANCE).getUnicodeEmojisPattern().pattern());
        sbU.append(')');
        return Pattern.compile(sbU.toString());
    }
}

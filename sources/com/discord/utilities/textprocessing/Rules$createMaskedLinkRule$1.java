package com.discord.utilities.textprocessing;

import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.textprocessing.node.UrlNode;
import d0.z.d.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [S, T] */
/* JADX INFO: compiled from: Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Rules$createMaskedLinkRule$1<S, T> extends Rule<T, UrlNode<T>, S> {
    public final /* synthetic */ Rules this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Rules$createMaskedLinkRule$1(Rules rules, Pattern pattern) {
        super(pattern);
        this.this$0 = rules;
    }

    private final boolean isLikelyPathologicalAttack(CharSequence source) {
        if (source.length() < 30) {
            return false;
        }
        double length = ((double) source.length()) * 0.3d;
        int length2 = source.length();
        int i = 0;
        for (int i2 = 0; i2 < length2; i2++) {
            if (Rules.access$getPATHOLOGICAL_MASKED_LINK_ATTACK_SUSPICIOUS_CHARS$p(Rules.INSTANCE).contains(Character.valueOf(source.charAt(i2)))) {
                i++;
                if (i > length) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public Matcher match(CharSequence inspectionSource, String lastCapture, S state) {
        m.checkNotNullParameter(inspectionSource, "inspectionSource");
        if (isLikelyPathologicalAttack(inspectionSource)) {
            return null;
        }
        return super.match(inspectionSource, lastCapture, state);
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super UrlNode<T>, S> parser, S state) {
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        m.checkNotNull(strGroup);
        String strGroup2 = matcher.group(2);
        m.checkNotNull(strGroup2);
        UrlNode urlNode = new UrlNode(strGroup2, strGroup);
        m.checkNotNullParameter(urlNode, "node");
        return new ParseSpec<>(urlNode, state);
    }
}

package com.discord.utilities.textprocessing;

import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.textprocessing.node.TimestampNode;
import d0.z.d.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [S, T] */
/* JADX INFO: compiled from: Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Rules$createTimestampRule$1<S, T> extends Rule<T, TimestampNode<T>, S> {
    public final /* synthetic */ Rules this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Rules$createTimestampRule$1(Rules rules, Pattern pattern) {
        super(pattern);
        this.this$0 = rules;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super TimestampNode<T>, S> parser, S state) {
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        m.checkNotNull(strGroup);
        TimestampNode timestampNode = new TimestampNode(strGroup, matcher.group(2));
        m.checkNotNullParameter(timestampNode, "node");
        return new ParseSpec<>(timestampNode, state);
    }
}

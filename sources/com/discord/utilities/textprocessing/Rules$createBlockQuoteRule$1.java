package com.discord.utilities.textprocessing;

import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule$BlockRule;
import com.discord.utilities.textprocessing.node.BlockQuoteNode;
import d0.z.d.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [S, T] */
/* JADX INFO: compiled from: Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Rules$createBlockQuoteRule$1<S, T> extends Rule$BlockRule<T, BlockQuoteNode<T>, S> {
    public final /* synthetic */ Rules this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Rules$createBlockQuoteRule$1(Rules rules, Pattern pattern) {
        super(pattern);
        this.this$0 = rules;
    }

    @Override // com.discord.simpleast.core.parser.Rule$BlockRule, com.discord.simpleast.core.parser.Rule
    public /* bridge */ /* synthetic */ Matcher match(CharSequence charSequence, String str, Object obj) {
        return match(charSequence, str, (Rules$BlockQuoteState) obj);
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public /* bridge */ /* synthetic */ ParseSpec parse(Matcher matcher, Parser parser, Object obj) {
        return parse(matcher, parser, (Rules$BlockQuoteState) obj);
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/CharSequence;Ljava/lang/String;TS;)Ljava/util/regex/Matcher; */
    /* JADX WARN: Multi-variable type inference failed */
    public Matcher match(CharSequence inspectionSource, String lastCapture, Rules$BlockQuoteState state) {
        m.checkNotNullParameter(inspectionSource, "inspectionSource");
        m.checkNotNullParameter(state, "state");
        if (state.getIsInQuote()) {
            return null;
        }
        return super.match(inspectionSource, lastCapture, state);
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser<TT;-Lcom/discord/utilities/textprocessing/node/BlockQuoteNode<TT;>;TS;>;TS;)Lcom/discord/simpleast/core/parser/ParseSpec<TT;TS;>; */
    public ParseSpec parse(Matcher matcher, Parser parser, Rules$BlockQuoteState state) {
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        m.checkNotNullParameter(state, "state");
        int i = matcher.group(1) != null ? 1 : 2;
        Rules$BlockQuoteState rules$BlockQuoteStateNewBlockQuoteState = state.newBlockQuoteState(true);
        BlockQuoteNode blockQuoteNode = new BlockQuoteNode();
        int iStart = matcher.start(i);
        int iEnd = matcher.end(i);
        m.checkNotNullParameter(blockQuoteNode, "node");
        return new ParseSpec(blockQuoteNode, rules$BlockQuoteStateNewBlockQuoteState, iStart, iEnd);
    }
}

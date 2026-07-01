package com.discord.utilities.search.query.parsing;

import android.content.Context;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.HasNode;
import com.discord.utilities.search.strings.SearchStringProvider;
import d0.z.d.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: QueryParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class QueryParser$Companion$getHasAnswerRule$1 extends Rule<Context, QueryNode, Object> {
    public final /* synthetic */ Pattern $hasAnswerPattern;
    public final /* synthetic */ SearchStringProvider $searchStringProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryParser$Companion$getHasAnswerRule$1(SearchStringProvider searchStringProvider, Pattern pattern, Pattern pattern2) {
        super(pattern2);
        this.$searchStringProvider = searchStringProvider;
        this.$hasAnswerPattern = pattern;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        m.checkNotNull(strGroup);
        HasNode hasNode = new HasNode(strGroup, this.$searchStringProvider);
        m.checkNotNullParameter(hasNode, "node");
        return new ParseSpec<>(hasNode, state);
    }
}

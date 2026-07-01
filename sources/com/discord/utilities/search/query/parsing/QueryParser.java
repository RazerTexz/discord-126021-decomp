package com.discord.utilities.search.query.parsing;

import android.content.Context;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.strings.SearchStringProvider;
import d0.z.d.m;

/* JADX INFO: compiled from: QueryParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class QueryParser extends Parser<Context, QueryNode, Object> {
    private static final String ANY_TOKEN_REGEX = "^[\\s]*[\\S]*[\\s]*";
    public static final QueryParser$Companion Companion = new QueryParser$Companion(null);
    private static final String IN_ANSWER_REGEX = "(?:\\s*#([^ ]+))";
    private static final String USER_REGEX = "(?:\\s*([^@#:]+)#([0-9]{4}))";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryParser(SearchStringProvider searchStringProvider) {
        super(false, 1, null);
        m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        QueryParser$Companion queryParser$Companion = Companion;
        addRule(QueryParser$Companion.access$getUserRule(queryParser$Companion)).addRule(QueryParser$Companion.access$getFromFilterRule(queryParser$Companion, searchStringProvider.getFromFilterString())).addRule(queryParser$Companion.getMentionsFilterRule(searchStringProvider.getMentionsFilterString())).addRule(queryParser$Companion.getHasFilterRule(searchStringProvider.getHasFilterString())).addRule(queryParser$Companion.getHasAnswerRule(searchStringProvider)).addRule(queryParser$Companion.getInFilterRule(searchStringProvider.getInFilterString())).addRule(queryParser$Companion.getInAnswerRule()).addRule(QueryParser$Companion.access$getContentRule(queryParser$Companion));
    }
}

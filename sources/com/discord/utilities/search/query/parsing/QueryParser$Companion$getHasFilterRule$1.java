package com.discord.utilities.search.query.parsing;

import android.content.Context;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.filter.FilterNode;
import d0.z.d.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: QueryParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class QueryParser$Companion$getHasFilterRule$1 extends Rule<Context, QueryNode, Object> {
    public final /* synthetic */ Pattern $hasFilterPattern;
    public final /* synthetic */ CharSequence $localizedHas;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryParser$Companion$getHasFilterRule$1(CharSequence charSequence, Pattern pattern, Pattern pattern2) {
        super(pattern2);
        this.$localizedHas = charSequence;
        this.$hasFilterPattern = pattern;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        FilterNode filterNode = new FilterNode(FilterType.HAS, this.$localizedHas);
        m.checkNotNullParameter(filterNode, "node");
        return new ParseSpec<>(filterNode, state);
    }
}

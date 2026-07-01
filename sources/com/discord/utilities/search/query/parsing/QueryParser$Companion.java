package com.discord.utilities.search.query.parsing;

import android.content.Context;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.HasAnswerOption;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: QueryParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class QueryParser$Companion {
    private QueryParser$Companion() {
    }

    public static final /* synthetic */ Rule access$getContentRule(QueryParser$Companion queryParser$Companion) {
        return queryParser$Companion.getContentRule();
    }

    public static final /* synthetic */ Rule access$getFromFilterRule(QueryParser$Companion queryParser$Companion, CharSequence charSequence) {
        return queryParser$Companion.getFromFilterRule(charSequence);
    }

    public static final /* synthetic */ Rule access$getUserRule(QueryParser$Companion queryParser$Companion) {
        return queryParser$Companion.getUserRule();
    }

    private final String createHasAnswerRegex(SearchStringProvider searchStringProvider) {
        HasAnswerOption.values();
        ArrayList arrayList = new ArrayList(7);
        HasAnswerOption[] hasAnswerOptionArrValues = HasAnswerOption.values();
        for (int i = 0; i < 7; i++) {
            arrayList.add(hasAnswerOptionArrValues[i].getLocalizedInputText(searchStringProvider));
        }
        StringBuilder sb = new StringBuilder("(?:\\s*(");
        int size = arrayList.size() - 1;
        for (int i2 = 0; i2 < size; i2++) {
            sb.append((CharSequence) arrayList.get(i2));
            sb.append('|');
        }
        sb.append((CharSequence) arrayList.get(arrayList.size() - 1));
        sb.append("))");
        String string = sb.toString();
        m.checkNotNullExpressionValue(string, "builder.toString()");
        return string;
    }

    private final Rule<Context, QueryNode, Object> getContentRule() {
        Pattern patternCompile = Pattern.compile("^[\\s]*[\\S]*[\\s]*", 64);
        m.checkNotNullExpressionValue(patternCompile, "simpleTextPattern");
        return new QueryParser$Companion$getContentRule$1(patternCompile, patternCompile);
    }

    private final Rule<Context, QueryNode, Object> getFromFilterRule(CharSequence localizedFrom) {
        Pattern patternCompile = Pattern.compile('^' + ("[\\s]*?(" + localizedFrom + "):"), 64);
        m.checkNotNullExpressionValue(patternCompile, "fromFilterPattern");
        return new QueryParser$Companion$getFromFilterRule$1(localizedFrom, patternCompile, patternCompile);
    }

    private final Rule<Context, QueryNode, Object> getUserRule() {
        Pattern patternCompile = Pattern.compile("^(?:\\s*([^@#:]+)#([0-9]{4}))", 64);
        m.checkNotNullExpressionValue(patternCompile, "fromUserPattern");
        return new QueryParser$Companion$getUserRule$1(patternCompile, patternCompile);
    }

    public final Rule<Context, QueryNode, Object> getHasAnswerRule(SearchStringProvider searchStringProvider) {
        m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        Pattern patternCompile = Pattern.compile('^' + createHasAnswerRegex(searchStringProvider), 64);
        m.checkNotNullExpressionValue(patternCompile, "hasAnswerPattern");
        return new QueryParser$Companion$getHasAnswerRule$1(searchStringProvider, patternCompile, patternCompile);
    }

    public final Rule<Context, QueryNode, Object> getHasFilterRule(CharSequence localizedHas) {
        m.checkNotNullParameter(localizedHas, "localizedHas");
        Pattern patternCompile = Pattern.compile('^' + ("^[\\s]*?" + localizedHas + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR), 64);
        m.checkNotNullExpressionValue(patternCompile, "hasFilterPattern");
        return new QueryParser$Companion$getHasFilterRule$1(localizedHas, patternCompile, patternCompile);
    }

    public final Rule<Context, QueryNode, Object> getInAnswerRule() {
        Pattern patternCompile = Pattern.compile("^(?:\\s*#([^ ]+))", 64);
        m.checkNotNullExpressionValue(patternCompile, "inAnswerPattern");
        return new QueryParser$Companion$getInAnswerRule$1(patternCompile, patternCompile);
    }

    public final Rule<Context, QueryNode, Object> getInFilterRule(CharSequence localizedIn) {
        m.checkNotNullParameter(localizedIn, "localizedIn");
        Pattern patternCompile = Pattern.compile('^' + ("^[\\s]*?" + localizedIn + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR), 64);
        m.checkNotNullExpressionValue(patternCompile, "fromUserPattern");
        return new QueryParser$Companion$getInFilterRule$1(localizedIn, patternCompile, patternCompile);
    }

    public final Rule<Context, QueryNode, Object> getMentionsFilterRule(CharSequence localizedMentions) {
        m.checkNotNullParameter(localizedMentions, "localizedMentions");
        Pattern patternCompile = Pattern.compile('^' + ("^[\\s]*?" + localizedMentions + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR), 64);
        m.checkNotNullExpressionValue(patternCompile, "mentionsFilterPattern");
        return new QueryParser$Companion$getMentionsFilterRule$1(localizedMentions, patternCompile, patternCompile);
    }

    public /* synthetic */ QueryParser$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

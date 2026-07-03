package com.discord.utilities.search.query.parsing;

import android.content.Context;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.ChannelNode;
import com.discord.utilities.search.query.node.answer.HasAnswerOption;
import com.discord.utilities.search.query.node.answer.HasNode;
import com.discord.utilities.search.query.node.answer.UserNode;
import com.discord.utilities.search.query.node.content.ContentNode;
import com.discord.utilities.search.query.node.filter.FilterNode;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: QueryParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class QueryParser extends Parser<Context, QueryNode, Object> {
    private static final String ANY_TOKEN_REGEX = "^[\\s]*[\\S]*[\\s]*";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String IN_ANSWER_REGEX = "(?:\\s*#([^ ]+))";
    private static final String USER_REGEX = "(?:\\s*([^@#:]+)#([0-9]{4}))";

    /* JADX INFO: compiled from: QueryParser.kt */
    public static final class Companion {
        private Companion() {
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
            C12238m.checkNotNullExpressionValue(string, "builder.toString()");
            return string;
        }

        private final Rule<Context, QueryNode, Object> getContentRule() {
            final Pattern patternCompile = Pattern.compile(QueryParser.ANY_TOKEN_REGEX, 64);
            C12238m.checkNotNullExpressionValue(patternCompile, "simpleTextPattern");
            return new Rule<Context, QueryNode, Object>(patternCompile) { // from class: com.discord.utilities.search.query.parsing.QueryParser$Companion$getContentRule$1
                @Override // com.discord.simpleast.core.parser.Rule
                public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
                    C12238m.checkNotNullParameter(matcher, "matcher");
                    C12238m.checkNotNullParameter(parser, "parser");
                    String strGroup = matcher.group();
                    C12238m.checkNotNullExpressionValue(strGroup, "matcher.group()");
                    int length = strGroup.length() - 1;
                    int i = 0;
                    boolean z2 = false;
                    while (i <= length) {
                        boolean z3 = C12238m.compare(strGroup.charAt(!z2 ? i : length), 32) <= 0;
                        if (z2) {
                            if (!z3) {
                                break;
                            }
                            length--;
                        } else if (z3) {
                            i++;
                        } else {
                            z2 = true;
                        }
                    }
                    ContentNode contentNode = new ContentNode(strGroup.subSequence(i, length + 1).toString());
                    C12238m.checkNotNullParameter(contentNode, "node");
                    return new ParseSpec<>(contentNode, state);
                }
            };
        }

        private final Rule<Context, QueryNode, Object> getFromFilterRule(final CharSequence localizedFrom) {
            final Pattern patternCompile = Pattern.compile('^' + ("[\\s]*?(" + localizedFrom + "):"), 64);
            C12238m.checkNotNullExpressionValue(patternCompile, "fromFilterPattern");
            return new Rule<Context, QueryNode, Object>(patternCompile) { // from class: com.discord.utilities.search.query.parsing.QueryParser$Companion$getFromFilterRule$1
                @Override // com.discord.simpleast.core.parser.Rule
                public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
                    C12238m.checkNotNullParameter(matcher, "matcher");
                    C12238m.checkNotNullParameter(parser, "parser");
                    FilterNode filterNode = new FilterNode(FilterType.FROM, localizedFrom);
                    C12238m.checkNotNullParameter(filterNode, "node");
                    return new ParseSpec<>(filterNode, state);
                }
            };
        }

        private final Rule<Context, QueryNode, Object> getUserRule() {
            final Pattern patternCompile = Pattern.compile("^(?:\\s*([^@#:]+)#([0-9]{4}))", 64);
            C12238m.checkNotNullExpressionValue(patternCompile, "fromUserPattern");
            return new Rule<Context, QueryNode, Object>(patternCompile) { // from class: com.discord.utilities.search.query.parsing.QueryParser$Companion$getUserRule$1
                @Override // com.discord.simpleast.core.parser.Rule
                public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
                    C12238m.checkNotNullParameter(matcher, "matcher");
                    C12238m.checkNotNullParameter(parser, "parser");
                    String strGroup = matcher.group(1);
                    C12238m.checkNotNull(strGroup);
                    String strGroup2 = matcher.group(2);
                    C12238m.checkNotNull(strGroup2);
                    UserNode userNode = new UserNode(strGroup, Integer.parseInt(strGroup2));
                    C12238m.checkNotNullParameter(userNode, "node");
                    return new ParseSpec<>(userNode, state);
                }
            };
        }

        public final Rule<Context, QueryNode, Object> getHasAnswerRule(final SearchStringProvider searchStringProvider) {
            C12238m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
            final Pattern patternCompile = Pattern.compile('^' + createHasAnswerRegex(searchStringProvider), 64);
            C12238m.checkNotNullExpressionValue(patternCompile, "hasAnswerPattern");
            return new Rule<Context, QueryNode, Object>(patternCompile) { // from class: com.discord.utilities.search.query.parsing.QueryParser$Companion$getHasAnswerRule$1
                @Override // com.discord.simpleast.core.parser.Rule
                public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
                    C12238m.checkNotNullParameter(matcher, "matcher");
                    C12238m.checkNotNullParameter(parser, "parser");
                    String strGroup = matcher.group(1);
                    C12238m.checkNotNull(strGroup);
                    HasNode hasNode = new HasNode(strGroup, searchStringProvider);
                    C12238m.checkNotNullParameter(hasNode, "node");
                    return new ParseSpec<>(hasNode, state);
                }
            };
        }

        public final Rule<Context, QueryNode, Object> getHasFilterRule(final CharSequence localizedHas) {
            C12238m.checkNotNullParameter(localizedHas, "localizedHas");
            final Pattern patternCompile = Pattern.compile('^' + ("^[\\s]*?" + localizedHas + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR), 64);
            C12238m.checkNotNullExpressionValue(patternCompile, "hasFilterPattern");
            return new Rule<Context, QueryNode, Object>(patternCompile) { // from class: com.discord.utilities.search.query.parsing.QueryParser$Companion$getHasFilterRule$1
                @Override // com.discord.simpleast.core.parser.Rule
                public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
                    C12238m.checkNotNullParameter(matcher, "matcher");
                    C12238m.checkNotNullParameter(parser, "parser");
                    FilterNode filterNode = new FilterNode(FilterType.HAS, localizedHas);
                    C12238m.checkNotNullParameter(filterNode, "node");
                    return new ParseSpec<>(filterNode, state);
                }
            };
        }

        public final Rule<Context, QueryNode, Object> getInAnswerRule() {
            final Pattern patternCompile = Pattern.compile("^(?:\\s*#([^ ]+))", 64);
            C12238m.checkNotNullExpressionValue(patternCompile, "inAnswerPattern");
            return new Rule<Context, QueryNode, Object>(patternCompile) { // from class: com.discord.utilities.search.query.parsing.QueryParser$Companion$getInAnswerRule$1
                @Override // com.discord.simpleast.core.parser.Rule
                public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
                    C12238m.checkNotNullParameter(matcher, "matcher");
                    C12238m.checkNotNullParameter(parser, "parser");
                    String strGroup = matcher.group(1);
                    C12238m.checkNotNull(strGroup);
                    ChannelNode channelNode = new ChannelNode(strGroup);
                    C12238m.checkNotNullParameter(channelNode, "node");
                    return new ParseSpec<>(channelNode, state);
                }
            };
        }

        public final Rule<Context, QueryNode, Object> getInFilterRule(final CharSequence localizedIn) {
            C12238m.checkNotNullParameter(localizedIn, "localizedIn");
            final Pattern patternCompile = Pattern.compile('^' + ("^[\\s]*?" + localizedIn + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR), 64);
            C12238m.checkNotNullExpressionValue(patternCompile, "fromUserPattern");
            return new Rule<Context, QueryNode, Object>(patternCompile) { // from class: com.discord.utilities.search.query.parsing.QueryParser$Companion$getInFilterRule$1
                @Override // com.discord.simpleast.core.parser.Rule
                public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
                    C12238m.checkNotNullParameter(matcher, "matcher");
                    C12238m.checkNotNullParameter(parser, "parser");
                    FilterNode filterNode = new FilterNode(FilterType.IN, localizedIn);
                    C12238m.checkNotNullParameter(filterNode, "node");
                    return new ParseSpec<>(filterNode, state);
                }
            };
        }

        public final Rule<Context, QueryNode, Object> getMentionsFilterRule(final CharSequence localizedMentions) {
            C12238m.checkNotNullParameter(localizedMentions, "localizedMentions");
            final Pattern patternCompile = Pattern.compile('^' + ("^[\\s]*?" + localizedMentions + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR), 64);
            C12238m.checkNotNullExpressionValue(patternCompile, "mentionsFilterPattern");
            return new Rule<Context, QueryNode, Object>(patternCompile) { // from class: com.discord.utilities.search.query.parsing.QueryParser$Companion$getMentionsFilterRule$1
                @Override // com.discord.simpleast.core.parser.Rule
                public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
                    C12238m.checkNotNullParameter(matcher, "matcher");
                    C12238m.checkNotNullParameter(parser, "parser");
                    FilterNode filterNode = new FilterNode(FilterType.MENTIONS, localizedMentions);
                    C12238m.checkNotNullParameter(filterNode, "node");
                    return new ParseSpec<>(filterNode, state);
                }
            };
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryParser(SearchStringProvider searchStringProvider) {
        super(false, 1, null);
        C12238m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        Companion companion = INSTANCE;
        addRule(companion.getUserRule()).addRule(companion.getFromFilterRule(searchStringProvider.getFromFilterString())).addRule(companion.getMentionsFilterRule(searchStringProvider.getMentionsFilterString())).addRule(companion.getHasFilterRule(searchStringProvider.getHasFilterString())).addRule(companion.getHasAnswerRule(searchStringProvider)).addRule(companion.getInFilterRule(searchStringProvider.getInFilterString())).addRule(companion.getInAnswerRule()).addRule(companion.getContentRule());
    }
}

package com.discord.utilities.search.query.parsing;

import android.content.Context;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.ChannelNode;
import com.discord.utilities.search.query.node.answer.HasNode;
import com.discord.utilities.search.query.node.answer.HasNode2;
import com.discord.utilities.search.query.node.answer.UserNode;
import com.discord.utilities.search.query.node.content.ContentNode;
import com.discord.utilities.search.query.node.filter.FilterNode;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.widgets.chat.input.MentionUtils;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
            HasNode2.values();
            ArrayList arrayList = new ArrayList(7);
            HasNode2[] hasNode2ArrValues = HasNode2.values();
            for (int i = 0; i < 7; i++) {
                arrayList.add(hasNode2ArrValues[i].getLocalizedInputText(searchStringProvider));
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
            Intrinsics3.checkNotNullExpressionValue(string, "builder.toString()");
            return string;
        }

        private final Rule<Context, QueryNode, Object> getContentRule() {
            final Pattern patternCompile = Pattern.compile(QueryParser.ANY_TOKEN_REGEX, 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "simpleTextPattern");
            return new Rule<Context, QueryNode, Object>(patternCompile) { // from class: com.discord.utilities.search.query.parsing.QueryParser$Companion$getContentRule$1
                @Override // com.discord.simpleast.core.parser.Rule
                public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
                    Intrinsics3.checkNotNullParameter(matcher, "matcher");
                    Intrinsics3.checkNotNullParameter(parser, "parser");
                    String strGroup = matcher.group();
                    Intrinsics3.checkNotNullExpressionValue(strGroup, "matcher.group()");
                    int length = strGroup.length() - 1;
                    int i = 0;
                    boolean z2 = false;
                    while (i <= length) {
                        boolean z3 = Intrinsics3.compare(strGroup.charAt(!z2 ? i : length), 32) <= 0;
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
                    Intrinsics3.checkNotNullParameter(contentNode, "node");
                    return new ParseSpec<>(contentNode, state);
                }
            };
        }

        private final Rule<Context, QueryNode, Object> getFromFilterRule(final CharSequence localizedFrom) {
            final Pattern patternCompile = Pattern.compile('^' + ("[\\s]*?(" + localizedFrom + "):"), 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "fromFilterPattern");
            return new Rule<Context, QueryNode, Object>(patternCompile) { // from class: com.discord.utilities.search.query.parsing.QueryParser$Companion$getFromFilterRule$1
                @Override // com.discord.simpleast.core.parser.Rule
                public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
                    Intrinsics3.checkNotNullParameter(matcher, "matcher");
                    Intrinsics3.checkNotNullParameter(parser, "parser");
                    FilterNode filterNode = new FilterNode(FilterType.FROM, localizedFrom);
                    Intrinsics3.checkNotNullParameter(filterNode, "node");
                    return new ParseSpec<>(filterNode, state);
                }
            };
        }

        private final Rule<Context, QueryNode, Object> getUserRule() {
            final Pattern patternCompile = Pattern.compile("^(?:\\s*([^@#:]+)#([0-9]{4}))", 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "fromUserPattern");
            return new Rule<Context, QueryNode, Object>(patternCompile) { // from class: com.discord.utilities.search.query.parsing.QueryParser$Companion$getUserRule$1
                @Override // com.discord.simpleast.core.parser.Rule
                public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
                    Intrinsics3.checkNotNullParameter(matcher, "matcher");
                    Intrinsics3.checkNotNullParameter(parser, "parser");
                    String strGroup = matcher.group(1);
                    Intrinsics3.checkNotNull(strGroup);
                    String strGroup2 = matcher.group(2);
                    Intrinsics3.checkNotNull(strGroup2);
                    UserNode userNode = new UserNode(strGroup, Integer.parseInt(strGroup2));
                    Intrinsics3.checkNotNullParameter(userNode, "node");
                    return new ParseSpec<>(userNode, state);
                }
            };
        }

        public final Rule<Context, QueryNode, Object> getHasAnswerRule(final SearchStringProvider searchStringProvider) {
            Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
            final Pattern patternCompile = Pattern.compile('^' + createHasAnswerRegex(searchStringProvider), 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "hasAnswerPattern");
            return new Rule<Context, QueryNode, Object>(patternCompile) { // from class: com.discord.utilities.search.query.parsing.QueryParser$Companion$getHasAnswerRule$1
                @Override // com.discord.simpleast.core.parser.Rule
                public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
                    Intrinsics3.checkNotNullParameter(matcher, "matcher");
                    Intrinsics3.checkNotNullParameter(parser, "parser");
                    String strGroup = matcher.group(1);
                    Intrinsics3.checkNotNull(strGroup);
                    HasNode hasNode = new HasNode(strGroup, searchStringProvider);
                    Intrinsics3.checkNotNullParameter(hasNode, "node");
                    return new ParseSpec<>(hasNode, state);
                }
            };
        }

        public final Rule<Context, QueryNode, Object> getHasFilterRule(final CharSequence localizedHas) {
            Intrinsics3.checkNotNullParameter(localizedHas, "localizedHas");
            final Pattern patternCompile = Pattern.compile('^' + ("^[\\s]*?" + localizedHas + MentionUtils.EMOJIS_AND_STICKERS_CHAR), 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "hasFilterPattern");
            return new Rule<Context, QueryNode, Object>(patternCompile) { // from class: com.discord.utilities.search.query.parsing.QueryParser$Companion$getHasFilterRule$1
                @Override // com.discord.simpleast.core.parser.Rule
                public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
                    Intrinsics3.checkNotNullParameter(matcher, "matcher");
                    Intrinsics3.checkNotNullParameter(parser, "parser");
                    FilterNode filterNode = new FilterNode(FilterType.HAS, localizedHas);
                    Intrinsics3.checkNotNullParameter(filterNode, "node");
                    return new ParseSpec<>(filterNode, state);
                }
            };
        }

        public final Rule<Context, QueryNode, Object> getInAnswerRule() {
            final Pattern patternCompile = Pattern.compile("^(?:\\s*#([^ ]+))", 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "inAnswerPattern");
            return new Rule<Context, QueryNode, Object>(patternCompile) { // from class: com.discord.utilities.search.query.parsing.QueryParser$Companion$getInAnswerRule$1
                @Override // com.discord.simpleast.core.parser.Rule
                public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
                    Intrinsics3.checkNotNullParameter(matcher, "matcher");
                    Intrinsics3.checkNotNullParameter(parser, "parser");
                    String strGroup = matcher.group(1);
                    Intrinsics3.checkNotNull(strGroup);
                    ChannelNode channelNode = new ChannelNode(strGroup);
                    Intrinsics3.checkNotNullParameter(channelNode, "node");
                    return new ParseSpec<>(channelNode, state);
                }
            };
        }

        public final Rule<Context, QueryNode, Object> getInFilterRule(final CharSequence localizedIn) {
            Intrinsics3.checkNotNullParameter(localizedIn, "localizedIn");
            final Pattern patternCompile = Pattern.compile('^' + ("^[\\s]*?" + localizedIn + MentionUtils.EMOJIS_AND_STICKERS_CHAR), 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "fromUserPattern");
            return new Rule<Context, QueryNode, Object>(patternCompile) { // from class: com.discord.utilities.search.query.parsing.QueryParser$Companion$getInFilterRule$1
                @Override // com.discord.simpleast.core.parser.Rule
                public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
                    Intrinsics3.checkNotNullParameter(matcher, "matcher");
                    Intrinsics3.checkNotNullParameter(parser, "parser");
                    FilterNode filterNode = new FilterNode(FilterType.IN, localizedIn);
                    Intrinsics3.checkNotNullParameter(filterNode, "node");
                    return new ParseSpec<>(filterNode, state);
                }
            };
        }

        public final Rule<Context, QueryNode, Object> getMentionsFilterRule(final CharSequence localizedMentions) {
            Intrinsics3.checkNotNullParameter(localizedMentions, "localizedMentions");
            final Pattern patternCompile = Pattern.compile('^' + ("^[\\s]*?" + localizedMentions + MentionUtils.EMOJIS_AND_STICKERS_CHAR), 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "mentionsFilterPattern");
            return new Rule<Context, QueryNode, Object>(patternCompile) { // from class: com.discord.utilities.search.query.parsing.QueryParser$Companion$getMentionsFilterRule$1
                @Override // com.discord.simpleast.core.parser.Rule
                public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
                    Intrinsics3.checkNotNullParameter(matcher, "matcher");
                    Intrinsics3.checkNotNullParameter(parser, "parser");
                    FilterNode filterNode = new FilterNode(FilterType.MENTIONS, localizedMentions);
                    Intrinsics3.checkNotNullParameter(filterNode, "node");
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
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        Companion companion = INSTANCE;
        addRule(companion.getUserRule()).addRule(companion.getFromFilterRule(searchStringProvider.getFromFilterString())).addRule(companion.getMentionsFilterRule(searchStringProvider.getMentionsFilterString())).addRule(companion.getHasFilterRule(searchStringProvider.getHasFilterString())).addRule(companion.getHasAnswerRule(searchStringProvider)).addRule(companion.getInFilterRule(searchStringProvider.getInFilterString())).addRule(companion.getInAnswerRule()).addRule(companion.getContentRule());
    }
}

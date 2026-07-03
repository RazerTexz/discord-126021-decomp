package com.discord.utilities.textprocessing;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import androidx.annotation.ColorInt;
import androidx.exifinterface.media.ExifInterface;
import com.discord.C5419R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.simpleast.code.CodeNode;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import com.discord.utilities.textprocessing.node.BlockBackgroundNode;
import com.discord.utilities.textprocessing.node.BlockQuoteNode;
import com.discord.utilities.textprocessing.node.BulletListNode;
import com.discord.utilities.textprocessing.node.ChannelMentionNode;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.textprocessing.node.HeaderNode;
import com.discord.utilities.textprocessing.node.RoleMentionNode;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.textprocessing.node.TimestampNode;
import com.discord.utilities.textprocessing.node.UrlNode;
import com.discord.utilities.textprocessing.node.UserMentionNode;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import p007b.p008a.p050t.p051a.C1275a;
import p007b.p008a.p050t.p051a.C1277c;
import p007b.p008a.p050t.p051a.C1279e;
import p007b.p008a.p050t.p051a.C1280f;
import p007b.p008a.p050t.p051a.C1282h;
import p007b.p008a.p050t.p051a.C1283i;
import p007b.p008a.p050t.p051a.C1284j;
import p007b.p008a.p050t.p051a.C1285k;
import p007b.p008a.p050t.p051a.C1286l;
import p007b.p008a.p050t.p051a.C1287m;
import p007b.p008a.p050t.p051a.C1288n;
import p007b.p008a.p050t.p051a.C1289o;
import p007b.p008a.p050t.p051a.C1290p;
import p007b.p008a.p050t.p051a.C1291q;
import p007b.p008a.p050t.p051a.C1292r;
import p007b.p008a.p050t.p051a.C1293s;
import p007b.p008a.p050t.p051a.C1294t;
import p007b.p008a.p050t.p051a.C1295u;
import p007b.p008a.p050t.p051a.C1296v;
import p007b.p008a.p050t.p051a.C1297w;
import p007b.p008a.p050t.p052b.p053a.C1298a;
import p007b.p008a.p050t.p052b.p054b.C1303e;
import p007b.p008a.p050t.p056c.C1308a;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p579g0.C12102s;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Rules {
    private static final Pattern PATTERN_HEADER_ITEM;
    public static final String REGEX_CUSTOM_EMOJI = "<(a)?:([a-zA-Z_0-9]+):(\\d+)>";
    private static final String REGEX_LINK_HREF_AND_TITLE = "\\s*<?((?:[^\\s\\\\]|\\\\.)*?)>?(?:\\s+['\"]([\\s\\S]*?)['\"])?\\s*";
    private static final String REGEX_LINK_INSIDE = "(?:\\[[^]]*]|[^]]|](?=[^\\[]*]))*";
    private static final String REGEX_URL = "(https?://[^\\s<]+[^<.,:;\"')\\]\\s])";
    private static EmojiDataProvider emojiDataProvider;
    public static final Rules INSTANCE = new Rules();
    private static final Pattern PATTERN_BLOCK_QUOTE = Pattern.compile("^(?: *>>> +(.*)| *>(?!>>) +([^\\n]*\\n?))", 32);
    private static final Pattern PATTERN_CHANNEL_MENTION = Pattern.compile("^<#(\\d+)>");
    private static final Pattern PATTERN_ROLE_MENTION = Pattern.compile("^<@&(\\d+)>");
    private static final Pattern PATTERN_MENTION = Pattern.compile("^<@!?(\\d+)>|^@(everyone|here)");

    /* JADX INFO: renamed from: PATTERN_UNICODE_EMOJI$delegate, reason: from kotlin metadata */
    private static final Lazy PATTERN_UNICODE_EMOJI = C12083g.lazy(Rules$PATTERN_UNICODE_EMOJI$2.INSTANCE);
    private static final Pattern PATTERN_CUSTOM_EMOJI = Pattern.compile("^<(a)?:([a-zA-Z_0-9]+):(\\d+)>");
    private static final Pattern PATTERN_NAMED_EMOJI = Pattern.compile("^:([^\\s:]+?(?:::skin-tone-\\d)?):");
    private static final Pattern PATTERN_UNESCAPE_EMOTICON = Pattern.compile("^(¯\\\\_\\(ツ\\)_/¯)");
    private static final Pattern PATTERN_TIMESTAMP = Pattern.compile("^<t:(-?\\d{1,17})(?::(t|T|d|D|f|F|R))?>");
    private static final Pattern PATTERN_URL = Pattern.compile("^(https?://[^\\s<]+[^<.,:;\"')\\]\\s])");
    private static final String LINK = "^\\[((?:\\[[^]]*]|[^]]|](?=[^\\[]*]))*)]\\(\\s*<?((?:[^\\s\\\\]|\\\\.)*?)>?(?:\\s+['\"]([\\s\\S]*?)['\"])?\\s*\\)";
    private static final Pattern PATTERN_MASKED_LINK = Pattern.compile(LINK);
    private static final Set<Character> PATHOLOGICAL_MASKED_LINK_ATTACK_SUSPICIOUS_CHARS = C12148n0.setOf((Object[]) new Character[]{'[', ']'});
    private static final Pattern PATTERN_URL_NO_EMBED = Pattern.compile("^<(https?://[^\\s<]+[^<.,:;\"')\\]\\s])>");
    private static final Pattern PATTERN_SOFT_HYPHEN = Pattern.compile("^\\u00AD");
    private static final Pattern PATTERN_SPOILER = Pattern.compile("^\\|\\|([\\s\\S]+?)\\|\\|");
    private static final String HOOKED_LINK = "^\\$\\[((?:\\[[^]]*]|[^]]|](?=[^\\[]*]))*)?]\\(\\s*<?((?:[^\\s\\\\]|\\\\.)*?)>?(?:\\s+['\"]([\\s\\S]*?)['\"])?\\s*\\)";
    private static final Pattern PATTERN_HOOKED_LINK = Pattern.compile(HOOKED_LINK);
    private static final Pattern PATTERN_LIST_ITEM = Pattern.compile("^([^\\S\\r\\n]*)[*-][ \\s]?(.*)([\\n|$])?");

    /* JADX INFO: compiled from: Rules.kt */
    public interface BlockQuoteState<Self extends BlockQuoteState<Self>> {
        /* JADX INFO: renamed from: isInQuote */
        boolean getIsInQuote();

        Self newBlockQuoteState(boolean isInQuote);
    }

    /* JADX INFO: compiled from: Rules.kt */
    public interface EmojiDataProvider {
        Map<String, ModelEmojiUnicode> getUnicodeEmojiSurrogateMap();

        Map<String, ModelEmojiUnicode> getUnicodeEmojisNamesMap();

        Pattern getUnicodeEmojisPattern();
    }

    /* JADX INFO: compiled from: Rules.kt */
    public static final class HeaderLineClassedRule<RC, T, S> extends C1308a.a<RC, Object, S> {
        private final Function0<List<Object>> headerPaddingSpanProvider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public HeaderLineClassedRule(Function0<? extends List<? extends Object>> function0, Function1<? super Integer, ? extends CharacterStyle> function1, Function1<? super String, ? extends T> function2) {
            super(function1, function2);
            C12238m.checkNotNullParameter(function0, "headerPaddingSpanProvider");
            C12238m.checkNotNullParameter(function1, "styleSpanProvider");
            C12238m.checkNotNullParameter(function2, "classSpanProvider");
            this.headerPaddingSpanProvider = function0;
        }

        @Override // p007b.p008a.p050t.p056c.C1308a.a, p007b.p008a.p050t.p056c.C1308a.b, p007b.p008a.p050t.p056c.C1308a.c, com.discord.simpleast.core.parser.Rule
        public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S state) {
            C12238m.checkNotNullParameter(matcher, "matcher");
            C12238m.checkNotNullParameter(parser, "parser");
            Node<RC> node = super.parse(matcher, parser, state).root;
            StyleNode styleNode = new StyleNode(this.headerPaddingSpanProvider.invoke());
            styleNode.addChild(node);
            C12238m.checkNotNullParameter(styleNode, "node");
            return new ParseSpec<>(styleNode, state);
        }
    }

    /* JADX INFO: compiled from: Rules.kt */
    public static final class MarkdownListItemRule<RC, S> extends Rule.BlockRule<RC, Node<RC>, S> {
        private final Function0<List<Object>> spansProvider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public MarkdownListItemRule(Function0<? extends List<? extends Object>> function0) {
            super(C1308a.f1992a);
            C12238m.checkNotNullParameter(function0, "spansProvider");
            C1308a c1308a = C1308a.f1996e;
            this.spansProvider = function0;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S state) {
            C12238m.checkNotNullParameter(matcher, "matcher");
            C12238m.checkNotNullParameter(parser, "parser");
            StyleNode styleNode = new StyleNode(this.spansProvider.invoke());
            int iStart = matcher.start(1);
            int iEnd = matcher.end(1);
            C12238m.checkNotNullParameter(styleNode, "node");
            return new ParseSpec<>(styleNode, state, iStart, iEnd);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.textprocessing.Rules$createBoldColoredRule$1 */
    /* JADX INFO: compiled from: Rules.kt */
    public static final class C69531 extends AbstractC12240o implements Function0<List<? extends CharacterStyle>> {
        public final /* synthetic */ int $color;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69531(int i) {
            super(0);
            this.$color = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends CharacterStyle> invoke() {
            return C12147n.listOf((Object[]) new CharacterStyle[]{new ForegroundColorSpan(this.$color), new StyleSpan(1)});
        }
    }

    /* JADX INFO: Add missing generic type declarations: [RC, S] */
    /* JADX INFO: renamed from: com.discord.utilities.textprocessing.Rules$createCodeBlockRule$1 */
    /* JADX INFO: compiled from: Rules.kt */
    public static final class C69551<RC, S> extends AbstractC12240o implements Function3<CodeNode<RC>, Boolean, S, Node<RC>> {
        public static final C69551 INSTANCE = new C69551();

        public C69551() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Boolean bool, Object obj2) {
            return invoke((CodeNode) obj, bool.booleanValue(), (BlockQuoteState) obj2);
        }

        /* JADX WARN: Incorrect types in method signature: (Lcom/discord/simpleast/code/CodeNode<TRC;>;ZTS;)Lcom/discord/simpleast/core/node/Node<TRC;>; */
        public final Node invoke(final CodeNode codeNode, boolean z2, BlockQuoteState blockQuoteState) {
            C12238m.checkNotNullParameter(codeNode, "codeNode");
            C12238m.checkNotNullParameter(blockQuoteState, "state");
            return !z2 ? new Node.C5655a<RC>(new Node[]{codeNode}) { // from class: com.discord.utilities.textprocessing.Rules.createCodeBlockRule.1.1
                /* JADX WARN: Incorrect types in method signature: (Landroid/text/SpannableStringBuilder;TRC;)V */
                @Override // com.discord.simpleast.core.node.Node.C5655a, com.discord.simpleast.core.node.Node
                public void render(SpannableStringBuilder builder, BasicRenderContext renderContext) {
                    C12238m.checkNotNullParameter(builder, "builder");
                    C12238m.checkNotNullParameter(renderContext, "renderContext");
                    int length = builder.length();
                    super.render(builder, renderContext);
                    builder.setSpan(new BackgroundColorSpan(ColorCompat.getThemedColor(renderContext.getContext(), C5419R.attr.theme_chat_code)), length, builder.length(), 33);
                }
            } : new BlockBackgroundNode(blockQuoteState.getIsInQuote(), codeNode);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.textprocessing.Rules$createStrikethroughColoredRule$1 */
    /* JADX INFO: compiled from: Rules.kt */
    public static final class C69671 extends AbstractC12240o implements Function0<List<? extends CharacterStyle>> {
        public final /* synthetic */ int $color;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69671(int i) {
            super(0);
            this.$color = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends CharacterStyle> invoke() {
            return C12147n.listOf((Object[]) new CharacterStyle[]{new ForegroundColorSpan(this.$color), new StrikethroughSpan()});
        }
    }

    static {
        C1308a c1308a = C1308a.f1996e;
        PATTERN_HEADER_ITEM = C1308a.f1993b;
    }

    private Rules() {
    }

    public static final /* synthetic */ EmojiDataProvider access$getEmojiDataProvider$p(Rules rules) {
        EmojiDataProvider emojiDataProvider2 = emojiDataProvider;
        if (emojiDataProvider2 == null) {
            C12238m.throwUninitializedPropertyAccessException("emojiDataProvider");
        }
        return emojiDataProvider2;
    }

    public static final /* synthetic */ Set access$getPATHOLOGICAL_MASKED_LINK_ATTACK_SUSPICIOUS_CHARS$p(Rules rules) {
        return PATHOLOGICAL_MASKED_LINK_ATTACK_SUSPICIOUS_CHARS;
    }

    private final Pattern getPATTERN_UNICODE_EMOJI() {
        return (Pattern) PATTERN_UNICODE_EMOJI.getValue();
    }

    private final String replaceEmojiSurrogates(String originalText) {
        StringBuffer stringBuffer = new StringBuffer();
        EmojiDataProvider emojiDataProvider2 = emojiDataProvider;
        if (emojiDataProvider2 == null) {
            C12238m.throwUninitializedPropertyAccessException("emojiDataProvider");
        }
        Matcher matcher = emojiDataProvider2.getUnicodeEmojisPattern().matcher(originalText);
        while (matcher.find()) {
            String strGroup = matcher.group();
            EmojiDataProvider emojiDataProvider3 = emojiDataProvider;
            if (emojiDataProvider3 == null) {
                C12238m.throwUninitializedPropertyAccessException("emojiDataProvider");
            }
            ModelEmojiUnicode modelEmojiUnicode = emojiDataProvider3.getUnicodeEmojiSurrogateMap().get(strGroup);
            if (modelEmojiUnicode != null) {
                StringBuilder sbM833U = C1643a.m833U(":");
                sbM833U.append(modelEmojiUnicode.getFirstName());
                sbM833U.append(":");
                matcher.appendReplacement(stringBuffer, sbM833U.toString());
            }
        }
        matcher.appendTail(stringBuffer);
        String string = stringBuffer.toString();
        C12238m.checkNotNullExpressionValue(string, "stringBuffer.toString()");
        return string;
    }

    public static final void setEmojiDataProvider(EmojiDataProvider emojiDataProvider2) {
        C12238m.checkNotNullParameter(emojiDataProvider2, "emojiDataProvider");
        emojiDataProvider = emojiDataProvider2;
    }

    private final long toLongOrDefault(String str, long j) {
        Long longOrNull;
        return (str == null || (longOrNull = C12102s.toLongOrNull(str)) == null) ? j : longOrNull.longValue();
    }

    public static /* synthetic */ long toLongOrDefault$default(Rules rules, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = -1;
        }
        return rules.toLongOrDefault(str, j);
    }

    public final <T extends BasicRenderContext, S extends BlockQuoteState<S>> Rule.BlockRule<T, BlockQuoteNode<T>, S> createBlockQuoteRule() {
        Pattern pattern = PATTERN_BLOCK_QUOTE;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_BLOCK_QUOTE");
        return (Rule.BlockRule<T, BlockQuoteNode<T>, S>) new Rule.BlockRule<T, BlockQuoteNode<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.Rules.createBlockQuoteRule.1
            /* JADX WARN: Incorrect types in method signature: (Ljava/lang/CharSequence;Ljava/lang/String;TS;)Ljava/util/regex/Matcher; */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.discord.simpleast.core.parser.Rule.BlockRule, com.discord.simpleast.core.parser.Rule
            public Matcher match(CharSequence inspectionSource, String lastCapture, BlockQuoteState state) {
                C12238m.checkNotNullParameter(inspectionSource, "inspectionSource");
                C12238m.checkNotNullParameter(state, "state");
                if (state.getIsInQuote()) {
                    return null;
                }
                return super.match(inspectionSource, lastCapture, state);
            }

            /* JADX WARN: Incorrect types in method signature: (Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser<TT;-Lcom/discord/utilities/textprocessing/node/BlockQuoteNode<TT;>;TS;>;TS;)Lcom/discord/simpleast/core/parser/ParseSpec<TT;TS;>; */
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec parse(Matcher matcher, Parser parser, BlockQuoteState state) {
                C12238m.checkNotNullParameter(matcher, "matcher");
                C12238m.checkNotNullParameter(parser, "parser");
                C12238m.checkNotNullParameter(state, "state");
                int i = matcher.group(1) != null ? 1 : 2;
                BlockQuoteState blockQuoteStateNewBlockQuoteState = state.newBlockQuoteState(true);
                BlockQuoteNode blockQuoteNode = new BlockQuoteNode();
                int iStart = matcher.start(i);
                int iEnd = matcher.end(i);
                C12238m.checkNotNullParameter(blockQuoteNode, "node");
                return new ParseSpec(blockQuoteNode, blockQuoteStateNewBlockQuoteState, iStart, iEnd);
            }
        };
    }

    public final <T, S> Rule<T, Node<T>, S> createBoldColoredRule(@ColorInt int color) {
        C1303e c1303e = C1303e.f1988h;
        Pattern pattern = C1303e.f1981a;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_BOLD");
        return C1303e.m373c(pattern, new C69531(color));
    }

    public final <T extends ChannelMentionNode.RenderContext, S> Rule<T, ChannelMentionNode<T>, S> createChannelMentionRule() {
        Pattern pattern = PATTERN_CHANNEL_MENTION;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_CHANNEL_MENTION");
        return (Rule<T, ChannelMentionNode<T>, S>) new Rule<T, ChannelMentionNode<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.Rules.createChannelMentionRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super ChannelMentionNode<T>, S> parser, S state) {
                C12238m.checkNotNullParameter(matcher, "matcher");
                C12238m.checkNotNullParameter(parser, "parser");
                ChannelMentionNode channelMentionNode = new ChannelMentionNode(Rules.toLongOrDefault$default(Rules.INSTANCE, matcher.group(1), 0L, 1, null));
                C12238m.checkNotNullParameter(channelMentionNode, "node");
                return new ParseSpec<>(channelMentionNode, state);
            }
        };
    }

    public final <RC extends BasicRenderContext, S extends BlockQuoteState<S>> Rule<RC, Node<RC>, S> createCodeBlockRule() {
        C1280f c1280f = new C1280f(new StyleNode.InterfaceC5656a<RC>() { // from class: com.discord.utilities.textprocessing.Rules$createCodeBlockRule$codeStyleProviders$1
            /* JADX WARN: Incorrect types in method signature: (TRC;)Ljava/lang/Iterable<*>; */
            @Override // com.discord.simpleast.core.node.StyleNode.InterfaceC5656a
            public final Iterable get(BasicRenderContext basicRenderContext) {
                C12238m.checkNotNullParameter(basicRenderContext, "it");
                return C12147n.listOf(new TextAppearanceSpan(basicRenderContext.getContext(), C5419R.style.Code_TextAppearance), new RelativeSizeSpan(0.85f));
            }
        }, new StyleNode.InterfaceC5656a<RC>() { // from class: com.discord.utilities.textprocessing.Rules$createCodeBlockRule$codeStyleProviders$2
            /* JADX WARN: Incorrect types in method signature: (TRC;)Ljava/lang/Iterable<*>; */
            @Override // com.discord.simpleast.core.node.StyleNode.InterfaceC5656a
            public final Iterable get(BasicRenderContext basicRenderContext) {
                C12238m.checkNotNullParameter(basicRenderContext, "it");
                return C12145m.listOf(new TextAppearanceSpan(basicRenderContext.getContext(), C5419R.style.Code_TextAppearance_Comment));
            }
        }, new StyleNode.InterfaceC5656a<RC>() { // from class: com.discord.utilities.textprocessing.Rules$createCodeBlockRule$codeStyleProviders$3
            /* JADX WARN: Incorrect types in method signature: (TRC;)Ljava/lang/Iterable<*>; */
            @Override // com.discord.simpleast.core.node.StyleNode.InterfaceC5656a
            public final Iterable get(BasicRenderContext basicRenderContext) {
                C12238m.checkNotNullParameter(basicRenderContext, "it");
                return C12145m.listOf(new TextAppearanceSpan(basicRenderContext.getContext(), C5419R.style.Code_TextAppearance_Literal));
            }
        }, new StyleNode.InterfaceC5656a<RC>() { // from class: com.discord.utilities.textprocessing.Rules$createCodeBlockRule$codeStyleProviders$4
            /* JADX WARN: Incorrect types in method signature: (TRC;)Ljava/lang/Iterable<*>; */
            @Override // com.discord.simpleast.core.node.StyleNode.InterfaceC5656a
            public final Iterable get(BasicRenderContext basicRenderContext) {
                C12238m.checkNotNullParameter(basicRenderContext, "it");
                return C12145m.listOf(new TextAppearanceSpan(basicRenderContext.getContext(), C5419R.style.Code_TextAppearance_Keyword));
            }
        }, new StyleNode.InterfaceC5656a<RC>() { // from class: com.discord.utilities.textprocessing.Rules$createCodeBlockRule$codeStyleProviders$5
            /* JADX WARN: Incorrect types in method signature: (TRC;)Ljava/lang/Iterable<*>; */
            @Override // com.discord.simpleast.core.node.StyleNode.InterfaceC5656a
            public final Iterable get(BasicRenderContext basicRenderContext) {
                C12238m.checkNotNullParameter(basicRenderContext, "it");
                return C12145m.listOf(new TextAppearanceSpan(basicRenderContext.getContext(), C5419R.style.Code_TextAppearance_Identifier));
            }
        }, new StyleNode.InterfaceC5656a<RC>() { // from class: com.discord.utilities.textprocessing.Rules$createCodeBlockRule$codeStyleProviders$6
            /* JADX WARN: Incorrect types in method signature: (TRC;)Ljava/lang/Iterable<*>; */
            @Override // com.discord.simpleast.core.node.StyleNode.InterfaceC5656a
            public final Iterable get(BasicRenderContext basicRenderContext) {
                C12238m.checkNotNullParameter(basicRenderContext, "it");
                return C12145m.listOf(new TextAppearanceSpan(basicRenderContext.getContext(), C5419R.style.Code_TextAppearance_Types));
            }
        }, new StyleNode.InterfaceC5656a<RC>() { // from class: com.discord.utilities.textprocessing.Rules$createCodeBlockRule$codeStyleProviders$7
            /* JADX WARN: Incorrect types in method signature: (TRC;)Ljava/lang/Iterable<*>; */
            @Override // com.discord.simpleast.core.node.StyleNode.InterfaceC5656a
            public final Iterable get(BasicRenderContext basicRenderContext) {
                C12238m.checkNotNullParameter(basicRenderContext, "it");
                return C12145m.listOf(new TextAppearanceSpan(basicRenderContext.getContext(), C5419R.style.Code_TextAppearance_Generics));
            }
        }, new StyleNode.InterfaceC5656a<RC>() { // from class: com.discord.utilities.textprocessing.Rules$createCodeBlockRule$codeStyleProviders$8
            /* JADX WARN: Incorrect types in method signature: (TRC;)Ljava/lang/Iterable<*>; */
            @Override // com.discord.simpleast.core.node.StyleNode.InterfaceC5656a
            public final Iterable get(BasicRenderContext basicRenderContext) {
                C12238m.checkNotNullParameter(basicRenderContext, "it");
                return C12145m.listOf(new TextAppearanceSpan(basicRenderContext.getContext(), C5419R.style.Code_TextAppearance_Params));
            }
        });
        C1279e c1279e = C1279e.f1905f;
        C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
        C1289o c1289o = C1289o.f1948f;
        C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
        Pattern pattern = C1289o.f1945c;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_KOTLIN_COMMENTS");
        Pattern pattern2 = C1289o.f1947e;
        C12238m.checkNotNullExpressionValue(pattern2, "PATTERN_KOTLIN_STRINGS");
        Pattern pattern3 = C1289o.f1946d;
        C12238m.checkNotNullExpressionValue(pattern3, "PATTERN_KOTLIN_ANNOTATION");
        C1289o.a.C13215a c13215a = C1289o.a.f1950b;
        C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
        Pattern pattern4 = C1289o.a.f1949a;
        C12238m.checkNotNullExpressionValue(pattern4, "PATTERN_KOTLIN_FIELD");
        C1289o.b.a aVar = C1289o.b.f1952b;
        C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
        List listM368a = c1279e.m368a(c1280f, C12147n.listOf((Object[]) new Rule[]{C1279e.m367e(c1279e, pattern, 0, c1280f.f1907b, 1), C1279e.m367e(c1279e, pattern2, 0, c1280f.f1908c, 1), C1279e.m367e(c1279e, pattern3, 0, c1280f.f1912g, 1), new C1288n(c13215a, c1280f, pattern4), new C1290p(aVar, c1280f, C1289o.b.f1951a)}), new String[]{"object", "class", "interface"}, C1289o.f1944b, C1289o.f1943a, (32 & 32) != 0 ? new String[]{" "} : null);
        Pattern patternM369c = c1279e.m369c("//");
        C12238m.checkNotNullExpressionValue(patternM369c, "createSingleLineCommentPattern(\"//\")");
        Pattern patternCompile = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
        C12238m.checkNotNullExpressionValue(patternCompile, "Pattern.compile(\"\"\"^\"[\\s…*?(?<!\\\\)\"(?=\\W|\\s|$)\"\"\")");
        List listM368a2 = c1279e.m368a(c1280f, C12147n.listOf((Object[]) new Rule[]{C1279e.m367e(c1279e, patternM369c, 0, c1280f.f1907b, 1), C1279e.m367e(c1279e, patternCompile, 0, c1280f.f1908c, 1)}), new String[]{"message|enum|extend|service"}, new String[]{"true|false", "string|bool|double|float|bytes", "int32|uint32|sint32|int64|unit64|sint64", "map"}, new String[]{"required|repeated|optional|option|oneof|default|reserved", "package|import", "rpc|returns"}, (32 & 32) != 0 ? new String[]{" "} : null);
        Pattern patternM369c2 = c1279e.m369c("#");
        C12238m.checkNotNullExpressionValue(patternM369c2, "createSingleLineCommentPattern(\"#\")");
        Pattern patternCompile2 = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
        C12238m.checkNotNullExpressionValue(patternCompile2, "Pattern.compile(\"\"\"^\"[\\s…*?(?<!\\\\)\"(?=\\W|\\s|$)\"\"\")");
        Pattern patternCompile3 = Pattern.compile("^'[\\s\\S]*?(?<!\\\\)'(?=\\W|\\s|$)");
        C12238m.checkNotNullExpressionValue(patternCompile3, "Pattern.compile(\"\"\"^'[\\s…*?(?<!\\\\)'(?=\\W|\\s|$)\"\"\")");
        Pattern patternCompile4 = Pattern.compile("^@(\\w+)");
        C12238m.checkNotNullExpressionValue(patternCompile4, "Pattern.compile(\"\"\"^@(\\w+)\"\"\")");
        List listM368a3 = c1279e.m368a(c1280f, C12147n.listOf((Object[]) new Rule[]{C1279e.m367e(c1279e, patternM369c2, 0, c1280f.f1907b, 1), C1279e.m367e(c1279e, patternCompile2, 0, c1280f.f1908c, 1), C1279e.m367e(c1279e, patternCompile3, 0, c1280f.f1908c, 1), C1279e.m367e(c1279e, patternCompile4, 0, c1280f.f1912g, 1)}), new String[]{"class", "def", "lambda"}, new String[]{"True|False|None"}, new String[]{"from|import|global|nonlocal", "async|await|class|self|cls|def|lambda", "for|while|if|else|elif|break|continue|return", "try|except|finally|raise|pass|yeild", "in|as|is|del", "and|or|not|assert"}, (32 & 32) != 0 ? new String[]{" "} : null);
        Pattern patternM369c3 = c1279e.m369c("//");
        C12238m.checkNotNullExpressionValue(patternM369c3, "createSingleLineCommentPattern(\"//\")");
        Pattern patternCompile5 = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
        C12238m.checkNotNullExpressionValue(patternCompile5, "Pattern.compile(\"\"\"^\"[\\s…*?(?<!\\\\)\"(?=\\W|\\s|$)\"\"\")");
        Pattern patternCompile6 = Pattern.compile("^#!?\\[.*?\\]\\n");
        C12238m.checkNotNullExpressionValue(patternCompile6, "Pattern.compile(\"\"\"^#!?\\[.*?\\]\\n\"\"\")");
        List listM368a4 = c1279e.m368a(c1280f, C12147n.listOf((Object[]) new Rule[]{C1279e.m367e(c1279e, patternM369c3, 0, c1280f.f1907b, 1), C1279e.m367e(c1279e, patternCompile5, 0, c1280f.f1908c, 1), C1279e.m367e(c1279e, patternCompile6, 0, c1280f.f1912g, 1)}), new String[]{"struct", "trait", "mod"}, new String[]{"Self|Result|Ok|Err|Option|None|Some", "Copy|Clone|Eq|Hash|Send|Sync|Sized|Debug|Display", "Arc|Rc|Box|Pin|Future", "true|false|bool|usize|i64|u64|u32|i32|str|String"}, new String[]{"let|mut|static|const|unsafe", "crate|mod|extern|pub|pub(super)|use", "struct|enum|trait|type|where|impl|dyn|async|await|move|self|fn", "for|while|loop|if|else|match|break|continue|return|try", "in|as|ref"}, (32 & 32) != 0 ? new String[]{" "} : null);
        C1296v c1296v = C1296v.f1975c;
        C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
        Pattern pattern5 = C1279e.f1902c;
        Pattern pattern6 = C1279e.f1903d;
        List listListOf = C12147n.listOf((Object[]) new Rule[]{C1279e.m367e(c1279e, C1296v.f1973a, 0, c1280f.f1907b, 1), new C1297w(c1296v, c1280f, C1296v.f1974b), C1279e.m367e(c1279e, pattern5, 0, null, 3), C1279e.m367e(c1279e, pattern6, 0, null, 3)});
        Pattern patternM369c4 = c1279e.m369c("#");
        C12238m.checkNotNullExpressionValue(patternM369c4, "createSingleLineCommentPattern(\"#\")");
        Pattern patternCompile7 = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
        C12238m.checkNotNullExpressionValue(patternCompile7, "Pattern.compile(\"\"\"^\"[\\s…*?(?<!\\\\)\"(?=\\W|\\s|$)\"\"\")");
        String strPattern = c1279e.m370d("true|false|null").pattern();
        C12238m.checkNotNullExpressionValue(strPattern, "createWordPattern(\"true|false|null\").pattern()");
        Pattern patternCompile8 = Pattern.compile(strPattern, 2);
        C12238m.checkNotNullExpressionValue(patternCompile8, "java.util.regex.Pattern.compile(this, flags)");
        String strPattern2 = c1279e.m370d("select|from|join|where|and|as|distinct|count|avg", "order by|group by|desc|sum|min|max", "like|having|in|is|not").pattern();
        C12238m.checkNotNullExpressionValue(strPattern2, "createWordPattern(\n     …ing|in|is|not\").pattern()");
        Pattern patternCompile9 = Pattern.compile(strPattern2, 2);
        C12238m.checkNotNullExpressionValue(patternCompile9, "java.util.regex.Pattern.compile(this, flags)");
        List listListOf2 = C12147n.listOf((Object[]) new Rule[]{C1279e.m367e(c1279e, patternM369c4, 0, c1280f.f1907b, 1), C1279e.m367e(c1279e, patternCompile7, 0, c1280f.f1908c, 1), C1279e.m367e(c1279e, patternCompile8, 0, c1280f.f1912g, 1), C1279e.m367e(c1279e, patternCompile9, 0, c1280f.f1909d, 1), C1279e.m367e(c1279e, C1279e.f1904e, 0, c1280f.f1908c, 1), C1279e.m367e(c1279e, pattern5, 0, null, 3), C1279e.m367e(c1279e, pattern6, 0, null, 3)});
        C1283i c1283i = C1283i.f1923h;
        C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
        Pattern pattern7 = C1283i.f1918c;
        C12238m.checkNotNullExpressionValue(pattern7, "PATTERN_CRYSTAL_COMMENTS");
        Pattern pattern8 = C1283i.f1920e;
        C12238m.checkNotNullExpressionValue(pattern8, "PATTERN_CRYSTAL_STRINGS");
        Pattern pattern9 = C1283i.f1921f;
        C12238m.checkNotNullExpressionValue(pattern9, "PATTERN_CRYSTAL_REGEX");
        Pattern pattern10 = C1283i.f1919d;
        C12238m.checkNotNullExpressionValue(pattern10, "PATTERN_CRYSTAL_ANNOTATION");
        Pattern pattern11 = C1283i.f1922g;
        C12238m.checkNotNullExpressionValue(pattern11, "PATTERN_CRYSTAL_SYMBOL");
        C1283i.a.C13213a c13213a = C1283i.a.f1925b;
        C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
        Pattern pattern12 = C1283i.a.f1924a;
        C12238m.checkNotNullExpressionValue(pattern12, "PATTERN_CRYSTAL_FUNC");
        List listM368a5 = c1279e.m368a(c1280f, C12147n.listOf((Object[]) new Rule[]{C1279e.m367e(c1279e, pattern7, 0, c1280f.f1907b, 1), C1279e.m367e(c1279e, pattern8, 0, c1280f.f1908c, 1), C1279e.m367e(c1279e, pattern9, 0, c1280f.f1908c, 1), C1279e.m367e(c1279e, pattern10, 0, c1280f.f1912g, 1), C1279e.m367e(c1279e, pattern11, 0, c1280f.f1908c, 1), new C1282h(c13213a, c1280f, pattern12)}), new String[]{"def", "class"}, C1283i.f1917b, C1283i.f1916a, (32 & 32) != 0 ? new String[]{" "} : null);
        C1285k c1285k = C1285k.f1933g;
        C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
        Pattern pattern13 = C1285k.f1931e;
        C12238m.checkNotNullExpressionValue(pattern13, "PATTERN_JAVASCRIPT_COMMENTS");
        Pattern pattern14 = C1285k.f1932f;
        C12238m.checkNotNullExpressionValue(pattern14, "PATTERN_JAVASCRIPT_STRINGS");
        C1285k.c.a aVar2 = C1285k.c.f1939b;
        C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
        Pattern pattern15 = C1285k.c.f1938a;
        C12238m.checkNotNullExpressionValue(pattern15, "PATTERN_JAVASCRIPT_OBJECT_PROPERTY");
        Pattern pattern16 = C1285k.f1930d;
        C12238m.checkNotNullExpressionValue(pattern16, "PATTERN_JAVASCRIPT_GENERIC");
        Pattern pattern17 = C1285k.f1929c;
        C12238m.checkNotNullExpressionValue(pattern17, "PATTERN_JAVASCRIPT_REGEX");
        C1285k.a.C13214a c13214a = C1285k.a.f1935b;
        C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
        Pattern pattern18 = C1285k.a.f1934a;
        C12238m.checkNotNullExpressionValue(pattern18, "PATTERN_JAVASCRIPT_FIELD");
        C1285k.b.a aVar3 = C1285k.b.f1937b;
        C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
        List listM368a6 = c1279e.m368a(c1280f, C12147n.listOf((Object[]) new Rule[]{C1279e.m367e(c1279e, pattern13, 0, c1280f.f1907b, 1), C1279e.m367e(c1279e, pattern14, 0, c1280f.f1908c, 1), new C1287m(aVar2, c1280f, pattern15), C1279e.m367e(c1279e, pattern16, 0, c1280f.f1912g, 1), C1279e.m367e(c1279e, pattern17, 0, c1280f.f1908c, 1), new C1284j(c13214a, c1280f, pattern18), new C1286l(aVar3, c1280f, C1285k.b.f1936a)}), new String[]{"class"}, C1285k.f1928b, C1285k.f1927a, (32 & 32) != 0 ? new String[]{" "} : null);
        C1292r c1292r = C1292r.f1961g;
        C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
        Pattern pattern19 = C1292r.f1959e;
        C12238m.checkNotNullExpressionValue(pattern19, "PATTERN_TYPESCRIPT_COMMENTS");
        Pattern pattern20 = C1292r.f1960f;
        C12238m.checkNotNullExpressionValue(pattern20, "PATTERN_TYPESCRIPT_STRINGS");
        C1292r.d.a aVar4 = C1292r.d.f1969b;
        C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
        Pattern pattern21 = C1292r.d.f1968a;
        C12238m.checkNotNullExpressionValue(pattern21, "PATTERN_TYPESCRIPT_OBJECT_PROPERTY");
        Pattern pattern22 = C1292r.f1958d;
        C12238m.checkNotNullExpressionValue(pattern22, "PATTERN_TYPESCRIPT_REGEX");
        C1292r.b.a aVar5 = C1292r.b.f1965b;
        C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
        Pattern pattern23 = C1292r.b.f1964a;
        C12238m.checkNotNullExpressionValue(pattern23, "PATTERN_TYPESCRIPT_FIELD");
        C1292r.c.a aVar6 = C1292r.c.f1967b;
        C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
        C1292r.a.C13216a c13216a = C1292r.a.f1963b;
        C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
        Pattern pattern24 = C1292r.a.f1962a;
        C12238m.checkNotNullExpressionValue(pattern24, "PATTERN_TYPESCRIPT_DECORATOR");
        List listM368a7 = c1279e.m368a(c1280f, C12147n.listOf((Object[]) new Rule[]{C1279e.m367e(c1279e, pattern19, 0, c1280f.f1907b, 1), C1279e.m367e(c1279e, pattern20, 0, c1280f.f1908c, 1), new C1295u(aVar4, c1280f, pattern21), C1279e.m367e(c1279e, pattern22, 0, c1280f.f1908c, 1), new C1293s(aVar5, c1280f, pattern23), new C1294t(aVar6, c1280f, C1292r.c.f1966a), new C1291q(c13216a, c1280f, pattern24)}), new String[]{"class", "interface", "enum", "namespace", "module", "type"}, C1292r.f1956b, C1292r.f1955a, C1292r.f1957c);
        Map mapMapOf = C12136h0.mapOf(C12116o.m10073to("kt", listM368a), C12116o.m10073to("kotlin", listM368a), C12116o.m10073to("protobuf", listM368a2), C12116o.m10073to("proto", listM368a2), C12116o.m10073to("pb", listM368a2), C12116o.m10073to("py", listM368a3), C12116o.m10073to("python", listM368a3), C12116o.m10073to("rs", listM368a4), C12116o.m10073to("rust", listM368a4), C12116o.m10073to("cql", listListOf2), C12116o.m10073to("sql", listListOf2), C12116o.m10073to("xml", listListOf), C12116o.m10073to("http", listListOf), C12116o.m10073to("cr", listM368a5), C12116o.m10073to("crystal", listM368a5), C12116o.m10073to("js", listM368a6), C12116o.m10073to("javascript", listM368a6), C12116o.m10073to("ts", listM368a7), C12116o.m10073to("typescript", listM368a7));
        C1279e c1279e2 = C1279e.f1905f;
        StyleNode.InterfaceC5656a<R> interfaceC5656a = c1280f.f1906a;
        C69551 c69551 = C69551.INSTANCE;
        C12238m.checkNotNullParameter(interfaceC5656a, "textStyleProvider");
        C12238m.checkNotNullParameter(mapMapOf, "languageMap");
        C12238m.checkNotNullParameter(c69551, "wrapperNodeProvider");
        return new C1275a(c1279e2, mapMapOf, interfaceC5656a, c69551, C1279e.f1900a);
    }

    public final <T extends EmojiNode.RenderContext, S> Rule<T, EmojiNode<T>, S> createCustomEmojiRule() {
        Pattern pattern = PATTERN_CUSTOM_EMOJI;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_CUSTOM_EMOJI");
        return (Rule<T, EmojiNode<T>, S>) new Rule<T, EmojiNode<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.Rules.createCustomEmojiRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super EmojiNode<T>, S> parser, S state) {
                C12238m.checkNotNullParameter(matcher, "matcher");
                C12238m.checkNotNullParameter(parser, "parser");
                boolean zIsEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
                String strGroup = matcher.group(2);
                C12238m.checkNotNull(strGroup);
                long longOrDefault$default = Rules.toLongOrDefault$default(Rules.INSTANCE, matcher.group(3), 0L, 1, null);
                EmojiNode emojiNode = new EmojiNode(strGroup, new Rules$createCustomEmojiRule$1$parse$emojiNode$1(longOrDefault$default, zIsEmpty), new EmojiNode.EmojiIdAndType.Custom(longOrDefault$default, zIsEmpty, strGroup), 0, 0, 24, null);
                C12238m.checkNotNullParameter(emojiNode, "node");
                return new ParseSpec<>(emojiNode, state);
            }
        };
    }

    public final <T extends BasicRenderContext, S> Rule.BlockRule<T, HeaderNode<T>, S> createHeaderItemRule() {
        return (Rule.BlockRule<T, HeaderNode<T>, S>) new Rule.BlockRule<T, HeaderNode<T>, S>(PATTERN_HEADER_ITEM) { // from class: com.discord.utilities.textprocessing.Rules.createHeaderItemRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super HeaderNode<T>, S> parser, S state) {
                C12238m.checkNotNullParameter(matcher, "matcher");
                C12238m.checkNotNullParameter(parser, "parser");
                String strGroup = matcher.group(1);
                HeaderNode headerNode = new HeaderNode(strGroup != null ? strGroup.length() : 1);
                int iStart = matcher.start(2);
                int iEnd = matcher.end(2);
                C12238m.checkNotNullParameter(headerNode, "node");
                return new ParseSpec<>(headerNode, state, iStart, iEnd);
            }
        };
    }

    public final <T, S> Rule<T, Node<T>, S> createHookedLinkRule() {
        Pattern pattern = PATTERN_HOOKED_LINK;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_HOOKED_LINK");
        return new Rule<T, Node<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.Rules.createHookedLinkRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
                C12238m.checkNotNullParameter(matcher, "matcher");
                C12238m.checkNotNullParameter(parser, "parser");
                StyleNode styleNode = new StyleNode(C12147n.emptyList());
                int iStart = matcher.start(1);
                int iEnd = matcher.end(1);
                C12238m.checkNotNullParameter(styleNode, "node");
                return new ParseSpec<>(styleNode, state, iStart, iEnd);
            }
        };
    }

    public final <RC extends BasicRenderContext, S extends BlockQuoteState<S>> Rule<RC, Node<RC>, S> createInlineCodeRule() {
        C1279e c1279e = C1279e.f1905f;
        C69591 c69591 = new StyleNode.InterfaceC5656a<RC>() { // from class: com.discord.utilities.textprocessing.Rules.createInlineCodeRule.1
            /* JADX WARN: Incorrect types in method signature: (TRC;)Ljava/lang/Iterable<*>; */
            @Override // com.discord.simpleast.core.node.StyleNode.InterfaceC5656a
            public final Iterable get(BasicRenderContext basicRenderContext) {
                C12238m.checkNotNullParameter(basicRenderContext, "it");
                return C12147n.listOf(new TextAppearanceSpan(basicRenderContext.getContext(), C5419R.style.Code_TextAppearance), new RelativeSizeSpan(0.85f));
            }
        };
        C69602 c69602 = new StyleNode.InterfaceC5656a<RC>() { // from class: com.discord.utilities.textprocessing.Rules.createInlineCodeRule.2
            /* JADX WARN: Incorrect types in method signature: (TRC;)Ljava/lang/Iterable<*>; */
            @Override // com.discord.simpleast.core.node.StyleNode.InterfaceC5656a
            public final Iterable get(BasicRenderContext basicRenderContext) {
                C12238m.checkNotNullParameter(basicRenderContext, "it");
                return C12145m.listOf(new BackgroundColorSpan(ColorCompat.getThemedColor(basicRenderContext.getContext(), C5419R.attr.theme_chat_code)));
            }
        };
        C12238m.checkNotNullParameter(c69591, "textStyleProvider");
        C12238m.checkNotNullParameter(c69602, "bgStyleProvider");
        return new C1277c(c1279e, c69591, c69602, C1279e.f1901b);
    }

    public final <T extends BasicRenderContext, S> Rule<T, BulletListNode<T>, S> createListItemRule() {
        Pattern pattern = PATTERN_LIST_ITEM;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_LIST_ITEM");
        return (Rule<T, BulletListNode<T>, S>) new Rule<T, BulletListNode<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.Rules.createListItemRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super BulletListNode<T>, S> parser, S state) {
                C12238m.checkNotNullParameter(matcher, "matcher");
                C12238m.checkNotNullParameter(parser, "parser");
                String strGroup = matcher.group(1);
                int i = strGroup == null || strGroup.length() == 0 ? 1 : 2;
                String strGroup2 = matcher.group(3);
                BulletListNode bulletListNode = new BulletListNode(i, true ^ (strGroup2 == null || strGroup2.length() == 0));
                int iStart = matcher.start(2);
                int iEnd = matcher.end(2);
                C12238m.checkNotNullParameter(bulletListNode, "node");
                return new ParseSpec<>(bulletListNode, state, iStart, iEnd);
            }
        };
    }

    public final <T extends UrlNode.RenderContext, S> Rule<T, UrlNode<T>, S> createMaskedLinkRule() {
        Pattern pattern = PATTERN_MASKED_LINK;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_MASKED_LINK");
        return (Rule<T, UrlNode<T>, S>) new Rule<T, UrlNode<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.Rules.createMaskedLinkRule.1
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
                C12238m.checkNotNullParameter(inspectionSource, "inspectionSource");
                if (isLikelyPathologicalAttack(inspectionSource)) {
                    return null;
                }
                return super.match(inspectionSource, lastCapture, state);
            }

            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super UrlNode<T>, S> parser, S state) {
                C12238m.checkNotNullParameter(matcher, "matcher");
                C12238m.checkNotNullParameter(parser, "parser");
                String strGroup = matcher.group(1);
                C12238m.checkNotNull(strGroup);
                String strGroup2 = matcher.group(2);
                C12238m.checkNotNull(strGroup2);
                UrlNode urlNode = new UrlNode(strGroup2, strGroup);
                C12238m.checkNotNullParameter(urlNode, "node");
                return new ParseSpec<>(urlNode, state);
            }
        };
    }

    public final <T extends EmojiNode.RenderContext, S> Rule<T, Node<T>, S> createNamedEmojiRule() {
        Pattern pattern = PATTERN_NAMED_EMOJI;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_NAMED_EMOJI");
        return (Rule<T, Node<T>, S>) new Rule<T, Node<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.Rules.createNamedEmojiRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
                C12238m.checkNotNullParameter(matcher, "matcher");
                C12238m.checkNotNullParameter(parser, "parser");
                String strGroup = matcher.group(1);
                C12238m.checkNotNull(strGroup);
                ModelEmojiUnicode modelEmojiUnicode = Rules.access$getEmojiDataProvider$p(Rules.INSTANCE).getUnicodeEmojisNamesMap().get(strGroup);
                if (modelEmojiUnicode != null) {
                    EmojiNode emojiNodeFrom$default = EmojiNode.Companion.from$default(EmojiNode.INSTANCE, modelEmojiUnicode, 0, 2, (Object) null);
                    C12238m.checkNotNullParameter(emojiNodeFrom$default, "node");
                    return new ParseSpec<>(emojiNodeFrom$default, state);
                }
                String strGroup2 = matcher.group();
                C12238m.checkNotNullExpressionValue(strGroup2, "matcher.group()");
                C1298a c1298a = new C1298a(strGroup2);
                C12238m.checkNotNullParameter(c1298a, "node");
                return new ParseSpec<>(c1298a, state);
            }
        };
    }

    public final <T extends RoleMentionNode.RenderContext, S> Rule<T, RoleMentionNode<T>, S> createRoleMentionRule() {
        Pattern pattern = PATTERN_ROLE_MENTION;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_ROLE_MENTION");
        return (Rule<T, RoleMentionNode<T>, S>) new Rule<T, RoleMentionNode<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.Rules.createRoleMentionRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super RoleMentionNode<T>, S> parser, S state) {
                C12238m.checkNotNullParameter(matcher, "matcher");
                C12238m.checkNotNullParameter(parser, "parser");
                RoleMentionNode roleMentionNode = new RoleMentionNode(Rules.toLongOrDefault$default(Rules.INSTANCE, matcher.group(1), 0L, 1, null));
                C12238m.checkNotNullParameter(roleMentionNode, "node");
                return new ParseSpec<>(roleMentionNode, state);
            }
        };
    }

    public final <T, S> Rule<T, C1298a<T>, S> createSoftHyphenRule() {
        Pattern pattern = PATTERN_SOFT_HYPHEN;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_SOFT_HYPHEN");
        return new Rule<T, C1298a<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.Rules.createSoftHyphenRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super C1298a<T>, S> parser, S state) {
                C12238m.checkNotNullParameter(matcher, "matcher");
                C12238m.checkNotNullParameter(parser, "parser");
                C1298a c1298a = new C1298a("");
                C12238m.checkNotNullParameter(c1298a, "node");
                return new ParseSpec<>(c1298a, state);
            }
        };
    }

    public final <T extends SpoilerNode.RenderContext, S> Rule<T, SpoilerNode<T>, S> createSpoilerRule() {
        Pattern pattern = PATTERN_SPOILER;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_SPOILER");
        return (Rule<T, SpoilerNode<T>, S>) new Rule<T, SpoilerNode<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.Rules.createSpoilerRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super SpoilerNode<T>, S> parser, S state) {
                C12238m.checkNotNullParameter(matcher, "matcher");
                C12238m.checkNotNullParameter(parser, "parser");
                String strGroup = matcher.group(1);
                C12238m.checkNotNull(strGroup);
                SpoilerNode spoilerNode = new SpoilerNode(strGroup);
                int iStart = matcher.start(1);
                int iEnd = matcher.end(1);
                C12238m.checkNotNullParameter(spoilerNode, "node");
                return new ParseSpec<>(spoilerNode, state, iStart, iEnd);
            }
        };
    }

    public final <T, S> Rule<T, Node<T>, S> createStrikethroughColoredRule(@ColorInt int color) {
        C1303e c1303e = C1303e.f1988h;
        Pattern pattern = C1303e.f1983c;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_STRIKETHRU");
        return C1303e.m373c(pattern, new C69671(color));
    }

    public final <T extends EmojiNode.RenderContext, S> Rule<T, Node<T>, S> createTextReplacementRule() {
        C1303e c1303e = C1303e.f1988h;
        Pattern pattern = C1303e.f1985e;
        C12238m.checkNotNullExpressionValue(pattern, "SimpleMarkdownRules.PATTERN_TEXT");
        return (Rule<T, Node<T>, S>) new Rule<T, Node<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.Rules.createTextReplacementRule.1
            private final List<Rule<T, Node<T>, S>> innerRules = C12147n.listOf((Object[]) new Rule[]{Rules.INSTANCE.createNamedEmojiRule(), C1303e.f1988h.m374d()});

            public final List<Rule<T, Node<T>, S>> getInnerRules() {
                return this.innerRules;
            }

            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
                Node node;
                C12238m.checkNotNullParameter(matcher, "matcher");
                C12238m.checkNotNullParameter(parser, "parser");
                Rules rules = Rules.INSTANCE;
                String strGroup = matcher.group();
                C12238m.checkNotNullExpressionValue(strGroup, "matcher.group()");
                List<T> list = parser.parse(rules.replaceEmojiSurrogates(strGroup), state, this.innerRules);
                if (list.size() == 1) {
                    Object objFirst = C12163u.first((List<? extends Object>) list);
                    Objects.requireNonNull(objFirst, "null cannot be cast to non-null type com.discord.simpleast.core.node.Node<T>");
                    node = (Node) objFirst;
                } else {
                    StyleNode styleNode = new StyleNode(C12147n.emptyList());
                    for (Object obj : list) {
                        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.simpleast.core.node.Node<T>");
                        styleNode.addChild((Node) obj);
                    }
                    node = styleNode;
                }
                C12238m.checkNotNullParameter(node, "node");
                return new ParseSpec<>(node, state);
            }
        };
    }

    public final <T extends TimestampNode.RenderContext, S> Rule<T, TimestampNode<T>, S> createTimestampRule() {
        Pattern pattern = PATTERN_TIMESTAMP;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_TIMESTAMP");
        return (Rule<T, TimestampNode<T>, S>) new Rule<T, TimestampNode<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.Rules.createTimestampRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super TimestampNode<T>, S> parser, S state) {
                C12238m.checkNotNullParameter(matcher, "matcher");
                C12238m.checkNotNullParameter(parser, "parser");
                String strGroup = matcher.group(1);
                C12238m.checkNotNull(strGroup);
                TimestampNode timestampNode = new TimestampNode(strGroup, matcher.group(2));
                C12238m.checkNotNullParameter(timestampNode, "node");
                return new ParseSpec<>(timestampNode, state);
            }
        };
    }

    public final <T, S> Rule<T, C1298a<T>, S> createUnescapeEmoticonRule() {
        Pattern pattern = PATTERN_UNESCAPE_EMOTICON;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_UNESCAPE_EMOTICON");
        return new Rule<T, C1298a<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.Rules.createUnescapeEmoticonRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super C1298a<T>, S> parser, S state) {
                C12238m.checkNotNullParameter(matcher, "matcher");
                C12238m.checkNotNullParameter(parser, "parser");
                String strGroup = matcher.group(1);
                C12238m.checkNotNull(strGroup);
                C1298a c1298a = new C1298a(strGroup);
                C12238m.checkNotNullParameter(c1298a, "node");
                return new ParseSpec<>(c1298a, state);
            }
        };
    }

    public final <T extends EmojiNode.RenderContext, S> Rule<T, Node<T>, S> createUnicodeEmojiRule() {
        Pattern pattern_unicode_emoji = getPATTERN_UNICODE_EMOJI();
        C12238m.checkNotNullExpressionValue(pattern_unicode_emoji, "PATTERN_UNICODE_EMOJI");
        return (Rule<T, Node<T>, S>) new Rule<T, Node<T>, S>(pattern_unicode_emoji) { // from class: com.discord.utilities.textprocessing.Rules.createUnicodeEmojiRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
                C12238m.checkNotNullParameter(matcher, "matcher");
                C12238m.checkNotNullParameter(parser, "parser");
                String strGroup = matcher.group();
                ModelEmojiUnicode modelEmojiUnicode = Rules.access$getEmojiDataProvider$p(Rules.INSTANCE).getUnicodeEmojiSurrogateMap().get(strGroup);
                if (modelEmojiUnicode != null) {
                    EmojiNode emojiNodeFrom$default = EmojiNode.Companion.from$default(EmojiNode.INSTANCE, modelEmojiUnicode, 0, 2, (Object) null);
                    C12238m.checkNotNullParameter(emojiNodeFrom$default, "node");
                    return new ParseSpec<>(emojiNodeFrom$default, state);
                }
                C12238m.checkNotNullExpressionValue(strGroup, "match");
                C1298a c1298a = new C1298a(strGroup);
                C12238m.checkNotNullParameter(c1298a, "node");
                return new ParseSpec<>(c1298a, state);
            }
        };
    }

    public final <T extends UrlNode.RenderContext, S> Rule<T, UrlNode<T>, S> createUrlNoEmbedRule() {
        Pattern pattern = PATTERN_URL_NO_EMBED;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_URL_NO_EMBED");
        return (Rule<T, UrlNode<T>, S>) new Rule<T, UrlNode<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.Rules.createUrlNoEmbedRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super UrlNode<T>, S> parser, S state) {
                C12238m.checkNotNullParameter(matcher, "matcher");
                C12238m.checkNotNullParameter(parser, "parser");
                String strGroup = matcher.group(1);
                C12238m.checkNotNull(strGroup);
                UrlNode urlNode = new UrlNode(strGroup, null, 2, null);
                C12238m.checkNotNullParameter(urlNode, "node");
                return new ParseSpec<>(urlNode, state);
            }
        };
    }

    public final <T extends UrlNode.RenderContext, S> Rule<T, UrlNode<T>, S> createUrlRule() {
        Pattern pattern = PATTERN_URL;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_URL");
        return (Rule<T, UrlNode<T>, S>) new Rule<T, UrlNode<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.Rules.createUrlRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super UrlNode<T>, S> parser, S state) {
                C12238m.checkNotNullParameter(matcher, "matcher");
                C12238m.checkNotNullParameter(parser, "parser");
                String strGroup = matcher.group(1);
                C12238m.checkNotNull(strGroup);
                UrlNode urlNode = new UrlNode(strGroup, null, 2, null);
                C12238m.checkNotNullParameter(urlNode, "node");
                return new ParseSpec<>(urlNode, state);
            }
        };
    }

    public final <T extends UserMentionNode.RenderContext, S> Rule<T, Node<T>, S> createUserMentionRule() {
        Pattern pattern = PATTERN_MENTION;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_MENTION");
        return (Rule<T, Node<T>, S>) new Rule<T, Node<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.Rules.createUserMentionRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
                C12238m.checkNotNullParameter(matcher, "matcher");
                C12238m.checkNotNullParameter(parser, "parser");
                if (!TextUtils.isEmpty(matcher.group(1))) {
                    UserMentionNode userMentionNode = new UserMentionNode(UserMentionNode.Type.USER, Rules.toLongOrDefault$default(Rules.INSTANCE, matcher.group(1), 0L, 1, null));
                    C12238m.checkNotNullParameter(userMentionNode, "node");
                    return new ParseSpec<>(userMentionNode, state);
                }
                String strGroup = matcher.group(2);
                C12238m.checkNotNull(strGroup);
                UserMentionNode userMentionNode2 = new UserMentionNode(strGroup.charAt(0) != 'e' ? UserMentionNode.Type.HERE : UserMentionNode.Type.EVERYONE, 0L, 2, null);
                C12238m.checkNotNullParameter(userMentionNode2, "node");
                return new ParseSpec<>(userMentionNode2, state);
            }
        };
    }
}

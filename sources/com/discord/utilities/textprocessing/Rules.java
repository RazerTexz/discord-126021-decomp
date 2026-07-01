package com.discord.utilities.textprocessing;

import androidx.annotation.ColorInt;
import androidx.exifinterface.media.ExifInterface;
import b.a.t.a.c;
import b.a.t.a.f;
import b.a.t.a.h;
import b.a.t.a.i;
import b.a.t.a.i$a;
import b.a.t.a.i$a$a;
import b.a.t.a.j;
import b.a.t.a.k;
import b.a.t.a.k$a;
import b.a.t.a.k$a$a;
import b.a.t.a.k$b;
import b.a.t.a.k$b$a;
import b.a.t.a.k$c;
import b.a.t.a.k$c$a;
import b.a.t.a.l;
import b.a.t.a.o;
import b.a.t.a.o$a;
import b.a.t.a.o$a$a;
import b.a.t.a.o$b;
import b.a.t.a.o$b$a;
import b.a.t.a.p;
import b.a.t.a.q;
import b.a.t.a.r;
import b.a.t.a.r$a;
import b.a.t.a.r$a$a;
import b.a.t.a.r$b;
import b.a.t.a.r$b$a;
import b.a.t.a.r$c;
import b.a.t.a.r$c$a;
import b.a.t.a.r$d;
import b.a.t.a.r$d$a;
import b.a.t.a.t;
import b.a.t.a.u;
import b.a.t.a.v;
import b.a.t.a.w;
import b.a.t.b.b.e;
import b.a.t.c.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode$a;
import com.discord.simpleast.core.parser.Rule;
import com.discord.simpleast.core.parser.Rule$BlockRule;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import com.discord.utilities.textprocessing.node.BlockQuoteNode;
import com.discord.utilities.textprocessing.node.BulletListNode;
import com.discord.utilities.textprocessing.node.ChannelMentionNode;
import com.discord.utilities.textprocessing.node.ChannelMentionNode$RenderContext;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.textprocessing.node.EmojiNode$RenderContext;
import com.discord.utilities.textprocessing.node.HeaderNode;
import com.discord.utilities.textprocessing.node.RoleMentionNode;
import com.discord.utilities.textprocessing.node.RoleMentionNode$RenderContext;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.textprocessing.node.SpoilerNode$RenderContext;
import com.discord.utilities.textprocessing.node.TimestampNode;
import com.discord.utilities.textprocessing.node.TimestampNode$RenderContext;
import com.discord.utilities.textprocessing.node.UrlNode;
import com.discord.utilities.textprocessing.node.UrlNode$RenderContext;
import com.discord.utilities.textprocessing.node.UserMentionNode$RenderContext;
import d0.g;
import d0.g0.s;
import d0.t.h0;
import d0.t.n;
import d0.t.n0;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;

/* JADX INFO: compiled from: Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Rules {
    private static final Pattern PATTERN_HEADER_ITEM;
    public static final String REGEX_CUSTOM_EMOJI = "<(a)?:([a-zA-Z_0-9]+):(\\d+)>";
    private static final String REGEX_LINK_HREF_AND_TITLE = "\\s*<?((?:[^\\s\\\\]|\\\\.)*?)>?(?:\\s+['\"]([\\s\\S]*?)['\"])?\\s*";
    private static final String REGEX_LINK_INSIDE = "(?:\\[[^]]*]|[^]]|](?=[^\\[]*]))*";
    private static final String REGEX_URL = "(https?://[^\\s<]+[^<.,:;\"')\\]\\s])";
    private static Rules$EmojiDataProvider emojiDataProvider;
    public static final Rules INSTANCE = new Rules();
    private static final Pattern PATTERN_BLOCK_QUOTE = Pattern.compile("^(?: *>>> +(.*)| *>(?!>>) +([^\\n]*\\n?))", 32);
    private static final Pattern PATTERN_CHANNEL_MENTION = Pattern.compile("^<#(\\d+)>");
    private static final Pattern PATTERN_ROLE_MENTION = Pattern.compile("^<@&(\\d+)>");
    private static final Pattern PATTERN_MENTION = Pattern.compile("^<@!?(\\d+)>|^@(everyone|here)");

    /* JADX INFO: renamed from: PATTERN_UNICODE_EMOJI$delegate, reason: from kotlin metadata */
    private static final Lazy PATTERN_UNICODE_EMOJI = g.lazy(Rules$PATTERN_UNICODE_EMOJI$2.INSTANCE);
    private static final Pattern PATTERN_CUSTOM_EMOJI = Pattern.compile("^<(a)?:([a-zA-Z_0-9]+):(\\d+)>");
    private static final Pattern PATTERN_NAMED_EMOJI = Pattern.compile("^:([^\\s:]+?(?:::skin-tone-\\d)?):");
    private static final Pattern PATTERN_UNESCAPE_EMOTICON = Pattern.compile("^(¯\\\\_\\(ツ\\)_/¯)");
    private static final Pattern PATTERN_TIMESTAMP = Pattern.compile("^<t:(-?\\d{1,17})(?::(t|T|d|D|f|F|R))?>");
    private static final Pattern PATTERN_URL = Pattern.compile("^(https?://[^\\s<]+[^<.,:;\"')\\]\\s])");
    private static final String LINK = "^\\[((?:\\[[^]]*]|[^]]|](?=[^\\[]*]))*)]\\(\\s*<?((?:[^\\s\\\\]|\\\\.)*?)>?(?:\\s+['\"]([\\s\\S]*?)['\"])?\\s*\\)";
    private static final Pattern PATTERN_MASKED_LINK = Pattern.compile(LINK);
    private static final Set<Character> PATHOLOGICAL_MASKED_LINK_ATTACK_SUSPICIOUS_CHARS = n0.setOf((Object[]) new Character[]{'[', ']'});
    private static final Pattern PATTERN_URL_NO_EMBED = Pattern.compile("^<(https?://[^\\s<]+[^<.,:;\"')\\]\\s])>");
    private static final Pattern PATTERN_SOFT_HYPHEN = Pattern.compile("^\\u00AD");
    private static final Pattern PATTERN_SPOILER = Pattern.compile("^\\|\\|([\\s\\S]+?)\\|\\|");
    private static final String HOOKED_LINK = "^\\$\\[((?:\\[[^]]*]|[^]]|](?=[^\\[]*]))*)?]\\(\\s*<?((?:[^\\s\\\\]|\\\\.)*?)>?(?:\\s+['\"]([\\s\\S]*?)['\"])?\\s*\\)";
    private static final Pattern PATTERN_HOOKED_LINK = Pattern.compile(HOOKED_LINK);
    private static final Pattern PATTERN_LIST_ITEM = Pattern.compile("^([^\\S\\r\\n]*)[*-][ \\s]?(.*)([\\n|$])?");

    static {
        a aVar = a.e;
        PATTERN_HEADER_ITEM = a.f309b;
    }

    private Rules() {
    }

    public static final /* synthetic */ Rules$EmojiDataProvider access$getEmojiDataProvider$p(Rules rules) {
        Rules$EmojiDataProvider rules$EmojiDataProvider = emojiDataProvider;
        if (rules$EmojiDataProvider == null) {
            m.throwUninitializedPropertyAccessException("emojiDataProvider");
        }
        return rules$EmojiDataProvider;
    }

    public static final /* synthetic */ Set access$getPATHOLOGICAL_MASKED_LINK_ATTACK_SUSPICIOUS_CHARS$p(Rules rules) {
        return PATHOLOGICAL_MASKED_LINK_ATTACK_SUSPICIOUS_CHARS;
    }

    public static final /* synthetic */ String access$replaceEmojiSurrogates(Rules rules, String str) {
        return rules.replaceEmojiSurrogates(str);
    }

    public static final /* synthetic */ void access$setEmojiDataProvider$p(Rules rules, Rules$EmojiDataProvider rules$EmojiDataProvider) {
        emojiDataProvider = rules$EmojiDataProvider;
    }

    private final Pattern getPATTERN_UNICODE_EMOJI() {
        return (Pattern) PATTERN_UNICODE_EMOJI.getValue();
    }

    private final String replaceEmojiSurrogates(String originalText) {
        StringBuffer stringBuffer = new StringBuffer();
        Rules$EmojiDataProvider rules$EmojiDataProvider = emojiDataProvider;
        if (rules$EmojiDataProvider == null) {
            m.throwUninitializedPropertyAccessException("emojiDataProvider");
        }
        Matcher matcher = rules$EmojiDataProvider.getUnicodeEmojisPattern().matcher(originalText);
        while (matcher.find()) {
            String strGroup = matcher.group();
            Rules$EmojiDataProvider rules$EmojiDataProvider2 = emojiDataProvider;
            if (rules$EmojiDataProvider2 == null) {
                m.throwUninitializedPropertyAccessException("emojiDataProvider");
            }
            ModelEmojiUnicode modelEmojiUnicode = rules$EmojiDataProvider2.getUnicodeEmojiSurrogateMap().get(strGroup);
            if (modelEmojiUnicode != null) {
                StringBuilder sbU = b.d.b.a.a.U(":");
                sbU.append(modelEmojiUnicode.getFirstName());
                sbU.append(":");
                matcher.appendReplacement(stringBuffer, sbU.toString());
            }
        }
        matcher.appendTail(stringBuffer);
        String string = stringBuffer.toString();
        m.checkNotNullExpressionValue(string, "stringBuffer.toString()");
        return string;
    }

    public static final void setEmojiDataProvider(Rules$EmojiDataProvider emojiDataProvider2) {
        m.checkNotNullParameter(emojiDataProvider2, "emojiDataProvider");
        emojiDataProvider = emojiDataProvider2;
    }

    private final long toLongOrDefault(String str, long j) {
        Long longOrNull;
        return (str == null || (longOrNull = s.toLongOrNull(str)) == null) ? j : longOrNull.longValue();
    }

    public static /* synthetic */ long toLongOrDefault$default(Rules rules, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = -1;
        }
        return rules.toLongOrDefault(str, j);
    }

    public final <T extends BasicRenderContext, S extends Rules$BlockQuoteState<S>> Rule$BlockRule<T, BlockQuoteNode<T>, S> createBlockQuoteRule() {
        Pattern pattern = PATTERN_BLOCK_QUOTE;
        m.checkNotNullExpressionValue(pattern, "PATTERN_BLOCK_QUOTE");
        return new Rules$createBlockQuoteRule$1(this, pattern);
    }

    public final <T, S> Rule<T, Node<T>, S> createBoldColoredRule(@ColorInt int color) {
        e eVar = e.h;
        Pattern pattern = e.a;
        m.checkNotNullExpressionValue(pattern, "PATTERN_BOLD");
        return e.c(pattern, new Rules$createBoldColoredRule$1(color));
    }

    public final <T extends ChannelMentionNode$RenderContext, S> Rule<T, ChannelMentionNode<T>, S> createChannelMentionRule() {
        Pattern pattern = PATTERN_CHANNEL_MENTION;
        m.checkNotNullExpressionValue(pattern, "PATTERN_CHANNEL_MENTION");
        return new Rules$createChannelMentionRule$1(this, pattern);
    }

    public final <RC extends BasicRenderContext, S extends Rules$BlockQuoteState<S>> Rule<RC, Node<RC>, S> createCodeBlockRule() {
        f fVar = new f(Rules$createCodeBlockRule$codeStyleProviders$1.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$2.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$3.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$4.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$5.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$6.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$7.INSTANCE, Rules$createCodeBlockRule$codeStyleProviders$8.INSTANCE);
        b.a.t.a.e eVar = b.a.t.a.e.f;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        o oVar = o.f;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern = o.c;
        m.checkNotNullExpressionValue(pattern, "PATTERN_KOTLIN_COMMENTS");
        Pattern pattern2 = o.e;
        m.checkNotNullExpressionValue(pattern2, "PATTERN_KOTLIN_STRINGS");
        Pattern pattern3 = o.d;
        m.checkNotNullExpressionValue(pattern3, "PATTERN_KOTLIN_ANNOTATION");
        o$a$a o_a_a = o$a.f299b;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern4 = o$a.a;
        m.checkNotNullExpressionValue(pattern4, "PATTERN_KOTLIN_FIELD");
        o$b$a o_b_a = o$b.f300b;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        List listB = b.a.t.a.e.b(eVar, fVar, n.listOf((Object[]) new Rule[]{b.a.t.a.e.e(eVar, pattern, 0, fVar.f291b, 1), b.a.t.a.e.e(eVar, pattern2, 0, fVar.c, 1), b.a.t.a.e.e(eVar, pattern3, 0, fVar.g, 1), new b.a.t.a.n(o_a_a, fVar, pattern4), new p(o_b_a, fVar, o$b.a)}), new String[]{"object", "class", "interface"}, o.f298b, o.a, null, 32);
        Pattern patternC = eVar.c("//");
        m.checkNotNullExpressionValue(patternC, "createSingleLineCommentPattern(\"//\")");
        Pattern patternCompile = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
        m.checkNotNullExpressionValue(patternCompile, "Pattern.compile(\"\"\"^\"[\\s…*?(?<!\\\\)\"(?=\\W|\\s|$)\"\"\")");
        List listB2 = b.a.t.a.e.b(eVar, fVar, n.listOf((Object[]) new Rule[]{b.a.t.a.e.e(eVar, patternC, 0, fVar.f291b, 1), b.a.t.a.e.e(eVar, patternCompile, 0, fVar.c, 1)}), new String[]{"message|enum|extend|service"}, new String[]{"true|false", "string|bool|double|float|bytes", "int32|uint32|sint32|int64|unit64|sint64", "map"}, new String[]{"required|repeated|optional|option|oneof|default|reserved", "package|import", "rpc|returns"}, null, 32);
        Pattern patternC2 = eVar.c("#");
        m.checkNotNullExpressionValue(patternC2, "createSingleLineCommentPattern(\"#\")");
        Pattern patternCompile2 = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
        m.checkNotNullExpressionValue(patternCompile2, "Pattern.compile(\"\"\"^\"[\\s…*?(?<!\\\\)\"(?=\\W|\\s|$)\"\"\")");
        Pattern patternCompile3 = Pattern.compile("^'[\\s\\S]*?(?<!\\\\)'(?=\\W|\\s|$)");
        m.checkNotNullExpressionValue(patternCompile3, "Pattern.compile(\"\"\"^'[\\s…*?(?<!\\\\)'(?=\\W|\\s|$)\"\"\")");
        Pattern patternCompile4 = Pattern.compile("^@(\\w+)");
        m.checkNotNullExpressionValue(patternCompile4, "Pattern.compile(\"\"\"^@(\\w+)\"\"\")");
        List listB3 = b.a.t.a.e.b(eVar, fVar, n.listOf((Object[]) new Rule[]{b.a.t.a.e.e(eVar, patternC2, 0, fVar.f291b, 1), b.a.t.a.e.e(eVar, patternCompile2, 0, fVar.c, 1), b.a.t.a.e.e(eVar, patternCompile3, 0, fVar.c, 1), b.a.t.a.e.e(eVar, patternCompile4, 0, fVar.g, 1)}), new String[]{"class", "def", "lambda"}, new String[]{"True|False|None"}, new String[]{"from|import|global|nonlocal", "async|await|class|self|cls|def|lambda", "for|while|if|else|elif|break|continue|return", "try|except|finally|raise|pass|yeild", "in|as|is|del", "and|or|not|assert"}, null, 32);
        Pattern patternC3 = eVar.c("//");
        m.checkNotNullExpressionValue(patternC3, "createSingleLineCommentPattern(\"//\")");
        Pattern patternCompile5 = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
        m.checkNotNullExpressionValue(patternCompile5, "Pattern.compile(\"\"\"^\"[\\s…*?(?<!\\\\)\"(?=\\W|\\s|$)\"\"\")");
        Pattern patternCompile6 = Pattern.compile("^#!?\\[.*?\\]\\n");
        m.checkNotNullExpressionValue(patternCompile6, "Pattern.compile(\"\"\"^#!?\\[.*?\\]\\n\"\"\")");
        List listB4 = b.a.t.a.e.b(eVar, fVar, n.listOf((Object[]) new Rule[]{b.a.t.a.e.e(eVar, patternC3, 0, fVar.f291b, 1), b.a.t.a.e.e(eVar, patternCompile5, 0, fVar.c, 1), b.a.t.a.e.e(eVar, patternCompile6, 0, fVar.g, 1)}), new String[]{"struct", "trait", "mod"}, new String[]{"Self|Result|Ok|Err|Option|None|Some", "Copy|Clone|Eq|Hash|Send|Sync|Sized|Debug|Display", "Arc|Rc|Box|Pin|Future", "true|false|bool|usize|i64|u64|u32|i32|str|String"}, new String[]{"let|mut|static|const|unsafe", "crate|mod|extern|pub|pub(super)|use", "struct|enum|trait|type|where|impl|dyn|async|await|move|self|fn", "for|while|loop|if|else|match|break|continue|return|try", "in|as|ref"}, null, 32);
        v vVar = v.c;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern5 = b.a.t.a.e.c;
        Pattern pattern6 = b.a.t.a.e.d;
        List listListOf = n.listOf((Object[]) new Rule[]{b.a.t.a.e.e(eVar, v.a, 0, fVar.f291b, 1), new w(vVar, fVar, v.f306b), b.a.t.a.e.e(eVar, pattern5, 0, null, 3), b.a.t.a.e.e(eVar, pattern6, 0, null, 3)});
        Pattern patternC4 = eVar.c("#");
        m.checkNotNullExpressionValue(patternC4, "createSingleLineCommentPattern(\"#\")");
        Pattern patternCompile7 = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
        m.checkNotNullExpressionValue(patternCompile7, "Pattern.compile(\"\"\"^\"[\\s…*?(?<!\\\\)\"(?=\\W|\\s|$)\"\"\")");
        String strPattern = eVar.d("true|false|null").pattern();
        m.checkNotNullExpressionValue(strPattern, "createWordPattern(\"true|false|null\").pattern()");
        Pattern patternCompile8 = Pattern.compile(strPattern, 2);
        m.checkNotNullExpressionValue(patternCompile8, "java.util.regex.Pattern.compile(this, flags)");
        String strPattern2 = eVar.d("select|from|join|where|and|as|distinct|count|avg", "order by|group by|desc|sum|min|max", "like|having|in|is|not").pattern();
        m.checkNotNullExpressionValue(strPattern2, "createWordPattern(\n     …ing|in|is|not\").pattern()");
        Pattern patternCompile9 = Pattern.compile(strPattern2, 2);
        m.checkNotNullExpressionValue(patternCompile9, "java.util.regex.Pattern.compile(this, flags)");
        List listListOf2 = n.listOf((Object[]) new Rule[]{b.a.t.a.e.e(eVar, patternC4, 0, fVar.f291b, 1), b.a.t.a.e.e(eVar, patternCompile7, 0, fVar.c, 1), b.a.t.a.e.e(eVar, patternCompile8, 0, fVar.g, 1), b.a.t.a.e.e(eVar, patternCompile9, 0, fVar.d, 1), b.a.t.a.e.e(eVar, b.a.t.a.e.e, 0, fVar.c, 1), b.a.t.a.e.e(eVar, pattern5, 0, null, 3), b.a.t.a.e.e(eVar, pattern6, 0, null, 3)});
        i iVar = i.h;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern7 = i.c;
        m.checkNotNullExpressionValue(pattern7, "PATTERN_CRYSTAL_COMMENTS");
        Pattern pattern8 = i.e;
        m.checkNotNullExpressionValue(pattern8, "PATTERN_CRYSTAL_STRINGS");
        Pattern pattern9 = i.f;
        m.checkNotNullExpressionValue(pattern9, "PATTERN_CRYSTAL_REGEX");
        Pattern pattern10 = i.d;
        m.checkNotNullExpressionValue(pattern10, "PATTERN_CRYSTAL_ANNOTATION");
        Pattern pattern11 = i.g;
        m.checkNotNullExpressionValue(pattern11, "PATTERN_CRYSTAL_SYMBOL");
        i$a$a i_a_a = i$a.f293b;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern12 = i$a.a;
        m.checkNotNullExpressionValue(pattern12, "PATTERN_CRYSTAL_FUNC");
        List listB5 = b.a.t.a.e.b(eVar, fVar, n.listOf((Object[]) new Rule[]{b.a.t.a.e.e(eVar, pattern7, 0, fVar.f291b, 1), b.a.t.a.e.e(eVar, pattern8, 0, fVar.c, 1), b.a.t.a.e.e(eVar, pattern9, 0, fVar.c, 1), b.a.t.a.e.e(eVar, pattern10, 0, fVar.g, 1), b.a.t.a.e.e(eVar, pattern11, 0, fVar.c, 1), new h(i_a_a, fVar, pattern12)}), new String[]{"def", "class"}, i.f292b, i.a, null, 32);
        k kVar = k.g;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern13 = k.e;
        m.checkNotNullExpressionValue(pattern13, "PATTERN_JAVASCRIPT_COMMENTS");
        Pattern pattern14 = k.f;
        m.checkNotNullExpressionValue(pattern14, "PATTERN_JAVASCRIPT_STRINGS");
        k$c$a k_c_a = k$c.f297b;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern15 = k$c.a;
        m.checkNotNullExpressionValue(pattern15, "PATTERN_JAVASCRIPT_OBJECT_PROPERTY");
        Pattern pattern16 = k.d;
        m.checkNotNullExpressionValue(pattern16, "PATTERN_JAVASCRIPT_GENERIC");
        Pattern pattern17 = k.c;
        m.checkNotNullExpressionValue(pattern17, "PATTERN_JAVASCRIPT_REGEX");
        k$a$a k_a_a = k$a.f295b;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern18 = k$a.a;
        m.checkNotNullExpressionValue(pattern18, "PATTERN_JAVASCRIPT_FIELD");
        k$b$a k_b_a = k$b.f296b;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        List listB6 = b.a.t.a.e.b(eVar, fVar, n.listOf((Object[]) new Rule[]{b.a.t.a.e.e(eVar, pattern13, 0, fVar.f291b, 1), b.a.t.a.e.e(eVar, pattern14, 0, fVar.c, 1), new b.a.t.a.m(k_c_a, fVar, pattern15), b.a.t.a.e.e(eVar, pattern16, 0, fVar.g, 1), b.a.t.a.e.e(eVar, pattern17, 0, fVar.c, 1), new j(k_a_a, fVar, pattern18), new l(k_b_a, fVar, k$b.a)}), new String[]{"class"}, k.f294b, k.a, null, 32);
        r rVar = r.g;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern19 = r.e;
        m.checkNotNullExpressionValue(pattern19, "PATTERN_TYPESCRIPT_COMMENTS");
        Pattern pattern20 = r.f;
        m.checkNotNullExpressionValue(pattern20, "PATTERN_TYPESCRIPT_STRINGS");
        r$d$a r_d_a = r$d.f305b;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern21 = r$d.a;
        m.checkNotNullExpressionValue(pattern21, "PATTERN_TYPESCRIPT_OBJECT_PROPERTY");
        Pattern pattern22 = r.d;
        m.checkNotNullExpressionValue(pattern22, "PATTERN_TYPESCRIPT_REGEX");
        r$b$a r_b_a = r$b.f303b;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern23 = r$b.a;
        m.checkNotNullExpressionValue(pattern23, "PATTERN_TYPESCRIPT_FIELD");
        r$c$a r_c_a = r$c.f304b;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        r$a$a r_a_a = r$a.f302b;
        m.checkNotNullParameter(fVar, "codeStyleProviders");
        Pattern pattern24 = r$a.a;
        m.checkNotNullExpressionValue(pattern24, "PATTERN_TYPESCRIPT_DECORATOR");
        List listA = eVar.a(fVar, n.listOf((Object[]) new Rule[]{b.a.t.a.e.e(eVar, pattern19, 0, fVar.f291b, 1), b.a.t.a.e.e(eVar, pattern20, 0, fVar.c, 1), new u(r_d_a, fVar, pattern21), b.a.t.a.e.e(eVar, pattern22, 0, fVar.c, 1), new b.a.t.a.s(r_b_a, fVar, pattern23), new t(r_c_a, fVar, r$c.a), new q(r_a_a, fVar, pattern24)}), new String[]{"class", "interface", "enum", "namespace", "module", "type"}, r.f301b, r.a, r.c);
        Map mapMapOf = h0.mapOf(d0.o.to("kt", listB), d0.o.to("kotlin", listB), d0.o.to("protobuf", listB2), d0.o.to("proto", listB2), d0.o.to("pb", listB2), d0.o.to("py", listB3), d0.o.to("python", listB3), d0.o.to("rs", listB4), d0.o.to("rust", listB4), d0.o.to("cql", listListOf2), d0.o.to("sql", listListOf2), d0.o.to("xml", listListOf), d0.o.to("http", listListOf), d0.o.to("cr", listB5), d0.o.to("crystal", listB5), d0.o.to("js", listB6), d0.o.to("javascript", listB6), d0.o.to("ts", listA), d0.o.to("typescript", listA));
        b.a.t.a.e eVar2 = b.a.t.a.e.f;
        StyleNode$a<R> styleNode$a = fVar.a;
        Rules$createCodeBlockRule$1 rules$createCodeBlockRule$1 = Rules$createCodeBlockRule$1.INSTANCE;
        m.checkNotNullParameter(styleNode$a, "textStyleProvider");
        m.checkNotNullParameter(mapMapOf, "languageMap");
        m.checkNotNullParameter(rules$createCodeBlockRule$1, "wrapperNodeProvider");
        return new b.a.t.a.a(eVar2, mapMapOf, styleNode$a, rules$createCodeBlockRule$1, b.a.t.a.e.a);
    }

    public final <T extends EmojiNode$RenderContext, S> Rule<T, EmojiNode<T>, S> createCustomEmojiRule() {
        Pattern pattern = PATTERN_CUSTOM_EMOJI;
        m.checkNotNullExpressionValue(pattern, "PATTERN_CUSTOM_EMOJI");
        return new Rules$createCustomEmojiRule$1(this, pattern);
    }

    public final <T extends BasicRenderContext, S> Rule$BlockRule<T, HeaderNode<T>, S> createHeaderItemRule() {
        return new Rules$createHeaderItemRule$1(this, PATTERN_HEADER_ITEM);
    }

    public final <T, S> Rule<T, Node<T>, S> createHookedLinkRule() {
        Pattern pattern = PATTERN_HOOKED_LINK;
        m.checkNotNullExpressionValue(pattern, "PATTERN_HOOKED_LINK");
        return new Rules$createHookedLinkRule$1(this, pattern);
    }

    public final <RC extends BasicRenderContext, S extends Rules$BlockQuoteState<S>> Rule<RC, Node<RC>, S> createInlineCodeRule() {
        b.a.t.a.e eVar = b.a.t.a.e.f;
        Rules$createInlineCodeRule$1 rules$createInlineCodeRule$1 = Rules$createInlineCodeRule$1.INSTANCE;
        Rules$createInlineCodeRule$2 rules$createInlineCodeRule$2 = Rules$createInlineCodeRule$2.INSTANCE;
        m.checkNotNullParameter(rules$createInlineCodeRule$1, "textStyleProvider");
        m.checkNotNullParameter(rules$createInlineCodeRule$2, "bgStyleProvider");
        return new c(eVar, rules$createInlineCodeRule$1, rules$createInlineCodeRule$2, b.a.t.a.e.f290b);
    }

    public final <T extends BasicRenderContext, S> Rule<T, BulletListNode<T>, S> createListItemRule() {
        Pattern pattern = PATTERN_LIST_ITEM;
        m.checkNotNullExpressionValue(pattern, "PATTERN_LIST_ITEM");
        return new Rules$createListItemRule$1(this, pattern);
    }

    public final <T extends UrlNode$RenderContext, S> Rule<T, UrlNode<T>, S> createMaskedLinkRule() {
        Pattern pattern = PATTERN_MASKED_LINK;
        m.checkNotNullExpressionValue(pattern, "PATTERN_MASKED_LINK");
        return new Rules$createMaskedLinkRule$1(this, pattern);
    }

    public final <T extends EmojiNode$RenderContext, S> Rule<T, Node<T>, S> createNamedEmojiRule() {
        Pattern pattern = PATTERN_NAMED_EMOJI;
        m.checkNotNullExpressionValue(pattern, "PATTERN_NAMED_EMOJI");
        return new Rules$createNamedEmojiRule$1(this, pattern);
    }

    public final <T extends RoleMentionNode$RenderContext, S> Rule<T, RoleMentionNode<T>, S> createRoleMentionRule() {
        Pattern pattern = PATTERN_ROLE_MENTION;
        m.checkNotNullExpressionValue(pattern, "PATTERN_ROLE_MENTION");
        return new Rules$createRoleMentionRule$1(this, pattern);
    }

    public final <T, S> Rule<T, b.a.t.b.a.a<T>, S> createSoftHyphenRule() {
        Pattern pattern = PATTERN_SOFT_HYPHEN;
        m.checkNotNullExpressionValue(pattern, "PATTERN_SOFT_HYPHEN");
        return new Rules$createSoftHyphenRule$1(this, pattern);
    }

    public final <T extends SpoilerNode$RenderContext, S> Rule<T, SpoilerNode<T>, S> createSpoilerRule() {
        Pattern pattern = PATTERN_SPOILER;
        m.checkNotNullExpressionValue(pattern, "PATTERN_SPOILER");
        return new Rules$createSpoilerRule$1(this, pattern);
    }

    public final <T, S> Rule<T, Node<T>, S> createStrikethroughColoredRule(@ColorInt int color) {
        e eVar = e.h;
        Pattern pattern = e.c;
        m.checkNotNullExpressionValue(pattern, "PATTERN_STRIKETHRU");
        return e.c(pattern, new Rules$createStrikethroughColoredRule$1(color));
    }

    public final <T extends EmojiNode$RenderContext, S> Rule<T, Node<T>, S> createTextReplacementRule() {
        e eVar = e.h;
        Pattern pattern = e.e;
        m.checkNotNullExpressionValue(pattern, "SimpleMarkdownRules.PATTERN_TEXT");
        return new Rules$createTextReplacementRule$1(this, pattern);
    }

    public final <T extends TimestampNode$RenderContext, S> Rule<T, TimestampNode<T>, S> createTimestampRule() {
        Pattern pattern = PATTERN_TIMESTAMP;
        m.checkNotNullExpressionValue(pattern, "PATTERN_TIMESTAMP");
        return new Rules$createTimestampRule$1(this, pattern);
    }

    public final <T, S> Rule<T, b.a.t.b.a.a<T>, S> createUnescapeEmoticonRule() {
        Pattern pattern = PATTERN_UNESCAPE_EMOTICON;
        m.checkNotNullExpressionValue(pattern, "PATTERN_UNESCAPE_EMOTICON");
        return new Rules$createUnescapeEmoticonRule$1(this, pattern);
    }

    public final <T extends EmojiNode$RenderContext, S> Rule<T, Node<T>, S> createUnicodeEmojiRule() {
        Pattern pattern_unicode_emoji = getPATTERN_UNICODE_EMOJI();
        m.checkNotNullExpressionValue(pattern_unicode_emoji, "PATTERN_UNICODE_EMOJI");
        return new Rules$createUnicodeEmojiRule$1(this, pattern_unicode_emoji);
    }

    public final <T extends UrlNode$RenderContext, S> Rule<T, UrlNode<T>, S> createUrlNoEmbedRule() {
        Pattern pattern = PATTERN_URL_NO_EMBED;
        m.checkNotNullExpressionValue(pattern, "PATTERN_URL_NO_EMBED");
        return new Rules$createUrlNoEmbedRule$1(this, pattern);
    }

    public final <T extends UrlNode$RenderContext, S> Rule<T, UrlNode<T>, S> createUrlRule() {
        Pattern pattern = PATTERN_URL;
        m.checkNotNullExpressionValue(pattern, "PATTERN_URL");
        return new Rules$createUrlRule$1(this, pattern);
    }

    public final <T extends UserMentionNode$RenderContext, S> Rule<T, Node<T>, S> createUserMentionRule() {
        Pattern pattern = PATTERN_MENTION;
        m.checkNotNullExpressionValue(pattern, "PATTERN_MENTION");
        return new Rules$createUserMentionRule$1(this, pattern);
    }
}

package com.discord.utilities.textprocessing;

import android.content.Context;
import b.a.t.b.b.SimpleMarkdownRules2;
import b.a.t.b.b.SimpleMarkdownRules5;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.textprocessing.node.EditedMessageNode;
import com.discord.utilities.textprocessing.node.ZeroSpaceWidthNode;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: DiscordParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DiscordParser {
    public static final DiscordParser INSTANCE = new DiscordParser();
    private static final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> SAFE_LINK_PARSER = createParser$default(false, true, false, false, false, 28, null);
    private static final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> MASKED_LINK_PARSER = createParser$default(true, true, false, false, false, 28, null);
    private static final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> REPLY_PARSER = createParser$default(false, true, false, false, false, 24, null);
    private static final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> FORUM_POST_FIRST_MESSAGE = createParser$default(false, true, false, true, true, 4, null);

    /* JADX INFO: compiled from: DiscordParser.kt */
    public enum ParserOptions {
        DEFAULT,
        ALLOW_MASKED_LINKS,
        REPLY,
        FORUM_POST_FIRST_MESSAGE
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ParserOptions.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[ParserOptions.DEFAULT.ordinal()] = 1;
            iArr[ParserOptions.ALLOW_MASKED_LINKS.ordinal()] = 2;
            iArr[ParserOptions.REPLY.ordinal()] = 3;
            iArr[ParserOptions.FORUM_POST_FIRST_MESSAGE.ordinal()] = 4;
        }
    }

    private DiscordParser() {
    }

    public static final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> createParser(boolean allowMaskedLinks, boolean supportEntityMentions, boolean renderBlockQuotes, boolean renderHeaders, boolean renderLists) {
        Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser = new Parser<>(false, 1, null);
        Rules rules = Rules.INSTANCE;
        parser.addRule(rules.createSoftHyphenRule());
        SimpleMarkdownRules5 simpleMarkdownRules5 = SimpleMarkdownRules5.h;
        Pattern pattern = SimpleMarkdownRules5.f;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_ESCAPE");
        parser.addRule(new SimpleMarkdownRules2(simpleMarkdownRules5, pattern));
        if (renderBlockQuotes) {
            parser.addRule(rules.createBlockQuoteRule());
        }
        parser.addRule(rules.createCodeBlockRule());
        parser.addRule(rules.createInlineCodeRule());
        parser.addRule(rules.createSpoilerRule());
        if (allowMaskedLinks) {
            parser.addRule(rules.createMaskedLinkRule());
        }
        parser.addRule(rules.createUrlNoEmbedRule());
        parser.addRule(rules.createUrlRule());
        parser.addRule(rules.createCustomEmojiRule());
        parser.addRule(rules.createNamedEmojiRule());
        parser.addRule(rules.createUnescapeEmoticonRule());
        if (supportEntityMentions) {
            parser.addRule(rules.createChannelMentionRule());
            parser.addRule(rules.createRoleMentionRule());
            parser.addRule(rules.createUserMentionRule());
        }
        parser.addRule(rules.createUnicodeEmojiRule());
        parser.addRule(rules.createTimestampRule());
        if (renderHeaders) {
            parser.addRule(rules.createHeaderItemRule());
        }
        if (renderLists) {
            parser.addRule(rules.createListItemRule());
        }
        parser.addRules(SimpleMarkdownRules5.a(false, false));
        parser.addRule(rules.createTextReplacementRule());
        return parser;
    }

    public static /* synthetic */ Parser createParser$default(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, Object obj) {
        if ((i & 4) != 0) {
            z4 = true;
        }
        if ((i & 8) != 0) {
            z5 = false;
        }
        if ((i & 16) != 0) {
            z6 = false;
        }
        return createParser(z2, z3, z4, z5, z6);
    }

    public static final DraweeSpanStringBuilder parseChannelMessage(Context context, String messageText, MessageRenderContext messageRenderContext, MessagePreprocessor preprocessor, ParserOptions parserOptions, boolean isEdited) {
        Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser;
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(messageRenderContext, "messageRenderContext");
        Intrinsics3.checkNotNullParameter(preprocessor, "preprocessor");
        Intrinsics3.checkNotNullParameter(parserOptions, "parserOptions");
        int iOrdinal = parserOptions.ordinal();
        if (iOrdinal == 0) {
            parser = SAFE_LINK_PARSER;
        } else if (iOrdinal == 1) {
            parser = MASKED_LINK_PARSER;
        } else if (iOrdinal == 2) {
            parser = REPLY_PARSER;
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            parser = FORUM_POST_FIRST_MESSAGE;
        }
        Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser2 = parser;
        if (messageText == null) {
            messageText = "";
        }
        List list = Parser.parse$default(parser2, messageText, MessageParseState.INSTANCE.getInitialState(), null, 4, null);
        preprocessor.process(list);
        if (isEdited) {
            list.add(new EditedMessageNode(context));
        }
        list.add(new ZeroSpaceWidthNode());
        return AstRenderer.render(list, messageRenderContext);
    }
}

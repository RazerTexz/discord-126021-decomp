package com.discord.utilities.textprocessing;

import android.content.Context;
import b.a.t.b.b.b;
import b.a.t.b.b.e;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.textprocessing.node.EditedMessageNode;
import com.discord.utilities.textprocessing.node.ZeroSpaceWidthNode;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.z.d.m;
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

    private DiscordParser() {
    }

    public static final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> createParser(boolean allowMaskedLinks, boolean supportEntityMentions, boolean renderBlockQuotes, boolean renderHeaders, boolean renderLists) {
        Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser = new Parser<>(false, 1, null);
        Rules rules = Rules.INSTANCE;
        parser.addRule(rules.createSoftHyphenRule());
        e eVar = e.h;
        Pattern pattern = e.f;
        m.checkNotNullExpressionValue(pattern, "PATTERN_ESCAPE");
        parser.addRule(new b(eVar, pattern));
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
        parser.addRules(e.a(false, false));
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

    public static final DraweeSpanStringBuilder parseChannelMessage(Context context, String messageText, MessageRenderContext messageRenderContext, MessagePreprocessor preprocessor, DiscordParser$ParserOptions parserOptions, boolean isEdited) {
        Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser;
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(messageRenderContext, "messageRenderContext");
        m.checkNotNullParameter(preprocessor, "preprocessor");
        m.checkNotNullParameter(parserOptions, "parserOptions");
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
        List list = Parser.parse$default(parser2, messageText, MessageParseState.Companion.getInitialState(), null, 4, null);
        preprocessor.process(list);
        if (isEdited) {
            list.add(new EditedMessageNode(context));
        }
        list.add(new ZeroSpaceWidthNode());
        return AstRenderer.render(list, messageRenderContext);
    }
}

package com.discord.widgets.chat.list.utils;

import android.content.Context;
import com.discord.api.user.User;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageState$State;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.DiscordParser$ParserOptions;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.z.d.m;
import java.util.Objects;
import kotlin.text.Regex;

/* JADX INFO: compiled from: EmbeddedMessageParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmbeddedMessageParser {
    public static final EmbeddedMessageParser INSTANCE = new EmbeddedMessageParser();

    private EmbeddedMessageParser() {
    }

    private final MessagePreprocessor getMessagePreprocessor(long userId, Message message, StoreMessageState$State messageState, Integer maxNodes) {
        StoreUserSettings userSettings = StoreStream.Companion.getUserSettings();
        return new MessagePreprocessor(userId, messageState, (userSettings.getIsEmbedMediaInlined() && userSettings.getIsRenderEmbedsEnabled()) ? message.getEmbeds() : null, false, maxNodes);
    }

    private final MessageRenderContext getMessageRenderContext(EmbeddedMessageParser$ParserData parserData) {
        return new MessageRenderContext(parserData.getContext(), parserData.getAdapter().getData().getUserId(), parserData.getAnimateEmojis(), parserData.getNickOrUsernames(), parserData.getAdapter().getData().getChannelNames(), parserData.getRoleMentions(), 2130969054, EmbeddedMessageParser$getMessageRenderContext$1.INSTANCE, new EmbeddedMessageParser$getMessageRenderContext$2(parserData), ColorCompat.getThemedColor(parserData.getContext(), 2130970291), ColorCompat.getThemedColor(parserData.getContext(), 2130970292), null, new EmbeddedMessageParser$getMessageRenderContext$3(parserData), new EmbeddedMessageParser$getMessageRenderContext$4(parserData));
    }

    public final DraweeSpanStringBuilder parse(EmbeddedMessageParser$ParserData parserData) {
        m.checkNotNullParameter(parserData, "parserData");
        MessageRenderContext messageRenderContext = getMessageRenderContext(parserData);
        User author = parserData.getMessage().getAuthor();
        MessagePreprocessor messagePreprocessor = getMessagePreprocessor(author != null ? author.getId() : 0L, parserData.getMessage(), parserData.getMessageState(), parserData.getMaxNodes());
        String content = parserData.getMessage().getContent();
        if (content == null) {
            content = "";
        }
        Context context = parserData.getContext();
        String property = System.getProperty("line.separator");
        Objects.requireNonNull(property);
        m.checkNotNullExpressionValue(property, "Objects.requireNonNull(S…operty(\"line.separator\"))");
        return DiscordParser.parseChannelMessage(context, new Regex(property).replace(content, " "), messageRenderContext, messagePreprocessor, DiscordParser$ParserOptions.REPLY, false);
    }
}

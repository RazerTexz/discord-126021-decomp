package com.discord.utilities.textprocessing;

import androidx.exifinterface.media.ExifInterface;
import b.a.t.b.b.e;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: MessageUnparser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageUnparser {
    public static final MessageUnparser INSTANCE = new MessageUnparser();
    private static final Pattern PATTERN_USER_MENTION = Pattern.compile("^<@!?(\\d+)>");
    private static final Pattern PATTERN_ROLE_MENTION = Pattern.compile("^<@&?(\\d+)>");
    private static final Pattern PATTERN_CHANNEL_MENTION = Pattern.compile("^<#?(\\d+)>");
    private static final Pattern PATTERN_CUSTOM_EMOJI = Pattern.compile("^<(a)?:(\\w+):(\\d+)>");

    private MessageUnparser() {
    }

    private final <T, S> Rule<T, Node<T>, S> getChannelMentionRule(Map<Long, Channel> channels) {
        Pattern pattern = PATTERN_CHANNEL_MENTION;
        m.checkNotNullExpressionValue(pattern, "PATTERN_CHANNEL_MENTION");
        return new MessageUnparser$getChannelMentionRule$1(this, channels, pattern);
    }

    private final <T, S> Rule<T, Node<T>, S> getCustomEmojiRule(EmojiSet emojiSet) {
        Pattern pattern = PATTERN_CUSTOM_EMOJI;
        m.checkNotNullExpressionValue(pattern, "PATTERN_CUSTOM_EMOJI");
        return new MessageUnparser$getCustomEmojiRule$1(this, emojiSet, pattern);
    }

    private final <T, S> Rule<T, Node<T>, S> getRoleMentionRule(List<GuildRole> guildRoles) {
        Pattern pattern = PATTERN_ROLE_MENTION;
        m.checkNotNullExpressionValue(pattern, "PATTERN_ROLE_MENTION");
        return new MessageUnparser$getRoleMentionRule$1(this, guildRoles, pattern);
    }

    private final <T, S> Rule<T, Node<T>, S> getUserMentionRule(Map<Long, ? extends User> users) {
        Pattern pattern = PATTERN_USER_MENTION;
        m.checkNotNullExpressionValue(pattern, "PATTERN_USER_MENTION");
        return new MessageUnparser$getUserMentionRule$1(this, users, pattern);
    }

    public static final CharSequence unparse(String rawMessageContent, Guild guild, Map<Long, Channel> channels, Map<Long, ? extends User> users, EmojiSet emojiSet) {
        List<GuildRole> listEmptyList;
        m.checkNotNullParameter(rawMessageContent, "rawMessageContent");
        m.checkNotNullParameter(channels, "channels");
        m.checkNotNullParameter(users, "users");
        m.checkNotNullParameter(emojiSet, "emojiSet");
        Parser parser = new Parser(false, 1, null);
        MessageUnparser messageUnparser = INSTANCE;
        Parser parserAddRule = parser.addRule(messageUnparser.getUserMentionRule(users));
        if (guild == null || (listEmptyList = guild.getRoles()) == null) {
            listEmptyList = n.emptyList();
        }
        return AstRenderer.render(Parser.parse$default(parserAddRule.addRule(messageUnparser.getRoleMentionRule(listEmptyList)).addRule(messageUnparser.getChannelMentionRule(channels)).addRule(messageUnparser.getCustomEmojiRule(emojiSet)).addRule(e.h.d()), rawMessageContent, null, null, 4, null), null);
    }
}

package com.discord.utilities.textprocessing;

import androidx.exifinterface.media.ExifInterface;
import b.a.t.b.a.TextNode;
import b.a.t.b.b.SimpleMarkdownRules5;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.input.MentionUtils;
import d0.g0.StringNumberConversions;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
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

    private final <T, S> Rule<T, Node<T>, S> getChannelMentionRule(final Map<Long, Channel> channels) {
        Pattern pattern = PATTERN_CHANNEL_MENTION;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_CHANNEL_MENTION");
        return new Rule<T, Node<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.MessageUnparser.getChannelMentionRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
                String strGroup;
                Long longOrNull;
                Intrinsics3.checkNotNullParameter(matcher, "matcher");
                Intrinsics3.checkNotNullParameter(parser, "parser");
                String strGroup2 = matcher.group(1);
                Channel channel = (Channel) channels.get(Long.valueOf((strGroup2 == null || (longOrNull = StringNumberConversions.toLongOrNull(strGroup2)) == null) ? -1L : longOrNull.longValue()));
                if (channel != null) {
                    StringBuilder sbQ = outline.Q(MentionUtils.CHANNELS_CHAR);
                    sbQ.append(ChannelUtils.c(channel));
                    strGroup = sbQ.toString();
                } else {
                    strGroup = matcher.group();
                }
                Intrinsics3.checkNotNullExpressionValue(strGroup, "content");
                TextNode textNode = new TextNode(strGroup);
                Intrinsics3.checkNotNullParameter(textNode, "node");
                return new ParseSpec<>(textNode, state);
            }
        };
    }

    private final <T, S> Rule<T, Node<T>, S> getCustomEmojiRule(final EmojiSet emojiSet) {
        Pattern pattern = PATTERN_CUSTOM_EMOJI;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_CUSTOM_EMOJI");
        return new Rule<T, Node<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.MessageUnparser.getCustomEmojiRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
                Intrinsics3.checkNotNullParameter(matcher, "matcher");
                Intrinsics3.checkNotNullParameter(parser, "parser");
                Emoji emoji = emojiSet.emojiIndex.get(matcher.group(3));
                TextNode textNode = new TextNode(MentionUtils.EMOJIS_AND_STICKERS_CHAR + (emoji != null ? emoji.getFirstName() : matcher.group(2)) + MentionUtils.EMOJIS_AND_STICKERS_CHAR);
                Intrinsics3.checkNotNullParameter(textNode, "node");
                return new ParseSpec<>(textNode, state);
            }
        };
    }

    private final <T, S> Rule<T, Node<T>, S> getRoleMentionRule(final List<GuildRole> guildRoles) {
        Pattern pattern = PATTERN_ROLE_MENTION;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_ROLE_MENTION");
        return new Rule<T, Node<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.MessageUnparser.getRoleMentionRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
                T next;
                String strGroup;
                Long longOrNull;
                Intrinsics3.checkNotNullParameter(matcher, "matcher");
                Intrinsics3.checkNotNullParameter(parser, "parser");
                String strGroup2 = matcher.group(1);
                long jLongValue = (strGroup2 == null || (longOrNull = StringNumberConversions.toLongOrNull(strGroup2)) == null) ? -1L : longOrNull.longValue();
                Iterator<T> it = guildRoles.iterator();
                do {
                    if (!it.hasNext()) {
                        next = (T) null;
                        break;
                    }
                    next = it.next();
                } while (!(((GuildRole) next).getId() == jLongValue));
                GuildRole guildRole = next;
                if (guildRole != null) {
                    StringBuilder sbQ = outline.Q(MentionUtils.MENTIONS_CHAR);
                    sbQ.append(guildRole.getName());
                    strGroup = sbQ.toString();
                } else {
                    strGroup = matcher.group();
                }
                Intrinsics3.checkNotNullExpressionValue(strGroup, "content");
                TextNode textNode = new TextNode(strGroup);
                Intrinsics3.checkNotNullParameter(textNode, "node");
                return new ParseSpec<>(textNode, state);
            }
        };
    }

    private final <T, S> Rule<T, Node<T>, S> getUserMentionRule(final Map<Long, ? extends User> users) {
        Pattern pattern = PATTERN_USER_MENTION;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_USER_MENTION");
        return new Rule<T, Node<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.MessageUnparser.getUserMentionRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
                String strGroup;
                Long longOrNull;
                Intrinsics3.checkNotNullParameter(matcher, "matcher");
                Intrinsics3.checkNotNullParameter(parser, "parser");
                String strGroup2 = matcher.group(1);
                User user = (User) users.get(Long.valueOf((strGroup2 == null || (longOrNull = StringNumberConversions.toLongOrNull(strGroup2)) == null) ? -1L : longOrNull.longValue()));
                if (user != null) {
                    StringBuilder sbQ = outline.Q(MentionUtils.MENTIONS_CHAR);
                    sbQ.append(user.getUsername());
                    sbQ.append(UserUtils.INSTANCE.getDiscriminatorWithPadding(user));
                    strGroup = sbQ.toString();
                } else {
                    strGroup = matcher.group();
                }
                Intrinsics3.checkNotNullExpressionValue(strGroup, "content");
                TextNode textNode = new TextNode(strGroup);
                Intrinsics3.checkNotNullParameter(textNode, "node");
                return new ParseSpec<>(textNode, state);
            }
        };
    }

    public static final CharSequence unparse(String rawMessageContent, Guild guild, Map<Long, Channel> channels, Map<Long, ? extends User> users, EmojiSet emojiSet) {
        List<GuildRole> listEmptyList;
        Intrinsics3.checkNotNullParameter(rawMessageContent, "rawMessageContent");
        Intrinsics3.checkNotNullParameter(channels, "channels");
        Intrinsics3.checkNotNullParameter(users, "users");
        Intrinsics3.checkNotNullParameter(emojiSet, "emojiSet");
        Parser parser = new Parser(false, 1, null);
        MessageUnparser messageUnparser = INSTANCE;
        Parser parserAddRule = parser.addRule(messageUnparser.getUserMentionRule(users));
        if (guild == null || (listEmptyList = guild.getRoles()) == null) {
            listEmptyList = Collections2.emptyList();
        }
        return AstRenderer.render(Parser.parse$default(parserAddRule.addRule(messageUnparser.getRoleMentionRule(listEmptyList)).addRule(messageUnparser.getChannelMentionRule(channels)).addRule(messageUnparser.getCustomEmojiRule(emojiSet)).addRule(SimpleMarkdownRules5.h.d()), rawMessageContent, null, null, 4, null), null);
    }
}

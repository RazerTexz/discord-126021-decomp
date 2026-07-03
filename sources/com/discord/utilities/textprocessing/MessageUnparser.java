package com.discord.utilities.textprocessing;

import androidx.exifinterface.media.ExifInterface;
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
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p008a.p050t.p052b.p053a.C1298a;
import p007b.p008a.p050t.p052b.p054b.C1303e;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12102s;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

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
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_CHANNEL_MENTION");
        return new Rule<T, Node<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.MessageUnparser.getChannelMentionRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
                String strGroup;
                Long longOrNull;
                C12238m.checkNotNullParameter(matcher, "matcher");
                C12238m.checkNotNullParameter(parser, "parser");
                String strGroup2 = matcher.group(1);
                Channel channel = (Channel) channels.get(Long.valueOf((strGroup2 == null || (longOrNull = C12102s.toLongOrNull(strGroup2)) == null) ? -1L : longOrNull.longValue()));
                if (channel != null) {
                    StringBuilder sbM829Q = C1643a.m829Q(MentionUtilsKt.CHANNELS_CHAR);
                    sbM829Q.append(ChannelUtils.m7679c(channel));
                    strGroup = sbM829Q.toString();
                } else {
                    strGroup = matcher.group();
                }
                C12238m.checkNotNullExpressionValue(strGroup, "content");
                C1298a c1298a = new C1298a(strGroup);
                C12238m.checkNotNullParameter(c1298a, "node");
                return new ParseSpec<>(c1298a, state);
            }
        };
    }

    private final <T, S> Rule<T, Node<T>, S> getCustomEmojiRule(final EmojiSet emojiSet) {
        Pattern pattern = PATTERN_CUSTOM_EMOJI;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_CUSTOM_EMOJI");
        return new Rule<T, Node<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.MessageUnparser.getCustomEmojiRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
                C12238m.checkNotNullParameter(matcher, "matcher");
                C12238m.checkNotNullParameter(parser, "parser");
                Emoji emoji = emojiSet.emojiIndex.get(matcher.group(3));
                C1298a c1298a = new C1298a(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + (emoji != null ? emoji.getFirstName() : matcher.group(2)) + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
                C12238m.checkNotNullParameter(c1298a, "node");
                return new ParseSpec<>(c1298a, state);
            }
        };
    }

    private final <T, S> Rule<T, Node<T>, S> getRoleMentionRule(final List<GuildRole> guildRoles) {
        Pattern pattern = PATTERN_ROLE_MENTION;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_ROLE_MENTION");
        return new Rule<T, Node<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.MessageUnparser.getRoleMentionRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
                T next;
                String strGroup;
                Long longOrNull;
                C12238m.checkNotNullParameter(matcher, "matcher");
                C12238m.checkNotNullParameter(parser, "parser");
                String strGroup2 = matcher.group(1);
                long jLongValue = (strGroup2 == null || (longOrNull = C12102s.toLongOrNull(strGroup2)) == null) ? -1L : longOrNull.longValue();
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
                    StringBuilder sbM829Q = C1643a.m829Q(MentionUtilsKt.MENTIONS_CHAR);
                    sbM829Q.append(guildRole.getName());
                    strGroup = sbM829Q.toString();
                } else {
                    strGroup = matcher.group();
                }
                C12238m.checkNotNullExpressionValue(strGroup, "content");
                C1298a c1298a = new C1298a(strGroup);
                C12238m.checkNotNullParameter(c1298a, "node");
                return new ParseSpec<>(c1298a, state);
            }
        };
    }

    private final <T, S> Rule<T, Node<T>, S> getUserMentionRule(final Map<Long, ? extends User> users) {
        Pattern pattern = PATTERN_USER_MENTION;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_USER_MENTION");
        return new Rule<T, Node<T>, S>(pattern) { // from class: com.discord.utilities.textprocessing.MessageUnparser.getUserMentionRule.1
            @Override // com.discord.simpleast.core.parser.Rule
            public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
                String strGroup;
                Long longOrNull;
                C12238m.checkNotNullParameter(matcher, "matcher");
                C12238m.checkNotNullParameter(parser, "parser");
                String strGroup2 = matcher.group(1);
                User user = (User) users.get(Long.valueOf((strGroup2 == null || (longOrNull = C12102s.toLongOrNull(strGroup2)) == null) ? -1L : longOrNull.longValue()));
                if (user != null) {
                    StringBuilder sbM829Q = C1643a.m829Q(MentionUtilsKt.MENTIONS_CHAR);
                    sbM829Q.append(user.getUsername());
                    sbM829Q.append(UserUtils.INSTANCE.getDiscriminatorWithPadding(user));
                    strGroup = sbM829Q.toString();
                } else {
                    strGroup = matcher.group();
                }
                C12238m.checkNotNullExpressionValue(strGroup, "content");
                C1298a c1298a = new C1298a(strGroup);
                C12238m.checkNotNullParameter(c1298a, "node");
                return new ParseSpec<>(c1298a, state);
            }
        };
    }

    public static final CharSequence unparse(String rawMessageContent, Guild guild, Map<Long, Channel> channels, Map<Long, ? extends User> users, EmojiSet emojiSet) {
        List<GuildRole> listEmptyList;
        C12238m.checkNotNullParameter(rawMessageContent, "rawMessageContent");
        C12238m.checkNotNullParameter(channels, "channels");
        C12238m.checkNotNullParameter(users, "users");
        C12238m.checkNotNullParameter(emojiSet, "emojiSet");
        Parser parser = new Parser(false, 1, null);
        MessageUnparser messageUnparser = INSTANCE;
        Parser parserAddRule = parser.addRule(messageUnparser.getUserMentionRule(users));
        if (guild == null || (listEmptyList = guild.getRoles()) == null) {
            listEmptyList = C12147n.emptyList();
        }
        return AstRenderer.render(Parser.parse$default(parserAddRule.addRule(messageUnparser.getRoleMentionRule(listEmptyList)).addRule(messageUnparser.getChannelMentionRule(channels)).addRule(messageUnparser.getCustomEmojiRule(emojiSet)).addRule(C1303e.f1988h.m374d()), rawMessageContent, null, null, 4, null), null);
    }
}

package com.discord.widgets.chat.list.actions;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.thread.ThreadMetadata;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.permissions.ManageMessageContext;
import d0.z.d.m;
import j0.l.e.k;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$Model$Companion {
    private WidgetChatListActions$Model$Companion() {
    }

    public static final /* synthetic */ WidgetChatListActions$Model access$create(WidgetChatListActions$Model$Companion widgetChatListActions$Model$Companion, Message message, Guild guild, Long l, MeUser meUser, GuildMember guildMember, Channel channel, CharSequence charSequence, int i, EmojiSet emojiSet) {
        return widgetChatListActions$Model$Companion.create(message, guild, l, meUser, guildMember, channel, charSequence, i, emojiSet);
    }

    private final WidgetChatListActions$Model create(Message message, Guild guild, Long permissions, MeUser meUser, GuildMember member, Channel channel, CharSequence messageContent, int type, EmojiSet emojis) {
        String nick;
        ThreadMetadata threadMetadata;
        String username = null;
        if (message == null) {
            return null;
        }
        ManageMessageContext manageMessageContextFrom = ManageMessageContext.Companion.from(message, permissions, meUser, guild != null ? Integer.valueOf(guild.getMfaLevel()) : null, channel != null && ChannelUtils.B(channel), channel != null && ChannelUtils.E(channel), (channel == null || (threadMetadata = channel.getThreadMetadata()) == null || !threadMetadata.getArchived()) ? false : true);
        if (member == null || (nick = member.getNick()) == null) {
            User author = message.getAuthor();
            if (author != null) {
                username = author.getUsername();
            }
        } else {
            username = nick;
        }
        if (username == null) {
            username = "";
        }
        String str = username;
        boolean isDeveloperMode = StoreStream.Companion.getUserSettings().getIsDeveloperMode();
        List<Emoji> list = emojis.recentEmojis;
        m.checkNotNullExpressionValue(list, "emojis.recentEmojis");
        return new WidgetChatListActions$Model(message, guild, str, messageContent, manageMessageContextFrom, type, isDeveloperMode, list, channel, permissions, meUser);
    }

    public final Observable<WidgetChatListActions$Model> get(long channelId, long messageId, CharSequence messageContent, int type) {
        Observable<Message> observableObserveMessagesForChannel;
        if (type != 0) {
            observableObserveMessagesForChannel = type != 1 ? new k<>(null) : StoreStream.Companion.getPinnedMessages().observePinnedMessage(channelId, messageId);
        } else {
            observableObserveMessagesForChannel = StoreStream.Companion.getMessages().observeMessagesForChannel(channelId, messageId);
        }
        Observable<WidgetChatListActions$Model> observableY = Observable.j(observableObserveMessagesForChannel, StoreStream.Companion.getChannels().observeChannel(channelId), WidgetChatListActions$Model$Companion$get$1.INSTANCE).Y(new WidgetChatListActions$Model$Companion$get$2(channelId, messageContent, type));
        m.checkNotNullExpressionValue(observableY, "Observable\n            .…          }\n            }");
        return observableY;
    }

    public /* synthetic */ WidgetChatListActions$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

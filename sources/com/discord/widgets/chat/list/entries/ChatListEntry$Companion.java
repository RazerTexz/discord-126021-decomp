package com.discord.widgets.chat.list.entries;

import b.a.d.m0.a;
import com.discord.api.application.Application;
import com.discord.api.botuikit.Component;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.message.activity.MessageActivity;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.api.message.embed.EmbedType;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.api.role.GuildRole;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerPartial;
import com.discord.api.user.User;
import com.discord.models.botuikit.MessageComponent;
import com.discord.models.domain.ModelInvite;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageState$State;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadMessages$ThreadState;
import com.discord.utilities.embed.InviteEmbedModel;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.message.MessageUtils;
import com.discord.widgets.botuikit.BotComponentExperiments;
import com.discord.widgets.botuikit.ComponentChatListState$ComponentStoreState;
import com.discord.widgets.botuikit.ComponentStateMapper;
import com.discord.widgets.chat.AutocompleteSelectionTypes;
import com.discord.widgets.chat.AutocompleteTypes;
import d0.g0.s;
import d0.t.h0;
import d0.t.n;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.MatchResult;

/* JADX INFO: compiled from: ChatListEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatListEntry$Companion {
    private ChatListEntry$Companion() {
    }

    private final ChatListEntry createEntryForInvite(Message message, String inviteCode, String eventId, InviteEmbedModel inviteEmbedModel) {
        if (eventId != null) {
            ModelInvite modelInviteResolveInviteForGuildScheduledEvent = inviteEmbedModel.resolveInviteForGuildScheduledEvent(inviteCode, eventId);
            if ((modelInviteResolveInviteForGuildScheduledEvent != null ? modelInviteResolveInviteForGuildScheduledEvent.getGuildScheduledEvent() : null) != null) {
                GuildScheduledEvent guildScheduledEvent = modelInviteResolveInviteForGuildScheduledEvent.getGuildScheduledEvent();
                m.checkNotNull(guildScheduledEvent);
                m.checkNotNullExpressionValue(guildScheduledEvent, "eventInvite.guildScheduledEvent!!");
                return new GuildScheduledEventInviteEntry(modelInviteResolveInviteForGuildScheduledEvent, inviteCode, guildScheduledEvent);
            }
        }
        ModelInvite modelInviteResolveInviteCodeForPublicStage = inviteEmbedModel.resolveInviteCodeForPublicStage(inviteCode);
        if (modelInviteResolveInviteCodeForPublicStage != null) {
            User author = message.getAuthor();
            m.checkNotNull(author);
            long id2 = author.getId();
            long id3 = message.getId();
            Long guildId = message.getGuildId();
            return new StageInviteEntry(id2, id3, inviteCode, modelInviteResolveInviteCodeForPublicStage, guildId != null ? guildId.longValue() : 0L);
        }
        User author2 = message.getAuthor();
        m.checkNotNull(author2);
        long id4 = author2.getId();
        long id5 = message.getId();
        Long guildId2 = message.getGuildId();
        return new InviteEntry(id4, id5, inviteCode, guildId2 != null ? guildId2.longValue() : 0L, eventId);
    }

    public final Collection<ChatListEntry> createBotComponentEntries(Message message, long guildId, ComponentChatListState$ComponentStoreState componentStoreState, boolean animateEmojis) {
        long id2;
        m.checkNotNullParameter(message, "message");
        List<Component> components = message.getComponents();
        if (components == null || !(!components.isEmpty())) {
            return n.emptyList();
        }
        List<MessageComponent> listProcessComponentsToMessageComponents = ComponentStateMapper.INSTANCE.processComponentsToMessageComponents(message.getComponents(), componentStoreState, BotComponentExperiments.Companion.get(StoreStream.Companion.getExperiments()), animateEmojis);
        Long applicationId = message.getApplicationId();
        if (applicationId != null) {
            id2 = applicationId.longValue();
        } else {
            User author = message.getAuthor();
            m.checkNotNull(author);
            id2 = author.getId();
        }
        return d0.t.m.listOf(new BotUiComponentEntry(message, id2, Long.valueOf(guildId), listProcessComponentsToMessageComponents));
    }

    public final List<ChatListEntry> createEmbedEntries(Message message, StoreMessageState$State messageState, boolean blockedChunkExpanded, boolean allowAnimatedEmojis, boolean autoPlayGifs, boolean renderEmbeds, boolean isThreadStarterMessage, Channel channel, GuildMember author, Map<Long, GuildRole> roles, Map<Long, String> nickOrUsernames) {
        int i;
        int i2;
        Integer type;
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(nickOrUsernames, "nickOrUsernames");
        if (!message.hasAttachments() && (!message.hasEmbeds() || !renderEmbeds)) {
            return n.emptyList();
        }
        HashSet hashSet = new HashSet();
        ArrayList<MessageEmbed> arrayList = new ArrayList();
        List<MessageEmbed> embeds = message.getEmbeds();
        if (embeds != null) {
            for (MessageEmbed messageEmbed : embeds) {
                if (!hashSet.contains(messageEmbed.getUrl())) {
                    hashSet.add(messageEmbed.getUrl());
                    arrayList.add(messageEmbed);
                } else if (messageEmbed.getUrl() == null) {
                    arrayList.add(messageEmbed);
                }
            }
        }
        List<MessageAttachment> attachments = message.getAttachments();
        ArrayList arrayList2 = new ArrayList(arrayList.size() + (attachments != null ? attachments.size() : 0));
        List<MessageAttachment> attachments2 = message.getAttachments();
        if (attachments2 != null) {
            Iterator<T> it = attachments2.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                arrayList2.add(new AttachmentEntry(i3, channel.getGuildId(), message, messageState, (MessageAttachment) it.next(), blockedChunkExpanded, allowAnimatedEmojis, autoPlayGifs, isThreadStarterMessage));
                i3++;
            }
            i = 0;
            i2 = i3;
        } else {
            i = 0;
            i2 = 0;
        }
        Integer type2 = message.getType();
        if (type2 != null && type2.intValue() == 24) {
            arrayList2.add(new AutoModSystemMessageEmbedEntry(channel, message, messageState, (MessageEmbed) arrayList.get(i), author, allowAnimatedEmojis, roles, nickOrUsernames));
        }
        int i4 = i2;
        for (MessageEmbed messageEmbed2 : arrayList) {
            if (messageEmbed2.getType() != EmbedType.APPLICATION_NEWS && ((type = message.getType()) == null || type.intValue() != 24)) {
                arrayList2.add(new EmbedEntry(i4, channel.getGuildId(), message, messageState, messageEmbed2, blockedChunkExpanded, allowAnimatedEmojis, autoPlayGifs, isThreadStarterMessage));
                i4++;
            }
        }
        return arrayList2;
    }

    public final List<ChatListEntry> createGameInviteEntries(Message message) {
        m.checkNotNullParameter(message, "message");
        Application application = message.getApplication();
        MessageActivity activity = message.getActivity();
        if (application == null || activity == null) {
            return n.emptyList();
        }
        User author = message.getAuthor();
        m.checkNotNull(author);
        return d0.t.m.listOf(new GameInviteEntry(author.getId(), message.getId(), activity, application));
    }

    public final Collection<ChatListEntry> createGiftEntries(Message message) {
        m.checkNotNullParameter(message, "message");
        String content = message.getContent();
        if (content == null || content.length() == 0) {
            return n.emptyList();
        }
        HashMap map = new HashMap();
        Iterator<MatchResult> it = a.r.findAll(content, 0).iterator();
        while (it.hasNext()) {
            List<String> groupValues = it.next().getGroupValues();
            if (!groupValues.isEmpty()) {
                String str = groupValues.get(groupValues.size() - 1);
                User author = message.getAuthor();
                m.checkNotNull(author);
                map.put(str, new GiftEntry(author.getId(), message.getId(), message.getChannelId(), str));
            }
        }
        Collection<ChatListEntry> collectionValues = map.values();
        m.checkNotNullExpressionValue(collectionValues, "entries.values");
        return collectionValues;
    }

    public final Collection<ChatListEntry> createGuildTemplateEntries(Message message) {
        m.checkNotNullParameter(message, "message");
        String content = message.getContent();
        if (content != null) {
            if (!(content.length() == 0)) {
                HashMap map = new HashMap();
                Iterator<MatchResult> it = a.q.findAll(content, 0).iterator();
                while (it.hasNext()) {
                    List<String> groupValues = it.next().getGroupValues();
                    if (!groupValues.isEmpty()) {
                        String str = groupValues.get(groupValues.size() - 1);
                        User author = message.getAuthor();
                        m.checkNotNull(author);
                        map.put(str, new GuildTemplateEntry(author.getId(), message.getId(), str));
                    }
                }
                Collection<ChatListEntry> collectionValues = map.values();
                m.checkNotNullExpressionValue(collectionValues, "entries.values");
                return collectionValues;
            }
        }
        return n.emptyList();
    }

    public final Collection<ChatListEntry> createInviteEntries(Message message, InviteEmbedModel inviteEmbedModel) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(inviteEmbedModel, "inviteEmbedModel");
        String content = message.getContent();
        if (content == null || content.length() == 0) {
            return n.emptyList();
        }
        HashMap map = new HashMap();
        Iterator<MatchResult> it = a.o.findAll(content, 0).iterator();
        while (it.hasNext()) {
            List<String> groupValues = it.next().getGroupValues();
            if (groupValues.size() == 3) {
                String str = groupValues.get(1);
                Long longOrNull = s.toLongOrNull(groupValues.get(2));
                map.put(str, createEntryForInvite(message, str, longOrNull != null ? String.valueOf(longOrNull.longValue()) : null, inviteEmbedModel));
            }
        }
        Collection<ChatListEntry> collectionValues = map.values();
        m.checkNotNullExpressionValue(collectionValues, "entries.values");
        return collectionValues;
    }

    public final List<ChatListEntry> createSpotifyListenTogetherEntries(Message message) {
        m.checkNotNullParameter(message, "message");
        MessageActivity activity = message.getActivity();
        if (activity == null || !message.isSpotifyListeningActivity()) {
            return n.emptyList();
        }
        User author = message.getAuthor();
        m.checkNotNull(author);
        return d0.t.m.listOf(new SpotifyListenTogetherEntry(author.getId(), message.getId(), activity));
    }

    public final List<ChatListEntry> createStickerEntries(Message message) {
        ArrayList arrayList;
        m.checkNotNullParameter(message, "message");
        List<StickerPartial> stickerItems = message.getStickerItems();
        if (stickerItems == null || stickerItems.isEmpty()) {
            List<Sticker> stickers = message.getStickers();
            if (stickers != null) {
                arrayList = new ArrayList(o.collectionSizeOrDefault(stickers, 10));
                Iterator<T> it = stickers.iterator();
                while (it.hasNext()) {
                    arrayList.add(new StickerEntry(message, (Sticker) it.next()));
                }
            } else {
                arrayList = null;
            }
        } else {
            List<StickerPartial> stickerItems2 = message.getStickerItems();
            arrayList = new ArrayList(o.collectionSizeOrDefault(stickerItems2, 10));
            Iterator<T> it2 = stickerItems2.iterator();
            while (it2.hasNext()) {
                arrayList.add(new StickerEntry(message, (StickerPartial) it2.next()));
            }
        }
        return arrayList != null ? arrayList : n.emptyList();
    }

    public final Collection<ChatListEntry> createThreadEmbedEntries(Channel channel, Map<Long, GuildMember> channelMembers, Message message, Channel thread, StoreThreadMessages$ThreadState threadEmbedMetadata, Map<Long, GuildRole> guildRoles, boolean animateEmojis, boolean renderEmbeds) {
        Map<Long, String> mapEmptyMap;
        Message mostRecentMessage;
        User author;
        Message mostRecentMessage2;
        Message mostRecentMessage3;
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(channelMembers, "channelMembers");
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(thread, "thread");
        if (!renderEmbeds) {
            return n.emptyList();
        }
        long id2 = message.getId();
        int count = threadEmbedMetadata != null ? threadEmbedMetadata.getCount() : 0;
        Long lValueOf = null;
        Message mostRecentMessage4 = threadEmbedMetadata != null ? threadEmbedMetadata.getMostRecentMessage() : null;
        Map<Long, GuildRole> map = RoleUtils.containsRoleMentions((threadEmbedMetadata == null || (mostRecentMessage3 = threadEmbedMetadata.getMostRecentMessage()) == null) ? null : mostRecentMessage3.getContent()) ? guildRoles : null;
        if (threadEmbedMetadata == null || (mostRecentMessage2 = threadEmbedMetadata.getMostRecentMessage()) == null || (mapEmptyMap = MessageUtils.getNickOrUsernames(mostRecentMessage2, channel, channelMembers, channel.q())) == null) {
            mapEmptyMap = h0.emptyMap();
        }
        Map<Long, String> map2 = mapEmptyMap;
        if (threadEmbedMetadata != null && (mostRecentMessage = threadEmbedMetadata.getMostRecentMessage()) != null && (author = mostRecentMessage.getAuthor()) != null) {
            lValueOf = Long.valueOf(author.getId());
        }
        return d0.t.m.listOf(new ThreadEmbedEntry(id2, thread, count, mostRecentMessage4, map, map2, animateEmojis, channelMembers.get(lValueOf), message));
    }

    public /* synthetic */ ChatListEntry$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

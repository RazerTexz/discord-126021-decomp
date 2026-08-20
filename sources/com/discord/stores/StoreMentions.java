package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.permission.Permission;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelMessageDelete;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelReadState;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.message.Message;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.persister.Persister;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12160r;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreMentions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMentions extends StoreV2 {
    private final HashMap<Long, Long> channelGuildIds;
    private final Persister<Map<Long, Integer>> countsCache;
    private final Map<Long, Integer> countsEmpty;
    private Map<Long, Integer> countsSnapshot;
    private final HashMap<Long, Message> mentionedMessages;
    private long myId;
    private final HashMap<Long, List<Long>> myRoleIds;
    private final ObservationDeck observationDeck;
    private final HashSet<Long> privateChannels;
    private long selectedChannelId;
    private final ArrayList<ModelReadState> serverInitReadStates;
    private final StoreChannels storeChannels;
    private final StoreMessageAck storeMessageAck;
    private final StorePermissions storePermissions;
    private final StoreThreadsJoined storeThreadsJoined;
    private final StoreUserGuildSettings storeUserGuildSettings;
    private final StoreUserRelationships storeUserRelationships;

    /* JADX INFO: renamed from: com.discord.stores.StoreMentions$handleConnectionOpen$3 */
    /* JADX INFO: compiled from: StoreMentions.kt */
    public static final class C61923 extends AbstractC12240o implements Function1<ModelReadState, Boolean> {
        public final /* synthetic */ HashSet $newReadStateChannelIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61923(HashSet hashSet) {
            super(1);
            this.$newReadStateChannelIds = hashSet;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(ModelReadState modelReadState) {
            return Boolean.valueOf(invoke2(modelReadState));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(ModelReadState modelReadState) {
            C12238m.checkNotNullParameter(modelReadState, "readState");
            return this.$newReadStateChannelIds.contains(Long.valueOf(modelReadState.getChannelId()));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMentions$handleConnectionOpen$5 */
    /* JADX INFO: compiled from: StoreMentions.kt */
    public static final class C61935 extends AbstractC12240o implements Function1<ModelReadState, Boolean> {
        public C61935() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(ModelReadState modelReadState) {
            return Boolean.valueOf(invoke2(modelReadState));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(ModelReadState modelReadState) {
            C12238m.checkNotNullParameter(modelReadState, "readState");
            return !StoreMentions.this.storeChannels.getChannelNamesInternal$app_productionGoogleRelease().containsKey(Long.valueOf(modelReadState.getChannelId()));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMentions$handleMessageAck$1 */
    /* JADX INFO: compiled from: StoreMentions.kt */
    public static final class C61941 extends AbstractC12240o implements Function1<ModelReadState, Boolean> {
        public final /* synthetic */ ModelReadState $readState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61941(ModelReadState modelReadState) {
            super(1);
            this.$readState = modelReadState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(ModelReadState modelReadState) {
            return Boolean.valueOf(invoke2(modelReadState));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(ModelReadState modelReadState) {
            C12238m.checkNotNullParameter(modelReadState, "it");
            return modelReadState.getChannelId() == this.$readState.getChannelId();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMentions$observeMentionCounts$1 */
    /* JADX INFO: compiled from: StoreMentions.kt */
    public static final class C61951 extends AbstractC12240o implements Function0<Map<Long, ? extends Integer>> {
        public C61951() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Integer> invoke() {
            return StoreMentions.this.getMentionCounts();
        }
    }

    public /* synthetic */ StoreMentions(StoreUserRelationships storeUserRelationships, StorePermissions storePermissions, StoreMessageAck storeMessageAck, StoreUserGuildSettings storeUserGuildSettings, StoreChannels storeChannels, StoreThreadsJoined storeThreadsJoined, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeUserRelationships, storePermissions, storeMessageAck, storeUserGuildSettings, storeChannels, storeThreadsJoined, (i & 64) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    @StoreThread
    private final Map<Long, Integer> computeMentionCounts() {
        StoreMessageAck.Ack ack;
        if (this.serverInitReadStates.isEmpty() && this.mentionedMessages.isEmpty()) {
            return this.countsEmpty;
        }
        HashMap map = new HashMap();
        Map<Long, StoreMessageAck.Ack> allInternal = this.storeMessageAck.getAllInternal();
        for (ModelReadState modelReadState : this.serverInitReadStates) {
            long channelId = modelReadState.getChannelId();
            long lastMessageId = modelReadState.getLastMessageId();
            int mentionCount = modelReadState.getMentionCount();
            if (mentionCount >= 1 && isMentionableChannel(channelId) && (ack = allInternal.get(Long.valueOf(channelId))) != null && ack.getMessageId() <= lastMessageId) {
                Long lValueOf = Long.valueOf(channelId);
                Integer num = (Integer) map.get(Long.valueOf(channelId));
                if (num == null) {
                    num = 0;
                }
                map.put(lValueOf, Integer.valueOf(num.intValue() + mentionCount));
            }
        }
        for (Message message : this.mentionedMessages.values()) {
            long channelId2 = message.getChannelId();
            User author = message.getAuthor();
            if (!ModelUserRelationship.isType(this.storeUserRelationships.getRelationships().get(author != null ? Long.valueOf(author.getId()) : null), 2) && isMentionableChannel(channelId2)) {
                StoreMessageAck.Ack ack2 = allInternal.get(Long.valueOf(channelId2));
                if (ack2 == null || ack2.getMessageId() < message.getId()) {
                    Long lValueOf2 = Long.valueOf(channelId2);
                    Integer num2 = (Integer) map.get(Long.valueOf(channelId2));
                    if (num2 == null) {
                        num2 = 0;
                    }
                    map.put(lValueOf2, Integer.valueOf(num2.intValue() + 1));
                }
            }
        }
        return map;
    }

    @StoreThread
    private final boolean hasMention(long channelId, User author, UtcDateTime editedTimestamp, List<User> mentions, List<Long> mentionRoles, Boolean mentionEveryone) {
        List<Long> list;
        boolean z2;
        ModelNotificationSettings modelNotificationSettings;
        ModelNotificationSettings.ChannelOverride channelOverride;
        Long l = this.channelGuildIds.get(Long.valueOf(channelId));
        if (l == null) {
            l = 0L;
        }
        C12238m.checkNotNullExpressionValue(l, "channelGuildIds[channelId] ?: 0");
        long jLongValue = l.longValue();
        if (author == null || author.getId() != this.myId) {
            if ((editedTimestamp != null ? editedTimestamp.getDateTimeMillis() : 0L) <= 0) {
                Channel channel = this.storeChannels.getChannel(channelId);
                if (channel != null && ChannelUtils.m7673H(channel) && !this.storeThreadsJoined.hasJoined(channelId)) {
                    return false;
                }
                Map<Long, ModelNotificationSettings> guildSettingsInternal$app_productionGoogleRelease = this.storeUserGuildSettings.getGuildSettingsInternal$app_productionGoogleRelease();
                if (this.privateChannels.contains(Long.valueOf(channelId)) && ((modelNotificationSettings = guildSettingsInternal$app_productionGoogleRelease.get(0L)) == null || (channelOverride = modelNotificationSettings.getChannelOverride(channelId)) == null || !channelOverride.isMuted())) {
                    return true;
                }
                if (mentions != null) {
                    if (!mentions.isEmpty()) {
                        Iterator<T> it = mentions.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                            if (((User) it.next()).getId() == this.myId) {
                                z2 = true;
                                break;
                            }
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                    if (z2) {
                        return true;
                    }
                }
                ModelNotificationSettings modelNotificationSettings2 = guildSettingsInternal$app_productionGoogleRelease.get(Long.valueOf(jLongValue));
                if ((modelNotificationSettings2 == null || !modelNotificationSettings2.isSuppressRoles()) && (list = this.myRoleIds.get(Long.valueOf(jLongValue))) != null && mentionRoles != null) {
                    Iterator<T> it2 = mentionRoles.iterator();
                    if (it2.hasNext()) {
                        return list.contains(Long.valueOf(((Number) it2.next()).longValue()));
                    }
                }
                if (!C12238m.areEqual(mentionEveryone, Boolean.TRUE)) {
                    return false;
                }
                ModelNotificationSettings modelNotificationSettings3 = guildSettingsInternal$app_productionGoogleRelease.get(Long.valueOf(jLongValue));
                return modelNotificationSettings3 == null || !modelNotificationSettings3.isSuppressEveryone();
            }
        }
        return false;
    }

    @StoreThread
    private final boolean isMentionableChannel(long channelId) {
        StoreMessageAck.Ack ack = this.storeMessageAck.getAllInternal().get(Long.valueOf(channelId));
        boolean zIsLockedAck = ack != null ? ack.isLockedAck() : false;
        if (channelId == this.selectedChannelId && !zIsLockedAck) {
            return false;
        }
        return this.privateChannels.contains(Long.valueOf(channelId)) || PermissionUtils.can(Permission.VIEW_CHANNEL, this.storePermissions.getPermissionsByChannel().get(Long.valueOf(channelId)));
    }

    @StoreThread
    private final void removeAllMessagesForChannel(long channelId) {
        HashMap<Long, Message> map = this.mentionedMessages;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Message> entry : map.entrySet()) {
            if (entry.getValue().getChannelId() == channelId) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            this.mentionedMessages.remove(Long.valueOf(((Number) it.next()).longValue()));
            markChanged();
        }
    }

    public final Map<Long, Integer> getMentionCounts() {
        return this.countsSnapshot;
    }

    @StoreThread
    public final void handleChannelOrThreadCreateOrUpdate(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        this.channelGuildIds.put(Long.valueOf(channel.getId()), Long.valueOf(channel.getGuildId()));
        if (!ChannelUtils.m7667B(channel) || ChannelUtils.m7701y(channel)) {
            return;
        }
        this.privateChannels.add(Long.valueOf(channel.getId()));
    }

    @StoreThread
    public final void handleChannelOrThreadDelete(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        this.channelGuildIds.remove(Long.valueOf(channel.getId()));
        this.privateChannels.remove(Long.valueOf(channel.getId()));
        removeAllMessagesForChannel(channel.getId());
    }

    @StoreThread
    public final void handleChannelSelected(long selectedChannelId) {
        this.selectedChannelId = selectedChannelId;
        markChanged();
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        this.privateChannels.clear();
        this.mentionedMessages.clear();
        this.channelGuildIds.clear();
        this.myRoleIds.clear();
        this.myId = payload.getMe().getId();
        for (Guild guild : payload.getGuilds()) {
            C12238m.checkNotNullExpressionValue(guild, "guild");
            handleGuildAdd(guild);
        }
        HashSet<Long> hashSet = this.privateChannels;
        List<Channel> privateChannels = payload.getPrivateChannels();
        ArrayList arrayListM840a0 = C1643a.m840a0(privateChannels, "payload.privateChannels");
        for (Object obj : privateChannels) {
            Channel channel = (Channel) obj;
            C12238m.checkNotNullExpressionValue(channel, "it");
            if (!ChannelUtils.m7701y(channel)) {
                arrayListM840a0.add(obj);
            }
        }
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(arrayListM840a0, 10));
        Iterator it = arrayListM840a0.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((Channel) it.next()).getId()));
        }
        hashSet.addAll(arrayList);
        ModelPayload.VersionedReadStates readState = payload.getReadState();
        C12238m.checkNotNullExpressionValue(readState, "payload.readState");
        if (readState.isPartial()) {
            ModelPayload.VersionedReadStates readState2 = payload.getReadState();
            C12238m.checkNotNullExpressionValue(readState2, "payload.readState");
            List<ModelReadState> entries = readState2.getEntries();
            C12238m.checkNotNullExpressionValue(entries, "payload.readState.entries");
            ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(entries, 10));
            Iterator<T> it2 = entries.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Long.valueOf(((ModelReadState) it2.next()).getChannelId()));
            }
            C12160r.removeAll((List) this.serverInitReadStates, (Function1) new C61923(C12163u.toHashSet(arrayList2)));
        } else {
            this.serverInitReadStates.clear();
        }
        ArrayList<ModelReadState> arrayList3 = this.serverInitReadStates;
        ModelPayload.VersionedReadStates readState3 = payload.getReadState();
        C12238m.checkNotNullExpressionValue(readState3, "payload.readState");
        List<ModelReadState> entries2 = readState3.getEntries();
        C12238m.checkNotNullExpressionValue(entries2, "payload.readState.entries");
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : entries2) {
            if (((ModelReadState) obj2).isMentioned()) {
                arrayList4.add(obj2);
            }
        }
        arrayList3.addAll(arrayList4);
        C12160r.removeAll((List) this.serverInitReadStates, (Function1) new C61935());
        markChanged();
    }

    @StoreThread
    public final void handleGuildAdd(Guild guild) {
        Object next;
        C12238m.checkNotNullParameter(guild, "guild");
        List<GuildMember> listM7875v = guild.m7875v();
        if (listM7875v != null) {
            Iterator<T> it = listM7875v.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((GuildMember) next).getUser().getId() == this.myId));
            GuildMember guildMember = (GuildMember) next;
            if (guildMember != null) {
                this.myRoleIds.put(Long.valueOf(guild.getId()), guildMember.m7926l());
            }
        }
        List<Channel> listM7860g = guild.m7860g();
        if (listM7860g != null) {
            Iterator<T> it2 = listM7860g.iterator();
            while (it2.hasNext()) {
                this.channelGuildIds.put(Long.valueOf(((Channel) it2.next()).getId()), Long.valueOf(guild.getId()));
            }
        }
        List<Channel> listM7849N = guild.m7849N();
        if (listM7849N != null) {
            Iterator<T> it3 = listM7849N.iterator();
            while (it3.hasNext()) {
                this.channelGuildIds.put(Long.valueOf(((Channel) it3.next()).getId()), Long.valueOf(guild.getId()));
            }
        }
    }

    @StoreThread
    public final void handleGuildMemberAdd(GuildMember member) {
        C12238m.checkNotNullParameter(member, "member");
        long id2 = member.getUser().getId();
        if (id2 == this.myId) {
            this.myRoleIds.put(Long.valueOf(id2), member.m7926l());
        }
    }

    @StoreThread
    public final void handleMessageAck(ModelReadState readState) {
        C12238m.checkNotNullParameter(readState, "readState");
        C12160r.removeAll((List) this.serverInitReadStates, (Function1) new C61941(readState));
        this.serverInitReadStates.add(readState);
        markChanged();
    }

    @StoreThread
    public final void handleMessageCreateOrUpdate(com.discord.api.message.Message message) {
        C12238m.checkNotNullParameter(message, "message");
        if (hasMention(message)) {
            this.mentionedMessages.put(Long.valueOf(message.getId()), new Message(message));
            markChanged();
        }
    }

    @StoreThread
    public final void handleMessageDeleted(ModelMessageDelete messageDeleteBulk) {
        C12238m.checkNotNullParameter(messageDeleteBulk, "messageDeleteBulk");
        if (this.privateChannels.contains(Long.valueOf(messageDeleteBulk.getChannelId()))) {
            List<Long> messageIds = messageDeleteBulk.getMessageIds();
            C12238m.checkNotNullExpressionValue(messageIds, "messageDeleteBulk.messageIds");
            for (Long l : messageIds) {
                HashMap<Long, Message> map = this.mentionedMessages;
                C12238m.checkNotNullExpressionValue(l, "it");
                map.remove(l);
            }
            markChanged();
        }
    }

    @StoreThread
    public final void handleThreadListSync(ModelThreadListSync payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        Iterator<Channel> it = payload.getThreads().iterator();
        while (it.hasNext()) {
            this.channelGuildIds.put(Long.valueOf(it.next().getId()), Long.valueOf(payload.getGuildId()));
        }
    }

    @StoreThread
    public final void handleThreadMembersUpdate(ThreadMembersUpdate payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        List<Long> listM8278d = payload.m8278d();
        if (listM8278d == null || !listM8278d.contains(Long.valueOf(this.myId))) {
            return;
        }
        removeAllMessagesForChannel(payload.getId());
    }

    public final Observable<Map<Long, Integer>> observeMentionCounts() {
        Observable<Map<Long, Integer>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C61951(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Integer> observeTotalMentions() {
        Observable observableM11083G = observeMentionCounts().m11083G(new InterfaceC12589b<Map<Long, ? extends Integer>, Integer>() { // from class: com.discord.stores.StoreMentions.observeTotalMentions.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Integer call(Map<Long, ? extends Integer> map) {
                return call2((Map<Long, Integer>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Integer call2(Map<Long, Integer> map) {
                return Integer.valueOf(C12163u.sumOfInt(map.values()));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "observeMentionCounts()\n … .map { it.values.sum() }");
        return observableM11083G;
    }

    @StoreThread
    public final int processMarkUnread$app_productionGoogleRelease(long channelId, List<Message> messagesAfter) {
        C12238m.checkNotNullParameter(messagesAfter, "messagesAfter");
        int i = 0;
        for (Message message : messagesAfter) {
            if (!this.mentionedMessages.containsKey(Long.valueOf(message.getId())) && hasMention(message)) {
                this.mentionedMessages.put(Long.valueOf(message.getId()), message);
                i++;
            }
        }
        C12160r.removeAll((List) this.serverInitReadStates, (Function1) new StoreMentions$processMarkUnread$1(channelId));
        markChanged();
        return i;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        Map<Long, Integer> mapComputeMentionCounts = computeMentionCounts();
        Persister.set$default(this.countsCache, mapComputeMentionCounts, false, 2, null);
        this.countsSnapshot = mapComputeMentionCounts;
    }

    public StoreMentions(StoreUserRelationships storeUserRelationships, StorePermissions storePermissions, StoreMessageAck storeMessageAck, StoreUserGuildSettings storeUserGuildSettings, StoreChannels storeChannels, StoreThreadsJoined storeThreadsJoined, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(storeUserRelationships, "storeUserRelationships");
        C12238m.checkNotNullParameter(storePermissions, "storePermissions");
        C12238m.checkNotNullParameter(storeMessageAck, "storeMessageAck");
        C12238m.checkNotNullParameter(storeUserGuildSettings, "storeUserGuildSettings");
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(storeThreadsJoined, "storeThreadsJoined");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeUserRelationships = storeUserRelationships;
        this.storePermissions = storePermissions;
        this.storeMessageAck = storeMessageAck;
        this.storeUserGuildSettings = storeUserGuildSettings;
        this.storeChannels = storeChannels;
        this.storeThreadsJoined = storeThreadsJoined;
        this.observationDeck = observationDeck;
        HashMap map = new HashMap();
        this.countsEmpty = map;
        this.countsCache = new Persister<>("CHANNEL_MENTION_COUNTS_V6", map);
        this.countsSnapshot = C12136h0.emptyMap();
        this.serverInitReadStates = new ArrayList<>();
        this.mentionedMessages = new HashMap<>();
        this.privateChannels = new HashSet<>();
        this.myRoleIds = new HashMap<>();
        this.channelGuildIds = new HashMap<>();
    }

    @StoreThread
    private final boolean hasMention(Message message) {
        return hasMention(message.getChannelId(), message.getAuthor(), message.getEditedTimestamp(), message.getMentions(), message.getMentionRoles(), message.getMentionEveryone());
    }

    @StoreThread
    private final boolean hasMention(com.discord.api.message.Message message) {
        return hasMention(message.getChannelId(), message.getAuthor(), message.getEditedTimestamp(), message.m8047t(), message.m8046s(), message.getMentionEveryone());
    }
}

package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.emoji.GuildEmojisUpdate;
import com.discord.api.guild.Guild;
import com.discord.api.guildhash.GuildHash;
import com.discord.api.guildhash.GuildHashes;
import com.discord.api.message.Message;
import com.discord.api.sticker.GuildStickersUpdate;
import com.discord.gateway.p498io.OutgoingPayload;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelReadState;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.guildhash.GuildHashUtilsKt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12134g0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreClientDataState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreClientDataState extends StoreV2 {
    private ClientDataState clientDataStateSnapshot;
    private Map<Long, GuildHashes> guildHashes;
    private long highestLastMessageId;
    private final ObservationDeck observationDeck;
    private int readStateVersion;
    private int userGuildSettingsVersion;

    /* JADX INFO: compiled from: StoreClientDataState.kt */
    public static final /* data */ class ClientDataState {
        private final Map<Long, GuildHashes> guildHashes;
        private final long highestLastMessageId;
        private final int readStateVersion;
        private final int userGuildSettingsVersion;

        public ClientDataState() {
            this(null, 0L, 0, 0, 15, null);
        }

        public ClientDataState(Map<Long, GuildHashes> map, long j, int i, int i2) {
            C12238m.checkNotNullParameter(map, "guildHashes");
            this.guildHashes = map;
            this.highestLastMessageId = j;
            this.readStateVersion = i;
            this.userGuildSettingsVersion = i2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ClientDataState copy$default(ClientDataState clientDataState, Map map, long j, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                map = clientDataState.guildHashes;
            }
            if ((i3 & 2) != 0) {
                j = clientDataState.highestLastMessageId;
            }
            long j2 = j;
            if ((i3 & 4) != 0) {
                i = clientDataState.readStateVersion;
            }
            int i4 = i;
            if ((i3 & 8) != 0) {
                i2 = clientDataState.userGuildSettingsVersion;
            }
            return clientDataState.copy(map, j2, i4, i2);
        }

        private final String[] toArray(GuildHashes guildHashes) {
            GuildHash metadata = guildHashes.getMetadata();
            String hash = metadata != null ? metadata.getHash() : null;
            GuildHash channels = guildHashes.getChannels();
            String hash2 = channels != null ? channels.getHash() : null;
            GuildHash roles = guildHashes.getRoles();
            String hash3 = roles != null ? roles.getHash() : null;
            if (hash == null || hash2 == null || hash3 == null) {
                return null;
            }
            return new String[]{hash, hash2, hash3};
        }

        public final Map<Long, GuildHashes> component1() {
            return this.guildHashes;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getHighestLastMessageId() {
            return this.highestLastMessageId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getReadStateVersion() {
            return this.readStateVersion;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getUserGuildSettingsVersion() {
            return this.userGuildSettingsVersion;
        }

        public final ClientDataState copy(Map<Long, GuildHashes> guildHashes, long highestLastMessageId, int readStateVersion, int userGuildSettingsVersion) {
            C12238m.checkNotNullParameter(guildHashes, "guildHashes");
            return new ClientDataState(guildHashes, highestLastMessageId, readStateVersion, userGuildSettingsVersion);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClientDataState)) {
                return false;
            }
            ClientDataState clientDataState = (ClientDataState) other;
            return C12238m.areEqual(this.guildHashes, clientDataState.guildHashes) && this.highestLastMessageId == clientDataState.highestLastMessageId && this.readStateVersion == clientDataState.readStateVersion && this.userGuildSettingsVersion == clientDataState.userGuildSettingsVersion;
        }

        public final Map<Long, GuildHashes> getGuildHashes() {
            return this.guildHashes;
        }

        public final long getHighestLastMessageId() {
            return this.highestLastMessageId;
        }

        public final int getReadStateVersion() {
            return this.readStateVersion;
        }

        public final int getUserGuildSettingsVersion() {
            return this.userGuildSettingsVersion;
        }

        public int hashCode() {
            Map<Long, GuildHashes> map = this.guildHashes;
            return ((((C0002b.m3a(this.highestLastMessageId) + ((map != null ? map.hashCode() : 0) * 31)) * 31) + this.readStateVersion) * 31) + this.userGuildSettingsVersion;
        }

        public final OutgoingPayload.IdentifyClientState toIdentifyData() {
            Map<Long, GuildHashes> map = this.guildHashes;
            LinkedHashMap linkedHashMap = new LinkedHashMap(C12134g0.mapCapacity(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), toArray((GuildHashes) entry.getValue()));
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                if (entry2.getValue() != null) {
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(C12134g0.mapCapacity(linkedHashMap2.size()));
            for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                Object key = entry3.getKey();
                Object value = entry3.getValue();
                C12238m.checkNotNull(value);
                linkedHashMap3.put(key, (String[]) value);
            }
            return new OutgoingPayload.IdentifyClientState(linkedHashMap3, this.highestLastMessageId, this.readStateVersion, this.userGuildSettingsVersion);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ClientDataState(guildHashes=");
            sbM833U.append(this.guildHashes);
            sbM833U.append(", highestLastMessageId=");
            sbM833U.append(this.highestLastMessageId);
            sbM833U.append(", readStateVersion=");
            sbM833U.append(this.readStateVersion);
            sbM833U.append(", userGuildSettingsVersion=");
            return C1643a.m814B(sbM833U, this.userGuildSettingsVersion, ")");
        }

        public /* synthetic */ ClientDataState(Map map, long j, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new HashMap() : map, (i3 & 2) != 0 ? 0L : j, (i3 & 4) != 0 ? -1 : i, (i3 & 8) != 0 ? -1 : i2);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreClientDataState$observeClientState$1 */
    /* JADX INFO: compiled from: StoreClientDataState.kt */
    public static final class C58461 extends AbstractC12240o implements Function0<ClientDataState> {
        public C58461() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ClientDataState invoke() {
            return StoreClientDataState.this.clientDataStateSnapshot;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreClientDataState() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ StoreClientDataState(ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    @StoreThread
    private final void updateGuildHash(Guild guild) {
        GuildHashes guildHashes;
        if (guild.getUnavailable() || (guildHashes = guild.getGuildHashes()) == null || !GuildHashUtilsKt.isSupported(guildHashes)) {
            this.guildHashes.remove(Long.valueOf(guild.getId()));
            return;
        }
        Map<Long, GuildHashes> map = this.guildHashes;
        Long lValueOf = Long.valueOf(guild.getId());
        GuildHashes guildHashes2 = guild.getGuildHashes();
        C12238m.checkNotNull(guildHashes2);
        map.put(lValueOf, guildHashes2);
    }

    @StoreThread
    private final void updateHighestLastMessageId(long newMessageId) {
        if (newMessageId > this.highestLastMessageId) {
            this.highestLastMessageId = newMessageId;
        }
    }

    @StoreThread
    public final void clear() {
        this.guildHashes.clear();
        this.highestLastMessageId = 0L;
        this.readStateVersion = 0;
        this.userGuildSettingsVersion = -1;
        markChanged();
    }

    @StoreThread
    public final void handleChannelCreateOrUpdateOrDelete(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        GuildHashes guildHashes = channel.getGuildHashes();
        if (guildHashes == null || !GuildHashUtilsKt.isSupported(guildHashes)) {
            return;
        }
        Map<Long, GuildHashes> map = this.guildHashes;
        Long lValueOf = Long.valueOf(channel.getGuildId());
        GuildHashes guildHashes2 = channel.getGuildHashes();
        C12238m.checkNotNull(guildHashes2);
        map.put(lValueOf, guildHashes2);
        markChanged();
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        clear();
        for (Guild guild : payload.getGuilds()) {
            C12238m.checkNotNullExpressionValue(guild, "guild");
            updateGuildHash(guild);
            List<Channel> listM7860g = guild.m7860g();
            if (listM7860g != null) {
                Iterator<T> it = listM7860g.iterator();
                while (it.hasNext()) {
                    updateHighestLastMessageId(((Channel) it.next()).getLastMessageId());
                }
            }
        }
        Iterator<Channel> it2 = payload.getPrivateChannels().iterator();
        while (it2.hasNext()) {
            updateHighestLastMessageId(it2.next().getLastMessageId());
        }
        ModelPayload.VersionedReadStates readState = payload.getReadState();
        C12238m.checkNotNullExpressionValue(readState, "payload.readState");
        this.readStateVersion = readState.getVersion();
        ModelPayload.VersionedUserGuildSettings userGuildSettings = payload.getUserGuildSettings();
        C12238m.checkNotNullExpressionValue(userGuildSettings, "payload.userGuildSettings");
        this.userGuildSettingsVersion = userGuildSettings.getVersion();
        markChanged();
    }

    @StoreThread
    public final void handleEmojiUpdate(GuildEmojisUpdate payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        if (GuildHashUtilsKt.isSupported(payload.getGuildHashes())) {
            this.guildHashes.put(Long.valueOf(payload.getGuildId()), payload.getGuildHashes());
            markChanged();
        }
    }

    @StoreThread
    public final void handleGuildAdd(Guild guild) {
        C12238m.checkNotNullParameter(guild, "guild");
        updateGuildHash(guild);
        markChanged();
    }

    @StoreThread
    public final void handleGuildRemove(Guild guild) {
        C12238m.checkNotNullParameter(guild, "guild");
        this.guildHashes.remove(Long.valueOf(guild.getId()));
        markChanged();
    }

    @StoreThread
    public final void handleGuildSettingUpdated(ModelNotificationSettings userGuildSettings) {
        C12238m.checkNotNullParameter(userGuildSettings, "userGuildSettings");
        if (userGuildSettings.getVersion() > this.userGuildSettingsVersion) {
            this.userGuildSettingsVersion = userGuildSettings.getVersion();
            markChanged();
        }
    }

    @StoreThread
    public final void handleMessageAck(ModelReadState readState) {
        C12238m.checkNotNullParameter(readState, "readState");
        if (readState.getVersion() > this.readStateVersion) {
            this.readStateVersion = readState.getVersion();
            markChanged();
        }
    }

    @StoreThread
    public final void handleMessageCreate(Message message) {
        C12238m.checkNotNullParameter(message, "message");
        updateHighestLastMessageId(message.getId());
        markChanged();
    }

    @StoreThread
    public final void handleRoleAddOrRemove(long guildId, GuildHashes guildHashes) {
        if (guildHashes == null || !GuildHashUtilsKt.isSupported(guildHashes)) {
            return;
        }
        this.guildHashes.put(Long.valueOf(guildId), guildHashes);
        markChanged();
    }

    @StoreThread
    public final void handleStickersUpdate(GuildStickersUpdate payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        if (GuildHashUtilsKt.isSupported(payload.getGuildHashes())) {
            this.guildHashes.put(Long.valueOf(payload.getGuildId()), payload.getGuildHashes());
            markChanged();
        }
    }

    public final Observable<ClientDataState> observeClientState() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C58461(), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.clientDataStateSnapshot = new ClientDataState(this.guildHashes, this.highestLastMessageId, this.readStateVersion, this.userGuildSettingsVersion);
    }

    public StoreClientDataState(ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        this.guildHashes = new HashMap();
        this.readStateVersion = -1;
        this.userGuildSettingsVersion = -1;
        this.clientDataStateSnapshot = new ClientDataState(null, 0L, 0, 0, 15, null);
    }
}

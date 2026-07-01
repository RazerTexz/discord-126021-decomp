package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.emoji.GuildEmojisUpdate;
import com.discord.api.guild.Guild;
import com.discord.api.guildhash.GuildHash;
import com.discord.api.guildhash.GuildHashes;
import com.discord.api.message.Message;
import com.discord.api.sticker.GuildStickersUpdate;
import com.discord.gateway.io.Outgoing2;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelReadState;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.guildhash.GuildHashUtils;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

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
            Intrinsics3.checkNotNullParameter(map, "guildHashes");
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
            Intrinsics3.checkNotNullParameter(guildHashes, "guildHashes");
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
            return Intrinsics3.areEqual(this.guildHashes, clientDataState.guildHashes) && this.highestLastMessageId == clientDataState.highestLastMessageId && this.readStateVersion == clientDataState.readStateVersion && this.userGuildSettingsVersion == clientDataState.userGuildSettingsVersion;
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
            return ((((b.a(this.highestLastMessageId) + ((map != null ? map.hashCode() : 0) * 31)) * 31) + this.readStateVersion) * 31) + this.userGuildSettingsVersion;
        }

        public final Outgoing2.IdentifyClientState toIdentifyData() {
            Map<Long, GuildHashes> map = this.guildHashes;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(map.size()));
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
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsJVM.mapCapacity(linkedHashMap2.size()));
            for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                Object key = entry3.getKey();
                Object value = entry3.getValue();
                Intrinsics3.checkNotNull(value);
                linkedHashMap3.put(key, (String[]) value);
            }
            return new Outgoing2.IdentifyClientState(linkedHashMap3, this.highestLastMessageId, this.readStateVersion, this.userGuildSettingsVersion);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ClientDataState(guildHashes=");
            sbU.append(this.guildHashes);
            sbU.append(", highestLastMessageId=");
            sbU.append(this.highestLastMessageId);
            sbU.append(", readStateVersion=");
            sbU.append(this.readStateVersion);
            sbU.append(", userGuildSettingsVersion=");
            return outline.B(sbU, this.userGuildSettingsVersion, ")");
        }

        public /* synthetic */ ClientDataState(Map map, long j, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new HashMap() : map, (i3 & 2) != 0 ? 0L : j, (i3 & 4) != 0 ? -1 : i, (i3 & 8) != 0 ? -1 : i2);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreClientDataState$observeClientState$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreClientDataState.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<ClientDataState> {
        public AnonymousClass1() {
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
        this((i & 1) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    @Store3
    private final void updateGuildHash(Guild guild) {
        GuildHashes guildHashes;
        if (guild.getUnavailable() || (guildHashes = guild.getGuildHashes()) == null || !GuildHashUtils.isSupported(guildHashes)) {
            this.guildHashes.remove(Long.valueOf(guild.getId()));
            return;
        }
        Map<Long, GuildHashes> map = this.guildHashes;
        Long lValueOf = Long.valueOf(guild.getId());
        GuildHashes guildHashes2 = guild.getGuildHashes();
        Intrinsics3.checkNotNull(guildHashes2);
        map.put(lValueOf, guildHashes2);
    }

    @Store3
    private final void updateHighestLastMessageId(long newMessageId) {
        if (newMessageId > this.highestLastMessageId) {
            this.highestLastMessageId = newMessageId;
        }
    }

    @Store3
    public final void clear() {
        this.guildHashes.clear();
        this.highestLastMessageId = 0L;
        this.readStateVersion = 0;
        this.userGuildSettingsVersion = -1;
        markChanged();
    }

    @Store3
    public final void handleChannelCreateOrUpdateOrDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        GuildHashes guildHashes = channel.getGuildHashes();
        if (guildHashes == null || !GuildHashUtils.isSupported(guildHashes)) {
            return;
        }
        Map<Long, GuildHashes> map = this.guildHashes;
        Long lValueOf = Long.valueOf(channel.getGuildId());
        GuildHashes guildHashes2 = channel.getGuildHashes();
        Intrinsics3.checkNotNull(guildHashes2);
        map.put(lValueOf, guildHashes2);
        markChanged();
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        clear();
        for (Guild guild : payload.getGuilds()) {
            Intrinsics3.checkNotNullExpressionValue(guild, "guild");
            updateGuildHash(guild);
            List<Channel> listG = guild.g();
            if (listG != null) {
                Iterator<T> it = listG.iterator();
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
        Intrinsics3.checkNotNullExpressionValue(readState, "payload.readState");
        this.readStateVersion = readState.getVersion();
        ModelPayload.VersionedUserGuildSettings userGuildSettings = payload.getUserGuildSettings();
        Intrinsics3.checkNotNullExpressionValue(userGuildSettings, "payload.userGuildSettings");
        this.userGuildSettingsVersion = userGuildSettings.getVersion();
        markChanged();
    }

    @Store3
    public final void handleEmojiUpdate(GuildEmojisUpdate payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        if (GuildHashUtils.isSupported(payload.getGuildHashes())) {
            this.guildHashes.put(Long.valueOf(payload.getGuildId()), payload.getGuildHashes());
            markChanged();
        }
    }

    @Store3
    public final void handleGuildAdd(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        updateGuildHash(guild);
        markChanged();
    }

    @Store3
    public final void handleGuildRemove(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        this.guildHashes.remove(Long.valueOf(guild.getId()));
        markChanged();
    }

    @Store3
    public final void handleGuildSettingUpdated(ModelNotificationSettings userGuildSettings) {
        Intrinsics3.checkNotNullParameter(userGuildSettings, "userGuildSettings");
        if (userGuildSettings.getVersion() > this.userGuildSettingsVersion) {
            this.userGuildSettingsVersion = userGuildSettings.getVersion();
            markChanged();
        }
    }

    @Store3
    public final void handleMessageAck(ModelReadState readState) {
        Intrinsics3.checkNotNullParameter(readState, "readState");
        if (readState.getVersion() > this.readStateVersion) {
            this.readStateVersion = readState.getVersion();
            markChanged();
        }
    }

    @Store3
    public final void handleMessageCreate(Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        updateHighestLastMessageId(message.getId());
        markChanged();
    }

    @Store3
    public final void handleRoleAddOrRemove(long guildId, GuildHashes guildHashes) {
        if (guildHashes == null || !GuildHashUtils.isSupported(guildHashes)) {
            return;
        }
        this.guildHashes.put(Long.valueOf(guildId), guildHashes);
        markChanged();
    }

    @Store3
    public final void handleStickersUpdate(GuildStickersUpdate payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        if (GuildHashUtils.isSupported(payload.getGuildHashes())) {
            this.guildHashes.put(Long.valueOf(payload.getGuildId()), payload.getGuildHashes());
            markChanged();
        }
    }

    public final Observable<ClientDataState> observeClientState() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.clientDataStateSnapshot = new ClientDataState(this.guildHashes, this.highestLastMessageId, this.readStateVersion, this.userGuildSettingsVersion);
    }

    public StoreClientDataState(ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        this.guildHashes = new HashMap();
        this.readStateVersion = -1;
        this.userGuildSettingsVersion = -1;
        this.clientDataStateSnapshot = new ClientDataState(null, 0L, 0, 0, 15, null);
    }
}

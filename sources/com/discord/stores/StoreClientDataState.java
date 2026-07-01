package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.emoji.GuildEmojisUpdate;
import com.discord.api.guild.Guild;
import com.discord.api.guildhash.GuildHashes;
import com.discord.api.message.Message;
import com.discord.api.sticker.GuildStickersUpdate;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelPayload$VersionedReadStates;
import com.discord.models.domain.ModelPayload$VersionedUserGuildSettings;
import com.discord.models.domain.ModelReadState;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.guildhash.GuildHashUtilsKt;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreClientDataState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreClientDataState extends StoreV2 {
    private StoreClientDataState$ClientDataState clientDataStateSnapshot;
    private Map<Long, GuildHashes> guildHashes;
    private long highestLastMessageId;
    private final ObservationDeck observationDeck;
    private int readStateVersion;
    private int userGuildSettingsVersion;

    public StoreClientDataState() {
        this(null, 1, null);
    }

    public /* synthetic */ StoreClientDataState(ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ StoreClientDataState$ClientDataState access$getClientDataStateSnapshot$p(StoreClientDataState storeClientDataState) {
        return storeClientDataState.clientDataStateSnapshot;
    }

    public static final /* synthetic */ void access$setClientDataStateSnapshot$p(StoreClientDataState storeClientDataState, StoreClientDataState$ClientDataState storeClientDataState$ClientDataState) {
        storeClientDataState.clientDataStateSnapshot = storeClientDataState$ClientDataState;
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
        m.checkNotNull(guildHashes2);
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
        m.checkNotNullParameter(channel, "channel");
        GuildHashes guildHashes = channel.getGuildHashes();
        if (guildHashes == null || !GuildHashUtilsKt.isSupported(guildHashes)) {
            return;
        }
        Map<Long, GuildHashes> map = this.guildHashes;
        Long lValueOf = Long.valueOf(channel.getGuildId());
        GuildHashes guildHashes2 = channel.getGuildHashes();
        m.checkNotNull(guildHashes2);
        map.put(lValueOf, guildHashes2);
        markChanged();
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        clear();
        for (Guild guild : payload.getGuilds()) {
            m.checkNotNullExpressionValue(guild, "guild");
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
        ModelPayload$VersionedReadStates readState = payload.getReadState();
        m.checkNotNullExpressionValue(readState, "payload.readState");
        this.readStateVersion = readState.getVersion();
        ModelPayload$VersionedUserGuildSettings userGuildSettings = payload.getUserGuildSettings();
        m.checkNotNullExpressionValue(userGuildSettings, "payload.userGuildSettings");
        this.userGuildSettingsVersion = userGuildSettings.getVersion();
        markChanged();
    }

    @StoreThread
    public final void handleEmojiUpdate(GuildEmojisUpdate payload) {
        m.checkNotNullParameter(payload, "payload");
        if (GuildHashUtilsKt.isSupported(payload.getGuildHashes())) {
            this.guildHashes.put(Long.valueOf(payload.getGuildId()), payload.getGuildHashes());
            markChanged();
        }
    }

    @StoreThread
    public final void handleGuildAdd(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        updateGuildHash(guild);
        markChanged();
    }

    @StoreThread
    public final void handleGuildRemove(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        this.guildHashes.remove(Long.valueOf(guild.getId()));
        markChanged();
    }

    @StoreThread
    public final void handleGuildSettingUpdated(ModelNotificationSettings userGuildSettings) {
        m.checkNotNullParameter(userGuildSettings, "userGuildSettings");
        if (userGuildSettings.getVersion() > this.userGuildSettingsVersion) {
            this.userGuildSettingsVersion = userGuildSettings.getVersion();
            markChanged();
        }
    }

    @StoreThread
    public final void handleMessageAck(ModelReadState readState) {
        m.checkNotNullParameter(readState, "readState");
        if (readState.getVersion() > this.readStateVersion) {
            this.readStateVersion = readState.getVersion();
            markChanged();
        }
    }

    @StoreThread
    public final void handleMessageCreate(Message message) {
        m.checkNotNullParameter(message, "message");
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
        m.checkNotNullParameter(payload, "payload");
        if (GuildHashUtilsKt.isSupported(payload.getGuildHashes())) {
            this.guildHashes.put(Long.valueOf(payload.getGuildId()), payload.getGuildHashes());
            markChanged();
        }
    }

    public final Observable<StoreClientDataState$ClientDataState> observeClientState() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreClientDataState$observeClientState$1(this), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.clientDataStateSnapshot = new StoreClientDataState$ClientDataState(this.guildHashes, this.highestLastMessageId, this.readStateVersion, this.userGuildSettingsVersion);
    }

    public StoreClientDataState(ObservationDeck observationDeck) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        this.guildHashes = new HashMap();
        this.readStateVersion = -1;
        this.userGuildSettingsVersion = -1;
        this.clientDataStateSnapshot = new StoreClientDataState$ClientDataState(null, 0L, 0, 0, 15, null);
    }
}

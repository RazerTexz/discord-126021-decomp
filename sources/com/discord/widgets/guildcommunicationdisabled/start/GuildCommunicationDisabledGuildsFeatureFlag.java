package com.discord.widgets.guildcommunicationdisabled.start;

import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GuildCommunicationDisabledGuildsFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildCommunicationDisabledGuildsFeatureFlag {
    public static final GuildCommunicationDisabledGuildsFeatureFlag$Companion Companion = new GuildCommunicationDisabledGuildsFeatureFlag$Companion(null);
    private static final Lazy INSTANCE$delegate = g.lazy(GuildCommunicationDisabledGuildsFeatureFlag$Companion$INSTANCE$2.INSTANCE);
    private final StoreGuilds guildsStore;
    private final ObservationDeck observationDeck;
    private final StoreExperiments storeExperiments;

    public GuildCommunicationDisabledGuildsFeatureFlag() {
        this(null, null, null, 7, null);
    }

    public GuildCommunicationDisabledGuildsFeatureFlag(StoreGuilds storeGuilds, StoreExperiments storeExperiments, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.guildsStore = storeGuilds;
        this.storeExperiments = storeExperiments;
        this.observationDeck = observationDeck;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public final boolean canGuildAccessCommunicationDisabled(long guildId) {
        Experiment guildExperiment;
        return (this.guildsStore.getGuild(guildId) == null || (guildExperiment = this.storeExperiments.getGuildExperiment("2021-11_guild_communication_disabled_guilds", guildId, true)) == null || guildExperiment.getBucket() != 1) ? false : true;
    }

    public final boolean canUserAccessDisableCommunication() {
        Experiment userExperiment = this.storeExperiments.getUserExperiment("2021-11_guild_communication_disabled_users", true);
        return userExperiment != null && userExperiment.getBucket() == 1;
    }

    public final Observable<Boolean> observeCanGuildAccessCommunicationDisabled(long guildId) {
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this.guildsStore, this.storeExperiments}, false, null, null, new GuildCommunicationDisabledGuildsFeatureFlag$observeCanGuildAccessCommunicationDisabled$1(this, guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ GuildCommunicationDisabledGuildsFeatureFlag(StoreGuilds storeGuilds, StoreExperiments storeExperiments, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 2) != 0 ? StoreStream.Companion.getExperiments() : storeExperiments, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }
}

package com.discord.widgets.guildcommunicationdisabled.start;

import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GuildCommunicationDisabledGuildsFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildCommunicationDisabledGuildsFeatureFlag {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(GuildCommunicationDisabledGuildsFeatureFlag2.INSTANCE);
    private final StoreGuilds guildsStore;
    private final ObservationDeck observationDeck;
    private final StoreExperiments storeExperiments;

    /* JADX INFO: compiled from: GuildCommunicationDisabledGuildsFeatureFlag.kt */
    public static final class Companion {
        private Companion() {
        }

        public final GuildCommunicationDisabledGuildsFeatureFlag getINSTANCE() {
            Lazy lazy = GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE$delegate;
            Companion companion = GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE;
            return (GuildCommunicationDisabledGuildsFeatureFlag) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildcommunicationdisabled.start.GuildCommunicationDisabledGuildsFeatureFlag$observeCanGuildAccessCommunicationDisabled$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildCommunicationDisabledGuildsFeatureFlag.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return GuildCommunicationDisabledGuildsFeatureFlag.this.canGuildAccessCommunicationDisabled(this.$guildId) && GuildCommunicationDisabledGuildsFeatureFlag.this.canUserAccessDisableCommunication();
        }
    }

    public GuildCommunicationDisabledGuildsFeatureFlag() {
        this(null, null, null, 7, null);
    }

    public GuildCommunicationDisabledGuildsFeatureFlag(StoreGuilds storeGuilds, StoreExperiments storeExperiments, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.guildsStore = storeGuilds;
        this.storeExperiments = storeExperiments;
        this.observationDeck = observationDeck;
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
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.guildsStore, this.storeExperiments}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ GuildCommunicationDisabledGuildsFeatureFlag(StoreGuilds storeGuilds, StoreExperiments storeExperiments, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 2) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck);
    }
}

package com.discord.widgets.guildcommunicationdisabled.start;

import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

/* JADX INFO: compiled from: GuildCommunicationDisabledGuildsFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildCommunicationDisabledGuildsFeatureFlag {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = C12083g.lazy(GuildCommunicationDisabledGuildsFeatureFlag$Companion$INSTANCE$2.INSTANCE);
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

    /* JADX INFO: renamed from: com.discord.widgets.guildcommunicationdisabled.start.GuildCommunicationDisabledGuildsFeatureFlag$observeCanGuildAccessCommunicationDisabled$1 */
    /* JADX INFO: compiled from: GuildCommunicationDisabledGuildsFeatureFlag.kt */
    public static final class C85581 extends AbstractC12240o implements Function0<Boolean> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C85581(long j) {
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
        C12238m.checkNotNullParameter(storeGuilds, "guildsStore");
        C12238m.checkNotNullParameter(storeExperiments, "storeExperiments");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
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
        Observable<Boolean> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.guildsStore, this.storeExperiments}, false, null, null, new C85581(guildId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public /* synthetic */ GuildCommunicationDisabledGuildsFeatureFlag(StoreGuilds storeGuilds, StoreExperiments storeExperiments, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 2) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }
}

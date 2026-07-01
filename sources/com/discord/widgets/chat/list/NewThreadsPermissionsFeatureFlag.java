package com.discord.widgets.chat.list;

import com.discord.api.guild.GuildFeature;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: NewThreadsPermissionsFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NewThreadsPermissionsFeatureFlag {
    public static final NewThreadsPermissionsFeatureFlag$Companion Companion = new NewThreadsPermissionsFeatureFlag$Companion(null);
    private static final Lazy INSTANCE$delegate = g.lazy(NewThreadsPermissionsFeatureFlag$Companion$INSTANCE$2.INSTANCE);
    private final StoreExperiments storeExperiments;
    private final StoreGuilds storeGuilds;

    public NewThreadsPermissionsFeatureFlag() {
        this(null, null, 3, null);
    }

    public NewThreadsPermissionsFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        this.storeExperiments = storeExperiments;
        this.storeGuilds = storeGuilds;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public static final /* synthetic */ boolean access$isEnabled(NewThreadsPermissionsFeatureFlag newThreadsPermissionsFeatureFlag, Experiment experiment, Guild guild) {
        return newThreadsPermissionsFeatureFlag.isEnabled(experiment, guild);
    }

    public final boolean isEnabled(long guildId) {
        return isEnabled(this.storeExperiments.getGuildExperiment("2021-08_threads_permissions", guildId, true), this.storeGuilds.getGuild(guildId));
    }

    public final Observable<Boolean> observeEnabled(long guildId) {
        Observable<Boolean> observableJ = Observable.j(this.storeExperiments.observeGuildExperiment("2021-08_threads_permissions", guildId, true), this.storeGuilds.observeGuild(guildId), new NewThreadsPermissionsFeatureFlag$observeEnabled$1(this));
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…dExperiment, guild)\n    }");
        return observableJ;
    }

    public /* synthetic */ NewThreadsPermissionsFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getExperiments() : storeExperiments, (i & 2) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds);
    }

    private final boolean isEnabled(Experiment experiment, Guild guild) {
        return (experiment != null && experiment.getBucket() == 1) || (guild != null && guild.hasFeature(GuildFeature.NEW_THREAD_PERMISSIONS));
    }
}

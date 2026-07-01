package com.discord.widgets.chat.list;

import com.discord.api.guild.GuildFeature;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;

/* JADX INFO: compiled from: NewThreadsPermissionsFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NewThreadsPermissionsFeatureFlag {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(NewThreadsPermissionsFeatureFlag2.INSTANCE);
    private final StoreExperiments storeExperiments;
    private final StoreGuilds storeGuilds;

    /* JADX INFO: compiled from: NewThreadsPermissionsFeatureFlag.kt */
    public static final class Companion {
        private Companion() {
        }

        public final NewThreadsPermissionsFeatureFlag getINSTANCE() {
            Lazy lazy = NewThreadsPermissionsFeatureFlag.INSTANCE$delegate;
            Companion companion = NewThreadsPermissionsFeatureFlag.INSTANCE;
            return (NewThreadsPermissionsFeatureFlag) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NewThreadsPermissionsFeatureFlag() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public NewThreadsPermissionsFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        this.storeExperiments = storeExperiments;
        this.storeGuilds = storeGuilds;
    }

    public final boolean isEnabled(long guildId) {
        return isEnabled(this.storeExperiments.getGuildExperiment("2021-08_threads_permissions", guildId, true), this.storeGuilds.getGuild(guildId));
    }

    public final Observable<Boolean> observeEnabled(long guildId) {
        Observable<Boolean> observableJ = Observable.j(this.storeExperiments.observeGuildExperiment("2021-08_threads_permissions", guildId, true), this.storeGuilds.observeGuild(guildId), new Func2<Experiment, Guild, Boolean>() { // from class: com.discord.widgets.chat.list.NewThreadsPermissionsFeatureFlag.observeEnabled.1
            @Override // rx.functions.Func2
            public final Boolean call(Experiment experiment, Guild guild) {
                return Boolean.valueOf(NewThreadsPermissionsFeatureFlag.this.isEnabled(experiment, guild));
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…dExperiment, guild)\n    }");
        return observableJ;
    }

    public /* synthetic */ NewThreadsPermissionsFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds);
    }

    private final boolean isEnabled(Experiment experiment, Guild guild) {
        return (experiment != null && experiment.getBucket() == 1) || (guild != null && guild.hasFeature(GuildFeature.NEW_THREAD_PERMISSIONS));
    }
}

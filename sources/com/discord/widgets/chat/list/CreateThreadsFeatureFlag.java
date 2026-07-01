package com.discord.widgets.chat.list;

import com.discord.api.guild.GuildFeature;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func3;

/* JADX INFO: compiled from: CreateThreadsFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CreateThreadsFeatureFlag {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(CreateThreadsFeatureFlag2.INSTANCE);
    private final StoreExperiments storeExperiments;
    private final StoreGuilds storeGuilds;

    /* JADX INFO: compiled from: CreateThreadsFeatureFlag.kt */
    public static final class Companion {
        private Companion() {
        }

        public final boolean computeIsEnabled(Experiment createExperiment, Experiment rolloutExperiment, Guild guild) {
            if (guild == null) {
                return false;
            }
            if (guild.hasFeature(GuildFeature.THREADS_ENABLED)) {
                return true;
            }
            return ((rolloutExperiment != null && rolloutExperiment.getBucket() == 2) || !guild.hasFeature(GuildFeature.COMMUNITY)) && createExperiment != null && createExperiment.getBucket() == 1;
        }

        public final CreateThreadsFeatureFlag getINSTANCE() {
            Lazy lazy = CreateThreadsFeatureFlag.INSTANCE$delegate;
            Companion companion = CreateThreadsFeatureFlag.INSTANCE;
            return (CreateThreadsFeatureFlag) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.CreateThreadsFeatureFlag$observeEnabled$1, reason: invalid class name */
    /* JADX INFO: compiled from: CreateThreadsFeatureFlag.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<Experiment, Experiment, Guild, Boolean> {
        public AnonymousClass1(Companion companion) {
            super(3, companion, Companion.class, "computeIsEnabled", "computeIsEnabled(Lcom/discord/models/experiments/domain/Experiment;Lcom/discord/models/experiments/domain/Experiment;Lcom/discord/models/guild/Guild;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Boolean invoke(Experiment experiment, Experiment experiment2, Guild guild) {
            return Boolean.valueOf(invoke2(experiment, experiment2, guild));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Experiment experiment, Experiment experiment2, Guild guild) {
            return ((Companion) this.receiver).computeIsEnabled(experiment, experiment2, guild);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreateThreadsFeatureFlag() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public CreateThreadsFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        this.storeExperiments = storeExperiments;
        this.storeGuilds = storeGuilds;
    }

    public final boolean isEnabled(long guildId) {
        return INSTANCE.computeIsEnabled(this.storeExperiments.getGuildExperiment("2020-09_threads", guildId, true), this.storeExperiments.getGuildExperiment("2021-06_threads_rollout", guildId, false), this.storeGuilds.getGuild(guildId));
    }

    public final Observable<Boolean> observeEnabled(long guildId) {
        Observable<Experiment> observableObserveGuildExperiment = this.storeExperiments.observeGuildExperiment("2020-09_threads", guildId, true);
        Observable<Experiment> observableObserveGuildExperiment2 = this.storeExperiments.observeGuildExperiment("2021-06_threads_rollout", guildId, false);
        Observable<Guild> observableObserveGuild = this.storeGuilds.observeGuild(guildId);
        final AnonymousClass1 anonymousClass1 = new AnonymousClass1(INSTANCE);
        Observable<Boolean> observableI = Observable.i(observableObserveGuildExperiment, observableObserveGuildExperiment2, observableObserveGuild, new Func3() { // from class: com.discord.widgets.chat.list.CreateThreadsFeatureFlag$sam$rx_functions_Func3$0
            @Override // rx.functions.Func3
            public final /* synthetic */ Object call(Object obj, Object obj2, Object obj3) {
                return anonymousClass1.invoke(obj, obj2, obj3);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest… ::computeIsEnabled\n    )");
        return observableI;
    }

    public /* synthetic */ CreateThreadsFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds);
    }
}

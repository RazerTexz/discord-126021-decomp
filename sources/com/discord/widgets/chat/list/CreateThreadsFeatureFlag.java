package com.discord.widgets.chat.list;

import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: CreateThreadsFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CreateThreadsFeatureFlag {
    public static final CreateThreadsFeatureFlag$Companion Companion = new CreateThreadsFeatureFlag$Companion(null);
    private static final Lazy INSTANCE$delegate = g.lazy(CreateThreadsFeatureFlag$Companion$INSTANCE$2.INSTANCE);
    private final StoreExperiments storeExperiments;
    private final StoreGuilds storeGuilds;

    public CreateThreadsFeatureFlag() {
        this(null, null, 3, null);
    }

    public CreateThreadsFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        this.storeExperiments = storeExperiments;
        this.storeGuilds = storeGuilds;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public final boolean isEnabled(long guildId) {
        return Companion.computeIsEnabled(this.storeExperiments.getGuildExperiment("2020-09_threads", guildId, true), this.storeExperiments.getGuildExperiment("2021-06_threads_rollout", guildId, false), this.storeGuilds.getGuild(guildId));
    }

    public final Observable<Boolean> observeEnabled(long guildId) {
        Observable<Boolean> observableI = Observable.i(this.storeExperiments.observeGuildExperiment("2020-09_threads", guildId, true), this.storeExperiments.observeGuildExperiment("2021-06_threads_rollout", guildId, false), this.storeGuilds.observeGuild(guildId), new CreateThreadsFeatureFlag$sam$rx_functions_Func3$0(new CreateThreadsFeatureFlag$observeEnabled$1(Companion)));
        m.checkNotNullExpressionValue(observableI, "Observable.combineLatest… ::computeIsEnabled\n    )");
        return observableI;
    }

    public /* synthetic */ CreateThreadsFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getExperiments() : storeExperiments, (i & 2) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds);
    }
}

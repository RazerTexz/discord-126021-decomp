package com.discord.widgets.chat.list;

import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ViewThreadsFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewThreadsFeatureFlag {
    public static final ViewThreadsFeatureFlag$Companion Companion = new ViewThreadsFeatureFlag$Companion(null);
    private static final Lazy INSTANCE$delegate = g.lazy(ViewThreadsFeatureFlag$Companion$INSTANCE$2.INSTANCE);
    private final StoreExperiments storeExperiments;

    public ViewThreadsFeatureFlag() {
        this(null, 1, null);
    }

    public ViewThreadsFeatureFlag(StoreExperiments storeExperiments) {
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        this.storeExperiments = storeExperiments;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public final boolean isEnabled() {
        Experiment userExperiment = this.storeExperiments.getUserExperiment("2021-02_view_threads", true);
        return userExperiment != null && userExperiment.getBucket() == 1;
    }

    public /* synthetic */ ViewThreadsFeatureFlag(StoreExperiments storeExperiments, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getExperiments() : storeExperiments);
    }
}

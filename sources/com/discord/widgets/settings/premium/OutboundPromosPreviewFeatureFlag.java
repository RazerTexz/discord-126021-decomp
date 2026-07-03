package com.discord.widgets.settings.premium;

import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: OutboundPromosPreviewFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OutboundPromosPreviewFeatureFlag {
    private final StoreExperiments storeExperiments;

    public OutboundPromosPreviewFeatureFlag(StoreExperiments storeExperiments) {
        C12238m.checkNotNullParameter(storeExperiments, "storeExperiments");
        this.storeExperiments = storeExperiments;
    }

    public final boolean isEnabled() {
        Experiment userExperiment = this.storeExperiments.getUserExperiment("2021-06_preview_promotions", true);
        return userExperiment != null && userExperiment.getBucket() == 1;
    }
}

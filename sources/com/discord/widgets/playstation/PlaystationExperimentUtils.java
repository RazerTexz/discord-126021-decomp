package com.discord.widgets.playstation;

import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.playstation.PlaystationExperimentUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: PlaystationExperimentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PlaystationExperimentUtils {
    public static final boolean canSeePlaystationAccountIntegration(StoreExperiments storeExperiments) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "experimentStore");
        Integer experimentBucket = getExperimentBucket(storeExperiments);
        if (experimentBucket != null && experimentBucket.intValue() == 1) {
            return true;
        }
        return experimentBucket != null && experimentBucket.intValue() == 2;
    }

    public static final boolean canSeePlaystationUpsells(StoreExperiments storeExperiments) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "experimentStore");
        Integer experimentBucket = getExperimentBucket(storeExperiments);
        return experimentBucket != null && experimentBucket.intValue() == 1;
    }

    private static final Integer getExperimentBucket(StoreExperiments storeExperiments) {
        Experiment userExperiment = storeExperiments.getUserExperiment("2021-12_connected_accounts_playstation", true);
        if (userExperiment != null) {
            return Integer.valueOf(userExperiment.getBucket());
        }
        return null;
    }
}

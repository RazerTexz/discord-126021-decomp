package com.discord.widgets.botuikit;

import com.discord.api.botuikit.ComponentType;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: ComponentExperiments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BotComponentExperiments implements ComponentExperiments {
    public static final BotComponentExperiments$Companion Companion = new BotComponentExperiments$Companion(null);
    private static BotComponentExperiments botComponentExperiments;
    private final StoreExperiments storeExperiments;

    public BotComponentExperiments(StoreExperiments storeExperiments) {
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        this.storeExperiments = storeExperiments;
    }

    public static final /* synthetic */ BotComponentExperiments access$getBotComponentExperiments$cp() {
        return botComponentExperiments;
    }

    public static final /* synthetic */ void access$setBotComponentExperiments$cp(BotComponentExperiments botComponentExperiments2) {
        botComponentExperiments = botComponentExperiments2;
    }

    public final StoreExperiments getStoreExperiments() {
        return this.storeExperiments;
    }

    @Override // com.discord.widgets.botuikit.ComponentExperiments
    public boolean isEnabled(ComponentType componentType) {
        m.checkNotNullParameter(componentType, "componentType");
        int iOrdinal = componentType.ordinal();
        if (iOrdinal == 0) {
            return false;
        }
        if (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3 || iOrdinal == 4) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isExperimentEnabled(String experimentName) {
        m.checkNotNullParameter(experimentName, "experimentName");
        Experiment userExperiment = this.storeExperiments.getUserExperiment(experimentName, false);
        return userExperiment != null && userExperiment.getBucket() == 1;
    }
}

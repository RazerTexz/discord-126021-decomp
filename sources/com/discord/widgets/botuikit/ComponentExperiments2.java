package com.discord.widgets.botuikit;

import com.discord.api.botuikit.Component6;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import d0.z.d.Intrinsics3;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.botuikit.BotComponentExperiments, reason: use source file name */
/* JADX INFO: compiled from: ComponentExperiments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ComponentExperiments2 implements ComponentExperiments {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ComponentExperiments2 botComponentExperiments;
    private final StoreExperiments storeExperiments;

    /* JADX INFO: renamed from: com.discord.widgets.botuikit.BotComponentExperiments$Companion, reason: from kotlin metadata */
    /* JADX INFO: compiled from: ComponentExperiments.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ComponentExperiments get(StoreExperiments storeExperiments) {
            Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
            ComponentExperiments2 botComponentExperiments = getBotComponentExperiments();
            if (botComponentExperiments != null) {
                return botComponentExperiments;
            }
            ComponentExperiments2 componentExperiments2 = new ComponentExperiments2(storeExperiments);
            setBotComponentExperiments(componentExperiments2);
            return componentExperiments2;
        }

        public final ComponentExperiments2 getBotComponentExperiments() {
            return ComponentExperiments2.botComponentExperiments;
        }

        public final void setBotComponentExperiments(ComponentExperiments2 componentExperiments2) {
            ComponentExperiments2.botComponentExperiments = componentExperiments2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.botuikit.BotComponentExperiments$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Component6.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[Component6.UNKNOWN.ordinal()] = 1;
            iArr[Component6.ACTION_ROW.ordinal()] = 2;
            iArr[Component6.BUTTON.ordinal()] = 3;
            iArr[Component6.SELECT.ordinal()] = 4;
            iArr[Component6.TEXT.ordinal()] = 5;
        }
    }

    public ComponentExperiments2(StoreExperiments storeExperiments) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        this.storeExperiments = storeExperiments;
    }

    public final StoreExperiments getStoreExperiments() {
        return this.storeExperiments;
    }

    @Override // com.discord.widgets.botuikit.ComponentExperiments
    public boolean isEnabled(Component6 componentType) {
        Intrinsics3.checkNotNullParameter(componentType, "componentType");
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
        Intrinsics3.checkNotNullParameter(experimentName, "experimentName");
        Experiment userExperiment = this.storeExperiments.getUserExperiment(experimentName, false);
        return userExperiment != null && userExperiment.getBucket() == 1;
    }
}

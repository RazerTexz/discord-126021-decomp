package com.discord.widgets.servers.creator_monetization_eligibility;

import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CreatorMonetizationCountryAllowlist.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CreatorMonetizationCountryAllowlist {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(CreatorMonetizationCountryAllowlist2.INSTANCE);
    private final StoreExperiments storeExperiments;

    /* JADX INFO: compiled from: CreatorMonetizationCountryAllowlist.kt */
    public static final class Companion {
        private Companion() {
        }

        public final CreatorMonetizationCountryAllowlist getINSTANCE() {
            Lazy lazy = CreatorMonetizationCountryAllowlist.INSTANCE$delegate;
            Companion companion = CreatorMonetizationCountryAllowlist.INSTANCE;
            return (CreatorMonetizationCountryAllowlist) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreatorMonetizationCountryAllowlist() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public CreatorMonetizationCountryAllowlist(StoreExperiments storeExperiments) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        this.storeExperiments = storeExperiments;
    }

    public final boolean isUserInEligibleCountry() {
        Experiment userExperiment = this.storeExperiments.getUserExperiment("2022-04_creator_monetization_country_allowlist", false);
        return userExperiment != null && userExperiment.getBucket() == 1;
    }

    public /* synthetic */ CreatorMonetizationCountryAllowlist(StoreExperiments storeExperiments, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments);
    }
}

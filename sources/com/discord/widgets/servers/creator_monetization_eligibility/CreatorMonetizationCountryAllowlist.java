package com.discord.widgets.servers.creator_monetization_eligibility;

import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CreatorMonetizationCountryAllowlist.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CreatorMonetizationCountryAllowlist {
    public static final CreatorMonetizationCountryAllowlist$Companion Companion = new CreatorMonetizationCountryAllowlist$Companion(null);
    private static final Lazy INSTANCE$delegate = g.lazy(CreatorMonetizationCountryAllowlist$Companion$INSTANCE$2.INSTANCE);
    private final StoreExperiments storeExperiments;

    public CreatorMonetizationCountryAllowlist() {
        this(null, 1, null);
    }

    public CreatorMonetizationCountryAllowlist(StoreExperiments storeExperiments) {
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        this.storeExperiments = storeExperiments;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public final boolean isUserInEligibleCountry() {
        Experiment userExperiment = this.storeExperiments.getUserExperiment("2022-04_creator_monetization_country_allowlist", false);
        return userExperiment != null && userExperiment.getBucket() == 1;
    }

    public /* synthetic */ CreatorMonetizationCountryAllowlist(StoreExperiments storeExperiments, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getExperiments() : storeExperiments);
    }
}

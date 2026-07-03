package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackMarketingSite.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMarketingSite {
    private final CharSequence marketingVariant = null;

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackMarketingSite) && C12238m.areEqual(this.marketingVariant, ((TrackMarketingSite) other).marketingVariant);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.marketingVariant;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m817E(C1643a.m833U("TrackMarketingSite(marketingVariant="), this.marketingVariant, ")");
    }
}

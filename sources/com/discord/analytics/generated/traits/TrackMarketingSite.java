package com.discord.analytics.generated.traits;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackMarketingSite.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMarketingSite {
    private final CharSequence marketingVariant = null;

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackMarketingSite) && m.areEqual(this.marketingVariant, ((TrackMarketingSite) other).marketingVariant);
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
        return a.E(a.U("TrackMarketingSite(marketingVariant="), this.marketingVariant, ")");
    }
}

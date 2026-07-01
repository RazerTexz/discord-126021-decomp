package com.discord.api.premium;

import b.c.a.a0.d;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: PremiumTier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PremiumTierTypeAdapter extends TypeAdapter<PremiumTier> {
    @Override // com.google.gson.TypeAdapter
    public PremiumTier read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        Integer numN1 = d.n1(jsonReader);
        if (numN1 != null && numN1.intValue() == 0) {
            return PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY;
        }
        if (numN1 != null && numN1.intValue() == 1) {
            return PremiumTier.TIER_1;
        }
        if (numN1 != null && numN1.intValue() == 2) {
            return PremiumTier.TIER_2;
        }
        return (numN1 != null && numN1.intValue() == 3) ? PremiumTier.TIER_0 : PremiumTier.NONE;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, PremiumTier premiumTier) throws IOException {
        Integer num;
        PremiumTier premiumTier2 = premiumTier;
        m.checkNotNullParameter(jsonWriter, "out");
        if (premiumTier2 == null) {
            jsonWriter.s();
            return;
        }
        int iOrdinal = premiumTier2.ordinal();
        if (iOrdinal == 0) {
            num = null;
        } else if (iOrdinal == 1) {
            num = 0;
        } else if (iOrdinal == 2) {
            num = 3;
        } else if (iOrdinal == 3) {
            num = 1;
        } else {
            if (iOrdinal != 4) {
                throw new NoWhenBranchMatchedException();
            }
            num = 2;
        }
        jsonWriter.D(num);
    }
}

package com.discord.api.premium;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;
import p007b.p085c.p086a.p087a0.C1460d;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PremiumTier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PremiumTierTypeAdapter extends TypeAdapter<PremiumTier> {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PremiumTier.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY.ordinal()] = 1;
            iArr[PremiumTier.TIER_1.ordinal()] = 2;
            iArr[PremiumTier.TIER_2.ordinal()] = 3;
            iArr[PremiumTier.TIER_0.ordinal()] = 4;
            iArr[PremiumTier.NONE.ordinal()] = 5;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public PremiumTier read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "in");
        Integer numM549n1 = C1460d.m549n1(jsonReader);
        if (numM549n1 != null && numM549n1.intValue() == 0) {
            return PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY;
        }
        if (numM549n1 != null && numM549n1.intValue() == 1) {
            return PremiumTier.TIER_1;
        }
        if (numM549n1 != null && numM549n1.intValue() == 2) {
            return PremiumTier.TIER_2;
        }
        return (numM549n1 != null && numM549n1.intValue() == 3) ? PremiumTier.TIER_0 : PremiumTier.NONE;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, PremiumTier premiumTier) throws IOException {
        Integer num;
        PremiumTier premiumTier2 = premiumTier;
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (premiumTier2 == null) {
            jsonWriter.mo6905s();
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
        jsonWriter.mo6894D(num);
    }
}

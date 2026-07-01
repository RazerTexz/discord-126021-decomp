package com.discord.api.premium;

import b.c.a.a0.d;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: PriceTierType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PriceTierTypeAdapter extends TypeAdapter<PriceTierType> {
    @Override // com.google.gson.TypeAdapter
    public PriceTierType read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        Integer numN1 = d.n1(jsonReader);
        return (numN1 != null && numN1.intValue() == 1) ? PriceTierType.GUILD_ROLE_SUBSCRIPTIONS : PriceTierType.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, PriceTierType priceTierType) throws IOException {
        Integer num;
        PriceTierType priceTierType2 = priceTierType;
        m.checkNotNullParameter(jsonWriter, "out");
        if (priceTierType2 == null) {
            jsonWriter.s();
            return;
        }
        int iOrdinal = priceTierType2.ordinal();
        if (iOrdinal == 0) {
            num = null;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            num = 1;
        }
        jsonWriter.D(num);
    }
}

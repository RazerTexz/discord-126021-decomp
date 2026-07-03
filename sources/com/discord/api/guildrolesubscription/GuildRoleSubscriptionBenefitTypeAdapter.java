package com.discord.api.guildrolesubscription;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildRoleSubscriptionBenefitTypeAdapter extends TypeAdapter<GuildRoleSubscriptionBenefitType> {
    @Override // com.google.gson.TypeAdapter
    public GuildRoleSubscriptionBenefitType read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "in");
        GuildRoleSubscriptionBenefitType.Companion companion = GuildRoleSubscriptionBenefitType.INSTANCE;
        int iMo6891y = jsonReader.mo6891y();
        Objects.requireNonNull(companion);
        if (iMo6891y != 1) {
            return iMo6891y != 2 ? GuildRoleSubscriptionBenefitType.UNKNOWN : GuildRoleSubscriptionBenefitType.INTANGIBLE;
        }
        return GuildRoleSubscriptionBenefitType.CHANNEL;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType) throws IOException {
        GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType2 = guildRoleSubscriptionBenefitType;
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (guildRoleSubscriptionBenefitType2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(guildRoleSubscriptionBenefitType2.getApiValue()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}

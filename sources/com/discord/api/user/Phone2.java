package com.discord.api.user;

import com.discord.api.user.Phone;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: renamed from: com.discord.api.user.PhoneTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: Phone.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Phone2 extends TypeAdapter<Phone> {
    @Override // com.google.gson.TypeAdapter
    public Phone read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        if (jsonReader.N() == JsonToken.NULL) {
            jsonReader.H();
            return Phone.NoPhoneNumber.INSTANCE;
        }
        String strJ = jsonReader.J();
        Intrinsics3.checkNotNullExpressionValue(strJ, "number");
        return new Phone.PhoneNumber(strJ);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Phone phone) throws IOException {
        JsonWriter jsonWriterS;
        Phone phone2 = phone;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (phone2 instanceof Phone.PhoneNumber) {
            jsonWriterS = jsonWriter.H(((Phone.PhoneNumber) phone2).getNumber());
        } else {
            if (!Intrinsics3.areEqual(phone2, Phone.NoPhoneNumber.INSTANCE) && phone2 != null) {
                throw new NoWhenBranchMatchedException();
            }
            jsonWriterS = jsonWriter.s();
        }
        jsonWriterS.getClass();
    }
}

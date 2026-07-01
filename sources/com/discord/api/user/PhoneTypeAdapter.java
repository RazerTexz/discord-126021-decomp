package com.discord.api.user;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: Phone.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PhoneTypeAdapter extends TypeAdapter<Phone> {
    @Override // com.google.gson.TypeAdapter
    public Phone read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        if (jsonReader.N() == JsonToken.NULL) {
            jsonReader.H();
            return Phone$NoPhoneNumber.INSTANCE;
        }
        String strJ = jsonReader.J();
        m.checkNotNullExpressionValue(strJ, "number");
        return new Phone$PhoneNumber(strJ);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Phone phone) throws IOException {
        JsonWriter jsonWriterS;
        Phone phone2 = phone;
        m.checkNotNullParameter(jsonWriter, "out");
        if (phone2 instanceof Phone$PhoneNumber) {
            jsonWriterS = jsonWriter.H(((Phone$PhoneNumber) phone2).getNumber());
        } else {
            if (!m.areEqual(phone2, Phone$NoPhoneNumber.INSTANCE) && phone2 != null) {
                throw new NoWhenBranchMatchedException();
            }
            jsonWriterS = jsonWriter.s();
        }
        jsonWriterS.getClass();
    }
}

package com.discord.api.message.embed;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;

/* JADX INFO: compiled from: EmbedType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EmbedTypeTypeAdapter extends TypeAdapter<EmbedType> {
    /* JADX WARN: Code duplicated, block: B:11:0x0025  */
    /* JADX WARN: Code duplicated, block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // com.google.gson.TypeAdapter
    public EmbedType read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        String strJ = jsonReader.J();
        for (EmbedType embedType : EmbedTypeKt.a()) {
            if (m.areEqual(embedType.getApiValue(), strJ)) {
                if (embedType != null) {
                    return embedType;
                }
                return EmbedType.UNKNOWN;
            }
        }
        embedType = null;
        if (embedType != null) {
            return embedType;
        }
        return EmbedType.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, EmbedType embedType) throws IOException {
        EmbedType embedType2 = embedType;
        m.checkNotNullParameter(jsonWriter, "out");
        if (embedType2 != null) {
            jsonWriter.H(embedType2.getApiValue());
        } else {
            jsonWriter.s();
        }
    }
}

package com.discord.api.message.embed;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: EmbedType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EmbedTypeTypeAdapter extends TypeAdapter<EmbedType> {
    /* JADX WARN: Code duplicated, block: B:11:0x0025  */
    /* JADX WARN: Code duplicated, block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // com.google.gson.TypeAdapter
    public EmbedType read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "in");
        String strMo6877J = jsonReader.mo6877J();
        for (EmbedType embedType : EmbedTypeKt.EMBED_TYPES) {
            if (C12238m.areEqual(embedType.getApiValue(), strMo6877J)) {
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
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (embedType2 != null) {
            jsonWriter.mo6895H(embedType2.getApiValue());
        } else {
            jsonWriter.mo6905s();
        }
    }
}

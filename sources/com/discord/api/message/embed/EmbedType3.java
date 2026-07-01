package com.discord.api.message.embed;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;

/* JADX INFO: renamed from: com.discord.api.message.embed.EmbedTypeTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: EmbedType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EmbedType3 extends TypeAdapter<EmbedType> {
    /* JADX WARN: Code duplicated, block: B:11:0x0025  */
    /* JADX WARN: Code duplicated, block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // com.google.gson.TypeAdapter
    public EmbedType read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        String strJ = jsonReader.J();
        for (EmbedType embedType : EmbedType2.EMBED_TYPES) {
            if (Intrinsics3.areEqual(embedType.getApiValue(), strJ)) {
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
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (embedType2 != null) {
            jsonWriter.H(embedType2.getApiValue());
        } else {
            jsonWriter.s();
        }
    }
}

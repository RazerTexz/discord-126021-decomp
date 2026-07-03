package com.discord.api.sticker;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StickerFormatType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StickerFormatTypeTypeAdapter extends TypeAdapter<StickerFormatType> {
    @Override // com.google.gson.TypeAdapter
    public StickerFormatType read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "in");
        return StickerFormatType.INSTANCE.m8242a(jsonReader.mo6891y());
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, StickerFormatType stickerFormatType) throws IOException {
        StickerFormatType stickerFormatType2 = stickerFormatType;
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (stickerFormatType2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(stickerFormatType2.getApiValue()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}

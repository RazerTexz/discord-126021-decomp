package com.discord.api.sticker;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;

/* JADX INFO: compiled from: StickerFormatType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StickerFormatTypeTypeAdapter extends TypeAdapter<StickerFormatType> {
    @Override // com.google.gson.TypeAdapter
    public StickerFormatType read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        return StickerFormatType.Companion.a(jsonReader.y());
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, StickerFormatType stickerFormatType) throws IOException {
        StickerFormatType stickerFormatType2 = stickerFormatType;
        m.checkNotNullParameter(jsonWriter, "out");
        if (stickerFormatType2 != null) {
            jsonWriter.D(Integer.valueOf(stickerFormatType2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}

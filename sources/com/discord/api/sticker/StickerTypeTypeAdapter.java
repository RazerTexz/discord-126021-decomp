package com.discord.api.sticker;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StickerType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StickerTypeTypeAdapter extends TypeAdapter<StickerType> {
    @Override // com.google.gson.TypeAdapter
    public StickerType read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "in");
        return StickerType.INSTANCE.m8244a(jsonReader.mo6891y());
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, StickerType stickerType) throws IOException {
        StickerType stickerType2 = stickerType;
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (stickerType2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(stickerType2.getApiValue()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}

package com.discord.api.sticker;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;

/* JADX INFO: renamed from: com.discord.api.sticker.StickerFormatTypeTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: StickerFormatType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StickerFormatType2 extends TypeAdapter<StickerFormatType> {
    @Override // com.google.gson.TypeAdapter
    public StickerFormatType read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        return StickerFormatType.INSTANCE.a(jsonReader.y());
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, StickerFormatType stickerFormatType) throws IOException {
        StickerFormatType stickerFormatType2 = stickerFormatType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (stickerFormatType2 != null) {
            jsonWriter.D(Integer.valueOf(stickerFormatType2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}

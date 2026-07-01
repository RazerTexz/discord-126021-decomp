package com.discord.api.sticker;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;

/* JADX INFO: renamed from: com.discord.api.sticker.StickerTypeTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: StickerType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StickerType2 extends TypeAdapter<StickerType> {
    @Override // com.google.gson.TypeAdapter
    public StickerType read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        return StickerType.INSTANCE.a(jsonReader.y());
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, StickerType stickerType) throws IOException {
        StickerType stickerType2 = stickerType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (stickerType2 != null) {
            jsonWriter.D(Integer.valueOf(stickerType2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}

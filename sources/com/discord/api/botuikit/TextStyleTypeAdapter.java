package com.discord.api.botuikit;

import b.c.a.a0.d;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: TextComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextStyleTypeAdapter extends TypeAdapter<TextStyle> {
    @Override // com.google.gson.TypeAdapter
    public TextStyle read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        Integer numN1 = d.n1(jsonReader);
        if (numN1 != null && numN1.intValue() == 1) {
            return TextStyle.SMALL;
        }
        return (numN1 != null && numN1.intValue() == 2) ? TextStyle.PARAGRAPH : TextStyle.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, TextStyle textStyle) throws IOException {
        Integer num;
        TextStyle textStyle2 = textStyle;
        m.checkNotNullParameter(jsonWriter, "out");
        if (textStyle2 != null) {
            int iOrdinal = textStyle2.ordinal();
            if (iOrdinal == 0) {
                num = 1;
            } else if (iOrdinal == 1) {
                num = 2;
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                num = null;
            }
            jsonWriter.D(num);
        }
    }
}

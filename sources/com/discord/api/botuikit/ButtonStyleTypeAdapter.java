package com.discord.api.botuikit;

import b.c.a.a0.d;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: ButtonComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ButtonStyleTypeAdapter extends TypeAdapter<ButtonStyle> {
    @Override // com.google.gson.TypeAdapter
    public ButtonStyle read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        Integer numN1 = d.n1(jsonReader);
        if (numN1 != null && numN1.intValue() == 1) {
            return ButtonStyle.PRIMARY;
        }
        if (numN1 != null && numN1.intValue() == 2) {
            return ButtonStyle.SECONDARY;
        }
        if (numN1 != null && numN1.intValue() == 3) {
            return ButtonStyle.SUCCESS;
        }
        if (numN1 != null && numN1.intValue() == 4) {
            return ButtonStyle.DANGER;
        }
        return (numN1 != null && numN1.intValue() == 5) ? ButtonStyle.LINK : ButtonStyle.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ButtonStyle buttonStyle) throws IOException {
        Integer num;
        ButtonStyle buttonStyle2 = buttonStyle;
        m.checkNotNullParameter(jsonWriter, "out");
        if (buttonStyle2 != null) {
            int iOrdinal = buttonStyle2.ordinal();
            if (iOrdinal == 0) {
                num = null;
            } else if (iOrdinal == 1) {
                num = 1;
            } else if (iOrdinal == 2) {
                num = 2;
            } else if (iOrdinal == 3) {
                num = 3;
            } else if (iOrdinal == 4) {
                num = 4;
            } else {
                if (iOrdinal != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                num = 5;
            }
            jsonWriter.D(num);
        }
    }
}

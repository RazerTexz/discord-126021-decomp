package com.discord.api.botuikit;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;
import p007b.p085c.p086a.p087a0.C1460d;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TextComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextStyleTypeAdapter extends TypeAdapter<TextStyle> {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            TextStyle.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[TextStyle.SMALL.ordinal()] = 1;
            iArr[TextStyle.PARAGRAPH.ordinal()] = 2;
            iArr[TextStyle.UNKNOWN.ordinal()] = 3;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public TextStyle read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "in");
        Integer numM549n1 = C1460d.m549n1(jsonReader);
        if (numM549n1 != null && numM549n1.intValue() == 1) {
            return TextStyle.SMALL;
        }
        return (numM549n1 != null && numM549n1.intValue() == 2) ? TextStyle.PARAGRAPH : TextStyle.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, TextStyle textStyle) throws IOException {
        Integer num;
        TextStyle textStyle2 = textStyle;
        C12238m.checkNotNullParameter(jsonWriter, "out");
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
            jsonWriter.mo6894D(num);
        }
    }
}

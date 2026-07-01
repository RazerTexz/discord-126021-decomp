package com.discord.api.botuikit;

import b.c.a.a0.AnimatableValueParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: renamed from: com.discord.api.botuikit.TextStyleTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: TextComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextComponent3 extends TypeAdapter<TextComponent2> {

    /* JADX INFO: renamed from: com.discord.api.botuikit.TextStyleTypeAdapter$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            TextComponent2.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[TextComponent2.SMALL.ordinal()] = 1;
            iArr[TextComponent2.PARAGRAPH.ordinal()] = 2;
            iArr[TextComponent2.UNKNOWN.ordinal()] = 3;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public TextComponent2 read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        Integer numN1 = AnimatableValueParser.n1(jsonReader);
        if (numN1 != null && numN1.intValue() == 1) {
            return TextComponent2.SMALL;
        }
        return (numN1 != null && numN1.intValue() == 2) ? TextComponent2.PARAGRAPH : TextComponent2.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, TextComponent2 textComponent2) throws IOException {
        Integer num;
        TextComponent2 textComponent3 = textComponent2;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (textComponent3 != null) {
            int iOrdinal = textComponent3.ordinal();
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

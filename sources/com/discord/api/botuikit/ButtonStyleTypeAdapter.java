package com.discord.api.botuikit;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;
import p007b.p085c.p086a.p087a0.C1460d;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ButtonComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ButtonStyleTypeAdapter extends TypeAdapter<ButtonStyle> {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ButtonStyle.values();
            int[] iArr = new int[6];
            $EnumSwitchMapping$0 = iArr;
            iArr[ButtonStyle.PRIMARY.ordinal()] = 1;
            iArr[ButtonStyle.SECONDARY.ordinal()] = 2;
            iArr[ButtonStyle.SUCCESS.ordinal()] = 3;
            iArr[ButtonStyle.DANGER.ordinal()] = 4;
            iArr[ButtonStyle.LINK.ordinal()] = 5;
            iArr[ButtonStyle.UNKNOWN.ordinal()] = 6;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public ButtonStyle read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "in");
        Integer numM549n1 = C1460d.m549n1(jsonReader);
        if (numM549n1 != null && numM549n1.intValue() == 1) {
            return ButtonStyle.PRIMARY;
        }
        if (numM549n1 != null && numM549n1.intValue() == 2) {
            return ButtonStyle.SECONDARY;
        }
        if (numM549n1 != null && numM549n1.intValue() == 3) {
            return ButtonStyle.SUCCESS;
        }
        if (numM549n1 != null && numM549n1.intValue() == 4) {
            return ButtonStyle.DANGER;
        }
        return (numM549n1 != null && numM549n1.intValue() == 5) ? ButtonStyle.LINK : ButtonStyle.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ButtonStyle buttonStyle) throws IOException {
        Integer num;
        ButtonStyle buttonStyle2 = buttonStyle;
        C12238m.checkNotNullParameter(jsonWriter, "out");
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
            jsonWriter.mo6894D(num);
        }
    }
}

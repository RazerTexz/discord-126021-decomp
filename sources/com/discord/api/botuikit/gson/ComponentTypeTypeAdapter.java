package com.discord.api.botuikit.gson;

import b.c.a.a0.AnimatableValueParser;
import com.discord.api.botuikit.Component6;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;

/* JADX INFO: compiled from: ComponentTypeTypeAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ComponentTypeTypeAdapter extends TypeAdapter<Component6> {
    /* JADX WARN: Code duplicated, block: B:18:0x002e  */
    /* JADX WARN: Code duplicated, block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // com.google.gson.TypeAdapter
    public Component6 read(JsonReader jsonReader) throws IOException {
        Component6 component6;
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        Integer numN1 = AnimatableValueParser.n1(jsonReader);
        Component6[] component6ArrValues = Component6.values();
        for (int i = 0; i < 5; i++) {
            component6 = component6ArrValues[i];
            if (numN1 != null && component6.getType() == numN1.intValue()) {
                if (component6 != null) {
                    return component6;
                }
                return Component6.UNKNOWN;
            }
        }
        component6 = null;
        if (component6 != null) {
            return component6;
        }
        return Component6.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Component6 component6) throws IOException {
        Component6 component7 = component6;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (component7 != null) {
            jsonWriter.D(Integer.valueOf(component7.getType()));
        }
    }
}

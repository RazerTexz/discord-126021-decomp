package com.discord.api.botuikit.gson;

import com.discord.api.botuikit.ComponentType;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p007b.p085c.p086a.p087a0.C1460d;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ComponentTypeTypeAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ComponentTypeTypeAdapter extends TypeAdapter<ComponentType> {
    /* JADX WARN: Code duplicated, block: B:18:0x002e  */
    /* JADX WARN: Code duplicated, block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // com.google.gson.TypeAdapter
    public ComponentType read(JsonReader jsonReader) throws IOException {
        ComponentType componentType;
        C12238m.checkNotNullParameter(jsonReader, "in");
        Integer numM549n1 = C1460d.m549n1(jsonReader);
        ComponentType[] componentTypeArrValues = ComponentType.values();
        for (int i = 0; i < 5; i++) {
            componentType = componentTypeArrValues[i];
            if (numM549n1 != null && componentType.getType() == numM549n1.intValue()) {
                if (componentType != null) {
                    return componentType;
                }
                return ComponentType.UNKNOWN;
            }
        }
        componentType = null;
        if (componentType != null) {
            return componentType;
        }
        return ComponentType.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ComponentType componentType) throws IOException {
        ComponentType componentType2 = componentType;
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (componentType2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(componentType2.getType()));
        }
    }
}

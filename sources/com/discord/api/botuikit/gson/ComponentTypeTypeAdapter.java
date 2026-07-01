package com.discord.api.botuikit.gson;

import b.c.a.a0.d;
import com.discord.api.botuikit.ComponentType;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;

/* JADX INFO: compiled from: ComponentTypeTypeAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ComponentTypeTypeAdapter extends TypeAdapter<ComponentType> {
    /* JADX WARN: Code duplicated, block: B:18:0x002e  */
    /* JADX WARN: Code duplicated, block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // com.google.gson.TypeAdapter
    public ComponentType read(JsonReader jsonReader) throws IOException {
        ComponentType componentType;
        m.checkNotNullParameter(jsonReader, "in");
        Integer numN1 = d.n1(jsonReader);
        ComponentType[] componentTypeArrValues = ComponentType.values();
        for (int i = 0; i < 5; i++) {
            componentType = componentTypeArrValues[i];
            if (numN1 != null && componentType.getType() == numN1.intValue()) {
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
        m.checkNotNullParameter(jsonWriter, "out");
        if (componentType2 != null) {
            jsonWriter.D(Integer.valueOf(componentType2.getType()));
        }
    }
}

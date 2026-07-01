package com.google.gson.internal.bind;

import b.i.d.p.b;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.Enum;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeAdapters$EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
    public final Map<String, T> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<T, String> f3134b = new HashMap();

    public TypeAdapters$EnumTypeAdapter(Class<T> cls) {
        try {
            for (T t : cls.getEnumConstants()) {
                String strName = t.name();
                b bVar = (b) cls.getField(strName).getAnnotation(b.class);
                if (bVar != null) {
                    strName = bVar.value();
                    for (String str : bVar.alternate()) {
                        this.a.put(str, t);
                    }
                }
                this.a.put(strName, t);
                this.f3134b.put(t, strName);
            }
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) throws IOException {
        if (jsonReader.N() != JsonToken.NULL) {
            return this.a.get(jsonReader.J());
        }
        jsonReader.H();
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        Enum r3 = (Enum) obj;
        jsonWriter.H(r3 == null ? null : this.f3134b.get(r3));
    }
}

package com.google.gson.internal.bind;

import b.i.d.o;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    public static final o a = new ObjectTypeAdapter$1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Gson f3121b;

    public ObjectTypeAdapter(Gson gson) {
        this.f3121b = gson;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) throws IOException {
        int iOrdinal = jsonReader.N().ordinal();
        if (iOrdinal == 0) {
            ArrayList arrayList = new ArrayList();
            jsonReader.a();
            while (jsonReader.q()) {
                arrayList.add(read(jsonReader));
            }
            jsonReader.e();
            return arrayList;
        }
        if (iOrdinal == 2) {
            LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
            jsonReader.b();
            while (jsonReader.q()) {
                linkedTreeMap.put(jsonReader.C(), read(jsonReader));
            }
            jsonReader.f();
            return linkedTreeMap;
        }
        if (iOrdinal == 5) {
            return jsonReader.J();
        }
        if (iOrdinal == 6) {
            return Double.valueOf(jsonReader.x());
        }
        if (iOrdinal == 7) {
            return Boolean.valueOf(jsonReader.u());
        }
        if (iOrdinal != 8) {
            throw new IllegalStateException();
        }
        jsonReader.H();
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.s();
            return;
        }
        TypeAdapter typeAdapterI = this.f3121b.i(obj.getClass());
        if (!(typeAdapterI instanceof ObjectTypeAdapter)) {
            typeAdapterI.write(jsonWriter, obj);
        } else {
            jsonWriter.c();
            jsonWriter.f();
        }
    }
}

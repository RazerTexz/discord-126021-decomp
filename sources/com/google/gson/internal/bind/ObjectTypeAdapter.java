package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import p007b.p225i.p408d.InterfaceC4911o;

/* JADX INFO: loaded from: classes3.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC4911o f21525a = new InterfaceC4911o() { // from class: com.google.gson.internal.bind.ObjectTypeAdapter.1
        @Override // p007b.p225i.p408d.InterfaceC4911o
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Object.class) {
                return new ObjectTypeAdapter(gson);
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: b */
    public final Gson f21526b;

    public ObjectTypeAdapter(Gson gson) {
        this.f21526b = gson;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) throws IOException {
        int iOrdinal = jsonReader.mo6878N().ordinal();
        if (iOrdinal == 0) {
            ArrayList arrayList = new ArrayList();
            jsonReader.mo6882a();
            while (jsonReader.mo6888q()) {
                arrayList.add(read(jsonReader));
            }
            jsonReader.mo6886e();
            return arrayList;
        }
        if (iOrdinal == 2) {
            LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
            jsonReader.mo6883b();
            while (jsonReader.mo6888q()) {
                linkedTreeMap.put(jsonReader.mo6875C(), read(jsonReader));
            }
            jsonReader.mo6887f();
            return linkedTreeMap;
        }
        if (iOrdinal == 5) {
            return jsonReader.mo6877J();
        }
        if (iOrdinal == 6) {
            return Double.valueOf(jsonReader.mo6890x());
        }
        if (iOrdinal == 7) {
            return Boolean.valueOf(jsonReader.mo6889u());
        }
        if (iOrdinal != 8) {
            throw new IllegalStateException();
        }
        jsonReader.mo6876H();
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.mo6905s();
            return;
        }
        TypeAdapter typeAdapterM9205i = this.f21526b.m9205i(obj.getClass());
        if (!(typeAdapterM9205i instanceof ObjectTypeAdapter)) {
            typeAdapterM9205i.write(jsonWriter, obj);
        } else {
            jsonWriter.mo6901c();
            jsonWriter.mo6903f();
        }
    }
}

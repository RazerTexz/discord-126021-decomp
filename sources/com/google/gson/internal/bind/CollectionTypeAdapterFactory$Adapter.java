package com.google.gson.internal.bind;

import b.i.d.q.r;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class CollectionTypeAdapterFactory$Adapter<E> extends TypeAdapter<Collection<E>> {
    public final TypeAdapter<E> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r<? extends Collection<E>> f3118b;

    public CollectionTypeAdapterFactory$Adapter(Gson gson, Type type, TypeAdapter<E> typeAdapter, r<? extends Collection<E>> rVar) {
        this.a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
        this.f3118b = rVar;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) throws IOException {
        if (jsonReader.N() == JsonToken.NULL) {
            jsonReader.H();
            return null;
        }
        Collection<E> collectionA = this.f3118b.a();
        jsonReader.a();
        while (jsonReader.q()) {
            collectionA.add(this.a.read(jsonReader));
        }
        jsonReader.e();
        return collectionA;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        Collection collection = (Collection) obj;
        if (collection == null) {
            jsonWriter.s();
            return;
        }
        jsonWriter.b();
        Iterator<E> it = collection.iterator();
        while (it.hasNext()) {
            this.a.write(jsonWriter, it.next());
        }
        jsonWriter.e();
    }
}

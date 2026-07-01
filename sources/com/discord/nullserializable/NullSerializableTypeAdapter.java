package com.discord.nullserializable;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: NullSerializable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NullSerializableTypeAdapter<T> extends TypeAdapter<NullSerializable<? super T>> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final Gson gsonInstance;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final TypeAdapter<T> delegateTypeAdapter;

    public NullSerializableTypeAdapter(Gson gson, TypeAdapter<T> typeAdapter) {
        m.checkNotNullParameter(gson, "gsonInstance");
        m.checkNotNullParameter(typeAdapter, "delegateTypeAdapter");
        this.gsonInstance = gson;
        this.delegateTypeAdapter = typeAdapter;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        T t = this.delegateTypeAdapter.read(jsonReader);
        return t == null ? new NullSerializable$a(null, 1) : new NullSerializable$b(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        NullSerializable nullSerializable = (NullSerializable) obj;
        m.checkNotNullParameter(jsonWriter, "out");
        if (nullSerializable instanceof NullSerializable$b) {
            Object objA = nullSerializable.a();
            Gson gson = this.gsonInstance;
            m.checkNotNull(objA);
            TypeAdapter typeAdapterI = gson.i(objA.getClass());
            Objects.requireNonNull(typeAdapterI, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T>");
            typeAdapterI.write(jsonWriter, objA);
            return;
        }
        if (nullSerializable instanceof NullSerializable$a) {
            boolean z2 = jsonWriter.t;
            jsonWriter.t = true;
            jsonWriter.s();
            jsonWriter.t = z2;
            return;
        }
        if (nullSerializable == null) {
            boolean z3 = jsonWriter.t;
            jsonWriter.t = false;
            jsonWriter.s();
            jsonWriter.t = z3;
        }
    }
}

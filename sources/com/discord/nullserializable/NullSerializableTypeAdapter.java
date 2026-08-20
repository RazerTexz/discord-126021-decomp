package com.discord.nullserializable;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: NullSerializable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NullSerializableTypeAdapter<T> extends TypeAdapter<NullSerializable<? super T>> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final Gson gsonInstance;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final TypeAdapter<T> delegateTypeAdapter;

    public NullSerializableTypeAdapter(Gson gson, TypeAdapter<T> typeAdapter) {
        C12238m.checkNotNullParameter(gson, "gsonInstance");
        C12238m.checkNotNullParameter(typeAdapter, "delegateTypeAdapter");
        this.gsonInstance = gson;
        this.delegateTypeAdapter = typeAdapter;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "in");
        T t = this.delegateTypeAdapter.read(jsonReader);
        return t == null ? new NullSerializable.C5565a(null, 1) : new NullSerializable.C5566b(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        NullSerializable nullSerializable = (NullSerializable) obj;
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (nullSerializable instanceof NullSerializable.C5566b) {
            Object objMo8429a = nullSerializable.mo8429a();
            Gson gson = this.gsonInstance;
            C12238m.checkNotNull(objMo8429a);
            TypeAdapter typeAdapterM9205i = gson.m9205i(objMo8429a.getClass());
            Objects.requireNonNull(typeAdapterM9205i, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T>");
            typeAdapterM9205i.write(jsonWriter, objMo8429a);
            return;
        }
        if (nullSerializable instanceof NullSerializable.C5565a) {
            boolean z2 = jsonWriter.f21662t;
            jsonWriter.f21662t = true;
            jsonWriter.mo6905s();
            jsonWriter.f21662t = z2;
            return;
        }
        if (nullSerializable == null) {
            boolean z3 = jsonWriter.f21662t;
            jsonWriter.f21662t = false;
            jsonWriter.mo6905s();
            jsonWriter.f21662t = z3;
        }
    }
}

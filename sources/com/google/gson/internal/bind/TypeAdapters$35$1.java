package com.google.gson.internal.bind;

import b.d.b.a.a;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: Add missing generic type declarations: [T1] */
/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$35$1<T1> extends TypeAdapter<T1> {
    public final /* synthetic */ Class a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TypeAdapters$35 f3133b;

    public TypeAdapters$35$1(TypeAdapters$35 typeAdapters$35, Class cls) {
        this.f3133b = typeAdapters$35;
        this.a = cls;
    }

    @Override // com.google.gson.TypeAdapter
    public T1 read(JsonReader jsonReader) throws IOException {
        T1 t1 = (T1) this.f3133b.k.read(jsonReader);
        if (t1 == null || this.a.isInstance(t1)) {
            return t1;
        }
        StringBuilder sbU = a.U("Expected a ");
        sbU.append(this.a.getName());
        sbU.append(" but was ");
        sbU.append(t1.getClass().getName());
        throw new JsonSyntaxException(sbU.toString());
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T1 t1) throws IOException {
        this.f3133b.k.write(jsonWriter, t1);
    }
}

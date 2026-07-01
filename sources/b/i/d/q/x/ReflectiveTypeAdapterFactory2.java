package b.i.d.q.x;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;

/* JADX INFO: renamed from: b.i.d.q.x.c, reason: use source file name */
/* JADX INFO: compiled from: ReflectiveTypeAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class ReflectiveTypeAdapterFactory2 extends ReflectiveTypeAdapterFactory.a {
    public final /* synthetic */ Field d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ TypeAdapter f;
    public final /* synthetic */ Gson g;
    public final /* synthetic */ TypeToken h;
    public final /* synthetic */ boolean i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectiveTypeAdapterFactory2(ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory, String str, boolean z2, boolean z3, Field field, boolean z4, TypeAdapter typeAdapter, Gson gson, TypeToken typeToken, boolean z5) {
        super(str, z2, z3);
        this.d = field;
        this.e = z4;
        this.f = typeAdapter;
        this.g = gson;
        this.h = typeToken;
        this.i = z5;
    }

    @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.a
    public void a(JsonReader jsonReader, Object obj) throws IllegalAccessException, IOException {
        Object obj2 = this.f.read(jsonReader);
        if (obj2 == null && this.i) {
            return;
        }
        this.d.set(obj, obj2);
    }

    @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.a
    public void b(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IOException {
        (this.e ? this.f : new TypeAdapterRuntimeTypeWrapper(this.g, this.f, this.h.getType())).write(jsonWriter, this.d.get(obj));
    }

    @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.a
    public boolean c(Object obj) throws IllegalAccessException, IOException {
        return this.f3123b && this.d.get(obj) != obj;
    }
}

package p007b.p225i.p408d.p410q.p411x;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;

/* JADX INFO: renamed from: b.i.d.q.x.c */
/* JADX INFO: compiled from: ReflectiveTypeAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4941c extends ReflectiveTypeAdapterFactory.AbstractC11109a {

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Field f13141d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ boolean f13142e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ TypeAdapter f13143f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ Gson f13144g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ TypeToken f13145h;

    /* JADX INFO: renamed from: i */
    public final /* synthetic */ boolean f13146i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4941c(ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory, String str, boolean z2, boolean z3, Field field, boolean z4, TypeAdapter typeAdapter, Gson gson, TypeToken typeToken, boolean z5) {
        super(str, z2, z3);
        this.f13141d = field;
        this.f13142e = z4;
        this.f13143f = typeAdapter;
        this.f13144g = gson;
        this.f13145h = typeToken;
        this.f13146i = z5;
    }

    @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.AbstractC11109a
    /* JADX INFO: renamed from: a */
    public void mo6906a(JsonReader jsonReader, Object obj) throws IllegalAccessException, IOException {
        Object obj2 = this.f13143f.read(jsonReader);
        if (obj2 == null && this.f13146i) {
            return;
        }
        this.f13141d.set(obj, obj2);
    }

    @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.AbstractC11109a
    /* JADX INFO: renamed from: b */
    public void mo6907b(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IOException {
        (this.f13142e ? this.f13143f : new TypeAdapterRuntimeTypeWrapper(this.f13144g, this.f13143f, this.f13145h.getType())).write(jsonWriter, this.f13141d.get(obj));
    }

    @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.AbstractC11109a
    /* JADX INFO: renamed from: c */
    public boolean mo6908c(Object obj) throws IllegalAccessException, IOException {
        return this.f21535b && this.f13141d.get(obj) != obj;
    }
}

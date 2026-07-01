package b.i.d;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: renamed from: b.i.d.o, reason: use source file name */
/* JADX INFO: compiled from: TypeAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public interface TypeAdapterFactory2 {
    <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken);
}

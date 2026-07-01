package b.i.d;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: compiled from: TypeAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public interface o {
    <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken);
}

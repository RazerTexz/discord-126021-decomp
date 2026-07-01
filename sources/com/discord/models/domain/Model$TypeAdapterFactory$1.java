package com.discord.models.domain;

import b.d.b.a.a;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes.dex */
public class Model$TypeAdapterFactory$1<T> extends TypeAdapter<T> {
    public final /* synthetic */ Model$TypeAdapterFactory this$0;
    public final /* synthetic */ TypeToken val$type;

    public Model$TypeAdapterFactory$1(Model$TypeAdapterFactory model$TypeAdapterFactory, TypeToken typeToken) {
        this.this$0 = model$TypeAdapterFactory;
        this.val$type = typeToken;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader jsonReader) throws Exception {
        try {
            return (T) new Model$JsonReader(jsonReader).parse((Model) this.val$type.getRawType().newInstance());
        } catch (IllegalAccessException e) {
            throw new IOException("Unable to parse model.", e);
        } catch (InstantiationException e2) {
            throw new IOException("Unable to parse model.", e2);
        } catch (Exception e3) {
            if (e3 instanceof IOException) {
                throw e3;
            }
            throw new IOException("Unable to parse model.", e3);
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        throw new IOException(a.v("Writer incorrectly invoked for object.", t));
    }
}

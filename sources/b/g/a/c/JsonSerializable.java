package b.g.a.c;

import b.g.a.b.JsonGenerator;
import b.g.a.c.e0.TypeSerializer;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.c.m, reason: use source file name */
/* JADX INFO: compiled from: JsonSerializable.java */
/* JADX INFO: loaded from: classes3.dex */
public interface JsonSerializable {

    /* JADX INFO: renamed from: b.g.a.c.m$a */
    /* JADX INFO: compiled from: JsonSerializable.java */
    public static abstract class a implements JsonSerializable {
    }

    void c(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException;

    void d(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException;
}

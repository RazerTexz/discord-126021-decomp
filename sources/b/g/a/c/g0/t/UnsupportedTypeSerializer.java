package b.g.a.c.g0.t;

import b.g.a.b.JsonGenerator;
import b.g.a.c.JavaType;
import b.g.a.c.SerializerProvider;
import b.g.a.c.g0.u.StdSerializer;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.c.g0.t.r, reason: use source file name */
/* JADX INFO: compiled from: UnsupportedTypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class UnsupportedTypeSerializer extends StdSerializer<Object> {
    private static final long serialVersionUID = 1;
    public final String _message;
    public final JavaType _type;

    public UnsupportedTypeSerializer(JavaType javaType, String str) {
        super(Object.class);
        this._type = javaType;
        this._message = str;
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        serializerProvider.f(this._type, this._message);
        throw null;
    }
}

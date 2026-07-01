package b.g.a.c.e0;

import b.g.a.a.JsonTypeInfo;
import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonToken2;
import b.g.a.b.s.WritableTypeId;
import b.g.a.b.t.VersionUtil;
import b.g.a.c.BeanProperty;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.c.e0.g, reason: use source file name */
/* JADX INFO: compiled from: TypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeSerializer {
    public abstract TypeSerializer a(BeanProperty beanProperty);

    public abstract String b();

    public abstract JsonTypeInfo.a c();

    public WritableTypeId d(Object obj, JsonToken2 jsonToken2) {
        WritableTypeId writableTypeId = new WritableTypeId(obj, jsonToken2);
        int iOrdinal = c().ordinal();
        if (iOrdinal == 0) {
            writableTypeId.e = 3;
            writableTypeId.d = b();
        } else if (iOrdinal == 1) {
            writableTypeId.e = 2;
        } else if (iOrdinal == 2) {
            writableTypeId.e = 1;
        } else if (iOrdinal == 3) {
            writableTypeId.e = 5;
            writableTypeId.d = b();
        } else {
            if (iOrdinal != 4) {
                int i = VersionUtil.a;
                throw new RuntimeException("Internal error: this code path should never get executed");
            }
            writableTypeId.e = 4;
            writableTypeId.d = b();
        }
        return writableTypeId;
    }

    public abstract WritableTypeId e(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) throws IOException;

    public abstract WritableTypeId f(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) throws IOException;
}

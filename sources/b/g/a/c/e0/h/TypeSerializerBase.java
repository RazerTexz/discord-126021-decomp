package b.g.a.c.e0.h;

import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonToken2;
import b.g.a.b.s.WritableTypeId;
import b.g.a.c.BeanProperty;
import b.g.a.c.e0.TypeIdResolver;
import b.g.a.c.e0.TypeSerializer;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.e0.h.m, reason: use source file name */
/* JADX INFO: compiled from: TypeSerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeSerializerBase extends TypeSerializer {
    public final TypeIdResolver a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BeanProperty f699b;

    public TypeSerializerBase(TypeIdResolver typeIdResolver, BeanProperty beanProperty) {
        this.a = typeIdResolver;
        this.f699b = beanProperty;
    }

    @Override // b.g.a.c.e0.TypeSerializer
    public String b() {
        return null;
    }

    @Override // b.g.a.c.e0.TypeSerializer
    public WritableTypeId e(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) throws IOException {
        if (writableTypeId.c == null) {
            Object obj = writableTypeId.a;
            Class<?> cls = writableTypeId.f675b;
            writableTypeId.c = cls == null ? this.a.a(obj) : this.a.c(obj, cls);
        }
        Objects.requireNonNull(jsonGenerator);
        Object obj2 = writableTypeId.c;
        JsonToken2 jsonToken2 = writableTypeId.f;
        String strValueOf = obj2 instanceof String ? (String) obj2 : String.valueOf(obj2);
        writableTypeId.g = true;
        int i = writableTypeId.e;
        JsonToken2 jsonToken3 = JsonToken2.START_OBJECT;
        if (jsonToken2 != jsonToken3) {
            b.c.a.y.b.j(i);
            if (i == 3 || i == 4) {
                writableTypeId.e = 1;
                i = 1;
            }
        }
        int iH = b.c.a.y.b.h(i);
        if (iH != 1) {
            if (iH == 2) {
                jsonGenerator.d0(writableTypeId.a);
                jsonGenerator.y(writableTypeId.d);
                jsonGenerator.j0(strValueOf);
            } else if (iH != 3 && iH != 4) {
                jsonGenerator.W();
                jsonGenerator.j0(strValueOf);
            }
            return writableTypeId;
        }
        jsonGenerator.c0();
        jsonGenerator.y(strValueOf);
        if (jsonToken2 == jsonToken3) {
            jsonGenerator.d0(writableTypeId.a);
        } else if (jsonToken2 == JsonToken2.START_ARRAY) {
            jsonGenerator.W();
        }
        return writableTypeId;
    }

    @Override // b.g.a.c.e0.TypeSerializer
    public WritableTypeId f(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) throws IOException {
        Objects.requireNonNull(jsonGenerator);
        JsonToken2 jsonToken2 = writableTypeId.f;
        if (jsonToken2 == JsonToken2.START_OBJECT) {
            jsonGenerator.u();
        } else if (jsonToken2 == JsonToken2.START_ARRAY) {
            jsonGenerator.t();
        }
        if (writableTypeId.g) {
            int iH = b.c.a.y.b.h(writableTypeId.e);
            if (iH == 0) {
                jsonGenerator.t();
            } else if (iH != 2 && iH != 3) {
                if (iH != 4) {
                    jsonGenerator.u();
                } else {
                    Object obj = writableTypeId.c;
                    String strValueOf = obj instanceof String ? (String) obj : String.valueOf(obj);
                    jsonGenerator.y(writableTypeId.d);
                    jsonGenerator.j0(strValueOf);
                }
            }
        }
        return writableTypeId;
    }
}

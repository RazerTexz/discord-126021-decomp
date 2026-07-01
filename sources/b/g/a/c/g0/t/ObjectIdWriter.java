package b.g.a.c.g0.t;

import b.g.a.a.ObjectIdGenerator;
import b.g.a.b.SerializableString;
import b.g.a.b.p.SerializedString;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.PropertyName;

/* JADX INFO: renamed from: b.g.a.c.g0.t.j, reason: use source file name */
/* JADX INFO: compiled from: ObjectIdWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ObjectIdWriter {
    public final JavaType a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SerializableString f704b;
    public final ObjectIdGenerator<?> c;
    public final JsonSerializer<Object> d;
    public final boolean e;

    public ObjectIdWriter(JavaType javaType, SerializableString serializableString, ObjectIdGenerator<?> objectIdGenerator, JsonSerializer<?> jsonSerializer, boolean z2) {
        this.a = javaType;
        this.f704b = serializableString;
        this.c = objectIdGenerator;
        this.d = jsonSerializer;
        this.e = z2;
    }

    public static ObjectIdWriter a(JavaType javaType, PropertyName propertyName, ObjectIdGenerator<?> objectIdGenerator, boolean z2) {
        String str = propertyName == null ? null : propertyName._simpleName;
        return new ObjectIdWriter(javaType, str != null ? new SerializedString(str) : null, objectIdGenerator, null, z2);
    }
}

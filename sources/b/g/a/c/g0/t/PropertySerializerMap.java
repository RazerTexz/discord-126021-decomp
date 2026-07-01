package b.g.a.c.g0.t;

import b.g.a.c.BeanProperty;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializerProvider;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.util.Arrays;

/* JADX INFO: renamed from: b.g.a.c.g0.t.l, reason: use source file name */
/* JADX INFO: compiled from: PropertySerializerMap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PropertySerializerMap {
    public final boolean a;

    /* JADX INFO: renamed from: b.g.a.c.g0.t.l$a */
    /* JADX INFO: compiled from: PropertySerializerMap.java */
    public static final class a extends PropertySerializerMap {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<?> f705b;
        public final Class<?> c;
        public final JsonSerializer<Object> d;
        public final JsonSerializer<Object> e;

        public a(PropertySerializerMap propertySerializerMap, Class<?> cls, JsonSerializer<Object> jsonSerializer, Class<?> cls2, JsonSerializer<Object> jsonSerializer2) {
            super(propertySerializerMap);
            this.f705b = cls;
            this.d = jsonSerializer;
            this.c = cls2;
            this.e = jsonSerializer2;
        }

        @Override // b.g.a.c.g0.t.PropertySerializerMap
        public PropertySerializerMap b(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            return new c(this, new f[]{new f(this.f705b, this.d), new f(this.c, this.e), new f(cls, jsonSerializer)});
        }

        @Override // b.g.a.c.g0.t.PropertySerializerMap
        public JsonSerializer<Object> c(Class<?> cls) {
            if (cls == this.f705b) {
                return this.d;
            }
            if (cls == this.c) {
                return this.e;
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.t.l$b */
    /* JADX INFO: compiled from: PropertySerializerMap.java */
    public static final class b extends PropertySerializerMap {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f706b = new b(false);

        public b(boolean z2) {
            super(z2);
        }

        @Override // b.g.a.c.g0.t.PropertySerializerMap
        public PropertySerializerMap b(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            return new e(this, cls, jsonSerializer);
        }

        @Override // b.g.a.c.g0.t.PropertySerializerMap
        public JsonSerializer<Object> c(Class<?> cls) {
            return null;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.t.l$c */
    /* JADX INFO: compiled from: PropertySerializerMap.java */
    public static final class c extends PropertySerializerMap {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f[] f707b;

        public c(PropertySerializerMap propertySerializerMap, f[] fVarArr) {
            super(propertySerializerMap);
            this.f707b = fVarArr;
        }

        @Override // b.g.a.c.g0.t.PropertySerializerMap
        public PropertySerializerMap b(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            f[] fVarArr = this.f707b;
            int length = fVarArr.length;
            if (length == 8) {
                return this.a ? new e(this, cls, jsonSerializer) : this;
            }
            f[] fVarArr2 = (f[]) Arrays.copyOf(fVarArr, length + 1);
            fVarArr2[length] = new f(cls, jsonSerializer);
            return new c(this, fVarArr2);
        }

        @Override // b.g.a.c.g0.t.PropertySerializerMap
        public JsonSerializer<Object> c(Class<?> cls) {
            f[] fVarArr = this.f707b;
            f fVar = fVarArr[0];
            if (fVar.a == cls) {
                return fVar.f710b;
            }
            f fVar2 = fVarArr[1];
            if (fVar2.a == cls) {
                return fVar2.f710b;
            }
            f fVar3 = fVarArr[2];
            if (fVar3.a == cls) {
                return fVar3.f710b;
            }
            switch (fVarArr.length) {
                case 8:
                    f fVar4 = fVarArr[7];
                    if (fVar4.a == cls) {
                        return fVar4.f710b;
                    }
                case 7:
                    f fVar5 = fVarArr[6];
                    if (fVar5.a == cls) {
                        return fVar5.f710b;
                    }
                case 6:
                    f fVar6 = fVarArr[5];
                    if (fVar6.a == cls) {
                        return fVar6.f710b;
                    }
                case 5:
                    f fVar7 = fVarArr[4];
                    if (fVar7.a == cls) {
                        return fVar7.f710b;
                    }
                case 4:
                    f fVar8 = fVarArr[3];
                    if (fVar8.a == cls) {
                        return fVar8.f710b;
                    }
                    return null;
                default:
                    return null;
            }
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.t.l$d */
    /* JADX INFO: compiled from: PropertySerializerMap.java */
    public static final class d {
        public final JsonSerializer<Object> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PropertySerializerMap f708b;

        public d(JsonSerializer<Object> jsonSerializer, PropertySerializerMap propertySerializerMap) {
            this.a = jsonSerializer;
            this.f708b = propertySerializerMap;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.t.l$e */
    /* JADX INFO: compiled from: PropertySerializerMap.java */
    public static final class e extends PropertySerializerMap {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<?> f709b;
        public final JsonSerializer<Object> c;

        public e(PropertySerializerMap propertySerializerMap, Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            super(propertySerializerMap);
            this.f709b = cls;
            this.c = jsonSerializer;
        }

        @Override // b.g.a.c.g0.t.PropertySerializerMap
        public PropertySerializerMap b(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            return new a(this, this.f709b, this.c, cls, jsonSerializer);
        }

        @Override // b.g.a.c.g0.t.PropertySerializerMap
        public JsonSerializer<Object> c(Class<?> cls) {
            if (cls == this.f709b) {
                return this.c;
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.t.l$f */
    /* JADX INFO: compiled from: PropertySerializerMap.java */
    public static final class f {
        public final Class<?> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final JsonSerializer<Object> f710b;

        public f(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            this.a = cls;
            this.f710b = jsonSerializer;
        }
    }

    public PropertySerializerMap(boolean z2) {
        this.a = z2;
    }

    public final d a(JavaType javaType, SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerM = serializerProvider.m(javaType, beanProperty);
        return new d(jsonSerializerM, b(javaType._class, jsonSerializerM));
    }

    public abstract PropertySerializerMap b(Class<?> cls, JsonSerializer<Object> jsonSerializer);

    public abstract JsonSerializer<Object> c(Class<?> cls);

    public PropertySerializerMap(PropertySerializerMap propertySerializerMap) {
        this.a = propertySerializerMap.a;
    }
}

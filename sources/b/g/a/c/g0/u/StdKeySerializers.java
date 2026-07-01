package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializationFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.g0.t.PropertySerializerMap;
import b.g.a.c.h0.TypeFactory;
import b.g.a.c.i0.EnumValues;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.g0.u.o0, reason: use source file name */
/* JADX INFO: compiled from: StdKeySerializers.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class StdKeySerializers {
    public static final JsonSerializer<Object> a = new d();

    /* JADX INFO: renamed from: b.g.a.c.g0.u.o0$a */
    /* JADX INFO: compiled from: StdKeySerializers.java */
    public static class a extends StdSerializer<Object> {
        public final int _typeId;

        public a(int i, Class<?> cls) {
            super(cls, false);
            this._typeId = i;
        }

        @Override // b.g.a.c.JsonSerializer
        public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            String strValueOf;
            switch (this._typeId) {
                case 1:
                    Date date = (Date) obj;
                    Objects.requireNonNull(serializerProvider);
                    if (!serializerProvider.D(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
                        jsonGenerator.y(serializerProvider.j().format(date));
                    } else {
                        jsonGenerator.y(String.valueOf(date.getTime()));
                    }
                    break;
                case 2:
                    long timeInMillis = ((Calendar) obj).getTimeInMillis();
                    Objects.requireNonNull(serializerProvider);
                    if (!serializerProvider.D(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
                        jsonGenerator.y(serializerProvider.j().format(new Date(timeInMillis)));
                    } else {
                        jsonGenerator.y(String.valueOf(timeInMillis));
                    }
                    break;
                case 3:
                    jsonGenerator.y(((Class) obj).getName());
                    break;
                case 4:
                    if (serializerProvider.D(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)) {
                        strValueOf = obj.toString();
                    } else {
                        Enum r3 = (Enum) obj;
                        strValueOf = serializerProvider.D(SerializationFeature.WRITE_ENUM_KEYS_USING_INDEX) ? String.valueOf(r3.ordinal()) : r3.name();
                    }
                    jsonGenerator.y(strValueOf);
                    break;
                case 5:
                case 6:
                    long jLongValue = ((Number) obj).longValue();
                    Objects.requireNonNull(jsonGenerator);
                    jsonGenerator.y(Long.toString(jLongValue));
                    break;
                case 7:
                    jsonGenerator.y(serializerProvider._config._base._defaultBase64.a((byte[]) obj));
                    break;
                default:
                    jsonGenerator.y(obj.toString());
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.o0$b */
    /* JADX INFO: compiled from: StdKeySerializers.java */
    public static class b extends StdSerializer<Object> {
        public transient PropertySerializerMap k;

        public b() {
            super(String.class, false);
            this.k = PropertySerializerMap.b.f706b;
        }

        @Override // b.g.a.c.JsonSerializer
        public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            Class<?> cls = obj.getClass();
            PropertySerializerMap propertySerializerMap = this.k;
            JsonSerializer<Object> jsonSerializerC = propertySerializerMap.c(cls);
            if (jsonSerializerC == null) {
                if (cls == Object.class) {
                    jsonSerializerC = new a(8, cls);
                    this.k = propertySerializerMap.b(cls, jsonSerializerC);
                } else {
                    jsonSerializerC = serializerProvider.o(serializerProvider._config._base._typeFactory.b(null, cls, TypeFactory.l), null);
                    PropertySerializerMap propertySerializerMapB = propertySerializerMap.b(cls, jsonSerializerC);
                    if (propertySerializerMap != propertySerializerMapB) {
                        this.k = propertySerializerMapB;
                    }
                }
            }
            jsonSerializerC.f(obj, jsonGenerator, serializerProvider);
        }

        public Object readResolve() {
            this.k = PropertySerializerMap.b.f706b;
            return this;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.o0$c */
    /* JADX INFO: compiled from: StdKeySerializers.java */
    public static class c extends StdSerializer<Object> {
        public final EnumValues _values;

        public c(Class<?> cls, EnumValues enumValues) {
            super(cls, false);
            this._values = enumValues;
        }

        @Override // b.g.a.c.JsonSerializer
        public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (serializerProvider.D(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)) {
                jsonGenerator.y(obj.toString());
                return;
            }
            Enum<?> r2 = (Enum) obj;
            if (serializerProvider.D(SerializationFeature.WRITE_ENUM_KEYS_USING_INDEX)) {
                jsonGenerator.y(String.valueOf(r2.ordinal()));
            } else {
                jsonGenerator.x(this._values.c(r2));
            }
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.o0$d */
    /* JADX INFO: compiled from: StdKeySerializers.java */
    public static class d extends StdSerializer<Object> {
        public d() {
            super(String.class, false);
        }

        @Override // b.g.a.c.JsonSerializer
        public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.y((String) obj);
        }
    }
}

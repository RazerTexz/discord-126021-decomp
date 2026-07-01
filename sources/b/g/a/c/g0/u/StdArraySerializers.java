package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonToken2;
import b.g.a.b.s.WritableTypeId;
import b.g.a.c.BeanProperty;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializationFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.ContainerSerializer;
import b.g.a.c.h0.TypeFactory;
import b.g.a.c.y.JacksonStdImpl;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.g0.u.i0, reason: use source file name */
/* JADX INFO: compiled from: StdArraySerializers.java */
/* JADX INFO: loaded from: classes3.dex */
public class StdArraySerializers {
    public static final HashMap<String, JsonSerializer<?>> a;

    /* JADX INFO: renamed from: b.g.a.c.g0.u.i0$a */
    /* JADX INFO: compiled from: StdArraySerializers.java */
    @JacksonStdImpl
    public static class a extends ArraySerializerBase<boolean[]> {
        static {
            TypeFactory.k.j(Boolean.class);
        }

        public a() {
            super(boolean[].class);
        }

        @Override // b.g.a.c.JsonSerializer
        public boolean d(SerializerProvider serializerProvider, Object obj) {
            return ((boolean[]) obj).length == 0;
        }

        @Override // b.g.a.c.g0.u.ArraySerializerBase, b.g.a.c.JsonSerializer
        public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            boolean[] zArr = (boolean[]) obj;
            int length = zArr.length;
            if (length == 1 && r(serializerProvider)) {
                u(zArr, jsonGenerator);
                return;
            }
            jsonGenerator.b0(zArr, length);
            u(zArr, jsonGenerator);
            jsonGenerator.t();
        }

        @Override // b.g.a.c.g0.ContainerSerializer
        public ContainerSerializer<?> p(TypeSerializer typeSerializer) {
            return this;
        }

        @Override // b.g.a.c.g0.ContainerSerializer
        public boolean q(Object obj) {
            return ((boolean[]) obj).length == 1;
        }

        @Override // b.g.a.c.g0.u.ArraySerializerBase
        public JsonSerializer<?> s(BeanProperty beanProperty, Boolean bool) {
            return new a(this, beanProperty, bool);
        }

        @Override // b.g.a.c.g0.u.ArraySerializerBase
        public /* bridge */ /* synthetic */ void t(boolean[] zArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            u(zArr, jsonGenerator);
        }

        public void u(boolean[] zArr, JsonGenerator jsonGenerator) throws IOException {
            for (boolean z2 : zArr) {
                jsonGenerator.s(z2);
            }
        }

        public a(a aVar, BeanProperty beanProperty, Boolean bool) {
            super(aVar, beanProperty, bool);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.i0$b */
    /* JADX INFO: compiled from: StdArraySerializers.java */
    @JacksonStdImpl
    public static class b extends StdSerializer<char[]> {
        public b() {
            super(char[].class);
        }

        @Override // b.g.a.c.JsonSerializer
        public boolean d(SerializerProvider serializerProvider, Object obj) {
            return ((char[]) obj).length == 0;
        }

        @Override // b.g.a.c.JsonSerializer
        public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            char[] cArr = (char[]) obj;
            if (!serializerProvider.D(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                jsonGenerator.m0(cArr, 0, cArr.length);
                return;
            }
            jsonGenerator.b0(cArr, cArr.length);
            int length = cArr.length;
            for (int i = 0; i < length; i++) {
                jsonGenerator.m0(cArr, i, 1);
            }
            jsonGenerator.t();
        }

        @Override // b.g.a.c.JsonSerializer
        public void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
            WritableTypeId writableTypeIdE;
            char[] cArr = (char[]) obj;
            if (serializerProvider.D(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                writableTypeIdE = typeSerializer.e(jsonGenerator, typeSerializer.d(cArr, JsonToken2.START_ARRAY));
                int length = cArr.length;
                for (int i = 0; i < length; i++) {
                    jsonGenerator.m0(cArr, i, 1);
                }
            } else {
                writableTypeIdE = typeSerializer.e(jsonGenerator, typeSerializer.d(cArr, JsonToken2.VALUE_STRING));
                jsonGenerator.m0(cArr, 0, cArr.length);
            }
            typeSerializer.f(jsonGenerator, writableTypeIdE);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.i0$c */
    /* JADX INFO: compiled from: StdArraySerializers.java */
    @JacksonStdImpl
    public static class c extends ArraySerializerBase<double[]> {
        static {
            TypeFactory.k.j(Double.TYPE);
        }

        public c() {
            super(double[].class);
        }

        @Override // b.g.a.c.JsonSerializer
        public boolean d(SerializerProvider serializerProvider, Object obj) {
            return ((double[]) obj).length == 0;
        }

        @Override // b.g.a.c.g0.u.ArraySerializerBase, b.g.a.c.JsonSerializer
        public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            double[] dArr = (double[]) obj;
            int i = 0;
            if (dArr.length == 1 && r(serializerProvider)) {
                int length = dArr.length;
                while (i < length) {
                    jsonGenerator.C(dArr[i]);
                    i++;
                }
                return;
            }
            int length2 = dArr.length;
            Objects.requireNonNull(jsonGenerator);
            jsonGenerator.a(dArr.length, 0, length2);
            jsonGenerator.b0(dArr, length2);
            int i2 = length2 + 0;
            while (i < i2) {
                jsonGenerator.C(dArr[i]);
                i++;
            }
            jsonGenerator.t();
        }

        @Override // b.g.a.c.g0.ContainerSerializer
        public ContainerSerializer<?> p(TypeSerializer typeSerializer) {
            return this;
        }

        @Override // b.g.a.c.g0.ContainerSerializer
        public boolean q(Object obj) {
            return ((double[]) obj).length == 1;
        }

        @Override // b.g.a.c.g0.u.ArraySerializerBase
        public JsonSerializer<?> s(BeanProperty beanProperty, Boolean bool) {
            return new c(this, beanProperty, bool);
        }

        @Override // b.g.a.c.g0.u.ArraySerializerBase
        public void t(double[] dArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            for (double d : dArr) {
                jsonGenerator.C(d);
            }
        }

        public c(c cVar, BeanProperty beanProperty, Boolean bool) {
            super(cVar, beanProperty, bool);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.i0$d */
    /* JADX INFO: compiled from: StdArraySerializers.java */
    @JacksonStdImpl
    public static class d extends h<float[]> {
        static {
            TypeFactory.k.j(Float.TYPE);
        }

        public d() {
            super(float[].class);
        }

        @Override // b.g.a.c.JsonSerializer
        public boolean d(SerializerProvider serializerProvider, Object obj) {
            return ((float[]) obj).length == 0;
        }

        @Override // b.g.a.c.g0.u.ArraySerializerBase, b.g.a.c.JsonSerializer
        public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            float[] fArr = (float[]) obj;
            int length = fArr.length;
            if (length == 1 && r(serializerProvider)) {
                u(fArr, jsonGenerator);
                return;
            }
            jsonGenerator.b0(fArr, length);
            u(fArr, jsonGenerator);
            jsonGenerator.t();
        }

        @Override // b.g.a.c.g0.ContainerSerializer
        public boolean q(Object obj) {
            return ((float[]) obj).length == 1;
        }

        @Override // b.g.a.c.g0.u.ArraySerializerBase
        public JsonSerializer<?> s(BeanProperty beanProperty, Boolean bool) {
            return new d(this, beanProperty, bool);
        }

        @Override // b.g.a.c.g0.u.ArraySerializerBase
        public /* bridge */ /* synthetic */ void t(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            u((float[]) obj, jsonGenerator);
        }

        public void u(float[] fArr, JsonGenerator jsonGenerator) throws IOException {
            for (float f : fArr) {
                jsonGenerator.D(f);
            }
        }

        public d(d dVar, BeanProperty beanProperty, Boolean bool) {
            super(dVar, beanProperty, bool);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.i0$e */
    /* JADX INFO: compiled from: StdArraySerializers.java */
    @JacksonStdImpl
    public static class e extends ArraySerializerBase<int[]> {
        static {
            TypeFactory.k.j(Integer.TYPE);
        }

        public e() {
            super(int[].class);
        }

        @Override // b.g.a.c.JsonSerializer
        public boolean d(SerializerProvider serializerProvider, Object obj) {
            return ((int[]) obj).length == 0;
        }

        @Override // b.g.a.c.g0.u.ArraySerializerBase, b.g.a.c.JsonSerializer
        public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            int[] iArr = (int[]) obj;
            int i = 0;
            if (iArr.length == 1 && r(serializerProvider)) {
                int length = iArr.length;
                while (i < length) {
                    jsonGenerator.H(iArr[i]);
                    i++;
                }
                return;
            }
            int length2 = iArr.length;
            Objects.requireNonNull(jsonGenerator);
            jsonGenerator.a(iArr.length, 0, length2);
            jsonGenerator.b0(iArr, length2);
            int i2 = length2 + 0;
            while (i < i2) {
                jsonGenerator.H(iArr[i]);
                i++;
            }
            jsonGenerator.t();
        }

        @Override // b.g.a.c.g0.ContainerSerializer
        public ContainerSerializer<?> p(TypeSerializer typeSerializer) {
            return this;
        }

        @Override // b.g.a.c.g0.ContainerSerializer
        public boolean q(Object obj) {
            return ((int[]) obj).length == 1;
        }

        @Override // b.g.a.c.g0.u.ArraySerializerBase
        public JsonSerializer<?> s(BeanProperty beanProperty, Boolean bool) {
            return new e(this, beanProperty, bool);
        }

        @Override // b.g.a.c.g0.u.ArraySerializerBase
        public void t(int[] iArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            for (int i : iArr) {
                jsonGenerator.H(i);
            }
        }

        public e(e eVar, BeanProperty beanProperty, Boolean bool) {
            super(eVar, beanProperty, bool);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.i0$f */
    /* JADX INFO: compiled from: StdArraySerializers.java */
    @JacksonStdImpl
    public static class f extends h<long[]> {
        static {
            TypeFactory.k.j(Long.TYPE);
        }

        public f() {
            super(long[].class);
        }

        @Override // b.g.a.c.JsonSerializer
        public boolean d(SerializerProvider serializerProvider, Object obj) {
            return ((long[]) obj).length == 0;
        }

        @Override // b.g.a.c.g0.u.ArraySerializerBase, b.g.a.c.JsonSerializer
        public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            long[] jArr = (long[]) obj;
            int i = 0;
            if (jArr.length == 1 && r(serializerProvider)) {
                int length = jArr.length;
                while (i < length) {
                    jsonGenerator.I(jArr[i]);
                    i++;
                }
                return;
            }
            int length2 = jArr.length;
            Objects.requireNonNull(jsonGenerator);
            jsonGenerator.a(jArr.length, 0, length2);
            jsonGenerator.b0(jArr, length2);
            int i2 = length2 + 0;
            while (i < i2) {
                jsonGenerator.I(jArr[i]);
                i++;
            }
            jsonGenerator.t();
        }

        @Override // b.g.a.c.g0.ContainerSerializer
        public boolean q(Object obj) {
            return ((long[]) obj).length == 1;
        }

        @Override // b.g.a.c.g0.u.ArraySerializerBase
        public JsonSerializer<?> s(BeanProperty beanProperty, Boolean bool) {
            return new f(this, beanProperty, bool);
        }

        @Override // b.g.a.c.g0.u.ArraySerializerBase
        public void t(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            for (long j : (long[]) obj) {
                jsonGenerator.I(j);
            }
        }

        public f(f fVar, BeanProperty beanProperty, Boolean bool) {
            super(fVar, beanProperty, bool);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.i0$g */
    /* JADX INFO: compiled from: StdArraySerializers.java */
    @JacksonStdImpl
    public static class g extends h<short[]> {
        static {
            TypeFactory.k.j(Short.TYPE);
        }

        public g() {
            super(short[].class);
        }

        @Override // b.g.a.c.JsonSerializer
        public boolean d(SerializerProvider serializerProvider, Object obj) {
            return ((short[]) obj).length == 0;
        }

        @Override // b.g.a.c.g0.u.ArraySerializerBase, b.g.a.c.JsonSerializer
        public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            short[] sArr = (short[]) obj;
            int length = sArr.length;
            if (length == 1 && r(serializerProvider)) {
                u(sArr, jsonGenerator);
                return;
            }
            jsonGenerator.b0(sArr, length);
            u(sArr, jsonGenerator);
            jsonGenerator.t();
        }

        @Override // b.g.a.c.g0.ContainerSerializer
        public boolean q(Object obj) {
            return ((short[]) obj).length == 1;
        }

        @Override // b.g.a.c.g0.u.ArraySerializerBase
        public JsonSerializer<?> s(BeanProperty beanProperty, Boolean bool) {
            return new g(this, beanProperty, bool);
        }

        @Override // b.g.a.c.g0.u.ArraySerializerBase
        public /* bridge */ /* synthetic */ void t(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            u((short[]) obj, jsonGenerator);
        }

        public void u(short[] sArr, JsonGenerator jsonGenerator) throws IOException {
            for (short s2 : sArr) {
                jsonGenerator.H(s2);
            }
        }

        public g(g gVar, BeanProperty beanProperty, Boolean bool) {
            super(gVar, beanProperty, bool);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.i0$h */
    /* JADX INFO: compiled from: StdArraySerializers.java */
    public static abstract class h<T> extends ArraySerializerBase<T> {
        public h(Class<T> cls) {
            super(cls);
        }

        @Override // b.g.a.c.g0.ContainerSerializer
        public final ContainerSerializer<?> p(TypeSerializer typeSerializer) {
            return this;
        }

        public h(h<T> hVar, BeanProperty beanProperty, Boolean bool) {
            super(hVar, beanProperty, bool);
        }
    }

    static {
        HashMap<String, JsonSerializer<?>> map = new HashMap<>();
        a = map;
        map.put(boolean[].class.getName(), new a());
        map.put(byte[].class.getName(), new ByteArraySerializer2());
        map.put(char[].class.getName(), new b());
        map.put(short[].class.getName(), new g());
        map.put(int[].class.getName(), new e());
        map.put(long[].class.getName(), new f());
        map.put(float[].class.getName(), new d());
        map.put(double[].class.getName(), new c());
    }
}

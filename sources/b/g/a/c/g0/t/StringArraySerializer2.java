package b.g.a.c.g0.t;

import b.g.a.a.JsonFormat;
import b.g.a.b.JsonGenerator;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.BeanProperty;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializationFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.c0.AnnotatedMember;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.ContainerSerializer;
import b.g.a.c.g0.ContextualSerializer;
import b.g.a.c.g0.u.ArraySerializerBase;
import b.g.a.c.h0.TypeFactory;
import b.g.a.c.i0.ClassUtil;
import b.g.a.c.y.JacksonStdImpl;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.g0.t.n, reason: use source file name */
/* JADX INFO: compiled from: StringArraySerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class StringArraySerializer2 extends ArraySerializerBase<String[]> implements ContextualSerializer {
    public static final StringArraySerializer2 k;
    public final JsonSerializer<Object> _elementSerializer;

    static {
        TypeFactory.k.j(String.class);
        k = new StringArraySerializer2();
    }

    public StringArraySerializer2() {
        super(String[].class);
        this._elementSerializer = null;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @Override // b.g.a.c.g0.u.ArraySerializerBase, b.g.a.c.g0.ContextualSerializer
    public JsonSerializer<?> a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerH;
        Object objC;
        if (beanProperty != null) {
            AnnotationIntrospector annotationIntrospectorV = serializerProvider.v();
            AnnotatedMember member = beanProperty.getMember();
            if (member == null || (objC = annotationIntrospectorV.c(member)) == null) {
                jsonSerializerH = null;
            } else {
                jsonSerializerH = serializerProvider.H(member, objC);
            }
        } else {
            jsonSerializerH = null;
        }
        JsonFormat.a aVar = JsonFormat.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED;
        JsonFormat.d dVarL = l(serializerProvider, beanProperty, String[].class);
        Boolean boolB = dVarL != null ? dVarL.b(aVar) : null;
        if (jsonSerializerH == null) {
            jsonSerializerH = this._elementSerializer;
        }
        JsonSerializer<?> jsonSerializerK = k(serializerProvider, beanProperty, jsonSerializerH);
        if (jsonSerializerK == null) {
            jsonSerializerK = serializerProvider.n(String.class, beanProperty);
        }
        JsonSerializer<?> jsonSerializer = ClassUtil.s(jsonSerializerK) ? null : jsonSerializerK;
        return (jsonSerializer == this._elementSerializer && Objects.equals(boolB, this._unwrapSingle)) ? this : new StringArraySerializer2(this, beanProperty, jsonSerializer, boolB);
    }

    @Override // b.g.a.c.JsonSerializer
    public boolean d(SerializerProvider serializerProvider, Object obj) {
        return ((String[]) obj).length == 0;
    }

    @Override // b.g.a.c.g0.u.ArraySerializerBase, b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String[] strArr = (String[]) obj;
        int length = strArr.length;
        if (length == 1 && ((this._unwrapSingle == null && serializerProvider.D(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            t(strArr, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.b0(strArr, length);
        t(strArr, jsonGenerator, serializerProvider);
        jsonGenerator.t();
    }

    @Override // b.g.a.c.g0.ContainerSerializer
    public ContainerSerializer<?> p(TypeSerializer typeSerializer) {
        return this;
    }

    @Override // b.g.a.c.g0.ContainerSerializer
    public boolean q(Object obj) {
        return ((String[]) obj).length == 1;
    }

    @Override // b.g.a.c.g0.u.ArraySerializerBase
    public JsonSerializer<?> s(BeanProperty beanProperty, Boolean bool) {
        return new StringArraySerializer2(this, beanProperty, this._elementSerializer, bool);
    }

    @Override // b.g.a.c.g0.u.ArraySerializerBase
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void t(String[] strArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        int length = strArr.length;
        if (length == 0) {
            return;
        }
        JsonSerializer<Object> jsonSerializer = this._elementSerializer;
        int i = 0;
        if (jsonSerializer == null) {
            while (i < length) {
                if (strArr[i] == null) {
                    jsonGenerator.A();
                } else {
                    jsonGenerator.j0(strArr[i]);
                }
                i++;
            }
            return;
        }
        int length2 = strArr.length;
        while (i < length2) {
            if (strArr[i] == null) {
                serializerProvider.l(jsonGenerator);
            } else {
                jsonSerializer.f(strArr[i], jsonGenerator, serializerProvider);
            }
            i++;
        }
    }

    public StringArraySerializer2(StringArraySerializer2 stringArraySerializer2, BeanProperty beanProperty, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super(stringArraySerializer2, beanProperty, bool);
        this._elementSerializer = jsonSerializer;
    }
}

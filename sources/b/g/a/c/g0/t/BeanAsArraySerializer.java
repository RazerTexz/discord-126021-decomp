package b.g.a.c.g0.t;

import b.d.b.a.outline;
import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonToken2;
import b.g.a.b.s.WritableTypeId;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializationFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.BeanPropertyWriter;
import b.g.a.c.g0.u.BeanSerializerBase;
import b.g.a.c.i0.NameTransformer4;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Set;

/* JADX INFO: renamed from: b.g.a.c.g0.t.b, reason: use source file name */
/* JADX INFO: compiled from: BeanAsArraySerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class BeanAsArraySerializer extends BeanSerializerBase {
    private static final long serialVersionUID = 1;
    public final BeanSerializerBase _defaultSerializer;

    public BeanAsArraySerializer(BeanSerializerBase beanSerializerBase, Set<String> set, Set<String> set2) {
        super(beanSerializerBase, set, set2);
        this._defaultSerializer = beanSerializerBase;
    }

    @Override // b.g.a.c.JsonSerializer
    public final void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (serializerProvider.D(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) {
            BeanPropertyWriter[] beanPropertyWriterArr = this._filteredProps;
            if (beanPropertyWriterArr == null || serializerProvider._serializationView == null) {
                beanPropertyWriterArr = this._props;
            }
            if (beanPropertyWriterArr.length == 1) {
                z(obj, jsonGenerator, serializerProvider);
                return;
            }
        }
        jsonGenerator.X(obj);
        z(obj, jsonGenerator, serializerProvider);
        jsonGenerator.t();
    }

    @Override // b.g.a.c.g0.u.BeanSerializerBase, b.g.a.c.JsonSerializer
    public void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        if (this._objectIdWriter != null) {
            p(obj, jsonGenerator, serializerProvider, typeSerializer);
            return;
        }
        WritableTypeId writableTypeIdR = r(typeSerializer, obj, JsonToken2.START_ARRAY);
        typeSerializer.e(jsonGenerator, writableTypeIdR);
        jsonGenerator.e(obj);
        z(obj, jsonGenerator, serializerProvider);
        typeSerializer.f(jsonGenerator, writableTypeIdR);
    }

    @Override // b.g.a.c.JsonSerializer
    public JsonSerializer<Object> h(NameTransformer4 nameTransformer4) {
        return this._defaultSerializer.h(nameTransformer4);
    }

    @Override // b.g.a.c.g0.u.BeanSerializerBase
    public BeanSerializerBase s() {
        return this;
    }

    public String toString() {
        StringBuilder sbU = outline.U("BeanAsArraySerializer for ");
        sbU.append(this._handledType.getName());
        return sbU.toString();
    }

    @Override // b.g.a.c.g0.u.BeanSerializerBase
    public BeanSerializerBase v(Set set, Set set2) {
        return new BeanAsArraySerializer(this, (Set<String>) set, (Set<String>) set2);
    }

    @Override // b.g.a.c.g0.u.BeanSerializerBase
    public BeanSerializerBase w(Object obj) {
        return new BeanAsArraySerializer(this, this._objectIdWriter, obj);
    }

    @Override // b.g.a.c.g0.u.BeanSerializerBase
    public BeanSerializerBase x(ObjectIdWriter objectIdWriter) {
        return this._defaultSerializer.x(objectIdWriter);
    }

    @Override // b.g.a.c.g0.u.BeanSerializerBase
    public BeanSerializerBase y(BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        return this;
    }

    public final void z(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        BeanPropertyWriter[] beanPropertyWriterArr = this._filteredProps;
        if (beanPropertyWriterArr == null || serializerProvider._serializationView == null) {
            beanPropertyWriterArr = this._props;
        }
        int i = 0;
        try {
            int length = beanPropertyWriterArr.length;
            while (i < length) {
                BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
                if (beanPropertyWriter == null) {
                    jsonGenerator.A();
                } else {
                    beanPropertyWriter.h(obj, jsonGenerator, serializerProvider);
                }
                i++;
            }
        } catch (Exception e) {
            o(serializerProvider, e, obj, i != beanPropertyWriterArr.length ? beanPropertyWriterArr[i]._name._value : "[anySetter]");
            throw null;
        } catch (StackOverflowError e2) {
            JsonMappingException jsonMappingException = new JsonMappingException(jsonGenerator, "Infinite recursion (StackOverflowError)", e2);
            jsonMappingException.e(new JsonMappingException.a(obj, i != beanPropertyWriterArr.length ? beanPropertyWriterArr[i]._name._value : "[anySetter]"));
            throw jsonMappingException;
        }
    }

    public BeanAsArraySerializer(BeanSerializerBase beanSerializerBase, ObjectIdWriter objectIdWriter, Object obj) {
        super(beanSerializerBase, objectIdWriter, obj);
        this._defaultSerializer = beanSerializerBase;
    }

    public BeanAsArraySerializer(BeanSerializerBase beanSerializerBase) {
        super(beanSerializerBase, (ObjectIdWriter) null, beanSerializerBase._propertyFilterId);
        this._defaultSerializer = beanSerializerBase;
    }
}

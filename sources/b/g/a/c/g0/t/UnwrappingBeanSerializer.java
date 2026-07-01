package b.g.a.c.g0.t;

import b.d.b.a.outline;
import b.g.a.b.JsonGenerator;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializationFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.BeanPropertyWriter;
import b.g.a.c.g0.u.BeanSerializerBase;
import b.g.a.c.i0.NameTransformer4;
import java.io.IOException;
import java.io.Serializable;
import java.util.Set;

/* JADX INFO: renamed from: b.g.a.c.g0.t.t, reason: use source file name */
/* JADX INFO: compiled from: UnwrappingBeanSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class UnwrappingBeanSerializer extends BeanSerializerBase implements Serializable {
    private static final long serialVersionUID = 1;
    public final NameTransformer4 _nameTransformer;

    public UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingBeanSerializer, ObjectIdWriter objectIdWriter, Object obj) {
        super(unwrappingBeanSerializer, objectIdWriter, obj);
        this._nameTransformer = unwrappingBeanSerializer._nameTransformer;
    }

    @Override // b.g.a.c.JsonSerializer
    public final void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.e(obj);
        if (this._objectIdWriter != null) {
            q(obj, jsonGenerator, serializerProvider, false);
            return;
        }
        Object obj2 = this._propertyFilterId;
        if (obj2 == null) {
            u(obj, jsonGenerator, serializerProvider);
            return;
        }
        if (this._filteredProps != null) {
            Class<?> cls = serializerProvider._serializationView;
        }
        m(serializerProvider, obj2, obj);
        throw null;
    }

    @Override // b.g.a.c.g0.u.BeanSerializerBase, b.g.a.c.JsonSerializer
    public void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        if (serializerProvider.D(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS)) {
            serializerProvider.g(this._handledType, "Unwrapped property requires use of type information: cannot serialize without disabling `SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS`");
        }
        jsonGenerator.e(obj);
        if (this._objectIdWriter != null) {
            p(obj, jsonGenerator, serializerProvider, typeSerializer);
            return;
        }
        Object obj2 = this._propertyFilterId;
        if (obj2 == null) {
            u(obj, jsonGenerator, serializerProvider);
        } else {
            BeanPropertyWriter[] beanPropertyWriterArr = this._filteredProps;
            m(serializerProvider, obj2, obj);
            throw null;
        }
    }

    @Override // b.g.a.c.JsonSerializer
    public JsonSerializer<Object> h(NameTransformer4 nameTransformer4) {
        return new UnwrappingBeanSerializer(this, nameTransformer4);
    }

    @Override // b.g.a.c.g0.u.BeanSerializerBase
    public BeanSerializerBase s() {
        return this;
    }

    public String toString() {
        StringBuilder sbU = outline.U("UnwrappingBeanSerializer for ");
        sbU.append(this._handledType.getName());
        return sbU.toString();
    }

    @Override // b.g.a.c.g0.u.BeanSerializerBase
    public BeanSerializerBase v(Set<String> set, Set<String> set2) {
        return new UnwrappingBeanSerializer(this, set, set2);
    }

    @Override // b.g.a.c.g0.u.BeanSerializerBase
    public BeanSerializerBase w(Object obj) {
        return new UnwrappingBeanSerializer(this, this._objectIdWriter, obj);
    }

    @Override // b.g.a.c.g0.u.BeanSerializerBase
    public BeanSerializerBase x(ObjectIdWriter objectIdWriter) {
        return new UnwrappingBeanSerializer(this, objectIdWriter);
    }

    @Override // b.g.a.c.g0.u.BeanSerializerBase
    public BeanSerializerBase y(BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        return new UnwrappingBeanSerializer(this, beanPropertyWriterArr, beanPropertyWriterArr2);
    }

    public UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingBeanSerializer, Set<String> set, Set<String> set2) {
        super(unwrappingBeanSerializer, set, set2);
        this._nameTransformer = unwrappingBeanSerializer._nameTransformer;
    }

    public UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingBeanSerializer, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        super(unwrappingBeanSerializer, beanPropertyWriterArr, beanPropertyWriterArr2);
        this._nameTransformer = unwrappingBeanSerializer._nameTransformer;
    }

    public UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingBeanSerializer, ObjectIdWriter objectIdWriter) {
        super(unwrappingBeanSerializer, objectIdWriter, unwrappingBeanSerializer._propertyFilterId);
        this._nameTransformer = unwrappingBeanSerializer._nameTransformer;
    }

    public UnwrappingBeanSerializer(BeanSerializerBase beanSerializerBase, NameTransformer4 nameTransformer4) {
        super(beanSerializerBase, BeanSerializerBase.t(beanSerializerBase._props, nameTransformer4), BeanSerializerBase.t(beanSerializerBase._filteredProps, nameTransformer4));
        this._nameTransformer = nameTransformer4;
    }
}

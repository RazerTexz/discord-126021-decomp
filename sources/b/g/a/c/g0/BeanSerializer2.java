package b.g.a.c.g0;

import b.d.b.a.outline;
import b.g.a.b.JsonGenerator;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializerProvider;
import b.g.a.c.g0.t.BeanAsArraySerializer;
import b.g.a.c.g0.t.ObjectIdWriter;
import b.g.a.c.g0.t.UnwrappingBeanSerializer;
import b.g.a.c.g0.u.BeanSerializerBase;
import b.g.a.c.i0.NameTransformer4;
import java.io.IOException;
import java.util.Set;

/* JADX INFO: renamed from: b.g.a.c.g0.d, reason: use source file name */
/* JADX INFO: compiled from: BeanSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class BeanSerializer2 extends BeanSerializerBase {
    private static final long serialVersionUID = 29;

    public BeanSerializer2(JavaType javaType, BeanSerializerBuilder beanSerializerBuilder, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        super(javaType, beanSerializerBuilder, beanPropertyWriterArr, beanPropertyWriterArr2);
    }

    @Override // b.g.a.c.JsonSerializer
    public final void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (this._objectIdWriter != null) {
            jsonGenerator.e(obj);
            q(obj, jsonGenerator, serializerProvider, true);
            return;
        }
        jsonGenerator.d0(obj);
        Object obj2 = this._propertyFilterId;
        if (obj2 == null) {
            u(obj, jsonGenerator, serializerProvider);
            jsonGenerator.u();
        } else {
            if (this._filteredProps != null) {
                Class<?> cls = serializerProvider._serializationView;
            }
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
        return (this._objectIdWriter == null && this._anyGetterWriter == null && this._propertyFilterId == null) ? new BeanAsArraySerializer(this) : this;
    }

    public String toString() {
        StringBuilder sbU = outline.U("BeanSerializer for ");
        sbU.append(this._handledType.getName());
        return sbU.toString();
    }

    @Override // b.g.a.c.g0.u.BeanSerializerBase
    public BeanSerializerBase v(Set<String> set, Set<String> set2) {
        return new BeanSerializer2(this, set, set2);
    }

    @Override // b.g.a.c.g0.u.BeanSerializerBase
    public BeanSerializerBase w(Object obj) {
        return new BeanSerializer2(this, this._objectIdWriter, obj);
    }

    @Override // b.g.a.c.g0.u.BeanSerializerBase
    public BeanSerializerBase x(ObjectIdWriter objectIdWriter) {
        return new BeanSerializer2(this, objectIdWriter, this._propertyFilterId);
    }

    @Override // b.g.a.c.g0.u.BeanSerializerBase
    public BeanSerializerBase y(BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        return new BeanSerializer2(this, beanPropertyWriterArr, beanPropertyWriterArr2);
    }

    public BeanSerializer2(BeanSerializerBase beanSerializerBase, ObjectIdWriter objectIdWriter, Object obj) {
        super(beanSerializerBase, objectIdWriter, obj);
    }

    public BeanSerializer2(BeanSerializerBase beanSerializerBase, Set<String> set, Set<String> set2) {
        super(beanSerializerBase, set, set2);
    }

    public BeanSerializer2(BeanSerializerBase beanSerializerBase, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        super(beanSerializerBase, beanPropertyWriterArr, beanPropertyWriterArr2);
    }
}

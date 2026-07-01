package b.g.a.c.g0.t;

import b.g.a.b.JsonGenerator;
import b.g.a.c.JavaType;
import b.g.a.c.SerializerProvider;
import b.g.a.c.c0.AnnotatedClass;
import b.g.a.c.c0.BeanPropertyDefinition;
import b.g.a.c.g0.VirtualBeanPropertyWriter;
import b.g.a.c.i0.Annotations;
import b.g.a.c.z.MapperConfig;

/* JADX INFO: renamed from: b.g.a.c.g0.t.a, reason: use source file name */
/* JADX INFO: compiled from: AttributePropertyWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class AttributePropertyWriter extends VirtualBeanPropertyWriter {
    private static final long serialVersionUID = 1;
    public final String _attrName;

    public AttributePropertyWriter(String str, BeanPropertyDefinition beanPropertyDefinition, Annotations annotations, JavaType javaType) {
        super(beanPropertyDefinition, annotations, javaType, null, null, null, beanPropertyDefinition.g(), null);
        this._attrName = str;
    }

    @Override // b.g.a.c.g0.VirtualBeanPropertyWriter
    public Object j(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        return serializerProvider.w(this._attrName);
    }

    @Override // b.g.a.c.g0.VirtualBeanPropertyWriter
    public VirtualBeanPropertyWriter k(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, BeanPropertyDefinition beanPropertyDefinition, JavaType javaType) {
        throw new IllegalStateException("Should not be called on this type");
    }
}

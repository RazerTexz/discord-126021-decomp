package b.g.a.c.g0.t;

import b.d.b.a.outline;
import b.g.a.a.ObjectIdGenerator;
import b.g.a.a.ObjectIdGenerators3;
import b.g.a.c.c0.ObjectIdInfo;
import b.g.a.c.g0.BeanPropertyWriter;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: b.g.a.c.g0.t.k, reason: use source file name */
/* JADX INFO: compiled from: PropertyBasedObjectIdGenerator.java */
/* JADX INFO: loaded from: classes3.dex */
public class PropertyBasedObjectIdGenerator extends ObjectIdGenerators3 {
    private static final long serialVersionUID = 1;
    public final BeanPropertyWriter _property;

    public PropertyBasedObjectIdGenerator(Class<?> cls, BeanPropertyWriter beanPropertyWriter) {
        super(cls);
        this._property = beanPropertyWriter;
    }

    @Override // b.g.a.a.ObjectIdGenerators, b.g.a.a.ObjectIdGenerator
    public boolean a(ObjectIdGenerator<?> objectIdGenerator) {
        if (objectIdGenerator.getClass() != PropertyBasedObjectIdGenerator.class) {
            return false;
        }
        PropertyBasedObjectIdGenerator propertyBasedObjectIdGenerator = (PropertyBasedObjectIdGenerator) objectIdGenerator;
        return propertyBasedObjectIdGenerator._scope == this._scope && propertyBasedObjectIdGenerator._property == this._property;
    }

    @Override // b.g.a.a.ObjectIdGenerator
    public ObjectIdGenerator<Object> b(Class<?> cls) {
        return cls == this._scope ? this : new PropertyBasedObjectIdGenerator(cls, this._property);
    }

    @Override // b.g.a.a.ObjectIdGenerator
    public Object c(Object obj) {
        try {
            BeanPropertyWriter beanPropertyWriter = this._property;
            Method method = beanPropertyWriter.l;
            return method == null ? beanPropertyWriter.m.get(obj) : method.invoke(obj, null);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            StringBuilder sbU = outline.U("Problem accessing property '");
            sbU.append(this._property._name._value);
            sbU.append("': ");
            sbU.append(e2.getMessage());
            throw new IllegalStateException(sbU.toString(), e2);
        }
    }

    @Override // b.g.a.a.ObjectIdGenerator
    public ObjectIdGenerator<Object> e(Object obj) {
        return this;
    }

    public PropertyBasedObjectIdGenerator(ObjectIdInfo objectIdInfo, BeanPropertyWriter beanPropertyWriter) {
        super(objectIdInfo.e);
        this._property = beanPropertyWriter;
    }
}

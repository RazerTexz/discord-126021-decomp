package b.g.a.c.g0.t;

import b.g.a.b.JsonGenerator;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializerProvider;
import b.g.a.c.g0.BeanPropertyWriter;
import b.g.a.c.i0.NameTransformer4;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.g0.t.e, reason: use source file name */
/* JADX INFO: compiled from: FilteredBeanPropertyWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FilteredBeanPropertyWriter2 extends BeanPropertyWriter implements Serializable {
    private static final long serialVersionUID = 1;
    public final BeanPropertyWriter _delegate;
    public final Class<?> _view;

    public FilteredBeanPropertyWriter2(BeanPropertyWriter beanPropertyWriter, Class<?> cls) {
        super(beanPropertyWriter, beanPropertyWriter._name);
        this._delegate = beanPropertyWriter;
        this._view = cls;
    }

    @Override // b.g.a.c.g0.BeanPropertyWriter
    public void e(JsonSerializer<Object> jsonSerializer) {
        this._delegate.e(jsonSerializer);
    }

    @Override // b.g.a.c.g0.BeanPropertyWriter
    public void f(JsonSerializer<Object> jsonSerializer) {
        this._delegate.f(jsonSerializer);
    }

    @Override // b.g.a.c.g0.BeanPropertyWriter
    public BeanPropertyWriter g(NameTransformer4 nameTransformer4) {
        return new FilteredBeanPropertyWriter2(this._delegate.g(nameTransformer4), this._view);
    }

    @Override // b.g.a.c.g0.BeanPropertyWriter
    public void h(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        Class<?> cls = serializerProvider._serializationView;
        if (cls == null || this._view.isAssignableFrom(cls)) {
            this._delegate.h(obj, jsonGenerator, serializerProvider);
            return;
        }
        JsonSerializer<Object> jsonSerializer = this._delegate._nullSerializer;
        if (jsonSerializer != null) {
            jsonSerializer.f(null, jsonGenerator, serializerProvider);
        } else {
            jsonGenerator.A();
        }
    }

    @Override // b.g.a.c.g0.BeanPropertyWriter
    public void i(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        Class<?> cls = serializerProvider._serializationView;
        if (cls == null || this._view.isAssignableFrom(cls)) {
            this._delegate.i(obj, jsonGenerator, serializerProvider);
        } else {
            Objects.requireNonNull(this._delegate);
            Objects.requireNonNull(jsonGenerator);
        }
    }
}

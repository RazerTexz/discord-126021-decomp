package b.g.a.c.g0.t;

import b.g.a.b.JsonGenerator;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializerProvider;
import b.g.a.c.g0.BeanPropertyWriter;
import b.g.a.c.i0.NameTransformer4;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.g0.t.d, reason: use source file name */
/* JADX INFO: compiled from: FilteredBeanPropertyWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FilteredBeanPropertyWriter extends BeanPropertyWriter implements Serializable {
    private static final long serialVersionUID = 1;
    public final BeanPropertyWriter _delegate;
    public final Class<?>[] _views;

    public FilteredBeanPropertyWriter(BeanPropertyWriter beanPropertyWriter, Class<?>[] clsArr) {
        super(beanPropertyWriter, beanPropertyWriter._name);
        this._delegate = beanPropertyWriter;
        this._views = clsArr;
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
        return new FilteredBeanPropertyWriter(this._delegate.g(nameTransformer4), this._views);
    }

    @Override // b.g.a.c.g0.BeanPropertyWriter
    public void h(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        if (j(serializerProvider._serializationView)) {
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
        if (j(serializerProvider._serializationView)) {
            this._delegate.i(obj, jsonGenerator, serializerProvider);
        } else {
            Objects.requireNonNull(this._delegate);
            Objects.requireNonNull(jsonGenerator);
        }
    }

    public final boolean j(Class<?> cls) {
        if (cls == null) {
            return true;
        }
        int length = this._views.length;
        for (int i = 0; i < length; i++) {
            if (this._views[i].isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }
}

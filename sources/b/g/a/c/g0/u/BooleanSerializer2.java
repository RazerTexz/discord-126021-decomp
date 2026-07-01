package b.g.a.c.g0.u;

import b.g.a.a.JsonFormat;
import b.g.a.b.JsonGenerator;
import b.g.a.c.BeanProperty;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.ContextualSerializer;
import b.g.a.c.y.JacksonStdImpl;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.c.g0.u.e, reason: use source file name */
/* JADX INFO: compiled from: BooleanSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public final class BooleanSerializer2 extends StdScalarSerializer<Object> implements ContextualSerializer {
    private static final long serialVersionUID = 1;
    public final boolean _forPrimitive;

    /* JADX INFO: renamed from: b.g.a.c.g0.u.e$a */
    /* JADX INFO: compiled from: BooleanSerializer.java */
    public static final class a extends StdScalarSerializer<Object> implements ContextualSerializer {
        private static final long serialVersionUID = 1;
        public final boolean _forPrimitive;

        public a(boolean z2) {
            super(z2 ? Boolean.TYPE : Boolean.class, false);
            this._forPrimitive = z2;
        }

        @Override // b.g.a.c.g0.ContextualSerializer
        public JsonSerializer<?> a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
            JsonFormat.d dVarL = l(serializerProvider, beanProperty, Boolean.class);
            return (dVarL == null || dVarL.e().f()) ? this : new BooleanSerializer2(this._forPrimitive);
        }

        @Override // b.g.a.c.JsonSerializer
        public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.H(!Boolean.FALSE.equals(obj) ? 1 : 0);
        }

        @Override // b.g.a.c.g0.u.StdScalarSerializer, b.g.a.c.JsonSerializer
        public final void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
            jsonGenerator.s(Boolean.TRUE.equals(obj));
        }
    }

    public BooleanSerializer2(boolean z2) {
        super(z2 ? Boolean.TYPE : Boolean.class, false);
        this._forPrimitive = z2;
    }

    @Override // b.g.a.c.g0.ContextualSerializer
    public JsonSerializer<?> a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.d dVarL = l(serializerProvider, beanProperty, Boolean.class);
        return (dVarL == null || !dVarL.e().f()) ? this : new a(this._forPrimitive);
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.s(Boolean.TRUE.equals(obj));
    }

    @Override // b.g.a.c.g0.u.StdScalarSerializer, b.g.a.c.JsonSerializer
    public final void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        jsonGenerator.s(Boolean.TRUE.equals(obj));
    }
}

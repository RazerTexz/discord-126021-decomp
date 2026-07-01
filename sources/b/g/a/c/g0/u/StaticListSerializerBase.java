package b.g.a.c.g0.u;

import b.g.a.a.JsonFormat;
import b.g.a.b.JsonGenerator;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.BeanProperty;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializerProvider;
import b.g.a.c.c0.AnnotatedMember;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.ContextualSerializer;
import b.g.a.c.i0.ClassUtil;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.g0.u.h0, reason: use source file name */
/* JADX INFO: compiled from: StaticListSerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class StaticListSerializerBase<T extends Collection<?>> extends StdSerializer<T> implements ContextualSerializer {
    public final Boolean _unwrapSingle;

    public StaticListSerializerBase(Class<?> cls) {
        super(cls, false);
        this._unwrapSingle = null;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001a  */
    @Override // b.g.a.c.g0.ContextualSerializer
    public JsonSerializer<?> a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<?> jsonSerializerH;
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
        JsonFormat.d dVarL = l(serializerProvider, beanProperty, this._handledType);
        Boolean boolB = dVarL != null ? dVarL.b(JsonFormat.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : null;
        JsonSerializer<?> jsonSerializerK = k(serializerProvider, beanProperty, jsonSerializerH);
        if (jsonSerializerK == null) {
            jsonSerializerK = serializerProvider.n(String.class, beanProperty);
        }
        if (ClassUtil.s(jsonSerializerK)) {
            return Objects.equals(boolB, this._unwrapSingle) ? this : p(beanProperty, boolB);
        }
        return new CollectionSerializer2(serializerProvider.b(String.class), true, null, jsonSerializerK);
    }

    @Override // b.g.a.c.JsonSerializer
    public boolean d(SerializerProvider serializerProvider, Object obj) {
        Collection collection = (Collection) obj;
        return collection == null || collection.size() == 0;
    }

    public abstract JsonSerializer<?> p(BeanProperty beanProperty, Boolean bool);

    @Override // b.g.a.c.JsonSerializer
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public abstract void g(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException;

    public StaticListSerializerBase(StaticListSerializerBase<?> staticListSerializerBase, Boolean bool) {
        super(staticListSerializerBase);
        this._unwrapSingle = bool;
    }
}

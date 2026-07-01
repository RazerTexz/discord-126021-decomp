package b.g.a.c.g0.u;

import b.g.a.a.JsonFormat;
import b.g.a.b.JsonGenerator;
import b.g.a.c.BeanProperty;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializationFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.g0.ContextualSerializer;
import b.g.a.c.i0.EnumValues;
import b.g.a.c.y.JacksonStdImpl;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.g0.u.m, reason: use source file name */
/* JADX INFO: compiled from: EnumSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class EnumSerializer2 extends StdScalarSerializer<Enum<?>> implements ContextualSerializer {
    public static final /* synthetic */ int k = 0;
    private static final long serialVersionUID = 1;
    public final Boolean _serializeAsIndex;
    public final EnumValues _values;

    public EnumSerializer2(EnumValues enumValues, Boolean bool) {
        super(enumValues.b(), false);
        this._values = enumValues;
        this._serializeAsIndex = bool;
    }

    public static Boolean p(Class<?> cls, JsonFormat.d dVar, boolean z2, Boolean bool) {
        JsonFormat.c cVarE = dVar == null ? null : dVar.e();
        if (cVarE == null || cVarE == JsonFormat.c.ANY || cVarE == JsonFormat.c.SCALAR) {
            return bool;
        }
        if (cVarE == JsonFormat.c.STRING || cVarE == JsonFormat.c.NATURAL) {
            return Boolean.FALSE;
        }
        if (cVarE.f() || cVarE == JsonFormat.c.ARRAY) {
            return Boolean.TRUE;
        }
        Object[] objArr = new Object[3];
        objArr[0] = cVarE;
        objArr[1] = cls.getName();
        objArr[2] = z2 ? "class" : "property";
        throw new IllegalArgumentException(String.format("Unsupported serialization shape (%s) for Enum %s, not supported as %s annotation", objArr));
    }

    @Override // b.g.a.c.g0.ContextualSerializer
    public JsonSerializer<?> a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.d dVarL = l(serializerProvider, beanProperty, this._handledType);
        if (dVarL != null) {
            Boolean boolP = p(this._handledType, dVarL, false, this._serializeAsIndex);
            if (!Objects.equals(boolP, this._serializeAsIndex)) {
                return new EnumSerializer2(this._values, boolP);
            }
        }
        return this;
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Enum<?> r2 = (Enum) obj;
        Boolean bool = this._serializeAsIndex;
        if (bool != null ? bool.booleanValue() : serializerProvider.D(SerializationFeature.WRITE_ENUMS_USING_INDEX)) {
            jsonGenerator.H(r2.ordinal());
        } else if (serializerProvider.D(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)) {
            jsonGenerator.j0(r2.toString());
        } else {
            jsonGenerator.g0(this._values.c(r2));
        }
    }
}

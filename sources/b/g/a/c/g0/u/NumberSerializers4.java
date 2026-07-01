package b.g.a.c.g0.u;

import b.g.a.a.JsonFormat;
import b.g.a.b.JsonParser;
import b.g.a.c.BeanProperty;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializerProvider;
import b.g.a.c.g0.ContextualSerializer;
import b.g.a.c.g0.u.NumberSerializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.math.BigDecimal;

/* JADX INFO: renamed from: b.g.a.c.g0.u.w, reason: use source file name */
/* JADX INFO: compiled from: NumberSerializers.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class NumberSerializers4<T> extends StdScalarSerializer<T> implements ContextualSerializer {
    public final boolean _isInt;
    public final JsonParser.b _numberType;
    public final String _schemaType;

    public NumberSerializers4(Class<?> cls, JsonParser.b bVar, String str) {
        super(cls, false);
        this._numberType = bVar;
        this._schemaType = str;
        this._isInt = bVar == JsonParser.b.INT || bVar == JsonParser.b.LONG || bVar == JsonParser.b.BIG_INTEGER;
    }

    @Override // b.g.a.c.g0.ContextualSerializer
    public JsonSerializer<?> a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.d dVarL = l(serializerProvider, beanProperty, this._handledType);
        if (dVarL == null || dVarL.e().ordinal() != 8) {
            return this;
        }
        if (this._handledType != BigDecimal.class) {
            return ToStringSerializer.k;
        }
        NumberSerializer numberSerializer = NumberSerializer.k;
        return NumberSerializer.a.k;
    }
}

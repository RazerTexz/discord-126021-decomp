package b.g.a.c.g0.u;

import b.g.a.a.JsonFormat;
import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonToken2;
import b.g.a.b.s.WritableTypeId;
import b.g.a.c.BeanProperty;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.ContextualSerializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.net.InetAddress;

/* JADX INFO: renamed from: b.g.a.c.g0.u.p, reason: use source file name */
/* JADX INFO: compiled from: InetAddressSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class InetAddressSerializer extends StdScalarSerializer<InetAddress> implements ContextualSerializer {
    public final boolean _asNumeric;

    public InetAddressSerializer() {
        super(InetAddress.class);
        this._asNumeric = false;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @Override // b.g.a.c.g0.ContextualSerializer
    public JsonSerializer<?> a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        boolean z2;
        JsonFormat.d dVarL = l(serializerProvider, beanProperty, this._handledType);
        if (dVarL != null) {
            JsonFormat.c cVarE = dVarL.e();
            if (cVarE.f() || cVarE == JsonFormat.c.ARRAY) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        return z2 != this._asNumeric ? new InetAddressSerializer(z2) : this;
    }

    @Override // b.g.a.c.JsonSerializer
    public /* bridge */ /* synthetic */ void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        p((InetAddress) obj, jsonGenerator);
    }

    @Override // b.g.a.c.g0.u.StdScalarSerializer, b.g.a.c.JsonSerializer
    public void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        InetAddress inetAddress = (InetAddress) obj;
        WritableTypeId writableTypeIdD = typeSerializer.d(inetAddress, JsonToken2.VALUE_STRING);
        writableTypeIdD.f675b = InetAddress.class;
        WritableTypeId writableTypeIdE = typeSerializer.e(jsonGenerator, writableTypeIdD);
        p(inetAddress, jsonGenerator);
        typeSerializer.f(jsonGenerator, writableTypeIdE);
    }

    public void p(InetAddress inetAddress, JsonGenerator jsonGenerator) throws IOException {
        String strTrim;
        if (this._asNumeric) {
            strTrim = inetAddress.getHostAddress();
        } else {
            strTrim = inetAddress.toString().trim();
            int iIndexOf = strTrim.indexOf(47);
            if (iIndexOf >= 0) {
                strTrim = iIndexOf == 0 ? strTrim.substring(1) : strTrim.substring(0, iIndexOf);
            }
        }
        jsonGenerator.j0(strTrim);
    }

    public InetAddressSerializer(boolean z2) {
        super(InetAddress.class);
        this._asNumeric = z2;
    }
}

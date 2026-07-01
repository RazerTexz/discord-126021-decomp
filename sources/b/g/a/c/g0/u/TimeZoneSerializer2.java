package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonToken2;
import b.g.a.b.s.WritableTypeId;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import java.io.IOException;
import java.util.TimeZone;

/* JADX INFO: renamed from: b.g.a.c.g0.u.s0, reason: use source file name */
/* JADX INFO: compiled from: TimeZoneSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class TimeZoneSerializer2 extends StdScalarSerializer<TimeZone> {
    public TimeZoneSerializer2() {
        super(TimeZone.class);
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.j0(((TimeZone) obj).getID());
    }

    @Override // b.g.a.c.g0.u.StdScalarSerializer, b.g.a.c.JsonSerializer
    public void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        TimeZone timeZone = (TimeZone) obj;
        WritableTypeId writableTypeIdD = typeSerializer.d(timeZone, JsonToken2.VALUE_STRING);
        writableTypeIdD.f675b = TimeZone.class;
        WritableTypeId writableTypeIdE = typeSerializer.e(jsonGenerator, writableTypeIdD);
        jsonGenerator.j0(timeZone.getID());
        typeSerializer.f(jsonGenerator, writableTypeIdE);
    }
}

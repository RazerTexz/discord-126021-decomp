package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.c.SerializerProvider;
import b.g.a.c.y.JacksonStdImpl;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

/* JADX INFO: renamed from: b.g.a.c.g0.u.k, reason: use source file name */
/* JADX INFO: compiled from: DateSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class DateSerializer2 extends DateTimeSerializerBase<Date> {
    public static final DateSerializer2 k = new DateSerializer2();

    public DateSerializer2() {
        super(Date.class, null, null);
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Date date = (Date) obj;
        if (p(serializerProvider)) {
            jsonGenerator.I(date == null ? 0L : date.getTime());
        } else {
            q(date, jsonGenerator, serializerProvider);
        }
    }

    @Override // b.g.a.c.g0.u.DateTimeSerializerBase
    public DateTimeSerializerBase<Date> r(Boolean bool, DateFormat dateFormat) {
        return new DateSerializer2(bool, dateFormat);
    }

    public DateSerializer2(Boolean bool, DateFormat dateFormat) {
        super(Date.class, bool, dateFormat);
    }
}

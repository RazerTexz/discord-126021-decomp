package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.c.SerializerProvider;
import b.g.a.c.y.JacksonStdImpl;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;

/* JADX INFO: renamed from: b.g.a.c.g0.u.h, reason: use source file name */
/* JADX INFO: compiled from: CalendarSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class CalendarSerializer2 extends DateTimeSerializerBase<Calendar> {
    public static final CalendarSerializer2 k = new CalendarSerializer2();

    public CalendarSerializer2() {
        super(Calendar.class, null, null);
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Calendar calendar = (Calendar) obj;
        if (p(serializerProvider)) {
            jsonGenerator.I(calendar == null ? 0L : calendar.getTimeInMillis());
        } else {
            q(calendar.getTime(), jsonGenerator, serializerProvider);
        }
    }

    @Override // b.g.a.c.g0.u.DateTimeSerializerBase
    public DateTimeSerializerBase<Calendar> r(Boolean bool, DateFormat dateFormat) {
        return new CalendarSerializer2(bool, dateFormat);
    }

    public CalendarSerializer2(Boolean bool, DateFormat dateFormat) {
        super(Calendar.class, bool, dateFormat);
    }
}

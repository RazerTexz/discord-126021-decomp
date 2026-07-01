package b.g.a.c.g0.u;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/* JADX INFO: compiled from: StdKeySerializers.java */
/* JADX INFO: loaded from: classes3.dex */
public class o0$a extends q0<Object> {
    public final int _typeId;

    public o0$a(int i, Class<?> cls) {
        super(cls, false);
        this._typeId = i;
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        String strValueOf;
        switch (this._typeId) {
            case 1:
                Date date = (Date) obj;
                Objects.requireNonNull(xVar);
                if (!xVar.D(b.g.a.c.w.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
                    dVar.y(xVar.j().format(date));
                } else {
                    dVar.y(String.valueOf(date.getTime()));
                }
                break;
            case 2:
                long timeInMillis = ((Calendar) obj).getTimeInMillis();
                Objects.requireNonNull(xVar);
                if (!xVar.D(b.g.a.c.w.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
                    dVar.y(xVar.j().format(new Date(timeInMillis)));
                } else {
                    dVar.y(String.valueOf(timeInMillis));
                }
                break;
            case 3:
                dVar.y(((Class) obj).getName());
                break;
            case 4:
                if (xVar.D(b.g.a.c.w.WRITE_ENUMS_USING_TO_STRING)) {
                    strValueOf = obj.toString();
                } else {
                    Enum r3 = (Enum) obj;
                    strValueOf = xVar.D(b.g.a.c.w.WRITE_ENUM_KEYS_USING_INDEX) ? String.valueOf(r3.ordinal()) : r3.name();
                }
                dVar.y(strValueOf);
                break;
            case 5:
            case 6:
                long jLongValue = ((Number) obj).longValue();
                Objects.requireNonNull(dVar);
                dVar.y(Long.toString(jLongValue));
                break;
            case 7:
                dVar.y(xVar._config._base._defaultBase64.a((byte[]) obj));
                break;
            default:
                dVar.y(obj.toString());
                break;
        }
    }
}

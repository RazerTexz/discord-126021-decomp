package b.g.a.c.g0.u;

import b.g.a.a.i$c;
import b.g.a.a.i$d;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: DateTimeSerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l<T> extends p0<T> implements b.g.a.c.g0.i {
    public final DateFormat _customFormat;
    public final AtomicReference<DateFormat> _reusedCustomFormat;
    public final Boolean _useTimestamp;

    public l(Class<T> cls, Boolean bool, DateFormat dateFormat) {
        super(cls);
        this._useTimestamp = bool;
        this._customFormat = dateFormat;
        this._reusedCustomFormat = dateFormat == null ? null : new AtomicReference<>();
    }

    @Override // b.g.a.c.g0.i
    public b.g.a.c.n<?> a(b.g.a.c.x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        TimeZone timeZoneF;
        i$d i_dL = l(xVar, dVar, this._handledType);
        if (i_dL == null) {
            return this;
        }
        i$c i_cE = i_dL.e();
        if (i_cE.f()) {
            return r(Boolean.TRUE, null);
        }
        if (i_dL.h()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(i_dL.d(), i_dL.g() ? i_dL.c() : xVar._config._base._locale);
            if (i_dL.j()) {
                timeZoneF = i_dL.f();
            } else {
                timeZoneF = xVar._config._base._timeZone;
                if (timeZoneF == null) {
                    timeZoneF = b.g.a.c.z.a.j;
                }
            }
            simpleDateFormat.setTimeZone(timeZoneF);
            return r(Boolean.FALSE, simpleDateFormat);
        }
        boolean zG = i_dL.g();
        boolean zJ = i_dL.j();
        boolean z2 = i_cE == i$c.STRING;
        if (!zG && !zJ && !z2) {
            return this;
        }
        DateFormat dateFormat = xVar._config._base._dateFormat;
        if (dateFormat instanceof b.g.a.c.i0.r) {
            b.g.a.c.i0.r rVarM = (b.g.a.c.i0.r) dateFormat;
            if (i_dL.g()) {
                rVarM = rVarM.l(i_dL.c());
            }
            if (i_dL.j()) {
                rVarM = rVarM.m(i_dL.f());
            }
            return r(Boolean.FALSE, rVarM);
        }
        if (!(dateFormat instanceof SimpleDateFormat)) {
            xVar.g(this._handledType, String.format("Configured `DateFormat` (%s) not a `SimpleDateFormat`; cannot configure `Locale` or `TimeZone`", dateFormat.getClass().getName()));
        }
        SimpleDateFormat simpleDateFormat2 = (SimpleDateFormat) dateFormat;
        SimpleDateFormat simpleDateFormat3 = zG ? new SimpleDateFormat(simpleDateFormat2.toPattern(), i_dL.c()) : (SimpleDateFormat) simpleDateFormat2.clone();
        TimeZone timeZoneF2 = i_dL.f();
        if ((timeZoneF2 == null || timeZoneF2.equals(simpleDateFormat3.getTimeZone())) ? false : true) {
            simpleDateFormat3.setTimeZone(timeZoneF2);
        }
        return r(Boolean.FALSE, simpleDateFormat3);
    }

    @Override // b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, T t) {
        return false;
    }

    public boolean p(b.g.a.c.x xVar) {
        Boolean bool = this._useTimestamp;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (this._customFormat != null) {
            return false;
        }
        if (xVar != null) {
            return xVar.D(b.g.a.c.w.WRITE_DATES_AS_TIMESTAMPS);
        }
        StringBuilder sbU = b.d.b.a.a.U("Null SerializerProvider passed for ");
        sbU.append(this._handledType.getName());
        throw new IllegalArgumentException(sbU.toString());
    }

    public void q(Date date, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        if (this._customFormat == null) {
            Objects.requireNonNull(xVar);
            if (xVar.D(b.g.a.c.w.WRITE_DATES_AS_TIMESTAMPS)) {
                dVar.I(date.getTime());
                return;
            } else {
                dVar.j0(xVar.j().format(date));
                return;
            }
        }
        DateFormat andSet = this._reusedCustomFormat.getAndSet(null);
        if (andSet == null) {
            andSet = (DateFormat) this._customFormat.clone();
        }
        dVar.j0(andSet.format(date));
        this._reusedCustomFormat.compareAndSet(null, andSet);
    }

    public abstract l<T> r(Boolean bool, DateFormat dateFormat);
}

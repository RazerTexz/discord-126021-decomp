package b.g.a.c.g0.u;

import b.d.b.a.outline;
import b.g.a.a.JsonFormat;
import b.g.a.b.JsonGenerator;
import b.g.a.c.BeanProperty;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializationFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.g0.ContextualSerializer;
import b.g.a.c.i0.StdDateFormat;
import b.g.a.c.z.BaseSettings;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: b.g.a.c.g0.u.l, reason: use source file name */
/* JADX INFO: compiled from: DateTimeSerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DateTimeSerializerBase<T> extends StdScalarSerializer<T> implements ContextualSerializer {
    public final DateFormat _customFormat;
    public final AtomicReference<DateFormat> _reusedCustomFormat;
    public final Boolean _useTimestamp;

    public DateTimeSerializerBase(Class<T> cls, Boolean bool, DateFormat dateFormat) {
        super(cls);
        this._useTimestamp = bool;
        this._customFormat = dateFormat;
        this._reusedCustomFormat = dateFormat == null ? null : new AtomicReference<>();
    }

    @Override // b.g.a.c.g0.ContextualSerializer
    public JsonSerializer<?> a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        TimeZone timeZoneF;
        JsonFormat.d dVarL = l(serializerProvider, beanProperty, this._handledType);
        if (dVarL == null) {
            return this;
        }
        JsonFormat.c cVarE = dVarL.e();
        if (cVarE.f()) {
            return r(Boolean.TRUE, null);
        }
        if (dVarL.h()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dVarL.d(), dVarL.g() ? dVarL.c() : serializerProvider._config._base._locale);
            if (dVarL.j()) {
                timeZoneF = dVarL.f();
            } else {
                timeZoneF = serializerProvider._config._base._timeZone;
                if (timeZoneF == null) {
                    timeZoneF = BaseSettings.j;
                }
            }
            simpleDateFormat.setTimeZone(timeZoneF);
            return r(Boolean.FALSE, simpleDateFormat);
        }
        boolean zG = dVarL.g();
        boolean zJ = dVarL.j();
        boolean z2 = cVarE == JsonFormat.c.STRING;
        if (!zG && !zJ && !z2) {
            return this;
        }
        DateFormat dateFormat = serializerProvider._config._base._dateFormat;
        if (dateFormat instanceof StdDateFormat) {
            StdDateFormat stdDateFormatM = (StdDateFormat) dateFormat;
            if (dVarL.g()) {
                stdDateFormatM = stdDateFormatM.l(dVarL.c());
            }
            if (dVarL.j()) {
                stdDateFormatM = stdDateFormatM.m(dVarL.f());
            }
            return r(Boolean.FALSE, stdDateFormatM);
        }
        if (!(dateFormat instanceof SimpleDateFormat)) {
            serializerProvider.g(this._handledType, String.format("Configured `DateFormat` (%s) not a `SimpleDateFormat`; cannot configure `Locale` or `TimeZone`", dateFormat.getClass().getName()));
        }
        SimpleDateFormat simpleDateFormat2 = (SimpleDateFormat) dateFormat;
        SimpleDateFormat simpleDateFormat3 = zG ? new SimpleDateFormat(simpleDateFormat2.toPattern(), dVarL.c()) : (SimpleDateFormat) simpleDateFormat2.clone();
        TimeZone timeZoneF2 = dVarL.f();
        if ((timeZoneF2 == null || timeZoneF2.equals(simpleDateFormat3.getTimeZone())) ? false : true) {
            simpleDateFormat3.setTimeZone(timeZoneF2);
        }
        return r(Boolean.FALSE, simpleDateFormat3);
    }

    @Override // b.g.a.c.JsonSerializer
    public boolean d(SerializerProvider serializerProvider, T t) {
        return false;
    }

    public boolean p(SerializerProvider serializerProvider) {
        Boolean bool = this._useTimestamp;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (this._customFormat != null) {
            return false;
        }
        if (serializerProvider != null) {
            return serializerProvider.D(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        }
        StringBuilder sbU = outline.U("Null SerializerProvider passed for ");
        sbU.append(this._handledType.getName());
        throw new IllegalArgumentException(sbU.toString());
    }

    public void q(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (this._customFormat == null) {
            Objects.requireNonNull(serializerProvider);
            if (serializerProvider.D(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)) {
                jsonGenerator.I(date.getTime());
                return;
            } else {
                jsonGenerator.j0(serializerProvider.j().format(date));
                return;
            }
        }
        DateFormat andSet = this._reusedCustomFormat.getAndSet(null);
        if (andSet == null) {
            andSet = (DateFormat) this._customFormat.clone();
        }
        jsonGenerator.j0(andSet.format(date));
        this._reusedCustomFormat.compareAndSet(null, andSet);
    }

    public abstract DateTimeSerializerBase<T> r(Boolean bool, DateFormat dateFormat);
}

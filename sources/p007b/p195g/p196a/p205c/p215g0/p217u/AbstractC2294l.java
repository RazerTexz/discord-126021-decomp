package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p197a.InterfaceC2081i;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.EnumC2373w;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i;
import p007b.p195g.p196a.p205c.p219i0.C2356r;
import p007b.p195g.p196a.p205c.p221z.C2383a;

/* JADX INFO: renamed from: b.g.a.c.g0.u.l */
/* JADX INFO: compiled from: DateTimeSerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2294l<T> extends AbstractC2303p0<T> implements InterfaceC2240i {
    public final DateFormat _customFormat;
    public final AtomicReference<DateFormat> _reusedCustomFormat;
    public final Boolean _useTimestamp;

    public AbstractC2294l(Class<T> cls, Boolean bool, DateFormat dateFormat) {
        super(cls);
        this._useTimestamp = bool;
        this._customFormat = dateFormat;
        this._reusedCustomFormat = dateFormat == null ? null : new AtomicReference<>();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i
    /* JADX INFO: renamed from: a */
    public AbstractC2364n<?> mo1997a(AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        TimeZone timeZoneM1602f;
        InterfaceC2081i.d dVarM2074l = m2074l(abstractC2374x, interfaceC2206d, this._handledType);
        if (dVarM2074l == null) {
            return this;
        }
        InterfaceC2081i.c cVarM1601e = dVarM2074l.m1601e();
        if (cVarM1601e.m1596f()) {
            return mo2060r(Boolean.TRUE, null);
        }
        if (dVarM2074l.m1604h()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dVarM2074l.m1600d(), dVarM2074l.m1603g() ? dVarM2074l.m1599c() : abstractC2374x._config._base._locale);
            if (dVarM2074l.m1606j()) {
                timeZoneM1602f = dVarM2074l.m1602f();
            } else {
                timeZoneM1602f = abstractC2374x._config._base._timeZone;
                if (timeZoneM1602f == null) {
                    timeZoneM1602f = C2383a.f5074j;
                }
            }
            simpleDateFormat.setTimeZone(timeZoneM1602f);
            return mo2060r(Boolean.FALSE, simpleDateFormat);
        }
        boolean zM1603g = dVarM2074l.m1603g();
        boolean zM1606j = dVarM2074l.m1606j();
        boolean z2 = cVarM1601e == InterfaceC2081i.c.STRING;
        if (!zM1603g && !zM1606j && !z2) {
            return this;
        }
        DateFormat dateFormat = abstractC2374x._config._base._dateFormat;
        if (dateFormat instanceof C2356r) {
            C2356r c2356rM2212m = (C2356r) dateFormat;
            if (dVarM2074l.m1603g()) {
                c2356rM2212m = c2356rM2212m.m2211l(dVarM2074l.m1599c());
            }
            if (dVarM2074l.m1606j()) {
                c2356rM2212m = c2356rM2212m.m2212m(dVarM2074l.m1602f());
            }
            return mo2060r(Boolean.FALSE, c2356rM2212m);
        }
        if (!(dateFormat instanceof SimpleDateFormat)) {
            abstractC2374x.m1943g(this._handledType, String.format("Configured `DateFormat` (%s) not a `SimpleDateFormat`; cannot configure `Locale` or `TimeZone`", dateFormat.getClass().getName()));
        }
        SimpleDateFormat simpleDateFormat2 = (SimpleDateFormat) dateFormat;
        SimpleDateFormat simpleDateFormat3 = zM1603g ? new SimpleDateFormat(simpleDateFormat2.toPattern(), dVarM2074l.m1599c()) : (SimpleDateFormat) simpleDateFormat2.clone();
        TimeZone timeZoneM1602f2 = dVarM2074l.m1602f();
        if ((timeZoneM1602f2 == null || timeZoneM1602f2.equals(simpleDateFormat3.getTimeZone())) ? false : true) {
            simpleDateFormat3.setTimeZone(timeZoneM1602f2);
        }
        return mo2060r(Boolean.FALSE, simpleDateFormat3);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(AbstractC2374x abstractC2374x, T t) {
        return false;
    }

    /* JADX INFO: renamed from: p */
    public boolean m2066p(AbstractC2374x abstractC2374x) {
        Boolean bool = this._useTimestamp;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (this._customFormat != null) {
            return false;
        }
        if (abstractC2374x != null) {
            return abstractC2374x.m2240D(EnumC2373w.WRITE_DATES_AS_TIMESTAMPS);
        }
        StringBuilder sbM833U = C1643a.m833U("Null SerializerProvider passed for ");
        sbM833U.append(this._handledType.getName());
        throw new IllegalArgumentException(sbM833U.toString());
    }

    /* JADX INFO: renamed from: q */
    public void m2067q(Date date, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        if (this._customFormat == null) {
            Objects.requireNonNull(abstractC2374x);
            if (abstractC2374x.m2240D(EnumC2373w.WRITE_DATES_AS_TIMESTAMPS)) {
                abstractC2108d.mo1635I(date.getTime());
                return;
            } else {
                abstractC2108d.mo1658j0(abstractC2374x.m2246j().format(date));
                return;
            }
        }
        DateFormat andSet = this._reusedCustomFormat.getAndSet(null);
        if (andSet == null) {
            andSet = (DateFormat) this._customFormat.clone();
        }
        abstractC2108d.mo1658j0(andSet.format(date));
        this._reusedCustomFormat.compareAndSet(null, andSet);
    }

    /* JADX INFO: renamed from: r */
    public abstract AbstractC2294l<T> mo2060r(Boolean bool, DateFormat dateFormat);
}

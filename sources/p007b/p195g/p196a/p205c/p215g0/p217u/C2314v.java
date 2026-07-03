package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import p007b.p195g.p196a.p197a.InterfaceC2081i;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2375a;

/* JADX INFO: renamed from: b.g.a.c.g0.u.v */
/* JADX INFO: compiled from: NumberSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2375a
public class C2314v extends AbstractC2303p0<Number> implements InterfaceC2240i {

    /* JADX INFO: renamed from: k */
    public static final C2314v f4868k = new C2314v(Number.class);
    public final boolean _isInt;

    /* JADX INFO: renamed from: b.g.a.c.g0.u.v$a */
    /* JADX INFO: compiled from: NumberSerializer.java */
    public static final class a extends AbstractC2313u0 {

        /* JADX INFO: renamed from: k */
        public static final a f4869k = new a();

        public a() {
            super(BigDecimal.class);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2313u0, p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: d */
        public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
            return false;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2313u0, p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: f */
        public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
            String string;
            if (abstractC2108d.mo1652d(AbstractC2108d.a.WRITE_BIGDECIMAL_AS_PLAIN)) {
                BigDecimal bigDecimal = (BigDecimal) obj;
                int iScale = bigDecimal.scale();
                if (!(iScale >= -9999 && iScale <= 9999)) {
                    abstractC2374x.m2243G(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", Integer.valueOf(bigDecimal.scale()), 9999, 9999), new Object[0]);
                    throw null;
                }
                string = bigDecimal.toPlainString();
            } else {
                string = obj.toString();
            }
            abstractC2108d.mo1658j0(string);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2313u0
        /* JADX INFO: renamed from: p */
        public String mo2087p(Object obj) {
            throw new IllegalStateException();
        }
    }

    public C2314v(Class<? extends Number> cls) {
        super(cls, false);
        this._isInt = cls == BigInteger.class;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i
    /* JADX INFO: renamed from: a */
    public AbstractC2364n<?> mo1997a(AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        InterfaceC2081i.d dVarM2074l = m2074l(abstractC2374x, interfaceC2206d, this._handledType);
        if (dVarM2074l == null || dVarM2074l.m1601e().ordinal() != 8) {
            return this;
        }
        return this._handledType == BigDecimal.class ? a.f4869k : C2311t0.f4866k;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        Number number = (Number) obj;
        if (number instanceof BigDecimal) {
            abstractC2108d.mo1637L((BigDecimal) number);
            return;
        }
        if (number instanceof BigInteger) {
            abstractC2108d.mo1638N((BigInteger) number);
            return;
        }
        if (number instanceof Long) {
            abstractC2108d.mo1635I(number.longValue());
            return;
        }
        if (number instanceof Double) {
            abstractC2108d.mo1632C(number.doubleValue());
            return;
        }
        if (number instanceof Float) {
            abstractC2108d.mo1633D(number.floatValue());
        } else if ((number instanceof Integer) || (number instanceof Byte) || (number instanceof Short)) {
            abstractC2108d.mo1634H(number.intValue());
        } else {
            abstractC2108d.mo1636J(number.toString());
        }
    }
}

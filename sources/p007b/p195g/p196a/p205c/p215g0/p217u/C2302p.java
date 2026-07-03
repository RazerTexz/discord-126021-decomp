package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.net.InetAddress;
import p007b.p195g.p196a.p197a.InterfaceC2081i;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.EnumC2112h;
import p007b.p195g.p196a.p198b.p203s.C2138b;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i;

/* JADX INFO: renamed from: b.g.a.c.g0.u.p */
/* JADX INFO: compiled from: InetAddressSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2302p extends AbstractC2303p0<InetAddress> implements InterfaceC2240i {
    public final boolean _asNumeric;

    public C2302p() {
        super(InetAddress.class);
        this._asNumeric = false;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @Override // p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i
    /* JADX INFO: renamed from: a */
    public AbstractC2364n<?> mo1997a(AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        boolean z2;
        InterfaceC2081i.d dVarM2074l = m2074l(abstractC2374x, interfaceC2206d, this._handledType);
        if (dVarM2074l != null) {
            InterfaceC2081i.c cVarM1601e = dVarM2074l.m1601e();
            if (cVarM1601e.m1596f() || cVarM1601e == InterfaceC2081i.c.ARRAY) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        return z2 != this._asNumeric ? new C2302p(z2) : this;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public /* bridge */ /* synthetic */ void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        m2070p((InetAddress) obj, abstractC2108d);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2303p0, p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        InetAddress inetAddress = (InetAddress) obj;
        C2138b c2138bM1958d = abstractC2215g.m1958d(inetAddress, EnumC2112h.VALUE_STRING);
        c2138bM1958d.f4585b = InetAddress.class;
        C2138b c2138bMo1959e = abstractC2215g.mo1959e(abstractC2108d, c2138bM1958d);
        m2070p(inetAddress, abstractC2108d);
        abstractC2215g.mo1960f(abstractC2108d, c2138bMo1959e);
    }

    /* JADX INFO: renamed from: p */
    public void m2070p(InetAddress inetAddress, AbstractC2108d abstractC2108d) throws IOException {
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
        abstractC2108d.mo1658j0(strTrim);
    }

    public C2302p(boolean z2) {
        super(InetAddress.class);
        this._asNumeric = z2;
    }
}

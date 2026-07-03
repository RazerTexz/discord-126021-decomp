package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;
import p007b.p195g.p196a.p197a.InterfaceC2081i;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i;
import p007b.p195g.p196a.p205c.p219i0.C2357s;

/* JADX INFO: renamed from: b.g.a.c.g0.u.w0 */
/* JADX INFO: compiled from: UUIDSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2317w0 extends AbstractC2303p0<UUID> implements InterfaceC2240i {

    /* JADX INFO: renamed from: k */
    public static final char[] f4870k = "0123456789abcdef".toCharArray();
    public final Boolean _asBinary;

    public C2317w0() {
        super(UUID.class);
        this._asBinary = null;
    }

    /* JADX INFO: renamed from: p */
    public static final void m2088p(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >> 24);
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >> 16);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >> 8);
        bArr[i4 + 1] = (byte) i;
    }

    /* JADX INFO: renamed from: q */
    public static void m2089q(int i, char[] cArr, int i2) {
        char[] cArr2 = f4870k;
        cArr[i2] = cArr2[(i >> 12) & 15];
        int i3 = i2 + 1;
        cArr[i3] = cArr2[(i >> 8) & 15];
        int i4 = i3 + 1;
        cArr[i4] = cArr2[(i >> 4) & 15];
        cArr[i4 + 1] = cArr2[i & 15];
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001a  */
    @Override // p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i
    /* JADX INFO: renamed from: a */
    public AbstractC2364n<?> mo1997a(AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        Boolean bool;
        InterfaceC2081i.d dVarM2074l = m2074l(abstractC2374x, interfaceC2206d, this._handledType);
        if (dVarM2074l == null) {
            bool = null;
        } else {
            InterfaceC2081i.c cVarM1601e = dVarM2074l.m1601e();
            if (cVarM1601e == InterfaceC2081i.c.BINARY) {
                bool = Boolean.TRUE;
            } else if (cVarM1601e == InterfaceC2081i.c.STRING) {
                bool = Boolean.FALSE;
            } else {
                bool = null;
            }
        }
        return !Objects.equals(bool, this._asBinary) ? new C2317w0(bool) : this;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
        UUID uuid = (UUID) obj;
        return uuid.getLeastSignificantBits() == 0 && uuid.getMostSignificantBits() == 0;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0019  */
    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        boolean zBooleanValue;
        UUID uuid = (UUID) obj;
        Boolean bool = this._asBinary;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        } else if (abstractC2108d instanceof C2357s) {
            zBooleanValue = false;
        } else {
            Objects.requireNonNull(abstractC2108d);
            if (abstractC2108d instanceof C2357s) {
                zBooleanValue = true;
            } else {
                zBooleanValue = false;
            }
        }
        if (zBooleanValue) {
            byte[] bArr = new byte[16];
            long mostSignificantBits = uuid.getMostSignificantBits();
            long leastSignificantBits = uuid.getLeastSignificantBits();
            m2088p((int) (mostSignificantBits >> 32), bArr, 0);
            m2088p((int) mostSignificantBits, bArr, 4);
            m2088p((int) (leastSignificantBits >> 32), bArr, 8);
            m2088p((int) leastSignificantBits, bArr, 12);
            abstractC2108d.m1661q(bArr);
            return;
        }
        char[] cArr = new char[36];
        long mostSignificantBits2 = uuid.getMostSignificantBits();
        int i = (int) (mostSignificantBits2 >> 32);
        m2089q(i >> 16, cArr, 0);
        m2089q(i, cArr, 4);
        cArr[8] = '-';
        int i2 = (int) mostSignificantBits2;
        m2089q(i2 >>> 16, cArr, 9);
        cArr[13] = '-';
        m2089q(i2, cArr, 14);
        cArr[18] = '-';
        long leastSignificantBits2 = uuid.getLeastSignificantBits();
        m2089q((int) (leastSignificantBits2 >>> 48), cArr, 19);
        cArr[23] = '-';
        m2089q((int) (leastSignificantBits2 >>> 32), cArr, 24);
        int i3 = (int) leastSignificantBits2;
        m2089q(i3 >> 16, cArr, 28);
        m2089q(i3, cArr, 32);
        abstractC2108d.mo1659m0(cArr, 0, 36);
    }

    public C2317w0(Boolean bool) {
        super(UUID.class);
        this._asBinary = bool;
    }
}

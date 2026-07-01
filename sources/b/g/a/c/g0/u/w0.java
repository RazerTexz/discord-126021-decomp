package b.g.a.c.g0.u;

import b.g.a.a.i$c;
import b.g.a.a.i$d;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: UUIDSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class w0 extends p0<UUID> implements b.g.a.c.g0.i {
    public static final char[] k = "0123456789abcdef".toCharArray();
    public final Boolean _asBinary;

    public w0() {
        super(UUID.class);
        this._asBinary = null;
    }

    public static final void p(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >> 24);
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >> 16);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >> 8);
        bArr[i4 + 1] = (byte) i;
    }

    public static void q(int i, char[] cArr, int i2) {
        char[] cArr2 = k;
        cArr[i2] = cArr2[(i >> 12) & 15];
        int i3 = i2 + 1;
        cArr[i3] = cArr2[(i >> 8) & 15];
        int i4 = i3 + 1;
        cArr[i4] = cArr2[(i >> 4) & 15];
        cArr[i4 + 1] = cArr2[i & 15];
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001a  */
    @Override // b.g.a.c.g0.i
    public b.g.a.c.n<?> a(b.g.a.c.x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        Boolean bool;
        i$d i_dL = l(xVar, dVar, this._handledType);
        if (i_dL == null) {
            bool = null;
        } else {
            i$c i_cE = i_dL.e();
            if (i_cE == i$c.BINARY) {
                bool = Boolean.TRUE;
            } else if (i_cE == i$c.STRING) {
                bool = Boolean.FALSE;
            } else {
                bool = null;
            }
        }
        return !Objects.equals(bool, this._asBinary) ? new w0(bool) : this;
    }

    @Override // b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, Object obj) {
        UUID uuid = (UUID) obj;
        return uuid.getLeastSignificantBits() == 0 && uuid.getMostSignificantBits() == 0;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0019  */
    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        boolean zBooleanValue;
        UUID uuid = (UUID) obj;
        Boolean bool = this._asBinary;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        } else if (dVar instanceof b.g.a.c.i0.s) {
            zBooleanValue = false;
        } else {
            Objects.requireNonNull(dVar);
            if (dVar instanceof b.g.a.c.i0.s) {
                zBooleanValue = true;
            } else {
                zBooleanValue = false;
            }
        }
        if (zBooleanValue) {
            byte[] bArr = new byte[16];
            long mostSignificantBits = uuid.getMostSignificantBits();
            long leastSignificantBits = uuid.getLeastSignificantBits();
            p((int) (mostSignificantBits >> 32), bArr, 0);
            p((int) mostSignificantBits, bArr, 4);
            p((int) (leastSignificantBits >> 32), bArr, 8);
            p((int) leastSignificantBits, bArr, 12);
            dVar.q(bArr);
            return;
        }
        char[] cArr = new char[36];
        long mostSignificantBits2 = uuid.getMostSignificantBits();
        int i = (int) (mostSignificantBits2 >> 32);
        q(i >> 16, cArr, 0);
        q(i, cArr, 4);
        cArr[8] = '-';
        int i2 = (int) mostSignificantBits2;
        q(i2 >>> 16, cArr, 9);
        cArr[13] = '-';
        q(i2, cArr, 14);
        cArr[18] = '-';
        long leastSignificantBits2 = uuid.getLeastSignificantBits();
        q((int) (leastSignificantBits2 >>> 48), cArr, 19);
        cArr[23] = '-';
        q((int) (leastSignificantBits2 >>> 32), cArr, 24);
        int i3 = (int) leastSignificantBits2;
        q(i3 >> 16, cArr, 28);
        q(i3, cArr, 32);
        dVar.m0(cArr, 0, 36);
    }

    public w0(Boolean bool) {
        super(UUID.class);
        this._asBinary = bool;
    }
}

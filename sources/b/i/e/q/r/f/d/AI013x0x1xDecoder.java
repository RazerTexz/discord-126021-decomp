package b.i.e.q.r.f.d;

import b.i.e.n.BitArray;
import com.google.zxing.NotFoundException;

/* JADX INFO: renamed from: b.i.e.q.r.f.d.e, reason: use source file name */
/* JADX INFO: compiled from: AI013x0x1xDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AI013x0x1xDecoder extends AI01weightDecoder {
    public final String c;
    public final String d;

    public AI013x0x1xDecoder(BitArray bitArray, String str, String str2) {
        super(bitArray);
        this.c = str2;
        this.d = str;
    }

    @Override // b.i.e.q.r.f.d.AbstractExpandedDecoder
    public String a() throws NotFoundException {
        if (this.a.k != 84) {
            throw NotFoundException.l;
        }
        StringBuilder sb = new StringBuilder();
        b(sb, 8);
        f(sb, 48, 20);
        int iD = GeneralAppIdDecoder.d(this.f1867b.a, 68, 16);
        if (iD != 38400) {
            sb.append('(');
            sb.append(this.c);
            sb.append(')');
            int i = iD % 32;
            int i2 = iD / 32;
            int i3 = (i2 % 12) + 1;
            int i4 = i2 / 12;
            if (i4 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i4);
            if (i3 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i3);
            if (i / 10 == 0) {
                sb.append('0');
            }
            sb.append(i);
        }
        return sb.toString();
    }

    @Override // b.i.e.q.r.f.d.AI01weightDecoder
    public void d(StringBuilder sb, int i) {
        sb.append('(');
        sb.append(this.d);
        sb.append(i / 100000);
        sb.append(')');
    }

    @Override // b.i.e.q.r.f.d.AI01weightDecoder
    public int e(int i) {
        return i % 100000;
    }
}

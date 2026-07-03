package p007b.p225i.p226a.p242c.p279z2.p284l;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.scte35.PrivateCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand;
import com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p007b.p225i.p226a.p242c.p259f3.C2736d0;
import p007b.p225i.p226a.p242c.p259f3.C2756w;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p279z2.AbstractC3161g;
import p007b.p225i.p226a.p242c.p279z2.C3158d;

/* JADX INFO: renamed from: b.i.a.c.z2.l.a */
/* JADX INFO: compiled from: SpliceInfoDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3168a extends AbstractC3161g {

    /* JADX INFO: renamed from: a */
    public final C2757x f9159a = new C2757x();

    /* JADX INFO: renamed from: b */
    public final C2756w f9160b = new C2756w();

    /* JADX INFO: renamed from: c */
    public C2736d0 f9161c;

    @Override // p007b.p225i.p226a.p242c.p279z2.AbstractC3161g
    /* JADX INFO: renamed from: b */
    public Metadata mo3899b(C3158d c3158d, ByteBuffer byteBuffer) {
        int i;
        long j;
        ArrayList arrayList;
        boolean z2;
        boolean z3;
        long j2;
        boolean z4;
        long j3;
        int iM3105y;
        int iM3100t;
        int iM3100t2;
        boolean z5;
        long jM3101u;
        List list;
        long j4;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        long j5;
        int i2;
        int i3;
        int iM3100t3;
        boolean z10;
        long jM3101u2;
        C2736d0 c2736d0 = this.f9161c;
        if (c2736d0 == null || c3158d.f9137r != c2736d0.m2975d()) {
            C2736d0 c2736d1 = new C2736d0(c3158d.f19780n);
            this.f9161c = c2736d1;
            c2736d1.m2972a(c3158d.f19780n - c3158d.f9137r);
        }
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        this.f9159a.m3077C(bArrArray, iLimit);
        this.f9160b.m3070j(bArrArray, iLimit);
        this.f9160b.m3073m(39);
        long jM3067g = (((long) this.f9160b.m3067g(1)) << 32) | ((long) this.f9160b.m3067g(32));
        this.f9160b.m3073m(20);
        int iM3067g = this.f9160b.m3067g(12);
        int iM3067g2 = this.f9160b.m3067g(8);
        this.f9159a.m3080F(14);
        Metadata.Entry spliceNullCommand = null;
        if (iM3067g2 == 0) {
            spliceNullCommand = new SpliceNullCommand();
        } else if (iM3067g2 != 255) {
            long j6 = 128;
            if (iM3067g2 == 4) {
                C2757x c2757x = this.f9159a;
                int iM3100t4 = c2757x.m3100t();
                ArrayList arrayList2 = new ArrayList(iM3100t4);
                int i4 = 0;
                while (i4 < iM3100t4) {
                    long jM3101u3 = c2757x.m3101u();
                    boolean z11 = (c2757x.m3100t() & 128) != 0;
                    ArrayList arrayList3 = new ArrayList();
                    if (z11) {
                        i = iM3100t4;
                        j = j6;
                        arrayList = arrayList3;
                        z2 = false;
                        z3 = false;
                        j2 = -9223372036854775807L;
                        z4 = false;
                        j3 = -9223372036854775807L;
                        iM3105y = 0;
                        iM3100t = 0;
                        iM3100t2 = 0;
                    } else {
                        int iM3100t5 = c2757x.m3100t();
                        boolean z12 = (iM3100t5 & 128) != 0;
                        boolean z13 = (iM3100t5 & 64) != 0;
                        boolean z14 = (iM3100t5 & 32) != 0;
                        long jM3101u4 = z13 ? c2757x.m3101u() : -9223372036854775807L;
                        if (z13) {
                            i = iM3100t4;
                        } else {
                            int iM3100t6 = c2757x.m3100t();
                            ArrayList arrayList4 = new ArrayList(iM3100t6);
                            int i5 = 0;
                            while (i5 < iM3100t6) {
                                arrayList4.add(new SpliceScheduleCommand.C10747b(c2757x.m3100t(), c2757x.m3101u(), null));
                                i5++;
                                iM3100t6 = iM3100t6;
                                iM3100t4 = iM3100t4;
                            }
                            i = iM3100t4;
                            arrayList3 = arrayList4;
                        }
                        if (z14) {
                            long jM3100t = c2757x.m3100t();
                            j = 128;
                            z5 = (jM3100t & 128) != 0;
                            jM3101u = ((((jM3100t & 1) << 32) | c2757x.m3101u()) * 1000) / 90;
                        } else {
                            j = 128;
                            z5 = false;
                            jM3101u = -9223372036854775807L;
                        }
                        z4 = z5;
                        j3 = jM3101u;
                        arrayList = arrayList3;
                        iM3105y = c2757x.m3105y();
                        z2 = z12;
                        z3 = z13;
                        j2 = jM3101u4;
                        iM3100t = c2757x.m3100t();
                        iM3100t2 = c2757x.m3100t();
                    }
                    arrayList2.add(new SpliceScheduleCommand.C10748c(jM3101u3, z11, z2, z3, arrayList, j2, z4, j3, iM3105y, iM3100t, iM3100t2));
                    i4++;
                    j6 = j;
                    iM3100t4 = i;
                }
                spliceNullCommand = new SpliceScheduleCommand(arrayList2);
            } else if (iM3067g2 == 5) {
                C2757x c2757x2 = this.f9159a;
                C2736d0 c2736d2 = this.f9161c;
                long jM3101u5 = c2757x2.m3101u();
                boolean z15 = (c2757x2.m3100t() & 128) != 0;
                List listEmptyList = Collections.emptyList();
                if (z15) {
                    list = listEmptyList;
                    j4 = -9223372036854775807L;
                    z6 = false;
                    z7 = false;
                    z8 = false;
                    z9 = false;
                    j5 = -9223372036854775807L;
                    i2 = 0;
                    i3 = 0;
                    iM3100t3 = 0;
                } else {
                    int iM3100t7 = c2757x2.m3100t();
                    boolean z16 = (iM3100t7 & 128) != 0;
                    boolean z17 = (iM3100t7 & 64) != 0;
                    boolean z18 = (iM3100t7 & 32) != 0;
                    boolean z19 = (iM3100t7 & 16) != 0;
                    long jM8883a = (!z17 || z19) ? -9223372036854775807L : TimeSignalCommand.m8883a(c2757x2, jM3067g);
                    if (!z17) {
                        int iM3100t8 = c2757x2.m3100t();
                        ArrayList arrayList5 = new ArrayList(iM3100t8);
                        for (int i6 = 0; i6 < iM3100t8; i6++) {
                            int iM3100t9 = c2757x2.m3100t();
                            long jM8883a2 = !z19 ? TimeSignalCommand.m8883a(c2757x2, jM3067g) : -9223372036854775807L;
                            arrayList5.add(new SpliceInsertCommand.C10744b(iM3100t9, jM8883a2, c2736d2.m2973b(jM8883a2), null));
                        }
                        listEmptyList = arrayList5;
                    }
                    if (z18) {
                        long jM3100t2 = c2757x2.m3100t();
                        z10 = (jM3100t2 & 128) != 0;
                        jM3101u2 = ((((jM3100t2 & 1) << 32) | c2757x2.m3101u()) * 1000) / 90;
                    } else {
                        z10 = false;
                        jM3101u2 = -9223372036854775807L;
                    }
                    int iM3105y2 = c2757x2.m3105y();
                    int iM3100t10 = c2757x2.m3100t();
                    i2 = iM3105y2;
                    z9 = z10;
                    iM3100t3 = c2757x2.m3100t();
                    list = listEmptyList;
                    j5 = jM3101u2;
                    i3 = iM3100t10;
                    z6 = z16;
                    j4 = jM8883a;
                    z8 = z19;
                    z7 = z17;
                }
                spliceNullCommand = new SpliceInsertCommand(jM3101u5, z15, z6, z7, z8, j4, c2736d2.m2973b(j4), list, z9, j5, i2, i3, iM3100t3);
            } else if (iM3067g2 == 6) {
                C2757x c2757x3 = this.f9159a;
                C2736d0 c2736d3 = this.f9161c;
                long jM8883a3 = TimeSignalCommand.m8883a(c2757x3, jM3067g);
                spliceNullCommand = new TimeSignalCommand(jM8883a3, c2736d3.m2973b(jM8883a3));
            }
        } else {
            C2757x c2757x4 = this.f9159a;
            long jM3101u6 = c2757x4.m3101u();
            int i7 = iM3067g - 4;
            byte[] bArr = new byte[i7];
            System.arraycopy(c2757x4.f6793a, c2757x4.f6794b, bArr, 0, i7);
            c2757x4.f6794b += i7;
            spliceNullCommand = new PrivateCommand(jM3101u6, bArr, jM3067g);
        }
        return spliceNullCommand == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(spliceNullCommand);
    }
}

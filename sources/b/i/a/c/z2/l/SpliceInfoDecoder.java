package b.i.a.c.z2.l;

import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.TimestampAdjuster;
import b.i.a.c.z2.MetadataInputBuffer;
import b.i.a.c.z2.SimpleMetadataDecoder;
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

/* JADX INFO: renamed from: b.i.a.c.z2.l.a, reason: use source file name */
/* JADX INFO: compiled from: SpliceInfoDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SpliceInfoDecoder extends SimpleMetadataDecoder {
    public final ParsableByteArray a = new ParsableByteArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ParsableBitArray f1326b = new ParsableBitArray();
    public TimestampAdjuster c;

    @Override // b.i.a.c.z2.SimpleMetadataDecoder
    public Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        int i;
        long j;
        ArrayList arrayList;
        boolean z2;
        boolean z3;
        long j2;
        boolean z4;
        long j3;
        int iY;
        int iT;
        int iT2;
        boolean z5;
        long jU;
        List list;
        long j4;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        long j5;
        int i2;
        int i3;
        int iT3;
        boolean z10;
        long jU2;
        TimestampAdjuster timestampAdjuster = this.c;
        if (timestampAdjuster == null || metadataInputBuffer.r != timestampAdjuster.d()) {
            TimestampAdjuster timestampAdjuster2 = new TimestampAdjuster(metadataInputBuffer.n);
            this.c = timestampAdjuster2;
            timestampAdjuster2.a(metadataInputBuffer.n - metadataInputBuffer.r);
        }
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        this.a.C(bArrArray, iLimit);
        this.f1326b.j(bArrArray, iLimit);
        this.f1326b.m(39);
        long jG = (((long) this.f1326b.g(1)) << 32) | ((long) this.f1326b.g(32));
        this.f1326b.m(20);
        int iG = this.f1326b.g(12);
        int iG2 = this.f1326b.g(8);
        this.a.F(14);
        Metadata.Entry spliceNullCommand = null;
        if (iG2 == 0) {
            spliceNullCommand = new SpliceNullCommand();
        } else if (iG2 != 255) {
            long j6 = 128;
            if (iG2 == 4) {
                ParsableByteArray parsableByteArray = this.a;
                int iT4 = parsableByteArray.t();
                ArrayList arrayList2 = new ArrayList(iT4);
                int i4 = 0;
                while (i4 < iT4) {
                    long jU3 = parsableByteArray.u();
                    boolean z11 = (parsableByteArray.t() & 128) != 0;
                    ArrayList arrayList3 = new ArrayList();
                    if (z11) {
                        i = iT4;
                        j = j6;
                        arrayList = arrayList3;
                        z2 = false;
                        z3 = false;
                        j2 = -9223372036854775807L;
                        z4 = false;
                        j3 = -9223372036854775807L;
                        iY = 0;
                        iT = 0;
                        iT2 = 0;
                    } else {
                        int iT5 = parsableByteArray.t();
                        boolean z12 = (iT5 & 128) != 0;
                        boolean z13 = (iT5 & 64) != 0;
                        boolean z14 = (iT5 & 32) != 0;
                        long jU4 = z13 ? parsableByteArray.u() : -9223372036854775807L;
                        if (z13) {
                            i = iT4;
                        } else {
                            int iT6 = parsableByteArray.t();
                            ArrayList arrayList4 = new ArrayList(iT6);
                            int i5 = 0;
                            while (i5 < iT6) {
                                arrayList4.add(new SpliceScheduleCommand.b(parsableByteArray.t(), parsableByteArray.u(), null));
                                i5++;
                                iT6 = iT6;
                                iT4 = iT4;
                            }
                            i = iT4;
                            arrayList3 = arrayList4;
                        }
                        if (z14) {
                            long jT = parsableByteArray.t();
                            j = 128;
                            z5 = (jT & 128) != 0;
                            jU = ((((jT & 1) << 32) | parsableByteArray.u()) * 1000) / 90;
                        } else {
                            j = 128;
                            z5 = false;
                            jU = -9223372036854775807L;
                        }
                        z4 = z5;
                        j3 = jU;
                        arrayList = arrayList3;
                        iY = parsableByteArray.y();
                        z2 = z12;
                        z3 = z13;
                        j2 = jU4;
                        iT = parsableByteArray.t();
                        iT2 = parsableByteArray.t();
                    }
                    arrayList2.add(new SpliceScheduleCommand.c(jU3, z11, z2, z3, arrayList, j2, z4, j3, iY, iT, iT2));
                    i4++;
                    j6 = j;
                    iT4 = i;
                }
                spliceNullCommand = new SpliceScheduleCommand(arrayList2);
            } else if (iG2 == 5) {
                ParsableByteArray parsableByteArray2 = this.a;
                TimestampAdjuster timestampAdjuster3 = this.c;
                long jU5 = parsableByteArray2.u();
                boolean z15 = (parsableByteArray2.t() & 128) != 0;
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
                    iT3 = 0;
                } else {
                    int iT7 = parsableByteArray2.t();
                    boolean z16 = (iT7 & 128) != 0;
                    boolean z17 = (iT7 & 64) != 0;
                    boolean z18 = (iT7 & 32) != 0;
                    boolean z19 = (iT7 & 16) != 0;
                    long jA = (!z17 || z19) ? -9223372036854775807L : TimeSignalCommand.a(parsableByteArray2, jG);
                    if (!z17) {
                        int iT8 = parsableByteArray2.t();
                        ArrayList arrayList5 = new ArrayList(iT8);
                        for (int i6 = 0; i6 < iT8; i6++) {
                            int iT9 = parsableByteArray2.t();
                            long jA2 = !z19 ? TimeSignalCommand.a(parsableByteArray2, jG) : -9223372036854775807L;
                            arrayList5.add(new SpliceInsertCommand.b(iT9, jA2, timestampAdjuster3.b(jA2), null));
                        }
                        listEmptyList = arrayList5;
                    }
                    if (z18) {
                        long jT2 = parsableByteArray2.t();
                        z10 = (jT2 & 128) != 0;
                        jU2 = ((((jT2 & 1) << 32) | parsableByteArray2.u()) * 1000) / 90;
                    } else {
                        z10 = false;
                        jU2 = -9223372036854775807L;
                    }
                    int iY2 = parsableByteArray2.y();
                    int iT10 = parsableByteArray2.t();
                    i2 = iY2;
                    z9 = z10;
                    iT3 = parsableByteArray2.t();
                    list = listEmptyList;
                    j5 = jU2;
                    i3 = iT10;
                    z6 = z16;
                    j4 = jA;
                    z8 = z19;
                    z7 = z17;
                }
                spliceNullCommand = new SpliceInsertCommand(jU5, z15, z6, z7, z8, j4, timestampAdjuster3.b(j4), list, z9, j5, i2, i3, iT3);
            } else if (iG2 == 6) {
                ParsableByteArray parsableByteArray3 = this.a;
                TimestampAdjuster timestampAdjuster4 = this.c;
                long jA3 = TimeSignalCommand.a(parsableByteArray3, jG);
                spliceNullCommand = new TimeSignalCommand(jA3, timestampAdjuster4.b(jA3));
            }
        } else {
            ParsableByteArray parsableByteArray4 = this.a;
            long jU6 = parsableByteArray4.u();
            int i7 = iG - 4;
            byte[] bArr = new byte[i7];
            System.arraycopy(parsableByteArray4.a, parsableByteArray4.f984b, bArr, 0, i7);
            parsableByteArray4.f984b += i7;
            spliceNullCommand = new PrivateCommand(jU6, bArr, jG);
        }
        return spliceNullCommand == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(spliceNullCommand);
    }
}

package b.i.a.c.x2.i0;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.f3.NalUnitUtil;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.t2.Ac4Util;
import b.i.a.c.x2.ChunkIndex;
import b.i.a.c.x2.Extractor;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.GaplessInfoHolder;
import b.i.a.c.x2.PositionHolder;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.i0.Atom;
import b.i.a.c.z2.i.EventMessageEncoder;
import b.i.b.a.Function2;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.a.c.x2.i0.g, reason: use source file name */
/* JADX INFO: compiled from: FragmentedMp4Extractor.java */
/* JADX INFO: loaded from: classes3.dex */
public class FragmentedMp4Extractor implements Extractor {
    public static final byte[] a = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Format2 f1215b;
    public int A;
    public int B;
    public boolean C;
    public ExtractorOutput D;
    public TrackOutput2[] E;
    public TrackOutput2[] F;
    public boolean G;
    public final int c;
    public final List<Format2> d;
    public final SparseArray<b> e;
    public final ParsableByteArray f;
    public final ParsableByteArray g;
    public final ParsableByteArray h;
    public final byte[] i;
    public final ParsableByteArray j;
    public final EventMessageEncoder k;
    public final ParsableByteArray l;
    public final ArrayDeque<Atom.a> m;
    public final ArrayDeque<a> n;
    public int o;
    public int p;
    public long q;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public ParsableByteArray f1216s;
    public long t;
    public int u;
    public long v;
    public long w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f1217x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public b f1218y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f1219z;

    /* JADX INFO: renamed from: b.i.a.c.x2.i0.g$a */
    /* JADX INFO: compiled from: FragmentedMp4Extractor.java */
    public static final class a {
        public final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1220b;

        public a(long j, int i) {
            this.a = j;
            this.f1220b = i;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.i0.g$b */
    /* JADX INFO: compiled from: FragmentedMp4Extractor.java */
    public static final class b {
        public final TrackOutput2 a;
        public TrackSampleTable d;
        public DefaultSampleValues e;
        public int f;
        public int g;
        public int h;
        public int i;
        public boolean l;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TrackFragment f1221b = new TrackFragment();
        public final ParsableByteArray c = new ParsableByteArray();
        public final ParsableByteArray j = new ParsableByteArray(1);
        public final ParsableByteArray k = new ParsableByteArray();

        public b(TrackOutput2 trackOutput2, TrackSampleTable trackSampleTable, DefaultSampleValues defaultSampleValues) {
            this.a = trackOutput2;
            this.d = trackSampleTable;
            this.e = defaultSampleValues;
            this.d = trackSampleTable;
            this.e = defaultSampleValues;
            trackOutput2.e(trackSampleTable.a.f);
            e();
        }

        public long a() {
            return !this.l ? this.d.c[this.f] : this.f1221b.f[this.h];
        }

        @Nullable
        public TrackEncryptionBox b() {
            if (!this.l) {
                return null;
            }
            TrackFragment trackFragment = this.f1221b;
            DefaultSampleValues defaultSampleValues = trackFragment.a;
            int i = Util2.a;
            int i2 = defaultSampleValues.a;
            TrackEncryptionBox trackEncryptionBoxA = trackFragment.m;
            if (trackEncryptionBoxA == null) {
                trackEncryptionBoxA = this.d.a.a(i2);
            }
            if (trackEncryptionBoxA == null || !trackEncryptionBoxA.a) {
                return null;
            }
            return trackEncryptionBoxA;
        }

        public boolean c() {
            this.f++;
            if (!this.l) {
                return false;
            }
            int i = this.g + 1;
            this.g = i;
            int[] iArr = this.f1221b.g;
            int i2 = this.h;
            if (i != iArr[i2]) {
                return true;
            }
            this.h = i2 + 1;
            this.g = 0;
            return false;
        }

        public int d(int i, int i2) {
            ParsableByteArray parsableByteArray;
            TrackEncryptionBox trackEncryptionBoxB = b();
            if (trackEncryptionBoxB == null) {
                return 0;
            }
            int length = trackEncryptionBoxB.d;
            if (length != 0) {
                parsableByteArray = this.f1221b.n;
            } else {
                byte[] bArr = trackEncryptionBoxB.e;
                int i3 = Util2.a;
                ParsableByteArray parsableByteArray2 = this.k;
                int length2 = bArr.length;
                parsableByteArray2.a = bArr;
                parsableByteArray2.c = length2;
                parsableByteArray2.f984b = 0;
                length = bArr.length;
                parsableByteArray = parsableByteArray2;
            }
            TrackFragment trackFragment = this.f1221b;
            boolean z2 = trackFragment.k && trackFragment.l[this.f];
            boolean z3 = z2 || i2 != 0;
            ParsableByteArray parsableByteArray3 = this.j;
            parsableByteArray3.a[0] = (byte) ((z3 ? 128 : 0) | length);
            parsableByteArray3.E(0);
            this.a.f(this.j, 1, 1);
            this.a.f(parsableByteArray, length, 1);
            if (!z3) {
                return length + 1;
            }
            if (!z2) {
                this.c.A(8);
                ParsableByteArray parsableByteArray4 = this.c;
                byte[] bArr2 = parsableByteArray4.a;
                bArr2[0] = 0;
                bArr2[1] = 1;
                bArr2[2] = (byte) ((i2 >> 8) & 255);
                bArr2[3] = (byte) (i2 & 255);
                bArr2[4] = (byte) ((i >> 24) & 255);
                bArr2[5] = (byte) ((i >> 16) & 255);
                bArr2[6] = (byte) ((i >> 8) & 255);
                bArr2[7] = (byte) (i & 255);
                this.a.f(parsableByteArray4, 8, 1);
                return length + 1 + 8;
            }
            ParsableByteArray parsableByteArray5 = this.f1221b.n;
            int iY = parsableByteArray5.y();
            parsableByteArray5.F(-2);
            int i4 = (iY * 6) + 2;
            if (i2 != 0) {
                this.c.A(i4);
                byte[] bArr3 = this.c.a;
                parsableByteArray5.e(bArr3, 0, i4);
                int i5 = (((bArr3[2] & 255) << 8) | (bArr3[3] & 255)) + i2;
                bArr3[2] = (byte) ((i5 >> 8) & 255);
                bArr3[3] = (byte) (i5 & 255);
                parsableByteArray5 = this.c;
            }
            this.a.f(parsableByteArray5, i4, 1);
            return length + 1 + i4;
        }

        public void e() {
            TrackFragment trackFragment = this.f1221b;
            trackFragment.d = 0;
            trackFragment.p = 0L;
            trackFragment.q = false;
            trackFragment.k = false;
            trackFragment.o = false;
            trackFragment.m = null;
            this.f = 0;
            this.h = 0;
            this.g = 0;
            this.i = 0;
            this.l = false;
        }
    }

    static {
        Format2.b bVar = new Format2.b();
        bVar.k = "application/x-emsg";
        f1215b = bVar.a();
    }

    public FragmentedMp4Extractor(int i) {
        List listEmptyList = Collections.emptyList();
        this.c = i;
        this.d = Collections.unmodifiableList(listEmptyList);
        this.k = new EventMessageEncoder();
        this.l = new ParsableByteArray(16);
        this.f = new ParsableByteArray(NalUnitUtil.a);
        this.g = new ParsableByteArray(5);
        this.h = new ParsableByteArray();
        byte[] bArr = new byte[16];
        this.i = bArr;
        this.j = new ParsableByteArray(bArr);
        this.m = new ArrayDeque<>();
        this.n = new ArrayDeque<>();
        this.e = new SparseArray<>();
        this.w = -9223372036854775807L;
        this.v = -9223372036854775807L;
        this.f1217x = -9223372036854775807L;
        this.D = ExtractorOutput.d;
        this.E = new TrackOutput2[0];
        this.F = new TrackOutput2[0];
    }

    public static int a(int i) throws ParserException {
        if (i >= 0) {
            return i;
        }
        throw outline.w0(38, "Unexpected negative value: ", i, null);
    }

    @Nullable
    public static DrmInitData h(List<Atom.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            Atom.b bVar = list.get(i);
            if (bVar.a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.f1210b.a;
                PsshAtomUtil psshAtomUtilV1 = AnimatableValueParser.v1(bArr);
                UUID uuid = psshAtomUtilV1 == null ? null : psshAtomUtilV1.a;
                if (uuid == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuid, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(null, false, (DrmInitData.SchemeData[]) arrayList.toArray(new DrmInitData.SchemeData[0]));
    }

    public static void i(ParsableByteArray parsableByteArray, int i, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.E(i + 8);
        int iF = parsableByteArray.f() & ViewCompat.MEASURED_SIZE_MASK;
        if ((iF & 1) != 0) {
            throw ParserException.b("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z2 = (iF & 2) != 0;
        int iW = parsableByteArray.w();
        if (iW == 0) {
            Arrays.fill(trackFragment.l, 0, trackFragment.e, false);
            return;
        }
        int i2 = trackFragment.e;
        if (iW != i2) {
            throw ParserException.a(outline.h(80, "Senc sample count ", iW, " is different from fragment sample count", i2), null);
        }
        Arrays.fill(trackFragment.l, 0, iW, z2);
        int iA = parsableByteArray.a();
        ParsableByteArray parsableByteArray2 = trackFragment.n;
        byte[] bArr = parsableByteArray2.a;
        if (bArr.length < iA) {
            bArr = new byte[iA];
        }
        parsableByteArray2.a = bArr;
        parsableByteArray2.c = iA;
        parsableByteArray2.f984b = 0;
        trackFragment.k = true;
        trackFragment.o = true;
        parsableByteArray.e(bArr, 0, iA);
        trackFragment.n.E(0);
        trackFragment.o = false;
    }

    @Override // b.i.a.c.x2.Extractor
    public boolean b(ExtractorInput extractorInput) throws IOException {
        return Sniffer2.a(extractorInput, true, false);
    }

    public final void c() {
        this.o = 0;
        this.r = 0;
    }

    public final DefaultSampleValues d(SparseArray<DefaultSampleValues> sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        DefaultSampleValues defaultSampleValues = sparseArray.get(i);
        Objects.requireNonNull(defaultSampleValues);
        return defaultSampleValues;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:102:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:103:0x0221  */
    /* JADX WARN: Code duplicated, block: B:106:0x0236 A[LOOP:10: B:106:0x0236->B:108:0x023c, LOOP_START] */
    /* JADX WARN: Code duplicated, block: B:108:0x023c A[LOOP:10: B:106:0x0236->B:108:0x023c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:111:0x024c  */
    /* JADX WARN: Code duplicated, block: B:112:0x0255  */
    /* JADX WARN: Code duplicated, block: B:114:0x025f  */
    /* JADX WARN: Code duplicated, block: B:115:0x0261  */
    /* JADX WARN: Code duplicated, block: B:118:0x0268  */
    /* JADX WARN: Code duplicated, block: B:121:0x0272  */
    /* JADX WARN: Code duplicated, block: B:122:0x0275  */
    /* JADX WARN: Code duplicated, block: B:126:0x0287  */
    /* JADX WARN: Code duplicated, block: B:128:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:131:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:207:0x0588  */
    /* JADX WARN: Code duplicated, block: B:208:0x059f  */
    /* JADX WARN: Code duplicated, block: B:210:0x05a5  */
    /* JADX WARN: Code duplicated, block: B:217:0x05c5  */
    /* JADX WARN: Code duplicated, block: B:220:0x05d9  */
    /* JADX WARN: Code duplicated, block: B:228:0x0604  */
    /* JADX WARN: Code duplicated, block: B:230:0x060d A[LOOP:1: B:229:0x060b->B:230:0x060d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:233:0x0625  */
    /* JADX WARN: Code duplicated, block: B:234:0x0632  */
    /* JADX WARN: Code duplicated, block: B:253:0x065f  */
    /* JADX WARN: Code duplicated, block: B:255:0x0662  */
    /* JADX WARN: Code duplicated, block: B:257:0x0681  */
    /* JADX WARN: Code duplicated, block: B:258:0x0686  */
    /* JADX WARN: Code duplicated, block: B:259:0x068b  */
    /* JADX WARN: Code duplicated, block: B:315:0x0714  */
    /* JADX WARN: Code duplicated, block: B:318:0x071a  */
    /* JADX WARN: Code duplicated, block: B:320:0x0720  */
    /* JADX WARN: Code duplicated, block: B:322:0x0726  */
    /* JADX WARN: Code duplicated, block: B:327:0x074a  */
    /* JADX WARN: Code duplicated, block: B:329:0x0750  */
    /* JADX WARN: Code duplicated, block: B:344:0x01d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:353:0x0743 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:354:0x073c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:355:0x075b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:357:0x0762 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0090  */
    /* JADX WARN: Code duplicated, block: B:384:0x0248 A[EDGE_INSN: B:384:0x0248->B:109:0x0248 BREAK  A[LOOP:10: B:106:0x0236->B:108:0x023c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0094  */
    /* JADX WARN: Code duplicated, block: B:40:0x009d  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:48:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:59:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:66:0x010b  */
    /* JADX WARN: Code duplicated, block: B:67:0x0128  */
    /* JADX WARN: Code duplicated, block: B:69:0x013e  */
    /* JADX WARN: Code duplicated, block: B:71:0x0148  */
    /* JADX WARN: Code duplicated, block: B:72:0x014f  */
    /* JADX WARN: Code duplicated, block: B:75:0x015c  */
    /* JADX WARN: Code duplicated, block: B:78:0x0172  */
    /* JADX WARN: Code duplicated, block: B:80:0x0178  */
    /* JADX WARN: Code duplicated, block: B:82:0x0189  */
    /* JADX WARN: Code duplicated, block: B:84:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:86:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:88:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:95:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:96:0x01ca  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // b.i.a.c.x2.Extractor
    public int e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        char c;
        TrackSampleTable trackSampleTable;
        Track track;
        TrackOutput2 trackOutput2;
        long j;
        long j2;
        int i;
        int i2;
        int i3;
        int i4;
        TrackEncryptionBox trackEncryptionBoxB;
        TrackOutput2.a aVar;
        a aVarRemoveFirst;
        long j3;
        TrackOutput2[] trackOutput2Arr;
        int length;
        int i5;
        byte[] bArr;
        int i6;
        int i7;
        int i8;
        int iB;
        int iF;
        boolean z2;
        String str;
        byte b2;
        int i9;
        TrackEncryptionBox trackEncryptionBoxB2;
        ParsableByteArray parsableByteArray;
        int i10;
        TrackFragment trackFragment;
        boolean z3;
        String strN;
        String strN2;
        long jF;
        long j4;
        long jU;
        long jX;
        long jX2;
        long j5;
        long jB;
        long position;
        int i11;
        int i12;
        boolean z4;
        boolean z5;
        long j6;
        long position2;
        boolean z6;
        int size;
        int i13;
        while (true) {
            int i14 = this.o;
            int i15 = 1;
            if (i14 == 0) {
                if (this.r != 0) {
                    j5 = this.q;
                    if (j5 == 1) {
                        extractorInput.readFully(this.l.a, 8, 8);
                        this.r += 8;
                        this.q = this.l.x();
                    } else if (j5 == 0) {
                        jB = extractorInput.b();
                        if (jB == -1 && !this.m.isEmpty()) {
                            jB = this.m.peek().f1209b;
                        }
                        if (jB != -1) {
                            this.q = (jB - extractorInput.getPosition()) + ((long) this.r);
                        }
                    }
                    if (this.q >= this.r) {
                        throw ParserException.b("Atom size less than header length (unsupported).");
                    }
                    position = extractorInput.getPosition() - ((long) this.r);
                    i11 = this.p;
                    if ((i11 != 1836019558 || i11 == 1835295092) && !this.G) {
                        this.D.a(new SeekMap.b(this.w, position));
                        this.G = true;
                    }
                    if (this.p == 1836019558) {
                        size = this.e.size();
                        for (i13 = 0; i13 < size; i13++) {
                            TrackFragment trackFragment2 = this.e.valueAt(i13).f1221b;
                            Objects.requireNonNull(trackFragment2);
                            trackFragment2.c = position;
                            trackFragment2.f1232b = position;
                        }
                    }
                    i12 = this.p;
                    if (i12 == 1835295092) {
                        this.f1218y = null;
                        this.t = position + this.q;
                        this.o = 2;
                    } else {
                        if (i12 != 1836019574 || i12 == 1953653099 || i12 == 1835297121 || i12 == 1835626086 || i12 == 1937007212 || i12 == 1836019558 || i12 == 1953653094 || i12 == 1836475768 || i12 == 1701082227) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            position2 = (extractorInput.getPosition() + this.q) - 8;
                            this.m.push(new Atom.a(this.p, position2));
                            if (this.q == this.r) {
                                j(position2);
                            } else {
                                c();
                            }
                        } else {
                            if (i12 != 1751411826 || i12 == 1835296868 || i12 == 1836476516 || i12 == 1936286840 || i12 == 1937011556 || i12 == 1937011827 || i12 == 1668576371 || i12 == 1937011555 || i12 == 1937011578 || i12 == 1937013298 || i12 == 1937007471 || i12 == 1668232756 || i12 == 1937011571 || i12 == 1952867444 || i12 == 1952868452 || i12 == 1953196132 || i12 == 1953654136 || i12 == 1953658222 || i12 == 1886614376 || i12 == 1935763834 || i12 == 1935763823 || i12 == 1936027235 || i12 == 1970628964 || i12 == 1935828848 || i12 == 1936158820 || i12 == 1701606260 || i12 == 1835362404 || i12 == 1701671783) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (z5) {
                                if (this.r == 8) {
                                    throw ParserException.b("Leaf atom defines extended atom size (unsupported).");
                                }
                                j6 = this.q;
                                if (j6 <= 2147483647L) {
                                    throw ParserException.b("Leaf atom with length > 2147483647 (unsupported).");
                                }
                                ParsableByteArray parsableByteArray2 = new ParsableByteArray((int) j6);
                                System.arraycopy(this.l.a, 0, parsableByteArray2.a, 0, 8);
                                this.f1216s = parsableByteArray2;
                                this.o = 1;
                            } else {
                                if (this.q <= 2147483647L) {
                                    throw ParserException.b("Skipping atom with length > 2147483647 (unsupported).");
                                }
                                this.f1216s = null;
                                this.o = 1;
                            }
                        }
                    }
                    z6 = true;
                } else if (extractorInput.c(this.l.a, 0, 8, true)) {
                    this.r = 8;
                    this.l.E(0);
                    this.q = this.l.u();
                    this.p = this.l.f();
                    j5 = this.q;
                    if (j5 == 1) {
                        extractorInput.readFully(this.l.a, 8, 8);
                        this.r += 8;
                        this.q = this.l.x();
                    } else if (j5 == 0) {
                        jB = extractorInput.b();
                        if (jB == -1) {
                            jB = this.m.peek().f1209b;
                        }
                        if (jB != -1) {
                            this.q = (jB - extractorInput.getPosition()) + ((long) this.r);
                        }
                    }
                    if (this.q >= this.r) {
                        throw ParserException.b("Atom size less than header length (unsupported).");
                    }
                    position = extractorInput.getPosition() - ((long) this.r);
                    i11 = this.p;
                    if (i11 != 1836019558) {
                        this.D.a(new SeekMap.b(this.w, position));
                        this.G = true;
                    } else {
                        this.D.a(new SeekMap.b(this.w, position));
                        this.G = true;
                    }
                    if (this.p == 1836019558) {
                        size = this.e.size();
                        while (i13 < size) {
                            TrackFragment trackFragment3 = this.e.valueAt(i13).f1221b;
                            Objects.requireNonNull(trackFragment3);
                            trackFragment3.c = position;
                            trackFragment3.f1232b = position;
                        }
                    }
                    i12 = this.p;
                    if (i12 == 1835295092) {
                        this.f1218y = null;
                        this.t = position + this.q;
                        this.o = 2;
                    } else {
                        if (i12 != 1836019574) {
                            z4 = true;
                        } else {
                            z4 = true;
                        }
                        if (z4) {
                            position2 = (extractorInput.getPosition() + this.q) - 8;
                            this.m.push(new Atom.a(this.p, position2));
                            if (this.q == this.r) {
                                j(position2);
                            } else {
                                c();
                            }
                        } else {
                            if (i12 != 1751411826) {
                                z5 = true;
                            } else {
                                z5 = true;
                            }
                            if (z5) {
                                if (this.r == 8) {
                                    throw ParserException.b("Leaf atom defines extended atom size (unsupported).");
                                }
                                j6 = this.q;
                                if (j6 <= 2147483647L) {
                                    throw ParserException.b("Leaf atom with length > 2147483647 (unsupported).");
                                }
                                ParsableByteArray parsableByteArray3 = new ParsableByteArray((int) j6);
                                System.arraycopy(this.l.a, 0, parsableByteArray3.a, 0, 8);
                                this.f1216s = parsableByteArray3;
                                this.o = 1;
                            } else {
                                if (this.q <= 2147483647L) {
                                    throw ParserException.b("Skipping atom with length > 2147483647 (unsupported).");
                                }
                                this.f1216s = null;
                                this.o = 1;
                            }
                        }
                    }
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (!z6) {
                    return -1;
                }
            } else if (i14 == 1) {
                int i16 = ((int) this.q) - this.r;
                ParsableByteArray parsableByteArray4 = this.f1216s;
                if (parsableByteArray4 != null) {
                    extractorInput.readFully(parsableByteArray4.a, 8, i16);
                    int i17 = this.p;
                    Atom.b bVar = new Atom.b(i17, parsableByteArray4);
                    long position3 = extractorInput.getPosition();
                    if (!this.m.isEmpty()) {
                        this.m.peek().c.add(bVar);
                    } else if (i17 == 1936286840) {
                        parsableByteArray4.E(8);
                        int iF2 = (parsableByteArray4.f() >> 24) & 255;
                        parsableByteArray4.F(4);
                        long jU2 = parsableByteArray4.u();
                        if (iF2 == 0) {
                            jX = parsableByteArray4.u();
                            jX2 = parsableByteArray4.u();
                        } else {
                            jX = parsableByteArray4.x();
                            jX2 = parsableByteArray4.x();
                        }
                        long j7 = position3 + jX2;
                        long jF2 = Util2.F(jX, 1000000L, jU2);
                        parsableByteArray4.F(2);
                        int iY = parsableByteArray4.y();
                        int[] iArr = new int[iY];
                        long[] jArr = new long[iY];
                        long[] jArr2 = new long[iY];
                        long[] jArr3 = new long[iY];
                        int i18 = 0;
                        long jF3 = jF2;
                        while (i18 < iY) {
                            int iF3 = parsableByteArray4.f();
                            if ((iF3 & Integer.MIN_VALUE) != 0) {
                                throw ParserException.a("Unhandled indirect reference", null);
                            }
                            long jU3 = parsableByteArray4.u();
                            iArr[i18] = iF3 & Integer.MAX_VALUE;
                            jArr[i18] = j7;
                            jArr3[i18] = jF3;
                            long j8 = jX + jU3;
                            int i19 = i18;
                            int i20 = iY;
                            long[] jArr4 = jArr2;
                            long[] jArr5 = jArr3;
                            jF3 = Util2.F(j8, 1000000L, jU2);
                            jArr4[i19] = jF3 - jArr5[i19];
                            parsableByteArray4.F(4);
                            j7 += (long) iArr[i19];
                            i18 = i19 + 1;
                            jArr2 = jArr4;
                            jArr3 = jArr5;
                            jArr = jArr;
                            jX = j8;
                            iY = i20;
                        }
                        Pair pairCreate = Pair.create(Long.valueOf(jF2), new ChunkIndex(iArr, jArr, jArr2, jArr3));
                        this.f1217x = ((Long) pairCreate.first).longValue();
                        this.D.a((SeekMap) pairCreate.second);
                        this.G = true;
                    } else if (i17 == 1701671783 && this.E.length != 0) {
                        parsableByteArray4.E(8);
                        int iF4 = (parsableByteArray4.f() >> 24) & 255;
                        long j9 = -9223372036854775807L;
                        if (iF4 == 0) {
                            strN = parsableByteArray4.n();
                            Objects.requireNonNull(strN);
                            strN2 = parsableByteArray4.n();
                            Objects.requireNonNull(strN2);
                            long jU4 = parsableByteArray4.u();
                            long jF4 = Util2.F(parsableByteArray4.u(), 1000000L, jU4);
                            long j10 = this.f1217x;
                            j9 = j10 != -9223372036854775807L ? j10 + jF4 : -9223372036854775807L;
                            jF = Util2.F(parsableByteArray4.u(), 1000L, jU4);
                            j4 = j9;
                            j9 = jF4;
                            jU = parsableByteArray4.u();
                        } else if (iF4 != 1) {
                            outline.g0(46, "Skipping unsupported emsg version: ", iF4, "FragmentedMp4Extractor");
                        } else {
                            long jU5 = parsableByteArray4.u();
                            long jF5 = Util2.F(parsableByteArray4.x(), 1000000L, jU5);
                            jF = Util2.F(parsableByteArray4.u(), 1000L, jU5);
                            jU = parsableByteArray4.u();
                            strN = parsableByteArray4.n();
                            Objects.requireNonNull(strN);
                            strN2 = parsableByteArray4.n();
                            Objects.requireNonNull(strN2);
                            j4 = jF5;
                        }
                        byte[] bArr2 = new byte[parsableByteArray4.a()];
                        int iA = parsableByteArray4.a();
                        System.arraycopy(parsableByteArray4.a, parsableByteArray4.f984b, bArr2, 0, iA);
                        parsableByteArray4.f984b += iA;
                        EventMessageEncoder eventMessageEncoder = this.k;
                        eventMessageEncoder.a.reset();
                        try {
                            DataOutputStream dataOutputStream = eventMessageEncoder.f1322b;
                            dataOutputStream.writeBytes(strN);
                            dataOutputStream.writeByte(0);
                            DataOutputStream dataOutputStream2 = eventMessageEncoder.f1322b;
                            dataOutputStream2.writeBytes(strN2);
                            dataOutputStream2.writeByte(0);
                            eventMessageEncoder.f1322b.writeLong(jF);
                            eventMessageEncoder.f1322b.writeLong(jU);
                            eventMessageEncoder.f1322b.write(bArr2);
                            eventMessageEncoder.f1322b.flush();
                            ParsableByteArray parsableByteArray5 = new ParsableByteArray(eventMessageEncoder.a.toByteArray());
                            int iA2 = parsableByteArray5.a();
                            for (TrackOutput2 trackOutput3 : this.E) {
                                parsableByteArray5.E(0);
                                trackOutput3.c(parsableByteArray5, iA2);
                            }
                            if (j4 == -9223372036854775807L) {
                                this.n.addLast(new a(j9, iA2));
                                this.u += iA2;
                            } else {
                                for (TrackOutput2 trackOutput4 : this.E) {
                                    trackOutput4.d(j4, 1, iA2, 0, null);
                                }
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                } else {
                    extractorInput.l(i16);
                }
                j(extractorInput.getPosition());
            } else if (i14 != 2) {
                b bVar2 = this.f1218y;
                if (bVar2 == null) {
                    SparseArray<b> sparseArray = this.e;
                    int size2 = sparseArray.size();
                    long j11 = Long.MAX_VALUE;
                    b bVar3 = null;
                    for (int i21 = 0; i21 < size2; i21++) {
                        b bVarValueAt = sparseArray.valueAt(i21);
                        boolean z7 = bVarValueAt.l;
                        if ((z7 || bVarValueAt.f != bVarValueAt.d.f1233b) && (!z7 || bVarValueAt.h != bVarValueAt.f1221b.d)) {
                            long jA = bVarValueAt.a();
                            if (jA < j11) {
                                bVar3 = bVarValueAt;
                                j11 = jA;
                            }
                        }
                    }
                    if (bVar3 == null) {
                        int position4 = (int) (this.t - extractorInput.getPosition());
                        if (position4 < 0) {
                            throw ParserException.a("Offset to end of mdat was negative.", null);
                        }
                        extractorInput.l(position4);
                        c();
                        i15 = 0;
                    } else {
                        int iA3 = (int) (bVar3.a() - extractorInput.getPosition());
                        if (iA3 < 0) {
                            Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                            iA3 = 0;
                        }
                        extractorInput.l(iA3);
                        this.f1218y = bVar3;
                        bVar2 = bVar3;
                        c = 6;
                        if (this.o != 3) {
                            trackSampleTable = bVar2.d;
                            track = trackSampleTable.a;
                            trackOutput2 = bVar2.a;
                            if (bVar2.l) {
                                j = bVar2.f1221b.i[bVar2.f];
                            } else {
                                j = trackSampleTable.f[bVar2.f];
                            }
                            j2 = j;
                            i = track.j;
                            if (i != 0) {
                                while (true) {
                                    i2 = this.A;
                                    i3 = this.f1219z;
                                    if (i2 < i3) {
                                        break;
                                    }
                                    this.A += trackOutput2.b(extractorInput, i3 - i2, false);
                                }
                            } else {
                                bArr = this.g.a;
                                bArr[0] = 0;
                                bArr[1] = 0;
                                bArr[2] = 0;
                                i6 = i + 1;
                                i7 = 4 - i;
                                while (this.A < this.f1219z) {
                                    i8 = this.B;
                                    if (i8 == 0) {
                                        extractorInput.readFully(bArr, i7, i6);
                                        this.g.E(0);
                                        iF = this.g.f();
                                        if (iF >= i15) {
                                            throw ParserException.a("Invalid NAL length", null);
                                        }
                                        this.B = iF - 1;
                                        this.f.E(0);
                                        trackOutput2.c(this.f, 4);
                                        trackOutput2.c(this.g, i15);
                                        if (this.F.length > 0) {
                                            str = track.f.w;
                                            b2 = bArr[4];
                                            byte[] bArr3 = NalUnitUtil.a;
                                            if ((!"video/avc".equals(str) && (b2 & 31) == c) || ("video/hevc".equals(str) && ((b2 & 126) >> i15) == 39)) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                        } else {
                                            z2 = false;
                                        }
                                        this.C = z2;
                                        this.A += 5;
                                        this.f1219z += i7;
                                    } else {
                                        if (this.C) {
                                            this.h.A(i8);
                                            extractorInput.readFully(this.h.a, 0, this.B);
                                            trackOutput2.c(this.h, this.B);
                                            iB = this.B;
                                            ParsableByteArray parsableByteArray6 = this.h;
                                            int iF5 = NalUnitUtil.f(parsableByteArray6.a, parsableByteArray6.c);
                                            this.h.E("video/hevc".equals(track.f.w) ? 1 : 0);
                                            this.h.D(iF5);
                                            AnimatableValueParser.J(j2, this.h, this.F);
                                        } else {
                                            iB = trackOutput2.b(extractorInput, i8, false);
                                        }
                                        this.A += iB;
                                        this.B -= iB;
                                        c = 6;
                                        i15 = 1;
                                    }
                                }
                            }
                            if (!bVar2.l) {
                                i4 = bVar2.d.g[bVar2.f];
                            } else if (bVar2.f1221b.j[bVar2.f]) {
                                i4 = 1;
                            } else {
                                i4 = 0;
                            }
                            if (bVar2.b() != null) {
                                i4 |= BasicMeasure.EXACTLY;
                            }
                            int i22 = i4;
                            trackEncryptionBoxB = bVar2.b();
                            if (trackEncryptionBoxB != null) {
                                aVar = trackEncryptionBoxB.c;
                            } else {
                                aVar = null;
                            }
                            trackOutput2.d(j2, i22, this.f1219z, 0, aVar);
                            while (!this.n.isEmpty()) {
                                aVarRemoveFirst = this.n.removeFirst();
                                this.u -= aVarRemoveFirst.f1220b;
                                j3 = aVarRemoveFirst.a + j2;
                                trackOutput2Arr = this.E;
                                i5 = 0;
                                for (length = trackOutput2Arr.length; i5 < length; length = length) {
                                    trackOutput2Arr[i5].d(j3, 1, aVarRemoveFirst.f1220b, this.u, null);
                                    i5++;
                                }
                            }
                            if (!bVar2.c()) {
                                this.f1218y = null;
                            }
                            this.o = 3;
                            i15 = 1;
                        } else {
                            if (bVar2.l) {
                                i9 = bVar2.f1221b.h[bVar2.f];
                            } else {
                                i9 = bVar2.d.d[bVar2.f];
                            }
                            this.f1219z = i9;
                            if (bVar2.f < bVar2.i) {
                                extractorInput.l(i9);
                                trackEncryptionBoxB2 = bVar2.b();
                                if (trackEncryptionBoxB2 != null) {
                                    parsableByteArray = bVar2.f1221b.n;
                                    i10 = trackEncryptionBoxB2.d;
                                    if (i10 != 0) {
                                        parsableByteArray.F(i10);
                                    }
                                    trackFragment = bVar2.f1221b;
                                    int i23 = bVar2.f;
                                    if (trackFragment.k || !trackFragment.l[i23]) {
                                        z3 = false;
                                    } else {
                                        z3 = true;
                                    }
                                    if (z3) {
                                        parsableByteArray.F(parsableByteArray.y() * 6);
                                    }
                                }
                                if (!bVar2.c()) {
                                    this.f1218y = null;
                                }
                                this.o = 3;
                            } else {
                                if (bVar2.d.a.g == 1) {
                                    this.f1219z = i9 - 8;
                                    extractorInput.l(8);
                                }
                                if ("audio/ac4".equals(bVar2.d.a.f.w)) {
                                    this.A = bVar2.d(this.f1219z, 7);
                                    Ac4Util.a(this.f1219z, this.j);
                                    bVar2.a.c(this.j, 7);
                                    this.A += 7;
                                } else {
                                    this.A = bVar2.d(this.f1219z, 0);
                                }
                                this.f1219z += this.A;
                                this.o = 4;
                                this.B = 0;
                                trackSampleTable = bVar2.d;
                                track = trackSampleTable.a;
                                trackOutput2 = bVar2.a;
                                if (bVar2.l) {
                                    j = trackSampleTable.f[bVar2.f];
                                } else {
                                    j = bVar2.f1221b.i[bVar2.f];
                                }
                                j2 = j;
                                i = track.j;
                                if (i != 0) {
                                    while (true) {
                                        i2 = this.A;
                                        i3 = this.f1219z;
                                        if (i2 < i3) {
                                            break;
                                            break;
                                        }
                                        this.A += trackOutput2.b(extractorInput, i3 - i2, false);
                                    }
                                } else {
                                    bArr = this.g.a;
                                    bArr[0] = 0;
                                    bArr[1] = 0;
                                    bArr[2] = 0;
                                    i6 = i + 1;
                                    i7 = 4 - i;
                                    while (this.A < this.f1219z) {
                                        i8 = this.B;
                                        if (i8 == 0) {
                                            extractorInput.readFully(bArr, i7, i6);
                                            this.g.E(0);
                                            iF = this.g.f();
                                            if (iF >= i15) {
                                                throw ParserException.a("Invalid NAL length", null);
                                            }
                                            this.B = iF - 1;
                                            this.f.E(0);
                                            trackOutput2.c(this.f, 4);
                                            trackOutput2.c(this.g, i15);
                                            if (this.F.length > 0) {
                                                str = track.f.w;
                                                b2 = bArr[4];
                                                byte[] bArr4 = NalUnitUtil.a;
                                                if ((!"video/avc".equals(str) && (b2 & 31) == c) || ("video/hevc".equals(str) && ((b2 & 126) >> i15) == 39)) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                            } else {
                                                z2 = false;
                                            }
                                            this.C = z2;
                                            this.A += 5;
                                            this.f1219z += i7;
                                        } else {
                                            if (this.C) {
                                                this.h.A(i8);
                                                extractorInput.readFully(this.h.a, 0, this.B);
                                                trackOutput2.c(this.h, this.B);
                                                iB = this.B;
                                                ParsableByteArray parsableByteArray7 = this.h;
                                                int iF6 = NalUnitUtil.f(parsableByteArray7.a, parsableByteArray7.c);
                                                this.h.E("video/hevc".equals(track.f.w) ? 1 : 0);
                                                this.h.D(iF6);
                                                AnimatableValueParser.J(j2, this.h, this.F);
                                            } else {
                                                iB = trackOutput2.b(extractorInput, i8, false);
                                            }
                                            this.A += iB;
                                            this.B -= iB;
                                            c = 6;
                                            i15 = 1;
                                        }
                                    }
                                }
                                if (!bVar2.l) {
                                    i4 = bVar2.d.g[bVar2.f];
                                } else if (bVar2.f1221b.j[bVar2.f]) {
                                    i4 = 1;
                                } else {
                                    i4 = 0;
                                }
                                if (bVar2.b() != null) {
                                    i4 |= BasicMeasure.EXACTLY;
                                }
                                int i24 = i4;
                                trackEncryptionBoxB = bVar2.b();
                                if (trackEncryptionBoxB != null) {
                                    aVar = trackEncryptionBoxB.c;
                                } else {
                                    aVar = null;
                                }
                                trackOutput2.d(j2, i24, this.f1219z, 0, aVar);
                                while (!this.n.isEmpty()) {
                                    aVarRemoveFirst = this.n.removeFirst();
                                    this.u -= aVarRemoveFirst.f1220b;
                                    j3 = aVarRemoveFirst.a + j2;
                                    trackOutput2Arr = this.E;
                                    i5 = 0;
                                    while (i5 < length) {
                                        trackOutput2Arr[i5].d(j3, 1, aVarRemoveFirst.f1220b, this.u, null);
                                        i5++;
                                    }
                                }
                                if (!bVar2.c()) {
                                    this.f1218y = null;
                                }
                                this.o = 3;
                                i15 = 1;
                            }
                        }
                    }
                } else {
                    c = 6;
                    if (this.o != 3) {
                        trackSampleTable = bVar2.d;
                        track = trackSampleTable.a;
                        trackOutput2 = bVar2.a;
                        if (bVar2.l) {
                            j = trackSampleTable.f[bVar2.f];
                        } else {
                            j = bVar2.f1221b.i[bVar2.f];
                        }
                        j2 = j;
                        i = track.j;
                        if (i != 0) {
                            while (true) {
                                i2 = this.A;
                                i3 = this.f1219z;
                                if (i2 < i3) {
                                    break;
                                    break;
                                }
                                this.A += trackOutput2.b(extractorInput, i3 - i2, false);
                            }
                        } else {
                            bArr = this.g.a;
                            bArr[0] = 0;
                            bArr[1] = 0;
                            bArr[2] = 0;
                            i6 = i + 1;
                            i7 = 4 - i;
                            while (this.A < this.f1219z) {
                                i8 = this.B;
                                if (i8 == 0) {
                                    extractorInput.readFully(bArr, i7, i6);
                                    this.g.E(0);
                                    iF = this.g.f();
                                    if (iF >= i15) {
                                        throw ParserException.a("Invalid NAL length", null);
                                    }
                                    this.B = iF - 1;
                                    this.f.E(0);
                                    trackOutput2.c(this.f, 4);
                                    trackOutput2.c(this.g, i15);
                                    if (this.F.length > 0) {
                                        str = track.f.w;
                                        b2 = bArr[4];
                                        byte[] bArr5 = NalUnitUtil.a;
                                        if ((!"video/avc".equals(str) && (b2 & 31) == c) || ("video/hevc".equals(str) && ((b2 & 126) >> i15) == 39)) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                    } else {
                                        z2 = false;
                                    }
                                    this.C = z2;
                                    this.A += 5;
                                    this.f1219z += i7;
                                } else {
                                    if (this.C) {
                                        this.h.A(i8);
                                        extractorInput.readFully(this.h.a, 0, this.B);
                                        trackOutput2.c(this.h, this.B);
                                        iB = this.B;
                                        ParsableByteArray parsableByteArray8 = this.h;
                                        int iF7 = NalUnitUtil.f(parsableByteArray8.a, parsableByteArray8.c);
                                        this.h.E("video/hevc".equals(track.f.w) ? 1 : 0);
                                        this.h.D(iF7);
                                        AnimatableValueParser.J(j2, this.h, this.F);
                                    } else {
                                        iB = trackOutput2.b(extractorInput, i8, false);
                                    }
                                    this.A += iB;
                                    this.B -= iB;
                                    c = 6;
                                    i15 = 1;
                                }
                            }
                        }
                        if (!bVar2.l) {
                            i4 = bVar2.d.g[bVar2.f];
                        } else if (bVar2.f1221b.j[bVar2.f]) {
                            i4 = 1;
                        } else {
                            i4 = 0;
                        }
                        if (bVar2.b() != null) {
                            i4 |= BasicMeasure.EXACTLY;
                        }
                        int i25 = i4;
                        trackEncryptionBoxB = bVar2.b();
                        if (trackEncryptionBoxB != null) {
                            aVar = trackEncryptionBoxB.c;
                        } else {
                            aVar = null;
                        }
                        trackOutput2.d(j2, i25, this.f1219z, 0, aVar);
                        while (!this.n.isEmpty()) {
                            aVarRemoveFirst = this.n.removeFirst();
                            this.u -= aVarRemoveFirst.f1220b;
                            j3 = aVarRemoveFirst.a + j2;
                            trackOutput2Arr = this.E;
                            i5 = 0;
                            while (i5 < length) {
                                trackOutput2Arr[i5].d(j3, 1, aVarRemoveFirst.f1220b, this.u, null);
                                i5++;
                            }
                        }
                        if (!bVar2.c()) {
                            this.f1218y = null;
                        }
                        this.o = 3;
                        i15 = 1;
                    } else {
                        if (bVar2.l) {
                            i9 = bVar2.d.d[bVar2.f];
                        } else {
                            i9 = bVar2.f1221b.h[bVar2.f];
                        }
                        this.f1219z = i9;
                        if (bVar2.f < bVar2.i) {
                            extractorInput.l(i9);
                            trackEncryptionBoxB2 = bVar2.b();
                            if (trackEncryptionBoxB2 != null) {
                                parsableByteArray = bVar2.f1221b.n;
                                i10 = trackEncryptionBoxB2.d;
                                if (i10 != 0) {
                                    parsableByteArray.F(i10);
                                }
                                trackFragment = bVar2.f1221b;
                                int i26 = bVar2.f;
                                if (trackFragment.k) {
                                    z3 = false;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    parsableByteArray.F(parsableByteArray.y() * 6);
                                }
                            }
                            if (!bVar2.c()) {
                                this.f1218y = null;
                            }
                            this.o = 3;
                        } else {
                            if (bVar2.d.a.g == 1) {
                                this.f1219z = i9 - 8;
                                extractorInput.l(8);
                            }
                            if ("audio/ac4".equals(bVar2.d.a.f.w)) {
                                this.A = bVar2.d(this.f1219z, 7);
                                Ac4Util.a(this.f1219z, this.j);
                                bVar2.a.c(this.j, 7);
                                this.A += 7;
                            } else {
                                this.A = bVar2.d(this.f1219z, 0);
                            }
                            this.f1219z += this.A;
                            this.o = 4;
                            this.B = 0;
                            trackSampleTable = bVar2.d;
                            track = trackSampleTable.a;
                            trackOutput2 = bVar2.a;
                            if (bVar2.l) {
                                j = trackSampleTable.f[bVar2.f];
                            } else {
                                j = bVar2.f1221b.i[bVar2.f];
                            }
                            j2 = j;
                            i = track.j;
                            if (i != 0) {
                                while (true) {
                                    i2 = this.A;
                                    i3 = this.f1219z;
                                    if (i2 < i3) {
                                        break;
                                        break;
                                    }
                                    this.A += trackOutput2.b(extractorInput, i3 - i2, false);
                                }
                            } else {
                                bArr = this.g.a;
                                bArr[0] = 0;
                                bArr[1] = 0;
                                bArr[2] = 0;
                                i6 = i + 1;
                                i7 = 4 - i;
                                while (this.A < this.f1219z) {
                                    i8 = this.B;
                                    if (i8 == 0) {
                                        extractorInput.readFully(bArr, i7, i6);
                                        this.g.E(0);
                                        iF = this.g.f();
                                        if (iF >= i15) {
                                            throw ParserException.a("Invalid NAL length", null);
                                        }
                                        this.B = iF - 1;
                                        this.f.E(0);
                                        trackOutput2.c(this.f, 4);
                                        trackOutput2.c(this.g, i15);
                                        if (this.F.length > 0) {
                                            str = track.f.w;
                                            b2 = bArr[4];
                                            byte[] bArr6 = NalUnitUtil.a;
                                            if ((!"video/avc".equals(str) && (b2 & 31) == c) || ("video/hevc".equals(str) && ((b2 & 126) >> i15) == 39)) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                        } else {
                                            z2 = false;
                                        }
                                        this.C = z2;
                                        this.A += 5;
                                        this.f1219z += i7;
                                    } else {
                                        if (this.C) {
                                            this.h.A(i8);
                                            extractorInput.readFully(this.h.a, 0, this.B);
                                            trackOutput2.c(this.h, this.B);
                                            iB = this.B;
                                            ParsableByteArray parsableByteArray9 = this.h;
                                            int iF8 = NalUnitUtil.f(parsableByteArray9.a, parsableByteArray9.c);
                                            this.h.E("video/hevc".equals(track.f.w) ? 1 : 0);
                                            this.h.D(iF8);
                                            AnimatableValueParser.J(j2, this.h, this.F);
                                        } else {
                                            iB = trackOutput2.b(extractorInput, i8, false);
                                        }
                                        this.A += iB;
                                        this.B -= iB;
                                        c = 6;
                                        i15 = 1;
                                    }
                                }
                            }
                            if (!bVar2.l) {
                                i4 = bVar2.d.g[bVar2.f];
                            } else if (bVar2.f1221b.j[bVar2.f]) {
                                i4 = 1;
                            } else {
                                i4 = 0;
                            }
                            if (bVar2.b() != null) {
                                i4 |= BasicMeasure.EXACTLY;
                            }
                            int i27 = i4;
                            trackEncryptionBoxB = bVar2.b();
                            if (trackEncryptionBoxB != null) {
                                aVar = trackEncryptionBoxB.c;
                            } else {
                                aVar = null;
                            }
                            trackOutput2.d(j2, i27, this.f1219z, 0, aVar);
                            while (!this.n.isEmpty()) {
                                aVarRemoveFirst = this.n.removeFirst();
                                this.u -= aVarRemoveFirst.f1220b;
                                j3 = aVarRemoveFirst.a + j2;
                                trackOutput2Arr = this.E;
                                i5 = 0;
                                while (i5 < length) {
                                    trackOutput2Arr[i5].d(j3, 1, aVarRemoveFirst.f1220b, this.u, null);
                                    i5++;
                                }
                            }
                            if (!bVar2.c()) {
                                this.f1218y = null;
                            }
                            this.o = 3;
                            i15 = 1;
                        }
                    }
                }
                if (i15 != 0) {
                    return 0;
                }
            } else {
                int size3 = this.e.size();
                long j12 = Long.MAX_VALUE;
                b bVarValueAt2 = null;
                for (int i28 = 0; i28 < size3; i28++) {
                    TrackFragment trackFragment4 = this.e.valueAt(i28).f1221b;
                    if (trackFragment4.o) {
                        long j13 = trackFragment4.c;
                        if (j13 < j12) {
                            bVarValueAt2 = this.e.valueAt(i28);
                            j12 = j13;
                        }
                    }
                }
                if (bVarValueAt2 == null) {
                    this.o = 3;
                } else {
                    int position5 = (int) (j12 - extractorInput.getPosition());
                    if (position5 < 0) {
                        throw ParserException.a("Offset to encryption data was negative.", null);
                    }
                    extractorInput.l(position5);
                    TrackFragment trackFragment5 = bVarValueAt2.f1221b;
                    ParsableByteArray parsableByteArray10 = trackFragment5.n;
                    extractorInput.readFully(parsableByteArray10.a, 0, parsableByteArray10.c);
                    trackFragment5.n.E(0);
                    trackFragment5.o = false;
                }
            }
        }
    }

    @Override // b.i.a.c.x2.Extractor
    public void f(ExtractorOutput extractorOutput) {
        int i;
        this.D = extractorOutput;
        c();
        TrackOutput2[] trackOutput2Arr = new TrackOutput2[2];
        this.E = trackOutput2Arr;
        int i2 = 100;
        int i3 = 0;
        if ((this.c & 4) != 0) {
            trackOutput2Arr[0] = this.D.p(100, 5);
            i2 = 101;
            i = 1;
        } else {
            i = 0;
        }
        TrackOutput2[] trackOutput2Arr2 = (TrackOutput2[]) Util2.D(this.E, i);
        this.E = trackOutput2Arr2;
        for (TrackOutput2 trackOutput2 : trackOutput2Arr2) {
            trackOutput2.e(f1215b);
        }
        this.F = new TrackOutput2[this.d.size()];
        while (i3 < this.F.length) {
            TrackOutput2 trackOutput2P = this.D.p(i2, 3);
            trackOutput2P.e(this.d.get(i3));
            this.F[i3] = trackOutput2P;
            i3++;
            i2++;
        }
    }

    @Override // b.i.a.c.x2.Extractor
    public void g(long j, long j2) {
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            this.e.valueAt(i).e();
        }
        this.n.clear();
        this.u = 0;
        this.v = j2;
        this.m.clear();
        c();
    }

    /* JADX WARN: Code duplicated, block: B:141:0x035d  */
    /* JADX WARN: Code duplicated, block: B:144:0x0370 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:145:0x0372  */
    /* JADX WARN: Code duplicated, block: B:146:0x037b  */
    /* JADX WARN: Code duplicated, block: B:149:0x0384  */
    /* JADX WARN: Code duplicated, block: B:150:0x038d  */
    /* JADX WARN: Code duplicated, block: B:153:0x0396  */
    /* JADX WARN: Code duplicated, block: B:154:0x039f  */
    /* JADX WARN: Code duplicated, block: B:157:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:159:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:160:0x03b9  */
    /* JADX WARN: Code duplicated, block: B:163:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:164:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:170:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:281:0x0680  */
    public final void j(long j) throws ParserException {
        FragmentedMp4Extractor fragmentedMp4Extractor;
        byte[] bArr;
        SparseArray<b> sparseArray;
        Atom.a aVar;
        int i;
        int i2;
        int i3;
        int i4;
        byte[] bArr2;
        int i5;
        TrackFragment trackFragment;
        int i6;
        long j2;
        int[] iArr;
        long[] jArr;
        boolean[] zArr;
        boolean z2;
        int i7;
        long j3;
        long j4;
        int i8;
        int iF;
        int iF2;
        int iF3;
        int iF4;
        boolean z3;
        FragmentedMp4Extractor fragmentedMp4Extractor2 = this;
        final FragmentedMp4Extractor fragmentedMp4Extractor3 = fragmentedMp4Extractor2;
        while (!fragmentedMp4Extractor3.m.isEmpty() && fragmentedMp4Extractor3.m.peek().f1209b == j) {
            Atom.a aVarPop = fragmentedMp4Extractor3.m.pop();
            int i9 = aVarPop.a;
            int i10 = 12;
            if (i9 == 1836019574) {
                AnimatableValueParser.E(true, "Unexpected moov box.");
                DrmInitData drmInitDataH = h(aVarPop.c);
                Atom.a aVarB = aVarPop.b(1836475768);
                Objects.requireNonNull(aVarB);
                SparseArray<DefaultSampleValues> sparseArray2 = new SparseArray<>();
                int size = aVarB.c.size();
                long jU = -9223372036854775807L;
                int i11 = 0;
                while (i11 < size) {
                    Atom.b bVar = aVarB.c.get(i11);
                    int i12 = bVar.a;
                    if (i12 == 1953654136) {
                        ParsableByteArray parsableByteArray = bVar.f1210b;
                        parsableByteArray.E(i10);
                        Pair pairCreate = Pair.create(Integer.valueOf(parsableByteArray.f()), new DefaultSampleValues(parsableByteArray.f() - 1, parsableByteArray.f(), parsableByteArray.f(), parsableByteArray.f()));
                        sparseArray2.put(((Integer) pairCreate.first).intValue(), (DefaultSampleValues) pairCreate.second);
                    } else {
                        if (i12 == 1835362404) {
                            ParsableByteArray parsableByteArray2 = bVar.f1210b;
                            parsableByteArray2.E(8);
                            jU = ((parsableByteArray2.f() >> 24) & 255) == 0 ? parsableByteArray2.u() : parsableByteArray2.x();
                        }
                        i11++;
                        i10 = 12;
                    }
                    i11++;
                    i10 = 12;
                }
                ArrayList arrayList = (ArrayList) AtomParsers.e(aVarPop, new GaplessInfoHolder(), jU, drmInitDataH, (fragmentedMp4Extractor3.c & 16) != 0, false, new Function2() { // from class: b.i.a.c.x2.i0.c
                    @Override // b.i.b.a.Function2
                    public final Object apply(Object obj) {
                        Track track = (Track) obj;
                        Objects.requireNonNull(this.a);
                        return track;
                    }
                });
                int size2 = arrayList.size();
                if (fragmentedMp4Extractor3.e.size() == 0) {
                    for (int i13 = 0; i13 < size2; i13++) {
                        TrackSampleTable trackSampleTable = (TrackSampleTable) arrayList.get(i13);
                        Track track = trackSampleTable.a;
                        fragmentedMp4Extractor3.e.put(track.a, new b(fragmentedMp4Extractor3.D.p(i13, track.f1230b), trackSampleTable, fragmentedMp4Extractor3.d(sparseArray2, track.a)));
                        fragmentedMp4Extractor3.w = Math.max(fragmentedMp4Extractor3.w, track.e);
                    }
                    fragmentedMp4Extractor3.D.j();
                } else {
                    AnimatableValueParser.D(fragmentedMp4Extractor3.e.size() == size2);
                    for (int i14 = 0; i14 < size2; i14++) {
                        TrackSampleTable trackSampleTable2 = (TrackSampleTable) arrayList.get(i14);
                        Track track2 = trackSampleTable2.a;
                        b bVar2 = fragmentedMp4Extractor3.e.get(track2.a);
                        DefaultSampleValues defaultSampleValuesD = fragmentedMp4Extractor3.d(sparseArray2, track2.a);
                        bVar2.d = trackSampleTable2;
                        bVar2.e = defaultSampleValuesD;
                        bVar2.a.e(trackSampleTable2.a.f);
                        bVar2.e();
                    }
                }
                fragmentedMp4Extractor = fragmentedMp4Extractor2;
            } else {
                int i15 = 8;
                if (i9 == 1836019558) {
                    SparseArray<b> sparseArray3 = fragmentedMp4Extractor3.e;
                    int i16 = fragmentedMp4Extractor3.c;
                    byte[] bArr3 = fragmentedMp4Extractor3.i;
                    int size3 = aVarPop.d.size();
                    int i17 = 0;
                    while (i17 < size3) {
                        Atom.a aVar2 = aVarPop.d.get(i17);
                        if (aVar2.a == 1953653094) {
                            Atom.b bVarC = aVar2.c(1952868452);
                            Objects.requireNonNull(bVarC);
                            ParsableByteArray parsableByteArray3 = bVarC.f1210b;
                            parsableByteArray3.E(i15);
                            int iF5 = parsableByteArray3.f() & ViewCompat.MEASURED_SIZE_MASK;
                            b bVar3 = sparseArray3.get(parsableByteArray3.f());
                            if (bVar3 == null) {
                                bVar3 = null;
                            } else {
                                if ((iF5 & 1) != 0) {
                                    long jX = parsableByteArray3.x();
                                    TrackFragment trackFragment2 = bVar3.f1221b;
                                    trackFragment2.f1232b = jX;
                                    trackFragment2.c = jX;
                                }
                                DefaultSampleValues defaultSampleValues = bVar3.e;
                                bVar3.f1221b.a = new DefaultSampleValues((iF5 & 2) != 0 ? parsableByteArray3.f() - 1 : defaultSampleValues.a, (iF5 & 8) != 0 ? parsableByteArray3.f() : defaultSampleValues.f1214b, (iF5 & 16) != 0 ? parsableByteArray3.f() : defaultSampleValues.c, (iF5 & 32) != 0 ? parsableByteArray3.f() : defaultSampleValues.d);
                            }
                            if (bVar3 == null) {
                                bArr = bArr3;
                                sparseArray = sparseArray3;
                                aVar = aVarPop;
                                i = i16;
                                i2 = size3;
                                i3 = i17;
                            } else {
                                TrackFragment trackFragment3 = bVar3.f1221b;
                                long j5 = trackFragment3.p;
                                boolean z4 = trackFragment3.q;
                                bVar3.e();
                                bVar3.l = true;
                                Atom.b bVarC2 = aVar2.c(1952867444);
                                if (bVarC2 == null || (i16 & 2) != 0) {
                                    trackFragment3.p = j5;
                                    trackFragment3.q = z4;
                                } else {
                                    ParsableByteArray parsableByteArray4 = bVarC2.f1210b;
                                    parsableByteArray4.E(i15);
                                    trackFragment3.p = ((parsableByteArray4.f() >> 24) & 255) == 1 ? parsableByteArray4.x() : parsableByteArray4.u();
                                    trackFragment3.q = true;
                                }
                                List<Atom.b> list = aVar2.c;
                                int size4 = list.size();
                                int i18 = 0;
                                int i19 = 0;
                                int i20 = 0;
                                while (true) {
                                    i4 = 1953658222;
                                    if (i18 >= size4) {
                                        break;
                                    }
                                    SparseArray<b> sparseArray4 = sparseArray3;
                                    Atom.b bVar4 = list.get(i18);
                                    int i21 = size3;
                                    if (bVar4.a == 1953658222) {
                                        ParsableByteArray parsableByteArray5 = bVar4.f1210b;
                                        parsableByteArray5.E(12);
                                        int iW = parsableByteArray5.w();
                                        if (iW > 0) {
                                            i20 += iW;
                                            i19++;
                                        }
                                    }
                                    i18++;
                                    size3 = i21;
                                    sparseArray3 = sparseArray4;
                                }
                                sparseArray = sparseArray3;
                                i2 = size3;
                                bVar3.h = 0;
                                bVar3.g = 0;
                                bVar3.f = 0;
                                TrackFragment trackFragment4 = bVar3.f1221b;
                                trackFragment4.d = i19;
                                trackFragment4.e = i20;
                                if (trackFragment4.g.length < i19) {
                                    trackFragment4.f = new long[i19];
                                    trackFragment4.g = new int[i19];
                                }
                                if (trackFragment4.h.length < i20) {
                                    int i22 = (i20 * Opcodes.LUSHR) / 100;
                                    trackFragment4.h = new int[i22];
                                    trackFragment4.i = new long[i22];
                                    trackFragment4.j = new boolean[i22];
                                    trackFragment4.l = new boolean[i22];
                                }
                                int i23 = 0;
                                int i24 = 0;
                                int i25 = 0;
                                while (i23 < size4) {
                                    Atom.b bVar5 = list.get(i23);
                                    if (bVar5.a == i4) {
                                        int i26 = i25 + 1;
                                        ParsableByteArray parsableByteArray6 = bVar5.f1210b;
                                        parsableByteArray6.E(8);
                                        int iF6 = parsableByteArray6.f() & ViewCompat.MEASURED_SIZE_MASK;
                                        Track track3 = bVar3.d.a;
                                        TrackFragment trackFragment5 = bVar3.f1221b;
                                        DefaultSampleValues defaultSampleValues2 = trackFragment5.a;
                                        int i27 = Util2.a;
                                        trackFragment5.g[i25] = parsableByteArray6.w();
                                        long[] jArr2 = trackFragment5.f;
                                        jArr2[i25] = trackFragment5.f1232b;
                                        if ((iF6 & 1) != 0) {
                                            jArr2[i25] = jArr2[i25] + ((long) parsableByteArray6.f());
                                        }
                                        boolean z5 = (iF6 & 4) != 0;
                                        int iF7 = defaultSampleValues2.d;
                                        if (z5) {
                                            iF7 = parsableByteArray6.f();
                                        }
                                        boolean z6 = (iF6 & 256) != 0;
                                        boolean z7 = (iF6 & 512) != 0;
                                        boolean z8 = (iF6 & 1024) != 0;
                                        boolean z9 = (iF6 & 2048) != 0;
                                        long[] jArr3 = track3.h;
                                        if (jArr3 != null) {
                                            i6 = iF7;
                                            trackFragment = trackFragment3;
                                            if (jArr3.length == 1 && jArr3[0] == 0) {
                                                j2 = track3.i[0];
                                            }
                                            iArr = trackFragment5.h;
                                            jArr = trackFragment5.i;
                                            zArr = trackFragment5.j;
                                            if (track3.f1230b == 2 || (i16 & 1) == 0) {
                                                z2 = false;
                                            } else {
                                                z2 = true;
                                            }
                                            i7 = trackFragment5.g[i25] + i24;
                                            j3 = track3.c;
                                            j4 = trackFragment5.p;
                                            i8 = i24;
                                            while (i8 < i7) {
                                                if (z6) {
                                                    iF = parsableByteArray6.f();
                                                } else {
                                                    iF = defaultSampleValues2.f1214b;
                                                }
                                                a(iF);
                                                if (z7) {
                                                    iF2 = parsableByteArray6.f();
                                                } else {
                                                    iF2 = defaultSampleValues2.c;
                                                }
                                                a(iF2);
                                                if (z8) {
                                                    iF3 = parsableByteArray6.f();
                                                } else if (i8 == 0 || !z5) {
                                                    iF3 = defaultSampleValues2.d;
                                                } else {
                                                    iF3 = i6;
                                                }
                                                if (z9) {
                                                    iF4 = parsableByteArray6.f();
                                                } else {
                                                    iF4 = 0;
                                                }
                                                jArr[i8] = Util2.F((((long) iF4) + j4) - j2, 1000000L, j3);
                                                if (!trackFragment5.q) {
                                                    jArr[i8] = jArr[i8] + bVar3.d.h;
                                                }
                                                iArr[i8] = iF2;
                                                if (((iF3 >> 16) & 1) == 0 || (z2 && i8 != 0)) {
                                                    z3 = false;
                                                } else {
                                                    z3 = true;
                                                }
                                                zArr[i8] = z3;
                                                j4 += (long) iF;
                                                i8++;
                                                i7 = i7;
                                                parsableByteArray6 = parsableByteArray6;
                                                z6 = z6;
                                                z7 = z7;
                                                z5 = z5;
                                                z8 = z8;
                                                z9 = z9;
                                            }
                                            int i28 = i7;
                                            trackFragment5.p = j4;
                                            i25 = i26;
                                            i24 = i28;
                                        } else {
                                            i6 = iF7;
                                            trackFragment = trackFragment3;
                                        }
                                        j2 = 0;
                                        iArr = trackFragment5.h;
                                        jArr = trackFragment5.i;
                                        zArr = trackFragment5.j;
                                        if (track3.f1230b == 2) {
                                            z2 = false;
                                        } else {
                                            z2 = false;
                                        }
                                        i7 = trackFragment5.g[i25] + i24;
                                        j3 = track3.c;
                                        j4 = trackFragment5.p;
                                        i8 = i24;
                                        while (i8 < i7) {
                                            if (z6) {
                                                iF = parsableByteArray6.f();
                                            } else {
                                                iF = defaultSampleValues2.f1214b;
                                            }
                                            a(iF);
                                            if (z7) {
                                                iF2 = parsableByteArray6.f();
                                            } else {
                                                iF2 = defaultSampleValues2.c;
                                            }
                                            a(iF2);
                                            if (z8) {
                                                iF3 = parsableByteArray6.f();
                                            } else if (i8 == 0) {
                                                iF3 = defaultSampleValues2.d;
                                            } else {
                                                iF3 = defaultSampleValues2.d;
                                            }
                                            if (z9) {
                                                iF4 = parsableByteArray6.f();
                                            } else {
                                                iF4 = 0;
                                            }
                                            jArr[i8] = Util2.F((((long) iF4) + j4) - j2, 1000000L, j3);
                                            if (!trackFragment5.q) {
                                                jArr[i8] = jArr[i8] + bVar3.d.h;
                                            }
                                            iArr[i8] = iF2;
                                            if (((iF3 >> 16) & 1) == 0) {
                                                z3 = false;
                                            } else {
                                                z3 = false;
                                            }
                                            zArr[i8] = z3;
                                            j4 += (long) iF;
                                            i8++;
                                            i7 = i7;
                                            parsableByteArray6 = parsableByteArray6;
                                            z6 = z6;
                                            z7 = z7;
                                            z5 = z5;
                                            z8 = z8;
                                            z9 = z9;
                                        }
                                        int i29 = i7;
                                        trackFragment5.p = j4;
                                        i25 = i26;
                                        i24 = i29;
                                    } else {
                                        bArr3 = bArr3;
                                        i23 = i23;
                                        aVarPop = aVarPop;
                                        trackFragment = trackFragment3;
                                    }
                                    i23++;
                                    i16 = i16;
                                    list = list;
                                    size4 = size4;
                                    i17 = i17;
                                    aVar2 = aVar2;
                                    aVarPop = aVarPop;
                                    bArr3 = bArr3;
                                    trackFragment3 = trackFragment;
                                    i4 = 1953658222;
                                }
                                byte[] bArr4 = bArr3;
                                aVar = aVarPop;
                                i = i16;
                                i3 = i17;
                                TrackFragment trackFragment6 = trackFragment3;
                                Track track4 = bVar3.d.a;
                                DefaultSampleValues defaultSampleValues3 = trackFragment6.a;
                                Objects.requireNonNull(defaultSampleValues3);
                                TrackEncryptionBox trackEncryptionBoxA = track4.a(defaultSampleValues3.a);
                                Atom.b bVarC3 = aVar2.c(1935763834);
                                if (bVarC3 != null) {
                                    Objects.requireNonNull(trackEncryptionBoxA);
                                    ParsableByteArray parsableByteArray7 = bVarC3.f1210b;
                                    int i30 = trackEncryptionBoxA.d;
                                    parsableByteArray7.E(8);
                                    if ((parsableByteArray7.f() & ViewCompat.MEASURED_SIZE_MASK & 1) == 1) {
                                        parsableByteArray7.F(8);
                                    }
                                    int iT = parsableByteArray7.t();
                                    int iW2 = parsableByteArray7.w();
                                    int i31 = trackFragment6.e;
                                    if (iW2 > i31) {
                                        throw ParserException.a(outline.h(78, "Saiz sample count ", iW2, " is greater than fragment sample count", i31), null);
                                    }
                                    if (iT == 0) {
                                        boolean[] zArr2 = trackFragment6.l;
                                        i5 = 0;
                                        for (int i32 = 0; i32 < iW2; i32++) {
                                            int iT2 = parsableByteArray7.t();
                                            i5 += iT2;
                                            zArr2[i32] = iT2 > i30;
                                        }
                                    } else {
                                        i5 = (iT * iW2) + 0;
                                        Arrays.fill(trackFragment6.l, 0, iW2, iT > i30);
                                    }
                                    Arrays.fill(trackFragment6.l, iW2, trackFragment6.e, false);
                                    if (i5 > 0) {
                                        ParsableByteArray parsableByteArray8 = trackFragment6.n;
                                        byte[] bArr5 = parsableByteArray8.a;
                                        if (bArr5.length < i5) {
                                            bArr5 = new byte[i5];
                                        }
                                        parsableByteArray8.C(bArr5, i5);
                                        trackFragment6.k = true;
                                        trackFragment6.o = true;
                                    }
                                }
                                Atom.b bVarC4 = aVar2.c(1935763823);
                                if (bVarC4 != null) {
                                    ParsableByteArray parsableByteArray9 = bVarC4.f1210b;
                                    parsableByteArray9.E(8);
                                    int iF8 = parsableByteArray9.f();
                                    if ((16777215 & iF8 & 1) == 1) {
                                        parsableByteArray9.F(8);
                                    }
                                    int iW3 = parsableByteArray9.w();
                                    if (iW3 != 1) {
                                        throw outline.w0(40, "Unexpected saio entry count: ", iW3, null);
                                    }
                                    trackFragment6.c += ((iF8 >> 24) & 255) == 0 ? parsableByteArray9.u() : parsableByteArray9.x();
                                }
                                byte[] bArr6 = null;
                                Atom.b bVarC5 = aVar2.c(1936027235);
                                if (bVarC5 != null) {
                                    i(bVarC5.f1210b, 0, trackFragment6);
                                }
                                String str = trackEncryptionBoxA != null ? trackEncryptionBoxA.f1231b : null;
                                ParsableByteArray parsableByteArray10 = null;
                                ParsableByteArray parsableByteArray11 = null;
                                for (int i33 = 0; i33 < aVar2.c.size(); i33++) {
                                    Atom.b bVar6 = aVar2.c.get(i33);
                                    ParsableByteArray parsableByteArray12 = bVar6.f1210b;
                                    int i34 = bVar6.a;
                                    if (i34 == 1935828848) {
                                        parsableByteArray12.E(12);
                                        if (parsableByteArray12.f() == 1936025959) {
                                            parsableByteArray10 = parsableByteArray12;
                                        }
                                    } else if (i34 == 1936158820) {
                                        parsableByteArray12.E(12);
                                        if (parsableByteArray12.f() == 1936025959) {
                                            parsableByteArray11 = parsableByteArray12;
                                        }
                                    }
                                }
                                if (parsableByteArray10 != null && parsableByteArray11 != null) {
                                    parsableByteArray10.E(8);
                                    int iF9 = (parsableByteArray10.f() >> 24) & 255;
                                    parsableByteArray10.F(4);
                                    if (iF9 == 1) {
                                        parsableByteArray10.F(4);
                                    }
                                    if (parsableByteArray10.f() != 1) {
                                        throw ParserException.b("Entry count in sbgp != 1 (unsupported).");
                                    }
                                    parsableByteArray11.E(8);
                                    int iF10 = (parsableByteArray11.f() >> 24) & 255;
                                    parsableByteArray11.F(4);
                                    if (iF10 == 1) {
                                        if (parsableByteArray11.u() == 0) {
                                            throw ParserException.b("Variable length description in sgpd found (unsupported)");
                                        }
                                    } else if (iF10 >= 2) {
                                        parsableByteArray11.F(4);
                                    }
                                    if (parsableByteArray11.u() != 1) {
                                        throw ParserException.b("Entry count in sgpd != 1 (unsupported).");
                                    }
                                    parsableByteArray11.F(1);
                                    int iT3 = parsableByteArray11.t();
                                    int i35 = (iT3 & 240) >> 4;
                                    int i36 = iT3 & 15;
                                    boolean z10 = parsableByteArray11.t() == 1;
                                    if (z10) {
                                        int iT4 = parsableByteArray11.t();
                                        byte[] bArr7 = new byte[16];
                                        System.arraycopy(parsableByteArray11.a, parsableByteArray11.f984b, bArr7, 0, 16);
                                        parsableByteArray11.f984b += 16;
                                        if (iT4 == 0) {
                                            int iT5 = parsableByteArray11.t();
                                            bArr6 = new byte[iT5];
                                            System.arraycopy(parsableByteArray11.a, parsableByteArray11.f984b, bArr6, 0, iT5);
                                            parsableByteArray11.f984b += iT5;
                                        }
                                        trackFragment6.k = true;
                                        trackFragment6.m = new TrackEncryptionBox(z10, str, iT4, bArr7, i35, i36, bArr6);
                                    }
                                }
                                int size5 = aVar2.c.size();
                                int i37 = 0;
                                while (i37 < size5) {
                                    Atom.b bVar7 = aVar2.c.get(i37);
                                    if (bVar7.a == 1970628964) {
                                        ParsableByteArray parsableByteArray13 = bVar7.f1210b;
                                        parsableByteArray13.E(8);
                                        bArr2 = bArr4;
                                        System.arraycopy(parsableByteArray13.a, parsableByteArray13.f984b, bArr2, 0, 16);
                                        parsableByteArray13.f984b += 16;
                                        if (Arrays.equals(bArr2, a)) {
                                            i(parsableByteArray13, 16, trackFragment6);
                                        }
                                    } else {
                                        bArr2 = bArr4;
                                    }
                                    i37++;
                                    bArr4 = bArr2;
                                }
                                bArr = bArr4;
                            }
                        } else {
                            bArr = bArr3;
                            sparseArray = sparseArray3;
                            aVar = aVarPop;
                            i = i16;
                            i2 = size3;
                            i3 = i17;
                        }
                        i17 = i3 + 1;
                        i15 = 8;
                        bArr3 = bArr;
                        i16 = i;
                        size3 = i2;
                        sparseArray3 = sparseArray;
                        aVarPop = aVar;
                    }
                    DrmInitData drmInitDataH2 = h(aVarPop.c);
                    fragmentedMp4Extractor = this;
                    if (drmInitDataH2 != null) {
                        int size6 = fragmentedMp4Extractor.e.size();
                        for (int i38 = 0; i38 < size6; i38++) {
                            b bVarValueAt = fragmentedMp4Extractor.e.valueAt(i38);
                            Track track5 = bVarValueAt.d.a;
                            DefaultSampleValues defaultSampleValues4 = bVarValueAt.f1221b.a;
                            int i39 = Util2.a;
                            TrackEncryptionBox trackEncryptionBoxA2 = track5.a(defaultSampleValues4.a);
                            DrmInitData drmInitDataA = drmInitDataH2.a(trackEncryptionBoxA2 != null ? trackEncryptionBoxA2.f1231b : null);
                            Format2.b bVarA = bVarValueAt.d.a.f.a();
                            bVarA.n = drmInitDataA;
                            bVarValueAt.a.e(bVarA.a());
                        }
                    }
                    if (fragmentedMp4Extractor.v != -9223372036854775807L) {
                        int size7 = fragmentedMp4Extractor.e.size();
                        for (int i40 = 0; i40 < size7; i40++) {
                            b bVarValueAt2 = fragmentedMp4Extractor.e.valueAt(i40);
                            long j6 = fragmentedMp4Extractor.v;
                            int i41 = bVarValueAt2.f;
                            while (true) {
                                TrackFragment trackFragment7 = bVarValueAt2.f1221b;
                                if (i41 >= trackFragment7.e || trackFragment7.i[i41] >= j6) {
                                    break;
                                }
                                if (trackFragment7.j[i41]) {
                                    bVarValueAt2.i = i41;
                                }
                                i41++;
                            }
                        }
                        fragmentedMp4Extractor.v = -9223372036854775807L;
                    }
                    fragmentedMp4Extractor3 = fragmentedMp4Extractor;
                } else {
                    fragmentedMp4Extractor = fragmentedMp4Extractor2;
                    if (!fragmentedMp4Extractor3.m.isEmpty()) {
                        fragmentedMp4Extractor3.m.peek().d.add(aVarPop);
                    }
                }
            }
            fragmentedMp4Extractor2 = fragmentedMp4Extractor;
        }
        c();
    }

    @Override // b.i.a.c.x2.Extractor
    public void release() {
    }
}

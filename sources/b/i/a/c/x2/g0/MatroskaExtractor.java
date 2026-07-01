package b.i.a.c.x2.g0;

import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.C;
import b.i.a.c.Format2;
import b.i.a.c.f3.LongArray;
import b.i.a.c.f3.MimeTypes;
import b.i.a.c.f3.NalUnitUtil;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.g3.AvcConfig;
import b.i.a.c.g3.ColorInfo;
import b.i.a.c.g3.DolbyVisionConfig;
import b.i.a.c.g3.HevcConfig;
import b.i.a.c.t2.AacUtil;
import b.i.a.c.x2.ChunkIndex;
import b.i.a.c.x2.Extractor;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.ExtractorsFactory;
import b.i.a.c.x2.ExtractorsFactory2;
import b.i.a.c.x2.PositionHolder;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.TrueHdSampleRechunker;
import b.i.a.c.x2.g0.DefaultEbmlReader;
import b.i.b.b.AbstractIndexedListIterator;
import b.i.b.b.ImmutableList2;
import com.discord.api.permission.Permission;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.a.c.x2.g0.e, reason: use source file name */
/* JADX INFO: compiled from: MatroskaExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public class MatroskaExtractor implements Extractor {
    public static final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f1185b;
    public static final byte[] c;
    public static final UUID d;
    public static final Map<String, Integer> e;
    public boolean A;
    public int B;
    public long C;
    public boolean D;
    public long E;
    public long F;
    public long G;

    @Nullable
    public LongArray H;

    @Nullable
    public LongArray I;
    public boolean J;
    public boolean K;
    public int L;
    public long M;
    public long N;
    public int O;
    public int P;
    public int[] Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public boolean V;
    public int W;
    public int X;
    public int Y;
    public boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f1186a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f1187b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f1188c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public byte f1189d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f1190e0;
    public final EbmlReader f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public ExtractorOutput f1191f0;
    public final VarintReader g;
    public final SparseArray<c> h;
    public final boolean i;
    public final ParsableByteArray j;
    public final ParsableByteArray k;
    public final ParsableByteArray l;
    public final ParsableByteArray m;
    public final ParsableByteArray n;
    public final ParsableByteArray o;
    public final ParsableByteArray p;
    public final ParsableByteArray q;
    public final ParsableByteArray r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ParsableByteArray f1192s;
    public ByteBuffer t;
    public long u;
    public long v;
    public long w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f1193x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f1194y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    public c f1195z;

    /* JADX INFO: renamed from: b.i.a.c.x2.g0.e$b */
    /* JADX INFO: compiled from: MatroskaExtractor.java */
    public final class b implements EbmlProcessor {
        public b(a aVar) {
        }
    }

    static {
        b.i.a.c.x2.g0.a aVar = new ExtractorsFactory2() { // from class: b.i.a.c.x2.g0.a
            @Override // b.i.a.c.x2.ExtractorsFactory2
            public final Extractor[] a() {
                return new Extractor[]{new MatroskaExtractor(0)};
            }

            @Override // b.i.a.c.x2.ExtractorsFactory2
            public /* synthetic */ Extractor[] b(Uri uri, Map map) {
                return ExtractorsFactory.a(this, uri, map);
            }
        };
        a = new byte[]{49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
        f1185b = Util2.w("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
        c = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        d = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        e = Collections.unmodifiableMap(map);
    }

    public MatroskaExtractor(int i) {
        DefaultEbmlReader defaultEbmlReader = new DefaultEbmlReader();
        this.v = -1L;
        this.w = -9223372036854775807L;
        this.f1193x = -9223372036854775807L;
        this.f1194y = -9223372036854775807L;
        this.E = -1L;
        this.F = -1L;
        this.G = -9223372036854775807L;
        this.f = defaultEbmlReader;
        defaultEbmlReader.d = new b(null);
        this.i = (i & 1) == 0;
        this.g = new VarintReader();
        this.h = new SparseArray<>();
        this.l = new ParsableByteArray(4);
        this.m = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.n = new ParsableByteArray(4);
        this.j = new ParsableByteArray(NalUnitUtil.a);
        this.k = new ParsableByteArray(4);
        this.o = new ParsableByteArray();
        this.p = new ParsableByteArray();
        this.q = new ParsableByteArray(8);
        this.r = new ParsableByteArray();
        this.f1192s = new ParsableByteArray();
        this.Q = new int[1];
    }

    public static int[] i(@Nullable int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return iArr.length >= i ? iArr : new int[Math.max(iArr.length * 2, i)];
    }

    public static byte[] j(long j, String str, long j2) {
        AnimatableValueParser.j(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - (((long) (i * 3600)) * 1000000);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - (((long) (i2 * 60)) * 1000000);
        int i3 = (int) (j4 / 1000000);
        return Util2.w(String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * 1000000)) / j2))));
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    public final void a(int i) throws ParserException {
        if (this.H == null || this.I == null) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Element ");
            sb.append(i);
            sb.append(" must be in a Cues");
            throw ParserException.a(sb.toString(), null);
        }
    }

    @Override // b.i.a.c.x2.Extractor
    public final boolean b(ExtractorInput extractorInput) throws IOException {
        Sniffer sniffer = new Sniffer();
        long jB = extractorInput.b();
        long j = Permission.VIEW_CHANNEL;
        if (jB != -1 && jB <= Permission.VIEW_CHANNEL) {
            j = jB;
        }
        int i = (int) j;
        extractorInput.o(sniffer.a.a, 0, 4);
        sniffer.f1201b = 4;
        for (long jU = sniffer.a.u(); jU != 440786851; jU = ((jU << 8) & (-256)) | ((long) (sniffer.a.a[0] & 255))) {
            int i2 = sniffer.f1201b + 1;
            sniffer.f1201b = i2;
            if (i2 == i) {
                return false;
            }
            extractorInput.o(sniffer.a.a, 0, 1);
        }
        long jA = sniffer.a(extractorInput);
        long j2 = sniffer.f1201b;
        if (jA == Long.MIN_VALUE) {
            return false;
        }
        if (jB != -1 && j2 + jA >= jB) {
            return false;
        }
        while (true) {
            long j3 = sniffer.f1201b;
            long j4 = j2 + jA;
            if (j3 >= j4) {
                return j3 == j4;
            }
            if (sniffer.a(extractorInput) == Long.MIN_VALUE) {
                return false;
            }
            long jA2 = sniffer.a(extractorInput);
            if (jA2 < 0 || jA2 > 2147483647L) {
                return false;
            }
            if (jA2 != 0) {
                int i3 = (int) jA2;
                extractorInput.g(i3);
                sniffer.f1201b += i3;
            }
        }
    }

    @EnsuresNonNull({"currentTrack"})
    public final void c(int i) throws ParserException {
        if (this.f1195z != null) {
            return;
        }
        StringBuilder sb = new StringBuilder(43);
        sb.append("Element ");
        sb.append(i);
        sb.append(" must be in a TrackEntry");
        throw ParserException.a(sb.toString(), null);
    }

    @RequiresNonNull({"#1.output"})
    public final void d(c cVar, long j, int i, int i2, int i3) {
        byte[] bArrJ;
        int i4;
        TrueHdSampleRechunker trueHdSampleRechunker = cVar.T;
        if (trueHdSampleRechunker != null) {
            trueHdSampleRechunker.b(cVar.X, j, i, i2, i3, cVar.j);
        } else {
            if ("S_TEXT/UTF8".equals(cVar.f1196b) || "S_TEXT/ASS".equals(cVar.f1196b)) {
                if (this.P > 1) {
                    Log.w("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j2 = this.N;
                    if (j2 == -9223372036854775807L) {
                        Log.w("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        String str = cVar.f1196b;
                        byte[] bArr = this.p.a;
                        str.hashCode();
                        if (str.equals("S_TEXT/ASS")) {
                            bArrJ = j(j2, "%01d:%02d:%02d:%02d", 10000L);
                            i4 = 21;
                        } else {
                            if (!str.equals("S_TEXT/UTF8")) {
                                throw new IllegalArgumentException();
                            }
                            bArrJ = j(j2, "%02d:%02d:%02d,%03d", 1000L);
                            i4 = 19;
                        }
                        System.arraycopy(bArrJ, 0, bArr, i4, bArrJ.length);
                        int i5 = this.p.f984b;
                        while (true) {
                            ParsableByteArray parsableByteArray = this.p;
                            if (i5 >= parsableByteArray.c) {
                                break;
                            }
                            if (parsableByteArray.a[i5] == 0) {
                                parsableByteArray.D(i5);
                                break;
                            }
                            i5++;
                        }
                        TrackOutput2 trackOutput2 = cVar.X;
                        ParsableByteArray parsableByteArray2 = this.p;
                        trackOutput2.c(parsableByteArray2, parsableByteArray2.c);
                        i2 += this.p.c;
                    }
                }
            }
            if ((268435456 & i) != 0) {
                if (this.P > 1) {
                    i &= -268435457;
                } else {
                    ParsableByteArray parsableByteArray3 = this.f1192s;
                    int i6 = parsableByteArray3.c;
                    cVar.X.f(parsableByteArray3, i6, 2);
                    i2 += i6;
                }
            }
            cVar.X.d(j, i, i2, i3, cVar.j);
        }
        this.K = true;
    }

    /* JADX WARN: Code duplicated, block: B:463:0x08d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:465:0x08d5 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v6, types: [int[]] */
    /* JADX WARN: Type inference failed for: r3v145 */
    /* JADX WARN: Type inference failed for: r3v68 */
    /* JADX WARN: Type inference failed for: r3v79 */
    /* JADX WARN: Type inference failed for: r4v141 */
    /* JADX WARN: Type inference failed for: r4v56, types: [int] */
    /* JADX WARN: Type inference failed for: r4v69 */
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
    public final int e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i;
        int i2;
        String str;
        ?? r4;
        long j;
        int i3;
        int[] iArr;
        boolean z2;
        boolean z3 = false;
        this.K = false;
        boolean z4 = true;
        boolean z5 = true;
        while (z5 && !this.K) {
            DefaultEbmlReader defaultEbmlReader = (DefaultEbmlReader) this.f;
            AnimatableValueParser.H(defaultEbmlReader.d);
            boolean z6 = z3;
            boolean z7 = z4;
            while (true) {
                DefaultEbmlReader.b bVarPeek = defaultEbmlReader.f1183b.peek();
                if (bVarPeek == null || extractorInput.getPosition() < bVarPeek.f1184b) {
                    if (defaultEbmlReader.e == 0) {
                        long jC = defaultEbmlReader.c.c(extractorInput, z7, z6, 4);
                        if (jC == -2) {
                            extractorInput.k();
                            while (true) {
                                extractorInput.o(defaultEbmlReader.a, z6 ? 1 : 0, 4);
                                int iB = VarintReader.b(defaultEbmlReader.a[z6 ? 1 : 0]);
                                if (iB != -1 && iB <= 4) {
                                    int iA = (int) VarintReader.a(defaultEbmlReader.a, iB, z6);
                                    Objects.requireNonNull(MatroskaExtractor.this);
                                    if (iA == 357149030 || iA == 524531317 || iA == 475249515 || iA == 374648427) {
                                        extractorInput.l(iB);
                                        jC = iA;
                                    }
                                }
                                extractorInput.l(z7 ? 1 : 0);
                            }
                        }
                        if (jC == -1) {
                            z5 = false;
                        } else {
                            defaultEbmlReader.f = (int) jC;
                            defaultEbmlReader.e = z7 ? 1 : 0;
                        }
                    }
                    if (defaultEbmlReader.e == z7) {
                        defaultEbmlReader.g = defaultEbmlReader.c.c(extractorInput, z6, z7, 8);
                        defaultEbmlReader.e = 2;
                    }
                    EbmlProcessor ebmlProcessor = defaultEbmlReader.d;
                    int i4 = defaultEbmlReader.f;
                    Objects.requireNonNull(MatroskaExtractor.this);
                    switch (i4) {
                        case Opcodes.LXOR /* 131 */:
                        case Opcodes.L2I /* 136 */:
                        case 155:
                        case Opcodes.IF_ICMPEQ /* 159 */:
                        case Opcodes.ARETURN /* 176 */:
                        case Opcodes.PUTSTATIC /* 179 */:
                        case Opcodes.INVOKEDYNAMIC /* 186 */:
                        case 215:
                        case 231:
                        case 238:
                        case 241:
                        case 251:
                        case 16871:
                        case 16980:
                        case 17029:
                        case 17143:
                        case 18401:
                        case 18408:
                        case 20529:
                        case 20530:
                        case 21420:
                        case 21432:
                        case 21680:
                        case 21682:
                        case 21690:
                        case 21930:
                        case 21945:
                        case 21946:
                        case 21947:
                        case 21948:
                        case 21949:
                        case 21998:
                        case 22186:
                        case 22203:
                        case 25188:
                        case 30321:
                        case 2352003:
                        case 2807729:
                            i = 2;
                            break;
                        case Opcodes.I2F /* 134 */:
                        case 17026:
                        case 21358:
                        case 2274716:
                            i = 3;
                            break;
                        case Opcodes.IF_ICMPNE /* 160 */:
                        case Opcodes.IF_ACMPNE /* 166 */:
                        case Opcodes.FRETURN /* 174 */:
                        case Opcodes.INVOKESPECIAL /* 183 */:
                        case Opcodes.NEW /* 187 */:
                        case 224:
                        case HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION /* 225 */:
                        case 16868:
                        case 18407:
                        case 19899:
                        case 20532:
                        case 20533:
                        case 21936:
                        case 21968:
                        case 25152:
                        case 28032:
                        case 30113:
                        case 30320:
                        case 290298740:
                        case 357149030:
                        case 374648427:
                        case 408125543:
                        case 440786851:
                        case 475249515:
                        case 524531317:
                            i = 1;
                            break;
                        case Opcodes.IF_ICMPLT /* 161 */:
                        case Opcodes.IF_ICMPGT /* 163 */:
                        case Opcodes.IF_ACMPEQ /* 165 */:
                        case 16877:
                        case 16981:
                        case 18402:
                        case 21419:
                        case 25506:
                        case 30322:
                            i = 4;
                            break;
                        case Opcodes.PUTFIELD /* 181 */:
                        case 17545:
                        case 21969:
                        case 21970:
                        case 21971:
                        case 21972:
                        case 21973:
                        case 21974:
                        case 21975:
                        case 21976:
                        case 21977:
                        case 21978:
                        case 30323:
                        case 30324:
                        case 30325:
                            i = 5;
                            break;
                        default:
                            i = 0;
                            break;
                    }
                    if (i == 0) {
                        extractorInput.l((int) defaultEbmlReader.g);
                        z6 = false;
                        defaultEbmlReader.e = 0;
                        z7 = true;
                    } else if (i == z7) {
                        long position = extractorInput.getPosition();
                        defaultEbmlReader.f1183b.push(new DefaultEbmlReader.b(defaultEbmlReader.f, defaultEbmlReader.g + position, null));
                        EbmlProcessor ebmlProcessor2 = defaultEbmlReader.d;
                        int i5 = defaultEbmlReader.f;
                        long j2 = defaultEbmlReader.g;
                        MatroskaExtractor matroskaExtractor = MatroskaExtractor.this;
                        AnimatableValueParser.H(matroskaExtractor.f1191f0);
                        if (i5 == 160) {
                            i2 = 0;
                            matroskaExtractor.V = false;
                        } else if (i5 == 174) {
                            i2 = 0;
                            matroskaExtractor.f1195z = new c(null);
                        } else if (i5 != 187) {
                            if (i5 == 19899) {
                                matroskaExtractor.B = -1;
                                matroskaExtractor.C = -1L;
                            } else if (i5 == 20533) {
                                matroskaExtractor.c(i5);
                                matroskaExtractor.f1195z.h = true;
                            } else if (i5 == 21968) {
                                matroskaExtractor.c(i5);
                                matroskaExtractor.f1195z.f1198x = true;
                            } else if (i5 == 408125543) {
                                long j3 = matroskaExtractor.v;
                                if (j3 != -1 && j3 != position) {
                                    throw ParserException.a("Multiple Segment elements not supported", null);
                                }
                                matroskaExtractor.v = position;
                                matroskaExtractor.u = j2;
                            } else if (i5 == 475249515) {
                                matroskaExtractor.H = new LongArray();
                                matroskaExtractor.I = new LongArray();
                            } else if (i5 == 524531317 && !matroskaExtractor.A) {
                                if (!matroskaExtractor.i || matroskaExtractor.E == -1) {
                                    matroskaExtractor.f1191f0.a(new SeekMap.b(matroskaExtractor.f1194y, 0L));
                                    matroskaExtractor.A = true;
                                } else {
                                    matroskaExtractor.D = true;
                                }
                            }
                            i2 = 0;
                        } else {
                            i2 = 0;
                            matroskaExtractor.J = false;
                        }
                        defaultEbmlReader.e = i2;
                    } else if (i == 2) {
                        long j4 = defaultEbmlReader.g;
                        if (j4 > 8) {
                            StringBuilder sb = new StringBuilder(42);
                            sb.append("Invalid integer size: ");
                            sb.append(j4);
                            throw ParserException.a(sb.toString(), null);
                        }
                        EbmlProcessor ebmlProcessor3 = defaultEbmlReader.d;
                        int i6 = defaultEbmlReader.f;
                        long jA = defaultEbmlReader.a(extractorInput, (int) j4);
                        MatroskaExtractor matroskaExtractor2 = MatroskaExtractor.this;
                        Objects.requireNonNull(matroskaExtractor2);
                        if (i6 != 20529) {
                            if (i6 != 20530) {
                                switch (i6) {
                                    case Opcodes.LXOR /* 131 */:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.d = (int) jA;
                                        break;
                                    case Opcodes.L2I /* 136 */:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.V = jA == 1;
                                        break;
                                    case 155:
                                        matroskaExtractor2.N = matroskaExtractor2.m(jA);
                                        break;
                                    case Opcodes.IF_ICMPEQ /* 159 */:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.O = (int) jA;
                                        break;
                                    case Opcodes.ARETURN /* 176 */:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.m = (int) jA;
                                        break;
                                    case Opcodes.PUTSTATIC /* 179 */:
                                        matroskaExtractor2.a(i6);
                                        matroskaExtractor2.H.a(matroskaExtractor2.m(jA));
                                        break;
                                    case Opcodes.INVOKEDYNAMIC /* 186 */:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.n = (int) jA;
                                        break;
                                    case 215:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.c = (int) jA;
                                        break;
                                    case 231:
                                        matroskaExtractor2.G = matroskaExtractor2.m(jA);
                                        break;
                                    case 238:
                                        matroskaExtractor2.U = (int) jA;
                                        break;
                                    case 241:
                                        if (!matroskaExtractor2.J) {
                                            matroskaExtractor2.a(i6);
                                            matroskaExtractor2.I.a(jA);
                                            matroskaExtractor2.J = true;
                                        }
                                        break;
                                    case 251:
                                        matroskaExtractor2.V = true;
                                        break;
                                    case 16871:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.g = (int) jA;
                                        break;
                                    case 16980:
                                        if (jA != 3) {
                                            throw ParserException.a(outline.i(50, "ContentCompAlgo ", jA, " not supported"), null);
                                        }
                                        break;
                                    case 17029:
                                        if (jA < 1 || jA > 2) {
                                            throw ParserException.a(outline.i(53, "DocTypeReadVersion ", jA, " not supported"), null);
                                        }
                                        break;
                                    case 17143:
                                        if (jA != 1) {
                                            throw ParserException.a(outline.i(50, "EBMLReadVersion ", jA, " not supported"), null);
                                        }
                                        break;
                                    case 18401:
                                        if (jA != 5) {
                                            throw ParserException.a(outline.i(49, "ContentEncAlgo ", jA, " not supported"), null);
                                        }
                                        break;
                                    case 18408:
                                        if (jA != 1) {
                                            throw ParserException.a(outline.i(56, "AESSettingsCipherMode ", jA, " not supported"), null);
                                        }
                                        break;
                                    case 21420:
                                        matroskaExtractor2.C = jA + matroskaExtractor2.v;
                                        break;
                                    case 21432:
                                        int i7 = (int) jA;
                                        matroskaExtractor2.c(i6);
                                        if (i7 == 0) {
                                            matroskaExtractor2.f1195z.w = 0;
                                        } else if (i7 == 1) {
                                            matroskaExtractor2.f1195z.w = 2;
                                        } else if (i7 == 3) {
                                            matroskaExtractor2.f1195z.w = 1;
                                        } else if (i7 == 15) {
                                            matroskaExtractor2.f1195z.w = 3;
                                        }
                                        break;
                                    case 21680:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.o = (int) jA;
                                        break;
                                    case 21682:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.q = (int) jA;
                                        break;
                                    case 21690:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.p = (int) jA;
                                        break;
                                    case 21930:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.U = jA == 1;
                                        break;
                                    case 21998:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.f = (int) jA;
                                        break;
                                    case 22186:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.R = jA;
                                        break;
                                    case 22203:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.S = jA;
                                        break;
                                    case 25188:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.P = (int) jA;
                                        break;
                                    case 30321:
                                        matroskaExtractor2.c(i6);
                                        int i8 = (int) jA;
                                        if (i8 == 0) {
                                            matroskaExtractor2.f1195z.r = 0;
                                        } else if (i8 == 1) {
                                            matroskaExtractor2.f1195z.r = 1;
                                        } else if (i8 == 2) {
                                            matroskaExtractor2.f1195z.r = 2;
                                        } else if (i8 == 3) {
                                            matroskaExtractor2.f1195z.r = 3;
                                        }
                                        break;
                                    case 2352003:
                                        matroskaExtractor2.c(i6);
                                        matroskaExtractor2.f1195z.e = (int) jA;
                                        break;
                                    case 2807729:
                                        matroskaExtractor2.w = jA;
                                        break;
                                    default:
                                        switch (i6) {
                                            case 21945:
                                                matroskaExtractor2.c(i6);
                                                int i9 = (int) jA;
                                                if (i9 == 1) {
                                                    matroskaExtractor2.f1195z.A = 2;
                                                } else if (i9 == 2) {
                                                    matroskaExtractor2.f1195z.A = 1;
                                                }
                                                break;
                                            case 21946:
                                                matroskaExtractor2.c(i6);
                                                int iB2 = ColorInfo.b((int) jA);
                                                if (iB2 != -1) {
                                                    matroskaExtractor2.f1195z.f1200z = iB2;
                                                }
                                                break;
                                            case 21947:
                                                matroskaExtractor2.c(i6);
                                                matroskaExtractor2.f1195z.f1198x = true;
                                                int iA2 = ColorInfo.a((int) jA);
                                                if (iA2 != -1) {
                                                    matroskaExtractor2.f1195z.f1199y = iA2;
                                                }
                                                break;
                                            case 21948:
                                                matroskaExtractor2.c(i6);
                                                matroskaExtractor2.f1195z.B = (int) jA;
                                                break;
                                            case 21949:
                                                matroskaExtractor2.c(i6);
                                                matroskaExtractor2.f1195z.C = (int) jA;
                                                break;
                                        }
                                        break;
                                }
                            } else if (jA != 1) {
                                throw ParserException.a(outline.i(55, "ContentEncodingScope ", jA, " not supported"), null);
                            }
                        } else if (jA != 0) {
                            throw ParserException.a(outline.i(55, "ContentEncodingOrder ", jA, " not supported"), null);
                        }
                        defaultEbmlReader.e = 0;
                    } else if (i == 3) {
                        long j5 = defaultEbmlReader.g;
                        if (j5 > 2147483647L) {
                            StringBuilder sb2 = new StringBuilder(41);
                            sb2.append("String element size: ");
                            sb2.append(j5);
                            throw ParserException.a(sb2.toString(), null);
                        }
                        EbmlProcessor ebmlProcessor4 = defaultEbmlReader.d;
                        int i10 = defaultEbmlReader.f;
                        int i11 = (int) j5;
                        if (i11 == 0) {
                            str = "";
                        } else {
                            byte[] bArr = new byte[i11];
                            extractorInput.readFully(bArr, 0, i11);
                            while (i11 > 0) {
                                int i12 = i11 - 1;
                                if (bArr[i12] == 0) {
                                    i11 = i12;
                                } else {
                                    str = new String(bArr, 0, i11);
                                }
                            }
                            str = new String(bArr, 0, i11);
                        }
                        MatroskaExtractor matroskaExtractor3 = MatroskaExtractor.this;
                        Objects.requireNonNull(matroskaExtractor3);
                        if (i10 == 134) {
                            matroskaExtractor3.c(i10);
                            matroskaExtractor3.f1195z.f1196b = str;
                        } else if (i10 != 17026) {
                            if (i10 == 21358) {
                                matroskaExtractor3.c(i10);
                                matroskaExtractor3.f1195z.a = str;
                            } else if (i10 == 2274716) {
                                matroskaExtractor3.c(i10);
                                matroskaExtractor3.f1195z.W = str;
                            }
                        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
                            StringBuilder sb3 = new StringBuilder(str.length() + 22);
                            sb3.append("DocType ");
                            sb3.append(str);
                            sb3.append(" not supported");
                            throw ParserException.a(sb3.toString(), null);
                        }
                        defaultEbmlReader.e = 0;
                    } else if (i == 4) {
                        EbmlProcessor ebmlProcessor5 = defaultEbmlReader.d;
                        int i13 = defaultEbmlReader.f;
                        int i14 = (int) defaultEbmlReader.g;
                        MatroskaExtractor matroskaExtractor4 = MatroskaExtractor.this;
                        Objects.requireNonNull(matroskaExtractor4);
                        if (i13 == 161 || i13 == 163) {
                            if (matroskaExtractor4.L == 0) {
                                matroskaExtractor4.R = (int) matroskaExtractor4.g.c(extractorInput, z6, z7, 8);
                                matroskaExtractor4.S = matroskaExtractor4.g.d;
                                matroskaExtractor4.N = -9223372036854775807L;
                                matroskaExtractor4.L = z7 ? 1 : 0;
                                matroskaExtractor4.l.A(z6 ? 1 : 0);
                            }
                            c cVar = matroskaExtractor4.h.get(matroskaExtractor4.R);
                            if (cVar == null) {
                                extractorInput.l(i14 - matroskaExtractor4.S);
                                matroskaExtractor4.L = z6 ? 1 : 0;
                            } else {
                                Objects.requireNonNull(cVar.X);
                                if (matroskaExtractor4.L == z7) {
                                    matroskaExtractor4.k(extractorInput, 3);
                                    int i15 = (matroskaExtractor4.l.a[2] & 6) >> (z7 ? 1 : 0);
                                    byte b2 = 255;
                                    if (i15 == 0) {
                                        matroskaExtractor4.P = z7 ? 1 : 0;
                                        int[] iArrI = i(matroskaExtractor4.Q, z7 ? 1 : 0);
                                        matroskaExtractor4.Q = iArrI;
                                        iArrI[z6 ? 1 : 0] = (i14 - matroskaExtractor4.S) - 3;
                                    } else {
                                        matroskaExtractor4.k(extractorInput, 4);
                                        int i16 = (matroskaExtractor4.l.a[3] & 255) + (z7 ? 1 : 0);
                                        matroskaExtractor4.P = i16;
                                        int[] iArrI2 = i(matroskaExtractor4.Q, i16);
                                        matroskaExtractor4.Q = iArrI2;
                                        if (i15 == 2) {
                                            int i17 = (i14 - matroskaExtractor4.S) - 4;
                                            int i18 = matroskaExtractor4.P;
                                            Arrays.fill(iArrI2, z6 ? 1 : 0, i18, i17 / i18);
                                        } else {
                                            int i19 = 4;
                                            if (i15 == z7) {
                                                int i20 = 0;
                                                int i21 = 0;
                                                while (true) {
                                                    int i22 = matroskaExtractor4.P;
                                                    if (i20 < i22 - 1) {
                                                        matroskaExtractor4.Q[i20] = z6 ? 1 : 0;
                                                        do {
                                                            i19 += z7 ? 1 : 0;
                                                            matroskaExtractor4.k(extractorInput, i19);
                                                            i3 = matroskaExtractor4.l.a[i19 - 1] & 255;
                                                            iArr = matroskaExtractor4.Q;
                                                            iArr[i20] = iArr[i20] + i3;
                                                        } while (i3 == 255);
                                                        i21 += iArr[i20];
                                                        i20++;
                                                    } else {
                                                        matroskaExtractor4.Q[i22 - 1] = ((i14 - matroskaExtractor4.S) - i19) - i21;
                                                    }
                                                }
                                            } else {
                                                if (i15 != 3) {
                                                    throw outline.w0(36, "Unexpected lacing value: ", i15, null);
                                                }
                                                int i23 = 0;
                                                int i24 = 0;
                                                ?? r3 = z6;
                                                boolean z8 = z7;
                                                while (true) {
                                                    int i25 = matroskaExtractor4.P;
                                                    if (i23 < i25 - 1) {
                                                        matroskaExtractor4.Q[i23] = r3;
                                                        i19++;
                                                        matroskaExtractor4.k(extractorInput, i19);
                                                        int i26 = i19 - 1;
                                                        if (matroskaExtractor4.l.a[i26] == 0) {
                                                            throw ParserException.a("No valid varint length mask found", null);
                                                        }
                                                        int i27 = 8;
                                                        int i28 = 0;
                                                        while (true) {
                                                            if (i28 < i27) {
                                                                int i29 = r4 << (7 - i28);
                                                                if ((matroskaExtractor4.l.a[i26] & i29) != 0) {
                                                                    r4 = z8;
                                                                    int i30 = i19 + i28;
                                                                    matroskaExtractor4.k(extractorInput, i30);
                                                                    j = (~i29) & matroskaExtractor4.l.a[i26] & b2;
                                                                    int i31 = i26 + 1;
                                                                    while (i31 < i30) {
                                                                        j = (j << 8) | ((long) (matroskaExtractor4.l.a[i31] & 255));
                                                                        i31++;
                                                                        i30 = i30;
                                                                    }
                                                                    int i32 = i30;
                                                                    if (i23 > 0) {
                                                                        j -= (1 << ((i28 * 7) + 6)) - 1;
                                                                    }
                                                                    i19 = i32;
                                                                } else {
                                                                    r4 = z8;
                                                                    i28++;
                                                                    i27 = 8;
                                                                    r4 = 1;
                                                                    b2 = 255;
                                                                }
                                                            } else {
                                                                r4 = z8;
                                                                j = 0;
                                                            }
                                                        }
                                                        if (j < -2147483648L || j > 2147483647L) {
                                                            throw ParserException.a("EBML lacing sample size out of range.", null);
                                                        }
                                                        int i33 = (int) j;
                                                        int[] iArr2 = matroskaExtractor4.Q;
                                                        if (i23 != 0) {
                                                            i33 += iArr2[i23 - 1];
                                                        }
                                                        iArr2[i23] = i33;
                                                        i24 += iArr2[i23];
                                                        i23++;
                                                        r3 = 0;
                                                        z8 = true;
                                                        b2 = 255;
                                                    } else {
                                                        matroskaExtractor4.Q[i25 - 1] = ((i14 - matroskaExtractor4.S) - i19) - i24;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    byte[] bArr2 = matroskaExtractor4.l.a;
                                    matroskaExtractor4.M = matroskaExtractor4.m((bArr2[1] & 255) | (bArr2[0] << 8)) + matroskaExtractor4.G;
                                    matroskaExtractor4.T = (cVar.d == 2 || (i13 == 163 && (matroskaExtractor4.l.a[2] & 128) == 128)) ? 1 : 0;
                                    matroskaExtractor4.L = 2;
                                    matroskaExtractor4.O = 0;
                                }
                                if (i13 == 163) {
                                    while (true) {
                                        int i34 = matroskaExtractor4.O;
                                        if (i34 < matroskaExtractor4.P) {
                                            matroskaExtractor4.d(cVar, ((long) ((matroskaExtractor4.O * cVar.e) / 1000)) + matroskaExtractor4.M, matroskaExtractor4.T, matroskaExtractor4.n(extractorInput, cVar, matroskaExtractor4.Q[i34]), 0);
                                            matroskaExtractor4.O++;
                                        } else {
                                            matroskaExtractor4.L = 0;
                                        }
                                    }
                                } else {
                                    while (true) {
                                        int i35 = matroskaExtractor4.O;
                                        if (i35 < matroskaExtractor4.P) {
                                            int[] iArr3 = matroskaExtractor4.Q;
                                            iArr3[i35] = matroskaExtractor4.n(extractorInput, cVar, iArr3[i35]);
                                            matroskaExtractor4.O++;
                                        }
                                    }
                                }
                            }
                        } else if (i13 != 165) {
                            if (i13 == 16877) {
                                matroskaExtractor4.c(i13);
                                c cVar2 = matroskaExtractor4.f1195z;
                                int i36 = cVar2.g;
                                if (i36 == 1685485123 || i36 == 1685480259) {
                                    byte[] bArr3 = new byte[i14];
                                    cVar2.N = bArr3;
                                    extractorInput.readFully(bArr3, z6 ? 1 : 0, i14);
                                } else {
                                    extractorInput.l(i14);
                                }
                            } else if (i13 == 16981) {
                                matroskaExtractor4.c(i13);
                                byte[] bArr4 = new byte[i14];
                                matroskaExtractor4.f1195z.i = bArr4;
                                extractorInput.readFully(bArr4, z6 ? 1 : 0, i14);
                            } else if (i13 == 18402) {
                                byte[] bArr5 = new byte[i14];
                                extractorInput.readFully(bArr5, z6 ? 1 : 0, i14);
                                matroskaExtractor4.c(i13);
                                matroskaExtractor4.f1195z.j = new TrackOutput2.a(z7 ? 1 : 0, bArr5, z6 ? 1 : 0, z6 ? 1 : 0);
                            } else if (i13 == 21419) {
                                Arrays.fill(matroskaExtractor4.n.a, z6 ? (byte) 1 : (byte) 0);
                                extractorInput.readFully(matroskaExtractor4.n.a, 4 - i14, i14);
                                matroskaExtractor4.n.E(z6 ? 1 : 0);
                                matroskaExtractor4.B = (int) matroskaExtractor4.n.u();
                            } else if (i13 == 25506) {
                                matroskaExtractor4.c(i13);
                                byte[] bArr6 = new byte[i14];
                                matroskaExtractor4.f1195z.k = bArr6;
                                extractorInput.readFully(bArr6, z6 ? 1 : 0, i14);
                            } else {
                                if (i13 != 30322) {
                                    throw outline.w0(26, "Unexpected id: ", i13, null);
                                }
                                matroskaExtractor4.c(i13);
                                byte[] bArr7 = new byte[i14];
                                matroskaExtractor4.f1195z.v = bArr7;
                                extractorInput.readFully(bArr7, z6 ? 1 : 0, i14);
                            }
                        } else if (matroskaExtractor4.L == 2) {
                            c cVar3 = matroskaExtractor4.h.get(matroskaExtractor4.R);
                            if (matroskaExtractor4.U == 4 && "V_VP9".equals(cVar3.f1196b)) {
                                ParsableByteArray parsableByteArray = matroskaExtractor4.f1192s;
                                byte[] bArr8 = parsableByteArray.a;
                                if (bArr8.length < i14) {
                                    bArr8 = new byte[i14];
                                }
                                parsableByteArray.C(bArr8, i14);
                                extractorInput.readFully(matroskaExtractor4.f1192s.a, z6 ? 1 : 0, i14);
                            } else {
                                extractorInput.l(i14);
                            }
                        }
                        defaultEbmlReader.e = 0;
                    } else {
                        if (i != 5) {
                            throw outline.w0(32, "Invalid element type ", i, null);
                        }
                        long j6 = defaultEbmlReader.g;
                        if (j6 != 4 && j6 != 8) {
                            StringBuilder sb4 = new StringBuilder(40);
                            sb4.append("Invalid float size: ");
                            sb4.append(j6);
                            throw ParserException.a(sb4.toString(), null);
                        }
                        EbmlProcessor ebmlProcessor6 = defaultEbmlReader.d;
                        int i37 = defaultEbmlReader.f;
                        int i38 = (int) j6;
                        long jA2 = defaultEbmlReader.a(extractorInput, i38);
                        double dIntBitsToFloat = i38 == 4 ? Float.intBitsToFloat((int) jA2) : Double.longBitsToDouble(jA2);
                        MatroskaExtractor matroskaExtractor5 = MatroskaExtractor.this;
                        Objects.requireNonNull(matroskaExtractor5);
                        if (i37 == 181) {
                            matroskaExtractor5.c(i37);
                            matroskaExtractor5.f1195z.Q = (int) dIntBitsToFloat;
                        } else if (i37 != 17545) {
                            switch (i37) {
                                case 21969:
                                    matroskaExtractor5.c(i37);
                                    matroskaExtractor5.f1195z.D = (float) dIntBitsToFloat;
                                    break;
                                case 21970:
                                    matroskaExtractor5.c(i37);
                                    matroskaExtractor5.f1195z.E = (float) dIntBitsToFloat;
                                    break;
                                case 21971:
                                    matroskaExtractor5.c(i37);
                                    matroskaExtractor5.f1195z.F = (float) dIntBitsToFloat;
                                    break;
                                case 21972:
                                    matroskaExtractor5.c(i37);
                                    matroskaExtractor5.f1195z.G = (float) dIntBitsToFloat;
                                    break;
                                case 21973:
                                    matroskaExtractor5.c(i37);
                                    matroskaExtractor5.f1195z.H = (float) dIntBitsToFloat;
                                    break;
                                case 21974:
                                    matroskaExtractor5.c(i37);
                                    matroskaExtractor5.f1195z.I = (float) dIntBitsToFloat;
                                    break;
                                case 21975:
                                    matroskaExtractor5.c(i37);
                                    matroskaExtractor5.f1195z.J = (float) dIntBitsToFloat;
                                    break;
                                case 21976:
                                    matroskaExtractor5.c(i37);
                                    matroskaExtractor5.f1195z.K = (float) dIntBitsToFloat;
                                    break;
                                case 21977:
                                    matroskaExtractor5.c(i37);
                                    matroskaExtractor5.f1195z.L = (float) dIntBitsToFloat;
                                    break;
                                case 21978:
                                    matroskaExtractor5.c(i37);
                                    matroskaExtractor5.f1195z.M = (float) dIntBitsToFloat;
                                    break;
                                default:
                                    switch (i37) {
                                        case 30323:
                                            matroskaExtractor5.c(i37);
                                            matroskaExtractor5.f1195z.f1197s = (float) dIntBitsToFloat;
                                            break;
                                        case 30324:
                                            matroskaExtractor5.c(i37);
                                            matroskaExtractor5.f1195z.t = (float) dIntBitsToFloat;
                                            break;
                                        case 30325:
                                            matroskaExtractor5.c(i37);
                                            matroskaExtractor5.f1195z.u = (float) dIntBitsToFloat;
                                            break;
                                    }
                                    break;
                            }
                        } else {
                            matroskaExtractor5.f1193x = (long) dIntBitsToFloat;
                        }
                        defaultEbmlReader.e = z6 ? 1 : 0;
                    }
                } else {
                    MatroskaExtractor.this.h(defaultEbmlReader.f1183b.pop().a);
                }
                z5 = true;
            }
            if (z5) {
                long position2 = extractorInput.getPosition();
                if (this.D) {
                    this.F = position2;
                    positionHolder.a = this.E;
                    this.D = false;
                } else {
                    if (this.A) {
                        long j7 = this.F;
                        if (j7 != -1) {
                            positionHolder.a = j7;
                            this.F = -1L;
                        }
                        if (z2) {
                            return 1;
                        }
                    }
                    z2 = false;
                    if (z2) {
                        return 1;
                    }
                }
                z2 = true;
                if (z2) {
                    return 1;
                }
            }
            z3 = false;
            z4 = true;
        }
        if (z5) {
            return 0;
        }
        for (int i39 = 0; i39 < this.h.size(); i39++) {
            c cVarValueAt = this.h.valueAt(i39);
            Objects.requireNonNull(cVarValueAt.X);
            TrueHdSampleRechunker trueHdSampleRechunker = cVarValueAt.T;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.a(cVarValueAt.X, cVarValueAt.j);
            }
        }
        return -1;
    }

    @Override // b.i.a.c.x2.Extractor
    public final void f(ExtractorOutput extractorOutput) {
        this.f1191f0 = extractorOutput;
    }

    @Override // b.i.a.c.x2.Extractor
    @CallSuper
    public void g(long j, long j2) {
        this.G = -9223372036854775807L;
        this.L = 0;
        DefaultEbmlReader defaultEbmlReader = (DefaultEbmlReader) this.f;
        defaultEbmlReader.e = 0;
        defaultEbmlReader.f1183b.clear();
        VarintReader varintReader = defaultEbmlReader.c;
        varintReader.c = 0;
        varintReader.d = 0;
        VarintReader varintReader2 = this.g;
        varintReader2.c = 0;
        varintReader2.d = 0;
        l();
        for (int i = 0; i < this.h.size(); i++) {
            TrueHdSampleRechunker trueHdSampleRechunker = this.h.valueAt(i).T;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.f1300b = false;
                trueHdSampleRechunker.c = 0;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:210:0x033a  */
    /* JADX WARN: Code duplicated, block: B:346:0x04eb  */
    /* JADX WARN: Code duplicated, block: B:476:0x080e  */
    /* JADX WARN: Code duplicated, block: B:478:0x0816  */
    /* JADX WARN: Code duplicated, block: B:479:0x0835 A[PHI: r3
      0x0835: PHI (r3v149 int) = (r3v104 int), (r3v150 int) binds: [B:477:0x0814, B:371:0x05e7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:480:0x083c  */
    /* JADX WARN: Code duplicated, block: B:494:0x0866  */
    /* JADX WARN: Code duplicated, block: B:499:0x087d  */
    /* JADX WARN: Code duplicated, block: B:500:0x087f  */
    /* JADX WARN: Code duplicated, block: B:503:0x088c  */
    /* JADX WARN: Code duplicated, block: B:504:0x0899  */
    /* JADX WARN: Code duplicated, block: B:506:0x089f  */
    /* JADX WARN: Code duplicated, block: B:508:0x08a3  */
    /* JADX WARN: Code duplicated, block: B:510:0x08a8  */
    /* JADX WARN: Code duplicated, block: B:513:0x08b0  */
    /* JADX WARN: Code duplicated, block: B:515:0x08b5  */
    /* JADX WARN: Code duplicated, block: B:518:0x08bc  */
    /* JADX WARN: Code duplicated, block: B:523:0x08cf  */
    /* JADX WARN: Code duplicated, block: B:525:0x08d7  */
    /* JADX WARN: Code duplicated, block: B:545:0x099d  */
    /* JADX WARN: Code duplicated, block: B:547:0x09aa  */
    /* JADX WARN: Code duplicated, block: B:550:0x09af  */
    /* JADX WARN: Code duplicated, block: B:552:0x09b7  */
    /* JADX WARN: Code duplicated, block: B:553:0x09c6  */
    /* JADX WARN: Code duplicated, block: B:556:0x09cc  */
    /* JADX WARN: Code duplicated, block: B:575:0x0a19  */
    /* JADX WARN: Code duplicated, block: B:577:0x0a33  */
    /* JADX WARN: Code duplicated, block: B:579:0x0a3b  */
    /* JADX WARN: Code duplicated, block: B:593:0x0a69  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v9, types: [b.i.a.c.x2.g0.e$c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v17, types: [boolean] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @CallSuper
    public void h(int i) throws ParserException {
        boolean z2;
        byte b2;
        boolean z3;
        int iR;
        List<byte[]> listSingletonList;
        int i2;
        List<byte[]> list;
        String str;
        String str2;
        String str3;
        ArrayList arrayList;
        Pair pair;
        Pair pair2;
        String str4;
        List<byte[]> list2;
        String str5;
        String str6;
        String str7;
        List<byte[]> list3;
        int i3;
        String str8;
        List<byte[]> list4;
        List<byte[]> list5;
        List<byte[]> listU;
        byte[] bArr;
        int i4;
        Format2.b bVar;
        int i5;
        int i6;
        float f;
        int i7;
        ColorInfo colorInfo;
        String str9;
        int iIntValue;
        int i8;
        Map<String, Integer> map;
        byte[] bArr2;
        int i9;
        int i10;
        int i11;
        String str10;
        DolbyVisionConfig dolbyVisionConfigA;
        List<byte[]> list6;
        List<byte[]> list7;
        SeekMap bVar2;
        int i12;
        int i13;
        AnimatableValueParser.H(this.f1191f0);
        int i14 = 0;
        if (i == 160) {
            if (this.L != 2) {
                return;
            }
            int i15 = 0;
            for (int i16 = 0; i16 < this.P; i16++) {
                i15 += this.Q[i16];
            }
            c cVar = this.h.get(this.R);
            Objects.requireNonNull(cVar.X);
            int i17 = 0;
            while (i17 < this.P) {
                long j = this.M + ((long) ((cVar.e * i17) / 1000));
                int i18 = this.T;
                if (i17 == 0 && !this.V) {
                    i18 |= 1;
                }
                int i19 = this.Q[i17];
                int i20 = i15 - i19;
                d(cVar, j, i18, i19, i20);
                i17++;
                i15 = i20;
            }
            this.L = 0;
            return;
        }
        if (i != 174) {
            if (i == 19899) {
                int i21 = this.B;
                if (i21 != -1) {
                    long j2 = this.C;
                    if (j2 != -1) {
                        if (i21 == 475249515) {
                            this.E = j2;
                            return;
                        }
                        return;
                    }
                }
                throw ParserException.a("Mandatory element SeekID or SeekPosition not found", null);
            }
            if (i == 25152) {
                c(i);
                c cVar2 = this.f1195z;
                if (cVar2.h) {
                    TrackOutput2.a aVar = cVar2.j;
                    if (aVar == null) {
                        throw ParserException.a("Encrypted Track found but ContentEncKeyID was not found", null);
                    }
                    cVar2.l = new DrmInitData(null, true, new DrmInitData.SchemeData(C.a, "video/webm", aVar.f1299b));
                    return;
                }
                return;
            }
            if (i == 28032) {
                c(i);
                c cVar3 = this.f1195z;
                if (cVar3.h && cVar3.i != null) {
                    throw ParserException.a("Combining encryption and compression is not supported", null);
                }
                return;
            }
            if (i == 357149030) {
                if (this.w == -9223372036854775807L) {
                    this.w = 1000000L;
                }
                long j3 = this.f1193x;
                if (j3 != -9223372036854775807L) {
                    this.f1194y = m(j3);
                    return;
                }
                return;
            }
            if (i == 374648427) {
                if (this.h.size() == 0) {
                    throw ParserException.a("No valid tracks were found", null);
                }
                this.f1191f0.j();
                return;
            }
            if (i != 475249515) {
                return;
            }
            if (!this.A) {
                ExtractorOutput extractorOutput = this.f1191f0;
                LongArray longArray = this.H;
                LongArray longArray2 = this.I;
                if (this.v == -1 || this.f1194y == -9223372036854775807L || longArray == null || (i12 = longArray.a) == 0 || longArray2 == null || longArray2.a != i12) {
                    bVar2 = new SeekMap.b(this.f1194y, 0L);
                } else {
                    int[] iArrCopyOf = new int[i12];
                    long[] jArrCopyOf = new long[i12];
                    long[] jArrCopyOf2 = new long[i12];
                    long[] jArrCopyOf3 = new long[i12];
                    for (int i22 = 0; i22 < i12; i22++) {
                        jArrCopyOf3[i22] = longArray.b(i22);
                        jArrCopyOf[i22] = longArray2.b(i22) + this.v;
                    }
                    while (true) {
                        i13 = i12 - 1;
                        if (i14 >= i13) {
                            break;
                        }
                        int i23 = i14 + 1;
                        iArrCopyOf[i14] = (int) (jArrCopyOf[i23] - jArrCopyOf[i14]);
                        jArrCopyOf2[i14] = jArrCopyOf3[i23] - jArrCopyOf3[i14];
                        i14 = i23;
                    }
                    iArrCopyOf[i13] = (int) ((this.v + this.u) - jArrCopyOf[i13]);
                    jArrCopyOf2[i13] = this.f1194y - jArrCopyOf3[i13];
                    long j4 = jArrCopyOf2[i13];
                    if (j4 <= 0) {
                        StringBuilder sb = new StringBuilder(72);
                        sb.append("Discarding last cue point with unexpected duration: ");
                        sb.append(j4);
                        Log.w("MatroskaExtractor", sb.toString());
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i13);
                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i13);
                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i13);
                        jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i13);
                    }
                    bVar2 = new ChunkIndex(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
                }
                extractorOutput.a(bVar2);
                this.A = true;
            }
            this.H = null;
            this.I = null;
            return;
        }
        ?? r0 = this.f1195z;
        AnimatableValueParser.H(r0);
        String str11 = r0.f1196b;
        if (str11 == null) {
            throw ParserException.a("CodecId is missing in TrackEntry element", null);
        }
        switch (str11) {
            case "V_MPEG4/ISO/AP":
            case "V_MPEG4/ISO/SP":
            case "A_MS/ACM":
            case "A_TRUEHD":
            case "A_VORBIS":
            case "A_MPEG/L2":
            case "A_MPEG/L3":
            case "V_MS/VFW/FOURCC":
            case "S_DVBSUB":
            case "V_MPEG4/ISO/ASP":
            case "V_MPEG4/ISO/AVC":
            case "S_VOBSUB":
            case "A_DTS/LOSSLESS":
            case "A_AAC":
            case "A_AC3":
            case "A_DTS":
            case "V_AV1":
            case "V_VP8":
            case "V_VP9":
            case "S_HDMV/PGS":
            case "V_THEORA":
            case "A_DTS/EXPRESS":
            case "A_PCM/FLOAT/IEEE":
            case "A_PCM/INT/BIG":
            case "A_PCM/INT/LIT":
            case "S_TEXT/ASS":
            case "V_MPEGH/ISO/HEVC":
            case "S_TEXT/UTF8":
            case "V_MPEG2":
            case "A_EAC3":
            case "A_FLAC":
            case "A_OPUS":
                z2 = true;
                break;
            default:
                z2 = false;
                break;
        }
        if (z2) {
            ExtractorOutput extractorOutput2 = this.f1191f0;
            int i24 = r0.c;
            String str12 = r0.f1196b;
            str12.hashCode();
            switch (str12) {
                case "V_MPEG4/ISO/AP":
                    b2 = 0;
                    break;
                case "V_MPEG4/ISO/SP":
                    b2 = 1;
                    break;
                case "A_MS/ACM":
                    b2 = 2;
                    break;
                case "A_TRUEHD":
                    b2 = 3;
                    break;
                case "A_VORBIS":
                    b2 = 4;
                    break;
                case "A_MPEG/L2":
                    b2 = 5;
                    break;
                case "A_MPEG/L3":
                    b2 = 6;
                    break;
                case "V_MS/VFW/FOURCC":
                    b2 = 7;
                    break;
                case "S_DVBSUB":
                    b2 = 8;
                    break;
                case "V_MPEG4/ISO/ASP":
                    b2 = 9;
                    break;
                case "V_MPEG4/ISO/AVC":
                    b2 = 10;
                    break;
                case "S_VOBSUB":
                    b2 = 11;
                    break;
                case "A_DTS/LOSSLESS":
                    b2 = 12;
                    break;
                case "A_AAC":
                    b2 = 13;
                    break;
                case "A_AC3":
                    b2 = 14;
                    break;
                case "A_DTS":
                    b2 = 15;
                    break;
                case "V_AV1":
                    b2 = 16;
                    break;
                case "V_VP8":
                    b2 = 17;
                    break;
                case "V_VP9":
                    b2 = 18;
                    break;
                case "S_HDMV/PGS":
                    b2 = 19;
                    break;
                case "V_THEORA":
                    b2 = 20;
                    break;
                case "A_DTS/EXPRESS":
                    b2 = 21;
                    break;
                case "A_PCM/FLOAT/IEEE":
                    b2 = 22;
                    break;
                case "A_PCM/INT/BIG":
                    b2 = 23;
                    break;
                case "A_PCM/INT/LIT":
                    b2 = 24;
                    break;
                case "S_TEXT/ASS":
                    b2 = 25;
                    break;
                case "V_MPEGH/ISO/HEVC":
                    b2 = 26;
                    break;
                case "S_TEXT/UTF8":
                    b2 = 27;
                    break;
                case "V_MPEG2":
                    b2 = 28;
                    break;
                case "A_EAC3":
                    b2 = 29;
                    break;
                case "A_FLAC":
                    b2 = 30;
                    break;
                case "A_OPUS":
                    b2 = 31;
                    break;
                default:
                    b2 = -1;
                    break;
            }
            String str13 = "video/x-unknown";
            String str14 = "audio/x-unknown";
            switch (b2) {
                case 0:
                case 1:
                case 9:
                    byte[] bArr3 = r0.k;
                    str14 = "video/mp4v-es";
                    listSingletonList = bArr3 == null ? null : Collections.singletonList(bArr3);
                    i2 = -1;
                    list = listSingletonList;
                    str = null;
                    list6 = list;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null && (dolbyVisionConfigA = DolbyVisionConfig.a(new ParsableByteArray(bArr))) != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i25 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i26 = i25 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6 && (i9 = r0.p) != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f || r0.E == -1.0f || r0.F == -1.0f || r0.G == -1.0f || r0.H == -1.0f || r0.I == -1.0f || r0.J == -1.0f || r0.K == -1.0f || r0.L == -1.0f || r0.M == -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = new byte[25];
                                ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr2).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder.put((byte) 0);
                                byteBufferOrder.putShort((short) ((r0.D * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.E * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.F * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.G * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.H * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.I * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.J * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.K * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) (r0.L + 0.5f));
                                byteBufferOrder.putShort((short) (r0.M + 0.5f));
                                byteBufferOrder.putShort((short) r0.B);
                                byteBufferOrder.putShort((short) r0.C);
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0 || Float.compare(r0.f1197s, 0.0f) != 0 || Float.compare(r0.t, 0.0f) != 0) {
                            i8 = iIntValue;
                        } else if (Float.compare(r0.u, 0.0f) == 0) {
                            i8 = 0;
                        } else if (Float.compare(r0.t, 90.0f) == 0) {
                            i8 = 90;
                        } else if (Float.compare(r0.t, -180.0f) == 0 || Float.compare(r0.t, 180.0f) == 0) {
                            i8 = 180;
                        } else if (Float.compare(r0.t, -90.0f) == 0) {
                            i8 = 270;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14) && !"text/x-ssa".equals(str14) && !"application/vobsub".equals(str14) && !"application/pgs".equals(str14) && !"application/dvbsubs".equals(str14)) {
                            throw ParserException.a("Unexpected MIME type.", null);
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null && !e.containsKey(str10)) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i26;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A = bVar.a();
                    TrackOutput2 trackOutput2P = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P;
                    trackOutput2P.e(format2A);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 2:
                    ParsableByteArray parsableByteArray = new ParsableByteArray(r0.a(r0.f1196b));
                    try {
                        int iL = parsableByteArray.l();
                        if (iL != 1) {
                            if (iL == 65534) {
                                parsableByteArray.E(24);
                                long jM = parsableByteArray.m();
                                UUID uuid = d;
                                if (jM != uuid.getMostSignificantBits() || parsableByteArray.m() != uuid.getLeastSignificantBits()) {
                                }
                                if (z3) {
                                    iR = Util2.r(r0.P);
                                    if (iR == 0) {
                                        int i27 = r0.P;
                                        StringBuilder sb2 = new StringBuilder(75);
                                        sb2.append("Unsupported PCM bit depth: ");
                                        sb2.append(i27);
                                        sb2.append(". Setting mimeType to ");
                                        sb2.append("audio/x-unknown");
                                        Log.w("MatroskaExtractor", sb2.toString());
                                    } else {
                                        str14 = "audio/raw";
                                        list3 = null;
                                        i3 = -1;
                                        str8 = null;
                                    }
                                    bArr = r0.N;
                                    if (bArr != null) {
                                        str8 = dolbyVisionConfigA.a;
                                        str14 = "video/dolby-vision";
                                    }
                                    int i28 = r0.V | 0;
                                    if (r0.U) {
                                        i4 = 2;
                                    } else {
                                        i4 = 0;
                                    }
                                    int i29 = i28 | i4;
                                    bVar = new Format2.b();
                                    if (MimeTypes.h(str14)) {
                                        bVar.f1023x = r0.O;
                                        bVar.f1024y = r0.Q;
                                        bVar.f1025z = iR;
                                        i5 = 1;
                                    } else if (MimeTypes.j(str14)) {
                                        if (r0.q == 0) {
                                            i10 = r0.o;
                                            i6 = -1;
                                            if (i10 == -1) {
                                                i10 = r0.m;
                                            }
                                            r0.o = i10;
                                            i11 = r0.p;
                                            if (i11 == -1) {
                                                i11 = r0.n;
                                            }
                                            r0.p = i11;
                                        } else {
                                            i6 = -1;
                                        }
                                        f = -1.0f;
                                        i7 = r0.o;
                                        if (i7 != i6) {
                                            f = (r0.n * i7) / (r0.m * i9);
                                        }
                                        if (r0.f1198x) {
                                            if (r0.D != -1.0f) {
                                                bArr2 = null;
                                            } else {
                                                bArr2 = null;
                                            }
                                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                                        } else {
                                            colorInfo = null;
                                        }
                                        str9 = r0.a;
                                        if (str9 != null) {
                                            map = e;
                                            if (map.containsKey(str9)) {
                                                iIntValue = map.get(r0.a).intValue();
                                            } else {
                                                iIntValue = -1;
                                            }
                                        } else {
                                            iIntValue = -1;
                                        }
                                        if (r0.r == 0) {
                                            i8 = iIntValue;
                                        } else {
                                            i8 = iIntValue;
                                        }
                                        bVar.p = r0.m;
                                        bVar.q = r0.n;
                                        bVar.t = f;
                                        bVar.f1022s = i8;
                                        bVar.u = r0.v;
                                        bVar.v = r0.w;
                                        bVar.w = colorInfo;
                                        i5 = 2;
                                    } else {
                                        if ("application/x-subrip".equals(str14)) {
                                        }
                                        i5 = 3;
                                    }
                                    str10 = r0.a;
                                    if (str10 != null) {
                                        bVar.f1021b = r0.a;
                                    }
                                    bVar.b(i24);
                                    bVar.k = str14;
                                    bVar.l = i3;
                                    bVar.c = r0.W;
                                    bVar.d = i29;
                                    bVar.m = list3;
                                    bVar.h = str8;
                                    bVar.n = r0.l;
                                    Format2 format2A2 = bVar.a();
                                    TrackOutput2 trackOutput2P2 = extractorOutput2.p(r0.c, i5);
                                    r0.X = trackOutput2P2;
                                    trackOutput2P2.e(format2A2);
                                    this.h.put(r0.c, (c) r0);
                                } else {
                                    Log.w("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to ".concat("audio/x-unknown"));
                                }
                                listSingletonList = null;
                                i2 = -1;
                                list = listSingletonList;
                                str = null;
                                list6 = list;
                                str8 = str;
                                i3 = i2;
                                list3 = list6;
                                iR = -1;
                                bArr = r0.N;
                                if (bArr != null) {
                                    str8 = dolbyVisionConfigA.a;
                                    str14 = "video/dolby-vision";
                                }
                                int i210 = r0.V | 0;
                                if (r0.U) {
                                    i4 = 2;
                                } else {
                                    i4 = 0;
                                }
                                int i211 = i210 | i4;
                                bVar = new Format2.b();
                                if (MimeTypes.h(str14)) {
                                    bVar.f1023x = r0.O;
                                    bVar.f1024y = r0.Q;
                                    bVar.f1025z = iR;
                                    i5 = 1;
                                } else if (MimeTypes.j(str14)) {
                                    if (r0.q == 0) {
                                        i10 = r0.o;
                                        i6 = -1;
                                        if (i10 == -1) {
                                            i10 = r0.m;
                                        }
                                        r0.o = i10;
                                        i11 = r0.p;
                                        if (i11 == -1) {
                                            i11 = r0.n;
                                        }
                                        r0.p = i11;
                                    } else {
                                        i6 = -1;
                                    }
                                    f = -1.0f;
                                    i7 = r0.o;
                                    if (i7 != i6) {
                                        f = (r0.n * i7) / (r0.m * i9);
                                    }
                                    if (r0.f1198x) {
                                        if (r0.D != -1.0f) {
                                            bArr2 = null;
                                        } else {
                                            bArr2 = null;
                                        }
                                        colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                                    } else {
                                        colorInfo = null;
                                    }
                                    str9 = r0.a;
                                    if (str9 != null) {
                                        map = e;
                                        if (map.containsKey(str9)) {
                                            iIntValue = map.get(r0.a).intValue();
                                        } else {
                                            iIntValue = -1;
                                        }
                                    } else {
                                        iIntValue = -1;
                                    }
                                    if (r0.r == 0) {
                                        i8 = iIntValue;
                                    } else {
                                        i8 = iIntValue;
                                    }
                                    bVar.p = r0.m;
                                    bVar.q = r0.n;
                                    bVar.t = f;
                                    bVar.f1022s = i8;
                                    bVar.u = r0.v;
                                    bVar.v = r0.w;
                                    bVar.w = colorInfo;
                                    i5 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str14)) {
                                    }
                                    i5 = 3;
                                }
                                str10 = r0.a;
                                if (str10 != null) {
                                    bVar.f1021b = r0.a;
                                }
                                bVar.b(i24);
                                bVar.k = str14;
                                bVar.l = i3;
                                bVar.c = r0.W;
                                bVar.d = i211;
                                bVar.m = list3;
                                bVar.h = str8;
                                bVar.n = r0.l;
                                Format2 format2A3 = bVar.a();
                                TrackOutput2 trackOutput2P3 = extractorOutput2.p(r0.c, i5);
                                r0.X = trackOutput2P3;
                                trackOutput2P3.e(format2A3);
                                this.h.put(r0.c, (c) r0);
                            }
                            z3 = false;
                            if (z3) {
                                iR = Util2.r(r0.P);
                                if (iR == 0) {
                                    int i212 = r0.P;
                                    StringBuilder sb3 = new StringBuilder(75);
                                    sb3.append("Unsupported PCM bit depth: ");
                                    sb3.append(i212);
                                    sb3.append(". Setting mimeType to ");
                                    sb3.append("audio/x-unknown");
                                    Log.w("MatroskaExtractor", sb3.toString());
                                } else {
                                    str14 = "audio/raw";
                                    list3 = null;
                                    i3 = -1;
                                    str8 = null;
                                }
                                bArr = r0.N;
                                if (bArr != null) {
                                    str8 = dolbyVisionConfigA.a;
                                    str14 = "video/dolby-vision";
                                }
                                int i213 = r0.V | 0;
                                if (r0.U) {
                                    i4 = 2;
                                } else {
                                    i4 = 0;
                                }
                                int i214 = i213 | i4;
                                bVar = new Format2.b();
                                if (MimeTypes.h(str14)) {
                                    bVar.f1023x = r0.O;
                                    bVar.f1024y = r0.Q;
                                    bVar.f1025z = iR;
                                    i5 = 1;
                                } else if (MimeTypes.j(str14)) {
                                    if (r0.q == 0) {
                                        i10 = r0.o;
                                        i6 = -1;
                                        if (i10 == -1) {
                                            i10 = r0.m;
                                        }
                                        r0.o = i10;
                                        i11 = r0.p;
                                        if (i11 == -1) {
                                            i11 = r0.n;
                                        }
                                        r0.p = i11;
                                    } else {
                                        i6 = -1;
                                    }
                                    f = -1.0f;
                                    i7 = r0.o;
                                    if (i7 != i6) {
                                        f = (r0.n * i7) / (r0.m * i9);
                                    }
                                    if (r0.f1198x) {
                                        if (r0.D != -1.0f) {
                                            bArr2 = null;
                                        } else {
                                            bArr2 = null;
                                        }
                                        colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                                    } else {
                                        colorInfo = null;
                                    }
                                    str9 = r0.a;
                                    if (str9 != null) {
                                        map = e;
                                        if (map.containsKey(str9)) {
                                            iIntValue = map.get(r0.a).intValue();
                                        } else {
                                            iIntValue = -1;
                                        }
                                    } else {
                                        iIntValue = -1;
                                    }
                                    if (r0.r == 0) {
                                        i8 = iIntValue;
                                    } else {
                                        i8 = iIntValue;
                                    }
                                    bVar.p = r0.m;
                                    bVar.q = r0.n;
                                    bVar.t = f;
                                    bVar.f1022s = i8;
                                    bVar.u = r0.v;
                                    bVar.v = r0.w;
                                    bVar.w = colorInfo;
                                    i5 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str14)) {
                                    }
                                    i5 = 3;
                                }
                                str10 = r0.a;
                                if (str10 != null) {
                                    bVar.f1021b = r0.a;
                                }
                                bVar.b(i24);
                                bVar.k = str14;
                                bVar.l = i3;
                                bVar.c = r0.W;
                                bVar.d = i214;
                                bVar.m = list3;
                                bVar.h = str8;
                                bVar.n = r0.l;
                                Format2 format2A4 = bVar.a();
                                TrackOutput2 trackOutput2P4 = extractorOutput2.p(r0.c, i5);
                                r0.X = trackOutput2P4;
                                trackOutput2P4.e(format2A4);
                                this.h.put(r0.c, (c) r0);
                            } else {
                                Log.w("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to ".concat("audio/x-unknown"));
                            }
                            listSingletonList = null;
                            i2 = -1;
                            list = listSingletonList;
                            str = null;
                            list6 = list;
                            str8 = str;
                            i3 = i2;
                            list3 = list6;
                            iR = -1;
                            bArr = r0.N;
                            if (bArr != null) {
                                str8 = dolbyVisionConfigA.a;
                                str14 = "video/dolby-vision";
                            }
                            int i215 = r0.V | 0;
                            if (r0.U) {
                                i4 = 2;
                            } else {
                                i4 = 0;
                            }
                            int i216 = i215 | i4;
                            bVar = new Format2.b();
                            if (MimeTypes.h(str14)) {
                                bVar.f1023x = r0.O;
                                bVar.f1024y = r0.Q;
                                bVar.f1025z = iR;
                                i5 = 1;
                            } else if (MimeTypes.j(str14)) {
                                if (r0.q == 0) {
                                    i10 = r0.o;
                                    i6 = -1;
                                    if (i10 == -1) {
                                        i10 = r0.m;
                                    }
                                    r0.o = i10;
                                    i11 = r0.p;
                                    if (i11 == -1) {
                                        i11 = r0.n;
                                    }
                                    r0.p = i11;
                                } else {
                                    i6 = -1;
                                }
                                f = -1.0f;
                                i7 = r0.o;
                                if (i7 != i6) {
                                    f = (r0.n * i7) / (r0.m * i9);
                                }
                                if (r0.f1198x) {
                                    if (r0.D != -1.0f) {
                                        bArr2 = null;
                                    } else {
                                        bArr2 = null;
                                    }
                                    colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                                } else {
                                    colorInfo = null;
                                }
                                str9 = r0.a;
                                if (str9 != null) {
                                    map = e;
                                    if (map.containsKey(str9)) {
                                        iIntValue = map.get(r0.a).intValue();
                                    } else {
                                        iIntValue = -1;
                                    }
                                } else {
                                    iIntValue = -1;
                                }
                                if (r0.r == 0) {
                                    i8 = iIntValue;
                                } else {
                                    i8 = iIntValue;
                                }
                                bVar.p = r0.m;
                                bVar.q = r0.n;
                                bVar.t = f;
                                bVar.f1022s = i8;
                                bVar.u = r0.v;
                                bVar.v = r0.w;
                                bVar.w = colorInfo;
                                i5 = 2;
                            } else {
                                if ("application/x-subrip".equals(str14)) {
                                }
                                i5 = 3;
                            }
                            str10 = r0.a;
                            if (str10 != null) {
                                bVar.f1021b = r0.a;
                            }
                            bVar.b(i24);
                            bVar.k = str14;
                            bVar.l = i3;
                            bVar.c = r0.W;
                            bVar.d = i216;
                            bVar.m = list3;
                            bVar.h = str8;
                            bVar.n = r0.l;
                            Format2 format2A5 = bVar.a();
                            TrackOutput2 trackOutput2P5 = extractorOutput2.p(r0.c, i5);
                            r0.X = trackOutput2P5;
                            trackOutput2P5.e(format2A5);
                            this.h.put(r0.c, (c) r0);
                            break;
                        }
                        z3 = true;
                        if (z3) {
                            iR = Util2.r(r0.P);
                            if (iR == 0) {
                                int i217 = r0.P;
                                StringBuilder sb4 = new StringBuilder(75);
                                sb4.append("Unsupported PCM bit depth: ");
                                sb4.append(i217);
                                sb4.append(". Setting mimeType to ");
                                sb4.append("audio/x-unknown");
                                Log.w("MatroskaExtractor", sb4.toString());
                            } else {
                                str14 = "audio/raw";
                                list3 = null;
                                i3 = -1;
                                str8 = null;
                            }
                            bArr = r0.N;
                            if (bArr != null) {
                                str8 = dolbyVisionConfigA.a;
                                str14 = "video/dolby-vision";
                            }
                            int i218 = r0.V | 0;
                            if (r0.U) {
                                i4 = 2;
                            } else {
                                i4 = 0;
                            }
                            int i219 = i218 | i4;
                            bVar = new Format2.b();
                            if (MimeTypes.h(str14)) {
                                bVar.f1023x = r0.O;
                                bVar.f1024y = r0.Q;
                                bVar.f1025z = iR;
                                i5 = 1;
                            } else if (MimeTypes.j(str14)) {
                                if (r0.q == 0) {
                                    i10 = r0.o;
                                    i6 = -1;
                                    if (i10 == -1) {
                                        i10 = r0.m;
                                    }
                                    r0.o = i10;
                                    i11 = r0.p;
                                    if (i11 == -1) {
                                        i11 = r0.n;
                                    }
                                    r0.p = i11;
                                } else {
                                    i6 = -1;
                                }
                                f = -1.0f;
                                i7 = r0.o;
                                if (i7 != i6) {
                                    f = (r0.n * i7) / (r0.m * i9);
                                }
                                if (r0.f1198x) {
                                    if (r0.D != -1.0f) {
                                        bArr2 = null;
                                    } else {
                                        bArr2 = null;
                                    }
                                    colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                                } else {
                                    colorInfo = null;
                                }
                                str9 = r0.a;
                                if (str9 != null) {
                                    map = e;
                                    if (map.containsKey(str9)) {
                                        iIntValue = map.get(r0.a).intValue();
                                    } else {
                                        iIntValue = -1;
                                    }
                                } else {
                                    iIntValue = -1;
                                }
                                if (r0.r == 0) {
                                    i8 = iIntValue;
                                } else {
                                    i8 = iIntValue;
                                }
                                bVar.p = r0.m;
                                bVar.q = r0.n;
                                bVar.t = f;
                                bVar.f1022s = i8;
                                bVar.u = r0.v;
                                bVar.v = r0.w;
                                bVar.w = colorInfo;
                                i5 = 2;
                            } else {
                                if ("application/x-subrip".equals(str14)) {
                                }
                                i5 = 3;
                            }
                            str10 = r0.a;
                            if (str10 != null) {
                                bVar.f1021b = r0.a;
                            }
                            bVar.b(i24);
                            bVar.k = str14;
                            bVar.l = i3;
                            bVar.c = r0.W;
                            bVar.d = i219;
                            bVar.m = list3;
                            bVar.h = str8;
                            bVar.n = r0.l;
                            Format2 format2A6 = bVar.a();
                            TrackOutput2 trackOutput2P6 = extractorOutput2.p(r0.c, i5);
                            r0.X = trackOutput2P6;
                            trackOutput2P6.e(format2A6);
                            this.h.put(r0.c, (c) r0);
                        } else {
                            Log.w("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to ".concat("audio/x-unknown"));
                        }
                        listSingletonList = null;
                        i2 = -1;
                        list = listSingletonList;
                        str = null;
                        list6 = list;
                        str8 = str;
                        i3 = i2;
                        list3 = list6;
                        iR = -1;
                        bArr = r0.N;
                        if (bArr != null) {
                            str8 = dolbyVisionConfigA.a;
                            str14 = "video/dolby-vision";
                        }
                        int i2110 = r0.V | 0;
                        if (r0.U) {
                            i4 = 2;
                        } else {
                            i4 = 0;
                        }
                        int i2111 = i2110 | i4;
                        bVar = new Format2.b();
                        if (MimeTypes.h(str14)) {
                            bVar.f1023x = r0.O;
                            bVar.f1024y = r0.Q;
                            bVar.f1025z = iR;
                            i5 = 1;
                        } else if (MimeTypes.j(str14)) {
                            if (r0.q == 0) {
                                i10 = r0.o;
                                i6 = -1;
                                if (i10 == -1) {
                                    i10 = r0.m;
                                }
                                r0.o = i10;
                                i11 = r0.p;
                                if (i11 == -1) {
                                    i11 = r0.n;
                                }
                                r0.p = i11;
                            } else {
                                i6 = -1;
                            }
                            f = -1.0f;
                            i7 = r0.o;
                            if (i7 != i6) {
                                f = (r0.n * i7) / (r0.m * i9);
                            }
                            if (r0.f1198x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                            } else {
                                colorInfo = null;
                            }
                            str9 = r0.a;
                            if (str9 != null) {
                                map = e;
                                if (map.containsKey(str9)) {
                                    iIntValue = map.get(r0.a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i8 = iIntValue;
                            } else {
                                i8 = iIntValue;
                            }
                            bVar.p = r0.m;
                            bVar.q = r0.n;
                            bVar.t = f;
                            bVar.f1022s = i8;
                            bVar.u = r0.v;
                            bVar.v = r0.w;
                            bVar.w = colorInfo;
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str14)) {
                            }
                            i5 = 3;
                        }
                        str10 = r0.a;
                        if (str10 != null) {
                            bVar.f1021b = r0.a;
                        }
                        bVar.b(i24);
                        bVar.k = str14;
                        bVar.l = i3;
                        bVar.c = r0.W;
                        bVar.d = i2111;
                        bVar.m = list3;
                        bVar.h = str8;
                        bVar.n = r0.l;
                        Format2 format2A7 = bVar.a();
                        TrackOutput2 trackOutput2P7 = extractorOutput2.p(r0.c, i5);
                        r0.X = trackOutput2P7;
                        trackOutput2P7.e(format2A7);
                        this.h.put(r0.c, (c) r0);
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw ParserException.a("Error parsing MS/ACM codec private", null);
                    }
                    break;
                case 3:
                    r0.T = new TrueHdSampleRechunker();
                    str14 = "audio/true-hd";
                    listSingletonList = null;
                    i2 = -1;
                    list = listSingletonList;
                    str = null;
                    list6 = list;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i2112 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i2113 = i2112 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i2113;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A8 = bVar.a();
                    TrackOutput2 trackOutput2P8 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P8;
                    trackOutput2P8.e(format2A8);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 4:
                    byte[] bArrA = r0.a(r0.f1196b);
                    try {
                        try {
                            if (bArrA[0] != 2) {
                                throw ParserException.a("Error parsing vorbis codec private", null);
                            }
                            int i30 = 1;
                            int i31 = 0;
                            while ((bArrA[i30] & 255) == 255) {
                                i31 += 255;
                                i30++;
                            }
                            int i32 = i30 + 1;
                            int i33 = i31 + (bArrA[i30] & 255);
                            int i34 = 0;
                            while ((bArrA[i32] & 255) == 255) {
                                i34 += 255;
                                i32++;
                            }
                            int i35 = i32 + 1;
                            int i36 = i34 + (bArrA[i32] & 255);
                            if (bArrA[i35] != 1) {
                                throw ParserException.a("Error parsing vorbis codec private", null);
                            }
                            byte[] bArr4 = new byte[i33];
                            System.arraycopy(bArrA, i35, bArr4, 0, i33);
                            int i37 = i35 + i33;
                            if (bArrA[i37] != 3) {
                                throw ParserException.a("Error parsing vorbis codec private", null);
                            }
                            int i38 = i37 + i36;
                            if (bArrA[i38] != 5) {
                                throw ParserException.a("Error parsing vorbis codec private", null);
                            }
                            byte[] bArr5 = new byte[bArrA.length - i38];
                            System.arraycopy(bArrA, i38, bArr5, 0, bArrA.length - i38);
                            ArrayList arrayList2 = new ArrayList(2);
                            arrayList2.add(bArr4);
                            arrayList2.add(bArr5);
                            i2 = 8192;
                            str14 = "audio/vorbis";
                            list = arrayList2;
                            str = null;
                            list6 = list;
                            str8 = str;
                            i3 = i2;
                            list3 = list6;
                            iR = -1;
                            bArr = r0.N;
                            if (bArr != null) {
                                str8 = dolbyVisionConfigA.a;
                                str14 = "video/dolby-vision";
                            }
                            int i2114 = r0.V | 0;
                            if (r0.U) {
                                i4 = 2;
                            } else {
                                i4 = 0;
                            }
                            int i2115 = i2114 | i4;
                            bVar = new Format2.b();
                            if (MimeTypes.h(str14)) {
                                bVar.f1023x = r0.O;
                                bVar.f1024y = r0.Q;
                                bVar.f1025z = iR;
                                i5 = 1;
                            } else if (MimeTypes.j(str14)) {
                                if (r0.q == 0) {
                                    i10 = r0.o;
                                    i6 = -1;
                                    if (i10 == -1) {
                                        i10 = r0.m;
                                    }
                                    r0.o = i10;
                                    i11 = r0.p;
                                    if (i11 == -1) {
                                        i11 = r0.n;
                                    }
                                    r0.p = i11;
                                } else {
                                    i6 = -1;
                                }
                                f = -1.0f;
                                i7 = r0.o;
                                if (i7 != i6) {
                                    f = (r0.n * i7) / (r0.m * i9);
                                }
                                if (r0.f1198x) {
                                    if (r0.D != -1.0f) {
                                        bArr2 = null;
                                    } else {
                                        bArr2 = null;
                                    }
                                    colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                                } else {
                                    colorInfo = null;
                                }
                                str9 = r0.a;
                                if (str9 != null) {
                                    map = e;
                                    if (map.containsKey(str9)) {
                                        iIntValue = map.get(r0.a).intValue();
                                    } else {
                                        iIntValue = -1;
                                    }
                                } else {
                                    iIntValue = -1;
                                }
                                if (r0.r == 0) {
                                    i8 = iIntValue;
                                } else {
                                    i8 = iIntValue;
                                }
                                bVar.p = r0.m;
                                bVar.q = r0.n;
                                bVar.t = f;
                                bVar.f1022s = i8;
                                bVar.u = r0.v;
                                bVar.v = r0.w;
                                bVar.w = colorInfo;
                                i5 = 2;
                            } else {
                                if ("application/x-subrip".equals(str14)) {
                                }
                                i5 = 3;
                            }
                            str10 = r0.a;
                            if (str10 != null) {
                                bVar.f1021b = r0.a;
                            }
                            bVar.b(i24);
                            bVar.k = str14;
                            bVar.l = i3;
                            bVar.c = r0.W;
                            bVar.d = i2115;
                            bVar.m = list3;
                            bVar.h = str8;
                            bVar.n = r0.l;
                            Format2 format2A9 = bVar.a();
                            TrackOutput2 trackOutput2P9 = extractorOutput2.p(r0.c, i5);
                            r0.X = trackOutput2P9;
                            trackOutput2P9.e(format2A9);
                            this.h.put(r0.c, (c) r0);
                        } catch (ArrayIndexOutOfBoundsException unused2) {
                            throw ParserException.a("Error parsing vorbis codec private", r0);
                        }
                    } catch (ArrayIndexOutOfBoundsException unused3) {
                        r0 = 0;
                    }
                    break;
                case 5:
                    str2 = "audio/mpeg-L2";
                    str3 = str2;
                    i2 = 4096;
                    arrayList = null;
                    str = null;
                    list7 = arrayList;
                    str14 = str3;
                    list6 = list7;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i2116 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i2117 = i2116 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i2117;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A10 = bVar.a();
                    TrackOutput2 trackOutput2P10 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P10;
                    trackOutput2P10.e(format2A10);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 6:
                    str2 = "audio/mpeg";
                    str3 = str2;
                    i2 = 4096;
                    arrayList = null;
                    str = null;
                    list7 = arrayList;
                    str14 = str3;
                    list6 = list7;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i2118 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i2119 = i2118 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i2119;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A11 = bVar.a();
                    TrackOutput2 trackOutput2P11 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P11;
                    trackOutput2P11.e(format2A11);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 7:
                    byte[] bArrA2 = r0.a(r0.f1196b);
                    try {
                        AnimatableValueParser.j(16 <= bArrA2.length);
                        long j5 = (((long) bArrA2[16]) & 255) | ((((long) bArrA2[17]) & 255) << 8) | ((((long) bArrA2[18]) & 255) << 16) | ((255 & ((long) bArrA2[19])) << 24);
                        if (j5 == 1482049860) {
                            pair2 = new Pair("video/divx", null);
                        } else if (j5 == 859189832) {
                            pair2 = new Pair("video/3gpp", null);
                        } else {
                            if (j5 == 826496599) {
                                int i39 = 40;
                                while (true) {
                                    if (i39 >= bArrA2.length - 4) {
                                        throw ParserException.a("Failed to find FourCC VC1 initialization data", null);
                                    }
                                    if (bArrA2[i39] == 0 && bArrA2[i39 + 1] == 0 && bArrA2[i39 + 2] == 1) {
                                        if (bArrA2[i39 + 3] == 15) {
                                            pair = new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArrA2, i39, bArrA2.length)));
                                        }
                                    }
                                    i39++;
                                }
                            } else {
                                Log.w("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                                pair = new Pair("video/x-unknown", null);
                            }
                            pair2 = pair;
                        }
                        str4 = (String) pair2.first;
                        listU = (List) pair2.second;
                        str3 = str4;
                        list4 = listU;
                        str7 = null;
                        list5 = list4;
                        str = str7;
                        i2 = -1;
                        list7 = list5;
                        str14 = str3;
                        list6 = list7;
                        str8 = str;
                        i3 = i2;
                        list3 = list6;
                        iR = -1;
                        bArr = r0.N;
                        if (bArr != null) {
                            str8 = dolbyVisionConfigA.a;
                            str14 = "video/dolby-vision";
                        }
                        int i21110 = r0.V | 0;
                        if (r0.U) {
                            i4 = 2;
                        } else {
                            i4 = 0;
                        }
                        int i21111 = i21110 | i4;
                        bVar = new Format2.b();
                        if (MimeTypes.h(str14)) {
                            bVar.f1023x = r0.O;
                            bVar.f1024y = r0.Q;
                            bVar.f1025z = iR;
                            i5 = 1;
                        } else if (MimeTypes.j(str14)) {
                            if (r0.q == 0) {
                                i10 = r0.o;
                                i6 = -1;
                                if (i10 == -1) {
                                    i10 = r0.m;
                                }
                                r0.o = i10;
                                i11 = r0.p;
                                if (i11 == -1) {
                                    i11 = r0.n;
                                }
                                r0.p = i11;
                            } else {
                                i6 = -1;
                            }
                            f = -1.0f;
                            i7 = r0.o;
                            if (i7 != i6) {
                                f = (r0.n * i7) / (r0.m * i9);
                            }
                            if (r0.f1198x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                            } else {
                                colorInfo = null;
                            }
                            str9 = r0.a;
                            if (str9 != null) {
                                map = e;
                                if (map.containsKey(str9)) {
                                    iIntValue = map.get(r0.a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i8 = iIntValue;
                            } else {
                                i8 = iIntValue;
                            }
                            bVar.p = r0.m;
                            bVar.q = r0.n;
                            bVar.t = f;
                            bVar.f1022s = i8;
                            bVar.u = r0.v;
                            bVar.v = r0.w;
                            bVar.w = colorInfo;
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str14)) {
                            }
                            i5 = 3;
                        }
                        str10 = r0.a;
                        if (str10 != null) {
                            bVar.f1021b = r0.a;
                        }
                        bVar.b(i24);
                        bVar.k = str14;
                        bVar.l = i3;
                        bVar.c = r0.W;
                        bVar.d = i21111;
                        bVar.m = list3;
                        bVar.h = str8;
                        bVar.n = r0.l;
                        Format2 format2A12 = bVar.a();
                        TrackOutput2 trackOutput2P12 = extractorOutput2.p(r0.c, i5);
                        r0.X = trackOutput2P12;
                        trackOutput2P12.e(format2A12);
                        this.h.put(r0.c, (c) r0);
                    } catch (ArrayIndexOutOfBoundsException unused4) {
                        throw ParserException.a("Error parsing FourCC private data", null);
                    }
                    break;
                case 8:
                    byte[] bArr6 = new byte[4];
                    System.arraycopy(r0.a(r0.f1196b), 0, bArr6, 0, 4);
                    ImmutableList2 immutableList2U = ImmutableList2.u(bArr6);
                    str4 = "application/dvbsubs";
                    listU = immutableList2U;
                    str3 = str4;
                    list4 = listU;
                    str7 = null;
                    list5 = list4;
                    str = str7;
                    i2 = -1;
                    list7 = list5;
                    str14 = str3;
                    list6 = list7;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i21112 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i21113 = i21112 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i21113;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A13 = bVar.a();
                    TrackOutput2 trackOutput2P13 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P13;
                    trackOutput2P13.e(format2A13);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 10:
                    AvcConfig avcConfigB = AvcConfig.b(new ParsableByteArray(r0.a(r0.f1196b)));
                    list2 = avcConfigB.a;
                    r0.Y = avcConfigB.f986b;
                    str5 = avcConfigB.f;
                    str6 = "video/avc";
                    str8 = str5;
                    str14 = str6;
                    iR = -1;
                    i3 = -1;
                    list3 = list2;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i21114 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i21115 = i21114 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i21115;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A14 = bVar.a();
                    TrackOutput2 trackOutput2P14 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P14;
                    trackOutput2P14.e(format2A14);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 11:
                    str4 = "application/vobsub";
                    listU = ImmutableList2.u(r0.a(r0.f1196b));
                    str3 = str4;
                    list4 = listU;
                    str7 = null;
                    list5 = list4;
                    str = str7;
                    i2 = -1;
                    list7 = list5;
                    str14 = str3;
                    list6 = list7;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i21116 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i21117 = i21116 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i21117;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A15 = bVar.a();
                    TrackOutput2 trackOutput2P15 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P15;
                    trackOutput2P15.e(format2A15);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 12:
                    str13 = "audio/vnd.dts.hd";
                    str14 = str13;
                    str3 = str14;
                    list4 = null;
                    str7 = null;
                    list5 = list4;
                    str = str7;
                    i2 = -1;
                    list7 = list5;
                    str14 = str3;
                    list6 = list7;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i21118 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i21119 = i21118 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i21119;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A16 = bVar.a();
                    TrackOutput2 trackOutput2P16 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P16;
                    trackOutput2P16.e(format2A16);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 13:
                    List<byte[]> listSingletonList2 = Collections.singletonList(r0.a(r0.f1196b));
                    AacUtil.b bVarC = AacUtil.c(r0.k);
                    r0.Q = bVarC.a;
                    r0.O = bVarC.f1122b;
                    str7 = bVarC.c;
                    str3 = "audio/mp4a-latm";
                    list5 = listSingletonList2;
                    str = str7;
                    i2 = -1;
                    list7 = list5;
                    str14 = str3;
                    list6 = list7;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i211110 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211111 = i211110 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i211111;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A17 = bVar.a();
                    TrackOutput2 trackOutput2P17 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P17;
                    trackOutput2P17.e(format2A17);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 14:
                    str13 = "audio/ac3";
                    str14 = str13;
                    str3 = str14;
                    list4 = null;
                    str7 = null;
                    list5 = list4;
                    str = str7;
                    i2 = -1;
                    list7 = list5;
                    str14 = str3;
                    list6 = list7;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i211112 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211113 = i211112 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i211113;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A18 = bVar.a();
                    TrackOutput2 trackOutput2P18 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P18;
                    trackOutput2P18.e(format2A18);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 15:
                case 21:
                    str13 = "audio/vnd.dts";
                    str14 = str13;
                    str3 = str14;
                    list4 = null;
                    str7 = null;
                    list5 = list4;
                    str = str7;
                    i2 = -1;
                    list7 = list5;
                    str14 = str3;
                    list6 = list7;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i211114 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211115 = i211114 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i211115;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A19 = bVar.a();
                    TrackOutput2 trackOutput2P19 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P19;
                    trackOutput2P19.e(format2A19);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 16:
                    str13 = "video/av01";
                    str14 = str13;
                    str3 = str14;
                    list4 = null;
                    str7 = null;
                    list5 = list4;
                    str = str7;
                    i2 = -1;
                    list7 = list5;
                    str14 = str3;
                    list6 = list7;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i211116 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211117 = i211116 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i211117;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A110 = bVar.a();
                    TrackOutput2 trackOutput2P110 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P110;
                    trackOutput2P110.e(format2A110);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 17:
                    str13 = "video/x-vnd.on2.vp8";
                    str14 = str13;
                    str3 = str14;
                    list4 = null;
                    str7 = null;
                    list5 = list4;
                    str = str7;
                    i2 = -1;
                    list7 = list5;
                    str14 = str3;
                    list6 = list7;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i211118 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211119 = i211118 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i211119;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A111 = bVar.a();
                    TrackOutput2 trackOutput2P111 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P111;
                    trackOutput2P111.e(format2A111);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 18:
                    str13 = "video/x-vnd.on2.vp9";
                    str14 = str13;
                    str3 = str14;
                    list4 = null;
                    str7 = null;
                    list5 = list4;
                    str = str7;
                    i2 = -1;
                    list7 = list5;
                    str14 = str3;
                    list6 = list7;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i2111110 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i2111111 = i2111110 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i2111111;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A112 = bVar.a();
                    TrackOutput2 trackOutput2P112 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P112;
                    trackOutput2P112.e(format2A112);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 19:
                    str13 = "application/pgs";
                    str14 = str13;
                    str3 = str14;
                    list4 = null;
                    str7 = null;
                    list5 = list4;
                    str = str7;
                    i2 = -1;
                    list7 = list5;
                    str14 = str3;
                    list6 = list7;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i2111112 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i2111113 = i2111112 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i2111113;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A113 = bVar.a();
                    TrackOutput2 trackOutput2P113 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P113;
                    trackOutput2P113.e(format2A113);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 20:
                    str14 = str13;
                    str3 = str14;
                    list4 = null;
                    str7 = null;
                    list5 = list4;
                    str = str7;
                    i2 = -1;
                    list7 = list5;
                    str14 = str3;
                    list6 = list7;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i2111114 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i2111115 = i2111114 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i2111115;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A114 = bVar.a();
                    TrackOutput2 trackOutput2P114 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P114;
                    trackOutput2P114.e(format2A114);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 22:
                    int i40 = r0.P;
                    if (i40 == 32) {
                        iR = 4;
                        str14 = "audio/raw";
                        list3 = null;
                        i3 = -1;
                        str8 = null;
                        bArr = r0.N;
                        if (bArr != null) {
                            str8 = dolbyVisionConfigA.a;
                            str14 = "video/dolby-vision";
                        }
                        int i2111116 = r0.V | 0;
                        if (r0.U) {
                            i4 = 2;
                        } else {
                            i4 = 0;
                        }
                        int i2111117 = i2111116 | i4;
                        bVar = new Format2.b();
                        if (MimeTypes.h(str14)) {
                            bVar.f1023x = r0.O;
                            bVar.f1024y = r0.Q;
                            bVar.f1025z = iR;
                            i5 = 1;
                        } else if (MimeTypes.j(str14)) {
                            if (r0.q == 0) {
                                i10 = r0.o;
                                i6 = -1;
                                if (i10 == -1) {
                                    i10 = r0.m;
                                }
                                r0.o = i10;
                                i11 = r0.p;
                                if (i11 == -1) {
                                    i11 = r0.n;
                                }
                                r0.p = i11;
                            } else {
                                i6 = -1;
                            }
                            f = -1.0f;
                            i7 = r0.o;
                            if (i7 != i6) {
                                f = (r0.n * i7) / (r0.m * i9);
                            }
                            if (r0.f1198x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                            } else {
                                colorInfo = null;
                            }
                            str9 = r0.a;
                            if (str9 != null) {
                                map = e;
                                if (map.containsKey(str9)) {
                                    iIntValue = map.get(r0.a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i8 = iIntValue;
                            } else {
                                i8 = iIntValue;
                            }
                            bVar.p = r0.m;
                            bVar.q = r0.n;
                            bVar.t = f;
                            bVar.f1022s = i8;
                            bVar.u = r0.v;
                            bVar.v = r0.w;
                            bVar.w = colorInfo;
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str14)) {
                            }
                            i5 = 3;
                        }
                        str10 = r0.a;
                        if (str10 != null) {
                            bVar.f1021b = r0.a;
                        }
                        bVar.b(i24);
                        bVar.k = str14;
                        bVar.l = i3;
                        bVar.c = r0.W;
                        bVar.d = i2111117;
                        bVar.m = list3;
                        bVar.h = str8;
                        bVar.n = r0.l;
                        Format2 format2A115 = bVar.a();
                        TrackOutput2 trackOutput2P115 = extractorOutput2.p(r0.c, i5);
                        r0.X = trackOutput2P115;
                        trackOutput2P115.e(format2A115);
                        this.h.put(r0.c, (c) r0);
                    } else {
                        StringBuilder sb5 = new StringBuilder(90);
                        sb5.append("Unsupported floating point PCM bit depth: ");
                        sb5.append(i40);
                        sb5.append(". Setting mimeType to ");
                        sb5.append("audio/x-unknown");
                        Log.w("MatroskaExtractor", sb5.toString());
                        str3 = str14;
                        list4 = null;
                        str7 = null;
                        list5 = list4;
                        str = str7;
                        i2 = -1;
                        list7 = list5;
                        str14 = str3;
                        list6 = list7;
                        str8 = str;
                        i3 = i2;
                        list3 = list6;
                        iR = -1;
                        bArr = r0.N;
                        if (bArr != null) {
                            str8 = dolbyVisionConfigA.a;
                            str14 = "video/dolby-vision";
                        }
                        int i2111118 = r0.V | 0;
                        if (r0.U) {
                            i4 = 2;
                        } else {
                            i4 = 0;
                        }
                        int i2111119 = i2111118 | i4;
                        bVar = new Format2.b();
                        if (MimeTypes.h(str14)) {
                            bVar.f1023x = r0.O;
                            bVar.f1024y = r0.Q;
                            bVar.f1025z = iR;
                            i5 = 1;
                        } else if (MimeTypes.j(str14)) {
                            if (r0.q == 0) {
                                i10 = r0.o;
                                i6 = -1;
                                if (i10 == -1) {
                                    i10 = r0.m;
                                }
                                r0.o = i10;
                                i11 = r0.p;
                                if (i11 == -1) {
                                    i11 = r0.n;
                                }
                                r0.p = i11;
                            } else {
                                i6 = -1;
                            }
                            f = -1.0f;
                            i7 = r0.o;
                            if (i7 != i6) {
                                f = (r0.n * i7) / (r0.m * i9);
                            }
                            if (r0.f1198x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                            } else {
                                colorInfo = null;
                            }
                            str9 = r0.a;
                            if (str9 != null) {
                                map = e;
                                if (map.containsKey(str9)) {
                                    iIntValue = map.get(r0.a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i8 = iIntValue;
                            } else {
                                i8 = iIntValue;
                            }
                            bVar.p = r0.m;
                            bVar.q = r0.n;
                            bVar.t = f;
                            bVar.f1022s = i8;
                            bVar.u = r0.v;
                            bVar.v = r0.w;
                            bVar.w = colorInfo;
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str14)) {
                            }
                            i5 = 3;
                        }
                        str10 = r0.a;
                        if (str10 != null) {
                            bVar.f1021b = r0.a;
                        }
                        bVar.b(i24);
                        bVar.k = str14;
                        bVar.l = i3;
                        bVar.c = r0.W;
                        bVar.d = i2111119;
                        bVar.m = list3;
                        bVar.h = str8;
                        bVar.n = r0.l;
                        Format2 format2A116 = bVar.a();
                        TrackOutput2 trackOutput2P116 = extractorOutput2.p(r0.c, i5);
                        r0.X = trackOutput2P116;
                        trackOutput2P116.e(format2A116);
                        this.h.put(r0.c, (c) r0);
                    }
                    break;
                case 23:
                    int i41 = r0.P;
                    if (i41 == 8) {
                        iR = 3;
                    } else if (i41 != 16) {
                        StringBuilder sb6 = new StringBuilder(86);
                        sb6.append("Unsupported big endian PCM bit depth: ");
                        sb6.append(i41);
                        sb6.append(". Setting mimeType to ");
                        sb6.append("audio/x-unknown");
                        Log.w("MatroskaExtractor", sb6.toString());
                        str3 = str14;
                        list4 = null;
                        str7 = null;
                        list5 = list4;
                        str = str7;
                        i2 = -1;
                        list7 = list5;
                        str14 = str3;
                        list6 = list7;
                        str8 = str;
                        i3 = i2;
                        list3 = list6;
                        iR = -1;
                        bArr = r0.N;
                        if (bArr != null) {
                            str8 = dolbyVisionConfigA.a;
                            str14 = "video/dolby-vision";
                        }
                        int i21111110 = r0.V | 0;
                        if (r0.U) {
                            i4 = 2;
                        } else {
                            i4 = 0;
                        }
                        int i21111111 = i21111110 | i4;
                        bVar = new Format2.b();
                        if (MimeTypes.h(str14)) {
                            bVar.f1023x = r0.O;
                            bVar.f1024y = r0.Q;
                            bVar.f1025z = iR;
                            i5 = 1;
                        } else if (MimeTypes.j(str14)) {
                            if (r0.q == 0) {
                                i10 = r0.o;
                                i6 = -1;
                                if (i10 == -1) {
                                    i10 = r0.m;
                                }
                                r0.o = i10;
                                i11 = r0.p;
                                if (i11 == -1) {
                                    i11 = r0.n;
                                }
                                r0.p = i11;
                            } else {
                                i6 = -1;
                            }
                            f = -1.0f;
                            i7 = r0.o;
                            if (i7 != i6) {
                                f = (r0.n * i7) / (r0.m * i9);
                            }
                            if (r0.f1198x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                            } else {
                                colorInfo = null;
                            }
                            str9 = r0.a;
                            if (str9 != null) {
                                map = e;
                                if (map.containsKey(str9)) {
                                    iIntValue = map.get(r0.a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i8 = iIntValue;
                            } else {
                                i8 = iIntValue;
                            }
                            bVar.p = r0.m;
                            bVar.q = r0.n;
                            bVar.t = f;
                            bVar.f1022s = i8;
                            bVar.u = r0.v;
                            bVar.v = r0.w;
                            bVar.w = colorInfo;
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str14)) {
                            }
                            i5 = 3;
                        }
                        str10 = r0.a;
                        if (str10 != null) {
                            bVar.f1021b = r0.a;
                        }
                        bVar.b(i24);
                        bVar.k = str14;
                        bVar.l = i3;
                        bVar.c = r0.W;
                        bVar.d = i21111111;
                        bVar.m = list3;
                        bVar.h = str8;
                        bVar.n = r0.l;
                        Format2 format2A117 = bVar.a();
                        TrackOutput2 trackOutput2P117 = extractorOutput2.p(r0.c, i5);
                        r0.X = trackOutput2P117;
                        trackOutput2P117.e(format2A117);
                        this.h.put(r0.c, (c) r0);
                    } else {
                        iR = 268435456;
                    }
                    str14 = "audio/raw";
                    list3 = null;
                    i3 = -1;
                    str8 = null;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i21111112 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i21111113 = i21111112 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i21111113;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A118 = bVar.a();
                    TrackOutput2 trackOutput2P118 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P118;
                    trackOutput2P118.e(format2A118);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 24:
                    iR = Util2.r(r0.P);
                    if (iR == 0) {
                        int i42 = r0.P;
                        StringBuilder sb7 = new StringBuilder(89);
                        sb7.append("Unsupported little endian PCM bit depth: ");
                        sb7.append(i42);
                        sb7.append(". Setting mimeType to ");
                        sb7.append("audio/x-unknown");
                        Log.w("MatroskaExtractor", sb7.toString());
                        str3 = str14;
                        list4 = null;
                        str7 = null;
                        list5 = list4;
                        str = str7;
                        i2 = -1;
                        list7 = list5;
                        str14 = str3;
                        list6 = list7;
                        str8 = str;
                        i3 = i2;
                        list3 = list6;
                        iR = -1;
                        bArr = r0.N;
                        if (bArr != null) {
                            str8 = dolbyVisionConfigA.a;
                            str14 = "video/dolby-vision";
                        }
                        int i21111114 = r0.V | 0;
                        if (r0.U) {
                            i4 = 2;
                        } else {
                            i4 = 0;
                        }
                        int i21111115 = i21111114 | i4;
                        bVar = new Format2.b();
                        if (MimeTypes.h(str14)) {
                            bVar.f1023x = r0.O;
                            bVar.f1024y = r0.Q;
                            bVar.f1025z = iR;
                            i5 = 1;
                        } else if (MimeTypes.j(str14)) {
                            if (r0.q == 0) {
                                i10 = r0.o;
                                i6 = -1;
                                if (i10 == -1) {
                                    i10 = r0.m;
                                }
                                r0.o = i10;
                                i11 = r0.p;
                                if (i11 == -1) {
                                    i11 = r0.n;
                                }
                                r0.p = i11;
                            } else {
                                i6 = -1;
                            }
                            f = -1.0f;
                            i7 = r0.o;
                            if (i7 != i6) {
                                f = (r0.n * i7) / (r0.m * i9);
                            }
                            if (r0.f1198x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                            } else {
                                colorInfo = null;
                            }
                            str9 = r0.a;
                            if (str9 != null) {
                                map = e;
                                if (map.containsKey(str9)) {
                                    iIntValue = map.get(r0.a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i8 = iIntValue;
                            } else {
                                i8 = iIntValue;
                            }
                            bVar.p = r0.m;
                            bVar.q = r0.n;
                            bVar.t = f;
                            bVar.f1022s = i8;
                            bVar.u = r0.v;
                            bVar.v = r0.w;
                            bVar.w = colorInfo;
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str14)) {
                            }
                            i5 = 3;
                        }
                        str10 = r0.a;
                        if (str10 != null) {
                            bVar.f1021b = r0.a;
                        }
                        bVar.b(i24);
                        bVar.k = str14;
                        bVar.l = i3;
                        bVar.c = r0.W;
                        bVar.d = i21111115;
                        bVar.m = list3;
                        bVar.h = str8;
                        bVar.n = r0.l;
                        Format2 format2A119 = bVar.a();
                        TrackOutput2 trackOutput2P119 = extractorOutput2.p(r0.c, i5);
                        r0.X = trackOutput2P119;
                        trackOutput2P119.e(format2A119);
                        this.h.put(r0.c, (c) r0);
                    }
                    str14 = "audio/raw";
                    list3 = null;
                    i3 = -1;
                    str8 = null;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i21111116 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i21111117 = i21111116 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i21111117;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A1110 = bVar.a();
                    TrackOutput2 trackOutput2P1110 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P1110;
                    trackOutput2P1110.e(format2A1110);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 25:
                    byte[] bArr7 = f1185b;
                    byte[] bArrA3 = r0.a(r0.f1196b);
                    AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
                    Object[] objArr = {bArr7, bArrA3};
                    str4 = "text/x-ssa";
                    listU = ImmutableList2.m(objArr);
                    str3 = str4;
                    list4 = listU;
                    str7 = null;
                    list5 = list4;
                    str = str7;
                    i2 = -1;
                    list7 = list5;
                    str14 = str3;
                    list6 = list7;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i21111118 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i21111119 = i21111118 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i21111119;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A1111 = bVar.a();
                    TrackOutput2 trackOutput2P1111 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P1111;
                    trackOutput2P1111.e(format2A1111);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 26:
                    HevcConfig hevcConfigA = HevcConfig.a(new ParsableByteArray(r0.a(r0.f1196b)));
                    list2 = hevcConfigA.a;
                    r0.Y = hevcConfigA.f989b;
                    str5 = hevcConfigA.d;
                    str6 = "video/hevc";
                    str8 = str5;
                    str14 = str6;
                    iR = -1;
                    i3 = -1;
                    list3 = list2;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i211111110 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211111111 = i211111110 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i211111111;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A1112 = bVar.a();
                    TrackOutput2 trackOutput2P1112 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P1112;
                    trackOutput2P1112.e(format2A1112);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 27:
                    str13 = "application/x-subrip";
                    str14 = str13;
                    str3 = str14;
                    list4 = null;
                    str7 = null;
                    list5 = list4;
                    str = str7;
                    i2 = -1;
                    list7 = list5;
                    str14 = str3;
                    list6 = list7;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i211111112 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211111113 = i211111112 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i211111113;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A1113 = bVar.a();
                    TrackOutput2 trackOutput2P1113 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P1113;
                    trackOutput2P1113.e(format2A1113);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 28:
                    str13 = "video/mpeg2";
                    str14 = str13;
                    str3 = str14;
                    list4 = null;
                    str7 = null;
                    list5 = list4;
                    str = str7;
                    i2 = -1;
                    list7 = list5;
                    str14 = str3;
                    list6 = list7;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i211111114 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211111115 = i211111114 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i211111115;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A1114 = bVar.a();
                    TrackOutput2 trackOutput2P1114 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P1114;
                    trackOutput2P1114.e(format2A1114);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 29:
                    str13 = "audio/eac3";
                    str14 = str13;
                    str3 = str14;
                    list4 = null;
                    str7 = null;
                    list5 = list4;
                    str = str7;
                    i2 = -1;
                    list7 = list5;
                    str14 = str3;
                    list6 = list7;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i211111116 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211111117 = i211111116 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i211111117;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A1115 = bVar.a();
                    TrackOutput2 trackOutput2P1115 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P1115;
                    trackOutput2P1115.e(format2A1115);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 30:
                    str4 = "audio/flac";
                    listU = Collections.singletonList(r0.a(r0.f1196b));
                    str3 = str4;
                    list4 = listU;
                    str7 = null;
                    list5 = list4;
                    str = str7;
                    i2 = -1;
                    list7 = list5;
                    str14 = str3;
                    list6 = list7;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i211111118 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211111119 = i211111118 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i211111119;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A1116 = bVar.a();
                    TrackOutput2 trackOutput2P1116 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P1116;
                    trackOutput2P1116.e(format2A1116);
                    this.h.put(r0.c, (c) r0);
                    break;
                case 31:
                    ArrayList arrayList3 = new ArrayList(3);
                    arrayList3.add(r0.a(r0.f1196b));
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    arrayList3.add(byteBufferAllocate.order(byteOrder).putLong(r0.R).array());
                    arrayList3.add(ByteBuffer.allocate(8).order(byteOrder).putLong(r0.S).array());
                    i2 = 5760;
                    str3 = "audio/opus";
                    arrayList = arrayList3;
                    str = null;
                    list7 = arrayList;
                    str14 = str3;
                    list6 = list7;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iR = -1;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = dolbyVisionConfigA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i2111111110 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i2111111111 = i2111111110 | i4;
                    bVar = new Format2.b();
                    if (MimeTypes.h(str14)) {
                        bVar.f1023x = r0.O;
                        bVar.f1024y = r0.Q;
                        bVar.f1025z = iR;
                        i5 = 1;
                    } else if (MimeTypes.j(str14)) {
                        if (r0.q == 0) {
                            i10 = r0.o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.m;
                            }
                            r0.o = i10;
                            i11 = r0.p;
                            if (i11 == -1) {
                                i11 = r0.n;
                            }
                            r0.p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.o;
                        if (i7 != i6) {
                            f = (r0.n * i7) / (r0.m * i9);
                        }
                        if (r0.f1198x) {
                            if (r0.D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            colorInfo = new ColorInfo(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        str9 = r0.a;
                        if (str9 != null) {
                            map = e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.p = r0.m;
                        bVar.q = r0.n;
                        bVar.t = f;
                        bVar.f1022s = i8;
                        bVar.u = r0.v;
                        bVar.v = r0.w;
                        bVar.w = colorInfo;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        bVar.f1021b = r0.a;
                    }
                    bVar.b(i24);
                    bVar.k = str14;
                    bVar.l = i3;
                    bVar.c = r0.W;
                    bVar.d = i2111111111;
                    bVar.m = list3;
                    bVar.h = str8;
                    bVar.n = r0.l;
                    Format2 format2A1117 = bVar.a();
                    TrackOutput2 trackOutput2P1117 = extractorOutput2.p(r0.c, i5);
                    r0.X = trackOutput2P1117;
                    trackOutput2P1117.e(format2A1117);
                    this.h.put(r0.c, (c) r0);
                    break;
                default:
                    throw ParserException.a("Unrecognized codec identifier.", null);
            }
        }
        this.f1195z = null;
    }

    public final void k(ExtractorInput extractorInput, int i) throws IOException {
        ParsableByteArray parsableByteArray = this.l;
        if (parsableByteArray.c >= i) {
            return;
        }
        byte[] bArr = parsableByteArray.a;
        if (bArr.length < i) {
            parsableByteArray.b(Math.max(bArr.length * 2, i));
        }
        ParsableByteArray parsableByteArray2 = this.l;
        byte[] bArr2 = parsableByteArray2.a;
        int i2 = parsableByteArray2.c;
        extractorInput.readFully(bArr2, i2, i - i2);
        this.l.D(i);
    }

    public final void l() {
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = false;
        this.f1186a0 = false;
        this.f1187b0 = false;
        this.f1188c0 = 0;
        this.f1189d0 = (byte) 0;
        this.f1190e0 = false;
        this.o.A(0);
    }

    public final long m(long j) throws ParserException {
        long j2 = this.w;
        if (j2 != -9223372036854775807L) {
            return Util2.F(j, j2, 1000L);
        }
        throw ParserException.a("Can't scale timecode prior to timecodeScale being set.", null);
    }

    @RequiresNonNull({"#2.output"})
    public final int n(ExtractorInput extractorInput, c cVar, int i) throws IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(cVar.f1196b)) {
            o(extractorInput, a, i);
            int i3 = this.X;
            l();
            return i3;
        }
        if ("S_TEXT/ASS".equals(cVar.f1196b)) {
            o(extractorInput, c, i);
            int i4 = this.X;
            l();
            return i4;
        }
        TrackOutput2 trackOutput2 = cVar.X;
        if (!this.Z) {
            if (cVar.h) {
                this.T &= -1073741825;
                if (!this.f1186a0) {
                    extractorInput.readFully(this.l.a, 0, 1);
                    this.W++;
                    byte[] bArr = this.l.a;
                    if ((bArr[0] & 128) == 128) {
                        throw ParserException.a("Extension bit is set in signal byte", null);
                    }
                    this.f1189d0 = bArr[0];
                    this.f1186a0 = true;
                }
                byte b2 = this.f1189d0;
                if ((b2 & 1) == 1) {
                    boolean z2 = (b2 & 2) == 2;
                    this.T |= BasicMeasure.EXACTLY;
                    if (!this.f1190e0) {
                        extractorInput.readFully(this.q.a, 0, 8);
                        this.W += 8;
                        this.f1190e0 = true;
                        ParsableByteArray parsableByteArray = this.l;
                        parsableByteArray.a[0] = (byte) ((z2 ? 128 : 0) | 8);
                        parsableByteArray.E(0);
                        trackOutput2.f(this.l, 1, 1);
                        this.X++;
                        this.q.E(0);
                        trackOutput2.f(this.q, 8, 1);
                        this.X += 8;
                    }
                    if (z2) {
                        if (!this.f1187b0) {
                            extractorInput.readFully(this.l.a, 0, 1);
                            this.W++;
                            this.l.E(0);
                            this.f1188c0 = this.l.t();
                            this.f1187b0 = true;
                        }
                        int i5 = this.f1188c0 * 4;
                        this.l.A(i5);
                        extractorInput.readFully(this.l.a, 0, i5);
                        this.W += i5;
                        short s2 = (short) ((this.f1188c0 / 2) + 1);
                        int i6 = (s2 * 6) + 2;
                        ByteBuffer byteBuffer = this.t;
                        if (byteBuffer == null || byteBuffer.capacity() < i6) {
                            this.t = ByteBuffer.allocate(i6);
                        }
                        this.t.position(0);
                        this.t.putShort(s2);
                        int i7 = 0;
                        int i8 = 0;
                        while (true) {
                            i2 = this.f1188c0;
                            if (i7 >= i2) {
                                break;
                            }
                            int iW = this.l.w();
                            if (i7 % 2 == 0) {
                                this.t.putShort((short) (iW - i8));
                            } else {
                                this.t.putInt(iW - i8);
                            }
                            i7++;
                            i8 = iW;
                        }
                        int i9 = (i - this.W) - i8;
                        if (i2 % 2 == 1) {
                            this.t.putInt(i9);
                        } else {
                            this.t.putShort((short) i9);
                            this.t.putInt(0);
                        }
                        this.r.C(this.t.array(), i6);
                        trackOutput2.f(this.r, i6, 1);
                        this.X += i6;
                    }
                }
            } else {
                byte[] bArr2 = cVar.i;
                if (bArr2 != null) {
                    ParsableByteArray parsableByteArray2 = this.o;
                    int length = bArr2.length;
                    parsableByteArray2.a = bArr2;
                    parsableByteArray2.c = length;
                    parsableByteArray2.f984b = 0;
                }
            }
            if (cVar.f > 0) {
                this.T |= 268435456;
                this.f1192s.A(0);
                this.l.A(4);
                ParsableByteArray parsableByteArray3 = this.l;
                byte[] bArr3 = parsableByteArray3.a;
                bArr3[0] = (byte) ((i >> 24) & 255);
                bArr3[1] = (byte) ((i >> 16) & 255);
                bArr3[2] = (byte) ((i >> 8) & 255);
                bArr3[3] = (byte) (i & 255);
                trackOutput2.f(parsableByteArray3, 4, 2);
                this.X += 4;
            }
            this.Z = true;
        }
        int i10 = i + this.o.c;
        if (!"V_MPEG4/ISO/AVC".equals(cVar.f1196b) && !"V_MPEGH/ISO/HEVC".equals(cVar.f1196b)) {
            if (cVar.T != null) {
                AnimatableValueParser.D(this.o.c == 0);
                cVar.T.c(extractorInput);
            }
            while (true) {
                int i11 = this.W;
                if (i11 >= i10) {
                    break;
                }
                int iP = p(extractorInput, trackOutput2, i10 - i11);
                this.W += iP;
                this.X += iP;
            }
        } else {
            byte[] bArr4 = this.k.a;
            bArr4[0] = 0;
            bArr4[1] = 0;
            bArr4[2] = 0;
            int i12 = cVar.Y;
            int i13 = 4 - i12;
            while (this.W < i10) {
                int i14 = this.Y;
                if (i14 == 0) {
                    int iMin = Math.min(i12, this.o.a());
                    extractorInput.readFully(bArr4, i13 + iMin, i12 - iMin);
                    if (iMin > 0) {
                        ParsableByteArray parsableByteArray4 = this.o;
                        System.arraycopy(parsableByteArray4.a, parsableByteArray4.f984b, bArr4, i13, iMin);
                        parsableByteArray4.f984b += iMin;
                    }
                    this.W += i12;
                    this.k.E(0);
                    this.Y = this.k.w();
                    this.j.E(0);
                    trackOutput2.c(this.j, 4);
                    this.X += 4;
                } else {
                    int iP2 = p(extractorInput, trackOutput2, i14);
                    this.W += iP2;
                    this.X += iP2;
                    this.Y -= iP2;
                }
            }
        }
        if ("A_VORBIS".equals(cVar.f1196b)) {
            this.m.E(0);
            trackOutput2.c(this.m, 4);
            this.X += 4;
        }
        int i15 = this.X;
        l();
        return i15;
    }

    public final void o(ExtractorInput extractorInput, byte[] bArr, int i) throws IOException {
        int length = bArr.length + i;
        ParsableByteArray parsableByteArray = this.p;
        byte[] bArr2 = parsableByteArray.a;
        if (bArr2.length < length) {
            parsableByteArray.B(Arrays.copyOf(bArr, length + i));
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        extractorInput.readFully(this.p.a, bArr.length, i);
        this.p.E(0);
        this.p.D(length);
    }

    public final int p(ExtractorInput extractorInput, TrackOutput2 trackOutput2, int i) throws IOException {
        int iA = this.o.a();
        if (iA <= 0) {
            return trackOutput2.b(extractorInput, i, false);
        }
        int iMin = Math.min(i, iA);
        trackOutput2.c(this.o, iMin);
        return iMin;
    }

    @Override // b.i.a.c.x2.Extractor
    public final void release() {
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.g0.e$c */
    /* JADX INFO: compiled from: MatroskaExtractor.java */
    public static final class c {
        public byte[] N;
        public TrueHdSampleRechunker T;
        public boolean U;
        public TrackOutput2 X;
        public int Y;
        public String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f1196b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public byte[] i;
        public TrackOutput2.a j;
        public byte[] k;
        public DrmInitData l;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = 0;
        public int r = -1;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public float f1197s = 0.0f;
        public float t = 0.0f;
        public float u = 0.0f;
        public byte[] v = null;
        public int w = -1;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f1198x = false;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f1199y = -1;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f1200z = -1;
        public int A = -1;
        public int B = 1000;
        public int C = 200;
        public float D = -1.0f;
        public float E = -1.0f;
        public float F = -1.0f;
        public float G = -1.0f;
        public float H = -1.0f;
        public float I = -1.0f;
        public float J = -1.0f;
        public float K = -1.0f;
        public float L = -1.0f;
        public float M = -1.0f;
        public int O = 1;
        public int P = -1;
        public int Q = 8000;
        public long R = 0;
        public long S = 0;
        public boolean V = true;
        public String W = "eng";

        public c() {
        }

        @EnsuresNonNull({"codecPrivate"})
        public final byte[] a(String str) throws ParserException {
            byte[] bArr = this.k;
            if (bArr != null) {
                return bArr;
            }
            String strValueOf = String.valueOf(str);
            throw ParserException.a(strValueOf.length() != 0 ? "Missing CodecPrivate for codec ".concat(strValueOf) : new String("Missing CodecPrivate for codec "), null);
        }

        public c(a aVar) {
        }
    }
}

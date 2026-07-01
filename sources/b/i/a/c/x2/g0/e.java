package b.i.a.c.x2.g0;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.r;
import b.i.a.c.f3.u;
import b.i.a.c.f3.x;
import b.i.a.c.g3.m;
import b.i.a.c.g3.n;
import b.i.a.c.g3.o;
import b.i.a.c.g3.q;
import b.i.a.c.j1;
import b.i.a.c.j1$b;
import b.i.a.c.t2.l;
import b.i.a.c.t2.l$b;
import b.i.a.c.x0;
import b.i.a.c.x2.h;
import b.i.a.c.x2.i;
import b.i.a.c.x2.j;
import b.i.a.c.x2.s;
import b.i.a.c.x2.t;
import b.i.a.c.x2.t$b;
import b.i.a.c.x2.w;
import b.i.a.c.x2.w$a;
import b.i.b.b.p;
import com.discord.api.permission.Permission;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData$SchemeData;
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

/* JADX INFO: compiled from: MatroskaExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public class e implements h {
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
    public r H;

    @Nullable
    public r I;
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
    public final d f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public j f1191f0;
    public final g g;
    public final SparseArray<e$c> h;
    public final boolean i;
    public final x j;
    public final x k;
    public final x l;
    public final x m;
    public final x n;
    public final x o;
    public final x p;
    public final x q;
    public final x r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final x f1192s;
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
    public e$c f1195z;

    static {
        a aVar = a.a;
        a = new byte[]{49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
        f1185b = e0.w("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
        c = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        d = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        e = Collections.unmodifiableMap(map);
    }

    public e(int i) {
        b bVar = new b();
        this.v = -1L;
        this.w = -9223372036854775807L;
        this.f1193x = -9223372036854775807L;
        this.f1194y = -9223372036854775807L;
        this.E = -1L;
        this.F = -1L;
        this.G = -9223372036854775807L;
        this.f = bVar;
        bVar.d = new e$b(this, null);
        this.i = (i & 1) == 0;
        this.g = new g();
        this.h = new SparseArray<>();
        this.l = new x(4);
        this.m = new x(ByteBuffer.allocate(4).putInt(-1).array());
        this.n = new x(4);
        this.j = new x(u.a);
        this.k = new x(4);
        this.o = new x();
        this.p = new x();
        this.q = new x(8);
        this.r = new x();
        this.f1192s = new x();
        this.Q = new int[1];
    }

    public static int[] i(@Nullable int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return iArr.length >= i ? iArr : new int[Math.max(iArr.length * 2, i)];
    }

    public static byte[] j(long j, String str, long j2) {
        b.c.a.a0.d.j(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - (((long) (i * 3600)) * 1000000);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - (((long) (i2 * 60)) * 1000000);
        int i3 = (int) (j4 / 1000000);
        return e0.w(String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * 1000000)) / j2))));
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

    @Override // b.i.a.c.x2.h
    public final boolean b(i iVar) throws IOException {
        f fVar = new f();
        long jB = iVar.b();
        long j = Permission.VIEW_CHANNEL;
        if (jB != -1 && jB <= Permission.VIEW_CHANNEL) {
            j = jB;
        }
        int i = (int) j;
        iVar.o(fVar.a.a, 0, 4);
        fVar.f1201b = 4;
        for (long jU = fVar.a.u(); jU != 440786851; jU = ((jU << 8) & (-256)) | ((long) (fVar.a.a[0] & 255))) {
            int i2 = fVar.f1201b + 1;
            fVar.f1201b = i2;
            if (i2 == i) {
                return false;
            }
            iVar.o(fVar.a.a, 0, 1);
        }
        long jA = fVar.a(iVar);
        long j2 = fVar.f1201b;
        if (jA == Long.MIN_VALUE) {
            return false;
        }
        if (jB != -1 && j2 + jA >= jB) {
            return false;
        }
        while (true) {
            long j3 = fVar.f1201b;
            long j4 = j2 + jA;
            if (j3 >= j4) {
                return j3 == j4;
            }
            if (fVar.a(iVar) == Long.MIN_VALUE) {
                return false;
            }
            long jA2 = fVar.a(iVar);
            if (jA2 < 0 || jA2 > 2147483647L) {
                return false;
            }
            if (jA2 != 0) {
                int i3 = (int) jA2;
                iVar.g(i3);
                fVar.f1201b += i3;
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
    public final void d(e$c e_c, long j, int i, int i2, int i3) {
        byte[] bArrJ;
        int i4;
        b.i.a.c.x2.x xVar = e_c.T;
        if (xVar != null) {
            xVar.b(e_c.X, j, i, i2, i3, e_c.j);
        } else {
            if ("S_TEXT/UTF8".equals(e_c.f1196b) || "S_TEXT/ASS".equals(e_c.f1196b)) {
                if (this.P > 1) {
                    Log.w("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j2 = this.N;
                    if (j2 == -9223372036854775807L) {
                        Log.w("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        String str = e_c.f1196b;
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
                            x xVar2 = this.p;
                            if (i5 >= xVar2.c) {
                                break;
                            }
                            if (xVar2.a[i5] == 0) {
                                xVar2.D(i5);
                                break;
                            }
                            i5++;
                        }
                        w wVar = e_c.X;
                        x xVar3 = this.p;
                        wVar.c(xVar3, xVar3.c);
                        i2 += this.p.c;
                    }
                }
            }
            if ((268435456 & i) != 0) {
                if (this.P > 1) {
                    i &= -268435457;
                } else {
                    x xVar4 = this.f1192s;
                    int i6 = xVar4.c;
                    e_c.X.f(xVar4, i6, 2);
                    i2 += i6;
                }
            }
            e_c.X.d(j, i, i2, i3, e_c.j);
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
    @Override // b.i.a.c.x2.h
    public final int e(i iVar, s sVar) throws IOException {
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
            b bVar = (b) this.f;
            b.c.a.a0.d.H(bVar.d);
            boolean z6 = z3;
            boolean z7 = z4;
            while (true) {
                b$b b_bPeek = bVar.f1183b.peek();
                if (b_bPeek == null || iVar.getPosition() < b_bPeek.f1184b) {
                    if (bVar.e == 0) {
                        long jC = bVar.c.c(iVar, z7, z6, 4);
                        if (jC == -2) {
                            iVar.k();
                            while (true) {
                                iVar.o(bVar.a, z6 ? 1 : 0, 4);
                                int iB = g.b(bVar.a[z6 ? 1 : 0]);
                                if (iB != -1 && iB <= 4) {
                                    int iA = (int) g.a(bVar.a, iB, z6);
                                    Objects.requireNonNull(((e$b) bVar.d).a);
                                    if (iA == 357149030 || iA == 524531317 || iA == 475249515 || iA == 374648427) {
                                        iVar.l(iB);
                                        jC = iA;
                                    }
                                }
                                iVar.l(z7 ? 1 : 0);
                            }
                        }
                        if (jC == -1) {
                            z5 = false;
                        } else {
                            bVar.f = (int) jC;
                            bVar.e = z7 ? 1 : 0;
                        }
                    }
                    if (bVar.e == z7) {
                        bVar.g = bVar.c.c(iVar, z6, z7, 8);
                        bVar.e = 2;
                    }
                    c cVar = bVar.d;
                    int i4 = bVar.f;
                    Objects.requireNonNull(((e$b) cVar).a);
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
                        iVar.l((int) bVar.g);
                        z6 = false;
                        bVar.e = 0;
                        z7 = true;
                    } else if (i == z7) {
                        long position = iVar.getPosition();
                        bVar.f1183b.push(new b$b(bVar.f, bVar.g + position, null));
                        c cVar2 = bVar.d;
                        int i5 = bVar.f;
                        long j2 = bVar.g;
                        e eVar = ((e$b) cVar2).a;
                        b.c.a.a0.d.H(eVar.f1191f0);
                        if (i5 == 160) {
                            i2 = 0;
                            eVar.V = false;
                        } else if (i5 == 174) {
                            i2 = 0;
                            eVar.f1195z = new e$c(null);
                        } else if (i5 != 187) {
                            if (i5 == 19899) {
                                eVar.B = -1;
                                eVar.C = -1L;
                            } else if (i5 == 20533) {
                                eVar.c(i5);
                                eVar.f1195z.h = true;
                            } else if (i5 == 21968) {
                                eVar.c(i5);
                                eVar.f1195z.f1198x = true;
                            } else if (i5 == 408125543) {
                                long j3 = eVar.v;
                                if (j3 != -1 && j3 != position) {
                                    throw ParserException.a("Multiple Segment elements not supported", null);
                                }
                                eVar.v = position;
                                eVar.u = j2;
                            } else if (i5 == 475249515) {
                                eVar.H = new r();
                                eVar.I = new r();
                            } else if (i5 == 524531317 && !eVar.A) {
                                if (!eVar.i || eVar.E == -1) {
                                    eVar.f1191f0.a(new t$b(eVar.f1194y, 0L));
                                    eVar.A = true;
                                } else {
                                    eVar.D = true;
                                }
                            }
                            i2 = 0;
                        } else {
                            i2 = 0;
                            eVar.J = false;
                        }
                        bVar.e = i2;
                    } else if (i == 2) {
                        long j4 = bVar.g;
                        if (j4 > 8) {
                            StringBuilder sb = new StringBuilder(42);
                            sb.append("Invalid integer size: ");
                            sb.append(j4);
                            throw ParserException.a(sb.toString(), null);
                        }
                        c cVar3 = bVar.d;
                        int i6 = bVar.f;
                        long jA = bVar.a(iVar, (int) j4);
                        e eVar2 = ((e$b) cVar3).a;
                        Objects.requireNonNull(eVar2);
                        if (i6 != 20529) {
                            if (i6 != 20530) {
                                switch (i6) {
                                    case Opcodes.LXOR /* 131 */:
                                        eVar2.c(i6);
                                        eVar2.f1195z.d = (int) jA;
                                        break;
                                    case Opcodes.L2I /* 136 */:
                                        eVar2.c(i6);
                                        eVar2.f1195z.V = jA == 1;
                                        break;
                                    case 155:
                                        eVar2.N = eVar2.m(jA);
                                        break;
                                    case Opcodes.IF_ICMPEQ /* 159 */:
                                        eVar2.c(i6);
                                        eVar2.f1195z.O = (int) jA;
                                        break;
                                    case Opcodes.ARETURN /* 176 */:
                                        eVar2.c(i6);
                                        eVar2.f1195z.m = (int) jA;
                                        break;
                                    case Opcodes.PUTSTATIC /* 179 */:
                                        eVar2.a(i6);
                                        eVar2.H.a(eVar2.m(jA));
                                        break;
                                    case Opcodes.INVOKEDYNAMIC /* 186 */:
                                        eVar2.c(i6);
                                        eVar2.f1195z.n = (int) jA;
                                        break;
                                    case 215:
                                        eVar2.c(i6);
                                        eVar2.f1195z.c = (int) jA;
                                        break;
                                    case 231:
                                        eVar2.G = eVar2.m(jA);
                                        break;
                                    case 238:
                                        eVar2.U = (int) jA;
                                        break;
                                    case 241:
                                        if (!eVar2.J) {
                                            eVar2.a(i6);
                                            eVar2.I.a(jA);
                                            eVar2.J = true;
                                        }
                                        break;
                                    case 251:
                                        eVar2.V = true;
                                        break;
                                    case 16871:
                                        eVar2.c(i6);
                                        eVar2.f1195z.g = (int) jA;
                                        break;
                                    case 16980:
                                        if (jA != 3) {
                                            throw ParserException.a(b.d.b.a.a.i(50, "ContentCompAlgo ", jA, " not supported"), null);
                                        }
                                        break;
                                    case 17029:
                                        if (jA < 1 || jA > 2) {
                                            throw ParserException.a(b.d.b.a.a.i(53, "DocTypeReadVersion ", jA, " not supported"), null);
                                        }
                                        break;
                                    case 17143:
                                        if (jA != 1) {
                                            throw ParserException.a(b.d.b.a.a.i(50, "EBMLReadVersion ", jA, " not supported"), null);
                                        }
                                        break;
                                    case 18401:
                                        if (jA != 5) {
                                            throw ParserException.a(b.d.b.a.a.i(49, "ContentEncAlgo ", jA, " not supported"), null);
                                        }
                                        break;
                                    case 18408:
                                        if (jA != 1) {
                                            throw ParserException.a(b.d.b.a.a.i(56, "AESSettingsCipherMode ", jA, " not supported"), null);
                                        }
                                        break;
                                    case 21420:
                                        eVar2.C = jA + eVar2.v;
                                        break;
                                    case 21432:
                                        int i7 = (int) jA;
                                        eVar2.c(i6);
                                        if (i7 == 0) {
                                            eVar2.f1195z.w = 0;
                                        } else if (i7 == 1) {
                                            eVar2.f1195z.w = 2;
                                        } else if (i7 == 3) {
                                            eVar2.f1195z.w = 1;
                                        } else if (i7 == 15) {
                                            eVar2.f1195z.w = 3;
                                        }
                                        break;
                                    case 21680:
                                        eVar2.c(i6);
                                        eVar2.f1195z.o = (int) jA;
                                        break;
                                    case 21682:
                                        eVar2.c(i6);
                                        eVar2.f1195z.q = (int) jA;
                                        break;
                                    case 21690:
                                        eVar2.c(i6);
                                        eVar2.f1195z.p = (int) jA;
                                        break;
                                    case 21930:
                                        eVar2.c(i6);
                                        eVar2.f1195z.U = jA == 1;
                                        break;
                                    case 21998:
                                        eVar2.c(i6);
                                        eVar2.f1195z.f = (int) jA;
                                        break;
                                    case 22186:
                                        eVar2.c(i6);
                                        eVar2.f1195z.R = jA;
                                        break;
                                    case 22203:
                                        eVar2.c(i6);
                                        eVar2.f1195z.S = jA;
                                        break;
                                    case 25188:
                                        eVar2.c(i6);
                                        eVar2.f1195z.P = (int) jA;
                                        break;
                                    case 30321:
                                        eVar2.c(i6);
                                        int i8 = (int) jA;
                                        if (i8 == 0) {
                                            eVar2.f1195z.r = 0;
                                        } else if (i8 == 1) {
                                            eVar2.f1195z.r = 1;
                                        } else if (i8 == 2) {
                                            eVar2.f1195z.r = 2;
                                        } else if (i8 == 3) {
                                            eVar2.f1195z.r = 3;
                                        }
                                        break;
                                    case 2352003:
                                        eVar2.c(i6);
                                        eVar2.f1195z.e = (int) jA;
                                        break;
                                    case 2807729:
                                        eVar2.w = jA;
                                        break;
                                    default:
                                        switch (i6) {
                                            case 21945:
                                                eVar2.c(i6);
                                                int i9 = (int) jA;
                                                if (i9 == 1) {
                                                    eVar2.f1195z.A = 2;
                                                } else if (i9 == 2) {
                                                    eVar2.f1195z.A = 1;
                                                }
                                                break;
                                            case 21946:
                                                eVar2.c(i6);
                                                int iB2 = n.b((int) jA);
                                                if (iB2 != -1) {
                                                    eVar2.f1195z.f1200z = iB2;
                                                }
                                                break;
                                            case 21947:
                                                eVar2.c(i6);
                                                eVar2.f1195z.f1198x = true;
                                                int iA2 = n.a((int) jA);
                                                if (iA2 != -1) {
                                                    eVar2.f1195z.f1199y = iA2;
                                                }
                                                break;
                                            case 21948:
                                                eVar2.c(i6);
                                                eVar2.f1195z.B = (int) jA;
                                                break;
                                            case 21949:
                                                eVar2.c(i6);
                                                eVar2.f1195z.C = (int) jA;
                                                break;
                                        }
                                        break;
                                }
                            } else if (jA != 1) {
                                throw ParserException.a(b.d.b.a.a.i(55, "ContentEncodingScope ", jA, " not supported"), null);
                            }
                        } else if (jA != 0) {
                            throw ParserException.a(b.d.b.a.a.i(55, "ContentEncodingOrder ", jA, " not supported"), null);
                        }
                        bVar.e = 0;
                    } else if (i == 3) {
                        long j5 = bVar.g;
                        if (j5 > 2147483647L) {
                            StringBuilder sb2 = new StringBuilder(41);
                            sb2.append("String element size: ");
                            sb2.append(j5);
                            throw ParserException.a(sb2.toString(), null);
                        }
                        c cVar4 = bVar.d;
                        int i10 = bVar.f;
                        int i11 = (int) j5;
                        if (i11 == 0) {
                            str = "";
                        } else {
                            byte[] bArr = new byte[i11];
                            iVar.readFully(bArr, 0, i11);
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
                        e eVar3 = ((e$b) cVar4).a;
                        Objects.requireNonNull(eVar3);
                        if (i10 == 134) {
                            eVar3.c(i10);
                            eVar3.f1195z.f1196b = str;
                        } else if (i10 != 17026) {
                            if (i10 == 21358) {
                                eVar3.c(i10);
                                eVar3.f1195z.a = str;
                            } else if (i10 == 2274716) {
                                eVar3.c(i10);
                                eVar3.f1195z.W = str;
                            }
                        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
                            StringBuilder sb3 = new StringBuilder(str.length() + 22);
                            sb3.append("DocType ");
                            sb3.append(str);
                            sb3.append(" not supported");
                            throw ParserException.a(sb3.toString(), null);
                        }
                        bVar.e = 0;
                    } else if (i == 4) {
                        c cVar5 = bVar.d;
                        int i13 = bVar.f;
                        int i14 = (int) bVar.g;
                        e eVar4 = ((e$b) cVar5).a;
                        Objects.requireNonNull(eVar4);
                        if (i13 == 161 || i13 == 163) {
                            if (eVar4.L == 0) {
                                eVar4.R = (int) eVar4.g.c(iVar, z6, z7, 8);
                                eVar4.S = eVar4.g.d;
                                eVar4.N = -9223372036854775807L;
                                eVar4.L = z7 ? 1 : 0;
                                eVar4.l.A(z6 ? 1 : 0);
                            }
                            e$c e_c = eVar4.h.get(eVar4.R);
                            if (e_c == null) {
                                iVar.l(i14 - eVar4.S);
                                eVar4.L = z6 ? 1 : 0;
                            } else {
                                Objects.requireNonNull(e_c.X);
                                if (eVar4.L == z7) {
                                    eVar4.k(iVar, 3);
                                    int i15 = (eVar4.l.a[2] & 6) >> (z7 ? 1 : 0);
                                    byte b2 = 255;
                                    if (i15 == 0) {
                                        eVar4.P = z7 ? 1 : 0;
                                        int[] iArrI = i(eVar4.Q, z7 ? 1 : 0);
                                        eVar4.Q = iArrI;
                                        iArrI[z6 ? 1 : 0] = (i14 - eVar4.S) - 3;
                                    } else {
                                        eVar4.k(iVar, 4);
                                        int i16 = (eVar4.l.a[3] & 255) + (z7 ? 1 : 0);
                                        eVar4.P = i16;
                                        int[] iArrI2 = i(eVar4.Q, i16);
                                        eVar4.Q = iArrI2;
                                        if (i15 == 2) {
                                            int i17 = (i14 - eVar4.S) - 4;
                                            int i18 = eVar4.P;
                                            Arrays.fill(iArrI2, z6 ? 1 : 0, i18, i17 / i18);
                                        } else {
                                            int i19 = 4;
                                            if (i15 == z7) {
                                                int i20 = 0;
                                                int i21 = 0;
                                                while (true) {
                                                    int i22 = eVar4.P;
                                                    if (i20 < i22 - 1) {
                                                        eVar4.Q[i20] = z6 ? 1 : 0;
                                                        do {
                                                            i19 += z7 ? 1 : 0;
                                                            eVar4.k(iVar, i19);
                                                            i3 = eVar4.l.a[i19 - 1] & 255;
                                                            iArr = eVar4.Q;
                                                            iArr[i20] = iArr[i20] + i3;
                                                        } while (i3 == 255);
                                                        i21 += iArr[i20];
                                                        i20++;
                                                    } else {
                                                        eVar4.Q[i22 - 1] = ((i14 - eVar4.S) - i19) - i21;
                                                    }
                                                }
                                            } else {
                                                if (i15 != 3) {
                                                    throw b.d.b.a.a.w0(36, "Unexpected lacing value: ", i15, null);
                                                }
                                                int i23 = 0;
                                                int i24 = 0;
                                                ?? r3 = z6;
                                                boolean z8 = z7;
                                                while (true) {
                                                    int i25 = eVar4.P;
                                                    if (i23 < i25 - 1) {
                                                        eVar4.Q[i23] = r3;
                                                        i19++;
                                                        eVar4.k(iVar, i19);
                                                        int i26 = i19 - 1;
                                                        if (eVar4.l.a[i26] == 0) {
                                                            throw ParserException.a("No valid varint length mask found", null);
                                                        }
                                                        int i27 = 8;
                                                        int i28 = 0;
                                                        while (true) {
                                                            if (i28 < i27) {
                                                                int i29 = r4 << (7 - i28);
                                                                if ((eVar4.l.a[i26] & i29) != 0) {
                                                                    r4 = z8;
                                                                    int i30 = i19 + i28;
                                                                    eVar4.k(iVar, i30);
                                                                    j = (~i29) & eVar4.l.a[i26] & b2;
                                                                    int i31 = i26 + 1;
                                                                    while (i31 < i30) {
                                                                        j = (j << 8) | ((long) (eVar4.l.a[i31] & 255));
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
                                                        int[] iArr2 = eVar4.Q;
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
                                                        eVar4.Q[i25 - 1] = ((i14 - eVar4.S) - i19) - i24;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    byte[] bArr2 = eVar4.l.a;
                                    eVar4.M = eVar4.m((bArr2[1] & 255) | (bArr2[0] << 8)) + eVar4.G;
                                    eVar4.T = (e_c.d == 2 || (i13 == 163 && (eVar4.l.a[2] & 128) == 128)) ? 1 : 0;
                                    eVar4.L = 2;
                                    eVar4.O = 0;
                                }
                                if (i13 == 163) {
                                    while (true) {
                                        int i34 = eVar4.O;
                                        if (i34 < eVar4.P) {
                                            eVar4.d(e_c, ((long) ((eVar4.O * e_c.e) / 1000)) + eVar4.M, eVar4.T, eVar4.n(iVar, e_c, eVar4.Q[i34]), 0);
                                            eVar4.O++;
                                        } else {
                                            eVar4.L = 0;
                                        }
                                    }
                                } else {
                                    while (true) {
                                        int i35 = eVar4.O;
                                        if (i35 < eVar4.P) {
                                            int[] iArr3 = eVar4.Q;
                                            iArr3[i35] = eVar4.n(iVar, e_c, iArr3[i35]);
                                            eVar4.O++;
                                        }
                                    }
                                }
                            }
                        } else if (i13 != 165) {
                            if (i13 == 16877) {
                                eVar4.c(i13);
                                e$c e_c2 = eVar4.f1195z;
                                int i36 = e_c2.g;
                                if (i36 == 1685485123 || i36 == 1685480259) {
                                    byte[] bArr3 = new byte[i14];
                                    e_c2.N = bArr3;
                                    iVar.readFully(bArr3, z6 ? 1 : 0, i14);
                                } else {
                                    iVar.l(i14);
                                }
                            } else if (i13 == 16981) {
                                eVar4.c(i13);
                                byte[] bArr4 = new byte[i14];
                                eVar4.f1195z.i = bArr4;
                                iVar.readFully(bArr4, z6 ? 1 : 0, i14);
                            } else if (i13 == 18402) {
                                byte[] bArr5 = new byte[i14];
                                iVar.readFully(bArr5, z6 ? 1 : 0, i14);
                                eVar4.c(i13);
                                eVar4.f1195z.j = new w$a(z7 ? 1 : 0, bArr5, z6 ? 1 : 0, z6 ? 1 : 0);
                            } else if (i13 == 21419) {
                                Arrays.fill(eVar4.n.a, z6 ? (byte) 1 : (byte) 0);
                                iVar.readFully(eVar4.n.a, 4 - i14, i14);
                                eVar4.n.E(z6 ? 1 : 0);
                                eVar4.B = (int) eVar4.n.u();
                            } else if (i13 == 25506) {
                                eVar4.c(i13);
                                byte[] bArr6 = new byte[i14];
                                eVar4.f1195z.k = bArr6;
                                iVar.readFully(bArr6, z6 ? 1 : 0, i14);
                            } else {
                                if (i13 != 30322) {
                                    throw b.d.b.a.a.w0(26, "Unexpected id: ", i13, null);
                                }
                                eVar4.c(i13);
                                byte[] bArr7 = new byte[i14];
                                eVar4.f1195z.v = bArr7;
                                iVar.readFully(bArr7, z6 ? 1 : 0, i14);
                            }
                        } else if (eVar4.L == 2) {
                            e$c e_c3 = eVar4.h.get(eVar4.R);
                            if (eVar4.U == 4 && "V_VP9".equals(e_c3.f1196b)) {
                                x xVar = eVar4.f1192s;
                                byte[] bArr8 = xVar.a;
                                if (bArr8.length < i14) {
                                    bArr8 = new byte[i14];
                                }
                                xVar.C(bArr8, i14);
                                iVar.readFully(eVar4.f1192s.a, z6 ? 1 : 0, i14);
                            } else {
                                iVar.l(i14);
                            }
                        }
                        bVar.e = 0;
                    } else {
                        if (i != 5) {
                            throw b.d.b.a.a.w0(32, "Invalid element type ", i, null);
                        }
                        long j6 = bVar.g;
                        if (j6 != 4 && j6 != 8) {
                            StringBuilder sb4 = new StringBuilder(40);
                            sb4.append("Invalid float size: ");
                            sb4.append(j6);
                            throw ParserException.a(sb4.toString(), null);
                        }
                        c cVar6 = bVar.d;
                        int i37 = bVar.f;
                        int i38 = (int) j6;
                        long jA2 = bVar.a(iVar, i38);
                        double dIntBitsToFloat = i38 == 4 ? Float.intBitsToFloat((int) jA2) : Double.longBitsToDouble(jA2);
                        e eVar5 = ((e$b) cVar6).a;
                        Objects.requireNonNull(eVar5);
                        if (i37 == 181) {
                            eVar5.c(i37);
                            eVar5.f1195z.Q = (int) dIntBitsToFloat;
                        } else if (i37 != 17545) {
                            switch (i37) {
                                case 21969:
                                    eVar5.c(i37);
                                    eVar5.f1195z.D = (float) dIntBitsToFloat;
                                    break;
                                case 21970:
                                    eVar5.c(i37);
                                    eVar5.f1195z.E = (float) dIntBitsToFloat;
                                    break;
                                case 21971:
                                    eVar5.c(i37);
                                    eVar5.f1195z.F = (float) dIntBitsToFloat;
                                    break;
                                case 21972:
                                    eVar5.c(i37);
                                    eVar5.f1195z.G = (float) dIntBitsToFloat;
                                    break;
                                case 21973:
                                    eVar5.c(i37);
                                    eVar5.f1195z.H = (float) dIntBitsToFloat;
                                    break;
                                case 21974:
                                    eVar5.c(i37);
                                    eVar5.f1195z.I = (float) dIntBitsToFloat;
                                    break;
                                case 21975:
                                    eVar5.c(i37);
                                    eVar5.f1195z.J = (float) dIntBitsToFloat;
                                    break;
                                case 21976:
                                    eVar5.c(i37);
                                    eVar5.f1195z.K = (float) dIntBitsToFloat;
                                    break;
                                case 21977:
                                    eVar5.c(i37);
                                    eVar5.f1195z.L = (float) dIntBitsToFloat;
                                    break;
                                case 21978:
                                    eVar5.c(i37);
                                    eVar5.f1195z.M = (float) dIntBitsToFloat;
                                    break;
                                default:
                                    switch (i37) {
                                        case 30323:
                                            eVar5.c(i37);
                                            eVar5.f1195z.f1197s = (float) dIntBitsToFloat;
                                            break;
                                        case 30324:
                                            eVar5.c(i37);
                                            eVar5.f1195z.t = (float) dIntBitsToFloat;
                                            break;
                                        case 30325:
                                            eVar5.c(i37);
                                            eVar5.f1195z.u = (float) dIntBitsToFloat;
                                            break;
                                    }
                                    break;
                            }
                        } else {
                            eVar5.f1193x = (long) dIntBitsToFloat;
                        }
                        bVar.e = z6 ? 1 : 0;
                    }
                } else {
                    ((e$b) bVar.d).a.h(bVar.f1183b.pop().a);
                }
                z5 = true;
            }
            if (z5) {
                long position2 = iVar.getPosition();
                if (this.D) {
                    this.F = position2;
                    sVar.a = this.E;
                    this.D = false;
                } else {
                    if (this.A) {
                        long j7 = this.F;
                        if (j7 != -1) {
                            sVar.a = j7;
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
            e$c e_cValueAt = this.h.valueAt(i39);
            Objects.requireNonNull(e_cValueAt.X);
            b.i.a.c.x2.x xVar2 = e_cValueAt.T;
            if (xVar2 != null) {
                xVar2.a(e_cValueAt.X, e_cValueAt.j);
            }
        }
        return -1;
    }

    @Override // b.i.a.c.x2.h
    public final void f(j jVar) {
        this.f1191f0 = jVar;
    }

    @Override // b.i.a.c.x2.h
    @CallSuper
    public void g(long j, long j2) {
        this.G = -9223372036854775807L;
        this.L = 0;
        b bVar = (b) this.f;
        bVar.e = 0;
        bVar.f1183b.clear();
        g gVar = bVar.c;
        gVar.c = 0;
        gVar.d = 0;
        g gVar2 = this.g;
        gVar2.c = 0;
        gVar2.d = 0;
        l();
        for (int i = 0; i < this.h.size(); i++) {
            b.i.a.c.x2.x xVar = this.h.valueAt(i).T;
            if (xVar != null) {
                xVar.f1300b = false;
                xVar.c = 0;
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
        j1$b j1_b;
        int i5;
        int i6;
        float f;
        int i7;
        n nVar;
        String str9;
        int iIntValue;
        int i8;
        Map<String, Integer> map;
        byte[] bArr2;
        int i9;
        int i10;
        int i11;
        String str10;
        o oVarA;
        List<byte[]> list6;
        List<byte[]> list7;
        t t_b;
        int i12;
        int i13;
        b.c.a.a0.d.H(this.f1191f0);
        int i14 = 0;
        if (i == 160) {
            if (this.L != 2) {
                return;
            }
            int i15 = 0;
            for (int i16 = 0; i16 < this.P; i16++) {
                i15 += this.Q[i16];
            }
            e$c e_c = this.h.get(this.R);
            Objects.requireNonNull(e_c.X);
            int i17 = 0;
            while (i17 < this.P) {
                long j = this.M + ((long) ((e_c.e * i17) / 1000));
                int i18 = this.T;
                if (i17 == 0 && !this.V) {
                    i18 |= 1;
                }
                int i19 = this.Q[i17];
                int i20 = i15 - i19;
                d(e_c, j, i18, i19, i20);
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
                e$c e_c2 = this.f1195z;
                if (e_c2.h) {
                    w$a w_a = e_c2.j;
                    if (w_a == null) {
                        throw ParserException.a("Encrypted Track found but ContentEncKeyID was not found", null);
                    }
                    e_c2.l = new DrmInitData(null, true, new DrmInitData$SchemeData(x0.a, "video/webm", w_a.f1299b));
                    return;
                }
                return;
            }
            if (i == 28032) {
                c(i);
                e$c e_c3 = this.f1195z;
                if (e_c3.h && e_c3.i != null) {
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
                j jVar = this.f1191f0;
                r rVar = this.H;
                r rVar2 = this.I;
                if (this.v == -1 || this.f1194y == -9223372036854775807L || rVar == null || (i12 = rVar.a) == 0 || rVar2 == null || rVar2.a != i12) {
                    t_b = new t$b(this.f1194y, 0L);
                } else {
                    int[] iArrCopyOf = new int[i12];
                    long[] jArrCopyOf = new long[i12];
                    long[] jArrCopyOf2 = new long[i12];
                    long[] jArrCopyOf3 = new long[i12];
                    for (int i22 = 0; i22 < i12; i22++) {
                        jArrCopyOf3[i22] = rVar.b(i22);
                        jArrCopyOf[i22] = rVar2.b(i22) + this.v;
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
                    t_b = new b.i.a.c.x2.c(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
                }
                jVar.a(t_b);
                this.A = true;
            }
            this.H = null;
            this.I = null;
            return;
        }
        ?? r0 = this.f1195z;
        b.c.a.a0.d.H(r0);
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
            j jVar2 = this.f1191f0;
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
                    if (bArr != null && (oVarA = o.a(new x(bArr))) != null) {
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i25 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i26 = i25 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14) && !"text/x-ssa".equals(str14) && !"application/vobsub".equals(str14) && !"application/pgs".equals(str14) && !"application/dvbsubs".equals(str14)) {
                            throw ParserException.a("Unexpected MIME type.", null);
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null && !e.containsKey(str10)) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i26;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA = j1_b.a();
                    w wVarP = jVar2.p(r0.c, i5);
                    r0.X = wVarP;
                    wVarP.e(j1VarA);
                    this.h.put(r0.c, (e$c) r0);
                    break;
                case 2:
                    x xVar = new x(r0.a(r0.f1196b));
                    try {
                        int iL = xVar.l();
                        if (iL != 1) {
                            if (iL == 65534) {
                                xVar.E(24);
                                long jM = xVar.m();
                                UUID uuid = d;
                                if (jM != uuid.getMostSignificantBits() || xVar.m() != uuid.getLeastSignificantBits()) {
                                }
                                if (z3) {
                                    iR = e0.r(r0.P);
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
                                        str8 = oVarA.a;
                                        str14 = "video/dolby-vision";
                                    }
                                    int i28 = r0.V | 0;
                                    if (r0.U) {
                                        i4 = 2;
                                    } else {
                                        i4 = 0;
                                    }
                                    int i29 = i28 | i4;
                                    j1_b = new j1$b();
                                    if (b.i.a.c.f3.t.h(str14)) {
                                        j1_b.f1023x = r0.O;
                                        j1_b.f1024y = r0.Q;
                                        j1_b.f1025z = iR;
                                        i5 = 1;
                                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                                        } else {
                                            nVar = null;
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
                                        j1_b.p = r0.m;
                                        j1_b.q = r0.n;
                                        j1_b.t = f;
                                        j1_b.f1022s = i8;
                                        j1_b.u = r0.v;
                                        j1_b.v = r0.w;
                                        j1_b.w = nVar;
                                        i5 = 2;
                                    } else {
                                        if ("application/x-subrip".equals(str14)) {
                                        }
                                        i5 = 3;
                                    }
                                    str10 = r0.a;
                                    if (str10 != null) {
                                        j1_b.f1021b = r0.a;
                                    }
                                    j1_b.b(i24);
                                    j1_b.k = str14;
                                    j1_b.l = i3;
                                    j1_b.c = r0.W;
                                    j1_b.d = i29;
                                    j1_b.m = list3;
                                    j1_b.h = str8;
                                    j1_b.n = r0.l;
                                    j1 j1VarA2 = j1_b.a();
                                    w wVarP2 = jVar2.p(r0.c, i5);
                                    r0.X = wVarP2;
                                    wVarP2.e(j1VarA2);
                                    this.h.put(r0.c, (e$c) r0);
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
                                    str8 = oVarA.a;
                                    str14 = "video/dolby-vision";
                                }
                                int i210 = r0.V | 0;
                                if (r0.U) {
                                    i4 = 2;
                                } else {
                                    i4 = 0;
                                }
                                int i211 = i210 | i4;
                                j1_b = new j1$b();
                                if (b.i.a.c.f3.t.h(str14)) {
                                    j1_b.f1023x = r0.O;
                                    j1_b.f1024y = r0.Q;
                                    j1_b.f1025z = iR;
                                    i5 = 1;
                                } else if (b.i.a.c.f3.t.j(str14)) {
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
                                        nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                                    } else {
                                        nVar = null;
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
                                    j1_b.p = r0.m;
                                    j1_b.q = r0.n;
                                    j1_b.t = f;
                                    j1_b.f1022s = i8;
                                    j1_b.u = r0.v;
                                    j1_b.v = r0.w;
                                    j1_b.w = nVar;
                                    i5 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str14)) {
                                    }
                                    i5 = 3;
                                }
                                str10 = r0.a;
                                if (str10 != null) {
                                    j1_b.f1021b = r0.a;
                                }
                                j1_b.b(i24);
                                j1_b.k = str14;
                                j1_b.l = i3;
                                j1_b.c = r0.W;
                                j1_b.d = i211;
                                j1_b.m = list3;
                                j1_b.h = str8;
                                j1_b.n = r0.l;
                                j1 j1VarA3 = j1_b.a();
                                w wVarP3 = jVar2.p(r0.c, i5);
                                r0.X = wVarP3;
                                wVarP3.e(j1VarA3);
                                this.h.put(r0.c, (e$c) r0);
                            }
                            z3 = false;
                            if (z3) {
                                iR = e0.r(r0.P);
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
                                    str8 = oVarA.a;
                                    str14 = "video/dolby-vision";
                                }
                                int i213 = r0.V | 0;
                                if (r0.U) {
                                    i4 = 2;
                                } else {
                                    i4 = 0;
                                }
                                int i214 = i213 | i4;
                                j1_b = new j1$b();
                                if (b.i.a.c.f3.t.h(str14)) {
                                    j1_b.f1023x = r0.O;
                                    j1_b.f1024y = r0.Q;
                                    j1_b.f1025z = iR;
                                    i5 = 1;
                                } else if (b.i.a.c.f3.t.j(str14)) {
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
                                        nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                                    } else {
                                        nVar = null;
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
                                    j1_b.p = r0.m;
                                    j1_b.q = r0.n;
                                    j1_b.t = f;
                                    j1_b.f1022s = i8;
                                    j1_b.u = r0.v;
                                    j1_b.v = r0.w;
                                    j1_b.w = nVar;
                                    i5 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str14)) {
                                    }
                                    i5 = 3;
                                }
                                str10 = r0.a;
                                if (str10 != null) {
                                    j1_b.f1021b = r0.a;
                                }
                                j1_b.b(i24);
                                j1_b.k = str14;
                                j1_b.l = i3;
                                j1_b.c = r0.W;
                                j1_b.d = i214;
                                j1_b.m = list3;
                                j1_b.h = str8;
                                j1_b.n = r0.l;
                                j1 j1VarA4 = j1_b.a();
                                w wVarP4 = jVar2.p(r0.c, i5);
                                r0.X = wVarP4;
                                wVarP4.e(j1VarA4);
                                this.h.put(r0.c, (e$c) r0);
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
                                str8 = oVarA.a;
                                str14 = "video/dolby-vision";
                            }
                            int i215 = r0.V | 0;
                            if (r0.U) {
                                i4 = 2;
                            } else {
                                i4 = 0;
                            }
                            int i216 = i215 | i4;
                            j1_b = new j1$b();
                            if (b.i.a.c.f3.t.h(str14)) {
                                j1_b.f1023x = r0.O;
                                j1_b.f1024y = r0.Q;
                                j1_b.f1025z = iR;
                                i5 = 1;
                            } else if (b.i.a.c.f3.t.j(str14)) {
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
                                    nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                                } else {
                                    nVar = null;
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
                                j1_b.p = r0.m;
                                j1_b.q = r0.n;
                                j1_b.t = f;
                                j1_b.f1022s = i8;
                                j1_b.u = r0.v;
                                j1_b.v = r0.w;
                                j1_b.w = nVar;
                                i5 = 2;
                            } else {
                                if ("application/x-subrip".equals(str14)) {
                                }
                                i5 = 3;
                            }
                            str10 = r0.a;
                            if (str10 != null) {
                                j1_b.f1021b = r0.a;
                            }
                            j1_b.b(i24);
                            j1_b.k = str14;
                            j1_b.l = i3;
                            j1_b.c = r0.W;
                            j1_b.d = i216;
                            j1_b.m = list3;
                            j1_b.h = str8;
                            j1_b.n = r0.l;
                            j1 j1VarA5 = j1_b.a();
                            w wVarP5 = jVar2.p(r0.c, i5);
                            r0.X = wVarP5;
                            wVarP5.e(j1VarA5);
                            this.h.put(r0.c, (e$c) r0);
                            break;
                        }
                        z3 = true;
                        if (z3) {
                            iR = e0.r(r0.P);
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
                                str8 = oVarA.a;
                                str14 = "video/dolby-vision";
                            }
                            int i218 = r0.V | 0;
                            if (r0.U) {
                                i4 = 2;
                            } else {
                                i4 = 0;
                            }
                            int i219 = i218 | i4;
                            j1_b = new j1$b();
                            if (b.i.a.c.f3.t.h(str14)) {
                                j1_b.f1023x = r0.O;
                                j1_b.f1024y = r0.Q;
                                j1_b.f1025z = iR;
                                i5 = 1;
                            } else if (b.i.a.c.f3.t.j(str14)) {
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
                                    nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                                } else {
                                    nVar = null;
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
                                j1_b.p = r0.m;
                                j1_b.q = r0.n;
                                j1_b.t = f;
                                j1_b.f1022s = i8;
                                j1_b.u = r0.v;
                                j1_b.v = r0.w;
                                j1_b.w = nVar;
                                i5 = 2;
                            } else {
                                if ("application/x-subrip".equals(str14)) {
                                }
                                i5 = 3;
                            }
                            str10 = r0.a;
                            if (str10 != null) {
                                j1_b.f1021b = r0.a;
                            }
                            j1_b.b(i24);
                            j1_b.k = str14;
                            j1_b.l = i3;
                            j1_b.c = r0.W;
                            j1_b.d = i219;
                            j1_b.m = list3;
                            j1_b.h = str8;
                            j1_b.n = r0.l;
                            j1 j1VarA6 = j1_b.a();
                            w wVarP6 = jVar2.p(r0.c, i5);
                            r0.X = wVarP6;
                            wVarP6.e(j1VarA6);
                            this.h.put(r0.c, (e$c) r0);
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
                            str8 = oVarA.a;
                            str14 = "video/dolby-vision";
                        }
                        int i2110 = r0.V | 0;
                        if (r0.U) {
                            i4 = 2;
                        } else {
                            i4 = 0;
                        }
                        int i2111 = i2110 | i4;
                        j1_b = new j1$b();
                        if (b.i.a.c.f3.t.h(str14)) {
                            j1_b.f1023x = r0.O;
                            j1_b.f1024y = r0.Q;
                            j1_b.f1025z = iR;
                            i5 = 1;
                        } else if (b.i.a.c.f3.t.j(str14)) {
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
                                nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                            } else {
                                nVar = null;
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
                            j1_b.p = r0.m;
                            j1_b.q = r0.n;
                            j1_b.t = f;
                            j1_b.f1022s = i8;
                            j1_b.u = r0.v;
                            j1_b.v = r0.w;
                            j1_b.w = nVar;
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str14)) {
                            }
                            i5 = 3;
                        }
                        str10 = r0.a;
                        if (str10 != null) {
                            j1_b.f1021b = r0.a;
                        }
                        j1_b.b(i24);
                        j1_b.k = str14;
                        j1_b.l = i3;
                        j1_b.c = r0.W;
                        j1_b.d = i2111;
                        j1_b.m = list3;
                        j1_b.h = str8;
                        j1_b.n = r0.l;
                        j1 j1VarA7 = j1_b.a();
                        w wVarP7 = jVar2.p(r0.c, i5);
                        r0.X = wVarP7;
                        wVarP7.e(j1VarA7);
                        this.h.put(r0.c, (e$c) r0);
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw ParserException.a("Error parsing MS/ACM codec private", null);
                    }
                    break;
                case 3:
                    r0.T = new b.i.a.c.x2.x();
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
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i2112 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i2113 = i2112 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i2113;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA8 = j1_b.a();
                    w wVarP8 = jVar2.p(r0.c, i5);
                    r0.X = wVarP8;
                    wVarP8.e(j1VarA8);
                    this.h.put(r0.c, (e$c) r0);
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
                                str8 = oVarA.a;
                                str14 = "video/dolby-vision";
                            }
                            int i2114 = r0.V | 0;
                            if (r0.U) {
                                i4 = 2;
                            } else {
                                i4 = 0;
                            }
                            int i2115 = i2114 | i4;
                            j1_b = new j1$b();
                            if (b.i.a.c.f3.t.h(str14)) {
                                j1_b.f1023x = r0.O;
                                j1_b.f1024y = r0.Q;
                                j1_b.f1025z = iR;
                                i5 = 1;
                            } else if (b.i.a.c.f3.t.j(str14)) {
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
                                    nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                                } else {
                                    nVar = null;
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
                                j1_b.p = r0.m;
                                j1_b.q = r0.n;
                                j1_b.t = f;
                                j1_b.f1022s = i8;
                                j1_b.u = r0.v;
                                j1_b.v = r0.w;
                                j1_b.w = nVar;
                                i5 = 2;
                            } else {
                                if ("application/x-subrip".equals(str14)) {
                                }
                                i5 = 3;
                            }
                            str10 = r0.a;
                            if (str10 != null) {
                                j1_b.f1021b = r0.a;
                            }
                            j1_b.b(i24);
                            j1_b.k = str14;
                            j1_b.l = i3;
                            j1_b.c = r0.W;
                            j1_b.d = i2115;
                            j1_b.m = list3;
                            j1_b.h = str8;
                            j1_b.n = r0.l;
                            j1 j1VarA9 = j1_b.a();
                            w wVarP9 = jVar2.p(r0.c, i5);
                            r0.X = wVarP9;
                            wVarP9.e(j1VarA9);
                            this.h.put(r0.c, (e$c) r0);
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
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i2116 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i2117 = i2116 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i2117;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA10 = j1_b.a();
                    w wVarP10 = jVar2.p(r0.c, i5);
                    r0.X = wVarP10;
                    wVarP10.e(j1VarA10);
                    this.h.put(r0.c, (e$c) r0);
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
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i2118 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i2119 = i2118 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i2119;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA11 = j1_b.a();
                    w wVarP11 = jVar2.p(r0.c, i5);
                    r0.X = wVarP11;
                    wVarP11.e(j1VarA11);
                    this.h.put(r0.c, (e$c) r0);
                    break;
                case 7:
                    byte[] bArrA2 = r0.a(r0.f1196b);
                    try {
                        b.c.a.a0.d.j(16 <= bArrA2.length);
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
                            str8 = oVarA.a;
                            str14 = "video/dolby-vision";
                        }
                        int i21110 = r0.V | 0;
                        if (r0.U) {
                            i4 = 2;
                        } else {
                            i4 = 0;
                        }
                        int i21111 = i21110 | i4;
                        j1_b = new j1$b();
                        if (b.i.a.c.f3.t.h(str14)) {
                            j1_b.f1023x = r0.O;
                            j1_b.f1024y = r0.Q;
                            j1_b.f1025z = iR;
                            i5 = 1;
                        } else if (b.i.a.c.f3.t.j(str14)) {
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
                                nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                            } else {
                                nVar = null;
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
                            j1_b.p = r0.m;
                            j1_b.q = r0.n;
                            j1_b.t = f;
                            j1_b.f1022s = i8;
                            j1_b.u = r0.v;
                            j1_b.v = r0.w;
                            j1_b.w = nVar;
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str14)) {
                            }
                            i5 = 3;
                        }
                        str10 = r0.a;
                        if (str10 != null) {
                            j1_b.f1021b = r0.a;
                        }
                        j1_b.b(i24);
                        j1_b.k = str14;
                        j1_b.l = i3;
                        j1_b.c = r0.W;
                        j1_b.d = i21111;
                        j1_b.m = list3;
                        j1_b.h = str8;
                        j1_b.n = r0.l;
                        j1 j1VarA12 = j1_b.a();
                        w wVarP12 = jVar2.p(r0.c, i5);
                        r0.X = wVarP12;
                        wVarP12.e(j1VarA12);
                        this.h.put(r0.c, (e$c) r0);
                    } catch (ArrayIndexOutOfBoundsException unused4) {
                        throw ParserException.a("Error parsing FourCC private data", null);
                    }
                    break;
                case 8:
                    byte[] bArr6 = new byte[4];
                    System.arraycopy(r0.a(r0.f1196b), 0, bArr6, 0, 4);
                    p pVarU = p.u(bArr6);
                    str4 = "application/dvbsubs";
                    listU = pVarU;
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
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i21112 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i21113 = i21112 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i21113;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA13 = j1_b.a();
                    w wVarP13 = jVar2.p(r0.c, i5);
                    r0.X = wVarP13;
                    wVarP13.e(j1VarA13);
                    this.h.put(r0.c, (e$c) r0);
                    break;
                case 10:
                    m mVarB = m.b(new x(r0.a(r0.f1196b)));
                    list2 = mVarB.a;
                    r0.Y = mVarB.f986b;
                    str5 = mVarB.f;
                    str6 = "video/avc";
                    str8 = str5;
                    str14 = str6;
                    iR = -1;
                    i3 = -1;
                    list3 = list2;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i21114 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i21115 = i21114 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i21115;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA14 = j1_b.a();
                    w wVarP14 = jVar2.p(r0.c, i5);
                    r0.X = wVarP14;
                    wVarP14.e(j1VarA14);
                    this.h.put(r0.c, (e$c) r0);
                    break;
                case 11:
                    str4 = "application/vobsub";
                    listU = p.u(r0.a(r0.f1196b));
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
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i21116 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i21117 = i21116 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i21117;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA15 = j1_b.a();
                    w wVarP15 = jVar2.p(r0.c, i5);
                    r0.X = wVarP15;
                    wVarP15.e(j1VarA15);
                    this.h.put(r0.c, (e$c) r0);
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
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i21118 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i21119 = i21118 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i21119;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA16 = j1_b.a();
                    w wVarP16 = jVar2.p(r0.c, i5);
                    r0.X = wVarP16;
                    wVarP16.e(j1VarA16);
                    this.h.put(r0.c, (e$c) r0);
                    break;
                case 13:
                    List<byte[]> listSingletonList2 = Collections.singletonList(r0.a(r0.f1196b));
                    l$b l_bC = l.c(r0.k);
                    r0.Q = l_bC.a;
                    r0.O = l_bC.f1122b;
                    str7 = l_bC.c;
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
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i211110 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211111 = i211110 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i211111;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA17 = j1_b.a();
                    w wVarP17 = jVar2.p(r0.c, i5);
                    r0.X = wVarP17;
                    wVarP17.e(j1VarA17);
                    this.h.put(r0.c, (e$c) r0);
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
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i211112 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211113 = i211112 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i211113;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA18 = j1_b.a();
                    w wVarP18 = jVar2.p(r0.c, i5);
                    r0.X = wVarP18;
                    wVarP18.e(j1VarA18);
                    this.h.put(r0.c, (e$c) r0);
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
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i211114 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211115 = i211114 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i211115;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA19 = j1_b.a();
                    w wVarP19 = jVar2.p(r0.c, i5);
                    r0.X = wVarP19;
                    wVarP19.e(j1VarA19);
                    this.h.put(r0.c, (e$c) r0);
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
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i211116 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211117 = i211116 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i211117;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA110 = j1_b.a();
                    w wVarP110 = jVar2.p(r0.c, i5);
                    r0.X = wVarP110;
                    wVarP110.e(j1VarA110);
                    this.h.put(r0.c, (e$c) r0);
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
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i211118 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211119 = i211118 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i211119;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA111 = j1_b.a();
                    w wVarP111 = jVar2.p(r0.c, i5);
                    r0.X = wVarP111;
                    wVarP111.e(j1VarA111);
                    this.h.put(r0.c, (e$c) r0);
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
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i2111110 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i2111111 = i2111110 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i2111111;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA112 = j1_b.a();
                    w wVarP112 = jVar2.p(r0.c, i5);
                    r0.X = wVarP112;
                    wVarP112.e(j1VarA112);
                    this.h.put(r0.c, (e$c) r0);
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
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i2111112 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i2111113 = i2111112 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i2111113;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA113 = j1_b.a();
                    w wVarP113 = jVar2.p(r0.c, i5);
                    r0.X = wVarP113;
                    wVarP113.e(j1VarA113);
                    this.h.put(r0.c, (e$c) r0);
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
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i2111114 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i2111115 = i2111114 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i2111115;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA114 = j1_b.a();
                    w wVarP114 = jVar2.p(r0.c, i5);
                    r0.X = wVarP114;
                    wVarP114.e(j1VarA114);
                    this.h.put(r0.c, (e$c) r0);
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
                            str8 = oVarA.a;
                            str14 = "video/dolby-vision";
                        }
                        int i2111116 = r0.V | 0;
                        if (r0.U) {
                            i4 = 2;
                        } else {
                            i4 = 0;
                        }
                        int i2111117 = i2111116 | i4;
                        j1_b = new j1$b();
                        if (b.i.a.c.f3.t.h(str14)) {
                            j1_b.f1023x = r0.O;
                            j1_b.f1024y = r0.Q;
                            j1_b.f1025z = iR;
                            i5 = 1;
                        } else if (b.i.a.c.f3.t.j(str14)) {
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
                                nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                            } else {
                                nVar = null;
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
                            j1_b.p = r0.m;
                            j1_b.q = r0.n;
                            j1_b.t = f;
                            j1_b.f1022s = i8;
                            j1_b.u = r0.v;
                            j1_b.v = r0.w;
                            j1_b.w = nVar;
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str14)) {
                            }
                            i5 = 3;
                        }
                        str10 = r0.a;
                        if (str10 != null) {
                            j1_b.f1021b = r0.a;
                        }
                        j1_b.b(i24);
                        j1_b.k = str14;
                        j1_b.l = i3;
                        j1_b.c = r0.W;
                        j1_b.d = i2111117;
                        j1_b.m = list3;
                        j1_b.h = str8;
                        j1_b.n = r0.l;
                        j1 j1VarA115 = j1_b.a();
                        w wVarP115 = jVar2.p(r0.c, i5);
                        r0.X = wVarP115;
                        wVarP115.e(j1VarA115);
                        this.h.put(r0.c, (e$c) r0);
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
                            str8 = oVarA.a;
                            str14 = "video/dolby-vision";
                        }
                        int i2111118 = r0.V | 0;
                        if (r0.U) {
                            i4 = 2;
                        } else {
                            i4 = 0;
                        }
                        int i2111119 = i2111118 | i4;
                        j1_b = new j1$b();
                        if (b.i.a.c.f3.t.h(str14)) {
                            j1_b.f1023x = r0.O;
                            j1_b.f1024y = r0.Q;
                            j1_b.f1025z = iR;
                            i5 = 1;
                        } else if (b.i.a.c.f3.t.j(str14)) {
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
                                nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                            } else {
                                nVar = null;
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
                            j1_b.p = r0.m;
                            j1_b.q = r0.n;
                            j1_b.t = f;
                            j1_b.f1022s = i8;
                            j1_b.u = r0.v;
                            j1_b.v = r0.w;
                            j1_b.w = nVar;
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str14)) {
                            }
                            i5 = 3;
                        }
                        str10 = r0.a;
                        if (str10 != null) {
                            j1_b.f1021b = r0.a;
                        }
                        j1_b.b(i24);
                        j1_b.k = str14;
                        j1_b.l = i3;
                        j1_b.c = r0.W;
                        j1_b.d = i2111119;
                        j1_b.m = list3;
                        j1_b.h = str8;
                        j1_b.n = r0.l;
                        j1 j1VarA116 = j1_b.a();
                        w wVarP116 = jVar2.p(r0.c, i5);
                        r0.X = wVarP116;
                        wVarP116.e(j1VarA116);
                        this.h.put(r0.c, (e$c) r0);
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
                            str8 = oVarA.a;
                            str14 = "video/dolby-vision";
                        }
                        int i21111110 = r0.V | 0;
                        if (r0.U) {
                            i4 = 2;
                        } else {
                            i4 = 0;
                        }
                        int i21111111 = i21111110 | i4;
                        j1_b = new j1$b();
                        if (b.i.a.c.f3.t.h(str14)) {
                            j1_b.f1023x = r0.O;
                            j1_b.f1024y = r0.Q;
                            j1_b.f1025z = iR;
                            i5 = 1;
                        } else if (b.i.a.c.f3.t.j(str14)) {
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
                                nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                            } else {
                                nVar = null;
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
                            j1_b.p = r0.m;
                            j1_b.q = r0.n;
                            j1_b.t = f;
                            j1_b.f1022s = i8;
                            j1_b.u = r0.v;
                            j1_b.v = r0.w;
                            j1_b.w = nVar;
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str14)) {
                            }
                            i5 = 3;
                        }
                        str10 = r0.a;
                        if (str10 != null) {
                            j1_b.f1021b = r0.a;
                        }
                        j1_b.b(i24);
                        j1_b.k = str14;
                        j1_b.l = i3;
                        j1_b.c = r0.W;
                        j1_b.d = i21111111;
                        j1_b.m = list3;
                        j1_b.h = str8;
                        j1_b.n = r0.l;
                        j1 j1VarA117 = j1_b.a();
                        w wVarP117 = jVar2.p(r0.c, i5);
                        r0.X = wVarP117;
                        wVarP117.e(j1VarA117);
                        this.h.put(r0.c, (e$c) r0);
                    } else {
                        iR = 268435456;
                    }
                    str14 = "audio/raw";
                    list3 = null;
                    i3 = -1;
                    str8 = null;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i21111112 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i21111113 = i21111112 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i21111113;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA118 = j1_b.a();
                    w wVarP118 = jVar2.p(r0.c, i5);
                    r0.X = wVarP118;
                    wVarP118.e(j1VarA118);
                    this.h.put(r0.c, (e$c) r0);
                    break;
                case 24:
                    iR = e0.r(r0.P);
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
                            str8 = oVarA.a;
                            str14 = "video/dolby-vision";
                        }
                        int i21111114 = r0.V | 0;
                        if (r0.U) {
                            i4 = 2;
                        } else {
                            i4 = 0;
                        }
                        int i21111115 = i21111114 | i4;
                        j1_b = new j1$b();
                        if (b.i.a.c.f3.t.h(str14)) {
                            j1_b.f1023x = r0.O;
                            j1_b.f1024y = r0.Q;
                            j1_b.f1025z = iR;
                            i5 = 1;
                        } else if (b.i.a.c.f3.t.j(str14)) {
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
                                nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                            } else {
                                nVar = null;
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
                            j1_b.p = r0.m;
                            j1_b.q = r0.n;
                            j1_b.t = f;
                            j1_b.f1022s = i8;
                            j1_b.u = r0.v;
                            j1_b.v = r0.w;
                            j1_b.w = nVar;
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str14)) {
                            }
                            i5 = 3;
                        }
                        str10 = r0.a;
                        if (str10 != null) {
                            j1_b.f1021b = r0.a;
                        }
                        j1_b.b(i24);
                        j1_b.k = str14;
                        j1_b.l = i3;
                        j1_b.c = r0.W;
                        j1_b.d = i21111115;
                        j1_b.m = list3;
                        j1_b.h = str8;
                        j1_b.n = r0.l;
                        j1 j1VarA119 = j1_b.a();
                        w wVarP119 = jVar2.p(r0.c, i5);
                        r0.X = wVarP119;
                        wVarP119.e(j1VarA119);
                        this.h.put(r0.c, (e$c) r0);
                    }
                    str14 = "audio/raw";
                    list3 = null;
                    i3 = -1;
                    str8 = null;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i21111116 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i21111117 = i21111116 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i21111117;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA1110 = j1_b.a();
                    w wVarP1110 = jVar2.p(r0.c, i5);
                    r0.X = wVarP1110;
                    wVarP1110.e(j1VarA1110);
                    this.h.put(r0.c, (e$c) r0);
                    break;
                case 25:
                    byte[] bArr7 = f1185b;
                    byte[] bArrA3 = r0.a(r0.f1196b);
                    b.i.b.b.a<Object> aVar = p.k;
                    Object[] objArr = {bArr7, bArrA3};
                    str4 = "text/x-ssa";
                    listU = p.m(objArr);
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
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i21111118 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i21111119 = i21111118 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i21111119;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA1111 = j1_b.a();
                    w wVarP1111 = jVar2.p(r0.c, i5);
                    r0.X = wVarP1111;
                    wVarP1111.e(j1VarA1111);
                    this.h.put(r0.c, (e$c) r0);
                    break;
                case 26:
                    q qVarA = q.a(new x(r0.a(r0.f1196b)));
                    list2 = qVarA.a;
                    r0.Y = qVarA.f989b;
                    str5 = qVarA.d;
                    str6 = "video/hevc";
                    str8 = str5;
                    str14 = str6;
                    iR = -1;
                    i3 = -1;
                    list3 = list2;
                    bArr = r0.N;
                    if (bArr != null) {
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i211111110 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211111111 = i211111110 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i211111111;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA1112 = j1_b.a();
                    w wVarP1112 = jVar2.p(r0.c, i5);
                    r0.X = wVarP1112;
                    wVarP1112.e(j1VarA1112);
                    this.h.put(r0.c, (e$c) r0);
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
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i211111112 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211111113 = i211111112 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i211111113;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA1113 = j1_b.a();
                    w wVarP1113 = jVar2.p(r0.c, i5);
                    r0.X = wVarP1113;
                    wVarP1113.e(j1VarA1113);
                    this.h.put(r0.c, (e$c) r0);
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
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i211111114 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211111115 = i211111114 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i211111115;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA1114 = j1_b.a();
                    w wVarP1114 = jVar2.p(r0.c, i5);
                    r0.X = wVarP1114;
                    wVarP1114.e(j1VarA1114);
                    this.h.put(r0.c, (e$c) r0);
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
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i211111116 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211111117 = i211111116 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i211111117;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA1115 = j1_b.a();
                    w wVarP1115 = jVar2.p(r0.c, i5);
                    r0.X = wVarP1115;
                    wVarP1115.e(j1VarA1115);
                    this.h.put(r0.c, (e$c) r0);
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
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i211111118 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211111119 = i211111118 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i211111119;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA1116 = j1_b.a();
                    w wVarP1116 = jVar2.p(r0.c, i5);
                    r0.X = wVarP1116;
                    wVarP1116.e(j1VarA1116);
                    this.h.put(r0.c, (e$c) r0);
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
                        str8 = oVarA.a;
                        str14 = "video/dolby-vision";
                    }
                    int i2111111110 = r0.V | 0;
                    if (r0.U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i2111111111 = i2111111110 | i4;
                    j1_b = new j1$b();
                    if (b.i.a.c.f3.t.h(str14)) {
                        j1_b.f1023x = r0.O;
                        j1_b.f1024y = r0.Q;
                        j1_b.f1025z = iR;
                        i5 = 1;
                    } else if (b.i.a.c.f3.t.j(str14)) {
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
                            nVar = new n(r0.f1199y, r0.A, r0.f1200z, bArr2);
                        } else {
                            nVar = null;
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
                        j1_b.p = r0.m;
                        j1_b.q = r0.n;
                        j1_b.t = f;
                        j1_b.f1022s = i8;
                        j1_b.u = r0.v;
                        j1_b.v = r0.w;
                        j1_b.w = nVar;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.a;
                    if (str10 != null) {
                        j1_b.f1021b = r0.a;
                    }
                    j1_b.b(i24);
                    j1_b.k = str14;
                    j1_b.l = i3;
                    j1_b.c = r0.W;
                    j1_b.d = i2111111111;
                    j1_b.m = list3;
                    j1_b.h = str8;
                    j1_b.n = r0.l;
                    j1 j1VarA1117 = j1_b.a();
                    w wVarP1117 = jVar2.p(r0.c, i5);
                    r0.X = wVarP1117;
                    wVarP1117.e(j1VarA1117);
                    this.h.put(r0.c, (e$c) r0);
                    break;
                default:
                    throw ParserException.a("Unrecognized codec identifier.", null);
            }
        }
        this.f1195z = null;
    }

    public final void k(i iVar, int i) throws IOException {
        x xVar = this.l;
        if (xVar.c >= i) {
            return;
        }
        byte[] bArr = xVar.a;
        if (bArr.length < i) {
            xVar.b(Math.max(bArr.length * 2, i));
        }
        x xVar2 = this.l;
        byte[] bArr2 = xVar2.a;
        int i2 = xVar2.c;
        iVar.readFully(bArr2, i2, i - i2);
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
            return e0.F(j, j2, 1000L);
        }
        throw ParserException.a("Can't scale timecode prior to timecodeScale being set.", null);
    }

    @RequiresNonNull({"#2.output"})
    public final int n(i iVar, e$c e_c, int i) throws IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(e_c.f1196b)) {
            o(iVar, a, i);
            int i3 = this.X;
            l();
            return i3;
        }
        if ("S_TEXT/ASS".equals(e_c.f1196b)) {
            o(iVar, c, i);
            int i4 = this.X;
            l();
            return i4;
        }
        w wVar = e_c.X;
        if (!this.Z) {
            if (e_c.h) {
                this.T &= -1073741825;
                if (!this.f1186a0) {
                    iVar.readFully(this.l.a, 0, 1);
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
                        iVar.readFully(this.q.a, 0, 8);
                        this.W += 8;
                        this.f1190e0 = true;
                        x xVar = this.l;
                        xVar.a[0] = (byte) ((z2 ? 128 : 0) | 8);
                        xVar.E(0);
                        wVar.f(this.l, 1, 1);
                        this.X++;
                        this.q.E(0);
                        wVar.f(this.q, 8, 1);
                        this.X += 8;
                    }
                    if (z2) {
                        if (!this.f1187b0) {
                            iVar.readFully(this.l.a, 0, 1);
                            this.W++;
                            this.l.E(0);
                            this.f1188c0 = this.l.t();
                            this.f1187b0 = true;
                        }
                        int i5 = this.f1188c0 * 4;
                        this.l.A(i5);
                        iVar.readFully(this.l.a, 0, i5);
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
                        wVar.f(this.r, i6, 1);
                        this.X += i6;
                    }
                }
            } else {
                byte[] bArr2 = e_c.i;
                if (bArr2 != null) {
                    x xVar2 = this.o;
                    int length = bArr2.length;
                    xVar2.a = bArr2;
                    xVar2.c = length;
                    xVar2.f984b = 0;
                }
            }
            if (e_c.f > 0) {
                this.T |= 268435456;
                this.f1192s.A(0);
                this.l.A(4);
                x xVar3 = this.l;
                byte[] bArr3 = xVar3.a;
                bArr3[0] = (byte) ((i >> 24) & 255);
                bArr3[1] = (byte) ((i >> 16) & 255);
                bArr3[2] = (byte) ((i >> 8) & 255);
                bArr3[3] = (byte) (i & 255);
                wVar.f(xVar3, 4, 2);
                this.X += 4;
            }
            this.Z = true;
        }
        int i10 = i + this.o.c;
        if (!"V_MPEG4/ISO/AVC".equals(e_c.f1196b) && !"V_MPEGH/ISO/HEVC".equals(e_c.f1196b)) {
            if (e_c.T != null) {
                b.c.a.a0.d.D(this.o.c == 0);
                e_c.T.c(iVar);
            }
            while (true) {
                int i11 = this.W;
                if (i11 >= i10) {
                    break;
                }
                int iP = p(iVar, wVar, i10 - i11);
                this.W += iP;
                this.X += iP;
            }
        } else {
            byte[] bArr4 = this.k.a;
            bArr4[0] = 0;
            bArr4[1] = 0;
            bArr4[2] = 0;
            int i12 = e_c.Y;
            int i13 = 4 - i12;
            while (this.W < i10) {
                int i14 = this.Y;
                if (i14 == 0) {
                    int iMin = Math.min(i12, this.o.a());
                    iVar.readFully(bArr4, i13 + iMin, i12 - iMin);
                    if (iMin > 0) {
                        x xVar4 = this.o;
                        System.arraycopy(xVar4.a, xVar4.f984b, bArr4, i13, iMin);
                        xVar4.f984b += iMin;
                    }
                    this.W += i12;
                    this.k.E(0);
                    this.Y = this.k.w();
                    this.j.E(0);
                    wVar.c(this.j, 4);
                    this.X += 4;
                } else {
                    int iP2 = p(iVar, wVar, i14);
                    this.W += iP2;
                    this.X += iP2;
                    this.Y -= iP2;
                }
            }
        }
        if ("A_VORBIS".equals(e_c.f1196b)) {
            this.m.E(0);
            wVar.c(this.m, 4);
            this.X += 4;
        }
        int i15 = this.X;
        l();
        return i15;
    }

    public final void o(i iVar, byte[] bArr, int i) throws IOException {
        int length = bArr.length + i;
        x xVar = this.p;
        byte[] bArr2 = xVar.a;
        if (bArr2.length < length) {
            xVar.B(Arrays.copyOf(bArr, length + i));
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        iVar.readFully(this.p.a, bArr.length, i);
        this.p.E(0);
        this.p.D(length);
    }

    public final int p(i iVar, w wVar, int i) throws IOException {
        int iA = this.o.a();
        if (iA <= 0) {
            return wVar.b(iVar, i, false);
        }
        int iMin = Math.min(i, iA);
        wVar.c(this.o, iMin);
        return iMin;
    }

    @Override // b.i.a.c.x2.h
    public final void release() {
    }
}

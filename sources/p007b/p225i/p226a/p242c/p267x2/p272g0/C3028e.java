package p007b.p225i.p226a.p242c.p267x2.p272g0;

import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
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
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.C2997x0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2751r;
import p007b.p225i.p226a.p242c.p259f3.C2753t;
import p007b.p225i.p226a.p242c.p259f3.C2754u;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p260g3.C2776m;
import p007b.p225i.p226a.p242c.p260g3.C2777n;
import p007b.p225i.p226a.p242c.p260g3.C2778o;
import p007b.p225i.p226a.p242c.p260g3.C2780q;
import p007b.p225i.p226a.p242c.p263t2.C2928l;
import p007b.p225i.p226a.p242c.p267x2.C3003c;
import p007b.p225i.p226a.p242c.p267x2.C3069k;
import p007b.p225i.p226a.p242c.p267x2.C3118s;
import p007b.p225i.p226a.p242c.p267x2.C3123x;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;
import p007b.p225i.p226a.p242c.p267x2.p272g0.C3025b;
import p007b.p225i.p355b.p357b.AbstractC4493a;
import p007b.p225i.p355b.p357b.AbstractC4523p;

/* JADX INFO: renamed from: b.i.a.c.x2.g0.e */
/* JADX INFO: compiled from: MatroskaExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public class C3028e implements InterfaceC3031h {

    /* JADX INFO: renamed from: a */
    public static final byte[] f8190a;

    /* JADX INFO: renamed from: b */
    public static final byte[] f8191b;

    /* JADX INFO: renamed from: c */
    public static final byte[] f8192c;

    /* JADX INFO: renamed from: d */
    public static final UUID f8193d;

    /* JADX INFO: renamed from: e */
    public static final Map<String, Integer> f8194e;

    /* JADX INFO: renamed from: A */
    public boolean f8195A;

    /* JADX INFO: renamed from: B */
    public int f8196B;

    /* JADX INFO: renamed from: C */
    public long f8197C;

    /* JADX INFO: renamed from: D */
    public boolean f8198D;

    /* JADX INFO: renamed from: E */
    public long f8199E;

    /* JADX INFO: renamed from: F */
    public long f8200F;

    /* JADX INFO: renamed from: G */
    public long f8201G;

    /* JADX INFO: renamed from: H */
    @Nullable
    public C2751r f8202H;

    /* JADX INFO: renamed from: I */
    @Nullable
    public C2751r f8203I;

    /* JADX INFO: renamed from: J */
    public boolean f8204J;

    /* JADX INFO: renamed from: K */
    public boolean f8205K;

    /* JADX INFO: renamed from: L */
    public int f8206L;

    /* JADX INFO: renamed from: M */
    public long f8207M;

    /* JADX INFO: renamed from: N */
    public long f8208N;

    /* JADX INFO: renamed from: O */
    public int f8209O;

    /* JADX INFO: renamed from: P */
    public int f8210P;

    /* JADX INFO: renamed from: Q */
    public int[] f8211Q;

    /* JADX INFO: renamed from: R */
    public int f8212R;

    /* JADX INFO: renamed from: S */
    public int f8213S;

    /* JADX INFO: renamed from: T */
    public int f8214T;

    /* JADX INFO: renamed from: U */
    public int f8215U;

    /* JADX INFO: renamed from: V */
    public boolean f8216V;

    /* JADX INFO: renamed from: W */
    public int f8217W;

    /* JADX INFO: renamed from: X */
    public int f8218X;

    /* JADX INFO: renamed from: Y */
    public int f8219Y;

    /* JADX INFO: renamed from: Z */
    public boolean f8220Z;

    /* JADX INFO: renamed from: a0 */
    public boolean f8221a0;

    /* JADX INFO: renamed from: b0 */
    public boolean f8222b0;

    /* JADX INFO: renamed from: c0 */
    public int f8223c0;

    /* JADX INFO: renamed from: d0 */
    public byte f8224d0;

    /* JADX INFO: renamed from: e0 */
    public boolean f8225e0;

    /* JADX INFO: renamed from: f */
    public final InterfaceC3027d f8226f;

    /* JADX INFO: renamed from: f0 */
    public InterfaceC3058j f8227f0;

    /* JADX INFO: renamed from: g */
    public final C3030g f8228g;

    /* JADX INFO: renamed from: h */
    public final SparseArray<c> f8229h;

    /* JADX INFO: renamed from: i */
    public final boolean f8230i;

    /* JADX INFO: renamed from: j */
    public final C2757x f8231j;

    /* JADX INFO: renamed from: k */
    public final C2757x f8232k;

    /* JADX INFO: renamed from: l */
    public final C2757x f8233l;

    /* JADX INFO: renamed from: m */
    public final C2757x f8234m;

    /* JADX INFO: renamed from: n */
    public final C2757x f8235n;

    /* JADX INFO: renamed from: o */
    public final C2757x f8236o;

    /* JADX INFO: renamed from: p */
    public final C2757x f8237p;

    /* JADX INFO: renamed from: q */
    public final C2757x f8238q;

    /* JADX INFO: renamed from: r */
    public final C2757x f8239r;

    /* JADX INFO: renamed from: s */
    public final C2757x f8240s;

    /* JADX INFO: renamed from: t */
    public ByteBuffer f8241t;

    /* JADX INFO: renamed from: u */
    public long f8242u;

    /* JADX INFO: renamed from: v */
    public long f8243v;

    /* JADX INFO: renamed from: w */
    public long f8244w;

    /* JADX INFO: renamed from: x */
    public long f8245x;

    /* JADX INFO: renamed from: y */
    public long f8246y;

    /* JADX INFO: renamed from: z */
    @Nullable
    public c f8247z;

    /* JADX INFO: renamed from: b.i.a.c.x2.g0.e$b */
    /* JADX INFO: compiled from: MatroskaExtractor.java */
    public final class b implements InterfaceC3026c {
        public b(a aVar) {
        }
    }

    static {
        C3024a c3024a = new InterfaceC3106l() { // from class: b.i.a.c.x2.g0.a
            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: a */
            public final InterfaceC3031h[] mo3630a() {
                return new InterfaceC3031h[]{new C3028e(0)};
            }

            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: b */
            public /* synthetic */ InterfaceC3031h[] mo3631b(Uri uri, Map map) {
                return C3069k.m3748a(this, uri, map);
            }
        };
        f8190a = new byte[]{49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
        f8191b = C2738e0.m3015w("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
        f8192c = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        f8193d = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        f8194e = Collections.unmodifiableMap(map);
    }

    public C3028e(int i) {
        C3025b c3025b = new C3025b();
        this.f8243v = -1L;
        this.f8244w = -9223372036854775807L;
        this.f8245x = -9223372036854775807L;
        this.f8246y = -9223372036854775807L;
        this.f8199E = -1L;
        this.f8200F = -1L;
        this.f8201G = -9223372036854775807L;
        this.f8226f = c3025b;
        c3025b.f8184d = new b(null);
        this.f8230i = (i & 1) == 0;
        this.f8228g = new C3030g();
        this.f8229h = new SparseArray<>();
        this.f8233l = new C2757x(4);
        this.f8234m = new C2757x(ByteBuffer.allocate(4).putInt(-1).array());
        this.f8235n = new C2757x(4);
        this.f8231j = new C2757x(C2754u.f6753a);
        this.f8232k = new C2757x(4);
        this.f8236o = new C2757x();
        this.f8237p = new C2757x();
        this.f8238q = new C2757x(8);
        this.f8239r = new C2757x();
        this.f8240s = new C2757x();
        this.f8211Q = new int[1];
    }

    /* JADX INFO: renamed from: i */
    public static int[] m3671i(@Nullable int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return iArr.length >= i ? iArr : new int[Math.max(iArr.length * 2, i)];
    }

    /* JADX INFO: renamed from: j */
    public static byte[] m3672j(long j, String str, long j2) {
        C1460d.m531j(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - (((long) (i * 3600)) * 1000000);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - (((long) (i2 * 60)) * 1000000);
        int i3 = (int) (j4 / 1000000);
        return C2738e0.m3015w(String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * 1000000)) / j2))));
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    /* JADX INFO: renamed from: a */
    public final void m3673a(int i) throws ParserException {
        if (this.f8202H == null || this.f8203I == null) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Element ");
            sb.append(i);
            sb.append(" must be in a Cues");
            throw ParserException.m8755a(sb.toString(), null);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: b */
    public final boolean mo3633b(InterfaceC3041i interfaceC3041i) throws IOException {
        C3029f c3029f = new C3029f();
        long jMo3642b = interfaceC3041i.mo3642b();
        long j = Permission.VIEW_CHANNEL;
        if (jMo3642b != -1 && jMo3642b <= Permission.VIEW_CHANNEL) {
            j = jMo3642b;
        }
        int i = (int) j;
        interfaceC3041i.mo3652o(c3029f.f8300a.f6793a, 0, 4);
        c3029f.f8301b = 4;
        for (long jM3101u = c3029f.f8300a.m3101u(); jM3101u != 440786851; jM3101u = ((jM3101u << 8) & (-256)) | ((long) (c3029f.f8300a.f6793a[0] & 255))) {
            int i2 = c3029f.f8301b + 1;
            c3029f.f8301b = i2;
            if (i2 == i) {
                return false;
            }
            interfaceC3041i.mo3652o(c3029f.f8300a.f6793a, 0, 1);
        }
        long jM3684a = c3029f.m3684a(interfaceC3041i);
        long j2 = c3029f.f8301b;
        if (jM3684a == Long.MIN_VALUE) {
            return false;
        }
        if (jMo3642b != -1 && j2 + jM3684a >= jMo3642b) {
            return false;
        }
        while (true) {
            long j3 = c3029f.f8301b;
            long j4 = j2 + jM3684a;
            if (j3 >= j4) {
                return j3 == j4;
            }
            if (c3029f.m3684a(interfaceC3041i) == Long.MIN_VALUE) {
                return false;
            }
            long jM3684a2 = c3029f.m3684a(interfaceC3041i);
            if (jM3684a2 < 0 || jM3684a2 > 2147483647L) {
                return false;
            }
            if (jM3684a2 != 0) {
                int i3 = (int) jM3684a2;
                interfaceC3041i.mo3646g(i3);
                c3029f.f8301b += i3;
            }
        }
    }

    @EnsuresNonNull({"currentTrack"})
    /* JADX INFO: renamed from: c */
    public final void m3674c(int i) throws ParserException {
        if (this.f8247z != null) {
            return;
        }
        StringBuilder sb = new StringBuilder(43);
        sb.append("Element ");
        sb.append(i);
        sb.append(" must be in a TrackEntry");
        throw ParserException.m8755a(sb.toString(), null);
    }

    @RequiresNonNull({"#1.output"})
    /* JADX INFO: renamed from: d */
    public final void m3675d(c cVar, long j, int i, int i2, int i3) {
        byte[] bArrM3672j;
        int i4;
        C3123x c3123x = cVar.f8268T;
        if (c3123x != null) {
            c3123x.m3820b(cVar.f8272X, j, i, i2, i3, cVar.f8283j);
        } else {
            if ("S_TEXT/UTF8".equals(cVar.f8275b) || "S_TEXT/ASS".equals(cVar.f8275b)) {
                if (this.f8210P > 1) {
                    Log.w("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j2 = this.f8208N;
                    if (j2 == -9223372036854775807L) {
                        Log.w("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        String str = cVar.f8275b;
                        byte[] bArr = this.f8237p.f6793a;
                        str.hashCode();
                        if (str.equals("S_TEXT/ASS")) {
                            bArrM3672j = m3672j(j2, "%01d:%02d:%02d:%02d", 10000L);
                            i4 = 21;
                        } else {
                            if (!str.equals("S_TEXT/UTF8")) {
                                throw new IllegalArgumentException();
                            }
                            bArrM3672j = m3672j(j2, "%02d:%02d:%02d,%03d", 1000L);
                            i4 = 19;
                        }
                        System.arraycopy(bArrM3672j, 0, bArr, i4, bArrM3672j.length);
                        int i5 = this.f8237p.f6794b;
                        while (true) {
                            C2757x c2757x = this.f8237p;
                            if (i5 >= c2757x.f6795c) {
                                break;
                            }
                            if (c2757x.f6793a[i5] == 0) {
                                c2757x.m3078D(i5);
                                break;
                            }
                            i5++;
                        }
                        InterfaceC3122w interfaceC3122w = cVar.f8272X;
                        C2757x c2757x2 = this.f8237p;
                        interfaceC3122w.mo2524c(c2757x2, c2757x2.f6795c);
                        i2 += this.f8237p.f6795c;
                    }
                }
            }
            if ((268435456 & i) != 0) {
                if (this.f8210P > 1) {
                    i &= -268435457;
                } else {
                    C2757x c2757x3 = this.f8240s;
                    int i6 = c2757x3.f6795c;
                    cVar.f8272X.mo2527f(c2757x3, i6, 2);
                    i2 += i6;
                }
            }
            cVar.f8272X.mo2525d(j, i, i2, i3, cVar.f8283j);
        }
        this.f8205K = true;
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
    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: e */
    public final int mo3635e(InterfaceC3041i interfaceC3041i, C3118s c3118s) throws IOException {
        int i;
        int i2;
        String str;
        ?? r4;
        long j;
        int i3;
        int[] iArr;
        boolean z2;
        boolean z3 = false;
        this.f8205K = false;
        boolean z4 = true;
        boolean z5 = true;
        while (z5 && !this.f8205K) {
            C3025b c3025b = (C3025b) this.f8226f;
            C1460d.m438H(c3025b.f8184d);
            boolean z6 = z3;
            boolean z7 = z4;
            while (true) {
                C3025b.b bVarPeek = c3025b.f8182b.peek();
                if (bVarPeek == null || interfaceC3041i.getPosition() < bVarPeek.f8189b) {
                    if (c3025b.f8185e == 0) {
                        long jM3687c = c3025b.f8183c.m3687c(interfaceC3041i, z7, z6, 4);
                        if (jM3687c == -2) {
                            interfaceC3041i.mo3649k();
                            while (true) {
                                interfaceC3041i.mo3652o(c3025b.f8181a, z6 ? 1 : 0, 4);
                                int iM3686b = C3030g.m3686b(c3025b.f8181a[z6 ? 1 : 0]);
                                if (iM3686b != -1 && iM3686b <= 4) {
                                    int iM3685a = (int) C3030g.m3685a(c3025b.f8181a, iM3686b, z6);
                                    Objects.requireNonNull(C3028e.this);
                                    if (iM3685a == 357149030 || iM3685a == 524531317 || iM3685a == 475249515 || iM3685a == 374648427) {
                                        interfaceC3041i.mo3650l(iM3686b);
                                        jM3687c = iM3685a;
                                    }
                                }
                                interfaceC3041i.mo3650l(z7 ? 1 : 0);
                            }
                        }
                        if (jM3687c == -1) {
                            z5 = false;
                        } else {
                            c3025b.f8186f = (int) jM3687c;
                            c3025b.f8185e = z7 ? 1 : 0;
                        }
                    }
                    if (c3025b.f8185e == z7) {
                        c3025b.f8187g = c3025b.f8183c.m3687c(interfaceC3041i, z6, z7, 8);
                        c3025b.f8185e = 2;
                    }
                    InterfaceC3026c interfaceC3026c = c3025b.f8184d;
                    int i4 = c3025b.f8186f;
                    Objects.requireNonNull(C3028e.this);
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
                        interfaceC3041i.mo3650l((int) c3025b.f8187g);
                        z6 = false;
                        c3025b.f8185e = 0;
                        z7 = true;
                    } else if (i == z7) {
                        long position = interfaceC3041i.getPosition();
                        c3025b.f8182b.push(new C3025b.b(c3025b.f8186f, c3025b.f8187g + position, null));
                        InterfaceC3026c interfaceC3026c2 = c3025b.f8184d;
                        int i5 = c3025b.f8186f;
                        long j2 = c3025b.f8187g;
                        C3028e c3028e = C3028e.this;
                        C1460d.m438H(c3028e.f8227f0);
                        if (i5 == 160) {
                            i2 = 0;
                            c3028e.f8216V = false;
                        } else if (i5 == 174) {
                            i2 = 0;
                            c3028e.f8247z = new c(null);
                        } else if (i5 != 187) {
                            if (i5 == 19899) {
                                c3028e.f8196B = -1;
                                c3028e.f8197C = -1L;
                            } else if (i5 == 20533) {
                                c3028e.m3674c(i5);
                                c3028e.f8247z.f8281h = true;
                            } else if (i5 == 21968) {
                                c3028e.m3674c(i5);
                                c3028e.f8247z.f8297x = true;
                            } else if (i5 == 408125543) {
                                long j3 = c3028e.f8243v;
                                if (j3 != -1 && j3 != position) {
                                    throw ParserException.m8755a("Multiple Segment elements not supported", null);
                                }
                                c3028e.f8243v = position;
                                c3028e.f8242u = j2;
                            } else if (i5 == 475249515) {
                                c3028e.f8202H = new C2751r();
                                c3028e.f8203I = new C2751r();
                            } else if (i5 == 524531317 && !c3028e.f8195A) {
                                if (!c3028e.f8230i || c3028e.f8199E == -1) {
                                    c3028e.f8227f0.mo2477a(new InterfaceC3119t.b(c3028e.f8246y, 0L));
                                    c3028e.f8195A = true;
                                } else {
                                    c3028e.f8198D = true;
                                }
                            }
                            i2 = 0;
                        } else {
                            i2 = 0;
                            c3028e.f8204J = false;
                        }
                        c3025b.f8185e = i2;
                    } else if (i == 2) {
                        long j4 = c3025b.f8187g;
                        if (j4 > 8) {
                            StringBuilder sb = new StringBuilder(42);
                            sb.append("Invalid integer size: ");
                            sb.append(j4);
                            throw ParserException.m8755a(sb.toString(), null);
                        }
                        InterfaceC3026c interfaceC3026c3 = c3025b.f8184d;
                        int i6 = c3025b.f8186f;
                        long jM3670a = c3025b.m3670a(interfaceC3041i, (int) j4);
                        C3028e c3028e2 = C3028e.this;
                        Objects.requireNonNull(c3028e2);
                        if (i6 != 20529) {
                            if (i6 != 20530) {
                                switch (i6) {
                                    case Opcodes.LXOR /* 131 */:
                                        c3028e2.m3674c(i6);
                                        c3028e2.f8247z.f8277d = (int) jM3670a;
                                        break;
                                    case Opcodes.L2I /* 136 */:
                                        c3028e2.m3674c(i6);
                                        c3028e2.f8247z.f8270V = jM3670a == 1;
                                        break;
                                    case 155:
                                        c3028e2.f8208N = c3028e2.m3679m(jM3670a);
                                        break;
                                    case Opcodes.IF_ICMPEQ /* 159 */:
                                        c3028e2.m3674c(i6);
                                        c3028e2.f8247z.f8263O = (int) jM3670a;
                                        break;
                                    case Opcodes.ARETURN /* 176 */:
                                        c3028e2.m3674c(i6);
                                        c3028e2.f8247z.f8286m = (int) jM3670a;
                                        break;
                                    case Opcodes.PUTSTATIC /* 179 */:
                                        c3028e2.m3673a(i6);
                                        c3028e2.f8202H.m3041a(c3028e2.m3679m(jM3670a));
                                        break;
                                    case Opcodes.INVOKEDYNAMIC /* 186 */:
                                        c3028e2.m3674c(i6);
                                        c3028e2.f8247z.f8287n = (int) jM3670a;
                                        break;
                                    case 215:
                                        c3028e2.m3674c(i6);
                                        c3028e2.f8247z.f8276c = (int) jM3670a;
                                        break;
                                    case 231:
                                        c3028e2.f8201G = c3028e2.m3679m(jM3670a);
                                        break;
                                    case 238:
                                        c3028e2.f8215U = (int) jM3670a;
                                        break;
                                    case 241:
                                        if (!c3028e2.f8204J) {
                                            c3028e2.m3673a(i6);
                                            c3028e2.f8203I.m3041a(jM3670a);
                                            c3028e2.f8204J = true;
                                        }
                                        break;
                                    case 251:
                                        c3028e2.f8216V = true;
                                        break;
                                    case 16871:
                                        c3028e2.m3674c(i6);
                                        c3028e2.f8247z.f8280g = (int) jM3670a;
                                        break;
                                    case 16980:
                                        if (jM3670a != 3) {
                                            throw ParserException.m8755a(C1643a.m855i(50, "ContentCompAlgo ", jM3670a, " not supported"), null);
                                        }
                                        break;
                                    case 17029:
                                        if (jM3670a < 1 || jM3670a > 2) {
                                            throw ParserException.m8755a(C1643a.m855i(53, "DocTypeReadVersion ", jM3670a, " not supported"), null);
                                        }
                                        break;
                                    case 17143:
                                        if (jM3670a != 1) {
                                            throw ParserException.m8755a(C1643a.m855i(50, "EBMLReadVersion ", jM3670a, " not supported"), null);
                                        }
                                        break;
                                    case 18401:
                                        if (jM3670a != 5) {
                                            throw ParserException.m8755a(C1643a.m855i(49, "ContentEncAlgo ", jM3670a, " not supported"), null);
                                        }
                                        break;
                                    case 18408:
                                        if (jM3670a != 1) {
                                            throw ParserException.m8755a(C1643a.m855i(56, "AESSettingsCipherMode ", jM3670a, " not supported"), null);
                                        }
                                        break;
                                    case 21420:
                                        c3028e2.f8197C = jM3670a + c3028e2.f8243v;
                                        break;
                                    case 21432:
                                        int i7 = (int) jM3670a;
                                        c3028e2.m3674c(i6);
                                        if (i7 == 0) {
                                            c3028e2.f8247z.f8296w = 0;
                                        } else if (i7 == 1) {
                                            c3028e2.f8247z.f8296w = 2;
                                        } else if (i7 == 3) {
                                            c3028e2.f8247z.f8296w = 1;
                                        } else if (i7 == 15) {
                                            c3028e2.f8247z.f8296w = 3;
                                        }
                                        break;
                                    case 21680:
                                        c3028e2.m3674c(i6);
                                        c3028e2.f8247z.f8288o = (int) jM3670a;
                                        break;
                                    case 21682:
                                        c3028e2.m3674c(i6);
                                        c3028e2.f8247z.f8290q = (int) jM3670a;
                                        break;
                                    case 21690:
                                        c3028e2.m3674c(i6);
                                        c3028e2.f8247z.f8289p = (int) jM3670a;
                                        break;
                                    case 21930:
                                        c3028e2.m3674c(i6);
                                        c3028e2.f8247z.f8269U = jM3670a == 1;
                                        break;
                                    case 21998:
                                        c3028e2.m3674c(i6);
                                        c3028e2.f8247z.f8279f = (int) jM3670a;
                                        break;
                                    case 22186:
                                        c3028e2.m3674c(i6);
                                        c3028e2.f8247z.f8266R = jM3670a;
                                        break;
                                    case 22203:
                                        c3028e2.m3674c(i6);
                                        c3028e2.f8247z.f8267S = jM3670a;
                                        break;
                                    case 25188:
                                        c3028e2.m3674c(i6);
                                        c3028e2.f8247z.f8264P = (int) jM3670a;
                                        break;
                                    case 30321:
                                        c3028e2.m3674c(i6);
                                        int i8 = (int) jM3670a;
                                        if (i8 == 0) {
                                            c3028e2.f8247z.f8291r = 0;
                                        } else if (i8 == 1) {
                                            c3028e2.f8247z.f8291r = 1;
                                        } else if (i8 == 2) {
                                            c3028e2.f8247z.f8291r = 2;
                                        } else if (i8 == 3) {
                                            c3028e2.f8247z.f8291r = 3;
                                        }
                                        break;
                                    case 2352003:
                                        c3028e2.m3674c(i6);
                                        c3028e2.f8247z.f8278e = (int) jM3670a;
                                        break;
                                    case 2807729:
                                        c3028e2.f8244w = jM3670a;
                                        break;
                                    default:
                                        switch (i6) {
                                            case 21945:
                                                c3028e2.m3674c(i6);
                                                int i9 = (int) jM3670a;
                                                if (i9 == 1) {
                                                    c3028e2.f8247z.f8249A = 2;
                                                } else if (i9 == 2) {
                                                    c3028e2.f8247z.f8249A = 1;
                                                }
                                                break;
                                            case 21946:
                                                c3028e2.m3674c(i6);
                                                int iM3124b = C2777n.m3124b((int) jM3670a);
                                                if (iM3124b != -1) {
                                                    c3028e2.f8247z.f8299z = iM3124b;
                                                }
                                                break;
                                            case 21947:
                                                c3028e2.m3674c(i6);
                                                c3028e2.f8247z.f8297x = true;
                                                int iM3123a = C2777n.m3123a((int) jM3670a);
                                                if (iM3123a != -1) {
                                                    c3028e2.f8247z.f8298y = iM3123a;
                                                }
                                                break;
                                            case 21948:
                                                c3028e2.m3674c(i6);
                                                c3028e2.f8247z.f8250B = (int) jM3670a;
                                                break;
                                            case 21949:
                                                c3028e2.m3674c(i6);
                                                c3028e2.f8247z.f8251C = (int) jM3670a;
                                                break;
                                        }
                                        break;
                                }
                            } else if (jM3670a != 1) {
                                throw ParserException.m8755a(C1643a.m855i(55, "ContentEncodingScope ", jM3670a, " not supported"), null);
                            }
                        } else if (jM3670a != 0) {
                            throw ParserException.m8755a(C1643a.m855i(55, "ContentEncodingOrder ", jM3670a, " not supported"), null);
                        }
                        c3025b.f8185e = 0;
                    } else if (i == 3) {
                        long j5 = c3025b.f8187g;
                        if (j5 > 2147483647L) {
                            StringBuilder sb2 = new StringBuilder(41);
                            sb2.append("String element size: ");
                            sb2.append(j5);
                            throw ParserException.m8755a(sb2.toString(), null);
                        }
                        InterfaceC3026c interfaceC3026c4 = c3025b.f8184d;
                        int i10 = c3025b.f8186f;
                        int i11 = (int) j5;
                        if (i11 == 0) {
                            str = "";
                        } else {
                            byte[] bArr = new byte[i11];
                            interfaceC3041i.readFully(bArr, 0, i11);
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
                        C3028e c3028e3 = C3028e.this;
                        Objects.requireNonNull(c3028e3);
                        if (i10 == 134) {
                            c3028e3.m3674c(i10);
                            c3028e3.f8247z.f8275b = str;
                        } else if (i10 != 17026) {
                            if (i10 == 21358) {
                                c3028e3.m3674c(i10);
                                c3028e3.f8247z.f8274a = str;
                            } else if (i10 == 2274716) {
                                c3028e3.m3674c(i10);
                                c3028e3.f8247z.f8271W = str;
                            }
                        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
                            StringBuilder sb3 = new StringBuilder(str.length() + 22);
                            sb3.append("DocType ");
                            sb3.append(str);
                            sb3.append(" not supported");
                            throw ParserException.m8755a(sb3.toString(), null);
                        }
                        c3025b.f8185e = 0;
                    } else if (i == 4) {
                        InterfaceC3026c interfaceC3026c5 = c3025b.f8184d;
                        int i13 = c3025b.f8186f;
                        int i14 = (int) c3025b.f8187g;
                        C3028e c3028e4 = C3028e.this;
                        Objects.requireNonNull(c3028e4);
                        if (i13 == 161 || i13 == 163) {
                            if (c3028e4.f8206L == 0) {
                                c3028e4.f8212R = (int) c3028e4.f8228g.m3687c(interfaceC3041i, z6, z7, 8);
                                c3028e4.f8213S = c3028e4.f8228g.f8305d;
                                c3028e4.f8208N = -9223372036854775807L;
                                c3028e4.f8206L = z7 ? 1 : 0;
                                c3028e4.f8233l.m3075A(z6 ? 1 : 0);
                            }
                            c cVar = c3028e4.f8229h.get(c3028e4.f8212R);
                            if (cVar == null) {
                                interfaceC3041i.mo3650l(i14 - c3028e4.f8213S);
                                c3028e4.f8206L = z6 ? 1 : 0;
                            } else {
                                Objects.requireNonNull(cVar.f8272X);
                                if (c3028e4.f8206L == z7) {
                                    c3028e4.m3677k(interfaceC3041i, 3);
                                    int i15 = (c3028e4.f8233l.f6793a[2] & 6) >> (z7 ? 1 : 0);
                                    byte b2 = 255;
                                    if (i15 == 0) {
                                        c3028e4.f8210P = z7 ? 1 : 0;
                                        int[] iArrM3671i = m3671i(c3028e4.f8211Q, z7 ? 1 : 0);
                                        c3028e4.f8211Q = iArrM3671i;
                                        iArrM3671i[z6 ? 1 : 0] = (i14 - c3028e4.f8213S) - 3;
                                    } else {
                                        c3028e4.m3677k(interfaceC3041i, 4);
                                        int i16 = (c3028e4.f8233l.f6793a[3] & 255) + (z7 ? 1 : 0);
                                        c3028e4.f8210P = i16;
                                        int[] iArrM3671i2 = m3671i(c3028e4.f8211Q, i16);
                                        c3028e4.f8211Q = iArrM3671i2;
                                        if (i15 == 2) {
                                            int i17 = (i14 - c3028e4.f8213S) - 4;
                                            int i18 = c3028e4.f8210P;
                                            Arrays.fill(iArrM3671i2, z6 ? 1 : 0, i18, i17 / i18);
                                        } else {
                                            int i19 = 4;
                                            if (i15 == z7) {
                                                int i20 = 0;
                                                int i21 = 0;
                                                while (true) {
                                                    int i22 = c3028e4.f8210P;
                                                    if (i20 < i22 - 1) {
                                                        c3028e4.f8211Q[i20] = z6 ? 1 : 0;
                                                        do {
                                                            i19 += z7 ? 1 : 0;
                                                            c3028e4.m3677k(interfaceC3041i, i19);
                                                            i3 = c3028e4.f8233l.f6793a[i19 - 1] & 255;
                                                            iArr = c3028e4.f8211Q;
                                                            iArr[i20] = iArr[i20] + i3;
                                                        } while (i3 == 255);
                                                        i21 += iArr[i20];
                                                        i20++;
                                                    } else {
                                                        c3028e4.f8211Q[i22 - 1] = ((i14 - c3028e4.f8213S) - i19) - i21;
                                                    }
                                                }
                                            } else {
                                                if (i15 != 3) {
                                                    throw C1643a.m884w0(36, "Unexpected lacing value: ", i15, null);
                                                }
                                                int i23 = 0;
                                                int i24 = 0;
                                                ?? r3 = z6;
                                                boolean z8 = z7;
                                                while (true) {
                                                    int i25 = c3028e4.f8210P;
                                                    if (i23 < i25 - 1) {
                                                        c3028e4.f8211Q[i23] = r3;
                                                        i19++;
                                                        c3028e4.m3677k(interfaceC3041i, i19);
                                                        int i26 = i19 - 1;
                                                        if (c3028e4.f8233l.f6793a[i26] == 0) {
                                                            throw ParserException.m8755a("No valid varint length mask found", null);
                                                        }
                                                        int i27 = 8;
                                                        int i28 = 0;
                                                        while (true) {
                                                            if (i28 < i27) {
                                                                int i29 = r4 << (7 - i28);
                                                                if ((c3028e4.f8233l.f6793a[i26] & i29) != 0) {
                                                                    r4 = z8;
                                                                    int i30 = i19 + i28;
                                                                    c3028e4.m3677k(interfaceC3041i, i30);
                                                                    j = (~i29) & c3028e4.f8233l.f6793a[i26] & b2;
                                                                    int i31 = i26 + 1;
                                                                    while (i31 < i30) {
                                                                        j = (j << 8) | ((long) (c3028e4.f8233l.f6793a[i31] & 255));
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
                                                            throw ParserException.m8755a("EBML lacing sample size out of range.", null);
                                                        }
                                                        int i33 = (int) j;
                                                        int[] iArr2 = c3028e4.f8211Q;
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
                                                        c3028e4.f8211Q[i25 - 1] = ((i14 - c3028e4.f8213S) - i19) - i24;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    byte[] bArr2 = c3028e4.f8233l.f6793a;
                                    c3028e4.f8207M = c3028e4.m3679m((bArr2[1] & 255) | (bArr2[0] << 8)) + c3028e4.f8201G;
                                    c3028e4.f8214T = (cVar.f8277d == 2 || (i13 == 163 && (c3028e4.f8233l.f6793a[2] & 128) == 128)) ? 1 : 0;
                                    c3028e4.f8206L = 2;
                                    c3028e4.f8209O = 0;
                                }
                                if (i13 == 163) {
                                    while (true) {
                                        int i34 = c3028e4.f8209O;
                                        if (i34 < c3028e4.f8210P) {
                                            c3028e4.m3675d(cVar, ((long) ((c3028e4.f8209O * cVar.f8278e) / 1000)) + c3028e4.f8207M, c3028e4.f8214T, c3028e4.m3680n(interfaceC3041i, cVar, c3028e4.f8211Q[i34]), 0);
                                            c3028e4.f8209O++;
                                        } else {
                                            c3028e4.f8206L = 0;
                                        }
                                    }
                                } else {
                                    while (true) {
                                        int i35 = c3028e4.f8209O;
                                        if (i35 < c3028e4.f8210P) {
                                            int[] iArr3 = c3028e4.f8211Q;
                                            iArr3[i35] = c3028e4.m3680n(interfaceC3041i, cVar, iArr3[i35]);
                                            c3028e4.f8209O++;
                                        }
                                    }
                                }
                            }
                        } else if (i13 != 165) {
                            if (i13 == 16877) {
                                c3028e4.m3674c(i13);
                                c cVar2 = c3028e4.f8247z;
                                int i36 = cVar2.f8280g;
                                if (i36 == 1685485123 || i36 == 1685480259) {
                                    byte[] bArr3 = new byte[i14];
                                    cVar2.f8262N = bArr3;
                                    interfaceC3041i.readFully(bArr3, z6 ? 1 : 0, i14);
                                } else {
                                    interfaceC3041i.mo3650l(i14);
                                }
                            } else if (i13 == 16981) {
                                c3028e4.m3674c(i13);
                                byte[] bArr4 = new byte[i14];
                                c3028e4.f8247z.f8282i = bArr4;
                                interfaceC3041i.readFully(bArr4, z6 ? 1 : 0, i14);
                            } else if (i13 == 18402) {
                                byte[] bArr5 = new byte[i14];
                                interfaceC3041i.readFully(bArr5, z6 ? 1 : 0, i14);
                                c3028e4.m3674c(i13);
                                c3028e4.f8247z.f8283j = new InterfaceC3122w.a(z7 ? 1 : 0, bArr5, z6 ? 1 : 0, z6 ? 1 : 0);
                            } else if (i13 == 21419) {
                                Arrays.fill(c3028e4.f8235n.f6793a, z6 ? (byte) 1 : (byte) 0);
                                interfaceC3041i.readFully(c3028e4.f8235n.f6793a, 4 - i14, i14);
                                c3028e4.f8235n.m3079E(z6 ? 1 : 0);
                                c3028e4.f8196B = (int) c3028e4.f8235n.m3101u();
                            } else if (i13 == 25506) {
                                c3028e4.m3674c(i13);
                                byte[] bArr6 = new byte[i14];
                                c3028e4.f8247z.f8284k = bArr6;
                                interfaceC3041i.readFully(bArr6, z6 ? 1 : 0, i14);
                            } else {
                                if (i13 != 30322) {
                                    throw C1643a.m884w0(26, "Unexpected id: ", i13, null);
                                }
                                c3028e4.m3674c(i13);
                                byte[] bArr7 = new byte[i14];
                                c3028e4.f8247z.f8295v = bArr7;
                                interfaceC3041i.readFully(bArr7, z6 ? 1 : 0, i14);
                            }
                        } else if (c3028e4.f8206L == 2) {
                            c cVar3 = c3028e4.f8229h.get(c3028e4.f8212R);
                            if (c3028e4.f8215U == 4 && "V_VP9".equals(cVar3.f8275b)) {
                                C2757x c2757x = c3028e4.f8240s;
                                byte[] bArr8 = c2757x.f6793a;
                                if (bArr8.length < i14) {
                                    bArr8 = new byte[i14];
                                }
                                c2757x.m3077C(bArr8, i14);
                                interfaceC3041i.readFully(c3028e4.f8240s.f6793a, z6 ? 1 : 0, i14);
                            } else {
                                interfaceC3041i.mo3650l(i14);
                            }
                        }
                        c3025b.f8185e = 0;
                    } else {
                        if (i != 5) {
                            throw C1643a.m884w0(32, "Invalid element type ", i, null);
                        }
                        long j6 = c3025b.f8187g;
                        if (j6 != 4 && j6 != 8) {
                            StringBuilder sb4 = new StringBuilder(40);
                            sb4.append("Invalid float size: ");
                            sb4.append(j6);
                            throw ParserException.m8755a(sb4.toString(), null);
                        }
                        InterfaceC3026c interfaceC3026c6 = c3025b.f8184d;
                        int i37 = c3025b.f8186f;
                        int i38 = (int) j6;
                        long jM3670a2 = c3025b.m3670a(interfaceC3041i, i38);
                        double dIntBitsToFloat = i38 == 4 ? Float.intBitsToFloat((int) jM3670a2) : Double.longBitsToDouble(jM3670a2);
                        C3028e c3028e5 = C3028e.this;
                        Objects.requireNonNull(c3028e5);
                        if (i37 == 181) {
                            c3028e5.m3674c(i37);
                            c3028e5.f8247z.f8265Q = (int) dIntBitsToFloat;
                        } else if (i37 != 17545) {
                            switch (i37) {
                                case 21969:
                                    c3028e5.m3674c(i37);
                                    c3028e5.f8247z.f8252D = (float) dIntBitsToFloat;
                                    break;
                                case 21970:
                                    c3028e5.m3674c(i37);
                                    c3028e5.f8247z.f8253E = (float) dIntBitsToFloat;
                                    break;
                                case 21971:
                                    c3028e5.m3674c(i37);
                                    c3028e5.f8247z.f8254F = (float) dIntBitsToFloat;
                                    break;
                                case 21972:
                                    c3028e5.m3674c(i37);
                                    c3028e5.f8247z.f8255G = (float) dIntBitsToFloat;
                                    break;
                                case 21973:
                                    c3028e5.m3674c(i37);
                                    c3028e5.f8247z.f8256H = (float) dIntBitsToFloat;
                                    break;
                                case 21974:
                                    c3028e5.m3674c(i37);
                                    c3028e5.f8247z.f8257I = (float) dIntBitsToFloat;
                                    break;
                                case 21975:
                                    c3028e5.m3674c(i37);
                                    c3028e5.f8247z.f8258J = (float) dIntBitsToFloat;
                                    break;
                                case 21976:
                                    c3028e5.m3674c(i37);
                                    c3028e5.f8247z.f8259K = (float) dIntBitsToFloat;
                                    break;
                                case 21977:
                                    c3028e5.m3674c(i37);
                                    c3028e5.f8247z.f8260L = (float) dIntBitsToFloat;
                                    break;
                                case 21978:
                                    c3028e5.m3674c(i37);
                                    c3028e5.f8247z.f8261M = (float) dIntBitsToFloat;
                                    break;
                                default:
                                    switch (i37) {
                                        case 30323:
                                            c3028e5.m3674c(i37);
                                            c3028e5.f8247z.f8292s = (float) dIntBitsToFloat;
                                            break;
                                        case 30324:
                                            c3028e5.m3674c(i37);
                                            c3028e5.f8247z.f8293t = (float) dIntBitsToFloat;
                                            break;
                                        case 30325:
                                            c3028e5.m3674c(i37);
                                            c3028e5.f8247z.f8294u = (float) dIntBitsToFloat;
                                            break;
                                    }
                                    break;
                            }
                        } else {
                            c3028e5.f8245x = (long) dIntBitsToFloat;
                        }
                        c3025b.f8185e = z6 ? 1 : 0;
                    }
                } else {
                    C3028e.this.m3676h(c3025b.f8182b.pop().f8188a);
                }
                z5 = true;
            }
            if (z5) {
                long position2 = interfaceC3041i.getPosition();
                if (this.f8198D) {
                    this.f8200F = position2;
                    c3118s.f8992a = this.f8199E;
                    this.f8198D = false;
                } else {
                    if (this.f8195A) {
                        long j7 = this.f8200F;
                        if (j7 != -1) {
                            c3118s.f8992a = j7;
                            this.f8200F = -1L;
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
        for (int i39 = 0; i39 < this.f8229h.size(); i39++) {
            c cVarValueAt = this.f8229h.valueAt(i39);
            Objects.requireNonNull(cVarValueAt.f8272X);
            C3123x c3123x = cVarValueAt.f8268T;
            if (c3123x != null) {
                c3123x.m3819a(cVarValueAt.f8272X, cVarValueAt.f8283j);
            }
        }
        return -1;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: f */
    public final void mo3636f(InterfaceC3058j interfaceC3058j) {
        this.f8227f0 = interfaceC3058j;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    @CallSuper
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        this.f8201G = -9223372036854775807L;
        this.f8206L = 0;
        C3025b c3025b = (C3025b) this.f8226f;
        c3025b.f8185e = 0;
        c3025b.f8182b.clear();
        C3030g c3030g = c3025b.f8183c;
        c3030g.f8304c = 0;
        c3030g.f8305d = 0;
        C3030g c3030g2 = this.f8228g;
        c3030g2.f8304c = 0;
        c3030g2.f8305d = 0;
        m3678l();
        for (int i = 0; i < this.f8229h.size(); i++) {
            C3123x c3123x = this.f8229h.valueAt(i).f8268T;
            if (c3123x != null) {
                c3123x.f9005b = false;
                c3123x.f9006c = 0;
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
    /* JADX INFO: renamed from: h */
    public void m3676h(int i) throws ParserException {
        boolean z2;
        byte b2;
        boolean z3;
        int iM3010r;
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
        List<byte[]> listM6266u;
        byte[] bArr;
        int i4;
        C2811j1.b bVar;
        int i5;
        int i6;
        float f;
        int i7;
        C2777n c2777n;
        String str9;
        int iIntValue;
        int i8;
        Map<String, Integer> map;
        byte[] bArr2;
        int i9;
        int i10;
        int i11;
        String str10;
        C2778o c2778oM3126a;
        List<byte[]> list6;
        List<byte[]> list7;
        InterfaceC3119t bVar2;
        int i12;
        int i13;
        C1460d.m438H(this.f8227f0);
        int i14 = 0;
        if (i == 160) {
            if (this.f8206L != 2) {
                return;
            }
            int i15 = 0;
            for (int i16 = 0; i16 < this.f8210P; i16++) {
                i15 += this.f8211Q[i16];
            }
            c cVar = this.f8229h.get(this.f8212R);
            Objects.requireNonNull(cVar.f8272X);
            int i17 = 0;
            while (i17 < this.f8210P) {
                long j = this.f8207M + ((long) ((cVar.f8278e * i17) / 1000));
                int i18 = this.f8214T;
                if (i17 == 0 && !this.f8216V) {
                    i18 |= 1;
                }
                int i19 = this.f8211Q[i17];
                int i20 = i15 - i19;
                m3675d(cVar, j, i18, i19, i20);
                i17++;
                i15 = i20;
            }
            this.f8206L = 0;
            return;
        }
        if (i != 174) {
            if (i == 19899) {
                int i21 = this.f8196B;
                if (i21 != -1) {
                    long j2 = this.f8197C;
                    if (j2 != -1) {
                        if (i21 == 475249515) {
                            this.f8199E = j2;
                            return;
                        }
                        return;
                    }
                }
                throw ParserException.m8755a("Mandatory element SeekID or SeekPosition not found", null);
            }
            if (i == 25152) {
                m3674c(i);
                c cVar2 = this.f8247z;
                if (cVar2.f8281h) {
                    InterfaceC3122w.a aVar = cVar2.f8283j;
                    if (aVar == null) {
                        throw ParserException.m8755a("Encrypted Track found but ContentEncKeyID was not found", null);
                    }
                    cVar2.f8285l = new DrmInitData(null, true, new DrmInitData.SchemeData(C2997x0.f8021a, "video/webm", aVar.f9001b));
                    return;
                }
                return;
            }
            if (i == 28032) {
                m3674c(i);
                c cVar3 = this.f8247z;
                if (cVar3.f8281h && cVar3.f8282i != null) {
                    throw ParserException.m8755a("Combining encryption and compression is not supported", null);
                }
                return;
            }
            if (i == 357149030) {
                if (this.f8244w == -9223372036854775807L) {
                    this.f8244w = 1000000L;
                }
                long j3 = this.f8245x;
                if (j3 != -9223372036854775807L) {
                    this.f8246y = m3679m(j3);
                    return;
                }
                return;
            }
            if (i == 374648427) {
                if (this.f8229h.size() == 0) {
                    throw ParserException.m8755a("No valid tracks were found", null);
                }
                this.f8227f0.mo2486j();
                return;
            }
            if (i != 475249515) {
                return;
            }
            if (!this.f8195A) {
                InterfaceC3058j interfaceC3058j = this.f8227f0;
                C2751r c2751r = this.f8202H;
                C2751r c2751r2 = this.f8203I;
                if (this.f8243v == -1 || this.f8246y == -9223372036854775807L || c2751r == null || (i12 = c2751r.f6747a) == 0 || c2751r2 == null || c2751r2.f6747a != i12) {
                    bVar2 = new InterfaceC3119t.b(this.f8246y, 0L);
                } else {
                    int[] iArrCopyOf = new int[i12];
                    long[] jArrCopyOf = new long[i12];
                    long[] jArrCopyOf2 = new long[i12];
                    long[] jArrCopyOf3 = new long[i12];
                    for (int i22 = 0; i22 < i12; i22++) {
                        jArrCopyOf3[i22] = c2751r.m3042b(i22);
                        jArrCopyOf[i22] = c2751r2.m3042b(i22) + this.f8243v;
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
                    iArrCopyOf[i13] = (int) ((this.f8243v + this.f8242u) - jArrCopyOf[i13]);
                    jArrCopyOf2[i13] = this.f8246y - jArrCopyOf3[i13];
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
                    bVar2 = new C3003c(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
                }
                interfaceC3058j.mo2477a(bVar2);
                this.f8195A = true;
            }
            this.f8202H = null;
            this.f8203I = null;
            return;
        }
        ?? r0 = this.f8247z;
        C1460d.m438H(r0);
        String str11 = r0.f8275b;
        if (str11 == null) {
            throw ParserException.m8755a("CodecId is missing in TrackEntry element", null);
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
            InterfaceC3058j interfaceC3058j2 = this.f8227f0;
            int i24 = r0.f8276c;
            String str12 = r0.f8275b;
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
                    byte[] bArr3 = r0.f8284k;
                    str14 = "video/mp4v-es";
                    listSingletonList = bArr3 == null ? null : Collections.singletonList(bArr3);
                    i2 = -1;
                    list = listSingletonList;
                    str = null;
                    list6 = list;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null && (c2778oM3126a = C2778o.m3126a(new C2757x(bArr))) != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i25 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i26 = i25 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6 && (i9 = r0.f8289p) != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f || r0.f8253E == -1.0f || r0.f8254F == -1.0f || r0.f8255G == -1.0f || r0.f8256H == -1.0f || r0.f8257I == -1.0f || r0.f8258J == -1.0f || r0.f8259K == -1.0f || r0.f8260L == -1.0f || r0.f8261M == -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = new byte[25];
                                ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr2).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder.put((byte) 0);
                                byteBufferOrder.putShort((short) ((r0.f8252D * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.f8253E * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.f8254F * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.f8255G * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.f8256H * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.f8257I * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.f8258J * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.f8259K * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) (r0.f8260L + 0.5f));
                                byteBufferOrder.putShort((short) (r0.f8261M + 0.5f));
                                byteBufferOrder.putShort((short) r0.f8250B);
                                byteBufferOrder.putShort((short) r0.f8251C);
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0 || Float.compare(r0.f8292s, 0.0f) != 0 || Float.compare(r0.f8293t, 0.0f) != 0) {
                            i8 = iIntValue;
                        } else if (Float.compare(r0.f8294u, 0.0f) == 0) {
                            i8 = 0;
                        } else if (Float.compare(r0.f8293t, 90.0f) == 0) {
                            i8 = 90;
                        } else if (Float.compare(r0.f8293t, -180.0f) == 0 || Float.compare(r0.f8293t, 180.0f) == 0) {
                            i8 = 180;
                        } else if (Float.compare(r0.f8293t, -90.0f) == 0) {
                            i8 = 270;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14) && !"text/x-ssa".equals(str14) && !"application/vobsub".equals(str14) && !"application/pgs".equals(str14) && !"application/dvbsubs".equals(str14)) {
                            throw ParserException.m8755a("Unexpected MIME type.", null);
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null && !f8194e.containsKey(str10)) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i26;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p;
                    interfaceC3122wMo2492p.mo2526e(c2811j1M3277a);
                    this.f8229h.put(r0.f8276c, (c) r0);
                    break;
                case 2:
                    C2757x c2757x = new C2757x(r0.m3683a(r0.f8275b));
                    try {
                        int iM3092l = c2757x.m3092l();
                        if (iM3092l != 1) {
                            if (iM3092l == 65534) {
                                c2757x.m3079E(24);
                                long jM3093m = c2757x.m3093m();
                                UUID uuid = f8193d;
                                if (jM3093m != uuid.getMostSignificantBits() || c2757x.m3093m() != uuid.getLeastSignificantBits()) {
                                }
                                if (z3) {
                                    iM3010r = C2738e0.m3010r(r0.f8264P);
                                    if (iM3010r == 0) {
                                        int i27 = r0.f8264P;
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
                                    bArr = r0.f8262N;
                                    if (bArr != null) {
                                        str8 = c2778oM3126a.f6849a;
                                        str14 = "video/dolby-vision";
                                    }
                                    int i28 = r0.f8270V | 0;
                                    if (r0.f8269U) {
                                        i4 = 2;
                                    } else {
                                        i4 = 0;
                                    }
                                    int i29 = i28 | i4;
                                    bVar = new C2811j1.b();
                                    if (C2753t.m3050h(str14)) {
                                        bVar.f7186x = r0.f8263O;
                                        bVar.f7187y = r0.f8265Q;
                                        bVar.f7188z = iM3010r;
                                        i5 = 1;
                                    } else if (C2753t.m3052j(str14)) {
                                        if (r0.f8290q == 0) {
                                            i10 = r0.f8288o;
                                            i6 = -1;
                                            if (i10 == -1) {
                                                i10 = r0.f8286m;
                                            }
                                            r0.f8288o = i10;
                                            i11 = r0.f8289p;
                                            if (i11 == -1) {
                                                i11 = r0.f8287n;
                                            }
                                            r0.f8289p = i11;
                                        } else {
                                            i6 = -1;
                                        }
                                        f = -1.0f;
                                        i7 = r0.f8288o;
                                        if (i7 != i6) {
                                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                                        }
                                        if (r0.f8297x) {
                                            if (r0.f8252D != -1.0f) {
                                                bArr2 = null;
                                            } else {
                                                bArr2 = null;
                                            }
                                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                                        } else {
                                            c2777n = null;
                                        }
                                        str9 = r0.f8274a;
                                        if (str9 != null) {
                                            map = f8194e;
                                            if (map.containsKey(str9)) {
                                                iIntValue = map.get(r0.f8274a).intValue();
                                            } else {
                                                iIntValue = -1;
                                            }
                                        } else {
                                            iIntValue = -1;
                                        }
                                        if (r0.f8291r == 0) {
                                            i8 = iIntValue;
                                        } else {
                                            i8 = iIntValue;
                                        }
                                        bVar.f7178p = r0.f8286m;
                                        bVar.f7179q = r0.f8287n;
                                        bVar.f7182t = f;
                                        bVar.f7181s = i8;
                                        bVar.f7183u = r0.f8295v;
                                        bVar.f7184v = r0.f8296w;
                                        bVar.f7185w = c2777n;
                                        i5 = 2;
                                    } else {
                                        if ("application/x-subrip".equals(str14)) {
                                        }
                                        i5 = 3;
                                    }
                                    str10 = r0.f8274a;
                                    if (str10 != null) {
                                        bVar.f7164b = r0.f8274a;
                                    }
                                    bVar.m3278b(i24);
                                    bVar.f7173k = str14;
                                    bVar.f7174l = i3;
                                    bVar.f7165c = r0.f8271W;
                                    bVar.f7166d = i29;
                                    bVar.f7175m = list3;
                                    bVar.f7170h = str8;
                                    bVar.f7176n = r0.f8285l;
                                    C2811j1 c2811j1M3277a2 = bVar.m3277a();
                                    InterfaceC3122w interfaceC3122wMo2492p2 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                                    r0.f8272X = interfaceC3122wMo2492p2;
                                    interfaceC3122wMo2492p2.mo2526e(c2811j1M3277a2);
                                    this.f8229h.put(r0.f8276c, (c) r0);
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
                                iM3010r = -1;
                                bArr = r0.f8262N;
                                if (bArr != null) {
                                    str8 = c2778oM3126a.f6849a;
                                    str14 = "video/dolby-vision";
                                }
                                int i210 = r0.f8270V | 0;
                                if (r0.f8269U) {
                                    i4 = 2;
                                } else {
                                    i4 = 0;
                                }
                                int i211 = i210 | i4;
                                bVar = new C2811j1.b();
                                if (C2753t.m3050h(str14)) {
                                    bVar.f7186x = r0.f8263O;
                                    bVar.f7187y = r0.f8265Q;
                                    bVar.f7188z = iM3010r;
                                    i5 = 1;
                                } else if (C2753t.m3052j(str14)) {
                                    if (r0.f8290q == 0) {
                                        i10 = r0.f8288o;
                                        i6 = -1;
                                        if (i10 == -1) {
                                            i10 = r0.f8286m;
                                        }
                                        r0.f8288o = i10;
                                        i11 = r0.f8289p;
                                        if (i11 == -1) {
                                            i11 = r0.f8287n;
                                        }
                                        r0.f8289p = i11;
                                    } else {
                                        i6 = -1;
                                    }
                                    f = -1.0f;
                                    i7 = r0.f8288o;
                                    if (i7 != i6) {
                                        f = (r0.f8287n * i7) / (r0.f8286m * i9);
                                    }
                                    if (r0.f8297x) {
                                        if (r0.f8252D != -1.0f) {
                                            bArr2 = null;
                                        } else {
                                            bArr2 = null;
                                        }
                                        c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                                    } else {
                                        c2777n = null;
                                    }
                                    str9 = r0.f8274a;
                                    if (str9 != null) {
                                        map = f8194e;
                                        if (map.containsKey(str9)) {
                                            iIntValue = map.get(r0.f8274a).intValue();
                                        } else {
                                            iIntValue = -1;
                                        }
                                    } else {
                                        iIntValue = -1;
                                    }
                                    if (r0.f8291r == 0) {
                                        i8 = iIntValue;
                                    } else {
                                        i8 = iIntValue;
                                    }
                                    bVar.f7178p = r0.f8286m;
                                    bVar.f7179q = r0.f8287n;
                                    bVar.f7182t = f;
                                    bVar.f7181s = i8;
                                    bVar.f7183u = r0.f8295v;
                                    bVar.f7184v = r0.f8296w;
                                    bVar.f7185w = c2777n;
                                    i5 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str14)) {
                                    }
                                    i5 = 3;
                                }
                                str10 = r0.f8274a;
                                if (str10 != null) {
                                    bVar.f7164b = r0.f8274a;
                                }
                                bVar.m3278b(i24);
                                bVar.f7173k = str14;
                                bVar.f7174l = i3;
                                bVar.f7165c = r0.f8271W;
                                bVar.f7166d = i211;
                                bVar.f7175m = list3;
                                bVar.f7170h = str8;
                                bVar.f7176n = r0.f8285l;
                                C2811j1 c2811j1M3277a3 = bVar.m3277a();
                                InterfaceC3122w interfaceC3122wMo2492p3 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                                r0.f8272X = interfaceC3122wMo2492p3;
                                interfaceC3122wMo2492p3.mo2526e(c2811j1M3277a3);
                                this.f8229h.put(r0.f8276c, (c) r0);
                            }
                            z3 = false;
                            if (z3) {
                                iM3010r = C2738e0.m3010r(r0.f8264P);
                                if (iM3010r == 0) {
                                    int i212 = r0.f8264P;
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
                                bArr = r0.f8262N;
                                if (bArr != null) {
                                    str8 = c2778oM3126a.f6849a;
                                    str14 = "video/dolby-vision";
                                }
                                int i213 = r0.f8270V | 0;
                                if (r0.f8269U) {
                                    i4 = 2;
                                } else {
                                    i4 = 0;
                                }
                                int i214 = i213 | i4;
                                bVar = new C2811j1.b();
                                if (C2753t.m3050h(str14)) {
                                    bVar.f7186x = r0.f8263O;
                                    bVar.f7187y = r0.f8265Q;
                                    bVar.f7188z = iM3010r;
                                    i5 = 1;
                                } else if (C2753t.m3052j(str14)) {
                                    if (r0.f8290q == 0) {
                                        i10 = r0.f8288o;
                                        i6 = -1;
                                        if (i10 == -1) {
                                            i10 = r0.f8286m;
                                        }
                                        r0.f8288o = i10;
                                        i11 = r0.f8289p;
                                        if (i11 == -1) {
                                            i11 = r0.f8287n;
                                        }
                                        r0.f8289p = i11;
                                    } else {
                                        i6 = -1;
                                    }
                                    f = -1.0f;
                                    i7 = r0.f8288o;
                                    if (i7 != i6) {
                                        f = (r0.f8287n * i7) / (r0.f8286m * i9);
                                    }
                                    if (r0.f8297x) {
                                        if (r0.f8252D != -1.0f) {
                                            bArr2 = null;
                                        } else {
                                            bArr2 = null;
                                        }
                                        c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                                    } else {
                                        c2777n = null;
                                    }
                                    str9 = r0.f8274a;
                                    if (str9 != null) {
                                        map = f8194e;
                                        if (map.containsKey(str9)) {
                                            iIntValue = map.get(r0.f8274a).intValue();
                                        } else {
                                            iIntValue = -1;
                                        }
                                    } else {
                                        iIntValue = -1;
                                    }
                                    if (r0.f8291r == 0) {
                                        i8 = iIntValue;
                                    } else {
                                        i8 = iIntValue;
                                    }
                                    bVar.f7178p = r0.f8286m;
                                    bVar.f7179q = r0.f8287n;
                                    bVar.f7182t = f;
                                    bVar.f7181s = i8;
                                    bVar.f7183u = r0.f8295v;
                                    bVar.f7184v = r0.f8296w;
                                    bVar.f7185w = c2777n;
                                    i5 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str14)) {
                                    }
                                    i5 = 3;
                                }
                                str10 = r0.f8274a;
                                if (str10 != null) {
                                    bVar.f7164b = r0.f8274a;
                                }
                                bVar.m3278b(i24);
                                bVar.f7173k = str14;
                                bVar.f7174l = i3;
                                bVar.f7165c = r0.f8271W;
                                bVar.f7166d = i214;
                                bVar.f7175m = list3;
                                bVar.f7170h = str8;
                                bVar.f7176n = r0.f8285l;
                                C2811j1 c2811j1M3277a4 = bVar.m3277a();
                                InterfaceC3122w interfaceC3122wMo2492p4 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                                r0.f8272X = interfaceC3122wMo2492p4;
                                interfaceC3122wMo2492p4.mo2526e(c2811j1M3277a4);
                                this.f8229h.put(r0.f8276c, (c) r0);
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
                            iM3010r = -1;
                            bArr = r0.f8262N;
                            if (bArr != null) {
                                str8 = c2778oM3126a.f6849a;
                                str14 = "video/dolby-vision";
                            }
                            int i215 = r0.f8270V | 0;
                            if (r0.f8269U) {
                                i4 = 2;
                            } else {
                                i4 = 0;
                            }
                            int i216 = i215 | i4;
                            bVar = new C2811j1.b();
                            if (C2753t.m3050h(str14)) {
                                bVar.f7186x = r0.f8263O;
                                bVar.f7187y = r0.f8265Q;
                                bVar.f7188z = iM3010r;
                                i5 = 1;
                            } else if (C2753t.m3052j(str14)) {
                                if (r0.f8290q == 0) {
                                    i10 = r0.f8288o;
                                    i6 = -1;
                                    if (i10 == -1) {
                                        i10 = r0.f8286m;
                                    }
                                    r0.f8288o = i10;
                                    i11 = r0.f8289p;
                                    if (i11 == -1) {
                                        i11 = r0.f8287n;
                                    }
                                    r0.f8289p = i11;
                                } else {
                                    i6 = -1;
                                }
                                f = -1.0f;
                                i7 = r0.f8288o;
                                if (i7 != i6) {
                                    f = (r0.f8287n * i7) / (r0.f8286m * i9);
                                }
                                if (r0.f8297x) {
                                    if (r0.f8252D != -1.0f) {
                                        bArr2 = null;
                                    } else {
                                        bArr2 = null;
                                    }
                                    c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                                } else {
                                    c2777n = null;
                                }
                                str9 = r0.f8274a;
                                if (str9 != null) {
                                    map = f8194e;
                                    if (map.containsKey(str9)) {
                                        iIntValue = map.get(r0.f8274a).intValue();
                                    } else {
                                        iIntValue = -1;
                                    }
                                } else {
                                    iIntValue = -1;
                                }
                                if (r0.f8291r == 0) {
                                    i8 = iIntValue;
                                } else {
                                    i8 = iIntValue;
                                }
                                bVar.f7178p = r0.f8286m;
                                bVar.f7179q = r0.f8287n;
                                bVar.f7182t = f;
                                bVar.f7181s = i8;
                                bVar.f7183u = r0.f8295v;
                                bVar.f7184v = r0.f8296w;
                                bVar.f7185w = c2777n;
                                i5 = 2;
                            } else {
                                if ("application/x-subrip".equals(str14)) {
                                }
                                i5 = 3;
                            }
                            str10 = r0.f8274a;
                            if (str10 != null) {
                                bVar.f7164b = r0.f8274a;
                            }
                            bVar.m3278b(i24);
                            bVar.f7173k = str14;
                            bVar.f7174l = i3;
                            bVar.f7165c = r0.f8271W;
                            bVar.f7166d = i216;
                            bVar.f7175m = list3;
                            bVar.f7170h = str8;
                            bVar.f7176n = r0.f8285l;
                            C2811j1 c2811j1M3277a5 = bVar.m3277a();
                            InterfaceC3122w interfaceC3122wMo2492p5 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                            r0.f8272X = interfaceC3122wMo2492p5;
                            interfaceC3122wMo2492p5.mo2526e(c2811j1M3277a5);
                            this.f8229h.put(r0.f8276c, (c) r0);
                            break;
                        }
                        z3 = true;
                        if (z3) {
                            iM3010r = C2738e0.m3010r(r0.f8264P);
                            if (iM3010r == 0) {
                                int i217 = r0.f8264P;
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
                            bArr = r0.f8262N;
                            if (bArr != null) {
                                str8 = c2778oM3126a.f6849a;
                                str14 = "video/dolby-vision";
                            }
                            int i218 = r0.f8270V | 0;
                            if (r0.f8269U) {
                                i4 = 2;
                            } else {
                                i4 = 0;
                            }
                            int i219 = i218 | i4;
                            bVar = new C2811j1.b();
                            if (C2753t.m3050h(str14)) {
                                bVar.f7186x = r0.f8263O;
                                bVar.f7187y = r0.f8265Q;
                                bVar.f7188z = iM3010r;
                                i5 = 1;
                            } else if (C2753t.m3052j(str14)) {
                                if (r0.f8290q == 0) {
                                    i10 = r0.f8288o;
                                    i6 = -1;
                                    if (i10 == -1) {
                                        i10 = r0.f8286m;
                                    }
                                    r0.f8288o = i10;
                                    i11 = r0.f8289p;
                                    if (i11 == -1) {
                                        i11 = r0.f8287n;
                                    }
                                    r0.f8289p = i11;
                                } else {
                                    i6 = -1;
                                }
                                f = -1.0f;
                                i7 = r0.f8288o;
                                if (i7 != i6) {
                                    f = (r0.f8287n * i7) / (r0.f8286m * i9);
                                }
                                if (r0.f8297x) {
                                    if (r0.f8252D != -1.0f) {
                                        bArr2 = null;
                                    } else {
                                        bArr2 = null;
                                    }
                                    c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                                } else {
                                    c2777n = null;
                                }
                                str9 = r0.f8274a;
                                if (str9 != null) {
                                    map = f8194e;
                                    if (map.containsKey(str9)) {
                                        iIntValue = map.get(r0.f8274a).intValue();
                                    } else {
                                        iIntValue = -1;
                                    }
                                } else {
                                    iIntValue = -1;
                                }
                                if (r0.f8291r == 0) {
                                    i8 = iIntValue;
                                } else {
                                    i8 = iIntValue;
                                }
                                bVar.f7178p = r0.f8286m;
                                bVar.f7179q = r0.f8287n;
                                bVar.f7182t = f;
                                bVar.f7181s = i8;
                                bVar.f7183u = r0.f8295v;
                                bVar.f7184v = r0.f8296w;
                                bVar.f7185w = c2777n;
                                i5 = 2;
                            } else {
                                if ("application/x-subrip".equals(str14)) {
                                }
                                i5 = 3;
                            }
                            str10 = r0.f8274a;
                            if (str10 != null) {
                                bVar.f7164b = r0.f8274a;
                            }
                            bVar.m3278b(i24);
                            bVar.f7173k = str14;
                            bVar.f7174l = i3;
                            bVar.f7165c = r0.f8271W;
                            bVar.f7166d = i219;
                            bVar.f7175m = list3;
                            bVar.f7170h = str8;
                            bVar.f7176n = r0.f8285l;
                            C2811j1 c2811j1M3277a6 = bVar.m3277a();
                            InterfaceC3122w interfaceC3122wMo2492p6 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                            r0.f8272X = interfaceC3122wMo2492p6;
                            interfaceC3122wMo2492p6.mo2526e(c2811j1M3277a6);
                            this.f8229h.put(r0.f8276c, (c) r0);
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
                        iM3010r = -1;
                        bArr = r0.f8262N;
                        if (bArr != null) {
                            str8 = c2778oM3126a.f6849a;
                            str14 = "video/dolby-vision";
                        }
                        int i2110 = r0.f8270V | 0;
                        if (r0.f8269U) {
                            i4 = 2;
                        } else {
                            i4 = 0;
                        }
                        int i2111 = i2110 | i4;
                        bVar = new C2811j1.b();
                        if (C2753t.m3050h(str14)) {
                            bVar.f7186x = r0.f8263O;
                            bVar.f7187y = r0.f8265Q;
                            bVar.f7188z = iM3010r;
                            i5 = 1;
                        } else if (C2753t.m3052j(str14)) {
                            if (r0.f8290q == 0) {
                                i10 = r0.f8288o;
                                i6 = -1;
                                if (i10 == -1) {
                                    i10 = r0.f8286m;
                                }
                                r0.f8288o = i10;
                                i11 = r0.f8289p;
                                if (i11 == -1) {
                                    i11 = r0.f8287n;
                                }
                                r0.f8289p = i11;
                            } else {
                                i6 = -1;
                            }
                            f = -1.0f;
                            i7 = r0.f8288o;
                            if (i7 != i6) {
                                f = (r0.f8287n * i7) / (r0.f8286m * i9);
                            }
                            if (r0.f8297x) {
                                if (r0.f8252D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                            } else {
                                c2777n = null;
                            }
                            str9 = r0.f8274a;
                            if (str9 != null) {
                                map = f8194e;
                                if (map.containsKey(str9)) {
                                    iIntValue = map.get(r0.f8274a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.f8291r == 0) {
                                i8 = iIntValue;
                            } else {
                                i8 = iIntValue;
                            }
                            bVar.f7178p = r0.f8286m;
                            bVar.f7179q = r0.f8287n;
                            bVar.f7182t = f;
                            bVar.f7181s = i8;
                            bVar.f7183u = r0.f8295v;
                            bVar.f7184v = r0.f8296w;
                            bVar.f7185w = c2777n;
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str14)) {
                            }
                            i5 = 3;
                        }
                        str10 = r0.f8274a;
                        if (str10 != null) {
                            bVar.f7164b = r0.f8274a;
                        }
                        bVar.m3278b(i24);
                        bVar.f7173k = str14;
                        bVar.f7174l = i3;
                        bVar.f7165c = r0.f8271W;
                        bVar.f7166d = i2111;
                        bVar.f7175m = list3;
                        bVar.f7170h = str8;
                        bVar.f7176n = r0.f8285l;
                        C2811j1 c2811j1M3277a7 = bVar.m3277a();
                        InterfaceC3122w interfaceC3122wMo2492p7 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                        r0.f8272X = interfaceC3122wMo2492p7;
                        interfaceC3122wMo2492p7.mo2526e(c2811j1M3277a7);
                        this.f8229h.put(r0.f8276c, (c) r0);
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw ParserException.m8755a("Error parsing MS/ACM codec private", null);
                    }
                    break;
                case 3:
                    r0.f8268T = new C3123x();
                    str14 = "audio/true-hd";
                    listSingletonList = null;
                    i2 = -1;
                    list = listSingletonList;
                    str = null;
                    list6 = list;
                    str8 = str;
                    i3 = i2;
                    list3 = list6;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i2112 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i2113 = i2112 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i2113;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a8 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p8 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p8;
                    interfaceC3122wMo2492p8.mo2526e(c2811j1M3277a8);
                    this.f8229h.put(r0.f8276c, (c) r0);
                    break;
                case 4:
                    byte[] bArrM3683a = r0.m3683a(r0.f8275b);
                    try {
                        try {
                            if (bArrM3683a[0] != 2) {
                                throw ParserException.m8755a("Error parsing vorbis codec private", null);
                            }
                            int i30 = 1;
                            int i31 = 0;
                            while ((bArrM3683a[i30] & 255) == 255) {
                                i31 += 255;
                                i30++;
                            }
                            int i32 = i30 + 1;
                            int i33 = i31 + (bArrM3683a[i30] & 255);
                            int i34 = 0;
                            while ((bArrM3683a[i32] & 255) == 255) {
                                i34 += 255;
                                i32++;
                            }
                            int i35 = i32 + 1;
                            int i36 = i34 + (bArrM3683a[i32] & 255);
                            if (bArrM3683a[i35] != 1) {
                                throw ParserException.m8755a("Error parsing vorbis codec private", null);
                            }
                            byte[] bArr4 = new byte[i33];
                            System.arraycopy(bArrM3683a, i35, bArr4, 0, i33);
                            int i37 = i35 + i33;
                            if (bArrM3683a[i37] != 3) {
                                throw ParserException.m8755a("Error parsing vorbis codec private", null);
                            }
                            int i38 = i37 + i36;
                            if (bArrM3683a[i38] != 5) {
                                throw ParserException.m8755a("Error parsing vorbis codec private", null);
                            }
                            byte[] bArr5 = new byte[bArrM3683a.length - i38];
                            System.arraycopy(bArrM3683a, i38, bArr5, 0, bArrM3683a.length - i38);
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
                            iM3010r = -1;
                            bArr = r0.f8262N;
                            if (bArr != null) {
                                str8 = c2778oM3126a.f6849a;
                                str14 = "video/dolby-vision";
                            }
                            int i2114 = r0.f8270V | 0;
                            if (r0.f8269U) {
                                i4 = 2;
                            } else {
                                i4 = 0;
                            }
                            int i2115 = i2114 | i4;
                            bVar = new C2811j1.b();
                            if (C2753t.m3050h(str14)) {
                                bVar.f7186x = r0.f8263O;
                                bVar.f7187y = r0.f8265Q;
                                bVar.f7188z = iM3010r;
                                i5 = 1;
                            } else if (C2753t.m3052j(str14)) {
                                if (r0.f8290q == 0) {
                                    i10 = r0.f8288o;
                                    i6 = -1;
                                    if (i10 == -1) {
                                        i10 = r0.f8286m;
                                    }
                                    r0.f8288o = i10;
                                    i11 = r0.f8289p;
                                    if (i11 == -1) {
                                        i11 = r0.f8287n;
                                    }
                                    r0.f8289p = i11;
                                } else {
                                    i6 = -1;
                                }
                                f = -1.0f;
                                i7 = r0.f8288o;
                                if (i7 != i6) {
                                    f = (r0.f8287n * i7) / (r0.f8286m * i9);
                                }
                                if (r0.f8297x) {
                                    if (r0.f8252D != -1.0f) {
                                        bArr2 = null;
                                    } else {
                                        bArr2 = null;
                                    }
                                    c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                                } else {
                                    c2777n = null;
                                }
                                str9 = r0.f8274a;
                                if (str9 != null) {
                                    map = f8194e;
                                    if (map.containsKey(str9)) {
                                        iIntValue = map.get(r0.f8274a).intValue();
                                    } else {
                                        iIntValue = -1;
                                    }
                                } else {
                                    iIntValue = -1;
                                }
                                if (r0.f8291r == 0) {
                                    i8 = iIntValue;
                                } else {
                                    i8 = iIntValue;
                                }
                                bVar.f7178p = r0.f8286m;
                                bVar.f7179q = r0.f8287n;
                                bVar.f7182t = f;
                                bVar.f7181s = i8;
                                bVar.f7183u = r0.f8295v;
                                bVar.f7184v = r0.f8296w;
                                bVar.f7185w = c2777n;
                                i5 = 2;
                            } else {
                                if ("application/x-subrip".equals(str14)) {
                                }
                                i5 = 3;
                            }
                            str10 = r0.f8274a;
                            if (str10 != null) {
                                bVar.f7164b = r0.f8274a;
                            }
                            bVar.m3278b(i24);
                            bVar.f7173k = str14;
                            bVar.f7174l = i3;
                            bVar.f7165c = r0.f8271W;
                            bVar.f7166d = i2115;
                            bVar.f7175m = list3;
                            bVar.f7170h = str8;
                            bVar.f7176n = r0.f8285l;
                            C2811j1 c2811j1M3277a9 = bVar.m3277a();
                            InterfaceC3122w interfaceC3122wMo2492p9 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                            r0.f8272X = interfaceC3122wMo2492p9;
                            interfaceC3122wMo2492p9.mo2526e(c2811j1M3277a9);
                            this.f8229h.put(r0.f8276c, (c) r0);
                        } catch (ArrayIndexOutOfBoundsException unused2) {
                            throw ParserException.m8755a("Error parsing vorbis codec private", r0);
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
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i2116 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i2117 = i2116 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i2117;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a10 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p10 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p10;
                    interfaceC3122wMo2492p10.mo2526e(c2811j1M3277a10);
                    this.f8229h.put(r0.f8276c, (c) r0);
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
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i2118 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i2119 = i2118 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i2119;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a11 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p11 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p11;
                    interfaceC3122wMo2492p11.mo2526e(c2811j1M3277a11);
                    this.f8229h.put(r0.f8276c, (c) r0);
                    break;
                case 7:
                    byte[] bArrM3683a2 = r0.m3683a(r0.f8275b);
                    try {
                        C1460d.m531j(16 <= bArrM3683a2.length);
                        long j5 = (((long) bArrM3683a2[16]) & 255) | ((((long) bArrM3683a2[17]) & 255) << 8) | ((((long) bArrM3683a2[18]) & 255) << 16) | ((255 & ((long) bArrM3683a2[19])) << 24);
                        if (j5 == 1482049860) {
                            pair2 = new Pair("video/divx", null);
                        } else if (j5 == 859189832) {
                            pair2 = new Pair("video/3gpp", null);
                        } else {
                            if (j5 == 826496599) {
                                int i39 = 40;
                                while (true) {
                                    if (i39 >= bArrM3683a2.length - 4) {
                                        throw ParserException.m8755a("Failed to find FourCC VC1 initialization data", null);
                                    }
                                    if (bArrM3683a2[i39] == 0 && bArrM3683a2[i39 + 1] == 0 && bArrM3683a2[i39 + 2] == 1) {
                                        if (bArrM3683a2[i39 + 3] == 15) {
                                            pair = new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArrM3683a2, i39, bArrM3683a2.length)));
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
                        listM6266u = (List) pair2.second;
                        str3 = str4;
                        list4 = listM6266u;
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
                        iM3010r = -1;
                        bArr = r0.f8262N;
                        if (bArr != null) {
                            str8 = c2778oM3126a.f6849a;
                            str14 = "video/dolby-vision";
                        }
                        int i21110 = r0.f8270V | 0;
                        if (r0.f8269U) {
                            i4 = 2;
                        } else {
                            i4 = 0;
                        }
                        int i21111 = i21110 | i4;
                        bVar = new C2811j1.b();
                        if (C2753t.m3050h(str14)) {
                            bVar.f7186x = r0.f8263O;
                            bVar.f7187y = r0.f8265Q;
                            bVar.f7188z = iM3010r;
                            i5 = 1;
                        } else if (C2753t.m3052j(str14)) {
                            if (r0.f8290q == 0) {
                                i10 = r0.f8288o;
                                i6 = -1;
                                if (i10 == -1) {
                                    i10 = r0.f8286m;
                                }
                                r0.f8288o = i10;
                                i11 = r0.f8289p;
                                if (i11 == -1) {
                                    i11 = r0.f8287n;
                                }
                                r0.f8289p = i11;
                            } else {
                                i6 = -1;
                            }
                            f = -1.0f;
                            i7 = r0.f8288o;
                            if (i7 != i6) {
                                f = (r0.f8287n * i7) / (r0.f8286m * i9);
                            }
                            if (r0.f8297x) {
                                if (r0.f8252D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                            } else {
                                c2777n = null;
                            }
                            str9 = r0.f8274a;
                            if (str9 != null) {
                                map = f8194e;
                                if (map.containsKey(str9)) {
                                    iIntValue = map.get(r0.f8274a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.f8291r == 0) {
                                i8 = iIntValue;
                            } else {
                                i8 = iIntValue;
                            }
                            bVar.f7178p = r0.f8286m;
                            bVar.f7179q = r0.f8287n;
                            bVar.f7182t = f;
                            bVar.f7181s = i8;
                            bVar.f7183u = r0.f8295v;
                            bVar.f7184v = r0.f8296w;
                            bVar.f7185w = c2777n;
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str14)) {
                            }
                            i5 = 3;
                        }
                        str10 = r0.f8274a;
                        if (str10 != null) {
                            bVar.f7164b = r0.f8274a;
                        }
                        bVar.m3278b(i24);
                        bVar.f7173k = str14;
                        bVar.f7174l = i3;
                        bVar.f7165c = r0.f8271W;
                        bVar.f7166d = i21111;
                        bVar.f7175m = list3;
                        bVar.f7170h = str8;
                        bVar.f7176n = r0.f8285l;
                        C2811j1 c2811j1M3277a12 = bVar.m3277a();
                        InterfaceC3122w interfaceC3122wMo2492p12 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                        r0.f8272X = interfaceC3122wMo2492p12;
                        interfaceC3122wMo2492p12.mo2526e(c2811j1M3277a12);
                        this.f8229h.put(r0.f8276c, (c) r0);
                    } catch (ArrayIndexOutOfBoundsException unused4) {
                        throw ParserException.m8755a("Error parsing FourCC private data", null);
                    }
                    break;
                case 8:
                    byte[] bArr6 = new byte[4];
                    System.arraycopy(r0.m3683a(r0.f8275b), 0, bArr6, 0, 4);
                    AbstractC4523p abstractC4523pM6266u = AbstractC4523p.m6266u(bArr6);
                    str4 = "application/dvbsubs";
                    listM6266u = abstractC4523pM6266u;
                    str3 = str4;
                    list4 = listM6266u;
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
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i21112 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i21113 = i21112 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i21113;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a13 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p13 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p13;
                    interfaceC3122wMo2492p13.mo2526e(c2811j1M3277a13);
                    this.f8229h.put(r0.f8276c, (c) r0);
                    break;
                case 10:
                    C2776m c2776mM3122b = C2776m.m3122b(new C2757x(r0.m3683a(r0.f8275b)));
                    list2 = c2776mM3122b.f6837a;
                    r0.f8273Y = c2776mM3122b.f6838b;
                    str5 = c2776mM3122b.f6842f;
                    str6 = "video/avc";
                    str8 = str5;
                    str14 = str6;
                    iM3010r = -1;
                    i3 = -1;
                    list3 = list2;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i21114 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i21115 = i21114 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i21115;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a14 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p14 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p14;
                    interfaceC3122wMo2492p14.mo2526e(c2811j1M3277a14);
                    this.f8229h.put(r0.f8276c, (c) r0);
                    break;
                case 11:
                    str4 = "application/vobsub";
                    listM6266u = AbstractC4523p.m6266u(r0.m3683a(r0.f8275b));
                    str3 = str4;
                    list4 = listM6266u;
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
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i21116 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i21117 = i21116 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i21117;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a15 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p15 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p15;
                    interfaceC3122wMo2492p15.mo2526e(c2811j1M3277a15);
                    this.f8229h.put(r0.f8276c, (c) r0);
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
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i21118 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i21119 = i21118 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i21119;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a16 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p16 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p16;
                    interfaceC3122wMo2492p16.mo2526e(c2811j1M3277a16);
                    this.f8229h.put(r0.f8276c, (c) r0);
                    break;
                case 13:
                    List<byte[]> listSingletonList2 = Collections.singletonList(r0.m3683a(r0.f8275b));
                    C2928l.b bVarM3490c = C2928l.m3490c(r0.f8284k);
                    r0.f8265Q = bVarM3490c.f7766a;
                    r0.f8263O = bVarM3490c.f7767b;
                    str7 = bVarM3490c.f7768c;
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
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i211110 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211111 = i211110 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i211111;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a17 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p17 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p17;
                    interfaceC3122wMo2492p17.mo2526e(c2811j1M3277a17);
                    this.f8229h.put(r0.f8276c, (c) r0);
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
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i211112 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211113 = i211112 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i211113;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a18 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p18 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p18;
                    interfaceC3122wMo2492p18.mo2526e(c2811j1M3277a18);
                    this.f8229h.put(r0.f8276c, (c) r0);
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
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i211114 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211115 = i211114 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i211115;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a19 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p19 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p19;
                    interfaceC3122wMo2492p19.mo2526e(c2811j1M3277a19);
                    this.f8229h.put(r0.f8276c, (c) r0);
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
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i211116 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211117 = i211116 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i211117;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a110 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p110 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p110;
                    interfaceC3122wMo2492p110.mo2526e(c2811j1M3277a110);
                    this.f8229h.put(r0.f8276c, (c) r0);
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
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i211118 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211119 = i211118 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i211119;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a111 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p111 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p111;
                    interfaceC3122wMo2492p111.mo2526e(c2811j1M3277a111);
                    this.f8229h.put(r0.f8276c, (c) r0);
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
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i2111110 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i2111111 = i2111110 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i2111111;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a112 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p112 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p112;
                    interfaceC3122wMo2492p112.mo2526e(c2811j1M3277a112);
                    this.f8229h.put(r0.f8276c, (c) r0);
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
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i2111112 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i2111113 = i2111112 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i2111113;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a113 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p113 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p113;
                    interfaceC3122wMo2492p113.mo2526e(c2811j1M3277a113);
                    this.f8229h.put(r0.f8276c, (c) r0);
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
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i2111114 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i2111115 = i2111114 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i2111115;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a114 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p114 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p114;
                    interfaceC3122wMo2492p114.mo2526e(c2811j1M3277a114);
                    this.f8229h.put(r0.f8276c, (c) r0);
                    break;
                case 22:
                    int i40 = r0.f8264P;
                    if (i40 == 32) {
                        iM3010r = 4;
                        str14 = "audio/raw";
                        list3 = null;
                        i3 = -1;
                        str8 = null;
                        bArr = r0.f8262N;
                        if (bArr != null) {
                            str8 = c2778oM3126a.f6849a;
                            str14 = "video/dolby-vision";
                        }
                        int i2111116 = r0.f8270V | 0;
                        if (r0.f8269U) {
                            i4 = 2;
                        } else {
                            i4 = 0;
                        }
                        int i2111117 = i2111116 | i4;
                        bVar = new C2811j1.b();
                        if (C2753t.m3050h(str14)) {
                            bVar.f7186x = r0.f8263O;
                            bVar.f7187y = r0.f8265Q;
                            bVar.f7188z = iM3010r;
                            i5 = 1;
                        } else if (C2753t.m3052j(str14)) {
                            if (r0.f8290q == 0) {
                                i10 = r0.f8288o;
                                i6 = -1;
                                if (i10 == -1) {
                                    i10 = r0.f8286m;
                                }
                                r0.f8288o = i10;
                                i11 = r0.f8289p;
                                if (i11 == -1) {
                                    i11 = r0.f8287n;
                                }
                                r0.f8289p = i11;
                            } else {
                                i6 = -1;
                            }
                            f = -1.0f;
                            i7 = r0.f8288o;
                            if (i7 != i6) {
                                f = (r0.f8287n * i7) / (r0.f8286m * i9);
                            }
                            if (r0.f8297x) {
                                if (r0.f8252D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                            } else {
                                c2777n = null;
                            }
                            str9 = r0.f8274a;
                            if (str9 != null) {
                                map = f8194e;
                                if (map.containsKey(str9)) {
                                    iIntValue = map.get(r0.f8274a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.f8291r == 0) {
                                i8 = iIntValue;
                            } else {
                                i8 = iIntValue;
                            }
                            bVar.f7178p = r0.f8286m;
                            bVar.f7179q = r0.f8287n;
                            bVar.f7182t = f;
                            bVar.f7181s = i8;
                            bVar.f7183u = r0.f8295v;
                            bVar.f7184v = r0.f8296w;
                            bVar.f7185w = c2777n;
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str14)) {
                            }
                            i5 = 3;
                        }
                        str10 = r0.f8274a;
                        if (str10 != null) {
                            bVar.f7164b = r0.f8274a;
                        }
                        bVar.m3278b(i24);
                        bVar.f7173k = str14;
                        bVar.f7174l = i3;
                        bVar.f7165c = r0.f8271W;
                        bVar.f7166d = i2111117;
                        bVar.f7175m = list3;
                        bVar.f7170h = str8;
                        bVar.f7176n = r0.f8285l;
                        C2811j1 c2811j1M3277a115 = bVar.m3277a();
                        InterfaceC3122w interfaceC3122wMo2492p115 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                        r0.f8272X = interfaceC3122wMo2492p115;
                        interfaceC3122wMo2492p115.mo2526e(c2811j1M3277a115);
                        this.f8229h.put(r0.f8276c, (c) r0);
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
                        iM3010r = -1;
                        bArr = r0.f8262N;
                        if (bArr != null) {
                            str8 = c2778oM3126a.f6849a;
                            str14 = "video/dolby-vision";
                        }
                        int i2111118 = r0.f8270V | 0;
                        if (r0.f8269U) {
                            i4 = 2;
                        } else {
                            i4 = 0;
                        }
                        int i2111119 = i2111118 | i4;
                        bVar = new C2811j1.b();
                        if (C2753t.m3050h(str14)) {
                            bVar.f7186x = r0.f8263O;
                            bVar.f7187y = r0.f8265Q;
                            bVar.f7188z = iM3010r;
                            i5 = 1;
                        } else if (C2753t.m3052j(str14)) {
                            if (r0.f8290q == 0) {
                                i10 = r0.f8288o;
                                i6 = -1;
                                if (i10 == -1) {
                                    i10 = r0.f8286m;
                                }
                                r0.f8288o = i10;
                                i11 = r0.f8289p;
                                if (i11 == -1) {
                                    i11 = r0.f8287n;
                                }
                                r0.f8289p = i11;
                            } else {
                                i6 = -1;
                            }
                            f = -1.0f;
                            i7 = r0.f8288o;
                            if (i7 != i6) {
                                f = (r0.f8287n * i7) / (r0.f8286m * i9);
                            }
                            if (r0.f8297x) {
                                if (r0.f8252D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                            } else {
                                c2777n = null;
                            }
                            str9 = r0.f8274a;
                            if (str9 != null) {
                                map = f8194e;
                                if (map.containsKey(str9)) {
                                    iIntValue = map.get(r0.f8274a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.f8291r == 0) {
                                i8 = iIntValue;
                            } else {
                                i8 = iIntValue;
                            }
                            bVar.f7178p = r0.f8286m;
                            bVar.f7179q = r0.f8287n;
                            bVar.f7182t = f;
                            bVar.f7181s = i8;
                            bVar.f7183u = r0.f8295v;
                            bVar.f7184v = r0.f8296w;
                            bVar.f7185w = c2777n;
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str14)) {
                            }
                            i5 = 3;
                        }
                        str10 = r0.f8274a;
                        if (str10 != null) {
                            bVar.f7164b = r0.f8274a;
                        }
                        bVar.m3278b(i24);
                        bVar.f7173k = str14;
                        bVar.f7174l = i3;
                        bVar.f7165c = r0.f8271W;
                        bVar.f7166d = i2111119;
                        bVar.f7175m = list3;
                        bVar.f7170h = str8;
                        bVar.f7176n = r0.f8285l;
                        C2811j1 c2811j1M3277a116 = bVar.m3277a();
                        InterfaceC3122w interfaceC3122wMo2492p116 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                        r0.f8272X = interfaceC3122wMo2492p116;
                        interfaceC3122wMo2492p116.mo2526e(c2811j1M3277a116);
                        this.f8229h.put(r0.f8276c, (c) r0);
                    }
                    break;
                case 23:
                    int i41 = r0.f8264P;
                    if (i41 == 8) {
                        iM3010r = 3;
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
                        iM3010r = -1;
                        bArr = r0.f8262N;
                        if (bArr != null) {
                            str8 = c2778oM3126a.f6849a;
                            str14 = "video/dolby-vision";
                        }
                        int i21111110 = r0.f8270V | 0;
                        if (r0.f8269U) {
                            i4 = 2;
                        } else {
                            i4 = 0;
                        }
                        int i21111111 = i21111110 | i4;
                        bVar = new C2811j1.b();
                        if (C2753t.m3050h(str14)) {
                            bVar.f7186x = r0.f8263O;
                            bVar.f7187y = r0.f8265Q;
                            bVar.f7188z = iM3010r;
                            i5 = 1;
                        } else if (C2753t.m3052j(str14)) {
                            if (r0.f8290q == 0) {
                                i10 = r0.f8288o;
                                i6 = -1;
                                if (i10 == -1) {
                                    i10 = r0.f8286m;
                                }
                                r0.f8288o = i10;
                                i11 = r0.f8289p;
                                if (i11 == -1) {
                                    i11 = r0.f8287n;
                                }
                                r0.f8289p = i11;
                            } else {
                                i6 = -1;
                            }
                            f = -1.0f;
                            i7 = r0.f8288o;
                            if (i7 != i6) {
                                f = (r0.f8287n * i7) / (r0.f8286m * i9);
                            }
                            if (r0.f8297x) {
                                if (r0.f8252D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                            } else {
                                c2777n = null;
                            }
                            str9 = r0.f8274a;
                            if (str9 != null) {
                                map = f8194e;
                                if (map.containsKey(str9)) {
                                    iIntValue = map.get(r0.f8274a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.f8291r == 0) {
                                i8 = iIntValue;
                            } else {
                                i8 = iIntValue;
                            }
                            bVar.f7178p = r0.f8286m;
                            bVar.f7179q = r0.f8287n;
                            bVar.f7182t = f;
                            bVar.f7181s = i8;
                            bVar.f7183u = r0.f8295v;
                            bVar.f7184v = r0.f8296w;
                            bVar.f7185w = c2777n;
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str14)) {
                            }
                            i5 = 3;
                        }
                        str10 = r0.f8274a;
                        if (str10 != null) {
                            bVar.f7164b = r0.f8274a;
                        }
                        bVar.m3278b(i24);
                        bVar.f7173k = str14;
                        bVar.f7174l = i3;
                        bVar.f7165c = r0.f8271W;
                        bVar.f7166d = i21111111;
                        bVar.f7175m = list3;
                        bVar.f7170h = str8;
                        bVar.f7176n = r0.f8285l;
                        C2811j1 c2811j1M3277a117 = bVar.m3277a();
                        InterfaceC3122w interfaceC3122wMo2492p117 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                        r0.f8272X = interfaceC3122wMo2492p117;
                        interfaceC3122wMo2492p117.mo2526e(c2811j1M3277a117);
                        this.f8229h.put(r0.f8276c, (c) r0);
                    } else {
                        iM3010r = 268435456;
                    }
                    str14 = "audio/raw";
                    list3 = null;
                    i3 = -1;
                    str8 = null;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i21111112 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i21111113 = i21111112 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i21111113;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a118 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p118 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p118;
                    interfaceC3122wMo2492p118.mo2526e(c2811j1M3277a118);
                    this.f8229h.put(r0.f8276c, (c) r0);
                    break;
                case 24:
                    iM3010r = C2738e0.m3010r(r0.f8264P);
                    if (iM3010r == 0) {
                        int i42 = r0.f8264P;
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
                        iM3010r = -1;
                        bArr = r0.f8262N;
                        if (bArr != null) {
                            str8 = c2778oM3126a.f6849a;
                            str14 = "video/dolby-vision";
                        }
                        int i21111114 = r0.f8270V | 0;
                        if (r0.f8269U) {
                            i4 = 2;
                        } else {
                            i4 = 0;
                        }
                        int i21111115 = i21111114 | i4;
                        bVar = new C2811j1.b();
                        if (C2753t.m3050h(str14)) {
                            bVar.f7186x = r0.f8263O;
                            bVar.f7187y = r0.f8265Q;
                            bVar.f7188z = iM3010r;
                            i5 = 1;
                        } else if (C2753t.m3052j(str14)) {
                            if (r0.f8290q == 0) {
                                i10 = r0.f8288o;
                                i6 = -1;
                                if (i10 == -1) {
                                    i10 = r0.f8286m;
                                }
                                r0.f8288o = i10;
                                i11 = r0.f8289p;
                                if (i11 == -1) {
                                    i11 = r0.f8287n;
                                }
                                r0.f8289p = i11;
                            } else {
                                i6 = -1;
                            }
                            f = -1.0f;
                            i7 = r0.f8288o;
                            if (i7 != i6) {
                                f = (r0.f8287n * i7) / (r0.f8286m * i9);
                            }
                            if (r0.f8297x) {
                                if (r0.f8252D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                            } else {
                                c2777n = null;
                            }
                            str9 = r0.f8274a;
                            if (str9 != null) {
                                map = f8194e;
                                if (map.containsKey(str9)) {
                                    iIntValue = map.get(r0.f8274a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.f8291r == 0) {
                                i8 = iIntValue;
                            } else {
                                i8 = iIntValue;
                            }
                            bVar.f7178p = r0.f8286m;
                            bVar.f7179q = r0.f8287n;
                            bVar.f7182t = f;
                            bVar.f7181s = i8;
                            bVar.f7183u = r0.f8295v;
                            bVar.f7184v = r0.f8296w;
                            bVar.f7185w = c2777n;
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str14)) {
                            }
                            i5 = 3;
                        }
                        str10 = r0.f8274a;
                        if (str10 != null) {
                            bVar.f7164b = r0.f8274a;
                        }
                        bVar.m3278b(i24);
                        bVar.f7173k = str14;
                        bVar.f7174l = i3;
                        bVar.f7165c = r0.f8271W;
                        bVar.f7166d = i21111115;
                        bVar.f7175m = list3;
                        bVar.f7170h = str8;
                        bVar.f7176n = r0.f8285l;
                        C2811j1 c2811j1M3277a119 = bVar.m3277a();
                        InterfaceC3122w interfaceC3122wMo2492p119 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                        r0.f8272X = interfaceC3122wMo2492p119;
                        interfaceC3122wMo2492p119.mo2526e(c2811j1M3277a119);
                        this.f8229h.put(r0.f8276c, (c) r0);
                    }
                    str14 = "audio/raw";
                    list3 = null;
                    i3 = -1;
                    str8 = null;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i21111116 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i21111117 = i21111116 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i21111117;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a1110 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p1110 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p1110;
                    interfaceC3122wMo2492p1110.mo2526e(c2811j1M3277a1110);
                    this.f8229h.put(r0.f8276c, (c) r0);
                    break;
                case 25:
                    byte[] bArr7 = f8191b;
                    byte[] bArrM3683a3 = r0.m3683a(r0.f8275b);
                    AbstractC4493a<Object> abstractC4493a = AbstractC4523p.f12045k;
                    Object[] objArr = {bArr7, bArrM3683a3};
                    str4 = "text/x-ssa";
                    listM6266u = AbstractC4523p.m6263m(objArr);
                    str3 = str4;
                    list4 = listM6266u;
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
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i21111118 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i21111119 = i21111118 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i21111119;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a1111 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p1111 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p1111;
                    interfaceC3122wMo2492p1111.mo2526e(c2811j1M3277a1111);
                    this.f8229h.put(r0.f8276c, (c) r0);
                    break;
                case 26:
                    C2780q c2780qM3131a = C2780q.m3131a(new C2757x(r0.m3683a(r0.f8275b)));
                    list2 = c2780qM3131a.f6863a;
                    r0.f8273Y = c2780qM3131a.f6864b;
                    str5 = c2780qM3131a.f6866d;
                    str6 = "video/hevc";
                    str8 = str5;
                    str14 = str6;
                    iM3010r = -1;
                    i3 = -1;
                    list3 = list2;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i211111110 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211111111 = i211111110 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i211111111;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a1112 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p1112 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p1112;
                    interfaceC3122wMo2492p1112.mo2526e(c2811j1M3277a1112);
                    this.f8229h.put(r0.f8276c, (c) r0);
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
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i211111112 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211111113 = i211111112 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i211111113;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a1113 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p1113 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p1113;
                    interfaceC3122wMo2492p1113.mo2526e(c2811j1M3277a1113);
                    this.f8229h.put(r0.f8276c, (c) r0);
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
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i211111114 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211111115 = i211111114 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i211111115;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a1114 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p1114 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p1114;
                    interfaceC3122wMo2492p1114.mo2526e(c2811j1M3277a1114);
                    this.f8229h.put(r0.f8276c, (c) r0);
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
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i211111116 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211111117 = i211111116 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i211111117;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a1115 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p1115 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p1115;
                    interfaceC3122wMo2492p1115.mo2526e(c2811j1M3277a1115);
                    this.f8229h.put(r0.f8276c, (c) r0);
                    break;
                case 30:
                    str4 = "audio/flac";
                    listM6266u = Collections.singletonList(r0.m3683a(r0.f8275b));
                    str3 = str4;
                    list4 = listM6266u;
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
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i211111118 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i211111119 = i211111118 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i211111119;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a1116 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p1116 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p1116;
                    interfaceC3122wMo2492p1116.mo2526e(c2811j1M3277a1116);
                    this.f8229h.put(r0.f8276c, (c) r0);
                    break;
                case 31:
                    ArrayList arrayList3 = new ArrayList(3);
                    arrayList3.add(r0.m3683a(r0.f8275b));
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    arrayList3.add(byteBufferAllocate.order(byteOrder).putLong(r0.f8266R).array());
                    arrayList3.add(ByteBuffer.allocate(8).order(byteOrder).putLong(r0.f8267S).array());
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
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                        str8 = c2778oM3126a.f6849a;
                        str14 = "video/dolby-vision";
                    }
                    int i2111111110 = r0.f8270V | 0;
                    if (r0.f8269U) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i2111111111 = i2111111110 | i4;
                    bVar = new C2811j1.b();
                    if (C2753t.m3050h(str14)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i5 = 1;
                    } else if (C2753t.m3052j(str14)) {
                        if (r0.f8290q == 0) {
                            i10 = r0.f8288o;
                            i6 = -1;
                            if (i10 == -1) {
                                i10 = r0.f8286m;
                            }
                            r0.f8288o = i10;
                            i11 = r0.f8289p;
                            if (i11 == -1) {
                                i11 = r0.f8287n;
                            }
                            r0.f8289p = i11;
                        } else {
                            i6 = -1;
                        }
                        f = -1.0f;
                        i7 = r0.f8288o;
                        if (i7 != i6) {
                            f = (r0.f8287n * i7) / (r0.f8286m * i9);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D != -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = null;
                            }
                            c2777n = new C2777n(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            c2777n = null;
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                            map = f8194e;
                            if (map.containsKey(str9)) {
                                iIntValue = map.get(r0.f8274a).intValue();
                            } else {
                                iIntValue = -1;
                            }
                        } else {
                            iIntValue = -1;
                        }
                        if (r0.f8291r == 0) {
                            i8 = iIntValue;
                        } else {
                            i8 = iIntValue;
                        }
                        bVar.f7178p = r0.f8286m;
                        bVar.f7179q = r0.f8287n;
                        bVar.f7182t = f;
                        bVar.f7181s = i8;
                        bVar.f7183u = r0.f8295v;
                        bVar.f7184v = r0.f8296w;
                        bVar.f7185w = c2777n;
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str14)) {
                        }
                        i5 = 3;
                    }
                    str10 = r0.f8274a;
                    if (str10 != null) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i24);
                    bVar.f7173k = str14;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i2111111111;
                    bVar.f7175m = list3;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    C2811j1 c2811j1M3277a1117 = bVar.m3277a();
                    InterfaceC3122w interfaceC3122wMo2492p1117 = interfaceC3058j2.mo2492p(r0.f8276c, i5);
                    r0.f8272X = interfaceC3122wMo2492p1117;
                    interfaceC3122wMo2492p1117.mo2526e(c2811j1M3277a1117);
                    this.f8229h.put(r0.f8276c, (c) r0);
                    break;
                default:
                    throw ParserException.m8755a("Unrecognized codec identifier.", null);
            }
        }
        this.f8247z = null;
    }

    /* JADX INFO: renamed from: k */
    public final void m3677k(InterfaceC3041i interfaceC3041i, int i) throws IOException {
        C2757x c2757x = this.f8233l;
        if (c2757x.f6795c >= i) {
            return;
        }
        byte[] bArr = c2757x.f6793a;
        if (bArr.length < i) {
            c2757x.m3082b(Math.max(bArr.length * 2, i));
        }
        C2757x c2757x2 = this.f8233l;
        byte[] bArr2 = c2757x2.f6793a;
        int i2 = c2757x2.f6795c;
        interfaceC3041i.readFully(bArr2, i2, i - i2);
        this.f8233l.m3078D(i);
    }

    /* JADX INFO: renamed from: l */
    public final void m3678l() {
        this.f8217W = 0;
        this.f8218X = 0;
        this.f8219Y = 0;
        this.f8220Z = false;
        this.f8221a0 = false;
        this.f8222b0 = false;
        this.f8223c0 = 0;
        this.f8224d0 = (byte) 0;
        this.f8225e0 = false;
        this.f8236o.m3075A(0);
    }

    /* JADX INFO: renamed from: m */
    public final long m3679m(long j) throws ParserException {
        long j2 = this.f8244w;
        if (j2 != -9223372036854775807L) {
            return C2738e0.m2985F(j, j2, 1000L);
        }
        throw ParserException.m8755a("Can't scale timecode prior to timecodeScale being set.", null);
    }

    @RequiresNonNull({"#2.output"})
    /* JADX INFO: renamed from: n */
    public final int m3680n(InterfaceC3041i interfaceC3041i, c cVar, int i) throws IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(cVar.f8275b)) {
            m3681o(interfaceC3041i, f8190a, i);
            int i3 = this.f8218X;
            m3678l();
            return i3;
        }
        if ("S_TEXT/ASS".equals(cVar.f8275b)) {
            m3681o(interfaceC3041i, f8192c, i);
            int i4 = this.f8218X;
            m3678l();
            return i4;
        }
        InterfaceC3122w interfaceC3122w = cVar.f8272X;
        if (!this.f8220Z) {
            if (cVar.f8281h) {
                this.f8214T &= -1073741825;
                if (!this.f8221a0) {
                    interfaceC3041i.readFully(this.f8233l.f6793a, 0, 1);
                    this.f8217W++;
                    byte[] bArr = this.f8233l.f6793a;
                    if ((bArr[0] & 128) == 128) {
                        throw ParserException.m8755a("Extension bit is set in signal byte", null);
                    }
                    this.f8224d0 = bArr[0];
                    this.f8221a0 = true;
                }
                byte b2 = this.f8224d0;
                if ((b2 & 1) == 1) {
                    boolean z2 = (b2 & 2) == 2;
                    this.f8214T |= BasicMeasure.EXACTLY;
                    if (!this.f8225e0) {
                        interfaceC3041i.readFully(this.f8238q.f6793a, 0, 8);
                        this.f8217W += 8;
                        this.f8225e0 = true;
                        C2757x c2757x = this.f8233l;
                        c2757x.f6793a[0] = (byte) ((z2 ? 128 : 0) | 8);
                        c2757x.m3079E(0);
                        interfaceC3122w.mo2527f(this.f8233l, 1, 1);
                        this.f8218X++;
                        this.f8238q.m3079E(0);
                        interfaceC3122w.mo2527f(this.f8238q, 8, 1);
                        this.f8218X += 8;
                    }
                    if (z2) {
                        if (!this.f8222b0) {
                            interfaceC3041i.readFully(this.f8233l.f6793a, 0, 1);
                            this.f8217W++;
                            this.f8233l.m3079E(0);
                            this.f8223c0 = this.f8233l.m3100t();
                            this.f8222b0 = true;
                        }
                        int i5 = this.f8223c0 * 4;
                        this.f8233l.m3075A(i5);
                        interfaceC3041i.readFully(this.f8233l.f6793a, 0, i5);
                        this.f8217W += i5;
                        short s2 = (short) ((this.f8223c0 / 2) + 1);
                        int i6 = (s2 * 6) + 2;
                        ByteBuffer byteBuffer = this.f8241t;
                        if (byteBuffer == null || byteBuffer.capacity() < i6) {
                            this.f8241t = ByteBuffer.allocate(i6);
                        }
                        this.f8241t.position(0);
                        this.f8241t.putShort(s2);
                        int i7 = 0;
                        int i8 = 0;
                        while (true) {
                            i2 = this.f8223c0;
                            if (i7 >= i2) {
                                break;
                            }
                            int iM3103w = this.f8233l.m3103w();
                            if (i7 % 2 == 0) {
                                this.f8241t.putShort((short) (iM3103w - i8));
                            } else {
                                this.f8241t.putInt(iM3103w - i8);
                            }
                            i7++;
                            i8 = iM3103w;
                        }
                        int i9 = (i - this.f8217W) - i8;
                        if (i2 % 2 == 1) {
                            this.f8241t.putInt(i9);
                        } else {
                            this.f8241t.putShort((short) i9);
                            this.f8241t.putInt(0);
                        }
                        this.f8239r.m3077C(this.f8241t.array(), i6);
                        interfaceC3122w.mo2527f(this.f8239r, i6, 1);
                        this.f8218X += i6;
                    }
                }
            } else {
                byte[] bArr2 = cVar.f8282i;
                if (bArr2 != null) {
                    C2757x c2757x2 = this.f8236o;
                    int length = bArr2.length;
                    c2757x2.f6793a = bArr2;
                    c2757x2.f6795c = length;
                    c2757x2.f6794b = 0;
                }
            }
            if (cVar.f8279f > 0) {
                this.f8214T |= 268435456;
                this.f8240s.m3075A(0);
                this.f8233l.m3075A(4);
                C2757x c2757x3 = this.f8233l;
                byte[] bArr3 = c2757x3.f6793a;
                bArr3[0] = (byte) ((i >> 24) & 255);
                bArr3[1] = (byte) ((i >> 16) & 255);
                bArr3[2] = (byte) ((i >> 8) & 255);
                bArr3[3] = (byte) (i & 255);
                interfaceC3122w.mo2527f(c2757x3, 4, 2);
                this.f8218X += 4;
            }
            this.f8220Z = true;
        }
        int i10 = i + this.f8236o.f6795c;
        if (!"V_MPEG4/ISO/AVC".equals(cVar.f8275b) && !"V_MPEGH/ISO/HEVC".equals(cVar.f8275b)) {
            if (cVar.f8268T != null) {
                C1460d.m426D(this.f8236o.f6795c == 0);
                cVar.f8268T.m3821c(interfaceC3041i);
            }
            while (true) {
                int i11 = this.f8217W;
                if (i11 >= i10) {
                    break;
                }
                int iM3682p = m3682p(interfaceC3041i, interfaceC3122w, i10 - i11);
                this.f8217W += iM3682p;
                this.f8218X += iM3682p;
            }
        } else {
            byte[] bArr4 = this.f8232k.f6793a;
            bArr4[0] = 0;
            bArr4[1] = 0;
            bArr4[2] = 0;
            int i12 = cVar.f8273Y;
            int i13 = 4 - i12;
            while (this.f8217W < i10) {
                int i14 = this.f8219Y;
                if (i14 == 0) {
                    int iMin = Math.min(i12, this.f8236o.m3081a());
                    interfaceC3041i.readFully(bArr4, i13 + iMin, i12 - iMin);
                    if (iMin > 0) {
                        C2757x c2757x4 = this.f8236o;
                        System.arraycopy(c2757x4.f6793a, c2757x4.f6794b, bArr4, i13, iMin);
                        c2757x4.f6794b += iMin;
                    }
                    this.f8217W += i12;
                    this.f8232k.m3079E(0);
                    this.f8219Y = this.f8232k.m3103w();
                    this.f8231j.m3079E(0);
                    interfaceC3122w.mo2524c(this.f8231j, 4);
                    this.f8218X += 4;
                } else {
                    int iM3682p2 = m3682p(interfaceC3041i, interfaceC3122w, i14);
                    this.f8217W += iM3682p2;
                    this.f8218X += iM3682p2;
                    this.f8219Y -= iM3682p2;
                }
            }
        }
        if ("A_VORBIS".equals(cVar.f8275b)) {
            this.f8234m.m3079E(0);
            interfaceC3122w.mo2524c(this.f8234m, 4);
            this.f8218X += 4;
        }
        int i15 = this.f8218X;
        m3678l();
        return i15;
    }

    /* JADX INFO: renamed from: o */
    public final void m3681o(InterfaceC3041i interfaceC3041i, byte[] bArr, int i) throws IOException {
        int length = bArr.length + i;
        C2757x c2757x = this.f8237p;
        byte[] bArr2 = c2757x.f6793a;
        if (bArr2.length < length) {
            c2757x.m3076B(Arrays.copyOf(bArr, length + i));
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        interfaceC3041i.readFully(this.f8237p.f6793a, bArr.length, i);
        this.f8237p.m3079E(0);
        this.f8237p.m3078D(length);
    }

    /* JADX INFO: renamed from: p */
    public final int m3682p(InterfaceC3041i interfaceC3041i, InterfaceC3122w interfaceC3122w, int i) throws IOException {
        int iM3081a = this.f8236o.m3081a();
        if (iM3081a <= 0) {
            return interfaceC3122w.mo2523b(interfaceC3041i, i, false);
        }
        int iMin = Math.min(i, iM3081a);
        interfaceC3122w.mo2524c(this.f8236o, iMin);
        return iMin;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    public final void release() {
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.g0.e$c */
    /* JADX INFO: compiled from: MatroskaExtractor.java */
    public static final class c {

        /* JADX INFO: renamed from: N */
        public byte[] f8262N;

        /* JADX INFO: renamed from: T */
        public C3123x f8268T;

        /* JADX INFO: renamed from: U */
        public boolean f8269U;

        /* JADX INFO: renamed from: X */
        public InterfaceC3122w f8272X;

        /* JADX INFO: renamed from: Y */
        public int f8273Y;

        /* JADX INFO: renamed from: a */
        public String f8274a;

        /* JADX INFO: renamed from: b */
        public String f8275b;

        /* JADX INFO: renamed from: c */
        public int f8276c;

        /* JADX INFO: renamed from: d */
        public int f8277d;

        /* JADX INFO: renamed from: e */
        public int f8278e;

        /* JADX INFO: renamed from: f */
        public int f8279f;

        /* JADX INFO: renamed from: g */
        public int f8280g;

        /* JADX INFO: renamed from: h */
        public boolean f8281h;

        /* JADX INFO: renamed from: i */
        public byte[] f8282i;

        /* JADX INFO: renamed from: j */
        public InterfaceC3122w.a f8283j;

        /* JADX INFO: renamed from: k */
        public byte[] f8284k;

        /* JADX INFO: renamed from: l */
        public DrmInitData f8285l;

        /* JADX INFO: renamed from: m */
        public int f8286m = -1;

        /* JADX INFO: renamed from: n */
        public int f8287n = -1;

        /* JADX INFO: renamed from: o */
        public int f8288o = -1;

        /* JADX INFO: renamed from: p */
        public int f8289p = -1;

        /* JADX INFO: renamed from: q */
        public int f8290q = 0;

        /* JADX INFO: renamed from: r */
        public int f8291r = -1;

        /* JADX INFO: renamed from: s */
        public float f8292s = 0.0f;

        /* JADX INFO: renamed from: t */
        public float f8293t = 0.0f;

        /* JADX INFO: renamed from: u */
        public float f8294u = 0.0f;

        /* JADX INFO: renamed from: v */
        public byte[] f8295v = null;

        /* JADX INFO: renamed from: w */
        public int f8296w = -1;

        /* JADX INFO: renamed from: x */
        public boolean f8297x = false;

        /* JADX INFO: renamed from: y */
        public int f8298y = -1;

        /* JADX INFO: renamed from: z */
        public int f8299z = -1;

        /* JADX INFO: renamed from: A */
        public int f8249A = -1;

        /* JADX INFO: renamed from: B */
        public int f8250B = 1000;

        /* JADX INFO: renamed from: C */
        public int f8251C = 200;

        /* JADX INFO: renamed from: D */
        public float f8252D = -1.0f;

        /* JADX INFO: renamed from: E */
        public float f8253E = -1.0f;

        /* JADX INFO: renamed from: F */
        public float f8254F = -1.0f;

        /* JADX INFO: renamed from: G */
        public float f8255G = -1.0f;

        /* JADX INFO: renamed from: H */
        public float f8256H = -1.0f;

        /* JADX INFO: renamed from: I */
        public float f8257I = -1.0f;

        /* JADX INFO: renamed from: J */
        public float f8258J = -1.0f;

        /* JADX INFO: renamed from: K */
        public float f8259K = -1.0f;

        /* JADX INFO: renamed from: L */
        public float f8260L = -1.0f;

        /* JADX INFO: renamed from: M */
        public float f8261M = -1.0f;

        /* JADX INFO: renamed from: O */
        public int f8263O = 1;

        /* JADX INFO: renamed from: P */
        public int f8264P = -1;

        /* JADX INFO: renamed from: Q */
        public int f8265Q = 8000;

        /* JADX INFO: renamed from: R */
        public long f8266R = 0;

        /* JADX INFO: renamed from: S */
        public long f8267S = 0;

        /* JADX INFO: renamed from: V */
        public boolean f8270V = true;

        /* JADX INFO: renamed from: W */
        public String f8271W = "eng";

        public c() {
        }

        @EnsuresNonNull({"codecPrivate"})
        /* JADX INFO: renamed from: a */
        public final byte[] m3683a(String str) throws ParserException {
            byte[] bArr = this.f8284k;
            if (bArr != null) {
                return bArr;
            }
            String strValueOf = String.valueOf(str);
            throw ParserException.m8755a(strValueOf.length() != 0 ? "Missing CodecPrivate for codec ".concat(strValueOf) : new String("Missing CodecPrivate for codec "), null);
        }

        public c(a aVar) {
        }
    }
}

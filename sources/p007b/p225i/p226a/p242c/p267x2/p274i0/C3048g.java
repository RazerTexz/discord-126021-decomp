package p007b.p225i.p226a.p242c.p267x2.p274i0;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
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
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2754u;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p263t2.C2930n;
import p007b.p225i.p226a.p242c.p267x2.C3003c;
import p007b.p225i.p226a.p242c.p267x2.C3115p;
import p007b.p225i.p226a.p242c.p267x2.C3118s;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;
import p007b.p225i.p226a.p242c.p267x2.p274i0.AbstractC3045d;
import p007b.p225i.p226a.p242c.p279z2.p281i.C3164b;
import p007b.p225i.p355b.p356a.InterfaceC4485e;

/* JADX INFO: renamed from: b.i.a.c.x2.i0.g */
/* JADX INFO: compiled from: FragmentedMp4Extractor.java */
/* JADX INFO: loaded from: classes3.dex */
public class C3048g implements InterfaceC3031h {

    /* JADX INFO: renamed from: a */
    public static final byte[] f8371a = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};

    /* JADX INFO: renamed from: b */
    public static final C2811j1 f8372b;

    /* JADX INFO: renamed from: A */
    public int f8373A;

    /* JADX INFO: renamed from: B */
    public int f8374B;

    /* JADX INFO: renamed from: C */
    public boolean f8375C;

    /* JADX INFO: renamed from: D */
    public InterfaceC3058j f8376D;

    /* JADX INFO: renamed from: E */
    public InterfaceC3122w[] f8377E;

    /* JADX INFO: renamed from: F */
    public InterfaceC3122w[] f8378F;

    /* JADX INFO: renamed from: G */
    public boolean f8379G;

    /* JADX INFO: renamed from: c */
    public final int f8380c;

    /* JADX INFO: renamed from: d */
    public final List<C2811j1> f8381d;

    /* JADX INFO: renamed from: e */
    public final SparseArray<b> f8382e;

    /* JADX INFO: renamed from: f */
    public final C2757x f8383f;

    /* JADX INFO: renamed from: g */
    public final C2757x f8384g;

    /* JADX INFO: renamed from: h */
    public final C2757x f8385h;

    /* JADX INFO: renamed from: i */
    public final byte[] f8386i;

    /* JADX INFO: renamed from: j */
    public final C2757x f8387j;

    /* JADX INFO: renamed from: k */
    public final C3164b f8388k;

    /* JADX INFO: renamed from: l */
    public final C2757x f8389l;

    /* JADX INFO: renamed from: m */
    public final ArrayDeque<AbstractC3045d.a> f8390m;

    /* JADX INFO: renamed from: n */
    public final ArrayDeque<a> f8391n;

    /* JADX INFO: renamed from: o */
    public int f8392o;

    /* JADX INFO: renamed from: p */
    public int f8393p;

    /* JADX INFO: renamed from: q */
    public long f8394q;

    /* JADX INFO: renamed from: r */
    public int f8395r;

    /* JADX INFO: renamed from: s */
    @Nullable
    public C2757x f8396s;

    /* JADX INFO: renamed from: t */
    public long f8397t;

    /* JADX INFO: renamed from: u */
    public int f8398u;

    /* JADX INFO: renamed from: v */
    public long f8399v;

    /* JADX INFO: renamed from: w */
    public long f8400w;

    /* JADX INFO: renamed from: x */
    public long f8401x;

    /* JADX INFO: renamed from: y */
    @Nullable
    public b f8402y;

    /* JADX INFO: renamed from: z */
    public int f8403z;

    /* JADX INFO: renamed from: b.i.a.c.x2.i0.g$a */
    /* JADX INFO: compiled from: FragmentedMp4Extractor.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final long f8404a;

        /* JADX INFO: renamed from: b */
        public final int f8405b;

        public a(long j, int i) {
            this.f8404a = j;
            this.f8405b = i;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.i0.g$b */
    /* JADX INFO: compiled from: FragmentedMp4Extractor.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final InterfaceC3122w f8406a;

        /* JADX INFO: renamed from: d */
        public C3057p f8409d;

        /* JADX INFO: renamed from: e */
        public C3047f f8410e;

        /* JADX INFO: renamed from: f */
        public int f8411f;

        /* JADX INFO: renamed from: g */
        public int f8412g;

        /* JADX INFO: renamed from: h */
        public int f8413h;

        /* JADX INFO: renamed from: i */
        public int f8414i;

        /* JADX INFO: renamed from: l */
        public boolean f8417l;

        /* JADX INFO: renamed from: b */
        public final C3056o f8407b = new C3056o();

        /* JADX INFO: renamed from: c */
        public final C2757x f8408c = new C2757x();

        /* JADX INFO: renamed from: j */
        public final C2757x f8415j = new C2757x(1);

        /* JADX INFO: renamed from: k */
        public final C2757x f8416k = new C2757x();

        public b(InterfaceC3122w interfaceC3122w, C3057p c3057p, C3047f c3047f) {
            this.f8406a = interfaceC3122w;
            this.f8409d = c3057p;
            this.f8410e = c3047f;
            this.f8409d = c3057p;
            this.f8410e = c3047f;
            interfaceC3122w.mo2526e(c3057p.f8493a.f8465f);
            m3720e();
        }

        /* JADX INFO: renamed from: a */
        public long m3716a() {
            return !this.f8417l ? this.f8409d.f8495c[this.f8411f] : this.f8407b.f8481f[this.f8413h];
        }

        @Nullable
        /* JADX INFO: renamed from: b */
        public C3055n m3717b() {
            if (!this.f8417l) {
                return null;
            }
            C3056o c3056o = this.f8407b;
            C3047f c3047f = c3056o.f8476a;
            int i = C2738e0.f6708a;
            int i2 = c3047f.f8367a;
            C3055n c3055nM3731a = c3056o.f8488m;
            if (c3055nM3731a == null) {
                c3055nM3731a = this.f8409d.f8493a.m3731a(i2);
            }
            if (c3055nM3731a == null || !c3055nM3731a.f8471a) {
                return null;
            }
            return c3055nM3731a;
        }

        /* JADX INFO: renamed from: c */
        public boolean m3718c() {
            this.f8411f++;
            if (!this.f8417l) {
                return false;
            }
            int i = this.f8412g + 1;
            this.f8412g = i;
            int[] iArr = this.f8407b.f8482g;
            int i2 = this.f8413h;
            if (i != iArr[i2]) {
                return true;
            }
            this.f8413h = i2 + 1;
            this.f8412g = 0;
            return false;
        }

        /* JADX INFO: renamed from: d */
        public int m3719d(int i, int i2) {
            C2757x c2757x;
            C3055n c3055nM3717b = m3717b();
            if (c3055nM3717b == null) {
                return 0;
            }
            int length = c3055nM3717b.f8474d;
            if (length != 0) {
                c2757x = this.f8407b.f8489n;
            } else {
                byte[] bArr = c3055nM3717b.f8475e;
                int i3 = C2738e0.f6708a;
                C2757x c2757x2 = this.f8416k;
                int length2 = bArr.length;
                c2757x2.f6793a = bArr;
                c2757x2.f6795c = length2;
                c2757x2.f6794b = 0;
                length = bArr.length;
                c2757x = c2757x2;
            }
            C3056o c3056o = this.f8407b;
            boolean z2 = c3056o.f8486k && c3056o.f8487l[this.f8411f];
            boolean z3 = z2 || i2 != 0;
            C2757x c2757x3 = this.f8415j;
            c2757x3.f6793a[0] = (byte) ((z3 ? 128 : 0) | length);
            c2757x3.m3079E(0);
            this.f8406a.mo2527f(this.f8415j, 1, 1);
            this.f8406a.mo2527f(c2757x, length, 1);
            if (!z3) {
                return length + 1;
            }
            if (!z2) {
                this.f8408c.m3075A(8);
                C2757x c2757x4 = this.f8408c;
                byte[] bArr2 = c2757x4.f6793a;
                bArr2[0] = 0;
                bArr2[1] = 1;
                bArr2[2] = (byte) ((i2 >> 8) & 255);
                bArr2[3] = (byte) (i2 & 255);
                bArr2[4] = (byte) ((i >> 24) & 255);
                bArr2[5] = (byte) ((i >> 16) & 255);
                bArr2[6] = (byte) ((i >> 8) & 255);
                bArr2[7] = (byte) (i & 255);
                this.f8406a.mo2527f(c2757x4, 8, 1);
                return length + 1 + 8;
            }
            C2757x c2757x5 = this.f8407b.f8489n;
            int iM3105y = c2757x5.m3105y();
            c2757x5.m3080F(-2);
            int i4 = (iM3105y * 6) + 2;
            if (i2 != 0) {
                this.f8408c.m3075A(i4);
                byte[] bArr3 = this.f8408c.f6793a;
                c2757x5.m3085e(bArr3, 0, i4);
                int i5 = (((bArr3[2] & 255) << 8) | (bArr3[3] & 255)) + i2;
                bArr3[2] = (byte) ((i5 >> 8) & 255);
                bArr3[3] = (byte) (i5 & 255);
                c2757x5 = this.f8408c;
            }
            this.f8406a.mo2527f(c2757x5, i4, 1);
            return length + 1 + i4;
        }

        /* JADX INFO: renamed from: e */
        public void m3720e() {
            C3056o c3056o = this.f8407b;
            c3056o.f8479d = 0;
            c3056o.f8491p = 0L;
            c3056o.f8492q = false;
            c3056o.f8486k = false;
            c3056o.f8490o = false;
            c3056o.f8488m = null;
            this.f8411f = 0;
            this.f8413h = 0;
            this.f8412g = 0;
            this.f8414i = 0;
            this.f8417l = false;
        }
    }

    static {
        C2811j1.b bVar = new C2811j1.b();
        bVar.f7173k = "application/x-emsg";
        f8372b = bVar.m3277a();
    }

    public C3048g(int i) {
        List listEmptyList = Collections.emptyList();
        this.f8380c = i;
        this.f8381d = Collections.unmodifiableList(listEmptyList);
        this.f8388k = new C3164b();
        this.f8389l = new C2757x(16);
        this.f8383f = new C2757x(C2754u.f6753a);
        this.f8384g = new C2757x(5);
        this.f8385h = new C2757x();
        byte[] bArr = new byte[16];
        this.f8386i = bArr;
        this.f8387j = new C2757x(bArr);
        this.f8390m = new ArrayDeque<>();
        this.f8391n = new ArrayDeque<>();
        this.f8382e = new SparseArray<>();
        this.f8400w = -9223372036854775807L;
        this.f8399v = -9223372036854775807L;
        this.f8401x = -9223372036854775807L;
        this.f8376D = InterfaceC3058j.f8501d;
        this.f8377E = new InterfaceC3122w[0];
        this.f8378F = new InterfaceC3122w[0];
    }

    /* JADX INFO: renamed from: a */
    public static int m3710a(int i) throws ParserException {
        if (i >= 0) {
            return i;
        }
        throw C1643a.m884w0(38, "Unexpected negative value: ", i, null);
    }

    @Nullable
    /* JADX INFO: renamed from: h */
    public static DrmInitData m3711h(List<AbstractC3045d.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            AbstractC3045d.b bVar = list.get(i);
            if (bVar.f8349a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.f8353b.f6793a;
                C3051j c3051jM581v1 = C1460d.m581v1(bArr);
                UUID uuid = c3051jM581v1 == null ? null : c3051jM581v1.f8449a;
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

    /* JADX INFO: renamed from: i */
    public static void m3712i(C2757x c2757x, int i, C3056o c3056o) throws ParserException {
        c2757x.m3079E(i + 8);
        int iM3086f = c2757x.m3086f() & ViewCompat.MEASURED_SIZE_MASK;
        if ((iM3086f & 1) != 0) {
            throw ParserException.m8756b("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z2 = (iM3086f & 2) != 0;
        int iM3103w = c2757x.m3103w();
        if (iM3103w == 0) {
            Arrays.fill(c3056o.f8487l, 0, c3056o.f8480e, false);
            return;
        }
        int i2 = c3056o.f8480e;
        if (iM3103w != i2) {
            throw ParserException.m8755a(C1643a.m853h(80, "Senc sample count ", iM3103w, " is different from fragment sample count", i2), null);
        }
        Arrays.fill(c3056o.f8487l, 0, iM3103w, z2);
        int iM3081a = c2757x.m3081a();
        C2757x c2757x2 = c3056o.f8489n;
        byte[] bArr = c2757x2.f6793a;
        if (bArr.length < iM3081a) {
            bArr = new byte[iM3081a];
        }
        c2757x2.f6793a = bArr;
        c2757x2.f6795c = iM3081a;
        c2757x2.f6794b = 0;
        c3056o.f8486k = true;
        c3056o.f8490o = true;
        c2757x.m3085e(bArr, 0, iM3081a);
        c3056o.f8489n.m3079E(0);
        c3056o.f8490o = false;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: b */
    public boolean mo3633b(InterfaceC3041i interfaceC3041i) throws IOException {
        return C3053l.m3730a(interfaceC3041i, true, false);
    }

    /* JADX INFO: renamed from: c */
    public final void m3713c() {
        this.f8392o = 0;
        this.f8395r = 0;
    }

    /* JADX INFO: renamed from: d */
    public final C3047f m3714d(SparseArray<C3047f> sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        C3047f c3047f = sparseArray.get(i);
        Objects.requireNonNull(c3047f);
        return c3047f;
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
    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: e */
    public int mo3635e(InterfaceC3041i interfaceC3041i, C3118s c3118s) throws IOException {
        char c;
        C3057p c3057p;
        C3054m c3054m;
        InterfaceC3122w interfaceC3122w;
        long j;
        long j2;
        int i;
        int i2;
        int i3;
        int i4;
        C3055n c3055nM3717b;
        InterfaceC3122w.a aVar;
        a aVarRemoveFirst;
        long j3;
        InterfaceC3122w[] interfaceC3122wArr;
        int length;
        int i5;
        byte[] bArr;
        int i6;
        int i7;
        int i8;
        int iMo2523b;
        int iM3086f;
        boolean z2;
        String str;
        byte b2;
        int i9;
        C3055n c3055nM3717b2;
        C2757x c2757x;
        int i10;
        C3056o c3056o;
        boolean z3;
        String strM3094n;
        String strM3094n2;
        long jM2985F;
        long j4;
        long jM3101u;
        long jM3104x;
        long jM3104x2;
        long j5;
        long jMo3642b;
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
            int i14 = this.f8392o;
            int i15 = 1;
            if (i14 == 0) {
                if (this.f8395r != 0) {
                    j5 = this.f8394q;
                    if (j5 == 1) {
                        interfaceC3041i.readFully(this.f8389l.f6793a, 8, 8);
                        this.f8395r += 8;
                        this.f8394q = this.f8389l.m3104x();
                    } else if (j5 == 0) {
                        jMo3642b = interfaceC3041i.mo3642b();
                        if (jMo3642b == -1 && !this.f8390m.isEmpty()) {
                            jMo3642b = this.f8390m.peek().f8350b;
                        }
                        if (jMo3642b != -1) {
                            this.f8394q = (jMo3642b - interfaceC3041i.getPosition()) + ((long) this.f8395r);
                        }
                    }
                    if (this.f8394q >= this.f8395r) {
                        throw ParserException.m8756b("Atom size less than header length (unsupported).");
                    }
                    position = interfaceC3041i.getPosition() - ((long) this.f8395r);
                    i11 = this.f8393p;
                    if ((i11 != 1836019558 || i11 == 1835295092) && !this.f8379G) {
                        this.f8376D.mo2477a(new InterfaceC3119t.b(this.f8400w, position));
                        this.f8379G = true;
                    }
                    if (this.f8393p == 1836019558) {
                        size = this.f8382e.size();
                        for (i13 = 0; i13 < size; i13++) {
                            C3056o c3056o2 = this.f8382e.valueAt(i13).f8407b;
                            Objects.requireNonNull(c3056o2);
                            c3056o2.f8478c = position;
                            c3056o2.f8477b = position;
                        }
                    }
                    i12 = this.f8393p;
                    if (i12 == 1835295092) {
                        this.f8402y = null;
                        this.f8397t = position + this.f8394q;
                        this.f8392o = 2;
                    } else {
                        if (i12 != 1836019574 || i12 == 1953653099 || i12 == 1835297121 || i12 == 1835626086 || i12 == 1937007212 || i12 == 1836019558 || i12 == 1953653094 || i12 == 1836475768 || i12 == 1701082227) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            position2 = (interfaceC3041i.getPosition() + this.f8394q) - 8;
                            this.f8390m.push(new AbstractC3045d.a(this.f8393p, position2));
                            if (this.f8394q == this.f8395r) {
                                m3715j(position2);
                            } else {
                                m3713c();
                            }
                        } else {
                            if (i12 != 1751411826 || i12 == 1835296868 || i12 == 1836476516 || i12 == 1936286840 || i12 == 1937011556 || i12 == 1937011827 || i12 == 1668576371 || i12 == 1937011555 || i12 == 1937011578 || i12 == 1937013298 || i12 == 1937007471 || i12 == 1668232756 || i12 == 1937011571 || i12 == 1952867444 || i12 == 1952868452 || i12 == 1953196132 || i12 == 1953654136 || i12 == 1953658222 || i12 == 1886614376 || i12 == 1935763834 || i12 == 1935763823 || i12 == 1936027235 || i12 == 1970628964 || i12 == 1935828848 || i12 == 1936158820 || i12 == 1701606260 || i12 == 1835362404 || i12 == 1701671783) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (z5) {
                                if (this.f8395r == 8) {
                                    throw ParserException.m8756b("Leaf atom defines extended atom size (unsupported).");
                                }
                                j6 = this.f8394q;
                                if (j6 <= 2147483647L) {
                                    throw ParserException.m8756b("Leaf atom with length > 2147483647 (unsupported).");
                                }
                                C2757x c2757x2 = new C2757x((int) j6);
                                System.arraycopy(this.f8389l.f6793a, 0, c2757x2.f6793a, 0, 8);
                                this.f8396s = c2757x2;
                                this.f8392o = 1;
                            } else {
                                if (this.f8394q <= 2147483647L) {
                                    throw ParserException.m8756b("Skipping atom with length > 2147483647 (unsupported).");
                                }
                                this.f8396s = null;
                                this.f8392o = 1;
                            }
                        }
                    }
                    z6 = true;
                } else if (interfaceC3041i.mo3643c(this.f8389l.f6793a, 0, 8, true)) {
                    this.f8395r = 8;
                    this.f8389l.m3079E(0);
                    this.f8394q = this.f8389l.m3101u();
                    this.f8393p = this.f8389l.m3086f();
                    j5 = this.f8394q;
                    if (j5 == 1) {
                        interfaceC3041i.readFully(this.f8389l.f6793a, 8, 8);
                        this.f8395r += 8;
                        this.f8394q = this.f8389l.m3104x();
                    } else if (j5 == 0) {
                        jMo3642b = interfaceC3041i.mo3642b();
                        if (jMo3642b == -1) {
                            jMo3642b = this.f8390m.peek().f8350b;
                        }
                        if (jMo3642b != -1) {
                            this.f8394q = (jMo3642b - interfaceC3041i.getPosition()) + ((long) this.f8395r);
                        }
                    }
                    if (this.f8394q >= this.f8395r) {
                        throw ParserException.m8756b("Atom size less than header length (unsupported).");
                    }
                    position = interfaceC3041i.getPosition() - ((long) this.f8395r);
                    i11 = this.f8393p;
                    if (i11 != 1836019558) {
                        this.f8376D.mo2477a(new InterfaceC3119t.b(this.f8400w, position));
                        this.f8379G = true;
                    } else {
                        this.f8376D.mo2477a(new InterfaceC3119t.b(this.f8400w, position));
                        this.f8379G = true;
                    }
                    if (this.f8393p == 1836019558) {
                        size = this.f8382e.size();
                        while (i13 < size) {
                            C3056o c3056o3 = this.f8382e.valueAt(i13).f8407b;
                            Objects.requireNonNull(c3056o3);
                            c3056o3.f8478c = position;
                            c3056o3.f8477b = position;
                        }
                    }
                    i12 = this.f8393p;
                    if (i12 == 1835295092) {
                        this.f8402y = null;
                        this.f8397t = position + this.f8394q;
                        this.f8392o = 2;
                    } else {
                        if (i12 != 1836019574) {
                            z4 = true;
                        } else {
                            z4 = true;
                        }
                        if (z4) {
                            position2 = (interfaceC3041i.getPosition() + this.f8394q) - 8;
                            this.f8390m.push(new AbstractC3045d.a(this.f8393p, position2));
                            if (this.f8394q == this.f8395r) {
                                m3715j(position2);
                            } else {
                                m3713c();
                            }
                        } else {
                            if (i12 != 1751411826) {
                                z5 = true;
                            } else {
                                z5 = true;
                            }
                            if (z5) {
                                if (this.f8395r == 8) {
                                    throw ParserException.m8756b("Leaf atom defines extended atom size (unsupported).");
                                }
                                j6 = this.f8394q;
                                if (j6 <= 2147483647L) {
                                    throw ParserException.m8756b("Leaf atom with length > 2147483647 (unsupported).");
                                }
                                C2757x c2757x3 = new C2757x((int) j6);
                                System.arraycopy(this.f8389l.f6793a, 0, c2757x3.f6793a, 0, 8);
                                this.f8396s = c2757x3;
                                this.f8392o = 1;
                            } else {
                                if (this.f8394q <= 2147483647L) {
                                    throw ParserException.m8756b("Skipping atom with length > 2147483647 (unsupported).");
                                }
                                this.f8396s = null;
                                this.f8392o = 1;
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
                int i16 = ((int) this.f8394q) - this.f8395r;
                C2757x c2757x4 = this.f8396s;
                if (c2757x4 != null) {
                    interfaceC3041i.readFully(c2757x4.f6793a, 8, i16);
                    int i17 = this.f8393p;
                    AbstractC3045d.b bVar = new AbstractC3045d.b(i17, c2757x4);
                    long position3 = interfaceC3041i.getPosition();
                    if (!this.f8390m.isEmpty()) {
                        this.f8390m.peek().f8351c.add(bVar);
                    } else if (i17 == 1936286840) {
                        c2757x4.m3079E(8);
                        int iM3086f2 = (c2757x4.m3086f() >> 24) & 255;
                        c2757x4.m3080F(4);
                        long jM3101u2 = c2757x4.m3101u();
                        if (iM3086f2 == 0) {
                            jM3104x = c2757x4.m3101u();
                            jM3104x2 = c2757x4.m3101u();
                        } else {
                            jM3104x = c2757x4.m3104x();
                            jM3104x2 = c2757x4.m3104x();
                        }
                        long j7 = position3 + jM3104x2;
                        long jM2985F2 = C2738e0.m2985F(jM3104x, 1000000L, jM3101u2);
                        c2757x4.m3080F(2);
                        int iM3105y = c2757x4.m3105y();
                        int[] iArr = new int[iM3105y];
                        long[] jArr = new long[iM3105y];
                        long[] jArr2 = new long[iM3105y];
                        long[] jArr3 = new long[iM3105y];
                        int i18 = 0;
                        long jM2985F3 = jM2985F2;
                        while (i18 < iM3105y) {
                            int iM3086f3 = c2757x4.m3086f();
                            if ((iM3086f3 & Integer.MIN_VALUE) != 0) {
                                throw ParserException.m8755a("Unhandled indirect reference", null);
                            }
                            long jM3101u3 = c2757x4.m3101u();
                            iArr[i18] = iM3086f3 & Integer.MAX_VALUE;
                            jArr[i18] = j7;
                            jArr3[i18] = jM2985F3;
                            long j8 = jM3104x + jM3101u3;
                            int i19 = i18;
                            int i20 = iM3105y;
                            long[] jArr4 = jArr2;
                            long[] jArr5 = jArr3;
                            jM2985F3 = C2738e0.m2985F(j8, 1000000L, jM3101u2);
                            jArr4[i19] = jM2985F3 - jArr5[i19];
                            c2757x4.m3080F(4);
                            j7 += (long) iArr[i19];
                            i18 = i19 + 1;
                            jArr2 = jArr4;
                            jArr3 = jArr5;
                            jArr = jArr;
                            jM3104x = j8;
                            iM3105y = i20;
                        }
                        Pair pairCreate = Pair.create(Long.valueOf(jM2985F2), new C3003c(iArr, jArr, jArr2, jArr3));
                        this.f8401x = ((Long) pairCreate.first).longValue();
                        this.f8376D.mo2477a((InterfaceC3119t) pairCreate.second);
                        this.f8379G = true;
                    } else if (i17 == 1701671783 && this.f8377E.length != 0) {
                        c2757x4.m3079E(8);
                        int iM3086f4 = (c2757x4.m3086f() >> 24) & 255;
                        long j9 = -9223372036854775807L;
                        if (iM3086f4 == 0) {
                            strM3094n = c2757x4.m3094n();
                            Objects.requireNonNull(strM3094n);
                            strM3094n2 = c2757x4.m3094n();
                            Objects.requireNonNull(strM3094n2);
                            long jM3101u4 = c2757x4.m3101u();
                            long jM2985F4 = C2738e0.m2985F(c2757x4.m3101u(), 1000000L, jM3101u4);
                            long j10 = this.f8401x;
                            j9 = j10 != -9223372036854775807L ? j10 + jM2985F4 : -9223372036854775807L;
                            jM2985F = C2738e0.m2985F(c2757x4.m3101u(), 1000L, jM3101u4);
                            j4 = j9;
                            j9 = jM2985F4;
                            jM3101u = c2757x4.m3101u();
                        } else if (iM3086f4 != 1) {
                            C1643a.m852g0(46, "Skipping unsupported emsg version: ", iM3086f4, "FragmentedMp4Extractor");
                        } else {
                            long jM3101u5 = c2757x4.m3101u();
                            long jM2985F5 = C2738e0.m2985F(c2757x4.m3104x(), 1000000L, jM3101u5);
                            jM2985F = C2738e0.m2985F(c2757x4.m3101u(), 1000L, jM3101u5);
                            jM3101u = c2757x4.m3101u();
                            strM3094n = c2757x4.m3094n();
                            Objects.requireNonNull(strM3094n);
                            strM3094n2 = c2757x4.m3094n();
                            Objects.requireNonNull(strM3094n2);
                            j4 = jM2985F5;
                        }
                        byte[] bArr2 = new byte[c2757x4.m3081a()];
                        int iM3081a = c2757x4.m3081a();
                        System.arraycopy(c2757x4.f6793a, c2757x4.f6794b, bArr2, 0, iM3081a);
                        c2757x4.f6794b += iM3081a;
                        C3164b c3164b = this.f8388k;
                        c3164b.f9148a.reset();
                        try {
                            DataOutputStream dataOutputStream = c3164b.f9149b;
                            dataOutputStream.writeBytes(strM3094n);
                            dataOutputStream.writeByte(0);
                            DataOutputStream dataOutputStream2 = c3164b.f9149b;
                            dataOutputStream2.writeBytes(strM3094n2);
                            dataOutputStream2.writeByte(0);
                            c3164b.f9149b.writeLong(jM2985F);
                            c3164b.f9149b.writeLong(jM3101u);
                            c3164b.f9149b.write(bArr2);
                            c3164b.f9149b.flush();
                            C2757x c2757x5 = new C2757x(c3164b.f9148a.toByteArray());
                            int iM3081a2 = c2757x5.m3081a();
                            for (InterfaceC3122w interfaceC3122w2 : this.f8377E) {
                                c2757x5.m3079E(0);
                                interfaceC3122w2.mo2524c(c2757x5, iM3081a2);
                            }
                            if (j4 == -9223372036854775807L) {
                                this.f8391n.addLast(new a(j9, iM3081a2));
                                this.f8398u += iM3081a2;
                            } else {
                                for (InterfaceC3122w interfaceC3122w3 : this.f8377E) {
                                    interfaceC3122w3.mo2525d(j4, 1, iM3081a2, 0, null);
                                }
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                } else {
                    interfaceC3041i.mo3650l(i16);
                }
                m3715j(interfaceC3041i.getPosition());
            } else if (i14 != 2) {
                b bVar2 = this.f8402y;
                if (bVar2 == null) {
                    SparseArray<b> sparseArray = this.f8382e;
                    int size2 = sparseArray.size();
                    long j11 = Long.MAX_VALUE;
                    b bVar3 = null;
                    for (int i21 = 0; i21 < size2; i21++) {
                        b bVarValueAt = sparseArray.valueAt(i21);
                        boolean z7 = bVarValueAt.f8417l;
                        if ((z7 || bVarValueAt.f8411f != bVarValueAt.f8409d.f8494b) && (!z7 || bVarValueAt.f8413h != bVarValueAt.f8407b.f8479d)) {
                            long jM3716a = bVarValueAt.m3716a();
                            if (jM3716a < j11) {
                                bVar3 = bVarValueAt;
                                j11 = jM3716a;
                            }
                        }
                    }
                    if (bVar3 == null) {
                        int position4 = (int) (this.f8397t - interfaceC3041i.getPosition());
                        if (position4 < 0) {
                            throw ParserException.m8755a("Offset to end of mdat was negative.", null);
                        }
                        interfaceC3041i.mo3650l(position4);
                        m3713c();
                        i15 = 0;
                    } else {
                        int iM3716a = (int) (bVar3.m3716a() - interfaceC3041i.getPosition());
                        if (iM3716a < 0) {
                            Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                            iM3716a = 0;
                        }
                        interfaceC3041i.mo3650l(iM3716a);
                        this.f8402y = bVar3;
                        bVar2 = bVar3;
                        c = 6;
                        if (this.f8392o != 3) {
                            c3057p = bVar2.f8409d;
                            c3054m = c3057p.f8493a;
                            interfaceC3122w = bVar2.f8406a;
                            if (bVar2.f8417l) {
                                j = bVar2.f8407b.f8484i[bVar2.f8411f];
                            } else {
                                j = c3057p.f8498f[bVar2.f8411f];
                            }
                            j2 = j;
                            i = c3054m.f8469j;
                            if (i != 0) {
                                while (true) {
                                    i2 = this.f8373A;
                                    i3 = this.f8403z;
                                    if (i2 < i3) {
                                        break;
                                    }
                                    this.f8373A += interfaceC3122w.mo2523b(interfaceC3041i, i3 - i2, false);
                                }
                            } else {
                                bArr = this.f8384g.f6793a;
                                bArr[0] = 0;
                                bArr[1] = 0;
                                bArr[2] = 0;
                                i6 = i + 1;
                                i7 = 4 - i;
                                while (this.f8373A < this.f8403z) {
                                    i8 = this.f8374B;
                                    if (i8 == 0) {
                                        interfaceC3041i.readFully(bArr, i7, i6);
                                        this.f8384g.m3079E(0);
                                        iM3086f = this.f8384g.m3086f();
                                        if (iM3086f >= i15) {
                                            throw ParserException.m8755a("Invalid NAL length", null);
                                        }
                                        this.f8374B = iM3086f - 1;
                                        this.f8383f.m3079E(0);
                                        interfaceC3122w.mo2524c(this.f8383f, 4);
                                        interfaceC3122w.mo2524c(this.f8384g, i15);
                                        if (this.f8378F.length > 0) {
                                            str = c3054m.f8465f.f7155w;
                                            b2 = bArr[4];
                                            byte[] bArr3 = C2754u.f6753a;
                                            if ((!"video/avc".equals(str) && (b2 & 31) == c) || ("video/hevc".equals(str) && ((b2 & 126) >> i15) == 39)) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                        } else {
                                            z2 = false;
                                        }
                                        this.f8375C = z2;
                                        this.f8373A += 5;
                                        this.f8403z += i7;
                                    } else {
                                        if (this.f8375C) {
                                            this.f8385h.m3075A(i8);
                                            interfaceC3041i.readFully(this.f8385h.f6793a, 0, this.f8374B);
                                            interfaceC3122w.mo2524c(this.f8385h, this.f8374B);
                                            iMo2523b = this.f8374B;
                                            C2757x c2757x6 = this.f8385h;
                                            int iM3059f = C2754u.m3059f(c2757x6.f6793a, c2757x6.f6795c);
                                            this.f8385h.m3079E("video/hevc".equals(c3054m.f8465f.f7155w) ? 1 : 0);
                                            this.f8385h.m3078D(iM3059f);
                                            C1460d.m444J(j2, this.f8385h, this.f8378F);
                                        } else {
                                            iMo2523b = interfaceC3122w.mo2523b(interfaceC3041i, i8, false);
                                        }
                                        this.f8373A += iMo2523b;
                                        this.f8374B -= iMo2523b;
                                        c = 6;
                                        i15 = 1;
                                    }
                                }
                            }
                            if (!bVar2.f8417l) {
                                i4 = bVar2.f8409d.f8499g[bVar2.f8411f];
                            } else if (bVar2.f8407b.f8485j[bVar2.f8411f]) {
                                i4 = 1;
                            } else {
                                i4 = 0;
                            }
                            if (bVar2.m3717b() != null) {
                                i4 |= BasicMeasure.EXACTLY;
                            }
                            int i22 = i4;
                            c3055nM3717b = bVar2.m3717b();
                            if (c3055nM3717b != null) {
                                aVar = c3055nM3717b.f8473c;
                            } else {
                                aVar = null;
                            }
                            interfaceC3122w.mo2525d(j2, i22, this.f8403z, 0, aVar);
                            while (!this.f8391n.isEmpty()) {
                                aVarRemoveFirst = this.f8391n.removeFirst();
                                this.f8398u -= aVarRemoveFirst.f8405b;
                                j3 = aVarRemoveFirst.f8404a + j2;
                                interfaceC3122wArr = this.f8377E;
                                i5 = 0;
                                for (length = interfaceC3122wArr.length; i5 < length; length = length) {
                                    interfaceC3122wArr[i5].mo2525d(j3, 1, aVarRemoveFirst.f8405b, this.f8398u, null);
                                    i5++;
                                }
                            }
                            if (!bVar2.m3718c()) {
                                this.f8402y = null;
                            }
                            this.f8392o = 3;
                            i15 = 1;
                        } else {
                            if (bVar2.f8417l) {
                                i9 = bVar2.f8407b.f8483h[bVar2.f8411f];
                            } else {
                                i9 = bVar2.f8409d.f8496d[bVar2.f8411f];
                            }
                            this.f8403z = i9;
                            if (bVar2.f8411f < bVar2.f8414i) {
                                interfaceC3041i.mo3650l(i9);
                                c3055nM3717b2 = bVar2.m3717b();
                                if (c3055nM3717b2 != null) {
                                    c2757x = bVar2.f8407b.f8489n;
                                    i10 = c3055nM3717b2.f8474d;
                                    if (i10 != 0) {
                                        c2757x.m3080F(i10);
                                    }
                                    c3056o = bVar2.f8407b;
                                    int i23 = bVar2.f8411f;
                                    if (c3056o.f8486k || !c3056o.f8487l[i23]) {
                                        z3 = false;
                                    } else {
                                        z3 = true;
                                    }
                                    if (z3) {
                                        c2757x.m3080F(c2757x.m3105y() * 6);
                                    }
                                }
                                if (!bVar2.m3718c()) {
                                    this.f8402y = null;
                                }
                                this.f8392o = 3;
                            } else {
                                if (bVar2.f8409d.f8493a.f8466g == 1) {
                                    this.f8403z = i9 - 8;
                                    interfaceC3041i.mo3650l(8);
                                }
                                if ("audio/ac4".equals(bVar2.f8409d.f8493a.f8465f.f7155w)) {
                                    this.f8373A = bVar2.m3719d(this.f8403z, 7);
                                    C2930n.m3492a(this.f8403z, this.f8387j);
                                    bVar2.f8406a.mo2524c(this.f8387j, 7);
                                    this.f8373A += 7;
                                } else {
                                    this.f8373A = bVar2.m3719d(this.f8403z, 0);
                                }
                                this.f8403z += this.f8373A;
                                this.f8392o = 4;
                                this.f8374B = 0;
                                c3057p = bVar2.f8409d;
                                c3054m = c3057p.f8493a;
                                interfaceC3122w = bVar2.f8406a;
                                if (bVar2.f8417l) {
                                    j = c3057p.f8498f[bVar2.f8411f];
                                } else {
                                    j = bVar2.f8407b.f8484i[bVar2.f8411f];
                                }
                                j2 = j;
                                i = c3054m.f8469j;
                                if (i != 0) {
                                    while (true) {
                                        i2 = this.f8373A;
                                        i3 = this.f8403z;
                                        if (i2 < i3) {
                                            break;
                                            break;
                                        }
                                        this.f8373A += interfaceC3122w.mo2523b(interfaceC3041i, i3 - i2, false);
                                    }
                                } else {
                                    bArr = this.f8384g.f6793a;
                                    bArr[0] = 0;
                                    bArr[1] = 0;
                                    bArr[2] = 0;
                                    i6 = i + 1;
                                    i7 = 4 - i;
                                    while (this.f8373A < this.f8403z) {
                                        i8 = this.f8374B;
                                        if (i8 == 0) {
                                            interfaceC3041i.readFully(bArr, i7, i6);
                                            this.f8384g.m3079E(0);
                                            iM3086f = this.f8384g.m3086f();
                                            if (iM3086f >= i15) {
                                                throw ParserException.m8755a("Invalid NAL length", null);
                                            }
                                            this.f8374B = iM3086f - 1;
                                            this.f8383f.m3079E(0);
                                            interfaceC3122w.mo2524c(this.f8383f, 4);
                                            interfaceC3122w.mo2524c(this.f8384g, i15);
                                            if (this.f8378F.length > 0) {
                                                str = c3054m.f8465f.f7155w;
                                                b2 = bArr[4];
                                                byte[] bArr4 = C2754u.f6753a;
                                                if ((!"video/avc".equals(str) && (b2 & 31) == c) || ("video/hevc".equals(str) && ((b2 & 126) >> i15) == 39)) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                            } else {
                                                z2 = false;
                                            }
                                            this.f8375C = z2;
                                            this.f8373A += 5;
                                            this.f8403z += i7;
                                        } else {
                                            if (this.f8375C) {
                                                this.f8385h.m3075A(i8);
                                                interfaceC3041i.readFully(this.f8385h.f6793a, 0, this.f8374B);
                                                interfaceC3122w.mo2524c(this.f8385h, this.f8374B);
                                                iMo2523b = this.f8374B;
                                                C2757x c2757x7 = this.f8385h;
                                                int iM3059f2 = C2754u.m3059f(c2757x7.f6793a, c2757x7.f6795c);
                                                this.f8385h.m3079E("video/hevc".equals(c3054m.f8465f.f7155w) ? 1 : 0);
                                                this.f8385h.m3078D(iM3059f2);
                                                C1460d.m444J(j2, this.f8385h, this.f8378F);
                                            } else {
                                                iMo2523b = interfaceC3122w.mo2523b(interfaceC3041i, i8, false);
                                            }
                                            this.f8373A += iMo2523b;
                                            this.f8374B -= iMo2523b;
                                            c = 6;
                                            i15 = 1;
                                        }
                                    }
                                }
                                if (!bVar2.f8417l) {
                                    i4 = bVar2.f8409d.f8499g[bVar2.f8411f];
                                } else if (bVar2.f8407b.f8485j[bVar2.f8411f]) {
                                    i4 = 1;
                                } else {
                                    i4 = 0;
                                }
                                if (bVar2.m3717b() != null) {
                                    i4 |= BasicMeasure.EXACTLY;
                                }
                                int i24 = i4;
                                c3055nM3717b = bVar2.m3717b();
                                if (c3055nM3717b != null) {
                                    aVar = c3055nM3717b.f8473c;
                                } else {
                                    aVar = null;
                                }
                                interfaceC3122w.mo2525d(j2, i24, this.f8403z, 0, aVar);
                                while (!this.f8391n.isEmpty()) {
                                    aVarRemoveFirst = this.f8391n.removeFirst();
                                    this.f8398u -= aVarRemoveFirst.f8405b;
                                    j3 = aVarRemoveFirst.f8404a + j2;
                                    interfaceC3122wArr = this.f8377E;
                                    i5 = 0;
                                    while (i5 < length) {
                                        interfaceC3122wArr[i5].mo2525d(j3, 1, aVarRemoveFirst.f8405b, this.f8398u, null);
                                        i5++;
                                    }
                                }
                                if (!bVar2.m3718c()) {
                                    this.f8402y = null;
                                }
                                this.f8392o = 3;
                                i15 = 1;
                            }
                        }
                    }
                } else {
                    c = 6;
                    if (this.f8392o != 3) {
                        c3057p = bVar2.f8409d;
                        c3054m = c3057p.f8493a;
                        interfaceC3122w = bVar2.f8406a;
                        if (bVar2.f8417l) {
                            j = c3057p.f8498f[bVar2.f8411f];
                        } else {
                            j = bVar2.f8407b.f8484i[bVar2.f8411f];
                        }
                        j2 = j;
                        i = c3054m.f8469j;
                        if (i != 0) {
                            while (true) {
                                i2 = this.f8373A;
                                i3 = this.f8403z;
                                if (i2 < i3) {
                                    break;
                                    break;
                                }
                                this.f8373A += interfaceC3122w.mo2523b(interfaceC3041i, i3 - i2, false);
                            }
                        } else {
                            bArr = this.f8384g.f6793a;
                            bArr[0] = 0;
                            bArr[1] = 0;
                            bArr[2] = 0;
                            i6 = i + 1;
                            i7 = 4 - i;
                            while (this.f8373A < this.f8403z) {
                                i8 = this.f8374B;
                                if (i8 == 0) {
                                    interfaceC3041i.readFully(bArr, i7, i6);
                                    this.f8384g.m3079E(0);
                                    iM3086f = this.f8384g.m3086f();
                                    if (iM3086f >= i15) {
                                        throw ParserException.m8755a("Invalid NAL length", null);
                                    }
                                    this.f8374B = iM3086f - 1;
                                    this.f8383f.m3079E(0);
                                    interfaceC3122w.mo2524c(this.f8383f, 4);
                                    interfaceC3122w.mo2524c(this.f8384g, i15);
                                    if (this.f8378F.length > 0) {
                                        str = c3054m.f8465f.f7155w;
                                        b2 = bArr[4];
                                        byte[] bArr5 = C2754u.f6753a;
                                        if ((!"video/avc".equals(str) && (b2 & 31) == c) || ("video/hevc".equals(str) && ((b2 & 126) >> i15) == 39)) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                    } else {
                                        z2 = false;
                                    }
                                    this.f8375C = z2;
                                    this.f8373A += 5;
                                    this.f8403z += i7;
                                } else {
                                    if (this.f8375C) {
                                        this.f8385h.m3075A(i8);
                                        interfaceC3041i.readFully(this.f8385h.f6793a, 0, this.f8374B);
                                        interfaceC3122w.mo2524c(this.f8385h, this.f8374B);
                                        iMo2523b = this.f8374B;
                                        C2757x c2757x8 = this.f8385h;
                                        int iM3059f3 = C2754u.m3059f(c2757x8.f6793a, c2757x8.f6795c);
                                        this.f8385h.m3079E("video/hevc".equals(c3054m.f8465f.f7155w) ? 1 : 0);
                                        this.f8385h.m3078D(iM3059f3);
                                        C1460d.m444J(j2, this.f8385h, this.f8378F);
                                    } else {
                                        iMo2523b = interfaceC3122w.mo2523b(interfaceC3041i, i8, false);
                                    }
                                    this.f8373A += iMo2523b;
                                    this.f8374B -= iMo2523b;
                                    c = 6;
                                    i15 = 1;
                                }
                            }
                        }
                        if (!bVar2.f8417l) {
                            i4 = bVar2.f8409d.f8499g[bVar2.f8411f];
                        } else if (bVar2.f8407b.f8485j[bVar2.f8411f]) {
                            i4 = 1;
                        } else {
                            i4 = 0;
                        }
                        if (bVar2.m3717b() != null) {
                            i4 |= BasicMeasure.EXACTLY;
                        }
                        int i25 = i4;
                        c3055nM3717b = bVar2.m3717b();
                        if (c3055nM3717b != null) {
                            aVar = c3055nM3717b.f8473c;
                        } else {
                            aVar = null;
                        }
                        interfaceC3122w.mo2525d(j2, i25, this.f8403z, 0, aVar);
                        while (!this.f8391n.isEmpty()) {
                            aVarRemoveFirst = this.f8391n.removeFirst();
                            this.f8398u -= aVarRemoveFirst.f8405b;
                            j3 = aVarRemoveFirst.f8404a + j2;
                            interfaceC3122wArr = this.f8377E;
                            i5 = 0;
                            while (i5 < length) {
                                interfaceC3122wArr[i5].mo2525d(j3, 1, aVarRemoveFirst.f8405b, this.f8398u, null);
                                i5++;
                            }
                        }
                        if (!bVar2.m3718c()) {
                            this.f8402y = null;
                        }
                        this.f8392o = 3;
                        i15 = 1;
                    } else {
                        if (bVar2.f8417l) {
                            i9 = bVar2.f8409d.f8496d[bVar2.f8411f];
                        } else {
                            i9 = bVar2.f8407b.f8483h[bVar2.f8411f];
                        }
                        this.f8403z = i9;
                        if (bVar2.f8411f < bVar2.f8414i) {
                            interfaceC3041i.mo3650l(i9);
                            c3055nM3717b2 = bVar2.m3717b();
                            if (c3055nM3717b2 != null) {
                                c2757x = bVar2.f8407b.f8489n;
                                i10 = c3055nM3717b2.f8474d;
                                if (i10 != 0) {
                                    c2757x.m3080F(i10);
                                }
                                c3056o = bVar2.f8407b;
                                int i26 = bVar2.f8411f;
                                if (c3056o.f8486k) {
                                    z3 = false;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    c2757x.m3080F(c2757x.m3105y() * 6);
                                }
                            }
                            if (!bVar2.m3718c()) {
                                this.f8402y = null;
                            }
                            this.f8392o = 3;
                        } else {
                            if (bVar2.f8409d.f8493a.f8466g == 1) {
                                this.f8403z = i9 - 8;
                                interfaceC3041i.mo3650l(8);
                            }
                            if ("audio/ac4".equals(bVar2.f8409d.f8493a.f8465f.f7155w)) {
                                this.f8373A = bVar2.m3719d(this.f8403z, 7);
                                C2930n.m3492a(this.f8403z, this.f8387j);
                                bVar2.f8406a.mo2524c(this.f8387j, 7);
                                this.f8373A += 7;
                            } else {
                                this.f8373A = bVar2.m3719d(this.f8403z, 0);
                            }
                            this.f8403z += this.f8373A;
                            this.f8392o = 4;
                            this.f8374B = 0;
                            c3057p = bVar2.f8409d;
                            c3054m = c3057p.f8493a;
                            interfaceC3122w = bVar2.f8406a;
                            if (bVar2.f8417l) {
                                j = c3057p.f8498f[bVar2.f8411f];
                            } else {
                                j = bVar2.f8407b.f8484i[bVar2.f8411f];
                            }
                            j2 = j;
                            i = c3054m.f8469j;
                            if (i != 0) {
                                while (true) {
                                    i2 = this.f8373A;
                                    i3 = this.f8403z;
                                    if (i2 < i3) {
                                        break;
                                        break;
                                    }
                                    this.f8373A += interfaceC3122w.mo2523b(interfaceC3041i, i3 - i2, false);
                                }
                            } else {
                                bArr = this.f8384g.f6793a;
                                bArr[0] = 0;
                                bArr[1] = 0;
                                bArr[2] = 0;
                                i6 = i + 1;
                                i7 = 4 - i;
                                while (this.f8373A < this.f8403z) {
                                    i8 = this.f8374B;
                                    if (i8 == 0) {
                                        interfaceC3041i.readFully(bArr, i7, i6);
                                        this.f8384g.m3079E(0);
                                        iM3086f = this.f8384g.m3086f();
                                        if (iM3086f >= i15) {
                                            throw ParserException.m8755a("Invalid NAL length", null);
                                        }
                                        this.f8374B = iM3086f - 1;
                                        this.f8383f.m3079E(0);
                                        interfaceC3122w.mo2524c(this.f8383f, 4);
                                        interfaceC3122w.mo2524c(this.f8384g, i15);
                                        if (this.f8378F.length > 0) {
                                            str = c3054m.f8465f.f7155w;
                                            b2 = bArr[4];
                                            byte[] bArr6 = C2754u.f6753a;
                                            if ((!"video/avc".equals(str) && (b2 & 31) == c) || ("video/hevc".equals(str) && ((b2 & 126) >> i15) == 39)) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                        } else {
                                            z2 = false;
                                        }
                                        this.f8375C = z2;
                                        this.f8373A += 5;
                                        this.f8403z += i7;
                                    } else {
                                        if (this.f8375C) {
                                            this.f8385h.m3075A(i8);
                                            interfaceC3041i.readFully(this.f8385h.f6793a, 0, this.f8374B);
                                            interfaceC3122w.mo2524c(this.f8385h, this.f8374B);
                                            iMo2523b = this.f8374B;
                                            C2757x c2757x9 = this.f8385h;
                                            int iM3059f4 = C2754u.m3059f(c2757x9.f6793a, c2757x9.f6795c);
                                            this.f8385h.m3079E("video/hevc".equals(c3054m.f8465f.f7155w) ? 1 : 0);
                                            this.f8385h.m3078D(iM3059f4);
                                            C1460d.m444J(j2, this.f8385h, this.f8378F);
                                        } else {
                                            iMo2523b = interfaceC3122w.mo2523b(interfaceC3041i, i8, false);
                                        }
                                        this.f8373A += iMo2523b;
                                        this.f8374B -= iMo2523b;
                                        c = 6;
                                        i15 = 1;
                                    }
                                }
                            }
                            if (!bVar2.f8417l) {
                                i4 = bVar2.f8409d.f8499g[bVar2.f8411f];
                            } else if (bVar2.f8407b.f8485j[bVar2.f8411f]) {
                                i4 = 1;
                            } else {
                                i4 = 0;
                            }
                            if (bVar2.m3717b() != null) {
                                i4 |= BasicMeasure.EXACTLY;
                            }
                            int i27 = i4;
                            c3055nM3717b = bVar2.m3717b();
                            if (c3055nM3717b != null) {
                                aVar = c3055nM3717b.f8473c;
                            } else {
                                aVar = null;
                            }
                            interfaceC3122w.mo2525d(j2, i27, this.f8403z, 0, aVar);
                            while (!this.f8391n.isEmpty()) {
                                aVarRemoveFirst = this.f8391n.removeFirst();
                                this.f8398u -= aVarRemoveFirst.f8405b;
                                j3 = aVarRemoveFirst.f8404a + j2;
                                interfaceC3122wArr = this.f8377E;
                                i5 = 0;
                                while (i5 < length) {
                                    interfaceC3122wArr[i5].mo2525d(j3, 1, aVarRemoveFirst.f8405b, this.f8398u, null);
                                    i5++;
                                }
                            }
                            if (!bVar2.m3718c()) {
                                this.f8402y = null;
                            }
                            this.f8392o = 3;
                            i15 = 1;
                        }
                    }
                }
                if (i15 != 0) {
                    return 0;
                }
            } else {
                int size3 = this.f8382e.size();
                long j12 = Long.MAX_VALUE;
                b bVarValueAt2 = null;
                for (int i28 = 0; i28 < size3; i28++) {
                    C3056o c3056o4 = this.f8382e.valueAt(i28).f8407b;
                    if (c3056o4.f8490o) {
                        long j13 = c3056o4.f8478c;
                        if (j13 < j12) {
                            bVarValueAt2 = this.f8382e.valueAt(i28);
                            j12 = j13;
                        }
                    }
                }
                if (bVarValueAt2 == null) {
                    this.f8392o = 3;
                } else {
                    int position5 = (int) (j12 - interfaceC3041i.getPosition());
                    if (position5 < 0) {
                        throw ParserException.m8755a("Offset to encryption data was negative.", null);
                    }
                    interfaceC3041i.mo3650l(position5);
                    C3056o c3056o5 = bVarValueAt2.f8407b;
                    C2757x c2757x10 = c3056o5.f8489n;
                    interfaceC3041i.readFully(c2757x10.f6793a, 0, c2757x10.f6795c);
                    c3056o5.f8489n.m3079E(0);
                    c3056o5.f8490o = false;
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: f */
    public void mo3636f(InterfaceC3058j interfaceC3058j) {
        int i;
        this.f8376D = interfaceC3058j;
        m3713c();
        InterfaceC3122w[] interfaceC3122wArr = new InterfaceC3122w[2];
        this.f8377E = interfaceC3122wArr;
        int i2 = 100;
        int i3 = 0;
        if ((this.f8380c & 4) != 0) {
            interfaceC3122wArr[0] = this.f8376D.mo2492p(100, 5);
            i2 = 101;
            i = 1;
        } else {
            i = 0;
        }
        InterfaceC3122w[] interfaceC3122wArr2 = (InterfaceC3122w[]) C2738e0.m2983D(this.f8377E, i);
        this.f8377E = interfaceC3122wArr2;
        for (InterfaceC3122w interfaceC3122w : interfaceC3122wArr2) {
            interfaceC3122w.mo2526e(f8372b);
        }
        this.f8378F = new InterfaceC3122w[this.f8381d.size()];
        while (i3 < this.f8378F.length) {
            InterfaceC3122w interfaceC3122wMo2492p = this.f8376D.mo2492p(i2, 3);
            interfaceC3122wMo2492p.mo2526e(this.f8381d.get(i3));
            this.f8378F[i3] = interfaceC3122wMo2492p;
            i3++;
            i2++;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        int size = this.f8382e.size();
        for (int i = 0; i < size; i++) {
            this.f8382e.valueAt(i).m3720e();
        }
        this.f8391n.clear();
        this.f8398u = 0;
        this.f8399v = j2;
        this.f8390m.clear();
        m3713c();
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
    /* JADX INFO: renamed from: j */
    public final void m3715j(long j) throws ParserException {
        C3048g c3048g;
        byte[] bArr;
        SparseArray<b> sparseArray;
        AbstractC3045d.a aVar;
        int i;
        int i2;
        int i3;
        int i4;
        byte[] bArr2;
        int i5;
        C3056o c3056o;
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
        int iM3086f;
        int iM3086f2;
        int iM3086f3;
        int iM3086f4;
        boolean z3;
        C3048g c3048g2 = this;
        final C3048g c3048g3 = c3048g2;
        while (!c3048g3.f8390m.isEmpty() && c3048g3.f8390m.peek().f8350b == j) {
            AbstractC3045d.a aVarPop = c3048g3.f8390m.pop();
            int i9 = aVarPop.f8349a;
            int i10 = 12;
            if (i9 == 1836019574) {
                C1460d.m429E(true, "Unexpected moov box.");
                DrmInitData drmInitDataM3711h = m3711h(aVarPop.f8351c);
                AbstractC3045d.a aVarM3700b = aVarPop.m3700b(1836475768);
                Objects.requireNonNull(aVarM3700b);
                SparseArray<C3047f> sparseArray2 = new SparseArray<>();
                int size = aVarM3700b.f8351c.size();
                long jM3101u = -9223372036854775807L;
                int i11 = 0;
                while (i11 < size) {
                    AbstractC3045d.b bVar = aVarM3700b.f8351c.get(i11);
                    int i12 = bVar.f8349a;
                    if (i12 == 1953654136) {
                        C2757x c2757x = bVar.f8353b;
                        c2757x.m3079E(i10);
                        Pair pairCreate = Pair.create(Integer.valueOf(c2757x.m3086f()), new C3047f(c2757x.m3086f() - 1, c2757x.m3086f(), c2757x.m3086f(), c2757x.m3086f()));
                        sparseArray2.put(((Integer) pairCreate.first).intValue(), (C3047f) pairCreate.second);
                    } else {
                        if (i12 == 1835362404) {
                            C2757x c2757x2 = bVar.f8353b;
                            c2757x2.m3079E(8);
                            jM3101u = ((c2757x2.m3086f() >> 24) & 255) == 0 ? c2757x2.m3101u() : c2757x2.m3104x();
                        }
                        i11++;
                        i10 = 12;
                    }
                    i11++;
                    i10 = 12;
                }
                ArrayList arrayList = (ArrayList) C3046e.m3706e(aVarPop, new C3115p(), jM3101u, drmInitDataM3711h, (c3048g3.f8380c & 16) != 0, false, new InterfaceC4485e() { // from class: b.i.a.c.x2.i0.c
                    @Override // p007b.p225i.p355b.p356a.InterfaceC4485e
                    public final Object apply(Object obj) {
                        C3054m c3054m = (C3054m) obj;
                        Objects.requireNonNull(this.f8348a);
                        return c3054m;
                    }
                });
                int size2 = arrayList.size();
                if (c3048g3.f8382e.size() == 0) {
                    for (int i13 = 0; i13 < size2; i13++) {
                        C3057p c3057p = (C3057p) arrayList.get(i13);
                        C3054m c3054m = c3057p.f8493a;
                        c3048g3.f8382e.put(c3054m.f8460a, new b(c3048g3.f8376D.mo2492p(i13, c3054m.f8461b), c3057p, c3048g3.m3714d(sparseArray2, c3054m.f8460a)));
                        c3048g3.f8400w = Math.max(c3048g3.f8400w, c3054m.f8464e);
                    }
                    c3048g3.f8376D.mo2486j();
                } else {
                    C1460d.m426D(c3048g3.f8382e.size() == size2);
                    for (int i14 = 0; i14 < size2; i14++) {
                        C3057p c3057p2 = (C3057p) arrayList.get(i14);
                        C3054m c3054m2 = c3057p2.f8493a;
                        b bVar2 = c3048g3.f8382e.get(c3054m2.f8460a);
                        C3047f c3047fM3714d = c3048g3.m3714d(sparseArray2, c3054m2.f8460a);
                        bVar2.f8409d = c3057p2;
                        bVar2.f8410e = c3047fM3714d;
                        bVar2.f8406a.mo2526e(c3057p2.f8493a.f8465f);
                        bVar2.m3720e();
                    }
                }
                c3048g = c3048g2;
            } else {
                int i15 = 8;
                if (i9 == 1836019558) {
                    SparseArray<b> sparseArray3 = c3048g3.f8382e;
                    int i16 = c3048g3.f8380c;
                    byte[] bArr3 = c3048g3.f8386i;
                    int size3 = aVarPop.f8352d.size();
                    int i17 = 0;
                    while (i17 < size3) {
                        AbstractC3045d.a aVar2 = aVarPop.f8352d.get(i17);
                        if (aVar2.f8349a == 1953653094) {
                            AbstractC3045d.b bVarM3701c = aVar2.m3701c(1952868452);
                            Objects.requireNonNull(bVarM3701c);
                            C2757x c2757x3 = bVarM3701c.f8353b;
                            c2757x3.m3079E(i15);
                            int iM3086f5 = c2757x3.m3086f() & ViewCompat.MEASURED_SIZE_MASK;
                            b bVar3 = sparseArray3.get(c2757x3.m3086f());
                            if (bVar3 == null) {
                                bVar3 = null;
                            } else {
                                if ((iM3086f5 & 1) != 0) {
                                    long jM3104x = c2757x3.m3104x();
                                    C3056o c3056o2 = bVar3.f8407b;
                                    c3056o2.f8477b = jM3104x;
                                    c3056o2.f8478c = jM3104x;
                                }
                                C3047f c3047f = bVar3.f8410e;
                                bVar3.f8407b.f8476a = new C3047f((iM3086f5 & 2) != 0 ? c2757x3.m3086f() - 1 : c3047f.f8367a, (iM3086f5 & 8) != 0 ? c2757x3.m3086f() : c3047f.f8368b, (iM3086f5 & 16) != 0 ? c2757x3.m3086f() : c3047f.f8369c, (iM3086f5 & 32) != 0 ? c2757x3.m3086f() : c3047f.f8370d);
                            }
                            if (bVar3 == null) {
                                bArr = bArr3;
                                sparseArray = sparseArray3;
                                aVar = aVarPop;
                                i = i16;
                                i2 = size3;
                                i3 = i17;
                            } else {
                                C3056o c3056o3 = bVar3.f8407b;
                                long j5 = c3056o3.f8491p;
                                boolean z4 = c3056o3.f8492q;
                                bVar3.m3720e();
                                bVar3.f8417l = true;
                                AbstractC3045d.b bVarM3701c2 = aVar2.m3701c(1952867444);
                                if (bVarM3701c2 == null || (i16 & 2) != 0) {
                                    c3056o3.f8491p = j5;
                                    c3056o3.f8492q = z4;
                                } else {
                                    C2757x c2757x4 = bVarM3701c2.f8353b;
                                    c2757x4.m3079E(i15);
                                    c3056o3.f8491p = ((c2757x4.m3086f() >> 24) & 255) == 1 ? c2757x4.m3104x() : c2757x4.m3101u();
                                    c3056o3.f8492q = true;
                                }
                                List<AbstractC3045d.b> list = aVar2.f8351c;
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
                                    AbstractC3045d.b bVar4 = list.get(i18);
                                    int i21 = size3;
                                    if (bVar4.f8349a == 1953658222) {
                                        C2757x c2757x5 = bVar4.f8353b;
                                        c2757x5.m3079E(12);
                                        int iM3103w = c2757x5.m3103w();
                                        if (iM3103w > 0) {
                                            i20 += iM3103w;
                                            i19++;
                                        }
                                    }
                                    i18++;
                                    size3 = i21;
                                    sparseArray3 = sparseArray4;
                                }
                                sparseArray = sparseArray3;
                                i2 = size3;
                                bVar3.f8413h = 0;
                                bVar3.f8412g = 0;
                                bVar3.f8411f = 0;
                                C3056o c3056o4 = bVar3.f8407b;
                                c3056o4.f8479d = i19;
                                c3056o4.f8480e = i20;
                                if (c3056o4.f8482g.length < i19) {
                                    c3056o4.f8481f = new long[i19];
                                    c3056o4.f8482g = new int[i19];
                                }
                                if (c3056o4.f8483h.length < i20) {
                                    int i22 = (i20 * Opcodes.LUSHR) / 100;
                                    c3056o4.f8483h = new int[i22];
                                    c3056o4.f8484i = new long[i22];
                                    c3056o4.f8485j = new boolean[i22];
                                    c3056o4.f8487l = new boolean[i22];
                                }
                                int i23 = 0;
                                int i24 = 0;
                                int i25 = 0;
                                while (i23 < size4) {
                                    AbstractC3045d.b bVar5 = list.get(i23);
                                    if (bVar5.f8349a == i4) {
                                        int i26 = i25 + 1;
                                        C2757x c2757x6 = bVar5.f8353b;
                                        c2757x6.m3079E(8);
                                        int iM3086f6 = c2757x6.m3086f() & ViewCompat.MEASURED_SIZE_MASK;
                                        C3054m c3054m3 = bVar3.f8409d.f8493a;
                                        C3056o c3056o5 = bVar3.f8407b;
                                        C3047f c3047f2 = c3056o5.f8476a;
                                        int i27 = C2738e0.f6708a;
                                        c3056o5.f8482g[i25] = c2757x6.m3103w();
                                        long[] jArr2 = c3056o5.f8481f;
                                        jArr2[i25] = c3056o5.f8477b;
                                        if ((iM3086f6 & 1) != 0) {
                                            jArr2[i25] = jArr2[i25] + ((long) c2757x6.m3086f());
                                        }
                                        boolean z5 = (iM3086f6 & 4) != 0;
                                        int iM3086f7 = c3047f2.f8370d;
                                        if (z5) {
                                            iM3086f7 = c2757x6.m3086f();
                                        }
                                        boolean z6 = (iM3086f6 & 256) != 0;
                                        boolean z7 = (iM3086f6 & 512) != 0;
                                        boolean z8 = (iM3086f6 & 1024) != 0;
                                        boolean z9 = (iM3086f6 & 2048) != 0;
                                        long[] jArr3 = c3054m3.f8467h;
                                        if (jArr3 != null) {
                                            i6 = iM3086f7;
                                            c3056o = c3056o3;
                                            if (jArr3.length == 1 && jArr3[0] == 0) {
                                                j2 = c3054m3.f8468i[0];
                                            }
                                            iArr = c3056o5.f8483h;
                                            jArr = c3056o5.f8484i;
                                            zArr = c3056o5.f8485j;
                                            if (c3054m3.f8461b == 2 || (i16 & 1) == 0) {
                                                z2 = false;
                                            } else {
                                                z2 = true;
                                            }
                                            i7 = c3056o5.f8482g[i25] + i24;
                                            j3 = c3054m3.f8462c;
                                            j4 = c3056o5.f8491p;
                                            i8 = i24;
                                            while (i8 < i7) {
                                                if (z6) {
                                                    iM3086f = c2757x6.m3086f();
                                                } else {
                                                    iM3086f = c3047f2.f8368b;
                                                }
                                                m3710a(iM3086f);
                                                if (z7) {
                                                    iM3086f2 = c2757x6.m3086f();
                                                } else {
                                                    iM3086f2 = c3047f2.f8369c;
                                                }
                                                m3710a(iM3086f2);
                                                if (z8) {
                                                    iM3086f3 = c2757x6.m3086f();
                                                } else if (i8 == 0 || !z5) {
                                                    iM3086f3 = c3047f2.f8370d;
                                                } else {
                                                    iM3086f3 = i6;
                                                }
                                                if (z9) {
                                                    iM3086f4 = c2757x6.m3086f();
                                                } else {
                                                    iM3086f4 = 0;
                                                }
                                                jArr[i8] = C2738e0.m2985F((((long) iM3086f4) + j4) - j2, 1000000L, j3);
                                                if (!c3056o5.f8492q) {
                                                    jArr[i8] = jArr[i8] + bVar3.f8409d.f8500h;
                                                }
                                                iArr[i8] = iM3086f2;
                                                if (((iM3086f3 >> 16) & 1) == 0 || (z2 && i8 != 0)) {
                                                    z3 = false;
                                                } else {
                                                    z3 = true;
                                                }
                                                zArr[i8] = z3;
                                                j4 += (long) iM3086f;
                                                i8++;
                                                i7 = i7;
                                                c2757x6 = c2757x6;
                                                z6 = z6;
                                                z7 = z7;
                                                z5 = z5;
                                                z8 = z8;
                                                z9 = z9;
                                            }
                                            int i28 = i7;
                                            c3056o5.f8491p = j4;
                                            i25 = i26;
                                            i24 = i28;
                                        } else {
                                            i6 = iM3086f7;
                                            c3056o = c3056o3;
                                        }
                                        j2 = 0;
                                        iArr = c3056o5.f8483h;
                                        jArr = c3056o5.f8484i;
                                        zArr = c3056o5.f8485j;
                                        if (c3054m3.f8461b == 2) {
                                            z2 = false;
                                        } else {
                                            z2 = false;
                                        }
                                        i7 = c3056o5.f8482g[i25] + i24;
                                        j3 = c3054m3.f8462c;
                                        j4 = c3056o5.f8491p;
                                        i8 = i24;
                                        while (i8 < i7) {
                                            if (z6) {
                                                iM3086f = c2757x6.m3086f();
                                            } else {
                                                iM3086f = c3047f2.f8368b;
                                            }
                                            m3710a(iM3086f);
                                            if (z7) {
                                                iM3086f2 = c2757x6.m3086f();
                                            } else {
                                                iM3086f2 = c3047f2.f8369c;
                                            }
                                            m3710a(iM3086f2);
                                            if (z8) {
                                                iM3086f3 = c2757x6.m3086f();
                                            } else if (i8 == 0) {
                                                iM3086f3 = c3047f2.f8370d;
                                            } else {
                                                iM3086f3 = c3047f2.f8370d;
                                            }
                                            if (z9) {
                                                iM3086f4 = c2757x6.m3086f();
                                            } else {
                                                iM3086f4 = 0;
                                            }
                                            jArr[i8] = C2738e0.m2985F((((long) iM3086f4) + j4) - j2, 1000000L, j3);
                                            if (!c3056o5.f8492q) {
                                                jArr[i8] = jArr[i8] + bVar3.f8409d.f8500h;
                                            }
                                            iArr[i8] = iM3086f2;
                                            if (((iM3086f3 >> 16) & 1) == 0) {
                                                z3 = false;
                                            } else {
                                                z3 = false;
                                            }
                                            zArr[i8] = z3;
                                            j4 += (long) iM3086f;
                                            i8++;
                                            i7 = i7;
                                            c2757x6 = c2757x6;
                                            z6 = z6;
                                            z7 = z7;
                                            z5 = z5;
                                            z8 = z8;
                                            z9 = z9;
                                        }
                                        int i29 = i7;
                                        c3056o5.f8491p = j4;
                                        i25 = i26;
                                        i24 = i29;
                                    } else {
                                        bArr3 = bArr3;
                                        i23 = i23;
                                        aVarPop = aVarPop;
                                        c3056o = c3056o3;
                                    }
                                    i23++;
                                    i16 = i16;
                                    list = list;
                                    size4 = size4;
                                    i17 = i17;
                                    aVar2 = aVar2;
                                    aVarPop = aVarPop;
                                    bArr3 = bArr3;
                                    c3056o3 = c3056o;
                                    i4 = 1953658222;
                                }
                                byte[] bArr4 = bArr3;
                                aVar = aVarPop;
                                i = i16;
                                i3 = i17;
                                C3056o c3056o6 = c3056o3;
                                C3054m c3054m4 = bVar3.f8409d.f8493a;
                                C3047f c3047f3 = c3056o6.f8476a;
                                Objects.requireNonNull(c3047f3);
                                C3055n c3055nM3731a = c3054m4.m3731a(c3047f3.f8367a);
                                AbstractC3045d.b bVarM3701c3 = aVar2.m3701c(1935763834);
                                if (bVarM3701c3 != null) {
                                    Objects.requireNonNull(c3055nM3731a);
                                    C2757x c2757x7 = bVarM3701c3.f8353b;
                                    int i30 = c3055nM3731a.f8474d;
                                    c2757x7.m3079E(8);
                                    if ((c2757x7.m3086f() & ViewCompat.MEASURED_SIZE_MASK & 1) == 1) {
                                        c2757x7.m3080F(8);
                                    }
                                    int iM3100t = c2757x7.m3100t();
                                    int iM3103w2 = c2757x7.m3103w();
                                    int i31 = c3056o6.f8480e;
                                    if (iM3103w2 > i31) {
                                        throw ParserException.m8755a(C1643a.m853h(78, "Saiz sample count ", iM3103w2, " is greater than fragment sample count", i31), null);
                                    }
                                    if (iM3100t == 0) {
                                        boolean[] zArr2 = c3056o6.f8487l;
                                        i5 = 0;
                                        for (int i32 = 0; i32 < iM3103w2; i32++) {
                                            int iM3100t2 = c2757x7.m3100t();
                                            i5 += iM3100t2;
                                            zArr2[i32] = iM3100t2 > i30;
                                        }
                                    } else {
                                        i5 = (iM3100t * iM3103w2) + 0;
                                        Arrays.fill(c3056o6.f8487l, 0, iM3103w2, iM3100t > i30);
                                    }
                                    Arrays.fill(c3056o6.f8487l, iM3103w2, c3056o6.f8480e, false);
                                    if (i5 > 0) {
                                        C2757x c2757x8 = c3056o6.f8489n;
                                        byte[] bArr5 = c2757x8.f6793a;
                                        if (bArr5.length < i5) {
                                            bArr5 = new byte[i5];
                                        }
                                        c2757x8.m3077C(bArr5, i5);
                                        c3056o6.f8486k = true;
                                        c3056o6.f8490o = true;
                                    }
                                }
                                AbstractC3045d.b bVarM3701c4 = aVar2.m3701c(1935763823);
                                if (bVarM3701c4 != null) {
                                    C2757x c2757x9 = bVarM3701c4.f8353b;
                                    c2757x9.m3079E(8);
                                    int iM3086f8 = c2757x9.m3086f();
                                    if ((16777215 & iM3086f8 & 1) == 1) {
                                        c2757x9.m3080F(8);
                                    }
                                    int iM3103w3 = c2757x9.m3103w();
                                    if (iM3103w3 != 1) {
                                        throw C1643a.m884w0(40, "Unexpected saio entry count: ", iM3103w3, null);
                                    }
                                    c3056o6.f8478c += ((iM3086f8 >> 24) & 255) == 0 ? c2757x9.m3101u() : c2757x9.m3104x();
                                }
                                byte[] bArr6 = null;
                                AbstractC3045d.b bVarM3701c5 = aVar2.m3701c(1936027235);
                                if (bVarM3701c5 != null) {
                                    m3712i(bVarM3701c5.f8353b, 0, c3056o6);
                                }
                                String str = c3055nM3731a != null ? c3055nM3731a.f8472b : null;
                                C2757x c2757x10 = null;
                                C2757x c2757x11 = null;
                                for (int i33 = 0; i33 < aVar2.f8351c.size(); i33++) {
                                    AbstractC3045d.b bVar6 = aVar2.f8351c.get(i33);
                                    C2757x c2757x12 = bVar6.f8353b;
                                    int i34 = bVar6.f8349a;
                                    if (i34 == 1935828848) {
                                        c2757x12.m3079E(12);
                                        if (c2757x12.m3086f() == 1936025959) {
                                            c2757x10 = c2757x12;
                                        }
                                    } else if (i34 == 1936158820) {
                                        c2757x12.m3079E(12);
                                        if (c2757x12.m3086f() == 1936025959) {
                                            c2757x11 = c2757x12;
                                        }
                                    }
                                }
                                if (c2757x10 != null && c2757x11 != null) {
                                    c2757x10.m3079E(8);
                                    int iM3086f9 = (c2757x10.m3086f() >> 24) & 255;
                                    c2757x10.m3080F(4);
                                    if (iM3086f9 == 1) {
                                        c2757x10.m3080F(4);
                                    }
                                    if (c2757x10.m3086f() != 1) {
                                        throw ParserException.m8756b("Entry count in sbgp != 1 (unsupported).");
                                    }
                                    c2757x11.m3079E(8);
                                    int iM3086f10 = (c2757x11.m3086f() >> 24) & 255;
                                    c2757x11.m3080F(4);
                                    if (iM3086f10 == 1) {
                                        if (c2757x11.m3101u() == 0) {
                                            throw ParserException.m8756b("Variable length description in sgpd found (unsupported)");
                                        }
                                    } else if (iM3086f10 >= 2) {
                                        c2757x11.m3080F(4);
                                    }
                                    if (c2757x11.m3101u() != 1) {
                                        throw ParserException.m8756b("Entry count in sgpd != 1 (unsupported).");
                                    }
                                    c2757x11.m3080F(1);
                                    int iM3100t3 = c2757x11.m3100t();
                                    int i35 = (iM3100t3 & 240) >> 4;
                                    int i36 = iM3100t3 & 15;
                                    boolean z10 = c2757x11.m3100t() == 1;
                                    if (z10) {
                                        int iM3100t4 = c2757x11.m3100t();
                                        byte[] bArr7 = new byte[16];
                                        System.arraycopy(c2757x11.f6793a, c2757x11.f6794b, bArr7, 0, 16);
                                        c2757x11.f6794b += 16;
                                        if (iM3100t4 == 0) {
                                            int iM3100t5 = c2757x11.m3100t();
                                            bArr6 = new byte[iM3100t5];
                                            System.arraycopy(c2757x11.f6793a, c2757x11.f6794b, bArr6, 0, iM3100t5);
                                            c2757x11.f6794b += iM3100t5;
                                        }
                                        c3056o6.f8486k = true;
                                        c3056o6.f8488m = new C3055n(z10, str, iM3100t4, bArr7, i35, i36, bArr6);
                                    }
                                }
                                int size5 = aVar2.f8351c.size();
                                int i37 = 0;
                                while (i37 < size5) {
                                    AbstractC3045d.b bVar7 = aVar2.f8351c.get(i37);
                                    if (bVar7.f8349a == 1970628964) {
                                        C2757x c2757x13 = bVar7.f8353b;
                                        c2757x13.m3079E(8);
                                        bArr2 = bArr4;
                                        System.arraycopy(c2757x13.f6793a, c2757x13.f6794b, bArr2, 0, 16);
                                        c2757x13.f6794b += 16;
                                        if (Arrays.equals(bArr2, f8371a)) {
                                            m3712i(c2757x13, 16, c3056o6);
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
                    DrmInitData drmInitDataM3711h2 = m3711h(aVarPop.f8351c);
                    c3048g = this;
                    if (drmInitDataM3711h2 != null) {
                        int size6 = c3048g.f8382e.size();
                        for (int i38 = 0; i38 < size6; i38++) {
                            b bVarValueAt = c3048g.f8382e.valueAt(i38);
                            C3054m c3054m5 = bVarValueAt.f8409d.f8493a;
                            C3047f c3047f4 = bVarValueAt.f8407b.f8476a;
                            int i39 = C2738e0.f6708a;
                            C3055n c3055nM3731a2 = c3054m5.m3731a(c3047f4.f8367a);
                            DrmInitData drmInitDataM8835a = drmInitDataM3711h2.m8835a(c3055nM3731a2 != null ? c3055nM3731a2.f8472b : null);
                            C2811j1.b bVarM3275a = bVarValueAt.f8409d.f8493a.f8465f.m3275a();
                            bVarM3275a.f7176n = drmInitDataM8835a;
                            bVarValueAt.f8406a.mo2526e(bVarM3275a.m3277a());
                        }
                    }
                    if (c3048g.f8399v != -9223372036854775807L) {
                        int size7 = c3048g.f8382e.size();
                        for (int i40 = 0; i40 < size7; i40++) {
                            b bVarValueAt2 = c3048g.f8382e.valueAt(i40);
                            long j6 = c3048g.f8399v;
                            int i41 = bVarValueAt2.f8411f;
                            while (true) {
                                C3056o c3056o7 = bVarValueAt2.f8407b;
                                if (i41 >= c3056o7.f8480e || c3056o7.f8484i[i41] >= j6) {
                                    break;
                                }
                                if (c3056o7.f8485j[i41]) {
                                    bVarValueAt2.f8414i = i41;
                                }
                                i41++;
                            }
                        }
                        c3048g.f8399v = -9223372036854775807L;
                    }
                    c3048g3 = c3048g;
                } else {
                    c3048g = c3048g2;
                    if (!c3048g3.f8390m.isEmpty()) {
                        c3048g3.f8390m.peek().f8352d.add(aVarPop);
                    }
                }
            }
            c3048g2 = c3048g;
        }
        m3713c();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    public void release() {
    }
}

package b.i.a.c.b3.n;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.b3.Cue;
import b.i.a.c.b3.Subtitle;
import b.i.a.c.b3.SubtitleInputBuffer;
import b.i.a.c.b3.n.Cea708Decoder;
import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.f3.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.a.c.b3.n.d, reason: use source file name */
/* JADX INFO: compiled from: Cea708Decoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Cea708Decoder extends CeaDecoder {
    public final ParsableByteArray g = new ParsableByteArray();
    public final ParsableBitArray h = new ParsableBitArray();
    public int i = -1;
    public final int j;
    public final b[] k;
    public b l;

    @Nullable
    public List<Cue> m;

    @Nullable
    public List<Cue> n;

    @Nullable
    public c o;
    public int p;

    /* JADX INFO: renamed from: b.i.a.c.b3.n.d$a */
    /* JADX INFO: compiled from: Cea708Decoder.java */
    public static final class a {
        public final Cue a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f853b;

        public a(CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z2, int i4, int i5) {
            boolean z3;
            int i6;
            if (z2) {
                i6 = i4;
                z3 = true;
            } else {
                z3 = false;
                i6 = ViewCompat.MEASURED_STATE_MASK;
            }
            this.a = new Cue(charSequence, alignment, null, null, f, i, i2, f2, i3, Integer.MIN_VALUE, -3.4028235E38f, f3, -3.4028235E38f, z3, i6, Integer.MIN_VALUE, 0.0f, null);
            this.f853b = i5;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.n.d$b */
    /* JADX INFO: compiled from: Cea708Decoder.java */
    public static final class b {
        public static final int a = d(2, 2, 2, 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f854b;
        public static final int c;
        public static final int[] d;
        public static final int[] e;
        public static final int[] f;
        public static final boolean[] g;
        public static final int[] h;
        public static final int[] i;
        public static final int[] j;
        public static final int[] k;
        public int A;
        public int B;
        public int C;
        public int D;
        public int E;
        public int F;
        public int G;
        public final List<SpannableString> l = new ArrayList();
        public final SpannableStringBuilder m = new SpannableStringBuilder();
        public boolean n;
        public boolean o;
        public int p;
        public boolean q;
        public int r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f855s;
        public int t;
        public int u;
        public boolean v;
        public int w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f856x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f857y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f858z;

        static {
            int iD = d(0, 0, 0, 0);
            f854b = iD;
            int iD2 = d(0, 0, 0, 3);
            c = iD2;
            d = new int[]{0, 0, 0, 0, 0, 2, 0};
            e = new int[]{0, 0, 0, 0, 0, 0, 2};
            f = new int[]{3, 3, 3, 3, 3, 3, 1};
            g = new boolean[]{false, false, false, true, true, true, false};
            h = new int[]{iD, iD2, iD, iD, iD2, iD, iD};
            i = new int[]{0, 1, 2, 3, 4, 3, 4};
            j = new int[]{0, 0, 0, 0, 0, 3, 3};
            k = new int[]{iD, iD, iD, iD, iD, iD2, iD2};
        }

        public b() {
            f();
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0021  */
        public static int d(int i2, int i3, int i4, int i5) {
            int i6;
            AnimatableValueParser.t(i2, 0, 4);
            AnimatableValueParser.t(i3, 0, 4);
            AnimatableValueParser.t(i4, 0, 4);
            AnimatableValueParser.t(i5, 0, 4);
            if (i5 == 0 || i5 == 1) {
                i6 = 255;
            } else if (i5 == 2) {
                i6 = Opcodes.LAND;
            } else if (i5 != 3) {
                i6 = 255;
            } else {
                i6 = 0;
            }
            return Color.argb(i6, i2 > 1 ? 255 : 0, i3 > 1 ? 255 : 0, i4 > 1 ? 255 : 0);
        }

        public void a(char c2) {
            if (c2 != '\n') {
                this.m.append(c2);
                return;
            }
            this.l.add(b());
            this.m.clear();
            if (this.A != -1) {
                this.A = 0;
            }
            if (this.B != -1) {
                this.B = 0;
            }
            if (this.C != -1) {
                this.C = 0;
            }
            if (this.E != -1) {
                this.E = 0;
            }
            while (true) {
                if ((!this.v || this.l.size() < this.u) && this.l.size() < 15) {
                    return;
                } else {
                    this.l.remove(0);
                }
            }
        }

        public SpannableString b() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.m);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.A != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.A, length, 33);
                }
                if (this.B != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.B, length, 33);
                }
                if (this.C != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.D), this.C, length, 33);
                }
                if (this.E != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.F), this.E, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void c() {
            this.l.clear();
            this.m.clear();
            this.A = -1;
            this.B = -1;
            this.C = -1;
            this.E = -1;
            this.G = 0;
        }

        public boolean e() {
            return !this.n || (this.l.isEmpty() && this.m.length() == 0);
        }

        public void f() {
            c();
            this.n = false;
            this.o = false;
            this.p = 4;
            this.q = false;
            this.r = 0;
            this.f855s = 0;
            this.t = 0;
            this.u = 15;
            this.v = true;
            this.w = 0;
            this.f856x = 0;
            this.f857y = 0;
            int i2 = f854b;
            this.f858z = i2;
            this.D = a;
            this.F = i2;
        }

        public void g(boolean z2, boolean z3) {
            if (this.A != -1) {
                if (!z2) {
                    this.m.setSpan(new StyleSpan(2), this.A, this.m.length(), 33);
                    this.A = -1;
                }
            } else if (z2) {
                this.A = this.m.length();
            }
            if (this.B == -1) {
                if (z3) {
                    this.B = this.m.length();
                }
            } else {
                if (z3) {
                    return;
                }
                this.m.setSpan(new UnderlineSpan(), this.B, this.m.length(), 33);
                this.B = -1;
            }
        }

        public void h(int i2, int i3) {
            if (this.C != -1 && this.D != i2) {
                this.m.setSpan(new ForegroundColorSpan(this.D), this.C, this.m.length(), 33);
            }
            if (i2 != a) {
                this.C = this.m.length();
                this.D = i2;
            }
            if (this.E != -1 && this.F != i3) {
                this.m.setSpan(new BackgroundColorSpan(this.F), this.E, this.m.length(), 33);
            }
            if (i3 != f854b) {
                this.E = this.m.length();
                this.F = i3;
            }
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.n.d$c */
    /* JADX INFO: compiled from: Cea708Decoder.java */
    public static final class c {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f859b;
        public final byte[] c;
        public int d = 0;

        public c(int i, int i2) {
            this.a = i;
            this.f859b = i2;
            this.c = new byte[(i2 * 2) - 1];
        }
    }

    public Cea708Decoder(int i, @Nullable List<byte[]> list) {
        this.j = i == -1 ? 1 : i;
        if (list != null && (list.size() != 1 || list.get(0).length != 1 || list.get(0)[0] != 1)) {
        }
        this.k = new b[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.k[i2] = new b();
        }
        this.l = this.k[0];
    }

    @Override // b.i.a.c.b3.n.CeaDecoder
    public Subtitle e() {
        List<Cue> list = this.m;
        this.n = list;
        Objects.requireNonNull(list);
        return new CeaSubtitle(list);
    }

    @Override // b.i.a.c.b3.n.CeaDecoder
    public void f(SubtitleInputBuffer subtitleInputBuffer) {
        ByteBuffer byteBuffer = subtitleInputBuffer.l;
        Objects.requireNonNull(byteBuffer);
        this.g.C(byteBuffer.array(), byteBuffer.limit());
        while (this.g.a() >= 3) {
            int iT = this.g.t() & 7;
            int i = iT & 3;
            boolean z2 = (iT & 4) == 4;
            byte bT = (byte) this.g.t();
            byte bT2 = (byte) this.g.t();
            if (i == 2 || i == 3) {
                if (z2) {
                    if (i == 3) {
                        j();
                        int i2 = (bT & 192) >> 6;
                        int i3 = this.i;
                        if (i3 != -1 && i2 != (i3 + 1) % 4) {
                            l();
                            Log.w("Cea708Decoder", outline.h(71, "Sequence number discontinuity. previous=", this.i, " current=", i2));
                        }
                        this.i = i2;
                        int i4 = bT & 63;
                        if (i4 == 0) {
                            i4 = 64;
                        }
                        c cVar = new c(i2, i4);
                        this.o = cVar;
                        byte[] bArr = cVar.c;
                        int i5 = cVar.d;
                        cVar.d = i5 + 1;
                        bArr[i5] = bT2;
                    } else {
                        AnimatableValueParser.j(i == 2);
                        c cVar2 = this.o;
                        if (cVar2 == null) {
                            Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = cVar2.c;
                            int i6 = cVar2.d;
                            int i7 = i6 + 1;
                            cVar2.d = i7;
                            bArr2[i6] = bT;
                            cVar2.d = i7 + 1;
                            bArr2[i7] = bT2;
                        }
                    }
                    c cVar3 = this.o;
                    if (cVar3.d == (cVar3.f859b * 2) - 1) {
                        j();
                    }
                }
            }
        }
    }

    @Override // b.i.a.c.b3.n.CeaDecoder, b.i.a.c.v2.Decoder
    public void flush() {
        super.flush();
        this.m = null;
        this.n = null;
        this.p = 0;
        this.l = this.k[0];
        l();
        this.o = null;
    }

    @Override // b.i.a.c.b3.n.CeaDecoder
    public boolean h() {
        return this.m != this.n;
    }

    public final void j() {
        c cVar = this.o;
        if (cVar == null) {
            return;
        }
        int i = cVar.d;
        int i2 = (cVar.f859b * 2) - 1;
        if (i != i2) {
            int i3 = cVar.a;
            StringBuilder sb = new StringBuilder(115);
            sb.append("DtvCcPacket ended prematurely; size is ");
            sb.append(i2);
            sb.append(", but current index is ");
            sb.append(i);
            sb.append(" (sequence number ");
            sb.append(i3);
            sb.append(");");
            Log.d("Cea708Decoder", sb.toString());
        }
        ParsableBitArray parsableBitArray = this.h;
        c cVar2 = this.o;
        parsableBitArray.j(cVar2.c, cVar2.d);
        int i4 = 3;
        int iG = this.h.g(3);
        int iG2 = this.h.g(5);
        int i5 = 7;
        int i6 = 6;
        if (iG == 7) {
            this.h.m(2);
            iG = this.h.g(6);
            if (iG < 7) {
                outline.g0(44, "Invalid extended service number: ", iG, "Cea708Decoder");
            }
        }
        if (iG2 == 0) {
            if (iG != 0) {
                StringBuilder sb2 = new StringBuilder(59);
                sb2.append("serviceNumber is non-zero (");
                sb2.append(iG);
                sb2.append(") when blockSize is 0");
                Log.w("Cea708Decoder", sb2.toString());
            }
        } else if (iG == this.j) {
            boolean z2 = false;
            while (this.h.b() > 0) {
                int iG3 = this.h.g(8);
                if (iG3 == 16) {
                    int iG4 = this.h.g(8);
                    if (iG4 > 31) {
                        if (iG4 <= 127) {
                            if (iG4 == 32) {
                                this.l.a(' ');
                            } else if (iG4 == 33) {
                                this.l.a((char) 160);
                            } else if (iG4 == 37) {
                                this.l.a((char) 8230);
                            } else if (iG4 == 42) {
                                this.l.a((char) 352);
                            } else if (iG4 == 44) {
                                this.l.a((char) 338);
                            } else if (iG4 == 63) {
                                this.l.a((char) 376);
                            } else if (iG4 == 57) {
                                this.l.a((char) 8482);
                            } else if (iG4 == 58) {
                                this.l.a((char) 353);
                            } else if (iG4 == 60) {
                                this.l.a((char) 339);
                            } else if (iG4 != 61) {
                                switch (iG4) {
                                    case 48:
                                        this.l.a((char) 9608);
                                        break;
                                    case 49:
                                        this.l.a((char) 8216);
                                        break;
                                    case 50:
                                        this.l.a((char) 8217);
                                        break;
                                    case 51:
                                        this.l.a((char) 8220);
                                        break;
                                    case 52:
                                        this.l.a((char) 8221);
                                        break;
                                    case 53:
                                        this.l.a((char) 8226);
                                        break;
                                    default:
                                        switch (iG4) {
                                            case 118:
                                                this.l.a((char) 8539);
                                                break;
                                            case 119:
                                                this.l.a((char) 8540);
                                                break;
                                            case 120:
                                                this.l.a((char) 8541);
                                                break;
                                            case 121:
                                                this.l.a((char) 8542);
                                                break;
                                            case 122:
                                                this.l.a((char) 9474);
                                                break;
                                            case 123:
                                                this.l.a((char) 9488);
                                                break;
                                            case 124:
                                                this.l.a((char) 9492);
                                                break;
                                            case Opcodes.LUSHR /* 125 */:
                                                this.l.a((char) 9472);
                                                break;
                                            case 126:
                                                this.l.a((char) 9496);
                                                break;
                                            case Opcodes.LAND /* 127 */:
                                                this.l.a((char) 9484);
                                                break;
                                            default:
                                                outline.g0(33, "Invalid G2 character: ", iG4, "Cea708Decoder");
                                                break;
                                        }
                                        break;
                                }
                            } else {
                                this.l.a((char) 8480);
                            }
                        } else if (iG4 <= 159) {
                            if (iG4 <= 135) {
                                this.h.m(32);
                            } else if (iG4 <= 143) {
                                this.h.m(40);
                            } else if (iG4 <= 159) {
                                this.h.m(2);
                                this.h.m(this.h.g(6) * 8);
                            }
                        } else if (iG4 > 255) {
                            outline.g0(37, "Invalid extended command: ", iG4, "Cea708Decoder");
                        } else if (iG4 == 160) {
                            this.l.a((char) 13252);
                        } else {
                            outline.g0(33, "Invalid G3 character: ", iG4, "Cea708Decoder");
                            this.l.a('_');
                        }
                        z2 = true;
                    } else if (iG4 > 7) {
                        if (iG4 <= 15) {
                            this.h.m(8);
                        } else if (iG4 <= 23) {
                            this.h.m(16);
                        } else if (iG4 <= 31) {
                            this.h.m(24);
                        }
                    }
                } else if (iG3 > 31) {
                    if (iG3 <= 127) {
                        if (iG3 == 127) {
                            this.l.a((char) 9835);
                        } else {
                            this.l.a((char) (iG3 & 255));
                        }
                    } else if (iG3 <= 159) {
                        switch (iG3) {
                            case 128:
                            case Opcodes.LOR /* 129 */:
                            case 130:
                            case Opcodes.LXOR /* 131 */:
                            case Opcodes.IINC /* 132 */:
                            case Opcodes.I2L /* 133 */:
                            case Opcodes.I2F /* 134 */:
                            case Opcodes.I2D /* 135 */:
                                int i7 = iG3 - 128;
                                if (this.p != i7) {
                                    this.p = i7;
                                    this.l = this.k[i7];
                                }
                                break;
                            case Opcodes.L2I /* 136 */:
                                for (int i8 = 1; i8 <= 8; i8++) {
                                    if (this.h.f()) {
                                        this.k[8 - i8].c();
                                    }
                                }
                                break;
                            case Opcodes.L2F /* 137 */:
                                for (int i9 = 1; i9 <= 8; i9++) {
                                    if (this.h.f()) {
                                        this.k[8 - i9].o = true;
                                    }
                                }
                                break;
                            case Opcodes.L2D /* 138 */:
                                for (int i10 = 1; i10 <= 8; i10++) {
                                    if (this.h.f()) {
                                        this.k[8 - i10].o = false;
                                    }
                                }
                                break;
                            case Opcodes.F2I /* 139 */:
                                for (int i11 = 1; i11 <= 8; i11++) {
                                    if (this.h.f()) {
                                        b bVar = this.k[8 - i11];
                                        bVar.o = !bVar.o;
                                    }
                                }
                                break;
                            case Opcodes.F2L /* 140 */:
                                for (int i12 = 1; i12 <= 8; i12++) {
                                    if (this.h.f()) {
                                        this.k[8 - i12].f();
                                    }
                                }
                                break;
                            case Opcodes.F2D /* 141 */:
                                this.h.m(8);
                                break;
                            case Opcodes.D2I /* 142 */:
                                break;
                            case Opcodes.D2L /* 143 */:
                                l();
                                break;
                            case Opcodes.D2F /* 144 */:
                                if (this.l.n) {
                                    this.h.g(4);
                                    this.h.g(2);
                                    this.h.g(2);
                                    boolean zF = this.h.f();
                                    boolean zF2 = this.h.f();
                                    this.h.g(3);
                                    this.h.g(3);
                                    this.l.g(zF, zF2);
                                } else {
                                    this.h.m(16);
                                }
                                break;
                            case Opcodes.I2B /* 145 */:
                                if (this.l.n) {
                                    int iD = b.d(this.h.g(2), this.h.g(2), this.h.g(2), this.h.g(2));
                                    int iD2 = b.d(this.h.g(2), this.h.g(2), this.h.g(2), this.h.g(2));
                                    this.h.m(2);
                                    b.d(this.h.g(2), this.h.g(2), this.h.g(2), 0);
                                    this.l.h(iD, iD2);
                                } else {
                                    this.h.m(24);
                                }
                                break;
                            case Opcodes.I2C /* 146 */:
                                if (this.l.n) {
                                    this.h.m(4);
                                    int iG5 = this.h.g(4);
                                    this.h.m(2);
                                    this.h.g(6);
                                    b bVar2 = this.l;
                                    if (bVar2.G != iG5) {
                                        bVar2.a('\n');
                                    }
                                    bVar2.G = iG5;
                                } else {
                                    this.h.m(16);
                                }
                                break;
                            case Opcodes.I2S /* 147 */:
                            case Opcodes.LCMP /* 148 */:
                            case Opcodes.FCMPL /* 149 */:
                            case 150:
                            default:
                                Log.w("Cea708Decoder", outline.g(31, "Invalid C1 command: ", iG3));
                                break;
                            case Opcodes.DCMPL /* 151 */:
                                if (this.l.n) {
                                    int iD3 = b.d(this.h.g(2), this.h.g(2), this.h.g(2), this.h.g(2));
                                    this.h.g(2);
                                    b.d(this.h.g(2), this.h.g(2), this.h.g(2), 0);
                                    this.h.f();
                                    this.h.f();
                                    this.h.g(2);
                                    this.h.g(2);
                                    int iG6 = this.h.g(2);
                                    this.h.m(8);
                                    b bVar3 = this.l;
                                    bVar3.f858z = iD3;
                                    bVar3.w = iG6;
                                } else {
                                    this.h.m(32);
                                }
                                break;
                            case Opcodes.DCMPG /* 152 */:
                            case 153:
                            case 154:
                            case 155:
                            case 156:
                            case 157:
                            case 158:
                            case Opcodes.IF_ICMPEQ /* 159 */:
                                int i13 = iG3 - 152;
                                b bVar4 = this.k[i13];
                                this.h.m(2);
                                boolean zF3 = this.h.f();
                                boolean zF4 = this.h.f();
                                this.h.f();
                                int iG7 = this.h.g(i4);
                                boolean zF5 = this.h.f();
                                int iG8 = this.h.g(i5);
                                int iG9 = this.h.g(8);
                                int iG10 = this.h.g(4);
                                int iG11 = this.h.g(4);
                                this.h.m(2);
                                this.h.g(i6);
                                this.h.m(2);
                                int iG12 = this.h.g(i4);
                                int iG13 = this.h.g(i4);
                                bVar4.n = true;
                                bVar4.o = zF3;
                                bVar4.v = zF4;
                                bVar4.p = iG7;
                                bVar4.q = zF5;
                                bVar4.r = iG8;
                                bVar4.f855s = iG9;
                                bVar4.t = iG10;
                                int i14 = iG11 + 1;
                                if (bVar4.u != i14) {
                                    bVar4.u = i14;
                                    while (true) {
                                        if ((zF4 && bVar4.l.size() >= bVar4.u) || bVar4.l.size() >= 15) {
                                            bVar4.l.remove(0);
                                        }
                                    }
                                }
                                if (iG12 != 0 && bVar4.f856x != iG12) {
                                    bVar4.f856x = iG12;
                                    int i15 = iG12 - 1;
                                    int i16 = b.h[i15];
                                    boolean z3 = b.g[i15];
                                    int i17 = b.e[i15];
                                    int i18 = b.f[i15];
                                    int i19 = b.d[i15];
                                    bVar4.f858z = i16;
                                    bVar4.w = i19;
                                }
                                if (iG13 != 0 && bVar4.f857y != iG13) {
                                    bVar4.f857y = iG13;
                                    int i20 = iG13 - 1;
                                    int i21 = b.j[i20];
                                    int i22 = b.i[i20];
                                    bVar4.g(false, false);
                                    bVar4.h(b.a, b.k[i20]);
                                }
                                if (this.p != i13) {
                                    this.p = i13;
                                    this.l = this.k[i13];
                                }
                                break;
                        }
                    } else if (iG3 <= 255) {
                        this.l.a((char) (iG3 & 255));
                    } else {
                        outline.g0(33, "Invalid base command: ", iG3, "Cea708Decoder");
                    }
                    z2 = true;
                } else if (iG3 != 0) {
                    if (iG3 == i4) {
                        this.m = k();
                    } else if (iG3 != 8) {
                        switch (iG3) {
                            case 12:
                                l();
                                break;
                            case 13:
                                this.l.a('\n');
                                break;
                            case 14:
                                break;
                            default:
                                if (iG3 >= 17 && iG3 <= 23) {
                                    outline.g0(55, "Currently unsupported COMMAND_EXT1 Command: ", iG3, "Cea708Decoder");
                                    this.h.m(8);
                                } else if (iG3 < 24 || iG3 > 31) {
                                    outline.g0(31, "Invalid C0 command: ", iG3, "Cea708Decoder");
                                } else {
                                    outline.g0(54, "Currently unsupported COMMAND_P16 Command: ", iG3, "Cea708Decoder");
                                    this.h.m(16);
                                }
                                break;
                        }
                    } else {
                        b bVar5 = this.l;
                        int length = bVar5.m.length();
                        if (length > 0) {
                            bVar5.m.delete(length - 1, length);
                        }
                    }
                }
                i4 = 3;
                i5 = 7;
                i6 = 6;
            }
            if (z2) {
                this.m = k();
            }
        }
        this.o = null;
    }

    public final List<Cue> k() {
        Layout.Alignment alignment;
        float f;
        float f2;
        a aVar;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            if (!this.k[i].e()) {
                b[] bVarArr = this.k;
                if (bVarArr[i].o) {
                    b bVar = bVarArr[i];
                    if (bVar.e()) {
                        aVar = null;
                    } else {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        for (int i2 = 0; i2 < bVar.l.size(); i2++) {
                            spannableStringBuilder.append((CharSequence) bVar.l.get(i2));
                            spannableStringBuilder.append('\n');
                        }
                        spannableStringBuilder.append((CharSequence) bVar.b());
                        int i3 = bVar.w;
                        if (i3 == 0) {
                            alignment = Layout.Alignment.ALIGN_NORMAL;
                        } else if (i3 == 1) {
                            alignment = Layout.Alignment.ALIGN_OPPOSITE;
                        } else if (i3 != 2) {
                            if (i3 != 3) {
                                throw new IllegalArgumentException(outline.g(43, "Unexpected justification value: ", bVar.w));
                            }
                            alignment = Layout.Alignment.ALIGN_NORMAL;
                        } else {
                            alignment = Layout.Alignment.ALIGN_CENTER;
                        }
                        Layout.Alignment alignment2 = alignment;
                        if (bVar.q) {
                            f = bVar.f855s / 99.0f;
                            f2 = bVar.r / 99.0f;
                        } else {
                            f = bVar.f855s / 209.0f;
                            f2 = bVar.r / 74.0f;
                        }
                        float f3 = (f * 0.9f) + 0.05f;
                        float f4 = (f2 * 0.9f) + 0.05f;
                        int i4 = bVar.t;
                        int i5 = i4 / 3;
                        int i6 = i4 % 3;
                        aVar = new a(spannableStringBuilder, alignment2, f4, 0, i5 == 0 ? 0 : i5 == 1 ? 1 : 2, f3, i6 == 0 ? 0 : i6 == 1 ? 1 : 2, -3.4028235E38f, bVar.f858z != b.f854b, bVar.f858z, bVar.p);
                    }
                    if (aVar != null) {
                        arrayList.add(aVar);
                    }
                } else {
                    continue;
                }
            }
        }
        Collections.sort(arrayList, new Comparator() { // from class: b.i.a.c.b3.n.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Integer.compare(((Cea708Decoder.a) obj2).f853b, ((Cea708Decoder.a) obj).f853b);
            }
        });
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            arrayList2.add(((a) arrayList.get(i7)).a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public final void l() {
        for (int i = 0; i < 8; i++) {
            this.k[i].f();
        }
    }
}

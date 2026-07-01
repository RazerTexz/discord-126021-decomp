package b.i.a.c.b3.n;

import android.text.Layout$Alignment;
import android.text.SpannableStringBuilder;
import android.util.Log;
import androidx.annotation.Nullable;
import b.i.a.c.b3.g;
import b.i.a.c.b3.j;
import b.i.a.c.f3.w;
import b.i.a.c.f3.x;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: Cea708Decoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends e {
    public final x g = new x();
    public final w h = new w();
    public int i = -1;
    public final int j;
    public final d$b[] k;
    public d$b l;

    @Nullable
    public List<b.i.a.c.b3.b> m;

    @Nullable
    public List<b.i.a.c.b3.b> n;

    @Nullable
    public d$c o;
    public int p;

    public d(int i, @Nullable List<byte[]> list) {
        this.j = i == -1 ? 1 : i;
        if (list != null && (list.size() != 1 || list.get(0).length != 1 || list.get(0)[0] != 1)) {
        }
        this.k = new d$b[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.k[i2] = new d$b();
        }
        this.l = this.k[0];
    }

    @Override // b.i.a.c.b3.n.e
    public g e() {
        List<b.i.a.c.b3.b> list = this.m;
        this.n = list;
        Objects.requireNonNull(list);
        return new f(list);
    }

    @Override // b.i.a.c.b3.n.e
    public void f(j jVar) {
        ByteBuffer byteBuffer = jVar.l;
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
                            Log.w("Cea708Decoder", b.d.b.a.a.h(71, "Sequence number discontinuity. previous=", this.i, " current=", i2));
                        }
                        this.i = i2;
                        int i4 = bT & 63;
                        if (i4 == 0) {
                            i4 = 64;
                        }
                        d$c d_c = new d$c(i2, i4);
                        this.o = d_c;
                        byte[] bArr = d_c.c;
                        int i5 = d_c.d;
                        d_c.d = i5 + 1;
                        bArr[i5] = bT2;
                    } else {
                        b.c.a.a0.d.j(i == 2);
                        d$c d_c2 = this.o;
                        if (d_c2 == null) {
                            Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = d_c2.c;
                            int i6 = d_c2.d;
                            int i7 = i6 + 1;
                            d_c2.d = i7;
                            bArr2[i6] = bT;
                            d_c2.d = i7 + 1;
                            bArr2[i7] = bT2;
                        }
                    }
                    d$c d_c3 = this.o;
                    if (d_c3.d == (d_c3.f859b * 2) - 1) {
                        j();
                    }
                }
            }
        }
    }

    @Override // b.i.a.c.b3.n.e, b.i.a.c.v2.d
    public void flush() {
        super.flush();
        this.m = null;
        this.n = null;
        this.p = 0;
        this.l = this.k[0];
        l();
        this.o = null;
    }

    @Override // b.i.a.c.b3.n.e
    public boolean h() {
        return this.m != this.n;
    }

    public final void j() {
        d$c d_c = this.o;
        if (d_c == null) {
            return;
        }
        int i = d_c.d;
        int i2 = (d_c.f859b * 2) - 1;
        if (i != i2) {
            int i3 = d_c.a;
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
        w wVar = this.h;
        d$c d_c2 = this.o;
        wVar.j(d_c2.c, d_c2.d);
        int i4 = 3;
        int iG = this.h.g(3);
        int iG2 = this.h.g(5);
        int i5 = 7;
        int i6 = 6;
        if (iG == 7) {
            this.h.m(2);
            iG = this.h.g(6);
            if (iG < 7) {
                b.d.b.a.a.g0(44, "Invalid extended service number: ", iG, "Cea708Decoder");
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
                                                b.d.b.a.a.g0(33, "Invalid G2 character: ", iG4, "Cea708Decoder");
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
                            b.d.b.a.a.g0(37, "Invalid extended command: ", iG4, "Cea708Decoder");
                        } else if (iG4 == 160) {
                            this.l.a((char) 13252);
                        } else {
                            b.d.b.a.a.g0(33, "Invalid G3 character: ", iG4, "Cea708Decoder");
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
                                        d$b d_b = this.k[8 - i11];
                                        d_b.o = !d_b.o;
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
                                    int iD = d$b.d(this.h.g(2), this.h.g(2), this.h.g(2), this.h.g(2));
                                    int iD2 = d$b.d(this.h.g(2), this.h.g(2), this.h.g(2), this.h.g(2));
                                    this.h.m(2);
                                    d$b.d(this.h.g(2), this.h.g(2), this.h.g(2), 0);
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
                                    d$b d_b2 = this.l;
                                    if (d_b2.G != iG5) {
                                        d_b2.a('\n');
                                    }
                                    d_b2.G = iG5;
                                } else {
                                    this.h.m(16);
                                }
                                break;
                            case Opcodes.I2S /* 147 */:
                            case Opcodes.LCMP /* 148 */:
                            case Opcodes.FCMPL /* 149 */:
                            case 150:
                            default:
                                Log.w("Cea708Decoder", b.d.b.a.a.g(31, "Invalid C1 command: ", iG3));
                                break;
                            case Opcodes.DCMPL /* 151 */:
                                if (this.l.n) {
                                    int iD3 = d$b.d(this.h.g(2), this.h.g(2), this.h.g(2), this.h.g(2));
                                    this.h.g(2);
                                    d$b.d(this.h.g(2), this.h.g(2), this.h.g(2), 0);
                                    this.h.f();
                                    this.h.f();
                                    this.h.g(2);
                                    this.h.g(2);
                                    int iG6 = this.h.g(2);
                                    this.h.m(8);
                                    d$b d_b3 = this.l;
                                    d_b3.f858z = iD3;
                                    d_b3.w = iG6;
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
                                d$b d_b4 = this.k[i13];
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
                                d_b4.n = true;
                                d_b4.o = zF3;
                                d_b4.v = zF4;
                                d_b4.p = iG7;
                                d_b4.q = zF5;
                                d_b4.r = iG8;
                                d_b4.f855s = iG9;
                                d_b4.t = iG10;
                                int i14 = iG11 + 1;
                                if (d_b4.u != i14) {
                                    d_b4.u = i14;
                                    while (true) {
                                        if ((zF4 && d_b4.l.size() >= d_b4.u) || d_b4.l.size() >= 15) {
                                            d_b4.l.remove(0);
                                        }
                                    }
                                }
                                if (iG12 != 0 && d_b4.f856x != iG12) {
                                    d_b4.f856x = iG12;
                                    int i15 = iG12 - 1;
                                    int i16 = d$b.h[i15];
                                    boolean z3 = d$b.g[i15];
                                    int i17 = d$b.e[i15];
                                    int i18 = d$b.f[i15];
                                    int i19 = d$b.d[i15];
                                    d_b4.f858z = i16;
                                    d_b4.w = i19;
                                }
                                if (iG13 != 0 && d_b4.f857y != iG13) {
                                    d_b4.f857y = iG13;
                                    int i20 = iG13 - 1;
                                    int i21 = d$b.j[i20];
                                    int i22 = d$b.i[i20];
                                    d_b4.g(false, false);
                                    d_b4.h(d$b.a, d$b.k[i20]);
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
                        b.d.b.a.a.g0(33, "Invalid base command: ", iG3, "Cea708Decoder");
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
                                    b.d.b.a.a.g0(55, "Currently unsupported COMMAND_EXT1 Command: ", iG3, "Cea708Decoder");
                                    this.h.m(8);
                                } else if (iG3 < 24 || iG3 > 31) {
                                    b.d.b.a.a.g0(31, "Invalid C0 command: ", iG3, "Cea708Decoder");
                                } else {
                                    b.d.b.a.a.g0(54, "Currently unsupported COMMAND_P16 Command: ", iG3, "Cea708Decoder");
                                    this.h.m(16);
                                }
                                break;
                        }
                    } else {
                        d$b d_b5 = this.l;
                        int length = d_b5.m.length();
                        if (length > 0) {
                            d_b5.m.delete(length - 1, length);
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

    public final List<b.i.a.c.b3.b> k() {
        Layout$Alignment layout$Alignment;
        float f;
        float f2;
        d$a d_a;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            if (!this.k[i].e()) {
                d$b[] d_bArr = this.k;
                if (d_bArr[i].o) {
                    d$b d_b = d_bArr[i];
                    if (d_b.e()) {
                        d_a = null;
                    } else {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        for (int i2 = 0; i2 < d_b.l.size(); i2++) {
                            spannableStringBuilder.append((CharSequence) d_b.l.get(i2));
                            spannableStringBuilder.append('\n');
                        }
                        spannableStringBuilder.append((CharSequence) d_b.b());
                        int i3 = d_b.w;
                        if (i3 == 0) {
                            layout$Alignment = Layout$Alignment.ALIGN_NORMAL;
                        } else if (i3 == 1) {
                            layout$Alignment = Layout$Alignment.ALIGN_OPPOSITE;
                        } else if (i3 != 2) {
                            if (i3 != 3) {
                                throw new IllegalArgumentException(b.d.b.a.a.g(43, "Unexpected justification value: ", d_b.w));
                            }
                            layout$Alignment = Layout$Alignment.ALIGN_NORMAL;
                        } else {
                            layout$Alignment = Layout$Alignment.ALIGN_CENTER;
                        }
                        Layout$Alignment layout$Alignment2 = layout$Alignment;
                        if (d_b.q) {
                            f = d_b.f855s / 99.0f;
                            f2 = d_b.r / 99.0f;
                        } else {
                            f = d_b.f855s / 209.0f;
                            f2 = d_b.r / 74.0f;
                        }
                        float f3 = (f * 0.9f) + 0.05f;
                        float f4 = (f2 * 0.9f) + 0.05f;
                        int i4 = d_b.t;
                        int i5 = i4 / 3;
                        int i6 = i4 % 3;
                        d_a = new d$a(spannableStringBuilder, layout$Alignment2, f4, 0, i5 == 0 ? 0 : i5 == 1 ? 1 : 2, f3, i6 == 0 ? 0 : i6 == 1 ? 1 : 2, -3.4028235E38f, d_b.f858z != d$b.f854b, d_b.f858z, d_b.p);
                    }
                    if (d_a != null) {
                        arrayList.add(d_a);
                    }
                } else {
                    continue;
                }
            }
        }
        Collections.sort(arrayList, a.j);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            arrayList2.add(((d$a) arrayList.get(i7)).a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public final void l() {
        for (int i = 0; i < 8; i++) {
            this.k[i].f();
        }
    }
}

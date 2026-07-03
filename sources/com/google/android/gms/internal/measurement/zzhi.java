package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.objectweb.asm.Opcodes;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3733l3;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3837t3;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3850u3;
import p007b.p225i.p226a.p288f.p313h.p325l.C3638e4;
import p007b.p225i.p226a.p288f.p313h.p325l.C3666g4;
import p007b.p225i.p226a.p288f.p313h.p325l.C3681h5;
import p007b.p225i.p226a.p288f.p313h.p325l.C3711j7;
import p007b.p225i.p226a.p288f.p313h.p325l.C3724k7;
import p007b.p225i.p226a.p288f.p313h.p325l.C3776o7;
import p007b.p225i.p226a.p288f.p313h.p325l.C3798q3;
import p007b.p225i.p226a.p288f.p313h.p325l.C3877w4;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3612c6;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3801q6;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhi extends AbstractC3850u3 {

    /* JADX INFO: renamed from: a */
    public static final Logger f20628a = Logger.getLogger(zzhi.class.getName());

    /* JADX INFO: renamed from: b */
    public static final boolean f20629b = C3711j7.f10038g;

    /* JADX INFO: renamed from: c */
    public C3666g4 f20630c;

    /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzhi$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static class C10804a extends zzhi {

        /* JADX INFO: renamed from: d */
        public final byte[] f20631d;

        /* JADX INFO: renamed from: e */
        public final int f20632e;

        /* JADX INFO: renamed from: f */
        public int f20633f;

        public C10804a(byte[] bArr, int i) {
            super(null);
            if ((i | 0 | (bArr.length - i)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i)));
            }
            this.f20631d = bArr;
            this.f20633f = 0;
            this.f20632e = i;
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        /* JADX INFO: renamed from: A */
        public final void mo9080A(long j) throws IOException {
            try {
                byte[] bArr = this.f20631d;
                int i = this.f20633f;
                int i2 = i + 1;
                this.f20633f = i2;
                bArr[i] = (byte) j;
                int i3 = i2 + 1;
                this.f20633f = i3;
                bArr[i2] = (byte) (j >> 8);
                int i4 = i3 + 1;
                this.f20633f = i4;
                bArr[i3] = (byte) (j >> 16);
                int i5 = i4 + 1;
                this.f20633f = i5;
                bArr[i4] = (byte) (j >> 24);
                int i6 = i5 + 1;
                this.f20633f = i6;
                bArr[i5] = (byte) (j >> 32);
                int i7 = i6 + 1;
                this.f20633f = i7;
                bArr[i6] = (byte) (j >> 40);
                int i8 = i7 + 1;
                this.f20633f = i8;
                bArr[i7] = (byte) (j >> 48);
                this.f20633f = i8 + 1;
                bArr[i8] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f20633f), Integer.valueOf(this.f20632e), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        /* JADX INFO: renamed from: C */
        public final void mo9081C(int i) throws IOException {
            try {
                byte[] bArr = this.f20631d;
                int i2 = this.f20633f;
                int i3 = i2 + 1;
                this.f20633f = i3;
                bArr[i2] = (byte) i;
                int i4 = i3 + 1;
                this.f20633f = i4;
                bArr[i3] = (byte) (i >> 8);
                int i5 = i4 + 1;
                this.f20633f = i5;
                bArr[i4] = (byte) (i >> 16);
                this.f20633f = i5 + 1;
                bArr[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f20633f), Integer.valueOf(this.f20632e), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        /* JADX INFO: renamed from: G */
        public final void mo9082G(int i, int i2) throws IOException {
            mo9094r((i << 3) | 5);
            mo9081C(i2);
        }

        /* JADX INFO: renamed from: W */
        public final void m9099W(AbstractC3837t3 abstractC3837t3) throws IOException {
            mo9094r(abstractC3837t3.mo5282d());
            abstractC3837t3.mo5286j(this);
        }

        /* JADX INFO: renamed from: X */
        public final void m9100X(InterfaceC3612c6 interfaceC3612c6) throws IOException {
            mo9094r(interfaceC3612c6.mo4606g());
            interfaceC3612c6.mo4608i(this);
        }

        /* JADX INFO: renamed from: Y */
        public final void m9101Y(String str) throws IOException {
            int i = this.f20633f;
            try {
                int iM9059L = zzhi.m9059L(str.length() * 3);
                int iM9059L2 = zzhi.m9059L(str.length());
                if (iM9059L2 != iM9059L) {
                    mo9094r(C3724k7.m5021a(str));
                    this.f20633f = C3724k7.f10058a.mo5056b(str, this.f20631d, this.f20633f, mo9083a());
                    return;
                }
                int i2 = i + iM9059L2;
                this.f20633f = i2;
                int iMo5056b = C3724k7.f10058a.mo5056b(str, this.f20631d, i2, mo9083a());
                this.f20633f = i;
                mo9094r((iMo5056b - i) - iM9059L2);
                this.f20633f = iMo5056b;
            } catch (C3776o7 e) {
                this.f20633f = i;
                zzhi.f20628a.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e);
                byte[] bytes = str.getBytes(C3877w4.f10379a);
                try {
                    mo9094r(bytes.length);
                    m9102Z(bytes, 0, bytes.length);
                } catch (zza e2) {
                    throw e2;
                } catch (IndexOutOfBoundsException e3) {
                    throw new zza(e3);
                }
            } catch (IndexOutOfBoundsException e4) {
                throw new zza(e4);
            }
        }

        /* JADX INFO: renamed from: Z */
        public final void m9102Z(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.f20631d, this.f20633f, i2);
                this.f20633f += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f20633f), Integer.valueOf(this.f20632e), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        /* JADX INFO: renamed from: a */
        public final int mo9083a() {
            return this.f20632e - this.f20633f;
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        /* JADX INFO: renamed from: d */
        public final void mo9084d(byte b2) throws IOException {
            try {
                byte[] bArr = this.f20631d;
                int i = this.f20633f;
                this.f20633f = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f20633f), Integer.valueOf(this.f20632e), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        /* JADX INFO: renamed from: e */
        public final void mo9085e(int i) throws IOException {
            if (i >= 0) {
                mo9094r(i);
            } else {
                mo9093m(i);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        /* JADX INFO: renamed from: f */
        public final void mo9086f(int i, int i2) throws IOException {
            mo9094r((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        /* JADX INFO: renamed from: g */
        public final void mo9087g(int i, long j) throws IOException {
            mo9094r((i << 3) | 0);
            mo9093m(j);
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        /* JADX INFO: renamed from: h */
        public final void mo9088h(int i, AbstractC3837t3 abstractC3837t3) throws IOException {
            mo9094r((i << 3) | 2);
            m9099W(abstractC3837t3);
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        /* JADX INFO: renamed from: i */
        public final void mo9089i(int i, InterfaceC3612c6 interfaceC3612c6) throws IOException {
            mo9086f(1, 3);
            mo9097y(2, i);
            mo9086f(3, 2);
            m9100X(interfaceC3612c6);
            mo9086f(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        /* JADX INFO: renamed from: j */
        public final void mo9090j(int i, InterfaceC3612c6 interfaceC3612c6, InterfaceC3801q6 interfaceC3801q6) throws IOException {
            mo9094r((i << 3) | 2);
            AbstractC3733l3 abstractC3733l3 = (AbstractC3733l3) interfaceC3612c6;
            int iMo5053e = abstractC3733l3.mo5053e();
            if (iMo5053e == -1) {
                iMo5053e = interfaceC3801q6.mo4847e(abstractC3733l3);
                abstractC3733l3.mo5054l(iMo5053e);
            }
            mo9094r(iMo5053e);
            interfaceC3801q6.mo4849g(interfaceC3612c6, this.f20630c);
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        /* JADX INFO: renamed from: k */
        public final void mo9091k(int i, String str) throws IOException {
            mo9094r((i << 3) | 2);
            m9101Y(str);
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        /* JADX INFO: renamed from: l */
        public final void mo9092l(int i, boolean z2) throws IOException {
            mo9094r((i << 3) | 0);
            mo9084d(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        /* JADX INFO: renamed from: m */
        public final void mo9093m(long j) throws IOException {
            if (zzhi.f20629b && mo9083a() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.f20631d;
                    int i = this.f20633f;
                    this.f20633f = i + 1;
                    C3711j7.m4982g(bArr, i, (byte) ((((int) j) & Opcodes.LAND) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.f20631d;
                int i2 = this.f20633f;
                this.f20633f = i2 + 1;
                C3711j7.m4982g(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f20631d;
                    int i3 = this.f20633f;
                    this.f20633f = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j) & Opcodes.LAND) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f20633f), Integer.valueOf(this.f20632e), 1), e);
                }
            }
            byte[] bArr4 = this.f20631d;
            int i4 = this.f20633f;
            this.f20633f = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        /* JADX INFO: renamed from: r */
        public final void mo9094r(int i) throws IOException {
            if (!zzhi.f20629b || C3798q3.m5185a() || mo9083a() < 5) {
                while ((i & (-128)) != 0) {
                    try {
                        byte[] bArr = this.f20631d;
                        int i2 = this.f20633f;
                        this.f20633f = i2 + 1;
                        bArr[i2] = (byte) ((i & Opcodes.LAND) | 128);
                        i >>>= 7;
                    } catch (IndexOutOfBoundsException e) {
                        throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f20633f), Integer.valueOf(this.f20632e), 1), e);
                    }
                }
                byte[] bArr2 = this.f20631d;
                int i3 = this.f20633f;
                this.f20633f = i3 + 1;
                bArr2[i3] = (byte) i;
                return;
            }
            if ((i & (-128)) == 0) {
                byte[] bArr3 = this.f20631d;
                int i4 = this.f20633f;
                this.f20633f = i4 + 1;
                C3711j7.m4982g(bArr3, i4, (byte) i);
                return;
            }
            byte[] bArr4 = this.f20631d;
            int i5 = this.f20633f;
            this.f20633f = i5 + 1;
            C3711j7.m4982g(bArr4, i5, (byte) (i | 128));
            int i6 = i >>> 7;
            if ((i6 & (-128)) == 0) {
                byte[] bArr5 = this.f20631d;
                int i7 = this.f20633f;
                this.f20633f = i7 + 1;
                C3711j7.m4982g(bArr5, i7, (byte) i6);
                return;
            }
            byte[] bArr6 = this.f20631d;
            int i8 = this.f20633f;
            this.f20633f = i8 + 1;
            C3711j7.m4982g(bArr6, i8, (byte) (i6 | 128));
            int i9 = i6 >>> 7;
            if ((i9 & (-128)) == 0) {
                byte[] bArr7 = this.f20631d;
                int i10 = this.f20633f;
                this.f20633f = i10 + 1;
                C3711j7.m4982g(bArr7, i10, (byte) i9);
                return;
            }
            byte[] bArr8 = this.f20631d;
            int i11 = this.f20633f;
            this.f20633f = i11 + 1;
            C3711j7.m4982g(bArr8, i11, (byte) (i9 | 128));
            int i12 = i9 >>> 7;
            if ((i12 & (-128)) == 0) {
                byte[] bArr9 = this.f20631d;
                int i13 = this.f20633f;
                this.f20633f = i13 + 1;
                C3711j7.m4982g(bArr9, i13, (byte) i12);
                return;
            }
            byte[] bArr10 = this.f20631d;
            int i14 = this.f20633f;
            this.f20633f = i14 + 1;
            C3711j7.m4982g(bArr10, i14, (byte) (i12 | 128));
            byte[] bArr11 = this.f20631d;
            int i15 = this.f20633f;
            this.f20633f = i15 + 1;
            C3711j7.m4982g(bArr11, i15, (byte) (i12 >>> 7));
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        /* JADX INFO: renamed from: s */
        public final void mo9095s(int i, int i2) throws IOException {
            mo9094r((i << 3) | 0);
            if (i2 >= 0) {
                mo9094r(i2);
            } else {
                mo9093m(i2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        /* JADX INFO: renamed from: t */
        public final void mo9096t(int i, AbstractC3837t3 abstractC3837t3) throws IOException {
            mo9086f(1, 3);
            mo9097y(2, i);
            mo9088h(3, abstractC3837t3);
            mo9086f(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        /* JADX INFO: renamed from: y */
        public final void mo9097y(int i, int i2) throws IOException {
            mo9094r((i << 3) | 0);
            mo9094r(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzhi
        /* JADX INFO: renamed from: z */
        public final void mo9098z(int i, long j) throws IOException {
            mo9094r((i << 3) | 1);
            mo9080A(j);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static class zza extends IOException {
        public zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        public zza(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public zza(String str, Throwable th) {
            String strValueOf = String.valueOf(str);
            super(strValueOf.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(strValueOf) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "), th);
        }
    }

    public zzhi() {
    }

    /* JADX INFO: renamed from: B */
    public static int m9051B(int i, long j) {
        return m9054F(j) + m9059L(i << 3);
    }

    /* JADX INFO: renamed from: D */
    public static int m9052D(int i) {
        return m9059L(i << 3);
    }

    /* JADX INFO: renamed from: E */
    public static int m9053E(int i, long j) {
        return m9054F(j) + m9059L(i << 3);
    }

    /* JADX INFO: renamed from: F */
    public static int m9054F(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    /* JADX INFO: renamed from: H */
    public static int m9055H(int i) {
        if (i >= 0) {
            return m9059L(i);
        }
        return 10;
    }

    /* JADX INFO: renamed from: I */
    public static int m9056I(int i, int i2) {
        return m9055H(i2) + m9059L(i << 3);
    }

    /* JADX INFO: renamed from: J */
    public static int m9057J(int i, long j) {
        return m9054F(m9065R(j)) + m9059L(i << 3);
    }

    /* JADX INFO: renamed from: K */
    public static int m9058K(long j) {
        return m9054F(m9065R(j));
    }

    /* JADX INFO: renamed from: L */
    public static int m9059L(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    /* JADX INFO: renamed from: M */
    public static int m9060M(int i, int i2) {
        return m9059L(i2) + m9059L(i << 3);
    }

    /* JADX INFO: renamed from: N */
    public static int m9061N(int i) {
        return m9059L(i << 3) + 8;
    }

    /* JADX INFO: renamed from: O */
    public static int m9062O(int i) {
        return m9059L(m9069V(i));
    }

    /* JADX INFO: renamed from: P */
    public static int m9063P(int i, int i2) {
        return m9059L(m9069V(i2)) + m9059L(i << 3);
    }

    /* JADX INFO: renamed from: Q */
    public static int m9064Q(int i) {
        return m9059L(i << 3) + 8;
    }

    /* JADX INFO: renamed from: R */
    public static long m9065R(long j) {
        return (j >> 63) ^ (j << 1);
    }

    /* JADX INFO: renamed from: S */
    public static int m9066S(int i) {
        return m9059L(i << 3) + 4;
    }

    /* JADX INFO: renamed from: T */
    public static int m9067T(int i) {
        return m9059L(i << 3) + 4;
    }

    /* JADX INFO: renamed from: U */
    public static int m9068U(int i, int i2) {
        return m9055H(i2) + m9059L(i << 3);
    }

    /* JADX INFO: renamed from: V */
    public static int m9069V(int i) {
        return (i >> 31) ^ (i << 1);
    }

    /* JADX INFO: renamed from: b */
    public static int m9070b(C3681h5 c3681h5) {
        int iM4934a = c3681h5.m4934a();
        return m9059L(iM4934a) + iM4934a;
    }

    /* JADX INFO: renamed from: c */
    public static int m9071c(InterfaceC3612c6 interfaceC3612c6, InterfaceC3801q6 interfaceC3801q6) {
        AbstractC3733l3 abstractC3733l3 = (AbstractC3733l3) interfaceC3612c6;
        int iMo5053e = abstractC3733l3.mo5053e();
        if (iMo5053e == -1) {
            iMo5053e = interfaceC3801q6.mo4847e(abstractC3733l3);
            abstractC3733l3.mo5054l(iMo5053e);
        }
        return m9059L(iMo5053e) + iMo5053e;
    }

    /* JADX INFO: renamed from: n */
    public static int m9072n(int i) {
        return m9059L(i << 3) + 4;
    }

    /* JADX INFO: renamed from: o */
    public static int m9073o(int i, String str) {
        return m9075q(str) + m9059L(i << 3);
    }

    /* JADX INFO: renamed from: p */
    public static int m9074p(AbstractC3837t3 abstractC3837t3) {
        int iMo5282d = abstractC3837t3.mo5282d();
        return m9059L(iMo5282d) + iMo5282d;
    }

    /* JADX INFO: renamed from: q */
    public static int m9075q(String str) {
        int length;
        try {
            length = C3724k7.m5021a(str);
        } catch (C3776o7 unused) {
            length = str.getBytes(C3877w4.f10379a).length;
        }
        return m9059L(length) + length;
    }

    /* JADX INFO: renamed from: u */
    public static int m9076u(int i) {
        return m9059L(i << 3) + 8;
    }

    /* JADX INFO: renamed from: v */
    public static int m9077v(int i) {
        return m9059L(i << 3) + 1;
    }

    /* JADX INFO: renamed from: w */
    public static int m9078w(int i, AbstractC3837t3 abstractC3837t3) {
        int iM9059L = m9059L(i << 3);
        int iMo5282d = abstractC3837t3.mo5282d();
        return m9059L(iMo5282d) + iMo5282d + iM9059L;
    }

    @Deprecated
    /* JADX INFO: renamed from: x */
    public static int m9079x(int i, InterfaceC3612c6 interfaceC3612c6, InterfaceC3801q6 interfaceC3801q6) {
        int iM9059L = m9059L(i << 3) << 1;
        AbstractC3733l3 abstractC3733l3 = (AbstractC3733l3) interfaceC3612c6;
        int iMo5053e = abstractC3733l3.mo5053e();
        if (iMo5053e == -1) {
            iMo5053e = interfaceC3801q6.mo4847e(abstractC3733l3);
            abstractC3733l3.mo5054l(iMo5053e);
        }
        return iM9059L + iMo5053e;
    }

    /* JADX INFO: renamed from: A */
    public abstract void mo9080A(long j) throws IOException;

    /* JADX INFO: renamed from: C */
    public abstract void mo9081C(int i) throws IOException;

    /* JADX INFO: renamed from: G */
    public abstract void mo9082G(int i, int i2) throws IOException;

    /* JADX INFO: renamed from: a */
    public abstract int mo9083a();

    /* JADX INFO: renamed from: d */
    public abstract void mo9084d(byte b2) throws IOException;

    /* JADX INFO: renamed from: e */
    public abstract void mo9085e(int i) throws IOException;

    /* JADX INFO: renamed from: f */
    public abstract void mo9086f(int i, int i2) throws IOException;

    /* JADX INFO: renamed from: g */
    public abstract void mo9087g(int i, long j) throws IOException;

    /* JADX INFO: renamed from: h */
    public abstract void mo9088h(int i, AbstractC3837t3 abstractC3837t3) throws IOException;

    /* JADX INFO: renamed from: i */
    public abstract void mo9089i(int i, InterfaceC3612c6 interfaceC3612c6) throws IOException;

    /* JADX INFO: renamed from: j */
    public abstract void mo9090j(int i, InterfaceC3612c6 interfaceC3612c6, InterfaceC3801q6 interfaceC3801q6) throws IOException;

    /* JADX INFO: renamed from: k */
    public abstract void mo9091k(int i, String str) throws IOException;

    /* JADX INFO: renamed from: l */
    public abstract void mo9092l(int i, boolean z2) throws IOException;

    /* JADX INFO: renamed from: m */
    public abstract void mo9093m(long j) throws IOException;

    /* JADX INFO: renamed from: r */
    public abstract void mo9094r(int i) throws IOException;

    /* JADX INFO: renamed from: s */
    public abstract void mo9095s(int i, int i2) throws IOException;

    /* JADX INFO: renamed from: t */
    public abstract void mo9096t(int i, AbstractC3837t3 abstractC3837t3) throws IOException;

    /* JADX INFO: renamed from: y */
    public abstract void mo9097y(int i, int i2) throws IOException;

    /* JADX INFO: renamed from: z */
    public abstract void mo9098z(int i, long j) throws IOException;

    public zzhi(C3638e4 c3638e4) {
    }
}

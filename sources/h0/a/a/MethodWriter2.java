package h0.a.a;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.MentionUtils;
import h0.a.a.SymbolTable2;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: h0.a.a.r, reason: use source file name */
/* JADX INFO: compiled from: MethodWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MethodWriter2 extends MethodVisitor2 {
    public static final int[] c = {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 0, 0, 1, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, -4, -3, -4, -3, -3, -3, -3, -1, -2, 1, 1, 1, 2, 2, 2, 0, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -2, -1, -2, -1, -2, 0, 1, 0, 1, -1, -1, 0, 0, 1, 1, -1, 0, -1, 0, 0, 0, -3, -1, -1, -3, -3, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2, -2, -2, 0, 1, 0, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, -1, -1, 0, 0};
    public final int A;
    public AnnotationWriter2 B;
    public AnnotationWriter2 C;
    public int D;
    public AnnotationWriter2[] E;
    public int F;
    public AnnotationWriter2[] G;
    public AnnotationWriter2 H;
    public AnnotationWriter2 I;
    public ByteVector2 J;
    public int K;
    public ByteVector2 L;
    public Attribute2 M;
    public final int N;
    public Label2 O;
    public Label2 P;
    public Label2 Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int[] V;
    public int[] W;
    public boolean X;
    public boolean Y;
    public int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f3716a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f3717b0;
    public final SymbolTable2 d;
    public final int e;
    public final int f;
    public final String g;
    public final int h;
    public final String i;
    public int j;
    public int k;
    public final ByteVector2 l;
    public Handler5 m;
    public Handler5 n;
    public int o;
    public ByteVector2 p;
    public int q;
    public ByteVector2 r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3718s;
    public ByteVector2 t;
    public int u;
    public ByteVector2 v;
    public AnnotationWriter2 w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public AnnotationWriter2 f3719x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f3720y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int[] f3721z;

    public MethodWriter2(SymbolTable2 symbolTable2, int i, String str, String str2, String str3, String[] strArr, int i2) {
        super(Opcodes.ASM7);
        this.l = new ByteVector2();
        this.d = symbolTable2;
        this.e = "<init>".equals(str) ? 262144 | i : i;
        this.f = symbolTable2.l(str);
        this.g = str;
        this.h = symbolTable2.l(str2);
        this.i = str2;
        this.A = str3 == null ? 0 : symbolTable2.l(str3);
        if (strArr == null || strArr.length <= 0) {
            this.f3720y = 0;
            this.f3721z = null;
        } else {
            int length = strArr.length;
            this.f3720y = length;
            this.f3721z = new int[length];
            for (int i3 = 0; i3 < this.f3720y; i3++) {
                this.f3721z[i3] = symbolTable2.c(strArr[i3]).a;
            }
        }
        this.N = i2;
        if (i2 != 0) {
            int iB = Type2.b(str2) >> 2;
            iB = (i & 8) != 0 ? iB - 1 : iB;
            this.k = iB;
            this.T = iB;
            Label2 label2 = new Label2();
            this.O = label2;
            i(label2);
        }
    }

    public int A(int i, int i2, int i3) {
        int i4 = i2 + 3 + i3;
        int[] iArr = this.W;
        if (iArr == null || iArr.length < i4) {
            this.W = new int[i4];
        }
        int[] iArr2 = this.W;
        iArr2[0] = i;
        iArr2[1] = i2;
        iArr2[2] = i3;
        return 3;
    }

    public final void B(Label2 label2, Label2[] label2Arr) {
        Label2 label3 = this.Q;
        if (label3 != null) {
            int i = this.N;
            if (i == 4) {
                label3.k.b(Opcodes.LOOKUPSWITCH, 0, null, null);
                u(0, label2);
                Label2 label2B = label2.b();
                label2B.f3714b = (short) (label2B.f3714b | 2);
                for (Label2 label4 : label2Arr) {
                    u(0, label4);
                    Label2 label2B2 = label4.b();
                    label2B2.f3714b = (short) (label2B2.f3714b | 2);
                }
            } else if (i == 1) {
                int i2 = this.R - 1;
                this.R = i2;
                u(i2, label2);
                for (Label2 label5 : label2Arr) {
                    u(this.R, label5);
                }
            }
            v();
        }
    }

    @Override // h0.a.a.MethodVisitor2
    public AnnotationWriter2 a(String str, boolean z2) {
        ByteVector2 byteVector2 = new ByteVector2();
        byteVector2.j(this.d.l(str));
        byteVector2.j(0);
        if (z2) {
            AnnotationWriter2 annotationWriter2 = new AnnotationWriter2(this.d, true, byteVector2, this.B);
            this.B = annotationWriter2;
            return annotationWriter2;
        }
        AnnotationWriter2 annotationWriter3 = new AnnotationWriter2(this.d, true, byteVector2, this.C);
        this.C = annotationWriter3;
        return annotationWriter3;
    }

    @Override // h0.a.a.MethodVisitor2
    public void b(int i, String str, String str2, String str3) {
        int i2;
        int i3;
        this.Z = this.l.f3699b;
        SymbolTable2.a aVarH = this.d.h(9, str, str2, str3);
        this.l.e(i, aVarH.a);
        Label2 label2 = this.Q;
        if (label2 != null) {
            int i4 = this.N;
            if (i4 == 4 || i4 == 3) {
                label2.k.b(i, 0, aVarH, this.d);
                return;
            }
            char cCharAt = str3.charAt(0);
            int i5 = -2;
            switch (i) {
                case Opcodes.GETSTATIC /* 178 */:
                    i2 = this.R + ((cCharAt == 'D' || cCharAt == 'J') ? 2 : 1);
                    break;
                case Opcodes.PUTSTATIC /* 179 */:
                    i3 = this.R;
                    if (cCharAt != 'D' && cCharAt != 'J') {
                        i5 = -1;
                    }
                    i2 = i3 + i5;
                    break;
                case 180:
                    i2 = this.R + ((cCharAt == 'D' || cCharAt == 'J') ? 1 : 0);
                    break;
                default:
                    i3 = this.R;
                    if (cCharAt == 'D' || cCharAt == 'J') {
                        i5 = -3;
                    }
                    i2 = i3 + i5;
                    break;
            }
            if (i2 > this.S) {
                this.S = i2;
            }
            this.R = i2;
        }
    }

    @Override // h0.a.a.MethodVisitor2
    public void c(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        int i4;
        int i5 = this.N;
        if (i5 == 4) {
            return;
        }
        int i6 = 3;
        if (i5 == 3) {
            Label2 label2 = this.Q;
            Frame3 frame3 = label2.k;
            if (frame3 == null) {
                CurrentFrame2 currentFrame2 = new CurrentFrame2(label2);
                label2.k = currentFrame2;
                currentFrame2.n(this.d, this.e, this.i, i2);
                this.Q.k.a(this);
            } else {
                if (i == -1) {
                    SymbolTable2 symbolTable2 = this.d;
                    int i7 = 0;
                    for (int i8 = 0; i8 < i2; i8++) {
                        int i9 = i7 + 1;
                        frame3.f3711b[i7] = Frame3.c(symbolTable2, objArr[i8]);
                        if (objArr[i8] == Opcodes2.e || objArr[i8] == Opcodes2.d) {
                            frame3.f3711b[i9] = 16777216;
                            i7 = i9 + 1;
                        } else {
                            i7 = i9;
                        }
                    }
                    while (true) {
                        int[] iArr = frame3.f3711b;
                        if (i7 >= iArr.length) {
                            break;
                        }
                        iArr[i7] = 16777216;
                        i7++;
                    }
                    int i10 = 0;
                    for (int i11 = 0; i11 < i3; i11++) {
                        if (objArr2[i11] == Opcodes2.e || objArr2[i11] == Opcodes2.d) {
                            i10++;
                        }
                    }
                    frame3.c = new int[i10 + i3];
                    int i12 = 0;
                    for (int i13 = 0; i13 < i3; i13++) {
                        int i14 = i12 + 1;
                        frame3.c[i12] = Frame3.c(symbolTable2, objArr2[i13]);
                        if (objArr2[i13] == Opcodes2.e || objArr2[i13] == Opcodes2.d) {
                            frame3.c[i14] = 16777216;
                            i12 = i14 + 1;
                        } else {
                            i12 = i14;
                        }
                    }
                    frame3.g = (short) 0;
                    frame3.h = 0;
                }
                this.Q.k.a(this);
            }
        } else if (i == -1) {
            if (this.V == null) {
                int iB = Type2.b(this.i) >> 2;
                Frame3 frame4 = new Frame3(new Label2());
                frame4.n(this.d, this.e, this.i, iB);
                frame4.a(this);
            }
            this.T = i2;
            A(this.l.f3699b, i2, i3);
            int i15 = 0;
            while (i15 < i2) {
                this.W[i6] = Frame3.c(this.d, objArr[i15]);
                i15++;
                i6++;
            }
            int i16 = 0;
            while (i16 < i3) {
                this.W[i6] = Frame3.c(this.d, objArr2[i16]);
                i16++;
                i6++;
            }
            z();
        } else {
            if (this.v == null) {
                this.v = new ByteVector2();
                i4 = this.l.f3699b;
            } else {
                i4 = (this.l.f3699b - this.U) - 1;
                if (i4 < 0) {
                    if (i != 3) {
                        throw new IllegalStateException();
                    }
                    return;
                }
            }
            if (i == 0) {
                this.T = i2;
                ByteVector2 byteVector2 = this.v;
                byteVector2.g(255);
                byteVector2.j(i4);
                byteVector2.j(i2);
                for (int i17 = 0; i17 < i2; i17++) {
                    x(objArr[i17]);
                }
                this.v.j(i3);
                for (int i18 = 0; i18 < i3; i18++) {
                    x(objArr2[i18]);
                }
            } else if (i == 1) {
                this.T += i2;
                ByteVector2 byteVector3 = this.v;
                byteVector3.g(i2 + 251);
                byteVector3.j(i4);
                for (int i19 = 0; i19 < i2; i19++) {
                    x(objArr[i19]);
                }
            } else if (i == 2) {
                this.T -= i2;
                ByteVector2 byteVector4 = this.v;
                byteVector4.g(251 - i2);
                byteVector4.j(i4);
            } else if (i != 3) {
                if (i != 4) {
                    throw new IllegalArgumentException();
                }
                if (i4 < 64) {
                    this.v.g(i4 + 64);
                } else {
                    ByteVector2 byteVector5 = this.v;
                    byteVector5.g(247);
                    byteVector5.j(i4);
                }
                x(objArr2[0]);
            } else if (i4 < 64) {
                this.v.g(i4);
            } else {
                ByteVector2 byteVector6 = this.v;
                byteVector6.g(251);
                byteVector6.j(i4);
            }
            this.U = this.l.f3699b;
            this.u++;
        }
        if (this.N == 2) {
            this.R = i3;
            for (int i20 = 0; i20 < i3; i20++) {
                if (objArr2[i20] == Opcodes2.e || objArr2[i20] == Opcodes2.d) {
                    this.R++;
                }
            }
            int i21 = this.R;
            if (i21 > this.S) {
                this.S = i21;
            }
        }
        this.j = Math.max(this.j, i3);
        this.k = Math.max(this.k, this.T);
    }

    @Override // h0.a.a.MethodVisitor2
    public void d(int i, int i2) {
        int i3;
        int i4;
        ByteVector2 byteVector2 = this.l;
        this.Z = byteVector2.f3699b;
        if (i > 255 || i2 > 127 || i2 < -128) {
            byteVector2.g(196);
            byteVector2.e(Opcodes.IINC, i);
            byteVector2.j(i2);
        } else {
            byteVector2.g(Opcodes.IINC);
            byteVector2.c(i, i2);
        }
        Label2 label2 = this.Q;
        if (label2 != null && ((i4 = this.N) == 4 || i4 == 3)) {
            label2.k.b(Opcodes.IINC, i, null, null);
        }
        if (this.N == 0 || (i3 = i + 1) <= this.k) {
            return;
        }
        this.k = i3;
    }

    @Override // h0.a.a.MethodVisitor2
    public void e(int i) {
        ByteVector2 byteVector2 = this.l;
        this.Z = byteVector2.f3699b;
        byteVector2.g(i);
        Label2 label2 = this.Q;
        if (label2 != null) {
            int i2 = this.N;
            if (i2 == 4 || i2 == 3) {
                label2.k.b(i, 0, null, null);
            } else {
                int i3 = this.R + c[i];
                if (i3 > this.S) {
                    this.S = i3;
                }
                this.R = i3;
            }
            if ((i < 172 || i > 177) && i != 191) {
                return;
            }
            v();
        }
    }

    @Override // h0.a.a.MethodVisitor2
    public AnnotationWriter2 f(int i, TypePath2 typePath2, String str, boolean z2) {
        ByteVector2 byteVector2 = new ByteVector2();
        b.i.a.f.e.o.f.W0((i & (-16776961)) | (this.Z << 8), byteVector2);
        TypePath2.a(typePath2, byteVector2);
        byteVector2.j(this.d.l(str));
        byteVector2.j(0);
        if (z2) {
            AnnotationWriter2 annotationWriter2 = new AnnotationWriter2(this.d, true, byteVector2, this.w);
            this.w = annotationWriter2;
            return annotationWriter2;
        }
        AnnotationWriter2 annotationWriter3 = new AnnotationWriter2(this.d, true, byteVector2, this.f3719x);
        this.f3719x = annotationWriter3;
        return annotationWriter3;
    }

    @Override // h0.a.a.MethodVisitor2
    public void g(int i, int i2) {
        ByteVector2 byteVector2 = this.l;
        this.Z = byteVector2.f3699b;
        if (i == 17) {
            byteVector2.e(i, i2);
        } else {
            byteVector2.c(i, i2);
        }
        Label2 label2 = this.Q;
        if (label2 != null) {
            int i3 = this.N;
            if (i3 == 4 || i3 == 3) {
                label2.k.b(i, i2, null, null);
            } else if (i != 188) {
                int i4 = this.R + 1;
                if (i4 > this.S) {
                    this.S = i4;
                }
                this.R = i4;
            }
        }
    }

    @Override // h0.a.a.MethodVisitor2
    public void h(int i, Label2 label2) {
        boolean z2;
        ByteVector2 byteVector2 = this.l;
        int i2 = byteVector2.f3699b;
        this.Z = i2;
        int i3 = i >= 200 ? i - 33 : i;
        if ((label2.f3714b & 4) == 0 || label2.e - i2 >= -32768) {
            if (i3 != i) {
                byteVector2.g(i);
                ByteVector2 byteVector3 = this.l;
                label2.e(byteVector3, byteVector3.f3699b - 1, true);
            } else {
                byteVector2.g(i3);
                ByteVector2 byteVector4 = this.l;
                label2.e(byteVector4, byteVector4.f3699b - 1, false);
            }
            z2 = false;
        } else {
            if (i3 == 167) {
                byteVector2.g(200);
            } else {
                if (i3 == 168) {
                    byteVector2.g(201);
                } else {
                    byteVector2.g(i3 >= 198 ? i3 ^ 1 : ((i3 + 1) ^ 1) - 1);
                    this.l.j(8);
                    this.l.g(220);
                    this.Y = true;
                    z2 = true;
                }
                ByteVector2 byteVector5 = this.l;
                label2.e(byteVector5, byteVector5.f3699b - 1, true);
            }
            z2 = false;
            ByteVector2 byteVector6 = this.l;
            label2.e(byteVector6, byteVector6.f3699b - 1, true);
        }
        Label2 label3 = this.Q;
        if (label3 != null) {
            int i4 = this.N;
            Label2 label4 = null;
            if (i4 == 4) {
                label3.k.b(i3, 0, null, null);
                Label2 label2B = label2.b();
                label2B.f3714b = (short) (label2B.f3714b | 2);
                u(0, label2);
                if (i3 != 167) {
                    label4 = new Label2();
                }
            } else if (i4 == 3) {
                label3.k.b(i3, 0, null, null);
            } else if (i4 == 2) {
                this.R += c[i3];
            } else if (i3 == 168) {
                short s2 = label2.f3714b;
                if ((s2 & 32) == 0) {
                    label2.f3714b = (short) (s2 | 32);
                    this.X = true;
                }
                label3.f3714b = (short) (label3.f3714b | 16);
                u(this.R + 1, label2);
                label4 = new Label2();
            } else {
                int i5 = this.R + c[i3];
                this.R = i5;
                u(i5, label2);
            }
            if (label4 != null) {
                if (z2) {
                    label4.f3714b = (short) (label4.f3714b | 2);
                }
                i(label4);
            }
            if (i3 == 167) {
                v();
            }
        }
    }

    @Override // h0.a.a.MethodVisitor2
    public void i(Label2 label2) {
        boolean z2 = this.Y;
        ByteVector2 byteVector2 = this.l;
        this.Y = z2 | label2.f(byteVector2.a, byteVector2.f3699b);
        short s2 = label2.f3714b;
        if ((s2 & 1) != 0) {
            return;
        }
        int i = this.N;
        if (i == 4) {
            Label2 label3 = this.Q;
            if (label3 != null) {
                if (label2.e == label3.e) {
                    label3.f3714b = (short) ((s2 & 2) | label3.f3714b);
                    label2.k = label3.k;
                    return;
                }
                u(0, label2);
            }
            Label2 label4 = this.P;
            if (label4 != null) {
                if (label2.e == label4.e) {
                    label4.f3714b = (short) (label4.f3714b | (label2.f3714b & 2));
                    label2.k = label4.k;
                    this.Q = label4;
                    return;
                }
                label4.l = label2;
            }
            this.P = label2;
            this.Q = label2;
            label2.k = new Frame3(label2);
            return;
        }
        if (i == 3) {
            Label2 label5 = this.Q;
            if (label5 == null) {
                this.Q = label2;
                return;
            } else {
                label5.k.a = label2;
                return;
            }
        }
        if (i != 1) {
            if (i == 2 && this.Q == null) {
                this.Q = label2;
                return;
            }
            return;
        }
        Label2 label6 = this.Q;
        if (label6 != null) {
            label6.i = (short) this.S;
            u(this.R, label2);
        }
        this.Q = label2;
        this.R = 0;
        this.S = 0;
        Label2 label7 = this.P;
        if (label7 != null) {
            label7.l = label2;
        }
        this.P = label2;
    }

    @Override // h0.a.a.MethodVisitor2
    public void j(Object obj) {
        char cCharAt;
        this.Z = this.l.f3699b;
        Symbol2 symbol2B = this.d.b(obj);
        int i = symbol2B.a;
        int i2 = symbol2B.f3724b;
        boolean z2 = i2 == 5 || i2 == 6 || (i2 == 17 && ((cCharAt = symbol2B.e.charAt(0)) == 'J' || cCharAt == 'D'));
        if (z2) {
            this.l.e(20, i);
        } else if (i >= 256) {
            this.l.e(19, i);
        } else {
            this.l.c(18, i);
        }
        Label2 label2 = this.Q;
        if (label2 != null) {
            int i3 = this.N;
            if (i3 == 4 || i3 == 3) {
                label2.k.b(18, 0, symbol2B, this.d);
                return;
            }
            int i4 = this.R + (z2 ? 2 : 1);
            if (i4 > this.S) {
                this.S = i4;
            }
            this.R = i4;
        }
    }

    @Override // h0.a.a.MethodVisitor2
    public void k(int i, Label2 label2) {
        if (this.p == null) {
            this.p = new ByteVector2();
        }
        this.o++;
        this.p.j(label2.e);
        this.p.j(i);
    }

    @Override // h0.a.a.MethodVisitor2
    public void l(String str, String str2, String str3, Label2 label2, Label2 label3, int i) {
        if (str3 != null) {
            if (this.t == null) {
                this.t = new ByteVector2();
            }
            this.f3718s++;
            ByteVector2 byteVector2 = this.t;
            byteVector2.j(label2.e);
            byteVector2.j(label3.e - label2.e);
            byteVector2.j(this.d.l(str));
            byteVector2.j(this.d.l(str3));
            byteVector2.j(i);
        }
        if (this.r == null) {
            this.r = new ByteVector2();
        }
        this.q++;
        ByteVector2 byteVector3 = this.r;
        byteVector3.j(label2.e);
        byteVector3.j(label3.e - label2.e);
        byteVector3.j(this.d.l(str));
        byteVector3.j(this.d.l(str2));
        byteVector3.j(i);
        if (this.N != 0) {
            char cCharAt = str2.charAt(0);
            int i2 = i + ((cCharAt == 'J' || cCharAt == 'D') ? 2 : 1);
            if (i2 > this.k) {
                this.k = i2;
            }
        }
    }

    @Override // h0.a.a.MethodVisitor2
    public AnnotationWriter2 m(int i, TypePath2 typePath2, Label2[] label2Arr, Label2[] label2Arr2, int[] iArr, String str, boolean z2) {
        ByteVector2 byteVector2 = new ByteVector2();
        byteVector2.g(i >>> 24);
        byteVector2.j(label2Arr.length);
        for (int i2 = 0; i2 < label2Arr.length; i2++) {
            byteVector2.j(label2Arr[i2].e);
            byteVector2.j(label2Arr2[i2].e - label2Arr[i2].e);
            byteVector2.j(iArr[i2]);
        }
        TypePath2.a(typePath2, byteVector2);
        byteVector2.j(this.d.l(str));
        byteVector2.j(0);
        if (z2) {
            AnnotationWriter2 annotationWriter2 = new AnnotationWriter2(this.d, true, byteVector2, this.w);
            this.w = annotationWriter2;
            return annotationWriter2;
        }
        AnnotationWriter2 annotationWriter3 = new AnnotationWriter2(this.d, true, byteVector2, this.f3719x);
        this.f3719x = annotationWriter3;
        return annotationWriter3;
    }

    @Override // h0.a.a.MethodVisitor2
    public void n(int i, int i2) {
        int i3 = this.N;
        if (i3 == 4) {
            Handler5 handler5 = this.m;
            while (true) {
                if (handler5 == null) {
                    break;
                }
                String str = handler5.e;
                int iN = 33554432 | this.d.n(str != null ? str : "java/lang/Throwable");
                Label2 label2B = handler5.c.b();
                label2B.f3714b = (short) (label2B.f3714b | 2);
                Label2 label2B2 = handler5.f3713b.b();
                for (Label2 label2B3 = handler5.a.b(); label2B3 != label2B2; label2B3 = label2B3.l) {
                    label2B3.m = new Edge2(iN, label2B, label2B3.m);
                }
                handler5 = handler5.f;
            }
            Frame3 frame3 = this.O.k;
            frame3.n(this.d, this.e, this.i, this.k);
            frame3.a(this);
            Label2 label2 = this.O;
            label2.n = Label2.a;
            int iMax = 0;
            while (label2 != Label2.a) {
                Label2 label3 = label2.n;
                label2.n = null;
                label2.f3714b = (short) (label2.f3714b | 8);
                int length = label2.k.c.length + label2.i;
                if (length > iMax) {
                    iMax = length;
                }
                for (Edge2 edge2 = label2.m; edge2 != null; edge2 = edge2.c) {
                    Label2 label2B4 = edge2.f3709b.b();
                    if (label2.k.h(this.d, label2B4.k, edge2.a) && label2B4.n == null) {
                        label2B4.n = label3;
                        label3 = label2B4;
                    }
                }
                label2 = label3;
            }
            for (Label2 label4 = this.O; label4 != null; label4 = label4.l) {
                if ((label4.f3714b & 10) == 10) {
                    label4.k.a(this);
                }
                if ((label4.f3714b & 8) == 0) {
                    Label2 label5 = label4.l;
                    int i4 = label4.e;
                    int i5 = (label5 == null ? this.l.f3699b : label5.e) - 1;
                    if (i5 >= i4) {
                        for (int i6 = i4; i6 < i5; i6++) {
                            this.l.a[i6] = 0;
                        }
                        this.l.a[i5] = -65;
                        A(i4, 0, 1);
                        this.W[3] = this.d.n("java/lang/Throwable") | 33554432;
                        z();
                        this.m = Handler5.a(this.m, label4, label5);
                        iMax = Math.max(iMax, 1);
                    }
                }
            }
            this.j = iMax;
            return;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                this.j = this.S;
                return;
            } else {
                this.j = i;
                this.k = i2;
                return;
            }
        }
        for (Handler5 handler6 = this.m; handler6 != null; handler6 = handler6.f) {
            Label2 label6 = handler6.c;
            Label2 label7 = handler6.f3713b;
            for (Label2 label8 = handler6.a; label8 != label7; label8 = label8.l) {
                if ((label8.f3714b & 16) == 0) {
                    label8.m = new Edge2(Integer.MAX_VALUE, label6, label8.m);
                } else {
                    Edge2 edge3 = label8.m.c;
                    edge3.c = new Edge2(Integer.MAX_VALUE, label6, edge3.c);
                }
            }
        }
        if (this.X) {
            this.O.c((short) 1);
            short s2 = 1;
            for (short s3 = 1; s3 <= s2; s3 = (short) (s3 + 1)) {
                for (Label2 label9 = this.O; label9 != null; label9 = label9.l) {
                    if ((label9.f3714b & 16) != 0 && label9.j == s3) {
                        Label2 label10 = label9.m.c.f3709b;
                        if (label10.j == 0) {
                            s2 = (short) (s2 + 1);
                            label10.c(s2);
                        }
                    }
                }
            }
            for (Label2 label11 = this.O; label11 != null; label11 = label11.l) {
                if ((label11.f3714b & 16) != 0) {
                    Label2 label2D = label11.m.c.f3709b;
                    Label2 label12 = Label2.a;
                    label2D.n = label12;
                    while (label2D != Label2.a) {
                        Label2 label13 = label2D.n;
                        label2D.n = label12;
                        if ((label2D.f3714b & 64) != 0 && label2D.j != label11.j) {
                            label2D.m = new Edge2(label2D.h, label11.m.f3709b, label2D.m);
                        }
                        label12 = label2D;
                        label2D = label2D.d(label13);
                    }
                    while (label12 != Label2.a) {
                        Label2 label14 = label12.n;
                        label12.n = null;
                        label12 = label14;
                    }
                }
            }
        }
        Label2 label15 = this.O;
        label15.n = Label2.a;
        int i7 = this.j;
        while (label15 != Label2.a) {
            Label2 label16 = label15.n;
            short s4 = label15.g;
            int i8 = label15.i + s4;
            if (i8 > i7) {
                i7 = i8;
            }
            Edge2 edge4 = label15.m;
            if ((label15.f3714b & 16) != 0) {
                edge4 = edge4.c;
            }
            label15 = label16;
            while (edge4 != null) {
                Label2 label17 = edge4.f3709b;
                if (label17.n == null) {
                    int i9 = edge4.a;
                    label17.g = (short) (i9 == Integer.MAX_VALUE ? 1 : i9 + s4);
                    label17.n = label15;
                    label15 = label17;
                }
                edge4 = edge4.c;
            }
        }
        this.j = i7;
    }

    @Override // h0.a.a.MethodVisitor2
    public void p(int i, String str, String str2, String str3, boolean z2) {
        this.Z = this.l.f3699b;
        SymbolTable2.a aVarH = this.d.h(z2 ? 11 : 10, str, str2, str3);
        if (i == 185) {
            ByteVector2 byteVector2 = this.l;
            byteVector2.e(Opcodes.INVOKEINTERFACE, aVarH.a);
            byteVector2.c(aVarH.a() >> 2, 0);
        } else {
            this.l.e(i, aVarH.a);
        }
        Label2 label2 = this.Q;
        if (label2 != null) {
            int i2 = this.N;
            if (i2 == 4 || i2 == 3) {
                label2.k.b(i, 0, aVarH, this.d);
                return;
            }
            int iA = aVarH.a();
            int i3 = (iA & 3) - (iA >> 2);
            int i4 = i == 184 ? this.R + i3 + 1 : this.R + i3;
            if (i4 > this.S) {
                this.S = i4;
            }
            this.R = i4;
        }
    }

    @Override // h0.a.a.MethodVisitor2
    public void q(int i, int i2, Label2 label2, Label2... label2Arr) {
        ByteVector2 byteVector2 = this.l;
        this.Z = byteVector2.f3699b;
        byteVector2.g(Opcodes.TABLESWITCH);
        byteVector2.h(null, 0, (4 - (this.l.f3699b % 4)) % 4);
        label2.e(this.l, this.Z, true);
        ByteVector2 byteVector3 = this.l;
        byteVector3.i(i);
        byteVector3.i(i2);
        for (Label2 label3 : label2Arr) {
            label3.e(this.l, this.Z, true);
        }
        B(label2, label2Arr);
    }

    @Override // h0.a.a.MethodVisitor2
    public AnnotationWriter2 r(int i, TypePath2 typePath2, String str, boolean z2) {
        ByteVector2 byteVector2 = new ByteVector2();
        b.i.a.f.e.o.f.W0(i, byteVector2);
        TypePath2.a(typePath2, byteVector2);
        byteVector2.j(this.d.l(str));
        byteVector2.j(0);
        if (z2) {
            AnnotationWriter2 annotationWriter2 = new AnnotationWriter2(this.d, true, byteVector2, this.H);
            this.H = annotationWriter2;
            return annotationWriter2;
        }
        AnnotationWriter2 annotationWriter3 = new AnnotationWriter2(this.d, true, byteVector2, this.I);
        this.I = annotationWriter3;
        return annotationWriter3;
    }

    @Override // h0.a.a.MethodVisitor2
    public void s(int i, String str) {
        this.Z = this.l.f3699b;
        Symbol2 symbol2M = this.d.m(7, str);
        this.l.e(i, symbol2M.a);
        Label2 label2 = this.Q;
        if (label2 != null) {
            int i2 = this.N;
            if (i2 == 4 || i2 == 3) {
                label2.k.b(i, this.Z, symbol2M, this.d);
            } else if (i == 187) {
                int i3 = this.R + 1;
                if (i3 > this.S) {
                    this.S = i3;
                }
                this.R = i3;
            }
        }
    }

    @Override // h0.a.a.MethodVisitor2
    public void t(int i, int i2) {
        ByteVector2 byteVector2 = this.l;
        this.Z = byteVector2.f3699b;
        if (i2 < 4 && i != 169) {
            byteVector2.g((i < 54 ? ((i - 21) << 2) + 26 : ((i - 54) << 2) + 59) + i2);
        } else if (i2 >= 256) {
            byteVector2.g(196);
            byteVector2.e(i, i2);
        } else {
            byteVector2.c(i, i2);
        }
        Label2 label2 = this.Q;
        if (label2 != null) {
            int i3 = this.N;
            if (i3 == 4 || i3 == 3) {
                label2.k.b(i, i2, null, null);
            } else if (i == 169) {
                label2.f3714b = (short) (label2.f3714b | 64);
                label2.h = (short) this.R;
                v();
            } else {
                int i4 = this.R + c[i];
                if (i4 > this.S) {
                    this.S = i4;
                }
                this.R = i4;
            }
        }
        int i5 = this.N;
        if (i5 != 0) {
            int i6 = (i == 22 || i == 24 || i == 55 || i == 57) ? i2 + 2 : i2 + 1;
            if (i6 > this.k) {
                this.k = i6;
            }
        }
        if (i < 54 || i5 != 4 || this.m == null) {
            return;
        }
        i(new Label2());
    }

    public final void u(int i, Label2 label2) {
        Label2 label3 = this.Q;
        label3.m = new Edge2(i, label2, label3.m);
    }

    public final void v() {
        int i = this.N;
        if (i != 4) {
            if (i == 1) {
                this.Q.i = (short) this.S;
                this.Q = null;
                return;
            }
            return;
        }
        Label2 label2 = new Label2();
        label2.k = new Frame3(label2);
        ByteVector2 byteVector2 = this.l;
        label2.f(byteVector2.a, byteVector2.f3699b);
        this.P.l = label2;
        this.P = label2;
        this.Q = null;
    }

    public final void w(int i, int i2) {
        while (i < i2) {
            SymbolTable2 symbolTable2 = this.d;
            int i3 = this.W[i];
            ByteVector2 byteVector2 = this.v;
            int i4 = ((-268435456) & i3) >> 28;
            if (i4 == 0) {
                int i5 = i3 & 1048575;
                int i6 = i3 & 251658240;
                if (i6 == 16777216) {
                    byteVector2.g(i5);
                } else if (i6 == 33554432) {
                    byteVector2.g(7);
                    byteVector2.j(symbolTable2.c(symbolTable2.l[i5].e).a);
                } else {
                    if (i6 != 50331648) {
                        throw new AssertionError();
                    }
                    byteVector2.g(8);
                    byteVector2.j((int) symbolTable2.l[i5].f);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i7 = i4 - 1;
                    if (i4 > 0) {
                        sb.append('[');
                        i4 = i7;
                    } else {
                        if ((i3 & 251658240) == 33554432) {
                            sb.append('L');
                            sb.append(symbolTable2.l[i3 & 1048575].e);
                            sb.append(';');
                        } else {
                            int i8 = i3 & 1048575;
                            if (i8 == 1) {
                                sb.append('I');
                            } else if (i8 == 2) {
                                sb.append('F');
                            } else if (i8 == 3) {
                                sb.append('D');
                            } else if (i8 != 4) {
                                switch (i8) {
                                    case 9:
                                        sb.append('Z');
                                        break;
                                    case 10:
                                        sb.append('B');
                                        break;
                                    case 11:
                                        sb.append('C');
                                        break;
                                    case 12:
                                        sb.append('S');
                                        break;
                                    default:
                                        throw new AssertionError();
                                }
                            } else {
                                sb.append('J');
                            }
                        }
                        byteVector2.g(7);
                        byteVector2.j(symbolTable2.c(sb.toString()).a);
                    }
                }
            }
            i++;
        }
    }

    public final void x(Object obj) {
        if (obj instanceof Integer) {
            this.v.g(((Integer) obj).intValue());
            return;
        }
        if (obj instanceof String) {
            ByteVector2 byteVector2 = this.v;
            byteVector2.g(7);
            byteVector2.j(this.d.c((String) obj).a);
        } else {
            ByteVector2 byteVector3 = this.v;
            byteVector3.g(8);
            byteVector3.j(((Label2) obj).e);
        }
    }

    public void y(ByteVector2 byteVector2) {
        int i;
        boolean z2 = this.d.c < 49;
        byteVector2.j((~(z2 ? 4096 : 0)) & this.e);
        byteVector2.j(this.f);
        byteVector2.j(this.h);
        int i2 = this.f3716a0;
        if (i2 != 0) {
            byteVector2.h(this.d.f3725b.a, i2, this.f3717b0);
            return;
        }
        int iC = this.l.f3699b > 0 ? 1 : 0;
        if (this.f3720y > 0) {
            iC++;
        }
        int i3 = this.e;
        if ((i3 & 4096) != 0 && z2) {
            iC++;
        }
        if (this.A != 0) {
            iC++;
        }
        if ((i3 & 131072) != 0) {
            iC++;
        }
        if (this.B != null) {
            iC++;
        }
        if (this.C != null) {
            iC++;
        }
        if (this.E != null) {
            iC++;
        }
        if (this.G != null) {
            iC++;
        }
        if (this.H != null) {
            iC++;
        }
        if (this.I != null) {
            iC++;
        }
        if (this.J != null) {
            iC++;
        }
        if (this.L != null) {
            iC++;
        }
        Attribute2 attribute2 = this.M;
        if (attribute2 != null) {
            iC += attribute2.c();
        }
        byteVector2.j(iC);
        int i4 = this.l.f3699b;
        if (i4 > 0) {
            int i5 = i4 + 10;
            int i6 = 0;
            for (Handler5 handler5 = this.m; handler5 != null; handler5 = handler5.f) {
                i6++;
            }
            int iA = (i6 * 8) + 2 + i5;
            ByteVector2 byteVector3 = this.v;
            if (byteVector3 != null) {
                iA += byteVector3.f3699b + 8;
                i = 1;
            } else {
                i = 0;
            }
            ByteVector2 byteVector4 = this.p;
            if (byteVector4 != null) {
                iA += byteVector4.f3699b + 8;
                i++;
            }
            ByteVector2 byteVector5 = this.r;
            if (byteVector5 != null) {
                iA += byteVector5.f3699b + 8;
                i++;
            }
            ByteVector2 byteVector6 = this.t;
            if (byteVector6 != null) {
                iA += byteVector6.f3699b + 8;
                i++;
            }
            AnnotationWriter2 annotationWriter2 = this.w;
            if (annotationWriter2 != null) {
                iA += annotationWriter2.a("RuntimeVisibleTypeAnnotations");
                i++;
            }
            AnnotationWriter2 annotationWriter3 = this.f3719x;
            if (annotationWriter3 != null) {
                iA += annotationWriter3.a("RuntimeInvisibleTypeAnnotations");
                i++;
            }
            outline.t0(this.d, "Code", byteVector2, iA);
            byteVector2.j(this.j);
            byteVector2.j(this.k);
            byteVector2.i(this.l.f3699b);
            ByteVector2 byteVector7 = this.l;
            byteVector2.h(byteVector7.a, 0, byteVector7.f3699b);
            Handler5 handler6 = this.m;
            int i7 = 0;
            for (Handler5 handler7 = handler6; handler7 != null; handler7 = handler7.f) {
                i7++;
            }
            byteVector2.j(i7);
            while (handler6 != null) {
                byteVector2.j(handler6.a.e);
                byteVector2.j(handler6.f3713b.e);
                byteVector2.j(handler6.c.e);
                byteVector2.j(handler6.d);
                handler6 = handler6.f;
            }
            byteVector2.j(i);
            if (this.v != null) {
                SymbolTable2 symbolTable2 = this.d;
                byteVector2.j(symbolTable2.l(symbolTable2.c >= 50 ? "StackMapTable" : "StackMap"));
                byteVector2.i(this.v.f3699b + 2);
                byteVector2.j(this.u);
                ByteVector2 byteVector8 = this.v;
                byteVector2.h(byteVector8.a, 0, byteVector8.f3699b);
            }
            if (this.p != null) {
                byteVector2.j(this.d.l("LineNumberTable"));
                byteVector2.i(this.p.f3699b + 2);
                byteVector2.j(this.o);
                ByteVector2 byteVector9 = this.p;
                byteVector2.h(byteVector9.a, 0, byteVector9.f3699b);
            }
            if (this.r != null) {
                byteVector2.j(this.d.l("LocalVariableTable"));
                byteVector2.i(this.r.f3699b + 2);
                byteVector2.j(this.q);
                ByteVector2 byteVector10 = this.r;
                byteVector2.h(byteVector10.a, 0, byteVector10.f3699b);
            }
            if (this.t != null) {
                byteVector2.j(this.d.l("LocalVariableTypeTable"));
                byteVector2.i(this.t.f3699b + 2);
                byteVector2.j(this.f3718s);
                ByteVector2 byteVector11 = this.t;
                byteVector2.h(byteVector11.a, 0, byteVector11.f3699b);
            }
            AnnotationWriter2 annotationWriter4 = this.w;
            if (annotationWriter4 != null) {
                annotationWriter4.c(this.d.l("RuntimeVisibleTypeAnnotations"), byteVector2);
            }
            AnnotationWriter2 annotationWriter5 = this.f3719x;
            if (annotationWriter5 != null) {
                annotationWriter5.c(this.d.l("RuntimeInvisibleTypeAnnotations"), byteVector2);
            }
        }
        if (this.f3720y > 0) {
            byteVector2.j(this.d.l("Exceptions"));
            byteVector2.i((this.f3720y * 2) + 2);
            byteVector2.j(this.f3720y);
            for (int i8 : this.f3721z) {
                byteVector2.j(i8);
            }
        }
        if ((4096 & this.e) != 0 && z2) {
            outline.t0(this.d, "Synthetic", byteVector2, 0);
        }
        if (this.A != 0) {
            outline.t0(this.d, "Signature", byteVector2, 2);
            byteVector2.j(this.A);
        }
        if ((this.e & 131072) != 0) {
            outline.t0(this.d, "Deprecated", byteVector2, 0);
        }
        AnnotationWriter2 annotationWriter6 = this.B;
        if (annotationWriter6 != null) {
            annotationWriter6.c(this.d.l("RuntimeVisibleAnnotations"), byteVector2);
        }
        AnnotationWriter2 annotationWriter7 = this.C;
        if (annotationWriter7 != null) {
            annotationWriter7.c(this.d.l("RuntimeInvisibleAnnotations"), byteVector2);
        }
        if (this.E != null) {
            int iL = this.d.l("RuntimeVisibleParameterAnnotations");
            AnnotationWriter2[] annotationWriter2Arr = this.E;
            int length = this.D;
            if (length == 0) {
                length = annotationWriter2Arr.length;
            }
            AnnotationWriter2.d(iL, annotationWriter2Arr, length, byteVector2);
        }
        if (this.G != null) {
            int iL2 = this.d.l("RuntimeInvisibleParameterAnnotations");
            AnnotationWriter2[] annotationWriter2Arr2 = this.G;
            int length2 = this.F;
            if (length2 == 0) {
                length2 = annotationWriter2Arr2.length;
            }
            AnnotationWriter2.d(iL2, annotationWriter2Arr2, length2, byteVector2);
        }
        AnnotationWriter2 annotationWriter8 = this.H;
        if (annotationWriter8 != null) {
            annotationWriter8.c(this.d.l("RuntimeVisibleTypeAnnotations"), byteVector2);
        }
        AnnotationWriter2 annotationWriter9 = this.I;
        if (annotationWriter9 != null) {
            annotationWriter9.c(this.d.l("RuntimeInvisibleTypeAnnotations"), byteVector2);
        }
        if (this.J != null) {
            byteVector2.j(this.d.l("AnnotationDefault"));
            byteVector2.i(this.J.f3699b);
            ByteVector2 byteVector12 = this.J;
            byteVector2.h(byteVector12.a, 0, byteVector12.f3699b);
        }
        if (this.L != null) {
            byteVector2.j(this.d.l("MethodParameters"));
            byteVector2.i(this.L.f3699b + 1);
            byteVector2.g(this.K);
            ByteVector2 byteVector13 = this.L;
            byteVector2.h(byteVector13.a, 0, byteVector13.f3699b);
        }
        Attribute2 attribute3 = this.M;
        if (attribute3 != null) {
            attribute3.d(this.d, byteVector2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x007a  */
    public void z() {
        char c2;
        int[] iArr = this.V;
        if (iArr != null) {
            if (this.v == null) {
                this.v = new ByteVector2();
            }
            int[] iArr2 = this.W;
            int i = iArr2[1];
            int i2 = iArr2[2];
            if (this.d.c < 50) {
                ByteVector2 byteVector2 = this.v;
                byteVector2.j(iArr2[0]);
                byteVector2.j(i);
                int i3 = i + 3;
                w(3, i3);
                this.v.j(i2);
                w(i3, i2 + i3);
            } else {
                int i4 = this.u == 0 ? iArr2[0] : (iArr2[0] - iArr[0]) - 1;
                int i5 = iArr[1];
                int i6 = i - i5;
                if (i2 == 0) {
                    switch (i6) {
                        case -3:
                        case -2:
                        case -1:
                            c2 = 248;
                            break;
                        case 0:
                            c2 = i4 < 64 ? (char) 0 : (char) 251;
                            break;
                        case 1:
                        case 2:
                        case 3:
                            c2 = 252;
                            break;
                        default:
                            c2 = 255;
                            break;
                    }
                } else if (i6 == 0 && i2 == 1) {
                    c2 = i4 < 63 ? MentionUtils.MENTIONS_CHAR : (char) 247;
                } else {
                    c2 = 255;
                }
                if (c2 != 255) {
                    int i7 = 3;
                    for (int i8 = 0; i8 < i5 && i8 < i; i8++) {
                        if (this.W[i7] != this.V[i7]) {
                            c2 = 255;
                        } else {
                            i7++;
                        }
                    }
                }
                if (c2 == 0) {
                    this.v.g(i4);
                } else if (c2 == '@') {
                    this.v.g(i4 + 64);
                    w(i + 3, i + 4);
                } else if (c2 == 247) {
                    ByteVector2 byteVector3 = this.v;
                    byteVector3.g(247);
                    byteVector3.j(i4);
                    w(i + 3, i + 4);
                } else if (c2 == 248) {
                    ByteVector2 byteVector4 = this.v;
                    byteVector4.g(i6 + 251);
                    byteVector4.j(i4);
                } else if (c2 == 251) {
                    ByteVector2 byteVector5 = this.v;
                    byteVector5.g(251);
                    byteVector5.j(i4);
                } else if (c2 != 252) {
                    ByteVector2 byteVector6 = this.v;
                    byteVector6.g(255);
                    byteVector6.j(i4);
                    byteVector6.j(i);
                    int i9 = i + 3;
                    w(3, i9);
                    this.v.j(i2);
                    w(i9, i2 + i9);
                } else {
                    ByteVector2 byteVector7 = this.v;
                    byteVector7.g(i6 + 251);
                    byteVector7.j(i4);
                    w(i5 + 3, i + 3);
                }
            }
            this.u++;
        }
        this.V = this.W;
        this.W = null;
    }
}

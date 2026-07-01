package b.i.a.c.b3.n;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.i.a.c.b3.Cue;
import b.i.a.c.b3.Subtitle;
import b.i.a.c.b3.SubtitleInputBuffer;
import b.i.a.c.b3.SubtitleOutputBuffer;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.a.c.b3.n.c, reason: use source file name */
/* JADX INFO: compiled from: Cea608Decoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Cea608Decoder extends CeaDecoder {
    public static final int[] g = {11, 1, 3, 12, 14, 5, 7, 9};
    public static final int[] h = {0, 4, 8, 12, 16, 20, 24, 28};
    public static final int[] i = {-1, -16711936, -16776961, -16711681, -65536, InputDeviceCompat.SOURCE_ANY, -65281};
    public static final int[] j = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    public static final int[] k = {Opcodes.FRETURN, Opcodes.ARETURN, Opcodes.ANEWARRAY, Opcodes.ATHROW, 8482, Opcodes.IF_ICMPGE, Opcodes.IF_ICMPGT, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    public static final int[] l = {Opcodes.INSTANCEOF, 201, 211, 218, 220, 252, 8216, Opcodes.IF_ICMPLT, 42, 39, 8212, Opcodes.RET, 8480, 8226, 8220, 8221, Opcodes.CHECKCAST, Opcodes.MONITORENTER, Opcodes.IFNONNULL, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, Opcodes.LOOKUPSWITCH, Opcodes.NEW};
    public static final int[] m = {Opcodes.MONITOREXIT, 227, 205, 204, 236, 210, 242, 213, 245, 123, Opcodes.LUSHR, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, Opcodes.IF_ACMPEQ, Opcodes.IF_ICMPLE, 9474, Opcodes.MULTIANEWARRAY, 229, 216, 248, 9484, 9488, 9492, 9496};
    public static final boolean[] n = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};
    public boolean A;
    public byte B;
    public byte C;
    public boolean E;
    public long F;
    public final int p;
    public final int q;
    public final int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f847s;

    @Nullable
    public List<Cue> v;

    @Nullable
    public List<Cue> w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f848x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f849y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f850z;
    public final ParsableByteArray o = new ParsableByteArray();
    public final ArrayList<a> t = new ArrayList<>();
    public a u = new a(0, 4);
    public int D = 0;

    /* JADX INFO: renamed from: b.i.a.c.b3.n.c$a */
    /* JADX INFO: compiled from: Cea608Decoder.java */
    public static final class a {
        public final List<C0028a> a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<SpannableString> f851b = new ArrayList();
        public final StringBuilder c = new StringBuilder();
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;

        /* JADX INFO: renamed from: b.i.a.c.b3.n.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Cea608Decoder.java */
        public static class C0028a {
            public final int a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f852b;
            public int c;

            public C0028a(int i, boolean z2, int i2) {
                this.a = i;
                this.f852b = z2;
                this.c = i2;
            }
        }

        public a(int i, int i2) {
            f(i);
            this.h = i2;
        }

        public void a(char c) {
            if (this.c.length() < 32) {
                this.c.append(c);
            }
        }

        public void b() {
            int length = this.c.length();
            if (length > 0) {
                this.c.delete(length - 1, length);
                for (int size = this.a.size() - 1; size >= 0; size--) {
                    C0028a c0028a = this.a.get(size);
                    int i = c0028a.c;
                    if (i != length) {
                        return;
                    }
                    c0028a.c = i - 1;
                }
            }
        }

        @Nullable
        public Cue c(int i) {
            int i2;
            float f;
            int i3 = this.e + this.f;
            int i4 = 32 - i3;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i5 = 0; i5 < this.f851b.size(); i5++) {
                SpannableString spannableStringSubSequence = this.f851b.get(i5);
                int i6 = Util2.a;
                if (spannableStringSubSequence.length() > i4) {
                    spannableStringSubSequence = spannableStringSubSequence.subSequence(0, i4);
                }
                spannableStringBuilder.append(spannableStringSubSequence);
                spannableStringBuilder.append('\n');
            }
            SpannableString spannableStringD = d();
            int i7 = Util2.a;
            int length = spannableStringD.length();
            SpannableString spannableStringSubSequence2 = spannableStringD;
            if (length > i4) {
                spannableStringSubSequence2 = spannableStringD.subSequence(0, i4);
            }
            spannableStringBuilder.append((CharSequence) spannableStringSubSequence2);
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length2 = i4 - spannableStringBuilder.length();
            int i8 = i3 - length2;
            if (i != Integer.MIN_VALUE) {
                i2 = i;
            } else if (this.g != 2 || (Math.abs(i8) >= 3 && length2 >= 0)) {
                i2 = (this.g != 2 || i8 <= 0) ? 0 : 2;
            } else {
                i2 = 1;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    i3 = 32 - length2;
                }
                f = ((i3 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f = 0.5f;
            }
            int i9 = this.d;
            if (i9 > 7) {
                i9 = (i9 - 15) - 2;
            } else if (this.g == 1) {
                i9 -= this.h - 1;
            }
            return new Cue(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, null, null, i9, 1, Integer.MIN_VALUE, f, i2, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);
        }

        public final SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c);
            int length = spannableStringBuilder.length();
            int i = 0;
            int i2 = -1;
            int i3 = -1;
            int i4 = 0;
            int i5 = -1;
            boolean z2 = false;
            int i6 = -1;
            while (i < this.a.size()) {
                C0028a c0028a = this.a.get(i);
                boolean z3 = c0028a.f852b;
                int i7 = c0028a.a;
                if (i7 != 8) {
                    boolean z4 = i7 == 7;
                    if (i7 != 7) {
                        i6 = Cea608Decoder.i[i7];
                    }
                    z2 = z4;
                }
                int i8 = c0028a.c;
                i++;
                if (i8 != (i < this.a.size() ? this.a.get(i).c : length)) {
                    if (i2 != -1 && !z3) {
                        spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i8, 33);
                        i2 = -1;
                    } else if (i2 == -1 && z3) {
                        i2 = i8;
                    }
                    if (i3 != -1 && !z2) {
                        spannableStringBuilder.setSpan(new StyleSpan(2), i3, i8, 33);
                        i3 = -1;
                    } else if (i3 == -1 && z2) {
                        i3 = i8;
                    }
                    if (i6 != i5) {
                        if (i5 != -1) {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(i5), i4, i8, 33);
                        }
                        i4 = i8;
                        i5 = i6;
                    }
                }
            }
            if (i2 != -1 && i2 != length) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i2, length, 33);
            }
            if (i3 != -1 && i3 != length) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, length, 33);
            }
            if (i4 != length && i5 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i5), i4, length, 33);
            }
            return new SpannableString(spannableStringBuilder);
        }

        public boolean e() {
            return this.a.isEmpty() && this.f851b.isEmpty() && this.c.length() == 0;
        }

        public void f(int i) {
            this.g = i;
            this.a.clear();
            this.f851b.clear();
            this.c.setLength(0);
            this.d = 15;
            this.e = 0;
            this.f = 0;
        }
    }

    public Cea608Decoder(String str, int i2, long j2) {
        this.f847s = j2 > 0 ? j2 * 1000 : -9223372036854775807L;
        this.p = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i2 == 1) {
            this.r = 0;
            this.q = 0;
        } else if (i2 == 2) {
            this.r = 1;
            this.q = 0;
        } else if (i2 == 3) {
            this.r = 0;
            this.q = 1;
        } else if (i2 != 4) {
            Log.w("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.r = 0;
            this.q = 0;
        } else {
            this.r = 1;
            this.q = 1;
        }
        l(0);
        k();
        this.E = true;
        this.F = -9223372036854775807L;
    }

    @Override // b.i.a.c.b3.n.CeaDecoder
    public Subtitle e() {
        List<Cue> list = this.v;
        this.w = list;
        Objects.requireNonNull(list);
        return new CeaSubtitle(list);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0062  */
    /* JADX WARN: Code duplicated, block: B:42:0x0089  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c3 A[FALL_THROUGH] */
    @Override // b.i.a.c.b3.n.CeaDecoder
    public void f(SubtitleInputBuffer subtitleInputBuffer) {
        boolean z2;
        boolean z3;
        ByteBuffer byteBuffer = subtitleInputBuffer.l;
        Objects.requireNonNull(byteBuffer);
        this.o.C(byteBuffer.array(), byteBuffer.limit());
        boolean z4 = false;
        while (true) {
            int iA = this.o.a();
            int i2 = this.p;
            if (iA < i2) {
                if (z4) {
                    int i3 = this.f848x;
                    if (i3 == 1 || i3 == 3) {
                        this.v = j();
                        this.F = this.e;
                        return;
                    }
                    return;
                }
                return;
            }
            byte bT = i2 == 2 ? (byte) -4 : (byte) this.o.t();
            int iT = this.o.t();
            int iT2 = this.o.t();
            if ((bT & 2) == 0 && (bT & 1) == this.q) {
                byte b2 = (byte) (iT & Opcodes.LAND);
                byte b3 = (byte) (iT2 & Opcodes.LAND);
                if (b2 != 0 || b3 != 0) {
                    boolean z5 = this.f850z;
                    if ((bT & 4) == 4) {
                        boolean[] zArr = n;
                        if (zArr[iT] && zArr[iT2]) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                    }
                    this.f850z = z2;
                    if (z2) {
                        if (!((b2 & 240) == 16)) {
                            this.A = false;
                        } else if (this.A && this.B == b2 && this.C == b3) {
                            this.A = false;
                            z3 = true;
                        } else {
                            this.A = true;
                            this.B = b2;
                            this.C = b3;
                        }
                        z3 = false;
                    } else {
                        this.A = false;
                        z3 = false;
                    }
                    if (!z3) {
                        if (z2) {
                            if (1 <= b2 && b2 <= 15) {
                                this.E = false;
                            } else if ((b2 & 247) == 20) {
                                if (b3 != 32 && b3 != 47) {
                                    switch (b3) {
                                        default:
                                            switch (b3) {
                                                case 42:
                                                case 43:
                                                    this.E = false;
                                                    break;
                                            }
                                        case 37:
                                        case 38:
                                        case 39:
                                            this.E = true;
                                            break;
                                    }
                                } else {
                                    this.E = true;
                                }
                            }
                            if (this.E) {
                                int i4 = b2 & 224;
                                if (i4 == 0) {
                                    this.D = (b2 >> 3) & 1;
                                }
                                if (this.D == this.r) {
                                    if (i4 == 0) {
                                        int i5 = b2 & 247;
                                        if (i5 == 17 && (b3 & 240) == 48) {
                                            this.u.a((char) k[b3 & 15]);
                                        } else {
                                            int i6 = b2 & 246;
                                            if (i6 == 18 && (b3 & 224) == 32) {
                                                this.u.b();
                                                this.u.a((char) ((b2 & 1) == 0 ? l[b3 & 31] : m[b3 & 31]));
                                            } else if (i5 == 17 && (b3 & 240) == 32) {
                                                this.u.a(' ');
                                                boolean z6 = (b3 & 1) == 1;
                                                a aVar = this.u;
                                                aVar.a.add(new a.C0028a((b3 >> 1) & 7, z6, aVar.c.length()));
                                            } else if ((b2 & 240) == 16 && (b3 & 192) == 64) {
                                                int i7 = g[b2 & 7];
                                                if ((b3 & 32) != 0) {
                                                    i7++;
                                                }
                                                a aVar2 = this.u;
                                                if (i7 != aVar2.d) {
                                                    if (this.f848x != 1 && !aVar2.e()) {
                                                        a aVar3 = new a(this.f848x, this.f849y);
                                                        this.u = aVar3;
                                                        this.t.add(aVar3);
                                                    }
                                                    this.u.d = i7;
                                                }
                                                boolean z7 = (b3 & 16) == 16;
                                                boolean z8 = (b3 & 1) == 1;
                                                int i8 = (b3 >> 1) & 7;
                                                a aVar4 = this.u;
                                                aVar4.a.add(new a.C0028a(z7 ? 8 : i8, z8, aVar4.c.length()));
                                                if (z7) {
                                                    this.u.e = h[i8];
                                                }
                                            } else if (i5 == 23 && b3 >= 33 && b3 <= 35) {
                                                this.u.f = b3 - 32;
                                            } else if (i6 == 20 && (b3 & 240) == 32) {
                                                if (b3 == 32) {
                                                    l(2);
                                                } else if (b3 != 41) {
                                                    switch (b3) {
                                                        case 37:
                                                            l(1);
                                                            m(2);
                                                            break;
                                                        case 38:
                                                            l(1);
                                                            m(3);
                                                            break;
                                                        case 39:
                                                            l(1);
                                                            m(4);
                                                            break;
                                                        default:
                                                            int i9 = this.f848x;
                                                            if (i9 != 0) {
                                                                if (b3 != 33) {
                                                                    switch (b3) {
                                                                        case 44:
                                                                            this.v = Collections.emptyList();
                                                                            int i10 = this.f848x;
                                                                            if (i10 == 1 || i10 == 3) {
                                                                                k();
                                                                            }
                                                                            break;
                                                                        case 45:
                                                                            if (i9 == 1 && !this.u.e()) {
                                                                                a aVar5 = this.u;
                                                                                aVar5.f851b.add(aVar5.d());
                                                                                aVar5.c.setLength(0);
                                                                                aVar5.a.clear();
                                                                                int iMin = Math.min(aVar5.h, aVar5.d);
                                                                                while (aVar5.f851b.size() >= iMin) {
                                                                                    aVar5.f851b.remove(0);
                                                                                }
                                                                            }
                                                                            break;
                                                                        case 46:
                                                                            k();
                                                                            break;
                                                                        case 47:
                                                                            this.v = j();
                                                                            k();
                                                                            break;
                                                                    }
                                                                } else {
                                                                    this.u.b();
                                                                    break;
                                                                }
                                                            }
                                                            break;
                                                    }
                                                } else {
                                                    l(3);
                                                }
                                            }
                                        }
                                    } else {
                                        a aVar6 = this.u;
                                        int[] iArr = j;
                                        aVar6.a((char) iArr[(b2 & 127) - 32]);
                                        if ((b3 & 224) != 0) {
                                            this.u.a((char) iArr[(b3 & 127) - 32]);
                                        }
                                    }
                                    z4 = true;
                                }
                            }
                        } else if (z5) {
                            k();
                            z4 = true;
                        }
                    }
                }
            }
        }
    }

    @Override // b.i.a.c.b3.n.CeaDecoder, b.i.a.c.v2.Decoder
    public void flush() {
        super.flush();
        this.v = null;
        this.w = null;
        l(0);
        m(4);
        k();
        this.f850z = false;
        this.A = false;
        this.B = (byte) 0;
        this.C = (byte) 0;
        this.D = 0;
        this.E = true;
        this.F = -9223372036854775807L;
    }

    @Override // b.i.a.c.b3.n.CeaDecoder, b.i.a.c.v2.Decoder
    @Nullable
    /* JADX INFO: renamed from: g */
    public SubtitleOutputBuffer b() throws SubtitleDecoderException {
        SubtitleOutputBuffer subtitleOutputBufferPollFirst;
        SubtitleOutputBuffer subtitleOutputBufferB = super.b();
        if (subtitleOutputBufferB != null) {
            return subtitleOutputBufferB;
        }
        long j2 = this.f847s;
        boolean z2 = false;
        if (j2 != -9223372036854775807L) {
            long j3 = this.F;
            if (j3 != -9223372036854775807L && this.e - j3 >= j2) {
                z2 = true;
            }
        }
        if (!z2 || (subtitleOutputBufferPollFirst = this.f860b.pollFirst()) == null) {
            return null;
        }
        List<Cue> listEmptyList = Collections.emptyList();
        this.v = listEmptyList;
        this.F = -9223372036854775807L;
        this.w = listEmptyList;
        Objects.requireNonNull(listEmptyList);
        subtitleOutputBufferPollFirst.r(this.e, new CeaSubtitle(listEmptyList), RecyclerView.FOREVER_NS);
        return subtitleOutputBufferPollFirst;
    }

    @Override // b.i.a.c.b3.n.CeaDecoder
    public boolean h() {
        return this.v != this.w;
    }

    public final List<Cue> j() {
        int size = this.t.size();
        ArrayList arrayList = new ArrayList(size);
        int iMin = 2;
        for (int i2 = 0; i2 < size; i2++) {
            Cue cueC = this.t.get(i2).c(Integer.MIN_VALUE);
            arrayList.add(cueC);
            if (cueC != null) {
                iMin = Math.min(iMin, cueC.t);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            Cue cueC2 = (Cue) arrayList.get(i3);
            if (cueC2 != null) {
                if (cueC2.t != iMin) {
                    cueC2 = this.t.get(i3).c(iMin);
                    Objects.requireNonNull(cueC2);
                }
                arrayList2.add(cueC2);
            }
        }
        return arrayList2;
    }

    public final void k() {
        this.u.f(this.f848x);
        this.t.clear();
        this.t.add(this.u);
    }

    public final void l(int i2) {
        int i3 = this.f848x;
        if (i3 == i2) {
            return;
        }
        this.f848x = i2;
        if (i2 == 3) {
            for (int i4 = 0; i4 < this.t.size(); i4++) {
                this.t.get(i4).g = i2;
            }
            return;
        }
        k();
        if (i3 == 3 || i2 == 1 || i2 == 0) {
            this.v = Collections.emptyList();
        }
    }

    public final void m(int i2) {
        this.f849y = i2;
        this.u.h = i2;
    }

    @Override // b.i.a.c.b3.n.CeaDecoder, b.i.a.c.v2.Decoder
    public void release() {
    }
}

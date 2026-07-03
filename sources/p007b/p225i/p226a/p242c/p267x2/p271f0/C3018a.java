package p007b.p225i.p226a.p242c.p267x2.p271f0;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import java.io.IOException;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.C3118s;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;
import p007b.p225i.p226a.p242c.p267x2.p271f0.C3019b;
import p007b.p225i.p226a.p242c.p267x2.p274i0.C3050i;
import p007b.p225i.p226a.p242c.p267x2.p274i0.C3053l;

/* JADX INFO: renamed from: b.i.a.c.x2.f0.a */
/* JADX INFO: compiled from: JpegExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3018a implements InterfaceC3031h {

    /* JADX INFO: renamed from: b */
    public InterfaceC3058j f8156b;

    /* JADX INFO: renamed from: c */
    public int f8157c;

    /* JADX INFO: renamed from: d */
    public int f8158d;

    /* JADX INFO: renamed from: e */
    public int f8159e;

    /* JADX INFO: renamed from: g */
    @Nullable
    public MotionPhotoMetadata f8161g;

    /* JADX INFO: renamed from: h */
    public InterfaceC3041i f8162h;

    /* JADX INFO: renamed from: i */
    public C3020c f8163i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public C3050i f8164j;

    /* JADX INFO: renamed from: a */
    public final C2757x f8155a = new C2757x(6);

    /* JADX INFO: renamed from: f */
    public long f8160f = -1;

    /* JADX INFO: renamed from: a */
    public final void m3665a() {
        m3666c(new Metadata.Entry[0]);
        InterfaceC3058j interfaceC3058j = this.f8156b;
        Objects.requireNonNull(interfaceC3058j);
        interfaceC3058j.mo2486j();
        this.f8156b.mo2477a(new InterfaceC3119t.b(-9223372036854775807L, 0L));
        this.f8157c = 6;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: b */
    public boolean mo3633b(InterfaceC3041i interfaceC3041i) throws IOException {
        if (m3667d(interfaceC3041i) != 65496) {
            return false;
        }
        int iM3667d = m3667d(interfaceC3041i);
        this.f8158d = iM3667d;
        if (iM3667d == 65504) {
            this.f8155a.m3075A(2);
            interfaceC3041i.mo3652o(this.f8155a.f6793a, 0, 2);
            interfaceC3041i.mo3646g(this.f8155a.m3105y() - 2);
            this.f8158d = m3667d(interfaceC3041i);
        }
        if (this.f8158d != 65505) {
            return false;
        }
        interfaceC3041i.mo3646g(2);
        this.f8155a.m3075A(6);
        interfaceC3041i.mo3652o(this.f8155a.f6793a, 0, 6);
        return this.f8155a.m3101u() == 1165519206 && this.f8155a.m3105y() == 0;
    }

    /* JADX INFO: renamed from: c */
    public final void m3666c(Metadata.Entry... entryArr) {
        InterfaceC3058j interfaceC3058j = this.f8156b;
        Objects.requireNonNull(interfaceC3058j);
        InterfaceC3122w interfaceC3122wMo2492p = interfaceC3058j.mo2492p(1024, 4);
        C2811j1.b bVar = new C2811j1.b();
        bVar.f7172j = "image/jpeg";
        bVar.f7171i = new Metadata(entryArr);
        interfaceC3122wMo2492p.mo2526e(bVar.m3277a());
    }

    /* JADX INFO: renamed from: d */
    public final int m3667d(InterfaceC3041i interfaceC3041i) throws IOException {
        this.f8155a.m3075A(2);
        interfaceC3041i.mo3652o(this.f8155a.f6793a, 0, 2);
        return this.f8155a.m3105y();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: e */
    public int mo3635e(InterfaceC3041i interfaceC3041i, C3118s c3118s) throws IOException {
        int i;
        String strM3005m;
        String strM3005m2;
        C3019b c3019bM3668a;
        long j;
        int i2 = this.f8157c;
        if (i2 == 0) {
            this.f8155a.m3075A(2);
            interfaceC3041i.readFully(this.f8155a.f6793a, 0, 2);
            int iM3105y = this.f8155a.m3105y();
            this.f8158d = iM3105y;
            if (iM3105y == 65498) {
                if (this.f8160f != -1) {
                    this.f8157c = 4;
                } else {
                    m3665a();
                }
            } else if ((iM3105y < 65488 || iM3105y > 65497) && iM3105y != 65281) {
                this.f8157c = 1;
            }
            return 0;
        }
        if (i2 == 1) {
            this.f8155a.m3075A(2);
            interfaceC3041i.readFully(this.f8155a.f6793a, 0, 2);
            this.f8159e = this.f8155a.m3105y() - 2;
            this.f8157c = 2;
            return 0;
        }
        if (i2 != 2) {
            if (i2 != 4) {
                if (i2 != 5) {
                    if (i2 == 6) {
                        return -1;
                    }
                    throw new IllegalStateException();
                }
                if (this.f8163i == null || interfaceC3041i != this.f8162h) {
                    this.f8162h = interfaceC3041i;
                    this.f8163i = new C3020c(interfaceC3041i, this.f8160f);
                }
                C3050i c3050i = this.f8164j;
                Objects.requireNonNull(c3050i);
                int iMo3635e = c3050i.mo3635e(this.f8163i, c3118s);
                if (iMo3635e == 1) {
                    c3118s.f8992a += this.f8160f;
                }
                return iMo3635e;
            }
            long position = interfaceC3041i.getPosition();
            long j2 = this.f8160f;
            if (position != j2) {
                c3118s.f8992a = j2;
                return 1;
            }
            if (interfaceC3041i.mo3644e(this.f8155a.f6793a, 0, 1, true)) {
                interfaceC3041i.mo3649k();
                if (this.f8164j == null) {
                    this.f8164j = new C3050i(0);
                }
                C3020c c3020c = new C3020c(interfaceC3041i, this.f8160f);
                this.f8163i = c3020c;
                if (C3053l.m3730a(c3020c, false, (this.f8164j.f8420b & 2) != 0)) {
                    C3050i c3050i2 = this.f8164j;
                    long j3 = this.f8160f;
                    InterfaceC3058j interfaceC3058j = this.f8156b;
                    Objects.requireNonNull(interfaceC3058j);
                    c3050i2.f8437s = new C3021d(j3, interfaceC3058j);
                    MotionPhotoMetadata motionPhotoMetadata = this.f8161g;
                    Objects.requireNonNull(motionPhotoMetadata);
                    m3666c(motionPhotoMetadata);
                    this.f8157c = 5;
                } else {
                    m3665a();
                }
            } else {
                m3665a();
            }
            return 0;
        }
        if (this.f8158d == 65505) {
            int i3 = this.f8159e;
            byte[] bArr = new byte[i3];
            interfaceC3041i.readFully(bArr, 0, i3);
            if (this.f8161g == null) {
                MotionPhotoMetadata motionPhotoMetadata2 = null;
                if (i3 + 0 == 0) {
                    strM3005m = null;
                    i = 0;
                } else {
                    i = 0;
                    while (i < i3 && bArr[i] != 0) {
                        i++;
                    }
                    strM3005m = C2738e0.m3005m(bArr, 0, i + 0);
                    if (i < i3) {
                        i++;
                    }
                }
                if ("http://ns.adobe.com/xap/1.0/".equals(strM3005m)) {
                    if (i3 - i == 0) {
                        strM3005m2 = null;
                    } else {
                        int i4 = i;
                        while (i4 < i3 && bArr[i4] != 0) {
                            i4++;
                        }
                        strM3005m2 = C2738e0.m3005m(bArr, i, i4 - i);
                    }
                    if (strM3005m2 != null) {
                        long jMo3642b = interfaceC3041i.mo3642b();
                        if (jMo3642b != -1) {
                            try {
                                c3019bM3668a = C3022e.m3668a(strM3005m2);
                            } catch (ParserException | NumberFormatException | XmlPullParserException unused) {
                                Log.w("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
                                c3019bM3668a = null;
                            }
                            if (c3019bM3668a != null && c3019bM3668a.f8166b.size() >= 2) {
                                long j4 = -1;
                                long j5 = -1;
                                long j6 = -1;
                                long j7 = -1;
                                boolean zEquals = false;
                                for (int size = c3019bM3668a.f8166b.size() - 1; size >= 0; size--) {
                                    C3019b.a aVar = c3019bM3668a.f8166b.get(size);
                                    zEquals |= "video/mp4".equals(aVar.f8167a);
                                    if (size == 0) {
                                        j = jMo3642b - aVar.f8169c;
                                        jMo3642b = 0;
                                    } else {
                                        long j8 = jMo3642b - aVar.f8168b;
                                        j = jMo3642b;
                                        jMo3642b = j8;
                                    }
                                    if (zEquals && jMo3642b != j) {
                                        j7 = j - jMo3642b;
                                        j6 = jMo3642b;
                                        zEquals = false;
                                    }
                                    if (size == 0) {
                                        j5 = j;
                                        j4 = jMo3642b;
                                    }
                                }
                                if (j6 != -1 && j7 != -1 && j4 != -1 && j5 != -1) {
                                    motionPhotoMetadata2 = new MotionPhotoMetadata(j4, j5, c3019bM3668a.f8165a, j6, j7);
                                }
                            }
                        }
                        this.f8161g = motionPhotoMetadata2;
                        if (motionPhotoMetadata2 != null) {
                            this.f8160f = motionPhotoMetadata2.f20011m;
                        }
                    }
                }
            }
        } else {
            interfaceC3041i.mo3650l(this.f8159e);
        }
        this.f8157c = 0;
        return 0;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: f */
    public void mo3636f(InterfaceC3058j interfaceC3058j) {
        this.f8156b = interfaceC3058j;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        if (j == 0) {
            this.f8157c = 0;
            this.f8164j = null;
        } else if (this.f8157c == 5) {
            C3050i c3050i = this.f8164j;
            Objects.requireNonNull(c3050i);
            c3050i.mo3637g(j, j2);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    public void release() {
        C3050i c3050i = this.f8164j;
        if (c3050i != null) {
            Objects.requireNonNull(c3050i);
        }
    }
}

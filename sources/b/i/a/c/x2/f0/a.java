package b.i.a.c.x2.f0;

import android.util.Log;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.x;
import b.i.a.c.j1$b;
import b.i.a.c.x2.h;
import b.i.a.c.x2.i;
import b.i.a.c.x2.i0.l;
import b.i.a.c.x2.j;
import b.i.a.c.x2.s;
import b.i.a.c.x2.t$b;
import b.i.a.c.x2.w;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import java.io.IOException;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: JpegExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f1177b;
    public int c;
    public int d;
    public int e;

    @Nullable
    public MotionPhotoMetadata g;
    public i h;
    public c i;

    @Nullable
    public b.i.a.c.x2.i0.i j;
    public final x a = new x(6);
    public long f = -1;

    public final void a() {
        c(new Metadata$Entry[0]);
        j jVar = this.f1177b;
        Objects.requireNonNull(jVar);
        jVar.j();
        this.f1177b.a(new t$b(-9223372036854775807L, 0L));
        this.c = 6;
    }

    @Override // b.i.a.c.x2.h
    public boolean b(i iVar) throws IOException {
        if (d(iVar) != 65496) {
            return false;
        }
        int iD = d(iVar);
        this.d = iD;
        if (iD == 65504) {
            this.a.A(2);
            iVar.o(this.a.a, 0, 2);
            iVar.g(this.a.y() - 2);
            this.d = d(iVar);
        }
        if (this.d != 65505) {
            return false;
        }
        iVar.g(2);
        this.a.A(6);
        iVar.o(this.a.a, 0, 6);
        return this.a.u() == 1165519206 && this.a.y() == 0;
    }

    public final void c(Metadata$Entry... metadata$EntryArr) {
        j jVar = this.f1177b;
        Objects.requireNonNull(jVar);
        w wVarP = jVar.p(1024, 4);
        j1$b j1_b = new j1$b();
        j1_b.j = "image/jpeg";
        j1_b.i = new Metadata(metadata$EntryArr);
        wVarP.e(j1_b.a());
    }

    public final int d(i iVar) throws IOException {
        this.a.A(2);
        iVar.o(this.a.a, 0, 2);
        return this.a.y();
    }

    @Override // b.i.a.c.x2.h
    public int e(i iVar, s sVar) throws IOException {
        int i;
        String strM;
        String strM2;
        b bVarA;
        long j;
        int i2 = this.c;
        if (i2 == 0) {
            this.a.A(2);
            iVar.readFully(this.a.a, 0, 2);
            int iY = this.a.y();
            this.d = iY;
            if (iY == 65498) {
                if (this.f != -1) {
                    this.c = 4;
                } else {
                    a();
                }
            } else if ((iY < 65488 || iY > 65497) && iY != 65281) {
                this.c = 1;
            }
            return 0;
        }
        if (i2 == 1) {
            this.a.A(2);
            iVar.readFully(this.a.a, 0, 2);
            this.e = this.a.y() - 2;
            this.c = 2;
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
                if (this.i == null || iVar != this.h) {
                    this.h = iVar;
                    this.i = new c(iVar, this.f);
                }
                b.i.a.c.x2.i0.i iVar2 = this.j;
                Objects.requireNonNull(iVar2);
                int iE = iVar2.e(this.i, sVar);
                if (iE == 1) {
                    sVar.a += this.f;
                }
                return iE;
            }
            long position = iVar.getPosition();
            long j2 = this.f;
            if (position != j2) {
                sVar.a = j2;
                return 1;
            }
            if (iVar.e(this.a.a, 0, 1, true)) {
                iVar.k();
                if (this.j == null) {
                    this.j = new b.i.a.c.x2.i0.i(0);
                }
                c cVar = new c(iVar, this.f);
                this.i = cVar;
                if (l.a(cVar, false, (this.j.f1222b & 2) != 0)) {
                    b.i.a.c.x2.i0.i iVar3 = this.j;
                    long j3 = this.f;
                    j jVar = this.f1177b;
                    Objects.requireNonNull(jVar);
                    iVar3.f1223s = new d(j3, jVar);
                    MotionPhotoMetadata motionPhotoMetadata = this.g;
                    Objects.requireNonNull(motionPhotoMetadata);
                    c(motionPhotoMetadata);
                    this.c = 5;
                } else {
                    a();
                }
            } else {
                a();
            }
            return 0;
        }
        if (this.d == 65505) {
            int i3 = this.e;
            byte[] bArr = new byte[i3];
            iVar.readFully(bArr, 0, i3);
            if (this.g == null) {
                MotionPhotoMetadata motionPhotoMetadata2 = null;
                if (i3 + 0 == 0) {
                    strM = null;
                    i = 0;
                } else {
                    i = 0;
                    while (i < i3 && bArr[i] != 0) {
                        i++;
                    }
                    strM = e0.m(bArr, 0, i + 0);
                    if (i < i3) {
                        i++;
                    }
                }
                if ("http://ns.adobe.com/xap/1.0/".equals(strM)) {
                    if (i3 - i == 0) {
                        strM2 = null;
                    } else {
                        int i4 = i;
                        while (i4 < i3 && bArr[i4] != 0) {
                            i4++;
                        }
                        strM2 = e0.m(bArr, i, i4 - i);
                    }
                    if (strM2 != null) {
                        long jB = iVar.b();
                        if (jB != -1) {
                            try {
                                bVarA = e.a(strM2);
                            } catch (ParserException | NumberFormatException | XmlPullParserException unused) {
                                Log.w("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
                                bVarA = null;
                            }
                            if (bVarA != null && bVarA.f1178b.size() >= 2) {
                                long j4 = -1;
                                long j5 = -1;
                                long j6 = -1;
                                long j7 = -1;
                                boolean zEquals = false;
                                for (int size = bVarA.f1178b.size() - 1; size >= 0; size--) {
                                    b$a b_a = bVarA.f1178b.get(size);
                                    zEquals |= "video/mp4".equals(b_a.a);
                                    if (size == 0) {
                                        j = jB - b_a.c;
                                        jB = 0;
                                    } else {
                                        long j8 = jB - b_a.f1179b;
                                        j = jB;
                                        jB = j8;
                                    }
                                    if (zEquals && jB != j) {
                                        j7 = j - jB;
                                        j6 = jB;
                                        zEquals = false;
                                    }
                                    if (size == 0) {
                                        j5 = j;
                                        j4 = jB;
                                    }
                                }
                                if (j6 != -1 && j7 != -1 && j4 != -1 && j5 != -1) {
                                    motionPhotoMetadata2 = new MotionPhotoMetadata(j4, j5, bVarA.a, j6, j7);
                                }
                            }
                        }
                        this.g = motionPhotoMetadata2;
                        if (motionPhotoMetadata2 != null) {
                            this.f = motionPhotoMetadata2.m;
                        }
                    }
                }
            }
        } else {
            iVar.l(this.e);
        }
        this.c = 0;
        return 0;
    }

    @Override // b.i.a.c.x2.h
    public void f(j jVar) {
        this.f1177b = jVar;
    }

    @Override // b.i.a.c.x2.h
    public void g(long j, long j2) {
        if (j == 0) {
            this.c = 0;
            this.j = null;
        } else if (this.c == 5) {
            b.i.a.c.x2.i0.i iVar = this.j;
            Objects.requireNonNull(iVar);
            iVar.g(j, j2);
        }
    }

    @Override // b.i.a.c.x2.h
    public void release() {
        b.i.a.c.x2.i0.i iVar = this.j;
        if (iVar != null) {
            Objects.requireNonNull(iVar);
        }
    }
}

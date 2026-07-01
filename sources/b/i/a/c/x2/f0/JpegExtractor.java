package b.i.a.c.x2.f0;

import android.util.Log;
import androidx.annotation.Nullable;
import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.Extractor;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.PositionHolder;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.f0.MotionPhotoDescription;
import b.i.a.c.x2.i0.Mp4Extractor;
import b.i.a.c.x2.i0.Sniffer2;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import java.io.IOException;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: b.i.a.c.x2.f0.a, reason: use source file name */
/* JADX INFO: compiled from: JpegExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class JpegExtractor implements Extractor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ExtractorOutput f1177b;
    public int c;
    public int d;
    public int e;

    @Nullable
    public MotionPhotoMetadata g;
    public ExtractorInput h;
    public StartOffsetExtractorInput i;

    @Nullable
    public Mp4Extractor j;
    public final ParsableByteArray a = new ParsableByteArray(6);
    public long f = -1;

    public final void a() {
        c(new Metadata.Entry[0]);
        ExtractorOutput extractorOutput = this.f1177b;
        Objects.requireNonNull(extractorOutput);
        extractorOutput.j();
        this.f1177b.a(new SeekMap.b(-9223372036854775807L, 0L));
        this.c = 6;
    }

    @Override // b.i.a.c.x2.Extractor
    public boolean b(ExtractorInput extractorInput) throws IOException {
        if (d(extractorInput) != 65496) {
            return false;
        }
        int iD = d(extractorInput);
        this.d = iD;
        if (iD == 65504) {
            this.a.A(2);
            extractorInput.o(this.a.a, 0, 2);
            extractorInput.g(this.a.y() - 2);
            this.d = d(extractorInput);
        }
        if (this.d != 65505) {
            return false;
        }
        extractorInput.g(2);
        this.a.A(6);
        extractorInput.o(this.a.a, 0, 6);
        return this.a.u() == 1165519206 && this.a.y() == 0;
    }

    public final void c(Metadata.Entry... entryArr) {
        ExtractorOutput extractorOutput = this.f1177b;
        Objects.requireNonNull(extractorOutput);
        TrackOutput2 trackOutput2P = extractorOutput.p(1024, 4);
        Format2.b bVar = new Format2.b();
        bVar.j = "image/jpeg";
        bVar.i = new Metadata(entryArr);
        trackOutput2P.e(bVar.a());
    }

    public final int d(ExtractorInput extractorInput) throws IOException {
        this.a.A(2);
        extractorInput.o(this.a.a, 0, 2);
        return this.a.y();
    }

    @Override // b.i.a.c.x2.Extractor
    public int e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i;
        String strM;
        String strM2;
        MotionPhotoDescription motionPhotoDescriptionA;
        long j;
        int i2 = this.c;
        if (i2 == 0) {
            this.a.A(2);
            extractorInput.readFully(this.a.a, 0, 2);
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
            extractorInput.readFully(this.a.a, 0, 2);
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
                if (this.i == null || extractorInput != this.h) {
                    this.h = extractorInput;
                    this.i = new StartOffsetExtractorInput(extractorInput, this.f);
                }
                Mp4Extractor mp4Extractor = this.j;
                Objects.requireNonNull(mp4Extractor);
                int iE = mp4Extractor.e(this.i, positionHolder);
                if (iE == 1) {
                    positionHolder.a += this.f;
                }
                return iE;
            }
            long position = extractorInput.getPosition();
            long j2 = this.f;
            if (position != j2) {
                positionHolder.a = j2;
                return 1;
            }
            if (extractorInput.e(this.a.a, 0, 1, true)) {
                extractorInput.k();
                if (this.j == null) {
                    this.j = new Mp4Extractor(0);
                }
                StartOffsetExtractorInput startOffsetExtractorInput = new StartOffsetExtractorInput(extractorInput, this.f);
                this.i = startOffsetExtractorInput;
                if (Sniffer2.a(startOffsetExtractorInput, false, (this.j.f1222b & 2) != 0)) {
                    Mp4Extractor mp4Extractor2 = this.j;
                    long j3 = this.f;
                    ExtractorOutput extractorOutput = this.f1177b;
                    Objects.requireNonNull(extractorOutput);
                    mp4Extractor2.f1223s = new StartOffsetExtractorOutput(j3, extractorOutput);
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
            extractorInput.readFully(bArr, 0, i3);
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
                    strM = Util2.m(bArr, 0, i + 0);
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
                        strM2 = Util2.m(bArr, i, i4 - i);
                    }
                    if (strM2 != null) {
                        long jB = extractorInput.b();
                        if (jB != -1) {
                            try {
                                motionPhotoDescriptionA = XmpMotionPhotoDescriptionParser.a(strM2);
                            } catch (ParserException | NumberFormatException | XmlPullParserException unused) {
                                Log.w("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
                                motionPhotoDescriptionA = null;
                            }
                            if (motionPhotoDescriptionA != null && motionPhotoDescriptionA.f1178b.size() >= 2) {
                                long j4 = -1;
                                long j5 = -1;
                                long j6 = -1;
                                long j7 = -1;
                                boolean zEquals = false;
                                for (int size = motionPhotoDescriptionA.f1178b.size() - 1; size >= 0; size--) {
                                    MotionPhotoDescription.a aVar = motionPhotoDescriptionA.f1178b.get(size);
                                    zEquals |= "video/mp4".equals(aVar.a);
                                    if (size == 0) {
                                        j = jB - aVar.c;
                                        jB = 0;
                                    } else {
                                        long j8 = jB - aVar.f1179b;
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
                                    motionPhotoMetadata2 = new MotionPhotoMetadata(j4, j5, motionPhotoDescriptionA.a, j6, j7);
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
            extractorInput.l(this.e);
        }
        this.c = 0;
        return 0;
    }

    @Override // b.i.a.c.x2.Extractor
    public void f(ExtractorOutput extractorOutput) {
        this.f1177b = extractorOutput;
    }

    @Override // b.i.a.c.x2.Extractor
    public void g(long j, long j2) {
        if (j == 0) {
            this.c = 0;
            this.j = null;
        } else if (this.c == 5) {
            Mp4Extractor mp4Extractor = this.j;
            Objects.requireNonNull(mp4Extractor);
            mp4Extractor.g(j, j2);
        }
    }

    @Override // b.i.a.c.x2.Extractor
    public void release() {
        Mp4Extractor mp4Extractor = this.j;
        if (mp4Extractor != null) {
            Objects.requireNonNull(mp4Extractor);
        }
    }
}

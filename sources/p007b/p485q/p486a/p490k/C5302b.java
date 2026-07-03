package p007b.p485q.p486a.p490k;

import android.util.Log;
import com.adjust.sdk.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.q.a.k.b */
/* JADX INFO: compiled from: ImageHeaderParser.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5302b {

    /* JADX INFO: renamed from: a */
    public static final byte[] f14440a = "Exif\u0000\u0000".getBytes(Charset.forName(Constants.ENCODING));

    /* JADX INFO: renamed from: b */
    public static final int[] f14441b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* JADX INFO: renamed from: c */
    public final a f14442c;

    /* JADX INFO: renamed from: b.q.a.k.b$a */
    /* JADX INFO: compiled from: ImageHeaderParser.java */
    public interface a {
    }

    /* JADX INFO: renamed from: b.q.a.k.b$b */
    /* JADX INFO: compiled from: ImageHeaderParser.java */
    public static class b implements a {

        /* JADX INFO: renamed from: a */
        public final InputStream f14443a;

        public b(InputStream inputStream) {
            this.f14443a = inputStream;
        }

        /* JADX INFO: renamed from: a */
        public int m7476a() throws IOException {
            return ((this.f14443a.read() << 8) & 65280) | (this.f14443a.read() & 255);
        }
    }

    public C5302b(InputStream inputStream) {
        this.f14442c = new b(inputStream);
    }

    /* JADX INFO: renamed from: a */
    public int m7475a() throws IOException {
        int iM7476a;
        int iM7476a2 = ((b) this.f14442c).m7476a();
        if (!((iM7476a2 & 65496) == 65496 || iM7476a2 == 19789 || iM7476a2 == 18761)) {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                C1643a.m866n0("Parser doesn't handle magic number: ", iM7476a2, "ImageHeaderParser");
            }
            return -1;
        }
        while (true) {
            short s2 = (short) (((b) this.f14442c).f14443a.read() & 255);
            if (s2 == 255) {
                short s3 = (short) (((b) this.f14442c).f14443a.read() & 255);
                if (s3 != 218) {
                    if (s3 != 217) {
                        iM7476a = ((b) this.f14442c).m7476a() - 2;
                        if (s3 == 225) {
                            break;
                        }
                        long j = iM7476a;
                        b bVar = (b) this.f14442c;
                        Objects.requireNonNull(bVar);
                        long j2 = 0;
                        if (j >= 0) {
                            long j3 = j;
                            while (j3 > 0) {
                                long jSkip = bVar.f14443a.skip(j3);
                                if (jSkip <= 0) {
                                    if (bVar.f14443a.read() == -1) {
                                        break;
                                    }
                                    jSkip = 1;
                                }
                                j3 -= jSkip;
                            }
                            j2 = j - j3;
                        }
                        if (j2 != j) {
                            if (Log.isLoggable("ImageHeaderParser", 3)) {
                                StringBuilder sbM835W = C1643a.m835W("Unable to skip enough data, type: ", s3, ", wanted to skip: ", iM7476a, ", but actually skipped: ");
                                sbM835W.append(j2);
                                Log.d("ImageHeaderParser", sbM835W.toString());
                            }
                        }
                    } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                        Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
                    }
                }
            } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                C1643a.m866n0("Unknown segmentId=", s2, "ImageHeaderParser");
            }
            iM7476a = -1;
            break;
        }
        if (iM7476a == -1) {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        byte[] bArr = new byte[iM7476a];
        b bVar2 = (b) this.f14442c;
        Objects.requireNonNull(bVar2);
        int i = iM7476a;
        while (i > 0) {
            int i2 = bVar2.f14443a.read(bArr, iM7476a - i, i);
            if (i2 == -1) {
                break;
            }
            i -= i2;
        }
        int i3 = iM7476a - i;
        if (i3 != iM7476a) {
            if (!Log.isLoggable("ImageHeaderParser", 3)) {
                return -1;
            }
            Log.d("ImageHeaderParser", "Unable to read exif segment data, length: " + iM7476a + ", actually read: " + i3);
            return -1;
        }
        boolean z2 = iM7476a > f14440a.length;
        if (z2) {
            int i4 = 0;
            while (true) {
                byte[] bArr2 = f14440a;
                if (i4 >= bArr2.length) {
                    break;
                }
                if (bArr[i4] != bArr2[i4]) {
                    z2 = false;
                    break;
                }
                i4++;
            }
        }
        if (!z2) {
            if (!Log.isLoggable("ImageHeaderParser", 3)) {
                return -1;
            }
            Log.d("ImageHeaderParser", "Missing jpeg exif preamble");
            return -1;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        ByteBuffer byteBuffer = (ByteBuffer) byteBufferWrap.order(byteOrder).limit(iM7476a);
        short s4 = byteBuffer.getShort(6);
        if (s4 != 19789) {
            if (s4 == 18761) {
                byteOrder = ByteOrder.LITTLE_ENDIAN;
            } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                C1643a.m866n0("Unknown endianness = ", s4, "ImageHeaderParser");
            }
        }
        byteBuffer.order(byteOrder);
        int i5 = byteBuffer.getInt(10) + 6;
        short s5 = byteBuffer.getShort(i5);
        for (int i6 = 0; i6 < s5; i6++) {
            int i7 = (i6 * 12) + i5 + 2;
            short s6 = byteBuffer.getShort(i7);
            if (s6 == 274) {
                short s7 = byteBuffer.getShort(i7 + 2);
                if (s7 >= 1 && s7 <= 12) {
                    int i8 = byteBuffer.getInt(i7 + 4);
                    if (i8 >= 0) {
                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                            StringBuilder sbM835W2 = C1643a.m835W("Got tagIndex=", i6, " tagType=", s6, " formatCode=");
                            sbM835W2.append((int) s7);
                            sbM835W2.append(" componentCount=");
                            sbM835W2.append(i8);
                            Log.d("ImageHeaderParser", sbM835W2.toString());
                        }
                        int i9 = i8 + f14441b[s7];
                        if (i9 <= 4) {
                            int i10 = i7 + 8;
                            if (i10 >= 0 && i10 <= byteBuffer.remaining()) {
                                if (i9 >= 0 && i9 + i10 <= byteBuffer.remaining()) {
                                    return byteBuffer.getShort(i10);
                                }
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    C1643a.m866n0("Illegal number of bytes for TI tag data tagType=", s6, "ImageHeaderParser");
                                }
                            } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                                Log.d("ImageHeaderParser", "Illegal tagValueOffset=" + i10 + " tagType=" + ((int) s6));
                            }
                        } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                            C1643a.m866n0("Got byte count > 4, not orientation, continuing, formatCode=", s7, "ImageHeaderParser");
                        }
                    } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                        Log.d("ImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                    C1643a.m866n0("Got invalid format code = ", s7, "ImageHeaderParser");
                }
            }
        }
        return -1;
    }
}

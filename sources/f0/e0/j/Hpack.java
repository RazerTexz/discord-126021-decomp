package f0.e0.j;

import androidx.browser.trusted.sharing.ShareTarget;
import b.d.b.a.outline;
import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import d0.t._ArraysJvm;
import d0.z.d.Intrinsics3;
import f0.e0.Util7;
import f0.e0.j.Huffman;
import g0.Buffer3;
import g0.BufferedSource;
import g0.RealBufferedSource;
import g0.Source2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okio.ByteString;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: f0.e0.j.c, reason: use source file name */
/* JADX INFO: compiled from: Hpack.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Hpack {
    public static final Header2[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<ByteString, Integer> f3634b;
    public static final Hpack c = new Hpack();

    /* JADX INFO: renamed from: f0.e0.j.c$a */
    /* JADX INFO: compiled from: Hpack.kt */
    public static final class a {
        public final List<Header2> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BufferedSource f3635b;
        public Header2[] c;
        public int d;
        public int e;
        public int f;
        public final int g;
        public int h;

        public a(Source2 source2, int i, int i2, int i3) {
            i2 = (i3 & 4) != 0 ? i : i2;
            Intrinsics3.checkParameterIsNotNull(source2, "source");
            this.g = i;
            this.h = i2;
            this.a = new ArrayList();
            Intrinsics3.checkParameterIsNotNull(source2, "$this$buffer");
            this.f3635b = new RealBufferedSource(source2);
            this.c = new Header2[8];
            this.d = 7;
        }

        public final void a() {
            _ArraysJvm.fill$default(this.c, null, 0, 0, 6, null);
            this.d = this.c.length - 1;
            this.e = 0;
            this.f = 0;
        }

        public final int b(int i) {
            return this.d + 1 + i;
        }

        public final int c(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.c.length;
                while (true) {
                    length--;
                    i2 = this.d;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    Header2 header2 = this.c[length];
                    if (header2 == null) {
                        Intrinsics3.throwNpe();
                    }
                    int i4 = header2.g;
                    i -= i4;
                    this.f -= i4;
                    this.e--;
                    i3++;
                }
                Header2[] header2Arr = this.c;
                System.arraycopy(header2Arr, i2 + 1, header2Arr, i2 + 1 + i3, this.e);
                this.d += i3;
            }
            return i3;
        }

        /* JADX WARN: Code duplicated, block: B:6:0x000d  */
        public final ByteString d(int i) throws IOException {
            boolean z2;
            if (i >= 0) {
                Hpack hpack = Hpack.c;
                if (i <= Hpack.a.length - 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            if (z2) {
                Hpack hpack2 = Hpack.c;
                return Hpack.a[i].h;
            }
            Hpack hpack3 = Hpack.c;
            int iB = b(i - Hpack.a.length);
            if (iB >= 0) {
                Header2[] header2Arr = this.c;
                if (iB < header2Arr.length) {
                    Header2 header2 = header2Arr[iB];
                    if (header2 == null) {
                        Intrinsics3.throwNpe();
                    }
                    return header2.h;
                }
            }
            StringBuilder sbU = outline.U("Header index too large ");
            sbU.append(i + 1);
            throw new IOException(sbU.toString());
        }

        public final void e(int i, Header2 header2) {
            this.a.add(header2);
            int i2 = header2.g;
            if (i != -1) {
                Header2 header3 = this.c[this.d + 1 + i];
                if (header3 == null) {
                    Intrinsics3.throwNpe();
                }
                i2 -= header3.g;
            }
            int i3 = this.h;
            if (i2 > i3) {
                a();
                return;
            }
            int iC = c((this.f + i2) - i3);
            if (i == -1) {
                int i4 = this.e + 1;
                Header2[] header2Arr = this.c;
                if (i4 > header2Arr.length) {
                    Header2[] header2Arr2 = new Header2[header2Arr.length * 2];
                    System.arraycopy(header2Arr, 0, header2Arr2, header2Arr.length, header2Arr.length);
                    this.d = this.c.length - 1;
                    this.c = header2Arr2;
                }
                int i5 = this.d;
                this.d = i5 - 1;
                this.c[i5] = header2;
                this.e++;
            } else {
                this.c[this.d + 1 + i + iC + i] = header2;
            }
            this.f += i2;
        }

        public final ByteString f() throws IOException {
            byte b2 = this.f3635b.readByte();
            byte[] bArr = Util7.a;
            int i = b2 & 255;
            int i2 = 0;
            boolean z2 = (i & 128) == 128;
            long jG = g(i, Opcodes.LAND);
            if (!z2) {
                return this.f3635b.o(jG);
            }
            Buffer3 buffer3 = new Buffer3();
            Huffman huffman = Huffman.d;
            BufferedSource bufferedSource = this.f3635b;
            Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
            Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
            Huffman.a aVar = Huffman.c;
            int i3 = 0;
            for (long j = 0; j < jG; j++) {
                byte b3 = bufferedSource.readByte();
                byte[] bArr2 = Util7.a;
                i2 = (i2 << 8) | (b3 & 255);
                i3 += 8;
                while (i3 >= 8) {
                    int i4 = i3 - 8;
                    int i5 = (i2 >>> i4) & 255;
                    Huffman.a[] aVarArr = aVar.a;
                    if (aVarArr == null) {
                        Intrinsics3.throwNpe();
                    }
                    aVar = aVarArr[i5];
                    if (aVar == null) {
                        Intrinsics3.throwNpe();
                    }
                    if (aVar.a == null) {
                        buffer3.T(aVar.f3646b);
                        i3 -= aVar.c;
                        aVar = Huffman.c;
                    } else {
                        i3 = i4;
                    }
                }
            }
            while (i3 > 0) {
                int i6 = (i2 << (8 - i3)) & 255;
                Huffman.a[] aVarArr2 = aVar.a;
                if (aVarArr2 == null) {
                    Intrinsics3.throwNpe();
                }
                Huffman.a aVar2 = aVarArr2[i6];
                if (aVar2 == null) {
                    Intrinsics3.throwNpe();
                }
                if (aVar2.a != null || aVar2.c > i3) {
                    break;
                }
                buffer3.T(aVar2.f3646b);
                i3 -= aVar2.c;
                aVar = Huffman.c;
            }
            return buffer3.x();
        }

        public final int g(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                byte b2 = this.f3635b.readByte();
                byte[] bArr = Util7.a;
                int i5 = b2 & 255;
                if ((i5 & 128) == 0) {
                    return i2 + (i5 << i4);
                }
                i2 += (i5 & Opcodes.LAND) << i4;
                i4 += 7;
            }
        }
    }

    /* JADX INFO: renamed from: f0.e0.j.c$b */
    /* JADX INFO: compiled from: Hpack.kt */
    public static final class b {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3636b;
        public int c;
        public Header2[] d;
        public int e;
        public int f;
        public int g;
        public int h;
        public final boolean i;
        public final Buffer3 j;

        public b(int i, boolean z2, Buffer3 buffer3, int i2) {
            i = (i2 & 1) != 0 ? 4096 : i;
            z2 = (i2 & 2) != 0 ? true : z2;
            Intrinsics3.checkParameterIsNotNull(buffer3, "out");
            this.h = i;
            this.i = z2;
            this.j = buffer3;
            this.a = Integer.MAX_VALUE;
            this.c = i;
            this.d = new Header2[8];
            this.e = 7;
        }

        public final void a() {
            _ArraysJvm.fill$default(this.d, null, 0, 0, 6, null);
            this.e = this.d.length - 1;
            this.f = 0;
            this.g = 0;
        }

        public final int b(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.d.length;
                while (true) {
                    length--;
                    i2 = this.e;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    Header2 header2 = this.d[length];
                    if (header2 == null) {
                        Intrinsics3.throwNpe();
                    }
                    i -= header2.g;
                    int i4 = this.g;
                    Header2 header3 = this.d[length];
                    if (header3 == null) {
                        Intrinsics3.throwNpe();
                    }
                    this.g = i4 - header3.g;
                    this.f--;
                    i3++;
                }
                Header2[] header2Arr = this.d;
                System.arraycopy(header2Arr, i2 + 1, header2Arr, i2 + 1 + i3, this.f);
                Header2[] header2Arr2 = this.d;
                int i5 = this.e;
                Arrays.fill(header2Arr2, i5 + 1, i5 + 1 + i3, (Object) null);
                this.e += i3;
            }
            return i3;
        }

        public final void c(Header2 header2) {
            int i = header2.g;
            int i2 = this.c;
            if (i > i2) {
                a();
                return;
            }
            b((this.g + i) - i2);
            int i3 = this.f + 1;
            Header2[] header2Arr = this.d;
            if (i3 > header2Arr.length) {
                Header2[] header2Arr2 = new Header2[header2Arr.length * 2];
                System.arraycopy(header2Arr, 0, header2Arr2, header2Arr.length, header2Arr.length);
                this.e = this.d.length - 1;
                this.d = header2Arr2;
            }
            int i4 = this.e;
            this.e = i4 - 1;
            this.d[i4] = header2;
            this.f++;
            this.g += i;
        }

        public final void d(ByteString byteString) throws IOException {
            Intrinsics3.checkParameterIsNotNull(byteString, "data");
            if (this.i) {
                Huffman huffman = Huffman.d;
                Intrinsics3.checkParameterIsNotNull(byteString, "bytes");
                int iJ = byteString.j();
                long j = 0;
                for (int i = 0; i < iJ; i++) {
                    byte bM = byteString.m(i);
                    byte[] bArr = Util7.a;
                    j += (long) Huffman.f3645b[bM & 255];
                }
                if (((int) ((j + ((long) 7)) >> 3)) < byteString.j()) {
                    Buffer3 buffer3 = new Buffer3();
                    Huffman huffman2 = Huffman.d;
                    Intrinsics3.checkParameterIsNotNull(byteString, "source");
                    Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
                    int iJ2 = byteString.j();
                    long j2 = 0;
                    int i2 = 0;
                    for (int i3 = 0; i3 < iJ2; i3++) {
                        byte bM2 = byteString.m(i3);
                        byte[] bArr2 = Util7.a;
                        int i4 = bM2 & 255;
                        int i5 = Huffman.a[i4];
                        byte b2 = Huffman.f3645b[i4];
                        j2 = (j2 << b2) | ((long) i5);
                        i2 += b2;
                        while (i2 >= 8) {
                            i2 -= 8;
                            buffer3.writeByte((int) (j2 >> i2));
                        }
                    }
                    if (i2 > 0) {
                        buffer3.writeByte((int) ((255 >>> i2) | (j2 << (8 - i2))));
                    }
                    ByteString byteStringX = buffer3.x();
                    f(byteStringX.j(), Opcodes.LAND, 128);
                    this.j.O(byteStringX);
                    return;
                }
            }
            f(byteString.j(), Opcodes.LAND, 0);
            this.j.O(byteString);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0072  */
        public final void e(List<Header2> list) throws IOException {
            int length;
            int length2;
            Intrinsics3.checkParameterIsNotNull(list, "headerBlock");
            if (this.f3636b) {
                int i = this.a;
                if (i < this.c) {
                    f(i, 31, 32);
                }
                this.f3636b = false;
                this.a = Integer.MAX_VALUE;
                f(this.c, 31, 32);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Header2 header2 = list.get(i2);
                ByteString byteStringP = header2.h.p();
                ByteString byteString = header2.i;
                Hpack hpack = Hpack.c;
                Integer num = Hpack.f3634b.get(byteStringP);
                if (num != null) {
                    length = num.intValue() + 1;
                    if (2 <= length && 7 >= length) {
                        Header2[] header2Arr = Hpack.a;
                        if (Intrinsics3.areEqual(header2Arr[length - 1].i, byteString)) {
                            length2 = length;
                        } else if (Intrinsics3.areEqual(header2Arr[length].i, byteString)) {
                            length2 = length;
                            length++;
                        } else {
                            length2 = length;
                            length = -1;
                        }
                    } else {
                        length2 = length;
                        length = -1;
                    }
                } else {
                    length = -1;
                    length2 = -1;
                }
                if (length == -1) {
                    int length3 = this.d.length;
                    for (int i3 = this.e + 1; i3 < length3; i3++) {
                        Header2 header3 = this.d[i3];
                        if (header3 == null) {
                            Intrinsics3.throwNpe();
                        }
                        if (Intrinsics3.areEqual(header3.h, byteStringP)) {
                            Header2 header4 = this.d[i3];
                            if (header4 == null) {
                                Intrinsics3.throwNpe();
                            }
                            if (Intrinsics3.areEqual(header4.i, byteString)) {
                                int i4 = i3 - this.e;
                                Hpack hpack2 = Hpack.c;
                                length = Hpack.a.length + i4;
                                break;
                            } else if (length2 == -1) {
                                int i5 = i3 - this.e;
                                Hpack hpack3 = Hpack.c;
                                length2 = i5 + Hpack.a.length;
                            }
                        }
                    }
                }
                if (length != -1) {
                    f(length, Opcodes.LAND, 128);
                } else if (length2 == -1) {
                    this.j.T(64);
                    d(byteStringP);
                    d(byteString);
                    c(header2);
                } else {
                    ByteString byteString2 = Header2.a;
                    Objects.requireNonNull(byteStringP);
                    Intrinsics3.checkParameterIsNotNull(byteString2, "prefix");
                    if (byteStringP.n(0, byteString2, 0, byteString2.j()) && (!Intrinsics3.areEqual(Header2.f, byteStringP))) {
                        f(length2, 15, 0);
                        d(byteString);
                    } else {
                        f(length2, 63, 64);
                        d(byteString);
                        c(header2);
                    }
                }
            }
        }

        public final void f(int i, int i2, int i3) {
            if (i < i2) {
                this.j.T(i | i3);
                return;
            }
            this.j.T(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.j.T(128 | (i4 & Opcodes.LAND));
                i4 >>>= 7;
            }
            this.j.T(i4);
        }
    }

    static {
        Header2 header2 = new Header2(Header2.f, "");
        ByteString byteString = Header2.c;
        ByteString byteString2 = Header2.d;
        ByteString byteString3 = Header2.e;
        ByteString byteString4 = Header2.f3633b;
        Header2[] header2Arr = {header2, new Header2(byteString, ShareTarget.METHOD_GET), new Header2(byteString, ShareTarget.METHOD_POST), new Header2(byteString2, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN), new Header2(byteString2, "/index.html"), new Header2(byteString3, "http"), new Header2(byteString3, Constants.SCHEME), new Header2(byteString4, "200"), new Header2(byteString4, "204"), new Header2(byteString4, "206"), new Header2(byteString4, "304"), new Header2(byteString4, "400"), new Header2(byteString4, "404"), new Header2(byteString4, "500"), new Header2("accept-charset", ""), new Header2("accept-encoding", "gzip, deflate"), new Header2("accept-language", ""), new Header2("accept-ranges", ""), new Header2("accept", ""), new Header2("access-control-allow-origin", ""), new Header2("age", ""), new Header2(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED, ""), new Header2("authorization", ""), new Header2("cache-control", ""), new Header2("content-disposition", ""), new Header2("content-encoding", ""), new Header2("content-language", ""), new Header2("content-length", ""), new Header2("content-location", ""), new Header2("content-range", ""), new Header2("content-type", ""), new Header2("cookie", ""), new Header2("date", ""), new Header2("etag", ""), new Header2("expect", ""), new Header2("expires", ""), new Header2("from", ""), new Header2("host", ""), new Header2("if-match", ""), new Header2("if-modified-since", ""), new Header2("if-none-match", ""), new Header2("if-range", ""), new Header2("if-unmodified-since", ""), new Header2("last-modified", ""), new Header2("link", ""), new Header2(ModelAuditLogEntry.CHANGE_KEY_LOCATION, ""), new Header2("max-forwards", ""), new Header2("proxy-authenticate", ""), new Header2("proxy-authorization", ""), new Header2("range", ""), new Header2("referer", ""), new Header2("refresh", ""), new Header2("retry-after", ""), new Header2("server", ""), new Header2("set-cookie", ""), new Header2("strict-transport-security", ""), new Header2("transfer-encoding", ""), new Header2("user-agent", ""), new Header2("vary", ""), new Header2("via", ""), new Header2("www-authenticate", "")};
        a = header2Arr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(header2Arr.length);
        int length = header2Arr.length;
        for (int i = 0; i < length; i++) {
            Header2[] header2Arr2 = a;
            if (!linkedHashMap.containsKey(header2Arr2[i].h)) {
                linkedHashMap.put(header2Arr2[i].h, Integer.valueOf(i));
            }
        }
        Map<ByteString, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics3.checkExpressionValueIsNotNull(mapUnmodifiableMap, "Collections.unmodifiableMap(result)");
        f3634b = mapUnmodifiableMap;
    }

    public final ByteString a(ByteString byteString) throws IOException {
        Intrinsics3.checkParameterIsNotNull(byteString, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int iJ = byteString.j();
        for (int i = 0; i < iJ; i++) {
            byte b2 = (byte) 65;
            byte b3 = (byte) 90;
            byte bM = byteString.m(i);
            if (b2 <= bM && b3 >= bM) {
                StringBuilder sbU = outline.U("PROTOCOL_ERROR response malformed: mixed case name: ");
                sbU.append(byteString.q());
                throw new IOException(sbU.toString());
            }
        }
        return byteString;
    }
}

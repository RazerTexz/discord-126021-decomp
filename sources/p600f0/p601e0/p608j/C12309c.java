package p600f0.p601e0.p608j;

import androidx.browser.trusted.sharing.ShareTarget;
import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12139j;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p608j.C12322p;
import p615g0.C12388e;
import p615g0.C12401r;
import p615g0.InterfaceC12390g;
import p615g0.InterfaceC12407x;

/* JADX INFO: renamed from: f0.e0.j.c */
/* JADX INFO: compiled from: Hpack.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12309c {

    /* JADX INFO: renamed from: a */
    public static final C12308b[] f25589a;

    /* JADX INFO: renamed from: b */
    public static final Map<ByteString, Integer> f25590b;

    /* JADX INFO: renamed from: c */
    public static final C12309c f25591c = new C12309c();

    /* JADX INFO: renamed from: f0.e0.j.c$a */
    /* JADX INFO: compiled from: Hpack.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final List<C12308b> f25592a;

        /* JADX INFO: renamed from: b */
        public final InterfaceC12390g f25593b;

        /* JADX INFO: renamed from: c */
        public C12308b[] f25594c;

        /* JADX INFO: renamed from: d */
        public int f25595d;

        /* JADX INFO: renamed from: e */
        public int f25596e;

        /* JADX INFO: renamed from: f */
        public int f25597f;

        /* JADX INFO: renamed from: g */
        public final int f25598g;

        /* JADX INFO: renamed from: h */
        public int f25599h;

        public a(InterfaceC12407x interfaceC12407x, int i, int i2, int i3) {
            i2 = (i3 & 4) != 0 ? i : i2;
            C12238m.checkParameterIsNotNull(interfaceC12407x, "source");
            this.f25598g = i;
            this.f25599h = i2;
            this.f25592a = new ArrayList();
            C12238m.checkParameterIsNotNull(interfaceC12407x, "$this$buffer");
            this.f25593b = new C12401r(interfaceC12407x);
            this.f25594c = new C12308b[8];
            this.f25595d = 7;
        }

        /* JADX INFO: renamed from: a */
        public final void m10243a() {
            C12139j.fill$default(this.f25594c, null, 0, 0, 6, null);
            this.f25595d = this.f25594c.length - 1;
            this.f25596e = 0;
            this.f25597f = 0;
        }

        /* JADX INFO: renamed from: b */
        public final int m10244b(int i) {
            return this.f25595d + 1 + i;
        }

        /* JADX INFO: renamed from: c */
        public final int m10245c(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f25594c.length;
                while (true) {
                    length--;
                    i2 = this.f25595d;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    C12308b c12308b = this.f25594c[length];
                    if (c12308b == null) {
                        C12238m.throwNpe();
                    }
                    int i4 = c12308b.f25586g;
                    i -= i4;
                    this.f25597f -= i4;
                    this.f25596e--;
                    i3++;
                }
                C12308b[] c12308bArr = this.f25594c;
                System.arraycopy(c12308bArr, i2 + 1, c12308bArr, i2 + 1 + i3, this.f25596e);
                this.f25595d += i3;
            }
            return i3;
        }

        /* JADX WARN: Code duplicated, block: B:6:0x000d  */
        /* JADX INFO: renamed from: d */
        public final ByteString m10246d(int i) throws IOException {
            boolean z2;
            if (i >= 0) {
                C12309c c12309c = C12309c.f25591c;
                if (i <= C12309c.f25589a.length - 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            if (z2) {
                C12309c c12309c2 = C12309c.f25591c;
                return C12309c.f25589a[i].f25587h;
            }
            C12309c c12309c3 = C12309c.f25591c;
            int iM10244b = m10244b(i - C12309c.f25589a.length);
            if (iM10244b >= 0) {
                C12308b[] c12308bArr = this.f25594c;
                if (iM10244b < c12308bArr.length) {
                    C12308b c12308b = c12308bArr[iM10244b];
                    if (c12308b == null) {
                        C12238m.throwNpe();
                    }
                    return c12308b.f25587h;
                }
            }
            StringBuilder sbM833U = C1643a.m833U("Header index too large ");
            sbM833U.append(i + 1);
            throw new IOException(sbM833U.toString());
        }

        /* JADX INFO: renamed from: e */
        public final void m10247e(int i, C12308b c12308b) {
            this.f25592a.add(c12308b);
            int i2 = c12308b.f25586g;
            if (i != -1) {
                C12308b c12308b2 = this.f25594c[this.f25595d + 1 + i];
                if (c12308b2 == null) {
                    C12238m.throwNpe();
                }
                i2 -= c12308b2.f25586g;
            }
            int i3 = this.f25599h;
            if (i2 > i3) {
                m10243a();
                return;
            }
            int iM10245c = m10245c((this.f25597f + i2) - i3);
            if (i == -1) {
                int i4 = this.f25596e + 1;
                C12308b[] c12308bArr = this.f25594c;
                if (i4 > c12308bArr.length) {
                    C12308b[] c12308bArr2 = new C12308b[c12308bArr.length * 2];
                    System.arraycopy(c12308bArr, 0, c12308bArr2, c12308bArr.length, c12308bArr.length);
                    this.f25595d = this.f25594c.length - 1;
                    this.f25594c = c12308bArr2;
                }
                int i5 = this.f25595d;
                this.f25595d = i5 - 1;
                this.f25594c[i5] = c12308b;
                this.f25596e++;
            } else {
                this.f25594c[this.f25595d + 1 + i + iM10245c + i] = c12308b;
            }
            this.f25597f += i2;
        }

        /* JADX INFO: renamed from: f */
        public final ByteString m10248f() throws IOException {
            byte b2 = this.f25593b.readByte();
            byte[] bArr = C12272c.f25397a;
            int i = b2 & 255;
            int i2 = 0;
            boolean z2 = (i & 128) == 128;
            long jM10249g = m10249g(i, Opcodes.LAND);
            if (!z2) {
                return this.f25593b.mo10461o(jM10249g);
            }
            C12388e c12388e = new C12388e();
            C12322p c12322p = C12322p.f25747d;
            InterfaceC12390g interfaceC12390g = this.f25593b;
            C12238m.checkParameterIsNotNull(interfaceC12390g, "source");
            C12238m.checkParameterIsNotNull(c12388e, "sink");
            C12322p.a aVar = C12322p.f25746c;
            int i3 = 0;
            for (long j = 0; j < jM10249g; j++) {
                byte b3 = interfaceC12390g.readByte();
                byte[] bArr2 = C12272c.f25397a;
                i2 = (i2 << 8) | (b3 & 255);
                i3 += 8;
                while (i3 >= 8) {
                    int i4 = i3 - 8;
                    int i5 = (i2 >>> i4) & 255;
                    C12322p.a[] aVarArr = aVar.f25748a;
                    if (aVarArr == null) {
                        C12238m.throwNpe();
                    }
                    aVar = aVarArr[i5];
                    if (aVar == null) {
                        C12238m.throwNpe();
                    }
                    if (aVar.f25748a == null) {
                        c12388e.m10444T(aVar.f25749b);
                        i3 -= aVar.f25750c;
                        aVar = C12322p.f25746c;
                    } else {
                        i3 = i4;
                    }
                }
            }
            while (i3 > 0) {
                int i6 = (i2 << (8 - i3)) & 255;
                C12322p.a[] aVarArr2 = aVar.f25748a;
                if (aVarArr2 == null) {
                    C12238m.throwNpe();
                }
                C12322p.a aVar2 = aVarArr2[i6];
                if (aVar2 == null) {
                    C12238m.throwNpe();
                }
                if (aVar2.f25748a != null || aVar2.f25750c > i3) {
                    break;
                }
                c12388e.m10444T(aVar2.f25749b);
                i3 -= aVar2.f25750c;
                aVar = C12322p.f25746c;
            }
            return c12388e.m10473x();
        }

        /* JADX INFO: renamed from: g */
        public final int m10249g(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                byte b2 = this.f25593b.readByte();
                byte[] bArr = C12272c.f25397a;
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

        /* JADX INFO: renamed from: a */
        public int f25600a;

        /* JADX INFO: renamed from: b */
        public boolean f25601b;

        /* JADX INFO: renamed from: c */
        public int f25602c;

        /* JADX INFO: renamed from: d */
        public C12308b[] f25603d;

        /* JADX INFO: renamed from: e */
        public int f25604e;

        /* JADX INFO: renamed from: f */
        public int f25605f;

        /* JADX INFO: renamed from: g */
        public int f25606g;

        /* JADX INFO: renamed from: h */
        public int f25607h;

        /* JADX INFO: renamed from: i */
        public final boolean f25608i;

        /* JADX INFO: renamed from: j */
        public final C12388e f25609j;

        public b(int i, boolean z2, C12388e c12388e, int i2) {
            i = (i2 & 1) != 0 ? 4096 : i;
            z2 = (i2 & 2) != 0 ? true : z2;
            C12238m.checkParameterIsNotNull(c12388e, "out");
            this.f25607h = i;
            this.f25608i = z2;
            this.f25609j = c12388e;
            this.f25600a = Integer.MAX_VALUE;
            this.f25602c = i;
            this.f25603d = new C12308b[8];
            this.f25604e = 7;
        }

        /* JADX INFO: renamed from: a */
        public final void m10250a() {
            C12139j.fill$default(this.f25603d, null, 0, 0, 6, null);
            this.f25604e = this.f25603d.length - 1;
            this.f25605f = 0;
            this.f25606g = 0;
        }

        /* JADX INFO: renamed from: b */
        public final int m10251b(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f25603d.length;
                while (true) {
                    length--;
                    i2 = this.f25604e;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    C12308b c12308b = this.f25603d[length];
                    if (c12308b == null) {
                        C12238m.throwNpe();
                    }
                    i -= c12308b.f25586g;
                    int i4 = this.f25606g;
                    C12308b c12308b2 = this.f25603d[length];
                    if (c12308b2 == null) {
                        C12238m.throwNpe();
                    }
                    this.f25606g = i4 - c12308b2.f25586g;
                    this.f25605f--;
                    i3++;
                }
                C12308b[] c12308bArr = this.f25603d;
                System.arraycopy(c12308bArr, i2 + 1, c12308bArr, i2 + 1 + i3, this.f25605f);
                C12308b[] c12308bArr2 = this.f25603d;
                int i5 = this.f25604e;
                Arrays.fill(c12308bArr2, i5 + 1, i5 + 1 + i3, (Object) null);
                this.f25604e += i3;
            }
            return i3;
        }

        /* JADX INFO: renamed from: c */
        public final void m10252c(C12308b c12308b) {
            int i = c12308b.f25586g;
            int i2 = this.f25602c;
            if (i > i2) {
                m10250a();
                return;
            }
            m10251b((this.f25606g + i) - i2);
            int i3 = this.f25605f + 1;
            C12308b[] c12308bArr = this.f25603d;
            if (i3 > c12308bArr.length) {
                C12308b[] c12308bArr2 = new C12308b[c12308bArr.length * 2];
                System.arraycopy(c12308bArr, 0, c12308bArr2, c12308bArr.length, c12308bArr.length);
                this.f25604e = this.f25603d.length - 1;
                this.f25603d = c12308bArr2;
            }
            int i4 = this.f25604e;
            this.f25604e = i4 - 1;
            this.f25603d[i4] = c12308b;
            this.f25605f++;
            this.f25606g += i;
        }

        /* JADX INFO: renamed from: d */
        public final void m10253d(ByteString byteString) throws IOException {
            C12238m.checkParameterIsNotNull(byteString, "data");
            if (this.f25608i) {
                C12322p c12322p = C12322p.f25747d;
                C12238m.checkParameterIsNotNull(byteString, "bytes");
                int iMo10502j = byteString.mo10502j();
                long j = 0;
                for (int i = 0; i < iMo10502j; i++) {
                    byte bMo10505m = byteString.mo10505m(i);
                    byte[] bArr = C12272c.f25397a;
                    j += (long) C12322p.f25745b[bMo10505m & 255];
                }
                if (((int) ((j + ((long) 7)) >> 3)) < byteString.mo10502j()) {
                    C12388e c12388e = new C12388e();
                    C12322p c12322p2 = C12322p.f25747d;
                    C12238m.checkParameterIsNotNull(byteString, "source");
                    C12238m.checkParameterIsNotNull(c12388e, "sink");
                    int iMo10502j2 = byteString.mo10502j();
                    long j2 = 0;
                    int i2 = 0;
                    for (int i3 = 0; i3 < iMo10502j2; i3++) {
                        byte bMo10505m2 = byteString.mo10505m(i3);
                        byte[] bArr2 = C12272c.f25397a;
                        int i4 = bMo10505m2 & 255;
                        int i5 = C12322p.f25744a[i4];
                        byte b2 = C12322p.f25745b[i4];
                        j2 = (j2 << b2) | ((long) i5);
                        i2 += b2;
                        while (i2 >= 8) {
                            i2 -= 8;
                            c12388e.writeByte((int) (j2 >> i2));
                        }
                    }
                    if (i2 > 0) {
                        c12388e.writeByte((int) ((255 >>> i2) | (j2 << (8 - i2))));
                    }
                    ByteString byteStringM10473x = c12388e.m10473x();
                    m10255f(byteStringM10473x.mo10502j(), Opcodes.LAND, 128);
                    this.f25609j.m10439O(byteStringM10473x);
                    return;
                }
            }
            m10255f(byteString.mo10502j(), Opcodes.LAND, 0);
            this.f25609j.m10439O(byteString);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0072  */
        /* JADX INFO: renamed from: e */
        public final void m10254e(List<C12308b> list) throws IOException {
            int length;
            int length2;
            C12238m.checkParameterIsNotNull(list, "headerBlock");
            if (this.f25601b) {
                int i = this.f25600a;
                if (i < this.f25602c) {
                    m10255f(i, 31, 32);
                }
                this.f25601b = false;
                this.f25600a = Integer.MAX_VALUE;
                m10255f(this.f25602c, 31, 32);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                C12308b c12308b = list.get(i2);
                ByteString byteStringMo10508p = c12308b.f25587h.mo10508p();
                ByteString byteString = c12308b.f25588i;
                C12309c c12309c = C12309c.f25591c;
                Integer num = C12309c.f25590b.get(byteStringMo10508p);
                if (num != null) {
                    length = num.intValue() + 1;
                    if (2 <= length && 7 >= length) {
                        C12308b[] c12308bArr = C12309c.f25589a;
                        if (C12238m.areEqual(c12308bArr[length - 1].f25588i, byteString)) {
                            length2 = length;
                        } else if (C12238m.areEqual(c12308bArr[length].f25588i, byteString)) {
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
                    int length3 = this.f25603d.length;
                    for (int i3 = this.f25604e + 1; i3 < length3; i3++) {
                        C12308b c12308b2 = this.f25603d[i3];
                        if (c12308b2 == null) {
                            C12238m.throwNpe();
                        }
                        if (C12238m.areEqual(c12308b2.f25587h, byteStringMo10508p)) {
                            C12308b c12308b3 = this.f25603d[i3];
                            if (c12308b3 == null) {
                                C12238m.throwNpe();
                            }
                            if (C12238m.areEqual(c12308b3.f25588i, byteString)) {
                                int i4 = i3 - this.f25604e;
                                C12309c c12309c2 = C12309c.f25591c;
                                length = C12309c.f25589a.length + i4;
                                break;
                            } else if (length2 == -1) {
                                int i5 = i3 - this.f25604e;
                                C12309c c12309c3 = C12309c.f25591c;
                                length2 = i5 + C12309c.f25589a.length;
                            }
                        }
                    }
                }
                if (length != -1) {
                    m10255f(length, Opcodes.LAND, 128);
                } else if (length2 == -1) {
                    this.f25609j.m10444T(64);
                    m10253d(byteStringMo10508p);
                    m10253d(byteString);
                    m10252c(c12308b);
                } else {
                    ByteString byteString2 = C12308b.f25580a;
                    Objects.requireNonNull(byteStringMo10508p);
                    C12238m.checkParameterIsNotNull(byteString2, "prefix");
                    if (byteStringMo10508p.mo10506n(0, byteString2, 0, byteString2.mo10502j()) && (!C12238m.areEqual(C12308b.f25585f, byteStringMo10508p))) {
                        m10255f(length2, 15, 0);
                        m10253d(byteString);
                    } else {
                        m10255f(length2, 63, 64);
                        m10253d(byteString);
                        m10252c(c12308b);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: f */
        public final void m10255f(int i, int i2, int i3) {
            if (i < i2) {
                this.f25609j.m10444T(i | i3);
                return;
            }
            this.f25609j.m10444T(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f25609j.m10444T(128 | (i4 & Opcodes.LAND));
                i4 >>>= 7;
            }
            this.f25609j.m10444T(i4);
        }
    }

    static {
        C12308b c12308b = new C12308b(C12308b.f25585f, "");
        ByteString byteString = C12308b.f25582c;
        ByteString byteString2 = C12308b.f25583d;
        ByteString byteString3 = C12308b.f25584e;
        ByteString byteString4 = C12308b.f25581b;
        C12308b[] c12308bArr = {c12308b, new C12308b(byteString, ShareTarget.METHOD_GET), new C12308b(byteString, ShareTarget.METHOD_POST), new C12308b(byteString2, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN), new C12308b(byteString2, "/index.html"), new C12308b(byteString3, "http"), new C12308b(byteString3, Constants.SCHEME), new C12308b(byteString4, "200"), new C12308b(byteString4, "204"), new C12308b(byteString4, "206"), new C12308b(byteString4, "304"), new C12308b(byteString4, "400"), new C12308b(byteString4, "404"), new C12308b(byteString4, "500"), new C12308b("accept-charset", ""), new C12308b("accept-encoding", "gzip, deflate"), new C12308b("accept-language", ""), new C12308b("accept-ranges", ""), new C12308b("accept", ""), new C12308b("access-control-allow-origin", ""), new C12308b("age", ""), new C12308b(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED, ""), new C12308b("authorization", ""), new C12308b("cache-control", ""), new C12308b("content-disposition", ""), new C12308b("content-encoding", ""), new C12308b("content-language", ""), new C12308b("content-length", ""), new C12308b("content-location", ""), new C12308b("content-range", ""), new C12308b("content-type", ""), new C12308b("cookie", ""), new C12308b("date", ""), new C12308b("etag", ""), new C12308b("expect", ""), new C12308b("expires", ""), new C12308b("from", ""), new C12308b("host", ""), new C12308b("if-match", ""), new C12308b("if-modified-since", ""), new C12308b("if-none-match", ""), new C12308b("if-range", ""), new C12308b("if-unmodified-since", ""), new C12308b("last-modified", ""), new C12308b("link", ""), new C12308b(ModelAuditLogEntry.CHANGE_KEY_LOCATION, ""), new C12308b("max-forwards", ""), new C12308b("proxy-authenticate", ""), new C12308b("proxy-authorization", ""), new C12308b("range", ""), new C12308b("referer", ""), new C12308b("refresh", ""), new C12308b("retry-after", ""), new C12308b("server", ""), new C12308b("set-cookie", ""), new C12308b("strict-transport-security", ""), new C12308b("transfer-encoding", ""), new C12308b("user-agent", ""), new C12308b("vary", ""), new C12308b("via", ""), new C12308b("www-authenticate", "")};
        f25589a = c12308bArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(c12308bArr.length);
        int length = c12308bArr.length;
        for (int i = 0; i < length; i++) {
            C12308b[] c12308bArr2 = f25589a;
            if (!linkedHashMap.containsKey(c12308bArr2[i].f25587h)) {
                linkedHashMap.put(c12308bArr2[i].f25587h, Integer.valueOf(i));
            }
        }
        Map<ByteString, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        C12238m.checkExpressionValueIsNotNull(mapUnmodifiableMap, "Collections.unmodifiableMap(result)");
        f25590b = mapUnmodifiableMap;
    }

    /* JADX INFO: renamed from: a */
    public final ByteString m10242a(ByteString byteString) throws IOException {
        C12238m.checkParameterIsNotNull(byteString, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int iMo10502j = byteString.mo10502j();
        for (int i = 0; i < iMo10502j; i++) {
            byte b2 = (byte) 65;
            byte b3 = (byte) 90;
            byte bMo10505m = byteString.mo10505m(i);
            if (b2 <= bMo10505m && b3 >= bMo10505m) {
                StringBuilder sbM833U = C1643a.m833U("PROTOCOL_ERROR response malformed: mixed case name: ");
                sbM833U.append(byteString.m11008q());
                throw new IOException(sbM833U.toString());
            }
        }
        return byteString;
    }
}

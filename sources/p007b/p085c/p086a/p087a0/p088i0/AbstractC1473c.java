package p007b.p085c.p086a.p087a0.p088i0;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.ByteString;
import p007b.p100d.p104b.p105a.C1643a;
import p615g0.C12388e;
import p615g0.C12398o;

/* JADX INFO: renamed from: b.c.a.a0.i0.c */
/* JADX INFO: compiled from: JsonReader.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1473c implements Closeable {

    /* JADX INFO: renamed from: j */
    public static final String[] f2236j = new String[128];

    /* JADX INFO: renamed from: k */
    public int f2237k;

    /* JADX INFO: renamed from: l */
    public int[] f2238l = new int[32];

    /* JADX INFO: renamed from: m */
    public String[] f2239m = new String[32];

    /* JADX INFO: renamed from: n */
    public int[] f2240n = new int[32];

    /* JADX INFO: renamed from: b.c.a.a0.i0.c$a */
    /* JADX INFO: compiled from: JsonReader.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final String[] f2241a;

        /* JADX INFO: renamed from: b */
        public final C12398o f2242b;

        public a(String[] strArr, C12398o c12398o) {
            this.f2241a = strArr;
            this.f2242b = c12398o;
        }

        /* JADX WARN: Code duplicated, block: B:19:0x003a A[Catch: IOException -> 0x006b, TryCatch #0 {IOException -> 0x006b, blocks: (B:2:0x0000, B:3:0x000a, B:5:0x000d, B:7:0x001e, B:9:0x0026, B:21:0x0042, B:19:0x003a, B:20:0x003d, B:23:0x0047, B:24:0x004a, B:25:0x0059), top: B:30:0x0000 }] */
        /* JADX INFO: renamed from: a */
        public static a m616a(String... strArr) {
            String str;
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                C12388e c12388e = new C12388e();
                for (int i = 0; i < strArr.length; i++) {
                    String str2 = strArr[i];
                    String[] strArr2 = AbstractC1473c.f2236j;
                    c12388e.m10444T(34);
                    int length = str2.length();
                    int i2 = 0;
                    for (int i3 = 0; i3 < length; i3++) {
                        char cCharAt = str2.charAt(i3);
                        if (cCharAt < 128) {
                            str = strArr2[cCharAt];
                            if (str != null) {
                                if (i2 < i3) {
                                    c12388e.m10453c0(str2, i2, i3);
                                }
                                c12388e.m10452b0(str);
                                i2 = i3 + 1;
                            }
                        } else {
                            if (cCharAt == 8232) {
                                str = "\\u2028";
                            } else if (cCharAt == 8233) {
                                str = "\\u2029";
                            }
                            if (i2 < i3) {
                                c12388e.m10453c0(str2, i2, i3);
                            }
                            c12388e.m10452b0(str);
                            i2 = i3 + 1;
                        }
                    }
                    if (i2 < length) {
                        c12388e.m10453c0(str2, i2, length);
                    }
                    c12388e.m10444T(34);
                    c12388e.readByte();
                    byteStringArr[i] = c12388e.m10473x();
                }
                return new a((String[]) strArr.clone(), C12398o.f26106k.m10491c(byteStringArr));
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* JADX INFO: renamed from: b.c.a.a0.i0.c$b */
    /* JADX INFO: compiled from: JsonReader.java */
    public enum b {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static {
        for (int i = 0; i <= 31; i++) {
            f2236j[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = f2236j;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    /* JADX INFO: renamed from: A */
    public abstract void mo600A() throws IOException;

    /* JADX INFO: renamed from: C */
    public abstract void mo601C() throws IOException;

    /* JADX INFO: renamed from: D */
    public final C1472b m602D(String str) throws C1472b {
        StringBuilder sbM836X = C1643a.m836X(str, " at path ");
        sbM836X.append(getPath());
        throw new C1472b(sbM836X.toString());
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo603a() throws IOException;

    /* JADX INFO: renamed from: b */
    public abstract void mo604b() throws IOException;

    /* JADX INFO: renamed from: c */
    public abstract void mo605c() throws IOException;

    /* JADX INFO: renamed from: d */
    public abstract void mo606d() throws IOException;

    /* JADX INFO: renamed from: e */
    public abstract boolean mo607e() throws IOException;

    /* JADX INFO: renamed from: f */
    public abstract boolean mo608f() throws IOException;

    public final String getPath() {
        int i = this.f2237k;
        int[] iArr = this.f2238l;
        String[] strArr = this.f2239m;
        int[] iArr2 = this.f2240n;
        StringBuilder sbM829Q = C1643a.m829Q('$');
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (i3 == 1 || i3 == 2) {
                sbM829Q.append('[');
                sbM829Q.append(iArr2[i2]);
                sbM829Q.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sbM829Q.append('.');
                if (strArr[i2] != null) {
                    sbM829Q.append(strArr[i2]);
                }
            }
        }
        return sbM829Q.toString();
    }

    /* JADX INFO: renamed from: n */
    public abstract double mo609n() throws IOException;

    /* JADX INFO: renamed from: q */
    public abstract int mo610q() throws IOException;

    /* JADX INFO: renamed from: s */
    public abstract String mo611s() throws IOException;

    /* JADX INFO: renamed from: t */
    public abstract String mo612t() throws IOException;

    /* JADX INFO: renamed from: u */
    public abstract b mo613u() throws IOException;

    /* JADX INFO: renamed from: x */
    public final void m614x(int i) {
        int i2 = this.f2237k;
        int[] iArr = this.f2238l;
        if (i2 == iArr.length) {
            if (i2 == 256) {
                StringBuilder sbM833U = C1643a.m833U("Nesting too deep at ");
                sbM833U.append(getPath());
                throw new C1471a(sbM833U.toString());
            }
            this.f2238l = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f2239m;
            this.f2239m = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.f2240n;
            this.f2240n = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f2238l;
        int i3 = this.f2237k;
        this.f2237k = i3 + 1;
        iArr3[i3] = i;
    }

    /* JADX INFO: renamed from: y */
    public abstract int mo615y(a aVar) throws IOException;
}

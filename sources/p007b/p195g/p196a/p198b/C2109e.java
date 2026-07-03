package p007b.p195g.p196a.p198b;

import com.adjust.sdk.Constants;
import java.io.Serializable;
import java.nio.charset.Charset;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.g.a.b.e */
/* JADX INFO: compiled from: JsonLocation.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2109e implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final C2109e f4478j = new C2109e(null, -1, -1, -1, -1);
    private static final long serialVersionUID = 1;
    public final int _columnNr;
    public final int _lineNr;
    public final long _totalBytes;
    public final long _totalChars;

    /* JADX INFO: renamed from: k */
    public final transient Object f4479k = null;

    public C2109e(Object obj, long j, long j2, int i, int i2) {
        this._totalBytes = j;
        this._totalChars = j2;
        this._lineNr = i;
        this._columnNr = i2;
    }

    /* JADX INFO: renamed from: a */
    public final int m1670a(StringBuilder sb, String str) {
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        return str.length();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof C2109e)) {
            return false;
        }
        C2109e c2109e = (C2109e) obj;
        Object obj2 = this.f4479k;
        if (obj2 == null) {
            if (c2109e.f4479k != null) {
                return false;
            }
        } else if (!obj2.equals(c2109e.f4479k)) {
            return false;
        }
        return this._lineNr == c2109e._lineNr && this._columnNr == c2109e._columnNr && this._totalChars == c2109e._totalChars && this._totalBytes == c2109e._totalBytes;
    }

    public int hashCode() {
        Object obj = this.f4479k;
        return ((((obj == null ? 1 : obj.hashCode()) ^ this._lineNr) + this._columnNr) ^ ((int) this._totalChars)) + ((int) this._totalBytes);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00bb  */
    public String toString() {
        int length;
        int length2;
        StringBuilder sb = new StringBuilder(80);
        sb.append("[Source: ");
        Object obj = this.f4479k;
        if (obj == null) {
            sb.append("UNKNOWN");
        } else {
            Class<?> cls = obj instanceof Class ? (Class) obj : obj.getClass();
            String name = cls.getName();
            if (name.startsWith("java.")) {
                name = cls.getSimpleName();
            } else if (obj instanceof byte[]) {
                name = "byte[]";
            } else if (obj instanceof char[]) {
                name = "char[]";
            }
            sb.append('(');
            sb.append(name);
            sb.append(')');
            int length3 = 0;
            String str = " chars";
            if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                length = charSequence.length();
                length2 = m1670a(sb, charSequence.subSequence(0, Math.min(length, 500)).toString());
            } else {
                if (obj instanceof char[]) {
                    char[] cArr = (char[]) obj;
                    length = cArr.length;
                    String str2 = new String(cArr, 0, Math.min(length, 500));
                    sb.append('\"');
                    sb.append(str2);
                    sb.append('\"');
                    length2 = str2.length();
                } else if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    int iMin = Math.min(bArr.length, 500);
                    String str3 = new String(bArr, 0, iMin, Charset.forName(Constants.ENCODING));
                    sb.append('\"');
                    sb.append(str3);
                    sb.append('\"');
                    str3.length();
                    length3 = bArr.length - iMin;
                    str = " bytes";
                }
                if (length3 > 0) {
                    sb.append("[truncated ");
                    sb.append(length3);
                    sb.append(str);
                    sb.append(']');
                }
            }
            length3 = length - length2;
            if (length3 > 0) {
                sb.append("[truncated ");
                sb.append(length3);
                sb.append(str);
                sb.append(']');
            }
        }
        sb.append("; line: ");
        sb.append(this._lineNr);
        sb.append(", column: ");
        return C1643a.m813A(sb, this._columnNr, ']');
    }
}

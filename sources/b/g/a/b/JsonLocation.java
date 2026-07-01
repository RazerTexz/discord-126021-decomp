package b.g.a.b;

import b.d.b.a.outline;
import com.adjust.sdk.Constants;
import java.io.Serializable;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: b.g.a.b.e, reason: use source file name */
/* JADX INFO: compiled from: JsonLocation.java */
/* JADX INFO: loaded from: classes3.dex */
public class JsonLocation implements Serializable {
    public static final JsonLocation j = new JsonLocation(null, -1, -1, -1, -1);
    private static final long serialVersionUID = 1;
    public final int _columnNr;
    public final int _lineNr;
    public final long _totalBytes;
    public final long _totalChars;
    public final transient Object k = null;

    public JsonLocation(Object obj, long j2, long j3, int i, int i2) {
        this._totalBytes = j2;
        this._totalChars = j3;
        this._lineNr = i;
        this._columnNr = i2;
    }

    public final int a(StringBuilder sb, String str) {
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        return str.length();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof JsonLocation)) {
            return false;
        }
        JsonLocation jsonLocation = (JsonLocation) obj;
        Object obj2 = this.k;
        if (obj2 == null) {
            if (jsonLocation.k != null) {
                return false;
            }
        } else if (!obj2.equals(jsonLocation.k)) {
            return false;
        }
        return this._lineNr == jsonLocation._lineNr && this._columnNr == jsonLocation._columnNr && this._totalChars == jsonLocation._totalChars && this._totalBytes == jsonLocation._totalBytes;
    }

    public int hashCode() {
        Object obj = this.k;
        return ((((obj == null ? 1 : obj.hashCode()) ^ this._lineNr) + this._columnNr) ^ ((int) this._totalChars)) + ((int) this._totalBytes);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00bb  */
    public String toString() {
        int length;
        int length2;
        StringBuilder sb = new StringBuilder(80);
        sb.append("[Source: ");
        Object obj = this.k;
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
                length2 = a(sb, charSequence.subSequence(0, Math.min(length, 500)).toString());
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
        return outline.A(sb, this._columnNr, ']');
    }
}

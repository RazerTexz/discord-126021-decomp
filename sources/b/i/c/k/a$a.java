package b.i.c.k;

import android.os.Bundle;
import androidx.annotation.NonNull;
import b.i.a.f.e.o.f;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public class a$a {
    public final Bundle a = new Bundle();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1660b;
    public String c;
    public String d;
    public String e;

    public a$a(@NonNull String str) {
        this.f1660b = str;
    }

    public a$a a(@NonNull String str, @NonNull String... strArr) {
        Bundle bundle = this.a;
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        if (strArr2.length > 0) {
            int i = 0;
            for (int i2 = 0; i2 < Math.min(strArr2.length, 100); i2++) {
                strArr2[i] = strArr2[i2];
                if (strArr2[i2] == null) {
                    StringBuilder sb = new StringBuilder(59);
                    sb.append("String at ");
                    sb.append(i2);
                    sb.append(" is null and is ignored by put method.");
                    f.x2(sb.toString());
                } else {
                    int i3 = 20000;
                    if (strArr2[i].length() > 20000) {
                        StringBuilder sb2 = new StringBuilder(53);
                        sb2.append("String at ");
                        sb2.append(i2);
                        sb2.append(" is too long, truncating string.");
                        f.x2(sb2.toString());
                        String strSubstring = strArr2[i];
                        if (strSubstring.length() > 20000) {
                            if (Character.isHighSurrogate(strSubstring.charAt(19999)) && Character.isLowSurrogate(strSubstring.charAt(20000))) {
                                i3 = 19999;
                            }
                            strSubstring = strSubstring.substring(0, i3);
                        }
                        strArr2[i] = strSubstring;
                    }
                    i++;
                }
            }
            if (i > 0) {
                Object[] objArrCopyOf = (String[]) Arrays.copyOfRange(strArr2, 0, i);
                if (objArrCopyOf.length >= 100) {
                    f.x2("Input Array of elements is too big, cutting off.");
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, 100);
                }
                bundle.putStringArray(str, (String[]) objArrCopyOf);
            }
        } else {
            f.x2("String array is empty and is ignored by put method.");
        }
        return this;
    }
}

package p007b.p225i.p361c.p365k;

import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.Arrays;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.c.k.a */
/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC4560a {

    /* JADX INFO: renamed from: b.i.c.k.a$a */
    /* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
    public static class a {

        /* JADX INFO: renamed from: a */
        public final Bundle f12163a = new Bundle();

        /* JADX INFO: renamed from: b */
        public final String f12164b;

        /* JADX INFO: renamed from: c */
        public String f12165c;

        /* JADX INFO: renamed from: d */
        public String f12166d;

        /* JADX INFO: renamed from: e */
        public String f12167e;

        public a(@NonNull String str) {
            this.f12164b = str;
        }

        /* JADX INFO: renamed from: a */
        public a m6344a(@NonNull String str, @NonNull String... strArr) {
            Bundle bundle = this.f12163a;
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
                        C3404f.m4362x2(sb.toString());
                    } else {
                        int i3 = 20000;
                        if (strArr2[i].length() > 20000) {
                            StringBuilder sb2 = new StringBuilder(53);
                            sb2.append("String at ");
                            sb2.append(i2);
                            sb2.append(" is too long, truncating string.");
                            C3404f.m4362x2(sb2.toString());
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
                        C3404f.m4362x2("Input Array of elements is too big, cutting off.");
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, 100);
                    }
                    bundle.putStringArray(str, (String[]) objArrCopyOf);
                }
            } else {
                C3404f.m4362x2("String array is empty and is ignored by put method.");
            }
            return this;
        }
    }
}

package f0;

import java.util.Comparator;

/* JADX INFO: compiled from: CipherSuite.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$a implements Comparator<String> {
    /* JADX WARN: Code duplicated, block: B:9:0x002c A[RETURN, SYNTHETIC] */
    @Override // java.util.Comparator
    public int compare(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        d0.z.d.m.checkParameterIsNotNull(str3, "a");
        d0.z.d.m.checkParameterIsNotNull(str4, "b");
        int iMin = Math.min(str3.length(), str4.length());
        for (int i = 4; i < iMin; i++) {
            char cCharAt = str3.charAt(i);
            char cCharAt2 = str4.charAt(i);
            if (cCharAt != cCharAt2) {
                if (cCharAt < cCharAt2) {
                    return -1;
                }
                return 1;
            }
        }
        int length = str3.length();
        int length2 = str4.length();
        if (length == length2) {
            return 0;
        }
        if (length < length2) {
            return -1;
        }
        return 1;
    }
}

package b.g.a.c;

/* JADX INFO: compiled from: PropertyNamingStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class u$b extends u$a {
    @Override // b.g.a.c.u$a
    public String e(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length * 2);
        int i = 0;
        boolean z2 = false;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (i2 > 0 || cCharAt != '_') {
                if (Character.isUpperCase(cCharAt)) {
                    if (!z2 && i > 0 && sb.charAt(i - 1) != '_') {
                        sb.append('_');
                        i++;
                    }
                    cCharAt = Character.toLowerCase(cCharAt);
                    z2 = true;
                } else {
                    z2 = false;
                }
                sb.append(cCharAt);
                i++;
            }
        }
        return i > 0 ? sb.toString() : str;
    }
}

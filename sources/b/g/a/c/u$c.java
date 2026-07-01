package b.g.a.c;

/* JADX INFO: compiled from: PropertyNamingStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class u$c extends u$a {
    @Override // b.g.a.c.u$a
    public String e(String str) {
        char cCharAt;
        char upperCase;
        if (str == null || str.isEmpty() || cCharAt == (upperCase = Character.toUpperCase((cCharAt = str.charAt(0))))) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(0, upperCase);
        return sb.toString();
    }
}

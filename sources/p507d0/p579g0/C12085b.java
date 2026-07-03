package p507d0.p579g0;

/* JADX INFO: renamed from: d0.g0.b */
/* JADX INFO: compiled from: Char.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12085b extends C12084a {
    public static final boolean equals(char c, char c2, boolean z2) {
        if (c == c2) {
            return true;
        }
        if (!z2) {
            return false;
        }
        char upperCase = Character.toUpperCase(c);
        char upperCase2 = Character.toUpperCase(c2);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }
}

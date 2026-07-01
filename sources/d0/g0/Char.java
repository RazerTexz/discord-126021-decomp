package d0.g0;

/* JADX INFO: renamed from: d0.g0.b, reason: use source file name */
/* JADX INFO: compiled from: Char.kt */
/* JADX INFO: loaded from: classes3.dex */
public class Char extends CharJVM {
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

package p615g0.p616z;

/* JADX INFO: renamed from: g0.z.b */
/* JADX INFO: compiled from: ByteString.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12410b {

    /* JADX INFO: renamed from: a */
    public static final char[] f26138a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: a */
    public static final int m10515a(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        char c2 = 'a';
        if ('a' > c || 'f' < c) {
            c2 = 'A';
            if ('A' > c || 'F' < c) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c);
            }
        }
        return (c - c2) + 10;
    }
}

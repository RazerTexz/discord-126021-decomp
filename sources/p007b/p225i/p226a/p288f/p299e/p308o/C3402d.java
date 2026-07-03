package p007b.p225i.p226a.p288f.p299e.p308o;

import androidx.annotation.RecentlyNonNull;

/* JADX INFO: renamed from: b.i.a.f.e.o.d */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3402d {

    /* JADX INFO: renamed from: a */
    public static final char[] f9585a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: b */
    public static final char[] f9586b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @RecentlyNonNull
    /* JADX INFO: renamed from: a */
    public static String m4187a(@RecentlyNonNull byte[] bArr, boolean z2) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (int i = 0; i < length && (!z2 || i != length - 1 || (bArr[i] & 255) != 0); i++) {
            char[] cArr = f9585a;
            sb.append(cArr[(bArr[i] & 240) >>> 4]);
            sb.append(cArr[bArr[i] & 15]);
        }
        return sb.toString();
    }
}

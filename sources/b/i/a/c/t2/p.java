package b.i.a.c.t2;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: AudioCapabilities.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p {
    public static final p a = new p(new int[]{2}, 8);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p f1125b = new p(new int[]{2, 5, 6}, 8);
    public static final int[] c = {5, 6, 18, 17, 14, 7, 8};
    public final int[] d;
    public final int e;

    public p(@Nullable int[] iArr, int i) {
        if (iArr != null) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.d = iArrCopyOf;
            Arrays.sort(iArrCopyOf);
        } else {
            this.d = new int[0];
        }
        this.e = i;
    }

    public boolean a(int i) {
        return Arrays.binarySearch(this.d, i) >= 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return Arrays.equals(this.d, pVar.d) && this.e == pVar.e;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.d) * 31) + this.e;
    }

    public String toString() {
        int i = this.e;
        String string = Arrays.toString(this.d);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i);
        sb.append(", supportedEncodings=");
        sb.append(string);
        sb.append("]");
        return sb.toString();
    }
}

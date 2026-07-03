package p007b.p225i.p226a.p242c.p263t2;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Arrays;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.AbstractC4493a;
import p007b.p225i.p355b.p357b.AbstractC4519n;
import p007b.p225i.p355b.p357b.AbstractC4523p;

/* JADX INFO: renamed from: b.i.a.c.t2.p */
/* JADX INFO: compiled from: AudioCapabilities.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2932p {

    /* JADX INFO: renamed from: a */
    public static final C2932p f7785a = new C2932p(new int[]{2}, 8);

    /* JADX INFO: renamed from: b */
    public static final C2932p f7786b = new C2932p(new int[]{2, 5, 6}, 8);

    /* JADX INFO: renamed from: c */
    public static final int[] f7787c = {5, 6, 18, 17, 14, 7, 8};

    /* JADX INFO: renamed from: d */
    public final int[] f7788d;

    /* JADX INFO: renamed from: e */
    public final int f7789e;

    /* JADX INFO: renamed from: b.i.a.c.t2.p$a */
    /* JADX INFO: compiled from: AudioCapabilities.java */
    @RequiresApi(29)
    public static final class a {
        @DoNotInline
        /* JADX INFO: renamed from: a */
        public static int[] m3496a() {
            AbstractC4493a<Object> abstractC4493a = AbstractC4523p.f12045k;
            C3404f.m4189A(4, "initialCapacity");
            Object[] objArrCopyOf = new Object[4];
            int i = 0;
            boolean z2 = false;
            for (int i2 : C2932p.f7787c) {
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(i2).setSampleRate(48000).build(), new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build())) {
                    Integer numValueOf = Integer.valueOf(i2);
                    Objects.requireNonNull(numValueOf);
                    int i3 = i + 1;
                    if (objArrCopyOf.length < i3) {
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, AbstractC4519n.b.m6260a(objArrCopyOf.length, i3));
                    } else {
                        if (z2) {
                            objArrCopyOf = (Object[]) objArrCopyOf.clone();
                        }
                        objArrCopyOf[i] = numValueOf;
                        i++;
                    }
                    z2 = false;
                    objArrCopyOf[i] = numValueOf;
                    i++;
                }
            }
            Objects.requireNonNull(2);
            int i4 = i + 1;
            if (objArrCopyOf.length < i4) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, AbstractC4519n.b.m6260a(objArrCopyOf.length, i4));
            } else if (z2) {
                objArrCopyOf = (Object[]) objArrCopyOf.clone();
            }
            objArrCopyOf[i] = 2;
            return C3404f.m4333q1(AbstractC4523p.m6262l(objArrCopyOf, i + 1));
        }
    }

    public C2932p(@Nullable int[] iArr, int i) {
        if (iArr != null) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.f7788d = iArrCopyOf;
            Arrays.sort(iArrCopyOf);
        } else {
            this.f7788d = new int[0];
        }
        this.f7789e = i;
    }

    /* JADX INFO: renamed from: a */
    public boolean m3495a(int i) {
        return Arrays.binarySearch(this.f7788d, i) >= 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2932p)) {
            return false;
        }
        C2932p c2932p = (C2932p) obj;
        return Arrays.equals(this.f7788d, c2932p.f7788d) && this.f7789e == c2932p.f7789e;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f7788d) * 31) + this.f7789e;
    }

    public String toString() {
        int i = this.f7789e;
        String string = Arrays.toString(this.f7788d);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i);
        sb.append(", supportedEncodings=");
        sb.append(string);
        sb.append("]");
        return sb.toString();
    }
}

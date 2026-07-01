package b.i.a.c.t2;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.i.b.b.AbstractIndexedListIterator;
import b.i.b.b.ImmutableCollection;
import b.i.b.b.ImmutableList2;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.t2.p, reason: use source file name */
/* JADX INFO: compiled from: AudioCapabilities.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AudioCapabilities {
    public static final AudioCapabilities a = new AudioCapabilities(new int[]{2}, 8);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AudioCapabilities f1125b = new AudioCapabilities(new int[]{2, 5, 6}, 8);
    public static final int[] c = {5, 6, 18, 17, 14, 7, 8};
    public final int[] d;
    public final int e;

    /* JADX INFO: renamed from: b.i.a.c.t2.p$a */
    /* JADX INFO: compiled from: AudioCapabilities.java */
    @RequiresApi(29)
    public static final class a {
        @DoNotInline
        public static int[] a() {
            AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
            b.i.a.f.e.o.f.A(4, "initialCapacity");
            Object[] objArrCopyOf = new Object[4];
            int i = 0;
            boolean z2 = false;
            for (int i2 : AudioCapabilities.c) {
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(i2).setSampleRate(48000).build(), new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build())) {
                    Integer numValueOf = Integer.valueOf(i2);
                    Objects.requireNonNull(numValueOf);
                    int i3 = i + 1;
                    if (objArrCopyOf.length < i3) {
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, ImmutableCollection.b.a(objArrCopyOf.length, i3));
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
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, ImmutableCollection.b.a(objArrCopyOf.length, i4));
            } else if (z2) {
                objArrCopyOf = (Object[]) objArrCopyOf.clone();
            }
            objArrCopyOf[i] = 2;
            return b.i.a.f.e.o.f.q1(ImmutableList2.l(objArrCopyOf, i + 1));
        }
    }

    public AudioCapabilities(@Nullable int[] iArr, int i) {
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
        if (!(obj instanceof AudioCapabilities)) {
            return false;
        }
        AudioCapabilities audioCapabilities = (AudioCapabilities) obj;
        return Arrays.equals(this.d, audioCapabilities.d) && this.e == audioCapabilities.e;
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

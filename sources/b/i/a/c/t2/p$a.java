package b.i.a.c.t2;

import android.media.AudioAttributes$Builder;
import android.media.AudioFormat$Builder;
import android.media.AudioTrack;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: AudioCapabilities.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(29)
public final class p$a {
    @DoNotInline
    public static int[] a() {
        b.i.b.b.a<Object> aVar = b.i.b.b.p.k;
        b.i.a.f.e.o.f.A(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        int i = 0;
        boolean z2 = false;
        for (int i2 : p.c) {
            if (AudioTrack.isDirectPlaybackSupported(new AudioFormat$Builder().setChannelMask(12).setEncoding(i2).setSampleRate(48000).build(), new AudioAttributes$Builder().setUsage(1).setContentType(3).setFlags(0).build())) {
                Integer numValueOf = Integer.valueOf(i2);
                Objects.requireNonNull(numValueOf);
                int i3 = i + 1;
                if (objArrCopyOf.length < i3) {
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, b.i.b.b.n$b.a(objArrCopyOf.length, i3));
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
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, b.i.b.b.n$b.a(objArrCopyOf.length, i4));
        } else if (z2) {
            objArrCopyOf = (Object[]) objArrCopyOf.clone();
        }
        objArrCopyOf[i] = 2;
        return b.i.a.f.e.o.f.q1(b.i.b.b.p.l(objArrCopyOf, i + 1));
    }
}

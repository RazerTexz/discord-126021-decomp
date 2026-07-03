package p007b.p225i.p226a.p288f.p299e.p304k;

import android.content.Context;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.C3256c;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;

/* JADX INFO: renamed from: b.i.a.f.e.k.r */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3377r {

    /* JADX INFO: renamed from: a */
    public final SparseIntArray f9551a = new SparseIntArray();

    /* JADX INFO: renamed from: b */
    public C3256c f9552b;

    public C3377r(@NonNull C3256c c3256c) {
        Objects.requireNonNull(c3256c, "null reference");
        this.f9552b = c3256c;
    }

    /* JADX INFO: renamed from: a */
    public final int m4175a(@NonNull Context context, @NonNull C3266a.f fVar) {
        Objects.requireNonNull(context, "null reference");
        Objects.requireNonNull(fVar, "null reference");
        int iMo4018b = 0;
        if (!fVar.mo4039k()) {
            return 0;
        }
        int iMo3982l = fVar.mo3982l();
        int i = this.f9551a.get(iMo3982l, -1);
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.f9551a.size()) {
                iMo4018b = i;
                break;
            }
            int iKeyAt = this.f9551a.keyAt(i2);
            if (iKeyAt > iMo3982l && this.f9551a.get(iKeyAt) == 0) {
                break;
            }
            i2++;
        }
        if (iMo4018b == -1) {
            iMo4018b = this.f9552b.mo4018b(context, iMo3982l);
        }
        this.f9551a.put(iMo3982l, iMo4018b);
        return iMo4018b;
    }
}

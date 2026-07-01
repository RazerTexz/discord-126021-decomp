package b.b.a.d;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.os.CancellationSignal;
import androidx.annotation.RequiresApi;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: ThumbnailViewHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(29)
public final class i$b {
    public Job a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CancellationSignal f321b;
    public Bitmap c;
    public final ContentResolver d;

    public i$b(ContentResolver contentResolver) {
        d0.z.d.m.checkNotNullParameter(contentResolver, "contentResolver");
        this.d = contentResolver;
    }

    public final void a() {
        if (i$a.a(i.m)) {
            Job job = this.a;
            if (job != null) {
                b.i.a.f.e.o.f.t(job, null, 1, null);
            }
            CancellationSignal cancellationSignal = this.f321b;
            if (cancellationSignal != null) {
                cancellationSignal.cancel();
            }
        }
        Bitmap bitmap = this.c;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.c = null;
    }
}

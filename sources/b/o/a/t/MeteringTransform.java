package b.o.a.t;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.t.c, reason: use source file name */
/* JADX INFO: compiled from: MeteringTransform.java */
/* JADX INFO: loaded from: classes3.dex */
public interface MeteringTransform<T> {
    @NonNull
    T a(@NonNull RectF rectF, int i);

    @NonNull
    PointF b(@NonNull PointF pointF);
}

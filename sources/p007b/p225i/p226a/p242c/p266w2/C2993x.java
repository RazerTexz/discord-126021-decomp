package p007b.p225i.p226a.p242c.p266w2;

import android.media.MediaDrmResetException;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: renamed from: b.i.a.c.w2.x */
/* JADX INFO: compiled from: DrmUtil.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(23)
public final class C2993x {
    @DoNotInline
    /* JADX INFO: renamed from: a */
    public static boolean m3605a(@Nullable Throwable th) {
        return th instanceof MediaDrmResetException;
    }
}

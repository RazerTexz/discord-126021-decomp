package b.i.a.c.w2;

import android.media.MediaDrmResetException;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: renamed from: b.i.a.c.w2.x, reason: use source file name */
/* JADX INFO: compiled from: DrmUtil.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(23)
public final class DrmUtil3 {
    @DoNotInline
    public static boolean a(@Nullable Throwable th) {
        return th instanceof MediaDrmResetException;
    }
}

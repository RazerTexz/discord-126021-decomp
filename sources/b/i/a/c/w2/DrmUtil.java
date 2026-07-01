package b.i.a.c.w2;

import android.media.DeniedByServerException;
import android.media.NotProvisionedException;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: renamed from: b.i.a.c.w2.v, reason: use source file name */
/* JADX INFO: compiled from: DrmUtil.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(18)
public final class DrmUtil {
    @DoNotInline
    public static boolean a(@Nullable Throwable th) {
        return th instanceof DeniedByServerException;
    }

    @DoNotInline
    public static boolean b(@Nullable Throwable th) {
        return th instanceof NotProvisionedException;
    }
}

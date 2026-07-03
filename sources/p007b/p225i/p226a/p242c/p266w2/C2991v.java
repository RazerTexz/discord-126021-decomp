package p007b.p225i.p226a.p242c.p266w2;

import android.media.DeniedByServerException;
import android.media.NotProvisionedException;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: renamed from: b.i.a.c.w2.v */
/* JADX INFO: compiled from: DrmUtil.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(18)
public final class C2991v {
    @DoNotInline
    /* JADX INFO: renamed from: a */
    public static boolean m3601a(@Nullable Throwable th) {
        return th instanceof DeniedByServerException;
    }

    @DoNotInline
    /* JADX INFO: renamed from: b */
    public static boolean m3602b(@Nullable Throwable th) {
        return th instanceof NotProvisionedException;
    }
}

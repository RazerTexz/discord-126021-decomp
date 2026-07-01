package b.i.a.c.w2;

import android.media.MediaDrm$MediaDrmStateException;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Objects;

/* JADX INFO: compiled from: DrmUtil.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public final class w {
    @DoNotInline
    public static boolean a(@Nullable Throwable th) {
        return th instanceof MediaDrm$MediaDrmStateException;
    }

    @DoNotInline
    public static int b(Throwable th) {
        String[] strArrSplit;
        int length;
        String diagnosticInfo = ((MediaDrm$MediaDrmStateException) th).getDiagnosticInfo();
        int i = b.i.a.c.f3.e0.a;
        int i2 = 0;
        if (diagnosticInfo != null && (length = (strArrSplit = diagnosticInfo.split("_", -1)).length) >= 2) {
            String str = strArrSplit[length - 1];
            boolean z2 = length >= 3 && "neg".equals(strArrSplit[length - 2]);
            try {
                Objects.requireNonNull(str);
                i2 = Integer.parseInt(str);
                if (z2) {
                    i2 = -i2;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return b.i.a.c.f3.e0.p(i2);
    }
}

package b.i.a.c.w2;

import android.media.UnsupportedSchemeException;
import android.util.Log;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import java.util.UUID;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class n implements a0$c {
    public static final /* synthetic */ n a = new n();

    @Override // b.i.a.c.w2.a0$c
    public final a0 a(UUID uuid) {
        int i = c0.a;
        try {
            try {
                return new c0(uuid);
            } catch (UnsupportedDrmException unused) {
                String strValueOf = String.valueOf(uuid);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 53);
                sb.append("Failed to instantiate a FrameworkMediaDrm for uuid: ");
                sb.append(strValueOf);
                sb.append(".");
                Log.e("FrameworkMediaDrm", sb.toString());
                return new y();
            }
        } catch (UnsupportedSchemeException e) {
            throw new UnsupportedDrmException(1, e);
        } catch (Exception e2) {
            throw new UnsupportedDrmException(2, e2);
        }
    }
}

package b.o.a;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: CameraLogger.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$a implements b$b {
    @Override // b.o.a.b$b
    public void a(int i, @NonNull String str, @NonNull String str2, @Nullable Throwable th) {
        if (i == 0) {
            Log.v(str, str2, th);
            return;
        }
        if (i == 1) {
            Log.i(str, str2, th);
        } else if (i == 2) {
            Log.w(str, str2, th);
        } else {
            if (i != 3) {
                return;
            }
            Log.e(str, str2, th);
        }
    }
}

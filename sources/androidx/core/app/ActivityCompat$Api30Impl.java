package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.LocusIdCompat;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(30)
public class ActivityCompat$Api30Impl {
    private ActivityCompat$Api30Impl() {
    }

    public static void setLocusContext(@NonNull Activity activity, @Nullable LocusIdCompat locusIdCompat, @Nullable Bundle bundle) {
        activity.setLocusContext(locusIdCompat == null ? null : locusIdCompat.toLocusId(), bundle);
    }
}

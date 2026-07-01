package androidx.core.content;

import android.content.LocusId;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
public class LocusIdCompat$Api29Impl {
    private LocusIdCompat$Api29Impl() {
    }

    @NonNull
    public static LocusId create(@NonNull String str) {
        return new LocusId(str);
    }

    @NonNull
    public static String getId(@NonNull LocusId locusId) {
        return locusId.getId();
    }
}

package androidx.core.content.res;

import android.content.res.Resources;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
public class ResourcesCompat$ImplApi29 {
    private ResourcesCompat$ImplApi29() {
    }

    public static float getFloat(@NonNull Resources resources, @DimenRes int i) {
        return resources.getFloat(i);
    }
}

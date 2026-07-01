package androidx.core.content;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(30)
public class ContextCompat$Api30Impl {
    private ContextCompat$Api30Impl() {
    }

    @DoNotInline
    public static String getAttributionTag(Context context) {
        return context.getAttributionTag();
    }
}

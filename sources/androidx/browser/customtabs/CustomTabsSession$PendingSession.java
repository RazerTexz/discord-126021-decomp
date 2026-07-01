package androidx.browser.customtabs;

import android.app.PendingIntent;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY})
public class CustomTabsSession$PendingSession {

    @Nullable
    private final CustomTabsCallback mCallback;

    @Nullable
    private final PendingIntent mId;

    public CustomTabsSession$PendingSession(@Nullable CustomTabsCallback customTabsCallback, @Nullable PendingIntent pendingIntent) {
        this.mCallback = customTabsCallback;
        this.mId = pendingIntent;
    }

    @Nullable
    public CustomTabsCallback getCallback() {
        return this.mCallback;
    }

    @Nullable
    public PendingIntent getId() {
        return this.mId;
    }
}

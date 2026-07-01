package y.a.a;

import android.os.IBinder$DeathRecipient;
import androidx.browser.customtabs.CustomTabsService$1;
import androidx.browser.customtabs.CustomTabsSessionToken;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements IBinder$DeathRecipient {
    public final /* synthetic */ CustomTabsService$1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CustomTabsSessionToken f3856b;

    public /* synthetic */ a(CustomTabsService$1 customTabsService$1, CustomTabsSessionToken customTabsSessionToken) {
        this.a = customTabsService$1;
        this.f3856b = customTabsSessionToken;
    }

    @Override // android.os.IBinder$DeathRecipient
    public final void binderDied() {
        CustomTabsService$1 customTabsService$1 = this.a;
        customTabsService$1.this$0.cleanUpSession(this.f3856b);
    }
}

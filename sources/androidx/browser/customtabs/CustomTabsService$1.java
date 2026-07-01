package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import x.a.a.a;
import x.a.a.b$a;

/* JADX INFO: loaded from: classes.dex */
public class CustomTabsService$1 extends b$a {
    public final /* synthetic */ CustomTabsService this$0;

    public CustomTabsService$1(CustomTabsService customTabsService) {
        this.this$0 = customTabsService;
    }

    @Nullable
    private PendingIntent getSessionIdFromBundle(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(CustomTabsIntent.EXTRA_SESSION_ID);
        bundle.remove(CustomTabsIntent.EXTRA_SESSION_ID);
        return pendingIntent;
    }

    private boolean newSessionInternal(@NonNull a aVar, @Nullable PendingIntent pendingIntent) {
        CustomTabsSessionToken customTabsSessionToken = new CustomTabsSessionToken(aVar, pendingIntent);
        try {
            y.a.a.a aVar2 = new y.a.a.a(this, customTabsSessionToken);
            synchronized (this.this$0.mDeathRecipientMap) {
                aVar.asBinder().linkToDeath(aVar2, 0);
                this.this$0.mDeathRecipientMap.put(aVar.asBinder(), aVar2);
            }
            return this.this$0.newSession(customTabsSessionToken);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // x.a.a.b
    public Bundle extraCommand(@NonNull String str, @Nullable Bundle bundle) {
        return this.this$0.extraCommand(str, bundle);
    }

    @Override // x.a.a.b
    public boolean mayLaunchUrl(@Nullable a aVar, @Nullable Uri uri, @Nullable Bundle bundle, @Nullable List<Bundle> list) {
        return this.this$0.mayLaunchUrl(new CustomTabsSessionToken(aVar, getSessionIdFromBundle(bundle)), uri, bundle, list);
    }

    @Override // x.a.a.b
    public boolean newSession(@NonNull a aVar) {
        return newSessionInternal(aVar, null);
    }

    @Override // x.a.a.b
    public boolean newSessionWithExtras(@NonNull a aVar, @Nullable Bundle bundle) {
        return newSessionInternal(aVar, getSessionIdFromBundle(bundle));
    }

    @Override // x.a.a.b
    public int postMessage(@NonNull a aVar, @NonNull String str, @Nullable Bundle bundle) {
        return this.this$0.postMessage(new CustomTabsSessionToken(aVar, getSessionIdFromBundle(bundle)), str, bundle);
    }

    @Override // x.a.a.b
    public boolean receiveFile(@NonNull a aVar, @NonNull Uri uri, int i, @Nullable Bundle bundle) {
        return this.this$0.receiveFile(new CustomTabsSessionToken(aVar, getSessionIdFromBundle(bundle)), uri, i, bundle);
    }

    @Override // x.a.a.b
    public boolean requestPostMessageChannel(@NonNull a aVar, @NonNull Uri uri) {
        return this.this$0.requestPostMessageChannel(new CustomTabsSessionToken(aVar, null), uri);
    }

    @Override // x.a.a.b
    public boolean requestPostMessageChannelWithExtras(@NonNull a aVar, @NonNull Uri uri, @NonNull Bundle bundle) {
        return this.this$0.requestPostMessageChannel(new CustomTabsSessionToken(aVar, getSessionIdFromBundle(bundle)), uri);
    }

    @Override // x.a.a.b
    public boolean updateVisuals(@NonNull a aVar, @Nullable Bundle bundle) {
        return this.this$0.updateVisuals(new CustomTabsSessionToken(aVar, getSessionIdFromBundle(bundle)), bundle);
    }

    @Override // x.a.a.b
    public boolean validateRelationship(@NonNull a aVar, int i, @NonNull Uri uri, @Nullable Bundle bundle) {
        return this.this$0.validateRelationship(new CustomTabsSessionToken(aVar, getSessionIdFromBundle(bundle)), i, uri, bundle);
    }

    @Override // x.a.a.b
    public boolean warmup(long j) {
        return this.this$0.warmup(j);
    }
}

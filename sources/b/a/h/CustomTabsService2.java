package b.a.h;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.a.h.d, reason: use source file name */
/* JADX INFO: compiled from: CustomTabsService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CustomTabsService2 extends CustomTabsServiceConnection {
    public final List<Uri> j;

    /* JADX WARN: Multi-variable type inference failed */
    public CustomTabsService2(List<? extends Uri> list) {
        Intrinsics3.checkNotNullParameter(list, "uris");
        this.j = list;
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        Intrinsics3.checkNotNullParameter(componentName, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(customTabsClient, "client");
        customTabsClient.warmup(0L);
        CustomTabsSession customTabsSessionNewSession = customTabsClient.newSession(new CustomTabsCallback());
        if (customTabsSessionNewSession != null) {
            Uri uri = (Uri) _Collections.first((List) this.j);
            List<Uri> listDrop = _Collections.drop(this.j, 1);
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listDrop, 10));
            for (Uri uri2 : listDrop) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(CustomTabsService.KEY_URL, uri2);
                arrayList.add(bundle);
            }
            customTabsSessionNewSession.mayLaunchUrl(uri, Bundle.EMPTY, arrayList);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}

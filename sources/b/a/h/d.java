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
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: CustomTabsService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d extends CustomTabsServiceConnection {
    public final List<Uri> j;

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<? extends Uri> list) {
        m.checkNotNullParameter(list, "uris");
        this.j = list;
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        m.checkNotNullParameter(componentName, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(customTabsClient, "client");
        customTabsClient.warmup(0L);
        CustomTabsSession customTabsSessionNewSession = customTabsClient.newSession(new CustomTabsCallback());
        if (customTabsSessionNewSession != null) {
            Uri uri = (Uri) u.first((List) this.j);
            List<Uri> listDrop = u.drop(this.j, 1);
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listDrop, 10));
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

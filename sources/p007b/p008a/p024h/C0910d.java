package p007b.p008a.p024h;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.List;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.h.d */
/* JADX INFO: compiled from: CustomTabsService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0910d extends CustomTabsServiceConnection {

    /* JADX INFO: renamed from: j */
    public final List<Uri> f653j;

    /* JADX WARN: Multi-variable type inference failed */
    public C0910d(List<? extends Uri> list) {
        C12238m.checkNotNullParameter(list, "uris");
        this.f653j = list;
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        C12238m.checkNotNullParameter(componentName, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(customTabsClient, "client");
        customTabsClient.warmup(0L);
        CustomTabsSession customTabsSessionNewSession = customTabsClient.newSession(new CustomTabsCallback());
        if (customTabsSessionNewSession != null) {
            Uri uri = (Uri) C12163u.first((List) this.f653j);
            List<Uri> listDrop = C12163u.drop(this.f653j, 1);
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listDrop, 10));
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

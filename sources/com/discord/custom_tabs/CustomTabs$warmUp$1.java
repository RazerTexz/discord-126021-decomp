package com.discord.custom_tabs;

import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.view.DefaultLifecycleObserver;
import androidx.view.LifecycleOwner;
import java.util.List;
import p007b.p008a.p024h.C0908b;
import p007b.p008a.p024h.C0909c;
import p007b.p008a.p024h.C0910d;
import p507d0.p580t.C12141k;
import p507d0.p592z.p594d.C12238m;
import p677y.p685c.C13195a;

/* JADX INFO: compiled from: CustomTabs.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CustomTabs$warmUp$1 implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public CustomTabsServiceConnection connection;

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        C13195a.m11359a(this, lifecycleOwner);
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        C13195a.m11360b(this, lifecycleOwner);
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        C12238m.checkNotNullParameter(owner, "owner");
        C13195a.m11361c(this, owner);
        if (this.connection != null) {
            throw null;
        }
        this.connection = null;
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        C12238m.checkNotNullParameter(owner, "owner");
        C13195a.m11362d(this, owner);
        C0910d c0910d = null;
        List list = C12141k.toList((Object[]) null);
        C12238m.checkNotNullParameter(null, "context");
        C12238m.checkNotNullParameter(list, "uris");
        String strM194a = C0909c.f652a.m194a(null, C0908b.f651j);
        if (strM194a != null) {
            C0910d c0910d2 = new C0910d(list);
            if (CustomTabsClient.bindCustomTabsService(null, strM194a, c0910d2)) {
                c0910d = c0910d2;
            }
        }
        this.connection = c0910d;
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        C13195a.m11363e(this, lifecycleOwner);
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        C13195a.m11364f(this, lifecycleOwner);
    }
}

package com.discord.widgets.friends;

import b.i.a.f.j.b.c;
import com.discord.utilities.analytics.AnalyticsTracker;
import java.util.HashSet;

/* JADX INFO: compiled from: NearbyManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NearbyManager$buildClient$$inlined$also$lambda$1 extends c {
    public final /* synthetic */ NearbyManager this$0;

    public NearbyManager$buildClient$$inlined$also$lambda$1(NearbyManager nearbyManager) {
        this.this$0 = nearbyManager;
    }

    @Override // b.i.a.f.j.b.c
    public void onPermissionChanged(boolean permissionGranted) {
        super.onPermissionChanged(permissionGranted);
        if (!permissionGranted) {
            NearbyManager.access$getNearbyStateSubject$p(this.this$0).onNext(new NearbyManager$NearbyState$Disconnected(98));
        } else {
            AnalyticsTracker.nearbyConnected();
            NearbyManager.access$getNearbyStateSubject$p(this.this$0).onNext(new NearbyManager$NearbyState$Connected(new HashSet(NearbyManager.access$getNearbyUserIds$p(this.this$0))));
        }
    }
}

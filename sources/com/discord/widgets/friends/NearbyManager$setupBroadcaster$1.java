package com.discord.widgets.friends;

import b.i.a.f.j.b.b;

/* JADX INFO: compiled from: NearbyManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NearbyManager$setupBroadcaster$1 extends b {
    public final /* synthetic */ NearbyManager this$0;

    public NearbyManager$setupBroadcaster$1(NearbyManager nearbyManager) {
        this.this$0 = nearbyManager;
    }

    @Override // b.i.a.f.j.b.b
    public void onExpired() {
        super.onExpired();
        this.this$0.activateNearby();
    }
}

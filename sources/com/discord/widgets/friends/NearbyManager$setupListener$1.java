package com.discord.widgets.friends;

import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;

/* JADX INFO: compiled from: NearbyManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NearbyManager$setupListener$1 extends MessageListener {
    public final /* synthetic */ NearbyManager this$0;

    public NearbyManager$setupListener$1(NearbyManager nearbyManager) {
        this.this$0 = nearbyManager;
    }

    @Override // com.google.android.gms.nearby.messages.MessageListener
    public void onFound(Message message) {
        Long lAccess$parseUserId;
        super.onFound(message);
        if (message == null || (lAccess$parseUserId = NearbyManager.access$parseUserId(this.this$0, message)) == null) {
            return;
        }
        NearbyManager.access$foundUserId(this.this$0, lAccess$parseUserId.longValue());
    }

    @Override // com.google.android.gms.nearby.messages.MessageListener
    public void onLost(Message message) {
        Long lAccess$parseUserId;
        super.onLost(message);
        if (message == null || (lAccess$parseUserId = NearbyManager.access$parseUserId(this.this$0, message)) == null) {
            return;
        }
        NearbyManager.access$lostUserId(this.this$0, lAccess$parseUserId.longValue());
    }
}

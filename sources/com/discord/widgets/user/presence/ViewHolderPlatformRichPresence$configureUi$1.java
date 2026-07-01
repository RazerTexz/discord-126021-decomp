package com.discord.widgets.user.presence;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.analytics.Traits$Location$Obj;
import com.discord.utilities.platform.Platform;
import d0.z.d.m;

/* JADX INFO: compiled from: ViewHolderPlatformRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewHolderPlatformRichPresence$configureUi$1 implements View$OnClickListener {
    public final /* synthetic */ Platform $platform;
    public final /* synthetic */ StoreUserConnections $userConnectionStore;

    public ViewHolderPlatformRichPresence$configureUi$1(StoreUserConnections storeUserConnections, Platform platform) {
        this.$userConnectionStore = storeUserConnections;
        this.$platform = platform;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StoreUserConnections storeUserConnections = this.$userConnectionStore;
        String platformId = this.$platform.getPlatformId();
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        storeUserConnections.authorizeConnection(platformId, context, Traits$Location$Obj.ACTIVITY_ACTION);
    }
}

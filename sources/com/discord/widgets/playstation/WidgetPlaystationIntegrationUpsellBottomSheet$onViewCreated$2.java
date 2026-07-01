package com.discord.widgets.playstation;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.analytics.Traits$Location$Section;
import com.discord.utilities.platform.Platform;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetPlaystationIntegrationUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPlaystationIntegrationUpsellBottomSheet$onViewCreated$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetPlaystationIntegrationUpsellBottomSheet this$0;

    public WidgetPlaystationIntegrationUpsellBottomSheet$onViewCreated$2(WidgetPlaystationIntegrationUpsellBottomSheet widgetPlaystationIntegrationUpsellBottomSheet) {
        this.this$0 = widgetPlaystationIntegrationUpsellBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetPlaystationIntegrationUpsellBottomSheet.access$logConfirm(this.this$0);
        StoreUserConnections userConnections = StoreStream.Companion.getUserConnections();
        String platformId = Platform.PLAYSTATION.getPlatformId();
        FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
        m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        userConnections.authorizeConnection(platformId, fragmentActivityRequireActivity, Traits$Location$Section.PLAYSTATION_UPSELL);
        this.this$0.dismiss();
    }
}

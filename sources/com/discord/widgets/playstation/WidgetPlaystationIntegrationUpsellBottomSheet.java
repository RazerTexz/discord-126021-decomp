package com.discord.widgets.playstation;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetPlaystationUpsellBottomSheetBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetPlaystationIntegrationUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPlaystationIntegrationUpsellBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetPlaystationIntegrationUpsellBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPlaystationUpsellBottomSheetBinding;", 0)};
    public static final WidgetPlaystationIntegrationUpsellBottomSheet$Companion Companion = new WidgetPlaystationIntegrationUpsellBottomSheet$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetPlaystationIntegrationUpsellBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetPlaystationIntegrationUpsellBottomSheet$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$logConfirm(WidgetPlaystationIntegrationUpsellBottomSheet widgetPlaystationIntegrationUpsellBottomSheet) {
        widgetPlaystationIntegrationUpsellBottomSheet.logConfirm();
    }

    private final WidgetPlaystationUpsellBottomSheetBinding getBinding() {
        return (WidgetPlaystationUpsellBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void logConfirm() {
        AnalyticsTracker.INSTANCE.trackAccountLinkStep(Platform.PLAYSTATION.getPlatformId(), "playstation_connect_upsell");
    }

    private final void logDismiss() {
        AnalyticsTracker.INSTANCE.trackDismissibleContentDismissed("PLAYSTATION_CONNECT_UPSELL");
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_playstation_upsell_bottom_sheet;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface$OnCancelListener
    public void onCancel(DialogInterface dialog) {
        m.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        logDismiss();
    }

    @Override // com.discord.app.AppBottomSheet
    public void onStateChanged(int state) {
        super.onStateChanged(state);
        if (state == 5) {
            logDismiss();
        }
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.upsellHeader");
        textView.setText(b.e(this, 2131896723, new Object[0], WidgetPlaystationIntegrationUpsellBottomSheet$onViewCreated$1.INSTANCE));
        getBinding().c.setOnClickListener(new WidgetPlaystationIntegrationUpsellBottomSheet$onViewCreated$2(this));
        getBinding().f2511b.setOnClickListener(new WidgetPlaystationIntegrationUpsellBottomSheet$onViewCreated$3(this));
    }
}

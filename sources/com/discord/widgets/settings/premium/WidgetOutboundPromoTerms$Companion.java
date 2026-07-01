package com.discord.widgets.settings.premium;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetOutboundPromoTerms.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOutboundPromoTerms$Companion {
    private WidgetOutboundPromoTerms$Companion() {
    }

    public final void show(String content, FragmentManager fragmentManager) {
        m.checkNotNullParameter(content, "content");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetOutboundPromoTerms widgetOutboundPromoTerms = new WidgetOutboundPromoTerms();
        Bundle bundle = new Bundle();
        bundle.putString("ARG_CONTENT", content);
        widgetOutboundPromoTerms.setArguments(bundle);
        widgetOutboundPromoTerms.show(fragmentManager, WidgetOutboundPromoTerms.class.getName());
    }

    public /* synthetic */ WidgetOutboundPromoTerms$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

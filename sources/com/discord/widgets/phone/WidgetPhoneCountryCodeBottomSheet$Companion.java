package com.discord.widgets.phone;

import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPhoneCountryCodeBottomSheet$Companion {
    private WidgetPhoneCountryCodeBottomSheet$Companion() {
    }

    public final void show(FragmentManager context) {
        m.checkNotNullParameter(context, "context");
        new WidgetPhoneCountryCodeBottomSheet().show(context, WidgetPhoneCountryCodeBottomSheet.class.getName());
    }

    public /* synthetic */ WidgetPhoneCountryCodeBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

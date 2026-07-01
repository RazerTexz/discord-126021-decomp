package com.discord.widgets.guild_role_subscriptions;

import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import d0.o;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetPriceTierPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPriceTierPickerBottomSheet$Companion {
    private WidgetPriceTierPickerBottomSheet$Companion() {
    }

    public final void launch(Fragment fragment, String requestKey) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(requestKey, "requestKey");
        WidgetPriceTierPickerBottomSheet widgetPriceTierPickerBottomSheet = new WidgetPriceTierPickerBottomSheet();
        widgetPriceTierPickerBottomSheet.setArguments(BundleKt.bundleOf(o.to("INTENT_EXTRA_REQUEST_CODE", requestKey)));
        FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
        widgetPriceTierPickerBottomSheet.show(parentFragmentManager, WidgetPriceTierPickerBottomSheet.class.getName());
    }

    public final void registerForResult(Fragment fragment, String requestKey, Function1<? super Integer, Unit> onPriceTierSelected) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(requestKey, "requestKey");
        m.checkNotNullParameter(onPriceTierSelected, "onPriceTierSelected");
        FragmentKt.setFragmentResultListener(fragment, requestKey, new WidgetPriceTierPickerBottomSheet$Companion$registerForResult$1(requestKey, onPriceTierSelected));
    }

    public /* synthetic */ WidgetPriceTierPickerBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

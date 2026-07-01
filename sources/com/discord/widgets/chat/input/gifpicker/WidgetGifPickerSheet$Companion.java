package com.discord.widgets.chat.input.gifpicker;

import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGifPickerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGifPickerSheet$Companion {
    private WidgetGifPickerSheet$Companion() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void show$default(WidgetGifPickerSheet$Companion widgetGifPickerSheet$Companion, FragmentManager fragmentManager, Function0 function0, Function0 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        widgetGifPickerSheet$Companion.show(fragmentManager, function0, function1);
    }

    public final void show(FragmentManager fragmentManager, Function0<Unit> onGifSelected, Function0<Unit> onCancel) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetGifPickerSheet widgetGifPickerSheet = new WidgetGifPickerSheet();
        widgetGifPickerSheet.show(fragmentManager, WidgetGifPickerSheet.class.getSimpleName());
        widgetGifPickerSheet.setOnGifSelected(onGifSelected);
        widgetGifPickerSheet.setOnCancel(onCancel);
    }

    public /* synthetic */ WidgetGifPickerSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

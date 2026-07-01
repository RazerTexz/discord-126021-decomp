package com.discord.widgets.settings;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetSettingsLanguageSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsLanguageSelect$Companion {
    private WidgetSettingsLanguageSelect$Companion() {
    }

    public final void registerForResult(Fragment fragment, Function1<? super String, Unit> onLocaleSelected) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(onLocaleSelected, "onLocaleSelected");
        FragmentKt.setFragmentResultListener(fragment, "REQUEST_KEY_USER_LOCALE", new WidgetSettingsLanguageSelect$Companion$registerForResult$1(onLocaleSelected));
    }

    public final void show(Fragment fragment) {
        m.checkNotNullParameter(fragment, "fragment");
        WidgetSettingsLanguageSelect widgetSettingsLanguageSelect = new WidgetSettingsLanguageSelect();
        widgetSettingsLanguageSelect.setArguments(new Bundle());
        FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
        widgetSettingsLanguageSelect.show(parentFragmentManager, WidgetSettingsLanguageSelect.class.getName());
    }

    public /* synthetic */ WidgetSettingsLanguageSelect$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

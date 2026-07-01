package com.discord.widgets.auth;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetAuthLandingViewModel$ViewState {
    private final String ageGateError;

    private WidgetAuthLandingViewModel$ViewState(String str) {
        this.ageGateError = str;
    }

    public String getAgeGateError() {
        return this.ageGateError;
    }

    public /* synthetic */ WidgetAuthLandingViewModel$ViewState(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}

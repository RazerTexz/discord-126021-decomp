package com.discord.widgets.auth;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetAuthLandingViewModel$ViewState$Empty extends WidgetAuthLandingViewModel$ViewState {
    private final String ageGateError;

    public WidgetAuthLandingViewModel$ViewState$Empty(String str) {
        super(str, null);
        this.ageGateError = str;
    }

    public static /* synthetic */ WidgetAuthLandingViewModel$ViewState$Empty copy$default(WidgetAuthLandingViewModel$ViewState$Empty widgetAuthLandingViewModel$ViewState$Empty, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetAuthLandingViewModel$ViewState$Empty.getAgeGateError();
        }
        return widgetAuthLandingViewModel$ViewState$Empty.copy(str);
    }

    public final String component1() {
        return getAgeGateError();
    }

    public final WidgetAuthLandingViewModel$ViewState$Empty copy(String ageGateError) {
        return new WidgetAuthLandingViewModel$ViewState$Empty(ageGateError);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetAuthLandingViewModel$ViewState$Empty) && m.areEqual(getAgeGateError(), ((WidgetAuthLandingViewModel$ViewState$Empty) other).getAgeGateError());
        }
        return true;
    }

    @Override // com.discord.widgets.auth.WidgetAuthLandingViewModel$ViewState
    public String getAgeGateError() {
        return this.ageGateError;
    }

    public int hashCode() {
        String ageGateError = getAgeGateError();
        if (ageGateError != null) {
            return ageGateError.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Empty(ageGateError=");
        sbU.append(getAgeGateError());
        sbU.append(")");
        return sbU.toString();
    }
}

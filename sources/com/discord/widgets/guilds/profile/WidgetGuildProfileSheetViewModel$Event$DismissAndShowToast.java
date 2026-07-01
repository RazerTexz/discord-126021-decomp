package com.discord.widgets.guilds.profile;

import androidx.annotation.StringRes;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildProfileSheetViewModel$Event$DismissAndShowToast extends WidgetGuildProfileSheetViewModel$Event {
    private final int stringRes;

    public WidgetGuildProfileSheetViewModel$Event$DismissAndShowToast(@StringRes int i) {
        super(null);
        this.stringRes = i;
    }

    public static /* synthetic */ WidgetGuildProfileSheetViewModel$Event$DismissAndShowToast copy$default(WidgetGuildProfileSheetViewModel$Event$DismissAndShowToast widgetGuildProfileSheetViewModel$Event$DismissAndShowToast, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetGuildProfileSheetViewModel$Event$DismissAndShowToast.stringRes;
        }
        return widgetGuildProfileSheetViewModel$Event$DismissAndShowToast.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getStringRes() {
        return this.stringRes;
    }

    public final WidgetGuildProfileSheetViewModel$Event$DismissAndShowToast copy(@StringRes int stringRes) {
        return new WidgetGuildProfileSheetViewModel$Event$DismissAndShowToast(stringRes);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetGuildProfileSheetViewModel$Event$DismissAndShowToast) && this.stringRes == ((WidgetGuildProfileSheetViewModel$Event$DismissAndShowToast) other).stringRes;
        }
        return true;
    }

    public final int getStringRes() {
        return this.stringRes;
    }

    public int hashCode() {
        return this.stringRes;
    }

    public String toString() {
        return a.B(a.U("DismissAndShowToast(stringRes="), this.stringRes, ")");
    }
}

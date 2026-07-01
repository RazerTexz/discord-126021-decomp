package com.discord.widgets.user.usersheet;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserSheetViewModel$Event$ShowToast extends WidgetUserSheetViewModel$Event {
    private final int stringRes;

    public WidgetUserSheetViewModel$Event$ShowToast(int i) {
        super(null);
        this.stringRes = i;
    }

    public static /* synthetic */ WidgetUserSheetViewModel$Event$ShowToast copy$default(WidgetUserSheetViewModel$Event$ShowToast widgetUserSheetViewModel$Event$ShowToast, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetUserSheetViewModel$Event$ShowToast.stringRes;
        }
        return widgetUserSheetViewModel$Event$ShowToast.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getStringRes() {
        return this.stringRes;
    }

    public final WidgetUserSheetViewModel$Event$ShowToast copy(int stringRes) {
        return new WidgetUserSheetViewModel$Event$ShowToast(stringRes);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetUserSheetViewModel$Event$ShowToast) && this.stringRes == ((WidgetUserSheetViewModel$Event$ShowToast) other).stringRes;
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
        return a.B(a.U("ShowToast(stringRes="), this.stringRes, ")");
    }
}

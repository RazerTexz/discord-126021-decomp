package com.discord.widgets.guilds.create;

import androidx.annotation.StringRes;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildCreateViewModel$Event$ShowToast extends WidgetGuildCreateViewModel$Event {
    private final int stringResId;

    public WidgetGuildCreateViewModel$Event$ShowToast(@StringRes int i) {
        super(null);
        this.stringResId = i;
    }

    public static /* synthetic */ WidgetGuildCreateViewModel$Event$ShowToast copy$default(WidgetGuildCreateViewModel$Event$ShowToast widgetGuildCreateViewModel$Event$ShowToast, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetGuildCreateViewModel$Event$ShowToast.stringResId;
        }
        return widgetGuildCreateViewModel$Event$ShowToast.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getStringResId() {
        return this.stringResId;
    }

    public final WidgetGuildCreateViewModel$Event$ShowToast copy(@StringRes int stringResId) {
        return new WidgetGuildCreateViewModel$Event$ShowToast(stringResId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetGuildCreateViewModel$Event$ShowToast) && this.stringResId == ((WidgetGuildCreateViewModel$Event$ShowToast) other).stringResId;
        }
        return true;
    }

    public final int getStringResId() {
        return this.stringResId;
    }

    public int hashCode() {
        return this.stringResId;
    }

    public String toString() {
        return a.B(a.U("ShowToast(stringResId="), this.stringResId, ")");
    }
}

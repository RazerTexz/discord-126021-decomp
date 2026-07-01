package com.discord.widgets.settings.account;

import androidx.annotation.StringRes;

/* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum WidgetDisableDeleteAccountDialog$Mode {
    DISABLE(2131888463, 2131888464, 2131888462),
    DELETE(2131888370, 2131888371, 2131888369);

    private final int bodyStringId;
    private final int confirmStringId;
    private final int headerStringId;

    WidgetDisableDeleteAccountDialog$Mode(@StringRes int i, int i2, int i3) {
        this.headerStringId = i;
        this.bodyStringId = i2;
        this.confirmStringId = i3;
    }

    public final int getBodyStringId() {
        return this.bodyStringId;
    }

    public final int getConfirmStringId() {
        return this.confirmStringId;
    }

    public final int getHeaderStringId() {
        return this.headerStringId;
    }
}

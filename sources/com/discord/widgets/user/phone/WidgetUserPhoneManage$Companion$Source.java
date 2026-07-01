package com.discord.widgets.user.phone;


/* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
/* JADX INFO: loaded from: classes.dex */
public enum WidgetUserPhoneManage$Companion$Source {
    USER_ACTION_REQUIRED("user_action_required"),
    USER_SETTINGS_UPDATE("user_settings_update"),
    GUILD_PHONE_REQUIRED("guild_phone_required"),
    MFA_PHONE_UPDATE("mfa_phone_update"),
    CONTACT_SYNC("contact_sync"),
    DEFAULT("update_phone");

    private final String source;

    WidgetUserPhoneManage$Companion$Source(String str) {
        this.source = str;
    }

    public final String getSource() {
        return this.source;
    }
}

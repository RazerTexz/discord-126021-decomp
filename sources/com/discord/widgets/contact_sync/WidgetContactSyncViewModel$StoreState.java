package com.discord.widgets.contact_sync;

import b.d.b.a.a;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.phone.PhoneCountryCode;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetContactSyncViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetContactSyncViewModel$StoreState {
    private final ConnectedAccount contactsConnection;
    private final PhoneCountryCode countryCode;
    private final String userPhone;
    private final String username;

    public WidgetContactSyncViewModel$StoreState(String str, String str2, PhoneCountryCode phoneCountryCode, ConnectedAccount connectedAccount) {
        m.checkNotNullParameter(str2, "username");
        m.checkNotNullParameter(phoneCountryCode, "countryCode");
        this.userPhone = str;
        this.username = str2;
        this.countryCode = phoneCountryCode;
        this.contactsConnection = connectedAccount;
    }

    public static /* synthetic */ WidgetContactSyncViewModel$StoreState copy$default(WidgetContactSyncViewModel$StoreState widgetContactSyncViewModel$StoreState, String str, String str2, PhoneCountryCode phoneCountryCode, ConnectedAccount connectedAccount, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetContactSyncViewModel$StoreState.userPhone;
        }
        if ((i & 2) != 0) {
            str2 = widgetContactSyncViewModel$StoreState.username;
        }
        if ((i & 4) != 0) {
            phoneCountryCode = widgetContactSyncViewModel$StoreState.countryCode;
        }
        if ((i & 8) != 0) {
            connectedAccount = widgetContactSyncViewModel$StoreState.contactsConnection;
        }
        return widgetContactSyncViewModel$StoreState.copy(str, str2, phoneCountryCode, connectedAccount);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUserPhone() {
        return this.userPhone;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PhoneCountryCode getCountryCode() {
        return this.countryCode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ConnectedAccount getContactsConnection() {
        return this.contactsConnection;
    }

    public final WidgetContactSyncViewModel$StoreState copy(String userPhone, String username, PhoneCountryCode countryCode, ConnectedAccount contactsConnection) {
        m.checkNotNullParameter(username, "username");
        m.checkNotNullParameter(countryCode, "countryCode");
        return new WidgetContactSyncViewModel$StoreState(userPhone, username, countryCode, contactsConnection);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetContactSyncViewModel$StoreState)) {
            return false;
        }
        WidgetContactSyncViewModel$StoreState widgetContactSyncViewModel$StoreState = (WidgetContactSyncViewModel$StoreState) other;
        return m.areEqual(this.userPhone, widgetContactSyncViewModel$StoreState.userPhone) && m.areEqual(this.username, widgetContactSyncViewModel$StoreState.username) && m.areEqual(this.countryCode, widgetContactSyncViewModel$StoreState.countryCode) && m.areEqual(this.contactsConnection, widgetContactSyncViewModel$StoreState.contactsConnection);
    }

    public final ConnectedAccount getContactsConnection() {
        return this.contactsConnection;
    }

    public final PhoneCountryCode getCountryCode() {
        return this.countryCode;
    }

    public final String getUserPhone() {
        return this.userPhone;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        String str = this.userPhone;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.username;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        PhoneCountryCode phoneCountryCode = this.countryCode;
        int iHashCode3 = (iHashCode2 + (phoneCountryCode != null ? phoneCountryCode.hashCode() : 0)) * 31;
        ConnectedAccount connectedAccount = this.contactsConnection;
        return iHashCode3 + (connectedAccount != null ? connectedAccount.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(userPhone=");
        sbU.append(this.userPhone);
        sbU.append(", username=");
        sbU.append(this.username);
        sbU.append(", countryCode=");
        sbU.append(this.countryCode);
        sbU.append(", contactsConnection=");
        sbU.append(this.contactsConnection);
        sbU.append(")");
        return sbU.toString();
    }
}

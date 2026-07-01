package com.discord.widgets.contact_sync;

import b.d.b.a.a;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.phone.PhoneCountryCode;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetContactSyncViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetContactSyncViewModel$ViewState {
    private final boolean allowEmail;
    private final boolean allowPhone;
    private final String bulkAddToken;
    private final PhoneCountryCode countryCode;
    private final WidgetContactSyncViewModel$Views displayedChild;
    private final ConnectedAccount existingConnection;
    private final List<WidgetContactSyncViewModel$Item> friendSuggestions;
    private final boolean isSubmitting;
    private final boolean landingNextEnabled;
    private final ContactSyncMode mode;
    private final String name;
    private final boolean permissionsDenied;
    private final String phoneNumber;
    private final List<Long> selectedFriendIds;
    private final WidgetContactSyncViewModel$ToolbarConfig toolbarConfig;
    private final String username;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetContactSyncViewModel$ViewState(boolean z2, ContactSyncMode contactSyncMode, String str, ConnectedAccount connectedAccount, PhoneCountryCode phoneCountryCode, String str2, String str3, boolean z3, boolean z4, WidgetContactSyncViewModel$Views widgetContactSyncViewModel$Views, boolean z5, boolean z6, String str4, List<? extends WidgetContactSyncViewModel$Item> list, List<Long> list2, WidgetContactSyncViewModel$ToolbarConfig widgetContactSyncViewModel$ToolbarConfig) {
        m.checkNotNullParameter(contactSyncMode, "mode");
        m.checkNotNullParameter(phoneCountryCode, "countryCode");
        m.checkNotNullParameter(str2, "username");
        m.checkNotNullParameter(widgetContactSyncViewModel$Views, "displayedChild");
        m.checkNotNullParameter(list, "friendSuggestions");
        m.checkNotNullParameter(list2, "selectedFriendIds");
        m.checkNotNullParameter(widgetContactSyncViewModel$ToolbarConfig, "toolbarConfig");
        this.landingNextEnabled = z2;
        this.mode = contactSyncMode;
        this.phoneNumber = str;
        this.existingConnection = connectedAccount;
        this.countryCode = phoneCountryCode;
        this.username = str2;
        this.name = str3;
        this.isSubmitting = z3;
        this.permissionsDenied = z4;
        this.displayedChild = widgetContactSyncViewModel$Views;
        this.allowPhone = z5;
        this.allowEmail = z6;
        this.bulkAddToken = str4;
        this.friendSuggestions = list;
        this.selectedFriendIds = list2;
        this.toolbarConfig = widgetContactSyncViewModel$ToolbarConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetContactSyncViewModel$ViewState copy$default(WidgetContactSyncViewModel$ViewState widgetContactSyncViewModel$ViewState, boolean z2, ContactSyncMode contactSyncMode, String str, ConnectedAccount connectedAccount, PhoneCountryCode phoneCountryCode, String str2, String str3, boolean z3, boolean z4, WidgetContactSyncViewModel$Views widgetContactSyncViewModel$Views, boolean z5, boolean z6, String str4, List list, List list2, WidgetContactSyncViewModel$ToolbarConfig widgetContactSyncViewModel$ToolbarConfig, int i, Object obj) {
        return widgetContactSyncViewModel$ViewState.copy((i & 1) != 0 ? widgetContactSyncViewModel$ViewState.landingNextEnabled : z2, (i & 2) != 0 ? widgetContactSyncViewModel$ViewState.mode : contactSyncMode, (i & 4) != 0 ? widgetContactSyncViewModel$ViewState.phoneNumber : str, (i & 8) != 0 ? widgetContactSyncViewModel$ViewState.existingConnection : connectedAccount, (i & 16) != 0 ? widgetContactSyncViewModel$ViewState.countryCode : phoneCountryCode, (i & 32) != 0 ? widgetContactSyncViewModel$ViewState.username : str2, (i & 64) != 0 ? widgetContactSyncViewModel$ViewState.name : str3, (i & 128) != 0 ? widgetContactSyncViewModel$ViewState.isSubmitting : z3, (i & 256) != 0 ? widgetContactSyncViewModel$ViewState.permissionsDenied : z4, (i & 512) != 0 ? widgetContactSyncViewModel$ViewState.displayedChild : widgetContactSyncViewModel$Views, (i & 1024) != 0 ? widgetContactSyncViewModel$ViewState.allowPhone : z5, (i & 2048) != 0 ? widgetContactSyncViewModel$ViewState.allowEmail : z6, (i & 4096) != 0 ? widgetContactSyncViewModel$ViewState.bulkAddToken : str4, (i & 8192) != 0 ? widgetContactSyncViewModel$ViewState.friendSuggestions : list, (i & 16384) != 0 ? widgetContactSyncViewModel$ViewState.selectedFriendIds : list2, (i & 32768) != 0 ? widgetContactSyncViewModel$ViewState.toolbarConfig : widgetContactSyncViewModel$ToolbarConfig);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLandingNextEnabled() {
        return this.landingNextEnabled;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final WidgetContactSyncViewModel$Views getDisplayedChild() {
        return this.displayedChild;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getAllowPhone() {
        return this.allowPhone;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getAllowEmail() {
        return this.allowEmail;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getBulkAddToken() {
        return this.bulkAddToken;
    }

    public final List<WidgetContactSyncViewModel$Item> component14() {
        return this.friendSuggestions;
    }

    public final List<Long> component15() {
        return this.selectedFriendIds;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final WidgetContactSyncViewModel$ToolbarConfig getToolbarConfig() {
        return this.toolbarConfig;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ContactSyncMode getMode() {
        return this.mode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ConnectedAccount getExistingConnection() {
        return this.existingConnection;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final PhoneCountryCode getCountryCode() {
        return this.countryCode;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsSubmitting() {
        return this.isSubmitting;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getPermissionsDenied() {
        return this.permissionsDenied;
    }

    public final WidgetContactSyncViewModel$ViewState copy(boolean landingNextEnabled, ContactSyncMode mode, String phoneNumber, ConnectedAccount existingConnection, PhoneCountryCode countryCode, String username, String name, boolean isSubmitting, boolean permissionsDenied, WidgetContactSyncViewModel$Views displayedChild, boolean allowPhone, boolean allowEmail, String bulkAddToken, List<? extends WidgetContactSyncViewModel$Item> friendSuggestions, List<Long> selectedFriendIds, WidgetContactSyncViewModel$ToolbarConfig toolbarConfig) {
        m.checkNotNullParameter(mode, "mode");
        m.checkNotNullParameter(countryCode, "countryCode");
        m.checkNotNullParameter(username, "username");
        m.checkNotNullParameter(displayedChild, "displayedChild");
        m.checkNotNullParameter(friendSuggestions, "friendSuggestions");
        m.checkNotNullParameter(selectedFriendIds, "selectedFriendIds");
        m.checkNotNullParameter(toolbarConfig, "toolbarConfig");
        return new WidgetContactSyncViewModel$ViewState(landingNextEnabled, mode, phoneNumber, existingConnection, countryCode, username, name, isSubmitting, permissionsDenied, displayedChild, allowPhone, allowEmail, bulkAddToken, friendSuggestions, selectedFriendIds, toolbarConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetContactSyncViewModel$ViewState)) {
            return false;
        }
        WidgetContactSyncViewModel$ViewState widgetContactSyncViewModel$ViewState = (WidgetContactSyncViewModel$ViewState) other;
        return this.landingNextEnabled == widgetContactSyncViewModel$ViewState.landingNextEnabled && m.areEqual(this.mode, widgetContactSyncViewModel$ViewState.mode) && m.areEqual(this.phoneNumber, widgetContactSyncViewModel$ViewState.phoneNumber) && m.areEqual(this.existingConnection, widgetContactSyncViewModel$ViewState.existingConnection) && m.areEqual(this.countryCode, widgetContactSyncViewModel$ViewState.countryCode) && m.areEqual(this.username, widgetContactSyncViewModel$ViewState.username) && m.areEqual(this.name, widgetContactSyncViewModel$ViewState.name) && this.isSubmitting == widgetContactSyncViewModel$ViewState.isSubmitting && this.permissionsDenied == widgetContactSyncViewModel$ViewState.permissionsDenied && m.areEqual(this.displayedChild, widgetContactSyncViewModel$ViewState.displayedChild) && this.allowPhone == widgetContactSyncViewModel$ViewState.allowPhone && this.allowEmail == widgetContactSyncViewModel$ViewState.allowEmail && m.areEqual(this.bulkAddToken, widgetContactSyncViewModel$ViewState.bulkAddToken) && m.areEqual(this.friendSuggestions, widgetContactSyncViewModel$ViewState.friendSuggestions) && m.areEqual(this.selectedFriendIds, widgetContactSyncViewModel$ViewState.selectedFriendIds) && m.areEqual(this.toolbarConfig, widgetContactSyncViewModel$ViewState.toolbarConfig);
    }

    public final boolean getAllowEmail() {
        return this.allowEmail;
    }

    public final boolean getAllowPhone() {
        return this.allowPhone;
    }

    public final String getBulkAddToken() {
        return this.bulkAddToken;
    }

    public final PhoneCountryCode getCountryCode() {
        return this.countryCode;
    }

    public final WidgetContactSyncViewModel$Views getDisplayedChild() {
        return this.displayedChild;
    }

    public final ConnectedAccount getExistingConnection() {
        return this.existingConnection;
    }

    public final List<WidgetContactSyncViewModel$Item> getFriendSuggestions() {
        return this.friendSuggestions;
    }

    public final boolean getLandingNextEnabled() {
        return this.landingNextEnabled;
    }

    public final ContactSyncMode getMode() {
        return this.mode;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getPermissionsDenied() {
        return this.permissionsDenied;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final List<Long> getSelectedFriendIds() {
        return this.selectedFriendIds;
    }

    public final WidgetContactSyncViewModel$ToolbarConfig getToolbarConfig() {
        return this.toolbarConfig;
    }

    public final String getUsername() {
        return this.username;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    public int hashCode() {
        boolean z2 = this.landingNextEnabled;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        ContactSyncMode contactSyncMode = this.mode;
        int iHashCode = (i + (contactSyncMode != null ? contactSyncMode.hashCode() : 0)) * 31;
        String str = this.phoneNumber;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        ConnectedAccount connectedAccount = this.existingConnection;
        int iHashCode3 = (iHashCode2 + (connectedAccount != null ? connectedAccount.hashCode() : 0)) * 31;
        PhoneCountryCode phoneCountryCode = this.countryCode;
        int iHashCode4 = (iHashCode3 + (phoneCountryCode != null ? phoneCountryCode.hashCode() : 0)) * 31;
        String str2 = this.username;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        int iHashCode6 = (iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z3 = this.isSubmitting;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (iHashCode6 + r2) * 31;
        boolean z4 = this.permissionsDenied;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        WidgetContactSyncViewModel$Views widgetContactSyncViewModel$Views = this.displayedChild;
        int iHashCode7 = (i3 + (widgetContactSyncViewModel$Views != null ? widgetContactSyncViewModel$Views.hashCode() : 0)) * 31;
        boolean z5 = this.allowPhone;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (iHashCode7 + r4) * 31;
        boolean z6 = this.allowEmail;
        int i5 = (i4 + (z6 ? 1 : z6)) * 31;
        String str4 = this.bulkAddToken;
        int iHashCode8 = (i5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<WidgetContactSyncViewModel$Item> list = this.friendSuggestions;
        int iHashCode9 = (iHashCode8 + (list != null ? list.hashCode() : 0)) * 31;
        List<Long> list2 = this.selectedFriendIds;
        int iHashCode10 = (iHashCode9 + (list2 != null ? list2.hashCode() : 0)) * 31;
        WidgetContactSyncViewModel$ToolbarConfig widgetContactSyncViewModel$ToolbarConfig = this.toolbarConfig;
        return iHashCode10 + (widgetContactSyncViewModel$ToolbarConfig != null ? widgetContactSyncViewModel$ToolbarConfig.hashCode() : 0);
    }

    public final boolean isSubmitting() {
        return this.isSubmitting;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(landingNextEnabled=");
        sbU.append(this.landingNextEnabled);
        sbU.append(", mode=");
        sbU.append(this.mode);
        sbU.append(", phoneNumber=");
        sbU.append(this.phoneNumber);
        sbU.append(", existingConnection=");
        sbU.append(this.existingConnection);
        sbU.append(", countryCode=");
        sbU.append(this.countryCode);
        sbU.append(", username=");
        sbU.append(this.username);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", isSubmitting=");
        sbU.append(this.isSubmitting);
        sbU.append(", permissionsDenied=");
        sbU.append(this.permissionsDenied);
        sbU.append(", displayedChild=");
        sbU.append(this.displayedChild);
        sbU.append(", allowPhone=");
        sbU.append(this.allowPhone);
        sbU.append(", allowEmail=");
        sbU.append(this.allowEmail);
        sbU.append(", bulkAddToken=");
        sbU.append(this.bulkAddToken);
        sbU.append(", friendSuggestions=");
        sbU.append(this.friendSuggestions);
        sbU.append(", selectedFriendIds=");
        sbU.append(this.selectedFriendIds);
        sbU.append(", toolbarConfig=");
        sbU.append(this.toolbarConfig);
        sbU.append(")");
        return sbU.toString();
    }
}

package com.discord.stores;

import android.net.Uri;
import b.d.b.a.a;
import com.discord.models.authentication.AuthState;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.widgets.tabs.NavigationTab;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation {
    private final AuthState authState;
    private final boolean clientOutdated;
    private final String guildTemplateCode;
    private final boolean incomingCall;
    private final boolean initialized;
    private final StoreInviteSettings$InviteCode inviteCode;
    private final boolean isInitializedForAuthedUser;
    private final NavigationTab navigationTab;
    private final StoreNotices$Notice notice;
    private final StoreNux$NuxState nuxState;
    private final Uri oAuthUri;
    private final StoreNavigation$AgeGate shouldShowAgeGate;
    private final boolean userHasPhone;
    private final RequiredAction userRequiredAction;

    public StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation(StoreNux$NuxState storeNux$NuxState, boolean z2, AuthState authState, boolean z3, boolean z4, RequiredAction requiredAction, boolean z5, StoreInviteSettings$InviteCode storeInviteSettings$InviteCode, String str, StoreNotices$Notice storeNotices$Notice, StoreNavigation$AgeGate storeNavigation$AgeGate, Uri uri, NavigationTab navigationTab, boolean z6) {
        m.checkNotNullParameter(storeNux$NuxState, "nuxState");
        m.checkNotNullParameter(requiredAction, "userRequiredAction");
        m.checkNotNullParameter(uri, "oAuthUri");
        m.checkNotNullParameter(navigationTab, "navigationTab");
        this.nuxState = storeNux$NuxState;
        this.initialized = z2;
        this.authState = authState;
        this.isInitializedForAuthedUser = z3;
        this.incomingCall = z4;
        this.userRequiredAction = requiredAction;
        this.clientOutdated = z5;
        this.inviteCode = storeInviteSettings$InviteCode;
        this.guildTemplateCode = str;
        this.notice = storeNotices$Notice;
        this.shouldShowAgeGate = storeNavigation$AgeGate;
        this.oAuthUri = uri;
        this.navigationTab = navigationTab;
        this.userHasPhone = z6;
    }

    public static /* synthetic */ StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation copy$default(StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, StoreNux$NuxState storeNux$NuxState, boolean z2, AuthState authState, boolean z3, boolean z4, RequiredAction requiredAction, boolean z5, StoreInviteSettings$InviteCode storeInviteSettings$InviteCode, String str, StoreNotices$Notice storeNotices$Notice, StoreNavigation$AgeGate storeNavigation$AgeGate, Uri uri, NavigationTab navigationTab, boolean z6, int i, Object obj) {
        return storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.copy((i & 1) != 0 ? storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.nuxState : storeNux$NuxState, (i & 2) != 0 ? storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.initialized : z2, (i & 4) != 0 ? storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.authState : authState, (i & 8) != 0 ? storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.isInitializedForAuthedUser : z3, (i & 16) != 0 ? storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.incomingCall : z4, (i & 32) != 0 ? storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.userRequiredAction : requiredAction, (i & 64) != 0 ? storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.clientOutdated : z5, (i & 128) != 0 ? storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.inviteCode : storeInviteSettings$InviteCode, (i & 256) != 0 ? storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.guildTemplateCode : str, (i & 512) != 0 ? storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.notice : storeNotices$Notice, (i & 1024) != 0 ? storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.shouldShowAgeGate : storeNavigation$AgeGate, (i & 2048) != 0 ? storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.oAuthUri : uri, (i & 4096) != 0 ? storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.navigationTab : navigationTab, (i & 8192) != 0 ? storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.userHasPhone : z6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreNux$NuxState getNuxState() {
        return this.nuxState;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final StoreNotices$Notice getNotice() {
        return this.notice;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final StoreNavigation$AgeGate getShouldShowAgeGate() {
        return this.shouldShowAgeGate;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Uri getOAuthUri() {
        return this.oAuthUri;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final NavigationTab getNavigationTab() {
        return this.navigationTab;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getUserHasPhone() {
        return this.userHasPhone;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getInitialized() {
        return this.initialized;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AuthState getAuthState() {
        return this.authState;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsInitializedForAuthedUser() {
        return this.isInitializedForAuthedUser;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIncomingCall() {
        return this.incomingCall;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final RequiredAction getUserRequiredAction() {
        return this.userRequiredAction;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getClientOutdated() {
        return this.clientOutdated;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final StoreInviteSettings$InviteCode getInviteCode() {
        return this.inviteCode;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getGuildTemplateCode() {
        return this.guildTemplateCode;
    }

    public final StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation copy(StoreNux$NuxState nuxState, boolean initialized, AuthState authState, boolean isInitializedForAuthedUser, boolean incomingCall, RequiredAction userRequiredAction, boolean clientOutdated, StoreInviteSettings$InviteCode inviteCode, String guildTemplateCode, StoreNotices$Notice notice, StoreNavigation$AgeGate shouldShowAgeGate, Uri oAuthUri, NavigationTab navigationTab, boolean userHasPhone) {
        m.checkNotNullParameter(nuxState, "nuxState");
        m.checkNotNullParameter(userRequiredAction, "userRequiredAction");
        m.checkNotNullParameter(oAuthUri, "oAuthUri");
        m.checkNotNullParameter(navigationTab, "navigationTab");
        return new StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation(nuxState, initialized, authState, isInitializedForAuthedUser, incomingCall, userRequiredAction, clientOutdated, inviteCode, guildTemplateCode, notice, shouldShowAgeGate, oAuthUri, navigationTab, userHasPhone);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation)) {
            return false;
        }
        StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation = (StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation) other;
        return m.areEqual(this.nuxState, storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.nuxState) && this.initialized == storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.initialized && m.areEqual(this.authState, storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.authState) && this.isInitializedForAuthedUser == storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.isInitializedForAuthedUser && this.incomingCall == storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.incomingCall && m.areEqual(this.userRequiredAction, storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.userRequiredAction) && this.clientOutdated == storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.clientOutdated && m.areEqual(this.inviteCode, storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.inviteCode) && m.areEqual(this.guildTemplateCode, storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.guildTemplateCode) && m.areEqual(this.notice, storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.notice) && m.areEqual(this.shouldShowAgeGate, storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.shouldShowAgeGate) && m.areEqual(this.oAuthUri, storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.oAuthUri) && m.areEqual(this.navigationTab, storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.navigationTab) && this.userHasPhone == storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.userHasPhone;
    }

    public final AuthState getAuthState() {
        return this.authState;
    }

    public final boolean getClientOutdated() {
        return this.clientOutdated;
    }

    public final String getGuildTemplateCode() {
        return this.guildTemplateCode;
    }

    public final boolean getIncomingCall() {
        return this.incomingCall;
    }

    public final boolean getInitialized() {
        return this.initialized;
    }

    public final StoreInviteSettings$InviteCode getInviteCode() {
        return this.inviteCode;
    }

    public final NavigationTab getNavigationTab() {
        return this.navigationTab;
    }

    public final StoreNotices$Notice getNotice() {
        return this.notice;
    }

    public final StoreNux$NuxState getNuxState() {
        return this.nuxState;
    }

    public final Uri getOAuthUri() {
        return this.oAuthUri;
    }

    public final StoreNavigation$AgeGate getShouldShowAgeGate() {
        return this.shouldShowAgeGate;
    }

    public final boolean getUserHasPhone() {
        return this.userHasPhone;
    }

    public final RequiredAction getUserRequiredAction() {
        return this.userRequiredAction;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v28, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        StoreNux$NuxState storeNux$NuxState = this.nuxState;
        int iHashCode = (storeNux$NuxState != null ? storeNux$NuxState.hashCode() : 0) * 31;
        boolean z2 = this.initialized;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        AuthState authState = this.authState;
        int iHashCode2 = (i + (authState != null ? authState.hashCode() : 0)) * 31;
        boolean z3 = this.isInitializedForAuthedUser;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (iHashCode2 + r3) * 31;
        boolean z4 = this.incomingCall;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int i3 = (i2 + r4) * 31;
        RequiredAction requiredAction = this.userRequiredAction;
        int iHashCode3 = (i3 + (requiredAction != null ? requiredAction.hashCode() : 0)) * 31;
        boolean z5 = this.clientOutdated;
        ?? r5 = z5;
        if (z5) {
            r5 = 1;
        }
        int i4 = (iHashCode3 + r5) * 31;
        StoreInviteSettings$InviteCode storeInviteSettings$InviteCode = this.inviteCode;
        int iHashCode4 = (i4 + (storeInviteSettings$InviteCode != null ? storeInviteSettings$InviteCode.hashCode() : 0)) * 31;
        String str = this.guildTemplateCode;
        int iHashCode5 = (iHashCode4 + (str != null ? str.hashCode() : 0)) * 31;
        StoreNotices$Notice storeNotices$Notice = this.notice;
        int iHashCode6 = (iHashCode5 + (storeNotices$Notice != null ? storeNotices$Notice.hashCode() : 0)) * 31;
        StoreNavigation$AgeGate storeNavigation$AgeGate = this.shouldShowAgeGate;
        int iHashCode7 = (iHashCode6 + (storeNavigation$AgeGate != null ? storeNavigation$AgeGate.hashCode() : 0)) * 31;
        Uri uri = this.oAuthUri;
        int iHashCode8 = (iHashCode7 + (uri != null ? uri.hashCode() : 0)) * 31;
        NavigationTab navigationTab = this.navigationTab;
        int iHashCode9 = (iHashCode8 + (navigationTab != null ? navigationTab.hashCode() : 0)) * 31;
        boolean z6 = this.userHasPhone;
        return iHashCode9 + (z6 ? 1 : z6);
    }

    public final boolean isInitializedForAuthedUser() {
        return this.isInitializedForAuthedUser;
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelGlobalNavigation(nuxState=");
        sbU.append(this.nuxState);
        sbU.append(", initialized=");
        sbU.append(this.initialized);
        sbU.append(", authState=");
        sbU.append(this.authState);
        sbU.append(", isInitializedForAuthedUser=");
        sbU.append(this.isInitializedForAuthedUser);
        sbU.append(", incomingCall=");
        sbU.append(this.incomingCall);
        sbU.append(", userRequiredAction=");
        sbU.append(this.userRequiredAction);
        sbU.append(", clientOutdated=");
        sbU.append(this.clientOutdated);
        sbU.append(", inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", guildTemplateCode=");
        sbU.append(this.guildTemplateCode);
        sbU.append(", notice=");
        sbU.append(this.notice);
        sbU.append(", shouldShowAgeGate=");
        sbU.append(this.shouldShowAgeGate);
        sbU.append(", oAuthUri=");
        sbU.append(this.oAuthUri);
        sbU.append(", navigationTab=");
        sbU.append(this.navigationTab);
        sbU.append(", userHasPhone=");
        return a.O(sbU, this.userHasPhone, ")");
    }
}

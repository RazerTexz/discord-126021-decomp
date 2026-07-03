package com.discord.stores;

import android.net.Uri;
import com.discord.models.authentication.AuthState;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreNux;
import com.discord.widgets.tabs.NavigationTab;
import kotlin.jvm.functions.Function14;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$getGlobalNavigationData$2 */
/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C6278x99818c97 extends C12236k implements Function14<StoreNux.NuxState, Boolean, AuthState, Boolean, Boolean, RequiredAction, Boolean, StoreInviteSettings.InviteCode, String, StoreNotices.Notice, StoreNavigation.AgeGate, Uri, NavigationTab, Boolean, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation> {
    public static final C6278x99818c97 INSTANCE = new C6278x99818c97();

    public C6278x99818c97() {
        super(14, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation.class, "<init>", "<init>(Lcom/discord/stores/StoreNux$NuxState;ZLcom/discord/models/authentication/AuthState;ZZLcom/discord/models/requiredaction/RequiredAction;ZLcom/discord/stores/StoreInviteSettings$InviteCode;Ljava/lang/String;Lcom/discord/stores/StoreNotices$Notice;Lcom/discord/stores/StoreNavigation$AgeGate;Landroid/net/Uri;Lcom/discord/widgets/tabs/NavigationTab;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function14
    public /* bridge */ /* synthetic */ StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation invoke(StoreNux.NuxState nuxState, Boolean bool, AuthState authState, Boolean bool2, Boolean bool3, RequiredAction requiredAction, Boolean bool4, StoreInviteSettings.InviteCode inviteCode, String str, StoreNotices.Notice notice, StoreNavigation.AgeGate ageGate, Uri uri, NavigationTab navigationTab, Boolean bool5) {
        return invoke(nuxState, bool.booleanValue(), authState, bool2.booleanValue(), bool3.booleanValue(), requiredAction, bool4.booleanValue(), inviteCode, str, notice, ageGate, uri, navigationTab, bool5.booleanValue());
    }

    public final StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation invoke(StoreNux.NuxState nuxState, boolean z2, AuthState authState, boolean z3, boolean z4, RequiredAction requiredAction, boolean z5, StoreInviteSettings.InviteCode inviteCode, String str, StoreNotices.Notice notice, StoreNavigation.AgeGate ageGate, Uri uri, NavigationTab navigationTab, boolean z6) {
        C12238m.checkNotNullParameter(nuxState, "p1");
        C12238m.checkNotNullParameter(requiredAction, "p6");
        C12238m.checkNotNullParameter(uri, "p12");
        C12238m.checkNotNullParameter(navigationTab, "p13");
        return new StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation(nuxState, z2, authState, z3, z4, requiredAction, z5, inviteCode, str, notice, ageGate, uri, navigationTab, z6);
    }
}

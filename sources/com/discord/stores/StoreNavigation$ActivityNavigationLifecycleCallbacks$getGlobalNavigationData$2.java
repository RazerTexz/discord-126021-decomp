package com.discord.stores;

import android.net.Uri;
import com.discord.models.authentication.AuthState;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.widgets.tabs.NavigationTab;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function14;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreNavigation$ActivityNavigationLifecycleCallbacks$getGlobalNavigationData$2 extends k implements Function14<StoreNux$NuxState, Boolean, AuthState, Boolean, Boolean, RequiredAction, Boolean, StoreInviteSettings$InviteCode, String, StoreNotices$Notice, StoreNavigation$AgeGate, Uri, NavigationTab, Boolean, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation> {
    public static final StoreNavigation$ActivityNavigationLifecycleCallbacks$getGlobalNavigationData$2 INSTANCE = new StoreNavigation$ActivityNavigationLifecycleCallbacks$getGlobalNavigationData$2();

    public StoreNavigation$ActivityNavigationLifecycleCallbacks$getGlobalNavigationData$2() {
        super(14, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation.class, "<init>", "<init>(Lcom/discord/stores/StoreNux$NuxState;ZLcom/discord/models/authentication/AuthState;ZZLcom/discord/models/requiredaction/RequiredAction;ZLcom/discord/stores/StoreInviteSettings$InviteCode;Ljava/lang/String;Lcom/discord/stores/StoreNotices$Notice;Lcom/discord/stores/StoreNavigation$AgeGate;Landroid/net/Uri;Lcom/discord/widgets/tabs/NavigationTab;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function14
    public /* bridge */ /* synthetic */ StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation invoke(StoreNux$NuxState storeNux$NuxState, Boolean bool, AuthState authState, Boolean bool2, Boolean bool3, RequiredAction requiredAction, Boolean bool4, StoreInviteSettings$InviteCode storeInviteSettings$InviteCode, String str, StoreNotices$Notice storeNotices$Notice, StoreNavigation$AgeGate storeNavigation$AgeGate, Uri uri, NavigationTab navigationTab, Boolean bool5) {
        return invoke(storeNux$NuxState, bool.booleanValue(), authState, bool2.booleanValue(), bool3.booleanValue(), requiredAction, bool4.booleanValue(), storeInviteSettings$InviteCode, str, storeNotices$Notice, storeNavigation$AgeGate, uri, navigationTab, bool5.booleanValue());
    }

    public final StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation invoke(StoreNux$NuxState storeNux$NuxState, boolean z2, AuthState authState, boolean z3, boolean z4, RequiredAction requiredAction, boolean z5, StoreInviteSettings$InviteCode storeInviteSettings$InviteCode, String str, StoreNotices$Notice storeNotices$Notice, StoreNavigation$AgeGate storeNavigation$AgeGate, Uri uri, NavigationTab navigationTab, boolean z6) {
        m.checkNotNullParameter(storeNux$NuxState, "p1");
        m.checkNotNullParameter(requiredAction, "p6");
        m.checkNotNullParameter(uri, "p12");
        m.checkNotNullParameter(navigationTab, "p13");
        return new StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation(storeNux$NuxState, z2, authState, z3, z4, requiredAction, z5, storeInviteSettings$InviteCode, str, storeNotices$Notice, storeNavigation$AgeGate, uri, navigationTab, z6);
    }
}

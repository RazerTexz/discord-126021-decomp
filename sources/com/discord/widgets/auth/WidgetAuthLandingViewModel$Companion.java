package com.discord.widgets.auth;

import com.discord.stores.StoreAuthentication;
import com.discord.stores.StoreGuildTemplates;
import com.discord.stores.StoreInviteSettings;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLandingViewModel$Companion {
    private WidgetAuthLandingViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(WidgetAuthLandingViewModel$Companion widgetAuthLandingViewModel$Companion, StoreInviteSettings storeInviteSettings, StoreGuildTemplates storeGuildTemplates, StoreAuthentication storeAuthentication) {
        return widgetAuthLandingViewModel$Companion.observeStoreState(storeInviteSettings, storeGuildTemplates, storeAuthentication);
    }

    private final Observable<WidgetAuthLandingViewModel$StoreState> observeStoreState(StoreInviteSettings storeInviteSettings, StoreGuildTemplates storeGuildTemplates, StoreAuthentication storeAuthentication) {
        Observable<WidgetAuthLandingViewModel$StoreState> observableH = Observable.h(storeInviteSettings.getInviteCode(), storeInviteSettings.getInvite(), storeGuildTemplates.observeDynamicLinkGuildTemplateCode().Y(new WidgetAuthLandingViewModel$Companion$observeStoreState$1(storeGuildTemplates)), storeAuthentication.getAgeGateError(), WidgetAuthLandingViewModel$Companion$observeStoreState$2.INSTANCE);
        m.checkNotNullExpressionValue(observableH, "Observable.combineLatest…eError,\n        )\n      }");
        return observableH;
    }

    public /* synthetic */ WidgetAuthLandingViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

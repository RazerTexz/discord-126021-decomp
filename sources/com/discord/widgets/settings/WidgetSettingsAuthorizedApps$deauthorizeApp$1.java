package com.discord.widgets.settings;

import android.view.View;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAuthorizedApps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAuthorizedApps$deauthorizeApp$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ long $oauthId;
    public final /* synthetic */ WidgetSettingsAuthorizedApps this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAuthorizedApps$deauthorizeApp$1(WidgetSettingsAuthorizedApps widgetSettingsAuthorizedApps, long j) {
        super(1);
        this.this$0 = widgetSettingsAuthorizedApps;
        this.$oauthId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().deleteOAuthToken(this.$oauthId), false, 1, null), this.this$0.getContext(), "REST: deauthorize app", (Function1) null, new WidgetSettingsAuthorizedApps$deauthorizeApp$1$1(this), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
    }
}

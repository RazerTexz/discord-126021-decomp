package com.discord.widgets.chat.list.adapter;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import b.a.k.b;
import com.discord.api.activity.ActivityActionConfirmation;
import com.discord.api.application.Application;
import com.discord.utilities.intent.IntentUtils$RouteBuilders$SDK;
import com.discord.utilities.uri.UriHandler;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler$onUserActivityAction$1 extends o implements Function1<ActivityActionConfirmation, Unit> {
    public final /* synthetic */ Application $application;
    public final /* synthetic */ WidgetChatListAdapterEventsHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterEventsHandler$onUserActivityAction$1(WidgetChatListAdapterEventsHandler widgetChatListAdapterEventsHandler, Application application) {
        super(1);
        this.this$0 = widgetChatListAdapterEventsHandler;
        this.$application = application;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ActivityActionConfirmation activityActionConfirmation) {
        invoke2(activityActionConfirmation);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ActivityActionConfirmation activityActionConfirmation) {
        m.checkNotNullParameter(activityActionConfirmation, "<name for destructuring parameter 0>");
        try {
            Intent intentJoin = IntentUtils$RouteBuilders$SDK.join(this.$application.a(), this.$application.getId(), activityActionConfirmation.getSecret());
            intentJoin.addFlags(268435456);
            WidgetChatListAdapterEventsHandler.access$getContext$p(this.this$0).startActivity(intentJoin);
        } catch (ActivityNotFoundException unused) {
            b.a.d.m.h(WidgetChatListAdapterEventsHandler.access$getContext$p(this.this$0), b.h(WidgetChatListAdapterEventsHandler.access$getContext$p(this.this$0), 2131896738, new Object[]{this.$application.getName()}, null, 4), 0, null, 12);
            String str = (String) u.firstOrNull((List) this.$application.d());
            if (str != null) {
                UriHandler.directToPlayStore$default(WidgetChatListAdapterEventsHandler.access$getContext$p(this.this$0), str, null, 4, null);
            }
        }
    }
}

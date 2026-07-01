package com.discord.widgets.servers;

import com.discord.api.guild.VanityUrlResponse;
import com.discord.app.AppFragment;
import com.discord.utilities.stateful.StatefulViews;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsVanityUrl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsVanityUrl$updateVanityUrl$1 extends o implements Function1<VanityUrlResponse, Unit> {
    public final /* synthetic */ WidgetServerSettingsVanityUrl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsVanityUrl$updateVanityUrl$1(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl) {
        super(1);
        this.this$0 = widgetServerSettingsVanityUrl;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(VanityUrlResponse vanityUrlResponse) {
        invoke2(vanityUrlResponse);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(VanityUrlResponse vanityUrlResponse) {
        m.checkNotNullParameter(vanityUrlResponse, "<name for destructuring parameter 0>");
        String code = vanityUrlResponse.getCode();
        int uses = vanityUrlResponse.getUses();
        WidgetServerSettingsVanityUrl.access$showLoadingUI(this.this$0, false);
        AppFragment.hideKeyboard$default(this.this$0, null, 1, null);
        WidgetServerSettingsVanityUrl.access$configureInviteCode(this.this$0, code, uses);
        StatefulViews.clear$default(WidgetServerSettingsVanityUrl.access$getState$p(this.this$0), false, 1, null);
    }
}

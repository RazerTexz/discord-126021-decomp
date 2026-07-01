package com.discord.widgets.servers;

import android.widget.TextView;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsVanityUrl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsVanityUrl$updateVanityUrl$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetServerSettingsVanityUrl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsVanityUrl$updateVanityUrl$2(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl) {
        super(1);
        this.this$0 = widgetServerSettingsVanityUrl;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        WidgetServerSettingsVanityUrl.access$showLoadingUI(this.this$0, false);
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        if (response.getCode() == 50020) {
            error.setShowErrorToasts(false);
            TextView textView = WidgetServerSettingsVanityUrl.access$getBinding$p(this.this$0).d;
            m.checkNotNullExpressionValue(textView, "binding.serverSettingsVanityUrlErrorText");
            textView.setVisibility(0);
        }
    }
}

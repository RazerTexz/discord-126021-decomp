package com.discord.widgets.settings;

import com.discord.models.domain.ModelOAuth2Token;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAuthorizedApps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAuthorizedApps$adapter$1$1 extends o implements Function1<ModelOAuth2Token, Unit> {
    public final /* synthetic */ WidgetSettingsAuthorizedApps$adapter$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAuthorizedApps$adapter$1$1(WidgetSettingsAuthorizedApps$adapter$1 widgetSettingsAuthorizedApps$adapter$1) {
        super(1);
        this.this$0 = widgetSettingsAuthorizedApps$adapter$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelOAuth2Token modelOAuth2Token) {
        invoke2(modelOAuth2Token);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelOAuth2Token modelOAuth2Token) {
        m.checkNotNullParameter(modelOAuth2Token, "oath2Token");
        this.this$0.this$0.deauthorizeApp(modelOAuth2Token.getId());
    }
}

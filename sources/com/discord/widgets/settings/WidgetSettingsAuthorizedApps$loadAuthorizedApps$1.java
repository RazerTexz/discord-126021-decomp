package com.discord.widgets.settings;

import com.discord.models.domain.ModelOAuth2Token;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAuthorizedApps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAuthorizedApps$loadAuthorizedApps$1 extends o implements Function1<List<? extends ModelOAuth2Token>, Unit> {
    public final /* synthetic */ WidgetSettingsAuthorizedApps this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAuthorizedApps$loadAuthorizedApps$1(WidgetSettingsAuthorizedApps widgetSettingsAuthorizedApps) {
        super(1);
        this.this$0 = widgetSettingsAuthorizedApps;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelOAuth2Token> list) {
        invoke2((List<ModelOAuth2Token>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<ModelOAuth2Token> list) {
        m.checkNotNullParameter(list, "authedTokens");
        WidgetSettingsAuthorizedApps.access$getAdapter$p(this.this$0).setData(list);
    }
}

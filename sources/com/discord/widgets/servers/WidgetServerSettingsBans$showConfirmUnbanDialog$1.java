package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import com.discord.models.domain.ModelBan;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsBans$showConfirmUnbanDialog$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ ModelBan $ban;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ WidgetServerSettingsBans this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsBans$showConfirmUnbanDialog$1(WidgetServerSettingsBans widgetServerSettingsBans, long j, ModelBan modelBan) {
        super(1);
        this.this$0 = widgetServerSettingsBans;
        this.$guildId = j;
        this.$ban = modelBan;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().unbanUser(this.$guildId, this.$ban.getUser().getId()), false, 1, null), this.this$0, null, 2, null), this.this$0.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, WidgetServerSettingsBans$showConfirmUnbanDialog$1$1.INSTANCE, 62, (Object) null);
    }
}

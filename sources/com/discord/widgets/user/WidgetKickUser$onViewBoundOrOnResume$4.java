package com.discord.widgets.user;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.t;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetKickUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetKickUser$onViewBoundOrOnResume$4 implements View$OnClickListener {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ String $userName;
    public final /* synthetic */ WidgetKickUser this$0;

    public WidgetKickUser$onViewBoundOrOnResume$4(WidgetKickUser widgetKickUser, long j, long j2, String str) {
        this.this$0 = widgetKickUser;
        this.$guildId = j;
        this.$userId = j2;
        this.$userName = str;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        TextInputLayout textInputLayout = WidgetKickUser.access$getBinding$p(this.this$0).e;
        m.checkNotNullExpressionValue(textInputLayout, "binding.kickUserReason");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().kickGuildMember(this.$guildId, this.$userId, t.isBlank(textOrEmpty) ^ true ? textOrEmpty : null), false, 1, null), this.this$0, null, 2, null), this.this$0.getClass(), this.this$0.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetKickUser$onViewBoundOrOnResume$4$1(this), 60, (Object) null);
    }
}

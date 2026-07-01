package com.discord.widgets.user;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.R$id;
import com.discord.restapi.RestAPIParams$BanGuildMember;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.t;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetBanUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetBanUser$onViewBound$3 implements View$OnClickListener {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ String $userName;
    public final /* synthetic */ WidgetBanUser this$0;

    public WidgetBanUser$onViewBound$3(WidgetBanUser widgetBanUser, long j, long j2, String str) {
        this.this$0 = widgetBanUser;
        this.$guildId = j;
        this.$userId = j2;
        this.$userName = str;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i;
        List listAccess$getHistoryRadios$p = WidgetBanUser.access$getHistoryRadios$p(this.this$0);
        RadioManager radioManagerAccess$getDeleteHistoryRadioManager$p = WidgetBanUser.access$getDeleteHistoryRadioManager$p(this.this$0);
        switch (((CheckedSetting) listAccess$getHistoryRadios$p.get(radioManagerAccess$getDeleteHistoryRadioManager$p != null ? radioManagerAccess$getDeleteHistoryRadioManager$p.b() : 0)).getId()) {
            case R$id.ban_user_delete_messages_1_day /* 2131362131 */:
                i = 1;
                break;
            case R$id.ban_user_delete_messages_7_days /* 2131362132 */:
                i = 7;
                break;
            case R$id.ban_user_delete_messages_none /* 2131362133 */:
            default:
                i = 0;
                break;
        }
        TextInputLayout textInputLayout = WidgetBanUser.access$getBinding$p(this.this$0).h;
        m.checkNotNullExpressionValue(textInputLayout, "binding.banUserReason");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().banGuildMember(this.$guildId, this.$userId, new RestAPIParams$BanGuildMember(Integer.valueOf(i)), t.isBlank(textOrEmpty) ^ true ? textOrEmpty : null), false, 1, null), this.this$0, null, 2, null), this.this$0.getClass(), this.this$0.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetBanUser$onViewBound$3$1(this), 60, (Object) null);
    }
}

package com.discord.widgets.servers.settings.invites;

import android.os.CountDownTimer;
import com.discord.models.domain.ModelInvite;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvitesListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvitesListItem$setupExpirationTime$1 extends CountDownTimer {
    public final /* synthetic */ ModelInvite $invite;
    public final /* synthetic */ WidgetServerSettingsInstantInvitesListItem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsInstantInvitesListItem$setupExpirationTime$1(WidgetServerSettingsInstantInvitesListItem widgetServerSettingsInstantInvitesListItem, ModelInvite modelInvite, long j, long j2) {
        super(j, j2);
        this.this$0 = widgetServerSettingsInstantInvitesListItem;
        this.$invite = modelInvite;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        WidgetServerSettingsInstantInvitesListItem.access$setCountdownText(this.this$0, 0L);
        WidgetServerSettingsInstantInvitesListItem.access$getAdapter$p(this.this$0).onInviteExpired(this.$invite);
    }

    @Override // android.os.CountDownTimer
    public void onTick(long millisUntilFinished) {
        WidgetServerSettingsInstantInvitesListItem.access$setCountdownText(this.this$0, millisUntilFinished);
    }
}

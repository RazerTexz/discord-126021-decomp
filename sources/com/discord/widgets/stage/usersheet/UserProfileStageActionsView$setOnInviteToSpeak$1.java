package com.discord.widgets.stage.usersheet;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: UserProfileStageActionsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserProfileStageActionsView$setOnInviteToSpeak$1 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onInviteToSpeak;

    public UserProfileStageActionsView$setOnInviteToSpeak$1(Function0 function0) {
        this.$onInviteToSpeak = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onInviteToSpeak.invoke();
    }
}

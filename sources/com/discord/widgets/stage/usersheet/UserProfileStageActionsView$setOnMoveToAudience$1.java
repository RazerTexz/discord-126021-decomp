package com.discord.widgets.stage.usersheet;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: UserProfileStageActionsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserProfileStageActionsView$setOnMoveToAudience$1 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onMoveToAudience;

    public UserProfileStageActionsView$setOnMoveToAudience$1(Function0 function0) {
        this.$onMoveToAudience = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onMoveToAudience.invoke();
    }
}

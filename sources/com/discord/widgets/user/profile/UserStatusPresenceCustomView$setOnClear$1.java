package com.discord.widgets.user.profile;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: UserStatusPresenceCustomView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserStatusPresenceCustomView$setOnClear$1 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onClear;

    public UserStatusPresenceCustomView$setOnClear$1(Function0 function0) {
        this.$onClear = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onClear.invoke();
    }
}

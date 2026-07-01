package com.discord.widgets.user.profile;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: UserProfileAdminView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileAdminView$setOnBan$1 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onBan;

    public UserProfileAdminView$setOnBan$1(Function0 function0) {
        this.$onBan = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onBan.invoke();
    }
}

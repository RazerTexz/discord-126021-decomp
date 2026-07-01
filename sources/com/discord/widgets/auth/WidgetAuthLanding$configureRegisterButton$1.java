package com.discord.widgets.auth;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetAuthLanding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLanding$configureRegisterButton$1 implements View$OnClickListener {
    public final /* synthetic */ String $ageGateError;

    public WidgetAuthLanding$configureRegisterButton$1(String str) {
        this.$ageGateError = str;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetAuthAgeGated.Companion.start(a.x(view, "it", "it.context"), this.$ageGateError);
    }
}

package com.discord.widgets.user.email;

import android.content.Context;
import b.a.d.j;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase$Mode;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserEmailVerify$Companion {
    private WidgetUserEmailVerify$Companion() {
    }

    public final void launch(Context context, WidgetUserAccountVerifyBase$Mode mode) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(mode, "mode");
        j.d(context, WidgetUserEmailVerify.class, WidgetUserAccountVerifyBase.Companion.getLaunchIntent(mode, false, true));
    }

    public /* synthetic */ WidgetUserEmailVerify$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

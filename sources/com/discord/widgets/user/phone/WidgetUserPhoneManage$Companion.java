package com.discord.widgets.user.phone;

import android.content.Context;
import android.content.Intent;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import b.a.d.j;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase$Mode;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneManage$Companion {
    private WidgetUserPhoneManage$Companion() {
    }

    public final void launch(Context context, WidgetUserAccountVerifyBase$Mode mode, WidgetUserPhoneManage$Companion$Source source) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(mode, "mode");
        m.checkNotNullParameter(source, "source");
        Intent launchIntent = WidgetUserAccountVerifyBase.Companion.getLaunchIntent(mode, true, false);
        if (mode == WidgetUserAccountVerifyBase$Mode.NO_HISTORY_FROM_USER_SETTINGS) {
            launchIntent.addFlags(BasicMeasure.EXACTLY);
        }
        launchIntent.putExtra("intent_args_key", source.getSource());
        j.d(context, WidgetUserPhoneManage.class, launchIntent);
    }

    public /* synthetic */ WidgetUserPhoneManage$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

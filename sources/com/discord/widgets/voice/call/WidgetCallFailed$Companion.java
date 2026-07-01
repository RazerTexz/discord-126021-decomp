package com.discord.widgets.voice.call;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetCallFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFailed$Companion {
    private WidgetCallFailed$Companion() {
    }

    public final void show(FragmentManager fragmentManager, long userId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetCallFailed widgetCallFailed = new WidgetCallFailed();
        Bundle bundle = new Bundle();
        bundle.putLong("INTENT_USER_ID", userId);
        widgetCallFailed.setArguments(bundle);
        widgetCallFailed.show(fragmentManager, WidgetCallFailed.class.getSimpleName());
    }

    public /* synthetic */ WidgetCallFailed$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

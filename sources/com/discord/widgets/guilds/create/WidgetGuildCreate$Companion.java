package com.discord.widgets.guilds.create;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import b.a.d.j;
import com.discord.app.AppFragment;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildCreate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildCreate$Companion {
    private WidgetGuildCreate$Companion() {
    }

    public final void show(Context context, WidgetGuildCreate$Options options) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(options, "options");
        Intent intent = new Intent();
        intent.putExtra(WidgetGuildCreate.EXTRA_OPTIONS, options);
        j.d(context, WidgetGuildCreate.class, intent);
    }

    public final void showFragment(AppFragment fragment, WidgetGuildCreate$Options options) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(options, "options");
        Bundle bundle = new Bundle();
        bundle.putParcelable(WidgetGuildCreate.EXTRA_OPTIONS, options);
        j.g(j.g, fragment.getParentFragmentManager(), fragment.requireContext(), WidgetGuildCreate.class, 0, true, null, bundle, 40);
    }

    public /* synthetic */ WidgetGuildCreate$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

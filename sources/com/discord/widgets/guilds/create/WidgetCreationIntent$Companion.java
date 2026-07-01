package com.discord.widgets.guilds.create;

import b.a.d.j;
import com.discord.app.AppFragment;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetCreationIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreationIntent$Companion {
    private WidgetCreationIntent$Companion() {
    }

    public final void show(AppFragment fragment, CreateGuildTrigger trigger, WidgetGuildCreate$Options createGuildOptions) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(trigger, "trigger");
        m.checkNotNullParameter(createGuildOptions, "createGuildOptions");
        j.g(j.g, fragment.getParentFragmentManager(), fragment.requireContext(), WidgetCreationIntent.class, 0, true, null, new CreationIntentArgs(trigger, createGuildOptions), 40);
    }

    public /* synthetic */ WidgetCreationIntent$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

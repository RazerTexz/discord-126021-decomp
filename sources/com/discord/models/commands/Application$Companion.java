package com.discord.models.commands;

import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Application.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Application$Companion {
    private Application$Companion() {
    }

    public final Application fromApiApplication(com.discord.api.application.Application apiApplication) {
        m.checkNotNullParameter(apiApplication, "apiApplication");
        return new Application(apiApplication.getId(), apiApplication.getName(), apiApplication.getIcon(), null, 0, null, false, 104, null);
    }

    public /* synthetic */ Application$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

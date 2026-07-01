package com.discord.utilities.images;

import d0.z.d.m;

/* JADX INFO: compiled from: MGImages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGImages$AlwaysUpdateChangeDetector implements MGImages$ChangeDetector {
    public static final MGImages$AlwaysUpdateChangeDetector INSTANCE = new MGImages$AlwaysUpdateChangeDetector();

    private MGImages$AlwaysUpdateChangeDetector() {
    }

    @Override // com.discord.utilities.images.MGImages$ChangeDetector
    public boolean track(Object key, Object value) {
        m.checkNotNullParameter(key, "key");
        return true;
    }
}

package com.discord.api.science;

import java.util.List;

/* JADX INFO: compiled from: Science.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Science {
    private final List<Science$Event> events;
    private final String token;

    /* JADX WARN: Multi-variable type inference failed */
    public Science(String str, List<? extends Science$Event> list) {
        this.token = str;
        this.events = list;
    }
}

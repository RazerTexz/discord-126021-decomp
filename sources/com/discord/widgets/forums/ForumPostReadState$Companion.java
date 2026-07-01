package com.discord.widgets.forums;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ForumPostReadState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumPostReadState$Companion {
    private ForumPostReadState$Companion() {
    }

    public final ForumPostReadState createDefault(long channelId) {
        return new ForumPostReadState(channelId, true, false);
    }

    public /* synthetic */ ForumPostReadState$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

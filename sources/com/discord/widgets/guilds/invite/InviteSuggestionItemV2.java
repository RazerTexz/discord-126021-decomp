package com.discord.widgets.guilds.invite;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: InviteSuggestionItemV2.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class InviteSuggestionItemV2 implements MGRecyclerDataPayload {
    public static final InviteSuggestionItemV2$Companion Companion = new InviteSuggestionItemV2$Companion(null);
    public static final int TYPE_CHANNEL = 3;
    public static final int TYPE_EMPTY_SEARCH_RESULTS = 1;
    public static final int TYPE_USER = 2;

    private InviteSuggestionItemV2() {
    }

    public abstract boolean hasSentInvite();

    public /* synthetic */ InviteSuggestionItemV2(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

package com.discord.widgets.share;

import com.discord.widgets.chat.list.ViewEmbedGameInvite$Model;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$Model {
    private final String comment;
    private final WidgetIncomingShare$ContentModel contentModel;
    private final ViewEmbedGameInvite$Model gameInviteModel;
    private final boolean isOnCooldown;
    private final boolean isUserPremium;
    private final int maxFileSizeMB;
    private final WidgetGlobalSearchModel$ItemDataPayload receiver;
    private final WidgetGlobalSearchModel searchModel;

    public WidgetIncomingShare$Model(WidgetIncomingShare$ContentModel widgetIncomingShare$ContentModel, ViewEmbedGameInvite$Model viewEmbedGameInvite$Model, String str, WidgetGlobalSearchModel widgetGlobalSearchModel, WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload, boolean z2, int i, boolean z3) {
        m.checkNotNullParameter(widgetIncomingShare$ContentModel, "contentModel");
        m.checkNotNullParameter(widgetGlobalSearchModel, "searchModel");
        this.contentModel = widgetIncomingShare$ContentModel;
        this.gameInviteModel = viewEmbedGameInvite$Model;
        this.comment = str;
        this.searchModel = widgetGlobalSearchModel;
        this.receiver = widgetGlobalSearchModel$ItemDataPayload;
        this.isOnCooldown = z2;
        this.maxFileSizeMB = i;
        this.isUserPremium = z3;
    }

    public final String getComment() {
        return this.comment;
    }

    public final WidgetIncomingShare$ContentModel getContentModel() {
        return this.contentModel;
    }

    public final ViewEmbedGameInvite$Model getGameInviteModel() {
        return this.gameInviteModel;
    }

    public final int getMaxFileSizeMB() {
        return this.maxFileSizeMB;
    }

    public final WidgetGlobalSearchModel$ItemDataPayload getReceiver() {
        return this.receiver;
    }

    public final WidgetGlobalSearchModel getSearchModel() {
        return this.searchModel;
    }

    /* JADX INFO: renamed from: isOnCooldown, reason: from getter */
    public final boolean getIsOnCooldown() {
        return this.isOnCooldown;
    }

    /* JADX INFO: renamed from: isUserPremium, reason: from getter */
    public final boolean getIsUserPremium() {
        return this.isUserPremium;
    }
}

package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public interface WidgetGlobalSearchModel$ItemDataPayload extends MGRecyclerDataPayload {
    Channel getChannel();

    WidgetGlobalSearchModel$MatchedResult getMatchedResult();

    int getMentions();

    boolean getUnread();
}

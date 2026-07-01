package com.discord.widgets.guildscheduledevent;

import com.discord.simpleast.core.node.Node;
import com.discord.utilities.textprocessing.MessageRenderContext;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildScheduledEventDescriptionParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GuildScheduledEventDescriptionParser$DescriptionCache {
    private final List<Node<MessageRenderContext>> maybeAst;
    private final String maybeDescription;

    private GuildScheduledEventDescriptionParser$DescriptionCache(String str, List<Node<MessageRenderContext>> list) {
        this.maybeDescription = str;
        this.maybeAst = list;
    }

    public final List<Node<MessageRenderContext>> getMaybeAst() {
        return this.maybeAst;
    }

    public final String getMaybeDescription() {
        return this.maybeDescription;
    }

    public /* synthetic */ GuildScheduledEventDescriptionParser$DescriptionCache(String str, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list);
    }
}

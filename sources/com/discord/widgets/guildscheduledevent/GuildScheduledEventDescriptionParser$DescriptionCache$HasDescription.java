package com.discord.widgets.guildscheduledevent;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.textprocessing.MessageRenderContext;
import d0.z.d.m;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: GuildScheduledEventDescriptionParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventDescriptionParser$DescriptionCache$HasDescription extends GuildScheduledEventDescriptionParser$DescriptionCache {
    private final List<Node<MessageRenderContext>> ast;
    private final String description;
    private final Set<Integer> shownSpoilerIndices;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDescriptionParser$DescriptionCache$HasDescription(String str, List<Node<MessageRenderContext>> list, Set<Integer> set) {
        super(str, list, null);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        m.checkNotNullParameter(list, "ast");
        m.checkNotNullParameter(set, "shownSpoilerIndices");
        this.description = str;
        this.ast = list;
        this.shownSpoilerIndices = set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildScheduledEventDescriptionParser$DescriptionCache$HasDescription copy$default(GuildScheduledEventDescriptionParser$DescriptionCache$HasDescription guildScheduledEventDescriptionParser$DescriptionCache$HasDescription, String str, List list, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guildScheduledEventDescriptionParser$DescriptionCache$HasDescription.description;
        }
        if ((i & 2) != 0) {
            list = guildScheduledEventDescriptionParser$DescriptionCache$HasDescription.ast;
        }
        if ((i & 4) != 0) {
            set = guildScheduledEventDescriptionParser$DescriptionCache$HasDescription.shownSpoilerIndices;
        }
        return guildScheduledEventDescriptionParser$DescriptionCache$HasDescription.copy(str, list, set);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<Node<MessageRenderContext>> component2() {
        return this.ast;
    }

    public final Set<Integer> component3() {
        return this.shownSpoilerIndices;
    }

    public final GuildScheduledEventDescriptionParser$DescriptionCache$HasDescription copy(String description, List<Node<MessageRenderContext>> ast, Set<Integer> shownSpoilerIndices) {
        m.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        m.checkNotNullParameter(ast, "ast");
        m.checkNotNullParameter(shownSpoilerIndices, "shownSpoilerIndices");
        return new GuildScheduledEventDescriptionParser$DescriptionCache$HasDescription(description, ast, shownSpoilerIndices);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventDescriptionParser$DescriptionCache$HasDescription)) {
            return false;
        }
        GuildScheduledEventDescriptionParser$DescriptionCache$HasDescription guildScheduledEventDescriptionParser$DescriptionCache$HasDescription = (GuildScheduledEventDescriptionParser$DescriptionCache$HasDescription) other;
        return m.areEqual(this.description, guildScheduledEventDescriptionParser$DescriptionCache$HasDescription.description) && m.areEqual(this.ast, guildScheduledEventDescriptionParser$DescriptionCache$HasDescription.ast) && m.areEqual(this.shownSpoilerIndices, guildScheduledEventDescriptionParser$DescriptionCache$HasDescription.shownSpoilerIndices);
    }

    public final List<Node<MessageRenderContext>> getAst() {
        return this.ast;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Set<Integer> getShownSpoilerIndices() {
        return this.shownSpoilerIndices;
    }

    public int hashCode() {
        String str = this.description;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Node<MessageRenderContext>> list = this.ast;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        Set<Integer> set = this.shownSpoilerIndices;
        return iHashCode2 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("HasDescription(description=");
        sbU.append(this.description);
        sbU.append(", ast=");
        sbU.append(this.ast);
        sbU.append(", shownSpoilerIndices=");
        return a.N(sbU, this.shownSpoilerIndices, ")");
    }
}

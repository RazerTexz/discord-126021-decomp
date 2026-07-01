package com.discord.widgets.chat.list.adapter;

import b.d.b.a.a;
import com.discord.models.domain.ModelGuildTemplate;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListAdapterItemGuildTemplate$Model$Resolved extends WidgetChatListAdapterItemGuildTemplate$Model {
    private final ModelGuildTemplate guildTemplate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGuildTemplate$Model$Resolved(ModelGuildTemplate modelGuildTemplate) {
        super(null);
        m.checkNotNullParameter(modelGuildTemplate, "guildTemplate");
        this.guildTemplate = modelGuildTemplate;
    }

    public static /* synthetic */ WidgetChatListAdapterItemGuildTemplate$Model$Resolved copy$default(WidgetChatListAdapterItemGuildTemplate$Model$Resolved widgetChatListAdapterItemGuildTemplate$Model$Resolved, ModelGuildTemplate modelGuildTemplate, int i, Object obj) {
        if ((i & 1) != 0) {
            modelGuildTemplate = widgetChatListAdapterItemGuildTemplate$Model$Resolved.guildTemplate;
        }
        return widgetChatListAdapterItemGuildTemplate$Model$Resolved.copy(modelGuildTemplate);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelGuildTemplate getGuildTemplate() {
        return this.guildTemplate;
    }

    public final WidgetChatListAdapterItemGuildTemplate$Model$Resolved copy(ModelGuildTemplate guildTemplate) {
        m.checkNotNullParameter(guildTemplate, "guildTemplate");
        return new WidgetChatListAdapterItemGuildTemplate$Model$Resolved(guildTemplate);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetChatListAdapterItemGuildTemplate$Model$Resolved) && m.areEqual(this.guildTemplate, ((WidgetChatListAdapterItemGuildTemplate$Model$Resolved) other).guildTemplate);
        }
        return true;
    }

    public final ModelGuildTemplate getGuildTemplate() {
        return this.guildTemplate;
    }

    public int hashCode() {
        ModelGuildTemplate modelGuildTemplate = this.guildTemplate;
        if (modelGuildTemplate != null) {
            return modelGuildTemplate.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Resolved(guildTemplate=");
        sbU.append(this.guildTemplate);
        sbU.append(")");
        return sbU.toString();
    }
}

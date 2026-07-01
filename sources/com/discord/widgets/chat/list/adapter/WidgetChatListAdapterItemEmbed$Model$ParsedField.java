package com.discord.widgets.chat.list.adapter;

import b.d.b.a.a;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.textprocessing.MessageRenderContext;
import d0.z.d.m;
import java.util.Collection;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListAdapterItemEmbed$Model$ParsedField {
    private final Collection<Node<MessageRenderContext>> parsedName;
    private final Collection<Node<MessageRenderContext>> parsedValue;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChatListAdapterItemEmbed$Model$ParsedField(Collection<? extends Node<MessageRenderContext>> collection, Collection<? extends Node<MessageRenderContext>> collection2) {
        m.checkNotNullParameter(collection, "parsedName");
        m.checkNotNullParameter(collection2, "parsedValue");
        this.parsedName = collection;
        this.parsedValue = collection2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChatListAdapterItemEmbed$Model$ParsedField copy$default(WidgetChatListAdapterItemEmbed$Model$ParsedField widgetChatListAdapterItemEmbed$Model$ParsedField, Collection collection, Collection collection2, int i, Object obj) {
        if ((i & 1) != 0) {
            collection = widgetChatListAdapterItemEmbed$Model$ParsedField.parsedName;
        }
        if ((i & 2) != 0) {
            collection2 = widgetChatListAdapterItemEmbed$Model$ParsedField.parsedValue;
        }
        return widgetChatListAdapterItemEmbed$Model$ParsedField.copy(collection, collection2);
    }

    public final Collection<Node<MessageRenderContext>> component1() {
        return this.parsedName;
    }

    public final Collection<Node<MessageRenderContext>> component2() {
        return this.parsedValue;
    }

    public final WidgetChatListAdapterItemEmbed$Model$ParsedField copy(Collection<? extends Node<MessageRenderContext>> parsedName, Collection<? extends Node<MessageRenderContext>> parsedValue) {
        m.checkNotNullParameter(parsedName, "parsedName");
        m.checkNotNullParameter(parsedValue, "parsedValue");
        return new WidgetChatListAdapterItemEmbed$Model$ParsedField(parsedName, parsedValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListAdapterItemEmbed$Model$ParsedField)) {
            return false;
        }
        WidgetChatListAdapterItemEmbed$Model$ParsedField widgetChatListAdapterItemEmbed$Model$ParsedField = (WidgetChatListAdapterItemEmbed$Model$ParsedField) other;
        return m.areEqual(this.parsedName, widgetChatListAdapterItemEmbed$Model$ParsedField.parsedName) && m.areEqual(this.parsedValue, widgetChatListAdapterItemEmbed$Model$ParsedField.parsedValue);
    }

    public final Collection<Node<MessageRenderContext>> getParsedName() {
        return this.parsedName;
    }

    public final Collection<Node<MessageRenderContext>> getParsedValue() {
        return this.parsedValue;
    }

    public int hashCode() {
        Collection<Node<MessageRenderContext>> collection = this.parsedName;
        int iHashCode = (collection != null ? collection.hashCode() : 0) * 31;
        Collection<Node<MessageRenderContext>> collection2 = this.parsedValue;
        return iHashCode + (collection2 != null ? collection2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ParsedField(parsedName=");
        sbU.append(this.parsedName);
        sbU.append(", parsedValue=");
        sbU.append(this.parsedValue);
        sbU.append(")");
        return sbU.toString();
    }
}

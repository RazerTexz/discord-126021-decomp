package com.discord.widgets.voice.fullscreen;

import b.d.b.a.a;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter$ListItem;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetCallPreviewFullscreenViewModel$ParticipantsList$ListItems extends WidgetCallPreviewFullscreenViewModel$ParticipantsList {
    private final List<CallParticipantsAdapter$ListItem> items;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetCallPreviewFullscreenViewModel$ParticipantsList$ListItems(List<? extends CallParticipantsAdapter$ListItem> list) {
        super(null);
        m.checkNotNullParameter(list, "items");
        this.items = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetCallPreviewFullscreenViewModel$ParticipantsList$ListItems copy$default(WidgetCallPreviewFullscreenViewModel$ParticipantsList$ListItems widgetCallPreviewFullscreenViewModel$ParticipantsList$ListItems, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = widgetCallPreviewFullscreenViewModel$ParticipantsList$ListItems.items;
        }
        return widgetCallPreviewFullscreenViewModel$ParticipantsList$ListItems.copy(list);
    }

    public final List<CallParticipantsAdapter$ListItem> component1() {
        return this.items;
    }

    public final WidgetCallPreviewFullscreenViewModel$ParticipantsList$ListItems copy(List<? extends CallParticipantsAdapter$ListItem> items) {
        m.checkNotNullParameter(items, "items");
        return new WidgetCallPreviewFullscreenViewModel$ParticipantsList$ListItems(items);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetCallPreviewFullscreenViewModel$ParticipantsList$ListItems) && m.areEqual(this.items, ((WidgetCallPreviewFullscreenViewModel$ParticipantsList$ListItems) other).items);
        }
        return true;
    }

    public final List<CallParticipantsAdapter$ListItem> getItems() {
        return this.items;
    }

    public int hashCode() {
        List<CallParticipantsAdapter$ListItem> list = this.items;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("ListItems(items="), this.items, ")");
    }
}

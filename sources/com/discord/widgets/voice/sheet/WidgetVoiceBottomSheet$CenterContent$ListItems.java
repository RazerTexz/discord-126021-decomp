package com.discord.widgets.voice.sheet;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetVoiceBottomSheet$CenterContent$ListItems extends WidgetVoiceBottomSheet$CenterContent {
    private final List<CallParticipantsAdapter$ListItem> items;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetVoiceBottomSheet$CenterContent$ListItems(List<? extends CallParticipantsAdapter$ListItem> list) {
        super(null);
        m.checkNotNullParameter(list, "items");
        this.items = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetVoiceBottomSheet$CenterContent$ListItems copy$default(WidgetVoiceBottomSheet$CenterContent$ListItems widgetVoiceBottomSheet$CenterContent$ListItems, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = widgetVoiceBottomSheet$CenterContent$ListItems.items;
        }
        return widgetVoiceBottomSheet$CenterContent$ListItems.copy(list);
    }

    public final List<CallParticipantsAdapter$ListItem> component1() {
        return this.items;
    }

    public final WidgetVoiceBottomSheet$CenterContent$ListItems copy(List<? extends CallParticipantsAdapter$ListItem> items) {
        m.checkNotNullParameter(items, "items");
        return new WidgetVoiceBottomSheet$CenterContent$ListItems(items);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetVoiceBottomSheet$CenterContent$ListItems) && m.areEqual(this.items, ((WidgetVoiceBottomSheet$CenterContent$ListItems) other).items);
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

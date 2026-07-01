package com.discord.widgets.stage.start;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModeratorStartStageItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ModeratorStartStageItem$ListItem$StaticOption$ScheduleEvent extends ModeratorStartStageItem$ListItem$StaticOption {
    private final String key;

    public ModeratorStartStageItem$ListItem$StaticOption$ScheduleEvent() {
        this(null, 1, null);
    }

    public /* synthetic */ ModeratorStartStageItem$ListItem$StaticOption$ScheduleEvent(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ModeratorStartStageItem.KEY_SCHEDULE_EVENT : str);
    }

    public static /* synthetic */ ModeratorStartStageItem$ListItem$StaticOption$ScheduleEvent copy$default(ModeratorStartStageItem$ListItem$StaticOption$ScheduleEvent moderatorStartStageItem$ListItem$StaticOption$ScheduleEvent, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = moderatorStartStageItem$ListItem$StaticOption$ScheduleEvent.getKey();
        }
        return moderatorStartStageItem$ListItem$StaticOption$ScheduleEvent.copy(str);
    }

    public final String component1() {
        return getKey();
    }

    public final ModeratorStartStageItem$ListItem$StaticOption$ScheduleEvent copy(String key) {
        m.checkNotNullParameter(key, "key");
        return new ModeratorStartStageItem$ListItem$StaticOption$ScheduleEvent(key);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModeratorStartStageItem$ListItem$StaticOption$ScheduleEvent) && m.areEqual(getKey(), ((ModeratorStartStageItem$ListItem$StaticOption$ScheduleEvent) other).getKey());
        }
        return true;
    }

    @Override // com.discord.widgets.stage.start.ModeratorStartStageItem$ListItem$StaticOption, com.discord.widgets.stage.start.ModeratorStartStageItem$ListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public int hashCode() {
        String key = getKey();
        if (key != null) {
            return key.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("ScheduleEvent(key=");
        sbU.append(getKey());
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModeratorStartStageItem$ListItem$StaticOption$ScheduleEvent(String str) {
        super(str, 2131231750, 2131099767, 2131895236, 2131895237, null);
        m.checkNotNullParameter(str, "key");
        this.key = str;
    }
}

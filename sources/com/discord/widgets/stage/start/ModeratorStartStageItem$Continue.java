package com.discord.widgets.stage.start;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModeratorStartStageItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ModeratorStartStageItem$Continue extends ModeratorStartStageItem {
    private final String key;
    private final int type;

    public ModeratorStartStageItem$Continue() {
        this(0, null, 3, null);
    }

    public /* synthetic */ ModeratorStartStageItem$Continue(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 2 : i, (i2 & 2) != 0 ? "KEY_CREATE_STAGE_EVENT_CONTINUE" : str);
    }

    public static /* synthetic */ ModeratorStartStageItem$Continue copy$default(ModeratorStartStageItem$Continue moderatorStartStageItem$Continue, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = moderatorStartStageItem$Continue.getType();
        }
        if ((i2 & 2) != 0) {
            str = moderatorStartStageItem$Continue.getKey();
        }
        return moderatorStartStageItem$Continue.copy(i, str);
    }

    public final int component1() {
        return getType();
    }

    public final String component2() {
        return getKey();
    }

    public final ModeratorStartStageItem$Continue copy(int type, String key) {
        m.checkNotNullParameter(key, "key");
        return new ModeratorStartStageItem$Continue(type, key);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModeratorStartStageItem$Continue)) {
            return false;
        }
        ModeratorStartStageItem$Continue moderatorStartStageItem$Continue = (ModeratorStartStageItem$Continue) other;
        return getType() == moderatorStartStageItem$Continue.getType() && m.areEqual(getKey(), moderatorStartStageItem$Continue.getKey());
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        int type = getType() * 31;
        String key = getKey();
        return type + (key != null ? key.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Continue(type=");
        sbU.append(getType());
        sbU.append(", key=");
        sbU.append(getKey());
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModeratorStartStageItem$Continue(int i, String str) {
        super(null);
        m.checkNotNullParameter(str, "key");
        this.type = i;
        this.key = str;
    }
}

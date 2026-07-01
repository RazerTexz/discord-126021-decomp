package com.discord.widgets.stage.start;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModeratorStartStageItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ModeratorStartStageItem$ListItem$StaticOption$StartStage extends ModeratorStartStageItem$ListItem$StaticOption {
    private final String key;

    public ModeratorStartStageItem$ListItem$StaticOption$StartStage() {
        this(null, 1, null);
    }

    public /* synthetic */ ModeratorStartStageItem$ListItem$StaticOption$StartStage(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ModeratorStartStageItem.KEY_START_STAGE : str);
    }

    public static /* synthetic */ ModeratorStartStageItem$ListItem$StaticOption$StartStage copy$default(ModeratorStartStageItem$ListItem$StaticOption$StartStage moderatorStartStageItem$ListItem$StaticOption$StartStage, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = moderatorStartStageItem$ListItem$StaticOption$StartStage.getKey();
        }
        return moderatorStartStageItem$ListItem$StaticOption$StartStage.copy(str);
    }

    public final String component1() {
        return getKey();
    }

    public final ModeratorStartStageItem$ListItem$StaticOption$StartStage copy(String key) {
        m.checkNotNullParameter(key, "key");
        return new ModeratorStartStageItem$ListItem$StaticOption$StartStage(key);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModeratorStartStageItem$ListItem$StaticOption$StartStage) && m.areEqual(getKey(), ((ModeratorStartStageItem$ListItem$StaticOption$StartStage) other).getKey());
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
        StringBuilder sbU = a.U("StartStage(key=");
        sbU.append(getKey());
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModeratorStartStageItem$ListItem$StaticOption$StartStage(String str) {
        super(str, 2131231625, 2131100304, 2131895801, 2131895800, null);
        m.checkNotNullParameter(str, "key");
        this.key = str;
    }
}

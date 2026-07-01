package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.api.thread.MuteConfig;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelMuteConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelMuteConfig {
    public static final ModelMuteConfig$Parser Parser = new ModelMuteConfig$Parser(null);
    private final String endTime;
    private final Long endTimeMs;

    public ModelMuteConfig(Long l, String str) {
        this.endTimeMs = l;
        this.endTime = str;
    }

    public static /* synthetic */ ModelMuteConfig copy$default(ModelMuteConfig modelMuteConfig, Long l, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            l = modelMuteConfig.endTimeMs;
        }
        if ((i & 2) != 0) {
            str = modelMuteConfig.endTime;
        }
        return modelMuteConfig.copy(l, str);
    }

    public static ModelMuteConfig parse(Model$JsonReader model$JsonReader) {
        return Parser.parse(model$JsonReader);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getEndTimeMs() {
        return this.endTimeMs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    public final ModelMuteConfig copy(Long endTimeMs, String endTime) {
        return new ModelMuteConfig(endTimeMs, endTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelMuteConfig)) {
            return false;
        }
        ModelMuteConfig modelMuteConfig = (ModelMuteConfig) other;
        return m.areEqual(this.endTimeMs, modelMuteConfig.endTimeMs) && m.areEqual(this.endTime, modelMuteConfig.endTime);
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final Long getEndTimeMs() {
        return this.endTimeMs;
    }

    public int hashCode() {
        Long l = this.endTimeMs;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        String str = this.endTime;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelMuteConfig(endTimeMs=");
        sbU.append(this.endTimeMs);
        sbU.append(", endTime=");
        return a.J(sbU, this.endTime, ")");
    }

    public ModelMuteConfig(Long l) {
        this(l, l != null ? TimeUtils.toUTCDateTime$default(Long.valueOf(l.longValue()), null, 2, null) : null);
    }

    public ModelMuteConfig(String str) {
        this(str != null ? Long.valueOf(TimeUtils.parseUTCDate(str)) : null, str);
    }

    public ModelMuteConfig(MuteConfig muteConfig) {
        this(Long.valueOf(TimeUtils.parseUTCDate(muteConfig != null ? muteConfig.getEndTime() : null)), muteConfig != null ? muteConfig.getEndTime() : null);
    }
}

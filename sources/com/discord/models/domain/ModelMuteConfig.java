package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.api.thread.MuteConfig;
import com.discord.models.domain.Model;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelMuteConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelMuteConfig {

    /* JADX INFO: renamed from: Parser, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String endTime;
    private final Long endTimeMs;

    /* JADX INFO: renamed from: com.discord.models.domain.ModelMuteConfig$Parser, reason: from kotlin metadata */
    /* JADX INFO: compiled from: ModelMuteConfig.kt */
    public static final class Companion implements Model.Parser<ModelMuteConfig> {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelMuteConfig parse(final Model.JsonReader reader) throws IOException {
            final Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            reader.nextObject(new Action1<String>() { // from class: com.discord.models.domain.ModelMuteConfig$Parser$parse$1
                @Override // rx.functions.Action1
                public final void call(String str) throws IOException {
                    if (str == null || str.hashCode() != 1725551537 || !str.equals("end_time")) {
                        reader.skipValue();
                    } else {
                        ref$ObjectRefC0.element = (T) reader.nextStringOrNull();
                    }
                }
            });
            return new ModelMuteConfig((String) ref$ObjectRefC0.element);
        }
    }

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

    public static ModelMuteConfig parse(Model.JsonReader jsonReader) {
        return INSTANCE.parse(jsonReader);
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
        return Intrinsics3.areEqual(this.endTimeMs, modelMuteConfig.endTimeMs) && Intrinsics3.areEqual(this.endTime, modelMuteConfig.endTime);
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
        StringBuilder sbU = outline.U("ModelMuteConfig(endTimeMs=");
        sbU.append(this.endTimeMs);
        sbU.append(", endTime=");
        return outline.J(sbU, this.endTime, ")");
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

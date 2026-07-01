package com.discord.models.experiments.dto;

import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentFilter$Parser$parseRange$1$2 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $fieldHash;
    public final /* synthetic */ GuildExperimentFilter$Parser$parseRange$1 this$0;

    public GuildExperimentFilter$Parser$parseRange$1$2(GuildExperimentFilter$Parser$parseRange$1 guildExperimentFilter$Parser$parseRange$1, Ref$ObjectRef ref$ObjectRef) {
        this.this$0 = guildExperimentFilter$Parser$parseRange$1;
        this.$fieldHash = ref$ObjectRef;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r0v9, types: [T, java.lang.Long] */
    @Override // java.lang.Runnable
    public final void run() {
        Long l = (Long) this.$fieldHash.element;
        GuildExperimentFilter$Parser guildExperimentFilter$Parser = GuildExperimentFilter$Parser.INSTANCE;
        long jAccess$getMIN_ID_HASH$p = GuildExperimentFilter$Parser.access$getMIN_ID_HASH$p(guildExperimentFilter$Parser);
        if (l != null && l.longValue() == jAccess$getMIN_ID_HASH$p) {
            GuildExperimentFilter$Parser$parseRange$1 guildExperimentFilter$Parser$parseRange$1 = this.this$0;
            guildExperimentFilter$Parser$parseRange$1.$start.element = guildExperimentFilter$Parser$parseRange$1.$reader.nextLongOrNull();
        } else {
            Long l2 = (Long) this.$fieldHash.element;
            long jAccess$getMAX_ID_HASH$p = GuildExperimentFilter$Parser.access$getMAX_ID_HASH$p(guildExperimentFilter$Parser);
            if (l2 != null && l2.longValue() == jAccess$getMAX_ID_HASH$p) {
                GuildExperimentFilter$Parser$parseRange$1 guildExperimentFilter$Parser$parseRange$2 = this.this$0;
                guildExperimentFilter$Parser$parseRange$2.$end.element = guildExperimentFilter$Parser$parseRange$2.$reader.nextLongOrNull();
            }
        }
        this.$fieldHash.element = null;
    }
}

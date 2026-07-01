package com.discord.models.experiments.dto;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model$JsonReader;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentOverridesDto$Parser$parse$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$IntRef $bucket;
    public final /* synthetic */ Ref$ObjectRef $guildIds;
    public final /* synthetic */ Model$JsonReader $reader;

    public GuildExperimentOverridesDto$Parser$parse$1(Ref$IntRef ref$IntRef, Model$JsonReader model$JsonReader, Ref$ObjectRef ref$ObjectRef) {
        this.$bucket = ref$IntRef;
        this.$reader = model$JsonReader;
        this.$guildIds = ref$ObjectRef;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) {
        if (str == null) {
            return;
        }
        int iHashCode = str.hashCode();
        if (iHashCode == 98) {
            if (str.equals("b")) {
                Ref$IntRef ref$IntRef = this.$bucket;
                ref$IntRef.element = this.$reader.nextInt(ref$IntRef.element);
                return;
            }
            return;
        }
        if (iHashCode == 107 && str.equals("k")) {
            Ref$ObjectRef ref$ObjectRef = this.$guildIds;
            T t = (T) this.$reader.nextList(new GuildExperimentOverridesDto$Parser$parse$1$1(this));
            m.checkNotNullExpressionValue(t, "reader.nextList { reader.nextLong(-1L) }");
            ref$ObjectRef.element = t;
        }
    }
}

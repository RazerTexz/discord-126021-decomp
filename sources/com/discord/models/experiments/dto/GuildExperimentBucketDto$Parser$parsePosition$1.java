package com.discord.models.experiments.dto;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model$JsonReader;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.IOException;
import kotlin.jvm.internal.Ref$IntRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentBucketDto$Parser$parsePosition$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$IntRef $end;
    public final /* synthetic */ Model$JsonReader $jsonReader;
    public final /* synthetic */ Ref$IntRef $start;

    public GuildExperimentBucketDto$Parser$parsePosition$1(Ref$IntRef ref$IntRef, Model$JsonReader model$JsonReader, Ref$IntRef ref$IntRef2) {
        this.$start = ref$IntRef;
        this.$jsonReader = model$JsonReader;
        this.$end = ref$IntRef2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != 101) {
                if (iHashCode == 115 && str.equals("s")) {
                    Ref$IntRef ref$IntRef = this.$start;
                    ref$IntRef.element = this.$jsonReader.nextInt(ref$IntRef.element);
                    return;
                }
            } else if (str.equals("e")) {
                Ref$IntRef ref$IntRef2 = this.$end;
                ref$IntRef2.element = this.$jsonReader.nextInt(ref$IntRef2.element);
                return;
            }
        }
        this.$jsonReader.skipValue();
    }
}

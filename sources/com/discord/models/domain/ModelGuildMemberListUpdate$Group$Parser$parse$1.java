package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelGuildMemberListUpdate$Group$Parser$parse$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$IntRef $count;
    public final /* synthetic */ Ref$ObjectRef $id;
    public final /* synthetic */ Model$JsonReader $reader;

    public ModelGuildMemberListUpdate$Group$Parser$parse$1(Ref$ObjectRef ref$ObjectRef, Model$JsonReader model$JsonReader, Ref$IntRef ref$IntRef) {
        this.$id = ref$ObjectRef;
        this.$reader = model$JsonReader;
        this.$count = ref$IntRef;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != 3355) {
                if (iHashCode == 94851343 && str.equals("count")) {
                    Ref$IntRef ref$IntRef = this.$count;
                    Integer numNextIntOrNull = this.$reader.nextIntOrNull();
                    m.checkNotNullExpressionValue(numNextIntOrNull, "reader.nextIntOrNull()");
                    ref$IntRef.element = numNextIntOrNull.intValue();
                    return;
                }
            } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                Ref$ObjectRef ref$ObjectRef = this.$id;
                T t = (T) this.$reader.nextString("");
                m.checkNotNullExpressionValue(t, "reader.nextString(\"\")");
                ref$ObjectRef.element = t;
                return;
            }
        }
        this.$reader.skipValue();
    }
}

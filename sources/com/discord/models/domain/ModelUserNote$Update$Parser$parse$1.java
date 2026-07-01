package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelUserNote.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelUserNote$Update$Parser$parse$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$LongRef $id;
    public final /* synthetic */ Ref$ObjectRef $note;
    public final /* synthetic */ Model$JsonReader $reader;

    public ModelUserNote$Update$Parser$parse$1(Ref$LongRef ref$LongRef, Model$JsonReader model$JsonReader, Ref$ObjectRef ref$ObjectRef) {
        this.$id = ref$LongRef;
        this.$reader = model$JsonReader;
        this.$note = ref$ObjectRef;
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
                if (iHashCode == 3387378 && str.equals("note")) {
                    Ref$ObjectRef ref$ObjectRef = this.$note;
                    T t = (T) this.$reader.nextString("");
                    m.checkNotNullExpressionValue(t, "reader.nextString(\"\")");
                    ref$ObjectRef.element = t;
                    return;
                }
            } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                this.$id.element = this.$reader.nextLong(0L);
                return;
            }
        }
        this.$reader.skipValue();
    }
}

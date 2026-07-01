package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StreamDelete$Parser$parse$1<T> implements Action1<String> {
    public final /* synthetic */ Model$JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $reasonStr;
    public final /* synthetic */ Ref$ObjectRef $streamKey;
    public final /* synthetic */ Ref$ObjectRef $unavailable;

    public StreamDelete$Parser$parse$1(Ref$ObjectRef ref$ObjectRef, Model$JsonReader model$JsonReader, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3) {
        this.$streamKey = ref$ObjectRef;
        this.$reader = model$JsonReader;
        this.$reasonStr = ref$ObjectRef2;
        this.$unavailable = ref$ObjectRef3;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -1194435296) {
                if (iHashCode != -934964668) {
                    if (iHashCode == -665462704 && str.equals("unavailable")) {
                        this.$unavailable.element = (T) this.$reader.nextBooleanOrNull();
                        return;
                    }
                } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_REASON)) {
                    this.$reasonStr.element = (T) this.$reader.nextStringOrNull();
                    return;
                }
            } else if (str.equals("stream_key")) {
                Ref$ObjectRef ref$ObjectRef = this.$streamKey;
                T t = (T) this.$reader.nextStringOrNull();
                m.checkNotNull(t);
                ref$ObjectRef.element = t;
                return;
            }
        }
        this.$reader.skipValue();
    }
}

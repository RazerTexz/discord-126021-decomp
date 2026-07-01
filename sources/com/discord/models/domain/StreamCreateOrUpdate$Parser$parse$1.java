package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StreamCreateOrUpdate$Parser$parse$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$BooleanRef $paused;
    public final /* synthetic */ Model$JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $rtcServerId;
    public final /* synthetic */ Ref$ObjectRef $streamKey;
    public final /* synthetic */ Ref$ObjectRef $viewerIds;

    public StreamCreateOrUpdate$Parser$parse$1(Ref$ObjectRef ref$ObjectRef, Model$JsonReader model$JsonReader, Ref$ObjectRef ref$ObjectRef2, Ref$BooleanRef ref$BooleanRef, Ref$ObjectRef ref$ObjectRef3) {
        this.$streamKey = ref$ObjectRef;
        this.$reader = model$JsonReader;
        this.$rtcServerId = ref$ObjectRef2;
        this.$paused = ref$BooleanRef;
        this.$viewerIds = ref$ObjectRef3;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            switch (str.hashCode()) {
                case -1349214453:
                    if (str.equals("viewer_ids")) {
                        this.$viewerIds.element = (T) this.$reader.nextList(new StreamCreateOrUpdate$Parser$parse$1$1(this));
                        return;
                    }
                    break;
                case -1194435296:
                    if (str.equals("stream_key")) {
                        Ref$ObjectRef ref$ObjectRef = this.$streamKey;
                        T t = (T) this.$reader.nextStringOrNull();
                        m.checkNotNull(t);
                        ref$ObjectRef.element = t;
                        return;
                    }
                    break;
                case -995321554:
                    if (str.equals("paused")) {
                        Ref$BooleanRef ref$BooleanRef = this.$paused;
                        Boolean boolNextBooleanOrNull = this.$reader.nextBooleanOrNull();
                        m.checkNotNullExpressionValue(boolNextBooleanOrNull, "reader.nextBooleanOrNull()");
                        ref$BooleanRef.element = boolNextBooleanOrNull.booleanValue();
                        return;
                    }
                    break;
                case -490387655:
                    if (str.equals("rtc_server_id")) {
                        this.$rtcServerId.element = (T) this.$reader.nextStringOrNull();
                        return;
                    }
                    break;
            }
        }
        this.$reader.skipValue();
    }
}

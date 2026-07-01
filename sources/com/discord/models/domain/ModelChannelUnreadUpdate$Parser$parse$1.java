package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelChannelUnreadUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelChannelUnreadUpdate$Parser$parse$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $channelReadStates;
    public final /* synthetic */ Model$JsonReader $reader;

    public ModelChannelUnreadUpdate$Parser$parse$1(Ref$ObjectRef ref$ObjectRef, Model$JsonReader model$JsonReader) {
        this.$channelReadStates = ref$ObjectRef;
        this.$reader = model$JsonReader;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str == null || str.hashCode() != -298662154 || !str.equals("channel_unread_updates")) {
            this.$reader.skipValue();
            return;
        }
        Ref$ObjectRef ref$ObjectRef = this.$channelReadStates;
        T t = (T) this.$reader.nextList(new ModelChannelUnreadUpdate$Parser$parse$1$1(this));
        m.checkNotNullExpressionValue(t, "reader.nextList { ModelR…te.Parser.parse(reader) }");
        ref$ObjectRef.element = t;
    }
}

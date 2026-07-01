package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelMuteConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelMuteConfig$Parser$parse$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $endTime;
    public final /* synthetic */ Model$JsonReader $reader;

    public ModelMuteConfig$Parser$parse$1(Ref$ObjectRef ref$ObjectRef, Model$JsonReader model$JsonReader) {
        this.$endTime = ref$ObjectRef;
        this.$reader = model$JsonReader;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str == null || str.hashCode() != 1725551537 || !str.equals("end_time")) {
            this.$reader.skipValue();
        } else {
            this.$endTime.element = (T) this.$reader.nextStringOrNull();
        }
    }
}

package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelPhoneVerificationToken.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelPhoneVerificationToken$Update$Parser$parse$1<T> implements Action1<String> {
    public final /* synthetic */ Model$JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $token;

    public ModelPhoneVerificationToken$Update$Parser$parse$1(Ref$ObjectRef ref$ObjectRef, Model$JsonReader model$JsonReader) {
        this.$token = ref$ObjectRef;
        this.$reader = model$JsonReader;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str == null || str.hashCode() != 110541305 || !str.equals("token")) {
            this.$reader.skipValue();
            return;
        }
        Ref$ObjectRef ref$ObjectRef = this.$token;
        T t = (T) this.$reader.nextString("");
        m.checkNotNullExpressionValue(t, "reader.nextString(\"\")");
        ref$ObjectRef.element = t;
    }
}

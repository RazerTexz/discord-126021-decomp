package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelSku.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelSku$Price$Parser$parse$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $amount;
    public final /* synthetic */ Ref$ObjectRef $currency;
    public final /* synthetic */ Model$JsonReader $reader;

    public ModelSku$Price$Parser$parse$1(Ref$ObjectRef ref$ObjectRef, Model$JsonReader model$JsonReader, Ref$ObjectRef ref$ObjectRef2) {
        this.$amount = ref$ObjectRef;
        this.$reader = model$JsonReader;
        this.$currency = ref$ObjectRef2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -1413853096) {
                if (iHashCode == 575402001 && str.equals("currency")) {
                    this.$currency.element = (T) this.$reader.nextStringOrNull();
                    return;
                }
            } else if (str.equals("amount")) {
                this.$amount.element = (T) this.$reader.nextIntOrNull();
                return;
            }
        }
        this.$reader.skipValue();
    }
}

package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelStoreListing.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelStoreListing$Parser$parse$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $id;
    public final /* synthetic */ Model$JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $sku;

    public ModelStoreListing$Parser$parse$1(Ref$ObjectRef ref$ObjectRef, Model$JsonReader model$JsonReader, Ref$ObjectRef ref$ObjectRef2) {
        this.$sku = ref$ObjectRef;
        this.$reader = model$JsonReader;
        this.$id = ref$ObjectRef2;
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
                if (iHashCode == 113949 && str.equals("sku")) {
                    this.$sku.element = (T) ModelSku$Parser.INSTANCE.parse(this.$reader);
                    return;
                }
            } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                this.$id.element = (T) this.$reader.nextLongOrNull();
                return;
            }
        }
        this.$reader.skipValue();
    }
}

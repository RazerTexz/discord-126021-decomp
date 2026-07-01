package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.api.application.Application;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelLibraryApplication.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelLibraryApplication$Parser$parse$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $application;
    public final /* synthetic */ Ref$ObjectRef $branchId;
    public final /* synthetic */ Ref$ObjectRef $createdAt;
    public final /* synthetic */ Ref$ObjectRef $flags;
    public final /* synthetic */ Model$JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $skuId;

    public ModelLibraryApplication$Parser$parse$1(Ref$ObjectRef ref$ObjectRef, Model$JsonReader model$JsonReader, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, Ref$ObjectRef ref$ObjectRef4, Ref$ObjectRef ref$ObjectRef5) {
        this.$application = ref$ObjectRef;
        this.$reader = model$JsonReader;
        this.$createdAt = ref$ObjectRef2;
        this.$skuId = ref$ObjectRef3;
        this.$flags = ref$ObjectRef4;
        this.$branchId = ref$ObjectRef5;
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
                case -900217987:
                    if (str.equals("sku_id")) {
                        this.$skuId.element = (T) this.$reader.nextLongOrNull();
                        return;
                    }
                    break;
                case -787623720:
                    if (str.equals("branch_id")) {
                        this.$branchId.element = (T) this.$reader.nextLongOrNull();
                        return;
                    }
                    break;
                case 97513095:
                    if (str.equals("flags")) {
                        this.$flags.element = (T) this.$reader.nextIntOrNull();
                        return;
                    }
                    break;
                case 1369680106:
                    if (str.equals("created_at")) {
                        this.$createdAt.element = (T) this.$reader.nextStringOrNull();
                        return;
                    }
                    break;
                case 1554253136:
                    if (str.equals("application")) {
                        this.$application.element = (T) ((Application) InboundGatewayGsonParser.fromJson(this.$reader, Application.class));
                        return;
                    }
                    break;
            }
        }
        this.$reader.skipValue();
    }
}

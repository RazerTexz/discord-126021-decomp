package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.api.application.Application;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelSku.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelSku$Parser$parse$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $application;
    public final /* synthetic */ Ref$ObjectRef $applicationId;
    public final /* synthetic */ Ref$ObjectRef $flags;
    public final /* synthetic */ Ref$ObjectRef $id;
    public final /* synthetic */ Ref$ObjectRef $name;
    public final /* synthetic */ Ref$ObjectRef $premium;
    public final /* synthetic */ Ref$ObjectRef $price;
    public final /* synthetic */ Model$JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $type;

    public ModelSku$Parser$parse$1(Ref$ObjectRef ref$ObjectRef, Model$JsonReader model$JsonReader, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, Ref$ObjectRef ref$ObjectRef4, Ref$ObjectRef ref$ObjectRef5, Ref$ObjectRef ref$ObjectRef6, Ref$ObjectRef ref$ObjectRef7, Ref$ObjectRef ref$ObjectRef8) {
        this.$applicationId = ref$ObjectRef;
        this.$reader = model$JsonReader;
        this.$name = ref$ObjectRef2;
        this.$id = ref$ObjectRef3;
        this.$application = ref$ObjectRef4;
        this.$premium = ref$ObjectRef5;
        this.$type = ref$ObjectRef6;
        this.$price = ref$ObjectRef7;
        this.$flags = ref$ObjectRef8;
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
                case -1287148950:
                    if (str.equals(ModelAuditLogEntry.CHANGE_KEY_APPLICATION_ID)) {
                        this.$applicationId.element = (T) this.$reader.nextLongOrNull();
                        return;
                    }
                    break;
                case -318452137:
                    if (str.equals("premium")) {
                        this.$premium.element = (T) this.$reader.nextBooleanOrNull();
                        return;
                    }
                    break;
                case 3355:
                    if (str.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                        this.$id.element = (T) this.$reader.nextLongOrNull();
                        return;
                    }
                    break;
                case 3373707:
                    if (str.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                        this.$name.element = (T) this.$reader.nextStringOrNull();
                        return;
                    }
                    break;
                case 3575610:
                    if (str.equals("type")) {
                        this.$type.element = (T) this.$reader.nextIntOrNull();
                        return;
                    }
                    break;
                case 97513095:
                    if (str.equals("flags")) {
                        this.$flags.element = (T) this.$reader.nextIntOrNull();
                        return;
                    }
                    break;
                case 106934601:
                    if (str.equals("price")) {
                        this.$price.element = (T) ModelSku$Price$Parser.INSTANCE.parse(this.$reader);
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

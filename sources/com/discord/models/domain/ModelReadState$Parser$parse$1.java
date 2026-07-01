package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelReadState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelReadState$Parser$parse$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$LongRef $channelId;
    public final /* synthetic */ Ref$LongRef $id;
    public final /* synthetic */ Ref$LongRef $lastMessageId;
    public final /* synthetic */ Ref$IntRef $mentionCount;
    public final /* synthetic */ Ref$LongRef $messageId;
    public final /* synthetic */ Model$JsonReader $reader;
    public final /* synthetic */ Ref$IntRef $version;

    public ModelReadState$Parser$parse$1(Ref$LongRef ref$LongRef, Model$JsonReader model$JsonReader, Ref$IntRef ref$IntRef, Ref$LongRef ref$LongRef2, Ref$LongRef ref$LongRef3, Ref$LongRef ref$LongRef4, Ref$IntRef ref$IntRef2) {
        this.$id = ref$LongRef;
        this.$reader = model$JsonReader;
        this.$mentionCount = ref$IntRef;
        this.$lastMessageId = ref$LongRef2;
        this.$messageId = ref$LongRef3;
        this.$channelId = ref$LongRef4;
        this.$version = ref$IntRef2;
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
                case -1930808873:
                    if (str.equals(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID)) {
                        Ref$LongRef ref$LongRef = this.$channelId;
                        ref$LongRef.element = this.$reader.nextLong(ref$LongRef.element);
                        return;
                    }
                    break;
                case -1690722221:
                    if (str.equals("message_id")) {
                        Ref$LongRef ref$LongRef2 = this.$messageId;
                        ref$LongRef2.element = this.$reader.nextLong(ref$LongRef2.element);
                        return;
                    }
                    break;
                case -83031652:
                    if (str.equals("last_message_id")) {
                        Ref$LongRef ref$LongRef3 = this.$lastMessageId;
                        ref$LongRef3.element = this.$reader.nextLong(ref$LongRef3.element);
                        return;
                    }
                    break;
                case 3355:
                    if (str.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                        this.$id.element = this.$reader.nextLong(0L);
                        return;
                    }
                    break;
                case 351608024:
                    if (str.equals("version")) {
                        Ref$IntRef ref$IntRef = this.$version;
                        ref$IntRef.element = this.$reader.nextInt(ref$IntRef.element);
                        return;
                    }
                    break;
                case 2144418426:
                    if (str.equals("mention_count")) {
                        Ref$IntRef ref$IntRef2 = this.$mentionCount;
                        ref$IntRef2.element = this.$reader.nextInt(ref$IntRef2.element);
                        return;
                    }
                    break;
            }
        }
        this.$reader.skipValue();
    }
}

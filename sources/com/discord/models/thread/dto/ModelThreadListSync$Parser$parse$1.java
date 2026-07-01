package com.discord.models.thread.dto;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model$JsonReader;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.gson.stream.JsonToken;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelThreadListSync.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelThreadListSync$Parser$parse$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$LongRef $guildId;
    public final /* synthetic */ Ref$ObjectRef $members;
    public final /* synthetic */ Ref$ObjectRef $mostRecentMessages;
    public final /* synthetic */ Model$JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $threads;

    public ModelThreadListSync$Parser$parse$1(Ref$LongRef ref$LongRef, Model$JsonReader model$JsonReader, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3) {
        this.$guildId = ref$LongRef;
        this.$reader = model$JsonReader;
        this.$threads = ref$ObjectRef;
        this.$members = ref$ObjectRef2;
        this.$mostRecentMessages = ref$ObjectRef3;
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
                case -1337936983:
                    if (str.equals("threads")) {
                        this.$threads.element = (T) this.$reader.nextList(new ModelThreadListSync$Parser$parse$1$1(this));
                        return;
                    }
                    break;
                case -1306538777:
                    if (str.equals(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID)) {
                        Ref$LongRef ref$LongRef = this.$guildId;
                        Long lNextLongOrNull = this.$reader.nextLongOrNull();
                        m.checkNotNull(lNextLongOrNull);
                        ref$LongRef.element = lNextLongOrNull.longValue();
                        return;
                    }
                    break;
                case 948881689:
                    if (str.equals("members")) {
                        if (this.$reader.peek() != JsonToken.BEGIN_ARRAY) {
                            this.$reader.nextObject(new ModelThreadListSync$Parser$parse$1$3(this));
                            return;
                        }
                        Ref$ObjectRef ref$ObjectRef = this.$members;
                        T t = (T) this.$reader.nextList(new ModelThreadListSync$Parser$parse$1$2(this));
                        m.checkNotNullExpressionValue(t, "reader.nextList { Inboun…readMember::class.java) }");
                        ref$ObjectRef.element = t;
                        return;
                    }
                    break;
                case 1472794100:
                    if (str.equals("most_recent_messages")) {
                        this.$mostRecentMessages.element = (T) this.$reader.nextList(new ModelThreadListSync$Parser$parse$1$4(this));
                        return;
                    }
                    break;
            }
        }
        this.$reader.skipValue();
    }
}

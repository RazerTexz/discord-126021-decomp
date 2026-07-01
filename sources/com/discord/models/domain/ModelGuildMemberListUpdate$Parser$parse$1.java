package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelGuildMemberListUpdate$Parser$parse$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $groups;
    public final /* synthetic */ Ref$ObjectRef $guildId;
    public final /* synthetic */ Ref$ObjectRef $id;
    public final /* synthetic */ Ref$ObjectRef $operations;
    public final /* synthetic */ Model$JsonReader $reader;

    public ModelGuildMemberListUpdate$Parser$parse$1(Ref$ObjectRef ref$ObjectRef, Model$JsonReader model$JsonReader, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, Ref$ObjectRef ref$ObjectRef4) {
        this.$guildId = ref$ObjectRef;
        this.$reader = model$JsonReader;
        this.$id = ref$ObjectRef2;
        this.$operations = ref$ObjectRef3;
        this.$groups = ref$ObjectRef4;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -1306538777) {
                if (iHashCode != -1237460524) {
                    if (iHashCode != 3355) {
                        if (iHashCode == 110258 && str.equals("ops")) {
                            this.$operations.element = (T) this.$reader.nextList(new ModelGuildMemberListUpdate$Parser$parse$1$1(this));
                            return;
                        }
                    } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                        this.$id.element = (T) this.$reader.nextStringOrNull();
                        return;
                    }
                } else if (str.equals("groups")) {
                    this.$groups.element = (T) this.$reader.nextList(new ModelGuildMemberListUpdate$Parser$parse$1$2(this));
                    return;
                }
            } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID)) {
                this.$guildId.element = (T) this.$reader.nextLongOrNull();
                return;
            }
        }
        this.$reader.skipValue();
    }
}

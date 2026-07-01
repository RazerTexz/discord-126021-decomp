package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelGuildFolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelGuildFolder$Parser$parse$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $color;
    public final /* synthetic */ Ref$ObjectRef $guildIds;
    public final /* synthetic */ Ref$ObjectRef $id;
    public final /* synthetic */ Ref$ObjectRef $name;
    public final /* synthetic */ Model$JsonReader $reader;

    public ModelGuildFolder$Parser$parse$1(Ref$ObjectRef ref$ObjectRef, Model$JsonReader model$JsonReader, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, Ref$ObjectRef ref$ObjectRef4) {
        this.$id = ref$ObjectRef;
        this.$reader = model$JsonReader;
        this.$guildIds = ref$ObjectRef2;
        this.$color = ref$ObjectRef3;
        this.$name = ref$ObjectRef4;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -1847996308) {
                if (iHashCode != 3355) {
                    if (iHashCode != 3373707) {
                        if (iHashCode == 94842723 && str.equals(ModelAuditLogEntry.CHANGE_KEY_COLOR)) {
                            this.$color.element = (T) this.$reader.nextIntOrNull();
                            return;
                        }
                    } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                        this.$name.element = (T) this.$reader.nextStringOrNull();
                        return;
                    }
                } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                    this.$id.element = (T) this.$reader.nextLongOrNull();
                    return;
                }
            } else if (str.equals("guild_ids")) {
                this.$guildIds.element = (T) this.$reader.nextList(new ModelGuildFolder$Parser$parse$1$1(this));
                return;
            }
        }
        this.$reader.skipValue();
    }
}

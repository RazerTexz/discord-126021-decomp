package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildmember.GuildMember;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelGuildMemberListUpdate$Operation$Item$Parser$parse$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $group;
    public final /* synthetic */ Ref$ObjectRef $member;
    public final /* synthetic */ Model$JsonReader $reader;

    public ModelGuildMemberListUpdate$Operation$Item$Parser$parse$1(Ref$ObjectRef ref$ObjectRef, Model$JsonReader model$JsonReader, Ref$ObjectRef ref$ObjectRef2) {
        this.$group = ref$ObjectRef;
        this.$reader = model$JsonReader;
        this.$member = ref$ObjectRef2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -1077769574) {
                if (iHashCode == 98629247 && str.equals("group")) {
                    this.$group.element = (T) ModelGuildMemberListUpdate$Group$Parser.INSTANCE.parse(this.$reader);
                    return;
                }
            } else if (str.equals("member")) {
                this.$member.element = (T) ((GuildMember) InboundGatewayGsonParser.fromJson(this.$reader, GuildMember.class));
                return;
            }
        }
        this.$reader.skipValue();
    }
}

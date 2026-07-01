package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.api.guildmember.GuildMember;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelGuildMemberListUpdate$Operation$Item$Parser implements Model$Parser<ModelGuildMemberListUpdate$Operation$Item> {
    public static final ModelGuildMemberListUpdate$Operation$Item$Parser INSTANCE = new ModelGuildMemberListUpdate$Operation$Item$Parser();

    private ModelGuildMemberListUpdate$Operation$Item$Parser() {
    }

    @Override // com.discord.models.domain.Model$Parser
    public /* bridge */ /* synthetic */ ModelGuildMemberListUpdate$Operation$Item parse(Model$JsonReader model$JsonReader) {
        return parse(model$JsonReader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.models.domain.Model$Parser
    public ModelGuildMemberListUpdate$Operation$Item parse(Model$JsonReader reader) throws IOException {
        Ref$ObjectRef ref$ObjectRefC0 = a.c0(reader, "reader");
        ref$ObjectRefC0.element = null;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        reader.nextObject(new ModelGuildMemberListUpdate$Operation$Item$Parser$parse$1(ref$ObjectRefC0, reader, ref$ObjectRef));
        T t = ref$ObjectRef.element;
        if (((GuildMember) t) != null) {
            GuildMember guildMember = (GuildMember) t;
            m.checkNotNull(guildMember);
            return new ModelGuildMemberListUpdate$Operation$Item$MemberItem(guildMember);
        }
        T t2 = ref$ObjectRefC0.element;
        if (((ModelGuildMemberListUpdate$Group) t2) == null) {
            throw new IllegalArgumentException("either member or group must be present.");
        }
        ModelGuildMemberListUpdate$Group modelGuildMemberListUpdate$Group = (ModelGuildMemberListUpdate$Group) t2;
        m.checkNotNull(modelGuildMemberListUpdate$Group);
        return new ModelGuildMemberListUpdate$Operation$Item$GroupItem(modelGuildMemberListUpdate$Group);
    }
}

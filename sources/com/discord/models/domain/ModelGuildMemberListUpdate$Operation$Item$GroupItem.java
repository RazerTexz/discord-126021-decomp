package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelGuildMemberListUpdate$Operation$Item$GroupItem extends ModelGuildMemberListUpdate$Operation$Item {
    private final ModelGuildMemberListUpdate$Group group;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelGuildMemberListUpdate$Operation$Item$GroupItem(ModelGuildMemberListUpdate$Group modelGuildMemberListUpdate$Group) {
        super(null);
        m.checkNotNullParameter(modelGuildMemberListUpdate$Group, "group");
        this.group = modelGuildMemberListUpdate$Group;
    }

    public static /* synthetic */ ModelGuildMemberListUpdate$Operation$Item$GroupItem copy$default(ModelGuildMemberListUpdate$Operation$Item$GroupItem modelGuildMemberListUpdate$Operation$Item$GroupItem, ModelGuildMemberListUpdate$Group modelGuildMemberListUpdate$Group, int i, Object obj) {
        if ((i & 1) != 0) {
            modelGuildMemberListUpdate$Group = modelGuildMemberListUpdate$Operation$Item$GroupItem.group;
        }
        return modelGuildMemberListUpdate$Operation$Item$GroupItem.copy(modelGuildMemberListUpdate$Group);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelGuildMemberListUpdate$Group getGroup() {
        return this.group;
    }

    public final ModelGuildMemberListUpdate$Operation$Item$GroupItem copy(ModelGuildMemberListUpdate$Group group) {
        m.checkNotNullParameter(group, "group");
        return new ModelGuildMemberListUpdate$Operation$Item$GroupItem(group);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModelGuildMemberListUpdate$Operation$Item$GroupItem) && m.areEqual(this.group, ((ModelGuildMemberListUpdate$Operation$Item$GroupItem) other).group);
        }
        return true;
    }

    public final ModelGuildMemberListUpdate$Group getGroup() {
        return this.group;
    }

    public int hashCode() {
        ModelGuildMemberListUpdate$Group modelGuildMemberListUpdate$Group = this.group;
        if (modelGuildMemberListUpdate$Group != null) {
            return modelGuildMemberListUpdate$Group.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("GroupItem(group=");
        sbU.append(this.group);
        sbU.append(")");
        return sbU.toString();
    }
}

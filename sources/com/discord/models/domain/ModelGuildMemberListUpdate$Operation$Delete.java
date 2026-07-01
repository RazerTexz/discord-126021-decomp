package com.discord.models.domain;

import b.d.b.a.a;

/* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelGuildMemberListUpdate$Operation$Delete extends ModelGuildMemberListUpdate$Operation {
    private final int index;

    public ModelGuildMemberListUpdate$Operation$Delete(int i) {
        super(null, null, 3, null);
        this.index = i;
    }

    public static /* synthetic */ ModelGuildMemberListUpdate$Operation$Delete copy$default(ModelGuildMemberListUpdate$Operation$Delete modelGuildMemberListUpdate$Operation$Delete, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = modelGuildMemberListUpdate$Operation$Delete.index;
        }
        return modelGuildMemberListUpdate$Operation$Delete.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    public final ModelGuildMemberListUpdate$Operation$Delete copy(int index) {
        return new ModelGuildMemberListUpdate$Operation$Delete(index);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModelGuildMemberListUpdate$Operation$Delete) && this.index == ((ModelGuildMemberListUpdate$Operation$Delete) other).index;
        }
        return true;
    }

    public final int getIndex() {
        return this.index;
    }

    public int hashCode() {
        return this.index;
    }

    public String toString() {
        return a.B(a.U("Delete(index="), this.index, ")");
    }
}

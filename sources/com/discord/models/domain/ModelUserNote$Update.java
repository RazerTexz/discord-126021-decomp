package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelUserNote.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelUserNote$Update {
    private final long id;
    private final String note;

    public ModelUserNote$Update(long j, String str) {
        m.checkNotNullParameter(str, "note");
        this.id = j;
        this.note = str;
    }

    public static /* synthetic */ ModelUserNote$Update copy$default(ModelUserNote$Update modelUserNote$Update, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = modelUserNote$Update.id;
        }
        if ((i & 2) != 0) {
            str = modelUserNote$Update.note;
        }
        return modelUserNote$Update.copy(j, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNote() {
        return this.note;
    }

    public final ModelUserNote$Update copy(long id2, String note) {
        m.checkNotNullParameter(note, "note");
        return new ModelUserNote$Update(id2, note);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelUserNote$Update)) {
            return false;
        }
        ModelUserNote$Update modelUserNote$Update = (ModelUserNote$Update) other;
        return this.id == modelUserNote$Update.id && m.areEqual(this.note, modelUserNote$Update.note);
    }

    public final long getId() {
        return this.id;
    }

    public final String getNote() {
        return this.note;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.note;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Update(id=");
        sbU.append(this.id);
        sbU.append(", note=");
        return a.J(sbU, this.note, ")");
    }
}

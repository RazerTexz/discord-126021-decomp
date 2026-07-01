package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelUserNote.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelUserNote {
    private final String note;
    private final long noteUserId;

    public ModelUserNote(long j, String str) {
        this.noteUserId = j;
        this.note = str;
    }

    public static /* synthetic */ ModelUserNote copy$default(ModelUserNote modelUserNote, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = modelUserNote.noteUserId;
        }
        if ((i & 2) != 0) {
            str = modelUserNote.note;
        }
        return modelUserNote.copy(j, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getNoteUserId() {
        return this.noteUserId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNote() {
        return this.note;
    }

    public final ModelUserNote copy(long noteUserId, String note) {
        return new ModelUserNote(noteUserId, note);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelUserNote)) {
            return false;
        }
        ModelUserNote modelUserNote = (ModelUserNote) other;
        return this.noteUserId == modelUserNote.noteUserId && m.areEqual(this.note, modelUserNote.note);
    }

    public final String getNote() {
        return this.note;
    }

    public final long getNoteUserId() {
        return this.noteUserId;
    }

    public int hashCode() {
        long j = this.noteUserId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.note;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelUserNote(noteUserId=");
        sbU.append(this.noteUserId);
        sbU.append(", note=");
        return a.J(sbU, this.note, ")");
    }
}

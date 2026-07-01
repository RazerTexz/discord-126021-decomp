package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.domain.ModelUserNote;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreUserNotes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreUserNotes$UserNoteState$Loaded extends StoreUserNotes$UserNoteState {
    private final ModelUserNote note;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserNotes$UserNoteState$Loaded(ModelUserNote modelUserNote) {
        super(null);
        m.checkNotNullParameter(modelUserNote, "note");
        this.note = modelUserNote;
    }

    public static /* synthetic */ StoreUserNotes$UserNoteState$Loaded copy$default(StoreUserNotes$UserNoteState$Loaded storeUserNotes$UserNoteState$Loaded, ModelUserNote modelUserNote, int i, Object obj) {
        if ((i & 1) != 0) {
            modelUserNote = storeUserNotes$UserNoteState$Loaded.note;
        }
        return storeUserNotes$UserNoteState$Loaded.copy(modelUserNote);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelUserNote getNote() {
        return this.note;
    }

    public final StoreUserNotes$UserNoteState$Loaded copy(ModelUserNote note) {
        m.checkNotNullParameter(note, "note");
        return new StoreUserNotes$UserNoteState$Loaded(note);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreUserNotes$UserNoteState$Loaded) && m.areEqual(this.note, ((StoreUserNotes$UserNoteState$Loaded) other).note);
        }
        return true;
    }

    public final ModelUserNote getNote() {
        return this.note;
    }

    public int hashCode() {
        ModelUserNote modelUserNote = this.note;
        if (modelUserNote != null) {
            return modelUserNote.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(note=");
        sbU.append(this.note);
        sbU.append(")");
        return sbU.toString();
    }
}

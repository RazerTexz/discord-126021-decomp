package com.discord.models.domain;

import java.io.IOException;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: ModelUserNote.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelUserNote {
    private final String note;
    private final long noteUserId;

    /* JADX INFO: compiled from: ModelUserNote.kt */
    public static final /* data */ class Update {
        private final long id;
        private final String note;

        /* JADX INFO: compiled from: ModelUserNote.kt */
        public static final class Parser implements Model.Parser<Update> {
            public static final Parser INSTANCE = new Parser();

            private Parser() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.discord.models.domain.Model.Parser
            public Update parse(final Model.JsonReader reader) throws IOException {
                C12238m.checkNotNullParameter(reader, "reader");
                final Ref$LongRef ref$LongRef = new Ref$LongRef();
                ref$LongRef.element = 0L;
                final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = "";
                reader.nextObject(new Action1<String>() { // from class: com.discord.models.domain.ModelUserNote$Update$Parser$parse$1
                    @Override // p658rx.functions.Action1
                    public final void call(String str) throws IOException {
                        if (str != null) {
                            int iHashCode = str.hashCode();
                            if (iHashCode != 3355) {
                                if (iHashCode == 3387378 && str.equals("note")) {
                                    Ref$ObjectRef ref$ObjectRef2 = ref$ObjectRef;
                                    T t = (T) reader.nextString("");
                                    C12238m.checkNotNullExpressionValue(t, "reader.nextString(\"\")");
                                    ref$ObjectRef2.element = t;
                                    return;
                                }
                            } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                                ref$LongRef.element = reader.nextLong(0L);
                                return;
                            }
                        }
                        reader.skipValue();
                    }
                });
                return new Update(ref$LongRef.element, (String) ref$ObjectRef.element);
            }
        }

        public Update(long j, String str) {
            C12238m.checkNotNullParameter(str, "note");
            this.id = j;
            this.note = str;
        }

        public static /* synthetic */ Update copy$default(Update update, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = update.id;
            }
            if ((i & 2) != 0) {
                str = update.note;
            }
            return update.copy(j, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getNote() {
            return this.note;
        }

        public final Update copy(long id2, String note) {
            C12238m.checkNotNullParameter(note, "note");
            return new Update(id2, note);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Update)) {
                return false;
            }
            Update update = (Update) other;
            return this.id == update.id && C12238m.areEqual(this.note, update.note);
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
            StringBuilder sbM833U = C1643a.m833U("Update(id=");
            sbM833U.append(this.id);
            sbM833U.append(", note=");
            return C1643a.m822J(sbM833U, this.note, ")");
        }
    }

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
        return this.noteUserId == modelUserNote.noteUserId && C12238m.areEqual(this.note, modelUserNote.note);
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
        StringBuilder sbM833U = C1643a.m833U("ModelUserNote(noteUserId=");
        sbM833U.append(this.noteUserId);
        sbM833U.append(", note=");
        return C1643a.m822J(sbM833U, this.note, ")");
    }
}

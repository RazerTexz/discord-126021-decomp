package com.discord.restapi;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$UserNoteUpdate {
    private final String note;

    public RestAPIParams$UserNoteUpdate(String str) {
        this.note = str;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final String getNote() {
        return this.note;
    }

    public static /* synthetic */ RestAPIParams$UserNoteUpdate copy$default(RestAPIParams$UserNoteUpdate restAPIParams$UserNoteUpdate, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = restAPIParams$UserNoteUpdate.note;
        }
        return restAPIParams$UserNoteUpdate.copy(str);
    }

    public final RestAPIParams$UserNoteUpdate copy(String note) {
        return new RestAPIParams$UserNoteUpdate(note);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof RestAPIParams$UserNoteUpdate) && m.areEqual(this.note, ((RestAPIParams$UserNoteUpdate) other).note);
        }
        return true;
    }

    public int hashCode() {
        String str = this.note;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("UserNoteUpdate(note="), this.note, ")");
    }
}

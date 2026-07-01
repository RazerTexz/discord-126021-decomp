package com.franmontiel.persistentcookiejar.persistence;

import b.d.b.a.a;
import b.i.a.f.e.o.f;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import d0.g0.t;
import d0.g0.w;
import d0.z.d.m;
import f0.n;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class SerializableCookie implements Serializable {
    public static final String j = SerializableCookie.class.getSimpleName();
    private static final long serialVersionUID = -8594045714036645534L;
    public transient n k;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        long j2;
        boolean z2;
        boolean z3;
        String str = (String) objectInputStream.readObject();
        m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (!m.areEqual(w.trim(str).toString(), str)) {
            throw new IllegalArgumentException("name is not trimmed".toString());
        }
        String str2 = (String) objectInputStream.readObject();
        m.checkParameterIsNotNull(str2, "value");
        if (!m.areEqual(w.trim(str2).toString(), str2)) {
            throw new IllegalArgumentException("value is not trimmed".toString());
        }
        long j3 = objectInputStream.readLong();
        if (j3 != -1) {
            if (j3 <= 0) {
                j3 = Long.MIN_VALUE;
            }
            j2 = j3 <= 253402300799999L ? j3 : 253402300799999L;
            z2 = true;
        } else {
            j2 = 253402300799999L;
            z2 = false;
        }
        String str3 = (String) objectInputStream.readObject();
        m.checkParameterIsNotNull(str3, "domain");
        String strR1 = f.r1(str3);
        if (strR1 == null) {
            throw new IllegalArgumentException(a.w("unexpected domain: ", str3));
        }
        String str4 = (String) objectInputStream.readObject();
        m.checkParameterIsNotNull(str4, "path");
        if (!t.startsWith$default(str4, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, false, 2, null)) {
            throw new IllegalArgumentException("path must start with '/'".toString());
        }
        boolean z4 = objectInputStream.readBoolean();
        boolean z5 = objectInputStream.readBoolean();
        if (objectInputStream.readBoolean()) {
            m.checkParameterIsNotNull(str3, "domain");
            String strR2 = f.r1(str3);
            if (strR2 == null) {
                throw new IllegalArgumentException(a.w("unexpected domain: ", str3));
            }
            strR1 = strR2;
            z3 = true;
        } else {
            z3 = false;
        }
        Objects.requireNonNull(str, "builder.name == null");
        Objects.requireNonNull(str2, "builder.value == null");
        Objects.requireNonNull(strR1, "builder.domain == null");
        this.k = new n(str, str2, j2, strR1, str4, z4, z5, z2, z3, null);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.k.f);
        objectOutputStream.writeObject(this.k.g);
        n nVar = this.k;
        objectOutputStream.writeLong(nVar.m ? nVar.h : -1L);
        objectOutputStream.writeObject(this.k.i);
        objectOutputStream.writeObject(this.k.j);
        objectOutputStream.writeBoolean(this.k.k);
        objectOutputStream.writeBoolean(this.k.l);
        objectOutputStream.writeBoolean(this.k.n);
    }
}

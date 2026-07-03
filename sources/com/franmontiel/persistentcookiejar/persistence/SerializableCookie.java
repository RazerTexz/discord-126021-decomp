package com.franmontiel.persistentcookiejar.persistence;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12370n;

/* JADX INFO: loaded from: classes3.dex */
public class SerializableCookie implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final String f19670j = SerializableCookie.class.getSimpleName();
    private static final long serialVersionUID = -8594045714036645534L;

    /* JADX INFO: renamed from: k */
    public transient C12370n f19671k;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        long j;
        boolean z2;
        boolean z3;
        String str = (String) objectInputStream.readObject();
        C12238m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (!C12238m.areEqual(C12106w.trim(str).toString(), str)) {
            throw new IllegalArgumentException("name is not trimmed".toString());
        }
        String str2 = (String) objectInputStream.readObject();
        C12238m.checkParameterIsNotNull(str2, "value");
        if (!C12238m.areEqual(C12106w.trim(str2).toString(), str2)) {
            throw new IllegalArgumentException("value is not trimmed".toString());
        }
        long j2 = objectInputStream.readLong();
        if (j2 != -1) {
            if (j2 <= 0) {
                j2 = Long.MIN_VALUE;
            }
            j = j2 <= 253402300799999L ? j2 : 253402300799999L;
            z2 = true;
        } else {
            j = 253402300799999L;
            z2 = false;
        }
        String str3 = (String) objectInputStream.readObject();
        C12238m.checkParameterIsNotNull(str3, "domain");
        String strM4337r1 = C3404f.m4337r1(str3);
        if (strM4337r1 == null) {
            throw new IllegalArgumentException(C1643a.m883w("unexpected domain: ", str3));
        }
        String str4 = (String) objectInputStream.readObject();
        C12238m.checkParameterIsNotNull(str4, "path");
        if (!C12103t.startsWith$default(str4, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, false, 2, null)) {
            throw new IllegalArgumentException("path must start with '/'".toString());
        }
        boolean z4 = objectInputStream.readBoolean();
        boolean z5 = objectInputStream.readBoolean();
        if (objectInputStream.readBoolean()) {
            C12238m.checkParameterIsNotNull(str3, "domain");
            String strM4337r2 = C3404f.m4337r1(str3);
            if (strM4337r2 == null) {
                throw new IllegalArgumentException(C1643a.m883w("unexpected domain: ", str3));
            }
            strM4337r1 = strM4337r2;
            z3 = true;
        } else {
            z3 = false;
        }
        Objects.requireNonNull(str, "builder.name == null");
        Objects.requireNonNull(str2, "builder.value == null");
        Objects.requireNonNull(strM4337r1, "builder.domain == null");
        this.f19671k = new C12370n(str, str2, j, strM4337r1, str4, z4, z5, z2, z3, null);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.f19671k.f25947f);
        objectOutputStream.writeObject(this.f19671k.f25948g);
        C12370n c12370n = this.f19671k;
        objectOutputStream.writeLong(c12370n.f25954m ? c12370n.f25949h : -1L);
        objectOutputStream.writeObject(this.f19671k.f25950i);
        objectOutputStream.writeObject(this.f19671k.f25951j);
        objectOutputStream.writeBoolean(this.f19671k.f25952k);
        objectOutputStream.writeBoolean(this.f19671k.f25953l);
        objectOutputStream.writeBoolean(this.f19671k.f25955n);
    }
}

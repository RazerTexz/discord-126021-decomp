package com.discord.api.user;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: Phone.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Phone$PhoneNumber extends Phone {
    private final String number;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Phone$PhoneNumber(String str) {
        super(null);
        m.checkNotNullParameter(str, "number");
        this.number = str;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getNumber() {
        return this.number;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof Phone$PhoneNumber) && m.areEqual(this.number, ((Phone$PhoneNumber) other).number);
        }
        return true;
    }

    public int hashCode() {
        String str = this.number;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("PhoneNumber(number="), this.number, ")");
    }
}

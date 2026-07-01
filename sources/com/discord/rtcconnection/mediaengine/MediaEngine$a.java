package com.discord.rtcconnection.mediaengine;

import b.d.b.a.a;
import co.discord.media_engine.StreamParameters;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: MediaEngine.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaEngine$a {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2797b;
    public final int c;
    public final List<StreamParameters> d;

    public MediaEngine$a(int i, String str, int i2, List<StreamParameters> list) {
        m.checkNotNullParameter(str, "ip");
        m.checkNotNullParameter(list, "streams");
        this.a = i;
        this.f2797b = str;
        this.c = i2;
        this.d = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaEngine$a)) {
            return false;
        }
        MediaEngine$a mediaEngine$a = (MediaEngine$a) obj;
        return this.a == mediaEngine$a.a && m.areEqual(this.f2797b, mediaEngine$a.f2797b) && this.c == mediaEngine$a.c && m.areEqual(this.d, mediaEngine$a.d);
    }

    public int hashCode() {
        int i = this.a * 31;
        String str = this.f2797b;
        int iHashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.c) * 31;
        List<StreamParameters> list = this.d;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ConnectionOptions(ssrc=");
        sbU.append(this.a);
        sbU.append(", ip=");
        sbU.append(this.f2797b);
        sbU.append(", port=");
        sbU.append(this.c);
        sbU.append(", streams=");
        return a.L(sbU, this.d, ")");
    }
}

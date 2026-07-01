package com.google.android.gms.internal.measurement;

import b.i.a.f.h.l.c6;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzij extends IOException {
    public static final /* synthetic */ int j = 0;
    private c6 zza;

    public zzij(String str) {
        super(str);
        this.zza = null;
    }

    public static zzij a() {
        return new zzij("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static zzij b() {
        return new zzij("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzij c() {
        return new zzij("Protocol message contained an invalid tag (zero).");
    }

    public static zzij d() {
        return new zzij("Failed to parse the message.");
    }

    public static zzij e() {
        return new zzij("Protocol message had invalid UTF-8.");
    }
}

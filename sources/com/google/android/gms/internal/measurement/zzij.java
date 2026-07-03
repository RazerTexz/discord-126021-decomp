package com.google.android.gms.internal.measurement;

import java.io.IOException;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3612c6;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzij extends IOException {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f20634j = 0;
    private InterfaceC3612c6 zza;

    public zzij(String str) {
        super(str);
        this.zza = null;
    }

    /* JADX INFO: renamed from: a */
    public static zzij m9103a() {
        return new zzij("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: renamed from: b */
    public static zzij m9104b() {
        return new zzij("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: renamed from: c */
    public static zzij m9105c() {
        return new zzij("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: renamed from: d */
    public static zzij m9106d() {
        return new zzij("Failed to parse the message.");
    }

    /* JADX INFO: renamed from: e */
    public static zzij m9107e() {
        return new zzij("Protocol message had invalid UTF-8.");
    }
}

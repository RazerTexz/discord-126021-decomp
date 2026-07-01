package b.i.a.f.i.b;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class u3 {

    @NonNull
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public String f1569b;
    public long c;

    @NonNull
    public Bundle d;

    public u3(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle, long j) {
        this.a = str;
        this.f1569b = str2;
        this.d = bundle;
        this.c = j;
    }

    public static u3 b(zzaq zzaqVar) {
        return new u3(zzaqVar.j, zzaqVar.l, zzaqVar.k.x0(), zzaqVar.m);
    }

    public final zzaq a() {
        return new zzaq(this.a, new zzap(new Bundle(this.d)), this.f1569b, this.c);
    }

    public final String toString() {
        String str = this.f1569b;
        String str2 = this.a;
        String strValueOf = String.valueOf(this.d);
        return outline.J(outline.S(strValueOf.length() + outline.b(str2, outline.b(str, 21)), "origin=", str, ",name=", str2), ",params=", strValueOf);
    }
}

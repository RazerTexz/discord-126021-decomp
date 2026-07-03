package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.f.i.b.u3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4201u3 {

    /* JADX INFO: renamed from: a */
    @NonNull
    public String f11241a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public String f11242b;

    /* JADX INFO: renamed from: c */
    public long f11243c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public Bundle f11244d;

    public C4201u3(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle, long j) {
        this.f11241a = str;
        this.f11242b = str2;
        this.f11244d = bundle;
        this.f11243c = j;
    }

    /* JADX INFO: renamed from: b */
    public static C4201u3 m5931b(zzaq zzaqVar) {
        return new C4201u3(zzaqVar.f20666j, zzaqVar.f20668l, zzaqVar.f20667k.m9114x0(), zzaqVar.f20669m);
    }

    /* JADX INFO: renamed from: a */
    public final zzaq m5932a() {
        return new zzaq(this.f11241a, new zzap(new Bundle(this.f11244d)), this.f11242b, this.f11243c);
    }

    public final String toString() {
        String str = this.f11242b;
        String str2 = this.f11241a;
        String strValueOf = String.valueOf(this.f11244d);
        return C1643a.m822J(C1643a.m831S(strValueOf.length() + C1643a.m841b(str2, C1643a.m841b(str, 21)), "origin=", str, ",name=", str2), ",params=", strValueOf);
    }
}

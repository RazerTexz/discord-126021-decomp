package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzae;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.i.b.y5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4247y5 {

    /* JADX INFO: renamed from: a */
    public final Context f11370a;

    /* JADX INFO: renamed from: b */
    public String f11371b;

    /* JADX INFO: renamed from: c */
    public String f11372c;

    /* JADX INFO: renamed from: d */
    public String f11373d;

    /* JADX INFO: renamed from: e */
    public Boolean f11374e;

    /* JADX INFO: renamed from: f */
    public long f11375f;

    /* JADX INFO: renamed from: g */
    public zzae f11376g;

    /* JADX INFO: renamed from: h */
    public boolean f11377h;

    /* JADX INFO: renamed from: i */
    public Long f11378i;

    public C4247y5(Context context, zzae zzaeVar, Long l) {
        this.f11377h = true;
        Context applicationContext = context.getApplicationContext();
        Objects.requireNonNull(applicationContext, "null reference");
        this.f11370a = applicationContext;
        this.f11378i = l;
        if (zzaeVar != null) {
            this.f11376g = zzaeVar;
            this.f11371b = zzaeVar.f20626o;
            this.f11372c = zzaeVar.f20625n;
            this.f11373d = zzaeVar.f20624m;
            this.f11377h = zzaeVar.f20623l;
            this.f11375f = zzaeVar.f20622k;
            Bundle bundle = zzaeVar.f20627p;
            if (bundle != null) {
                this.f11374e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}

package b.i.a.f.i.b;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzae;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class y5 {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1580b;
    public String c;
    public String d;
    public Boolean e;
    public long f;
    public zzae g;
    public boolean h;
    public Long i;

    public y5(Context context, zzae zzaeVar, Long l) {
        this.h = true;
        Context applicationContext = context.getApplicationContext();
        Objects.requireNonNull(applicationContext, "null reference");
        this.a = applicationContext;
        this.i = l;
        if (zzaeVar != null) {
            this.g = zzaeVar;
            this.f1580b = zzaeVar.o;
            this.c = zzaeVar.n;
            this.d = zzaeVar.m;
            this.h = zzaeVar.l;
            this.f = zzaeVar.k;
            Bundle bundle = zzaeVar.p;
            if (bundle != null) {
                this.e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}

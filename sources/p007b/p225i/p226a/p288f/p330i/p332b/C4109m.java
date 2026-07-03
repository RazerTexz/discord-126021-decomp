package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzap;
import java.util.Iterator;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.f.i.b.m */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4109m {

    /* JADX INFO: renamed from: a */
    public final String f10952a;

    /* JADX INFO: renamed from: b */
    public final String f10953b;

    /* JADX INFO: renamed from: c */
    public final String f10954c;

    /* JADX INFO: renamed from: d */
    public final long f10955d;

    /* JADX INFO: renamed from: e */
    public final long f10956e;

    /* JADX INFO: renamed from: f */
    public final zzap f10957f;

    public C4109m(C4202u4 c4202u4, String str, String str2, String str3, long j, long j2, zzap zzapVar) {
        C1460d.m583w(str2);
        C1460d.m583w(str3);
        Objects.requireNonNull(zzapVar, "null reference");
        this.f10952a = str2;
        this.f10953b = str3;
        this.f10954c = TextUtils.isEmpty(str) ? null : str;
        this.f10955d = j;
        this.f10956e = j2;
        if (j2 != 0 && j2 > j) {
            c4202u4.mo5726g().f11144i.m5862c("Event created with reverse previous/current timestamps. appId, name", C4157q3.m5788s(str2), C4157q3.m5788s(str3));
        }
        this.f10957f = zzapVar;
    }

    /* JADX INFO: renamed from: a */
    public final C4109m m5752a(C4202u4 c4202u4, long j) {
        return new C4109m(c4202u4, this.f10954c, this.f10952a, this.f10953b, this.f10955d, j, this.f10957f);
    }

    public final String toString() {
        String str = this.f10952a;
        String str2 = this.f10953b;
        String strValueOf = String.valueOf(this.f10957f);
        StringBuilder sbM831S = C1643a.m831S(strValueOf.length() + C1643a.m841b(str2, C1643a.m841b(str, 33)), "Event{appId='", str, "', name='", str2);
        sbM831S.append("', params=");
        sbM831S.append(strValueOf);
        sbM831S.append('}');
        return sbM831S.toString();
    }

    public C4109m(C4202u4 c4202u4, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzap zzapVar;
        C1460d.m583w(str2);
        C1460d.m583w(str3);
        this.f10952a = str2;
        this.f10953b = str3;
        this.f10954c = TextUtils.isEmpty(str) ? null : str;
        this.f10955d = j;
        this.f10956e = j2;
        if (j2 != 0 && j2 > j) {
            c4202u4.mo5726g().f11144i.m5861b("Event created with reverse previous/current timestamps. appId", C4157q3.m5788s(str2));
        }
        if (!bundle.isEmpty()) {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    c4202u4.mo5726g().f11141f.m5860a("Param name can't be null");
                    it.remove();
                } else {
                    Object objM5892D = c4202u4.m5949t().m5892D(next, bundle2.get(next));
                    if (objM5892D == null) {
                        c4202u4.mo5726g().f11144i.m5861b("Param value can't be null", c4202u4.m5950u().m5768x(next));
                        it.remove();
                    } else {
                        c4202u4.m5949t().m5895I(bundle2, next, objM5892D);
                    }
                }
            }
            zzapVar = new zzap(bundle2);
        } else {
            zzapVar = new zzap(new Bundle());
        }
        this.f10957f = zzapVar;
    }
}

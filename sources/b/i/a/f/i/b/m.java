package b.i.a.f.i.b;

import android.os.Bundle;
import android.text.TextUtils;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.google.android.gms.measurement.internal.zzap;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1549b;
    public final String c;
    public final long d;
    public final long e;
    public final zzap f;

    public m(u4 u4Var, String str, String str2, String str3, long j, long j2, zzap zzapVar) {
        AnimatableValueParser.w(str2);
        AnimatableValueParser.w(str3);
        Objects.requireNonNull(zzapVar, "null reference");
        this.a = str2;
        this.f1549b = str3;
        this.c = TextUtils.isEmpty(str) ? null : str;
        this.d = j;
        this.e = j2;
        if (j2 != 0 && j2 > j) {
            u4Var.g().i.c("Event created with reverse previous/current timestamps. appId, name", q3.s(str2), q3.s(str3));
        }
        this.f = zzapVar;
    }

    public final m a(u4 u4Var, long j) {
        return new m(u4Var, this.c, this.a, this.f1549b, this.d, j, this.f);
    }

    public final String toString() {
        String str = this.a;
        String str2 = this.f1549b;
        String strValueOf = String.valueOf(this.f);
        StringBuilder sbS = outline.S(strValueOf.length() + outline.b(str2, outline.b(str, 33)), "Event{appId='", str, "', name='", str2);
        sbS.append("', params=");
        sbS.append(strValueOf);
        sbS.append('}');
        return sbS.toString();
    }

    public m(u4 u4Var, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzap zzapVar;
        AnimatableValueParser.w(str2);
        AnimatableValueParser.w(str3);
        this.a = str2;
        this.f1549b = str3;
        this.c = TextUtils.isEmpty(str) ? null : str;
        this.d = j;
        this.e = j2;
        if (j2 != 0 && j2 > j) {
            u4Var.g().i.b("Event created with reverse previous/current timestamps. appId", q3.s(str2));
        }
        if (!bundle.isEmpty()) {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    u4Var.g().f.a("Param name can't be null");
                    it.remove();
                } else {
                    Object objD = u4Var.t().D(next, bundle2.get(next));
                    if (objD == null) {
                        u4Var.g().i.b("Param value can't be null", u4Var.u().x(next));
                        it.remove();
                    } else {
                        u4Var.t().I(bundle2, next, objD);
                    }
                }
            }
            zzapVar = new zzap(bundle2);
        } else {
            zzapVar = new zzap(new Bundle());
        }
        this.f = zzapVar;
    }
}

package p007b.p225i.p226a.p288f.p313h.p325l;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.measurement.zzae;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p311f.BinderC3423b;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;

/* JADX INFO: renamed from: b.i.a.f.h.l.j */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3703j extends C3661g.a {

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ String f10015n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ String f10016o;

    /* JADX INFO: renamed from: p */
    public final /* synthetic */ Context f10017p;

    /* JADX INFO: renamed from: q */
    public final /* synthetic */ Bundle f10018q;

    /* JADX INFO: renamed from: r */
    public final /* synthetic */ C3661g f10019r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3703j(C3661g c3661g, String str, String str2, Context context, Bundle bundle) {
        super(true);
        this.f10019r = c3661g;
        this.f10015n = str;
        this.f10016o = str2;
        this.f10017p = context;
        this.f10018q = bundle;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: a */
    public final void mo4521a() {
        String str;
        String str2;
        String str3;
        boolean z2;
        int iMax;
        try {
            InterfaceC3646ec interfaceC3646ecAsInterface = null;
            if (C3661g.m4884e(this.f10015n, this.f10016o)) {
                str3 = this.f10016o;
                str2 = this.f10015n;
                str = this.f10019r.f9948c;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            C3661g.m4883d(this.f10017p);
            boolean z3 = C3661g.f9947b.booleanValue() || str2 != null;
            C3661g c3661g = this.f10019r;
            Context context = this.f10017p;
            Objects.requireNonNull(c3661g);
            try {
                interfaceC3646ecAsInterface = AbstractBinderC3632dc.asInterface(DynamiteModule.m9043c(context, z3 ? DynamiteModule.f20573c : DynamiteModule.f20571a, ModuleDescriptor.MODULE_ID).m9050b("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
            } catch (DynamiteModule.LoadingException e) {
                c3661g.m4885b(e, true, false);
            }
            c3661g.f9955j = interfaceC3646ecAsInterface;
            if (this.f10019r.f9955j == null) {
                Log.w(this.f10019r.f9948c, "Failed to connect to measurement client.");
                return;
            }
            int iM9042a = DynamiteModule.m9042a(this.f10017p, ModuleDescriptor.MODULE_ID);
            int iM9044d = DynamiteModule.m9044d(this.f10017p, ModuleDescriptor.MODULE_ID, false);
            if (z3) {
                iMax = Math.max(iM9042a, iM9044d);
                z2 = iM9044d < iM9042a;
            } else {
                if (iM9042a > 0) {
                    iM9044d = iM9042a;
                }
                z2 = iM9042a > 0;
                iMax = iM9044d;
            }
            this.f10019r.f9955j.initialize(new BinderC3423b(this.f10017p), new zzae(33025L, iMax, z2, str, str2, str3, this.f10018q), this.f9956j);
        } catch (Exception e2) {
            this.f10019r.m4885b(e2, true, false);
        }
    }
}

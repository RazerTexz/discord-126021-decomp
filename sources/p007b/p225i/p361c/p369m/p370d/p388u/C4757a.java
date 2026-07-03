package p007b.p225i.p361c.p369m.p370d.p388u;

import android.content.Context;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.p373k.C4628h;

/* JADX INFO: renamed from: b.i.c.m.d.u.a */
/* JADX INFO: compiled from: ResourceUnityVersionProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4757a {

    /* JADX INFO: renamed from: a */
    public final Context f12781a;

    /* JADX INFO: renamed from: b */
    public boolean f12782b = false;

    /* JADX INFO: renamed from: c */
    public String f12783c;

    public C4757a(Context context) {
        this.f12781a = context;
    }

    /* JADX INFO: renamed from: a */
    public String m6697a() {
        String string;
        if (!this.f12782b) {
            Context context = this.f12781a;
            int iM6420n = C4628h.m6420n(context, "com.google.firebase.crashlytics.unity_version", "string");
            if (iM6420n != 0) {
                string = context.getResources().getString(iM6420n);
                C1643a.m868o0("Unity Editor version is: ", string, C4592b.f12227a);
            } else {
                string = null;
            }
            this.f12783c = string;
            this.f12782b = true;
        }
        String str = this.f12783c;
        if (str != null) {
            return str;
        }
        return null;
    }
}

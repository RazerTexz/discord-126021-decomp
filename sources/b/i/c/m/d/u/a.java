package b.i.c.m.d.u;

import android.content.Context;
import b.i.c.m.d.b;
import b.i.c.m.d.k.h;

/* JADX INFO: compiled from: ResourceUnityVersionProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1754b = false;
    public String c;

    public a(Context context) {
        this.a = context;
    }

    public String a() {
        String string;
        if (!this.f1754b) {
            Context context = this.a;
            int iN = h.n(context, "com.google.firebase.crashlytics.unity_version", "string");
            if (iN != 0) {
                string = context.getResources().getString(iN);
                b.d.b.a.a.o0("Unity Editor version is: ", string, b.a);
            } else {
                string = null;
            }
            this.c = string;
            this.f1754b = true;
        }
        String str = this.c;
        if (str != null) {
            return str;
        }
        return null;
    }
}

package b.i.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* JADX INFO: compiled from: FirebaseCommonRegistrar.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements b.i.c.x.g {
    public static final d a = new d();

    @Override // b.i.c.x.g
    public String a(Object obj) {
        ApplicationInfo applicationInfo = ((Context) obj).getApplicationInfo();
        return applicationInfo != null ? String.valueOf(applicationInfo.targetSdkVersion) : "";
    }
}

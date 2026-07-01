package b.i.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build$VERSION;

/* JADX INFO: compiled from: FirebaseCommonRegistrar.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements b.i.c.x.g {
    public static final e a = new e();

    @Override // b.i.c.x.g
    public String a(Object obj) {
        ApplicationInfo applicationInfo = ((Context) obj).getApplicationInfo();
        return (applicationInfo == null || Build$VERSION.SDK_INT < 24) ? "" : String.valueOf(applicationInfo.minSdkVersion);
    }
}

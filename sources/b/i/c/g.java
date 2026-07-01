package b.i.c;

import android.content.Context;
import com.google.firebase.FirebaseCommonRegistrar;

/* JADX INFO: compiled from: FirebaseCommonRegistrar.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g implements b.i.c.x.g {
    public static final g a = new g();

    @Override // b.i.c.x.g
    public String a(Object obj) {
        Context context = (Context) obj;
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName != null ? FirebaseCommonRegistrar.a(installerPackageName) : "";
    }
}

package b.i.c.m.e;

import android.content.Context;
import com.google.firebase.crashlytics.ndk.CrashlyticsNdkRegistrar;
import com.google.firebase.crashlytics.ndk.JniNativeApi;
import java.io.File;
import java.util.Objects;

/* JADX INFO: compiled from: CrashlyticsNdkRegistrar.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements b.i.c.l.f {
    public final CrashlyticsNdkRegistrar a;

    public b(CrashlyticsNdkRegistrar crashlyticsNdkRegistrar) {
        this.a = crashlyticsNdkRegistrar;
    }

    @Override // b.i.c.l.f
    public Object a(b.i.c.l.e eVar) {
        Objects.requireNonNull(this.a);
        Context context = (Context) eVar.a(Context.class);
        return new c(new a(context, new JniNativeApi(context), new f(new File(context.getFilesDir(), ".com.google.firebase.crashlytics-ndk"))));
    }
}

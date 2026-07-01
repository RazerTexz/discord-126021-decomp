package b.i.a.f.h.j;

import android.content.Context;
import b.c.a.a0.AnimatableValueParser;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1419b;

    public i(Context context) {
        Context applicationContext = context.getApplicationContext();
        AnimatableValueParser.z(applicationContext, "Application context can't be null");
        this.a = applicationContext;
        this.f1419b = applicationContext;
    }
}

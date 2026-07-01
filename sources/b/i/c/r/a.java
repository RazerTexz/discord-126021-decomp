package b.i.c.r;

import android.content.Context;

/* JADX INFO: compiled from: DefaultHeartBeatInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements b.i.c.t.a {
    public final Context a;

    public a(Context context) {
        this.a = context;
    }

    @Override // b.i.c.t.a
    public Object get() {
        e eVar;
        Context context = this.a;
        synchronized (e.class) {
            if (e.a == null) {
                e.a = new e(context);
            }
            eVar = e.a;
        }
        return eVar;
    }
}

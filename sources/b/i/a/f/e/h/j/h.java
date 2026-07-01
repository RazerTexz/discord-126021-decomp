package b.i.a.f.e.h.j;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.R$a;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class h {
    public static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public static h f1365b;

    @Nullable
    public final String c;
    public final Status d;
    public final boolean e;

    public h(Context context) {
        Resources resources = context.getResources();
        int i = R$a.common_google_play_services_unknown_issue;
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(i));
        if (identifier != 0) {
            this.e = resources.getInteger(identifier) == 0;
        } else {
            this.e = false;
        }
        b.i.a.f.e.k.f0.a(context);
        String string = b.i.a.f.e.k.f0.c;
        if (string == null) {
            Resources resources2 = context.getResources();
            int identifier2 = resources2.getIdentifier("google_app_id", "string", resources2.getResourcePackageName(i));
            string = identifier2 == 0 ? null : resources2.getString(identifier2);
        }
        if (TextUtils.isEmpty(string)) {
            this.d = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.c = null;
        } else {
            this.c = string;
            this.d = Status.j;
        }
    }

    public static h a(String str) {
        h hVar;
        synchronized (a) {
            hVar = f1365b;
            if (hVar == null) {
                StringBuilder sb = new StringBuilder(str.length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
        }
        return hVar;
    }
}

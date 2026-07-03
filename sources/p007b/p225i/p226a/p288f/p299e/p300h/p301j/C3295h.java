package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.C10800R;
import com.google.android.gms.common.api.Status;
import p007b.p225i.p226a.p288f.p299e.p304k.C3354f0;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.h */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class C3295h {

    /* JADX INFO: renamed from: a */
    public static final Object f9421a = new Object();

    /* JADX INFO: renamed from: b */
    @Nullable
    public static C3295h f9422b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final String f9423c;

    /* JADX INFO: renamed from: d */
    public final Status f9424d;

    /* JADX INFO: renamed from: e */
    public final boolean f9425e;

    public C3295h(Context context) {
        Resources resources = context.getResources();
        int i = C10800R.a.common_google_play_services_unknown_issue;
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(i));
        if (identifier != 0) {
            this.f9425e = resources.getInteger(identifier) == 0;
        } else {
            this.f9425e = false;
        }
        C3354f0.m4155a(context);
        String string = C3354f0.f9521c;
        if (string == null) {
            Resources resources2 = context.getResources();
            int identifier2 = resources2.getIdentifier("google_app_id", "string", resources2.getResourcePackageName(i));
            string = identifier2 == 0 ? null : resources2.getString(identifier2);
        }
        if (TextUtils.isEmpty(string)) {
            this.f9424d = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f9423c = null;
        } else {
            this.f9423c = string;
            this.f9424d = Status.f20489j;
        }
    }

    /* JADX INFO: renamed from: a */
    public static C3295h m4105a(String str) {
        C3295h c3295h;
        synchronized (f9421a) {
            c3295h = f9422b;
            if (c3295h == null) {
                StringBuilder sb = new StringBuilder(str.length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
        }
        return c3295h;
    }
}

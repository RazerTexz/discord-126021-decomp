package b.i.a.f.h.b;

import com.google.android.gms.common.Feature;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final Feature a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Feature f1404b;
    public static final Feature c;
    public static final Feature[] d;

    static {
        Feature feature = new Feature("sms_code_autofill", 2L);
        a = feature;
        Feature feature2 = new Feature("sms_retrieve", 1L);
        f1404b = feature2;
        Feature feature3 = new Feature("user_consent", 3L);
        c = feature3;
        d = new Feature[]{feature, feature2, feature3};
    }
}

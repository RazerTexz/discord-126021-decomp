package p007b.p225i.p226a.p288f.p313h.p315b;

import com.google.android.gms.common.Feature;

/* JADX INFO: renamed from: b.i.a.f.h.b.b */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3442b {

    /* JADX INFO: renamed from: a */
    public static final Feature f9625a;

    /* JADX INFO: renamed from: b */
    public static final Feature f9626b;

    /* JADX INFO: renamed from: c */
    public static final Feature f9627c;

    /* JADX INFO: renamed from: d */
    public static final Feature[] f9628d;

    static {
        Feature feature = new Feature("sms_code_autofill", 2L);
        f9625a = feature;
        Feature feature2 = new Feature("sms_retrieve", 1L);
        f9626b = feature2;
        Feature feature3 = new Feature("user_consent", 3L);
        f9627c = feature3;
        f9628d = new Feature[]{feature, feature2, feature3};
    }
}

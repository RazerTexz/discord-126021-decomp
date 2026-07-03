package p007b.p225i.p361c;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.C10800R;
import java.util.Arrays;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p304k.C3361j;
import p007b.p225i.p226a.p288f.p299e.p308o.C3406h;

/* JADX INFO: renamed from: b.i.c.i */
/* JADX INFO: compiled from: FirebaseOptions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4548i {

    /* JADX INFO: renamed from: a */
    public final String f12134a;

    /* JADX INFO: renamed from: b */
    public final String f12135b;

    /* JADX INFO: renamed from: c */
    public final String f12136c;

    /* JADX INFO: renamed from: d */
    public final String f12137d;

    /* JADX INFO: renamed from: e */
    public final String f12138e;

    /* JADX INFO: renamed from: f */
    public final String f12139f;

    /* JADX INFO: renamed from: g */
    public final String f12140g;

    public C4548i(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        C1460d.m435G(!C3406h.m4371a(str), "ApplicationId must be set.");
        this.f12135b = str;
        this.f12134a = str2;
        this.f12136c = str3;
        this.f12137d = str4;
        this.f12138e = str5;
        this.f12139f = str6;
        this.f12140g = str7;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C4548i m6337a(@NonNull Context context) {
        Objects.requireNonNull(context, "null reference");
        Resources resources = context.getResources();
        String resourcePackageName = resources.getResourcePackageName(C10800R.a.common_google_play_services_unknown_issue);
        int identifier = resources.getIdentifier("google_app_id", "string", resourcePackageName);
        String string = identifier == 0 ? null : resources.getString(identifier);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        int identifier2 = resources.getIdentifier("google_api_key", "string", resourcePackageName);
        String string2 = identifier2 == 0 ? null : resources.getString(identifier2);
        int identifier3 = resources.getIdentifier("firebase_database_url", "string", resourcePackageName);
        String string3 = identifier3 == 0 ? null : resources.getString(identifier3);
        int identifier4 = resources.getIdentifier("ga_trackingId", "string", resourcePackageName);
        String string4 = identifier4 == 0 ? null : resources.getString(identifier4);
        int identifier5 = resources.getIdentifier("gcm_defaultSenderId", "string", resourcePackageName);
        String string5 = identifier5 == 0 ? null : resources.getString(identifier5);
        int identifier6 = resources.getIdentifier("google_storage_bucket", "string", resourcePackageName);
        String string6 = identifier6 == 0 ? null : resources.getString(identifier6);
        int identifier7 = resources.getIdentifier("project_id", "string", resourcePackageName);
        return new C4548i(string, string2, string3, string4, string5, string6, identifier7 != 0 ? resources.getString(identifier7) : null);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C4548i)) {
            return false;
        }
        C4548i c4548i = (C4548i) obj;
        return C1460d.m524h0(this.f12135b, c4548i.f12135b) && C1460d.m524h0(this.f12134a, c4548i.f12134a) && C1460d.m524h0(this.f12136c, c4548i.f12136c) && C1460d.m524h0(this.f12137d, c4548i.f12137d) && C1460d.m524h0(this.f12138e, c4548i.f12138e) && C1460d.m524h0(this.f12139f, c4548i.f12139f) && C1460d.m524h0(this.f12140g, c4548i.f12140g);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f12135b, this.f12134a, this.f12136c, this.f12137d, this.f12138e, this.f12139f, this.f12140g});
    }

    public String toString() {
        C3361j c3361j = new C3361j(this);
        c3361j.m4162a("applicationId", this.f12135b);
        c3361j.m4162a("apiKey", this.f12134a);
        c3361j.m4162a("databaseUrl", this.f12136c);
        c3361j.m4162a("gcmSenderId", this.f12138e);
        c3361j.m4162a("storageBucket", this.f12139f);
        c3361j.m4162a("projectId", this.f12140g);
        return c3361j.toString();
    }
}

package b.i.c;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.k.j;
import com.google.android.gms.common.R;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.c.i, reason: use source file name */
/* JADX INFO: compiled from: FirebaseOptions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FirebaseOptions {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1655b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public FirebaseOptions(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        AnimatableValueParser.G(!b.i.a.f.e.o.h.a(str), "ApplicationId must be set.");
        this.f1655b = str;
        this.a = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    @Nullable
    public static FirebaseOptions a(@NonNull Context context) {
        Objects.requireNonNull(context, "null reference");
        Resources resources = context.getResources();
        String resourcePackageName = resources.getResourcePackageName(R.a.common_google_play_services_unknown_issue);
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
        return new FirebaseOptions(string, string2, string3, string4, string5, string6, identifier7 != 0 ? resources.getString(identifier7) : null);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        return AnimatableValueParser.h0(this.f1655b, firebaseOptions.f1655b) && AnimatableValueParser.h0(this.a, firebaseOptions.a) && AnimatableValueParser.h0(this.c, firebaseOptions.c) && AnimatableValueParser.h0(this.d, firebaseOptions.d) && AnimatableValueParser.h0(this.e, firebaseOptions.e) && AnimatableValueParser.h0(this.f, firebaseOptions.f) && AnimatableValueParser.h0(this.g, firebaseOptions.g);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1655b, this.a, this.c, this.d, this.e, this.f, this.g});
    }

    public String toString() {
        j jVar = new j(this);
        jVar.a("applicationId", this.f1655b);
        jVar.a("apiKey", this.a);
        jVar.a("databaseUrl", this.c);
        jVar.a("gcmSenderId", this.e);
        jVar.a("storageBucket", this.f);
        jVar.a("projectId", this.g);
        return jVar.toString();
    }
}

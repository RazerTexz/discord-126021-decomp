package b.i.c.m.d.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.NonNull;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.google.android.gms.tasks.Task;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: IdManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class v0 implements w0 {
    public static final Pattern a = Pattern.compile("[^\\p{Alnum}]");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f1698b = Pattern.quote(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
    public final x0 c;
    public final Context d;
    public final String e;
    public final b.i.c.u.g f;
    public String g;

    public v0(Context context, String str, b.i.c.u.g gVar) {
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.d = context;
        this.e = str;
        this.f = gVar;
        this.c = new x0();
    }

    public final synchronized String a(String str, SharedPreferences sharedPreferences) {
        String lowerCase;
        String string = UUID.randomUUID().toString();
        lowerCase = string == null ? null : a.matcher(string).replaceAll("").toLowerCase(Locale.US);
        b.i.c.m.d.b.a.b("Created new Crashlytics IID: " + lowerCase);
        sharedPreferences.edit().putString("crashlytics.installation.id", lowerCase).putString("firebase.installation.id", str).apply();
        return lowerCase;
    }

    @NonNull
    public synchronized String b() {
        String str;
        String str2 = this.g;
        if (str2 != null) {
            return str2;
        }
        SharedPreferences sharedPreferencesO = h.o(this.d);
        Task<String> id2 = this.f.getId();
        String string = sharedPreferencesO.getString("firebase.installation.id", null);
        try {
            str = (String) h1.a(id2);
        } catch (Exception e) {
            if (b.i.c.m.d.b.a.a(3)) {
                Log.d("FirebaseCrashlytics", "Failed to retrieve installation id", e);
            }
            str = string != null ? string : null;
        }
        if (string != null) {
            if (string.equals(str)) {
                this.g = sharedPreferencesO.getString("crashlytics.installation.id", null);
                b.i.c.m.d.b.a.b("Found matching FID, using Crashlytics IID: " + this.g);
                if (this.g == null) {
                    this.g = a(str, sharedPreferencesO);
                }
            } else {
                this.g = a(str, sharedPreferencesO);
            }
            return this.g;
        }
        SharedPreferences sharedPreferences = this.d.getSharedPreferences("com.crashlytics.prefs", 0);
        String string2 = sharedPreferences.getString("crashlytics.installation.id", null);
        b.i.c.m.d.b.a.b("No cached FID; legacy id is " + string2);
        if (string2 == null) {
            this.g = a(str, sharedPreferencesO);
        } else {
            this.g = string2;
            d(string2, str, sharedPreferencesO, sharedPreferences);
        }
        return this.g;
    }

    public String c() {
        String str;
        x0 x0Var = this.c;
        Context context = this.d;
        synchronized (x0Var) {
            if (x0Var.a == null) {
                String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                if (installerPackageName == null) {
                    installerPackageName = "";
                }
                x0Var.a = installerPackageName;
            }
            str = "".equals(x0Var.a) ? null : x0Var.a;
        }
        return str;
    }

    public final synchronized void d(String str, String str2, SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        b.i.c.m.d.b.a.b("Migrating legacy Crashlytics IID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", str).putString("firebase.installation.id", str2).apply();
        sharedPreferences2.edit().remove("crashlytics.installation.id").remove("crashlytics.advertising.id").apply();
    }

    public final String e(String str) {
        return str.replaceAll(f1698b, "");
    }
}

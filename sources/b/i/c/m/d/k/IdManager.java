package b.i.c.m.d.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.NonNull;
import b.i.c.m.d.Logger3;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.google.android.gms.tasks.Task;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.i.c.m.d.k.v0, reason: use source file name */
/* JADX INFO: compiled from: IdManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class IdManager implements InstallIdProvider {
    public static final Pattern a = Pattern.compile("[^\\p{Alnum}]");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f1698b = Pattern.quote(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
    public final InstallerPackageNameProvider c;
    public final Context d;
    public final String e;
    public final b.i.c.u.g f;
    public String g;

    public IdManager(Context context, String str, b.i.c.u.g gVar) {
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.d = context;
        this.e = str;
        this.f = gVar;
        this.c = new InstallerPackageNameProvider();
    }

    public final synchronized String a(String str, SharedPreferences sharedPreferences) {
        String lowerCase;
        String string = UUID.randomUUID().toString();
        lowerCase = string == null ? null : a.matcher(string).replaceAll("").toLowerCase(Locale.US);
        Logger3.a.b("Created new Crashlytics IID: " + lowerCase);
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
        SharedPreferences sharedPreferencesO = CommonUtils.o(this.d);
        Task<String> id2 = this.f.getId();
        String string = sharedPreferencesO.getString("firebase.installation.id", null);
        try {
            str = (String) Utils3.a(id2);
        } catch (Exception e) {
            if (Logger3.a.a(3)) {
                Log.d("FirebaseCrashlytics", "Failed to retrieve installation id", e);
            }
            str = string != null ? string : null;
        }
        if (string != null) {
            if (string.equals(str)) {
                this.g = sharedPreferencesO.getString("crashlytics.installation.id", null);
                Logger3.a.b("Found matching FID, using Crashlytics IID: " + this.g);
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
        Logger3.a.b("No cached FID; legacy id is " + string2);
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
        InstallerPackageNameProvider installerPackageNameProvider = this.c;
        Context context = this.d;
        synchronized (installerPackageNameProvider) {
            if (installerPackageNameProvider.a == null) {
                String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                if (installerPackageName == null) {
                    installerPackageName = "";
                }
                installerPackageNameProvider.a = installerPackageName;
            }
            str = "".equals(installerPackageNameProvider.a) ? null : installerPackageNameProvider.a;
        }
        return str;
    }

    public final synchronized void d(String str, String str2, SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        Logger3.a.b("Migrating legacy Crashlytics IID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", str).putString("firebase.installation.id", str2).apply();
        sharedPreferences2.edit().remove("crashlytics.installation.id").remove("crashlytics.advertising.id").apply();
    }

    public final String e(String str) {
        return str.replaceAll(f1698b, "");
    }
}

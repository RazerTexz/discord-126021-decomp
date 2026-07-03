package p007b.p225i.p361c.p369m.p370d.p373k;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.NonNull;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.google.android.gms.tasks.Task;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p401u.InterfaceC4843g;

/* JADX INFO: renamed from: b.i.c.m.d.k.v0 */
/* JADX INFO: compiled from: IdManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4660v0 implements InterfaceC4662w0 {

    /* JADX INFO: renamed from: a */
    public static final Pattern f12407a = Pattern.compile("[^\\p{Alnum}]");

    /* JADX INFO: renamed from: b */
    public static final String f12408b = Pattern.quote(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);

    /* JADX INFO: renamed from: c */
    public final C4664x0 f12409c;

    /* JADX INFO: renamed from: d */
    public final Context f12410d;

    /* JADX INFO: renamed from: e */
    public final String f12411e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC4843g f12412f;

    /* JADX INFO: renamed from: g */
    public String f12413g;

    public C4660v0(Context context, String str, InterfaceC4843g interfaceC4843g) {
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.f12410d = context;
        this.f12411e = str;
        this.f12412f = interfaceC4843g;
        this.f12409c = new C4664x0();
    }

    /* JADX INFO: renamed from: a */
    public final synchronized String m6455a(String str, SharedPreferences sharedPreferences) {
        String lowerCase;
        String string = UUID.randomUUID().toString();
        lowerCase = string == null ? null : f12407a.matcher(string).replaceAll("").toLowerCase(Locale.US);
        C4592b.f12227a.m6371b("Created new Crashlytics IID: " + lowerCase);
        sharedPreferences.edit().putString("crashlytics.installation.id", lowerCase).putString("firebase.installation.id", str).apply();
        return lowerCase;
    }

    @NonNull
    /* JADX INFO: renamed from: b */
    public synchronized String m6456b() {
        String str;
        String str2 = this.f12413g;
        if (str2 != null) {
            return str2;
        }
        SharedPreferences sharedPreferencesM6421o = C4628h.m6421o(this.f12410d);
        Task<String> id2 = this.f12412f.getId();
        String string = sharedPreferencesM6421o.getString("firebase.installation.id", null);
        try {
            str = (String) C4630h1.m6432a(id2);
        } catch (Exception e) {
            if (C4592b.f12227a.m6370a(3)) {
                Log.d("FirebaseCrashlytics", "Failed to retrieve installation id", e);
            }
            str = string != null ? string : null;
        }
        if (string != null) {
            if (string.equals(str)) {
                this.f12413g = sharedPreferencesM6421o.getString("crashlytics.installation.id", null);
                C4592b.f12227a.m6371b("Found matching FID, using Crashlytics IID: " + this.f12413g);
                if (this.f12413g == null) {
                    this.f12413g = m6455a(str, sharedPreferencesM6421o);
                }
            } else {
                this.f12413g = m6455a(str, sharedPreferencesM6421o);
            }
            return this.f12413g;
        }
        SharedPreferences sharedPreferences = this.f12410d.getSharedPreferences("com.crashlytics.prefs", 0);
        String string2 = sharedPreferences.getString("crashlytics.installation.id", null);
        C4592b.f12227a.m6371b("No cached FID; legacy id is " + string2);
        if (string2 == null) {
            this.f12413g = m6455a(str, sharedPreferencesM6421o);
        } else {
            this.f12413g = string2;
            m6458d(string2, str, sharedPreferencesM6421o, sharedPreferences);
        }
        return this.f12413g;
    }

    /* JADX INFO: renamed from: c */
    public String m6457c() {
        String str;
        C4664x0 c4664x0 = this.f12409c;
        Context context = this.f12410d;
        synchronized (c4664x0) {
            if (c4664x0.f12459a == null) {
                String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                if (installerPackageName == null) {
                    installerPackageName = "";
                }
                c4664x0.f12459a = installerPackageName;
            }
            str = "".equals(c4664x0.f12459a) ? null : c4664x0.f12459a;
        }
        return str;
    }

    /* JADX INFO: renamed from: d */
    public final synchronized void m6458d(String str, String str2, SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        C4592b.f12227a.m6371b("Migrating legacy Crashlytics IID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", str).putString("firebase.installation.id", str2).apply();
        sharedPreferences2.edit().remove("crashlytics.installation.id").remove("crashlytics.advertising.id").apply();
    }

    /* JADX INFO: renamed from: e */
    public final String m6459e(String str) {
        return str.replaceAll(f12408b, "");
    }
}

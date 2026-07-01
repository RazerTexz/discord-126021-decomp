package b.i.a.f.i.b;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import b.d.b.a.outline;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends r5 {
    public long c;
    public String d;
    public Boolean e;
    public AccountManager f;
    public Boolean g;
    public long h;

    public j(u4 u4Var) {
        super(u4Var);
    }

    @Override // b.i.a.f.i.b.r5
    public final boolean r() {
        Calendar calendar = Calendar.getInstance();
        this.c = TimeUnit.MINUTES.convert(calendar.get(16) + calendar.get(15), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        this.d = outline.k(outline.b(lowerCase2, outline.b(lowerCase, 1)), lowerCase, "-", lowerCase2);
        return false;
    }

    public final boolean s(Context context) {
        if (this.e == null) {
            this.e = Boolean.FALSE;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageManager.getPackageInfo("com.google.android.gms", 128);
                    this.e = Boolean.TRUE;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return this.e.booleanValue();
    }

    public final long t() {
        o();
        return this.c;
    }

    public final String u() {
        o();
        return this.d;
    }

    @WorkerThread
    public final long v() {
        b();
        return this.h;
    }

    @WorkerThread
    public final boolean w() {
        b();
        Objects.requireNonNull((b.i.a.f.e.o.c) this.a.o);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.h > 86400000) {
            this.g = null;
        }
        Boolean bool = this.g;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (ContextCompat.checkSelfPermission(this.a.f1570b, "android.permission.GET_ACCOUNTS") != 0) {
            g().j.a("Permission error checking for dasher/unicorn accounts");
            this.h = jCurrentTimeMillis;
            this.g = Boolean.FALSE;
            return false;
        }
        if (this.f == null) {
            this.f = AccountManager.get(this.a.f1570b);
        }
        try {
            Account[] result = this.f.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, null, null).getResult();
            if (result != null && result.length > 0) {
                this.g = Boolean.TRUE;
                this.h = jCurrentTimeMillis;
                return true;
            }
            Account[] result2 = this.f.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, null, null).getResult();
            if (result2 != null && result2.length > 0) {
                this.g = Boolean.TRUE;
                this.h = jCurrentTimeMillis;
                return true;
            }
            this.h = jCurrentTimeMillis;
            this.g = Boolean.FALSE;
            return false;
        } catch (AuthenticatorException | OperationCanceledException | IOException e) {
            g().g.b("Exception checking account types", e);
        }
    }
}

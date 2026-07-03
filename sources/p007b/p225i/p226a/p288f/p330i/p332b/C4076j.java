package p007b.p225i.p226a.p288f.p330i.p332b;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;

/* JADX INFO: renamed from: b.i.a.f.i.b.j */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4076j extends AbstractC4170r5 {

    /* JADX INFO: renamed from: c */
    public long f10829c;

    /* JADX INFO: renamed from: d */
    public String f10830d;

    /* JADX INFO: renamed from: e */
    public Boolean f10831e;

    /* JADX INFO: renamed from: f */
    public AccountManager f10832f;

    /* JADX INFO: renamed from: g */
    public Boolean f10833g;

    /* JADX INFO: renamed from: h */
    public long f10834h;

    public C4076j(C4202u4 c4202u4) {
        super(c4202u4);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4170r5
    /* JADX INFO: renamed from: r */
    public final boolean mo5574r() {
        Calendar calendar = Calendar.getInstance();
        this.f10829c = TimeUnit.MINUTES.convert(calendar.get(16) + calendar.get(15), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        this.f10830d = C1643a.m859k(C1643a.m841b(lowerCase2, C1643a.m841b(lowerCase, 1)), lowerCase, "-", lowerCase2);
        return false;
    }

    /* JADX INFO: renamed from: s */
    public final boolean m5688s(Context context) {
        if (this.f10831e == null) {
            this.f10831e = Boolean.FALSE;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageManager.getPackageInfo("com.google.android.gms", 128);
                    this.f10831e = Boolean.TRUE;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return this.f10831e.booleanValue();
    }

    /* JADX INFO: renamed from: t */
    public final long m5689t() {
        m5857o();
        return this.f10829c;
    }

    /* JADX INFO: renamed from: u */
    public final String m5690u() {
        m5857o();
        return this.f10830d;
    }

    @WorkerThread
    /* JADX INFO: renamed from: v */
    public final long m5691v() {
        mo5848b();
        return this.f10834h;
    }

    @WorkerThread
    /* JADX INFO: renamed from: w */
    public final boolean m5692w() {
        mo5848b();
        Objects.requireNonNull((C3401c) this.f11202a.f11267o);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f10834h > 86400000) {
            this.f10833g = null;
        }
        Boolean bool = this.f10833g;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (ContextCompat.checkSelfPermission(this.f11202a.f11254b, "android.permission.GET_ACCOUNTS") != 0) {
            mo5726g().f11145j.m5860a("Permission error checking for dasher/unicorn accounts");
            this.f10834h = jCurrentTimeMillis;
            this.f10833g = Boolean.FALSE;
            return false;
        }
        if (this.f10832f == null) {
            this.f10832f = AccountManager.get(this.f11202a.f11254b);
        }
        try {
            Account[] result = this.f10832f.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, null, null).getResult();
            if (result != null && result.length > 0) {
                this.f10833g = Boolean.TRUE;
                this.f10834h = jCurrentTimeMillis;
                return true;
            }
            Account[] result2 = this.f10832f.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, null, null).getResult();
            if (result2 != null && result2.length > 0) {
                this.f10833g = Boolean.TRUE;
                this.f10834h = jCurrentTimeMillis;
                return true;
            }
            this.f10834h = jCurrentTimeMillis;
            this.f10833g = Boolean.FALSE;
            return false;
        } catch (AuthenticatorException | OperationCanceledException | IOException e) {
            mo5726g().f11142g.m5861b("Exception checking account types", e);
        }
    }
}

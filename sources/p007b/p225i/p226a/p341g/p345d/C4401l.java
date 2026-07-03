package p007b.p225i.p226a.p341g.p345d;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import android.icu.util.TimeZone;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.C10817R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: b.i.a.g.d.l */
/* JADX INFO: compiled from: UtcDates.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4401l {

    /* JADX INFO: renamed from: a */
    public static AtomicReference<C4400k> f11617a = new AtomicReference<>();

    /* JADX INFO: renamed from: a */
    public static long m6068a(long j) {
        Calendar calendarM6076i = m6076i();
        calendarM6076i.setTimeInMillis(j);
        return m6071d(calendarM6076i).getTimeInMillis();
    }

    /* JADX INFO: renamed from: b */
    public static int m6069b(@NonNull String str, @NonNull String str2, int i, int i2) {
        while (i2 >= 0 && i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
            if (str.charAt(i2) == '\'') {
                do {
                    i2 += i;
                    if (i2 < 0 || i2 >= str.length()) {
                        break;
                    }
                } while (str.charAt(i2) != '\'');
            }
            i2 += i;
        }
        return i2;
    }

    @TargetApi(24)
    /* JADX INFO: renamed from: c */
    public static DateFormat m6070c(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
        return instanceForSkeleton;
    }

    /* JADX INFO: renamed from: d */
    public static Calendar m6071d(Calendar calendar) {
        Calendar calendarM6077j = m6077j(calendar);
        Calendar calendarM6076i = m6076i();
        calendarM6076i.set(calendarM6077j.get(1), calendarM6077j.get(2), calendarM6077j.get(5));
        return calendarM6076i;
    }

    /* JADX INFO: renamed from: e */
    public static SimpleDateFormat m6072e() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toLocalizedPattern().replaceAll("\\s+", ""), Locale.getDefault());
        simpleDateFormat.setTimeZone(m6074g());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    /* JADX INFO: renamed from: f */
    public static String m6073f(Resources resources, SimpleDateFormat simpleDateFormat) {
        String localizedPattern = simpleDateFormat.toLocalizedPattern();
        return localizedPattern.replaceAll("d", resources.getString(C10817R.string.mtrl_picker_text_input_day_abbr)).replaceAll("M", resources.getString(C10817R.string.mtrl_picker_text_input_month_abbr)).replaceAll("y", resources.getString(C10817R.string.mtrl_picker_text_input_year_abbr));
    }

    /* JADX INFO: renamed from: g */
    public static java.util.TimeZone m6074g() {
        return java.util.TimeZone.getTimeZone("UTC");
    }

    /* JADX INFO: renamed from: h */
    public static Calendar m6075h() {
        C4400k c4400k = f11617a.get();
        if (c4400k == null) {
            c4400k = C4400k.f11614a;
        }
        java.util.TimeZone timeZone = c4400k.f11616c;
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l = c4400k.f11615b;
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
        }
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.setTimeZone(m6074g());
        return calendar;
    }

    /* JADX INFO: renamed from: i */
    public static Calendar m6076i() {
        return m6077j(null);
    }

    /* JADX INFO: renamed from: j */
    public static Calendar m6077j(@Nullable Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(m6074g());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }
}

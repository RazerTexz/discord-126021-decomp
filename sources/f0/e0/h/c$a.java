package f0.e0.h;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: compiled from: dates.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a extends ThreadLocal<DateFormat> {
    @Override // java.lang.ThreadLocal
    public DateFormat initialValue() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setLenient(false);
        simpleDateFormat.setTimeZone(f0.e0.c.e);
        return simpleDateFormat;
    }
}

package p600f0.p601e0.p606h;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import p600f0.p601e0.C12272c;

/* JADX INFO: renamed from: f0.e0.h.c */
/* JADX INFO: compiled from: dates.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12297c {

    /* JADX INFO: renamed from: a */
    public static final a f25526a = new a();

    /* JADX INFO: renamed from: b */
    public static final String[] f25527b;

    /* JADX INFO: renamed from: c */
    public static final DateFormat[] f25528c;

    /* JADX INFO: renamed from: f0.e0.h.c$a */
    /* JADX INFO: compiled from: dates.kt */
    public static final class a extends ThreadLocal<DateFormat> {
        @Override // java.lang.ThreadLocal
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(C12272c.f25401e);
            return simpleDateFormat;
        }
    }

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f25527b = strArr;
        f25528c = new DateFormat[strArr.length];
    }
}

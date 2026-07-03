package p600f0.p601e0.p609k.p610i;

import android.util.Log;
import com.discord.utilities.rest.SendUtils;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12106w;
import p507d0.p579g0.C12108y;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: f0.e0.k.i.d */
/* JADX INFO: compiled from: AndroidLog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12337d extends Handler {

    /* JADX INFO: renamed from: a */
    public static final C12337d f25791a = new C12337d();

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        int i;
        int iMin;
        C12238m.checkParameterIsNotNull(logRecord, "record");
        C12336c c12336c = C12336c.f25790c;
        String loggerName = logRecord.getLoggerName();
        C12238m.checkExpressionValueIsNotNull(loggerName, "record.loggerName");
        if (logRecord.getLevel().intValue() > Level.INFO.intValue()) {
            i = 5;
        } else {
            i = logRecord.getLevel().intValue() == Level.INFO.intValue() ? 4 : 3;
        }
        String message = logRecord.getMessage();
        C12238m.checkExpressionValueIsNotNull(message, "record.message");
        Throwable thrown = logRecord.getThrown();
        C12238m.checkParameterIsNotNull(loggerName, "loggerName");
        C12238m.checkParameterIsNotNull(message, "message");
        String strTake = C12336c.f25789b.get(loggerName);
        if (strTake == null) {
            strTake = C12108y.take(loggerName, 23);
        }
        if (Log.isLoggable(strTake, i)) {
            if (thrown != null) {
                StringBuilder sbM836X = C1643a.m836X(message, "\n");
                sbM836X.append(Log.getStackTraceString(thrown));
                message = sbM836X.toString();
            }
            int i2 = 0;
            int length = message.length();
            while (i2 < length) {
                int iIndexOf$default = C12106w.indexOf$default((CharSequence) message, '\n', i2, false, 4, (Object) null);
                if (iIndexOf$default == -1) {
                    iIndexOf$default = length;
                }
                while (true) {
                    iMin = Math.min(iIndexOf$default, i2 + SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM);
                    String strSubstring = message.substring(i2, iMin);
                    C12238m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.println(i, strTake, strSubstring);
                    if (iMin >= iIndexOf$default) {
                        break;
                    } else {
                        i2 = iMin;
                    }
                }
                i2 = iMin + 1;
            }
        }
    }
}

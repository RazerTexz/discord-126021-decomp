package f0.e0.k.i;

import android.util.Log;
import com.discord.utilities.rest.SendUtils;
import d0.g0.w;
import d0.g0.y;
import d0.z.d.m;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/* JADX INFO: compiled from: AndroidLog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends Handler {
    public static final d a = new d();

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
        m.checkParameterIsNotNull(logRecord, "record");
        c cVar = c.c;
        String loggerName = logRecord.getLoggerName();
        m.checkExpressionValueIsNotNull(loggerName, "record.loggerName");
        if (logRecord.getLevel().intValue() > Level.INFO.intValue()) {
            i = 5;
        } else {
            i = logRecord.getLevel().intValue() == Level.INFO.intValue() ? 4 : 3;
        }
        String message = logRecord.getMessage();
        m.checkExpressionValueIsNotNull(message, "record.message");
        Throwable thrown = logRecord.getThrown();
        m.checkParameterIsNotNull(loggerName, "loggerName");
        m.checkParameterIsNotNull(message, "message");
        String strTake = c.f3652b.get(loggerName);
        if (strTake == null) {
            strTake = y.take(loggerName, 23);
        }
        if (Log.isLoggable(strTake, i)) {
            if (thrown != null) {
                StringBuilder sbX = b.d.b.a.a.X(message, "\n");
                sbX.append(Log.getStackTraceString(thrown));
                message = sbX.toString();
            }
            int i2 = 0;
            int length = message.length();
            while (i2 < length) {
                int iIndexOf$default = w.indexOf$default((CharSequence) message, '\n', i2, false, 4, (Object) null);
                if (iIndexOf$default == -1) {
                    iIndexOf$default = length;
                }
                while (true) {
                    iMin = Math.min(iIndexOf$default, i2 + SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM);
                    String strSubstring = message.substring(i2, iMin);
                    m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
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

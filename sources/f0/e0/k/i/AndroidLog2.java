package f0.e0.k.i;

import android.util.Log;
import b.d.b.a.outline;
import com.discord.utilities.rest.SendUtils;
import d0.g0.Strings4;
import d0.g0._Strings;
import d0.z.d.Intrinsics3;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/* JADX INFO: renamed from: f0.e0.k.i.d, reason: use source file name */
/* JADX INFO: compiled from: AndroidLog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AndroidLog2 extends Handler {
    public static final AndroidLog2 a = new AndroidLog2();

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
        Intrinsics3.checkParameterIsNotNull(logRecord, "record");
        AndroidLog androidLog = AndroidLog.c;
        String loggerName = logRecord.getLoggerName();
        Intrinsics3.checkExpressionValueIsNotNull(loggerName, "record.loggerName");
        if (logRecord.getLevel().intValue() > Level.INFO.intValue()) {
            i = 5;
        } else {
            i = logRecord.getLevel().intValue() == Level.INFO.intValue() ? 4 : 3;
        }
        String message = logRecord.getMessage();
        Intrinsics3.checkExpressionValueIsNotNull(message, "record.message");
        Throwable thrown = logRecord.getThrown();
        Intrinsics3.checkParameterIsNotNull(loggerName, "loggerName");
        Intrinsics3.checkParameterIsNotNull(message, "message");
        String strTake = AndroidLog.f3652b.get(loggerName);
        if (strTake == null) {
            strTake = _Strings.take(loggerName, 23);
        }
        if (Log.isLoggable(strTake, i)) {
            if (thrown != null) {
                StringBuilder sbX = outline.X(message, "\n");
                sbX.append(Log.getStackTraceString(thrown));
                message = sbX.toString();
            }
            int i2 = 0;
            int length = message.length();
            while (i2 < length) {
                int iIndexOf$default = Strings4.indexOf$default((CharSequence) message, '\n', i2, false, 4, (Object) null);
                if (iIndexOf$default == -1) {
                    iIndexOf$default = length;
                }
                while (true) {
                    iMin = Math.min(iIndexOf$default, i2 + SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM);
                    String strSubstring = message.substring(i2, iMin);
                    Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
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

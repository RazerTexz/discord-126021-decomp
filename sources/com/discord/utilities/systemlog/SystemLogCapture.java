package com.discord.utilities.systemlog;

import com.discord.utilities.collections.FixedSizeLineBuffer;
import d0.g0.c;
import d0.v.a;
import d0.z.d.m;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* JADX INFO: compiled from: SystemLogCapture.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SystemLogCapture {
    public static final SystemLogCapture$Companion Companion = new SystemLogCapture$Companion(null);
    private final FixedSizeLineBuffer buffer = new FixedSizeLineBuffer(524288);
    private final FixedSizeLineBuffer tombstoneBuffer = new FixedSizeLineBuffer(102400);

    public static final /* synthetic */ void access$start(SystemLogCapture systemLogCapture) {
        systemLogCapture.start();
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0078 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void start() throws InterruptedException {
        if (!new File(SystemLogUtils.logcatPath).exists()) {
            this.buffer.addLine("Unable to locate '/system/bin/logcat'");
            return;
        }
        while (true) {
            Process processStart = null;
            try {
                processStart = new ProcessBuilder(SystemLogUtils.logcatPath).redirectErrorStream(true).start();
                m.checkNotNullExpressionValue(processStart, "logcatProcess");
                InputStream inputStream = processStart.getInputStream();
                m.checkNotNullExpressionValue(inputStream, "logcatProcess.inputStream");
                Reader inputStreamReader = new InputStreamReader(inputStream, c.a);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (Companion.shouldIncludeLogLine$app_productionGoogleRelease(line)) {
                            this.buffer.addLine(line);
                        }
                        if (SystemLogUtils.INSTANCE.getRegexExtractTombstone$app_productionGoogleRelease().matches(line)) {
                            this.tombstoneBuffer.addLine(line);
                        }
                    } catch (IOException unused) {
                    }
                }
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
                this.buffer.addLine("Exception getting system logs '" + e + '\'');
                StackTraceElement[] stackTrace = e.getStackTrace();
                m.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
                for (StackTraceElement stackTraceElement : stackTrace) {
                    this.buffer.addLine("    " + stackTraceElement);
                }
                if (processStart != null) {
                }
                Thread.sleep(1000L);
            }
            processStart.destroy();
            Thread.sleep(1000L);
        }
    }

    public final void appendOutput(StringBuilder sb) {
        m.checkNotNullParameter(sb, "sb");
        this.tombstoneBuffer.appendString(sb);
        this.buffer.appendString(sb);
    }

    public final String getOutput() {
        return this.tombstoneBuffer.getString() + '\n' + this.buffer.getString();
    }

    public final Thread startThread() {
        return a.thread$default(true, true, null, SystemLogCapture.class.getSimpleName(), 0, new SystemLogCapture$startThread$1(this), 20, null);
    }
}

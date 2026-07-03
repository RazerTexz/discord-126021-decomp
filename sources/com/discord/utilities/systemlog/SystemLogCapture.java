package com.discord.utilities.systemlog;

import com.discord.utilities.collections.FixedSizeLineBuffer;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p579g0.C12086c;
import p507d0.p579g0.C12106w;
import p507d0.p583v.C12173a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SystemLogCapture.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SystemLogCapture {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final FixedSizeLineBuffer buffer = new FixedSizeLineBuffer(524288);
    private final FixedSizeLineBuffer tombstoneBuffer = new FixedSizeLineBuffer(102400);

    /* JADX INFO: compiled from: SystemLogCapture.kt */
    public static final class Companion {
        private Companion() {
        }

        public final boolean shouldIncludeLogLine$app_productionGoogleRelease(String line) {
            C12238m.checkNotNullParameter(line, "line");
            return !C12106w.contains$default((CharSequence) line, (CharSequence) "chatty  : uid=", false, 2, (Object) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.systemlog.SystemLogCapture$startThread$1 */
    /* JADX INFO: compiled from: SystemLogCapture.kt */
    public static final class C69331 extends AbstractC12240o implements Function0<Unit> {
        public C69331() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws InterruptedException {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws InterruptedException {
            SystemLogCapture.this.start();
        }
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
                C12238m.checkNotNullExpressionValue(processStart, "logcatProcess");
                InputStream inputStream = processStart.getInputStream();
                C12238m.checkNotNullExpressionValue(inputStream, "logcatProcess.inputStream");
                Reader inputStreamReader = new InputStreamReader(inputStream, C12086c.f25136a);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (INSTANCE.shouldIncludeLogLine$app_productionGoogleRelease(line)) {
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
                C12238m.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
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
        C12238m.checkNotNullParameter(sb, "sb");
        this.tombstoneBuffer.appendString(sb);
        this.buffer.appendString(sb);
    }

    public final String getOutput() {
        return this.tombstoneBuffer.getString() + '\n' + this.buffer.getString();
    }

    public final Thread startThread() {
        return C12173a.thread((4 & 1) != 0 ? true : true, (4 & 2) != 0 ? false : true, (4 & 4) != 0 ? null : null, (4 & 8) != 0 ? null : SystemLogCapture.class.getSimpleName(), (4 & 16) != 0 ? -1 : 0, new C69331());
    }
}

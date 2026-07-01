package com.discord.utilities.systemlog;

import androidx.core.app.NotificationCompat;
import d0.g0.c;
import d0.z.d.m;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import kotlin.text.Regex;

/* JADX INFO: compiled from: SystemLogUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SystemLogUtils$fetch$1<V> implements Callable<LinkedList<String>> {
    public final /* synthetic */ Regex $filter;
    public final /* synthetic */ boolean $logErrors;
    public final /* synthetic */ LinkedList $output;

    public SystemLogUtils$fetch$1(LinkedList linkedList, Regex regex, boolean z2) {
        this.$output = linkedList;
        this.$filter = regex;
        this.$logErrors = z2;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ LinkedList<String> call() {
        return call2();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final LinkedList<String> call2() {
        Process processStart = null;
        try {
            try {
                processStart = new ProcessBuilder(SystemLogUtils.logcatPath, "-d").redirectErrorStream(true).start();
                SystemLogUtils systemLogUtils = SystemLogUtils.INSTANCE;
                m.checkNotNullExpressionValue(processStart, "logcatProcess");
                SystemLogUtils.access$waitFor(systemLogUtils, processStart);
                InputStream inputStream = processStart.getInputStream();
                m.checkNotNullExpressionValue(inputStream, "logcatProcess.inputStream");
                Reader inputStreamReader = new InputStreamReader(inputStream, c.a);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                systemLogUtils.processLogs$app_productionGoogleRelease(bufferedReader, this.$output, this.$filter);
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
                if (this.$logErrors) {
                    this.$output.add("Exception getting system logs '" + e + '\'');
                    StackTraceElement[] stackTrace = e.getStackTrace();
                    m.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        this.$output.add("    " + stackTraceElement);
                    }
                }
                if (processStart != null) {
                }
                return this.$output;
            }
            processStart.destroy();
            return this.$output;
        } catch (Throwable th) {
            if (processStart != null) {
                processStart.destroy();
            }
            throw th;
        }
    }
}

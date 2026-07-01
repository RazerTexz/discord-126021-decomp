package com.discord.utilities.systemlog;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.adjust.sdk.Constants;
import com.discord.utilities.debug.DebugPrintable3;
import d0.f0._Sequences2;
import d0.g0.Charsets2;
import d0.g0.Regex5;
import d0.g0.StringBuilderJVM;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Sets5;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.a.EmptyObservableHolder;
import j0.l.e.ScalarSynchronousObservable;
import j0.p.Schedulers2;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import rx.Observable;

/* JADX INFO: compiled from: SystemLogUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SystemLogUtils {
    public static final String logcatPath = "/system/bin/logcat";
    private static final int maxLogSize = 2500000;
    private static final Regex regexExtractTombstone;
    public static final SystemLogUtils INSTANCE = new SystemLogUtils();
    private static final DebugPrintable3 debugPrintables = new DebugPrintable3();
    private static final SystemLogCapture systemLogCapture = new SystemLogCapture();

    /* JADX INFO: compiled from: SystemLogUtils.kt */
    public static final /* data */ class Tombstone {
        private final String cause;
        private final String groupBy;
        private final String groupHash;
        private final String origin;
        private final String text;
        private final String textHash;

        public Tombstone(String str, String str2, String str3, String str4, String str5, String str6) {
            Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            Intrinsics3.checkNotNullParameter(str3, "groupBy");
            Intrinsics3.checkNotNullParameter(str4, "origin");
            Intrinsics3.checkNotNullParameter(str5, "groupHash");
            Intrinsics3.checkNotNullParameter(str6, "textHash");
            this.text = str;
            this.cause = str2;
            this.groupBy = str3;
            this.origin = str4;
            this.groupHash = str5;
            this.textHash = str6;
        }

        public static /* synthetic */ Tombstone copy$default(Tombstone tombstone, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tombstone.text;
            }
            if ((i & 2) != 0) {
                str2 = tombstone.cause;
            }
            String str7 = str2;
            if ((i & 4) != 0) {
                str3 = tombstone.groupBy;
            }
            String str8 = str3;
            if ((i & 8) != 0) {
                str4 = tombstone.origin;
            }
            String str9 = str4;
            if ((i & 16) != 0) {
                str5 = tombstone.groupHash;
            }
            String str10 = str5;
            if ((i & 32) != 0) {
                str6 = tombstone.textHash;
            }
            return tombstone.copy(str, str7, str8, str9, str10, str6);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCause() {
            return this.cause;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getGroupBy() {
            return this.groupBy;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getOrigin() {
            return this.origin;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getGroupHash() {
            return this.groupHash;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getTextHash() {
            return this.textHash;
        }

        public final Tombstone copy(String text, String cause, String groupBy, String origin, String groupHash, String textHash) {
            Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            Intrinsics3.checkNotNullParameter(groupBy, "groupBy");
            Intrinsics3.checkNotNullParameter(origin, "origin");
            Intrinsics3.checkNotNullParameter(groupHash, "groupHash");
            Intrinsics3.checkNotNullParameter(textHash, "textHash");
            return new Tombstone(text, cause, groupBy, origin, groupHash, textHash);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Tombstone)) {
                return false;
            }
            Tombstone tombstone = (Tombstone) other;
            return Intrinsics3.areEqual(this.text, tombstone.text) && Intrinsics3.areEqual(this.cause, tombstone.cause) && Intrinsics3.areEqual(this.groupBy, tombstone.groupBy) && Intrinsics3.areEqual(this.origin, tombstone.origin) && Intrinsics3.areEqual(this.groupHash, tombstone.groupHash) && Intrinsics3.areEqual(this.textHash, tombstone.textHash);
        }

        public final String getCause() {
            return this.cause;
        }

        public final String getGroupBy() {
            return this.groupBy;
        }

        public final String getGroupHash() {
            return this.groupHash;
        }

        public final String getOrigin() {
            return this.origin;
        }

        public final String getText() {
            return this.text;
        }

        public final String getTextHash() {
            return this.textHash;
        }

        public int hashCode() {
            String str = this.text;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.cause;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.groupBy;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.origin;
            int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.groupHash;
            int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.textHash;
            return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Tombstone(text=");
            sbU.append(this.text);
            sbU.append(", cause=");
            sbU.append(this.cause);
            sbU.append(", groupBy=");
            sbU.append(this.groupBy);
            sbU.append(", origin=");
            sbU.append(this.origin);
            sbU.append(", groupHash=");
            sbU.append(this.groupHash);
            sbU.append(", textHash=");
            return outline.J(sbU, this.textHash, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.systemlog.SystemLogUtils$hashString$1, reason: invalid class name */
    /* JADX INFO: compiled from: SystemLogUtils.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Byte, CharSequence> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Byte b2) {
            return invoke(b2.byteValue());
        }

        public final CharSequence invoke(byte b2) {
            return outline.P(new Object[]{Byte.valueOf(b2)}, 1, "%02X", "java.lang.String.format(this, *args)");
        }
    }

    static {
        StringBuilder sbU = outline.U("(?:^(?:[^\\s]+\\s+){4}F\\s+DEBUG\\s+:\\s(.+))|(^.+(\\[");
        sbU.append(Regex.INSTANCE.escape("libdiscord_version"));
        sbU.append("\\].+))");
        regexExtractTombstone = new Regex(sbU.toString());
    }

    private SystemLogUtils() {
    }

    private final String hashString(String input) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA1);
        Charset charset = Charsets2.a;
        Objects.requireNonNull(input, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = input.getBytes(charset);
        Intrinsics3.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        Intrinsics3.checkNotNullExpressionValue(bArrDigest, "bytes");
        return _Arrays.joinToString$default(bArrDigest, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, AnonymousClass1.INSTANCE, 30, (Object) null);
    }

    private final void waitFor(Process process) throws InterruptedException {
        long nanos = TimeUnit.SECONDS.toNanos(15L) + System.nanoTime();
        do {
            try {
                process.exitValue();
                return;
            } catch (IllegalThreadStateException unused) {
                Thread.sleep(100L);
            }
        } while (System.nanoTime() < nanos);
    }

    public final String fetch() {
        StringBuilder sb = new StringBuilder();
        debugPrintables.debugPrint(sb);
        systemLogCapture.appendOutput(sb);
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public final Observable<Tombstone> fetchLastTombstone() {
        Observable observableA = fetch(regexExtractTombstone).A(new Func1<LinkedList<String>, Observable<? extends Tombstone>>() { // from class: com.discord.utilities.systemlog.SystemLogUtils.fetchLastTombstone.1
            @Override // j0.k.Func1
            public final Observable<? extends Tombstone> call(LinkedList<String> linkedList) {
                SystemLogUtils systemLogUtils = SystemLogUtils.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(linkedList, "crashes");
                Tombstone tombstoneFetchLastTombstone$app_productionGoogleRelease = systemLogUtils.fetchLastTombstone$app_productionGoogleRelease(linkedList);
                return tombstoneFetchLastTombstone$app_productionGoogleRelease == null ? EmptyObservableHolder.k : new ScalarSynchronousObservable(tombstoneFetchLastTombstone$app_productionGoogleRelease);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableA, "fetch(regexExtractTombst…ble.just(tombstone)\n    }");
        return observableA;
    }

    public final Tombstone fetchLastTombstone$app_productionGoogleRelease(Collection<String> crashes) {
        String str;
        List<String> groupValues;
        Object next;
        Intrinsics3.checkNotNullParameter(crashes, "crashes");
        String str2 = null;
        if (crashes.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String str3 = null;
        String str4 = null;
        for (String str5 : crashes) {
            if (Strings4.contains$default((CharSequence) str5, (CharSequence) "libdiscord_version", false, 2, (Object) null)) {
                str3 = str5;
            } else {
                if (Strings4.contains$default((CharSequence) str5, (CharSequence) "*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***", false, 2, (Object) null)) {
                    StringBuilderJVM.clear(sb);
                    str4 = str3;
                }
                sb.append(str5);
                Intrinsics3.checkNotNullExpressionValue(sb, "append(value)");
                sb.append('\n');
                Intrinsics3.checkNotNullExpressionValue(sb, "append('\\n')");
            }
        }
        if (!StringsJVM.isBlank(sb)) {
            sb.append('\n');
            Intrinsics3.checkNotNullExpressionValue(sb, "append('\\n')");
            sb.append("Tombstone's libdiscord_version: ");
            if (str4 == null) {
                str4 = "Unknown libdiscord_version";
            }
            sb.append(str4);
            Intrinsics3.checkNotNullExpressionValue(sb, "append(value)");
            sb.append('\n');
            Intrinsics3.checkNotNullExpressionValue(sb, "append('\\n')");
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().also { s…\n      }\n    }.toString()");
        if (StringsJVM.isBlank(string)) {
            return null;
        }
        Regex5 regex5 = Regex5.MULTILINE;
        Regex regex = new Regex("^Cause: (.+)$", regex5);
        Sequence map = _Sequences2.map(Regex.findAll$default(new Regex("^\\s+#\\d+ pc .+/(.+? .+?)\\+?[+)]", regex5), string, 0, 2, null), new SystemLogUtils2(new Regex("classes\\d+.dex")));
        HashSet hashSetHashSetOf = Sets5.hashSetOf("libc.so (abort", "libart.so (art::Runtime::Abort(char const*", "libbase.so (android::base::LogMessage::~LogMessage(");
        try {
            Iterator it = map.iterator();
            do {
                if (!it.hasNext()) {
                    throw new NoSuchElementException("Sequence contains no element matching the predicate.");
                }
                next = it.next();
            } while (!(!hashSetHashSetOf.contains((String) next)));
            str = (String) next;
        } catch (NoSuchElementException unused) {
            str = "Unknown";
        }
        String strJoinToString$default = _Sequences2.joinToString$default(map, "\n", null, null, 0, null, null, 62, null);
        MatchResult matchResultFind$default = Regex.find$default(regex, string, 0, 2, null);
        if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
            str2 = groupValues.get(1);
        }
        return new Tombstone(string, str2, strJoinToString$default, str, hashString(strJoinToString$default), hashString(string));
    }

    public final DebugPrintable3 getDebugPrintables$app_productionGoogleRelease() {
        return debugPrintables;
    }

    public final Regex getRegexExtractTombstone$app_productionGoogleRelease() {
        return regexExtractTombstone;
    }

    public final Thread initSystemLogCapture() {
        return systemLogCapture.startThread();
    }

    public final void processLogs$app_productionGoogleRelease(BufferedReader reader, LinkedList<String> output, Regex filter) {
        String strPrevious;
        Intrinsics3.checkNotNullParameter(reader, "reader");
        Intrinsics3.checkNotNullParameter(output, "output");
        int i = 0;
        while (true) {
            try {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                if (filter != null) {
                    MatchResult matchResultFind$default = Regex.find$default(filter, line, 0, 2, null);
                    if (matchResultFind$default != null) {
                        List<String> groupValues = matchResultFind$default.getGroupValues();
                        ListIterator<String> listIterator = groupValues.listIterator(groupValues.size());
                        do {
                            if (!listIterator.hasPrevious()) {
                                throw new NoSuchElementException("List contains no element matching the predicate.");
                            }
                            strPrevious = listIterator.previous();
                        } while (!(strPrevious.length() > 0));
                        line = strPrevious;
                    } else {
                        continue;
                    }
                }
                if (!StringsJVM.isBlank(line) && !Strings4.contains$default((CharSequence) line, (CharSequence) "Accessing hidden method", false, 2, (Object) null)) {
                    int length = line.length() + 1 + i;
                    try {
                        output.add(line);
                        if (length > maxLogSize) {
                            length -= output.pop().length() - 1;
                        }
                        i = length;
                    } catch (Exception e) {
                        e = e;
                        i = length;
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
            e.printStackTrace();
            if (filter == null) {
                output.add("IOException: " + e);
            }
        }
        if (i > maxLogSize) {
            output.pop().length();
        }
    }

    private final Observable<LinkedList<String>> fetch(final Regex filter) {
        final LinkedList linkedList = new LinkedList();
        final boolean z2 = filter == null;
        if (!new File(logcatPath).exists()) {
            if (z2) {
                linkedList.add("Unable to locate '/system/bin/logcat'");
            }
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(linkedList);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(output)");
            return scalarSynchronousObservable;
        }
        Observable<LinkedList<String>> observableX = Observable.D(new Callable<LinkedList<String>>() { // from class: com.discord.utilities.systemlog.SystemLogUtils.fetch.1
            @Override // java.util.concurrent.Callable
            public final LinkedList<String> call() {
                Process processStart = null;
                try {
                    try {
                        processStart = new ProcessBuilder(SystemLogUtils.logcatPath, "-d").redirectErrorStream(true).start();
                        SystemLogUtils systemLogUtils = SystemLogUtils.INSTANCE;
                        Intrinsics3.checkNotNullExpressionValue(processStart, "logcatProcess");
                        systemLogUtils.waitFor(processStart);
                        InputStream inputStream = processStart.getInputStream();
                        Intrinsics3.checkNotNullExpressionValue(inputStream, "logcatProcess.inputStream");
                        Reader inputStreamReader = new InputStreamReader(inputStream, Charsets2.a);
                        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                        systemLogUtils.processLogs$app_productionGoogleRelease(bufferedReader, linkedList, filter);
                        bufferedReader.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (z2) {
                            linkedList.add("Exception getting system logs '" + e + '\'');
                            StackTraceElement[] stackTrace = e.getStackTrace();
                            Intrinsics3.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
                            for (StackTraceElement stackTraceElement : stackTrace) {
                                linkedList.add("    " + stackTraceElement);
                            }
                        }
                        if (processStart != null) {
                        }
                        return linkedList;
                    }
                    processStart.destroy();
                    return linkedList;
                } catch (Throwable th) {
                    if (processStart != null) {
                        processStart.destroy();
                    }
                    throw th;
                }
            }
        }).X(Schedulers2.b().d);
        Intrinsics3.checkNotNullExpressionValue(observableX, "Observable.fromCallable …n(Schedulers.newThread())");
        return observableX;
    }
}

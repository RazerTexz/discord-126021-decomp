package com.discord.utilities.systemlog;

import androidx.core.app.NotificationCompat;
import com.adjust.sdk.Constants;
import com.discord.utilities.debug.DebugPrintableCollection;
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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p578f0.C12078q;
import p507d0.p579g0.C12086c;
import p507d0.p579g0.C12099p;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p579g0.EnumC12092i;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p643a.EnumC12606c;
import p637j0.p642l.p647e.C12721k;
import p637j0.p653p.C12781a;
import p658rx.Observable;

/* JADX INFO: compiled from: SystemLogUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SystemLogUtils {
    public static final String logcatPath = "/system/bin/logcat";
    private static final int maxLogSize = 2500000;
    private static final Regex regexExtractTombstone;
    public static final SystemLogUtils INSTANCE = new SystemLogUtils();
    private static final DebugPrintableCollection debugPrintables = new DebugPrintableCollection();
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
            C12238m.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            C12238m.checkNotNullParameter(str3, "groupBy");
            C12238m.checkNotNullParameter(str4, "origin");
            C12238m.checkNotNullParameter(str5, "groupHash");
            C12238m.checkNotNullParameter(str6, "textHash");
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
            C12238m.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            C12238m.checkNotNullParameter(groupBy, "groupBy");
            C12238m.checkNotNullParameter(origin, "origin");
            C12238m.checkNotNullParameter(groupHash, "groupHash");
            C12238m.checkNotNullParameter(textHash, "textHash");
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
            return C12238m.areEqual(this.text, tombstone.text) && C12238m.areEqual(this.cause, tombstone.cause) && C12238m.areEqual(this.groupBy, tombstone.groupBy) && C12238m.areEqual(this.origin, tombstone.origin) && C12238m.areEqual(this.groupHash, tombstone.groupHash) && C12238m.areEqual(this.textHash, tombstone.textHash);
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
            StringBuilder sbM833U = C1643a.m833U("Tombstone(text=");
            sbM833U.append(this.text);
            sbM833U.append(", cause=");
            sbM833U.append(this.cause);
            sbM833U.append(", groupBy=");
            sbM833U.append(this.groupBy);
            sbM833U.append(", origin=");
            sbM833U.append(this.origin);
            sbM833U.append(", groupHash=");
            sbM833U.append(this.groupHash);
            sbM833U.append(", textHash=");
            return C1643a.m822J(sbM833U, this.textHash, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.systemlog.SystemLogUtils$hashString$1 */
    /* JADX INFO: compiled from: SystemLogUtils.kt */
    public static final class C69381 extends AbstractC12240o implements Function1<Byte, CharSequence> {
        public static final C69381 INSTANCE = new C69381();

        public C69381() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Byte b2) {
            return invoke(b2.byteValue());
        }

        public final CharSequence invoke(byte b2) {
            return C1643a.m828P(new Object[]{Byte.valueOf(b2)}, 1, "%02X", "java.lang.String.format(this, *args)");
        }
    }

    static {
        StringBuilder sbM833U = C1643a.m833U("(?:^(?:[^\\s]+\\s+){4}F\\s+DEBUG\\s+:\\s(.+))|(^.+(\\[");
        sbM833U.append(Regex.INSTANCE.escape("libdiscord_version"));
        sbM833U.append("\\].+))");
        regexExtractTombstone = new Regex(sbM833U.toString());
    }

    private SystemLogUtils() {
    }

    private final String hashString(String input) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA1);
        Charset charset = C12086c.f25136a;
        Objects.requireNonNull(input, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = input.getBytes(charset);
        C12238m.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        C12238m.checkNotNullExpressionValue(bArrDigest, "bytes");
        return C12141k.joinToString$default(bArrDigest, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, C69381.INSTANCE, 30, (Object) null);
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
        C12238m.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public final Observable<Tombstone> fetchLastTombstone() {
        Observable observableM11082A = fetch(regexExtractTombstone).m11082A(new InterfaceC12589b<LinkedList<String>, Observable<? extends Tombstone>>() { // from class: com.discord.utilities.systemlog.SystemLogUtils.fetchLastTombstone.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Tombstone> call(LinkedList<String> linkedList) {
                SystemLogUtils systemLogUtils = SystemLogUtils.INSTANCE;
                C12238m.checkNotNullExpressionValue(linkedList, "crashes");
                Tombstone tombstoneFetchLastTombstone$app_productionGoogleRelease = systemLogUtils.fetchLastTombstone$app_productionGoogleRelease(linkedList);
                return tombstoneFetchLastTombstone$app_productionGoogleRelease == null ? EnumC12606c.f26751k : new C12721k(tombstoneFetchLastTombstone$app_productionGoogleRelease);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11082A, "fetch(regexExtractTombst…ble.just(tombstone)\n    }");
        return observableM11082A;
    }

    public final Tombstone fetchLastTombstone$app_productionGoogleRelease(Collection<String> crashes) {
        String str;
        List<String> groupValues;
        Object next;
        C12238m.checkNotNullParameter(crashes, "crashes");
        String str2 = null;
        if (crashes.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String str3 = null;
        String str4 = null;
        for (String str5 : crashes) {
            if (C12106w.contains$default((CharSequence) str5, (CharSequence) "libdiscord_version", false, 2, (Object) null)) {
                str3 = str5;
            } else {
                if (C12106w.contains$default((CharSequence) str5, (CharSequence) "*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***", false, 2, (Object) null)) {
                    C12099p.clear(sb);
                    str4 = str3;
                }
                sb.append(str5);
                C12238m.checkNotNullExpressionValue(sb, "append(value)");
                sb.append('\n');
                C12238m.checkNotNullExpressionValue(sb, "append('\\n')");
            }
        }
        if (!C12103t.isBlank(sb)) {
            sb.append('\n');
            C12238m.checkNotNullExpressionValue(sb, "append('\\n')");
            sb.append("Tombstone's libdiscord_version: ");
            if (str4 == null) {
                str4 = "Unknown libdiscord_version";
            }
            sb.append(str4);
            C12238m.checkNotNullExpressionValue(sb, "append(value)");
            sb.append('\n');
            C12238m.checkNotNullExpressionValue(sb, "append('\\n')");
        }
        String string = sb.toString();
        C12238m.checkNotNullExpressionValue(string, "StringBuilder().also { s…\n      }\n    }.toString()");
        if (C12103t.isBlank(string)) {
            return null;
        }
        EnumC12092i enumC12092i = EnumC12092i.MULTILINE;
        Regex regex = new Regex("^Cause: (.+)$", enumC12092i);
        Sequence map = C12078q.map(Regex.findAll$default(new Regex("^\\s+#\\d+ pc .+/(.+? .+?)\\+?[+)]", enumC12092i), string, 0, 2, null), new SystemLogUtils$fetchLastTombstone$extractedGroups$1(new Regex("classes\\d+.dex")));
        HashSet hashSetHashSetOf = C12148n0.hashSetOf("libc.so (abort", "libart.so (art::Runtime::Abort(char const*", "libbase.so (android::base::LogMessage::~LogMessage(");
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
        String strJoinToString$default = C12078q.joinToString$default(map, "\n", null, null, 0, null, null, 62, null);
        MatchResult matchResultFind$default = Regex.find$default(regex, string, 0, 2, null);
        if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
            str2 = groupValues.get(1);
        }
        return new Tombstone(string, str2, strJoinToString$default, str, hashString(strJoinToString$default), hashString(string));
    }

    public final DebugPrintableCollection getDebugPrintables$app_productionGoogleRelease() {
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
        C12238m.checkNotNullParameter(reader, "reader");
        C12238m.checkNotNullParameter(output, "output");
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
                if (!C12103t.isBlank(line) && !C12106w.contains$default((CharSequence) line, (CharSequence) "Accessing hidden method", false, 2, (Object) null)) {
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
            C12721k c12721k = new C12721k(linkedList);
            C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(output)");
            return c12721k;
        }
        Observable<LinkedList<String>> observableM11098X = Observable.m11060D(new Callable<LinkedList<String>>() { // from class: com.discord.utilities.systemlog.SystemLogUtils.fetch.1
            @Override // java.util.concurrent.Callable
            public final LinkedList<String> call() {
                Process processStart = null;
                try {
                    try {
                        processStart = new ProcessBuilder(SystemLogUtils.logcatPath, "-d").redirectErrorStream(true).start();
                        SystemLogUtils systemLogUtils = SystemLogUtils.INSTANCE;
                        C12238m.checkNotNullExpressionValue(processStart, "logcatProcess");
                        systemLogUtils.waitFor(processStart);
                        InputStream inputStream = processStart.getInputStream();
                        C12238m.checkNotNullExpressionValue(inputStream, "logcatProcess.inputStream");
                        Reader inputStreamReader = new InputStreamReader(inputStream, C12086c.f25136a);
                        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                        systemLogUtils.processLogs$app_productionGoogleRelease(bufferedReader, linkedList, filter);
                        bufferedReader.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (z2) {
                            linkedList.add("Exception getting system logs '" + e + '\'');
                            StackTraceElement[] stackTrace = e.getStackTrace();
                            C12238m.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
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
        }).m11098X(C12781a.m10874b().f27396d);
        C12238m.checkNotNullExpressionValue(observableM11098X, "Observable.fromCallable …n(Schedulers.newThread())");
        return observableM11098X;
    }
}

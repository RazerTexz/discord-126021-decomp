package com.discord.utilities.systemlog;

import b.d.b.a.a;
import com.adjust.sdk.Constants;
import com.discord.utilities.debug.DebugPrintableCollection;
import d0.f0.q;
import d0.g0.c;
import d0.g0.i;
import d0.g0.p;
import d0.g0.t;
import d0.g0.w;
import d0.t.k;
import d0.t.n0;
import d0.z.d.m;
import java.io.BufferedReader;
import java.io.File;
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
import java.util.concurrent.TimeUnit;
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
    private static final DebugPrintableCollection debugPrintables = new DebugPrintableCollection();
    private static final SystemLogCapture systemLogCapture = new SystemLogCapture();

    static {
        StringBuilder sbU = a.U("(?:^(?:[^\\s]+\\s+){4}F\\s+DEBUG\\s+:\\s(.+))|(^.+(\\[");
        sbU.append(Regex.j.escape("libdiscord_version"));
        sbU.append("\\].+))");
        regexExtractTombstone = new Regex(sbU.toString());
    }

    private SystemLogUtils() {
    }

    public static final /* synthetic */ void access$waitFor(SystemLogUtils systemLogUtils, Process process) throws InterruptedException {
        systemLogUtils.waitFor(process);
    }

    private final String hashString(String input) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA1);
        Charset charset = c.a;
        Objects.requireNonNull(input, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = input.getBytes(charset);
        m.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        m.checkNotNullExpressionValue(bArrDigest, "bytes");
        return k.joinToString$default(bArrDigest, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, SystemLogUtils$hashString$1.INSTANCE, 30, (Object) null);
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
        m.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public final Observable<SystemLogUtils$Tombstone> fetchLastTombstone() {
        Observable observableA = fetch(regexExtractTombstone).A(SystemLogUtils$fetchLastTombstone$1.INSTANCE);
        m.checkNotNullExpressionValue(observableA, "fetch(regexExtractTombst…ble.just(tombstone)\n    }");
        return observableA;
    }

    public final SystemLogUtils$Tombstone fetchLastTombstone$app_productionGoogleRelease(Collection<String> crashes) {
        String str;
        List<String> groupValues;
        Object next;
        m.checkNotNullParameter(crashes, "crashes");
        String str2 = null;
        if (crashes.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String str3 = null;
        String str4 = null;
        for (String str5 : crashes) {
            if (w.contains$default((CharSequence) str5, (CharSequence) "libdiscord_version", false, 2, (Object) null)) {
                str3 = str5;
            } else {
                if (w.contains$default((CharSequence) str5, (CharSequence) "*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***", false, 2, (Object) null)) {
                    p.clear(sb);
                    str4 = str3;
                }
                sb.append(str5);
                m.checkNotNullExpressionValue(sb, "append(value)");
                sb.append('\n');
                m.checkNotNullExpressionValue(sb, "append('\\n')");
            }
        }
        if (!t.isBlank(sb)) {
            sb.append('\n');
            m.checkNotNullExpressionValue(sb, "append('\\n')");
            sb.append("Tombstone's libdiscord_version: ");
            if (str4 == null) {
                str4 = "Unknown libdiscord_version";
            }
            sb.append(str4);
            m.checkNotNullExpressionValue(sb, "append(value)");
            sb.append('\n');
            m.checkNotNullExpressionValue(sb, "append('\\n')");
        }
        String string = sb.toString();
        m.checkNotNullExpressionValue(string, "StringBuilder().also { s…\n      }\n    }.toString()");
        if (t.isBlank(string)) {
            return null;
        }
        i iVar = i.MULTILINE;
        Regex regex = new Regex("^Cause: (.+)$", iVar);
        Sequence map = q.map(Regex.findAll$default(new Regex("^\\s+#\\d+ pc .+/(.+? .+?)\\+?[+)]", iVar), string, 0, 2, null), new SystemLogUtils$fetchLastTombstone$extractedGroups$1(new Regex("classes\\d+.dex")));
        HashSet hashSetHashSetOf = n0.hashSetOf("libc.so (abort", "libart.so (art::Runtime::Abort(char const*", "libbase.so (android::base::LogMessage::~LogMessage(");
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
        String strJoinToString$default = q.joinToString$default(map, "\n", null, null, 0, null, null, 62, null);
        MatchResult matchResultFind$default = Regex.find$default(regex, string, 0, 2, null);
        if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
            str2 = groupValues.get(1);
        }
        return new SystemLogUtils$Tombstone(string, str2, strJoinToString$default, str, hashString(strJoinToString$default), hashString(string));
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
        m.checkNotNullParameter(reader, "reader");
        m.checkNotNullParameter(output, "output");
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
                if (!t.isBlank(line) && !w.contains$default((CharSequence) line, (CharSequence) "Accessing hidden method", false, 2, (Object) null)) {
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

    private final Observable<LinkedList<String>> fetch(Regex filter) {
        LinkedList linkedList = new LinkedList();
        boolean z2 = filter == null;
        if (!new File(logcatPath).exists()) {
            if (z2) {
                linkedList.add("Unable to locate '/system/bin/logcat'");
            }
            j0.l.e.k kVar = new j0.l.e.k(linkedList);
            m.checkNotNullExpressionValue(kVar, "Observable.just(output)");
            return kVar;
        }
        Observable<LinkedList<String>> observableX = Observable.D(new SystemLogUtils$fetch$1(linkedList, filter, z2)).X(j0.p.a.b().d);
        m.checkNotNullExpressionValue(observableX, "Observable.fromCallable …n(Schedulers.newThread())");
        return observableX;
    }
}

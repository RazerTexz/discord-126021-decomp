package p658rx.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    /* JADX INFO: renamed from: rx.exceptions.CompositeException$a */
    public static final class C13009a extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        @Override // java.lang.Throwable
        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    /* JADX INFO: renamed from: rx.exceptions.CompositeException$b */
    public static abstract class AbstractC13010b {
        /* JADX INFO: renamed from: a */
        public abstract Object mo11124a();

        /* JADX INFO: renamed from: b */
        public abstract void mo11125b(Object obj);
    }

    /* JADX INFO: renamed from: rx.exceptions.CompositeException$c */
    public static final class C13011c extends AbstractC13010b {

        /* JADX INFO: renamed from: a */
        public final PrintStream f27641a;

        public C13011c(PrintStream printStream) {
            this.f27641a = printStream;
        }

        @Override // p658rx.exceptions.CompositeException.AbstractC13010b
        /* JADX INFO: renamed from: a */
        public Object mo11124a() {
            return this.f27641a;
        }

        @Override // p658rx.exceptions.CompositeException.AbstractC13010b
        /* JADX INFO: renamed from: b */
        public void mo11125b(Object obj) {
            this.f27641a.println(obj);
        }
    }

    /* JADX INFO: renamed from: rx.exceptions.CompositeException$d */
    public static final class C13012d extends AbstractC13010b {

        /* JADX INFO: renamed from: a */
        public final PrintWriter f27642a;

        public C13012d(PrintWriter printWriter) {
            this.f27642a = printWriter;
        }

        @Override // p658rx.exceptions.CompositeException.AbstractC13010b
        /* JADX INFO: renamed from: a */
        public Object mo11124a() {
            return this.f27642a;
        }

        @Override // p658rx.exceptions.CompositeException.AbstractC13010b
        /* JADX INFO: renamed from: b */
        public void mo11125b(Object obj) {
            this.f27642a.println(obj);
        }
    }

    public CompositeException(Collection<? extends Throwable> collection) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            for (Throwable th : collection) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).exceptions);
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        List<Throwable> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        this.exceptions = listUnmodifiableList;
        this.message = listUnmodifiableList.size() + " exceptions occurred. ";
    }

    /* JADX INFO: renamed from: a */
    public final void m11121a(StringBuilder sb, Throwable th, String str) {
        sb.append(str);
        sb.append(th);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            m11121a(sb, th.getCause(), "");
        }
    }

    /* JADX INFO: renamed from: b */
    public List<Throwable> m11122b() {
        return this.exceptions;
    }

    /* JADX INFO: renamed from: c */
    public final void m11123c(AbstractC13010b abstractC13010b) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        int i = 1;
        for (Throwable th : this.exceptions) {
            sb.append("  ComposedException ");
            sb.append(i);
            sb.append(" :\n");
            m11121a(sb, th, "\t");
            i++;
        }
        synchronized (abstractC13010b.mo11124a()) {
            abstractC13010b.mo11125b(sb.toString());
        }
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        if (this.cause == null) {
            C13009a c13009a = new C13009a();
            HashSet hashSet = new HashSet();
            Iterator<Throwable> it = this.exceptions.iterator();
            C13009a c13009a2 = c13009a;
            while (it.hasNext()) {
                Throwable next = it.next();
                if (!hashSet.contains(next)) {
                    hashSet.add(next);
                    ArrayList<Throwable> arrayList = new ArrayList();
                    Throwable cause = next.getCause();
                    if (cause != null && cause != next) {
                        while (true) {
                            arrayList.add(cause);
                            Throwable cause2 = cause.getCause();
                            if (cause2 == null || cause2 == cause) {
                                break;
                                break;
                            }
                            cause = cause.getCause();
                        }
                    }
                    for (Throwable th : arrayList) {
                        if (hashSet.contains(th)) {
                            next = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            hashSet.add(th);
                        }
                    }
                    try {
                        c13009a2.initCause(next);
                    } catch (Throwable unused) {
                    }
                    Throwable cause3 = c13009a2.getCause();
                    if (cause3 != null && cause3 != c13009a2) {
                        while (true) {
                            Throwable cause4 = cause3.getCause();
                            if (cause4 == null || cause4 == cause3) {
                                break;
                                break;
                            }
                            cause3 = cause3.getCause();
                        }
                        c13009a2 = cause3;
                    }
                }
            }
            this.cause = c13009a;
        }
        return this.cause;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        m11123c(new C13011c(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        m11123c(new C13012d(printWriter));
    }

    public CompositeException(Throwable... thArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        for (Throwable th : thArr) {
            if (th instanceof CompositeException) {
                linkedHashSet.addAll(((CompositeException) th).exceptions);
            } else if (th != null) {
                linkedHashSet.add(th);
            } else {
                linkedHashSet.add(new NullPointerException());
            }
        }
        arrayList.addAll(linkedHashSet);
        List<Throwable> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        this.exceptions = listUnmodifiableList;
        this.message = listUnmodifiableList.size() + " exceptions occurred. ";
    }
}

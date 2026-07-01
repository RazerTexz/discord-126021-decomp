package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session;
import com.adjust.sdk.Constants;
import com.google.auto.value.AutoValue;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: b.i.c.m.d.m.v, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsReport.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class CrashlyticsReport {
    public static final Charset a = Charset.forName(Constants.ENCODING);

    /* JADX INFO: renamed from: b.i.c.m.d.m.v$a */
    /* JADX INFO: compiled from: CrashlyticsReport.java */
    @AutoValue.Builder
    public static abstract class a {
        @NonNull
        public abstract CrashlyticsReport a();
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.v$b */
    /* JADX INFO: compiled from: CrashlyticsReport.java */
    @AutoValue
    public static abstract class b {
        @NonNull
        public abstract String a();

        @NonNull
        public abstract String b();
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.v$c */
    /* JADX INFO: compiled from: CrashlyticsReport.java */
    @AutoValue
    public static abstract class c {

        /* JADX INFO: renamed from: b.i.c.m.d.m.v$c$a */
        /* JADX INFO: compiled from: CrashlyticsReport.java */
        @AutoValue
        public static abstract class a {
            @NonNull
            public abstract byte[] a();

            @NonNull
            public abstract String b();
        }

        @NonNull
        public abstract ImmutableList3<a> a();

        @Nullable
        public abstract String b();
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.v$d */
    /* JADX INFO: compiled from: CrashlyticsReport.java */
    @AutoValue
    public static abstract class d {

        /* JADX INFO: renamed from: b.i.c.m.d.m.v$d$a */
        /* JADX INFO: compiled from: CrashlyticsReport.java */
        @AutoValue
        public static abstract class a {

            /* JADX INFO: renamed from: b.i.c.m.d.m.v$d$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: CrashlyticsReport.java */
            @AutoValue
            public static abstract class AbstractC0048a {
                @NonNull
                public abstract String a();
            }

            @Nullable
            public abstract String a();

            @Nullable
            public abstract String b();

            @Nullable
            public abstract String c();

            @NonNull
            public abstract String d();

            @Nullable
            public abstract String e();

            @Nullable
            public abstract AbstractC0048a f();

            @NonNull
            public abstract String g();
        }

        /* JADX INFO: renamed from: b.i.c.m.d.m.v$d$b */
        /* JADX INFO: compiled from: CrashlyticsReport.java */
        @AutoValue.Builder
        public static abstract class b {
            @NonNull
            public abstract d a();
        }

        /* JADX INFO: renamed from: b.i.c.m.d.m.v$d$c */
        /* JADX INFO: compiled from: CrashlyticsReport.java */
        @AutoValue
        public static abstract class c {

            /* JADX INFO: renamed from: b.i.c.m.d.m.v$d$c$a */
            /* JADX INFO: compiled from: CrashlyticsReport.java */
            @AutoValue.Builder
            public static abstract class a {
            }

            @NonNull
            public abstract int a();

            public abstract int b();

            public abstract long c();

            @NonNull
            public abstract String d();

            @NonNull
            public abstract String e();

            @NonNull
            public abstract String f();

            public abstract long g();

            public abstract int h();

            public abstract boolean i();
        }

        /* JADX INFO: renamed from: b.i.c.m.d.m.v$d$d, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CrashlyticsReport.java */
        @AutoValue
        public static abstract class AbstractC0049d {

            /* JADX INFO: renamed from: b.i.c.m.d.m.v$d$d$a */
            /* JADX INFO: compiled from: CrashlyticsReport.java */
            @AutoValue
            public static abstract class a {

                /* JADX INFO: renamed from: b.i.c.m.d.m.v$d$d$a$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: CrashlyticsReport.java */
                @AutoValue.Builder
                public static abstract class AbstractC0050a {
                }

                /* JADX INFO: renamed from: b.i.c.m.d.m.v$d$d$a$b */
                /* JADX INFO: compiled from: CrashlyticsReport.java */
                @AutoValue
                public static abstract class b {

                    /* JADX INFO: renamed from: b.i.c.m.d.m.v$d$d$a$b$a, reason: collision with other inner class name */
                    /* JADX INFO: compiled from: CrashlyticsReport.java */
                    @AutoValue
                    public static abstract class AbstractC0051a {
                        @NonNull
                        public abstract long a();

                        @NonNull
                        public abstract String b();

                        public abstract long c();

                        @Nullable
                        public abstract String d();
                    }

                    /* JADX INFO: renamed from: b.i.c.m.d.m.v$d$d$a$b$b, reason: collision with other inner class name */
                    /* JADX INFO: compiled from: CrashlyticsReport.java */
                    @AutoValue
                    public static abstract class AbstractC0052b {
                        @Nullable
                        public abstract AbstractC0052b a();

                        @NonNull
                        public abstract ImmutableList3<AbstractC0053d.AbstractC0054a> b();

                        public abstract int c();

                        @Nullable
                        public abstract String d();

                        @NonNull
                        public abstract String e();
                    }

                    /* JADX INFO: renamed from: b.i.c.m.d.m.v$d$d$a$b$c */
                    /* JADX INFO: compiled from: CrashlyticsReport.java */
                    @AutoValue
                    public static abstract class c {
                        @NonNull
                        public abstract long a();

                        @NonNull
                        public abstract String b();

                        @NonNull
                        public abstract String c();
                    }

                    /* JADX INFO: renamed from: b.i.c.m.d.m.v$d$d$a$b$d, reason: collision with other inner class name */
                    /* JADX INFO: compiled from: CrashlyticsReport.java */
                    @AutoValue
                    public static abstract class AbstractC0053d {

                        /* JADX INFO: renamed from: b.i.c.m.d.m.v$d$d$a$b$d$a, reason: collision with other inner class name */
                        /* JADX INFO: compiled from: CrashlyticsReport.java */
                        @AutoValue
                        public static abstract class AbstractC0054a {

                            /* JADX INFO: renamed from: b.i.c.m.d.m.v$d$d$a$b$d$a$a, reason: collision with other inner class name */
                            /* JADX INFO: compiled from: CrashlyticsReport.java */
                            @AutoValue.Builder
                            public static abstract class AbstractC0055a {
                            }

                            @Nullable
                            public abstract String a();

                            public abstract int b();

                            public abstract long c();

                            public abstract long d();

                            @NonNull
                            public abstract String e();
                        }

                        @NonNull
                        public abstract ImmutableList3<AbstractC0054a> a();

                        public abstract int b();

                        @NonNull
                        public abstract String c();
                    }

                    @NonNull
                    public abstract ImmutableList3<AbstractC0051a> a();

                    @NonNull
                    public abstract AbstractC0052b b();

                    @NonNull
                    public abstract c c();

                    @NonNull
                    public abstract ImmutableList3<AbstractC0053d> d();
                }

                @Nullable
                public abstract Boolean a();

                @Nullable
                public abstract ImmutableList3<b> b();

                @NonNull
                public abstract b c();

                public abstract int d();
            }

            /* JADX INFO: renamed from: b.i.c.m.d.m.v$d$d$b */
            /* JADX INFO: compiled from: CrashlyticsReport.java */
            @AutoValue
            public static abstract class b {

                /* JADX INFO: renamed from: b.i.c.m.d.m.v$d$d$b$a */
                /* JADX INFO: compiled from: CrashlyticsReport.java */
                @AutoValue.Builder
                public static abstract class a {
                }

                @Nullable
                public abstract Double a();

                public abstract int b();

                public abstract long c();

                public abstract int d();

                public abstract long e();

                public abstract boolean f();
            }

            /* JADX INFO: renamed from: b.i.c.m.d.m.v$d$d$c */
            /* JADX INFO: compiled from: CrashlyticsReport.java */
            @AutoValue
            public static abstract class c {
                @NonNull
                public abstract String a();
            }

            @NonNull
            public abstract a a();

            @NonNull
            public abstract b b();

            @Nullable
            public abstract c c();

            public abstract long d();

            @NonNull
            public abstract String e();
        }

        /* JADX INFO: renamed from: b.i.c.m.d.m.v$d$e */
        /* JADX INFO: compiled from: CrashlyticsReport.java */
        @AutoValue
        public static abstract class e {
            @NonNull
            public abstract String a();

            public abstract int b();

            @NonNull
            public abstract String c();

            public abstract boolean d();
        }

        /* JADX INFO: renamed from: b.i.c.m.d.m.v$d$f */
        /* JADX INFO: compiled from: CrashlyticsReport.java */
        @AutoValue
        public static abstract class f {
            @NonNull
            public abstract String a();
        }

        @NonNull
        public abstract a a();

        @Nullable
        public abstract c b();

        @Nullable
        public abstract Long c();

        @Nullable
        public abstract ImmutableList3<AbstractC0049d> d();

        @NonNull
        public abstract String e();

        public abstract int f();

        @NonNull
        public abstract String g();

        @Nullable
        public abstract e h();

        public abstract long i();

        @Nullable
        public abstract f j();

        public abstract boolean k();

        @NonNull
        public abstract b l();
    }

    @NonNull
    public abstract String a();

    @NonNull
    public abstract String b();

    @NonNull
    public abstract String c();

    @NonNull
    public abstract String d();

    @Nullable
    public abstract c e();

    public abstract int f();

    @NonNull
    public abstract String g();

    @Nullable
    public abstract d h();

    @NonNull
    public abstract a i();

    @NonNull
    public CrashlyticsReport j(long j, boolean z2, @Nullable String str) {
        a aVarI = i();
        d dVar = ((AutoValue_CrashlyticsReport) this).h;
        if (dVar != null) {
            d.b bVarL = dVar.l();
            AutoValue_CrashlyticsReport_Session.b bVar = (AutoValue_CrashlyticsReport_Session.b) bVarL;
            bVar.d = Long.valueOf(j);
            bVar.e = Boolean.valueOf(z2);
            if (str != null) {
                bVar.g = new AutoValue_CrashlyticsReport_Session_User(str, null);
                bVar.a();
            }
            ((AutoValue_CrashlyticsReport.b) aVarI).g = bVarL.a();
        }
        return aVarI.a();
    }
}

package p007b.p008a.p039o;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.os.ConfigurationCompat;
import java.util.Locale;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.o.a */
/* JADX INFO: compiled from: LocaleProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1174a {

    /* JADX INFO: renamed from: a */
    public static Function1<? super Context, Locale> f1570a = a.f1572j;

    /* JADX INFO: renamed from: b */
    public static final C1174a f1571b = null;

    /* JADX INFO: renamed from: b.a.o.a$a */
    /* JADX INFO: compiled from: LocaleProvider.kt */
    public static final class a extends AbstractC12240o implements Function1<Context, Locale> {

        /* JADX INFO: renamed from: j */
        public static final a f1572j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Locale invoke(Context context) {
            Context context2 = context;
            C12238m.checkParameterIsNotNull(context2, "context");
            Resources resources = context2.getResources();
            C12238m.checkExpressionValueIsNotNull(resources, "context.resources");
            Locale locale = ConfigurationCompat.getLocales(resources.getConfiguration()).get(0);
            C12238m.checkExpressionValueIsNotNull(locale, "ConfigurationCompat.getL…sources.configuration)[0]");
            return locale;
        }
    }
}

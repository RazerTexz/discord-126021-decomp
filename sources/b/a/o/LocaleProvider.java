package b.a.o;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.os.ConfigurationCompat;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Locale;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.o.a, reason: use source file name */
/* JADX INFO: compiled from: LocaleProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LocaleProvider {
    public static Function1<? super Context, Locale> a = a.j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LocaleProvider f251b = null;

    /* JADX INFO: renamed from: b.a.o.a$a */
    /* JADX INFO: compiled from: LocaleProvider.kt */
    public static final class a extends Lambda implements Function1<Context, Locale> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Locale invoke(Context context) {
            Context context2 = context;
            Intrinsics3.checkParameterIsNotNull(context2, "context");
            Resources resources = context2.getResources();
            Intrinsics3.checkExpressionValueIsNotNull(resources, "context.resources");
            Locale locale = ConfigurationCompat.getLocales(resources.getConfiguration()).get(0);
            Intrinsics3.checkExpressionValueIsNotNull(locale, "ConfigurationCompat.getL…sources.configuration)[0]");
            return locale;
        }
    }
}

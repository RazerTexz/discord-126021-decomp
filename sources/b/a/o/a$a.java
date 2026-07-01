package b.a.o;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.os.ConfigurationCompat;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Locale;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LocaleProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$a extends o implements Function1<Context, Locale> {
    public static final a$a j = new a$a();

    public a$a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Locale invoke(Context context) {
        Context context2 = context;
        m.checkParameterIsNotNull(context2, "context");
        Resources resources = context2.getResources();
        m.checkExpressionValueIsNotNull(resources, "context.resources");
        Locale locale = ConfigurationCompat.getLocales(resources.getConfiguration()).get(0);
        m.checkExpressionValueIsNotNull(locale, "ConfigurationCompat.getL…sources.configuration)[0]");
        return locale;
    }
}

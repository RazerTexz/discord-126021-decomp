package b.a.p;

import android.content.Context;
import b.i.a.c.e3.b0.r;
import com.discord.utilities.lifecycle.ApplicationProvider;
import d0.z.d.m;
import d0.z.d.o;
import java.io.File;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: SimpleCacheProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class l$a extends o implements Function0<r> {
    public static final l$a j = new l$a();

    public l$a() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public r invoke() {
        Context applicationContext = ApplicationProvider.INSTANCE.get().getApplicationContext();
        m.checkNotNullExpressionValue(applicationContext, "context");
        return new r(new File(applicationContext.getCacheDir(), "app_media_player"), new b.i.a.c.e3.b0.o(104857600L), new b.i.a.c.u2.b(applicationContext));
    }
}

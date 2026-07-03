package p007b.p008a.p040p;

import android.content.Context;
import com.discord.utilities.lifecycle.ApplicationProvider;
import java.io.File;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import p007b.p225i.p226a.p242c.p257e3.p258b0.C2696o;
import p007b.p225i.p226a.p242c.p257e3.p258b0.C2699r;
import p007b.p225i.p226a.p242c.p264u2.C2947b;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.p.l */
/* JADX INFO: compiled from: SimpleCacheProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1187l {

    /* JADX INFO: renamed from: a */
    public static final Lazy f1596a = C12083g.lazy(a.f1598j);

    /* JADX INFO: renamed from: b */
    public static final C1187l f1597b = null;

    /* JADX INFO: renamed from: b.a.p.l$a */
    /* JADX INFO: compiled from: SimpleCacheProvider.kt */
    public static final class a extends AbstractC12240o implements Function0<C2699r> {

        /* JADX INFO: renamed from: j */
        public static final a f1598j = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public C2699r invoke() {
            Context applicationContext = ApplicationProvider.INSTANCE.get().getApplicationContext();
            C12238m.checkNotNullExpressionValue(applicationContext, "context");
            return new C2699r(new File(applicationContext.getCacheDir(), "app_media_player"), new C2696o(104857600L), new C2947b(applicationContext));
        }
    }
}

package b.a.p;

import android.content.Context;
import b.i.a.c.e3.b0.LeastRecentlyUsedCacheEvictor;
import b.i.a.c.e3.b0.SimpleCache2;
import b.i.a.c.u2.ExoDatabaseProvider;
import com.discord.utilities.lifecycle.ApplicationProvider;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.File;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: b.a.p.l, reason: use source file name */
/* JADX INFO: compiled from: SimpleCacheProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleCacheProvider {
    public static final Lazy a = LazyJVM.lazy(a.j);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SimpleCacheProvider f254b = null;

    /* JADX INFO: renamed from: b.a.p.l$a */
    /* JADX INFO: compiled from: SimpleCacheProvider.kt */
    public static final class a extends Lambda implements Function0<SimpleCache2> {
        public static final a j = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public SimpleCache2 invoke() {
            Context applicationContext = ApplicationProvider.INSTANCE.get().getApplicationContext();
            Intrinsics3.checkNotNullExpressionValue(applicationContext, "context");
            return new SimpleCache2(new File(applicationContext.getCacheDir(), "app_media_player"), new LeastRecentlyUsedCacheEvictor(104857600L), new ExoDatabaseProvider(applicationContext));
        }
    }
}

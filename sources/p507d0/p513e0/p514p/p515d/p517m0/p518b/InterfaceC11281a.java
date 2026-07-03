package p507d0.p513e0.p514p.p515d.p517m0.p518b;

import java.util.ServiceLoader;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import p507d0.C12083g;
import p507d0.EnumC12110i;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11334f0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11354a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11355b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11356c;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.a */
/* JADX INFO: compiled from: BuiltInsLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11281a {

    /* JADX INFO: renamed from: a */
    public static final a f22451a = a.f22452a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.a$a */
    /* JADX INFO: compiled from: BuiltInsLoader.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ a f22452a = new a();

        /* JADX INFO: renamed from: b */
        public static final Lazy<InterfaceC11281a> f22453b = C12083g.lazy(EnumC12110i.PUBLICATION, C13304a.f22454j);

        /* JADX INFO: renamed from: d0.e0.p.d.m0.b.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BuiltInsLoader.kt */
        public static final class C13304a extends AbstractC12240o implements Function0<InterfaceC11281a> {

            /* JADX INFO: renamed from: j */
            public static final C13304a f22454j = new C13304a();

            public C13304a() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final InterfaceC11281a invoke() {
                ServiceLoader serviceLoaderLoad = ServiceLoader.load(InterfaceC11281a.class, InterfaceC11281a.class.getClassLoader());
                C12238m.checkNotNullExpressionValue(serviceLoaderLoad, "implementations");
                InterfaceC11281a interfaceC11281a = (InterfaceC11281a) C12163u.firstOrNull(serviceLoaderLoad);
                if (interfaceC11281a != null) {
                    return interfaceC11281a;
                }
                throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
            }
        }

        public final InterfaceC11281a getInstance() {
            return f22453b.getValue();
        }
    }

    InterfaceC11334f0 createPackageFragmentProvider(InterfaceC11905o interfaceC11905o, InterfaceC11325c0 interfaceC11325c0, Iterable<? extends InterfaceC11355b> iterable, InterfaceC11356c interfaceC11356c, InterfaceC11354a interfaceC11354a, boolean z2);
}

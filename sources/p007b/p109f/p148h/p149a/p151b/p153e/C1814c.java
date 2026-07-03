package p007b.p109f.p148h.p149a.p151b.p153e;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.concurrent.ExecutorService;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p148h.p149a.p150a.InterfaceC1801a;
import p007b.p109f.p148h.p149a.p151b.InterfaceC1806b;
import p007b.p109f.p148h.p149a.p151b.InterfaceC1807c;
import p007b.p109f.p148h.p149a.p151b.p154f.C1817b;

/* JADX INFO: renamed from: b.f.h.a.b.e.c */
/* JADX INFO: compiled from: DefaultBitmapFramePreparer.java */
/* JADX INFO: loaded from: classes.dex */
public class C1814c implements InterfaceC1813b {

    /* JADX INFO: renamed from: a */
    public final PlatformBitmapFactory f3515a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1807c f3516b;

    /* JADX INFO: renamed from: c */
    public final Bitmap.Config f3517c;

    /* JADX INFO: renamed from: d */
    public final ExecutorService f3518d;

    /* JADX INFO: renamed from: e */
    public final SparseArray<Runnable> f3519e = new SparseArray<>();

    /* JADX INFO: renamed from: b.f.h.a.b.e.c$a */
    /* JADX INFO: compiled from: DefaultBitmapFramePreparer.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final InterfaceC1806b f3520j;

        /* JADX INFO: renamed from: k */
        public final InterfaceC1801a f3521k;

        /* JADX INFO: renamed from: l */
        public final int f3522l;

        /* JADX INFO: renamed from: m */
        public final int f3523m;

        public a(InterfaceC1801a interfaceC1801a, InterfaceC1806b interfaceC1806b, int i, int i2) {
            this.f3521k = interfaceC1801a;
            this.f3520j = interfaceC1806b;
            this.f3522l = i;
            this.f3523m = i2;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX INFO: renamed from: a */
        public final boolean m1159a(int i, int i2) {
            CloseableReference closeableReferenceMo1151a;
            int i3 = 2;
            CloseableReference closeableReference = null;
            try {
                if (i2 == 1) {
                    closeableReferenceMo1151a = this.f3520j.mo1151a(i, this.f3521k.mo1140i(), this.f3521k.mo1138g());
                } else {
                    if (i2 != 2) {
                        Class<CloseableReference> cls = CloseableReference.f19438j;
                        return false;
                    }
                    try {
                        closeableReferenceMo1151a = C1814c.this.f3515a.m8695a(this.f3521k.mo1140i(), this.f3521k.mo1138g(), C1814c.this.f3517c);
                        i3 = -1;
                    } catch (RuntimeException e) {
                        C1691a.m984l(C1814c.class, "Failed to create frame bitmap", e);
                        Class<CloseableReference> cls2 = CloseableReference.f19438j;
                        return false;
                    }
                }
                boolean zM1160b = m1160b(i, closeableReferenceMo1151a, i2);
                if (closeableReferenceMo1151a != null) {
                    closeableReferenceMo1151a.close();
                }
                return (zM1160b || i3 == -1) ? zM1160b : m1159a(i, i3);
            } catch (Throwable th) {
                Class<CloseableReference> cls3 = CloseableReference.f19438j;
                if (0 != 0) {
                    closeableReference.close();
                }
                throw th;
            }
        }

        /* JADX INFO: renamed from: b */
        public final boolean m1160b(int i, CloseableReference<Bitmap> closeableReference, int i2) {
            if (!CloseableReference.m8640y(closeableReference)) {
                return false;
            }
            if (!((C1817b) C1814c.this.f3516b).m1161a(i, closeableReference.m8642u())) {
                return false;
            }
            int i3 = C1691a.f3102a;
            synchronized (C1814c.this.f3519e) {
                this.f3520j.mo1152b(this.f3522l, closeableReference, i2);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f3520j.mo1153c(this.f3522l)) {
                    int i = C1691a.f3102a;
                    synchronized (C1814c.this.f3519e) {
                        C1814c.this.f3519e.remove(this.f3523m);
                    }
                    return;
                }
                if (m1159a(this.f3522l, 1)) {
                    int i2 = C1691a.f3102a;
                } else {
                    C1691a.m975c(C1814c.class, "Could not prepare frame %d.", Integer.valueOf(this.f3522l));
                }
                synchronized (C1814c.this.f3519e) {
                    C1814c.this.f3519e.remove(this.f3523m);
                }
            } catch (Throwable th) {
                synchronized (C1814c.this.f3519e) {
                    C1814c.this.f3519e.remove(this.f3523m);
                    throw th;
                }
            }
        }
    }

    public C1814c(PlatformBitmapFactory platformBitmapFactory, InterfaceC1807c interfaceC1807c, Bitmap.Config config, ExecutorService executorService) {
        this.f3515a = platformBitmapFactory;
        this.f3516b = interfaceC1807c;
        this.f3517c = config;
        this.f3518d = executorService;
    }
}

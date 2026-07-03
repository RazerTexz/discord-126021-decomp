package p007b.p109f.p161j.p170e;

import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p161j.p172g.C1907a;

/* JADX INFO: renamed from: b.f.j.e.a */
/* JADX INFO: compiled from: CloseableReferenceFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class C1886a {

    /* JADX INFO: renamed from: a */
    public final CloseableReference.InterfaceC10637c f3725a;

    /* JADX INFO: renamed from: b.f.j.e.a$a */
    /* JADX INFO: compiled from: CloseableReferenceFactory.java */
    public class a implements CloseableReference.InterfaceC10637c {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ C1907a f3726a;

        public a(C1886a c1886a, C1907a c1907a) {
            this.f3726a = c1907a;
        }

        @Override // com.facebook.common.references.CloseableReference.InterfaceC10637c
        /* JADX INFO: renamed from: a */
        public void mo1252a(SharedReference<Object> sharedReference, Throwable th) {
            String string;
            Objects.requireNonNull(this.f3726a);
            Object objM8646c = sharedReference.m8646c();
            String name = objM8646c != null ? objM8646c.getClass().getName() : "<value is null>";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(System.identityHashCode(this));
            objArr[1] = Integer.valueOf(System.identityHashCode(sharedReference));
            objArr[2] = name;
            if (th == null) {
                string = "";
            } else {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                string = stringWriter.toString();
            }
            objArr[3] = string;
            C1691a.m987o("Fresco", "Finalized without closing: %x %x (type = %s).\nStack:\n%s", objArr);
        }

        @Override // com.facebook.common.references.CloseableReference.InterfaceC10637c
        /* JADX INFO: renamed from: b */
        public boolean mo1253b() {
            Objects.requireNonNull(this.f3726a);
            return false;
        }
    }

    public C1886a(C1907a c1907a) {
        this.f3725a = new a(this, c1907a);
    }
}

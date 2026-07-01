package b.f.j.e;

import com.facebook.common.references.CloseableReference$c;
import com.facebook.common.references.SharedReference;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;

/* JADX INFO: compiled from: CloseableReferenceFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class a$a implements CloseableReference$c {
    public final /* synthetic */ b.f.j.g.a a;

    public a$a(a aVar, b.f.j.g.a aVar2) {
        this.a = aVar2;
    }

    @Override // com.facebook.common.references.CloseableReference$c
    public void a(SharedReference<Object> sharedReference, Throwable th) {
        String string;
        Objects.requireNonNull(this.a);
        Object objC = sharedReference.c();
        String name = objC != null ? objC.getClass().getName() : "<value is null>";
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
        b.f.d.e.a.o("Fresco", "Finalized without closing: %x %x (type = %s).\nStack:\n%s", objArr);
    }

    @Override // com.facebook.common.references.CloseableReference$c
    public boolean b() {
        Objects.requireNonNull(this.a);
        return false;
    }
}

package b.f.h.a.c;

/* JADX INFO: compiled from: AnimatedDrawable2.java */
/* JADX INFO: loaded from: classes.dex */
public class a$a implements Runnable {
    public final /* synthetic */ a j;

    public a$a(a aVar) {
        this.j = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar = this.j;
        aVar.unscheduleSelf(aVar.f535z);
        this.j.invalidateSelf();
    }
}

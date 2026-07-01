package b.f.m.n;

/* JADX INFO: renamed from: b.f.m.n.c, reason: use source file name */
/* JADX INFO: compiled from: SystemDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class SystemDelegate implements NativeLoaderDelegate {
    @Override // b.f.m.n.NativeLoaderDelegate
    public boolean a(String str, int i) {
        System.loadLibrary(str);
        return true;
    }
}

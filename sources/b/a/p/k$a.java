package b.a.p;

/* JADX INFO: compiled from: RxPlayerEventListener.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k$a {
    public final boolean a;

    public k$a(boolean z2) {
        this.a = z2;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof k$a) && this.a == ((k$a) obj).a;
        }
        return true;
    }

    public int hashCode() {
        boolean z2 = this.a;
        if (z2) {
            return 1;
        }
        return z2 ? 1 : 0;
    }

    public String toString() {
        return b.d.b.a.a.O(b.d.b.a.a.U("IsPlayingChange(isPlaying="), this.a, ")");
    }
}

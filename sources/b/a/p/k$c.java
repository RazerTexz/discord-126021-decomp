package b.a.p;

/* JADX INFO: compiled from: RxPlayerEventListener.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k$c {
    public final int a;

    public k$c(int i) {
        this.a = i;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof k$c) && this.a == ((k$c) obj).a;
        }
        return true;
    }

    public int hashCode() {
        return this.a;
    }

    public String toString() {
        return b.d.b.a.a.B(b.d.b.a.a.U("PlayerStateChange(playbackState="), this.a, ")");
    }
}

package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public class DiffUtil$PostponedUpdate {
    public int currentPos;
    public int posInOwnerList;
    public boolean removal;

    public DiffUtil$PostponedUpdate(int i, int i2, boolean z2) {
        this.posInOwnerList = i;
        this.currentPos = i2;
        this.removal = z2;
    }
}

package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public final class AdapterHelper$UpdateOp {
    public static final int ADD = 1;
    public static final int MOVE = 8;
    public static final int POOL_SIZE = 30;
    public static final int REMOVE = 2;
    public static final int UPDATE = 4;
    public int cmd;
    public int itemCount;
    public Object payload;
    public int positionStart;

    public AdapterHelper$UpdateOp(int i, int i2, int i3, Object obj) {
        this.cmd = i;
        this.positionStart = i2;
        this.itemCount = i3;
        this.payload = obj;
    }

    public String cmdToString() {
        int i = this.cmd;
        if (i == 1) {
            return "add";
        }
        if (i == 2) {
            return "rm";
        }
        if (i != 4) {
            return i != 8 ? "??" : "mv";
        }
        return "up";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdapterHelper$UpdateOp)) {
            return false;
        }
        AdapterHelper$UpdateOp adapterHelper$UpdateOp = (AdapterHelper$UpdateOp) obj;
        int i = this.cmd;
        if (i != adapterHelper$UpdateOp.cmd) {
            return false;
        }
        if (i == 8 && Math.abs(this.itemCount - this.positionStart) == 1 && this.itemCount == adapterHelper$UpdateOp.positionStart && this.positionStart == adapterHelper$UpdateOp.itemCount) {
            return true;
        }
        if (this.itemCount != adapterHelper$UpdateOp.itemCount || this.positionStart != adapterHelper$UpdateOp.positionStart) {
            return false;
        }
        Object obj2 = this.payload;
        if (obj2 != null) {
            if (!obj2.equals(adapterHelper$UpdateOp.payload)) {
                return false;
            }
        } else if (adapterHelper$UpdateOp.payload != null) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((this.cmd * 31) + this.positionStart) * 31) + this.itemCount;
    }

    public String toString() {
        return Integer.toHexString(System.identityHashCode(this)) + "[" + cmdToString() + ",s:" + this.positionStart + "c:" + this.itemCount + ",p:" + this.payload + "]";
    }
}

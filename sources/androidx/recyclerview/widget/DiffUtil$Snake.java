package androidx.recyclerview.widget;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class DiffUtil$Snake {
    public int endX;
    public int endY;
    public boolean reverse;
    public int startX;
    public int startY;

    public int diagonalSize() {
        return Math.min(this.endX - this.startX, this.endY - this.startY);
    }

    public boolean hasAdditionOrRemoval() {
        return this.endY - this.startY != this.endX - this.startX;
    }

    public boolean isAddition() {
        return this.endY - this.startY > this.endX - this.startX;
    }

    @NonNull
    public DiffUtil$Diagonal toDiagonal() {
        if (!hasAdditionOrRemoval()) {
            int i = this.startX;
            return new DiffUtil$Diagonal(i, this.startY, this.endX - i);
        }
        if (this.reverse) {
            return new DiffUtil$Diagonal(this.startX, this.startY, diagonalSize());
        }
        return isAddition() ? new DiffUtil$Diagonal(this.startX, this.startY + 1, diagonalSize()) : new DiffUtil$Diagonal(this.startX + 1, this.startY, diagonalSize());
    }
}

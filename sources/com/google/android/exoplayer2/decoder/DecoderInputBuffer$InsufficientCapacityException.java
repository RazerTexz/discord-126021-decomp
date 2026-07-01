package com.google.android.exoplayer2.decoder;

/* JADX INFO: loaded from: classes3.dex */
public final class DecoderInputBuffer$InsufficientCapacityException extends IllegalStateException {
    public final int currentCapacity;
    public final int requiredCapacity;

    public DecoderInputBuffer$InsufficientCapacityException(int i, int i2) {
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(i);
        sb.append(" < ");
        sb.append(i2);
        sb.append(")");
        super(sb.toString());
        this.currentCapacity = i;
        this.requiredCapacity = i2;
    }
}

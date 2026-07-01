package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class CameraEnumerationAndroid$2 extends CameraEnumerationAndroid$ClosestComparator<Size> {
    public final /* synthetic */ int val$requestedHeight;
    public final /* synthetic */ int val$requestedWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraEnumerationAndroid$2(int i, int i2) {
        super(null);
        this.val$requestedWidth = i;
        this.val$requestedHeight = i2;
    }

    @Override // org.webrtc.CameraEnumerationAndroid$ClosestComparator
    public /* bridge */ /* synthetic */ int diff(Size size) {
        return diff2(size);
    }

    /* JADX INFO: renamed from: diff, reason: avoid collision after fix types in other method */
    public int diff2(Size size) {
        return Math.abs(this.val$requestedHeight - size.height) + Math.abs(this.val$requestedWidth - size.width);
    }
}
